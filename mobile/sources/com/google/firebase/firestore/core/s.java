package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.h;
import com.google.firebase.firestore.model.b;

public class s extends g {
    s(pk field, h.a operator, wd0 value) {
        super(field, operator, value);
    }

    public boolean b(b doc) {
        return h(doc.a().compareTo(((wd0) f()).d()));
    }
}
