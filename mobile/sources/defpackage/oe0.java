package defpackage;

import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;

/* renamed from: oe0  reason: default package */
public final /* synthetic */ class oe0 implements Runnable {
    public final /* synthetic */ Typeface a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ResourcesCompat.FontCallback f4529a;

    public /* synthetic */ oe0(ResourcesCompat.FontCallback fontCallback, Typeface typeface) {
        this.f4529a = fontCallback;
        this.a = typeface;
    }

    public final void run() {
        this.f4529a.lambda$callbackSuccessAsync$0(this.a);
    }
}
