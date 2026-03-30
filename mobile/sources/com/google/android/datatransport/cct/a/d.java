package com.google.android.datatransport.cct.a;

import com.google.android.datatransport.cct.a.a;

final class d extends a {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final String f1336a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;

    static final class b extends a.C0009a {
        private Integer a;

        /* renamed from: a  reason: collision with other field name */
        private String f1337a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;

        b() {
        }

        public a.C0009a a(int i) {
            this.a = Integer.valueOf(i);
            return this;
        }

        public a.C0009a d(String str) {
            this.g = str;
            return this;
        }

        public a.C0009a e(String str) {
            this.b = str;
            return this;
        }

        public a.C0009a f(String str) {
            this.f = str;
            return this;
        }

        public a.C0009a g(String str) {
            this.f1337a = str;
            return this;
        }

        public a.C0009a h(String str) {
            this.e = str;
            return this;
        }

        public a.C0009a i(String str) {
            this.d = str;
            return this;
        }

        public a.C0009a b(String str) {
            this.c = str;
            return this;
        }

        public a c() {
            String str = "";
            if (this.a == null) {
                str = str + " sdkVersion";
            }
            if (str.isEmpty()) {
                return new d(this.a.intValue(), this.f1337a, this.b, this.c, this.d, this.e, this.f, this.g, (a) null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    /* synthetic */ d(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, a aVar) {
        this.a = i;
        this.f1336a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.g;
    }

    public String d() {
        return this.b;
    }

    public String e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        d dVar = (d) ((a) obj);
        if (this.a == dVar.a && ((str = this.f1336a) != null ? str.equals(dVar.f1336a) : dVar.f1336a == null) && ((str2 = this.b) != null ? str2.equals(dVar.b) : dVar.b == null) && ((str3 = this.c) != null ? str3.equals(dVar.c) : dVar.c == null) && ((str4 = this.d) != null ? str4.equals(dVar.d) : dVar.d == null) && ((str5 = this.e) != null ? str5.equals(dVar.e) : dVar.e == null) && ((str6 = this.f) != null ? str6.equals(dVar.f) : dVar.f == null)) {
            String str7 = this.g;
            if (str7 == null) {
                if (dVar.g == null) {
                    return true;
                }
            } else if (str7.equals(dVar.g)) {
                return true;
            }
        }
        return false;
    }

    public String f() {
        return this.f1336a;
    }

    public String g() {
        return this.e;
    }

    public String h() {
        return this.d;
    }

    public int hashCode() {
        int i = (this.a ^ 1000003) * 1000003;
        String str = this.f1336a;
        int i2 = 0;
        int hashCode = (i ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.b;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.c;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.d;
        int hashCode4 = (hashCode3 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.e;
        int hashCode5 = (hashCode4 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f;
        int hashCode6 = (hashCode5 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.g;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        return hashCode6 ^ i2;
    }

    public int i() {
        return this.a;
    }

    public String toString() {
        return "AndroidClientInfo{sdkVersion=" + this.a + ", model=" + this.f1336a + ", hardware=" + this.b + ", device=" + this.c + ", product=" + this.d + ", osBuild=" + this.e + ", manufacturer=" + this.f + ", fingerprint=" + this.g + "}";
    }
}
