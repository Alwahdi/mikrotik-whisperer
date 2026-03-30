package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Iterator;
import java.util.List;

class a extends WindowInsetsAnimationCompat.Callback {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private final View f1540a;

    /* renamed from: a  reason: collision with other field name */
    private final int[] f1541a = new int[2];
    private int b;

    public a(View view) {
        super(0);
        this.f1540a = view;
    }

    public void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        this.f1540a.getLocationOnScreen(this.f1541a);
        this.a = this.f1541a[1];
    }

    public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
        this.f1540a.getLocationOnScreen(this.f1541a);
        int i = this.a - this.f1541a[1];
        this.b = i;
        this.f1540a.setTranslationY((float) i);
        return boundsCompat;
    }

    public WindowInsetsCompat onProgress(WindowInsetsCompat insets, List<WindowInsetsAnimationCompat> animationList) {
        Iterator<WindowInsetsAnimationCompat> it = animationList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            WindowInsetsAnimationCompat animation = it.next();
            if ((animation.getTypeMask() & WindowInsetsCompat.Type.ime()) != 0) {
                this.f1540a.setTranslationY((float) f3.c(this.b, 0, animation.getInterpolatedFraction()));
                break;
            }
        }
        return insets;
    }

    public void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        this.f1540a.setTranslationY(0.0f);
    }
}
