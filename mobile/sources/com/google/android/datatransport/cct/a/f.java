package com.google.android.datatransport.cct.a;

import com.google.android.datatransport.cct.a.l;

final class f extends l {
    private final a a;

    /* renamed from: a  reason: collision with other field name */
    private final l.b f1338a;

    static final class b extends l.a {
        private a a;

        /* renamed from: a  reason: collision with other field name */
        private l.b f1339a;

        b() {
        }

        public l.a b(l.b bVar) {
            this.f1339a = bVar;
            return this;
        }

        public l.a a(a aVar) {
            this.a = aVar;
            return this;
        }

        public l c() {
            return new f(this.f1339a, this.a, (a) null);
        }
    }

    /* synthetic */ f(l.b bVar, a aVar, a aVar2) {
        this.f1338a = bVar;
        this.a = aVar;
    }

    public a b() {
        return this.a;
    }

    public l.b c() {
        return this.f1338a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l.b bVar = this.f1338a;
        if (bVar != null ? bVar.equals(((f) obj).f1338a) : ((f) obj).f1338a == null) {
            a aVar = this.a;
            if (aVar == null) {
                if (((f) obj).a == null) {
                    return true;
                }
            } else if (aVar.equals(((f) obj).a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        l.b bVar = this.f1338a;
        int i = 0;
        int hashCode = ((bVar == null ? 0 : bVar.hashCode()) ^ 1000003) * 1000003;
        a aVar = this.a;
        if (aVar != null) {
            i = aVar.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f1338a + ", androidClientInfo=" + this.a + "}";
    }
}
