package defpackage;

import java.util.Map;

/* renamed from: hp  reason: default package */
public class hp {
    private String a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, Object> f3177a;

    public hp(String str, Map<String, Object> map) {
        this.a = str;
        this.f3177a = map;
    }

    public String c() {
        return this.a;
    }

    public String b() {
        Map map = (Map) this.f3177a.get("firebase");
        if (map != null) {
            return (String) map.get("sign_in_provider");
        }
        return null;
    }

    public Map<String, Object> a() {
        return this.f3177a;
    }
}
