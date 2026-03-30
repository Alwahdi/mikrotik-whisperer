package defpackage;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import com.google.android.material.appbar.AppBarLayout;

/* renamed from: r3  reason: default package */
public final /* synthetic */ class r3 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ColorStateList a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ AppBarLayout f4875a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Integer f4876a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ p00 f4877a;
    public final /* synthetic */ ColorStateList b;

    public /* synthetic */ r3(AppBarLayout appBarLayout, ColorStateList colorStateList, ColorStateList colorStateList2, p00 p00, Integer num) {
        this.f4875a = appBarLayout;
        this.a = colorStateList;
        this.b = colorStateList2;
        this.f4877a = p00;
        this.f4876a = num;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f4875a.s(this.a, this.b, this.f4877a, this.f4876a, valueAnimator);
    }
}
