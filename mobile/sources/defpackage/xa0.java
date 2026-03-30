package defpackage;

import androidx.profileinstaller.ProfileInstaller;

/* renamed from: xa0  reason: default package */
public final /* synthetic */ class xa0 implements Runnable {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ProfileInstaller.DiagnosticsCallback f5580a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f5581a;

    public /* synthetic */ xa0(ProfileInstaller.DiagnosticsCallback diagnosticsCallback, int i, Object obj) {
        this.f5580a = diagnosticsCallback;
        this.a = i;
        this.f5581a = obj;
    }

    public final void run() {
        this.f5580a.onDiagnosticReceived(this.a, this.f5581a);
    }
}
