package defpackage;

/* renamed from: on  reason: default package */
public abstract class on implements id0 {
    private final id0 a;

    protected on(id0 buf) {
        this.a = (id0) v90.o(buf, "buf");
    }

    public int b() {
        return this.a.b();
    }

    public int readUnsignedByte() {
        return this.a.readUnsignedByte();
    }

    public void m(byte[] dest, int destOffset, int length) {
        this.a.m(dest, destOffset, length);
    }

    public id0 v(int length) {
        return this.a.v(length);
    }

    public String toString() {
        return f20.c(this).d("delegate", this.a).toString();
    }
}
