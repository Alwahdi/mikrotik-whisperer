package defpackage;

import android.content.Context;
import androidx.profileinstaller.ProfileInstaller;

/* renamed from: ab0  reason: default package */
public final /* synthetic */ class ab0 implements Runnable {
    public final /* synthetic */ Context a;

    public /* synthetic */ ab0(Context context) {
        this.a = context;
    }

    public final void run() {
        ProfileInstaller.writeProfile(this.a);
    }
}
