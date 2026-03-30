package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.content.SharedPreferences;

class d {
    private static d a = null;

    /* renamed from: a  reason: collision with other field name */
    private final SharedPreferences f2397a;

    private d(Context applicationContext) {
        this.f2397a = applicationContext.getSharedPreferences("FirebaseAppHeartBeat", 0);
    }

    static synchronized d a(Context applicationContext) {
        d dVar;
        synchronized (d.class) {
            if (a == null) {
                a = new d(applicationContext);
            }
            dVar = a;
        }
        return dVar;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean c(String heartBeatTag, long millis) {
        if (!this.f2397a.contains(heartBeatTag)) {
            this.f2397a.edit().putLong(heartBeatTag, millis).apply();
            return true;
        } else if (millis - this.f2397a.getLong(heartBeatTag, -1) < 86400000) {
            return false;
        } else {
            this.f2397a.edit().putLong(heartBeatTag, millis).apply();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean b(long millis) {
        return c("fire-global", millis);
    }
}
