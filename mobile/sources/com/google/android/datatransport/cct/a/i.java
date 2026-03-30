package com.google.android.datatransport.cct.a;

import com.google.android.datatransport.cct.a.s;

final class i extends s {
    private final s.b a;

    /* renamed from: a  reason: collision with other field name */
    private final s.c f1358a;

    static final class b extends s.a {
        private s.b a;

        /* renamed from: a  reason: collision with other field name */
        private s.c f1359a;

        b() {
        }

        public s.a b(s.c cVar) {
            this.f1359a = cVar;
            return this;
        }

        public s.a a(s.b bVar) {
            this.a = bVar;
            return this;
        }

        public s c() {
            return new i(this.f1359a, this.a, (a) null);
        }
    }

    /* synthetic */ i(s.c cVar, s.b bVar, a aVar) {
        this.f1358a = cVar;
        this.a = bVar;
    }

    public s.b b() {
        return this.a;
    }

    public s.c c() {
        return this.f1358a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s.c cVar = this.f1358a;
        if (cVar != null ? cVar.equals(((i) obj).f1358a) : ((i) obj).f1358a == null) {
            s.b bVar = this.a;
            if (bVar == null) {
                if (((i) obj).a == null) {
                    return true;
                }
            } else if (bVar.equals(((i) obj).a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        s.c cVar = this.f1358a;
        int i = 0;
        int hashCode = ((cVar == null ? 0 : cVar.hashCode()) ^ 1000003) * 1000003;
        s.b bVar = this.a;
        if (bVar != null) {
            i = bVar.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f1358a + ", mobileSubtype=" + this.a + "}";
    }
}
