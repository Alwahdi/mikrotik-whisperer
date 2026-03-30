package defpackage;

import java.util.ArrayList;

/* renamed from: vs  reason: default package */
public final class vs {
    private final ArrayList<String> a = new ArrayList<>();

    public vs a(Object insight) {
        this.a.add(String.valueOf(insight));
        return this;
    }

    public vs b(String key, Object value) {
        ArrayList<String> arrayList = this.a;
        arrayList.add(key + "=" + value);
        return this;
    }

    public String toString() {
        return this.a.toString();
    }
}
