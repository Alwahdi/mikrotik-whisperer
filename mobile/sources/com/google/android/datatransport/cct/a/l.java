package com.google.android.datatransport.cct.a;

import com.google.android.datatransport.cct.a.f;

public abstract class l {

    public static abstract class a {
        public abstract a a(a aVar);

        public abstract a b(b bVar);

        public abstract l c();
    }

    public enum b {
        UNKNOWN(0),
        ANDROID(4);

        static {
            b bVar = new b("UNKNOWN", 0, 0);
            UNKNOWN = bVar;
            b bVar2 = new b("ANDROID", 1, 4);
            ANDROID = bVar2;
            b[] bVarArr = {bVar, bVar2};
        }

        private b(int i) {
        }
    }

    public static a a() {
        return new f.b();
    }
}
