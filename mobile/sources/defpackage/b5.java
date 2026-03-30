package defpackage;

import defpackage.ij;

/* renamed from: b5  reason: default package */
final class b5 extends ij {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final long f174a;
    private final int b;

    /* renamed from: b  reason: collision with other field name */
    private final long f175b;

    private b5(long maxStorageSizeInBytes, int loadBatchSize, int criticalSectionEnterTimeoutMs, long eventCleanUpAge) {
        this.f174a = maxStorageSizeInBytes;
        this.a = loadBatchSize;
        this.b = criticalSectionEnterTimeoutMs;
        this.f175b = eventCleanUpAge;
    }

    /* access modifiers changed from: package-private */
    public long e() {
        return this.f174a;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public long c() {
        return this.f175b;
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f174a + ", loadBatchSize=" + this.a + ", criticalSectionEnterTimeoutMs=" + this.b + ", eventCleanUpAge=" + this.f175b + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ij)) {
            return false;
        }
        ij that = (ij) o;
        if (this.f174a == that.e() && this.a == that.d() && this.b == that.b() && this.f175b == that.c()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.f174a;
        long j2 = this.f175b;
        return (((((((1 * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.a) * 1000003) ^ this.b) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    /* renamed from: b5$b */
    static final class b extends ij.a {
        private Integer a;

        /* renamed from: a  reason: collision with other field name */
        private Long f176a;
        private Integer b;

        /* renamed from: b  reason: collision with other field name */
        private Long f177b;

        b() {
        }

        /* access modifiers changed from: package-private */
        public ij.a e(long maxStorageSizeInBytes) {
            this.f176a = Long.valueOf(maxStorageSizeInBytes);
            return this;
        }

        /* access modifiers changed from: package-private */
        public ij.a d(int loadBatchSize) {
            this.a = Integer.valueOf(loadBatchSize);
            return this;
        }

        /* access modifiers changed from: package-private */
        public ij.a b(int criticalSectionEnterTimeoutMs) {
            this.b = Integer.valueOf(criticalSectionEnterTimeoutMs);
            return this;
        }

        /* access modifiers changed from: package-private */
        public ij.a c(long eventCleanUpAge) {
            this.f177b = Long.valueOf(eventCleanUpAge);
            return this;
        }

        /* access modifiers changed from: package-private */
        public ij a() {
            String missing = "";
            if (this.f176a == null) {
                missing = missing + " maxStorageSizeInBytes";
            }
            if (this.a == null) {
                missing = missing + " loadBatchSize";
            }
            if (this.b == null) {
                missing = missing + " criticalSectionEnterTimeoutMs";
            }
            if (this.f177b == null) {
                missing = missing + " eventCleanUpAge";
            }
            if (missing.isEmpty()) {
                return new b5(this.f176a.longValue(), this.a.intValue(), this.b.intValue(), this.f177b.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + missing);
        }
    }
}
