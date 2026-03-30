package com.google.android.datatransport.cct.a;

import com.google.android.datatransport.cct.a.o;
import java.util.Arrays;

final class g extends o {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final long f1340a;

    /* renamed from: a  reason: collision with other field name */
    private final s f1341a;

    /* renamed from: a  reason: collision with other field name */
    private final String f1342a;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f1343a;
    private final long b;
    private final long c;

    static final class b extends o.a {
        private s a;

        /* renamed from: a  reason: collision with other field name */
        private Integer f1344a;

        /* renamed from: a  reason: collision with other field name */
        private Long f1345a;

        /* renamed from: a  reason: collision with other field name */
        private String f1346a;

        /* renamed from: a  reason: collision with other field name */
        private byte[] f1347a;
        private Long b;
        private Long c;

        b() {
        }

        public o.a b(long j) {
            this.f1345a = Long.valueOf(j);
            return this;
        }

        public o.a g(long j) {
            this.b = Long.valueOf(j);
            return this;
        }

        public o.a h(long j) {
            this.c = Long.valueOf(j);
            return this;
        }

        public o.a a(int i) {
            this.f1344a = Integer.valueOf(i);
            return this;
        }

        /* access modifiers changed from: package-private */
        public o.a e(byte[] bArr) {
            this.f1347a = bArr;
            return this;
        }

        /* access modifiers changed from: package-private */
        public o.a d(String str) {
            this.f1346a = str;
            return this;
        }

        public o.a c(s sVar) {
            this.a = sVar;
            return this;
        }

        public o f() {
            String str = "";
            if (this.f1345a == null) {
                str = str + " eventTimeMs";
            }
            if (this.f1344a == null) {
                str = str + " eventCode";
            }
            if (this.b == null) {
                str = str + " eventUptimeMs";
            }
            if (this.c == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new g(this.f1345a.longValue(), this.f1344a.intValue(), this.b.longValue(), this.f1347a, this.f1346a, this.c.longValue(), this.a, (a) null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    /* synthetic */ g(long j, int i, long j2, byte[] bArr, String str, long j3, s sVar, a aVar) {
        this.f1340a = j;
        this.a = i;
        this.b = j2;
        this.f1343a = bArr;
        this.f1342a = str;
        this.c = j3;
        this.f1341a = sVar;
    }

    public long a() {
        return this.f1340a;
    }

    public long d() {
        return this.b;
    }

    public long e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f1340a == oVar.a()) {
            g gVar = (g) oVar;
            if (this.a == gVar.a && this.b == oVar.d()) {
                byte[] bArr2 = this.f1343a;
                if (oVar instanceof g) {
                    bArr = gVar.f1343a;
                } else {
                    bArr = gVar.f1343a;
                }
                if (Arrays.equals(bArr2, bArr) && ((str = this.f1342a) != null ? str.equals(gVar.f1342a) : gVar.f1342a == null) && this.c == oVar.e()) {
                    s sVar = this.f1341a;
                    if (sVar == null) {
                        if (gVar.f1341a == null) {
                            return true;
                        }
                    } else if (sVar.equals(gVar.f1341a)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int f() {
        return this.a;
    }

    public s g() {
        return this.f1341a;
    }

    public byte[] h() {
        return this.f1343a;
    }

    public int hashCode() {
        long j = this.f1340a;
        long j2 = this.b;
        int hashCode = (((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.a) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f1343a)) * 1000003;
        String str = this.f1342a;
        int i = 0;
        int hashCode2 = str == null ? 0 : str.hashCode();
        long j3 = this.c;
        int i2 = (((hashCode ^ hashCode2) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003;
        s sVar = this.f1341a;
        if (sVar != null) {
            i = sVar.hashCode();
        }
        return i2 ^ i;
    }

    public String i() {
        return this.f1342a;
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f1340a + ", eventCode=" + this.a + ", eventUptimeMs=" + this.b + ", sourceExtension=" + Arrays.toString(this.f1343a) + ", sourceExtensionJsonProto3=" + this.f1342a + ", timezoneOffsetSeconds=" + this.c + ", networkConnectionInfo=" + this.f1341a + "}";
    }
}
