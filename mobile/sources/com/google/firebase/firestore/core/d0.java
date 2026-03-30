package com.google.firebase.firestore.core;

import java.util.Comparator;

final /* synthetic */ class d0 implements Comparator {
    private final e0 a;

    private d0(e0 e0Var) {
        this.a = e0Var;
    }

    public static Comparator a(e0 e0Var) {
        return new d0(e0Var);
    }

    public int compare(Object obj, Object obj2) {
        return e0.k(this.a, (d) obj, (d) obj2);
    }
}
