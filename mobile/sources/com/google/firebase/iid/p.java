package com.google.firebase.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;

public final class p extends Binder {
    private final m11 a;

    public p(m11 m11) {
        this.a = m11;
    }

    /* access modifiers changed from: package-private */
    public final void a(s sVar) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "service received new intent via bind strategy");
            }
            this.a.a(sVar.f2448a).d(a.b(), new o(sVar));
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
