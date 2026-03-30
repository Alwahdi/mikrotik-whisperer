package org.apache.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.CharArrayBuffer;

public abstract class AbstractSessionInputBuffer implements SessionInputBuffer, BufferInfo {
    private boolean ascii = true;
    private byte[] buffer;
    private int bufferlen;
    private int bufferpos;
    private String charset = "US-ASCII";
    private InputStream instream;
    private ByteArrayBuffer linebuffer = null;
    private int maxLineLen = -1;
    private HttpTransportMetricsImpl metrics;
    private int minChunkLimit = 512;

    /* access modifiers changed from: protected */
    public void init(InputStream instream2, int buffersize, HttpParams params) {
        if (instream2 == null) {
            throw new IllegalArgumentException("Input stream may not be null");
        } else if (buffersize <= 0) {
            throw new IllegalArgumentException("Buffer size may not be negative or zero");
        } else if (params != null) {
            this.instream = instream2;
            this.buffer = new byte[buffersize];
            boolean z = false;
            this.bufferpos = 0;
            this.bufferlen = 0;
            this.linebuffer = new ByteArrayBuffer(buffersize);
            String httpElementCharset = HttpProtocolParams.getHttpElementCharset(params);
            this.charset = httpElementCharset;
            if (httpElementCharset.equalsIgnoreCase("US-ASCII") || this.charset.equalsIgnoreCase(HTTP.ASCII)) {
                z = true;
            }
            this.ascii = z;
            this.maxLineLen = params.getIntParameter(CoreConnectionPNames.MAX_LINE_LENGTH, -1);
            this.minChunkLimit = params.getIntParameter(CoreConnectionPNames.MIN_CHUNK_LIMIT, 512);
            this.metrics = createTransportMetrics();
        } else {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
    }

    /* access modifiers changed from: protected */
    public HttpTransportMetricsImpl createTransportMetrics() {
        return new HttpTransportMetricsImpl();
    }

    public int capacity() {
        return this.buffer.length;
    }

    public int length() {
        return this.bufferlen - this.bufferpos;
    }

    public int available() {
        return capacity() - length();
    }

    /* access modifiers changed from: protected */
    public int fillBuffer() throws IOException {
        int i = this.bufferpos;
        if (i > 0) {
            int len = this.bufferlen - i;
            if (len > 0) {
                byte[] bArr = this.buffer;
                System.arraycopy(bArr, i, bArr, 0, len);
            }
            this.bufferpos = 0;
            this.bufferlen = len;
        }
        int off = this.bufferlen;
        byte[] bArr2 = this.buffer;
        int l = this.instream.read(bArr2, off, bArr2.length - off);
        if (l == -1) {
            return -1;
        }
        this.bufferlen = off + l;
        this.metrics.incrementBytesTransferred((long) l);
        return l;
    }

    /* access modifiers changed from: protected */
    public boolean hasBufferedData() {
        return this.bufferpos < this.bufferlen;
    }

    public int read() throws IOException {
        while (!hasBufferedData()) {
            if (fillBuffer() == -1) {
                return -1;
            }
        }
        byte[] bArr = this.buffer;
        int i = this.bufferpos;
        this.bufferpos = i + 1;
        return bArr[i] & 255;
    }

    public int read(byte[] b, int off, int len) throws IOException {
        if (b == null) {
            return 0;
        }
        if (hasBufferedData()) {
            int chunk = Math.min(len, this.bufferlen - this.bufferpos);
            System.arraycopy(this.buffer, this.bufferpos, b, off, chunk);
            this.bufferpos += chunk;
            return chunk;
        } else if (len > this.minChunkLimit) {
            int read = this.instream.read(b, off, len);
            if (read > 0) {
                this.metrics.incrementBytesTransferred((long) read);
            }
            return read;
        } else {
            while (hasBufferedData() == 0) {
                if (fillBuffer() == -1) {
                    return -1;
                }
            }
            int chunk2 = Math.min(len, this.bufferlen - this.bufferpos);
            System.arraycopy(this.buffer, this.bufferpos, b, off, chunk2);
            this.bufferpos += chunk2;
            return chunk2;
        }
    }

    public int read(byte[] b) throws IOException {
        if (b == null) {
            return 0;
        }
        return read(b, 0, b.length);
    }

    private int locateLF() {
        for (int i = this.bufferpos; i < this.bufferlen; i++) {
            if (this.buffer[i] == 10) {
                return i;
            }
        }
        return -1;
    }

    public int readLine(CharArrayBuffer charbuffer) throws IOException {
        if (charbuffer != null) {
            int noRead = 0;
            boolean retry = true;
            while (retry) {
                int i = locateLF();
                if (i == -1) {
                    if (hasBufferedData()) {
                        int i2 = this.bufferlen;
                        int i3 = this.bufferpos;
                        this.linebuffer.append(this.buffer, i3, i2 - i3);
                        this.bufferpos = this.bufferlen;
                    }
                    noRead = fillBuffer();
                    if (noRead == -1) {
                        retry = false;
                    }
                } else if (this.linebuffer.isEmpty()) {
                    return lineFromReadBuffer(charbuffer, i);
                } else {
                    retry = false;
                    int i4 = this.bufferpos;
                    this.linebuffer.append(this.buffer, i4, (i + 1) - i4);
                    this.bufferpos = i + 1;
                }
                if (this.maxLineLen > 0 && this.linebuffer.length() >= this.maxLineLen) {
                    throw new IOException("Maximum line length limit exceeded");
                }
            }
            if (noRead != -1 || !this.linebuffer.isEmpty()) {
                return lineFromLineBuffer(charbuffer);
            }
            return -1;
        }
        throw new IllegalArgumentException("Char array buffer may not be null");
    }

    private int lineFromLineBuffer(CharArrayBuffer charbuffer) throws IOException {
        int l = this.linebuffer.length();
        if (l > 0) {
            if (this.linebuffer.byteAt(l - 1) == 10) {
                l--;
                this.linebuffer.setLength(l);
            }
            if (l > 0 && this.linebuffer.byteAt(l - 1) == 13) {
                this.linebuffer.setLength(l - 1);
            }
        }
        int l2 = this.linebuffer.length();
        if (this.ascii) {
            charbuffer.append(this.linebuffer, 0, l2);
        } else {
            String s = new String(this.linebuffer.buffer(), 0, l2, this.charset);
            l2 = s.length();
            charbuffer.append(s);
        }
        this.linebuffer.clear();
        return l2;
    }

    private int lineFromReadBuffer(CharArrayBuffer charbuffer, int pos) throws IOException {
        int off = this.bufferpos;
        this.bufferpos = pos + 1;
        if (pos > 0 && this.buffer[pos - 1] == 13) {
            pos--;
        }
        int len = pos - off;
        if (this.ascii) {
            charbuffer.append(this.buffer, off, len);
            return len;
        }
        String s = new String(this.buffer, off, len, this.charset);
        charbuffer.append(s);
        return s.length();
    }

    public String readLine() throws IOException {
        CharArrayBuffer charbuffer = new CharArrayBuffer(64);
        if (readLine(charbuffer) != -1) {
            return charbuffer.toString();
        }
        return null;
    }

    public HttpTransportMetrics getMetrics() {
        return this.metrics;
    }
}
