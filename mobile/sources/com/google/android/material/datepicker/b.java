package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.widget.TextView;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;

final class b {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final ColorStateList f1682a;

    /* renamed from: a  reason: collision with other field name */
    private final Rect f1683a;

    /* renamed from: a  reason: collision with other field name */
    private final il0 f1684a;
    private final ColorStateList b;
    private final ColorStateList c;

    private b(ColorStateList backgroundColor, ColorStateList textColor, ColorStateList strokeColor, int strokeWidth, il0 itemShape, Rect insets) {
        Preconditions.checkArgumentNonnegative(insets.left);
        Preconditions.checkArgumentNonnegative(insets.top);
        Preconditions.checkArgumentNonnegative(insets.right);
        Preconditions.checkArgumentNonnegative(insets.bottom);
        this.f1683a = insets;
        this.f1682a = textColor;
        this.b = backgroundColor;
        this.c = strokeColor;
        this.a = strokeWidth;
        this.f1684a = itemShape;
    }

    static b a(Context context, int materialCalendarItemStyle) {
        Context context2 = context;
        int i = materialCalendarItemStyle;
        Preconditions.checkArgument(i != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray styleableArray = context2.obtainStyledAttributes(i, xc0.f5733z0);
        Rect insets = new Rect(styleableArray.getDimensionPixelOffset(xc0.O2, 0), styleableArray.getDimensionPixelOffset(xc0.Q2, 0), styleableArray.getDimensionPixelOffset(xc0.P2, 0), styleableArray.getDimensionPixelOffset(xc0.R2, 0));
        ColorStateList backgroundColor = o00.a(context2, styleableArray, xc0.S2);
        ColorStateList textColor = o00.a(context2, styleableArray, xc0.X2);
        ColorStateList strokeColor = o00.a(context2, styleableArray, xc0.V2);
        int strokeWidth = styleableArray.getDimensionPixelSize(xc0.W2, 0);
        int shapeAppearanceResId = styleableArray.getResourceId(xc0.T2, 0);
        il0 itemShape = il0.b(context2, shapeAppearanceResId, styleableArray.getResourceId(xc0.U2, 0)).m();
        styleableArray.recycle();
        int i2 = shapeAppearanceResId;
        return new b(backgroundColor, textColor, strokeColor, strokeWidth, itemShape, insets);
    }

    /* access modifiers changed from: package-private */
    public void d(TextView item) {
        e(item, (ColorStateList) null, (ColorStateList) null);
    }

    /* access modifiers changed from: package-private */
    public void e(TextView item, ColorStateList backgroundColorOverride, ColorStateList textColorOverride) {
        Drawable d;
        p00 backgroundDrawable = new p00();
        p00 shapeMask = new p00();
        backgroundDrawable.setShapeAppearanceModel(this.f1684a);
        shapeMask.setShapeAppearanceModel(this.f1684a);
        backgroundDrawable.V(backgroundColorOverride != null ? backgroundColorOverride : this.b);
        backgroundDrawable.c0((float) this.a, this.c);
        item.setTextColor(textColorOverride != null ? textColorOverride : this.f1682a);
        if (Build.VERSION.SDK_INT >= 21) {
            d = new RippleDrawable(this.f1682a.withAlpha(30), backgroundDrawable, shapeMask);
        } else {
            d = backgroundDrawable;
        }
        Rect rect = this.f1683a;
        ViewCompat.setBackground(item, new InsetDrawable(d, rect.left, rect.top, rect.right, rect.bottom));
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.f1683a.top;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f1683a.bottom;
    }
}
