package com.blogspot.yemeninfo4it.mumsmobile_app.activities;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.InterfaceList;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Payment;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Sessions;
import com.evrencoskun.tableview.TableView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class SalesArchiveActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    public static Spinner a;

    /* renamed from: a  reason: collision with other field name */
    public static TableView f986a;

    /* renamed from: a  reason: collision with other field name */
    public static d0 f987a;

    /* renamed from: a  reason: collision with other field name */
    public static String f988a;

    /* renamed from: a  reason: collision with other field name */
    public static StringBuilder f989a;

    /* renamed from: a  reason: collision with other field name */
    public static ue f990a;
    public static Spinner b;

    /* renamed from: b  reason: collision with other field name */
    public static String f991b;
    public static TextView d;

    /* renamed from: d  reason: collision with other field name */
    public static ArrayList<Sessions> f992d;
    public static TextView e;
    public static TextView f;
    public static TextView g;
    public static TextView h;

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f993a;

    /* renamed from: a  reason: collision with other field name */
    Context f994a;

    /* renamed from: a  reason: collision with other field name */
    public Button f995a;

    /* renamed from: a  reason: collision with other field name */
    ImageView f996a;

    /* renamed from: a  reason: collision with other field name */
    public TextView f997a;

    /* renamed from: a  reason: collision with other field name */
    h f998a;

    /* renamed from: a  reason: collision with other field name */
    i f999a;

    /* renamed from: a  reason: collision with other field name */
    j3 f1000a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<Sessions> f1001a;

    /* renamed from: a  reason: collision with other field name */
    public wp0 f1002a;

    /* renamed from: a  reason: collision with other field name */
    zd f1003a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1004a = true;

    /* renamed from: b  reason: collision with other field name */
    public Button f1005b;

    /* renamed from: b  reason: collision with other field name */
    public TextView f1006b;

    /* renamed from: b  reason: collision with other field name */
    public ArrayList<Payment> f1007b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public boolean f1008b = false;
    public Button c;

    /* renamed from: c  reason: collision with other field name */
    TextView f1009c;

    /* renamed from: c  reason: collision with other field name */
    public ArrayList<InterfaceList> f1010c;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.salse_layout);
        this.f994a = this;
        this.f1000a = qb0.d();
        this.f1010c = new ArrayList<>();
        f990a = new ue(this.f994a);
        zd zdVar = new zd(this.f994a);
        this.f1003a = zdVar;
        TextView textView = (TextView) zdVar.b().findViewById(R.id.cancel_btn);
        this.f1009c = textView;
        textView.setVisibility(8);
        this.f993a = new ProgressDialog(this);
        this.f995a = (Button) findViewById(R.id.activebtn);
        this.f1005b = (Button) findViewById(R.id.showbtn);
        this.c = (Button) findViewById(R.id.dubl);
        d = (TextView) findViewById(R.id.activeacount);
        e = (TextView) findViewById(R.id.sum);
        f = (TextView) findViewById(R.id.transmit_sum);
        g = (TextView) findViewById(R.id.start_date);
        h = (TextView) findViewById(R.id.end_date);
        a = (Spinner) findViewById(R.id.ether_name);
        b = (Spinner) findViewById(R.id.price_list);
        this.f1006b = (TextView) findViewById(R.id.header_text_title);
        this.f997a = (TextView) findViewById(R.id.load_myprofile);
        this.f996a = (ImageView) findViewById(R.id.icontoolbar);
        this.f1001a = new ArrayList<>();
        f992d = new ArrayList<>();
        this.f1007b = new ArrayList<>();
        f986a = (TableView) findViewById(R.id.tableview);
        try {
            this.f1006b.setText("ارشيف مبيعات يوزرمانجر");
            this.f996a.setVisibility(8);
            h hVar = new h();
            this.f998a = hVar;
            hVar.execute(new Void[0]);
            this.f997a.setOnClickListener(new a());
            this.f995a.setOnClickListener(new b());
            g.setOnClickListener(new c());
            h.setOnClickListener(new d());
            this.f1005b.setOnClickListener(new e());
            if (qb0.p != null) {
                List<String> list = new ArrayList<>();
                list.add("الكل");
                for (int i2 = 0; i2 < qb0.p.size(); i2++) {
                    list.add(qb0.p.get(i2).getPrice());
                }
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, 17367048, list);
                dataAdapter.setDropDownViewResource(17367049);
                b.setAdapter(dataAdapter);
            }
            if (qb0.f4831j != null) {
                List<String> list2 = new ArrayList<>();
                list2.add("الكل");
                for (int i3 = 0; i3 < qb0.f4831j.size(); i3++) {
                    list2.add(qb0.f4831j.get(i3).getName());
                }
                ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<>(this, 17367048, list2);
                dataAdapter2.setDropDownViewResource(17367049);
                a.setAdapter(dataAdapter2);
            } else {
                new j().execute(new String[0]);
            }
            a.setOnItemSelectedListener(new f());
            b.setOnItemSelectedListener(new g());
        } catch (Exception e2) {
            Toast.makeText(this, e2.toString(), 1).show();
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View v) {
            new j().execute(new String[0]);
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View v) {
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View v) {
            z20 mDatePickerDialogFragment = new z20();
            qb0.f4820e = true;
            mDatePickerDialogFragment.show(SalesArchiveActivity.this.getSupportFragmentManager(), "From Date");
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        public void onClick(View v) {
            z20 mDatePickerDialogFragment = new z20();
            qb0.f4820e = false;
            mDatePickerDialogFragment.show(SalesArchiveActivity.this.getSupportFragmentManager(), "To Date");
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        public void onClick(View v) {
        }
    }

    class f implements AdapterView.OnItemSelectedListener {
        f() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            if (SalesArchiveActivity.this.f1008b) {
                SalesArchiveActivity.this.l();
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class g implements AdapterView.OnItemSelectedListener {
        g() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            if (SalesArchiveActivity.this.f1008b) {
                SalesArchiveActivity.this.l();
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(jv0.b(newBase));
    }

    /* access modifiers changed from: private */
    public void n() {
        this.f1002a = new wp0(this, qb0.f4819e);
        np0 np0 = new np0(this, this.f1002a);
        f987a = np0;
        f986a.setAdapter(np0);
        f987a.x(this.f1002a.c(), this.f1002a.f(), this.f1002a.a());
    }

    public void onUserInteraction() {
        super.onUserInteraction();
        this.f1008b = true;
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date2;
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.set(1, year);
        mCalendar.set(2, month);
        mCalendar.set(5, dayOfMonth);
        String date = String.valueOf(view.getDayOfMonth()) + "/" + String.valueOf(view.getMonth() + 1) + "/" + String.valueOf(view.getYear());
        new SalesArchiveActivity();
        Locale locale = Locale.ENGLISH;
        SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy", locale);
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy/MM/dd", locale);
        try {
            date2 = formatter2.format(formatter.parse(date));
        } catch (Exception e2) {
            date2 = "";
        }
        f989a = new StringBuilder();
        if (qb0.f4820e) {
            g.setText(date2);
            f988a = date2;
            if (TextUtils.isEmpty(date2) || TextUtils.isEmpty(f991b)) {
                SimpleDateFormat simpleDateFormat = formatter;
                Calendar calendar = mCalendar;
                return;
            }
            Calendar calendar2 = mCalendar;
            i iVar = r1;
            SimpleDateFormat simpleDateFormat2 = formatter2;
            SimpleDateFormat simpleDateFormat3 = formatter;
            i iVar2 = new i(f988a, f991b, a.getSelectedItem().toString(), b.getSelectedItem().toString(), "يتم جلب البيانات حسب البيانات المحددة");
            this.f999a = iVar;
            iVar.execute(new Void[0]);
            return;
        }
        SimpleDateFormat simpleDateFormat4 = formatter;
        Calendar calendar3 = mCalendar;
        h.setText(date2);
        f991b = date2;
        if (!TextUtils.isEmpty(f988a) && !TextUtils.isEmpty(f991b)) {
            i iVar3 = new i(f988a, f991b, a.getSelectedItem().toString(), b.getSelectedItem().toString(), "يتم جلب البيانات حسب البيانات المحددة");
            this.f999a = iVar3;
            iVar3.execute(new Void[0]);
        }
    }

    class j extends AsyncTask<String, Void, String> {

        /* renamed from: a  reason: collision with other field name */
        String f1015a = "Error";

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f1016a = null;

        j() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            SalesArchiveActivity.this.f993a.setTitle("يرجى الانتظار..");
            SalesArchiveActivity.this.f993a.setMessage("جاري تحميل المنافذ");
            SalesArchiveActivity.this.f993a.setCancelable(false);
            SalesArchiveActivity.this.f993a.setIndeterminate(false);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                SalesArchiveActivity.this.f1000a.J(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
                this.f1016a = SalesArchiveActivity.this.f1000a.q("/interface/print");
                return null;
            } catch (Exception e) {
                try {
                    Log.d("LOG", e.getMessage() + "error");
                    this.f1015a = e.getMessage();
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.f1015a = e2.getMessage();
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            try {
                List<String> list = new ArrayList<>();
                list.add("الكل");
                for (Map<String, String> res : this.f1016a) {
                    if (res.get("name") != null) {
                        SalesArchiveActivity.this.f1010c.add(new InterfaceList(res.get(".id"), res.get("name")));
                        list.add(res.get("name"));
                    }
                }
                qb0.f4831j = SalesArchiveActivity.this.f1010c;
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(SalesArchiveActivity.this, 17367048, list);
                dataAdapter.setDropDownViewResource(17367049);
                SalesArchiveActivity.a.setAdapter(dataAdapter);
                SalesArchiveActivity.this.f993a.dismiss();
            } catch (Exception e) {
                Toast.makeText(SalesArchiveActivity.this, e.getMessage(), 1).show();
                SalesArchiveActivity.this.f993a.dismiss();
            }
        }
    }

    public void m() {
        try {
            String strDate = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).format(Calendar.getInstance().getTime());
            f989a = new StringBuilder();
            h.setText(strDate);
            f991b = strDate;
            g.setText(strDate);
            f988a = strDate;
            i iVar = new i(f988a, f991b, "الكل", "الكل", "يتم جلب البيانات حسب تاريخ اليوم");
            this.f999a = iVar;
            iVar.execute(new Void[0]);
        } catch (Exception e2) {
            Toast.makeText(this, e2.toString(), 1).show();
        }
    }

    public void l() {
        String eth;
        String pr = "الكل";
        String eth2 = pr;
        try {
            if (a.getSelectedItem() != null) {
                eth = a.getSelectedItem().toString();
            } else {
                eth = eth2;
            }
            if (b.getSelectedItem() != null) {
                pr = b.getSelectedItem().toString();
            }
            f989a = new StringBuilder();
            f991b = h.getText().toString();
            f988a = g.getText().toString();
            i iVar = new i(f988a, f991b, eth, pr, "يتم جلب البيانات حسب البيانات المحددة");
            this.f999a = iVar;
            iVar.execute(new Void[0]);
        } catch (Exception e2) {
            Toast.makeText(this, e2.toString(), 1).show();
        }
    }

    class h extends AsyncTask<Void, Void, ArrayList<Sessions>> {

        /* renamed from: a  reason: collision with other field name */
        ArrayList<Sessions> f1011a = new ArrayList<>();

        h() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            SalesArchiveActivity.this.f1003a.c("يتم جلب ارشيف المبيعات...");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public ArrayList<Sessions> doInBackground(Void... voids) {
            try {
                if (SalesArchiveActivity.f990a.e0("user_manager_sales") > 0) {
                    this.f1011a = SalesArchiveActivity.f990a.m0("user_manager_sales");
                }
            } catch (Exception e) {
            }
            return this.f1011a;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(ArrayList<Sessions> result) {
            try {
                Toast.makeText(SalesArchiveActivity.this.f994a, "تم جلب البيانات", 0).show();
                qb0.f4819e = result;
                if (result == null) {
                    SalesArchiveActivity.this.f1003a.a();
                    Toast.makeText(SalesArchiveActivity.this, "لا يوجد مبيعات في الارشيف", 1).show();
                } else if (result.size() > 0) {
                    SalesArchiveActivity.this.n();
                    SalesArchiveActivity.this.f1003a.a();
                    SalesArchiveActivity.this.m();
                } else {
                    SalesArchiveActivity.this.f1003a.a();
                    Toast.makeText(SalesArchiveActivity.this, "لا يوجد مبيعات في الارشيف", 1).show();
                }
            } catch (Exception e) {
                SalesArchiveActivity.this.f1003a.a();
            }
        }
    }

    class i extends AsyncTask<Void, Void, String> {
        double a = 0.0d;

        /* renamed from: a  reason: collision with other field name */
        String f1013a;

        /* renamed from: a  reason: collision with other field name */
        ArrayList<Sessions> f1014a = new ArrayList<>();
        String b;
        String c;
        String d;
        String e = "0";
        String f = "يتم جلب البيانات";

        public i(String StartDate, String endDate, String EtherName, String PriceList, String Msg) {
            this.f1013a = StartDate;
            this.b = endDate;
            this.c = EtherName;
            this.d = PriceList;
            this.f = Msg;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            SalesArchiveActivity.f992d.clear();
            SalesArchiveActivity.this.f1003a.c(this.f);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Void... voids) {
            try {
                if (TextUtils.isEmpty(this.f1013a) || TextUtils.isEmpty(this.b)) {
                    return "";
                }
                SalesArchiveActivity.f992d = SalesArchiveActivity.f990a.n0("user_manager_sales", this.f1013a, this.b, this.c, this.d, SalesArchiveActivity.f989a);
                this.e = SalesArchiveActivity.f989a.toString();
                Iterator<Sessions> it = SalesArchiveActivity.f992d.iterator();
                while (it.hasNext()) {
                    Sessions ses = it.next();
                    double d2 = 0.0d;
                    double parseFloat = this.a + ((ses.getDownload() == null || ses.getDownload().isEmpty()) ? 0.0d : (double) Float.parseFloat(ses.getDownload()));
                    this.a = parseFloat;
                    if (ses.getUpload() != null && !ses.getUpload().isEmpty()) {
                        d2 = (double) Float.parseFloat(ses.getUpload());
                    }
                    this.a = parseFloat + d2;
                }
                return "";
            } catch (Exception e2) {
                return "";
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            try {
                if (SalesArchiveActivity.f992d.size() > 0) {
                    SalesArchiveActivity.f986a.setVisibility(0);
                    SalesArchiveActivity.e.setVisibility(0);
                    SalesArchiveActivity.f.setVisibility(0);
                    String formatted = qb0.e(String.valueOf(this.a));
                    TextView textView = SalesArchiveActivity.f;
                    textView.setText("مجموع التحميل+الرفع: " + formatted);
                    TextView textView2 = SalesArchiveActivity.e;
                    textView2.setText("المجموع :" + this.e);
                    TextView textView3 = SalesArchiveActivity.d;
                    textView3.setText("العدد :" + String.valueOf(SalesArchiveActivity.f992d.size()));
                    SalesArchiveActivity salesArchiveActivity = SalesArchiveActivity.this;
                    salesArchiveActivity.f1002a = new wp0(salesArchiveActivity.f994a, SalesArchiveActivity.f992d);
                    SalesArchiveActivity salesArchiveActivity2 = SalesArchiveActivity.this;
                    SalesArchiveActivity.f987a = new np0(salesArchiveActivity2.f994a, salesArchiveActivity2.f1002a);
                    SalesArchiveActivity.f986a.setAdapter(SalesArchiveActivity.f987a);
                    SalesArchiveActivity.f987a.x(SalesArchiveActivity.this.f1002a.c(), SalesArchiveActivity.this.f1002a.f(), SalesArchiveActivity.this.f1002a.a());
                } else {
                    SalesArchiveActivity.d.setText("لا توجد مبيعات حسب البيانات المحدده");
                    SalesArchiveActivity.f986a.setVisibility(8);
                    SalesArchiveActivity.e.setVisibility(8);
                    SalesArchiveActivity.f.setVisibility(8);
                }
                SalesArchiveActivity.this.f1003a.a();
                Toast.makeText(SalesArchiveActivity.this.f994a, "تم جلب البيانات", 0).show();
            } catch (Exception e2) {
                SalesArchiveActivity.this.f1003a.a();
                Toast.makeText(SalesArchiveActivity.this.f994a, e2.getMessage(), 0).show();
            }
        }
    }
}
