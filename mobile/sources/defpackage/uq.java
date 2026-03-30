package defpackage;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard;
import java.util.ArrayList;

/* renamed from: uq  reason: default package */
public class uq extends ArrayAdapter<HotspotCard> {
    Context a;

    /* renamed from: a  reason: collision with other field name */
    private SparseBooleanArray f5253a;

    /* renamed from: a  reason: collision with other field name */
    Filter f5254a = new b();

    /* renamed from: a  reason: collision with other field name */
    ArrayList<HotspotCard> f5255a;
    ArrayList<HotspotCard> b;
    ArrayList<HotspotCard> c;

    public uq(Context context, ArrayList<HotspotCard> objects) {
        super(context, R.layout.customer_row_hotspot, objects);
        this.a = context;
        this.f5255a = objects;
        this.b = new ArrayList<>(objects);
        this.c = new ArrayList<>(objects);
        this.f5253a = new SparseBooleanArray();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: uq$c} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r31, android.view.View r32, android.view.ViewGroup r33) {
        /*
            r30 = this;
            r0 = r30
            r1 = r31
            java.lang.Object r2 = r30.getItem(r31)
            com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard r2 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard) r2
            r3 = 0
            r5 = 0
            r7 = 0
            r9 = 0
            r11 = 0
            r13 = r31
            java.util.Locale r14 = java.util.Locale.ENGLISH
            java.text.NumberFormat r14 = java.text.NumberFormat.getNumberInstance(r14)
            r15 = r14
            java.text.DecimalFormat r15 = (java.text.DecimalFormat) r15
            r16 = r3
            java.lang.String r3 = "#.##"
            r15.applyPattern(r3)
            if (r32 != 0) goto L_0x00b3
            android.content.Context r3 = r30.getContext()
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            r4 = 2131492920(0x7f0c0038, float:1.8609306E38)
            r18 = r5
            r5 = 0
            android.view.View r3 = r3.inflate(r4, r5)
            uq$c r4 = new uq$c
            r4.<init>()
            r4.a = r1
            r5 = 2131297127(0x7f090367, float:1.821219E38)
            android.view.View r5 = r3.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r4.f5259a = r5
            r5 = 2131296874(0x7f09026a, float:1.8211677E38)
            android.view.View r5 = r3.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r4.f5261b = r5
            r5 = 2131297140(0x7f090374, float:1.8212217E38)
            android.view.View r5 = r3.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r4.c = r5
            r5 = 2131297141(0x7f090375, float:1.8212219E38)
            android.view.View r5 = r3.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r4.d = r5
            r5 = 2131296526(0x7f09010e, float:1.8210971E38)
            android.view.View r5 = r3.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r4.e = r5
            r5 = 2131297139(0x7f090373, float:1.8212214E38)
            android.view.View r5 = r3.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r4.f = r5
            r5 = 2131296447(0x7f0900bf, float:1.821081E38)
            android.view.View r5 = r3.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r4.g = r5
            r5 = 2131296491(0x7f0900eb, float:1.82109E38)
            android.view.View r5 = r3.findViewById(r5)
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            r4.b = r5
            r5 = 2131297087(0x7f09033f, float:1.821211E38)
            android.view.View r5 = r3.findViewById(r5)
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            r4.f5258a = r5
            r5 = 2131296661(0x7f090195, float:1.8211245E38)
            android.view.View r5 = r3.findViewById(r5)
            android.widget.CheckBox r5 = (android.widget.CheckBox) r5
            r4.f5257a = r5
            r3.setTag(r4)
            goto L_0x00be
        L_0x00b3:
            r18 = r5
            java.lang.Object r3 = r32.getTag()
            r4 = r3
            uq$c r4 = (defpackage.uq.c) r4
            r3 = r32
        L_0x00be:
            r5 = 1
            r6 = 0
            if (r1 >= r5) goto L_0x00c8
            android.widget.LinearLayout r5 = r4.f5258a
            r5.setVisibility(r6)
            goto L_0x00cf
        L_0x00c8:
            android.widget.LinearLayout r5 = r4.f5258a
            r6 = 8
            r5.setVisibility(r6)
        L_0x00cf:
            java.lang.String r5 = r2.getDownload_used()
            if (r5 == 0) goto L_0x00de
            java.lang.String r5 = r2.getDownload_used()
            double r5 = java.lang.Double.parseDouble(r5)
            goto L_0x00e0
        L_0x00de:
            r5 = 0
        L_0x00e0:
            java.lang.String r7 = r2.getUpload_used()
            if (r7 == 0) goto L_0x00ef
            java.lang.String r7 = r2.getUpload_used()
            double r7 = java.lang.Double.parseDouble(r7)
            goto L_0x00f1
        L_0x00ef:
            r7 = 0
        L_0x00f1:
            double r9 = r5 + r7
            java.lang.String r11 = " جيجا"
            java.lang.String r12 = " ميجا"
            r22 = 4697254411347427328(0x4130000000000000, double:1048576.0)
            r24 = 4652218415073722368(0x4090000000000000, double:1024.0)
            r20 = 0
            int r26 = (r9 > r20 ? 1 : (r9 == r20 ? 0 : -1))
            if (r26 == 0) goto L_0x0139
            r20 = r5
            double r5 = r9 / r22
            r26 = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = r15.format(r5)
            r7.append(r8)
            r7.append(r12)
            java.lang.String r7 = r7.toString()
            int r8 = (r5 > r24 ? 1 : (r5 == r24 ? 0 : -1))
            if (r8 <= 0) goto L_0x0136
            double r5 = r5 / r24
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r16 = r7
            java.lang.String r7 = r15.format(r5)
            r8.append(r7)
            r8.append(r11)
            java.lang.String r7 = r8.toString()
            goto L_0x0141
        L_0x0136:
            r16 = r7
            goto L_0x0141
        L_0x0139:
            r20 = r5
            r26 = r7
            java.lang.String r7 = "0"
            r5 = r16
        L_0x0141:
            java.lang.String r8 = r2.getLimitBytesTotal()
            if (r8 == 0) goto L_0x0182
            java.lang.String r8 = r2.getLimitBytesTotal()
            double r16 = java.lang.Double.parseDouble(r8)
            r28 = r5
            double r5 = r16 / r22
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r16 = r9
            java.lang.String r9 = r15.format(r5)
            r8.append(r9)
            r8.append(r12)
            java.lang.String r8 = r8.toString()
            int r9 = (r5 > r24 ? 1 : (r5 == r24 ? 0 : -1))
            if (r9 <= 0) goto L_0x018a
            double r5 = r5 / r24
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = r15.format(r5)
            r9.append(r10)
            r9.append(r11)
            java.lang.String r8 = r9.toString()
            goto L_0x018a
        L_0x0182:
            r28 = r5
            r16 = r9
            java.lang.String r8 = "غير محدود"
            r5 = r18
        L_0x018a:
            android.widget.TextView r9 = r4.f5259a
            java.lang.String r10 = r2.getUname()
            r9.setText(r10)
            android.widget.TextView r9 = r4.f5261b
            java.lang.String r10 = r2.getProfilename()
            r9.setText(r10)
            android.widget.TextView r9 = r4.c
            java.lang.String r10 = r2.getUptime_used()
            r9.setText(r10)
            android.widget.TextView r9 = r4.g
            java.lang.String r10 = r2.getComment()
            r9.setText(r10)
            android.widget.TextView r9 = r4.d
            java.lang.String r10 = r2.getLimitUptime()
            r9.setText(r10)
            android.widget.TextView r9 = r4.e
            r9.setText(r7)
            android.widget.TextView r9 = r4.f
            r9.setText(r8)
            android.widget.CheckBox r9 = r4.f5257a
            boolean r10 = r2.isSelected()
            r9.setChecked(r10)
            android.widget.CheckBox r9 = r4.f5257a
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard> r10 = r0.f5255a
            java.lang.Object r10 = r10.get(r1)
            r9.setTag(r10)
            android.widget.CheckBox r9 = r4.f5257a
            uq$a r10 = new uq$a
            r10.<init>(r13)
            r9.setOnClickListener(r10)
            boolean r9 = r2.getDisabled()
            if (r9 == 0) goto L_0x023c
            android.widget.LinearLayout r9 = r4.b
            r10 = 2131100403(0x7f0602f3, float:1.7813186E38)
            r9.setBackgroundResource(r10)
            android.widget.TextView r9 = r4.f5259a
            android.content.Context r10 = r0.a
            android.content.res.Resources r10 = r10.getResources()
            r11 = 2131100234(0x7f06024a, float:1.7812844E38)
            int r10 = r10.getColor(r11)
            r9.setTextColor(r10)
            android.widget.TextView r9 = r4.f5261b
            android.content.Context r10 = r0.a
            android.content.res.Resources r10 = r10.getResources()
            int r10 = r10.getColor(r11)
            r9.setTextColor(r10)
            android.widget.TextView r9 = r4.c
            android.content.Context r10 = r0.a
            android.content.res.Resources r10 = r10.getResources()
            int r10 = r10.getColor(r11)
            r9.setTextColor(r10)
            android.widget.TextView r9 = r4.e
            android.content.Context r10 = r0.a
            android.content.res.Resources r10 = r10.getResources()
            int r10 = r10.getColor(r11)
            r9.setTextColor(r10)
            android.widget.TextView r9 = r4.f
            android.content.Context r10 = r0.a
            android.content.res.Resources r10 = r10.getResources()
            int r10 = r10.getColor(r11)
            r9.setTextColor(r10)
            goto L_0x0292
        L_0x023c:
            android.widget.LinearLayout r9 = r4.b
            r10 = 2131100550(0x7f060386, float:1.7813485E38)
            r9.setBackgroundResource(r10)
            android.widget.TextView r9 = r4.f5259a
            android.content.Context r10 = r0.a
            android.content.res.Resources r10 = r10.getResources()
            r11 = 2131099686(0x7f060026, float:1.7811732E38)
            int r10 = r10.getColor(r11)
            r9.setTextColor(r10)
            android.widget.TextView r9 = r4.f5261b
            android.content.Context r10 = r0.a
            android.content.res.Resources r10 = r10.getResources()
            int r10 = r10.getColor(r11)
            r9.setTextColor(r10)
            android.widget.TextView r9 = r4.c
            android.content.Context r10 = r0.a
            android.content.res.Resources r10 = r10.getResources()
            int r10 = r10.getColor(r11)
            r9.setTextColor(r10)
            android.widget.TextView r9 = r4.e
            android.content.Context r10 = r0.a
            android.content.res.Resources r10 = r10.getResources()
            int r10 = r10.getColor(r11)
            r9.setTextColor(r10)
            android.widget.TextView r9 = r4.f
            android.content.Context r10 = r0.a
            android.content.res.Resources r10 = r10.getResources()
            int r10 = r10.getColor(r11)
            r9.setTextColor(r10)
        L_0x0292:
            android.util.SparseBooleanArray r9 = r0.f5253a
            boolean r9 = r9.get(r1)
            if (r9 == 0) goto L_0x029f
            r9 = -1724598812(0xffffffff9934b5e4, float:-9.3425144E-24)
            goto L_0x02a0
        L_0x029f:
            r9 = 0
        L_0x02a0:
            r3.setBackgroundColor(r9)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uq.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    /* renamed from: uq$a */
    class a implements View.OnClickListener {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        public void onClick(View v) {
            CheckBox cb = (CheckBox) v;
            ((HotspotCard) cb.getTag()).setSelected(cb.isChecked());
            uq.this.f5255a.get(this.a).setSelected(cb.isChecked());
        }
    }

    public Filter getFilter() {
        return this.f5254a;
    }

    /* renamed from: uq$b */
    class b extends Filter {
        b() {
        }

        public CharSequence convertResultToString(Object resultValue) {
            HotspotCard customer = (HotspotCard) resultValue;
            return customer.getUname() + " " + customer.getProfilename();
        }

        /* access modifiers changed from: protected */
        public Filter.FilterResults performFiltering(CharSequence constraint) {
            if (constraint == null) {
                return new Filter.FilterResults();
            }
            uq.this.c.clear();
            for (int i = 0; i < uq.this.b.size(); i++) {
                String str = qb0.i;
                char c = 65535;
                switch (str.hashCode()) {
                    case -61794734:
                        if (str.equals("used_card")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 96673:
                        if (str.equals("all")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 6644697:
                        if (str.equals("unused_card")) {
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        if (!uq.this.b.get(i).getUname().toLowerCase().startsWith(constraint.toString().toLowerCase())) {
                            break;
                        } else {
                            uq.this.c.add(uq.this.b.get(i));
                            break;
                        }
                    case 1:
                        if (!uq.this.b.get(i).getUptime_used().toLowerCase().equalsIgnoreCase("0s") && uq.this.b.get(i).getUname().toLowerCase().startsWith(constraint.toString().toLowerCase())) {
                            uq.this.c.add(uq.this.b.get(i));
                            break;
                        }
                    case 2:
                        if (uq.this.b.get(i).getUptime_used().toLowerCase().equalsIgnoreCase("0s") && uq.this.b.get(i).getUname().toLowerCase().startsWith(constraint.toString().toLowerCase())) {
                            uq.this.c.add(uq.this.b.get(i));
                            break;
                        }
                }
            }
            Filter.FilterResults filterResults = new Filter.FilterResults();
            ArrayList<HotspotCard> arrayList = uq.this.c;
            filterResults.values = arrayList;
            filterResults.count = arrayList.size();
            return filterResults;
        }

        /* access modifiers changed from: protected */
        public void publishResults(CharSequence constraint, Filter.FilterResults results) {
            ArrayList<HotspotCard> hotspotCards = (ArrayList) results.values;
            if (results.count > 0) {
                uq.this.clear();
                for (int i = 0; i < hotspotCards.size(); i++) {
                    uq.this.f5255a.add(hotspotCards.get(i));
                    uq.this.notifyDataSetChanged();
                }
                return;
            }
            uq.this.clear();
            uq.this.notifyDataSetChanged();
        }
    }

    /* renamed from: uq$c */
    public class c {
        int a;

        /* renamed from: a  reason: collision with other field name */
        CheckBox f5257a;

        /* renamed from: a  reason: collision with other field name */
        LinearLayout f5258a;

        /* renamed from: a  reason: collision with other field name */
        TextView f5259a;
        LinearLayout b;

        /* renamed from: b  reason: collision with other field name */
        TextView f5261b;
        TextView c;
        TextView d;
        TextView e;
        TextView f;
        TextView g;

        public c() {
        }
    }
}
