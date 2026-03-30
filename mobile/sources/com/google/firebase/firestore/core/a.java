package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.h;
import com.google.firebase.firestore.model.b;

public class a extends g {
    a(pk field, rk value) {
        super(field, h.a.ARRAY_CONTAINS_ANY, value);
    }

    public boolean b(b doc) {
        g4 arrayValue = (g4) f();
        rk other = doc.e(d());
        if (!(other instanceof g4)) {
            return false;
        }
        for (rk val : ((g4) other).g()) {
            if (arrayValue.g().contains(val)) {
                return true;
            }
        }
        return false;
    }
}
