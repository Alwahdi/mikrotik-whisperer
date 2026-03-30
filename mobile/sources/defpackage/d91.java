package defpackage;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: d91  reason: default package */
final class d91 {
    private final ReferenceQueue<Throwable> a = new ReferenceQueue<>();

    /* renamed from: a  reason: collision with other field name */
    private final ConcurrentHashMap<p91, List<Throwable>> f2749a = new ConcurrentHashMap<>(16, 0.75f, 10);

    d91() {
    }

    public final List<Throwable> a(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.a.poll();
        while (poll != null) {
            this.f2749a.remove(poll);
            poll = this.a.poll();
        }
        List<Throwable> list = this.f2749a.get(new p91(th, (ReferenceQueue<Throwable>) null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f2749a.putIfAbsent(new p91(th, this.a), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
