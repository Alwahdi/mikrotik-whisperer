package defpackage;

import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* renamed from: e10  reason: default package */
public final /* synthetic */ class e10 implements LifecycleEventObserver {
    public final /* synthetic */ MenuHostHelper a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ MenuProvider f2838a;

    public /* synthetic */ e10(MenuHostHelper menuHostHelper, MenuProvider menuProvider) {
        this.a = menuHostHelper;
        this.f2838a = menuProvider;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.a.lambda$addMenuProvider$0(this.f2838a, lifecycleOwner, event);
    }
}
