package com.google.firebase.iid;

import com.google.firebase.iid.FirebaseInstanceId;

final /* synthetic */ class b0 implements zi {
    private final FirebaseInstanceId.a a;

    b0(FirebaseInstanceId.a aVar) {
        this.a = aVar;
    }

    public final void a(vi viVar) {
        FirebaseInstanceId.a aVar = this.a;
        synchronized (aVar) {
            if (aVar.a()) {
                FirebaseInstanceId.this.B();
            }
        }
    }
}
