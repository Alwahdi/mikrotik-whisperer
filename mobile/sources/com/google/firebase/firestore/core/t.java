package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.h;
import com.google.firebase.firestore.model.b;
import java.util.Iterator;

public class t extends g {
    t(pk field, g4 value) {
        super(field, h.a.IN, value);
        for (rk refValue : ((g4) f()).g()) {
            n4.d(refValue instanceof wd0, "Comparing on key with IN, but an array value was not a ReferenceValue", new Object[0]);
        }
    }

    public boolean b(b doc) {
        Iterator<rk> it = ((g4) f()).g().iterator();
        while (it.hasNext()) {
            if (doc.a().equals(((wd0) it.next()).d())) {
                return true;
            }
        }
        return false;
    }
}
