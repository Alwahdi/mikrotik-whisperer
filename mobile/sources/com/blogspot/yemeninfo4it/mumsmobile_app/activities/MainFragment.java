package com.blogspot.yemeninfo4it.mumsmobile_app.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.evrencoskun.tableview.TableView;
import com.google.android.material.snackbar.Snackbar;
import defpackage.h50;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainFragment extends AppCompatActivity {
    /* access modifiers changed from: private */
    public ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    Context f777a;

    /* renamed from: a  reason: collision with other field name */
    private TextWatcher f778a = new h();

    /* renamed from: a  reason: collision with other field name */
    private View.OnClickListener f779a = new j();

    /* renamed from: a  reason: collision with other field name */
    private AdapterView.OnItemSelectedListener f780a = new g();

    /* renamed from: a  reason: collision with other field name */
    private EditText f781a;

    /* renamed from: a  reason: collision with other field name */
    public ImageButton f782a;

    /* renamed from: a  reason: collision with other field name */
    LinearLayout f783a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public Spinner f784a;

    /* renamed from: a  reason: collision with other field name */
    public TextView f785a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public TableView f786a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public d0 f787a;

    /* renamed from: a  reason: collision with other field name */
    private h50.d f788a = new f();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public h50 f789a;

    /* renamed from: a  reason: collision with other field name */
    public String f790a;

    /* renamed from: a  reason: collision with other field name */
    List<String> f791a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public rp0 f792a;

    /* renamed from: a  reason: collision with other field name */
    private tk f793a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f794a = true;
    private TextWatcher b = new a();

    /* renamed from: b  reason: collision with other field name */
    private AdapterView.OnItemSelectedListener f795b = new i();

    /* renamed from: b  reason: collision with other field name */
    public EditText f796b;

    /* renamed from: b  reason: collision with other field name */
    public ImageButton f797b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public Spinner f798b;

    /* renamed from: b  reason: collision with other field name */
    public String f799b;

    /* renamed from: b  reason: collision with other field name */
    List<String> f800b = new ArrayList();
    private Spinner c;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.tableview_main);
        this.f777a = this;
        this.f781a = (EditText) findViewById(R.id.query_string);
        this.a = new ProgressDialog(this);
        Spinner spinner = (Spinner) findViewById(R.id.mood_spinner);
        this.f784a = spinner;
        spinner.setOnItemSelectedListener(this.f780a);
        Spinner spinner2 = (Spinner) findViewById(R.id.gender_spinner);
        this.f798b = spinner2;
        spinner2.setOnItemSelectedListener(this.f780a);
        this.c = (Spinner) findViewById(R.id.items_per_page_spinner);
        List<String> list2 = new ArrayList<>();
        list2.add("10");
        list2.add("20");
        list2.add("25");
        list2.add("50");
        list2.add("All");
        this.f791a.add("اختر الباقة");
        for (int i2 = 0; i2 < qb0.p.size(); i2++) {
            this.f791a.add(qb0.p.get(i2).getUname());
        }
        for (int i3 = 0; i3 < qb0.q.size(); i3++) {
            this.f800b.add(qb0.q.get(i3).getUname());
        }
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<>(this, 17367048, list2);
        dataAdapter2.setDropDownViewResource(17367049);
        this.c.setAdapter(dataAdapter2);
        this.f783a = (LinearLayout) findViewById(R.id.table_test_container);
        this.f782a = (ImageButton) findViewById(R.id.previous_button);
        this.f797b = (ImageButton) findViewById(R.id.next_button);
        this.f796b = (EditText) findViewById(R.id.page_number_text);
        this.f785a = (TextView) findViewById(R.id.table_details);
        this.f786a = (TableView) findViewById(R.id.tableview);
        w();
        if (this.f794a) {
            this.f783a.setVisibility(0);
            this.c.setOnItemSelectedListener(this.f795b);
            this.f782a.setOnClickListener(this.f779a);
            this.f797b.setOnClickListener(this.f779a);
            this.f796b.addTextChangedListener(this.b);
        } else {
            this.f783a.setVisibility(8);
        }
        if (this.f794a) {
            this.f793a = new tk(this.f786a);
            h50 h50 = new h50(this.f786a);
            this.f789a = h50;
            h50.o(this.f788a);
        }
        this.f781a.addTextChangedListener(new b());
    }

    class b implements TextWatcher {
        b() {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                if (s.length() > 0) {
                    MainFragment.this.s(String.valueOf(s));
                    return;
                }
                MainFragment mainFragment = MainFragment.this;
                rp0 unused = mainFragment.f792a = new rp0(mainFragment);
                MainFragment mainFragment2 = MainFragment.this;
                MainFragment mainFragment3 = MainFragment.this;
                d0 unused2 = mainFragment2.f787a = new op0(mainFragment3, mainFragment3.f792a);
                MainFragment.this.f786a.setAdapter(MainFragment.this.f787a);
                MainFragment.this.f786a.setTableViewListener(new qp0(MainFragment.this.f786a));
                MainFragment mainFragment4 = MainFragment.this;
                mainFragment4.registerForContextMenu(mainFragment4.f786a);
                MainFragment.this.f787a.x(MainFragment.this.f792a.c(), MainFragment.this.f792a.f(), MainFragment.this.f792a.a());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void afterTextChanged(Editable s) {
        }
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) menuInfo;
        if (qb0.a >= 0) {
            menu.setHeaderTitle(qb0.f4807b.get(qb0.a).getUname());
        } else {
            menu.setHeaderTitle("الرجاء تحديد السجل");
        }
        String[] menuItems = getResources().getStringArray(R.array.selectoption);
        for (int i2 = 0; i2 < menuItems.length; i2++) {
            menu.add(0, i2, i2, menuItems[i2]);
        }
    }

    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        String str = getResources().getStringArray(R.array.selectoption)[item.getItemId()];
        switch (item.getItemId()) {
            case 0:
                if (qb0.a >= 0) {
                    new n().execute(new String[0]);
                    return true;
                }
                Snackbar.k0(this.f786a, "الرجاء تحديد السجل", 0).V();
                return true;
            case 1:
                if (qb0.a >= 0) {
                    z();
                    return true;
                }
                Snackbar.k0(this.f786a, "الرجاء تحديد السجل", 0).V();
                return true;
            case 3:
                if (qb0.a >= 0) {
                    new l().execute(new String[0]);
                    return true;
                }
                Snackbar.k0(this.f786a, "الرجاء تحديد السجل", 0).V();
                return true;
            case 4:
                if (qb0.a >= 0) {
                    new m().execute(new String[0]);
                    return true;
                }
                Snackbar.k0(this.f786a, "الرجاء تحديد السجل", 0).V();
                return true;
            default:
                return true;
        }
    }

    private void w() {
        this.f792a = new rp0(this);
        op0 op0 = new op0(this, this.f792a);
        this.f787a = op0;
        this.f786a.setAdapter(op0);
        TableView tableView = this.f786a;
        tableView.setTableViewListener(new qp0(tableView));
        registerForContextMenu(this.f786a);
        this.f787a.x(this.f792a.c(), this.f792a.f(), this.f792a.a());
    }

    public void z() {
        try {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
            View myView = getLayoutInflater().inflate(R.layout.feedback_popup, (ViewGroup) null);
            dialogBuilder.setView(myView);
            Spinner profilelist = (Spinner) myView.findViewById(R.id.profilelist);
            Spinner customerlist = (Spinner) myView.findViewById(R.id.customerlist);
            TextView textView = (TextView) myView.findViewById(R.id.addtonametxt);
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, 17367048, this.f791a);
            dataAdapter.setDropDownViewResource(17367049);
            profilelist.setAdapter(dataAdapter);
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367048, this.f800b);
            arrayAdapter.setDropDownViewResource(17367049);
            customerlist.setAdapter(arrayAdapter);
            AlertDialog b2 = dialogBuilder.create();
            this.f799b = customerlist.getSelectedItem().toString();
            qb0.f4810c = customerlist.getSelectedItem().toString();
            b2.show();
            profilelist.setOnItemSelectedListener(new c());
            customerlist.setOnItemSelectedListener(new d());
            ((Button) myView.findViewById(R.id.addprofiletouser)).setOnClickListener(new e(profilelist));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    class c implements AdapterView.OnItemSelectedListener {
        c() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            Object item = adapterView.getItemAtPosition(position);
            MainFragment.this.f790a = item.toString();
            qb0.f4806b = item.toString();
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class d implements AdapterView.OnItemSelectedListener {
        d() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            Object item = adapterView.getItemAtPosition(position);
            MainFragment.this.f799b = item.toString();
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class e implements View.OnClickListener {
        final /* synthetic */ Spinner a;

        e(Spinner spinner) {
            this.a = spinner;
        }

        public void onClick(View v) {
            if (this.a.getSelectedItem().toString().equals("اختر الباقة") || TextUtils.isEmpty(MainFragment.this.f799b)) {
                Snackbar.k0(MainFragment.this.f786a, "الرجاء اختيار اسم الباقة", 0).V();
            } else {
                new k().execute(new String[0]);
            }
        }
    }

    class k extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f802a = null;

        k() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            MainFragment.this.a.setTitle("يرجى الانتظار");
            MainFragment.this.a.setMessage("جاري تنفيذ العملية");
            MainFragment.this.a.setCancelable(false);
            MainFragment.this.a.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                j3 con = j3.c(qb0.f4797a.getIp(), Integer.valueOf(Integer.parseInt(qb0.f4797a.getPort())));
                con.C(qb0.f4797a.getUname(), qb0.f4797a.getPass(), true);
                con.w();
                con.q("/tool/user-manager/user/create-and-activate-profile numbers=" + qb0.f4807b.get(qb0.a).getUname().toString() + " profile=" + MainFragment.this.f790a + " customer=" + MainFragment.this.f799b + "");
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
            MainFragment.this.a.dismiss();
        }
    }

    class n extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f805a = null;

        n() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            MainFragment.this.a.setTitle("يرجى الانتظار");
            MainFragment.this.a.setMessage("جاري تنفيذ العملية");
            MainFragment.this.a.setCancelable(false);
            MainFragment.this.a.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                j3 con = j3.c(qb0.f4797a.getIp(), Integer.valueOf(Integer.parseInt(qb0.f4797a.getPort())));
                con.C(qb0.f4797a.getUname(), qb0.f4797a.getPass(), true);
                if (con.w()) {
                    con.q("/tool/user-manager/user/remove .id=" + qb0.f4807b.get(qb0.a).getId().toString() + "");
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
            MainFragment.this.a.dismiss();
        }
    }

    class l extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f803a = null;

        l() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            MainFragment.this.a.setTitle("يرجى الانتظار");
            MainFragment.this.a.setMessage("جاري تنفيذ العملية");
            MainFragment.this.a.setCancelable(false);
            MainFragment.this.a.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                j3 con = j3.c(qb0.f4797a.getIp(), Integer.valueOf(Integer.parseInt(qb0.f4797a.getPort())));
                con.C(qb0.f4797a.getUname(), qb0.f4797a.getPass(), true);
                if (con.w()) {
                    con.q("/tool/user-manager/user/disable numbers=" + qb0.f4807b.get(qb0.a).getUname().toString() + "");
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
            MainFragment.this.a.dismiss();
        }
    }

    class m extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f804a = null;

        m() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            MainFragment.this.a.setTitle("يرجى الانتظار");
            MainFragment.this.a.setMessage("جاري تنفيذ العملية");
            MainFragment.this.a.setCancelable(false);
            MainFragment.this.a.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                j3 con = j3.c(qb0.f4797a.getIp(), Integer.valueOf(Integer.parseInt(qb0.f4797a.getPort())));
                con.C(qb0.f4797a.getUname(), qb0.f4797a.getPass(), true);
                if (con.w()) {
                    con.q("/tool/user-manager/user/enable numbers=" + qb0.f4807b.get(qb0.a).getUname().toString() + "");
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
            MainFragment.this.a.dismiss();
        }
    }

    public void s(String filter) {
        try {
            this.f793a.e(0, filter);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void u(String filter) {
        this.f793a.e(3, filter);
    }

    public void t(String filter) {
        this.f793a.e(4, filter);
    }

    public void x() {
        this.f789a.i();
    }

    public void y() {
        this.f789a.l();
    }

    public void v(int page) {
        this.f789a.g(page);
    }

    public void A(int itemsPerPage) {
        if (this.f786a.getAdapter().equals(true)) {
            this.f789a.n(itemsPerPage);
        }
    }

    class f implements h50.d {
        f() {
        }

        public void a(int numItems, int itemsStart, int itemsEnd) {
            int currentPage = MainFragment.this.f789a.e();
            int pageCount = MainFragment.this.f789a.f();
            MainFragment.this.f782a.setVisibility(0);
            MainFragment.this.f797b.setVisibility(0);
            if (currentPage == 1 && pageCount == 1) {
                MainFragment.this.f782a.setVisibility(4);
                MainFragment.this.f797b.setVisibility(4);
            }
            if (currentPage == 1) {
                MainFragment.this.f782a.setVisibility(4);
            }
            if (currentPage == pageCount) {
                MainFragment.this.f797b.setVisibility(4);
            }
            MainFragment mainFragment = MainFragment.this;
            mainFragment.f785a.setText(mainFragment.getString(R.string.table_pagination_details, new Object[]{String.valueOf(currentPage), String.valueOf(itemsStart), String.valueOf(itemsEnd)}));
        }
    }

    class g implements AdapterView.OnItemSelectedListener {
        g() {
        }

        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (position > 0) {
                String filter = Integer.toString(position);
                if (parent == MainFragment.this.f784a) {
                    MainFragment.this.u(filter);
                } else if (parent == MainFragment.this.f798b) {
                    MainFragment.this.t(filter);
                }
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class h implements TextWatcher {
        h() {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            MainFragment.this.s(String.valueOf(s));
        }

        public void afterTextChanged(Editable s) {
        }
    }

    class i implements AdapterView.OnItemSelectedListener {
        i() {
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onItemSelected(android.widget.AdapterView<?> r4, android.view.View r5, int r6, long r7) {
            /*
                r3 = this;
                java.lang.Object r0 = r4.getItemAtPosition(r6)
                java.lang.String r0 = r0.toString()
                int r1 = r0.hashCode()
                switch(r1) {
                    case 65921: goto L_0x0010;
                    default: goto L_0x000f;
                }
            L_0x000f:
                goto L_0x001a
            L_0x0010:
                java.lang.String r1 = "All"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x000f
                r0 = 0
                goto L_0x001b
            L_0x001a:
                r0 = -1
            L_0x001b:
                switch(r0) {
                    case 0: goto L_0x002f;
                    default: goto L_0x001e;
                }
            L_0x001e:
                java.lang.Object r0 = r4.getItemAtPosition(r6)
                java.lang.String r0 = r0.toString()
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                int r0 = r0.intValue()
                goto L_0x0031
            L_0x002f:
                r0 = 0
            L_0x0031:
                com.blogspot.yemeninfo4it.mumsmobile_app.activities.MainFragment r1 = com.blogspot.yemeninfo4it.mumsmobile_app.activities.MainFragment.this
                com.evrencoskun.tableview.TableView r1 = r1.f786a
                d0 r1 = r1.getAdapter()
                r2 = 1
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x004b
                com.blogspot.yemeninfo4it.mumsmobile_app.activities.MainFragment r1 = com.blogspot.yemeninfo4it.mumsmobile_app.activities.MainFragment.this
                r1.A(r0)
            L_0x004b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blogspot.yemeninfo4it.mumsmobile_app.activities.MainFragment.i.onItemSelected(android.widget.AdapterView, android.view.View, int, long):void");
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class j implements View.OnClickListener {
        j() {
        }

        public void onClick(View v) {
            MainFragment mainFragment = MainFragment.this;
            if (v == mainFragment.f782a) {
                mainFragment.y();
            } else if (v == mainFragment.f797b) {
                mainFragment.x();
            }
        }
    }

    class a implements TextWatcher {
        a() {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            int page;
            if (TextUtils.isEmpty(s)) {
                page = 1;
            } else {
                page = Integer.valueOf(String.valueOf(s)).intValue();
            }
            MainFragment.this.v(page);
        }

        public void afterTextChanged(Editable s) {
        }
    }
}
