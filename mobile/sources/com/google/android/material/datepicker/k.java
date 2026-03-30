package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.util.Pair;
import java.util.Collection;

class k extends BaseAdapter {
    static final int a = p.k().getMaximum(4);
    private static final int b = ((p.k().getMaximum(5) + p.k().getMaximum(7)) - 1);

    /* renamed from: a  reason: collision with other field name */
    final a f1740a;

    /* renamed from: a  reason: collision with other field name */
    c f1741a;

    /* renamed from: a  reason: collision with other field name */
    final j f1742a;

    /* renamed from: a  reason: collision with other field name */
    private Collection<Long> f1743a;

    /* renamed from: a  reason: collision with other field name */
    final xe<?> f1744a;

    k(j month, xe<?> dateSelector, a calendarConstraints, ye dayViewDecorator) {
        this.f1742a = month;
        this.f1744a = dateSelector;
        this.f1740a = calendarConstraints;
        this.f1743a = dateSelector.h();
    }

    public boolean hasStableIds() {
        return true;
    }

    /* renamed from: d */
    public Long getItem(int position) {
        if (position < b() || position > m()) {
            return null;
        }
        return Long.valueOf(this.f1742a.s(n(position)));
    }

    public long getItemId(int position) {
        return (long) (position / this.f1742a.c);
    }

    public int getCount() {
        return b;
    }

    /* JADX WARNING: type inference failed for: r3v4, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0064 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0065  */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.widget.TextView getView(int r9, android.view.View r10, android.view.ViewGroup r11) {
        /*
            r8 = this;
            android.content.Context r0 = r11.getContext()
            r8.f(r0)
            r0 = r10
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r10 != 0) goto L_0x001e
            android.content.Context r2 = r11.getContext()
            android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r2)
            int r3 = defpackage.nc0.mtrl_calendar_day
            android.view.View r3 = r2.inflate(r3, r11, r1)
            r0 = r3
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x001e:
            int r2 = r8.b()
            int r2 = r9 - r2
            r3 = -1
            if (r2 < 0) goto L_0x0056
            com.google.android.material.datepicker.j r4 = r8.f1742a
            int r5 = r4.d
            if (r2 < r5) goto L_0x002e
            goto L_0x0056
        L_0x002e:
            int r3 = r2 + 1
            r0.setTag(r4)
            android.content.res.Resources r4 = r0.getResources()
            android.content.res.Configuration r4 = r4.getConfiguration()
            java.util.Locale r4 = r4.locale
            r5 = 1
            java.lang.Object[] r6 = new java.lang.Object[r5]
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
            r6[r1] = r7
            java.lang.String r7 = "%d"
            java.lang.String r6 = java.lang.String.format(r4, r7, r6)
            r0.setText(r6)
            r0.setVisibility(r1)
            r0.setEnabled(r5)
            goto L_0x005e
        L_0x0056:
            r4 = 8
            r0.setVisibility(r4)
            r0.setEnabled(r1)
        L_0x005e:
            java.lang.Long r1 = r8.getItem(r9)
            if (r1 != 0) goto L_0x0065
            return r0
        L_0x0065:
            long r4 = r1.longValue()
            r8.o(r0, r4, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.k.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    public void q(MaterialCalendarGridView monthGrid) {
        for (Long date : this.f1743a) {
            p(monthGrid, date.longValue());
        }
        xe<?> xeVar = this.f1744a;
        if (xeVar != null) {
            for (Long date2 : xeVar.h()) {
                p(monthGrid, date2.longValue());
            }
            this.f1743a = this.f1744a.h();
        }
    }

    private void p(MaterialCalendarGridView monthGrid, long date) {
        if (j.p(date).equals(this.f1742a)) {
            int day = this.f1742a.t(date);
            o((TextView) monthGrid.getChildAt(monthGrid.getAdapter().a(day) - monthGrid.getFirstVisiblePosition()), date, day);
        }
    }

    private void o(TextView dayTextView, long date, int dayNumber) {
        b style;
        if (dayTextView != null) {
            dayTextView.setContentDescription(c(dayTextView.getContext(), date));
            if (this.f1740a.r().g(date)) {
                dayTextView.setEnabled(true);
                boolean selected = j(date);
                dayTextView.setSelected(selected);
                if (selected) {
                    style = this.f1741a.b;
                } else if (l(date)) {
                    style = this.f1741a.c;
                } else {
                    style = this.f1741a.f1685a;
                }
            } else {
                dayTextView.setEnabled(false);
                style = this.f1741a.g;
            }
            style.d(dayTextView);
        }
    }

    private String c(Context context, long date) {
        return d.a(context, date, l(date), k(date), g(date));
    }

    private boolean l(long date) {
        return p.i().getTimeInMillis() == date;
    }

    /* access modifiers changed from: package-private */
    public boolean k(long date) {
        for (Pair<Long, Long> range : this.f1744a.c()) {
            F f = range.first;
            if (f != null && ((Long) f).longValue() == date) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean g(long date) {
        for (Pair<Long, Long> range : this.f1744a.c()) {
            S s = range.second;
            if (s != null && ((Long) s).longValue() == date) {
                return true;
            }
        }
        return false;
    }

    private boolean j(long date) {
        for (Long longValue : this.f1744a.h()) {
            if (p.a(date) == p.a(longValue.longValue())) {
                return true;
            }
        }
        return false;
    }

    private void f(Context context) {
        if (this.f1741a == null) {
            this.f1741a = new c(context);
        }
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f1742a.r(this.f1740a.t());
    }

    /* access modifiers changed from: package-private */
    public int m() {
        return (b() + this.f1742a.d) - 1;
    }

    /* access modifiers changed from: package-private */
    public int n(int position) {
        return (position - b()) + 1;
    }

    /* access modifiers changed from: package-private */
    public int a(int day) {
        return b() + (day - 1);
    }

    /* access modifiers changed from: package-private */
    public boolean r(int position) {
        return position >= b() && position <= m();
    }

    /* access modifiers changed from: package-private */
    public boolean h(int position) {
        return position % this.f1742a.c == 0;
    }

    /* access modifiers changed from: package-private */
    public boolean i(int position) {
        return (position + 1) % this.f1742a.c == 0;
    }
}
