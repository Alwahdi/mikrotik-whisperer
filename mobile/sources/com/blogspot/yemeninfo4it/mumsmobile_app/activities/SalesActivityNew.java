package com.blogspot.yemeninfo4it.mumsmobile_app.activities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
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
import android.widget.RelativeLayout;
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
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class SalesActivityNew extends AppCompatActivity {
    public static Spinner a;

    /* renamed from: a  reason: collision with other field name */
    public static TableView f957a;

    /* renamed from: a  reason: collision with other field name */
    public static d0 f958a;

    /* renamed from: a  reason: collision with other field name */
    public static String f959a;

    /* renamed from: a  reason: collision with other field name */
    public static StringBuilder f960a;

    /* renamed from: a  reason: collision with other field name */
    public static ue f961a;
    public static Spinner b;

    /* renamed from: b  reason: collision with other field name */
    public static String f962b;
    public static TextView d;

    /* renamed from: d  reason: collision with other field name */
    public static ArrayList<Sessions> f963d;
    public static TextView e;
    public static TextView f;
    public static TextView g;
    public static TextView h;

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f964a;

    /* renamed from: a  reason: collision with other field name */
    Context f965a;

    /* renamed from: a  reason: collision with other field name */
    public Button f966a;

    /* renamed from: a  reason: collision with other field name */
    ImageView f967a;

    /* renamed from: a  reason: collision with other field name */
    public TextView f968a;

    /* renamed from: a  reason: collision with other field name */
    i f969a;

    /* renamed from: a  reason: collision with other field name */
    j f970a;

    /* renamed from: a  reason: collision with other field name */
    j3 f971a;

    /* renamed from: a  reason: collision with other field name */
    DecimalFormat f972a;

    /* renamed from: a  reason: collision with other field name */
    NumberFormat f973a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<Sessions> f974a;

    /* renamed from: a  reason: collision with other field name */
    public wp0 f975a;

    /* renamed from: a  reason: collision with other field name */
    zd f976a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f977a = true;

    /* renamed from: b  reason: collision with other field name */
    public Button f978b;

    /* renamed from: b  reason: collision with other field name */
    public TextView f979b;

    /* renamed from: b  reason: collision with other field name */
    public ArrayList<Payment> f980b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public boolean f981b;
    public Button c;

    /* renamed from: c  reason: collision with other field name */
    TextView f982c;

    /* renamed from: c  reason: collision with other field name */
    public ArrayList<InterfaceList> f983c;

    public SalesActivityNew() {
        NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.ENGLISH);
        this.f973a = numberInstance;
        this.f972a = (DecimalFormat) numberInstance;
        this.f981b = false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.salse_layout);
        this.f965a = this;
        this.f971a = qb0.d();
        this.f983c = new ArrayList<>();
        zd zdVar = new zd(this);
        this.f976a = zdVar;
        TextView textView = (TextView) zdVar.b().findViewById(R.id.cancel_btn);
        this.f982c = textView;
        textView.setVisibility(8);
        f961a = new ue(this.f965a);
        this.f972a.applyPattern("#.##");
        this.f964a = new ProgressDialog(this);
        this.f966a = (Button) findViewById(R.id.activebtn);
        this.f978b = (Button) findViewById(R.id.showbtn);
        this.c = (Button) findViewById(R.id.dubl);
        d = (TextView) findViewById(R.id.activeacount);
        e = (TextView) findViewById(R.id.sum);
        f = (TextView) findViewById(R.id.transmit_sum);
        g = (TextView) findViewById(R.id.start_date);
        h = (TextView) findViewById(R.id.end_date);
        a = (Spinner) findViewById(R.id.ether_name);
        b = (Spinner) findViewById(R.id.price_list);
        this.f979b = (TextView) findViewById(R.id.header_text_title);
        this.f968a = (TextView) findViewById(R.id.load_myprofile);
        this.f967a = (ImageView) findViewById(R.id.icontoolbar);
        this.f974a = new ArrayList<>();
        f963d = new ArrayList<>();
        this.f980b = new ArrayList<>();
        f957a = (TableView) findViewById(R.id.tableview);
        try {
            this.f979b.setText("إدارة مبيعات يوزرمانجر");
            this.f967a.setVisibility(8);
            n();
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
                ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367048, list2);
                arrayAdapter.setDropDownViewResource(17367049);
                a.setAdapter(arrayAdapter);
            } else {
                new k().execute(new String[0]);
            }
            this.f968a.setOnClickListener(new a());
            this.f966a.setOnClickListener(new b());
            a.setOnItemSelectedListener(new c());
            b.setOnItemSelectedListener(new d());
            g.setOnClickListener(new e());
            h.setOnClickListener(new f());
            this.f978b.setOnClickListener(new g());
        } catch (Exception e2) {
            Toast.makeText(this, e2.toString(), 1).show();
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View v) {
            new k().execute(new String[0]);
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View v) {
        }
    }

    class c implements AdapterView.OnItemSelectedListener {
        c() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            if (SalesActivityNew.this.f981b) {
                SalesActivityNew.this.l();
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class d implements AdapterView.OnItemSelectedListener {
        d() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            if (SalesActivityNew.this.f981b) {
                SalesActivityNew.this.l();
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        public void onClick(View v) {
            DialogFragment dFragment = new h();
            qb0.f4820e = true;
            dFragment.show(SalesActivityNew.this.getFragmentManager(), "From Date");
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        public void onClick(View v) {
            DialogFragment dFragment = new h();
            qb0.f4820e = false;
            dFragment.show(SalesActivityNew.this.getFragmentManager(), "To Date");
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        public void onClick(View v) {
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(jv0.b(newBase));
    }

    public void n() {
        if (f961a.e0("user_manager_sales_cach") > 0) {
            qb0.f4819e = f961a.m0("user_manager_sales_cach");
            m();
        } else if (qb0.f <= 0) {
            Toast.makeText(this, "لم يتم تحميل البيانات..الرجاء التاكد من جودة اتصالك بالشبكه", 1).show();
        } else if (!qb0.f4823f) {
            j jVar = new j();
            this.f970a = jVar;
            jVar.execute(new Void[0]);
            i iVar = new i();
            this.f969a = iVar;
            iVar.execute(new Void[0]);
        }
    }

    public void onUserInteraction() {
        super.onUserInteraction();
        this.f981b = true;
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    class k extends AsyncTask<String, Void, String> {

        /* renamed from: a  reason: collision with other field name */
        String f984a = "Error";

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f985a = null;

        k() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            SalesActivityNew.this.f964a.setTitle("يرجى الانتظار..");
            SalesActivityNew.this.f964a.setMessage("جاري تحميل المنافذ");
            SalesActivityNew.this.f964a.setCancelable(false);
            SalesActivityNew.this.f964a.setIndeterminate(false);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                SalesActivityNew.this.f971a.J(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
                this.f985a = SalesActivityNew.this.f971a.q("/interface/print");
                return null;
            } catch (Exception e) {
                try {
                    Log.d("LOG", e.getMessage() + "error");
                    this.f984a = e.getMessage();
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.f984a = e2.getMessage();
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
                for (Map<String, String> res : this.f985a) {
                    if (res.get("name") != null) {
                        SalesActivityNew.this.f983c.add(new InterfaceList(res.get(".id"), res.get("name")));
                        list.add(res.get("name"));
                    }
                }
                qb0.f4831j = SalesActivityNew.this.f983c;
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(SalesActivityNew.this, 17367048, list);
                dataAdapter.setDropDownViewResource(17367049);
                SalesActivityNew.a.setAdapter(dataAdapter);
                SalesActivityNew.this.f964a.dismiss();
            } catch (Exception e) {
                Toast.makeText(SalesActivityNew.this, e.getMessage(), 1).show();
                SalesActivityNew.this.f964a.dismiss();
            }
        }
    }

    public static class h extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        DatePickerDialog a;

        public Dialog onCreateDialog(Bundle savedInstanceState) {
            Calendar calendar = Calendar.getInstance();
            this.a = new DatePickerDialog(getActivity(), 3, this, calendar.get(1), calendar.get(2), calendar.get(5));
            TextView tv = new TextView(getActivity());
            tv.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            tv.setPadding(10, 10, 10, 10);
            tv.setGravity(17);
            tv.setTextSize(1, 20.0f);
            tv.setText("قم بإختيار التاريخ");
            tv.setTextColor(Color.parseColor("#ffffff"));
            tv.setBackgroundColor(Color.parseColor("#FFD2DAA7"));
            this.a.setTitle("قم بإختيار التاريخ");
            return this.a;
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            Date d1;
            String date;
            double d;
            try {
                String date2 = String.valueOf(view.getDayOfMonth()) + "/" + String.valueOf(view.getMonth() + 1) + "/" + String.valueOf(view.getYear());
                Object obj = "";
                SalesActivityNew salesActivityNew = new SalesActivityNew();
                Locale locale = Locale.ENGLISH;
                SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy", locale);
                SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy/MM/dd", locale);
                String date22 = "";
                try {
                    date22 = formatter2.format(formatter.parse(date2));
                } catch (Exception e) {
                }
                SalesActivityNew.f960a = new StringBuilder();
                if (qb0.f4820e) {
                    SalesActivityNew.g.setText(date22);
                    SalesActivityNew.f959a = date22;
                    if (TextUtils.isEmpty(date22) || TextUtils.isEmpty(SalesActivityNew.f962b)) {
                        return;
                    }
                    SalesActivityNew.f963d.clear();
                    Date d12 = salesActivityNew.k(SalesActivityNew.f959a);
                    Date k = salesActivityNew.k(SalesActivityNew.f962b);
                    ArrayList<Sessions> n0 = SalesActivityNew.f961a.n0("user_manager_sales_cach", SalesActivityNew.f959a, SalesActivityNew.f962b, SalesActivityNew.a.getSelectedItem().toString(), SalesActivityNew.b.getSelectedItem().toString(), SalesActivityNew.f960a);
                    SalesActivityNew.f963d = n0;
                    if (n0.size() > 0) {
                        SalesActivityNew.f957a.setVisibility(0);
                        SalesActivityNew.e.setVisibility(0);
                        SalesActivityNew.f.setVisibility(0);
                        double mdownload = 0.0d;
                        Iterator<Sessions> it = SalesActivityNew.f963d.iterator();
                        while (it.hasNext()) {
                            Sessions ses = it.next();
                            if (ses.getDownload() == null || ses.getDownload().isEmpty()) {
                                d1 = d12;
                                date = date2;
                                d = 0.0d;
                            } else {
                                d1 = d12;
                                date = date2;
                                d = (double) Float.parseFloat(ses.getDownload());
                            }
                            mdownload = mdownload + d + ((ses.getUpload() == null || ses.getUpload().isEmpty()) ? 0.0d : (double) Float.parseFloat(ses.getUpload()));
                            date2 = date;
                            d12 = d1;
                        }
                        String str = date2;
                        String formatted = qb0.e(String.valueOf(mdownload));
                        SalesActivityNew.e.setText("المجموع :" + SalesActivityNew.f960a.toString());
                        SalesActivityNew.f.setText("مجموع التحميل+الرفع: " + formatted);
                        SalesActivityNew.d.setText("العدد :" + SalesActivityNew.f963d.size());
                        salesActivityNew.f975a = new wp0(getActivity(), SalesActivityNew.f963d);
                        SalesActivityNew.f958a = new np0(getActivity(), salesActivityNew.f975a);
                        SalesActivityNew.f957a.setAdapter(SalesActivityNew.f958a);
                        SalesActivityNew.f958a.x(salesActivityNew.f975a.c(), salesActivityNew.f975a.f(), salesActivityNew.f975a.a());
                    } else {
                        String str2 = date2;
                        SalesActivityNew.d.setText("لا توجد مبيعات حسب البيانات المحدده");
                        SalesActivityNew.f957a.setVisibility(8);
                        SalesActivityNew.e.setVisibility(8);
                        SalesActivityNew.f.setVisibility(8);
                    }
                    return;
                }
                SalesActivityNew.h.setText(date22);
                SalesActivityNew.f962b = date22;
                if (!TextUtils.isEmpty(SalesActivityNew.f959a) && !TextUtils.isEmpty(SalesActivityNew.f962b)) {
                    SalesActivityNew.f963d.clear();
                    Date k2 = salesActivityNew.k(SalesActivityNew.f959a);
                    Date k3 = salesActivityNew.k(SalesActivityNew.f962b);
                    ArrayList<Sessions> n02 = SalesActivityNew.f961a.n0("user_manager_sales_cach", SalesActivityNew.f959a, SalesActivityNew.f962b, SalesActivityNew.a.getSelectedItem().toString(), SalesActivityNew.b.getSelectedItem().toString(), SalesActivityNew.f960a);
                    SalesActivityNew.f963d = n02;
                    if (n02.size() > 0) {
                        SalesActivityNew.f957a.setVisibility(0);
                        SalesActivityNew.e.setVisibility(0);
                        SalesActivityNew.f.setVisibility(0);
                        double mdownload2 = 0.0d;
                        Iterator<Sessions> it2 = SalesActivityNew.f963d.iterator();
                        while (it2.hasNext()) {
                            Sessions ses2 = it2.next();
                            mdownload2 = mdownload2 + ((ses2.getDownload() == null || ses2.getDownload().isEmpty()) ? 0.0d : (double) Float.parseFloat(ses2.getDownload())) + ((ses2.getUpload() == null || ses2.getUpload().isEmpty()) ? 0.0d : (double) Float.parseFloat(ses2.getUpload()));
                        }
                        String formatted2 = qb0.e(String.valueOf(mdownload2));
                        SalesActivityNew.e.setText("المجموع :" + SalesActivityNew.f960a.toString());
                        SalesActivityNew.f.setText("مجموع التحميل+الرفع: " + formatted2);
                        SalesActivityNew.d.setText("العدد :" + SalesActivityNew.f963d.size());
                        salesActivityNew.f975a = new wp0(getActivity(), SalesActivityNew.f963d);
                        SalesActivityNew.f958a = new np0(getActivity(), salesActivityNew.f975a);
                        SalesActivityNew.f957a.setAdapter(SalesActivityNew.f958a);
                        SalesActivityNew.f958a.x(salesActivityNew.f975a.c(), salesActivityNew.f975a.f(), salesActivityNew.f975a.a());
                        return;
                    }
                    SalesActivityNew.d.setText("لا توجد مبيعات حسب البيانات المحدده");
                    SalesActivityNew.f957a.setVisibility(8);
                    SalesActivityNew.e.setVisibility(8);
                    SalesActivityNew.f.setVisibility(8);
                }
            } catch (Exception e2) {
                Toast.makeText(getActivity(), e2.toString(), 1).show();
            }
        }
    }

    public void m() {
        try {
            String strDate = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).format(Calendar.getInstance().getTime());
            f960a = new StringBuilder();
            h.setText(strDate);
            f962b = strDate;
            g.setText(strDate);
            f959a = strDate;
            if (!TextUtils.isEmpty(strDate) && !TextUtils.isEmpty(f962b)) {
                f963d.clear();
                ArrayList<Sessions> n0 = f961a.n0("user_manager_sales_cach", f959a, f962b, "الكل", "الكل", f960a);
                f963d = n0;
                if (n0.size() > 0) {
                    f957a.setVisibility(0);
                    e.setVisibility(0);
                    f.setVisibility(0);
                    double mdownload = 0.0d;
                    Iterator<Sessions> it = f963d.iterator();
                    while (it.hasNext()) {
                        Sessions ses = it.next();
                        double d2 = 0.0d;
                        double mdownload2 = mdownload + ((ses.getDownload() == null || ses.getDownload().isEmpty()) ? 0.0d : (double) Float.parseFloat(ses.getDownload()));
                        if (ses.getUpload() != null && !ses.getUpload().isEmpty()) {
                            d2 = (double) Float.parseFloat(ses.getUpload());
                        }
                        mdownload = mdownload2 + d2;
                    }
                    String formatted = qb0.e(String.valueOf(mdownload));
                    TextView textView = e;
                    textView.setText("المجموع :" + f960a.toString());
                    TextView textView2 = f;
                    textView2.setText("مجموع التحميل+الرفع: " + formatted);
                    TextView textView3 = d;
                    textView3.setText("العدد :" + f963d.size());
                    this.f975a = new wp0(this, f963d);
                    np0 np0 = new np0(this, this.f975a);
                    f958a = np0;
                    f957a.setAdapter(np0);
                    f958a.x(this.f975a.c(), this.f975a.f(), this.f975a.a());
                    return;
                }
                d.setText("لا توجد مبيعات بتاريخ اليوم");
                f957a.setVisibility(8);
                e.setVisibility(8);
                f.setVisibility(8);
            }
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
            f960a = new StringBuilder();
            f962b = h.getText().toString();
            String charSequence = g.getText().toString();
            f959a = charSequence;
            if (!TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(f962b)) {
                f963d.clear();
                ArrayList<Sessions> n0 = f961a.n0("user_manager_sales_cach", f959a, f962b, eth, pr, f960a);
                f963d = n0;
                if (n0.size() > 0) {
                    f957a.setVisibility(0);
                    e.setVisibility(0);
                    f.setVisibility(0);
                    double mdownload = 0.0d;
                    Iterator<Sessions> it = f963d.iterator();
                    while (it.hasNext()) {
                        Sessions ses = it.next();
                        double d2 = 0.0d;
                        double mdownload2 = mdownload + ((ses.getDownload() == null || ses.getDownload().isEmpty()) ? 0.0d : (double) Float.parseFloat(ses.getDownload()));
                        if (ses.getUpload() != null && !ses.getUpload().isEmpty()) {
                            d2 = (double) Float.parseFloat(ses.getUpload());
                        }
                        mdownload = mdownload2 + d2;
                    }
                    String formatted = qb0.e(String.valueOf(mdownload));
                    TextView textView = e;
                    textView.setText("المجموع :" + f960a.toString());
                    TextView textView2 = f;
                    textView2.setText("مجموع التحميل+الرفع: " + formatted);
                    TextView textView3 = d;
                    textView3.setText("العدد :" + f963d.size());
                    this.f975a = new wp0(this, f963d);
                    np0 np0 = new np0(this, this.f975a);
                    f958a = np0;
                    f957a.setAdapter(np0);
                    f958a.x(this.f975a.c(), this.f975a.f(), this.f975a.a());
                    return;
                }
                d.setText("لا توجد مبيعات حسب البيانات المحدده");
                f957a.setVisibility(8);
                e.setVisibility(8);
                f.setVisibility(8);
            }
        } catch (Exception e2) {
            Toast.makeText(this, e2.toString(), 1).show();
        }
    }

    public Date k(String dtStart) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date dateReturn = new Date();
        try {
            return format.parse(dtStart);
        } catch (ParseException e2) {
            e2.printStackTrace();
            return dateReturn;
        }
    }

    public class j extends AsyncTask<Void, Void, String> {
        public j() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            SalesActivityNew.this.f976a.c("يتم ارشفة المبيعات...");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Void... strings) {
            try {
                SalesActivityNew.f961a.X("user_manager_sales_cach", qb0.f4819e);
                qb0.f4823f = true;
                return null;
            } catch (Exception e) {
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            SalesActivityNew.this.f976a.a();
            try {
                Toast.makeText(SalesActivityNew.this.f965a, "تمت الارشفة", 0).show();
                qb0.f4823f = true;
                SalesActivityNew.this.m();
            } catch (Exception e) {
                Context context = SalesActivityNew.this.f965a;
                Toast.makeText(context, e.getMessage() + " cd", 0).show();
            }
        }
    }

    public class i extends AsyncTask<Void, Void, String> {
        public i() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Void... strings) {
            try {
                SalesActivityNew.f961a.Y();
                qb0.f4823f = true;
                return null;
            } catch (Exception e) {
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            try {
                qb0.f4823f = true;
            } catch (Exception e) {
            }
        }
    }
}
