package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* renamed from: s00  reason: default package */
public class s00 extends AppCompatTextView {
    public s00(Context context, AttributeSet attrs) {
        this(context, attrs, 16842884);
    }

    public s00(Context context, AttributeSet attrs, int defStyleAttr) {
        super(t00.c(context, attrs, defStyleAttr, 0), attrs, defStyleAttr);
        d(attrs, defStyleAttr, 0);
    }

    public void setTextAppearance(Context context, int resId) {
        super.setTextAppearance(context, resId);
        if (b(context)) {
            a(context.getTheme(), resId);
        }
    }

    private void d(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        int resId;
        Context context = getContext();
        if (b(context)) {
            Resources.Theme theme = context.getTheme();
            if (!f(context, theme, attrs, defStyleAttr, defStyleRes) && (resId = c(theme, attrs, defStyleAttr, defStyleRes)) != -1) {
                a(theme, resId);
            }
        }
    }

    private void a(Resources.Theme theme, int resId) {
        TypedArray attributes = theme.obtainStyledAttributes(resId, xc0.f5614H0);
        int lineHeight = e(getContext(), attributes, xc0.n3, xc0.o3);
        attributes.recycle();
        if (lineHeight >= 0) {
            setLineHeight(lineHeight);
        }
    }

    private static boolean b(Context context) {
        return e00.b(context, yb0.textAppearanceLineHeightEnabled, true);
    }

    private static int e(Context context, TypedArray attributes, int... indices) {
        int lineHeight = -1;
        for (int index = 0; index < indices.length && lineHeight < 0; index++) {
            lineHeight = o00.c(context, attributes, indices[index], -1);
        }
        return lineHeight;
    }

    private static boolean f(Context context, Resources.Theme theme, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray attributes = theme.obtainStyledAttributes(attrs, xc0.f5617I0, defStyleAttr, defStyleRes);
        int lineHeight = e(context, attributes, xc0.q3, xc0.r3);
        attributes.recycle();
        if (lineHeight != -1) {
            return true;
        }
        return false;
    }

    private static int c(Resources.Theme theme, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray attributes = theme.obtainStyledAttributes(attrs, xc0.f5617I0, defStyleAttr, defStyleRes);
        int appearanceAttrId = attributes.getResourceId(xc0.p3, -1);
        attributes.recycle();
        return appearanceAttrId;
    }
}
