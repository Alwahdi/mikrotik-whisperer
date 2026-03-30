package defpackage;

import java.io.Serializable;

/* renamed from: yo0  reason: default package */
final class yo0<T> implements rw<T>, Serializable {
    private volatile Object a;

    /* renamed from: a  reason: collision with other field name */
    private tn<? extends T> f5915a;
    private final Object b;

    public yo0(tn<? extends T> initializer, Object lock) {
        lu.f(initializer, "initializer");
        this.f5915a = initializer;
        this.a = bt0.a;
        this.b = lock == null ? this : lock;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ yo0(tn tnVar, Object obj, int i, Cif ifVar) {
        this(tnVar, (i & 2) != 0 ? null : obj);
    }

    public T getValue() {
        Object typedValue;
        Object _v1 = this.a;
        Object obj = bt0.a;
        if (_v1 != obj) {
            return _v1;
        }
        synchronized (this.b) {
            Object _v2 = this.a;
            if (_v2 != obj) {
                typedValue = _v2;
            } else {
                tn tnVar = this.f5915a;
                lu.c(tnVar);
                typedValue = tnVar.invoke();
                this.a = typedValue;
                this.f5915a = null;
            }
        }
        return typedValue;
    }

    public boolean a() {
        return this.a != bt0.a;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
