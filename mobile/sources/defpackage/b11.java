package defpackage;

import com.google.android.gms.common.api.internal.LifecycleCallback;

/* renamed from: b11  reason: default package */
final class b11 implements Runnable {
    private final /* synthetic */ LifecycleCallback a;

    /* renamed from: a  reason: collision with other field name */
    private final /* synthetic */ String f136a;

    /* renamed from: a  reason: collision with other field name */
    private final /* synthetic */ oy0 f137a;

    b11(oy0 oy0, LifecycleCallback lifecycleCallback, String str) {
        this.f137a = oy0;
        this.a = lifecycleCallback;
        this.f136a = str;
    }

    public final void run() {
        if (this.f137a.f4612a > 0) {
            this.a.e(this.f137a.f4613a != null ? this.f137a.f4613a.getBundle(this.f136a) : null);
        }
        if (this.f137a.f4612a >= 2) {
            this.a.i();
        }
        if (this.f137a.f4612a >= 3) {
            this.a.g();
        }
        if (this.f137a.f4612a >= 4) {
            this.a.j();
        }
        if (this.f137a.f4612a >= 5) {
            this.a.f();
        }
    }
}
