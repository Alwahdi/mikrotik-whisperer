package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;

final class s implements Runnable {
    private final /* synthetic */ FirebaseAuth a;

    s(FirebaseAuth firebaseAuth) {
        this.a = firebaseAuth;
    }

    public final void run() {
        for (FirebaseAuth.a a2 : this.a.c) {
            a2.a(this.a);
        }
    }
}
