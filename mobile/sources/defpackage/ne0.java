package defpackage;

import androidx.core.content.res.ResourcesCompat;

/* renamed from: ne0  reason: default package */
public final /* synthetic */ class ne0 implements Runnable {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ResourcesCompat.FontCallback f4430a;

    public /* synthetic */ ne0(ResourcesCompat.FontCallback fontCallback, int i) {
        this.f4430a = fontCallback;
        this.a = i;
    }

    public final void run() {
        this.f4430a.lambda$callbackFailAsync$1(this.a);
    }
}
