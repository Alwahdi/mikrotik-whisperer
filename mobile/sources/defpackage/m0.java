package defpackage;

import android.app.Activity;
import androidx.core.app.ActivityCompat;

/* renamed from: m0  reason: default package */
public final /* synthetic */ class m0 implements Runnable {
    public final /* synthetic */ Activity a;

    public /* synthetic */ m0(Activity activity) {
        this.a = activity;
    }

    public final void run() {
        ActivityCompat.lambda$recreate$0(this.a);
    }
}
