package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

final class l extends BroadcastReceiver {
    private m a;

    public l(m mVar) {
        this.a = mVar;
    }

    public final void a() {
        if (FirebaseInstanceId.w()) {
            Log.d("FirebaseInstanceId", "Connectivity change received registered");
        }
        this.a.a().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public final void onReceive(Context context, Intent intent) {
        m mVar = this.a;
        if (mVar != null && mVar.b()) {
            if (FirebaseInstanceId.w()) {
                Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
            }
            FirebaseInstanceId.m(this.a, 0);
            this.a.a().unregisterReceiver(this);
            this.a = null;
        }
    }
}
