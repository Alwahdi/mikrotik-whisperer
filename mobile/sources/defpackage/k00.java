package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;

/* renamed from: k00  reason: default package */
public abstract class k00 {
    public static int d(View view, int colorAttributeResId) {
        return m(view.getContext(), e00.f(view, colorAttributeResId));
    }

    public static int c(Context context, int colorAttributeResId, String errorMessageComponent) {
        return m(context, e00.e(context, colorAttributeResId, errorMessageComponent));
    }

    public static int e(View view, int colorAttributeResId, int defaultValue) {
        return b(view.getContext(), colorAttributeResId, defaultValue);
    }

    public static int b(Context context, int colorAttributeResId, int defaultValue) {
        Integer color = f(context, colorAttributeResId);
        return color != null ? color.intValue() : defaultValue;
    }

    public static Integer f(Context context, int colorAttributeResId) {
        TypedValue typedValue = e00.a(context, colorAttributeResId);
        if (typedValue != null) {
            return Integer.valueOf(m(context, typedValue));
        }
        return null;
    }

    public static ColorStateList g(Context context, int colorAttributeResId, ColorStateList defaultValue) {
        ColorStateList resolvedColor = null;
        TypedValue typedValue = e00.a(context, colorAttributeResId);
        if (typedValue != null) {
            resolvedColor = n(context, typedValue);
        }
        return resolvedColor == null ? defaultValue : resolvedColor;
    }

    public static ColorStateList h(Context context, int colorAttributeResId) {
        TypedValue typedValue = e00.a(context, colorAttributeResId);
        if (typedValue == null) {
            return null;
        }
        int i = typedValue.resourceId;
        if (i != 0) {
            return ContextCompat.getColorStateList(context, i);
        }
        int i2 = typedValue.data;
        if (i2 != 0) {
            return ColorStateList.valueOf(i2);
        }
        return null;
    }

    private static int m(Context context, TypedValue typedValue) {
        int i = typedValue.resourceId;
        if (i != 0) {
            return ContextCompat.getColor(context, i);
        }
        return typedValue.data;
    }

    private static ColorStateList n(Context context, TypedValue typedValue) {
        int i = typedValue.resourceId;
        if (i != 0) {
            return ContextCompat.getColorStateList(context, i);
        }
        return ColorStateList.valueOf(typedValue.data);
    }

    public static int l(View view, int backgroundColorAttributeResId, int overlayColorAttributeResId, float overlayAlpha) {
        return k(d(view, backgroundColorAttributeResId), d(view, overlayColorAttributeResId), overlayAlpha);
    }

    public static int k(int backgroundColor, int overlayColor, float overlayAlpha) {
        return j(backgroundColor, ColorUtils.setAlphaComponent(overlayColor, Math.round(((float) Color.alpha(overlayColor)) * overlayAlpha)));
    }

    public static int j(int backgroundColor, int overlayColor) {
        return ColorUtils.compositeColors(overlayColor, backgroundColor);
    }

    public static int a(int originalARGB, int alpha) {
        return ColorUtils.setAlphaComponent(originalARGB, (Color.alpha(originalARGB) * alpha) / 255);
    }

    public static boolean i(int color) {
        return color != 0 && ColorUtils.calculateLuminance(color) > 0.5d;
    }
}
