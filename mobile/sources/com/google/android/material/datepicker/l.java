package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.g;

class l extends RecyclerView.Adapter<b> {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final a f1745a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final g.m f1746a;

    /* renamed from: a  reason: collision with other field name */
    private final xe<?> f1747a;

    /* renamed from: a  reason: collision with other field name */
    private final ye f1748a;

    l(Context context, xe<?> dateSelector, a calendarConstraints, ye dayViewDecorator, g.m onDayClickListener) {
        j firstPage = calendarConstraints.w();
        j lastPage = calendarConstraints.s();
        j currentPage = calendarConstraints.v();
        if (firstPage.compareTo(currentPage) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        } else if (currentPage.compareTo(lastPage) <= 0) {
            this.a = (k.a * g.x(context)) + (h.x(context) ? g.x(context) : 0);
            this.f1745a = calendarConstraints;
            this.f1747a = dateSelector;
            this.f1746a = onDayClickListener;
            setHasStableIds(true);
        } else {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
    }

    public static class b extends RecyclerView.ViewHolder {
        final TextView a;

        /* renamed from: a  reason: collision with other field name */
        final MaterialCalendarGridView f1750a;

        b(LinearLayout container, boolean showLabel) {
            super(container);
            TextView textView = (TextView) container.findViewById(ic0.month_title);
            this.a = textView;
            ViewCompat.setAccessibilityHeading(textView, true);
            this.f1750a = (MaterialCalendarGridView) container.findViewById(ic0.month_grid);
            if (!showLabel) {
                textView.setVisibility(8);
            }
        }
    }

    /* renamed from: f */
    public b onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LinearLayout container = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(nc0.mtrl_calendar_month_labeled, viewGroup, false);
        if (!h.x(viewGroup.getContext())) {
            return new b(container, false);
        }
        container.setLayoutParams(new RecyclerView.LayoutParams(-1, this.a));
        return new b(container, true);
    }

    /* renamed from: e */
    public void onBindViewHolder(b viewHolder, int position) {
        j month = this.f1745a.w().w(position);
        viewHolder.a.setText(month.u());
        MaterialCalendarGridView monthGrid = (MaterialCalendarGridView) viewHolder.f1750a.findViewById(ic0.month_grid);
        if (monthGrid.getAdapter() == null || !month.equals(monthGrid.getAdapter().f1742a)) {
            k monthAdapter = new k(month, this.f1747a, this.f1745a, this.f1748a);
            monthGrid.setNumColumns(month.c);
            monthGrid.setAdapter((ListAdapter) monthAdapter);
        } else {
            monthGrid.invalidate();
            monthGrid.getAdapter().q(monthGrid);
        }
        monthGrid.setOnItemClickListener(new a(monthGrid));
    }

    class a implements AdapterView.OnItemClickListener {
        final /* synthetic */ MaterialCalendarGridView a;

        a(MaterialCalendarGridView materialCalendarGridView) {
            this.a = materialCalendarGridView;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            if (this.a.getAdapter().r(position)) {
                l.this.f1746a.a(this.a.getAdapter().getItem(position).longValue());
            }
        }
    }

    public long getItemId(int position) {
        return this.f1745a.w().w(position).v();
    }

    public int getItemCount() {
        return this.f1745a.u();
    }

    /* access modifiers changed from: package-private */
    public CharSequence c(int position) {
        return b(position).u();
    }

    /* access modifiers changed from: package-private */
    public j b(int position) {
        return this.f1745a.w().w(position);
    }

    /* access modifiers changed from: package-private */
    public int d(j month) {
        return this.f1745a.w().x(month);
    }
}
