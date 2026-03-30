package defpackage;

import androidx.profileinstaller.ProfileInstaller;

/* renamed from: ya0  reason: default package */
public final /* synthetic */ class ya0 implements Runnable {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ProfileInstaller.DiagnosticsCallback f5871a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f5872a;

    public /* synthetic */ ya0(ProfileInstaller.DiagnosticsCallback diagnosticsCallback, int i, Object obj) {
        this.f5871a = diagnosticsCallback;
        this.a = i;
        this.f5872a = obj;
    }

    public final void run() {
        this.f5871a.onResultReceived(this.a, this.f5872a);
    }
}
