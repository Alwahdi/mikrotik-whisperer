package com.google.firebase.firestore.remote;

final /* synthetic */ class a implements Runnable {
    private final b a;

    private a(b bVar) {
        this.a = bVar;
    }

    public static Runnable a(b bVar) {
        return new a(bVar);
    }

    public void run() {
        b.l(this.a);
    }
}
