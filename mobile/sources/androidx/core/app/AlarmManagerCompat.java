package androidx.core.app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class AlarmManagerCompat {
    public static void setAlarmClock(@NonNull AlarmManager alarmManager, long triggerTime, @NonNull PendingIntent showIntent, @NonNull PendingIntent operation) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.setAlarmClock(alarmManager, Api21Impl.createAlarmClockInfo(triggerTime, showIntent), operation);
        } else {
            setExact(alarmManager, 0, triggerTime, operation);
        }
    }

    public static void setAndAllowWhileIdle(@NonNull AlarmManager alarmManager, int type, long triggerAtMillis, @NonNull PendingIntent operation) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.setAndAllowWhileIdle(alarmManager, type, triggerAtMillis, operation);
        } else {
            alarmManager.set(type, triggerAtMillis, operation);
        }
    }

    public static void setExact(@NonNull AlarmManager alarmManager, int type, long triggerAtMillis, @NonNull PendingIntent operation) {
        if (Build.VERSION.SDK_INT >= 19) {
            Api19Impl.setExact(alarmManager, type, triggerAtMillis, operation);
        } else {
            alarmManager.set(type, triggerAtMillis, operation);
        }
    }

    public static void setExactAndAllowWhileIdle(@NonNull AlarmManager alarmManager, int type, long triggerAtMillis, @NonNull PendingIntent operation) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.setExactAndAllowWhileIdle(alarmManager, type, triggerAtMillis, operation);
        } else {
            setExact(alarmManager, type, triggerAtMillis, operation);
        }
    }

    private AlarmManagerCompat() {
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static void setAlarmClock(AlarmManager alarmManager, Object info, PendingIntent operation) {
            alarmManager.setAlarmClock((AlarmManager.AlarmClockInfo) info, operation);
        }

        @DoNotInline
        static AlarmManager.AlarmClockInfo createAlarmClockInfo(long triggerTime, PendingIntent showIntent) {
            return new AlarmManager.AlarmClockInfo(triggerTime, showIntent);
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static void setAndAllowWhileIdle(AlarmManager alarmManager, int type, long triggerAtMillis, PendingIntent operation) {
            alarmManager.setAndAllowWhileIdle(type, triggerAtMillis, operation);
        }

        @DoNotInline
        static void setExactAndAllowWhileIdle(AlarmManager alarmManager, int type, long triggerAtMillis, PendingIntent operation) {
            alarmManager.setExactAndAllowWhileIdle(type, triggerAtMillis, operation);
        }
    }

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static void setExact(AlarmManager alarmManager, int type, long triggerAtMillis, PendingIntent operation) {
            alarmManager.setExact(type, triggerAtMillis, operation);
        }
    }
}
