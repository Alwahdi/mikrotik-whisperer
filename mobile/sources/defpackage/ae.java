package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/* renamed from: ae  reason: default package */
public class ae extends ArrayAdapter<UsermanagerCards> {
    Context a;

    /* renamed from: a  reason: collision with other field name */
    Filter f48a = new b();

    /* renamed from: a  reason: collision with other field name */
    ArrayList<UsermanagerCards> f49a;
    ArrayList<UsermanagerCards> b;
    ArrayList<UsermanagerCards> c;

    public ae(Context context, ArrayList<UsermanagerCards> objects) {
        super(context, R.layout.customer_row, objects);
        this.f49a = objects;
        this.a = context;
        this.b = new ArrayList<>(objects);
        this.c = new ArrayList<>(objects);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View convertView2;
        c holder;
        String formatted;
        int i = position;
        try {
            UsermanagerCards customer = (UsermanagerCards) getItem(position);
            ((DecimalFormat) NumberFormat.getNumberInstance(Locale.ENGLISH)).applyPattern("#.##");
            if (convertView == null) {
                convertView2 = LayoutInflater.from(getContext()).inflate(R.layout.customer_row, (ViewGroup) null);
                try {
                    holder = new c();
                    holder.a = i;
                    holder.f54a = (TextView) convertView2.findViewById(R.id.uname);
                    holder.f55b = (TextView) convertView2.findViewById(R.id.profile);
                    holder.c = (TextView) convertView2.findViewById(R.id.uptime);
                    holder.d = (TextView) convertView2.findViewById(R.id.download);
                    holder.e = (TextView) convertView2.findViewById(R.id.upload);
                    holder.f52a = (CheckBox) convertView2.findViewById(R.id.isselected);
                    holder.f53a = (LinearLayout) convertView2.findViewById(R.id.title);
                    holder.b = (LinearLayout) convertView2.findViewById(R.id.data_layout);
                    convertView2.setTag(holder);
                } catch (Exception e) {
                    e = e;
                }
            } else {
                holder = (c) convertView.getTag();
                convertView2 = convertView;
            }
            if (i < 1) {
                holder.f53a.setVisibility(0);
            } else {
                holder.f53a.setVisibility(8);
            }
            if (customer.isDisabled()) {
                holder.b.setBackgroundResource(R.color.md_cell_line_color);
                holder.f54a.setTextColor(this.a.getResources().getColor(R.color.mainColorDark));
                holder.f55b.setTextColor(this.a.getResources().getColor(R.color.mainColorDark));
                holder.c.setTextColor(this.a.getResources().getColor(R.color.mainColorDark));
                holder.d.setTextColor(this.a.getResources().getColor(R.color.mainColorDark));
                holder.e.setTextColor(this.a.getResources().getColor(R.color.mainColorDark));
            } else {
                holder.b.setBackgroundResource(R.color.white);
                holder.f54a.setTextColor(this.a.getResources().getColor(R.color.black));
                holder.f55b.setTextColor(this.a.getResources().getColor(R.color.black));
                holder.c.setTextColor(this.a.getResources().getColor(R.color.black));
                holder.d.setTextColor(this.a.getResources().getColor(R.color.black));
                holder.e.setTextColor(this.a.getResources().getColor(R.color.black));
            }
            String formatted2 = "0";
            if (customer.getDownload_used() != null) {
                formatted = qb0.e(customer.getDownload_used());
            } else {
                formatted = formatted2;
            }
            if (customer.getUpload_used() != null) {
                formatted2 = qb0.e(customer.getUpload_used());
            }
            holder.f54a.setText(customer.getUname());
            holder.f55b.setText(customer.getProfilename());
            if (customer.getUptime_used() == null) {
                holder.c.setText(" 0 ");
            } else {
                holder.c.setText(customer.getUptime_used());
            }
            holder.d.setText(formatted);
            holder.e.setText(formatted2);
            holder.f52a.setChecked(customer.isSelected());
            holder.f52a.setTag(this.f49a.get(i));
            holder.f52a.setOnClickListener(new a(i));
        } catch (Exception e2) {
            e = e2;
            convertView2 = convertView;
            e.printStackTrace();
            Toast.makeText(this.a, e.getMessage(), 0).show();
            return convertView2;
        }
        return convertView2;
    }

    /* renamed from: ae$a */
    class a implements View.OnClickListener {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        public void onClick(View v) {
            CheckBox cb = (CheckBox) v;
            ((UsermanagerCards) cb.getTag()).setSelected(cb.isChecked());
            ae.this.f49a.get(this.a).setSelected(cb.isChecked());
        }
    }

    public Filter getFilter() {
        return this.f48a;
    }

    /* renamed from: ae$b */
    class b extends Filter {
        b() {
        }

        public CharSequence convertResultToString(Object resultValue) {
            return ((UsermanagerCards) resultValue).getProfilename();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.widget.Filter.FilterResults performFiltering(java.lang.CharSequence r10) {
            /*
                r9 = this;
                if (r10 == 0) goto L_0x01a9
                ae r0 = defpackage.ae.this     // Catch:{ Exception -> 0x01af }
                java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards> r0 = r0.c     // Catch:{ Exception -> 0x01af }
                r0.clear()     // Catch:{ Exception -> 0x01af }
                java.lang.String r0 = defpackage.qb0.h     // Catch:{ Exception -> 0x01af }
                java.lang.String r1 = "username"
                boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x01af }
                r1 = 2
                r2 = 0
                r3 = 1
                java.lang.String r4 = "all"
                r5 = -1
                java.lang.String r6 = "unused_card"
                java.lang.String r7 = "used_card"
                if (r0 == 0) goto L_0x00ae
                java.lang.String r0 = defpackage.qb0.i     // Catch:{ Exception -> 0x01af }
                int r8 = r0.hashCode()     // Catch:{ Exception -> 0x01af }
                switch(r8) {
                    case -61794734: goto L_0x0036;
                    case 96673: goto L_0x002e;
                    case 6644697: goto L_0x0027;
                    default: goto L_0x0026;
                }     // Catch:{ Exception -> 0x01af }
            L_0x0026:
                goto L_0x003e
            L_0x0027:
                boolean r0 = r0.equals(r6)     // Catch:{ Exception -> 0x01af }
                if (r0 == 0) goto L_0x0026
                goto L_0x003f
            L_0x002e:
                boolean r0 = r0.equals(r4)     // Catch:{ Exception -> 0x01af }
                if (r0 == 0) goto L_0x0026
                r1 = 0
                goto L_0x003f
            L_0x0036:
                boolean r0 = r0.equals(r7)     // Catch:{ Exception -> 0x01af }
                if (r0 == 0) goto L_0x0026
                r1 = 1
                goto L_0x003f
            L_0x003e:
                r1 = -1
            L_0x003f:
                switch(r1) {
                    case 0: goto L_0x0089;
                    case 1: goto L_0x0066;
                    case 2: goto L_0x0043;
                    default: goto L_0x0042;
                }     // Catch:{ Exception -> 0x01af }
            L_0x0042:
                goto L_0x00ac
            L_0x0043:
                ae r0 = defpackage.ae.this     // Catch:{ Exception -> 0x01af }
                java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards> r0 = r0.b     // Catch:{ Exception -> 0x01af }
                ln0 r0 = defpackage.ln0.U(r0)     // Catch:{ Exception -> 0x01af }
                be r1 = new be     // Catch:{ Exception -> 0x01af }
                r1.<init>(r10)     // Catch:{ Exception -> 0x01af }
                ln0 r0 = r0.q(r1)     // Catch:{ Exception -> 0x01af }
                u9 r1 = defpackage.v9.d()     // Catch:{ Exception -> 0x01af }
                java.lang.Object r0 = r0.f(r1)     // Catch:{ Exception -> 0x01af }
                java.util.List r0 = (java.util.List) r0     // Catch:{ Exception -> 0x01af }
                ae r1 = defpackage.ae.this     // Catch:{ Exception -> 0x01af }
                r2 = r0
                java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ Exception -> 0x01af }
                r1.c = r2     // Catch:{ Exception -> 0x01af }
                goto L_0x00ac
            L_0x0066:
                ae r0 = defpackage.ae.this     // Catch:{ Exception -> 0x01af }
                java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards> r0 = r0.b     // Catch:{ Exception -> 0x01af }
                ln0 r0 = defpackage.ln0.U(r0)     // Catch:{ Exception -> 0x01af }
                ce r1 = new ce     // Catch:{ Exception -> 0x01af }
                r1.<init>(r10)     // Catch:{ Exception -> 0x01af }
                ln0 r0 = r0.q(r1)     // Catch:{ Exception -> 0x01af }
                u9 r1 = defpackage.v9.d()     // Catch:{ Exception -> 0x01af }
                java.lang.Object r0 = r0.f(r1)     // Catch:{ Exception -> 0x01af }
                java.util.List r0 = (java.util.List) r0     // Catch:{ Exception -> 0x01af }
                ae r1 = defpackage.ae.this     // Catch:{ Exception -> 0x01af }
                r2 = r0
                java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ Exception -> 0x01af }
                r1.c = r2     // Catch:{ Exception -> 0x01af }
                goto L_0x00ac
            L_0x0089:
                ae r0 = defpackage.ae.this     // Catch:{ Exception -> 0x01af }
                java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards> r0 = r0.b     // Catch:{ Exception -> 0x01af }
                ln0 r0 = defpackage.ln0.U(r0)     // Catch:{ Exception -> 0x01af }
                de r1 = new de     // Catch:{ Exception -> 0x01af }
                r1.<init>(r10)     // Catch:{ Exception -> 0x01af }
                ln0 r0 = r0.q(r1)     // Catch:{ Exception -> 0x01af }
                u9 r1 = defpackage.v9.d()     // Catch:{ Exception -> 0x01af }
                java.lang.Object r0 = r0.f(r1)     // Catch:{ Exception -> 0x01af }
                java.util.List r0 = (java.util.List) r0     // Catch:{ Exception -> 0x01af }
                ae r1 = defpackage.ae.this     // Catch:{ Exception -> 0x01af }
                r2 = r0
                java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ Exception -> 0x01af }
                r1.c = r2     // Catch:{ Exception -> 0x01af }
            L_0x00ac:
                goto L_0x0197
            L_0x00ae:
                java.lang.String r0 = defpackage.qb0.h     // Catch:{ Exception -> 0x01af }
                java.lang.String r8 = "profilename"
                boolean r0 = r0.equals(r8)     // Catch:{ Exception -> 0x01af }
                if (r0 == 0) goto L_0x0148
                java.lang.String r0 = defpackage.qb0.i     // Catch:{ Exception -> 0x01af }
                int r8 = r0.hashCode()     // Catch:{ Exception -> 0x01af }
                switch(r8) {
                    case -61794734: goto L_0x00d1;
                    case 96673: goto L_0x00c9;
                    case 6644697: goto L_0x00c2;
                    default: goto L_0x00c1;
                }     // Catch:{ Exception -> 0x01af }
            L_0x00c1:
                goto L_0x00d9
            L_0x00c2:
                boolean r0 = r0.equals(r6)     // Catch:{ Exception -> 0x01af }
                if (r0 == 0) goto L_0x00c1
                goto L_0x00da
            L_0x00c9:
                boolean r0 = r0.equals(r4)     // Catch:{ Exception -> 0x01af }
                if (r0 == 0) goto L_0x00c1
                r1 = 0
                goto L_0x00da
            L_0x00d1:
                boolean r0 = r0.equals(r7)     // Catch:{ Exception -> 0x01af }
                if (r0 == 0) goto L_0x00c1
                r1 = 1
                goto L_0x00da
            L_0x00d9:
                r1 = -1
            L_0x00da:
                switch(r1) {
                    case 0: goto L_0x0124;
                    case 1: goto L_0x0101;
                    case 2: goto L_0x00de;
                    default: goto L_0x00dd;
                }     // Catch:{ Exception -> 0x01af }
            L_0x00dd:
                goto L_0x0147
            L_0x00de:
                ae r0 = defpackage.ae.this     // Catch:{ Exception -> 0x01af }
                java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards> r0 = r0.b     // Catch:{ Exception -> 0x01af }
                ln0 r0 = defpackage.ln0.U(r0)     // Catch:{ Exception -> 0x01af }
                ee r1 = new ee     // Catch:{ Exception -> 0x01af }
                r1.<init>(r10)     // Catch:{ Exception -> 0x01af }
                ln0 r0 = r0.q(r1)     // Catch:{ Exception -> 0x01af }
                u9 r1 = defpackage.v9.d()     // Catch:{ Exception -> 0x01af }
                java.lang.Object r0 = r0.f(r1)     // Catch:{ Exception -> 0x01af }
                java.util.List r0 = (java.util.List) r0     // Catch:{ Exception -> 0x01af }
                ae r1 = defpackage.ae.this     // Catch:{ Exception -> 0x01af }
                r2 = r0
                java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ Exception -> 0x01af }
                r1.c = r2     // Catch:{ Exception -> 0x01af }
                goto L_0x0147
            L_0x0101:
                ae r0 = defpackage.ae.this     // Catch:{ Exception -> 0x01af }
                java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards> r0 = r0.b     // Catch:{ Exception -> 0x01af }
                ln0 r0 = defpackage.ln0.U(r0)     // Catch:{ Exception -> 0x01af }
                fe r1 = new fe     // Catch:{ Exception -> 0x01af }
                r1.<init>(r10)     // Catch:{ Exception -> 0x01af }
                ln0 r0 = r0.q(r1)     // Catch:{ Exception -> 0x01af }
                u9 r1 = defpackage.v9.d()     // Catch:{ Exception -> 0x01af }
                java.lang.Object r0 = r0.f(r1)     // Catch:{ Exception -> 0x01af }
                java.util.List r0 = (java.util.List) r0     // Catch:{ Exception -> 0x01af }
                ae r1 = defpackage.ae.this     // Catch:{ Exception -> 0x01af }
                r2 = r0
                java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ Exception -> 0x01af }
                r1.c = r2     // Catch:{ Exception -> 0x01af }
                goto L_0x0147
            L_0x0124:
                ae r0 = defpackage.ae.this     // Catch:{ Exception -> 0x01af }
                java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards> r0 = r0.b     // Catch:{ Exception -> 0x01af }
                ln0 r0 = defpackage.ln0.U(r0)     // Catch:{ Exception -> 0x01af }
                ge r1 = new ge     // Catch:{ Exception -> 0x01af }
                r1.<init>(r10)     // Catch:{ Exception -> 0x01af }
                ln0 r0 = r0.q(r1)     // Catch:{ Exception -> 0x01af }
                u9 r1 = defpackage.v9.d()     // Catch:{ Exception -> 0x01af }
                java.lang.Object r0 = r0.f(r1)     // Catch:{ Exception -> 0x01af }
                java.util.List r0 = (java.util.List) r0     // Catch:{ Exception -> 0x01af }
                ae r1 = defpackage.ae.this     // Catch:{ Exception -> 0x01af }
                r2 = r0
                java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ Exception -> 0x01af }
                r1.c = r2     // Catch:{ Exception -> 0x01af }
            L_0x0147:
                goto L_0x0197
            L_0x0148:
                java.lang.String r0 = defpackage.qb0.i     // Catch:{ Exception -> 0x01af }
                boolean r0 = r0.equals(r7)     // Catch:{ Exception -> 0x01af }
                if (r0 == 0) goto L_0x0170
                ae r0 = defpackage.ae.this     // Catch:{ Exception -> 0x01af }
                java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards> r0 = r0.b     // Catch:{ Exception -> 0x01af }
                ln0 r0 = defpackage.ln0.U(r0)     // Catch:{ Exception -> 0x01af }
                ie r1 = defpackage.ie.a     // Catch:{ Exception -> 0x01af }
                ln0 r0 = r0.q(r1)     // Catch:{ Exception -> 0x01af }
                u9 r1 = defpackage.v9.d()     // Catch:{ Exception -> 0x01af }
                java.lang.Object r0 = r0.f(r1)     // Catch:{ Exception -> 0x01af }
                java.util.List r0 = (java.util.List) r0     // Catch:{ Exception -> 0x01af }
                ae r1 = defpackage.ae.this     // Catch:{ Exception -> 0x01af }
                r2 = r0
                java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ Exception -> 0x01af }
                r1.c = r2     // Catch:{ Exception -> 0x01af }
                goto L_0x0197
            L_0x0170:
                java.lang.String r0 = defpackage.qb0.i     // Catch:{ Exception -> 0x01af }
                boolean r0 = r0.equals(r6)     // Catch:{ Exception -> 0x01af }
                if (r0 == 0) goto L_0x0197
                ae r0 = defpackage.ae.this     // Catch:{ Exception -> 0x01af }
                java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards> r0 = r0.b     // Catch:{ Exception -> 0x01af }
                ln0 r0 = defpackage.ln0.U(r0)     // Catch:{ Exception -> 0x01af }
                he r1 = defpackage.he.a     // Catch:{ Exception -> 0x01af }
                ln0 r0 = r0.q(r1)     // Catch:{ Exception -> 0x01af }
                u9 r1 = defpackage.v9.d()     // Catch:{ Exception -> 0x01af }
                java.lang.Object r0 = r0.f(r1)     // Catch:{ Exception -> 0x01af }
                java.util.List r0 = (java.util.List) r0     // Catch:{ Exception -> 0x01af }
                ae r1 = defpackage.ae.this     // Catch:{ Exception -> 0x01af }
                r2 = r0
                java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ Exception -> 0x01af }
                r1.c = r2     // Catch:{ Exception -> 0x01af }
            L_0x0197:
                android.widget.Filter$FilterResults r0 = new android.widget.Filter$FilterResults     // Catch:{ Exception -> 0x01af }
                r0.<init>()     // Catch:{ Exception -> 0x01af }
                ae r1 = defpackage.ae.this     // Catch:{ Exception -> 0x01af }
                java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards> r1 = r1.c     // Catch:{ Exception -> 0x01af }
                r0.values = r1     // Catch:{ Exception -> 0x01af }
                int r1 = r1.size()     // Catch:{ Exception -> 0x01af }
                r0.count = r1     // Catch:{ Exception -> 0x01af }
                return r0
            L_0x01a9:
                android.widget.Filter$FilterResults r0 = new android.widget.Filter$FilterResults     // Catch:{ Exception -> 0x01af }
                r0.<init>()     // Catch:{ Exception -> 0x01af }
                return r0
            L_0x01af:
                r0 = move-exception
                r0.printStackTrace()
                android.widget.Filter$FilterResults r1 = new android.widget.Filter$FilterResults
                r1.<init>()
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.ae.b.performFiltering(java.lang.CharSequence):android.widget.Filter$FilterResults");
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean j(CharSequence constraint, UsermanagerCards c) {
            return !c.getLast_seen().toLowerCase().equalsIgnoreCase("never") && !c.getLast_seen().toLowerCase().equalsIgnoreCase("waiting") && c.getUname().toLowerCase().startsWith(constraint.toString().toLowerCase());
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean k(CharSequence constraint, UsermanagerCards c) {
            return (c.getLast_seen().toLowerCase().equalsIgnoreCase("never") || c.getLast_seen().toLowerCase().equalsIgnoreCase("waiting")) && c.getUname().toLowerCase().startsWith(constraint.toString().toLowerCase());
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean m(CharSequence constraint, UsermanagerCards c) {
            return !c.getLast_seen().toLowerCase().equalsIgnoreCase("never") && !c.getLast_seen().toLowerCase().equalsIgnoreCase("waiting") && c.getProfilename().toLowerCase().equals(constraint.toString().toLowerCase());
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean n(CharSequence constraint, UsermanagerCards c) {
            return (c.getLast_seen().toLowerCase().equalsIgnoreCase("never") || c.getLast_seen().toLowerCase().equalsIgnoreCase("waiting")) && c.getProfilename().toLowerCase().equals(constraint.toString().toLowerCase());
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean o(UsermanagerCards c) {
            return !c.getLast_seen().toLowerCase().equalsIgnoreCase("never") && !c.getLast_seen().toLowerCase().equalsIgnoreCase("waiting");
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean p(UsermanagerCards c) {
            return c.getLast_seen().toLowerCase().equalsIgnoreCase("never") || c.getLast_seen().toLowerCase().equalsIgnoreCase("waiting");
        }

        /* access modifiers changed from: protected */
        public void publishResults(CharSequence constraint, Filter.FilterResults results) {
            ArrayList<UsermanagerCards> usermanagerCards = (ArrayList) results.values;
            if (results.count > 0) {
                ae.this.clear();
                for (int i = 0; i < usermanagerCards.size(); i++) {
                    ae.this.f49a.add(usermanagerCards.get(i));
                    ae.this.notifyDataSetChanged();
                }
                return;
            }
            ae.this.clear();
            ae.this.notifyDataSetChanged();
        }
    }

    /* renamed from: ae$c */
    public class c {
        int a;

        /* renamed from: a  reason: collision with other field name */
        CheckBox f52a;

        /* renamed from: a  reason: collision with other field name */
        LinearLayout f53a;

        /* renamed from: a  reason: collision with other field name */
        TextView f54a;
        LinearLayout b;

        /* renamed from: b  reason: collision with other field name */
        TextView f55b;
        TextView c;
        TextView d;
        TextView e;

        public c() {
        }
    }
}
