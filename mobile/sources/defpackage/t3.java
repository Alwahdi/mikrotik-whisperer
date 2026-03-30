package defpackage;

import android.content.Context;
import androidx.appcompat.app.AppCompatDelegate;

/* renamed from: t3  reason: default package */
public final /* synthetic */ class t3 implements Runnable {
    public final /* synthetic */ Context a;

    public /* synthetic */ t3(Context context) {
        this.a = context;
    }

    public final void run() {
        AppCompatDelegate.syncRequestedAndStoredLocales(this.a);
    }
}
