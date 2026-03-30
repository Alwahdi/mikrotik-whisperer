package androidx.core.content;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ UnusedAppRestrictionsBackportServiceConnection a;

    public /* synthetic */ a(UnusedAppRestrictionsBackportServiceConnection unusedAppRestrictionsBackportServiceConnection) {
        this.a = unusedAppRestrictionsBackportServiceConnection;
    }

    public final void run() {
        this.a.disconnectFromService();
    }
}
