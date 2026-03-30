package androidx.core.location;

import android.location.Location;
import androidx.core.util.Consumer;

public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ Location a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Consumer f92a;

    public /* synthetic */ d(Consumer consumer, Location location) {
        this.f92a = consumer;
        this.a = location;
    }

    public final void run() {
        this.f92a.accept(this.a);
    }
}
