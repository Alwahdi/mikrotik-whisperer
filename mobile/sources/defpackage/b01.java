package defpackage;

import android.util.Log;
import java.util.Map;

/* renamed from: b01  reason: default package */
final class b01 implements m01 {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<String, Integer> f131a;
    private final int b;

    public b01(int i, int i2, Map<String, Integer> map) {
        this.a = b() ? 0 : i;
        this.b = i2;
        this.f131a = (Map) y90.j(map);
        b();
    }

    public final boolean a(String str) {
        int i = this.a;
        if (i == 0) {
            return true;
        }
        if (this.b <= i) {
            return false;
        }
        Integer num = this.f131a.get(str);
        if (num == null) {
            num = 0;
        }
        if (num.intValue() <= this.a || this.b < num.intValue()) {
            return false;
        }
        return true;
    }

    private static boolean b() {
        boolean equals = "local".equals(y61.a("firebear.preference"));
        if (equals) {
            Log.e("BiChannelGoogleApi", "Found local preference, will always use local service instance");
        }
        return equals;
    }
}
