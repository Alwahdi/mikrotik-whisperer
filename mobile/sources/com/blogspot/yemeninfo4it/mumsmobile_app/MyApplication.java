package com.blogspot.yemeninfo4it.mumsmobile_app;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.Log;
import androidx.multidex.MultiDex;
import defpackage.w7;
import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import java.util.Date;

public class MyApplication extends Application {
    private static MyApplication a;

    public void onCreate() {
        super.onCreate();
        a = this;
        b();
        c();
        a();
        w7.a.c().b(1).d(2000).a();
    }

    private void b() {
        iv0.e(iv0.c().a(new CalligraphyInterceptor(new CalligraphyConfig.Builder().setDefaultFontPath("fonts/HacenCasablanca.ttf").setFontAttrId(R.attr.fontPath).build())).b());
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    private void a() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel channel1 = new NotificationChannel("channel1", "Channel 1", 4);
            channel1.setDescription("This is Channel 1");
            NotificationChannel channel2 = new NotificationChannel("channel2", "Channel 2", 2);
            channel2.setDescription("This is Channel 2");
            NotificationManager manager = (NotificationManager) getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
        }
    }

    public void onLowMemory() {
        super.onLowMemory();
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    private void c() {
        bh bhVar = (bh) rs0.q().x(31428).z(100).A(this).y(true).u("time.google.com").g(gj0.a()).e(e3.a()).h(new a());
    }

    class a extends bh<Date> {
        a() {
        }

        /* renamed from: c */
        public void e(Date date) {
            Log.d("TAG", "Success initialized TrueTime :" + date.toString());
        }

        public void onError(Throwable e) {
            Log.e("TAG", "something went wrong when trying to initializeRx TrueTime", e);
        }
    }
}
