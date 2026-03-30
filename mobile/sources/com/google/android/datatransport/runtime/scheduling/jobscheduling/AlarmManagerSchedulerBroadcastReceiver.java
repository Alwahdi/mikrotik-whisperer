package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import defpackage.es0;

public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String backendName = intent.getData().getQueryParameter("backendName");
        String extras = intent.getData().getQueryParameter("extras");
        int priority = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int attemptNumber = intent.getExtras().getInt("attemptNumber");
        ls0.f(context);
        es0.a transportContext = es0.a().b(backendName).d(ta0.b(priority));
        if (extras != null) {
            transportContext.c(Base64.decode(extras, 0));
        }
        ls0.c().e().g(transportContext.a(), attemptNumber, a.a());
    }

    static /* synthetic */ void a() {
    }
}
