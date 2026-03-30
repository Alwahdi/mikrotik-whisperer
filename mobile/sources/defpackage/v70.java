package defpackage;

import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: v70  reason: default package */
public class v70 implements br {
    protected g0 a = new g0();

    /* renamed from: a  reason: collision with other field name */
    protected h70 f5308a = h70.Db;

    /* renamed from: a  reason: collision with other field name */
    protected ArrayList<t70> f5309a = null;

    /* renamed from: a  reason: collision with other field name */
    protected HashMap<h70, o70> f5310a = null;

    public o70 l(h70 key) {
        HashMap<h70, o70> hashMap = this.f5310a;
        if (hashMap != null) {
            return hashMap.get(key);
        }
        return null;
    }

    public void p(h70 key, o70 value) {
        if (this.f5310a == null) {
            this.f5310a = new HashMap<>();
        }
        this.f5310a.put(key, value);
    }

    public HashMap<h70, o70> u() {
        return this.f5310a;
    }

    public h70 j() {
        return this.f5308a;
    }

    public void b(h70 role) {
        this.f5308a = role;
    }

    public g0 s() {
        return this.a;
    }

    public void h(g0 id) {
        this.a = id;
    }

    public boolean isInline() {
        return false;
    }
}
