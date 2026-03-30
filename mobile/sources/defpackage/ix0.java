package defpackage;

import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import com.google.android.gms.common.api.Status;
import defpackage.wp;

/* renamed from: ix0  reason: default package */
public abstract class ix0 {
    private final int a;

    public ix0(int i) {
        this.a = i;
    }

    public abstract void b(Status status);

    public abstract void c(RuntimeException runtimeException);

    public abstract void d(my0 my0, boolean z);

    public abstract void f(wp.a<?> aVar);

    /* access modifiers changed from: private */
    public static Status a(RemoteException remoteException) {
        StringBuilder sb = new StringBuilder();
        if (n90.b() && (remoteException instanceof TransactionTooLargeException)) {
            sb.append("TransactionTooLargeException: ");
        }
        sb.append(remoteException.getLocalizedMessage());
        return new Status(8, sb.toString());
    }
}
