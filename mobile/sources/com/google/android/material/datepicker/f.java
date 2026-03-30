package com.google.android.material.datepicker;

import android.os.Build;
import android.widget.BaseAdapter;
import java.util.Calendar;

class f extends BaseAdapter {
    private static final int c = (Build.VERSION.SDK_INT >= 26 ? 4 : 1);
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final Calendar f1686a;
    private final int b;

    public f() {
        Calendar k = p.k();
        this.f1686a = k;
        this.a = k.getMaximum(7);
        this.b = k.getFirstDayOfWeek();
    }

    public f(int firstDayOfWeek) {
        Calendar k = p.k();
        this.f1686a = k;
        this.a = k.getMaximum(7);
        this.b = firstDayOfWeek;
    }

    /* renamed from: a */
    public Integer getItem(int position) {
        if (position >= this.a) {
            return null;
        }
        return Integer.valueOf(b(position));
    }

    public long getItemId(int position) {
        return 0;
    }

    public int getCount() {
        return this.a;
    }

    /* JADX WARNING: type inference failed for: r3v6, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r10, android.view.View r11, android.view.ViewGroup r12) {
        /*
            r9 = this;
            r0 = r11
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r11 != 0) goto L_0x0017
            android.content.Context r2 = r12.getContext()
            android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r2)
            int r3 = defpackage.nc0.mtrl_calendar_day_of_week
            android.view.View r3 = r2.inflate(r3, r12, r1)
            r0 = r3
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x0017:
            java.util.Calendar r2 = r9.f1686a
            int r3 = r9.b(r10)
            r4 = 7
            r2.set(r4, r3)
            android.content.res.Resources r2 = r0.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
            java.util.Locale r2 = r2.locale
            java.util.Calendar r3 = r9.f1686a
            int r5 = c
            java.lang.String r3 = r3.getDisplayName(r4, r5, r2)
            r0.setText(r3)
            android.content.Context r3 = r12.getContext()
            int r5 = defpackage.sc0.mtrl_picker_day_of_week_column_header
            java.lang.String r3 = r3.getString(r5)
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.util.Calendar r6 = r9.f1686a
            r7 = 2
            java.util.Locale r8 = java.util.Locale.getDefault()
            java.lang.String r4 = r6.getDisplayName(r4, r7, r8)
            r5[r1] = r4
            java.lang.String r1 = java.lang.String.format(r3, r5)
            r0.setContentDescription(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.f.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    private int b(int position) {
        int dayConstant = this.b + position;
        int i = this.a;
        if (dayConstant > i) {
            return dayConstant - i;
        }
        return dayConstant;
    }
}
