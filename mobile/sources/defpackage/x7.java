package defpackage;

import android.view.View;
import com.google.android.material.carousel.CarouselLayoutManager;

/* renamed from: x7  reason: default package */
public final /* synthetic */ class x7 implements View.OnLayoutChangeListener {
    public final /* synthetic */ CarouselLayoutManager a;

    public /* synthetic */ x7(CarouselLayoutManager carouselLayoutManager) {
        this.a = carouselLayoutManager;
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.a.P(view, i, i2, i3, i4, i5, i6, i7, i8);
    }
}
