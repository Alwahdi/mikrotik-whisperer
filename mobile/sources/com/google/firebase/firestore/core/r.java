package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.h;
import com.google.firebase.firestore.model.b;

public class r extends g {
    r(pk field, g4 value) {
        super(field, h.a.IN, value);
    }

    public boolean b(b doc) {
        g4 arrayValue = (g4) f();
        rk other = doc.e(d());
        return other != null && arrayValue.g().contains(other);
    }
}
