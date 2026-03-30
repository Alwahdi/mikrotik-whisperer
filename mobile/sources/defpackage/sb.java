package defpackage;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

/* renamed from: sb  reason: default package */
public class sb extends u {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private final Queue<id0> f4978a = new ArrayDeque();

    public void f(id0 buffer) {
        if (!(buffer instanceof sb)) {
            this.f4978a.add(buffer);
            this.a += buffer.b();
            return;
        }
        sb compositeBuffer = (sb) buffer;
        while (!compositeBuffer.f4978a.isEmpty()) {
            this.f4978a.add(compositeBuffer.f4978a.remove());
        }
        this.a += compositeBuffer.a;
        compositeBuffer.a = 0;
        compositeBuffer.close();
    }

    public int b() {
        return this.a;
    }

    /* renamed from: sb$a */
    class a extends c {
        a() {
            super((a) null);
        }

        /* access modifiers changed from: package-private */
        public int c(id0 buffer, int length) {
            return buffer.readUnsignedByte();
        }
    }

    public int readUnsignedByte() {
        c op = new a();
        q(op, 1);
        return op.a;
    }

    /* renamed from: sb$b */
    class b extends c {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ byte[] f4979a;
        int b;
        final /* synthetic */ int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(int i, byte[] bArr) {
            super((a) null);
            this.c = i;
            this.f4979a = bArr;
            this.b = i;
        }

        public int c(id0 buffer, int length) {
            buffer.m(this.f4979a, this.b, length);
            this.b += length;
            return 0;
        }
    }

    public void m(byte[] dest, int destOffset, int length) {
        q(new b(destOffset, dest), length);
    }

    /* renamed from: w */
    public sb v(int length) {
        c(length);
        this.a -= length;
        sb newBuffer = new sb();
        while (length > 0) {
            id0 buffer = this.f4978a.peek();
            if (buffer.b() > length) {
                newBuffer.f(buffer.v(length));
                length = 0;
            } else {
                newBuffer.f(this.f4978a.poll());
                length -= buffer.b();
            }
        }
        return newBuffer;
    }

    public void close() {
        while (!this.f4978a.isEmpty()) {
            this.f4978a.remove().close();
        }
    }

    private void q(c op, int length) {
        c(length);
        if (!this.f4978a.isEmpty()) {
            o();
        }
        while (length > 0 && !this.f4978a.isEmpty()) {
            id0 buffer = this.f4978a.peek();
            int lengthToCopy = Math.min(length, buffer.b());
            op.b(buffer, lengthToCopy);
            if (!op.a()) {
                length -= lengthToCopy;
                this.a -= lengthToCopy;
                o();
            } else {
                return;
            }
        }
        if (length > 0) {
            throw new AssertionError("Failed executing read operation");
        }
    }

    private void o() {
        if (this.f4978a.peek().b() == 0) {
            this.f4978a.remove().close();
        }
    }

    /* renamed from: sb$c */
    private static abstract class c {
        int a;

        /* renamed from: a  reason: collision with other field name */
        IOException f4980a;

        /* access modifiers changed from: package-private */
        public abstract int c(id0 id0, int i);

        private c() {
        }

        /* synthetic */ c(a x0) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final void b(id0 buffer, int length) {
            try {
                this.a = c(buffer, length);
            } catch (IOException e) {
                this.f4980a = e;
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean a() {
            return this.f4980a != null;
        }
    }
}
