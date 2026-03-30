package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;

final class q implements Runnable {
    private final /* synthetic */ FirebaseAuth a;

    /* renamed from: a  reason: collision with other field name */
    private final /* synthetic */ ju f2162a;

    q(FirebaseAuth firebaseAuth, ju juVar) {
        this.a = firebaseAuth;
        this.f2162a = juVar;
    }

    public final void run() {
        for (qr a2 : this.a.f2154b) {
            a2.a(this.f2162a);
        }
        for (FirebaseAuth.b a3 : this.a.f2147a) {
            a3.a(this.a);
        }
    }
}
