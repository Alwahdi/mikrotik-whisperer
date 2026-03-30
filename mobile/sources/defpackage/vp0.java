package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel;
import com.blogspot.yemeninfo4it.mumsmobile_app.tableview.model.ColumnHeader;
import com.blogspot.yemeninfo4it.mumsmobile_app.tableview.model.RowHeader;
import java.util.ArrayList;
import java.util.List;

/* renamed from: vp0  reason: default package */
public class vp0 {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private final Drawable f5404a;

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<ProfileModel> f5405a;

    /* renamed from: a  reason: collision with other field name */
    ue f5406a;
    private final Drawable b;
    private final Drawable c;
    private final Drawable d;

    public vp0(Context context, ArrayList<ProfileModel> profileModels) {
        this.a = context;
        this.f5406a = new ue(context);
        this.f5405a = profileModels;
        this.f5404a = ContextCompat.getDrawable(context, R.drawable.ic_plus);
        this.b = ContextCompat.getDrawable(context, R.drawable.ic_plus);
        this.c = ContextCompat.getDrawable(context, R.drawable.ic_plus);
        this.d = ContextCompat.getDrawable(context, R.drawable.ic_plus);
    }

    private List<cf0> g() {
        List<RowHeader> list = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            String valueOf = String.valueOf(i);
            list.add(new cf0(valueOf, "row " + i));
        }
        return list;
    }

    private List<y9> e() {
        List<ColumnHeader> list = new ArrayList<>();
        y9 header1 = new y9(String.valueOf(0), "اسم الباقة");
        y9 header2 = new y9(String.valueOf(1), "الــوقت");
        y9 header3 = new y9(String.valueOf(2), "كمية التحميل");
        y9 header4 = new y9(String.valueOf(3), "الصلاحيـة");
        list.add(header1);
        list.add(header2);
        list.add(header3);
        list.add(header4);
        list.add(new y9(String.valueOf(3), "السعـر"));
        return list;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00c4 A[SYNTHETIC, Splitter:B:19:0x00c4] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0124 A[Catch:{ Exception -> 0x01be }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0139 A[Catch:{ Exception -> 0x01be }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0143 A[Catch:{ Exception -> 0x01be }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<java.util.List<defpackage.z7>> b() {
        /*
            r20 = this;
            r1 = r20
            java.lang.String r0 = ""
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            ue r3 = r1.f5406a     // Catch:{ Exception -> 0x01be }
            android.database.Cursor r3 = r3.s0()     // Catch:{ Exception -> 0x01be }
            r4 = 0
        L_0x0010:
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel> r5 = r1.f5405a     // Catch:{ Exception -> 0x01be }
            int r5 = r5.size()     // Catch:{ Exception -> 0x01be }
            if (r4 >= r5) goto L_0x01bb
            r5 = r0
            r6 = 0
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ Exception -> 0x01be }
            java.lang.String r7 = "ميجا"
            r8 = r0
            r9 = r0
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel> r10 = r1.f5405a     // Catch:{ Exception -> 0x01be }
            java.lang.Object r10 = r10.get(r4)     // Catch:{ Exception -> 0x01be }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel r10 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel) r10     // Catch:{ Exception -> 0x01be }
            java.lang.String r10 = r10.getTrans_limit()     // Catch:{ Exception -> 0x01be }
            java.lang.String r11 = "غير محدود"
            r12 = 1
            if (r10 == 0) goto L_0x00a9
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel> r10 = r1.f5405a     // Catch:{ Exception -> 0x01be }
            java.lang.Object r10 = r10.get(r4)     // Catch:{ Exception -> 0x01be }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel r10 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel) r10     // Catch:{ Exception -> 0x01be }
            java.lang.String r10 = r10.getTrans_limit()     // Catch:{ Exception -> 0x01be }
            java.lang.String r13 = "0"
            boolean r10 = r10.equals(r13)     // Catch:{ Exception -> 0x01be }
            if (r10 != 0) goto L_0x00a9
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel> r10 = r1.f5405a     // Catch:{ Exception -> 0x01be }
            java.lang.Object r10 = r10.get(r4)     // Catch:{ Exception -> 0x01be }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel r10 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel) r10     // Catch:{ Exception -> 0x01be }
            java.lang.String r10 = r10.getTrans_limit()     // Catch:{ Exception -> 0x01be }
            double r13 = java.lang.Double.parseDouble(r10)     // Catch:{ Exception -> 0x01be }
            r15 = 4697254411347427328(0x4130000000000000, double:1048576.0)
            double r13 = r13 / r15
            java.lang.Double r10 = java.lang.Double.valueOf(r13)     // Catch:{ Exception -> 0x01be }
            r6 = r10
            double r13 = r6.doubleValue()     // Catch:{ Exception -> 0x01be }
            r15 = 4652218415073722368(0x4090000000000000, double:1024.0)
            int r10 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r10 <= 0) goto L_0x0085
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel> r10 = r1.f5405a     // Catch:{ Exception -> 0x01be }
            java.lang.Object r10 = r10.get(r4)     // Catch:{ Exception -> 0x01be }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel r10 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel) r10     // Catch:{ Exception -> 0x01be }
            java.lang.String r10 = r10.getTrans_limit()     // Catch:{ Exception -> 0x01be }
            double r13 = java.lang.Double.parseDouble(r10)     // Catch:{ Exception -> 0x01be }
            r15 = 4742290407621132288(0x41d0000000000000, double:1.073741824E9)
            double r13 = r13 / r15
            java.lang.Double r10 = java.lang.Double.valueOf(r13)     // Catch:{ Exception -> 0x01be }
            r6 = r10
            java.lang.String r10 = "جيجا"
            r7 = r10
        L_0x0085:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01be }
            r10.<init>()     // Catch:{ Exception -> 0x01be }
            java.util.Locale r13 = java.util.Locale.US     // Catch:{ Exception -> 0x01be }
            java.lang.String r14 = "%.1f"
            java.lang.Object[] r15 = new java.lang.Object[r12]     // Catch:{ Exception -> 0x01be }
            r16 = 0
            r15[r16] = r6     // Catch:{ Exception -> 0x01be }
            java.lang.String r13 = java.lang.String.format(r13, r14, r15)     // Catch:{ Exception -> 0x01be }
            r10.append(r13)     // Catch:{ Exception -> 0x01be }
            java.lang.String r13 = " "
            r10.append(r13)     // Catch:{ Exception -> 0x01be }
            r10.append(r7)     // Catch:{ Exception -> 0x01be }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x01be }
            r5 = r10
            goto L_0x00aa
        L_0x00a9:
            r5 = r11
        L_0x00aa:
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel> r10 = r1.f5405a     // Catch:{ Exception -> 0x01be }
            java.lang.Object r10 = r10.get(r4)     // Catch:{ Exception -> 0x01be }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel r10 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel) r10     // Catch:{ Exception -> 0x01be }
            java.lang.String r10 = r10.getTime_limit()     // Catch:{ Exception -> 0x01be }
            java.lang.String r13 = " اسبوع "
            java.lang.String r14 = "w"
            java.lang.String r15 = " يوم "
            java.lang.String r12 = "d"
            r17 = r0
            java.lang.String r0 = "0s"
            if (r10 == 0) goto L_0x00ff
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel> r10 = r1.f5405a     // Catch:{ Exception -> 0x01be }
            java.lang.Object r10 = r10.get(r4)     // Catch:{ Exception -> 0x01be }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel r10 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel) r10     // Catch:{ Exception -> 0x01be }
            java.lang.String r10 = r10.getTime_limit()     // Catch:{ Exception -> 0x01be }
            boolean r10 = r10.equals(r0)     // Catch:{ Exception -> 0x01be }
            if (r10 != 0) goto L_0x00ff
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel> r10 = r1.f5405a     // Catch:{ Exception -> 0x01be }
            java.lang.Object r10 = r10.get(r4)     // Catch:{ Exception -> 0x01be }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel r10 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel) r10     // Catch:{ Exception -> 0x01be }
            java.lang.String r10 = r10.getTime_limit()     // Catch:{ Exception -> 0x01be }
            r18 = r3
            java.lang.String r3 = "h"
            r19 = r6
            java.lang.String r6 = "ساعة"
            java.lang.String r3 = r10.replace(r3, r6)     // Catch:{ Exception -> 0x01be }
            java.lang.String r6 = "m"
            java.lang.String r10 = " دقيقة "
            java.lang.String r3 = r3.replace(r6, r10)     // Catch:{ Exception -> 0x01be }
            java.lang.String r3 = r3.replace(r12, r15)     // Catch:{ Exception -> 0x01be }
            java.lang.String r3 = r3.replace(r14, r13)     // Catch:{ Exception -> 0x01be }
            goto L_0x0104
        L_0x00ff:
            r18 = r3
            r19 = r6
            r3 = r11
        L_0x0104:
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel> r6 = r1.f5405a     // Catch:{ Exception -> 0x01be }
            java.lang.Object r6 = r6.get(r4)     // Catch:{ Exception -> 0x01be }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel r6 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel) r6     // Catch:{ Exception -> 0x01be }
            java.lang.String r6 = r6.getValidty_limit()     // Catch:{ Exception -> 0x01be }
            if (r6 == 0) goto L_0x0139
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel> r6 = r1.f5405a     // Catch:{ Exception -> 0x01be }
            java.lang.Object r6 = r6.get(r4)     // Catch:{ Exception -> 0x01be }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel r6 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel) r6     // Catch:{ Exception -> 0x01be }
            java.lang.String r6 = r6.getValidty_limit()     // Catch:{ Exception -> 0x01be }
            boolean r0 = r6.equals(r0)     // Catch:{ Exception -> 0x01be }
            if (r0 != 0) goto L_0x0139
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel> r0 = r1.f5405a     // Catch:{ Exception -> 0x01be }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ Exception -> 0x01be }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel r0 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel) r0     // Catch:{ Exception -> 0x01be }
            java.lang.String r0 = r0.getValidty_limit()     // Catch:{ Exception -> 0x01be }
            java.lang.String r0 = r0.replace(r12, r15)     // Catch:{ Exception -> 0x01be }
            java.lang.String r0 = r0.replace(r14, r13)     // Catch:{ Exception -> 0x01be }
            goto L_0x013a
        L_0x0139:
            r0 = r11
        L_0x013a:
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x01be }
            r6.<init>()     // Catch:{ Exception -> 0x01be }
            r8 = 0
        L_0x0140:
            r9 = 5
            if (r8 >= r9) goto L_0x01af
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel> r9 = r1.f5405a     // Catch:{ Exception -> 0x01be }
            java.lang.Object r9 = r9.get(r4)     // Catch:{ Exception -> 0x01be }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel r9 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel) r9     // Catch:{ Exception -> 0x01be }
            java.lang.String r9 = r9.getName()     // Catch:{ Exception -> 0x01be }
            r10 = 4
            r11 = 3
            if (r8 != 0) goto L_0x0162
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel> r12 = r1.f5405a     // Catch:{ Exception -> 0x01be }
            java.lang.Object r12 = r12.get(r4)     // Catch:{ Exception -> 0x01be }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel r12 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel) r12     // Catch:{ Exception -> 0x01be }
            java.lang.String r12 = r12.getName()     // Catch:{ Exception -> 0x01be }
            r9 = r12
            r12 = 1
            goto L_0x017f
        L_0x0162:
            r12 = 1
            if (r8 != r12) goto L_0x0167
            r9 = r3
            goto L_0x017f
        L_0x0167:
            r13 = 2
            if (r8 != r13) goto L_0x016c
            r9 = r5
            goto L_0x017f
        L_0x016c:
            if (r8 != r11) goto L_0x0170
            r9 = r0
            goto L_0x017f
        L_0x0170:
            if (r8 != r10) goto L_0x017f
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel> r13 = r1.f5405a     // Catch:{ Exception -> 0x01be }
            java.lang.Object r13 = r13.get(r4)     // Catch:{ Exception -> 0x01be }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel r13 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel) r13     // Catch:{ Exception -> 0x01be }
            java.lang.String r13 = r13.getPrice()     // Catch:{ Exception -> 0x01be }
            r9 = r13
        L_0x017f:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01be }
            r13.<init>()     // Catch:{ Exception -> 0x01be }
            r13.append(r8)     // Catch:{ Exception -> 0x01be }
            java.lang.String r14 = "-"
            r13.append(r14)     // Catch:{ Exception -> 0x01be }
            r13.append(r4)     // Catch:{ Exception -> 0x01be }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x01be }
            if (r8 != r11) goto L_0x019b
            z7 r10 = new z7     // Catch:{ Exception -> 0x01be }
            r10.<init>(r13, r9)     // Catch:{ Exception -> 0x01be }
            goto L_0x01a8
        L_0x019b:
            if (r8 != r10) goto L_0x01a3
            z7 r10 = new z7     // Catch:{ Exception -> 0x01be }
            r10.<init>(r13, r9)     // Catch:{ Exception -> 0x01be }
            goto L_0x01a8
        L_0x01a3:
            z7 r10 = new z7     // Catch:{ Exception -> 0x01be }
            r10.<init>(r13, r9)     // Catch:{ Exception -> 0x01be }
        L_0x01a8:
            r6.add(r10)     // Catch:{ Exception -> 0x01be }
            int r8 = r8 + 1
            goto L_0x0140
        L_0x01af:
            r2.add(r6)     // Catch:{ Exception -> 0x01be }
            int r4 = r4 + 1
            r0 = r17
            r3 = r18
            goto L_0x0010
        L_0x01bb:
            r18 = r3
            goto L_0x01c2
        L_0x01be:
            r0 = move-exception
            r0.printStackTrace()
        L_0x01c2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vp0.b():java.util.List");
    }

    public Drawable d(int value, boolean isGender) {
        return isGender ? value == 1 ? this.f5404a : this.b : value == 1 ? this.d : this.c;
    }

    public List<List<z7>> a() {
        return b();
    }

    public List<cf0> f() {
        return g();
    }

    public List<y9> c() {
        return e();
    }
}
