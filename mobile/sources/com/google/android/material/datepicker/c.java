package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;

final class c {
    final Paint a;

    /* renamed from: a  reason: collision with other field name */
    final b f1685a;
    final b b;
    final b c;
    final b d;
    final b e;
    final b f;
    final b g;

    c(Context context) {
        TypedArray calendarAttributes = context.obtainStyledAttributes(e00.d(context, yb0.materialCalendarStyle, g.class.getCanonicalName()), xc0.f5730y0);
        this.f1685a = b.a(context, calendarAttributes.getResourceId(xc0.I2, 0));
        this.g = b.a(context, calendarAttributes.getResourceId(xc0.G2, 0));
        this.b = b.a(context, calendarAttributes.getResourceId(xc0.H2, 0));
        this.c = b.a(context, calendarAttributes.getResourceId(xc0.J2, 0));
        ColorStateList rangeFillColorList = o00.a(context, calendarAttributes, xc0.K2);
        this.d = b.a(context, calendarAttributes.getResourceId(xc0.M2, 0));
        this.e = b.a(context, calendarAttributes.getResourceId(xc0.L2, 0));
        this.f = b.a(context, calendarAttributes.getResourceId(xc0.N2, 0));
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(rangeFillColorList.getDefaultColor());
        calendarAttributes.recycle();
    }
}
