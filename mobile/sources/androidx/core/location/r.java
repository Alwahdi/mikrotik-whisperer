package androidx.core.location;

import android.location.GnssStatus;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class r implements Runnable {
    public final /* synthetic */ GnssStatus a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f111a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Executor f112a;

    public /* synthetic */ r(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, GnssStatus gnssStatus) {
        this.f111a = preRGnssStatusTransport;
        this.f112a = executor;
        this.a = gnssStatus;
    }

    public final void run() {
        this.f111a.lambda$onSatelliteStatusChanged$3(this.f112a, this.a);
    }
}
