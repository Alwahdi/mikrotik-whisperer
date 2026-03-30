package com.google.firebase.messaging;

import com.google.android.datatransport.cct.a;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingRegistrar;

final /* synthetic */ class f implements kb {
    static final kb a = new f();

    private f() {
    }

    public final Object a(hb hbVar) {
        gl glVar = (gl) hbVar.d(gl.class);
        FirebaseInstanceId firebaseInstanceId = (FirebaseInstanceId) hbVar.d(FirebaseInstanceId.class);
        fs0 fs0 = (fs0) hbVar.d(fs0.class);
        if (fs0 == null || !a.b.b().contains(qi.b("json"))) {
            fs0 = new FirebaseMessagingRegistrar.a();
        }
        return new FirebaseMessaging(glVar, firebaseInstanceId, fs0);
    }
}
