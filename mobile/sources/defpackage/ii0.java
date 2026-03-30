package defpackage;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: ii0  reason: default package */
final class ii0<T> implements rw<T>, Serializable {
    public static final a a = new a((Cif) null);

    /* renamed from: a  reason: collision with other field name */
    private static final AtomicReferenceFieldUpdater<ii0<?>, Object> f3243a = AtomicReferenceFieldUpdater.newUpdater(ii0.class, Object.class, "a");

    /* renamed from: a  reason: collision with other field name */
    private volatile Object f3244a;

    /* renamed from: a  reason: collision with other field name */
    private volatile tn<? extends T> f3245a;
    private final Object b;

    public ii0(tn<? extends T> initializer) {
        lu.f(initializer, "initializer");
        this.f3245a = initializer;
        bt0 bt0 = bt0.a;
        this.f3244a = bt0;
        this.b = bt0;
    }

    public T getValue() {
        Object value = this.f3244a;
        Object obj = bt0.a;
        if (value != obj) {
            return value;
        }
        tn initializerValue = this.f3245a;
        if (initializerValue != null) {
            Object newValue = initializerValue.invoke();
            if (w.a(f3243a, this, obj, newValue)) {
                this.f3245a = null;
                return newValue;
            }
        }
        return this.f3244a;
    }

    public boolean a() {
        return this.f3244a != bt0.a;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    /* renamed from: ii0$a */
    public static final class a {
        public /* synthetic */ a(Cif ifVar) {
            this();
        }

        private a() {
        }
    }
}
