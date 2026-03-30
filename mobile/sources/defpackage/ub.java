package defpackage;

import defpackage.f9;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: ub  reason: default package */
public final class ub {
    private static final ub a = new ub(new f9.a(), f9.b.a);

    /* renamed from: a  reason: collision with other field name */
    private final ConcurrentMap<String, tb> f5239a = new ConcurrentHashMap();

    public static ub a() {
        return a;
    }

    ub(tb... cs) {
        for (tb c : cs) {
            this.f5239a.put(c.a(), c);
        }
    }

    public tb b(String compressorName) {
        return (tb) this.f5239a.get(compressorName);
    }
}
