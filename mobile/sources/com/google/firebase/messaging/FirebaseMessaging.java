package com.google.firebase.messaging;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.regex.Pattern;

public class FirebaseMessaging {
    public static final /* synthetic */ int a = 0;

    /* renamed from: a  reason: collision with other field name */
    static fs0 f2454a;

    /* renamed from: a  reason: collision with other field name */
    private static final Pattern f2455a = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* renamed from: a  reason: collision with other field name */
    private final Context f2456a;

    /* renamed from: a  reason: collision with other field name */
    private final FirebaseInstanceId f2457a;

    @NonNull
    @Keep
    static synchronized FirebaseMessaging getInstance(@NonNull gl glVar) {
        FirebaseMessaging firebaseMessaging;
        Class cls = FirebaseMessaging.class;
        synchronized (cls) {
            firebaseMessaging = (FirebaseMessaging) glVar.g(cls);
        }
        return firebaseMessaging;
    }

    FirebaseMessaging(gl glVar, FirebaseInstanceId firebaseInstanceId, fs0 fs0) {
        this.f2456a = glVar.i();
        f2454a = fs0;
        this.f2457a = firebaseInstanceId;
    }
}
