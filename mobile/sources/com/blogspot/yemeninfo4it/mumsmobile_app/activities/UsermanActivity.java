package com.blogspot.yemeninfo4it.mumsmobile_app.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UsermanActivity extends AppCompatActivity {
    public int a = 0;

    /* renamed from: a  reason: collision with other field name */
    ProgressDialog f1202a;

    /* renamed from: a  reason: collision with other field name */
    Context f1203a;

    /* renamed from: a  reason: collision with other field name */
    Button f1204a;

    /* renamed from: a  reason: collision with other field name */
    LinearLayout f1205a;

    /* renamed from: a  reason: collision with other field name */
    Spinner f1206a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public TableLayout f1207a;

    /* renamed from: a  reason: collision with other field name */
    TextView f1208a;

    /* renamed from: a  reason: collision with other field name */
    i50 f1209a;

    /* renamed from: a  reason: collision with other field name */
    public String f1210a;

    /* renamed from: a  reason: collision with other field name */
    ArrayList<UsermanagerCards> f1211a;

    /* renamed from: a  reason: collision with other field name */
    List<String> f1212a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    ue f1213a;
    public int b = 0;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public ProgressDialog f1214b;

    /* renamed from: b  reason: collision with other field name */
    Button f1215b;

    /* renamed from: b  reason: collision with other field name */
    public String f1216b;

    /* renamed from: b  reason: collision with other field name */
    List<String> f1217b = new ArrayList();
    public int c = 0;
    public int d = 20;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.userman_activity);
        this.f1203a = this;
        this.f1213a = new ue(this.f1203a);
        this.f1202a = new ProgressDialog(this);
        this.f1211a = new ArrayList<>();
        this.f1214b = new ProgressDialog(this);
        this.f1207a = (TableLayout) findViewById(R.id.tableInvoices);
        this.f1204a = (Button) findViewById(R.id.next_btn);
        this.f1215b = (Button) findViewById(R.id.pervos_btn);
        this.f1208a = (TextView) findViewById(R.id.count_users);
        this.f1205a = (LinearLayout) findViewById(R.id.search_btn);
        this.f1207a.setStretchAllColumns(true);
        this.f1206a = (Spinner) findViewById(R.id.page_item_count);
        try {
            this.f1208a.setText(String.valueOf(qb0.f4807b.size()));
            List<String> list4 = new ArrayList<>();
            list4.add("20");
            list4.add("50");
            list4.add("100");
            list4.add("500");
            ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<>(this, 17367048, list4);
            dataAdapter3.setDropDownViewResource(17367049);
            this.f1206a.setAdapter(dataAdapter3);
            this.f1212a.add("اختر الباقة");
            for (int i2 = 0; i2 < qb0.p.size(); i2++) {
                this.f1212a.add(qb0.p.get(i2).getUname());
            }
            if ((qb0.f4798a.getVersion() != null ? Integer.parseInt(qb0.f4798a.getVersion().substring(0, 1)) : 6) <= 6) {
                for (int i3 = 0; i3 < qb0.q.size(); i3++) {
                    this.f1217b.add(qb0.q.get(i3).getUname());
                }
            }
            this.f1209a = new i50();
            n();
            this.f1205a.setOnClickListener(new a());
            this.f1204a.setOnClickListener(new b());
            this.f1215b.setOnClickListener(new c());
            this.f1206a.setOnItemSelectedListener(new d());
        } catch (Exception e2) {
            Toast.makeText(this, e2.toString(), 1).show();
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View v) {
            UsermanActivity.this.startActivity(new Intent(UsermanActivity.this, SearchActivity.class));
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View v) {
            UsermanActivity usermanActivity = UsermanActivity.this;
            usermanActivity.b++;
            usermanActivity.n();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View v) {
            UsermanActivity usermanActivity = UsermanActivity.this;
            usermanActivity.b--;
            usermanActivity.n();
        }
    }

    class d implements AdapterView.OnItemSelectedListener {
        d() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            Object item = adapterView.getItemAtPosition(position);
            UsermanActivity usermanActivity = UsermanActivity.this;
            usermanActivity.b = 0;
            usermanActivity.d = Integer.parseInt(item.toString());
            UsermanActivity.this.n();
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(jv0.b(newBase));
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) menuInfo;
        int i2 = this.c;
        if (i2 >= 0) {
            menu.setHeaderTitle(this.f1211a.get(i2).getUname());
        } else {
            menu.setHeaderTitle("الرجاء تحديد السجل");
        }
        String[] menuItems = getResources().getStringArray(R.array.selectoption);
        for (int i3 = 0; i3 < menuItems.length; i3++) {
            menu.add(0, i3, i3, menuItems[i3]);
        }
    }

    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        String str = getResources().getStringArray(R.array.selectoption)[item.getItemId()];
        switch (item.getItemId()) {
            case 0:
                if (this.c >= 0) {
                    new m().execute(new String[0]);
                    return true;
                }
                Snackbar.k0(this.f1207a, "الرجاء تحديد السجل", 0).V();
                return true;
            case 1:
                if (this.c >= 0) {
                    m();
                    return true;
                }
                Snackbar.k0(this.f1207a, "الرجاء تحديد السجل", 0).V();
                return true;
            case 3:
                if (this.c >= 0) {
                    new j().execute(new String[0]);
                    return true;
                }
                Snackbar.k0(this.f1207a, "الرجاء تحديد السجل", 0).V();
                return true;
            case 4:
                if (this.c >= 0) {
                    new k().execute(new String[0]);
                    return true;
                }
                Snackbar.k0(this.f1207a, "الرجاء تحديد السجل", 0).V();
                return true;
            default:
                return true;
        }
    }

    public void n() {
        this.f1202a.setCancelable(false);
        this.f1202a.setMessage("جلب البيانات...");
        this.f1202a.show();
        new l().execute(new Integer[]{0});
    }

    public void l(ArrayList<UsermanagerCards> usermanagerCards11) {
        int smallTextSize;
        int rows;
        TextView tv;
        TextView textSpacer;
        TextView tv2;
        int i2;
        TextView tv6;
        TextView tv3;
        long a2;
        long a3;
        int mediumTextSize;
        int leftRowMargin;
        int leftRowMargin2 = 0;
        long a4 = 0;
        long a22 = 0;
        int textSize = (int) getResources().getDimension(R.dimen.font_size_medium);
        int smallTextSize2 = (int) getResources().getDimension(R.dimen.font_size_small);
        int mediumTextSize2 = (int) getResources().getDimension(R.dimen.font_size_large);
        this.f1211a = usermanagerCards11;
        int rows2 = qb0.f4807b.size();
        TextView textSpacer2 = null;
        this.f1207a.removeAllViews();
        int i3 = -1;
        while (true) {
            long a5 = a4;
            if (i3 < this.f1211a.size()) {
                if (i3 <= -1) {
                    TextView textSpacer3 = new TextView(this);
                    textSpacer3.setText("");
                    textSpacer2 = textSpacer3;
                }
                TextView tv4 = new TextView(this);
                long a23 = a22;
                tv4.setLayoutParams(new TableRow.LayoutParams(-2, -2));
                tv4.setGravity(17);
                tv4.setPadding(5, 15, 5, 15);
                if (i3 == -1) {
                    tv4.setText("Id.#");
                    tv4.setBackgroundColor(Color.parseColor("#f0f0f0"));
                    tv4.setTextSize(0, (float) smallTextSize2);
                } else {
                    tv4.setBackgroundColor(Color.parseColor("#f8f8f8"));
                    tv4.setPadding(5, 15, 5, 15);
                    tv4.setText(this.f1211a.get(i3).getId());
                    tv4.setTextSize(0, (float) textSize);
                }
                TextView tv22 = new TextView(this);
                tv22.setGravity(17);
                tv22.setPadding(5, 15, 5, 15);
                if (i3 == -1) {
                    smallTextSize = smallTextSize2;
                    tv22.setLayoutParams(new TableRow.LayoutParams(-1, -2));
                    tv22.setTextSize(0, (float) mediumTextSize2);
                } else {
                    smallTextSize = smallTextSize2;
                    tv22.setLayoutParams(new TableRow.LayoutParams(-2, -1));
                    tv22.setTextSize(0, (float) textSize);
                }
                tv22.setGravity(17);
                if (i3 == -1) {
                    tv22.setText("اسم المستخدم");
                    tv22.setPadding(5, 15, 5, 15);
                    tv22.setBackgroundColor(Color.parseColor("#f7f7f7"));
                } else {
                    tv22.setTextColor(Color.parseColor("#000000"));
                    tv22.setText(this.f1211a.get(i3).getUname());
                    tv22.setPadding(5, 15, 5, 15);
                }
                TextView tv32 = new TextView(this);
                if (i3 == -1) {
                    rows = rows2;
                    tv32.setLayoutParams(new TableRow.LayoutParams(-1, -1));
                    tv32.setTextSize(0, (float) mediumTextSize2);
                    tv32.setPadding(5, 15, 5, 15);
                } else {
                    rows = rows2;
                    tv32.setLayoutParams(new TableRow.LayoutParams(-1, -1));
                    tv32.setPadding(5, 15, 5, 15);
                    tv32.setTextSize(0, (float) textSize);
                }
                tv32.setGravity(17);
                if (i3 == -1) {
                    tv32.setText("كمية الرفع");
                    tv32.setBackgroundColor(Color.parseColor("#f0f0f0"));
                    textSpacer = textSpacer2;
                    tv32.setPadding(5, 15, 5, 15);
                    tv = tv4;
                    tv2 = tv22;
                } else {
                    textSpacer = textSpacer2;
                    tv32.setBackgroundColor(Color.parseColor("#f8f8f8"));
                    tv32.setTextColor(Color.parseColor("#000000"));
                    tv32.setTextSize(0, (float) mediumTextSize2);
                    tv32.setPadding(5, 15, 5, 15);
                    if (this.f1211a.get(i3).getUpload_used() != null) {
                        tv2 = tv22;
                        StringBuilder sb = new StringBuilder();
                        tv = tv4;
                        sb.append(String.valueOf((Long.parseLong(this.f1211a.get(i3).getUpload_used().toString()) / 1024) / 1024));
                        sb.append("ميجا");
                        tv32.setText(sb.toString());
                    } else {
                        tv = tv4;
                        tv2 = tv22;
                        tv32.setText(this.f1211a.get(i3).getUpload_used());
                    }
                }
                TextView tv62 = new TextView(this);
                if (i3 == -1) {
                    tv62.setLayoutParams(new TableRow.LayoutParams(-1, -2));
                    tv62.setTextSize(0, (float) mediumTextSize2);
                    tv62.setPadding(5, 15, 5, 15);
                    i2 = -1;
                } else {
                    i2 = -1;
                    tv62.setLayoutParams(new TableRow.LayoutParams(-2, -1));
                    tv62.setTextSize(0, (float) textSize);
                }
                tv62.setGravity(17);
                if (i3 == i2) {
                    tv62.setText("الباقـــة");
                    tv62.setBackgroundColor(Color.parseColor("#f7f7f7"));
                    tv62.setPadding(5, 15, 5, 15);
                } else {
                    tv62.setPadding(5, 15, 5, 15);
                    tv62.setTextColor(Color.parseColor("#000000"));
                    tv62.setText(this.f1211a.get(i3).getProfilename());
                }
                TextView tv5 = new TextView(this);
                tv5.setLayoutParams(new TableRow.LayoutParams(-2, -2));
                tv5.setGravity(17);
                if (i3 == -1) {
                    tv5.setText("كمية التحميل");
                    tv5.setBackgroundColor(Color.parseColor("#f0f0f0"));
                    tv5.setTextSize(0, (float) mediumTextSize2);
                    tv5.setPadding(5, 15, 5, 15);
                    tv3 = tv32;
                    tv6 = tv62;
                    a2 = a5;
                } else {
                    if (this.f1211a.get(i3).getDownload_used() != null) {
                        long a6 = (Long.parseLong(this.f1211a.get(i3).getDownload_used().toString()) / 1024) / 1024;
                        tv3 = tv32;
                        StringBuilder sb2 = new StringBuilder();
                        tv6 = tv62;
                        sb2.append(String.valueOf(a6));
                        sb2.append("ميجا");
                        tv5.setText(sb2.toString());
                        a2 = a6;
                    } else {
                        tv3 = tv32;
                        tv6 = tv62;
                        tv5.setText(this.f1211a.get(i3).getUpload_used());
                        a2 = a5;
                    }
                    tv5.setTextColor(Color.parseColor("#000000"));
                    tv5.setBackgroundColor(Color.parseColor("#f0f0f0"));
                    tv5.setPadding(5, 15, 5, 15);
                    tv5.setTextSize(0, (float) textSize);
                }
                TextView tv42 = new TextView(this);
                tv42.setGravity(17);
                if (i3 == -1) {
                    tv42.setText("الـوقت المستخــدم");
                    tv42.setBackgroundColor(Color.parseColor("#f7f7f7"));
                    tv42.setTextSize(0, (float) mediumTextSize2);
                    tv42.setPadding(5, 15, 5, 15);
                } else {
                    tv42.setBackgroundColor(Color.parseColor("#ffffff"));
                    tv42.setTextColor(Color.parseColor("#000000"));
                    tv42.setPadding(5, 15, 5, 15);
                    tv42.setText(this.f1211a.get(i3).getUptime_used());
                    tv42.setTextSize(0, (float) textSize);
                }
                TableRow tr = new TableRow(this);
                tr.setId(i3 + 1);
                TableLayout.LayoutParams trParams = new TableLayout.LayoutParams(-2, -2);
                trParams.setMargins(leftRowMargin2, 0, 0, 0);
                tr.setPadding(0, 0, 0, 0);
                tr.setLayoutParams(trParams);
                tr.setOnClickListener(new e(tr));
                tr.addView(tv);
                tr.addView(tv2);
                int textSize2 = textSize;
                tr.addView(tv6);
                tr.addView(tv42);
                tr.addView(tv5);
                TextView tv33 = tv3;
                tr.addView(tv33);
                TextView textView = tv33;
                this.f1207a.addView(tr, trParams);
                registerForContextMenu(tr);
                if (i3 > -1) {
                    TableRow trSep = new TableRow(this);
                    TableRow tableRow = tr;
                    mediumTextSize = mediumTextSize2;
                    a3 = a2;
                    TableLayout.LayoutParams trParamsSep = new TableLayout.LayoutParams(-1, -2);
                    trParamsSep.setMargins(leftRowMargin2, 0, 0, 0);
                    trSep.setLayoutParams(trParamsSep);
                    TextView tvSep = new TextView(this);
                    leftRowMargin = leftRowMargin2;
                    TableRow.LayoutParams tvSepLay = new TableRow.LayoutParams(-1, -2);
                    tvSepLay.span = 6;
                    tvSep.setLayoutParams(tvSepLay);
                    tvSep.setBackgroundColor(Color.parseColor("#d9d9d9"));
                    tvSep.setHeight(1);
                    trSep.addView(tvSep);
                    registerForContextMenu(trSep);
                    this.f1207a.addView(trSep, trParamsSep);
                } else {
                    leftRowMargin = leftRowMargin2;
                    TableRow tableRow2 = tr;
                    mediumTextSize = mediumTextSize2;
                    a3 = a2;
                }
                i3++;
                ArrayList<UsermanagerCards> arrayList = usermanagerCards11;
                leftRowMargin2 = leftRowMargin;
                a22 = a23;
                textSize = textSize2;
                mediumTextSize2 = mediumTextSize;
                a4 = a3;
                smallTextSize2 = smallTextSize;
                rows2 = rows;
                textSpacer2 = textSpacer;
            } else {
                return;
            }
        }
    }

    class e implements View.OnClickListener {
        final /* synthetic */ TableRow a;

        e(TableRow tableRow) {
            this.a = tableRow;
        }

        public void onClick(View view) {
            TableRow tableRow = (TableRow) view;
            UsermanActivity.this.c = this.a.getId() - 1;
        }
    }

    class l extends AsyncTask<Integer, Integer, String> {
        l() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Integer... params) {
            try {
                Thread.sleep(50);
                return "Task Completed.";
            } catch (InterruptedException e) {
                e.printStackTrace();
                return "Task Completed.";
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            UsermanActivity usermanActivity = UsermanActivity.this;
            usermanActivity.l(usermanActivity.f1209a.a(usermanActivity.b, usermanActivity.d));
            UsermanActivity.this.f1202a.dismiss();
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void onProgressUpdate(Integer... values) {
        }
    }

    class i extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f1220a = null;

        i() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            UsermanActivity.this.f1214b.setTitle("يرجى الانتظار");
            UsermanActivity.this.f1214b.setMessage("جاري تنفيذ العملية");
            UsermanActivity.this.f1214b.setCancelable(false);
            UsermanActivity.this.f1214b.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                j3 con = j3.c(qb0.f4797a.getIp(), Integer.valueOf(Integer.parseInt(qb0.f4797a.getPort())));
                con.C(qb0.f4797a.getUname(), qb0.f4797a.getPass(), true);
                con.w();
                StringBuilder sb = new StringBuilder();
                sb.append("/tool/user-manager/user/create-and-activate-profile numbers=");
                UsermanActivity usermanActivity = UsermanActivity.this;
                sb.append(usermanActivity.f1211a.get(usermanActivity.c).getUname().toString());
                sb.append(" profile=");
                sb.append(UsermanActivity.this.f1210a);
                sb.append(" customer=");
                sb.append(UsermanActivity.this.f1216b);
                sb.append("");
                con.q(sb.toString());
                con.close();
                return null;
            } catch (Exception e) {
                try {
                    Log.d("Tag", e.toString() + "error");
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            UsermanActivity.this.f1214b.dismiss();
        }
    }

    class m extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f1223a = null;

        m() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            UsermanActivity.this.f1214b.setTitle("يرجى الانتظار");
            UsermanActivity.this.f1214b.setMessage("جاري تنفيذ العملية");
            UsermanActivity.this.f1214b.setCancelable(false);
            UsermanActivity.this.f1214b.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                j3 con = j3.c(qb0.f4797a.getIp(), Integer.valueOf(Integer.parseInt(qb0.f4797a.getPort())));
                con.C(qb0.f4797a.getUname(), qb0.f4797a.getPass(), true);
                if (con.w()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("/tool/user-manager/user/remove .id=");
                    UsermanActivity usermanActivity = UsermanActivity.this;
                    sb.append(usermanActivity.f1211a.get(usermanActivity.c).getId().toString());
                    sb.append("");
                    con.q(sb.toString());
                }
                con.close();
                return null;
            } catch (Exception e) {
                try {
                    Log.d("Tag", e.toString() + "error");
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            UsermanActivity.this.f1214b.dismiss();
        }
    }

    class j extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f1221a = null;

        j() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            UsermanActivity.this.f1214b.setTitle("يرجى الانتظار");
            UsermanActivity.this.f1214b.setMessage("جاري تنفيذ العملية");
            UsermanActivity.this.f1214b.setCancelable(false);
            UsermanActivity.this.f1214b.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                j3 con = j3.c(qb0.f4797a.getIp(), Integer.valueOf(Integer.parseInt(qb0.f4797a.getPort())));
                con.C(qb0.f4797a.getUname(), qb0.f4797a.getPass(), true);
                if (con.w()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("/tool/user-manager/user/disable numbers=");
                    UsermanActivity usermanActivity = UsermanActivity.this;
                    sb.append(usermanActivity.f1211a.get(usermanActivity.c).getUname().toString());
                    sb.append("");
                    con.q(sb.toString());
                }
                con.close();
                return null;
            } catch (Exception e) {
                try {
                    Log.d("Tag", e.toString() + "error");
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            UsermanActivity.this.f1214b.dismiss();
        }
    }

    class k extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f1222a = null;

        k() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            UsermanActivity.this.f1214b.setTitle("يرجى الانتظار");
            UsermanActivity.this.f1214b.setMessage("جاري تنفيذ العملية");
            UsermanActivity.this.f1214b.setCancelable(false);
            UsermanActivity.this.f1214b.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                j3 con = j3.c(qb0.f4797a.getIp(), Integer.valueOf(Integer.parseInt(qb0.f4797a.getPort())));
                con.C(qb0.f4797a.getUname(), qb0.f4797a.getPass(), true);
                if (con.w()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("/tool/user-manager/user/enable numbers=");
                    UsermanActivity usermanActivity = UsermanActivity.this;
                    sb.append(usermanActivity.f1211a.get(usermanActivity.c).getUname().toString());
                    sb.append("");
                    con.q(sb.toString());
                }
                con.close();
                return null;
            } catch (Exception e) {
                try {
                    Log.d("Tag", e.toString() + "error");
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            UsermanActivity.this.f1214b.dismiss();
        }
    }

    public void m() {
        try {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
            View myView = getLayoutInflater().inflate(R.layout.feedback_popup, (ViewGroup) null);
            dialogBuilder.setView(myView);
            Spinner profilelist = (Spinner) myView.findViewById(R.id.profilelist);
            Spinner customerlist = (Spinner) myView.findViewById(R.id.customerlist);
            TextView textView = (TextView) myView.findViewById(R.id.addtonametxt);
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, 17367048, this.f1212a);
            dataAdapter.setDropDownViewResource(17367049);
            profilelist.setAdapter(dataAdapter);
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367048, this.f1217b);
            arrayAdapter.setDropDownViewResource(17367049);
            customerlist.setAdapter(arrayAdapter);
            AlertDialog b2 = dialogBuilder.create();
            this.f1216b = customerlist.getSelectedItem().toString();
            qb0.f4810c = customerlist.getSelectedItem().toString();
            b2.show();
            profilelist.setOnItemSelectedListener(new f());
            customerlist.setOnItemSelectedListener(new g());
            ((Button) myView.findViewById(R.id.addprofiletouser)).setOnClickListener(new h(profilelist));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    class f implements AdapterView.OnItemSelectedListener {
        f() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            Object item = adapterView.getItemAtPosition(position);
            UsermanActivity.this.f1210a = item.toString();
            qb0.f4806b = item.toString();
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class g implements AdapterView.OnItemSelectedListener {
        g() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            Object item = adapterView.getItemAtPosition(position);
            UsermanActivity.this.f1216b = item.toString();
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class h implements View.OnClickListener {
        final /* synthetic */ Spinner a;

        h(Spinner spinner) {
            this.a = spinner;
        }

        public void onClick(View v) {
            if (this.a.getSelectedItem().toString().equals("اختر الباقة") || TextUtils.isEmpty(UsermanActivity.this.f1216b)) {
                Snackbar.k0(UsermanActivity.this.f1207a, "الرجاء اختيار اسم الباقة", 0).V();
            } else {
                new i().execute(new String[0]);
            }
        }
    }
}
