package com.blogspot.yemeninfo4it.mumsmobile_app.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExpierHotspotActivity extends AppCompatActivity {
    public int a = 0;

    /* renamed from: a  reason: collision with other field name */
    Context f689a;

    /* renamed from: a  reason: collision with other field name */
    Button f690a;

    /* renamed from: a  reason: collision with other field name */
    CheckBox f691a;

    /* renamed from: a  reason: collision with other field name */
    EditText f692a;

    /* renamed from: a  reason: collision with other field name */
    LinearLayout f693a;

    /* renamed from: a  reason: collision with other field name */
    ListView f694a;

    /* renamed from: a  reason: collision with other field name */
    RadioButton f695a;

    /* renamed from: a  reason: collision with other field name */
    TextView f696a;

    /* renamed from: a  reason: collision with other field name */
    i f697a;

    /* renamed from: a  reason: collision with other field name */
    j3 f698a;

    /* renamed from: a  reason: collision with other field name */
    final String f699a = "mLog";

    /* renamed from: a  reason: collision with other field name */
    ArrayList<HotspotCard> f700a = null;

    /* renamed from: a  reason: collision with other field name */
    ue f701a;

    /* renamed from: a  reason: collision with other field name */
    uq f702a = null;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public zd f703a;

    /* renamed from: a  reason: collision with other field name */
    boolean f704a = false;
    int b = 0;

    /* renamed from: b  reason: collision with other field name */
    EditText f705b;

    /* renamed from: b  reason: collision with other field name */
    LinearLayout f706b;

    /* renamed from: b  reason: collision with other field name */
    RadioButton f707b;

    /* renamed from: b  reason: collision with other field name */
    TextView f708b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public ArrayList<HotspotCard> f709b = new ArrayList<>();
    EditText c;

    /* renamed from: c  reason: collision with other field name */
    RadioButton f710c;

    /* renamed from: c  reason: collision with other field name */
    TextView f711c;
    TextView d;
    TextView e;
    TextView f;
    TextView g;
    TextView h;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView((int) R.layout.activity_hotspot_expier);
            this.f689a = this;
            this.f698a = qb0.d();
            this.f695a = (RadioButton) findViewById(R.id.transmation_limitRadio);
            this.f707b = (RadioButton) findViewById(R.id.houer_limitRadio);
            this.f710c = (RadioButton) findViewById(R.id.disabled_cardRadio);
            this.f701a = new ue(this.f689a);
            this.f700a = new ArrayList<>();
            this.f706b = (LinearLayout) findViewById(R.id.houer_layout);
            this.f693a = (LinearLayout) findViewById(R.id.trans_layout);
            this.f692a = (EditText) findViewById(R.id.transmation_limit_txt);
            this.f705b = (EditText) findViewById(R.id.houer_limit_txt);
            this.c = (EditText) findViewById(R.id.time_menut_txt);
            this.f696a = (TextView) findViewById(R.id.title_txt);
            this.f711c = (TextView) findViewById(R.id.count_txt);
            this.d = (TextView) findViewById(R.id.deleted_count);
            this.f708b = (TextView) findViewById(R.id.time_description);
            this.f = (TextView) findViewById(R.id.show_user_btn);
            this.f691a = (CheckBox) findViewById(R.id.chk_select_all);
            this.f690a = (Button) findViewById(R.id.btn_delete_all);
            this.e = (TextView) findViewById(R.id.header_text_title);
            this.f694a = (ListView) findViewById(R.id.myCustomListView);
            this.f696a.setText("اكتب كمية التحميل الاصلية للباقة التي تريد حذف الكروت المنتهية منها");
            zd zdVar = new zd(this);
            this.f703a = zdVar;
            this.g = (TextView) zdVar.b().findViewById(R.id.cancel_btn);
            TextView textView = (TextView) this.f703a.b().findViewById(R.id.cp_percent);
            this.h = textView;
            textView.setVisibility(0);
            this.g.setOnClickListener(new bk(this));
            this.f695a.setOnClickListener(new a());
            this.f707b.setOnClickListener(new b());
            this.f710c.setOnClickListener(new c());
            this.f.setOnClickListener(new d());
            this.f691a.setOnClickListener(new e());
            this.f690a.setOnClickListener(new f());
            this.f705b.addTextChangedListener(new g());
            this.c.addTextChangedListener(new h());
        } catch (Exception ee) {
            Toast.makeText(this, ee.getMessage() + " حدثت مشكلة ", 1).show();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p(View v) {
        this.f703a.a();
        try {
            this.f704a = true;
        } catch (Exception e2) {
            e2.printStackTrace();
            Context context = this.f689a;
            Toast.makeText(context, e2.getMessage() + " ddd", 0).show();
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View v) {
            ExpierHotspotActivity.this.f693a.setVisibility(0);
            ExpierHotspotActivity.this.f695a.setChecked(true);
            ExpierHotspotActivity.this.f692a.setEnabled(true);
            ExpierHotspotActivity.this.f706b.setVisibility(8);
            ExpierHotspotActivity.this.f707b.setChecked(false);
            ExpierHotspotActivity.this.f710c.setChecked(false);
            ExpierHotspotActivity.this.f705b.setEnabled(false);
            ExpierHotspotActivity.this.f695a.setTextColor(Color.parseColor("#ffffff"));
            ExpierHotspotActivity.this.f707b.setTextColor(Color.parseColor("#25536e"));
            ExpierHotspotActivity.this.f710c.setTextColor(Color.parseColor("#25536e"));
            ExpierHotspotActivity.this.f696a.setText("اكتب كمية التحميل الاصلية للباقة التي تريد حذف الكروت المنتهية منها");
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View v) {
            ExpierHotspotActivity.this.f706b.setVisibility(0);
            ExpierHotspotActivity.this.f707b.setChecked(true);
            ExpierHotspotActivity.this.f705b.setEnabled(true);
            ExpierHotspotActivity.this.f693a.setVisibility(8);
            ExpierHotspotActivity.this.f695a.setChecked(false);
            ExpierHotspotActivity.this.f710c.setChecked(false);
            ExpierHotspotActivity.this.f692a.setEnabled(false);
            ExpierHotspotActivity.this.f695a.setTextColor(Color.parseColor("#25536e"));
            ExpierHotspotActivity.this.f707b.setTextColor(Color.parseColor("#ffffff"));
            ExpierHotspotActivity.this.f710c.setTextColor(Color.parseColor("#25536e"));
            ExpierHotspotActivity.this.f696a.setText("الكروت منتهية الوقت");
            ExpierHotspotActivity.this.f696a.setText("اكتب عدد الساعات للباقة او اترك الحقل فارغ لعرض الكروت النتهية لكافة الباقات");
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View v) {
            ExpierHotspotActivity.this.f710c.setChecked(true);
            ExpierHotspotActivity.this.f705b.setEnabled(false);
            ExpierHotspotActivity.this.f693a.setVisibility(8);
            ExpierHotspotActivity.this.f706b.setVisibility(8);
            ExpierHotspotActivity.this.f695a.setChecked(false);
            ExpierHotspotActivity.this.f707b.setChecked(false);
            ExpierHotspotActivity.this.f692a.setEnabled(false);
            ExpierHotspotActivity.this.f695a.setTextColor(Color.parseColor("#25536e"));
            ExpierHotspotActivity.this.f707b.setTextColor(Color.parseColor("#25536e"));
            ExpierHotspotActivity.this.f710c.setTextColor(Color.parseColor("#ffffff"));
            ExpierHotspotActivity.this.f696a.setText("الكروت منتهية الصلاحية");
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        public void onClick(View v) {
            ExpierHotspotActivity.this.f700a.clear();
            ExpierHotspotActivity expierHotspotActivity = ExpierHotspotActivity.this;
            expierHotspotActivity.f700a = expierHotspotActivity.q(expierHotspotActivity.f700a);
            ExpierHotspotActivity expierHotspotActivity2 = ExpierHotspotActivity.this;
            ExpierHotspotActivity expierHotspotActivity3 = ExpierHotspotActivity.this;
            expierHotspotActivity2.f702a = new uq(expierHotspotActivity3, expierHotspotActivity3.f700a);
            ExpierHotspotActivity expierHotspotActivity4 = ExpierHotspotActivity.this;
            expierHotspotActivity4.f694a.setAdapter(expierHotspotActivity4.f702a);
            ExpierHotspotActivity.this.d.setText("");
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        public void onClick(View v) {
            try {
                if (ExpierHotspotActivity.this.f700a.size() > 0) {
                    if (ExpierHotspotActivity.this.f691a.isChecked()) {
                        Iterator<HotspotCard> it = ExpierHotspotActivity.this.f700a.iterator();
                        while (it.hasNext()) {
                            it.next().setSelected(true);
                        }
                    } else {
                        Iterator<HotspotCard> it2 = ExpierHotspotActivity.this.f700a.iterator();
                        while (it2.hasNext()) {
                            it2.next().setSelected(false);
                        }
                    }
                    ExpierHotspotActivity.this.f702a.notifyDataSetChanged();
                    return;
                }
                Snackbar.k0(v, "لا توجد سجلات للتحديد", 0).V();
            } catch (Exception e) {
                Snackbar.k0(v, e.getMessage(), 0).V();
            }
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        public void onClick(View v) {
            try {
                if (ExpierHotspotActivity.this.f700a.size() > 0) {
                    new AlertDialog.Builder(ExpierHotspotActivity.this).setIcon(17301543).setTitle("تنبية !").setMessage("هل تريد حذف الكروت المنتهية التي قمت بتحديدها").setPositiveButton("نعم", new a()).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
                } else {
                    Toast.makeText(ExpierHotspotActivity.this.getApplicationContext(), "لا يوجد كروت منتهية", 0).show();
                }
            } catch (Exception e) {
                ExpierHotspotActivity expierHotspotActivity = ExpierHotspotActivity.this;
                Toast.makeText(expierHotspotActivity, e.getMessage() + "error", 1).show();
            }
        }

        class a implements DialogInterface.OnClickListener {
            a() {
            }

            public void onClick(DialogInterface dialog, int which) {
                ExpierHotspotActivity expierHotspotActivity = ExpierHotspotActivity.this;
                expierHotspotActivity.f704a = false;
                expierHotspotActivity.f697a = new i();
                ExpierHotspotActivity.this.f697a.execute(new String[0]);
            }
        }
    }

    class g implements TextWatcher {
        g() {
        }

        public void afterTextChanged(Editable s) {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                ExpierHotspotActivity expierHotspotActivity = ExpierHotspotActivity.this;
                expierHotspotActivity.f708b.setText(ExpierHotspotActivity.o(expierHotspotActivity.f705b.getText().toString(), ExpierHotspotActivity.this.c.getText().toString()));
            } catch (Exception e) {
                Log.d("mLog", e.getMessage() + "error odai dammag");
            }
        }
    }

    class h implements TextWatcher {
        h() {
        }

        public void afterTextChanged(Editable s) {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                ExpierHotspotActivity expierHotspotActivity = ExpierHotspotActivity.this;
                expierHotspotActivity.f708b.setText(ExpierHotspotActivity.o(expierHotspotActivity.f705b.getText().toString(), ExpierHotspotActivity.this.c.getText().toString()));
            } catch (Exception e) {
                Log.d("mLog", e.getMessage() + " Error Odai Dammag");
            }
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

    /* access modifiers changed from: private */
    public ArrayList<HotspotCard> q(ArrayList<HotspotCard> customers) {
        int counter = 0;
        try {
            if (this.f695a.isChecked()) {
                long dnuplimit = 0;
                if (TextUtils.isEmpty(this.f692a.getText().toString().trim())) {
                    this.f692a.setError("الرجاء تعبئة هذا الحقل");
                }
                if (!this.f692a.getText().toString().trim().isEmpty()) {
                    dnuplimit = Long.parseLong(this.f692a.getText().toString()) * 1048576;
                }
                for (int i2 = 0; i2 < qb0.f4834l.size(); i2++) {
                    long limitBytotl = 0;
                    if (qb0.f4834l.get(i2).getLimitBytesTotal() != null) {
                        limitBytotl = Long.parseLong(qb0.f4834l.get(i2).getLimitBytesTotal());
                    }
                    long cc = Long.parseLong(qb0.f4834l.get(i2).getDownload_used()) + Long.parseLong(qb0.f4834l.get(i2).getUpload_used());
                    if (dnuplimit == limitBytotl && cc >= limitBytotl && limitBytotl > 0) {
                        customers.add(qb0.f4834l.get(i2));
                        counter++;
                    }
                }
            } else if (this.f707b.isChecked()) {
                if (TextUtils.isEmpty(this.f705b.getText().toString().trim())) {
                    for (int i3 = 0; i3 < qb0.f4834l.size(); i3++) {
                        if (qb0.f4834l.get(i3).getUptime_used().equals(qb0.f4834l.get(i3).getLimitUptime())) {
                            customers.add(qb0.f4834l.get(i3));
                            counter++;
                        }
                    }
                    if (counter < 1) {
                        Snackbar.k0(this.f.getRootView(), "لا توجد كروت منتهية بهذه البيانات المدخلة", 0).V();
                    }
                } else {
                    String m_limit = this.c.getText().toString().trim();
                    long men = Long.parseLong(this.f705b.getText().toString()) * 60;
                    long m = 0;
                    if (!TextUtils.isEmpty(m_limit)) {
                        m = Long.parseLong(this.c.getText().toString());
                    }
                    String t = n(men + m);
                    this.f708b.setText(t);
                    for (int i4 = 0; i4 < qb0.f4834l.size(); i4++) {
                        if (t.equals(qb0.f4834l.get(i4).getLimitUptime()) && t.equals(qb0.f4834l.get(i4).getUptime_used())) {
                            customers.add(qb0.f4834l.get(i4));
                            counter++;
                        }
                    }
                    if (counter < 1) {
                        Snackbar.k0(this.f.getRootView(), "لا توجد كروت منتهية بهذه البيانات المدخلة", 0).V();
                    }
                }
            } else if (this.f710c.isChecked()) {
                for (int i5 = 0; i5 < qb0.f4834l.size(); i5++) {
                    if (qb0.f4834l.get(i5).getDisabled() && qb0.f4834l.get(i5).getComment() != null) {
                        customers.add(qb0.f4834l.get(i5));
                        counter++;
                    }
                }
                if (counter < 1) {
                    Snackbar.k0(this.f.getRootView(), "لا توجد كروت منتهية بهذه البيانات المدخلة", 0).V();
                }
            }
            TextView textView = this.f711c;
            textView.setText("العدد:" + counter);
        } catch (Exception e2) {
        }
        return customers;
    }

    class i extends AsyncTask<String, Integer, String> {

        /* renamed from: a  reason: collision with other field name */
        String f712a = "";

        /* renamed from: a  reason: collision with other field name */
        List<String> f713a = new ArrayList();

        /* renamed from: a  reason: collision with other field name */
        boolean f714a = false;

        i() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            ExpierHotspotActivity.this.h.setText("0%");
            ExpierHotspotActivity.this.f703a.c("جاري حذف الكروت المحددة..");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                ExpierHotspotActivity expierHotspotActivity = ExpierHotspotActivity.this;
                expierHotspotActivity.b = 0;
                int ncoun = expierHotspotActivity.f700a.size();
                if (ExpierHotspotActivity.this.f700a.size() <= 0) {
                    return null;
                }
                int iadd = 0;
                while (true) {
                    if (iadd >= ncoun) {
                        break;
                    }
                    if (ExpierHotspotActivity.this.f700a.get(iadd).isSelected()) {
                        j3 j3Var = ExpierHotspotActivity.this.f698a;
                        j3Var.q("/ip/hotspot/user/remove .id=" + ExpierHotspotActivity.this.f700a.get(iadd).getId() + "");
                        ExpierHotspotActivity.this.f709b.add(ExpierHotspotActivity.this.f700a.get(iadd));
                        ArrayList<HotspotCard> arrayList = qb0.f4834l;
                        arrayList.remove(arrayList.indexOf(ExpierHotspotActivity.this.f700a.get(iadd)));
                        qb0.d = qb0.d - 1;
                        this.f713a.add(ExpierHotspotActivity.this.f700a.get(iadd).getId());
                    }
                    publishProgress(new Integer[]{Integer.valueOf((int) ((((float) iadd) / ((float) ncoun)) * 100.0f))});
                    if (ExpierHotspotActivity.this.f704a) {
                        break;
                    }
                    iadd++;
                }
                ExpierHotspotActivity.this.f701a.B0(this.f713a, 1);
                return null;
            } catch (Exception e) {
                try {
                    this.f712a = e.getMessage();
                    this.f714a = true;
                    return null;
                } catch (Exception e2) {
                    this.f712a = e2.getMessage();
                    this.f714a = true;
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void onProgressUpdate(Integer... values) {
            TextView textView = ExpierHotspotActivity.this.h;
            textView.setText(values[0] + "%");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            ExpierHotspotActivity.this.f703a.a();
            try {
                if (this.f714a) {
                    Toast.makeText(ExpierHotspotActivity.this.f689a, this.f712a, 0).show();
                }
                if (ExpierHotspotActivity.this.f709b.size() > 0) {
                    int del_count = 0;
                    for (int i = 0; i < ExpierHotspotActivity.this.f709b.size(); i++) {
                        ExpierHotspotActivity expierHotspotActivity = ExpierHotspotActivity.this;
                        expierHotspotActivity.f700a.remove(expierHotspotActivity.f709b.get(i));
                        del_count++;
                    }
                    TextView textView = ExpierHotspotActivity.this.f711c;
                    textView.setText(" الكروت المنتهية: " + ExpierHotspotActivity.this.f700a.size());
                    TextView textView2 = ExpierHotspotActivity.this.d;
                    textView2.setText(" تم حذف: " + del_count + " كرت ");
                    try {
                        if (ExpierHotspotActivity.this.f700a.size() > 0) {
                            Iterator<HotspotCard> it = ExpierHotspotActivity.this.f700a.iterator();
                            while (it.hasNext()) {
                                it.next().setSelected(false);
                            }
                        }
                        ExpierHotspotActivity.this.f691a.setChecked(false);
                    } catch (Exception e) {
                    }
                }
                ExpierHotspotActivity.this.f702a.notifyDataSetChanged();
                ExpierHotspotActivity.this.f709b.clear();
            } catch (Exception e2) {
                e2.printStackTrace();
                Toast.makeText(ExpierHotspotActivity.this, e2.getMessage().toString(), 1).show();
            }
        }
    }

    public static String n(long minutes) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        int day = (int) timeUnit.toDays(minutes);
        long hours = timeUnit.toHours(minutes) - ((long) (day * 24));
        long minute = timeUnit.toMinutes(minutes) - (timeUnit.toHours(minutes) * 60);
        String result = "";
        if (day != 0) {
            String result2 = result + day;
            if (day == 1) {
                result = result2 + "d";
            } else {
                result = result2 + "d";
            }
        }
        if (hours != 0) {
            String result3 = result + hours;
            if (hours == 1) {
                result = result3 + "h";
            } else {
                result = result3 + "h";
            }
        }
        if (minute == 0) {
            return result;
        }
        String result4 = result + minute;
        if (minute == 1) {
            return result4 + "m";
        }
        return result4 + "m";
    }

    public static String o(String h2, String m) {
        String res = "";
        try {
            if (!h2.isEmpty()) {
                if (Integer.parseInt(h2) > 0) {
                    res = h2 + "ساعة";
                    if (!m.isEmpty() && Integer.parseInt(m) > 0) {
                        res = h2 + "ساعةو" + m + "دقيقة";
                    }
                }
            }
            if (m.isEmpty() || Integer.parseInt(m) <= 0) {
                return res;
            }
            String res2 = m + "دقيقة";
            if (h2.isEmpty() || Integer.parseInt(h2) <= 0) {
                return res2;
            }
            return h2 + "ساعةو" + m + "دقيقة";
        } catch (Exception e2) {
            return "";
        }
    }
}
