package defpackage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: y50  reason: default package */
public class y50 implements br {
    private static final HashSet<String> a = new HashSet<>(Arrays.asList(new String[]{"Pagination", "Layout", "Page", "Background"}));

    /* renamed from: a  reason: collision with other field name */
    protected g0 f5834a = new g0();

    /* renamed from: a  reason: collision with other field name */
    protected h70 f5835a = h70.O;

    /* renamed from: a  reason: collision with other field name */
    protected HashMap<h70, o70> f5836a = null;

    public o70 l(h70 key) {
        HashMap<h70, o70> hashMap = this.f5836a;
        if (hashMap != null) {
            return hashMap.get(key);
        }
        return null;
    }

    public void p(h70 key, o70 value) {
        if (this.f5836a == null) {
            this.f5836a = new HashMap<>();
        }
        this.f5836a.put(key, value);
    }

    public HashMap<h70, o70> u() {
        return this.f5836a;
    }

    public h70 j() {
        return this.f5835a;
    }

    public void b(h70 role) {
    }

    public g0 s() {
        return this.f5834a;
    }

    public void h(g0 id) {
        this.f5834a = id;
    }

    public boolean isInline() {
        return true;
    }
}
