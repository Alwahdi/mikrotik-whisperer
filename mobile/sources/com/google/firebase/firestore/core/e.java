package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.d;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class e {
    private final TreeMap<mh, d> a = new TreeMap<>();

    public void a(d change) {
        mh key = change.b().a();
        d old = this.a.get(key);
        if (old == null) {
            this.a.put(key, change);
            return;
        }
        d.a oldType = old.c();
        d.a newType = change.c();
        d.a aVar = d.a.ADDED;
        if (newType != aVar && oldType == d.a.METADATA) {
            this.a.put(key, change);
        } else if (newType != d.a.METADATA || oldType == d.a.REMOVED) {
            d.a aVar2 = d.a.MODIFIED;
            if (newType == aVar2 && oldType == aVar2) {
                this.a.put(key, d.a(aVar2, change.b()));
            } else if (newType == aVar2 && oldType == aVar) {
                this.a.put(key, d.a(aVar, change.b()));
            } else {
                d.a aVar3 = d.a.REMOVED;
                if (newType == aVar3 && oldType == aVar) {
                    this.a.remove(key);
                } else if (newType == aVar3 && oldType == aVar2) {
                    this.a.put(key, d.a(aVar3, old.b()));
                } else if (newType == aVar && oldType == aVar3) {
                    this.a.put(key, d.a(aVar2, change.b()));
                } else {
                    throw n4.a("Unsupported combination of changes %s after %s", newType, oldType);
                }
            }
        } else {
            this.a.put(key, d.a(oldType, change.b()));
        }
    }

    /* access modifiers changed from: package-private */
    public List<d> b() {
        return new ArrayList(this.a.values());
    }
}
