package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ud0  reason: default package */
abstract class ud0<T> extends AtomicReference<T> implements yg {
    /* access modifiers changed from: protected */
    public abstract void b(T t);

    ud0(T value) {
        super(a40.c(value, "value is null"));
    }

    public final void dispose() {
        T value;
        if (get() != null && (value = getAndSet((Object) null)) != null) {
            b(value);
        }
    }

    public final boolean a() {
        return get() == null;
    }
}
