package defpackage;

import com.google.protobuf.e;

/* renamed from: l6  reason: default package */
public class l6 implements Comparable<l6> {
    private final e a;

    private l6(e bytes) {
        this.a = bytes;
    }

    public static l6 b(e bytes) {
        v90.o(bytes, "Provided ByteString must not be null.");
        return new l6(bytes);
    }

    public String toString() {
        return "Blob { bytes=" + qu0.m(this.a) + " }";
    }

    public e c() {
        return this.a;
    }

    public boolean equals(Object other) {
        return (other instanceof l6) && this.a.equals(((l6) other).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    /* renamed from: a */
    public int compareTo(l6 other) {
        int size = Math.min(this.a.size(), other.a.size());
        for (int i = 0; i < size; i++) {
            int thisByte = this.a.b(i) & 255;
            int otherByte = other.a.b(i) & 255;
            if (thisByte < otherByte) {
                return -1;
            }
            if (thisByte > otherByte) {
                return 1;
            }
        }
        return qu0.d(this.a.size(), other.a.size());
    }
}
