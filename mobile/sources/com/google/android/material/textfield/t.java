package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Arrays;

abstract class t {
    static void h(CheckableImageButton iconView, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        iconView.setOnClickListener(onClickListener);
        f(iconView, onLongClickListener);
    }

    static void i(CheckableImageButton iconView, View.OnLongClickListener onLongClickListener) {
        iconView.setOnLongClickListener(onLongClickListener);
        f(iconView, onLongClickListener);
    }

    private static void f(CheckableImageButton iconView, View.OnLongClickListener onLongClickListener) {
        boolean iconClickable = ViewCompat.hasOnClickListeners(iconView);
        boolean iconFocusable = false;
        int i = 1;
        boolean iconLongClickable = onLongClickListener != null;
        if (iconClickable || iconLongClickable) {
            iconFocusable = true;
        }
        iconView.setFocusable(iconFocusable);
        iconView.setClickable(iconClickable);
        iconView.setPressable(iconClickable);
        iconView.setLongClickable(iconLongClickable);
        if (!iconFocusable) {
            i = 2;
        }
        ViewCompat.setImportantForAccessibility(iconView, i);
    }

    static void a(TextInputLayout textInputLayout, CheckableImageButton iconView, ColorStateList iconTintList, PorterDuff.Mode iconTintMode) {
        Drawable icon = iconView.getDrawable();
        if (icon != null) {
            icon = DrawableCompat.wrap(icon).mutate();
            if (iconTintList == null || !iconTintList.isStateful()) {
                DrawableCompat.setTintList(icon, iconTintList);
            } else {
                DrawableCompat.setTintList(icon, ColorStateList.valueOf(iconTintList.getColorForState(c(textInputLayout, iconView), iconTintList.getDefaultColor())));
            }
            if (iconTintMode != null) {
                DrawableCompat.setTintMode(icon, iconTintMode);
            }
        }
        if (iconView.getDrawable() != icon) {
            iconView.setImageDrawable(icon);
        }
    }

    static void d(TextInputLayout textInputLayout, CheckableImageButton iconView, ColorStateList colorStateList) {
        Drawable icon = iconView.getDrawable();
        if (iconView.getDrawable() != null && colorStateList != null && colorStateList.isStateful()) {
            int color = colorStateList.getColorForState(c(textInputLayout, iconView), colorStateList.getDefaultColor());
            Drawable icon2 = DrawableCompat.wrap(icon).mutate();
            DrawableCompat.setTintList(icon2, ColorStateList.valueOf(color));
            iconView.setImageDrawable(icon2);
        }
    }

    private static int[] c(TextInputLayout textInputLayout, CheckableImageButton iconView) {
        int[] textInputStates = textInputLayout.getDrawableState();
        int[] iconStates = iconView.getDrawableState();
        int index = textInputStates.length;
        int[] states = Arrays.copyOf(textInputStates, textInputStates.length + iconStates.length);
        System.arraycopy(iconStates, 0, states, index, iconStates.length);
        return states;
    }

    static void e(CheckableImageButton iconView) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21 && i <= 22) {
            iconView.setBackground(ye0.b(iconView.getContext(), (int) lv0.c(iconView.getContext(), 4)));
        }
    }

    static void g(CheckableImageButton iconView, int iconSize) {
        iconView.setMinimumWidth(iconSize);
        iconView.setMinimumHeight(iconSize);
    }

    static void j(CheckableImageButton iconView, ImageView.ScaleType scaleType) {
        iconView.setScaleType(scaleType);
    }

    static ImageView.ScaleType b(int scaleType) {
        switch (scaleType) {
            case 0:
                return ImageView.ScaleType.FIT_XY;
            case 1:
                return ImageView.ScaleType.FIT_START;
            case 2:
                return ImageView.ScaleType.FIT_CENTER;
            case 3:
                return ImageView.ScaleType.FIT_END;
            case 5:
                return ImageView.ScaleType.CENTER_CROP;
            case 6:
                return ImageView.ScaleType.CENTER_INSIDE;
            default:
                return ImageView.ScaleType.CENTER;
        }
    }
}
