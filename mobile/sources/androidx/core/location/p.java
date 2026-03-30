package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class p implements Runnable {
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Executor f108a;

    public /* synthetic */ p(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor) {
        this.a = preRGnssStatusTransport;
        this.f108a = executor;
    }

    public final void run() {
        this.a.lambda$onStarted$0(this.f108a);
    }
}
