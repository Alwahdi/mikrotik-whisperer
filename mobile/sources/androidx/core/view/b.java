package androidx.core.view;

import android.view.WindowInsetsController;
import androidx.core.view.WindowInsetsControllerCompat;

public final /* synthetic */ class b implements WindowInsetsController.OnControllableInsetsChangedListener {
    public final /* synthetic */ WindowInsetsControllerCompat.Impl30 a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ WindowInsetsControllerCompat.OnControllableInsetsChangedListener f113a;

    public /* synthetic */ b(WindowInsetsControllerCompat.Impl30 impl30, WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.a = impl30;
        this.f113a = onControllableInsetsChangedListener;
    }

    public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int i) {
        this.a.lambda$addOnControllableInsetsChangedListener$0(this.f113a, windowInsetsController, i);
    }
}
