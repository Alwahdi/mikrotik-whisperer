package defpackage;

import defpackage.es0;
import java.util.Arrays;

/* renamed from: f5  reason: default package */
final class f5 extends es0 {
    private final com.google.android.datatransport.a a;

    /* renamed from: a  reason: collision with other field name */
    private final String f2946a;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f2947a;

    private f5(String backendName, byte[] extras, com.google.android.datatransport.a priority) {
        this.f2946a = backendName;
        this.f2947a = extras;
        this.a = priority;
    }

    public String b() {
        return this.f2946a;
    }

    public byte[] c() {
        return this.f2947a;
    }

    public com.google.android.datatransport.a d() {
        return this.a;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof es0)) {
            return false;
        }
        es0 that = (es0) o;
        if (this.f2946a.equals(that.b())) {
            if (!Arrays.equals(this.f2947a, that instanceof f5 ? ((f5) that).f2947a : that.c()) || !this.a.equals(that.d())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((1 * 1000003) ^ this.f2946a.hashCode()) * 1000003) ^ Arrays.hashCode(this.f2947a)) * 1000003) ^ this.a.hashCode();
    }

    /* renamed from: f5$b */
    static final class b extends es0.a {
        private com.google.android.datatransport.a a;

        /* renamed from: a  reason: collision with other field name */
        private String f2948a;

        /* renamed from: a  reason: collision with other field name */
        private byte[] f2949a;

        b() {
        }

        public es0.a b(String backendName) {
            if (backendName != null) {
                this.f2948a = backendName;
                return this;
            }
            throw new NullPointerException("Null backendName");
        }

        public es0.a c(byte[] extras) {
            this.f2949a = extras;
            return this;
        }

        public es0.a d(com.google.android.datatransport.a priority) {
            if (priority != null) {
                this.a = priority;
                return this;
            }
            throw new NullPointerException("Null priority");
        }

        public es0 a() {
            String missing = "";
            if (this.f2948a == null) {
                missing = missing + " backendName";
            }
            if (this.a == null) {
                missing = missing + " priority";
            }
            if (missing.isEmpty()) {
                return new f5(this.f2948a, this.f2949a, this.a);
            }
            throw new IllegalStateException("Missing required properties:" + missing);
        }
    }
}
