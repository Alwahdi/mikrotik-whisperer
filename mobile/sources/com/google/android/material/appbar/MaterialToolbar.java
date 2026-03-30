package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;

public class MaterialToolbar extends Toolbar {
    private static final int a = uc0.Widget_MaterialComponents_Toolbar;

    /* renamed from: a  reason: collision with other field name */
    private static final ImageView.ScaleType[] f1458a = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: a  reason: collision with other field name */
    private ImageView.ScaleType f1459a;

    /* renamed from: a  reason: collision with other field name */
    private Boolean f1460a;

    /* renamed from: a  reason: collision with other field name */
    private Integer f1461a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f1462a;
    private boolean b;

    public MaterialToolbar(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, yb0.f0);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialToolbar(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = a
            android.content.Context r0 = defpackage.t00.c(r8, r9, r10, r4)
            r7.<init>(r0, r9, r10)
            android.content.Context r8 = r7.getContext()
            int[] r2 = defpackage.xc0.f5623K0
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r0 = defpackage.vq0.i(r0, r1, r2, r3, r4, r5)
            int r1 = defpackage.xc0.u3
            boolean r2 = r0.hasValue(r1)
            r3 = -1
            if (r2 == 0) goto L_0x0029
            int r1 = r0.getColor(r1, r3)
            r7.setNavigationIconTint(r1)
        L_0x0029:
            int r1 = defpackage.xc0.w3
            boolean r1 = r0.getBoolean(r1, r6)
            r7.f1462a = r1
            int r1 = defpackage.xc0.v3
            boolean r1 = r0.getBoolean(r1, r6)
            r7.b = r1
            int r1 = defpackage.xc0.t3
            int r1 = r0.getInt(r1, r3)
            if (r1 < 0) goto L_0x004a
            android.widget.ImageView$ScaleType[] r2 = f1458a
            int r3 = r2.length
            if (r1 >= r3) goto L_0x004a
            r2 = r2[r1]
            r7.f1459a = r2
        L_0x004a:
            int r2 = defpackage.xc0.s3
            boolean r3 = r0.hasValue(r2)
            if (r3 == 0) goto L_0x005c
            boolean r2 = r0.getBoolean(r2, r6)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r7.f1460a = r2
        L_0x005c:
            r0.recycle()
            r7.b(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.MaterialToolbar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void inflateMenu(int i) {
        Menu menu = getMenu();
        if (menu instanceof MenuBuilder) {
            ((MenuBuilder) menu).stopDispatchingItemsChanged();
        }
        super.inflateMenu(i);
        if (menu instanceof MenuBuilder) {
            ((MenuBuilder) menu).startDispatchingItemsChanged();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        d();
        f();
    }

    private void d() {
        if (this.f1462a || this.b) {
            TextView titleTextView = vr0.e(this);
            TextView subtitleTextView = vr0.c(this);
            if (titleTextView != null || subtitleTextView != null) {
                Pair<Integer, Integer> titleBoundLimits = a(titleTextView, subtitleTextView);
                if (this.f1462a && titleTextView != null) {
                    c(titleTextView, titleBoundLimits);
                }
                if (this.b && subtitleTextView != null) {
                    c(subtitleTextView, titleBoundLimits);
                }
            }
        }
    }

    private Pair<Integer, Integer> a(TextView titleTextView, TextView subtitleTextView) {
        int width = getMeasuredWidth();
        int midpoint = width / 2;
        int leftLimit = getPaddingLeft();
        int rightLimit = width - getPaddingRight();
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (!(child.getVisibility() == 8 || child == titleTextView || child == subtitleTextView)) {
                if (child.getRight() < midpoint && child.getRight() > leftLimit) {
                    leftLimit = child.getRight();
                }
                if (child.getLeft() > midpoint && child.getLeft() < rightLimit) {
                    rightLimit = child.getLeft();
                }
            }
        }
        return new Pair<>(Integer.valueOf(leftLimit), Integer.valueOf(rightLimit));
    }

    private void c(View titleView, Pair<Integer, Integer> titleBoundLimits) {
        int width = getMeasuredWidth();
        int titleWidth = titleView.getMeasuredWidth();
        int titleLeft = (width / 2) - (titleWidth / 2);
        int titleRight = titleLeft + titleWidth;
        int overlap = Math.max(Math.max(((Integer) titleBoundLimits.first).intValue() - titleLeft, 0), Math.max(titleRight - ((Integer) titleBoundLimits.second).intValue(), 0));
        if (overlap > 0) {
            titleLeft += overlap;
            titleRight -= overlap;
            titleView.measure(View.MeasureSpec.makeMeasureSpec(titleRight - titleLeft, BasicMeasure.EXACTLY), titleView.getMeasuredHeightAndState());
        }
        titleView.layout(titleLeft, titleView.getTop(), titleRight, titleView.getBottom());
    }

    private void f() {
        ImageView logoImageView = vr0.b(this);
        if (logoImageView != null) {
            Boolean bool = this.f1460a;
            if (bool != null) {
                logoImageView.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f1459a;
            if (scaleType != null) {
                logoImageView.setScaleType(scaleType);
            }
        }
    }

    @Nullable
    public ImageView.ScaleType getLogoScaleType() {
        return this.f1459a;
    }

    public void setLogoScaleType(@NonNull ImageView.ScaleType logoScaleType) {
        if (this.f1459a != logoScaleType) {
            this.f1459a = logoScaleType;
            requestLayout();
        }
    }

    public void setLogoAdjustViewBounds(boolean logoAdjustViewBounds) {
        Boolean bool = this.f1460a;
        if (bool == null || bool.booleanValue() != logoAdjustViewBounds) {
            this.f1460a = Boolean.valueOf(logoAdjustViewBounds);
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        q00.e(this);
    }

    @RequiresApi(21)
    public void setElevation(float elevation) {
        super.setElevation(elevation);
        q00.d(this, elevation);
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        super.setNavigationIcon(e(drawable));
    }

    public void setNavigationIconTint(@ColorInt int navigationIconTint) {
        this.f1461a = Integer.valueOf(navigationIconTint);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    @ColorInt
    @Nullable
    public Integer getNavigationIconTint() {
        return this.f1461a;
    }

    public void setTitleCentered(boolean titleCentered) {
        if (this.f1462a != titleCentered) {
            this.f1462a = titleCentered;
            requestLayout();
        }
    }

    public void setSubtitleCentered(boolean subtitleCentered) {
        if (this.b != subtitleCentered) {
            this.b = subtitleCentered;
            requestLayout();
        }
    }

    private void b(Context context) {
        ColorStateList backgroundColorStateList;
        Drawable background = getBackground();
        if (background == null) {
            backgroundColorStateList = ColorStateList.valueOf(0);
        } else {
            backgroundColorStateList = yh.f(background);
        }
        if (backgroundColorStateList != null) {
            p00 materialShapeDrawable = new p00();
            materialShapeDrawable.V(backgroundColorStateList);
            materialShapeDrawable.K(context);
            materialShapeDrawable.U(ViewCompat.getElevation(this));
            ViewCompat.setBackground(this, materialShapeDrawable);
        }
    }

    private Drawable e(Drawable navigationIcon) {
        if (navigationIcon == null || this.f1461a == null) {
            return navigationIcon;
        }
        Drawable wrappedNavigationIcon = DrawableCompat.wrap(navigationIcon.mutate());
        DrawableCompat.setTint(wrappedNavigationIcon, this.f1461a.intValue());
        return wrappedNavigationIcon;
    }
}
