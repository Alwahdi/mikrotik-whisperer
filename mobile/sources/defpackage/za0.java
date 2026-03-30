package defpackage;

import android.content.Context;
import androidx.profileinstaller.ProfileInstallerInitializer;

/* renamed from: za0  reason: default package */
public final /* synthetic */ class za0 implements Runnable {
    public final /* synthetic */ Context a;

    public /* synthetic */ za0(Context context) {
        this.a = context;
    }

    public final void run() {
        ProfileInstallerInitializer.writeInBackground(this.a);
    }
}
