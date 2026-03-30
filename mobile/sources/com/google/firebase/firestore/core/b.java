package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.h;

public class b extends g {
    b(pk field, rk value) {
        super(field, h.a.ARRAY_CONTAINS, value);
    }

    public boolean b(com.google.firebase.firestore.model.b doc) {
        rk other = doc.e(d());
        return (other instanceof g4) && ((g4) other).g().contains(f());
    }
}
