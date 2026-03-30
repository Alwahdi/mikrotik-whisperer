package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Intent;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class s {
    private final BroadcastReceiver.PendingResult a;

    /* renamed from: a  reason: collision with other field name */
    final Intent f2448a;

    /* renamed from: a  reason: collision with other field name */
    private final ScheduledFuture<?> f2449a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f2450a = false;

    s(Intent intent, BroadcastReceiver.PendingResult pendingResult, ScheduledExecutorService scheduledExecutorService) {
        this.f2448a = intent;
        this.a = pendingResult;
        this.f2449a = scheduledExecutorService.schedule(new r(this, intent), 9000, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a() {
        if (!this.f2450a) {
            this.a.finish();
            this.f2449a.cancel(false);
            this.f2450a = true;
        }
    }
}
