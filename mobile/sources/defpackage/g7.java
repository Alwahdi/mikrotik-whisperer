package defpackage;

import java.util.HashMap;

/* renamed from: g7  reason: default package */
public abstract class g7 {
    private static final HashMap<String, k7> a = new HashMap<>();
    private static final HashMap<String, i7> b = new HashMap<>();
    private static final HashMap<String, h7> c = new HashMap<>();
    private static final HashMap<String, Object> d = new HashMap<>();

    public static k7 c(String name) {
        k7 cmap;
        HashMap<String, k7> hashMap = a;
        synchronized (hashMap) {
            cmap = hashMap.get(name);
        }
        if (cmap != null) {
            return cmap;
        }
        k7 cmap2 = new k7();
        j7.a(name, cmap2, new r8());
        synchronized (hashMap) {
            hashMap.put(name, cmap2);
        }
        return cmap2;
    }

    public static i7 b(String name) {
        i7 cmap;
        HashMap<String, i7> hashMap = b;
        synchronized (hashMap) {
            cmap = hashMap.get(name);
        }
        if (cmap != null) {
            return cmap;
        }
        i7 cmap2 = new i7();
        j7.a(name, cmap2, new r8());
        synchronized (hashMap) {
            hashMap.put(name, cmap2);
        }
        return cmap2;
    }

    public static h7 a(String name) {
        h7 cmap;
        HashMap<String, h7> hashMap = c;
        synchronized (hashMap) {
            cmap = hashMap.get(name);
        }
        if (cmap != null) {
            return cmap;
        }
        h7 cmap2 = new h7();
        j7.a(name, cmap2, new r8());
        synchronized (hashMap) {
            hashMap.put(name, cmap2);
        }
        return cmap2;
    }
}
