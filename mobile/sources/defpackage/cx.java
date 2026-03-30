package defpackage;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleController;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* renamed from: cx  reason: default package */
public final /* synthetic */ class cx implements LifecycleEventObserver {
    public final /* synthetic */ LifecycleController a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ev f2678a;

    public /* synthetic */ cx(LifecycleController lifecycleController, ev evVar) {
        this.a = lifecycleController;
        this.f2678a = evVar;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        LifecycleController.observer$lambda$0(this.a, this.f2678a, lifecycleOwner, event);
    }
}
