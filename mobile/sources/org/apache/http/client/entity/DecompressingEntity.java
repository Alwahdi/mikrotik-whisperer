package org.apache.http.client.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

abstract class DecompressingEntity extends HttpEntityWrapper {
    private static final int BUFFER_SIZE = 2048;
    private InputStream content;

    /* access modifiers changed from: package-private */
    public abstract InputStream getDecompressingInputStream(InputStream inputStream) throws IOException;

    public DecompressingEntity(HttpEntity wrapped) {
        super(wrapped);
    }

    public InputStream getContent() throws IOException {
        if (!this.wrappedEntity.isStreaming()) {
            return getDecompressingInputStream(this.wrappedEntity.getContent());
        }
        if (this.content == null) {
            this.content = getDecompressingInputStream(this.wrappedEntity.getContent());
        }
        return this.content;
    }

    public void writeTo(OutputStream outstream) throws IOException {
        if (outstream != null) {
            InputStream instream = getContent();
            try {
                byte[] buffer = new byte[2048];
                while (true) {
                    int read = instream.read(buffer);
                    int l = read;
                    if (read != -1) {
                        outstream.write(buffer, 0, l);
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
}
