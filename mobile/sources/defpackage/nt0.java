package defpackage;

import java.io.Serializable;

/* renamed from: nt0  reason: default package */
public final class nt0<T> implements rw<T>, Serializable {
    private Object a = bt0.a;

    /* renamed from: a  reason: collision with other field name */
    private tn<? extends T> f4459a;

    public nt0(tn<? extends T> initializer) {
        lu.f(initializer, "initializer");
        this.f4459a = initializer;
    }

    public T getValue() {
        if (this.a == bt0.a) {
            tn<? extends T> tnVar = this.f4459a;
            lu.c(tnVar);
            this.a = tnVar.invoke();
            this.f4459a = null;
        }
        return this.a;
    }

    public boolean a() {
        return this.a != bt0.a;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
