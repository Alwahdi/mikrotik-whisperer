package defpackage;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: gc  reason: default package */
public final class gc<T> implements ck0<T> {
    private final AtomicReference<ck0<T>> a;

    public gc(ck0<? extends T> sequence) {
        lu.f(sequence, "sequence");
        this.a = new AtomicReference<>(sequence);
    }

    public Iterator<T> iterator() {
        ck0 sequence = this.a.getAndSet((Object) null);
        if (sequence != null) {
            return sequence.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
