package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.g;
import java.util.Calendar;
import java.util.Locale;

class q extends RecyclerView.Adapter<b> {
    /* access modifiers changed from: private */
    public final g<?> a;

    public static class b extends RecyclerView.ViewHolder {
        final TextView a;

        b(TextView view) {
            super(view);
            this.a = view;
        }
    }

    q(g<?> materialCalendar) {
        this.a = materialCalendar;
    }

    /* renamed from: f */
    public b onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new b((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(nc0.mtrl_calendar_year, viewGroup, false));
    }

    /* renamed from: e */
    public void onBindViewHolder(b viewHolder, int position) {
        int year = d(position);
        viewHolder.a.setText(String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(year)}));
        TextView textView = viewHolder.a;
        textView.setContentDescription(d.e(textView.getContext(), year));
        c styles = this.a.u();
        Calendar calendar = p.i();
        b style = calendar.get(1) == year ? styles.f : styles.d;
        for (Long day : this.a.w().h()) {
            calendar.setTimeInMillis(day.longValue());
            if (calendar.get(1) == year) {
                style = styles.e;
            }
        }
        style.d(viewHolder.a);
        viewHolder.a.setOnClickListener(b(year));
    }

    class a implements View.OnClickListener {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        public void onClick(View view) {
            q.this.a.C(q.this.a.t().q(j.o(this.a, q.this.a.v().a)));
            q.this.a.D(g.l.DAY);
        }
    }

    private View.OnClickListener b(int year) {
        return new a(year);
    }

    public int getItemCount() {
        return this.a.t().x();
    }

    /* access modifiers changed from: package-private */
    public int c(int year) {
        return year - this.a.t().w().b;
    }

    /* access modifiers changed from: package-private */
    public int d(int position) {
        return this.a.t().w().b + position;
    }
}
