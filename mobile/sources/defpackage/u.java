package defpackage;

/* renamed from: u  reason: default package */
public abstract class u implements id0 {
    public final int readInt() {
        c(4);
        return (readUnsignedByte() << 24) | (readUnsignedByte() << 16) | (readUnsignedByte() << 8) | readUnsignedByte();
    }

    public void close() {
    }

    /* access modifiers changed from: protected */
    public final void c(int length) {
        if (b() < length) {
            throw new IndexOutOfBoundsException();
        }
    }
}
