package defpackage;

import java.util.Map;

/* renamed from: xi  reason: default package */
final /* synthetic */ class xi implements Runnable {
    private final Map.Entry a;

    /* renamed from: a  reason: collision with other field name */
    private final vi f5744a;

    private xi(Map.Entry entry, vi viVar) {
        this.a = entry;
    }

    public static Runnable a(Map.Entry entry, vi viVar) {
        return new xi(entry, viVar);
    }

    public void run() {
        ((zi) this.a.getKey()).a(this.f5744a);
    }
}
