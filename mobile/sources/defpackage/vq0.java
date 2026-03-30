package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.TintTypedArray;

/* renamed from: vq0  reason: default package */
public abstract class vq0 {
    private static final int[] a = {yb0.l};
    private static final int[] b = {yb0.colorPrimaryVariant};

    public static TypedArray i(Context context, AttributeSet set, int[] attrs, int defStyleAttr, int defStyleRes, int... textAppearanceResIndices) {
        b(context, set, defStyleAttr, defStyleRes);
        d(context, set, attrs, defStyleAttr, defStyleRes, textAppearanceResIndices);
        return context.obtainStyledAttributes(set, attrs, defStyleAttr, defStyleRes);
    }

    public static TintTypedArray j(Context context, AttributeSet set, int[] attrs, int defStyleAttr, int defStyleRes, int... textAppearanceResIndices) {
        b(context, set, defStyleAttr, defStyleRes);
        d(context, set, attrs, defStyleAttr, defStyleRes, textAppearanceResIndices);
        return TintTypedArray.obtainStyledAttributes(context, set, attrs, defStyleAttr, defStyleRes);
    }

    private static void b(Context context, AttributeSet set, int defStyleAttr, int defStyleRes) {
        TypedArray a2 = context.obtainStyledAttributes(set, xc0.f5603D1, defStyleAttr, defStyleRes);
        boolean enforceMaterialTheme = a2.getBoolean(xc0.j6, false);
        a2.recycle();
        if (enforceMaterialTheme) {
            TypedValue isMaterialTheme = new TypedValue();
            if (!context.getTheme().resolveAttribute(yb0.isMaterialTheme, isMaterialTheme, true) || (isMaterialTheme.type == 18 && isMaterialTheme.data == 0)) {
                c(context);
            }
        }
        a(context);
    }

    private static void d(Context context, AttributeSet set, int[] attrs, int defStyleAttr, int defStyleRes, int... textAppearanceResIndices) {
        TypedArray themeEnforcementAttrs = context.obtainStyledAttributes(set, xc0.f5603D1, defStyleAttr, defStyleRes);
        boolean validTextAppearance = false;
        if (!themeEnforcementAttrs.getBoolean(xc0.k6, false)) {
            themeEnforcementAttrs.recycle();
            return;
        }
        if (textAppearanceResIndices != null && textAppearanceResIndices.length != 0) {
            validTextAppearance = f(context, set, attrs, defStyleAttr, defStyleRes, textAppearanceResIndices);
        } else if (themeEnforcementAttrs.getResourceId(xc0.i6, -1) != -1) {
            validTextAppearance = true;
        }
        themeEnforcementAttrs.recycle();
        if (!validTextAppearance) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    private static boolean f(Context context, AttributeSet set, int[] attrs, int defStyleAttr, int defStyleRes, int... textAppearanceResIndices) {
        TypedArray componentAttrs = context.obtainStyledAttributes(set, attrs, defStyleAttr, defStyleRes);
        for (int customTextAppearanceIndex : textAppearanceResIndices) {
            if (componentAttrs.getResourceId(customTextAppearanceIndex, -1) == -1) {
                componentAttrs.recycle();
                return false;
            }
        }
        componentAttrs.recycle();
        return true;
    }

    public static void a(Context context) {
        e(context, a, "Theme.AppCompat");
    }

    public static void c(Context context) {
        e(context, b, "Theme.MaterialComponents");
    }

    public static boolean g(Context context) {
        return e00.b(context, yb0.isMaterial3Theme, false);
    }

    private static boolean h(Context context, int[] themeAttributes) {
        TypedArray a2 = context.obtainStyledAttributes(themeAttributes);
        for (int i = 0; i < themeAttributes.length; i++) {
            if (!a2.hasValue(i)) {
                a2.recycle();
                return false;
            }
        }
        a2.recycle();
        return true;
    }

    private static void e(Context context, int[] themeAttributes, String themeName) {
        if (!h(context, themeAttributes)) {
            throw new IllegalArgumentException("The style on this component requires your app theme to be " + themeName + " (or a descendant).");
        }
    }
}
