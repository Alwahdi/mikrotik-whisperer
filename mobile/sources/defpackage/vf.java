package defpackage;

import java.util.Iterator;
import java.util.Set;

/* renamed from: vf  reason: default package */
public class vf implements zt0 {
    private final String a;

    /* renamed from: a  reason: collision with other field name */
    private final jp f5383a;

    vf(Set<yw> libraryVersions, jp gamesSDKRegistrar) {
        this.a = d(libraryVersions);
        this.f5383a = gamesSDKRegistrar;
    }

    public String a() {
        if (this.f5383a.b().isEmpty()) {
            return this.a;
        }
        return this.a + ' ' + d(this.f5383a.b());
    }

    private static String d(Set<yw> tokens) {
        StringBuilder sb = new StringBuilder();
        Iterator<yw> it = tokens.iterator();
        while (it.hasNext()) {
            yw token = it.next();
            sb.append(token.b());
            sb.append('/');
            sb.append(token.c());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public static cb<zt0> b() {
        return cb.a(zt0.class).b(cg.h(yw.class)).f(uf.b()).d();
    }

    static /* synthetic */ zt0 c(hb c) {
        return new vf(c.a(yw.class), jp.a());
    }
}
