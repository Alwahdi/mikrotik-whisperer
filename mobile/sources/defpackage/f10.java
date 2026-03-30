package defpackage;

import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* renamed from: f10  reason: default package */
public final /* synthetic */ class f10 implements LifecycleEventObserver {
    public final /* synthetic */ MenuHostHelper a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ MenuProvider f2934a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Lifecycle.State f2935a;

    public /* synthetic */ f10(MenuHostHelper menuHostHelper, Lifecycle.State state, MenuProvider menuProvider) {
        this.a = menuHostHelper;
        this.f2935a = state;
        this.f2934a = menuProvider;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.a.lambda$addMenuProvider$1(this.f2935a, this.f2934a, lifecycleOwner, event);
    }
}
