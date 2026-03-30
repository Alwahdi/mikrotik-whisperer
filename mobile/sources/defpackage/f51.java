package defpackage;

import android.content.Intent;

/* renamed from: f51  reason: default package */
final /* synthetic */ class f51 implements Runnable {
    private final Intent a;

    /* renamed from: a  reason: collision with other field name */
    private final f31 f2950a;

    /* renamed from: a  reason: collision with other field name */
    private final gq0 f2951a;

    f51(f31 f31, Intent intent, gq0 gq0) {
        this.f2950a = f31;
        this.a = intent;
        this.f2951a = gq0;
    }

    public final void run() {
        f31 f31 = this.f2950a;
        Intent intent = this.a;
        gq0 gq0 = this.f2951a;
        try {
            f31.d(intent);
        } finally {
            gq0.c(null);
        }
    }
}
