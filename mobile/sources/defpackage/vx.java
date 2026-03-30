package defpackage;

import defpackage.b30;
import defpackage.ux;
import java.util.Map;

/* renamed from: vx  reason: default package */
public abstract class vx extends ux.c {
    private static final b30.b a = b30.b.a(new a());

    public abstract String b();

    public abstract int c();

    public abstract boolean d();

    public abstract b30.b e(Map<String, ?> map);

    public final String toString() {
        return f20.c(this).d("policy", b()).b("priority", c()).e("available", d()).toString();
    }

    public final boolean equals(Object other) {
        return this == other;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    /* renamed from: vx$a */
    private static final class a {
        a() {
        }

        public String toString() {
            return "service config is unused";
        }
    }
}
