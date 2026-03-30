package com.google.firebase.messaging;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class c {
    private static final AtomicInteger a = new AtomicInteger((int) SystemClock.elapsedRealtime());

    static b d(Context context, j jVar) {
        Uri uri;
        Intent intent;
        PendingIntent pendingIntent;
        PendingIntent pendingIntent2;
        Bundle c = c(context.getPackageManager(), context.getPackageName());
        String packageName = context.getPackageName();
        String h = h(context, jVar.c("gcm.n.android_channel_id"), c);
        Resources resources = context.getResources();
        PackageManager packageManager = context.getPackageManager();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, h);
        builder.setContentTitle(e(packageName, jVar, packageManager, resources));
        String b = jVar.b(resources, packageName, "gcm.n.body");
        if (!TextUtils.isEmpty(b)) {
            builder.setContentText(b);
            builder.setStyle(new NotificationCompat.BigTextStyle().bigText(b));
        }
        builder.setSmallIcon(a(packageManager, resources, packageName, jVar.c("gcm.n.icon"), c));
        String e = jVar.e();
        Integer num = null;
        if (TextUtils.isEmpty(e)) {
            uri = null;
        } else if ("default".equals(e) || resources.getIdentifier(e, "raw", packageName) == 0) {
            uri = RingtoneManager.getDefaultUri(2);
        } else {
            StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 24 + String.valueOf(e).length());
            sb.append("android.resource://");
            sb.append(packageName);
            sb.append("/raw/");
            sb.append(e);
            uri = Uri.parse(sb.toString());
        }
        if (uri != null) {
            builder.setSound(uri);
        }
        String c2 = jVar.c("gcm.n.click_action");
        if (!TextUtils.isEmpty(c2)) {
            intent = new Intent(c2);
            intent.setPackage(packageName);
            intent.setFlags(268435456);
        } else {
            Uri a2 = jVar.a();
            if (a2 != null) {
                intent = new Intent("android.intent.action.VIEW");
                intent.setPackage(packageName);
                intent.setData(a2);
            } else {
                Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(packageName);
                if (launchIntentForPackage == null) {
                    Log.w("FirebaseMessaging", "No activity found to launch app");
                }
                intent = launchIntentForPackage;
            }
        }
        if (intent == null) {
            pendingIntent = null;
        } else {
            intent.addFlags(67108864);
            intent.putExtras(jVar.l());
            pendingIntent = PendingIntent.getActivity(context, a.incrementAndGet(), intent, BasicMeasure.EXACTLY);
            if (jVar.g("google.c.a.e")) {
                pendingIntent = b(context, new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN").putExtras(jVar.n()).putExtra("pending_intent", pendingIntent));
            }
        }
        builder.setContentIntent(pendingIntent);
        if (!jVar.g("google.c.a.e")) {
            pendingIntent2 = null;
        } else {
            pendingIntent2 = b(context, new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(jVar.n()));
        }
        if (pendingIntent2 != null) {
            builder.setDeleteIntent(pendingIntent2);
        }
        Integer f = f(context, jVar.c("gcm.n.color"), c);
        if (f != null) {
            builder.setColor(f.intValue());
        }
        int i = 1;
        builder.setAutoCancel(!jVar.g("gcm.n.sticky"));
        builder.setLocalOnly(jVar.g("gcm.n.local_only"));
        String c3 = jVar.c("gcm.n.ticker");
        if (c3 != null) {
            builder.setTicker(c3);
        }
        Integer h2 = jVar.h("gcm.n.notification_priority");
        if (h2 == null) {
            h2 = null;
        } else if (h2.intValue() < -2 || h2.intValue() > 2) {
            String valueOf = String.valueOf(h2);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 72);
            sb2.append("notificationPriority is invalid ");
            sb2.append(valueOf);
            sb2.append(". Skipping setting notificationPriority.");
            Log.w("FirebaseMessaging", sb2.toString());
            h2 = null;
        }
        if (h2 != null) {
            builder.setPriority(h2.intValue());
        }
        Integer h3 = jVar.h("gcm.n.visibility");
        if (h3 == null) {
            h3 = null;
        } else if (h3.intValue() < -1 || h3.intValue() > 1) {
            String valueOf2 = String.valueOf(h3);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 53);
            sb3.append("visibility is invalid: ");
            sb3.append(valueOf2);
            sb3.append(". Skipping setting visibility.");
            Log.w("NotificationParams", sb3.toString());
            h3 = null;
        }
        if (h3 != null) {
            builder.setVisibility(h3.intValue());
        }
        Integer h4 = jVar.h("gcm.n.notification_count");
        if (h4 != null) {
            if (h4.intValue() < 0) {
                String valueOf3 = String.valueOf(h4);
                StringBuilder sb4 = new StringBuilder(String.valueOf(valueOf3).length() + 67);
                sb4.append("notificationCount is invalid: ");
                sb4.append(valueOf3);
                sb4.append(". Skipping setting notificationCount.");
                Log.w("FirebaseMessaging", sb4.toString());
            } else {
                num = h4;
            }
        }
        if (num != null) {
            builder.setNumber(num.intValue());
        }
        Long j = jVar.j("gcm.n.event_time");
        if (j != null) {
            builder.setShowWhen(true);
            builder.setWhen(j.longValue());
        }
        long[] i2 = jVar.i();
        if (i2 != null) {
            builder.setVibrate(i2);
        }
        int[] k = jVar.k();
        if (k != null) {
            builder.setLights(k[0], k[1], k[2]);
        }
        if (!jVar.g("gcm.n.default_sound")) {
            i = 0;
        }
        if (jVar.g("gcm.n.default_vibrate_timings")) {
            i |= 2;
        }
        if (jVar.g("gcm.n.default_light_settings")) {
            i |= 4;
        }
        builder.setDefaults(i);
        String c4 = jVar.c("gcm.n.tag");
        if (TextUtils.isEmpty(c4)) {
            long uptimeMillis = SystemClock.uptimeMillis();
            StringBuilder sb5 = new StringBuilder(37);
            sb5.append("FCM-Notification:");
            sb5.append(uptimeMillis);
            c4 = sb5.toString();
        }
        return new b(builder, c4, 0);
    }

    private static CharSequence e(String str, j jVar, PackageManager packageManager, Resources resources) {
        String b = jVar.b(resources, str, "gcm.n.title");
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        try {
            return packageManager.getApplicationInfo(str, 0).loadLabel(packageManager);
        } catch (PackageManager.NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 35);
            sb.append("Couldn't get own application info: ");
            sb.append(valueOf);
            Log.e("FirebaseMessaging", sb.toString());
            return "";
        }
    }

    private static boolean g(Resources resources, int i) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!(resources.getDrawable(i, (Resources.Theme) null) instanceof AdaptiveIconDrawable)) {
                return true;
            }
            StringBuilder sb = new StringBuilder(77);
            sb.append("Adaptive icons cannot be used in notifications. Ignoring icon id: ");
            sb.append(i);
            Log.e("FirebaseMessaging", sb.toString());
            return false;
        } catch (Resources.NotFoundException e) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Couldn't find resource ");
            sb2.append(i);
            sb2.append(", treating it as an invalid icon");
            Log.e("FirebaseMessaging", sb2.toString());
            return false;
        }
    }

    private static int a(PackageManager packageManager, Resources resources, String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str2)) {
            int identifier = resources.getIdentifier(str2, "drawable", str);
            if (identifier != 0 && g(resources, identifier)) {
                return identifier;
            }
            int identifier2 = resources.getIdentifier(str2, "mipmap", str);
            if (identifier2 != 0 && g(resources, identifier2)) {
                return identifier2;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 61);
            sb.append("Icon resource ");
            sb.append(str2);
            sb.append(" not found. Notification will use default icon.");
            Log.w("FirebaseMessaging", sb.toString());
        }
        int i = bundle.getInt("com.google.firebase.messaging.default_notification_icon", 0);
        if (i == 0 || !g(resources, i)) {
            try {
                i = packageManager.getApplicationInfo(str, 0).icon;
            } catch (PackageManager.NameNotFoundException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 35);
                sb2.append("Couldn't get own application info: ");
                sb2.append(valueOf);
                Log.w("FirebaseMessaging", sb2.toString());
            }
        }
        if (i == 0 || !g(resources, i)) {
            return 17301651;
        }
        return i;
    }

    private static Integer f(Context context, String str, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException e) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 56);
                sb.append("Color is invalid: ");
                sb.append(str);
                sb.append(". Notification will use default color.");
                Log.w("FirebaseMessaging", sb.toString());
            }
        }
        int i = bundle.getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i != 0) {
            try {
                return Integer.valueOf(ContextCompat.getColor(context, i));
            } catch (Resources.NotFoundException e2) {
                Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
            }
        }
        return null;
    }

    private static Bundle c(PackageManager packageManager, String str) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (!(applicationInfo == null || (bundle = applicationInfo.metaData) == null)) {
                return bundle;
            }
        } catch (PackageManager.NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 35);
            sb.append("Couldn't get own application info: ");
            sb.append(valueOf);
            Log.w("FirebaseMessaging", sb.toString());
        }
        return Bundle.EMPTY;
    }

    private static String h(Context context, String str, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            if (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion < 26) {
                return null;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (!TextUtils.isEmpty(str)) {
                if (notificationManager.getNotificationChannel(str) != null) {
                    return str;
                }
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 122);
                sb.append("Notification Channel requested (");
                sb.append(str);
                sb.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
                Log.w("FirebaseMessaging", sb.toString());
            }
            String string = bundle.getString("com.google.firebase.messaging.default_notification_channel_id");
            if (TextUtils.isEmpty(string)) {
                Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
            } else if (notificationManager.getNotificationChannel(string) != null) {
                return string;
            } else {
                Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
            }
            if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                notificationManager.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", context.getString(context.getResources().getIdentifier("fcm_fallback_notification_channel_label", "string", context.getPackageName())), 3));
            }
            return "fcm_fallback_notification_channel";
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    private static PendingIntent b(Context context, Intent intent) {
        return PendingIntent.getBroadcast(context, a.incrementAndGet(), new Intent("com.google.firebase.MESSAGING_EVENT").setComponent(new ComponentName(context, "com.google.firebase.iid.FirebaseInstanceIdReceiver")).putExtra("wrapped_intent", intent), BasicMeasure.EXACTLY);
    }
}
