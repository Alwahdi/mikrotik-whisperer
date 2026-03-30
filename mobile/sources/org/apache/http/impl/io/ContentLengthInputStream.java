package org.apache.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.ConnectionClosedException;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.SessionInputBuffer;

public class ContentLengthInputStream extends InputStream {
    private static final int BUFFER_SIZE = 2048;
    private boolean closed = false;
    private long contentLength;
    private SessionInputBuffer in = null;
    private long pos = 0;

    public ContentLengthInputStream(SessionInputBuffer in2, long contentLength2) {
        if (in2 == null) {
            throw new IllegalArgumentException("Input stream may not be null");
        } else if (contentLength2 >= 0) {
            this.in = in2;
            this.contentLength = contentLength2;
        } else {
            throw new IllegalArgumentException("Content length may not be negative");
        }
    }

    public void close() throws IOException {
        if (!this.closed) {
            try {
                if (this.pos < this.contentLength) {
                    do {
                    } while (read(new byte[2048]) >= 0);
                }
            } finally {
                this.closed = true;
            }
        }
    }

    public int available() throws IOException {
        SessionInputBuffer sessionInputBuffer = this.in;
        if (sessionInputBuffer instanceof BufferInfo) {
            return Math.min(((BufferInfo) sessionInputBuffer).length(), (int) (this.contentLength - this.pos));
        }
        return 0;
    }

    public int read() throws IOException {
        if (this.closed) {
            throw new IOException("Attempted read from closed stream.");
        } else if (this.pos >= this.contentLength) {
            return -1;
        } else {
            int b = this.in.read();
            if (b != -1) {
                this.pos++;
            } else if (this.pos < this.contentLength) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Premature end of Content-Length delimited message body (expected: ");
                stringBuffer.append(this.contentLength);
                stringBuffer.append("; received: ");
                stringBuffer.append(this.pos);
                throw new ConnectionClosedException(stringBuffer.toString());
            }
            return b;
        }
    }

    public int read(byte[] b, int off, int len) throws IOException {
        if (!this.closed) {
            long j = this.pos;
            long j2 = this.contentLength;
            if (j >= j2) {
                return -1;
            }
            if (((long) len) + j > j2) {
                len = (int) (j2 - j);
            }
            int count = this.in.read(b, off, len);
            if (count != -1 || this.pos >= this.contentLength) {
                if (count > 0) {
                    this.pos += (long) count;
                }
                return count;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Premature end of Content-Length delimited message body (expected: ");
            stringBuffer.append(this.contentLength);
            stringBuffer.append("; received: ");
            stringBuffer.append(this.pos);
            throw new ConnectionClosedException(stringBuffer.toString());
        }
        throw new IOException("Attempted read from closed stream.");
    }

    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    public long skip(long n) throws IOException {
        int l;
        if (n <= 0) {
            return 0;
        }
        byte[] buffer = new byte[2048];
        long remaining = Math.min(n, this.contentLength - this.pos);
        long count = 0;
        while (remaining > 0 && (l = read(buffer, 0, (int) Math.min(2048, remaining))) != -1) {
            count += (long) l;
            remaining -= (long) l;
        }
        return count;
    }
}
