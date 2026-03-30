package defpackage;

import java.util.Random;

/* renamed from: jk  reason: default package */
public final class jk extends t {
    private final a a = new a();

    /* renamed from: jk$a */
    public static final class a extends ThreadLocal<Random> {
        a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Random initialValue() {
            return new Random();
        }
    }

    public Random d() {
        Object obj = this.a.get();
        lu.e(obj, "implStorage.get()");
        return (Random) obj;
    }
}
