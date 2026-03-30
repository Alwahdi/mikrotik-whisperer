package androidx.core.location;

import android.os.Bundle;
import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class m implements Runnable {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Bundle f103a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f104a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f105a;

    public /* synthetic */ m(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str, int i, Bundle bundle) {
        this.f104a = locationListenerTransport;
        this.f105a = str;
        this.a = i;
        this.f103a = bundle;
    }

    public final void run() {
        this.f104a.lambda$onStatusChanged$3(this.f105a, this.a, this.f103a);
    }
}
