package androidx.appcompat.app;

import androidx.appcompat.app.AppLocalesStorageHelper;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ AppLocalesStorageHelper.SerialExecutor a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Runnable f90a;

    public /* synthetic */ c(AppLocalesStorageHelper.SerialExecutor serialExecutor, Runnable runnable) {
        this.a = serialExecutor;
        this.f90a = runnable;
    }

    public final void run() {
        this.a.lambda$execute$0(this.f90a);
    }
}
