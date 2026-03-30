package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;

final class r implements ny0, jz0 {
    private final /* synthetic */ FirebaseAuth a;

    r(FirebaseAuth firebaseAuth) {
        this.a = firebaseAuth;
    }

    public final void a(s61 s61, dm dmVar) {
        this.a.m(dmVar, s61, true, true);
    }

    public final void d(Status status) {
        int m = status.m();
        if (m == 17011 || m == 17021 || m == 17005) {
            this.a.h();
        }
    }
}
