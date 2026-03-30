package defpackage;

import com.google.android.gms.common.api.internal.LifecycleCallback;

/* renamed from: h41  reason: default package */
final class h41 implements Runnable {
    private final /* synthetic */ LifecycleCallback a;

    /* renamed from: a  reason: collision with other field name */
    private final /* synthetic */ String f3137a;

    /* renamed from: a  reason: collision with other field name */
    private final /* synthetic */ x21 f3138a;

    h41(x21 x21, LifecycleCallback lifecycleCallback, String str) {
        this.f3138a = x21;
        this.a = lifecycleCallback;
        this.f3137a = str;
    }

    public final void run() {
        if (this.f3138a.f5564a > 0) {
            this.a.e(this.f3138a.f5565a != null ? this.f3138a.f5565a.getBundle(this.f3137a) : null);
        }
        if (this.f3138a.f5564a >= 2) {
            this.a.i();
        }
        if (this.f3138a.f5564a >= 3) {
            this.a.g();
        }
        if (this.f3138a.f5564a >= 4) {
            this.a.j();
        }
        if (this.f3138a.f5564a >= 5) {
            this.a.f();
        }
    }
}
