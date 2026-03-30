package defpackage;

import java.util.Arrays;

/* renamed from: pi  reason: default package */
public final class pi {
    private final qi a;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f4715a;

    public pi(qi encoding, byte[] bytes) {
        if (encoding == null) {
            throw new NullPointerException("encoding is null");
        } else if (bytes != null) {
            this.a = encoding;
            this.f4715a = bytes;
        } else {
            throw new NullPointerException("bytes is null");
        }
    }

    public qi b() {
        return this.a;
    }

    public byte[] a() {
        return this.f4715a;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof pi)) {
            return false;
        }
        pi that = (pi) o;
        if (!this.a.equals(that.a)) {
            return false;
        }
        return Arrays.equals(this.f4715a, that.f4715a);
    }

    public int hashCode() {
        return ((1000003 ^ this.a.hashCode()) * 1000003) ^ Arrays.hashCode(this.f4715a);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.a + ", bytes=[...]}";
    }
}
