package com.blogspot.yemeninfo4it.mumsmobile_app.activities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Payment;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Sessions;
import com.evrencoskun.tableview.TableView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

public class SalesHotsActivity extends AppCompatActivity {
    public static int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static TableView f1017a;

    /* renamed from: a  reason: collision with other field name */
    public static String f1018a;

    /* renamed from: a  reason: collision with other field name */
    public static ue f1019a;
    public static String b;
    public static TextView c;

    /* renamed from: c  reason: collision with other field name */
    public static ArrayList<Sessions> f1020c;
    public static TextView d;
    public static TextView e;
    public static TextView f;
    public static TextView g;

    /* renamed from: a  reason: collision with other field name */
    Context f1021a;

    /* renamed from: a  reason: collision with other field name */
    public Button f1022a;

    /* renamed from: a  reason: collision with other field name */
    ImageView f1023a;

    /* renamed from: a  reason: collision with other field name */
    public LinearLayout f1024a;

    /* renamed from: a  reason: collision with other field name */
    public TextView f1025a;

    /* renamed from: a  reason: collision with other field name */
    f f1026a;

    /* renamed from: a  reason: collision with other field name */
    public d0 f1027a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<Sessions> f1028a;

    /* renamed from: a  reason: collision with other field name */
    public wp0 f1029a;

    /* renamed from: a  reason: collision with other field name */
    zd f1030a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1031a = true;

    /* renamed from: b  reason: collision with other field name */
    public Button f1032b;

    /* renamed from: b  reason: collision with other field name */
    LinearLayout f1033b;

    /* renamed from: b  reason: collision with other field name */
    TextView f1034b;

    /* renamed from: b  reason: collision with other field name */
    public ArrayList<Payment> f1035b;

    /* renamed from: c  reason: collision with other field name */
    public Button f1036c;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.salse_layout);
        this.f1021a = this;
        try {
            f1019a = new ue(this.f1021a);
            zd zdVar = new zd(this);
            this.f1030a = zdVar;
            this.f1034b = (TextView) zdVar.b().findViewById(R.id.cancel_btn);
            this.f1022a = (Button) findViewById(R.id.activebtn);
            this.f1032b = (Button) findViewById(R.id.showbtn);
            this.f1023a = (ImageView) findViewById(R.id.icontoolbar);
            this.f1036c = (Button) findViewById(R.id.dubl);
            c = (TextView) findViewById(R.id.activeacount);
            d = (TextView) findViewById(R.id.sum);
            e = (TextView) findViewById(R.id.transmit_sum);
            f = (TextView) findViewById(R.id.start_date);
            g = (TextView) findViewById(R.id.end_date);
            this.f1024a = (LinearLayout) findViewById(R.id.ether_layout);
            this.f1025a = (TextView) findViewById(R.id.header_text_title);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.search_field);
            this.f1033b = linearLayout;
            linearLayout.setVisibility(8);
            this.f1023a.setVisibility(8);
            this.f1025a.setText("إدارة مبيعات الهوتسبوت");
            this.f1028a = new ArrayList<>();
            f1020c = new ArrayList<>();
            this.f1024a.setVisibility(8);
            this.f1035b = new ArrayList<>();
            f1017a = (TableView) findViewById(R.id.tableview);
            k();
            this.f1022a.setVisibility(8);
            this.f1034b.setOnClickListener(new a());
            f.setOnClickListener(new b());
            g.setOnClickListener(new c());
            this.f1032b.setOnClickListener(new d());
        } catch (Exception e2) {
            Toast.makeText(this, e2.getMessage() + "حدثت مشكله", 1).show();
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View v) {
            SalesHotsActivity.this.f1030a.a();
            SalesHotsActivity.this.f1026a.cancel(true);
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View v) {
            try {
                DialogFragment dFragment = new e();
                qb0.f4820e = true;
                dFragment.show(SalesHotsActivity.this.getFragmentManager(), "From Date");
            } catch (Exception e) {
                Toast.makeText(SalesHotsActivity.this.f1021a, e.getMessage(), 0).show();
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View v) {
            try {
                DialogFragment dFragment = new e();
                qb0.f4820e = false;
                dFragment.show(SalesHotsActivity.this.getFragmentManager(), "To Date");
            } catch (Exception e) {
                Toast.makeText(SalesHotsActivity.this.f1021a, e.getMessage(), 0).show();
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        public void onClick(View v) {
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(jv0.b(newBase));
    }

    public void onBackPressed() {
        super.onBackPressed();
        i40.e(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00f3 A[Catch:{ Exception -> 0x018d }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x013b A[SYNTHETIC, Splitter:B:54:0x013b] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0191 A[SYNTHETIC, Splitter:B:73:0x0191] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01f4 A[Catch:{ Exception -> 0x028e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k() {
        /*
            r30 = this;
            r1 = r30
            java.lang.String r2 = "العدد: "
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard> r0 = defpackage.qb0.f4834l     // Catch:{ Exception -> 0x028e }
            int r0 = r0.size()     // Catch:{ Exception -> 0x028e }
            if (r0 <= 0) goto L_0x0283
            r4 = 0
            a = r4     // Catch:{ Exception -> 0x028e }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x028e }
            r0.<init>()     // Catch:{ Exception -> 0x028e }
            r5 = r0
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x028e }
            java.lang.String r6 = "MMM/dd/yyyy"
            java.util.Locale r7 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x028e }
            r0.<init>(r6, r7)     // Catch:{ Exception -> 0x028e }
            r6 = r0
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x028e }
            java.lang.String r8 = "dd/MM/yyyy"
            r0.<init>(r8, r7)     // Catch:{ Exception -> 0x028e }
            r8 = r0
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x028e }
            java.lang.String r9 = "yyyy-MM-dd"
            r0.<init>(r9, r7)     // Catch:{ Exception -> 0x028e }
            r9 = r0
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x028e }
            java.lang.String r10 = "yyyy-MM-dd_HH:mm:ss"
            r0.<init>(r10, r7)     // Catch:{ Exception -> 0x028e }
            r7 = r0
            java.lang.String r10 = ""
            r0 = r10
            r11 = 0
            r12 = r11
            r11 = r0
        L_0x003d:
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard> r0 = defpackage.qb0.f4834l     // Catch:{ Exception -> 0x028e }
            int r0 = r0.size()     // Catch:{ Exception -> 0x028e }
            if (r12 >= r0) goto L_0x0204
            r13 = 0
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard> r0 = defpackage.qb0.f4834l     // Catch:{ Exception -> 0x028e }
            java.lang.Object r0 = r0.get(r12)     // Catch:{ Exception -> 0x028e }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard r0 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard) r0     // Catch:{ Exception -> 0x028e }
            java.lang.String r0 = r0.getComment()     // Catch:{ Exception -> 0x028e }
            if (r0 == 0) goto L_0x01f7
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard> r0 = defpackage.qb0.f4834l     // Catch:{ Exception -> 0x028e }
            java.lang.Object r0 = r0.get(r12)     // Catch:{ Exception -> 0x028e }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard r0 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard) r0     // Catch:{ Exception -> 0x028e }
            java.lang.String r0 = r0.getEmail()     // Catch:{ Exception -> 0x028e }
            if (r0 == 0) goto L_0x01f7
            r0 = r10
            r15 = 1
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard> r3 = defpackage.qb0.f4834l     // Catch:{ Exception -> 0x028e }
            java.lang.Object r3 = r3.get(r12)     // Catch:{ Exception -> 0x028e }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard r3 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard) r3     // Catch:{ Exception -> 0x028e }
            java.lang.String r3 = r3.getEmail()     // Catch:{ Exception -> 0x028e }
            r4 = 95
            int r3 = r3.indexOf(r4)     // Catch:{ Exception -> 0x028e }
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard> r4 = defpackage.qb0.f4834l     // Catch:{ Exception -> 0x028e }
            java.lang.Object r4 = r4.get(r12)     // Catch:{ Exception -> 0x028e }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard r4 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard) r4     // Catch:{ Exception -> 0x028e }
            java.lang.String r4 = r4.getEmail()     // Catch:{ Exception -> 0x028e }
            r16 = r0
            r0 = 46
            int r0 = r4.indexOf(r0)     // Catch:{ Exception -> 0x028e }
            r4 = r0
            int r0 = r4 + -1
            int r17 = r0 - r3
            if (r3 <= 0) goto L_0x00d0
            if (r4 <= 0) goto L_0x00d0
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard> r0 = defpackage.qb0.f4834l     // Catch:{ Exception -> 0x028e }
            java.lang.Object r0 = r0.get(r12)     // Catch:{ Exception -> 0x028e }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard r0 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard) r0     // Catch:{ Exception -> 0x028e }
            java.lang.String r0 = r0.getEmail()     // Catch:{ Exception -> 0x028e }
            r18 = r10
            int r10 = r3 + 1
            java.lang.String r0 = r0.substring(r10, r4)     // Catch:{ Exception -> 0x028e }
            r10 = r0
            int r0 = java.lang.Integer.parseInt(r10)     // Catch:{ Exception -> 0x00af }
            long r13 = (long) r0
            goto L_0x00bb
        L_0x00af:
            r0 = move-exception
            r16 = r0
            r0 = r16
            r15 = 0
            java.lang.String r16 = "0"
            r10 = r16
            r13 = 0
        L_0x00bb:
            int r0 = a     // Catch:{ Exception -> 0x00c9 }
            r19 = r3
            r20 = r4
            long r3 = (long) r0
            long r3 = r3 + r13
            int r0 = (int) r3
            a = r0     // Catch:{ Exception -> 0x00c7 }
            goto L_0x00d8
        L_0x00c7:
            r0 = move-exception
            goto L_0x00ce
        L_0x00c9:
            r0 = move-exception
            r19 = r3
            r20 = r4
        L_0x00ce:
            r15 = 0
            goto L_0x00d8
        L_0x00d0:
            r19 = r3
            r20 = r4
            r18 = r10
            r10 = r16
        L_0x00d8:
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard> r0 = defpackage.qb0.f4834l     // Catch:{ Exception -> 0x018d }
            java.lang.Object r0 = r0.get(r12)     // Catch:{ Exception -> 0x018d }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard r0 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard) r0     // Catch:{ Exception -> 0x018d }
            java.lang.String r0 = r0.getComment()     // Catch:{ Exception -> 0x018d }
            r3 = 4
            r4 = 0
            java.lang.String r0 = r0.substring(r4, r3)     // Catch:{ Exception -> 0x018d }
            r3 = r0
            java.lang.String r0 = "mums"
            boolean r0 = r3.equals(r0)     // Catch:{ Exception -> 0x018d }
            if (r0 == 0) goto L_0x013b
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard> r0 = defpackage.qb0.f4834l     // Catch:{ Exception -> 0x018d }
            java.lang.Object r0 = r0.get(r12)     // Catch:{ Exception -> 0x018d }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard r0 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard) r0     // Catch:{ Exception -> 0x018d }
            java.lang.String r0 = r0.getComment()     // Catch:{ Exception -> 0x018d }
            r4 = 5
            java.lang.String r0 = r0.substring(r4)     // Catch:{ Exception -> 0x018d }
            r4 = r0
            java.util.Date r0 = r6.parse(r4)     // Catch:{ Exception -> 0x0118 }
            if (r0 == 0) goto L_0x0112
            java.lang.String r16 = r8.format(r0)     // Catch:{ Exception -> 0x0118 }
            r0 = r16
            goto L_0x0139
        L_0x0112:
            java.lang.AssertionError r16 = new java.lang.AssertionError     // Catch:{ Exception -> 0x0118 }
            r16.<init>()     // Catch:{ Exception -> 0x0118 }
            throw r16     // Catch:{ Exception -> 0x0118 }
        L_0x0118:
            r0 = move-exception
            r16 = r0
            java.util.Date r0 = r9.parse(r4)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r21 = r8.format(r0)     // Catch:{ Exception -> 0x0127 }
            r11 = r21
            r0 = r11
            goto L_0x0139
        L_0x0127:
            r0 = move-exception
            java.util.Date r21 = r7.parse(r4)     // Catch:{ Exception -> 0x018d }
            r22 = r21
            r21 = r0
            r0 = r22
            java.lang.String r22 = r8.format(r0)     // Catch:{ Exception -> 0x018d }
            r11 = r22
            r0 = r11
        L_0x0139:
            r11 = r0
            goto L_0x018c
        L_0x013b:
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard> r0 = defpackage.qb0.f4834l     // Catch:{ Exception -> 0x015a }
            java.lang.Object r0 = r0.get(r12)     // Catch:{ Exception -> 0x015a }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard r0 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard) r0     // Catch:{ Exception -> 0x015a }
            java.lang.String r0 = r0.getComment()     // Catch:{ Exception -> 0x015a }
            java.util.Date r0 = r6.parse(r0)     // Catch:{ Exception -> 0x015a }
            if (r0 == 0) goto L_0x0154
            java.lang.String r4 = r8.format(r0)     // Catch:{ Exception -> 0x015a }
            r0 = r4
            r11 = r0
            goto L_0x018c
        L_0x0154:
            java.lang.AssertionError r4 = new java.lang.AssertionError     // Catch:{ Exception -> 0x015a }
            r4.<init>()     // Catch:{ Exception -> 0x015a }
            throw r4     // Catch:{ Exception -> 0x015a }
        L_0x015a:
            r0 = move-exception
            r4 = r0
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard> r0 = defpackage.qb0.f4834l     // Catch:{ Exception -> 0x0173 }
            java.lang.Object r0 = r0.get(r12)     // Catch:{ Exception -> 0x0173 }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard r0 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard) r0     // Catch:{ Exception -> 0x0173 }
            java.lang.String r0 = r0.getComment()     // Catch:{ Exception -> 0x0173 }
            java.util.Date r0 = r9.parse(r0)     // Catch:{ Exception -> 0x0173 }
            java.lang.String r16 = r8.format(r0)     // Catch:{ Exception -> 0x0173 }
            r11 = r16
            goto L_0x018c
        L_0x0173:
            r0 = move-exception
            r16 = r0
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard> r0 = defpackage.qb0.f4834l     // Catch:{ Exception -> 0x018d }
            java.lang.Object r0 = r0.get(r12)     // Catch:{ Exception -> 0x018d }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard r0 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard) r0     // Catch:{ Exception -> 0x018d }
            java.lang.String r0 = r0.getComment()     // Catch:{ Exception -> 0x018d }
            java.util.Date r0 = r7.parse(r0)     // Catch:{ Exception -> 0x018d }
            java.lang.String r21 = r8.format(r0)     // Catch:{ Exception -> 0x018d }
            r11 = r21
        L_0x018c:
            goto L_0x018f
        L_0x018d:
            r0 = move-exception
            r15 = 0
        L_0x018f:
            if (r15 == 0) goto L_0x01f4
            com.blogspot.yemeninfo4it.mumsmobile_app.model.Sessions r0 = new com.blogspot.yemeninfo4it.mumsmobile_app.model.Sessions     // Catch:{ Exception -> 0x01e2 }
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard> r3 = defpackage.qb0.f4834l     // Catch:{ Exception -> 0x01e2 }
            java.lang.Object r3 = r3.get(r12)     // Catch:{ Exception -> 0x01e2 }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard r3 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard) r3     // Catch:{ Exception -> 0x01e2 }
            java.lang.String r22 = r3.getUname()     // Catch:{ Exception -> 0x01e2 }
            java.lang.String r24 = java.lang.String.valueOf(r13)     // Catch:{ Exception -> 0x01e2 }
            java.lang.String r25 = ""
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard> r3 = defpackage.qb0.f4834l     // Catch:{ Exception -> 0x01e2 }
            java.lang.Object r3 = r3.get(r12)     // Catch:{ Exception -> 0x01e2 }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard r3 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard) r3     // Catch:{ Exception -> 0x01e2 }
            java.lang.String r26 = r3.getId()     // Catch:{ Exception -> 0x01e2 }
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard> r3 = defpackage.qb0.f4834l     // Catch:{ Exception -> 0x01e2 }
            java.lang.Object r3 = r3.get(r12)     // Catch:{ Exception -> 0x01e2 }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard r3 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard) r3     // Catch:{ Exception -> 0x01e2 }
            java.lang.String r27 = r3.getDownload_used()     // Catch:{ Exception -> 0x01e2 }
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard> r3 = defpackage.qb0.f4834l     // Catch:{ Exception -> 0x01e2 }
            java.lang.Object r3 = r3.get(r12)     // Catch:{ Exception -> 0x01e2 }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard r3 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard) r3     // Catch:{ Exception -> 0x01e2 }
            java.lang.String r28 = r3.getUpload_used()     // Catch:{ Exception -> 0x01e2 }
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard> r3 = defpackage.qb0.f4834l     // Catch:{ Exception -> 0x01e2 }
            java.lang.Object r3 = r3.get(r12)     // Catch:{ Exception -> 0x01e2 }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard r3 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard) r3     // Catch:{ Exception -> 0x01e2 }
            java.lang.String r29 = r3.getUptime_used()     // Catch:{ Exception -> 0x01e2 }
            r21 = r0
            r23 = r11
            r21.<init>(r22, r23, r24, r25, r26, r27, r28, r29)     // Catch:{ Exception -> 0x01e2 }
            r5.add(r0)     // Catch:{ Exception -> 0x01e2 }
            r16 = r6
            goto L_0x01f6
        L_0x01e2:
            r0 = move-exception
            android.content.Context r3 = r1.f1021a     // Catch:{ Exception -> 0x028e }
            java.lang.String r4 = r0.getMessage()     // Catch:{ Exception -> 0x028e }
            r16 = r6
            r6 = 0
            android.widget.Toast r3 = android.widget.Toast.makeText(r3, r4, r6)     // Catch:{ Exception -> 0x028e }
            r3.show()     // Catch:{ Exception -> 0x028e }
            goto L_0x01fb
        L_0x01f4:
            r16 = r6
        L_0x01f6:
            goto L_0x01fb
        L_0x01f7:
            r16 = r6
            r18 = r10
        L_0x01fb:
            int r12 = r12 + 1
            r6 = r16
            r10 = r18
            r4 = 0
            goto L_0x003d
        L_0x0204:
            r16 = r6
            defpackage.qb0.f4827h = r5     // Catch:{ Exception -> 0x028e }
            android.widget.TextView r0 = d     // Catch:{ Exception -> 0x028e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x028e }
            r3.<init>()     // Catch:{ Exception -> 0x028e }
            java.lang.String r4 = "المجموع :"
            r3.append(r4)     // Catch:{ Exception -> 0x028e }
            int r4 = a     // Catch:{ Exception -> 0x028e }
            r3.append(r4)     // Catch:{ Exception -> 0x028e }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x028e }
            r0.setText(r3)     // Catch:{ Exception -> 0x028e }
            android.widget.TextView r0 = c     // Catch:{ Exception -> 0x028e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x028e }
            r3.<init>()     // Catch:{ Exception -> 0x028e }
            r3.append(r2)     // Catch:{ Exception -> 0x028e }
            int r4 = r5.size()     // Catch:{ Exception -> 0x028e }
            r3.append(r4)     // Catch:{ Exception -> 0x028e }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x028e }
            r0.setText(r3)     // Catch:{ Exception -> 0x028e }
            r30.l()     // Catch:{ Exception -> 0x028e }
            android.widget.TextView r0 = c     // Catch:{ Exception -> 0x028e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x028e }
            r3.<init>()     // Catch:{ Exception -> 0x028e }
            r3.append(r2)     // Catch:{ Exception -> 0x028e }
            int r2 = r5.size()     // Catch:{ Exception -> 0x028e }
            r3.append(r2)     // Catch:{ Exception -> 0x028e }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x028e }
            r0.setText(r2)     // Catch:{ Exception -> 0x028e }
            int r0 = r5.size()     // Catch:{ Exception -> 0x028e }
            if (r0 <= 0) goto L_0x0276
            com.evrencoskun.tableview.TableView r0 = f1017a     // Catch:{ Exception -> 0x028e }
            r2 = 0
            r0.setVisibility(r2)     // Catch:{ Exception -> 0x028e }
            android.widget.TextView r0 = d     // Catch:{ Exception -> 0x028e }
            r0.setVisibility(r2)     // Catch:{ Exception -> 0x028e }
            boolean r0 = defpackage.qb0.f4826g     // Catch:{ Exception -> 0x028e }
            if (r0 != 0) goto L_0x0282
            com.blogspot.yemeninfo4it.mumsmobile_app.activities.SalesHotsActivity$f r0 = new com.blogspot.yemeninfo4it.mumsmobile_app.activities.SalesHotsActivity$f     // Catch:{ Exception -> 0x028e }
            r0.<init>()     // Catch:{ Exception -> 0x028e }
            r1.f1026a = r0     // Catch:{ Exception -> 0x028e }
            r2 = 0
            java.lang.Void[] r2 = new java.lang.Void[r2]     // Catch:{ Exception -> 0x028e }
            r0.execute(r2)     // Catch:{ Exception -> 0x028e }
            goto L_0x0282
        L_0x0276:
            com.evrencoskun.tableview.TableView r0 = f1017a     // Catch:{ Exception -> 0x028e }
            r2 = 8
            r0.setVisibility(r2)     // Catch:{ Exception -> 0x028e }
            android.widget.TextView r0 = d     // Catch:{ Exception -> 0x028e }
            r0.setVisibility(r2)     // Catch:{ Exception -> 0x028e }
        L_0x0282:
            goto L_0x028d
        L_0x0283:
            java.lang.String r0 = "اضغط على تحميل اولا"
            r2 = 1
            android.widget.Toast r0 = android.widget.Toast.makeText(r1, r0, r2)     // Catch:{ Exception -> 0x028e }
            r0.show()     // Catch:{ Exception -> 0x028e }
        L_0x028d:
            goto L_0x0299
        L_0x028e:
            r0 = move-exception
            java.lang.String r2 = "لا يوجد مبيعات"
            r3 = 1
            android.widget.Toast r2 = android.widget.Toast.makeText(r1, r2, r3)
            r2.show()
        L_0x0299:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blogspot.yemeninfo4it.mumsmobile_app.activities.SalesHotsActivity.k():void");
    }

    private void l() {
        try {
            Collections.sort(qb0.f4827h, ma.a(ji0.a));
        } catch (Exception e2) {
        }
        this.f1029a = new wp0(this.f1021a, qb0.f4827h);
        np0 np0 = new np0(this.f1021a, this.f1029a);
        this.f1027a = np0;
        f1017a.setAdapter(np0);
        this.f1027a.x(this.f1029a.c(), this.f1029a.f(), this.f1029a.a());
    }

    public static class e extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            Calendar calendar = Calendar.getInstance();
            DatePickerDialog dpd = new DatePickerDialog(getActivity(), 3, this, calendar.get(1), calendar.get(2), calendar.get(5));
            TextView tv = new TextView(getActivity());
            tv.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            tv.setPadding(10, 10, 10, 10);
            tv.setGravity(17);
            tv.setTextSize(1, 20.0f);
            tv.setText("قم بإختيار التاريخ");
            tv.setTextColor(Color.parseColor("#ffffff"));
            tv.setBackgroundColor(Color.parseColor("#FFD2DAA7"));
            dpd.setTitle("قم بإختيار التاريخ");
            return dpd;
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            String price;
            String date;
            String date2;
            double d;
            try {
                String date3 = String.valueOf(view.getDayOfMonth()) + "/" + String.valueOf(view.getMonth() + 1) + "/" + String.valueOf(view.getYear());
                String price2 = "";
                SalesHotsActivity salesHotsActivity = new SalesHotsActivity();
                Locale locale = Locale.ENGLISH;
                SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy", locale);
                SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy", locale);
                String date22 = "";
                try {
                    date22 = formatter2.format(formatter.parse(date3));
                } catch (Exception e) {
                }
                SalesHotsActivity.a = 0;
                if (qb0.f4820e) {
                    SalesHotsActivity.f.setText(date22);
                    SalesHotsActivity.f1018a = date22;
                    if (TextUtils.isEmpty(date22) || TextUtils.isEmpty(SalesHotsActivity.b)) {
                        return;
                    }
                    SalesHotsActivity.f1020c.clear();
                    double mdownload = 0.0d;
                    int i = 0;
                    while (i < qb0.f4827h.size()) {
                        Date d1 = salesHotsActivity.j(SalesHotsActivity.f1018a);
                        Date d2 = salesHotsActivity.j(SalesHotsActivity.b);
                        if ((salesHotsActivity.j(qb0.f4827h.get(i).getStfrom()).compareTo(d1) < 0 || salesHotsActivity.j(qb0.f4827h.get(i).getStfrom()).compareTo(d2) > 0) && (salesHotsActivity.j(qb0.f4827h.get(i).getStfrom()).compareTo(d1) > 0 || salesHotsActivity.j(qb0.f4827h.get(i).getStfrom()).compareTo(d2) < 0)) {
                            date2 = date3;
                        } else {
                            SalesHotsActivity.f1020c.add(new Sessions(qb0.f4827h.get(i).getName(), qb0.f4827h.get(i).getStfrom(), qb0.f4827h.get(i).getPrice(), "", "", qb0.f4827h.get(i).getDownload(), qb0.f4827h.get(i).getUpload(), qb0.f4827h.get(i).getUptime()));
                            SalesHotsActivity.a += Integer.parseInt(qb0.f4827h.get(i).getPrice());
                            if (qb0.f4827h.get(i).getDownload() == null || qb0.f4827h.get(i).getDownload().isEmpty()) {
                                date2 = date3;
                                d = 0.0d;
                            } else {
                                date2 = date3;
                                d = (double) Float.parseFloat(qb0.f4827h.get(i).getDownload());
                            }
                            mdownload = mdownload + d + ((qb0.f4827h.get(i).getUpload() == null || qb0.f4827h.get(i).getUpload().isEmpty()) ? 0.0d : (double) Float.parseFloat(qb0.f4827h.get(i).getUpload()));
                        }
                        i++;
                        date3 = date2;
                    }
                    if (SalesHotsActivity.f1020c.size() > 0) {
                        SalesHotsActivity.f1017a.setVisibility(0);
                        SalesHotsActivity.d.setVisibility(0);
                        SalesHotsActivity.e.setVisibility(0);
                        String formatted = qb0.e(String.valueOf(mdownload));
                        SalesHotsActivity.e.setText("مجموع التحميل+الرفع: " + formatted);
                        SalesHotsActivity.d.setText("المجموع :" + String.valueOf(SalesHotsActivity.a));
                        SalesHotsActivity.c.setText("العدد :" + String.valueOf(SalesHotsActivity.f1020c.size()));
                        try {
                            Collections.sort(SalesHotsActivity.f1020c, ma.a(ji0.a));
                        } catch (Exception e2) {
                        }
                        salesHotsActivity.f1029a = new wp0(getActivity(), SalesHotsActivity.f1020c);
                        np0 np0 = new np0(getActivity(), salesHotsActivity.f1029a);
                        salesHotsActivity.f1027a = np0;
                        SalesHotsActivity.f1017a.setAdapter(np0);
                        salesHotsActivity.f1027a.x(salesHotsActivity.f1029a.c(), salesHotsActivity.f1029a.f(), salesHotsActivity.f1029a.a());
                    } else {
                        SalesHotsActivity.c.setText("لا توجد مبيعات");
                        SalesHotsActivity.f1017a.setVisibility(8);
                        SalesHotsActivity.d.setVisibility(8);
                        SalesHotsActivity.e.setVisibility(8);
                    }
                    return;
                }
                String date4 = date3;
                SalesHotsActivity.g.setText(date22);
                SalesHotsActivity.b = date22;
                if (TextUtils.isEmpty(SalesHotsActivity.f1018a) || TextUtils.isEmpty(SalesHotsActivity.b)) {
                    String str = price2;
                    return;
                }
                SalesHotsActivity.f1020c.clear();
                double mdownload2 = 0.0d;
                int i2 = 0;
                while (i2 < qb0.f4827h.size()) {
                    Date d12 = salesHotsActivity.j(SalesHotsActivity.f1018a);
                    Date d22 = salesHotsActivity.j(SalesHotsActivity.b);
                    if ((salesHotsActivity.j(qb0.f4827h.get(i2).getStfrom()).compareTo(d12) < 0 || salesHotsActivity.j(qb0.f4827h.get(i2).getStfrom()).compareTo(d22) > 0) && (salesHotsActivity.j(qb0.f4827h.get(i2).getStfrom()).compareTo(d12) > 0 || salesHotsActivity.j(qb0.f4827h.get(i2).getStfrom()).compareTo(d22) < 0)) {
                        date = date4;
                        price = price2;
                    } else {
                        date = date4;
                        price = price2;
                        SalesHotsActivity.f1020c.add(new Sessions(qb0.f4827h.get(i2).getName(), qb0.f4827h.get(i2).getStfrom(), qb0.f4827h.get(i2).getPrice(), "", "", qb0.f4827h.get(i2).getDownload(), qb0.f4827h.get(i2).getUpload(), qb0.f4827h.get(i2).getUptime()));
                        SalesHotsActivity.a += Integer.parseInt(qb0.f4827h.get(i2).getPrice());
                        mdownload2 = mdownload2 + ((qb0.f4827h.get(i2).getDownload() == null || qb0.f4827h.get(i2).getDownload().isEmpty()) ? 0.0d : (double) Float.parseFloat(qb0.f4827h.get(i2).getDownload())) + ((qb0.f4827h.get(i2).getUpload() == null || qb0.f4827h.get(i2).getUpload().isEmpty()) ? 0.0d : (double) Float.parseFloat(qb0.f4827h.get(i2).getUpload()));
                    }
                    i2++;
                    date4 = date;
                    price2 = price;
                }
                String str2 = price2;
                if (SalesHotsActivity.f1020c.size() > 0) {
                    SalesHotsActivity.f1017a.setVisibility(0);
                    SalesHotsActivity.d.setVisibility(0);
                    SalesHotsActivity.e.setVisibility(0);
                    String formatted2 = qb0.e(String.valueOf(mdownload2));
                    SalesHotsActivity.e.setText("مجموع التحميل+الرفع: " + formatted2);
                    SalesHotsActivity.d.setText("المجموع :" + SalesHotsActivity.a);
                    SalesHotsActivity.c.setText("العدد :" + SalesHotsActivity.f1020c.size());
                    salesHotsActivity.f1029a = new wp0(getActivity(), SalesHotsActivity.f1020c);
                    np0 np02 = new np0(getActivity(), salesHotsActivity.f1029a);
                    salesHotsActivity.f1027a = np02;
                    SalesHotsActivity.f1017a.setAdapter(np02);
                    salesHotsActivity.f1027a.x(salesHotsActivity.f1029a.c(), salesHotsActivity.f1029a.f(), salesHotsActivity.f1029a.a());
                    return;
                }
                SalesHotsActivity.c.setText("لا توجد مبيعات");
                SalesHotsActivity.f1017a.setVisibility(8);
                SalesHotsActivity.d.setVisibility(8);
                SalesHotsActivity.e.setVisibility(8);
            } catch (Exception e3) {
                Toast.makeText(getActivity(), e3.getMessage(), 1).show();
            }
        }
    }

    public Date j(String dtStart) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date dateReturn = new Date();
        try {
            return format.parse(dtStart);
        } catch (ParseException e2) {
            e2.printStackTrace();
            return dateReturn;
        }
    }

    public class f extends AsyncTask<Void, Void, String> {
        public f() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            SalesHotsActivity.this.f1030a.c("يتم ارشفة المبيعات...");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Void... strings) {
            try {
                SalesHotsActivity.f1019a.J("hotpot_sales", qb0.f4827h);
                qb0.f4826g = true;
                return null;
            } catch (Exception e) {
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            SalesHotsActivity.this.f1030a.a();
            try {
                Toast.makeText(SalesHotsActivity.this.f1021a, "تمت الارشفة", 0).show();
                qb0.f4826g = true;
            } catch (Exception e) {
            }
        }
    }
}
