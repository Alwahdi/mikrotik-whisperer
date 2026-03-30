package com.google.firebase.firestore;

import com.google.firebase.firestore.core.x;

public class a extends m {
    a(me0 path, h firestore) {
        super(x.b(path), firestore);
        if (path.n() % 2 != 1) {
            throw new IllegalArgumentException("Invalid collection reference. Collection references must have an odd number of segments, but " + path.c() + " has " + path.n());
        }
    }

    public e a(String documentPath) {
        v90.o(documentPath, "Provided document path must not be null.");
        return e.c((me0) this.a.m().a(me0.t(documentPath)), this.f2277a);
    }
}
