package defpackage;

import com.google.protobuf.g;
import com.google.protobuf.p;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: jb0  reason: default package */
final class jb0 extends InputStream implements wh, hw {
    private p a;

    /* renamed from: a  reason: collision with other field name */
    private ByteArrayInputStream f4050a;

    /* renamed from: a  reason: collision with other field name */
    private final n50<?> f4051a;

    jb0(p message, n50<?> parser) {
        this.a = message;
        this.f4051a = parser;
    }

    public int c(OutputStream target) {
        p pVar = this.a;
        if (pVar != null) {
            int written = pVar.d();
            this.a.writeTo(target);
            this.a = null;
            return written;
        }
        ByteArrayInputStream byteArrayInputStream = this.f4050a;
        if (byteArrayInputStream == null) {
            return 0;
        }
        int written2 = (int) kb0.a(byteArrayInputStream, target);
        this.f4050a = null;
        return written2;
    }

    public int read() {
        if (this.a != null) {
            this.f4050a = new ByteArrayInputStream(this.a.e());
            this.a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f4050a;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read();
        }
        return -1;
    }

    public int read(byte[] b, int off, int len) {
        p pVar = this.a;
        if (pVar != null) {
            int size = pVar.d();
            if (size == 0) {
                this.a = null;
                this.f4050a = null;
                return -1;
            } else if (len >= size) {
                g stream = g.O(b, off, size);
                this.a.b(stream);
                stream.K();
                stream.d();
                this.a = null;
                this.f4050a = null;
                return size;
            } else {
                this.f4050a = new ByteArrayInputStream(this.a.e());
                this.a = null;
            }
        }
        ByteArrayInputStream byteArrayInputStream = this.f4050a;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read(b, off, len);
        }
        return -1;
    }

    public int available() {
        p pVar = this.a;
        if (pVar != null) {
            return pVar.d();
        }
        ByteArrayInputStream byteArrayInputStream = this.f4050a;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.available();
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public p f() {
        p pVar = this.a;
        if (pVar != null) {
            return pVar;
        }
        throw new IllegalStateException("message not available");
    }

    /* access modifiers changed from: package-private */
    public n50<?> o() {
        return this.f4051a;
    }
}
