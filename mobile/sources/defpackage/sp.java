package defpackage;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.api.GoogleApiActivity;

/* renamed from: sp  reason: default package */
public class sp extends up {
    private static final Object a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static final sp f5010a = new sp();
    public static final int b = up.a;

    /* renamed from: a  reason: collision with other field name */
    private String f5011a;

    public static sp m() {
        return f5010a;
    }

    /* renamed from: sp$a */
    private class a extends ly0 {
        private final Context a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.a = context.getApplicationContext();
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            switch (i) {
                case 1:
                    int f = sp.this.f(this.a);
                    if (sp.this.h(f)) {
                        sp.this.o(this.a, f);
                        return;
                    }
                    return;
                default:
                    StringBuilder sb = new StringBuilder(50);
                    sb.append("Don't know how to handle this message: ");
                    sb.append(i);
                    Log.w("GoogleApiAvailability", sb.toString());
                    return;
            }
        }
    }

    public Dialog k(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return p(activity, i, lg.a(activity, a(activity, i, "d"), i2), onCancelListener);
    }

    public boolean n(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog k = k(activity, i, i2, onCancelListener);
        if (k == null) {
            return false;
        }
        q(activity, k, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void o(Context context, int i) {
        s(context, i, (String) null, c(context, i, 0, "n"));
    }

    public final boolean t(Context context, dc dcVar, int i) {
        PendingIntent l = l(context, dcVar);
        if (l == null) {
            return false;
        }
        s(context, dcVar.m(), (String) null, GoogleApiActivity.a(context, l, i));
        return true;
    }

    private final String u() {
        String str;
        synchronized (a) {
            str = this.f5011a;
        }
        return str;
    }

    public int f(Context context) {
        return super.f(context);
    }

    public int g(Context context, int i) {
        return super.g(context, i);
    }

    public final boolean h(int i) {
        return super.h(i);
    }

    public Intent a(Context context, int i, String str) {
        return super.a(context, i, str);
    }

    public PendingIntent b(Context context, int i, int i2) {
        return super.b(context, i, i2);
    }

    public PendingIntent l(Context context, dc dcVar) {
        if (dcVar.s()) {
            return dcVar.r();
        }
        return b(context, dcVar.m(), 0);
    }

    public final String d(int i) {
        return super.d(i);
    }

    static Dialog p(Context context, int i, lg lgVar, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = null;
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(context, 5);
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(cc.d(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String c = cc.c(context, i);
        if (c != null) {
            builder.setPositiveButton(c, lgVar);
        }
        String g = cc.g(context, i);
        if (g != null) {
            builder.setTitle(g);
        }
        return builder.create();
    }

    static void q(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        if (activity instanceof FragmentActivity) {
            ro0.i(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
            return;
        }
        ui.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    private final void s(Context context, int i, String str, PendingIntent pendingIntent) {
        int i2;
        if (i == 18) {
            r(context);
        } else if (pendingIntent != null) {
            String f = cc.f(context, i);
            String e = cc.e(context, i);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            NotificationCompat.Builder style = new NotificationCompat.Builder(context).setLocalOnly(true).setAutoCancel(true).setContentTitle(f).setStyle(new NotificationCompat.BigTextStyle().bigText(e));
            if (jg.b(context)) {
                y90.l(n90.e());
                style.setSmallIcon(context.getApplicationInfo().icon).setPriority(2);
                if (jg.c(context)) {
                    style.addAction(fc0.common_full_open_on_phone, resources.getString(qc0.common_open_on_phone), pendingIntent);
                } else {
                    style.setContentIntent(pendingIntent);
                }
            } else {
                style.setSmallIcon(17301642).setTicker(resources.getString(qc0.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).setContentText(e);
            }
            if (n90.h()) {
                y90.l(n90.h());
                String u = u();
                if (u == null) {
                    u = "com.google.android.gms.availability";
                    NotificationChannel notificationChannel = notificationManager.getNotificationChannel(u);
                    String b2 = cc.b(context);
                    if (notificationChannel == null) {
                        notificationManager.createNotificationChannel(new NotificationChannel(u, b2, 4));
                    } else if (!b2.contentEquals(notificationChannel.getName())) {
                        notificationChannel.setName(b2);
                        notificationManager.createNotificationChannel(notificationChannel);
                    }
                }
                style.setChannelId(u);
            }
            Notification build = style.build();
            switch (i) {
                case 1:
                case 2:
                case 3:
                    i2 = 10436;
                    aq.f116a.set(false);
                    break;
                default:
                    i2 = 39789;
                    break;
            }
            notificationManager.notify(i2, build);
        } else if (i == 6) {
            Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void r(Context context) {
        new a(context).sendEmptyMessageDelayed(1, 120000);
    }
}
