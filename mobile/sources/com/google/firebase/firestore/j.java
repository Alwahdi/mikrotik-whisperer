package com.google.firebase.firestore;

public final class j {
    private final long a;

    /* renamed from: a  reason: collision with other field name */
    private final String f2269a;

    /* renamed from: a  reason: collision with other field name */
    private final boolean f2270a;
    private final boolean b;
    private final boolean c;

    public static final class b {
        /* access modifiers changed from: private */
        public long a = 104857600;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public String f2271a = "firestore.googleapis.com";
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public boolean f2272a = true;
        /* access modifiers changed from: private */
        public boolean b = true;
        /* access modifiers changed from: private */
        public boolean c = true;

        public j f() {
            if (this.f2272a || !this.f2271a.equals("firestore.googleapis.com")) {
                return new j(this);
            }
            throw new IllegalStateException("You can't set the 'sslEnabled' setting unless you also set a non-default 'host'.");
        }
    }

    private j(b builder) {
        this.f2269a = builder.f2271a;
        this.f2270a = builder.f2272a;
        this.b = builder.b;
        this.c = builder.c;
        this.a = builder.a;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        j that = (j) o;
        if (this.f2269a.equals(that.f2269a) && this.f2270a == that.f2270a && this.b == that.b && this.c == that.c && this.a == that.a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.f2269a.hashCode() * 31) + (this.f2270a ? 1 : 0)) * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31) + ((int) this.a);
    }

    public String toString() {
        return f20.c(this).d("host", this.f2269a).e("sslEnabled", this.f2270a).e("persistenceEnabled", this.b).e("timestampsInSnapshotsEnabled", this.c).toString();
    }

    public String c() {
        return this.f2269a;
    }

    public boolean e() {
        return this.f2270a;
    }

    public boolean d() {
        return this.b;
    }

    public boolean a() {
        return this.c;
    }

    public long b() {
        return this.a;
    }
}
