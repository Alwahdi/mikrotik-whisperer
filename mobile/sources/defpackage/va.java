package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: va  reason: default package */
public class va {
    private static final /* synthetic */ AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(va.class, "_handled");
    private volatile /* synthetic */ int _handled;

    /* renamed from: a  reason: collision with other field name */
    public final Throwable f5381a;

    public va(Throwable cause, boolean handled) {
        this.f5381a = cause;
        this._handled = handled;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ va(Throwable th, boolean z, int i, Cif ifVar) {
        this(th, (i & 2) != 0 ? false : z);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [int, boolean] */
    public final boolean a() {
        return this._handled;
    }

    public final boolean b() {
        return a.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return ef.a(this) + '[' + this.f5381a + ']';
    }
}
