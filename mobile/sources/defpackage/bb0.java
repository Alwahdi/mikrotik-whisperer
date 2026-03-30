package defpackage;

import android.content.Context;
import androidx.profileinstaller.ProfileInstallerInitializer;

/* renamed from: bb0  reason: default package */
public final /* synthetic */ class bb0 implements Runnable {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ProfileInstallerInitializer f217a;

    public /* synthetic */ bb0(ProfileInstallerInitializer profileInstallerInitializer, Context context) {
        this.f217a = profileInstallerInitializer;
        this.a = context;
    }

    public final void run() {
        this.f217a.lambda$delayAfterFirstFrame$0(this.a);
    }
}
