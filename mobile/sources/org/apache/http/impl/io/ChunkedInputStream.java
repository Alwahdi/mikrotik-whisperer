package org.apache.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.TruncatedChunkException;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.LineParser;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.ExceptionUtils;

public class ChunkedInputStream extends InputStream {
    private static final int BUFFER_SIZE = 2048;
    private static final int CHUNK_CRLF = 3;
    private static final int CHUNK_DATA = 2;
    private static final int CHUNK_LEN = 1;
    private final CharArrayBuffer buffer;
    private int chunkSize;
    private boolean closed = false;
    private boolean eof = false;
    private Header[] footers = new Header[0];
    private final SessionInputBuffer in;
    private int pos;
    private int state;

    public ChunkedInputStream(SessionInputBuffer in2) {
        if (in2 != null) {
            this.in = in2;
            this.pos = 0;
            this.buffer = new CharArrayBuffer(16);
            this.state = 1;
            return;
        }
        throw new IllegalArgumentException("Session input buffer may not be null");
    }

    public int available() throws IOException {
        SessionInputBuffer sessionInputBuffer = this.in;
        if (sessionInputBuffer instanceof BufferInfo) {
            return Math.min(((BufferInfo) sessionInputBuffer).length(), this.chunkSize - this.pos);
        }
        return 0;
    }

    public int read() throws IOException {
        if (this.closed) {
            throw new IOException("Attempted read from closed stream.");
        } else if (this.eof) {
            return -1;
        } else {
            if (this.state != 2) {
                nextChunk();
                if (this.eof) {
                    return -1;
                }
            }
            int b = this.in.read();
            if (b != -1) {
                int i = this.pos + 1;
                this.pos = i;
                if (i >= this.chunkSize) {
                    this.state = 3;
                }
            }
            return b;
        }
    }

    public int read(byte[] b, int off, int len) throws IOException {
        if (this.closed) {
            throw new IOException("Attempted read from closed stream.");
        } else if (this.eof) {
            return -1;
        } else {
            if (this.state != 2) {
                nextChunk();
                if (this.eof) {
                    return -1;
                }
            }
            int bytesRead = this.in.read(b, off, Math.min(len, this.chunkSize - this.pos));
            if (bytesRead != -1) {
                int i = this.pos + bytesRead;
                this.pos = i;
                if (i >= this.chunkSize) {
                    this.state = 3;
                }
                return bytesRead;
            }
            this.eof = true;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Truncated chunk ( expected size: ");
            stringBuffer.append(this.chunkSize);
            stringBuffer.append("; actual size: ");
            stringBuffer.append(this.pos);
            stringBuffer.append(")");
            throw new TruncatedChunkException(stringBuffer.toString());
        }
    }

    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    private void nextChunk() throws IOException {
        int chunkSize2 = getChunkSize();
        this.chunkSize = chunkSize2;
        if (chunkSize2 >= 0) {
            this.state = 2;
            this.pos = 0;
            if (chunkSize2 == 0) {
                this.eof = true;
                parseTrailerHeaders();
                return;
            }
            return;
        }
        throw new MalformedChunkCodingException("Negative chunk size");
    }

    private int getChunkSize() throws IOException {
        switch (this.state) {
            case 1:
                break;
            case 3:
                this.buffer.clear();
                if (this.in.readLine(this.buffer) == -1) {
                    return 0;
                }
                if (this.buffer.isEmpty()) {
                    this.state = 1;
                    break;
                } else {
                    throw new MalformedChunkCodingException("Unexpected content at the end of chunk");
                }
            default:
                throw new IllegalStateException("Inconsistent codec state");
        }
        this.buffer.clear();
        if (this.in.readLine(this.buffer) == -1) {
            return 0;
        }
        int separator = this.buffer.indexOf(59);
        if (separator < 0) {
            separator = this.buffer.length();
        }
        try {
            return Integer.parseInt(this.buffer.substringTrimmed(0, separator), 16);
        } catch (NumberFormatException e) {
            throw new MalformedChunkCodingException("Bad chunk header");
        }
    }

    private void parseTrailerHeaders() throws IOException {
        try {
            this.footers = AbstractMessageParser.parseHeaders(this.in, -1, -1, (LineParser) null);
        } catch (HttpException e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Invalid footer: ");
            stringBuffer.append(e.getMessage());
            IOException ioe = new MalformedChunkCodingException(stringBuffer.toString());
            ExceptionUtils.initCause(ioe, e);
            throw ioe;
        }
    }

    public void close() throws IOException {
        if (!this.closed) {
            try {
                if (!this.eof) {
                    do {
                    } while (read(new byte[2048]) >= 0);
                }
            } finally {
                this.eof = true;
                this.closed = true;
            }
        }
    }

    public Header[] getFooters() {
        return (Header[]) this.footers.clone();
    }
}
