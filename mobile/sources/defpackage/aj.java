package defpackage;

import defpackage.a5;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: aj  reason: default package */
public abstract class aj {
    /* access modifiers changed from: protected */
    public abstract Map<String, String> c();

    public abstract Integer d();

    public abstract pi e();

    public abstract long f();

    public abstract String j();

    public abstract long k();

    public final Map<String, String> i() {
        return Collections.unmodifiableMap(c());
    }

    public final int g(String key) {
        String value = c().get(key);
        if (value == null) {
            return 0;
        }
        return Integer.valueOf(value).intValue();
    }

    public final long h(String key) {
        String value = c().get(key);
        if (value == null) {
            return 0;
        }
        return Long.valueOf(value).longValue();
    }

    public final String b(String key) {
        String value = c().get(key);
        return value == null ? "" : value;
    }

    public a l() {
        return new a5.b().j(j()).g(d()).h(e()).i(f()).k(k()).f(new HashMap(c()));
    }

    public static a a() {
        return new a5.b().f(new HashMap());
    }

    /* renamed from: aj$a */
    public static abstract class a {
        public abstract aj d();

        /* access modifiers changed from: protected */
        public abstract Map<String, String> e();

        /* access modifiers changed from: protected */
        public abstract a f(Map<String, String> map);

        public abstract a g(Integer num);

        public abstract a h(pi piVar);

        public abstract a i(long j);

        public abstract a j(String str);

        public abstract a k(long j);

        public final a c(String key, String value) {
            e().put(key, value);
            return this;
        }

        public final a b(String key, long value) {
            e().put(key, String.valueOf(value));
            return this;
        }

        public final a a(String key, int value) {
            e().put(key, String.valueOf(value));
            return this;
        }
    }
}
