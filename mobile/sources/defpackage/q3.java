package defpackage;

import android.animation.ValueAnimator;
import com.google.android.material.appbar.AppBarLayout;

/* renamed from: q3  reason: default package */
public final /* synthetic */ class q3 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ AppBarLayout a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ p00 f4748a;

    public /* synthetic */ q3(AppBarLayout appBarLayout, p00 p00) {
        this.a = appBarLayout;
        this.f4748a = p00;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.t(this.f4748a, valueAnimator);
    }
}
