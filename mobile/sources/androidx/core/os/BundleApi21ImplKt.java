package androidx.core.os;

import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
final class BundleApi21ImplKt {
    public static final BundleApi21ImplKt INSTANCE = new BundleApi21ImplKt();

    private BundleApi21ImplKt() {
    }

    @DoNotInline
    public static final void putSize(Bundle bundle, String key, Size value) {
        lu.f(bundle, "bundle");
        lu.f(key, "key");
        bundle.putSize(key, value);
    }

    @DoNotInline
    public static final void putSizeF(Bundle bundle, String key, SizeF value) {
        lu.f(bundle, "bundle");
        lu.f(key, "key");
        bundle.putSizeF(key, value);
    }
}
