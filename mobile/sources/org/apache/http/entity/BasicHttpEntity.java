package org.apache.http.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BasicHttpEntity extends AbstractHttpEntity {
    private InputStream content;
    private long length = -1;

    public long getContentLength() {
        return this.length;
    }

    public InputStream getContent() throws IllegalStateException {
        InputStream inputStream = this.content;
        if (inputStream != null) {
            return inputStream;
        }
        throw new IllegalStateException("Content has not been provided");
    }

    public boolean isRepeatable() {
        return false;
    }

    public void setContentLength(long len) {
        this.length = len;
    }

    public void setContent(InputStream instream) {
        this.content = instream;
    }

    public void writeTo(OutputStream outstream) throws IOException {
        if (outstream != null) {
            InputStream instream = getContent();
            try {
                byte[] tmp = new byte[2048];
                while (true) {
                    int read = instream.read(tmp);
                    int l = read;
                    if (read != -1) {
                        outstream.write(tmp, 0, l);
                    } else {
                        return;
                    }
                }
            } finally {
                instream.close();
            }
        } else {
            throw new IllegalArgumentException("Output stream may not be null");
        }
    }

    public boolean isStreaming() {
        return this.content != null;
    }

    public void consumeContent() throws IOException {
        InputStream inputStream = this.content;
        if (inputStream != null) {
            inputStream.close();
        }
    }
}
