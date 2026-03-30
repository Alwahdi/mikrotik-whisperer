package com.blogspot.yemeninfo4it.mumsmobile_app.activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel;
import com.evrencoskun.tableview.TableView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UsermanProfileActivity extends AppCompatActivity implements pr {
    public int a = -1;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f1224a;

    /* renamed from: a  reason: collision with other field name */
    Context f1225a;

    /* renamed from: a  reason: collision with other field name */
    Button f1226a;

    /* renamed from: a  reason: collision with other field name */
    CheckBox f1227a;

    /* renamed from: a  reason: collision with other field name */
    EditText f1228a;

    /* renamed from: a  reason: collision with other field name */
    ImageView f1229a;

    /* renamed from: a  reason: collision with other field name */
    LinearLayout f1230a;

    /* renamed from: a  reason: collision with other field name */
    Spinner f1231a;

    /* renamed from: a  reason: collision with other field name */
    TextView f1232a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public TableView f1233a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public d0 f1234a;

    /* renamed from: a  reason: collision with other field name */
    j3 f1235a;

    /* renamed from: a  reason: collision with other field name */
    public String f1236a = "";

    /* renamed from: a  reason: collision with other field name */
    ArrayList<ProfileModel> f1237a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public vp0 f1238a;
    Button b;

    /* renamed from: b  reason: collision with other field name */
    CheckBox f1239b;

    /* renamed from: b  reason: collision with other field name */
    EditText f1240b;

    /* renamed from: b  reason: collision with other field name */
    LinearLayout f1241b;

    /* renamed from: b  reason: collision with other field name */
    Spinner f1242b;

    /* renamed from: b  reason: collision with other field name */
    TextView f1243b;
    Button c;

    /* renamed from: c  reason: collision with other field name */
    CheckBox f1244c;

    /* renamed from: c  reason: collision with other field name */
    EditText f1245c;

    /* renamed from: c  reason: collision with other field name */
    Spinner f1246c;

    /* renamed from: c  reason: collision with other field name */
    TextView f1247c;
    CheckBox d;

    /* renamed from: d  reason: collision with other field name */
    EditText f1248d;

    /* renamed from: d  reason: collision with other field name */
    TextView f1249d;
    CheckBox e;

    /* renamed from: e  reason: collision with other field name */
    EditText f1250e;
    EditText f;
    EditText g;
    EditText h;
    EditText i;
    EditText j;
    EditText k;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView((int) R.layout.activity_userman_profile);
            this.f1225a = this;
            this.f1235a = qb0.d();
            this.f1233a = (TableView) findViewById(R.id.tableview);
            this.f1237a = new ArrayList<>();
            this.f1224a = new ProgressDialog(this.f1225a);
            this.f1250e = (EditText) findViewById(R.id.price);
            this.f1228a = (EditText) findViewById(R.id.profile_name);
            this.f1240b = (EditText) findViewById(R.id.trans_limit);
            this.f1245c = (EditText) findViewById(R.id.time_limit);
            this.f1248d = (EditText) findViewById(R.id.validt_limit);
            this.f1231a = (Spinner) findViewById(R.id.trans_size_type);
            this.f1227a = (CheckBox) findViewById(R.id.monthly);
            this.j = (EditText) findViewById(R.id.add_price);
            this.f = (EditText) findViewById(R.id.add_profile_name);
            this.g = (EditText) findViewById(R.id.add_trans_limit);
            this.h = (EditText) findViewById(R.id.add_time_limit);
            this.i = (EditText) findViewById(R.id.add_validt_limit);
            this.k = (EditText) findViewById(R.id.add_minut_limit);
            this.f1242b = (Spinner) findViewById(R.id.add_trans_size_type);
            this.f1239b = (CheckBox) findViewById(R.id.add_monthly);
            this.f1232a = (TextView) findViewById(R.id.cancel_add_new);
            this.f1243b = (TextView) findViewById(R.id.add_new);
            this.f1247c = (TextView) findViewById(R.id.selected_profile_txt);
            this.f1244c = (CheckBox) findViewById(R.id.add_unlimited_time);
            this.d = (CheckBox) findViewById(R.id.add_unlimited_vali);
            this.e = (CheckBox) findViewById(R.id.no_time);
            this.f1246c = (Spinner) findViewById(R.id.customer);
            this.f1230a = (LinearLayout) findViewById(R.id.add_layout);
            this.f1241b = (LinearLayout) findViewById(R.id.show_layout);
            this.f1226a = (Button) findViewById(R.id.load_profile);
            this.b = (Button) findViewById(R.id.add_profile);
            this.c = (Button) findViewById(R.id.update_profile);
            this.f1229a = (ImageView) findViewById(R.id.back_img);
            this.f1249d = (TextView) findViewById(R.id.show_details);
            p();
            this.f1249d.setOnClickListener(new f());
            this.f1226a.setOnClickListener(new g());
            this.f1229a.setOnClickListener(new h());
            this.f1243b.setOnClickListener(new i());
            this.f1232a.setOnClickListener(new j());
            this.f1244c.setOnClickListener(new k());
            this.d.setOnClickListener(new l());
            this.f1239b.setOnClickListener(new m());
            this.e.setOnClickListener(new n());
            this.f1227a.setOnClickListener(new a());
            this.b.setOnClickListener(new b());
            this.c.setOnClickListener(new c());
            this.f1227a.setOnClickListener(new d());
            this.f1231a.setOnItemSelectedListener(new e());
            this.f1233a.setTableViewListener(this);
            ArrayList<ProfileModel> arrayList = qb0.f4822f;
            if (arrayList != null) {
                this.f1238a = new vp0(this.f1225a, arrayList);
                mp0 mp0 = new mp0(this.f1225a, this.f1238a);
                this.f1234a = mp0;
                this.f1233a.setAdapter(mp0);
                this.f1234a.x(this.f1238a.c(), this.f1238a.f(), this.f1238a.a());
            }
        } catch (Exception e2) {
            Toast.makeText(this.f1225a, e2.getMessage(), 1).show();
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        public void onClick(View v) {
            new AlertDialog.Builder(UsermanProfileActivity.this.f1225a).setIcon(17301543).setTitle("شرح لقيم الوقت والصلاحية عند التعديل فقط").setMessage("التفاصيل : " + "\n" + "w = اسبوع" + "\n" + "d = يوم" + "\n" + "h = ساعة" + "\n" + "m = دقيقة" + "\n" + "0s = غير محدود" + "\n مثال: " + "4w2d" + "تساوي 4اسابع و2 يوم = 30 يوم").setNegativeButton("تم", (DialogInterface.OnClickListener) null).show();
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        public void onClick(View v) {
            new o().execute(new String[0]);
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        public void onClick(View v) {
            UsermanProfileActivity.this.onBackPressed();
        }
    }

    class i implements View.OnClickListener {
        i() {
        }

        public void onClick(View v) {
            UsermanProfileActivity.this.f1230a.setVisibility(0);
            UsermanProfileActivity.this.f1241b.setVisibility(8);
        }
    }

    class j implements View.OnClickListener {
        j() {
        }

        public void onClick(View v) {
            UsermanProfileActivity.this.f1230a.setVisibility(8);
            UsermanProfileActivity.this.f1241b.setVisibility(0);
        }
    }

    class k implements View.OnClickListener {
        k() {
        }

        public void onClick(View v) {
            UsermanProfileActivity.this.i.setEnabled(true);
            if (UsermanProfileActivity.this.f1244c.isChecked()) {
                UsermanProfileActivity.this.f1239b.setChecked(false);
                UsermanProfileActivity.this.h.setEnabled(false);
                return;
            }
            UsermanProfileActivity.this.h.setEnabled(true);
        }
    }

    class l implements View.OnClickListener {
        l() {
        }

        public void onClick(View v) {
            UsermanProfileActivity.this.h.setEnabled(true);
            if (UsermanProfileActivity.this.d.isChecked()) {
                UsermanProfileActivity.this.f1239b.setChecked(false);
                UsermanProfileActivity.this.i.setEnabled(false);
                return;
            }
            UsermanProfileActivity.this.i.setEnabled(true);
        }
    }

    class m implements View.OnClickListener {
        m() {
        }

        public void onClick(View v) {
            if (UsermanProfileActivity.this.f1239b.isChecked()) {
                UsermanProfileActivity.this.f1244c.setChecked(false);
                UsermanProfileActivity.this.d.setChecked(false);
                UsermanProfileActivity.this.h.setEnabled(false);
                UsermanProfileActivity.this.i.setEnabled(false);
                return;
            }
            UsermanProfileActivity.this.h.setEnabled(true);
            UsermanProfileActivity.this.i.setEnabled(true);
        }
    }

    class n implements View.OnClickListener {
        n() {
        }

        public void onClick(View v) {
            if (UsermanProfileActivity.this.e.isChecked()) {
                UsermanProfileActivity.this.f1227a.setChecked(false);
                UsermanProfileActivity.this.f1245c.setEnabled(false);
                UsermanProfileActivity.this.f1248d.setEnabled(false);
                UsermanProfileActivity.this.f1245c.getText().clear();
                UsermanProfileActivity.this.f1248d.getText().clear();
                return;
            }
            UsermanProfileActivity.this.f1245c.setEnabled(true);
            UsermanProfileActivity.this.f1248d.setEnabled(true);
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View v) {
            if (UsermanProfileActivity.this.f1227a.isChecked()) {
                UsermanProfileActivity.this.e.setChecked(false);
                UsermanProfileActivity.this.f1245c.setText("720");
                UsermanProfileActivity.this.f1248d.setText("30");
                return;
            }
            UsermanProfileActivity.this.f1245c.getText().clear();
            UsermanProfileActivity.this.f1248d.getText().clear();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View v) {
            StringBuilder str = new StringBuilder();
            str.append("التفاصيل : ");
            str.append("\n");
            if (UsermanProfileActivity.this.f.getText().toString().trim().length() <= 0) {
                Toast.makeText(UsermanProfileActivity.this.f1225a, "الرجاء كتابة اسم الباقة/البروفايل", 0).show();
            } else if (!UsermanProfileActivity.this.f1242b.getSelectedItem().toString().equals("غير محدود") && UsermanProfileActivity.this.g.getText().toString().trim().length() <= 0) {
                Toast.makeText(UsermanProfileActivity.this.f1225a, "الرجاء كتابة حجم التحميل/النقل", 0).show();
            } else if (UsermanProfileActivity.this.h.getText().toString().trim().length() <= 0 && !UsermanProfileActivity.this.f1244c.isChecked() && !UsermanProfileActivity.this.f1239b.isChecked()) {
                Toast.makeText(UsermanProfileActivity.this.f1225a, "الرجاء كتابة الوقت/الساعات", 0).show();
            } else if (UsermanProfileActivity.this.j.getText().toString().trim().length() <= 0) {
                Toast.makeText(UsermanProfileActivity.this.f1225a, "الرجاء كتابة السعر", 0).show();
            } else if (UsermanProfileActivity.this.i.getText().toString().trim().length() > 0 || UsermanProfileActivity.this.d.isChecked() || UsermanProfileActivity.this.f1239b.isChecked()) {
                str.append(" اسم الباقة: " + UsermanProfileActivity.this.f.getText().toString());
                str.append("\n");
                str.append(" السعر: " + UsermanProfileActivity.this.j.getText().toString());
                str.append("\n");
                if (UsermanProfileActivity.this.f1242b.getSelectedItem().toString().equals("ميجا")) {
                    str.append(" التحميل: " + UsermanProfileActivity.this.g.getText().toString() + " ميجا ");
                    str.append("\n");
                } else if (UsermanProfileActivity.this.f1242b.getSelectedItem().toString().equals("جيجا")) {
                    str.append(" التحميل: " + UsermanProfileActivity.this.g.getText().toString() + " جيجا ");
                    str.append("\n");
                } else {
                    str.append(" غير محدود التحميل ");
                    str.append("\n");
                }
                if (UsermanProfileActivity.this.f1239b.isChecked()) {
                    str.append(" الوقت: شهري ");
                    str.append("\n");
                    str.append(" الصلاحية: شهري ");
                    str.append("\n");
                } else {
                    if (!UsermanProfileActivity.this.f1244c.isChecked() || UsermanProfileActivity.this.f1239b.isChecked()) {
                        str.append(" الوقت: " + UsermanProfileActivity.this.h.getText().toString());
                        if (UsermanProfileActivity.this.k.getText().toString().trim().length() > 0 && !UsermanProfileActivity.this.k.getText().toString().trim().equals("0")) {
                            str.append(" ساعة و " + UsermanProfileActivity.this.k.getText().toString() + " دقيقة ");
                        }
                        str.append("\n");
                    } else {
                        str.append("الوقت:غير محدود ");
                        str.append("\n");
                    }
                    if (!UsermanProfileActivity.this.d.isChecked() || UsermanProfileActivity.this.f1239b.isChecked()) {
                        str.append(" الصلاحية: " + UsermanProfileActivity.this.i.getText().toString() + " ايام ");
                        str.append("\n");
                    } else {
                        str.append("الصلاحية: غير محدود");
                        str.append("\n");
                    }
                }
                AlertDialog.Builder title = new AlertDialog.Builder(UsermanProfileActivity.this.f1225a).setIcon(17301543).setTitle("تنبية !");
                title.setMessage(str.toString() + " هل تريد الإضافة؟ ").setPositiveButton("نعم", new a()).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
            } else {
                Toast.makeText(UsermanProfileActivity.this.f1225a, "الرجاء كتابة الصلاحية/الايام", 0).show();
            }
        }

        class a implements DialogInterface.OnClickListener {
            a() {
            }

            public void onClick(DialogInterface dialog, int which) {
                new p().execute(new String[0]);
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View v) {
            StringBuilder str = new StringBuilder();
            if (UsermanProfileActivity.this.f1228a.getText().toString().trim().length() <= 0) {
                Toast.makeText(UsermanProfileActivity.this.f1225a, "الرجاء كتابة اسم الباقة/البروفايل", 0).show();
            } else if (!UsermanProfileActivity.this.f1231a.getSelectedItem().toString().equals("غير محدود") && UsermanProfileActivity.this.f1240b.getText().toString().trim().length() <= 0) {
                Toast.makeText(UsermanProfileActivity.this.f1225a, "الرجاء كتابة حجم التحميل/النقل", 0).show();
            } else if (UsermanProfileActivity.this.f1245c.getText().toString().trim().length() <= 0 && !UsermanProfileActivity.this.f1227a.isChecked()) {
                Toast.makeText(UsermanProfileActivity.this.f1225a, "الرجاء كتابة الوقت/الساعات", 0).show();
            } else if (UsermanProfileActivity.this.f1250e.getText().toString().trim().length() <= 0) {
                Toast.makeText(UsermanProfileActivity.this.f1225a, "الرجاء كتابة السعر", 0).show();
            } else if (UsermanProfileActivity.this.f1248d.getText().toString().trim().length() > 0 || UsermanProfileActivity.this.f1227a.isChecked()) {
                str.append(UsermanProfileActivity.this.f1228a.getText().toString());
                new AlertDialog.Builder(UsermanProfileActivity.this.f1225a).setIcon(17301543).setTitle("تنبية !").setMessage("هل تريد التعديل").setPositiveButton("نعم", new a()).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
            } else {
                Toast.makeText(UsermanProfileActivity.this.f1225a, "الرجاء كتابة الصلاحية/الايام", 0).show();
            }
        }

        class a implements DialogInterface.OnClickListener {
            a() {
            }

            public void onClick(DialogInterface dialog, int which) {
                new q().execute(new String[0]);
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        public void onClick(View v) {
            if (UsermanProfileActivity.this.f1227a.isChecked()) {
                UsermanProfileActivity.this.f1248d.setText("30d");
                UsermanProfileActivity.this.f1245c.setText("30d");
                UsermanProfileActivity.this.f1248d.setEnabled(false);
                UsermanProfileActivity.this.f1245c.setEnabled(false);
                return;
            }
            UsermanProfileActivity.this.f1248d.setEnabled(true);
            UsermanProfileActivity.this.f1245c.setEnabled(true);
            UsermanProfileActivity.this.f1248d.getText().clear();
            UsermanProfileActivity.this.f1245c.getText().clear();
        }
    }

    class e implements AdapterView.OnItemSelectedListener {
        e() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            if (adapterView.getItemAtPosition(position).toString().equals("غير محدود")) {
                UsermanProfileActivity.this.f1240b.getText().clear();
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public void p() {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        try {
            list1.add("ميجا");
            list1.add("جيجا");
            list1.add("غير محدود");
            ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<>(this, 17367048, list1);
            dataAdapter4.setDropDownViewResource(17367049);
            this.f1231a.setAdapter(dataAdapter4);
            this.f1242b.setAdapter(dataAdapter4);
            if (qb0.q != null) {
                for (int i2 = 0; i2 < qb0.q.size(); i2++) {
                    list2.add(qb0.q.get(i2).getUname());
                }
                ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367048, list2);
                arrayAdapter.setDropDownViewResource(17367049);
                this.f1246c.setAdapter(arrayAdapter);
            }
        } catch (Exception e2) {
            Toast.makeText(this.f1225a, e2.getMessage(), 1).show();
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(jv0.b(newBase));
    }

    class o extends AsyncTask<String, String, ArrayList<ProfileModel>> {

        /* renamed from: a  reason: collision with other field name */
        String f1251a = "";

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f1252a = null;

        /* renamed from: a  reason: collision with other field name */
        boolean f1253a = false;
        List<Map<String, String>> b = null;
        List<Map<String, String>> c = null;

        o() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            UsermanProfileActivity.this.f1224a.setTitle("يرجى الانتظار..");
            UsermanProfileActivity.this.f1224a.setMessage("جاري تحميل الباقات");
            UsermanProfileActivity.this.f1224a.setCancelable(false);
            UsermanProfileActivity.this.f1224a.setIndeterminate(false);
            UsermanProfileActivity.this.f1224a.show();
            UsermanProfileActivity.this.f1237a.clear();
        }

        /* access modifiers changed from: protected */
        /*  JADX ERROR: NullPointerException in pass: CodeShrinkVisitor
            java.lang.NullPointerException
            */
        /* renamed from: a */
        public java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel> doInBackground(java.lang.String... r40) {
            /*
                r39 = this;
                r1 = r39
                r2 = 1
                com.blogspot.yemeninfo4it.mumsmobile_app.activities.UsermanProfileActivity r0 = com.blogspot.yemeninfo4it.mumsmobile_app.activities.UsermanProfileActivity.this     // Catch:{ Exception -> 0x02ac }
                j3 r0 = r0.f1235a     // Catch:{ Exception -> 0x02ac }
                boolean r0 = r0.w()     // Catch:{ Exception -> 0x02ac }
                if (r0 == 0) goto L_0x02aa
                com.blogspot.yemeninfo4it.mumsmobile_app.model.Interface r0 = defpackage.qb0.f4798a     // Catch:{ Exception -> 0x02ac }
                java.lang.String r0 = r0.getVersion()     // Catch:{ Exception -> 0x02ac }
                r3 = 0
                if (r0 == 0) goto L_0x0025
                com.blogspot.yemeninfo4it.mumsmobile_app.model.Interface r0 = defpackage.qb0.f4798a     // Catch:{ Exception -> 0x02ac }
                java.lang.String r0 = r0.getVersion()     // Catch:{ Exception -> 0x02ac }
                java.lang.String r0 = r0.substring(r3, r2)     // Catch:{ Exception -> 0x02ac }
                int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x02ac }
                goto L_0x0026
            L_0x0025:
                r0 = 6
            L_0x0026:
                r4 = 7
                java.lang.String r5 = "download-limit"
                java.lang.String r6 = "validity"
                java.lang.String r7 = "uptime-limit"
                java.lang.String r8 = "price"
                java.lang.String r9 = "transfer-limit"
                java.lang.String r10 = "' return .id,transfer-limit,uptime-limit,download-limit"
                java.lang.String r11 = "ODAIData"
                java.lang.String r12 = "ODAI_DATA"
                java.lang.String r13 = "' return limitation"
                java.lang.String r14 = ".id"
                java.lang.String r15 = "limitation"
                java.lang.String r2 = "name"
                java.lang.String r3 = "ProfileData"
                java.lang.String r16 = ""
                if (r0 < r4) goto L_0x0170
                com.blogspot.yemeninfo4it.mumsmobile_app.activities.UsermanProfileActivity r4 = com.blogspot.yemeninfo4it.mumsmobile_app.activities.UsermanProfileActivity.this     // Catch:{ Exception -> 0x02ac }
                j3 r4 = r4.f1235a     // Catch:{ Exception -> 0x02ac }
                r17 = r0
                java.lang.String r0 = "/user-manager/profile/print return .id,name,price,validity"
                java.util.List r0 = r4.q(r0)     // Catch:{ Exception -> 0x02ac }
                r1.f1252a = r0     // Catch:{ Exception -> 0x02ac }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x02ac }
            L_0x0057:
                boolean r4 = r0.hasNext()     // Catch:{ Exception -> 0x02ac }
                if (r4 == 0) goto L_0x016e
                java.lang.Object r4 = r0.next()     // Catch:{ Exception -> 0x02ac }
                java.util.Map r4 = (java.util.Map) r4     // Catch:{ Exception -> 0x02ac }
                r18 = r16
                r19 = r16
                r20 = r16
                r21 = r16
                r22 = r16
                r23 = r16
                r24 = r0
                java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x02ac }
                android.util.Log.d(r3, r0)     // Catch:{ Exception -> 0x02ac }
                com.blogspot.yemeninfo4it.mumsmobile_app.activities.UsermanProfileActivity r0 = com.blogspot.yemeninfo4it.mumsmobile_app.activities.UsermanProfileActivity.this     // Catch:{ Exception -> 0x02ac }
                j3 r0 = r0.f1235a     // Catch:{ Exception -> 0x02ac }
                r25 = r6
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ac }
                r6.<init>()     // Catch:{ Exception -> 0x02ac }
                r26 = r8
                java.lang.String r8 = "/user-manager/profile-limitation/print where profile='"
                r6.append(r8)     // Catch:{ Exception -> 0x02ac }
                java.lang.Object r8 = r4.get(r2)     // Catch:{ Exception -> 0x02ac }
                java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x02ac }
                r6.append(r8)     // Catch:{ Exception -> 0x02ac }
                r6.append(r13)     // Catch:{ Exception -> 0x02ac }
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x02ac }
                java.util.List r0 = r0.q(r6)     // Catch:{ Exception -> 0x02ac }
                r1.b = r0     // Catch:{ Exception -> 0x02ac }
                r6 = 0
                java.lang.Object r0 = r0.get(r6)     // Catch:{ Exception -> 0x02ac }
                java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x02ac }
                java.lang.Object r0 = r0.get(r15)     // Catch:{ Exception -> 0x02ac }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x02ac }
                android.util.Log.d(r12, r0)     // Catch:{ Exception -> 0x02ac }
                java.util.List<java.util.Map<java.lang.String, java.lang.String>> r0 = r1.b     // Catch:{ Exception -> 0x02ac }
                r6 = 0
                java.lang.Object r0 = r0.get(r6)     // Catch:{ Exception -> 0x02ac }
                java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x02ac }
                java.lang.Object r0 = r0.get(r15)     // Catch:{ Exception -> 0x02ac }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x02ac }
                android.util.Log.d(r11, r0)     // Catch:{ Exception -> 0x02ac }
                com.blogspot.yemeninfo4it.mumsmobile_app.activities.UsermanProfileActivity r6 = com.blogspot.yemeninfo4it.mumsmobile_app.activities.UsermanProfileActivity.this     // Catch:{ Exception -> 0x02ac }
                j3 r6 = r6.f1235a     // Catch:{ Exception -> 0x02ac }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ac }
                r8.<init>()     // Catch:{ Exception -> 0x02ac }
                r18 = r11
                java.lang.String r11 = "/user-manager/limitation/print where name='"
                r8.append(r11)     // Catch:{ Exception -> 0x02ac }
                r8.append(r0)     // Catch:{ Exception -> 0x02ac }
                r8.append(r10)     // Catch:{ Exception -> 0x02ac }
                java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x02ac }
                java.util.List r6 = r6.q(r8)     // Catch:{ Exception -> 0x02ac }
                r1.c = r6     // Catch:{ Exception -> 0x02ac }
                java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x02ac }
            L_0x00e6:
                boolean r8 = r6.hasNext()     // Catch:{ Exception -> 0x02ac }
                if (r8 == 0) goto L_0x0127
                java.lang.Object r8 = r6.next()     // Catch:{ Exception -> 0x02ac }
                java.util.Map r8 = (java.util.Map) r8     // Catch:{ Exception -> 0x02ac }
                java.lang.String r11 = r8.toString()     // Catch:{ Exception -> 0x02ac }
                android.util.Log.d(r3, r11)     // Catch:{ Exception -> 0x02ac }
                java.lang.Object r11 = r8.get(r9)     // Catch:{ Exception -> 0x02ac }
                java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x02ac }
                r21 = r11
                java.lang.Object r11 = r8.get(r7)     // Catch:{ Exception -> 0x02ac }
                java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x02ac }
                r22 = r11
                java.lang.Object r11 = r8.get(r14)     // Catch:{ Exception -> 0x02ac }
                java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x02ac }
                r19 = r11
                java.util.List<java.util.Map<java.lang.String, java.lang.String>> r11 = r1.c     // Catch:{ Exception -> 0x02ac }
                r27 = r6
                r6 = 0
                java.lang.Object r11 = r11.get(r6)     // Catch:{ Exception -> 0x02ac }
                java.util.Map r11 = (java.util.Map) r11     // Catch:{ Exception -> 0x02ac }
                java.lang.Object r6 = r11.get(r5)     // Catch:{ Exception -> 0x02ac }
                java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x02ac }
                r20 = r6
                r6 = r27
                goto L_0x00e6
            L_0x0127:
                com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel r6 = new com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel     // Catch:{ Exception -> 0x02ac }
                java.lang.Object r8 = r4.get(r14)     // Catch:{ Exception -> 0x02ac }
                r28 = r8
                java.lang.String r28 = (java.lang.String) r28     // Catch:{ Exception -> 0x02ac }
                java.lang.Object r8 = r4.get(r2)     // Catch:{ Exception -> 0x02ac }
                r29 = r8
                java.lang.String r29 = (java.lang.String) r29     // Catch:{ Exception -> 0x02ac }
                r8 = r26
                java.lang.Object r11 = r4.get(r8)     // Catch:{ Exception -> 0x02ac }
                r30 = r11
                java.lang.String r30 = (java.lang.String) r30     // Catch:{ Exception -> 0x02ac }
                r11 = r25
                java.lang.Object r25 = r4.get(r11)     // Catch:{ Exception -> 0x02ac }
                r34 = r25
                java.lang.String r34 = (java.lang.String) r34     // Catch:{ Exception -> 0x02ac }
                java.lang.String r37 = ""
                r27 = r6
                r31 = r21
                r32 = r20
                r33 = r22
                r35 = r19
                r36 = r0
                r27.<init>(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37)     // Catch:{ Exception -> 0x02ac }
                r25 = r0
                com.blogspot.yemeninfo4it.mumsmobile_app.activities.UsermanProfileActivity r0 = com.blogspot.yemeninfo4it.mumsmobile_app.activities.UsermanProfileActivity.this     // Catch:{ Exception -> 0x02ac }
                java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel> r0 = r0.f1237a     // Catch:{ Exception -> 0x02ac }
                r0.add(r6)     // Catch:{ Exception -> 0x02ac }
                r6 = r11
                r11 = r18
                r0 = r24
                goto L_0x0057
            L_0x016e:
                goto L_0x02a8
            L_0x0170:
                r17 = r0
                r18 = r11
                r11 = r6
                com.blogspot.yemeninfo4it.mumsmobile_app.activities.UsermanProfileActivity r0 = com.blogspot.yemeninfo4it.mumsmobile_app.activities.UsermanProfileActivity.this     // Catch:{ Exception -> 0x02ac }
                j3 r0 = r0.f1235a     // Catch:{ Exception -> 0x02ac }
                java.lang.String r4 = "/tool/user-manager/profile/print return .id,name,price,validity"
                java.util.List r0 = r0.q(r4)     // Catch:{ Exception -> 0x02ac }
                r1.f1252a = r0     // Catch:{ Exception -> 0x02ac }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x02ac }
            L_0x0185:
                boolean r4 = r0.hasNext()     // Catch:{ Exception -> 0x02ac }
                if (r4 == 0) goto L_0x02a8
                java.lang.Object r4 = r0.next()     // Catch:{ Exception -> 0x02ac }
                java.util.Map r4 = (java.util.Map) r4     // Catch:{ Exception -> 0x02ac }
                r6 = r16
                r19 = r16
                r20 = r16
                r21 = r16
                r22 = r16
                r23 = r16
                r24 = r0
                java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x02ac }
                android.util.Log.d(r3, r0)     // Catch:{ Exception -> 0x02ac }
                com.blogspot.yemeninfo4it.mumsmobile_app.activities.UsermanProfileActivity r0 = com.blogspot.yemeninfo4it.mumsmobile_app.activities.UsermanProfileActivity.this     // Catch:{ Exception -> 0x02ac }
                j3 r0 = r0.f1235a     // Catch:{ Exception -> 0x02ac }
                r25 = r6
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ac }
                r6.<init>()     // Catch:{ Exception -> 0x02ac }
                r26 = r11
                java.lang.String r11 = "/tool/user-manager/profile/profile-limitation/print where profile='"
                r6.append(r11)     // Catch:{ Exception -> 0x02ac }
                java.lang.Object r11 = r4.get(r2)     // Catch:{ Exception -> 0x02ac }
                java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x02ac }
                r6.append(r11)     // Catch:{ Exception -> 0x02ac }
                r6.append(r13)     // Catch:{ Exception -> 0x02ac }
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x02ac }
                java.util.List r0 = r0.q(r6)     // Catch:{ Exception -> 0x02ac }
                r1.b = r0     // Catch:{ Exception -> 0x02ac }
                r6 = 0
                java.lang.Object r0 = r0.get(r6)     // Catch:{ Exception -> 0x02ac }
                java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x02ac }
                java.lang.Object r0 = r0.get(r15)     // Catch:{ Exception -> 0x02ac }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x02ac }
                android.util.Log.d(r12, r0)     // Catch:{ Exception -> 0x02ac }
                java.util.List<java.util.Map<java.lang.String, java.lang.String>> r0 = r1.b     // Catch:{ Exception -> 0x02ac }
                r6 = 0
                java.lang.Object r0 = r0.get(r6)     // Catch:{ Exception -> 0x02ac }
                java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x02ac }
                java.lang.Object r0 = r0.get(r15)     // Catch:{ Exception -> 0x02ac }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x02ac }
                r6 = r18
                android.util.Log.d(r6, r0)     // Catch:{ Exception -> 0x02ac }
                com.blogspot.yemeninfo4it.mumsmobile_app.activities.UsermanProfileActivity r11 = com.blogspot.yemeninfo4it.mumsmobile_app.activities.UsermanProfileActivity.this     // Catch:{ Exception -> 0x02ac }
                j3 r11 = r11.f1235a     // Catch:{ Exception -> 0x02ac }
                r18 = r6
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ac }
                r6.<init>()     // Catch:{ Exception -> 0x02ac }
                r25 = r12
                java.lang.String r12 = "/tool/user-manager/profile/limitation/print where name='"
                r6.append(r12)     // Catch:{ Exception -> 0x02ac }
                r6.append(r0)     // Catch:{ Exception -> 0x02ac }
                r6.append(r10)     // Catch:{ Exception -> 0x02ac }
                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x02ac }
                java.util.List r6 = r11.q(r6)     // Catch:{ Exception -> 0x02ac }
                r1.c = r6     // Catch:{ Exception -> 0x02ac }
                java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x02ac }
            L_0x0218:
                boolean r11 = r6.hasNext()     // Catch:{ Exception -> 0x02ac }
                if (r11 == 0) goto L_0x0259
                java.lang.Object r11 = r6.next()     // Catch:{ Exception -> 0x02ac }
                java.util.Map r11 = (java.util.Map) r11     // Catch:{ Exception -> 0x02ac }
                java.lang.String r12 = r11.toString()     // Catch:{ Exception -> 0x02ac }
                android.util.Log.d(r3, r12)     // Catch:{ Exception -> 0x02ac }
                java.lang.Object r12 = r11.get(r9)     // Catch:{ Exception -> 0x02ac }
                java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x02ac }
                r21 = r12
                java.lang.Object r12 = r11.get(r7)     // Catch:{ Exception -> 0x02ac }
                java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x02ac }
                r22 = r12
                java.lang.Object r12 = r11.get(r14)     // Catch:{ Exception -> 0x02ac }
                java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x02ac }
                r19 = r12
                java.util.List<java.util.Map<java.lang.String, java.lang.String>> r12 = r1.c     // Catch:{ Exception -> 0x02ac }
                r38 = r3
                r3 = 0
                java.lang.Object r12 = r12.get(r3)     // Catch:{ Exception -> 0x02ac }
                java.util.Map r12 = (java.util.Map) r12     // Catch:{ Exception -> 0x02ac }
                java.lang.Object r12 = r12.get(r5)     // Catch:{ Exception -> 0x02ac }
                java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x02ac }
                r20 = r12
                r3 = r38
                goto L_0x0218
            L_0x0259:
                r38 = r3
                r3 = 0
                com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel r6 = new com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel     // Catch:{ Exception -> 0x02ac }
                java.lang.Object r11 = r4.get(r14)     // Catch:{ Exception -> 0x02ac }
                r28 = r11
                java.lang.String r28 = (java.lang.String) r28     // Catch:{ Exception -> 0x02ac }
                java.lang.Object r11 = r4.get(r2)     // Catch:{ Exception -> 0x02ac }
                r29 = r11
                java.lang.String r29 = (java.lang.String) r29     // Catch:{ Exception -> 0x02ac }
                java.lang.Object r11 = r4.get(r8)     // Catch:{ Exception -> 0x02ac }
                r30 = r11
                java.lang.String r30 = (java.lang.String) r30     // Catch:{ Exception -> 0x02ac }
                r11 = r26
                java.lang.Object r12 = r4.get(r11)     // Catch:{ Exception -> 0x02ac }
                r34 = r12
                java.lang.String r34 = (java.lang.String) r34     // Catch:{ Exception -> 0x02ac }
                java.lang.String r12 = "owner"
                java.lang.Object r12 = r4.get(r12)     // Catch:{ Exception -> 0x02ac }
                r37 = r12
                java.lang.String r37 = (java.lang.String) r37     // Catch:{ Exception -> 0x02ac }
                r27 = r6
                r31 = r21
                r32 = r20
                r33 = r22
                r35 = r19
                r36 = r0
                r27.<init>(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37)     // Catch:{ Exception -> 0x02ac }
                com.blogspot.yemeninfo4it.mumsmobile_app.activities.UsermanProfileActivity r12 = com.blogspot.yemeninfo4it.mumsmobile_app.activities.UsermanProfileActivity.this     // Catch:{ Exception -> 0x02ac }
                java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel> r12 = r12.f1237a     // Catch:{ Exception -> 0x02ac }
                r12.add(r6)     // Catch:{ Exception -> 0x02ac }
                r0 = r24
                r12 = r25
                r3 = r38
                goto L_0x0185
            L_0x02a8:
                goto L_0x02b6
            L_0x02aa:
                r0 = 0
                return r0
            L_0x02ac:
                r0 = move-exception
                java.lang.String r2 = r0.getMessage()     // Catch:{ Exception -> 0x02b7 }
                r1.f1251a = r2     // Catch:{ Exception -> 0x02b7 }
                r2 = 1
                r1.f1253a = r2     // Catch:{ Exception -> 0x02b7 }
            L_0x02b6:
                goto L_0x02c1
            L_0x02b7:
                r0 = move-exception
                java.lang.String r2 = r0.getMessage()
                r1.f1251a = r2
                r2 = 1
                r1.f1253a = r2
            L_0x02c1:
                com.blogspot.yemeninfo4it.mumsmobile_app.activities.UsermanProfileActivity r0 = com.blogspot.yemeninfo4it.mumsmobile_app.activities.UsermanProfileActivity.this
                java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel> r0 = r0.f1237a
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blogspot.yemeninfo4it.mumsmobile_app.activities.UsermanProfileActivity.o.doInBackground(java.lang.String[]):java.util.ArrayList");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(ArrayList<ProfileModel> result) {
            super.onPostExecute(result);
            try {
                if (this.f1253a) {
                    Toast.makeText(UsermanProfileActivity.this.f1225a, this.f1251a, 1).show();
                } else {
                    Toast.makeText(UsermanProfileActivity.this.f1225a, "تم جلب البيانات", 1).show();
                }
                qb0.f4822f = result;
                UsermanProfileActivity usermanProfileActivity = UsermanProfileActivity.this;
                vp0 unused = usermanProfileActivity.f1238a = new vp0(usermanProfileActivity.f1225a, result);
                UsermanProfileActivity usermanProfileActivity2 = UsermanProfileActivity.this;
                UsermanProfileActivity usermanProfileActivity3 = UsermanProfileActivity.this;
                d0 unused2 = usermanProfileActivity2.f1234a = new mp0(usermanProfileActivity3.f1225a, usermanProfileActivity3.f1238a);
                UsermanProfileActivity.this.f1233a.setAdapter(UsermanProfileActivity.this.f1234a);
                UsermanProfileActivity.this.f1234a.x(UsermanProfileActivity.this.f1238a.c(), UsermanProfileActivity.this.f1238a.f(), UsermanProfileActivity.this.f1238a.a());
                UsermanProfileActivity.this.c.setVisibility(0);
                UsermanProfileActivity.this.f1224a.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
                UsermanProfileActivity.this.f1224a.dismiss();
                Toast.makeText(UsermanProfileActivity.this.f1225a, this.f1251a, 1).show();
            }
        }
    }

    class p extends AsyncTask<String, Void, String> {

        /* renamed from: a  reason: collision with other field name */
        String f1254a = "";

        /* renamed from: a  reason: collision with other field name */
        ArrayList<ProfileModel> f1255a = new ArrayList<>();

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f1256a = null;

        /* renamed from: a  reason: collision with other field name */
        boolean f1257a = false;
        String b = "0";

        /* renamed from: b  reason: collision with other field name */
        List<Map<String, String>> f1258b = null;
        String c = "";

        /* renamed from: c  reason: collision with other field name */
        List<Map<String, String>> f1259c = null;
        String d = "";
        String e = "";
        String f = "";
        String g = "";

        p() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            UsermanProfileActivity.this.f1224a.setTitle("يرجى الانتظار..");
            UsermanProfileActivity.this.f1224a.setMessage("جاري اضافة الباقة");
            UsermanProfileActivity.this.f1224a.setCancelable(false);
            UsermanProfileActivity.this.f1224a.setIndeterminate(false);
            UsermanProfileActivity.this.f1224a.show();
            if (UsermanProfileActivity.this.f1242b.getSelectedItem().toString().equals("ميجا")) {
                this.b = String.valueOf((long) (Double.parseDouble(UsermanProfileActivity.this.g.getText().toString()) * 1048576.0d));
            } else if (UsermanProfileActivity.this.f1242b.getSelectedItem().toString().equals("جيجا")) {
                this.b = String.valueOf((long) (Double.parseDouble(UsermanProfileActivity.this.g.getText().toString()) * 1.073741824E9d));
            } else {
                this.b = "0";
            }
            if (UsermanProfileActivity.this.f1239b.isChecked()) {
                this.c = "30d";
                this.d = "30d";
                return;
            }
            if (!UsermanProfileActivity.this.f1244c.isChecked() || UsermanProfileActivity.this.f1239b.isChecked()) {
                if (UsermanProfileActivity.this.h.getText().toString().trim().length() <= 0 || UsermanProfileActivity.this.h.getText().toString().trim().equals("0")) {
                    this.c = UsermanProfileActivity.this.h.getText().toString() + "h";
                } else {
                    this.c = UsermanProfileActivity.this.h.getText().toString() + "h";
                }
                if (UsermanProfileActivity.this.k.getText().toString().trim().length() > 0 && !UsermanProfileActivity.this.k.getText().toString().trim().equals("0")) {
                    this.c += UsermanProfileActivity.this.k.getText().toString() + "m";
                }
            } else {
                this.c = "0s";
            }
            if (UsermanProfileActivity.this.d.isChecked()) {
                this.d = "0s";
                return;
            }
            this.d = UsermanProfileActivity.this.i.getText().toString() + "d";
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                if (!UsermanProfileActivity.this.f1235a.w()) {
                    return null;
                }
                if ((qb0.f4798a.getVersion() != null ? Integer.parseInt(qb0.f4798a.getVersion().substring(0, 1)) : 6) >= 7) {
                    j3 j3Var = UsermanProfileActivity.this.f1235a;
                    this.f1256a = j3Var.q("/user-manager/profile/add name=\"" + UsermanProfileActivity.this.f.getText().toString() + "\" name-for-users=\"" + UsermanProfileActivity.this.f.getText().toString() + "\" starts-when='first-auth' price=" + UsermanProfileActivity.this.j.getText().toString() + " validity=" + this.d + "");
                    j3 j3Var2 = UsermanProfileActivity.this.f1235a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("/user-manager/limitation/add name=\"");
                    sb.append(UsermanProfileActivity.this.f.getText().toString());
                    sb.append("\" transfer-limit=");
                    sb.append(this.b);
                    sb.append("B uptime-limit=");
                    sb.append(this.c);
                    sb.append("");
                    this.f1259c = j3Var2.q(sb.toString());
                    j3 j3Var3 = UsermanProfileActivity.this.f1235a;
                    this.f1258b = j3Var3.q("/user-manager/profile-limitation/add profile=\"" + UsermanProfileActivity.this.f.getText().toString() + "\" limitation=\"" + UsermanProfileActivity.this.f.getText().toString() + "\"");
                    for (Map<String, String> res : this.f1256a) {
                        this.e = res.get("ret");
                    }
                    for (Map<String, String> res2 : this.f1259c) {
                        this.f = res2.get("ret");
                    }
                    for (Map<String, String> res3 : this.f1258b) {
                        this.g = res3.get("ret");
                    }
                    this.f1255a.add(new ProfileModel(this.e, UsermanProfileActivity.this.f.getText().toString(), UsermanProfileActivity.this.j.getText().toString(), String.valueOf(this.b), "0", this.c, this.d, this.f, this.g, ""));
                } else {
                    j3 j3Var4 = UsermanProfileActivity.this.f1235a;
                    this.f1256a = j3Var4.q("/tool/user-manager/profile/add name=\"" + UsermanProfileActivity.this.f.getText().toString() + "\" name-for-users=\"" + UsermanProfileActivity.this.f.getText().toString() + "\" starts-at='logon' price=" + UsermanProfileActivity.this.j.getText().toString() + " validity=" + this.d + " owner=" + UsermanProfileActivity.this.f1246c.getSelectedItem().toString() + "");
                    j3 j3Var5 = UsermanProfileActivity.this.f1235a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("/tool/user-manager/profile/limitation/add name=\"");
                    sb2.append(UsermanProfileActivity.this.f.getText().toString());
                    sb2.append("\" transfer-limit=");
                    sb2.append(this.b);
                    sb2.append("B uptime-limit=");
                    sb2.append(this.c);
                    sb2.append(" owner=");
                    sb2.append(UsermanProfileActivity.this.f1246c.getSelectedItem().toString());
                    sb2.append("");
                    this.f1259c = j3Var5.q(sb2.toString());
                    j3 j3Var6 = UsermanProfileActivity.this.f1235a;
                    this.f1258b = j3Var6.q("/tool/user-manager/profile/profile-limitation/add profile=\"" + UsermanProfileActivity.this.f.getText().toString() + "\" limitation=\"" + UsermanProfileActivity.this.f.getText().toString() + "\"");
                    for (Map<String, String> res4 : this.f1256a) {
                        this.e = res4.get("ret");
                    }
                    for (Map<String, String> res5 : this.f1259c) {
                        this.f = res5.get("ret");
                    }
                    for (Map<String, String> res6 : this.f1258b) {
                        this.g = res6.get("ret");
                    }
                    UsermanProfileActivity.this.f1237a.add(new ProfileModel(this.e, UsermanProfileActivity.this.f.getText().toString(), UsermanProfileActivity.this.j.getText().toString(), String.valueOf(this.b), "0", this.c, this.d, this.f, this.g, UsermanProfileActivity.this.f1246c.getSelectedItem().toString()));
                }
                return null;
            } catch (Exception e2) {
                try {
                    Log.d("ODAI_ERROR", e2.getMessage());
                    this.f1254a = e2.getMessage();
                    this.f1257a = true;
                } catch (Exception e3) {
                    Log.d("ODAI_ERROR2", e3.getMessage());
                    this.f1254a = e3.getMessage();
                    this.f1257a = true;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            try {
                if (this.f1257a) {
                    Toast.makeText(UsermanProfileActivity.this.f1225a, this.f1254a, 1).show();
                } else {
                    Toast.makeText(UsermanProfileActivity.this.f1225a, "تم إضافة الباقة بنجاح", 0).show();
                    try {
                        UsermanProfileActivity.this.f1230a.setVisibility(8);
                        UsermanProfileActivity.this.f1241b.setVisibility(0);
                        new o().execute(new String[0]);
                    } catch (Exception ttr) {
                        Toast.makeText(UsermanProfileActivity.this.f1225a, ttr.getMessage(), 1).show();
                    }
                }
                UsermanProfileActivity.this.f1224a.dismiss();
            } catch (Exception e2) {
                e2.printStackTrace();
                UsermanProfileActivity.this.f1224a.dismiss();
                Toast.makeText(UsermanProfileActivity.this.f1225a, this.f1254a, 1).show();
            }
        }
    }

    class q extends AsyncTask<String, Void, String> {

        /* renamed from: a  reason: collision with other field name */
        String f1260a = "";

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f1261a = null;

        /* renamed from: a  reason: collision with other field name */
        boolean f1262a = false;
        String b = "0";

        /* renamed from: b  reason: collision with other field name */
        List<Map<String, String>> f1263b = null;
        String c = "";

        /* renamed from: c  reason: collision with other field name */
        List<Map<String, String>> f1264c = null;
        String d = "";
        String e = "";
        String f = "";
        String g = "";

        q() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            UsermanProfileActivity.this.f1224a.setTitle("يرجى الانتظار..");
            UsermanProfileActivity.this.f1224a.setMessage("جاري تعدبل الباقة");
            UsermanProfileActivity.this.f1224a.setCancelable(false);
            UsermanProfileActivity.this.f1224a.setIndeterminate(false);
            UsermanProfileActivity.this.f1224a.show();
            if (UsermanProfileActivity.this.f1231a.getSelectedItem().toString().equals("ميجا")) {
                this.b = String.valueOf((long) (Double.parseDouble(UsermanProfileActivity.this.f1240b.getText().toString()) * 1048576.0d)) + "B";
            } else if (UsermanProfileActivity.this.f1231a.getSelectedItem().toString().equals("جيجا")) {
                this.b = String.valueOf((long) (Double.parseDouble(UsermanProfileActivity.this.f1240b.getText().toString()) * 1.073741824E9d)) + "B";
            } else {
                this.b = "0";
            }
            if (UsermanProfileActivity.this.f1227a.isChecked()) {
                this.c = "30d";
                this.d = "30d";
            } else if (UsermanProfileActivity.this.e.isChecked()) {
                this.c = "0s";
                this.d = "0s";
            } else {
                this.c = UsermanProfileActivity.this.f1245c.getText().toString();
                this.d = UsermanProfileActivity.this.f1248d.getText().toString();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                if (!UsermanProfileActivity.this.f1235a.w()) {
                    return null;
                }
                if ((qb0.f4798a.getVersion() != null ? Integer.parseInt(qb0.f4798a.getVersion().substring(0, 1)) : 6) >= 7) {
                    j3 j3Var = UsermanProfileActivity.this.f1235a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("/user-manager/profile/set .id=");
                    UsermanProfileActivity usermanProfileActivity = UsermanProfileActivity.this;
                    sb.append(usermanProfileActivity.f1237a.get(usermanProfileActivity.a).getId());
                    sb.append(" name=\"");
                    sb.append(UsermanProfileActivity.this.f1228a.getText().toString());
                    sb.append("\" name-for-users=\"");
                    sb.append(UsermanProfileActivity.this.f1228a.getText().toString());
                    sb.append("\" price=");
                    sb.append(UsermanProfileActivity.this.f1250e.getText().toString());
                    sb.append(" validity=");
                    sb.append(this.d);
                    sb.append("");
                    this.f1261a = j3Var.q(sb.toString());
                    j3 j3Var2 = UsermanProfileActivity.this.f1235a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("/user-manager/limitation/set .id=");
                    UsermanProfileActivity usermanProfileActivity2 = UsermanProfileActivity.this;
                    sb2.append(usermanProfileActivity2.f1237a.get(usermanProfileActivity2.a).getLimitation());
                    sb2.append(" transfer-limit=");
                    sb2.append(this.b);
                    sb2.append(" uptime-limit=");
                    sb2.append(this.c);
                    sb2.append("");
                    this.f1264c = j3Var2.q(sb2.toString());
                    UsermanProfileActivity usermanProfileActivity3 = UsermanProfileActivity.this;
                    usermanProfileActivity3.f1237a.get(usermanProfileActivity3.a).setName(UsermanProfileActivity.this.f1228a.getText().toString());
                    UsermanProfileActivity usermanProfileActivity4 = UsermanProfileActivity.this;
                    usermanProfileActivity4.f1237a.get(usermanProfileActivity4.a).setPrice(UsermanProfileActivity.this.f1250e.getText().toString());
                    UsermanProfileActivity usermanProfileActivity5 = UsermanProfileActivity.this;
                    usermanProfileActivity5.f1237a.get(usermanProfileActivity5.a).setTime_limit(this.c);
                    UsermanProfileActivity usermanProfileActivity6 = UsermanProfileActivity.this;
                    usermanProfileActivity6.f1237a.get(usermanProfileActivity6.a).setValidty_limit(this.d);
                    UsermanProfileActivity usermanProfileActivity7 = UsermanProfileActivity.this;
                    usermanProfileActivity7.f1237a.get(usermanProfileActivity7.a).setTrans_limit(this.b);
                } else {
                    j3 j3Var3 = UsermanProfileActivity.this.f1235a;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("/tool/user-manager/profile/set .id=");
                    UsermanProfileActivity usermanProfileActivity8 = UsermanProfileActivity.this;
                    sb3.append(usermanProfileActivity8.f1237a.get(usermanProfileActivity8.a).getId());
                    sb3.append(" name=\"");
                    sb3.append(UsermanProfileActivity.this.f1228a.getText().toString());
                    sb3.append("\" name-for-users=\"");
                    sb3.append(UsermanProfileActivity.this.f1228a.getText().toString());
                    sb3.append("\" price=");
                    sb3.append(UsermanProfileActivity.this.f1250e.getText().toString());
                    sb3.append(" validity=");
                    sb3.append(this.d);
                    sb3.append(" owner=");
                    sb3.append(UsermanProfileActivity.this.f1246c.getSelectedItem().toString());
                    sb3.append("");
                    this.f1261a = j3Var3.q(sb3.toString());
                    j3 j3Var4 = UsermanProfileActivity.this.f1235a;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("/tool/user-manager/profile/limitation/set .id=");
                    UsermanProfileActivity usermanProfileActivity9 = UsermanProfileActivity.this;
                    sb4.append(usermanProfileActivity9.f1237a.get(usermanProfileActivity9.a).getLimitation());
                    sb4.append(" transfer-limit=");
                    sb4.append(this.b);
                    sb4.append(" uptime-limit=");
                    sb4.append(this.c);
                    sb4.append(" owner=");
                    sb4.append(UsermanProfileActivity.this.f1246c.getSelectedItem().toString());
                    sb4.append("");
                    this.f1264c = j3Var4.q(sb4.toString());
                    UsermanProfileActivity usermanProfileActivity10 = UsermanProfileActivity.this;
                    usermanProfileActivity10.f1237a.get(usermanProfileActivity10.a).setName(UsermanProfileActivity.this.f1228a.getText().toString());
                    UsermanProfileActivity usermanProfileActivity11 = UsermanProfileActivity.this;
                    usermanProfileActivity11.f1237a.get(usermanProfileActivity11.a).setPrice(UsermanProfileActivity.this.f1250e.getText().toString());
                    UsermanProfileActivity usermanProfileActivity12 = UsermanProfileActivity.this;
                    usermanProfileActivity12.f1237a.get(usermanProfileActivity12.a).setTime_limit(this.c);
                    UsermanProfileActivity usermanProfileActivity13 = UsermanProfileActivity.this;
                    usermanProfileActivity13.f1237a.get(usermanProfileActivity13.a).setValidty_limit(this.d);
                    UsermanProfileActivity usermanProfileActivity14 = UsermanProfileActivity.this;
                    usermanProfileActivity14.f1237a.get(usermanProfileActivity14.a).setTrans_limit(this.b);
                }
                return null;
            } catch (Exception e2) {
                try {
                    Log.d("ODAI_ERROR", e2.getMessage());
                    this.f1260a = e2.getMessage();
                    this.f1262a = true;
                } catch (Exception e3) {
                    Log.d("ODAI_ERROR2", e3.getMessage());
                    this.f1260a = e3.getMessage();
                    this.f1262a = true;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            try {
                if (this.f1262a) {
                    Toast.makeText(UsermanProfileActivity.this.f1225a, this.f1260a, 1).show();
                } else {
                    UsermanProfileActivity usermanProfileActivity = UsermanProfileActivity.this;
                    vp0 unused = usermanProfileActivity.f1238a = new vp0(usermanProfileActivity.f1225a, usermanProfileActivity.f1237a);
                    UsermanProfileActivity usermanProfileActivity2 = UsermanProfileActivity.this;
                    UsermanProfileActivity usermanProfileActivity3 = UsermanProfileActivity.this;
                    d0 unused2 = usermanProfileActivity2.f1234a = new mp0(usermanProfileActivity3.f1225a, usermanProfileActivity3.f1238a);
                    UsermanProfileActivity.this.f1233a.setAdapter(UsermanProfileActivity.this.f1234a);
                    UsermanProfileActivity.this.f1234a.x(UsermanProfileActivity.this.f1238a.c(), UsermanProfileActivity.this.f1238a.f(), UsermanProfileActivity.this.f1238a.a());
                    Toast.makeText(UsermanProfileActivity.this.f1225a, "تم تعديل الباقة بنجاح", 0).show();
                }
                UsermanProfileActivity.this.f1224a.dismiss();
            } catch (Exception e2) {
                e2.printStackTrace();
                UsermanProfileActivity.this.f1224a.dismiss();
                Toast.makeText(UsermanProfileActivity.this.f1225a, this.f1260a, 1).show();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x012a A[Catch:{ Exception -> 0x017f }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x016f A[Catch:{ Exception -> 0x017f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(androidx.recyclerview.widget.RecyclerView.ViewHolder r12, int r13, int r14) {
        /*
            r11 = this;
            java.lang.String r0 = " - "
            java.lang.String r1 = "4w2d"
            java.lang.String r2 = ""
            r3 = 0
            java.lang.Double r3 = java.lang.Double.valueOf(r3)     // Catch:{ Exception -> 0x017f }
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel> r4 = defpackage.qb0.f4822f     // Catch:{ Exception -> 0x017f }
            if (r4 == 0) goto L_0x0017
            java.lang.Object r4 = r4.get(r14)     // Catch:{ Exception -> 0x017f }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel r4 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel) r4     // Catch:{ Exception -> 0x017f }
            goto L_0x001f
        L_0x0017:
            java.util.ArrayList<com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel> r4 = r11.f1237a     // Catch:{ Exception -> 0x017f }
            java.lang.Object r4 = r4.get(r14)     // Catch:{ Exception -> 0x017f }
            com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel r4 = (com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel) r4     // Catch:{ Exception -> 0x017f }
        L_0x001f:
            android.widget.TextView r5 = r11.f1247c     // Catch:{ Exception -> 0x017f }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x017f }
            r6.<init>()     // Catch:{ Exception -> 0x017f }
            java.lang.String r7 = " تم تحديد الباقة: "
            r6.append(r7)     // Catch:{ Exception -> 0x017f }
            java.lang.String r7 = r4.getName()     // Catch:{ Exception -> 0x017f }
            r6.append(r7)     // Catch:{ Exception -> 0x017f }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x017f }
            r5.setText(r6)     // Catch:{ Exception -> 0x017f }
            java.lang.String r5 = r4.getLimitation()     // Catch:{ Exception -> 0x017f }
            r11.f1236a = r5     // Catch:{ Exception -> 0x017f }
            r11.a = r14     // Catch:{ Exception -> 0x017f }
            android.content.Context r5 = r11.f1225a     // Catch:{ Exception -> 0x017f }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x017f }
            r6.<init>()     // Catch:{ Exception -> 0x017f }
            java.lang.String r7 = " تم تحديد: "
            r6.append(r7)     // Catch:{ Exception -> 0x017f }
            java.lang.String r7 = r4.getName()     // Catch:{ Exception -> 0x017f }
            r6.append(r7)     // Catch:{ Exception -> 0x017f }
            r6.append(r0)     // Catch:{ Exception -> 0x017f }
            java.lang.String r7 = r4.getLimitation()     // Catch:{ Exception -> 0x017f }
            r6.append(r7)     // Catch:{ Exception -> 0x017f }
            r6.append(r0)     // Catch:{ Exception -> 0x017f }
            java.lang.String r0 = r4.getProfile_limitation()     // Catch:{ Exception -> 0x017f }
            r6.append(r0)     // Catch:{ Exception -> 0x017f }
            java.lang.String r0 = r6.toString()     // Catch:{ Exception -> 0x017f }
            r6 = 0
            android.widget.Toast r0 = android.widget.Toast.makeText(r5, r0, r6)     // Catch:{ Exception -> 0x017f }
            r0.show()     // Catch:{ Exception -> 0x017f }
            android.widget.EditText r0 = r11.f1250e     // Catch:{ Exception -> 0x017f }
            java.lang.String r5 = r4.getPrice()     // Catch:{ Exception -> 0x017f }
            r0.setText(r5)     // Catch:{ Exception -> 0x017f }
            android.widget.EditText r0 = r11.f1228a     // Catch:{ Exception -> 0x017f }
            java.lang.String r5 = r4.getName()     // Catch:{ Exception -> 0x017f }
            r0.setText(r5)     // Catch:{ Exception -> 0x017f }
            java.lang.String r0 = r4.getValidty_limit()     // Catch:{ Exception -> 0x017f }
            r0.substring(r6, r6)     // Catch:{ Exception -> 0x017f }
            android.widget.EditText r0 = r11.f1248d     // Catch:{ Exception -> 0x017f }
            java.lang.String r5 = r4.getValidty_limit()     // Catch:{ Exception -> 0x017f }
            r0.setText(r5)     // Catch:{ Exception -> 0x017f }
            android.widget.EditText r0 = r11.f1245c     // Catch:{ Exception -> 0x017f }
            java.lang.String r5 = r4.getTime_limit()     // Catch:{ Exception -> 0x017f }
            r0.setText(r5)     // Catch:{ Exception -> 0x017f }
            r0 = 1
            java.lang.String r5 = r4.getValidty_limit()     // Catch:{ Exception -> 0x010a }
            boolean r5 = r5.equals(r1)     // Catch:{ Exception -> 0x010a }
            if (r5 == 0) goto L_0x00bf
            java.lang.String r5 = r4.getValidty_limit()     // Catch:{ Exception -> 0x010a }
            boolean r5 = r5.equals(r1)     // Catch:{ Exception -> 0x010a }
            if (r5 == 0) goto L_0x00bf
            android.widget.CheckBox r1 = r11.f1227a     // Catch:{ Exception -> 0x010a }
            r1.setChecked(r0)     // Catch:{ Exception -> 0x010a }
            android.widget.CheckBox r1 = r11.e     // Catch:{ Exception -> 0x010a }
            r1.setChecked(r6)     // Catch:{ Exception -> 0x010a }
            goto L_0x0109
        L_0x00bf:
            java.lang.String r5 = r4.getValidty_limit()     // Catch:{ Exception -> 0x010a }
            boolean r1 = r5.equals(r1)     // Catch:{ Exception -> 0x010a }
            java.lang.String r5 = "0s"
            if (r1 == 0) goto L_0x00e0
            java.lang.String r1 = r4.getTime_limit()     // Catch:{ Exception -> 0x010a }
            boolean r1 = r1.equals(r5)     // Catch:{ Exception -> 0x010a }
            if (r1 == 0) goto L_0x00e0
            android.widget.CheckBox r1 = r11.f1227a     // Catch:{ Exception -> 0x010a }
            r1.setChecked(r0)     // Catch:{ Exception -> 0x010a }
            android.widget.CheckBox r1 = r11.e     // Catch:{ Exception -> 0x010a }
            r1.setChecked(r6)     // Catch:{ Exception -> 0x010a }
            goto L_0x0109
        L_0x00e0:
            java.lang.String r1 = r4.getValidty_limit()     // Catch:{ Exception -> 0x010a }
            boolean r1 = r1.equals(r5)     // Catch:{ Exception -> 0x010a }
            if (r1 == 0) goto L_0x00ff
            java.lang.String r1 = r4.getTime_limit()     // Catch:{ Exception -> 0x010a }
            boolean r1 = r1.equals(r5)     // Catch:{ Exception -> 0x010a }
            if (r1 == 0) goto L_0x00ff
            android.widget.CheckBox r1 = r11.f1227a     // Catch:{ Exception -> 0x010a }
            r1.setChecked(r6)     // Catch:{ Exception -> 0x010a }
            android.widget.CheckBox r1 = r11.e     // Catch:{ Exception -> 0x010a }
            r1.setChecked(r0)     // Catch:{ Exception -> 0x010a }
            goto L_0x0109
        L_0x00ff:
            android.widget.CheckBox r1 = r11.f1227a     // Catch:{ Exception -> 0x010a }
            r1.setChecked(r6)     // Catch:{ Exception -> 0x010a }
            android.widget.CheckBox r1 = r11.e     // Catch:{ Exception -> 0x010a }
            r1.setChecked(r6)     // Catch:{ Exception -> 0x010a }
        L_0x0109:
            goto L_0x0118
        L_0x010a:
            r1 = move-exception
            android.content.Context r5 = r11.f1225a     // Catch:{ Exception -> 0x017f }
            java.lang.String r7 = r1.getMessage()     // Catch:{ Exception -> 0x017f }
            android.widget.Toast r5 = android.widget.Toast.makeText(r5, r7, r6)     // Catch:{ Exception -> 0x017f }
            r5.show()     // Catch:{ Exception -> 0x017f }
        L_0x0118:
            java.lang.String r1 = r4.getTrans_limit()     // Catch:{ Exception -> 0x017f }
            if (r1 == 0) goto L_0x016f
            java.lang.String r1 = r4.getTrans_limit()     // Catch:{ Exception -> 0x017f }
            java.lang.String r5 = "0"
            boolean r1 = r1.equals(r5)     // Catch:{ Exception -> 0x017f }
            if (r1 != 0) goto L_0x016f
            java.lang.String r1 = r4.getTrans_limit()     // Catch:{ Exception -> 0x017f }
            double r7 = java.lang.Double.parseDouble(r1)     // Catch:{ Exception -> 0x017f }
            r9 = 4697254411347427328(0x4130000000000000, double:1048576.0)
            double r7 = r7 / r9
            java.lang.Double r1 = java.lang.Double.valueOf(r7)     // Catch:{ Exception -> 0x017f }
            android.widget.Spinner r3 = r11.f1231a     // Catch:{ Exception -> 0x017f }
            r3.setSelection(r6)     // Catch:{ Exception -> 0x017f }
            double r7 = r1.doubleValue()     // Catch:{ Exception -> 0x017f }
            r9 = 4652218415073722368(0x4090000000000000, double:1024.0)
            int r3 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r3 <= 0) goto L_0x015d
            java.lang.String r3 = r4.getTrans_limit()     // Catch:{ Exception -> 0x017f }
            double r7 = java.lang.Double.parseDouble(r3)     // Catch:{ Exception -> 0x017f }
            r9 = 4742290407621132288(0x41d0000000000000, double:1.073741824E9)
            double r7 = r7 / r9
            java.lang.Double r3 = java.lang.Double.valueOf(r7)     // Catch:{ Exception -> 0x017f }
            r1 = r3
            android.widget.Spinner r3 = r11.f1231a     // Catch:{ Exception -> 0x017f }
            r3.setSelection(r0)     // Catch:{ Exception -> 0x017f }
        L_0x015d:
            android.widget.EditText r3 = r11.f1240b     // Catch:{ Exception -> 0x017f }
            java.util.Locale r5 = java.util.Locale.US     // Catch:{ Exception -> 0x017f }
            java.lang.String r7 = "%.1f"
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x017f }
            r0[r6] = r1     // Catch:{ Exception -> 0x017f }
            java.lang.String r0 = java.lang.String.format(r5, r7, r0)     // Catch:{ Exception -> 0x017f }
            r3.setText(r0)     // Catch:{ Exception -> 0x017f }
            goto L_0x017e
        L_0x016f:
            android.widget.Spinner r0 = r11.f1231a     // Catch:{ Exception -> 0x017f }
            r1 = 2
            r0.setSelection(r1)     // Catch:{ Exception -> 0x017f }
            android.widget.EditText r0 = r11.f1240b     // Catch:{ Exception -> 0x017f }
            android.text.Editable r0 = r0.getText()     // Catch:{ Exception -> 0x017f }
            r0.clear()     // Catch:{ Exception -> 0x017f }
        L_0x017e:
            goto L_0x0189
        L_0x017f:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()
            java.lang.String r2 = "ODAI_ERROR"
            android.util.Log.d(r2, r1)
        L_0x0189:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blogspot.yemeninfo4it.mumsmobile_app.activities.UsermanProfileActivity.g(androidx.recyclerview.widget.RecyclerView$ViewHolder, int, int):void");
    }

    public void c(RecyclerView.ViewHolder cellView, int column, int row) {
    }

    public void d(RecyclerView.ViewHolder columnHeaderView, int column) {
    }

    public void b(RecyclerView.ViewHolder columnHeaderView, int column) {
    }

    public void f(RecyclerView.ViewHolder rowHeaderView, int row) {
    }

    public void a(RecyclerView.ViewHolder rowHeaderView, int row) {
    }
}
