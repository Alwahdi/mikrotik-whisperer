package com.blogspot.yemeninfo4it.mumsmobile_app.fcm;

import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;

public class MyFirebaseInstanceIDService extends FirebaseMessagingService {
    public void k(String s) {
        super.k(s);
        Log.e("NEW_TOKEN", s);
    }

    public void i(fe0 remoteMessage) {
        super.i(remoteMessage);
    }
}
