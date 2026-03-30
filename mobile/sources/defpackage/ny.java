package defpackage;

import android.location.Location;
import android.os.Bundle;
import androidx.core.location.LocationListenerCompat;
import java.util.List;

/* renamed from: ny  reason: default package */
public abstract /* synthetic */ class ny {
    public static void e(LocationListenerCompat _this, String provider, int status, Bundle extras) {
    }

    public static void d(LocationListenerCompat _this, String provider) {
    }

    public static void c(LocationListenerCompat _this, String provider) {
    }

    public static void b(LocationListenerCompat _this, List locations) {
        int size = locations.size();
        for (int i = 0; i < size; i++) {
            _this.onLocationChanged((Location) locations.get(i));
        }
    }

    public static void a(LocationListenerCompat _this, int requestCode) {
    }
}
