package defpackage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.e;

/* renamed from: g2  reason: default package */
public class g2 implements yv0 {
    private AlarmManager a;

    /* renamed from: a  reason: collision with other field name */
    private final Context f3003a;

    /* renamed from: a  reason: collision with other field name */
    private final c9 f3004a;

    /* renamed from: a  reason: collision with other field name */
    private final e f3005a;

    /* renamed from: a  reason: collision with other field name */
    private final hj f3006a;

    public g2(Context applicationContext, hj eventStore, c9 clock, e config) {
        this(applicationContext, eventStore, (AlarmManager) applicationContext.getSystemService(NotificationCompat.CATEGORY_ALARM), clock, config);
    }

    g2(Context applicationContext, hj eventStore, AlarmManager alarmManager, c9 clock, e config) {
        this.f3003a = applicationContext;
        this.f3006a = eventStore;
        this.a = alarmManager;
        this.f3004a = clock;
        this.f3005a = config;
    }

    /* access modifiers changed from: package-private */
    public boolean b(Intent intent) {
        return PendingIntent.getBroadcast(this.f3003a, 0, intent, 536870912) != null;
    }

    public void a(es0 transportContext, int attemptNumber) {
        Uri.Builder intentDataBuilder = new Uri.Builder();
        intentDataBuilder.appendQueryParameter("backendName", transportContext.b());
        intentDataBuilder.appendQueryParameter("priority", String.valueOf(ta0.a(transportContext.d())));
        if (transportContext.c() != null) {
            intentDataBuilder.appendQueryParameter("extras", Base64.encodeToString(transportContext.c(), 0));
        }
        Intent intent = new Intent(this.f3003a, AlarmManagerSchedulerBroadcastReceiver.class);
        intent.setData(intentDataBuilder.build());
        intent.putExtra("attemptNumber", attemptNumber);
        if (b(intent)) {
            xy.a("AlarmManagerScheduler", "Upload for context %s is already scheduled. Returning...", transportContext);
            return;
        }
        long backendTime = this.f3006a.S(transportContext);
        long scheduleDelay = this.f3005a.f(transportContext.d(), backendTime, attemptNumber);
        xy.b("AlarmManagerScheduler", "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", transportContext, Long.valueOf(scheduleDelay), Long.valueOf(backendTime), Integer.valueOf(attemptNumber));
        this.a.set(3, this.f3004a.a() + scheduleDelay, PendingIntent.getBroadcast(this.f3003a, 0, intent, 0));
    }
}
