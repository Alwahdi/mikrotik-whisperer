package defpackage;

/* renamed from: d4  reason: default package */
class d4 implements dd0 {
    private byte[] a;

    public d4(byte[] array) {
        if (array != null) {
            this.a = array;
            return;
        }
        throw new NullPointerException();
    }

    public int a(long offset) {
        byte[] bArr = this.a;
        if (offset >= ((long) bArr.length)) {
            return -1;
        }
        return bArr[(int) offset] & 255;
    }

    public int c(long offset, byte[] bytes, int off, int len) {
        byte[] bArr = this.a;
        if (bArr == null) {
            throw new IllegalStateException("Already closed");
        } else if (offset >= ((long) bArr.length)) {
            return -1;
        } else {
            if (((long) len) + offset > ((long) bArr.length)) {
                len = (int) (((long) bArr.length) - offset);
            }
            System.arraycopy(bArr, (int) offset, bytes, off, len);
            return len;
        }
    }

    public long b() {
        return (long) this.a.length;
    }

    public void close() {
        this.a = null;
    }
}
