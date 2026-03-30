package com.blogspot.yemeninfo4it.mumsmobile_app.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.widget.RemoteViews;
import android.widget.Toast;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.MumsHomeActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.Splash_screen;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class MyLocation extends Service {
    public static final String b = (MyLocation.class.getName() + "LocationBroadcast");
    public static String c = "com.blogspot.yemeninfo4it.mumsmobile_app.receiver";
    long a = 11000;

    /* renamed from: a  reason: collision with other field name */
    public NotificationManager f1278a;

    /* renamed from: a  reason: collision with other field name */
    Intent f1279a;

    /* renamed from: a  reason: collision with other field name */
    Handler f1280a = new Handler();

    /* renamed from: a  reason: collision with other field name */
    b f1281a;

    /* renamed from: a  reason: collision with other field name */
    j3 f1282a;

    /* renamed from: a  reason: collision with other field name */
    String f1283a;

    /* renamed from: a  reason: collision with other field name */
    private Timer f1284a = null;

    static {
        System.loadLibrary("native-lib");
    }

    public IBinder onBind(Intent arg0) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        this.f1282a = qb0.d();
        this.f1278a = (NotificationManager) getSystemService("notification");
        Timer timer = new Timer();
        this.f1284a = timer;
        timer.schedule(new c(), 10, this.a);
        this.f1279a = new Intent(c);
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                this.f1278a.createNotificationChannel(new NotificationChannel("channel_01", "عدد المتصلين", 2));
            }
            if (i < 31) {
                startForeground(12345678, c());
            }
        } catch (Exception e) {
        }
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!intent.getBooleanExtra("com.google.android.gms.location.sample.locationupdatesforegroundservice.started_from_notification", false)) {
            return 2;
        }
        stopSelf();
        this.f1284a.cancel();
        return 2;
    }

    public void onTaskRemoved(Intent rootIntent) {
        Toast.makeText(this, "تم ايقاف الخدمة2", 1).show();
        super.onTaskRemoved(rootIntent);
        this.f1280a.removeCallbacksAndMessages((Object) null);
        stopSelf();
    }

    public void onDestroy() {
        try {
            Toast.makeText(this, "تم ايقاف الخدمة", 1).show();
            this.f1280a.removeCallbacksAndMessages((Object) null);
            b bVar = this.f1281a;
            if (bVar != null) {
                bVar.cancel(true);
            }
        } catch (Exception e) {
        }
    }

    /* access modifiers changed from: private */
    public void d(String active_count) {
        if (active_count != null) {
            Intent intent = new Intent(b);
            intent.putExtra("active_count", active_count);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        }
    }

    private class c extends TimerTask {
        private c() {
        }

        class a implements Runnable {
            a() {
            }

            public void run() {
                MyLocation.this.f1281a = new b();
                MyLocation.this.f1281a.execute(new String[0]);
            }
        }

        public void run() {
            MyLocation.this.f1280a.post(new a());
        }
    }

    class b extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        String f1285a = "";

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f1286a = null;

        /* renamed from: a  reason: collision with other field name */
        boolean f1287a = false;

        b() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            this.f1287a = false;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                if (!MyLocation.this.f1282a.w()) {
                    return null;
                }
                this.f1286a = MyLocation.this.f1282a.q(qb0.s.get(0).getAc());
                return null;
            } catch (Exception e) {
                try {
                    this.f1287a = true;
                    this.f1285a = e.getMessage();
                    return null;
                } catch (Exception e2) {
                    this.f1287a = true;
                    this.f1285a = e2.getMessage();
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            try {
                if (!this.f1287a) {
                    List<Map<String, String>> list = this.f1286a;
                    if (list != null) {
                        MyLocation.this.f1283a = (String) list.get(0).get("ret");
                        MyLocation myLocation = MyLocation.this;
                        myLocation.d(myLocation.f1283a);
                        if (Build.VERSION.SDK_INT <= 30) {
                            MyLocation myLocation2 = MyLocation.this;
                            myLocation2.f1278a.notify(12345678, myLocation2.c());
                        }
                    }
                } else if (this.f1285a.toUpperCase().equals("BROKEN PIPE")) {
                    MyLocation.this.d("BROKEN");
                }
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(MyLocation.this.getApplicationContext(), e.getMessage(), 0).show();
            }
        }
    }

    /* access modifiers changed from: private */
    public Notification c() {
        PendingIntent activityPendingIntent;
        Intent intentn = new Intent(this, MyLocation.class);
        CharSequence text = this.f1283a;
        intentn.putExtra("com.google.android.gms.location.sample.locationupdatesforegroundservice.started_from_notification", true);
        PendingIntent servicePendingIntent = PendingIntent.getService(this, 0, intentn, 134217728);
        if (qb0.f4797a != null) {
            qb0.f4813c = true;
            Intent intent = new Intent(this, MumsHomeActivity.class);
            intent.putExtra("l_data", true);
            activityPendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        } else {
            activityPendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, Splash_screen.class), 0);
        }
        RemoteViews contentView = new RemoteViews(getPackageName(), R.layout.my_notification_layout);
        contentView.setImageViewResource(R.id.image, R.mipmap.ic_launcher);
        contentView.setTextViewText(R.id.title, getString(R.string.active_user_count));
        contentView.setTextViewText(R.id.content_txt, text);
        Notification.Builder builder = new Notification.Builder(this).addAction(R.drawable.ic_settings, "فتح التطبيق", activityPendingIntent).addAction(R.drawable.ic_left, "إيقاف الخدمة", servicePendingIntent).setContentText(text).setContentTitle("عدد المستخدمين النشطين").setOngoing(true).setContent(contentView).setPriority(1).setSmallIcon(R.mipmap.ic_launcher).setTicker(text).setWhen(System.currentTimeMillis());
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setChannelId("channel_01");
        }
        return builder.build();
    }
}
