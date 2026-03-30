package com.google.firebase.firestore.model;

public abstract class c {
    private final hm0 a;

    /* renamed from: a  reason: collision with other field name */
    private final mh f2283a;

    public abstract boolean c();

    c(mh key, hm0 version) {
        this.f2283a = key;
        this.a = version;
    }

    public mh a() {
        return this.f2283a;
    }

    public hm0 b() {
        return this.a;
    }
}
