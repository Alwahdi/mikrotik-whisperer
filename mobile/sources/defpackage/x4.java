package defpackage;

import defpackage.i5;
import java.util.Arrays;

/* renamed from: x4  reason: default package */
final class x4 extends i5 {
    private final Iterable<aj> a;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f5568a;

    private x4(Iterable<aj> events, byte[] extras) {
        this.a = events;
        this.f5568a = extras;
    }

    public Iterable<aj> b() {
        return this.a;
    }

    public byte[] c() {
        return this.f5568a;
    }

    public String toString() {
        return "BackendRequest{events=" + this.a + ", extras=" + Arrays.toString(this.f5568a) + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof i5)) {
            return false;
        }
        i5 that = (i5) o;
        if (this.a.equals(that.b())) {
            if (Arrays.equals(this.f5568a, that instanceof x4 ? ((x4) that).f5568a : that.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((1 * 1000003) ^ this.a.hashCode()) * 1000003) ^ Arrays.hashCode(this.f5568a);
    }

    /* renamed from: x4$b */
    static final class b extends i5.a {
        private Iterable<aj> a;

        /* renamed from: a  reason: collision with other field name */
        private byte[] f5569a;

        b() {
        }

        public i5.a b(Iterable<aj> events) {
            if (events != null) {
                this.a = events;
                return this;
            }
            throw new NullPointerException("Null events");
        }

        public i5.a c(byte[] extras) {
            this.f5569a = extras;
            return this;
        }

        public i5 a() {
            String missing = "";
            if (this.a == null) {
                missing = missing + " events";
            }
            if (missing.isEmpty()) {
                return new x4(this.a, this.f5569a);
            }
            throw new IllegalStateException("Missing required properties:" + missing);
        }
    }
}
