package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.core.graphics.ColorUtils;

/* renamed from: ye0  reason: default package */
public abstract class ye0 {
    static final String a = ye0.class.getSimpleName();

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f5882a = (Build.VERSION.SDK_INT >= 21);

    /* renamed from: a  reason: collision with other field name */
    private static final int[] f5883a = {16842919};
    private static final int[] b = {16843623, 16842908};
    private static final int[] c = {16842908};
    private static final int[] d = {16843623};
    private static final int[] e = {16842913, 16842919};
    private static final int[] f = {16842913, 16843623, 16842908};
    private static final int[] g = {16842913, 16842908};
    private static final int[] h = {16842913, 16843623};
    private static final int[] i = {16842913};
    private static final int[] j = {16842910, 16842919};

    public static ColorStateList a(ColorStateList rippleColor) {
        if (f5882a) {
            int[][] states = new int[3][];
            int[] colors = new int[3];
            states[0] = i;
            colors[0] = d(rippleColor, e);
            int i2 = 0 + 1;
            int[] iArr = c;
            states[i2] = iArr;
            colors[i2] = d(rippleColor, iArr);
            int i3 = i2 + 1;
            states[i3] = StateSet.NOTHING;
            colors[i3] = d(rippleColor, f5883a);
            int i4 = i3 + 1;
            return new ColorStateList(states, colors);
        }
        int[][] states2 = new int[10][];
        int[] colors2 = new int[10];
        int[] iArr2 = e;
        states2[0] = iArr2;
        colors2[0] = d(rippleColor, iArr2);
        int i5 = 0 + 1;
        int[] iArr3 = f;
        states2[i5] = iArr3;
        colors2[i5] = d(rippleColor, iArr3);
        int i6 = i5 + 1;
        int[] iArr4 = g;
        states2[i6] = iArr4;
        colors2[i6] = d(rippleColor, iArr4);
        int i7 = i6 + 1;
        int[] iArr5 = h;
        states2[i7] = iArr5;
        colors2[i7] = d(rippleColor, iArr5);
        int i8 = i7 + 1;
        states2[i8] = i;
        colors2[i8] = 0;
        int i9 = i8 + 1;
        int[] iArr6 = f5883a;
        states2[i9] = iArr6;
        colors2[i9] = d(rippleColor, iArr6);
        int i10 = i9 + 1;
        int[] iArr7 = b;
        states2[i10] = iArr7;
        colors2[i10] = d(rippleColor, iArr7);
        int i11 = i10 + 1;
        int[] iArr8 = c;
        states2[i11] = iArr8;
        colors2[i11] = d(rippleColor, iArr8);
        int i12 = i11 + 1;
        int[] iArr9 = d;
        states2[i12] = iArr9;
        colors2[i12] = d(rippleColor, iArr9);
        int i13 = i12 + 1;
        states2[i13] = StateSet.NOTHING;
        colors2[i13] = 0;
        int i14 = i13 + 1;
        return new ColorStateList(states2, colors2);
    }

    public static ColorStateList e(ColorStateList rippleColor) {
        if (rippleColor == null) {
            return ColorStateList.valueOf(0);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 22 && i2 <= 27 && Color.alpha(rippleColor.getDefaultColor()) == 0 && Color.alpha(rippleColor.getColorForState(j, 0)) != 0) {
            Log.w(a, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        }
        return rippleColor;
    }

    public static boolean f(int[] stateSet) {
        boolean enabled = false;
        boolean interactedState = false;
        for (int state : stateSet) {
            if (state == 16842910) {
                enabled = true;
            } else if (state == 16842908) {
                interactedState = true;
            } else if (state == 16842919) {
                interactedState = true;
            } else if (state == 16843623) {
                interactedState = true;
            }
        }
        if (!enabled || !interactedState) {
            return false;
        }
        return true;
    }

    public static Drawable b(Context context, int padding) {
        return a.b(context, padding);
    }

    private static int d(ColorStateList rippleColor, int[] state) {
        int color;
        if (rippleColor != null) {
            color = rippleColor.getColorForState(state, rippleColor.getDefaultColor());
        } else {
            color = 0;
        }
        return f5882a ? c(color) : color;
    }

    private static int c(int color) {
        return ColorUtils.setAlphaComponent(color, Math.min(Color.alpha(color) * 2, 255));
    }

    /* renamed from: ye0$a */
    private static class a {
        /* access modifiers changed from: private */
        @DoNotInline
        public static Drawable b(@NonNull Context context, @Px int padding) {
            GradientDrawable maskDrawable = new GradientDrawable();
            maskDrawable.setColor(-1);
            maskDrawable.setShape(1);
            return new RippleDrawable(k00.g(context, yb0.i, ColorStateList.valueOf(0)), (Drawable) null, new InsetDrawable(maskDrawable, padding, padding, padding, padding));
        }
    }
}
