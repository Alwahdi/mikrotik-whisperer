package androidx.core.location;

import android.location.LocationManager;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Callable {
    public final /* synthetic */ LocationManager a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport f91a;

    public /* synthetic */ b(LocationManager locationManager, LocationManagerCompat.GpsStatusTransport gpsStatusTransport) {
        this.a = locationManager;
        this.f91a = gpsStatusTransport;
    }

    public final Object call() {
        return Boolean.valueOf(this.a.addGpsStatusListener(this.f91a));
    }
}
