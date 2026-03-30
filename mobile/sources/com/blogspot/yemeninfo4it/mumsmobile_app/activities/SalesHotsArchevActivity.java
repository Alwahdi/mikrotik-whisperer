package com.blogspot.yemeninfo4it.mumsmobile_app.activities;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SalesHotsArchevActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    public static int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static TableView f1037a;

    /* renamed from: a  reason: collision with other field name */
    public static String f1038a;

    /* renamed from: a  reason: collision with other field name */
    public static ue f1039a;
    public static String b;
    public static TextView c;

    /* renamed from: c  reason: collision with other field name */
    public static ArrayList<Sessions> f1040c;
    public static TextView d;
    public static TextView e;
    public static TextView f;
    public static TextView g;

    /* renamed from: a  reason: collision with other field name */
    Context f1041a;

    /* renamed from: a  reason: collision with other field name */
    public Button f1042a;

    /* renamed from: a  reason: collision with other field name */
    ImageView f1043a;

    /* renamed from: a  reason: collision with other field name */
    public LinearLayout f1044a;

    /* renamed from: a  reason: collision with other field name */
    public TextView f1045a;

    /* renamed from: a  reason: collision with other field name */
    d f1046a;

    /* renamed from: a  reason: collision with other field name */
    e f1047a;

    /* renamed from: a  reason: collision with other field name */
    public d0 f1048a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<Sessions> f1049a;

    /* renamed from: a  reason: collision with other field name */
    public wp0 f1050a;

    /* renamed from: a  reason: collision with other field name */
    zd f1051a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1052a = true;

    /* renamed from: b  reason: collision with other field name */
    public Button f1053b;

    /* renamed from: b  reason: collision with other field name */
    LinearLayout f1054b;

    /* renamed from: b  reason: collision with other field name */
    TextView f1055b;

    /* renamed from: b  reason: collision with other field name */
    public ArrayList<Payment> f1056b;

    /* renamed from: c  reason: collision with other field name */
    public Button f1057c;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.salse_layout);
        this.f1041a = this;
        try {
            f1039a = new ue(this.f1041a);
            zd zdVar = new zd(this);
            this.f1051a = zdVar;
            TextView textView = (TextView) zdVar.b().findViewById(R.id.cancel_btn);
            this.f1055b = textView;
            textView.setVisibility(8);
            this.f1042a = (Button) findViewById(R.id.activebtn);
            this.f1053b = (Button) findViewById(R.id.showbtn);
            this.f1043a = (ImageView) findViewById(R.id.icontoolbar);
            this.f1057c = (Button) findViewById(R.id.dubl);
            c = (TextView) findViewById(R.id.activeacount);
            d = (TextView) findViewById(R.id.sum);
            e = (TextView) findViewById(R.id.transmit_sum);
            f = (TextView) findViewById(R.id.start_date);
            g = (TextView) findViewById(R.id.end_date);
            this.f1044a = (LinearLayout) findViewById(R.id.ether_layout);
            this.f1045a = (TextView) findViewById(R.id.header_text_title);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.search_field);
            this.f1054b = linearLayout;
            linearLayout.setVisibility(8);
            this.f1043a.setVisibility(8);
            this.f1045a.setText("ارشيف مبيعات الهوتسبوت");
            this.f1049a = new ArrayList<>();
            f1040c = new ArrayList<>();
            this.f1044a.setVisibility(8);
            this.f1056b = new ArrayList<>();
            f1037a = (TableView) findViewById(R.id.tableview);
            this.f1042a.setVisibility(8);
            d dVar = new d();
            this.f1046a = dVar;
            dVar.execute(new Void[0]);
            f.setOnClickListener(new a());
            g.setOnClickListener(new b());
            this.f1053b.setOnClickListener(new c());
        } catch (Exception e2) {
            Toast.makeText(this, e2.getMessage() + "حدثت مشكله", 1).show();
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View v) {
            try {
                z20 mDatePickerDialogFragment = new z20();
                qb0.f4820e = true;
                mDatePickerDialogFragment.show(SalesHotsArchevActivity.this.getSupportFragmentManager(), "From Date");
            } catch (Exception e) {
                Toast.makeText(SalesHotsArchevActivity.this.f1041a, e.getMessage(), 0).show();
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View v) {
            try {
                z20 mDatePickerDialogFragment = new z20();
                qb0.f4820e = false;
                mDatePickerDialogFragment.show(SalesHotsArchevActivity.this.getSupportFragmentManager(), "To Date");
            } catch (Exception e) {
                Toast.makeText(SalesHotsArchevActivity.this.f1041a, e.getMessage(), 0).show();
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
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

    public void m() {
        String strDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).format(Calendar.getInstance().getTime());
        a = 0;
        g.setText(strDate);
        b = strDate;
        f.setText(strDate);
        f1038a = strDate;
        try {
            ArrayList<Sessions> arrayList = qb0.f4829i;
            if (arrayList != null && arrayList.size() > 0 && !TextUtils.isEmpty(f1038a) && !TextUtils.isEmpty(b)) {
                f1040c.clear();
                e eVar = new e(f1038a, b, "يتم جلب البيانات لتاريخ اليوم");
                this.f1047a = eVar;
                eVar.execute(new Void[0]);
            }
        } catch (Exception e2) {
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        this.f1050a = new wp0(this.f1041a, qb0.f4829i);
        np0 np0 = new np0(this.f1041a, this.f1050a);
        this.f1048a = np0;
        f1037a.setAdapter(np0);
        this.f1048a.x(this.f1050a.c(), this.f1050a.f(), this.f1050a.a());
    }

    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.set(1, year);
        mCalendar.set(2, month);
        mCalendar.set(5, dayOfMonth);
        String date = String.valueOf(view.getDayOfMonth()) + "/" + String.valueOf(view.getMonth() + 1) + "/" + String.valueOf(view.getYear());
        Locale locale = Locale.ENGLISH;
        SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy", locale);
        SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy", locale);
        String date2 = "";
        try {
            Date date4 = formatter.parse(date);
            if (date4 != null) {
                date2 = formatter2.format(date4);
            }
        } catch (Exception e2) {
        }
        a = 0;
        if (qb0.f4820e) {
            f.setText(date2);
            f1038a = date2;
            if (!TextUtils.isEmpty(date2) && !TextUtils.isEmpty(b)) {
                e eVar = new e(f1038a, b, "يتم جلب البيانات حسب التاريخ المحدد");
                this.f1047a = eVar;
                eVar.execute(new Void[0]);
                return;
            }
            return;
        }
        g.setText(date2);
        b = date2;
        if (!TextUtils.isEmpty(f1038a) && !TextUtils.isEmpty(b)) {
            e eVar2 = new e(f1038a, b, "يتم جلب البيانات حسب التاريخ المحدد");
            this.f1047a = eVar2;
            eVar2.execute(new Void[0]);
        }
    }

    public Date k(String dtStart) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date dateReturn = new Date();
        try {
            return format.parse(dtStart);
        } catch (ParseException e2) {
            e2.printStackTrace();
            return dateReturn;
        }
    }

    class d extends AsyncTask<Void, Void, ArrayList<Sessions>> {

        /* renamed from: a  reason: collision with other field name */
        ArrayList<Sessions> f1058a = new ArrayList<>();

        d() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            SalesHotsArchevActivity.this.f1051a.c("يتم جلب ارشيف المبيعات...");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public ArrayList<Sessions> doInBackground(Void... voids) {
            try {
                this.f1058a = SalesHotsArchevActivity.f1039a.f0("hotpot_sales");
            } catch (Exception e) {
            }
            return this.f1058a;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(ArrayList<Sessions> result) {
            try {
                Toast.makeText(SalesHotsArchevActivity.this.f1041a, "تم جلب البيانات", 0).show();
                qb0.f4829i = result;
                if (result == null) {
                    SalesHotsArchevActivity.this.f1051a.a();
                    Toast.makeText(SalesHotsArchevActivity.this, "لا يوجد مبيعات في الارشيف", 1).show();
                } else if (result.size() > 0) {
                    TextView textView = SalesHotsArchevActivity.d;
                    textView.setText("المجموع :" + SalesHotsArchevActivity.f1039a.r0("hotpot_sales"));
                    TextView textView2 = SalesHotsArchevActivity.c;
                    textView2.setText("العدد: " + qb0.f4829i.size());
                    SalesHotsArchevActivity.this.l();
                    SalesHotsArchevActivity.f1037a.setVisibility(0);
                    SalesHotsArchevActivity.d.setVisibility(0);
                    SalesHotsArchevActivity.this.f1051a.a();
                    SalesHotsArchevActivity.this.m();
                } else {
                    SalesHotsArchevActivity.this.f1051a.a();
                    Toast.makeText(SalesHotsArchevActivity.this, "لا يوجد مبيعات في الارشيف", 1).show();
                }
            } catch (Exception e) {
                SalesHotsArchevActivity.this.f1051a.a();
            }
        }
    }

    class e extends AsyncTask<Void, Void, String> {
        double a = 0.0d;

        /* renamed from: a  reason: collision with other field name */
        int f1059a = 0;

        /* renamed from: a  reason: collision with other field name */
        String f1061a;

        /* renamed from: a  reason: collision with other field name */
        ArrayList<Sessions> f1062a = new ArrayList<>();
        String b;
        String c = "يتم جلب البيانات";

        public e(String StartDate, String endDate, String Msg) {
            this.f1061a = StartDate;
            this.b = endDate;
            this.c = Msg;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            SalesHotsArchevActivity.f1040c.clear();
            SalesHotsArchevActivity.this.f1051a.c(this.c);
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public String doInBackground(Void... voids) {
            try {
                if (TextUtils.isEmpty(this.f1061a) || TextUtils.isEmpty(this.b)) {
                    return "";
                }
                List<Sessions> resList = (List) ln0.U(qb0.f4829i).q(new e(this, SalesHotsArchevActivity.this.k(this.f1061a), SalesHotsArchevActivity.this.k(this.b))).f(v9.d());
                if (resList == null) {
                    return "";
                }
                SalesHotsArchevActivity.f1040c = (ArrayList) resList;
                for (int i = 0; i < resList.size(); i++) {
                    this.f1059a += Integer.parseInt(resList.get(i).getPrice());
                    double d = 0.0d;
                    double parseFloat = this.a + ((resList.get(i).getDownload() == null || resList.get(i).getDownload().isEmpty()) ? 0.0d : (double) Float.parseFloat(resList.get(i).getDownload()));
                    this.a = parseFloat;
                    if (resList.get(i).getUpload() != null && !resList.get(i).getUpload().isEmpty()) {
                        d = (double) Float.parseFloat(resList.get(i).getUpload());
                    }
                    this.a = parseFloat + d;
                }
                return "";
            } catch (Exception e) {
                return "";
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ boolean c(Date d1, Date d2, Sessions item) {
            return (SalesHotsArchevActivity.this.k(item.getStfrom()).compareTo(d1) >= 0 && SalesHotsArchevActivity.this.k(item.getStfrom()).compareTo(d2) <= 0) || (SalesHotsArchevActivity.this.k(item.getStfrom()).compareTo(d1) <= 0 && SalesHotsArchevActivity.this.k(item.getStfrom()).compareTo(d2) >= 0);
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void onPostExecute(String result) {
            try {
                if (SalesHotsArchevActivity.f1040c.size() > 0) {
                    SalesHotsArchevActivity.f1037a.setVisibility(0);
                    SalesHotsArchevActivity.d.setVisibility(0);
                    SalesHotsArchevActivity.e.setVisibility(0);
                    String formatted = qb0.e(String.valueOf(this.a));
                    TextView textView = SalesHotsArchevActivity.e;
                    textView.setText("مجموع التحميل+الرفع: " + formatted);
                    TextView textView2 = SalesHotsArchevActivity.d;
                    textView2.setText("المجموع :" + String.valueOf(this.f1059a));
                    TextView textView3 = SalesHotsArchevActivity.c;
                    textView3.setText("العدد :" + String.valueOf(SalesHotsArchevActivity.f1040c.size()));
                    SalesHotsArchevActivity salesHotsArchevActivity = SalesHotsArchevActivity.this;
                    salesHotsArchevActivity.f1050a = new wp0(salesHotsArchevActivity.f1041a, SalesHotsArchevActivity.f1040c);
                    SalesHotsArchevActivity salesHotsArchevActivity2 = SalesHotsArchevActivity.this;
                    SalesHotsArchevActivity salesHotsArchevActivity3 = SalesHotsArchevActivity.this;
                    salesHotsArchevActivity2.f1048a = new np0(salesHotsArchevActivity3.f1041a, salesHotsArchevActivity3.f1050a);
                    SalesHotsArchevActivity.f1037a.setAdapter(SalesHotsArchevActivity.this.f1048a);
                    SalesHotsArchevActivity salesHotsArchevActivity4 = SalesHotsArchevActivity.this;
                    salesHotsArchevActivity4.f1048a.x(salesHotsArchevActivity4.f1050a.c(), SalesHotsArchevActivity.this.f1050a.f(), SalesHotsArchevActivity.this.f1050a.a());
                } else {
                    TextView textView4 = SalesHotsArchevActivity.c;
                    textView4.setText(" لا توجد مبيعات " + SalesHotsArchevActivity.f1040c.size());
                    SalesHotsArchevActivity.f1037a.setVisibility(8);
                    SalesHotsArchevActivity.d.setVisibility(8);
                    SalesHotsArchevActivity.e.setVisibility(8);
                }
                SalesHotsArchevActivity.this.f1051a.a();
                Toast.makeText(SalesHotsArchevActivity.this.f1041a, "تم جلب البيانات", 0).show();
            } catch (Exception e) {
                SalesHotsArchevActivity.this.f1051a.a();
                Toast.makeText(SalesHotsArchevActivity.this.f1041a, e.getMessage(), 0).show();
            }
        }
    }
}
