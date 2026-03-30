package defpackage;

import java.util.Map;

/* renamed from: g01  reason: default package */
public abstract class g01 {
    private static final vy a = new vy("GetTokenResultFactory", new String[0]);

    public static hp a(String str) {
        Map map;
        try {
            map = d01.b(str);
        } catch (wy0 e) {
            a.a("Error parsing token claims", e, new Object[0]);
            map = d21.a();
        }
        return new hp(str, map);
    }
}
