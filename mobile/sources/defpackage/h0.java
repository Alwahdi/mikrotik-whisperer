package defpackage;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import defpackage.cr;

/* renamed from: h0  reason: default package */
public abstract class h0 extends cr.a {
    public static Account c(cr crVar) {
        if (crVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return crVar.o();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return null;
    }
}
