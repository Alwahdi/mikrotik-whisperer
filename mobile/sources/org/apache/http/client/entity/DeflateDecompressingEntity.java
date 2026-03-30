package org.apache.http.client.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public class DeflateDecompressingEntity extends DecompressingEntity {
    public DeflateDecompressingEntity(HttpEntity entity) {
        super(entity);
    }

    /* access modifiers changed from: package-private */
    public InputStream getDecompressingInputStream(InputStream wrapped) throws IOException {
        int n;
        byte[] peeked = new byte[6];
        PushbackInputStream pushback = new PushbackInputStream(wrapped, peeked.length);
        int headerLength = pushback.read(peeked);
        if (headerLength != -1) {
            byte[] dummy = new byte[1];
            Inflater inf = new Inflater();
            while (true) {
                try {
                    int inflate = inf.inflate(dummy);
                    n = inflate;
                    if (inflate != 0) {
                        break;
                    } else if (inf.finished()) {
                        throw new IOException("Unable to read the response");
                    } else if (inf.needsDictionary()) {
                        break;
                    } else if (inf.needsInput()) {
                        inf.setInput(peeked);
                    }
                } catch (DataFormatException e) {
                    pushback.unread(peeked, 0, headerLength);
                    return new InflaterInputStream(pushback, new Inflater(true));
                }
            }
            if (n != -1) {
                pushback.unread(peeked, 0, headerLength);
                return new InflaterInputStream(pushback);
            }
            throw new IOException("Unable to read the response");
        }
        throw new IOException("Unable to read the response");
    }

    public Header getContentEncoding() {
        return null;
    }

    public long getContentLength() {
        return -1;
    }
}
