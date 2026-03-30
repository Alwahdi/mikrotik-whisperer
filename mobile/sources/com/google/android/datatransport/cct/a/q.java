package com.google.android.datatransport.cct.a;

import com.google.android.datatransport.cct.a.h;
import java.util.List;

public abstract class q {

    public static abstract class a {
        /* access modifiers changed from: package-private */
        public abstract a a(int i);

        public abstract a b(long j);

        public abstract a c(b bVar);

        public abstract a d(l lVar);

        /* access modifiers changed from: package-private */
        public abstract a e(String str);

        public abstract a f(List<o> list);

        public abstract q g();

        public a h(int i) {
            return a(i);
        }

        public abstract a i(long j);

        public a j(String str) {
            return e(str);
        }
    }

    public static a a() {
        return new h.b().a(Integer.MIN_VALUE);
    }
}
