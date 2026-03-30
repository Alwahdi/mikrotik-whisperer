package com.blogspot.yemeninfo4it.mumsmobile_app.fcm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import android.util.Log;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.Splash_screen;
import com.google.firebase.messaging.FirebaseMessagingService;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    public void i(fe0 remoteMessage) {
        if (remoteMessage.m() != null) {
            Log.d("MyFirebaseMsgService", "From: " + remoteMessage.p());
            Log.d("MyFirebaseMsgService", "Notification Message Body: " + remoteMessage.m());
            n(remoteMessage.m().get("message"));
            return;
        }
        Log.d("MyFirebaseMsgService", "FCM Notification failed");
    }

    private void n(String messageBody) {
        Intent intent = new Intent(this, Splash_screen.class);
        intent.addFlags(67108864);
        intent.putExtra("Notification", messageBody);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this).setContentTitle(getString(R.string.app_name)).setContentText(messageBody).setAutoCancel(true).setSound(RingtoneManager.getDefaultUri(2)).setContentIntent(PendingIntent.getActivity(this, 0, intent, BasicMeasure.EXACTLY));
        notificationBuilder.setSmallIcon(m(notificationBuilder), 1);
        ((NotificationManager) getSystemService("notification")).notify(0, notificationBuilder.build());
    }

    private int m(NotificationCompat.Builder notificationBuilder) {
        if (Build.VERSION.SDK_INT < 21) {
            return R.mipmap.ic_launcher;
        }
        notificationBuilder.setColor(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));
        return 17301646;
    }
}
