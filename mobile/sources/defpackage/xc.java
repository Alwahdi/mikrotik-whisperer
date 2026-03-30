package defpackage;

import android.graphics.RectF;

/* renamed from: xc  reason: default package */
public abstract class xc {
    public abstract void a(kl0 kl0, float f, float f2, float f3);

    public void b(kl0 shapePath, float angle, float interpolation, RectF bounds, wc size) {
        a(shapePath, angle, interpolation, size.a(bounds));
    }
}
