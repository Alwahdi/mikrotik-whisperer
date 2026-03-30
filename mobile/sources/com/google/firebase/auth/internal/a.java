package com.google.firebase.auth.internal;

final class a implements Runnable {
    private final /* synthetic */ FederatedSignInActivity a;

    a(FederatedSignInActivity federatedSignInActivity) {
        this.a = federatedSignInActivity;
    }

    public final void run() {
        this.a.k();
        Runnable unused = FederatedSignInActivity.f2159a = null;
    }
}
