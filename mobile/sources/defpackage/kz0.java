package defpackage;

import android.os.Bundle;

/* renamed from: kz0  reason: default package */
final class kz0 extends rz0<Void> {
    kz0(int i, int i2, Bundle bundle) {
        super(i, 2, bundle);
    }

    /* access modifiers changed from: package-private */
    public final boolean d() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            b(null);
        } else {
            c(new pz0(4, "Invalid response to one way request"));
        }
    }
}
