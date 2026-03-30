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
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.InterfaceList;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Payment;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Sessions;
import com.evrencoskun.tableview.TableView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class SalseActivity extends AppCompatActivity {
    public static TableView a;

    /* renamed from: a  reason: collision with other field name */
    public static d0 f1082a;

    /* renamed from: a  reason: collision with other field name */
    public static String f1083a;
    public static String b;
    public static int c = 0;

    /* renamed from: c  reason: collision with other field name */
    public static TextView f1084c;
    public static TextView d;

    /* renamed from: d  reason: collision with other field name */
    public static ArrayList<Sessions> f1085d;
    public static TextView e;
    public static TextView f;

    /* renamed from: a  reason: collision with other field name */
    public int f1086a = 1;

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f1087a;

    /* renamed from: a  reason: collision with other field name */
    Context f1088a;

    /* renamed from: a  reason: collision with other field name */
    public Button f1089a;

    /* renamed from: a  reason: collision with other field name */
    ImageView f1090a;

    /* renamed from: a  reason: collision with other field name */
    Spinner f1091a;

    /* renamed from: a  reason: collision with other field name */
    public TextView f1092a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<Sessions> f1093a;

    /* renamed from: a  reason: collision with other field name */
    List<String> f1094a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    ue f1095a;

    /* renamed from: a  reason: collision with other field name */
    public wp0 f1096a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1097a = true;

    /* renamed from: b  reason: collision with other field name */
    public int f1098b = 1;

    /* renamed from: b  reason: collision with other field name */
    public ProgressDialog f1099b;

    /* renamed from: b  reason: collision with other field name */
    public Button f1100b;

    /* renamed from: b  reason: collision with other field name */
    public TextView f1101b;

    /* renamed from: b  reason: collision with other field name */
    public ArrayList<Payment> f1102b;

    /* renamed from: b  reason: collision with other field name */
    List<String> f1103b = new ArrayList();

    /* renamed from: c  reason: collision with other field name */
    public ProgressDialog f1104c;

    /* renamed from: c  reason: collision with other field name */
    public Button f1105c;

    /* renamed from: c  reason: collision with other field name */
    public ArrayList<InterfaceList> f1106c;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.salse_layout);
        this.f1088a = this;
        this.f1095a = new ue(this.f1088a);
        this.f1106c = new ArrayList<>();
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.f1099b = progressDialog;
        progressDialog.setProgressStyle(1);
        ProgressDialog progressDialog2 = new ProgressDialog(this);
        this.f1104c = progressDialog2;
        progressDialog2.setProgressStyle(1);
        this.f1087a = new ProgressDialog(this);
        this.f1089a = (Button) findViewById(R.id.activebtn);
        this.f1100b = (Button) findViewById(R.id.showbtn);
        this.f1105c = (Button) findViewById(R.id.dubl);
        f1084c = (TextView) findViewById(R.id.activeacount);
        d = (TextView) findViewById(R.id.sum);
        e = (TextView) findViewById(R.id.start_date);
        f = (TextView) findViewById(R.id.end_date);
        this.f1091a = (Spinner) findViewById(R.id.ether_name);
        this.f1101b = (TextView) findViewById(R.id.header_text_title);
        this.f1092a = (TextView) findViewById(R.id.load_myprofile);
        this.f1090a = (ImageView) findViewById(R.id.icontoolbar);
        this.f1099b.setTitle("يرجى الانتظار..");
        this.f1099b.setMessage("جاري تحميل الجلسات");
        this.f1099b.setCancelable(false);
        this.f1099b.setIndeterminate(false);
        this.f1099b.setMax(100);
        this.f1104c.setTitle("يرجى الانتظار..");
        this.f1104c.setMessage("جاري تحميل المبيعات");
        this.f1104c.setCancelable(false);
        this.f1104c.setIndeterminate(false);
        this.f1104c.setMax(100);
        this.f1093a = new ArrayList<>();
        f1085d = new ArrayList<>();
        this.f1102b = new ArrayList<>();
        a = (TableView) findViewById(R.id.tableview);
        try {
            this.f1101b.setText("إدارة مبيعات يوزرمانجر");
            this.f1090a.setVisibility(8);
            n();
            this.f1092a.setOnClickListener(new a());
            this.f1089a.setOnClickListener(new b());
            this.f1091a.setOnItemSelectedListener(new c());
            e.setOnClickListener(new d());
            f.setOnClickListener(new e());
            this.f1100b.setOnClickListener(new f());
            m();
            if (qb0.f4831j != null) {
                List<String> list = new ArrayList<>();
                list.add("الكل");
                for (int i2 = 0; i2 < qb0.f4831j.size(); i2++) {
                    list.add(qb0.f4831j.get(i2).getName());
                }
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, 17367048, list);
                dataAdapter.setDropDownViewResource(17367049);
                this.f1091a.setAdapter(dataAdapter);
                return;
            }
            new j().execute(new String[0]);
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
            new h().execute(new String[0]);
        }
    }

    class c implements AdapterView.OnItemSelectedListener {
        c() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            SalseActivity.this.l();
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        public void onClick(View v) {
            DialogFragment dFragment = new g();
            qb0.f4820e = true;
            dFragment.show(SalseActivity.this.getFragmentManager(), "From Date");
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        public void onClick(View v) {
            DialogFragment dFragment = new g();
            qb0.f4820e = false;
            dFragment.show(SalseActivity.this.getFragmentManager(), "To Date");
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        public void onClick(View v) {
            String price;
            String date2 = "";
            try {
                SalseActivity.e.setText(String.valueOf(qb0.g));
            } catch (Exception e) {
                Toast.makeText(SalseActivity.this, e.toString(), 1).show();
            }
            try {
                if (qb0.f > 0) {
                    SalseActivity.c = 0;
                    qb0.f4819e = SalseActivity.p(qb0.f4815d);
                    Set<String> names = new HashSet<>();
                    ArrayList<Sessions> values = new ArrayList<>();
                    String price2 = date2;
                    String str = date2;
                    Object obj = "0";
                    Locale locale = Locale.ENGLISH;
                    SimpleDateFormat formatter = new SimpleDateFormat("MMM/dd/yyyy HH:mm:ss", locale);
                    SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy", locale);
                    int i = 0;
                    while (i < qb0.f4819e.size()) {
                        String newValue = qb0.f4819e.get(i).getName();
                        String nas_port_id = qb0.f4819e.get(i).getNas_port_id();
                        String sid = qb0.f4819e.get(i).getId();
                        String uptime = qb0.f4819e.get(i).getUptime();
                        String download = qb0.f4819e.get(i).getDownload();
                        String upload = qb0.f4819e.get(i).getUpload();
                        if (!names.contains(newValue)) {
                            names.add(qb0.f4819e.get(i).getName());
                            for (int w = 0; w < qb0.f4833k.size(); w++) {
                                if (newValue.equals(qb0.f4833k.get(w).getName())) {
                                    if (qb0.f4833k.get(w).getPrice().length() > 2) {
                                        price = qb0.f4833k.get(w).getPrice().substring(0, qb0.f4833k.get(w).getPrice().length() - 2);
                                    } else {
                                        price = qb0.f4833k.get(w).getPrice();
                                    }
                                    SalseActivity.c += Integer.valueOf(price).intValue();
                                    try {
                                        date2 = formatter2.format(formatter.parse(qb0.f4819e.get(i).getStfrom()));
                                        price2 = price;
                                    } catch (Exception e2) {
                                        price2 = price;
                                    }
                                }
                            }
                            values.add(new Sessions(newValue, date2, price2, nas_port_id, sid, download, upload, uptime));
                        }
                        i++;
                        String str2 = sid;
                        String str3 = download;
                        String str4 = upload;
                        String str5 = uptime;
                    }
                    qb0.f4819e = values;
                    SalseActivity.d.setText("المجموع :" + SalseActivity.c);
                    SalseActivity.f1084c.setText("العدد: " + String.valueOf(qb0.f4819e.size()));
                    SalseActivity.this.o();
                    SalseActivity.f1084c.setText("العدد: " + String.valueOf(qb0.f4815d.size()));
                    return;
                }
                Toast.makeText(SalseActivity.this, "اضغط على تحميل اولا", 1).show();
            } catch (Exception e3) {
                Toast.makeText(SalseActivity.this, e3.toString(), 1).show();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(jv0.b(newBase));
    }

    public void n() {
        ArrayList<Sessions> newList;
        ArrayList<Sessions> newList2;
        String price;
        if (qb0.f > 0) {
            c = 0;
            ArrayList<Sessions> newList3 = p(qb0.f4815d);
            qb0.f4819e = newList3;
            Set<String> names = new HashSet<>();
            ArrayList<Sessions> values = new ArrayList<>();
            String price2 = "";
            Locale locale = Locale.ENGLISH;
            SimpleDateFormat formatter = new SimpleDateFormat("MMM/dd/yyyy HH:mm:ss", locale);
            SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy", locale);
            String date2 = "";
            int i2 = 0;
            while (i2 < qb0.f4819e.size()) {
                String newValue = qb0.f4819e.get(i2).getName();
                String nas_port_id = qb0.f4819e.get(i2).getNas_port_id();
                String sid = qb0.f4819e.get(i2).getId();
                String uptime = qb0.f4819e.get(i2).getUptime();
                String download = qb0.f4819e.get(i2).getDownload();
                String upload = qb0.f4819e.get(i2).getUpload();
                if (!names.contains(newValue)) {
                    names.add(qb0.f4819e.get(i2).getName());
                    int w = 0;
                    while (w < qb0.f4833k.size()) {
                        if (newValue.equals(qb0.f4833k.get(w).getName())) {
                            if (qb0.f4833k.get(w).getPrice().length() > 2) {
                                newList2 = newList3;
                                price = qb0.f4833k.get(w).getPrice().substring(0, qb0.f4833k.get(w).getPrice().length() - 2);
                            } else {
                                newList2 = newList3;
                                price = qb0.f4833k.get(w).getPrice();
                            }
                            c += Integer.valueOf(price).intValue();
                            try {
                                date2 = formatter2.format(formatter.parse(qb0.f4819e.get(i2).getStfrom()));
                                price2 = price;
                            } catch (Exception e2) {
                                price2 = price;
                            }
                        } else {
                            newList2 = newList3;
                        }
                        w++;
                        newList3 = newList2;
                    }
                    newList = newList3;
                    values.add(new Sessions(newValue, date2, price2, nas_port_id, sid, download, upload, uptime));
                } else {
                    newList = newList3;
                }
                i2++;
                newList3 = newList;
            }
            qb0.f4819e = values;
            d.setText("المجموع :" + c);
            f1084c.setText("العدد: " + String.valueOf(qb0.f4819e.size()));
            o();
            f1084c.setText("العدد: " + String.valueOf(qb0.f4815d.size()));
            return;
        }
        Toast.makeText(this, "لم يتم تحميل البيانات..الرجاء التاكد من جودة اتصالك بالشبكه", 1).show();
    }

    /* access modifiers changed from: private */
    public void o() {
        this.f1096a = new wp0(this, qb0.f4819e);
        np0 np0 = new np0(this, this.f1096a);
        f1082a = np0;
        a.setAdapter(np0);
        f1082a.x(this.f1096a.c(), this.f1096a.f(), this.f1096a.a());
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public static <Sessions> ArrayList<Sessions> p(ArrayList<Sessions> list) {
        ArrayList<Sessions> newList = new ArrayList<>();
        Iterator<Sessions> it = list.iterator();
        while (it.hasNext()) {
            Sessions element = it.next();
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }

    class h extends AsyncTask<String, Integer, String> {

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f1107a = null;

        h() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            SalseActivity salseActivity = SalseActivity.this;
            salseActivity.f1086a = 1;
            salseActivity.f1099b.setProgress(0);
            SalseActivity.this.f1099b.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                Thread.sleep(100);
                try {
                    j3 con = j3.c(qb0.f4797a.getIp(), Integer.valueOf(Integer.parseInt(qb0.f4797a.getPort())));
                    con.C(qb0.f4797a.getUname(), qb0.f4797a.getPass(), true);
                    con.w();
                    this.f1107a = con.q("/tool/user-manager/session/print");
                    Thread.sleep(100);
                    int res_size = this.f1107a.size();
                    for (Map<String, String> res : this.f1107a) {
                        Thread.sleep(1);
                        SalseActivity.this.f1093a.add(new Sessions(res.get("user"), res.get("from-time"), "", res.get("nas-port-id"), "", "0", "0", ""));
                        publishProgress(new Integer[]{Integer.valueOf((int) ((((float) SalseActivity.this.f1086a) / ((float) res_size)) * 100.0f))});
                        SalseActivity.this.f1086a++;
                    }
                    ArrayList<Sessions> arrayList = SalseActivity.this.f1093a;
                    qb0.f4815d = arrayList;
                    qb0.f = arrayList.size();
                    con.close();
                    return null;
                } catch (Exception e) {
                    Log.d("LOG", e.toString() + "error");
                    Toast.makeText(SalseActivity.this, e.toString() + "error", 1).show();
                    SalseActivity.this.f1099b.dismiss();
                    return null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                SalseActivity.this.f1099b.dismiss();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void onProgressUpdate(Integer... values) {
            SalseActivity.this.f1099b.setProgress(values[0].intValue());
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            ArrayList<Sessions> arrayList = SalseActivity.this.f1093a;
            qb0.f4815d = arrayList;
            qb0.f = arrayList.size();
            SalseActivity.this.f1099b.dismiss();
            new i().execute(new String[0]);
        }
    }

    class i extends AsyncTask<String, Integer, String> {

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f1108a = null;

        i() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            SalseActivity salseActivity = SalseActivity.this;
            salseActivity.f1098b = 1;
            salseActivity.f1104c.setProgress(0);
            SalseActivity.this.f1104c.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                j3 con = j3.c(qb0.f4797a.getIp(), Integer.valueOf(Integer.parseInt(qb0.f4797a.getPort())));
                con.C(qb0.f4797a.getUname(), qb0.f4797a.getPass(), true);
                con.w();
                List<Map<String, String>> q = con.q("/tool/user-manager/payment/print");
                this.f1108a = q;
                for (Map<String, String> res : q) {
                    Thread.sleep(1);
                    SalseActivity.this.f1102b.add(new Payment(res.get("user"), res.get("price")));
                    publishProgress(new Integer[]{Integer.valueOf((int) ((((float) SalseActivity.this.f1098b) / ((float) this.f1108a.size())) * 100.0f))});
                    SalseActivity.this.f1098b++;
                }
                qb0.f4833k = SalseActivity.this.f1102b;
                con.close();
                return null;
            } catch (Exception e) {
                try {
                    Log.d("LOG", e.toString() + "error");
                    Toast.makeText(SalseActivity.this, e.toString() + "error", 1).show();
                    SalseActivity.this.f1104c.dismiss();
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    SalseActivity.this.f1104c.dismiss();
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void onProgressUpdate(Integer... values) {
            SalseActivity.this.f1104c.setProgress(values[0].intValue());
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            SalseActivity salseActivity = SalseActivity.this;
            qb0.f4833k = salseActivity.f1102b;
            salseActivity.f1104c.dismiss();
        }
    }

    class j extends AsyncTask<String, Void, String> {

        /* renamed from: a  reason: collision with other field name */
        String f1109a = "Error";

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f1110a = null;

        j() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            SalseActivity.this.f1087a.setTitle("يرجى الانتظار..");
            SalseActivity.this.f1087a.setMessage("جاري تحميل المنافذ");
            SalseActivity.this.f1087a.setCancelable(false);
            SalseActivity.this.f1087a.setIndeterminate(false);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                j3 con = j3.c(qb0.f4797a.getIp(), Integer.valueOf(Integer.parseInt(qb0.f4797a.getPort())));
                con.C(qb0.f4797a.getUname(), qb0.f4797a.getPass(), true);
                con.J(120000);
                con.w();
                this.f1110a = con.q("/interface/print");
                con.close();
                return null;
            } catch (Exception e) {
                try {
                    Log.d("LOG", e.getMessage() + "error");
                    this.f1109a = e.getMessage();
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.f1109a = e2.getMessage();
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
                for (Map<String, String> res : this.f1110a) {
                    SalseActivity.this.f1106c.add(new InterfaceList(res.get(".id"), res.get("name")));
                    list.add(res.get("name"));
                }
                qb0.f4831j = SalseActivity.this.f1106c;
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(SalseActivity.this, 17367048, list);
                dataAdapter.setDropDownViewResource(17367049);
                SalseActivity.this.f1091a.setAdapter(dataAdapter);
                SalseActivity.this.f1087a.dismiss();
            } catch (Exception e) {
                Toast.makeText(SalseActivity.this, e.getMessage(), 1).show();
                SalseActivity.this.f1087a.dismiss();
            }
        }
    }

    public static class g extends DialogFragment implements DatePickerDialog.OnDateSetListener {
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
            try {
                String date = String.valueOf(view.getDayOfMonth()) + "/" + String.valueOf(view.getMonth() + 1) + "/" + String.valueOf(view.getYear());
                Object obj = "";
                SalseActivity salseActivity = new SalseActivity();
                Locale locale = Locale.ENGLISH;
                SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy", locale);
                SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy", locale);
                String date2 = "";
                try {
                    date2 = formatter2.format(formatter.parse(date));
                } catch (Exception e) {
                }
                SalseActivity.c = 0;
                if (qb0.f4820e) {
                    SalseActivity.e.setText(date2);
                    SalseActivity.f1083a = date2;
                    if (!TextUtils.isEmpty(date2) && !TextUtils.isEmpty(SalseActivity.b)) {
                        SalseActivity.f1085d.clear();
                        for (int i = 0; i < qb0.f4819e.size(); i++) {
                            Date d1 = salseActivity.k(SalseActivity.f1083a);
                            Date d2 = salseActivity.k(SalseActivity.b);
                            if ((salseActivity.k(qb0.f4819e.get(i).getStfrom()).compareTo(d1) >= 0 && salseActivity.k(qb0.f4819e.get(i).getStfrom()).compareTo(d2) <= 0) || (salseActivity.k(qb0.f4819e.get(i).getStfrom()).compareTo(d1) <= 0 && salseActivity.k(qb0.f4819e.get(i).getStfrom()).compareTo(d2) >= 0)) {
                                SalseActivity.f1085d.add(new Sessions(qb0.f4819e.get(i).getName(), qb0.f4819e.get(i).getStfrom(), qb0.f4819e.get(i).getPrice(), qb0.f4819e.get(i).getNas_port_id(), qb0.f4819e.get(i).getId(), qb0.f4819e.get(i).getDownload(), qb0.f4819e.get(i).getUpload(), qb0.f4819e.get(i).getUptime()));
                                SalseActivity.c += Integer.valueOf(qb0.f4819e.get(i).getPrice()).intValue();
                            }
                        }
                        if (SalseActivity.f1085d.size() > 0) {
                            SalseActivity.a.setVisibility(0);
                            SalseActivity.d.setText("المجموع :" + SalseActivity.c);
                            SalseActivity.f1084c.setText("العدد :" + SalseActivity.f1085d.size());
                            salseActivity.f1096a = new wp0(getActivity(), SalseActivity.f1085d);
                            SalseActivity.f1082a = new np0(getActivity(), salseActivity.f1096a);
                            SalseActivity.a.setAdapter(SalseActivity.f1082a);
                            SalseActivity.f1082a.x(salseActivity.f1096a.c(), salseActivity.f1096a.f(), salseActivity.f1096a.a());
                            return;
                        }
                        SalseActivity.f1084c.setText("لا توجد مبيعات");
                        SalseActivity.a.setVisibility(8);
                        return;
                    }
                    return;
                }
                SalseActivity.f.setText(date2);
                SalseActivity.b = date2;
                if (!TextUtils.isEmpty(SalseActivity.f1083a) && !TextUtils.isEmpty(SalseActivity.b)) {
                    SalseActivity.f1085d.clear();
                    for (int i2 = 0; i2 < qb0.f4819e.size(); i2++) {
                        Date d12 = salseActivity.k(SalseActivity.f1083a);
                        Date d22 = salseActivity.k(SalseActivity.b);
                        if ((salseActivity.k(qb0.f4819e.get(i2).getStfrom()).compareTo(d12) >= 0 && salseActivity.k(qb0.f4819e.get(i2).getStfrom()).compareTo(d22) <= 0) || (salseActivity.k(qb0.f4819e.get(i2).getStfrom()).compareTo(d12) <= 0 && salseActivity.k(qb0.f4819e.get(i2).getStfrom()).compareTo(d22) >= 0)) {
                            ArrayList<Sessions> arrayList = SalseActivity.f1085d;
                            Sessions sessions = r14;
                            Sessions sessions2 = new Sessions(qb0.f4819e.get(i2).getName(), qb0.f4819e.get(i2).getStfrom(), qb0.f4819e.get(i2).getPrice(), qb0.f4819e.get(i2).getNas_port_id(), qb0.f4819e.get(i2).getId(), qb0.f4819e.get(i2).getDownload(), qb0.f4819e.get(i2).getUpload(), qb0.f4819e.get(i2).getUptime());
                            arrayList.add(sessions);
                            SalseActivity.c += Integer.valueOf(qb0.f4819e.get(i2).getPrice()).intValue();
                        }
                    }
                    if (SalseActivity.f1085d.size() > 0) {
                        SalseActivity.a.setVisibility(0);
                        SalseActivity.d.setVisibility(0);
                        SalseActivity.d.setText("المجموع :" + SalseActivity.c);
                        SalseActivity.f1084c.setText("العدد :" + SalseActivity.f1085d.size());
                        salseActivity.f1096a = new wp0(getActivity(), SalseActivity.f1085d);
                        SalseActivity.f1082a = new np0(getActivity(), salseActivity.f1096a);
                        SalseActivity.a.setAdapter(SalseActivity.f1082a);
                        SalseActivity.f1082a.x(salseActivity.f1096a.c(), salseActivity.f1096a.f(), salseActivity.f1096a.a());
                        return;
                    }
                    SalseActivity.f1084c.setText("لا توجد مبيعات");
                    SalseActivity.a.setVisibility(8);
                    SalseActivity.d.setVisibility(8);
                }
            } catch (Exception e2) {
                Toast.makeText(getActivity(), e2.toString(), 1).show();
            }
        }
    }

    public void m() {
        try {
            Date today = new Date();
            Locale locale = Locale.ENGLISH;
            SimpleDateFormat formattern = new SimpleDateFormat("dd/MM/yyyy", locale);
            Date ff = formattern.parse(formattern.format(today));
            Object obj = "";
            new SalseActivity();
            new SimpleDateFormat("d/M/yyyy", locale);
            SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy", locale);
            String date2 = "";
            try {
                date2 = formatter2.format(ff);
                Toast.makeText(this, date2, 1).show();
            } catch (Exception e2) {
            }
            c = 0;
            f.setText(date2);
            b = f.getText().toString();
            e.setText(date2);
            f1083a = e.getText().toString();
            qb0.f4820e = true;
            e.setText(date2);
            f1083a = date2;
            if (!TextUtils.isEmpty(date2) && !TextUtils.isEmpty(b)) {
                f1085d.clear();
                for (int i2 = 0; i2 < qb0.f4819e.size(); i2++) {
                    Date d1 = k(f1083a);
                    Date d2 = k(b);
                    if ((k(qb0.f4819e.get(i2).getStfrom()).compareTo(d1) >= 0 && k(qb0.f4819e.get(i2).getStfrom()).compareTo(d2) <= 0) || (k(qb0.f4819e.get(i2).getStfrom()).compareTo(d1) <= 0 && k(qb0.f4819e.get(i2).getStfrom()).compareTo(d2) >= 0)) {
                        ArrayList<Sessions> arrayList = f1085d;
                        Sessions sessions = r15;
                        Sessions sessions2 = new Sessions(qb0.f4819e.get(i2).getName(), qb0.f4819e.get(i2).getStfrom(), qb0.f4819e.get(i2).getPrice(), qb0.f4819e.get(i2).getNas_port_id(), qb0.f4819e.get(i2).getId(), qb0.f4819e.get(i2).getDownload(), qb0.f4819e.get(i2).getUpload(), qb0.f4819e.get(i2).getUptime());
                        arrayList.add(sessions);
                        c += Integer.valueOf(qb0.f4819e.get(i2).getPrice()).intValue();
                    }
                }
                if (f1085d.size() > 0) {
                    a.setVisibility(0);
                    d.setVisibility(0);
                    d.setText("المجموع :" + c);
                    f1084c.setText("العدد :" + f1085d.size());
                    this.f1096a = new wp0(this, f1085d);
                    np0 np0 = new np0(this, this.f1096a);
                    f1082a = np0;
                    a.setAdapter(np0);
                    f1082a.x(this.f1096a.c(), this.f1096a.f(), this.f1096a.a());
                    return;
                }
                f1084c.setText("لا توجد مبيعات");
                a.setVisibility(8);
                d.setVisibility(8);
            }
        } catch (Exception e3) {
            Toast.makeText(this, e3.toString(), 1).show();
        }
    }

    public void l() {
        try {
            c = 0;
            b = f.getText().toString();
            f1083a = e.getText().toString();
            qb0.f4820e = true;
            String charSequence = e.getText().toString();
            f1083a = charSequence;
            if (!TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(b)) {
                f1085d.clear();
                for (int i2 = 0; i2 < qb0.f4819e.size(); i2++) {
                    Date d1 = k(f1083a);
                    Date d2 = k(b);
                    if ((k(qb0.f4819e.get(i2).getStfrom()).compareTo(d1) >= 0 && k(qb0.f4819e.get(i2).getStfrom()).compareTo(d2) <= 0) || (k(qb0.f4819e.get(i2).getStfrom()).compareTo(d1) <= 0 && k(qb0.f4819e.get(i2).getStfrom()).compareTo(d2) >= 0)) {
                        if (this.f1091a.getSelectedItem().toString().equals("الكل")) {
                            f1085d.add(new Sessions(qb0.f4819e.get(i2).getName(), qb0.f4819e.get(i2).getStfrom(), qb0.f4819e.get(i2).getPrice(), qb0.f4819e.get(i2).getNas_port_id(), qb0.f4819e.get(i2).getId(), qb0.f4819e.get(i2).getDownload(), qb0.f4819e.get(i2).getUpload(), qb0.f4819e.get(i2).getUptime()));
                            c += Integer.valueOf(qb0.f4819e.get(i2).getPrice()).intValue();
                        } else if (qb0.f4819e.get(i2).getNas_port_id().toLowerCase().equalsIgnoreCase(this.f1091a.getSelectedItem().toString().toLowerCase())) {
                            ArrayList<Sessions> arrayList = f1085d;
                            Sessions sessions = r7;
                            Sessions sessions2 = new Sessions(qb0.f4819e.get(i2).getName(), qb0.f4819e.get(i2).getStfrom(), qb0.f4819e.get(i2).getPrice(), qb0.f4819e.get(i2).getNas_port_id(), qb0.f4819e.get(i2).getId(), qb0.f4819e.get(i2).getDownload(), qb0.f4819e.get(i2).getUpload(), qb0.f4819e.get(i2).getUptime());
                            arrayList.add(sessions);
                            c += Integer.valueOf(qb0.f4819e.get(i2).getPrice()).intValue();
                        }
                    }
                }
                if (f1085d.size() > 0) {
                    a.setVisibility(0);
                    d.setVisibility(0);
                    d.setText("المجموع :" + c);
                    f1084c.setText("العدد :" + f1085d.size());
                    this.f1096a = new wp0(this, f1085d);
                    np0 np0 = new np0(this, this.f1096a);
                    f1082a = np0;
                    a.setAdapter(np0);
                    f1082a.x(this.f1096a.c(), this.f1096a.f(), this.f1096a.a());
                    return;
                }
                f1084c.setText("لا توجد مبيعات");
                a.setVisibility(8);
                d.setVisibility(8);
            }
        } catch (Exception e2) {
            Toast.makeText(this, e2.toString(), 1).show();
        }
    }

    public Date k(String dtStart) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dateReturn = new Date();
        try {
            return format.parse(dtStart);
        } catch (ParseException e2) {
            e2.printStackTrace();
            return dateReturn;
        }
    }
}
