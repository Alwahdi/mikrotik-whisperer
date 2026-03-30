package defpackage;

import android.os.Bundle;

/* renamed from: vz0  reason: default package */
final class vz0 extends rz0<Bundle> {
    vz0(int i, int i2, Bundle bundle) {
        super(i, 1, bundle);
    }

    /* access modifiers changed from: package-private */
    public final boolean d() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        b(bundle2);
    }
}
