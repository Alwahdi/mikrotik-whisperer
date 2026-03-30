package androidx.core.app;

import android.app.SharedElementCallback;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;

public final /* synthetic */ class a implements SharedElementCallback.OnSharedElementsReadyListener {
    public final /* synthetic */ SharedElementCallback.OnSharedElementsReadyListener a;

    public /* synthetic */ a(SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
        this.a = onSharedElementsReadyListener;
    }

    public final void onSharedElementsReady() {
        ActivityCompat.Api23Impl.onSharedElementsReady(this.a);
    }
}
