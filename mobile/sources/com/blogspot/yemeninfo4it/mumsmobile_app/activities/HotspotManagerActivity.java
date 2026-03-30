package com.blogspot.yemeninfo4it.mumsmobile_app.activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HotspotManagerActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    public int a = 0;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f744a;

    /* renamed from: a  reason: collision with other field name */
    CheckBox f745a;

    /* renamed from: a  reason: collision with other field name */
    ImageView f746a;

    /* renamed from: a  reason: collision with other field name */
    ListView f747a;

    /* renamed from: a  reason: collision with other field name */
    RadioButton f748a;

    /* renamed from: a  reason: collision with other field name */
    SearchView f749a = null;

    /* renamed from: a  reason: collision with other field name */
    TextView f750a;

    /* renamed from: a  reason: collision with other field name */
    j f751a;

    /* renamed from: a  reason: collision with other field name */
    m f752a;

    /* renamed from: a  reason: collision with other field name */
    j3 f753a;

    /* renamed from: a  reason: collision with other field name */
    final String f754a = "mLog";

    /* renamed from: a  reason: collision with other field name */
    ArrayList<HotspotCard> f755a = null;

    /* renamed from: a  reason: collision with other field name */
    List<String> f756a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    ue f757a;

    /* renamed from: a  reason: collision with other field name */
    uq f758a = null;

    /* renamed from: a  reason: collision with other field name */
    zd f759a;

    /* renamed from: a  reason: collision with other field name */
    boolean f760a = false;
    public int b = 0;

    /* renamed from: b  reason: collision with other field name */
    RadioButton f761b;

    /* renamed from: b  reason: collision with other field name */
    TextView f762b;

    /* renamed from: b  reason: collision with other field name */
    public String f763b = "";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public ArrayList<HotspotCard> f764b = new ArrayList<>();

    /* renamed from: b  reason: collision with other field name */
    List<String> f765b = new ArrayList();
    public int c = 0;

    /* renamed from: c  reason: collision with other field name */
    RadioButton f766c;

    /* renamed from: c  reason: collision with other field name */
    TextView f767c;

    /* renamed from: c  reason: collision with other field name */
    public String f768c = "";
    int d = 0;

    /* renamed from: d  reason: collision with other field name */
    TextView f769d;
    TextView e;
    TextView f;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_mang_hotspot);
        this.f753a = qb0.d();
        ArrayList<HotspotCard> arrayList = new ArrayList<>();
        this.f755a = arrayList;
        this.f755a = o(arrayList);
        this.f757a = new ue(this);
        this.f749a = (SearchView) findViewById(R.id.mySearchView);
        this.f747a = (ListView) findViewById(R.id.myCustomListView);
        this.f762b = (TextView) findViewById(R.id.card_count);
        this.f745a = (CheckBox) findViewById(R.id.chk_select_all);
        this.f750a = (TextView) findViewById(R.id.btn_delete_all);
        this.f767c = (TextView) findViewById(R.id.print_selected);
        this.f766c = (RadioButton) findViewById(R.id.alluser_check);
        this.f748a = (RadioButton) findViewById(R.id.used_check);
        this.f761b = (RadioButton) findViewById(R.id.unused_check);
        this.f769d = (TextView) findViewById(R.id.header_text_title);
        this.f746a = (ImageView) findViewById(R.id.icontoolbar);
        uq uqVar = new uq(this, this.f755a);
        this.f758a = uqVar;
        this.f747a.setAdapter(uqVar);
        this.f747a.setOnItemClickListener(this);
        this.f744a = new ProgressDialog(this);
        zd zdVar = new zd(this);
        this.f759a = zdVar;
        this.e = (TextView) zdVar.b().findViewById(R.id.cancel_btn);
        TextView textView = (TextView) this.f759a.b().findViewById(R.id.cp_percent);
        this.f = textView;
        textView.setVisibility(0);
        this.f769d.setText("إدارة كروت الهوتسبوت");
        this.f746a.setVisibility(8);
        qb0.i = "all";
        this.e.setOnClickListener(new tq(this));
        this.f767c.setOnClickListener(new a());
        this.f745a.setOnClickListener(new b());
        this.f750a.setOnClickListener(new c());
        this.f747a.setOnItemLongClickListener(new d());
        this.f766c.setOnClickListener(new e());
        this.f748a.setOnClickListener(new f());
        this.f761b.setOnClickListener(new g());
        this.f749a.setOnQueryTextListener(new h());
        ArrayList<HotspotCard> arrayList2 = qb0.f4834l;
        if (arrayList2 == null) {
            this.f762b.setText("لم يتم التحميل");
        } else if (arrayList2.size() > 0) {
            this.f762b.setText(getString(R.string.cards_count, new Object[]{Integer.valueOf(qb0.f4834l.size())}));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(View v) {
        this.f759a.a();
        try {
            this.f760a = true;
        } catch (Exception e2) {
            e2.printStackTrace();
            Toast.makeText(this, e2.getMessage() + " ddd", 0).show();
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View v) {
            ArrayList<AddUser> addUsers = new ArrayList<>();
            if (HotspotManagerActivity.this.f755a.size() > 0) {
                Iterator<HotspotCard> it = HotspotManagerActivity.this.f755a.iterator();
                while (it.hasNext()) {
                    HotspotCard model = it.next();
                    if (model.isSelected()) {
                        addUsers.add(new AddUser(model.getUname(), model.getPassword(), model.getProfilename(), "yes", false));
                    }
                }
                if (addUsers.size() > 0) {
                    qb0.n = addUsers;
                    HotspotManagerActivity.this.startActivity(new Intent(HotspotManagerActivity.this, PrintCardsActivity.class));
                    return;
                }
                Snackbar.k0(v, "يرجى تحديد السجلات", 0).V();
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View v) {
            try {
                if (HotspotManagerActivity.this.f755a.size() > 0) {
                    if (HotspotManagerActivity.this.f745a.isChecked()) {
                        Iterator<HotspotCard> it = HotspotManagerActivity.this.f755a.iterator();
                        while (it.hasNext()) {
                            it.next().setSelected(true);
                        }
                    } else {
                        Iterator<HotspotCard> it2 = HotspotManagerActivity.this.f755a.iterator();
                        while (it2.hasNext()) {
                            it2.next().setSelected(false);
                        }
                    }
                    HotspotManagerActivity.this.f758a.notifyDataSetChanged();
                    return;
                }
                Snackbar.k0(v, "لا توجد سجلات للتحديد", 0).V();
            } catch (Exception e) {
                Snackbar.k0(v, e.toString(), 0).V();
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View v) {
            try {
                if (HotspotManagerActivity.this.f755a.size() > 0) {
                    new AlertDialog.Builder(HotspotManagerActivity.this).setIcon(17301543).setTitle("تنبية !").setMessage("هل تريد حذف الكروت التي تم تحديدها؟").setPositiveButton("نعم", new a()).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
                } else {
                    Toast.makeText(HotspotManagerActivity.this.getApplicationContext(), "لا يوجد كروت", 0).show();
                }
            } catch (Exception e) {
                HotspotManagerActivity hotspotManagerActivity = HotspotManagerActivity.this;
                Toast.makeText(hotspotManagerActivity, e.toString() + "error", 1).show();
            }
        }

        class a implements DialogInterface.OnClickListener {
            a() {
            }

            public void onClick(DialogInterface dialog, int which) {
                HotspotManagerActivity hotspotManagerActivity = HotspotManagerActivity.this;
                hotspotManagerActivity.f760a = false;
                hotspotManagerActivity.f752a = new m();
                HotspotManagerActivity.this.f752a.execute(new String[0]);
            }
        }
    }

    class d implements AdapterView.OnItemLongClickListener {
        d() {
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
            HotspotCard c = (HotspotCard) HotspotManagerActivity.this.f758a.getItem(position);
            try {
                HotspotManagerActivity.this.f763b = c.getUname();
                HotspotManagerActivity.this.f768c = c.getId();
                HotspotManagerActivity hotspotManagerActivity = HotspotManagerActivity.this;
                hotspotManagerActivity.b = position;
                int pp = hotspotManagerActivity.f755a.indexOf(c);
                ArrayList<HotspotCard> arrayList = qb0.f4834l;
                HotspotManagerActivity.this.c = qb0.f4834l.indexOf(arrayList.get(arrayList.indexOf(HotspotManagerActivity.this.f755a.get(pp))));
                HotspotManagerActivity hotspotManagerActivity2 = HotspotManagerActivity.this;
                hotspotManagerActivity2.registerForContextMenu(hotspotManagerActivity2.f747a);
                HotspotManagerActivity hotspotManagerActivity3 = HotspotManagerActivity.this;
                hotspotManagerActivity3.openContextMenu(hotspotManagerActivity3.f747a);
                HotspotManagerActivity hotspotManagerActivity4 = HotspotManagerActivity.this;
                StringBuilder sb = new StringBuilder();
                sb.append(String.valueOf(HotspotManagerActivity.this.c));
                sb.append(" - ");
                sb.append(String.valueOf(pp));
                sb.append(" - ");
                sb.append(HotspotManagerActivity.this.f755a.get(pp).getUname());
                sb.append(" - ");
                ArrayList<HotspotCard> arrayList2 = qb0.f4834l;
                sb.append(arrayList2.get(arrayList2.indexOf(HotspotManagerActivity.this.f755a.get(pp))).getUname());
                Toast.makeText(hotspotManagerActivity4, sb.toString(), 1).show();
            } catch (Exception e) {
            }
            return true;
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        public void onClick(View v) {
            qb0.i = "all";
            HotspotManagerActivity.this.f761b.setChecked(false);
            HotspotManagerActivity.this.f748a.setChecked(false);
            if (qb0.f4834l != null) {
                HotspotManagerActivity.this.f758a.getFilter().filter("");
                try {
                    Iterator<HotspotCard> it = qb0.f4834l.iterator();
                    while (it.hasNext()) {
                        it.next().setSelected(false);
                    }
                } catch (Exception e) {
                }
                if (qb0.f4834l.size() > 0) {
                    HotspotManagerActivity hotspotManagerActivity = HotspotManagerActivity.this;
                    hotspotManagerActivity.f762b.setText(hotspotManagerActivity.getString(R.string.cards_count, new Object[]{Integer.valueOf(qb0.f4834l.size())}));
                }
                HotspotManagerActivity.this.f758a.notifyDataSetChanged();
            }
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        public void onClick(View v) {
            qb0.i = "used_card";
            HotspotManagerActivity.this.f761b.setChecked(false);
            HotspotManagerActivity.this.f766c.setChecked(false);
            if (qb0.f4834l != null) {
                HotspotManagerActivity.this.f758a.getFilter().filter("");
                HotspotManagerActivity.this.f758a.getFilter().filter("", new a());
                HotspotManagerActivity.this.f758a.notifyDataSetChanged();
            }
        }

        class a implements Filter.FilterListener {
            a() {
            }

            public void onFilterComplete(int count) {
                HotspotManagerActivity hotspotManagerActivity = HotspotManagerActivity.this;
                hotspotManagerActivity.f762b.setText(hotspotManagerActivity.getString(R.string.cards_count, new Object[]{Integer.valueOf(count)}));
            }
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        public void onClick(View v) {
            qb0.i = "unused_card";
            HotspotManagerActivity.this.f748a.setChecked(false);
            HotspotManagerActivity.this.f766c.setChecked(false);
            if (qb0.f4834l != null) {
                HotspotManagerActivity.this.f758a.getFilter().filter("");
                HotspotManagerActivity.this.f758a.getFilter().filter("", new a());
                HotspotManagerActivity.this.f758a.notifyDataSetChanged();
            }
        }

        class a implements Filter.FilterListener {
            a() {
            }

            public void onFilterComplete(int count) {
                HotspotManagerActivity hotspotManagerActivity = HotspotManagerActivity.this;
                hotspotManagerActivity.f762b.setText(hotspotManagerActivity.getString(R.string.cards_count, new Object[]{Integer.valueOf(count)}));
            }
        }
    }

    class h implements SearchView.OnQueryTextListener {
        h() {
        }

        public boolean onQueryTextSubmit(String s) {
            return false;
        }

        class a implements Filter.FilterListener {
            a() {
            }

            public void onFilterComplete(int count) {
                HotspotManagerActivity hotspotManagerActivity = HotspotManagerActivity.this;
                hotspotManagerActivity.f762b.setText(hotspotManagerActivity.getString(R.string.cards_count, new Object[]{Integer.valueOf(count)}));
            }
        }

        public boolean onQueryTextChange(String s) {
            HotspotManagerActivity.this.f758a.getFilter().filter(s, new a());
            HotspotManagerActivity.this.f758a.notifyDataSetChanged();
            return false;
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        i40.e(this);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(jv0.b(newBase));
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) menuInfo;
        if (this.a >= 0) {
            menu.setHeaderTitle(" رقم الكرت " + this.f763b);
        } else {
            menu.setHeaderTitle("الرجاء تحديد السجل");
        }
        String[] menuItems = getResources().getStringArray(R.array.selectoptionhotspot);
        for (int i2 = 0; i2 < menuItems.length; i2++) {
            menu.add(0, i2, i2, menuItems[i2]);
        }
    }

    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        String str = getResources().getStringArray(R.array.selectoptionhotspot)[item.getItemId()];
        switch (item.getItemId()) {
            case 0:
                if (this.a >= 0) {
                    new AlertDialog.Builder(this).setIcon(17301543).setTitle("تنبية !").setMessage("هل تريد حذف الكرت ؟").setPositiveButton("نعم", new i()).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
                    return true;
                }
                Snackbar.k0(this.f747a, "الرجاء تحديد السجل", 0).V();
                return true;
            case 1:
                if (this.a >= 0) {
                    j jVar = new j();
                    this.f751a = jVar;
                    jVar.execute(new String[0]);
                    return true;
                }
                Snackbar.k0(this.f747a, "الرجاء تحديد السجل", 0).V();
                return true;
            case 2:
                if (this.a >= 0) {
                    new k().execute(new String[0]);
                    return true;
                }
                Snackbar.k0(this.f747a, "الرجاء تحديد السجل", 0).V();
                return true;
            case 3:
                if (this.a >= 0) {
                    new l().execute(new String[0]);
                    return true;
                }
                Snackbar.k0(this.f747a, "الرجاء تحديد السجل", 0).V();
                return true;
            default:
                return true;
        }
    }

    class i implements DialogInterface.OnClickListener {
        i() {
        }

        public void onClick(DialogInterface dialog, int which) {
            new n().execute(new String[0]);
        }
    }

    /* access modifiers changed from: private */
    public ArrayList<HotspotCard> o(ArrayList<HotspotCard> customers) {
        if (qb0.f4834l != null) {
            for (int i2 = 0; i2 < qb0.f4834l.size(); i2++) {
                customers.add(qb0.f4834l.get(i2));
            }
        }
        return customers;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l2) {
        HotspotCard c2 = (HotspotCard) this.f758a.getItem(position);
        this.f763b = c2.getUname();
        this.f768c = c2.getId();
        this.b = position;
    }

    class j extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f770a = null;

        j() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            HotspotManagerActivity.this.f744a.setTitle("يرجى الانتظار");
            HotspotManagerActivity.this.f744a.setMessage("جاري تنفيذ العملية");
            HotspotManagerActivity.this.f744a.setCancelable(false);
            HotspotManagerActivity.this.f744a.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                if (!HotspotManagerActivity.this.f753a.w()) {
                    return null;
                }
                j3 j3Var = HotspotManagerActivity.this.f753a;
                j3Var.q("/ip/hotspot/user/reset-counters numbers=" + HotspotManagerActivity.this.f763b.toString() + "");
                j3 j3Var2 = HotspotManagerActivity.this.f753a;
                j3Var2.q("/ip/hotspot/user/set comment=\"\" numbers=" + HotspotManagerActivity.this.f763b.toString() + "");
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
            try {
                HotspotManagerActivity.this.f744a.dismiss();
                Toast.makeText(HotspotManagerActivity.this, "تمت العملية بنجاح", 1).show();
            } catch (Exception e) {
                e.printStackTrace();
                HotspotManagerActivity hotspotManagerActivity = HotspotManagerActivity.this;
                Toast.makeText(hotspotManagerActivity, e.toString() + "error", 1).show();
                HotspotManagerActivity.this.f744a.dismiss();
            }
        }
    }

    class n extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        String f774a = "";

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f775a = null;

        /* renamed from: a  reason: collision with other field name */
        boolean f776a = false;

        n() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            HotspotManagerActivity.this.f744a.setTitle("يرجى الانتظار");
            HotspotManagerActivity.this.f744a.setMessage("جاري تنفيذ العملية");
            HotspotManagerActivity.this.f744a.setCancelable(false);
            HotspotManagerActivity.this.f744a.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                if (!HotspotManagerActivity.this.f753a.w()) {
                    return null;
                }
                HotspotManagerActivity.this.f753a.q("/ip/hotspot/user/remove .id=" + HotspotManagerActivity.this.f768c.toString() + "");
                qb0.f4834l.remove(HotspotManagerActivity.this.c);
                try {
                    if (qb0.f4834l.get(HotspotManagerActivity.this.c).getUptime_used().equals("0s")) {
                        qb0.e--;
                        return null;
                    }
                    qb0.d--;
                    return null;
                } catch (Exception e) {
                    return null;
                }
            } catch (Exception e2) {
                try {
                    this.f774a = e2.getMessage();
                    this.f776a = true;
                    return null;
                } catch (Exception e3) {
                    this.f774a = e3.getMessage();
                    this.f776a = true;
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            HotspotManagerActivity.this.f744a.dismiss();
            try {
                if (this.f776a) {
                    Toast.makeText(HotspotManagerActivity.this, this.f774a, 1).show();
                    return;
                }
                Toast.makeText(HotspotManagerActivity.this, "تمت الحذف", 1).show();
                HotspotManagerActivity hotspotManagerActivity = HotspotManagerActivity.this;
                hotspotManagerActivity.f755a.remove(hotspotManagerActivity.b);
                if (qb0.f4834l != null) {
                    HotspotManagerActivity.this.f758a.getFilter().filter("");
                    if (qb0.f4834l.size() > 0) {
                        HotspotManagerActivity hotspotManagerActivity2 = HotspotManagerActivity.this;
                        hotspotManagerActivity2.f762b.setText(hotspotManagerActivity2.getString(R.string.cards_count, new Object[]{Integer.valueOf(qb0.f4834l.size())}));
                    }
                }
                HotspotManagerActivity.this.f758a.clear();
                HotspotManagerActivity hotspotManagerActivity3 = HotspotManagerActivity.this;
                hotspotManagerActivity3.f755a = hotspotManagerActivity3.o(hotspotManagerActivity3.f755a);
                HotspotManagerActivity hotspotManagerActivity4 = HotspotManagerActivity.this;
                HotspotManagerActivity hotspotManagerActivity5 = HotspotManagerActivity.this;
                hotspotManagerActivity4.f758a = new uq(hotspotManagerActivity5, hotspotManagerActivity5.f755a);
                HotspotManagerActivity hotspotManagerActivity6 = HotspotManagerActivity.this;
                hotspotManagerActivity6.f747a.setAdapter(hotspotManagerActivity6.f758a);
                HotspotManagerActivity hotspotManagerActivity7 = HotspotManagerActivity.this;
                hotspotManagerActivity7.f747a.setOnItemClickListener(hotspotManagerActivity7);
            } catch (Exception e) {
                Toast.makeText(HotspotManagerActivity.this, e.getMessage(), 0).show();
                HotspotManagerActivity.this.f744a.dismiss();
            }
        }
    }

    class k extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f771a = null;

        k() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            HotspotManagerActivity.this.f744a.setTitle("يرجى الانتظار");
            HotspotManagerActivity.this.f744a.setMessage("جاري تنفيذ العملية");
            HotspotManagerActivity.this.f744a.setCancelable(false);
            HotspotManagerActivity.this.f744a.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                if (!HotspotManagerActivity.this.f753a.w()) {
                    return null;
                }
                j3 j3Var = HotspotManagerActivity.this.f753a;
                j3Var.q("/ip/hotspot/user/disable numbers=" + HotspotManagerActivity.this.f763b.toString() + "");
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
            HotspotManagerActivity.this.f744a.dismiss();
        }
    }

    class l extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f772a = null;

        l() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            HotspotManagerActivity.this.f744a.setTitle("يرجى الانتظار");
            HotspotManagerActivity.this.f744a.setMessage("جاري تنفيذ العملية");
            HotspotManagerActivity.this.f744a.setCancelable(false);
            HotspotManagerActivity.this.f744a.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                if (!HotspotManagerActivity.this.f753a.w()) {
                    return null;
                }
                j3 j3Var = HotspotManagerActivity.this.f753a;
                j3Var.q("/ip/hotspot/user/enable numbers=" + HotspotManagerActivity.this.f763b.toString() + "");
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
            HotspotManagerActivity.this.f744a.dismiss();
        }
    }

    class m extends AsyncTask<String, Integer, String> {

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f773a = null;
        List<String> b = new ArrayList();

        m() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            HotspotManagerActivity.this.f.setText("0%");
            HotspotManagerActivity.this.f759a.c("جاري حذف الكروت المحددة..");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                HotspotManagerActivity hotspotManagerActivity = HotspotManagerActivity.this;
                hotspotManagerActivity.d = 0;
                int ncoun = hotspotManagerActivity.f755a.size();
                if (HotspotManagerActivity.this.f755a.size() <= 0) {
                    return null;
                }
                int iadd = 0;
                while (true) {
                    if (iadd >= ncoun) {
                        break;
                    }
                    if (HotspotManagerActivity.this.f755a.get(iadd).isSelected()) {
                        j3 j3Var = HotspotManagerActivity.this.f753a;
                        j3Var.q("/ip/hotspot/user/remove .id=" + HotspotManagerActivity.this.f755a.get(iadd).getId() + "");
                        HotspotManagerActivity.this.f764b.add(HotspotManagerActivity.this.f755a.get(iadd));
                        this.b.add(HotspotManagerActivity.this.f755a.get(iadd).getId());
                        ArrayList<HotspotCard> arrayList = qb0.f4834l;
                        qb0.f4834l.remove(arrayList.get(arrayList.indexOf(HotspotManagerActivity.this.f755a.get(iadd))));
                    }
                    publishProgress(new Integer[]{Integer.valueOf((int) ((((float) iadd) / ((float) ncoun)) * 100.0f))});
                    if (HotspotManagerActivity.this.f760a) {
                        break;
                    }
                    iadd++;
                }
                HotspotManagerActivity.this.f757a.B0(this.b, 1);
                return null;
            } catch (Exception e) {
                try {
                    Log.d("mLog", e.toString() + "error odai dammag");
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    Log.d("mLog", e2.toString() + "error odai dammag");
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void onProgressUpdate(Integer... values) {
            TextView textView = HotspotManagerActivity.this.f;
            textView.setText(values[0] + "%");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            HotspotManagerActivity.this.f759a.a();
            try {
                if (HotspotManagerActivity.this.f764b.size() > 0) {
                    int del_count = 0;
                    for (int i = 0; i < HotspotManagerActivity.this.f764b.size(); i++) {
                        HotspotManagerActivity hotspotManagerActivity = HotspotManagerActivity.this;
                        hotspotManagerActivity.f755a.remove(hotspotManagerActivity.f764b.get(i));
                        del_count++;
                        if (qb0.f4834l.get(HotspotManagerActivity.this.c).getUptime_used().equals("0s")) {
                            qb0.e--;
                        } else {
                            qb0.d--;
                        }
                    }
                }
                if (qb0.f4834l.size() > 0) {
                    HotspotManagerActivity hotspotManagerActivity2 = HotspotManagerActivity.this;
                    hotspotManagerActivity2.f762b.setText(hotspotManagerActivity2.getString(R.string.cards_count, new Object[]{Integer.valueOf(qb0.f4834l.size())}));
                }
                HotspotManagerActivity.this.f758a.clear();
                HotspotManagerActivity hotspotManagerActivity3 = HotspotManagerActivity.this;
                hotspotManagerActivity3.f755a = hotspotManagerActivity3.o(hotspotManagerActivity3.f755a);
                HotspotManagerActivity hotspotManagerActivity4 = HotspotManagerActivity.this;
                HotspotManagerActivity hotspotManagerActivity5 = HotspotManagerActivity.this;
                hotspotManagerActivity4.f758a = new uq(hotspotManagerActivity5, hotspotManagerActivity5.f755a);
                HotspotManagerActivity hotspotManagerActivity6 = HotspotManagerActivity.this;
                hotspotManagerActivity6.f747a.setAdapter(hotspotManagerActivity6.f758a);
                HotspotManagerActivity hotspotManagerActivity7 = HotspotManagerActivity.this;
                hotspotManagerActivity7.f747a.setOnItemClickListener(hotspotManagerActivity7);
                HotspotManagerActivity.this.f764b.clear();
            } catch (Exception e) {
            }
        }
    }
}
