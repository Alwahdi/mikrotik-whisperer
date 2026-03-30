package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import androidx.legacy.content.WakefulBroadcastReceiver;
import org.apache.http.HttpStatus;

public final class FirebaseInstanceIdReceiver extends WakefulBroadcastReceiver {
    private static q a;

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
            Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
            if (intent2 != null) {
                c(context, intent2);
            } else {
                c(context, intent);
            }
        }
    }

    private final void c(Context context, Intent intent) {
        int i;
        intent.setComponent((ComponentName) null);
        intent.setPackage(context.getPackageName());
        if (Build.VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        if ("google.com/iid".equals(intent.getStringExtra("from"))) {
            String stringExtra = intent.getStringExtra("CMD");
            if (stringExtra != null) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(intent.getExtras());
                    StringBuilder sb = new StringBuilder(String.valueOf(stringExtra).length() + 21 + String.valueOf(valueOf).length());
                    sb.append("Received command: ");
                    sb.append(stringExtra);
                    sb.append(" - ");
                    sb.append(valueOf);
                    Log.d("FirebaseInstanceId", sb.toString());
                }
                if ("RST".equals(stringExtra) || "RST_FULL".equals(stringExtra)) {
                    FirebaseInstanceId.b().x();
                } else if ("SYNC".equals(stringExtra)) {
                    FirebaseInstanceId.b().z();
                }
            }
            i = -1;
        } else {
            String stringExtra2 = intent.getStringExtra("gcm.rawData64");
            if (stringExtra2 != null) {
                intent.putExtra("rawData", Base64.decode(stringExtra2, 0));
                intent.removeExtra("gcm.rawData64");
            }
            i = a(this, context, intent);
        }
        if (isOrderedBroadcast()) {
            setResultCode(i);
        }
    }

    public static int a(BroadcastReceiver broadcastReceiver, Context context, Intent intent) {
        boolean z = true;
        boolean z2 = n90.h() && context.getApplicationInfo().targetSdkVersion >= 26;
        if ((intent.getFlags() & 268435456) == 0) {
            z = false;
        }
        if (z2 && !z) {
            return d(broadcastReceiver, context, intent);
        }
        int a2 = h.b().a(context, intent);
        if (!n90.h() || a2 != 402) {
            return a2;
        }
        d(broadcastReceiver, context, intent);
        return HttpStatus.SC_FORBIDDEN;
    }

    private static int d(BroadcastReceiver broadcastReceiver, Context context, Intent intent) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Binding to service");
        }
        if (broadcastReceiver.isOrderedBroadcast()) {
            broadcastReceiver.setResultCode(-1);
        }
        b(context, "com.google.firebase.MESSAGING_EVENT").b(intent, broadcastReceiver.goAsync());
        return -1;
    }

    private static synchronized q b(Context context, String str) {
        q qVar;
        synchronized (FirebaseInstanceIdReceiver.class) {
            if (a == null) {
                a = new q(context, str);
            }
            qVar = a;
        }
        return qVar;
    }
}
