package defpackage;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* renamed from: w30  reason: default package */
public class w30<T> extends lz<T> {
    private final Comparator<? super T> a;

    /* renamed from: a  reason: collision with other field name */
    private final Iterator<? extends T> f5429a;
    private Iterator<T> b;

    public w30(Iterator<? extends T> iterator, Comparator<? super T> comparator) {
        this.f5429a = iterator;
        this.a = comparator;
    }

    /* access modifiers changed from: protected */
    public void a() {
        if (!this.b) {
            List<T> list = w40.a(this.f5429a);
            Collections.sort(list, this.a);
            this.b = list.iterator();
        }
        boolean hasNext = this.b.hasNext();
        this.f4300a = hasNext;
        if (hasNext) {
            this.a = this.b.next();
        }
    }
}
