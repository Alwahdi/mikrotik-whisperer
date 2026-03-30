package defpackage;

import android.util.Log;
import defpackage.wp;

/* renamed from: dx0  reason: default package */
final class dx0 implements Runnable {
    private final /* synthetic */ dc a;

    /* renamed from: a  reason: collision with other field name */
    private final /* synthetic */ wp.b f2828a;

    dx0(wp.b bVar, dc dcVar) {
        this.f2828a = bVar;
        this.a = dcVar;
    }

    public final void run() {
        wp.a aVar = (wp.a) wp.this.f5501a.get(this.f2828a.f5524a);
        if (aVar != null) {
            if (this.a.t()) {
                boolean unused = this.f2828a.f5526a = true;
                if (this.f2828a.f5522a.h()) {
                    this.f2828a.g();
                    return;
                }
                try {
                    this.f2828a.f5522a.a((cr) null, this.f2828a.f5522a.j());
                } catch (SecurityException e) {
                    Log.e("GoogleApiManager", "Failed to get service from broker. ", e);
                    aVar.c(new dc(10));
                }
            } else {
                aVar.c(this.a);
            }
        }
    }
}
