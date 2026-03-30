package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;
import com.google.firebase.iid.h;
import java.util.ArrayDeque;
import java.util.Queue;

public class FirebaseMessagingService extends f31 {
    private static final Queue<String> a = new ArrayDeque(10);

    public void i(fe0 fe0) {
    }

    public void h() {
    }

    public void j(String str) {
    }

    public void l(String str, Exception exc) {
    }

    public void k(String str) {
    }

    /* access modifiers changed from: protected */
    public final Intent a(Intent intent) {
        return h.b().e();
    }

    public final boolean c(Intent intent) {
        if (!"com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            return false;
        }
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException e) {
                Log.e("FirebaseMessaging", "Notification pending intent canceled");
            }
        }
        if (!c91.j(intent)) {
            return true;
        }
        c91.a(intent);
        return true;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e0, code lost:
        if (r1.equals("send_event") != false) goto L_0x0100;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(android.content.Intent r13) {
        /*
            r12 = this;
            java.lang.String r0 = r13.getAction()
            java.lang.String r1 = "com.google.android.c2dm.intent.RECEIVE"
            boolean r1 = r1.equals(r0)
            java.lang.String r2 = "FirebaseMessaging"
            if (r1 != 0) goto L_0x0059
            java.lang.String r1 = "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0017
            goto L_0x0059
        L_0x0017:
            java.lang.String r1 = "com.google.firebase.messaging.NOTIFICATION_DISMISS"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0029
            boolean r0 = defpackage.c91.j(r13)
            if (r0 == 0) goto L_0x0058
            defpackage.c91.f(r13)
            return
        L_0x0029:
            java.lang.String r1 = "com.google.firebase.messaging.NEW_TOKEN"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = "token"
            java.lang.String r13 = r13.getStringExtra(r0)
            r12.k(r13)
            return
        L_0x003b:
            java.lang.String r0 = "Unknown intent action: "
            java.lang.String r13 = r13.getAction()
            java.lang.String r13 = java.lang.String.valueOf(r13)
            int r1 = r13.length()
            if (r1 == 0) goto L_0x0050
            java.lang.String r13 = r0.concat(r13)
            goto L_0x0055
        L_0x0050:
            java.lang.String r13 = new java.lang.String
            r13.<init>(r0)
        L_0x0055:
            android.util.Log.d(r2, r13)
        L_0x0058:
            return
        L_0x0059:
            java.lang.String r0 = "google.message_id"
            java.lang.String r1 = r13.getStringExtra(r0)
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            r4 = 0
            r5 = 2
            if (r3 == 0) goto L_0x006e
            eq0 r3 = defpackage.lq0.e(r4)
            goto L_0x007e
        L_0x006e:
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            r3.putString(r0, r1)
            y91 r6 = defpackage.y91.e(r12)
            eq0 r3 = r6.b(r5, r3)
        L_0x007e:
            boolean r6 = android.text.TextUtils.isEmpty(r1)
            r7 = 1
            r8 = 3
            r9 = 0
            if (r6 == 0) goto L_0x008b
            r1 = 0
            goto L_0x00c3
        L_0x008b:
            java.util.Queue<java.lang.String> r6 = a
            boolean r10 = r6.contains(r1)
            if (r10 == 0) goto L_0x00b4
            boolean r6 = android.util.Log.isLoggable(r2, r8)
            if (r6 == 0) goto L_0x00b2
            java.lang.String r6 = "Received duplicate message: "
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r10 = r1.length()
            if (r10 == 0) goto L_0x00aa
            java.lang.String r1 = r6.concat(r1)
            goto L_0x00af
        L_0x00aa:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r6)
        L_0x00af:
            android.util.Log.d(r2, r1)
        L_0x00b2:
            r1 = 1
            goto L_0x00c3
        L_0x00b4:
            int r10 = r6.size()
            r11 = 10
            if (r10 < r11) goto L_0x00bf
            r6.remove()
        L_0x00bf:
            r6.add(r1)
            r1 = 0
        L_0x00c3:
            if (r1 != 0) goto L_0x01c1
            java.lang.String r1 = "message_type"
            java.lang.String r1 = r13.getStringExtra(r1)
            java.lang.String r6 = "gcm"
            if (r1 != 0) goto L_0x00d1
            r1 = r6
        L_0x00d1:
            r10 = -1
            int r11 = r1.hashCode()
            switch(r11) {
                case -2062414158: goto L_0x00f5;
                case 102161: goto L_0x00ed;
                case 814694033: goto L_0x00e3;
                case 814800675: goto L_0x00da;
                default: goto L_0x00d9;
            }
        L_0x00d9:
            goto L_0x00ff
        L_0x00da:
            java.lang.String r6 = "send_event"
            boolean r6 = r1.equals(r6)
            if (r6 == 0) goto L_0x00d9
            goto L_0x0100
        L_0x00e3:
            java.lang.String r5 = "send_error"
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x00d9
            r5 = 3
            goto L_0x0100
        L_0x00ed:
            boolean r5 = r1.equals(r6)
            if (r5 == 0) goto L_0x00d9
            r5 = 0
            goto L_0x0100
        L_0x00f5:
            java.lang.String r5 = "deleted_messages"
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x00d9
            r5 = 1
            goto L_0x0100
        L_0x00ff:
            r5 = -1
        L_0x0100:
            switch(r5) {
                case 0: goto L_0x0142;
                case 1: goto L_0x013d;
                case 2: goto L_0x0134;
                case 3: goto L_0x0115;
                default: goto L_0x0103;
            }
        L_0x0103:
            java.lang.String r13 = "Received message with unknown type: "
            java.lang.String r0 = java.lang.String.valueOf(r1)
            int r1 = r0.length()
            if (r1 == 0) goto L_0x01b8
            java.lang.String r13 = r13.concat(r0)
            goto L_0x01be
        L_0x0115:
            java.lang.String r0 = r13.getStringExtra(r0)
            if (r0 != 0) goto L_0x0123
            java.lang.String r0 = "message_id"
            java.lang.String r0 = r13.getStringExtra(r0)
        L_0x0123:
            com.google.firebase.messaging.a r1 = new com.google.firebase.messaging.a
            java.lang.String r4 = "error"
            java.lang.String r13 = r13.getStringExtra(r4)
            r1.<init>(r13)
            r12.l(r0, r1)
            goto L_0x01c1
        L_0x0134:
            java.lang.String r13 = r13.getStringExtra(r0)
            r12.j(r13)
            goto L_0x01c1
        L_0x013d:
            r12.h()
            goto L_0x01c1
        L_0x0142:
            boolean r0 = defpackage.c91.j(r13)
            if (r0 == 0) goto L_0x014b
            defpackage.c91.b(r13, r4)
        L_0x014b:
            boolean r0 = defpackage.c91.k(r13)
            if (r0 == 0) goto L_0x016d
            fs0 r0 = com.google.firebase.messaging.FirebaseMessaging.f2454a     // Catch:{ NullPointerException -> 0x0167 }
            java.lang.String r1 = "FCM_CLIENT_EVENT_LOGGING"
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            java.lang.String r5 = "json"
            qi r5 = defpackage.qi.b(r5)     // Catch:{ NullPointerException -> 0x0167 }
            as0 r6 = com.google.firebase.messaging.g.a     // Catch:{ NullPointerException -> 0x0167 }
            cs0 r0 = r0.a(r1, r4, r5, r6)     // Catch:{ NullPointerException -> 0x0167 }
            defpackage.c91.b(r13, r0)     // Catch:{ NullPointerException -> 0x0167 }
            goto L_0x016d
        L_0x0167:
            r0 = move-exception
            java.lang.String r0 = "TransportFactory is null. Skip exporting message delivery metrics to Big Query"
            android.util.Log.e(r2, r0)
        L_0x016d:
            android.os.Bundle r0 = r13.getExtras()
            if (r0 != 0) goto L_0x0179
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
        L_0x0179:
            java.lang.String r1 = "androidx.contentpager.content.wakelockid"
            r0.remove(r1)
            boolean r1 = com.google.firebase.messaging.j.d(r0)
            if (r1 == 0) goto L_0x01af
            com.google.firebase.messaging.j r1 = new com.google.firebase.messaging.j
            r1.<init>(r0)
            java.util.concurrent.ExecutorService r4 = java.util.concurrent.Executors.newSingleThreadExecutor()
            com.google.firebase.messaging.d r5 = new com.google.firebase.messaging.d
            r5.<init>(r12, r1, r4)
            boolean r1 = r5.a()     // Catch:{ all -> 0x01aa }
            if (r1 == 0) goto L_0x019c
            r4.shutdown()
            goto L_0x01c1
        L_0x019c:
            r4.shutdown()
            boolean r1 = defpackage.c91.j(r13)
            if (r1 == 0) goto L_0x01af
            defpackage.c91.h(r13)
            goto L_0x01af
        L_0x01aa:
            r13 = move-exception
            r4.shutdown()
            throw r13
        L_0x01af:
            fe0 r13 = new fe0
            r13.<init>(r0)
            r12.i(r13)
            goto L_0x01c1
        L_0x01b8:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r13)
            r13 = r0
        L_0x01be:
            android.util.Log.w(r2, r13)
        L_0x01c1:
            r0 = 1
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ ExecutionException -> 0x01cd, InterruptedException -> 0x01cb, TimeoutException -> 0x01c9 }
            defpackage.lq0.b(r3, r0, r13)     // Catch:{ ExecutionException -> 0x01cd, InterruptedException -> 0x01cb, TimeoutException -> 0x01c9 }
            return
        L_0x01c9:
            r13 = move-exception
            goto L_0x01ce
        L_0x01cb:
            r13 = move-exception
            goto L_0x01ce
        L_0x01cd:
            r13 = move-exception
        L_0x01ce:
            java.lang.String r13 = java.lang.String.valueOf(r13)
            java.lang.String r0 = java.lang.String.valueOf(r13)
            int r0 = r0.length()
            int r0 = r0 + 20
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Message ack failed: "
            r1.append(r0)
            r1.append(r13)
            java.lang.String r13 = r1.toString()
            android.util.Log.w(r2, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessagingService.d(android.content.Intent):void");
    }
}
