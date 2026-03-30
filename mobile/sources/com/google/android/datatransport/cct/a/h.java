package com.google.android.datatransport.cct.a;

import com.google.android.datatransport.cct.a.q;
import java.util.List;

final class h extends q {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final long f1348a;

    /* renamed from: a  reason: collision with other field name */
    private final b f1349a;

    /* renamed from: a  reason: collision with other field name */
    private final l f1350a;

    /* renamed from: a  reason: collision with other field name */
    private final String f1351a;

    /* renamed from: a  reason: collision with other field name */
    private final List<o> f1352a;
    private final long b;

    static final class b extends q.a {
        private b a;

        /* renamed from: a  reason: collision with other field name */
        private l f1353a;

        /* renamed from: a  reason: collision with other field name */
        private Integer f1354a;

        /* renamed from: a  reason: collision with other field name */
        private Long f1355a;

        /* renamed from: a  reason: collision with other field name */
        private String f1356a;

        /* renamed from: a  reason: collision with other field name */
        private List<o> f1357a;
        private Long b;

        b() {
        }

        public q.a b(long j) {
            this.f1355a = Long.valueOf(j);
            return this;
        }

        public q.a i(long j) {
            this.b = Long.valueOf(j);
            return this;
        }

        public q.a d(l lVar) {
            this.f1353a = lVar;
            return this;
        }

        /* access modifiers changed from: package-private */
        public q.a a(int i) {
            this.f1354a = Integer.valueOf(i);
            return this;
        }

        /* access modifiers changed from: package-private */
        public q.a e(String str) {
            this.f1356a = str;
            return this;
        }

        public q.a f(List<o> list) {
            this.f1357a = list;
            return this;
        }

        public q.a c(b bVar) {
            this.a = bVar;
            return this;
        }

        public q g() {
            String str = "";
            if (this.f1355a == null) {
                str = str + " requestTimeMs";
            }
            if (this.b == null) {
                str = str + " requestUptimeMs";
            }
            if (this.f1354a == null) {
                str = str + " logSource";
            }
            if (str.isEmpty()) {
                return new h(this.f1355a.longValue(), this.b.longValue(), this.f1353a, this.f1354a.intValue(), this.f1356a, this.f1357a, this.a, (a) null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    /* synthetic */ h(long j, long j2, l lVar, int i, String str, List list, b bVar, a aVar) {
        this.f1348a = j;
        this.b = j2;
        this.f1350a = lVar;
        this.a = i;
        this.f1351a = str;
        this.f1352a = list;
        this.f1349a = bVar;
    }

    public l b() {
        return this.f1350a;
    }

    public List<o> c() {
        return this.f1352a;
    }

    public int d() {
        return this.a;
    }

    public String e() {
        return this.f1351a;
    }

    public boolean equals(Object obj) {
        l lVar;
        String str;
        List<o> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        h hVar = (h) ((q) obj);
        if (this.f1348a == hVar.f1348a && this.b == hVar.b && ((lVar = this.f1350a) != null ? lVar.equals(hVar.f1350a) : hVar.f1350a == null) && this.a == hVar.a && ((str = this.f1351a) != null ? str.equals(hVar.f1351a) : hVar.f1351a == null) && ((list = this.f1352a) != null ? list.equals(hVar.f1352a) : hVar.f1352a == null)) {
            b bVar = this.f1349a;
            if (bVar == null) {
                if (hVar.f1349a == null) {
                    return true;
                }
            } else if (bVar.equals(hVar.f1349a)) {
                return true;
            }
        }
        return false;
    }

    public long f() {
        return this.f1348a;
    }

    public long g() {
        return this.b;
    }

    public int hashCode() {
        long j = this.f1348a;
        long j2 = this.b;
        int i = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        l lVar = this.f1350a;
        int i2 = 0;
        int hashCode = (((i ^ (lVar == null ? 0 : lVar.hashCode())) * 1000003) ^ this.a) * 1000003;
        String str = this.f1351a;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<o> list = this.f1352a;
        int hashCode3 = (hashCode2 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        b bVar = this.f1349a;
        if (bVar != null) {
            i2 = bVar.hashCode();
        }
        return hashCode3 ^ i2;
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f1348a + ", requestUptimeMs=" + this.b + ", clientInfo=" + this.f1350a + ", logSource=" + this.a + ", logSourceName=" + this.f1351a + ", logEvents=" + this.f1352a + ", qosTier=" + this.f1349a + "}";
    }
}
