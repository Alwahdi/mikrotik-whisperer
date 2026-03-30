package com.google.android.datatransport.runtime.scheduling.jobscheduling;

final /* synthetic */ class a implements Runnable {
    private static final a a = new a();

    private a() {
    }

    public static Runnable a() {
        return a;
    }

    public void run() {
        AlarmManagerSchedulerBroadcastReceiver.a();
    }
}
