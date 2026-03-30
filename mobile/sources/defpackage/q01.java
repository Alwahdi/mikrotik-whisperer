package defpackage;

import android.app.Application;
import android.content.Context;

/* renamed from: q01  reason: default package */
public final class q01 {
    private volatile int a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final yy0 f4743a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f4744a;

    public q01(gl glVar) {
        this(glVar.i(), new yy0(glVar));
    }

    private q01(Context context, yy0 yy0) {
        this.f4744a = false;
        this.a = 0;
        this.f4743a = yy0;
        j5.c((Application) context.getApplicationContext());
        j5.b().a(new x01(this));
    }

    public final void b(int i) {
        if (i > 0 && this.a == 0) {
            this.a = i;
            if (g()) {
                this.f4743a.a();
            }
        } else if (i == 0 && this.a != 0) {
            this.f4743a.c();
        }
        this.a = i;
    }

    public final void c(s61 s61) {
        if (s61 != null) {
            long u = s61.u();
            if (u <= 0) {
                u = 3600;
            }
            yy0 yy0 = this.f4743a;
            yy0.f5960a = s61.v() + (u * 1000);
            yy0.b = -1;
            if (g()) {
                this.f4743a.a();
            }
        }
    }

    public final void a() {
        this.f4743a.c();
    }

    /* access modifiers changed from: private */
    public final boolean g() {
        return this.a > 0 && !this.f4744a;
    }
}
