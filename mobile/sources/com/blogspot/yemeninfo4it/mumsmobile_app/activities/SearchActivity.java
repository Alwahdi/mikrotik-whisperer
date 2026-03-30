package com.blogspot.yemeninfo4it.mumsmobile_app.activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.AddUser;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SearchActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    public int a = 0;

    /* renamed from: a  reason: collision with other field name */
    ae f1111a = null;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f1112a;

    /* renamed from: a  reason: collision with other field name */
    CheckBox f1113a;

    /* renamed from: a  reason: collision with other field name */
    ImageView f1114a;

    /* renamed from: a  reason: collision with other field name */
    ListView f1115a;

    /* renamed from: a  reason: collision with other field name */
    RadioButton f1116a;

    /* renamed from: a  reason: collision with other field name */
    SearchView f1117a = null;

    /* renamed from: a  reason: collision with other field name */
    Spinner f1118a;

    /* renamed from: a  reason: collision with other field name */
    TextView f1119a;

    /* renamed from: a  reason: collision with other field name */
    t f1120a;

    /* renamed from: a  reason: collision with other field name */
    j3 f1121a;

    /* renamed from: a  reason: collision with other field name */
    public String f1122a = "";

    /* renamed from: a  reason: collision with other field name */
    ArrayList<UsermanagerCards> f1123a = null;

    /* renamed from: a  reason: collision with other field name */
    List<String> f1124a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    ue f1125a;

    /* renamed from: a  reason: collision with other field name */
    zd f1126a;

    /* renamed from: a  reason: collision with other field name */
    boolean f1127a = false;
    public int b = 0;

    /* renamed from: b  reason: collision with other field name */
    RadioButton f1128b;

    /* renamed from: b  reason: collision with other field name */
    TextView f1129b;

    /* renamed from: b  reason: collision with other field name */
    public String f1130b = "";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public final ArrayList<UsermanagerCards> f1131b = new ArrayList<>();

    /* renamed from: b  reason: collision with other field name */
    List<String> f1132b = new ArrayList();
    public int c = 0;

    /* renamed from: c  reason: collision with other field name */
    RadioButton f1133c;

    /* renamed from: c  reason: collision with other field name */
    TextView f1134c;

    /* renamed from: c  reason: collision with other field name */
    public String f1135c;
    int d = 6;

    /* renamed from: d  reason: collision with other field name */
    RadioButton f1136d;

    /* renamed from: d  reason: collision with other field name */
    TextView f1137d;

    /* renamed from: d  reason: collision with other field name */
    public String f1138d;
    RadioButton e;

    /* renamed from: e  reason: collision with other field name */
    TextView f1139e;

    /* renamed from: e  reason: collision with other field name */
    final String f1140e = "mLog";
    TextView f;
    TextView g;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_search);
        try {
            this.f1121a = qb0.d();
            this.f1123a = new ArrayList<>();
            this.f1123a = o();
            this.d = qb0.f4798a.getVersion() != null ? Integer.parseInt(qb0.f4798a.getVersion().substring(0, 1)) : 6;
            this.f1125a = new ue(this);
            this.f1117a = (SearchView) findViewById(R.id.mySearchView);
            this.f1115a = (ListView) findViewById(R.id.myCustomListView);
            this.f1113a = (CheckBox) findViewById(R.id.chk_select_all);
            this.f1119a = (TextView) findViewById(R.id.btn_delete_all);
            this.f1129b = (TextView) findViewById(R.id.print_selected);
            this.f1134c = (TextView) findViewById(R.id.header_text_title);
            this.f1137d = (TextView) findViewById(R.id.card_count);
            this.f1114a = (ImageView) findViewById(R.id.icontoolbar);
            this.f1116a = (RadioButton) findViewById(R.id.search_userman);
            this.f1128b = (RadioButton) findViewById(R.id.search_profile);
            this.e = (RadioButton) findViewById(R.id.alluser_check);
            this.f1133c = (RadioButton) findViewById(R.id.used_check);
            this.f1136d = (RadioButton) findViewById(R.id.unused_check);
            this.f1118a = (Spinner) findViewById(R.id.profilename);
            this.g = (TextView) findViewById(R.id.search_header);
            zd zdVar = new zd(this);
            this.f1126a = zdVar;
            this.f1139e = (TextView) zdVar.b().findViewById(R.id.cancel_btn);
            TextView textView = (TextView) this.f1126a.b().findViewById(R.id.cp_percent);
            this.f = textView;
            textView.setVisibility(0);
            ae aeVar = new ae(this, this.f1123a);
            this.f1111a = aeVar;
            this.f1115a.setAdapter(aeVar);
            this.f1115a.setOnItemClickListener(this);
            this.f1112a = new ProgressDialog(this);
            this.f1114a.setVisibility(8);
            qb0.h = "username";
            qb0.i = "all";
            this.f1134c.setText("إدارة كروت يوزر مانجر");
            this.f1124a.add("اختر الباقة");
            for (int i2 = 0; i2 < qb0.p.size(); i2++) {
                this.f1124a.add(qb0.p.get(i2).getUname());
            }
            for (int i3 = 0; i3 < qb0.q.size(); i3++) {
                this.f1132b.add(qb0.q.get(i3).getUname());
            }
            if (qb0.f4807b.size() > 0) {
                this.f1137d.setText(getString(R.string.cards_count, new Object[]{Integer.valueOf(qb0.f4807b.size())}));
            }
            ArrayAdapter<String> profileAdapter = new ArrayAdapter<>(this, 17367048, this.f1124a);
            profileAdapter.setDropDownViewResource(17367049);
            this.f1118a.setAdapter(profileAdapter);
            this.f1139e.setOnClickListener(new sj0(this));
            this.f1116a.setOnClickListener(new h());
            this.f1128b.setOnClickListener(new i());
            this.e.setOnClickListener(new j());
            this.f1133c.setOnClickListener(new k());
            this.f1136d.setOnClickListener(new l());
            this.f1117a.setOnQueryTextListener(new m());
            this.f1118a.setOnItemSelectedListener(new n());
            this.f1129b.setOnClickListener(new o());
            this.f1113a.setOnClickListener(new p());
            this.f1119a.setOnClickListener(new a());
            this.f1115a.setOnItemLongClickListener(new b());
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.d("mLog", e2.toString() + "error odai dammag");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(View v) {
        this.f1126a.a();
        this.f1127a = true;
    }

    class h implements View.OnClickListener {
        h() {
        }

        public void onClick(View v) {
            qb0.h = "username";
            SearchActivity.this.g.setText("اكتب اسم الكرت للبحث");
            SearchActivity.this.f1128b.setChecked(false);
            SearchActivity.this.f1117a.setVisibility(0);
            SearchActivity.this.f1118a.setVisibility(8);
            ArrayList<UsermanagerCards> arrayList = qb0.f4807b;
            if (arrayList != null) {
                try {
                    Iterator<UsermanagerCards> it = arrayList.iterator();
                    while (it.hasNext()) {
                        it.next().setSelected(false);
                    }
                } catch (Exception e) {
                }
                if (SearchActivity.this.e.isChecked()) {
                    SearchActivity.this.f1111a.getFilter().filter("");
                }
                if (qb0.f4807b.size() > 0) {
                    SearchActivity searchActivity = SearchActivity.this;
                    searchActivity.f1137d.setText(searchActivity.getString(R.string.cards_count, new Object[]{Integer.valueOf(qb0.f4807b.size())}));
                }
            }
        }
    }

    class i implements View.OnClickListener {
        i() {
        }

        public void onClick(View v) {
            qb0.h = "profilename";
            SearchActivity.this.g.setText("إختار اسم الباقة للبحث");
            SearchActivity.this.f1116a.setChecked(false);
            SearchActivity.this.f1118a.setVisibility(0);
            SearchActivity.this.f1117a.setVisibility(8);
        }
    }

    class j implements View.OnClickListener {
        j() {
        }

        public void onClick(View v) {
            qb0.i = "all";
            SearchActivity.this.f1136d.setChecked(false);
            SearchActivity.this.f1133c.setChecked(false);
            qb0.h = "username";
            SearchActivity.this.g.setText("اكتب اسم الكرت للبحث");
            SearchActivity.this.f1116a.setChecked(true);
            SearchActivity.this.f1128b.setChecked(false);
            SearchActivity.this.f1117a.setVisibility(0);
            SearchActivity.this.f1118a.setVisibility(8);
            if (qb0.f4807b != null) {
                SearchActivity.this.f1111a.getFilter().filter("");
                try {
                    Iterator<UsermanagerCards> it = qb0.f4807b.iterator();
                    while (it.hasNext()) {
                        it.next().setSelected(false);
                    }
                } catch (Exception e) {
                }
                if (qb0.f4807b.size() > 0) {
                    SearchActivity searchActivity = SearchActivity.this;
                    searchActivity.f1137d.setText(searchActivity.getString(R.string.cards_count, new Object[]{Integer.valueOf(qb0.f4807b.size())}));
                }
                SearchActivity.this.f1111a.notifyDataSetChanged();
            }
        }
    }

    class k implements View.OnClickListener {
        k() {
        }

        public void onClick(View v) {
            qb0.i = "used_card";
            SearchActivity.this.f1136d.setChecked(false);
            SearchActivity.this.e.setChecked(false);
            if (qb0.f4807b != null) {
                try {
                    SearchActivity.this.f1118a.setSelection(0);
                } catch (Exception e) {
                }
                SearchActivity.this.f1111a.getFilter().filter("");
                SearchActivity.this.f1111a.getFilter().filter("", new a());
                SearchActivity.this.f1111a.notifyDataSetChanged();
            }
        }

        class a implements Filter.FilterListener {
            a() {
            }

            public void onFilterComplete(int count) {
                SearchActivity searchActivity = SearchActivity.this;
                searchActivity.f1137d.setText(searchActivity.getString(R.string.cards_count, new Object[]{Integer.valueOf(count)}));
            }
        }
    }

    class l implements View.OnClickListener {
        l() {
        }

        public void onClick(View v) {
            qb0.i = "unused_card";
            SearchActivity.this.f1133c.setChecked(false);
            SearchActivity.this.e.setChecked(false);
            if (qb0.f4807b != null) {
                try {
                    SearchActivity.this.f1118a.setSelection(0);
                } catch (Exception e) {
                }
                SearchActivity.this.f1111a.getFilter().filter("");
                SearchActivity.this.f1111a.getFilter().filter("", new a());
                SearchActivity.this.f1111a.notifyDataSetChanged();
            }
        }

        class a implements Filter.FilterListener {
            a() {
            }

            public void onFilterComplete(int count) {
                SearchActivity searchActivity = SearchActivity.this;
                searchActivity.f1137d.setText(searchActivity.getString(R.string.cards_count, new Object[]{Integer.valueOf(count)}));
            }
        }
    }

    class m implements SearchView.OnQueryTextListener {
        m() {
        }

        public boolean onQueryTextSubmit(String s) {
            return false;
        }

        class a implements Filter.FilterListener {
            a() {
            }

            public void onFilterComplete(int count) {
                SearchActivity searchActivity = SearchActivity.this;
                searchActivity.f1137d.setText(searchActivity.getString(R.string.cards_count, new Object[]{Integer.valueOf(count)}));
            }
        }

        public boolean onQueryTextChange(String s) {
            try {
                SearchActivity.this.f1111a.getFilter().filter(s, new a());
                SearchActivity.this.f1111a.notifyDataSetChanged();
                return false;
            } catch (Exception e) {
                return false;
            }
        }
    }

    class n implements AdapterView.OnItemSelectedListener {
        n() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            Object item = adapterView.getItemAtPosition(position);
            if (!item.toString().equals("اختر الباقة")) {
                try {
                    SearchActivity.this.f1111a.getFilter().filter(item.toString(), new a());
                    SearchActivity.this.f1111a.notifyDataSetChanged();
                } catch (Exception e) {
                }
            }
        }

        class a implements Filter.FilterListener {
            a() {
            }

            public void onFilterComplete(int count) {
                SearchActivity searchActivity = SearchActivity.this;
                searchActivity.f1137d.setText(searchActivity.getString(R.string.cards_count, new Object[]{Integer.valueOf(count)}));
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class o implements View.OnClickListener {
        o() {
        }

        public void onClick(View v) {
            ArrayList<AddUser> addUsers = new ArrayList<>();
            if (SearchActivity.this.f1123a.size() > 0) {
                Iterator<UsermanagerCards> it = SearchActivity.this.f1123a.iterator();
                while (it.hasNext()) {
                    UsermanagerCards model = it.next();
                    if (model.isSelected()) {
                        addUsers.add(new AddUser(model.getUname(), model.getPassword(), model.getProfilename(), "yes", false));
                    }
                }
                if (addUsers.size() > 0) {
                    qb0.n = addUsers;
                    SearchActivity.this.startActivity(new Intent(SearchActivity.this, PrintCardsActivity.class));
                    return;
                }
                Snackbar.k0(v, "يرجى تحديد السجلات", 0).V();
            }
        }
    }

    class p implements View.OnClickListener {
        p() {
        }

        public void onClick(View v) {
            try {
                if (SearchActivity.this.f1123a.size() > 0) {
                    if (SearchActivity.this.f1113a.isChecked()) {
                        Iterator<UsermanagerCards> it = SearchActivity.this.f1123a.iterator();
                        while (it.hasNext()) {
                            it.next().setSelected(true);
                        }
                    } else {
                        Iterator<UsermanagerCards> it2 = SearchActivity.this.f1123a.iterator();
                        while (it2.hasNext()) {
                            it2.next().setSelected(false);
                        }
                    }
                    SearchActivity.this.f1111a.notifyDataSetChanged();
                    return;
                }
                Snackbar.k0(v, "لا توجد سجلات للتحديد", 0).V();
            } catch (Exception e) {
                Snackbar.k0(v, e.toString(), 0).V();
            }
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View v) {
            try {
                if (SearchActivity.this.f1123a.size() > 0) {
                    new AlertDialog.Builder(SearchActivity.this, R.style.CustomAlertDialog).setIcon(17301543).setTitle("تنبية !").setMessage("هل تريد حذف الكروت المنتهية التي قمت بتحديدها").setPositiveButton("نعم", new C0006a()).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
                } else {
                    Toast.makeText(SearchActivity.this.getApplicationContext(), "لا يوجد كروت منتهية", 0).show();
                }
            } catch (Exception e) {
                SearchActivity searchActivity = SearchActivity.this;
                Toast.makeText(searchActivity, e.toString() + "error", 1).show();
            }
        }

        /* renamed from: com.blogspot.yemeninfo4it.mumsmobile_app.activities.SearchActivity$a$a  reason: collision with other inner class name */
        class C0006a implements DialogInterface.OnClickListener {
            C0006a() {
            }

            public void onClick(DialogInterface dialog, int which) {
                SearchActivity searchActivity = SearchActivity.this;
                searchActivity.f1127a = false;
                searchActivity.f1120a = new t();
                SearchActivity.this.f1120a.execute(new String[0]);
            }
        }
    }

    class b implements AdapterView.OnItemLongClickListener {
        b() {
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
            try {
                UsermanagerCards c = (UsermanagerCards) SearchActivity.this.f1111a.getItem(position);
                SearchActivity.this.f1122a = c.getUname();
                SearchActivity.this.f1130b = c.getId();
                SearchActivity searchActivity = SearchActivity.this;
                searchActivity.b = searchActivity.f1123a.indexOf(c);
                ArrayList<UsermanagerCards> arrayList = qb0.f4807b;
                SearchActivity searchActivity2 = SearchActivity.this;
                SearchActivity.this.c = qb0.f4807b.indexOf(arrayList.get(arrayList.indexOf(searchActivity2.f1123a.get(searchActivity2.b))));
                SearchActivity searchActivity3 = SearchActivity.this;
                searchActivity3.registerForContextMenu(searchActivity3.f1115a);
                SearchActivity searchActivity4 = SearchActivity.this;
                searchActivity4.openContextMenu(searchActivity4.f1115a);
                return true;
            } catch (Exception e) {
                Toast.makeText(SearchActivity.this, e.getMessage(), 0).show();
                return true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(jv0.b(newBase));
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
        i40.e(this);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        try {
            AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) menuInfo;
            if (this.a >= 0) {
                menu.setHeaderTitle(" رقم الكرت " + this.f1122a);
            } else {
                menu.setHeaderTitle("الرجاء تحديد السجل");
            }
            String[] menuItems = getResources().getStringArray(R.array.selectoption);
            for (int i2 = 0; i2 < menuItems.length; i2++) {
                menu.add(0, i2, i2, menuItems[i2]);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean onContextItemSelected(MenuItem item) {
        try {
            AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            String str = getResources().getStringArray(R.array.selectoption)[item.getItemId()];
            switch (item.getItemId()) {
                case 0:
                    if (this.a >= 0) {
                        new u().execute(new String[0]);
                        return true;
                    }
                    Snackbar.k0(this.f1115a, "الرجاء تحديد السجل", 0).V();
                    return true;
                case 1:
                    if (this.a >= 0) {
                        p();
                        return true;
                    }
                    Snackbar.k0(this.f1115a, "الرجاء تحديد السجل", 0).V();
                    return true;
                case 2:
                    if (this.a < 0) {
                        Snackbar.k0(this.f1115a, "الرجاء تحديد السجل", 0).V();
                        return true;
                    } else if (!this.f1123a.get(this.b).last_seen.equals("never")) {
                        Intent intent = new Intent(this, SessionActivity.class);
                        intent.putExtra("selected_id", this.f1122a);
                        startActivity(intent);
                        return true;
                    } else {
                        Toast.makeText(this, "هذا الكرت لم يتم استخدامة لا يمكنك عرض الجلسات", 0).show();
                        return true;
                    }
                case 3:
                    if (this.a >= 0) {
                        new AlertDialog.Builder(this, R.style.CustomAlertDialog).setIcon(17301543).setTitle((CharSequence) "تنبية..!").setMessage((CharSequence) "هل تريد تعطيل هذا المستخدم").setPositiveButton((CharSequence) "نعم", (DialogInterface.OnClickListener) new c()).setNegativeButton((CharSequence) "لا", (DialogInterface.OnClickListener) null).show();
                        return true;
                    }
                    Snackbar.k0(this.f1115a, "الرجاء تحديد السجل", 0).V();
                    return true;
                case 4:
                    if (this.a >= 0) {
                        new AlertDialog.Builder(this, R.style.CustomAlertDialog).setIcon(17301543).setTitle((CharSequence) "تنبية..!").setMessage((CharSequence) "هل تريد تفعيل هذا المستخدم").setPositiveButton((CharSequence) "نعم", (DialogInterface.OnClickListener) new d()).setNegativeButton((CharSequence) "لا", (DialogInterface.OnClickListener) null).show();
                        return true;
                    }
                    Snackbar.k0(this.f1115a, "الرجاء تحديد السجل", 0).V();
                    return true;
                default:
                    return true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
        e2.printStackTrace();
        return true;
    }

    class c implements DialogInterface.OnClickListener {
        c() {
        }

        public void onClick(DialogInterface dialog, int which) {
            new r().execute(new String[0]);
        }
    }

    class d implements DialogInterface.OnClickListener {
        d() {
        }

        public void onClick(DialogInterface dialog, int which) {
            new s().execute(new String[0]);
        }
    }

    /* access modifiers changed from: private */
    public ArrayList<UsermanagerCards> o() {
        try {
            qb0.j();
        } catch (Exception e2) {
        }
        try {
            this.f1123a.addAll(qb0.f4807b);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return this.f1123a;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l2) {
        try {
            UsermanagerCards c2 = (UsermanagerCards) this.f1111a.getItem(position);
            this.f1122a = c2.getUname();
            this.f1130b = c2.getId();
            this.b = position;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    class q extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        String f1143a = "";

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f1144a = null;

        /* renamed from: a  reason: collision with other field name */
        boolean f1145a = false;

        q() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            SearchActivity.this.f1112a.setTitle("يرجى الانتظار");
            SearchActivity.this.f1112a.setMessage("جاري تنفيذ العملية");
            SearchActivity.this.f1112a.setCancelable(false);
            SearchActivity.this.f1112a.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                SearchActivity searchActivity = SearchActivity.this;
                if (searchActivity.d >= 7) {
                    j3 j3Var = searchActivity.f1121a;
                    j3Var.q("/user-manager/user-profile/add user=" + SearchActivity.this.f1130b + " profile=\"" + SearchActivity.this.f1135c + "\"");
                    return null;
                }
                j3 j3Var2 = searchActivity.f1121a;
                j3Var2.q("/tool/user-manager/user/create-and-activate-profile numbers=" + SearchActivity.this.f1130b + " profile=" + SearchActivity.this.f1135c + " customer=" + SearchActivity.this.f1138d + "");
                return null;
            } catch (Exception e) {
                try {
                    this.f1143a = e.getMessage();
                    this.f1145a = true;
                    return null;
                } catch (Exception e2) {
                    this.f1143a = e2.getMessage();
                    this.f1145a = true;
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            try {
                if (this.f1145a) {
                    Toast.makeText(SearchActivity.this, this.f1143a, 1).show();
                } else {
                    Toast.makeText(SearchActivity.this, "تمت الإضافة", 1).show();
                }
                SearchActivity.this.f1112a.dismiss();
            } catch (Exception e) {
                Toast.makeText(SearchActivity.this, this.f1143a, 1).show();
                SearchActivity.this.f1112a.dismiss();
            }
        }
    }

    class u extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        String f1155a = "";

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f1156a = null;

        /* renamed from: a  reason: collision with other field name */
        boolean f1157a = false;
        List<String> b = new ArrayList();

        u() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            SearchActivity.this.f1112a.setTitle("يرجى الانتظار");
            SearchActivity.this.f1112a.setMessage("جاري تنفيذ العملية");
            SearchActivity.this.f1112a.setCancelable(false);
            SearchActivity.this.f1112a.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                SearchActivity searchActivity = SearchActivity.this;
                if (searchActivity.d >= 7) {
                    searchActivity.f1121a.q("/user-manager/user/remove numbers=" + SearchActivity.this.f1130b + "");
                } else {
                    searchActivity.f1121a.q("/tool/user-manager/user/remove .id=" + SearchActivity.this.f1130b + "");
                }
                this.b.add(SearchActivity.this.f1130b);
                if (qb0.f4807b.get(SearchActivity.this.c).getUptime_used() == null) {
                    qb0.c--;
                } else {
                    qb0.b--;
                }
                qb0.f4807b.remove(SearchActivity.this.c);
                return null;
            } catch (Exception e) {
                try {
                    this.f1155a = e.getMessage();
                    this.f1157a = true;
                    return null;
                } catch (Exception e2) {
                    this.f1155a = e2.getMessage();
                    this.f1157a = true;
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            try {
                if (this.f1157a) {
                    Toast.makeText(SearchActivity.this, this.f1155a, 1).show();
                } else {
                    Toast.makeText(SearchActivity.this, "تمت الحذف", 1).show();
                    SearchActivity searchActivity = SearchActivity.this;
                    searchActivity.f1123a.remove(searchActivity.b);
                    SearchActivity.this.f1111a.clear();
                    if (qb0.f4807b.size() > 0) {
                        SearchActivity searchActivity2 = SearchActivity.this;
                        searchActivity2.f1137d.setText(searchActivity2.getString(R.string.cards_count, new Object[]{Integer.valueOf(qb0.f4807b.size())}));
                    }
                    SearchActivity searchActivity3 = SearchActivity.this;
                    searchActivity3.f1123a = searchActivity3.o();
                    SearchActivity searchActivity4 = SearchActivity.this;
                    SearchActivity searchActivity5 = SearchActivity.this;
                    searchActivity4.f1111a = new ae(searchActivity5, searchActivity5.f1123a);
                    SearchActivity searchActivity6 = SearchActivity.this;
                    searchActivity6.f1115a.setAdapter(searchActivity6.f1111a);
                    SearchActivity searchActivity7 = SearchActivity.this;
                    searchActivity7.f1115a.setOnItemClickListener(searchActivity7);
                    SearchActivity.this.f1125a.B0(this.b, 0);
                }
                SearchActivity.this.f1112a.dismiss();
            } catch (Exception e) {
                SearchActivity searchActivity8 = SearchActivity.this;
                Toast.makeText(searchActivity8, this.f1155a + "-" + e.getMessage(), 1).show();
                SearchActivity.this.f1112a.dismiss();
            }
        }
    }

    class r extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        String f1146a = "";

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f1147a = null;

        /* renamed from: a  reason: collision with other field name */
        boolean f1148a = false;

        r() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            SearchActivity.this.f1112a.setTitle("يرجى الانتظار");
            SearchActivity.this.f1112a.setMessage("جاري تنفيذ العملية");
            SearchActivity.this.f1112a.setCancelable(false);
            SearchActivity.this.f1112a.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                SearchActivity searchActivity = SearchActivity.this;
                if (searchActivity.d >= 7) {
                    j3 j3Var = searchActivity.f1121a;
                    j3Var.q("/user-manager/user/disable numbers=" + SearchActivity.this.f1130b + "");
                    return null;
                }
                j3 j3Var2 = searchActivity.f1121a;
                j3Var2.q("/tool/user-manager/user/disable numbers=" + SearchActivity.this.f1130b + "");
                return null;
            } catch (Exception e) {
                try {
                    this.f1146a = e.getMessage();
                    this.f1148a = true;
                    return null;
                } catch (Exception e2) {
                    this.f1146a = e2.getMessage();
                    this.f1148a = true;
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            SearchActivity.this.f1112a.dismiss();
            if (this.f1148a) {
                Toast.makeText(SearchActivity.this, this.f1146a, 1).show();
            } else {
                Toast.makeText(SearchActivity.this, "تمت العملية", 1).show();
            }
        }
    }

    class s extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        String f1149a = "";

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f1150a = null;

        /* renamed from: a  reason: collision with other field name */
        boolean f1151a = false;

        s() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            SearchActivity.this.f1112a.setTitle("يرجى الانتظار");
            SearchActivity.this.f1112a.setMessage("جاري تنفيذ العملية");
            SearchActivity.this.f1112a.setCancelable(false);
            SearchActivity.this.f1112a.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                if (!SearchActivity.this.f1121a.w()) {
                    return null;
                }
                SearchActivity searchActivity = SearchActivity.this;
                if (searchActivity.d >= 7) {
                    j3 j3Var = searchActivity.f1121a;
                    j3Var.q("/user-manager/user/enable numbers=" + SearchActivity.this.f1130b + "");
                    return null;
                }
                j3 j3Var2 = searchActivity.f1121a;
                j3Var2.q("/tool/user-manager/user/enable numbers=" + SearchActivity.this.f1130b + "");
                return null;
            } catch (Exception e) {
                try {
                    this.f1149a = e.getMessage();
                    this.f1151a = true;
                    return null;
                } catch (Exception e2) {
                    this.f1149a = e2.getMessage();
                    this.f1151a = true;
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            if (this.f1151a) {
                Toast.makeText(SearchActivity.this, this.f1149a, 1).show();
            } else {
                Toast.makeText(SearchActivity.this, "تمت العملية", 1).show();
            }
            SearchActivity.this.f1112a.dismiss();
        }
    }

    public void p() {
        try {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this, R.style.CustomAlertDialog);
            View myView = getLayoutInflater().inflate(R.layout.feedback_popup, (ViewGroup) null);
            dialogBuilder.setView(myView);
            Spinner profilelist = (Spinner) myView.findViewById(R.id.profilelist);
            Spinner customerlist = (Spinner) myView.findViewById(R.id.customerlist);
            Button addprofiletouser = (Button) myView.findViewById(R.id.addprofiletouser);
            LinearLayout customer_layout = (LinearLayout) myView.findViewById(R.id.customer_layout);
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, 17367048, this.f1124a);
            dataAdapter.setDropDownViewResource(17367049);
            profilelist.setAdapter(dataAdapter);
            int version = qb0.f4798a.getVersion() != null ? Integer.parseInt(qb0.f4798a.getVersion().substring(0, 1)) : 6;
            if (version <= 6) {
                ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367048, this.f1132b);
                arrayAdapter.setDropDownViewResource(17367049);
                customerlist.setAdapter(arrayAdapter);
                this.f1138d = customerlist.getSelectedItem().toString();
                qb0.f4810c = customerlist.getSelectedItem().toString();
            } else {
                customer_layout.setVisibility(8);
            }
            dialogBuilder.create().show();
            profilelist.setOnItemSelectedListener(new e());
            customerlist.setOnItemSelectedListener(new f());
            addprofiletouser.setOnClickListener(new g(version, profilelist));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    class e implements AdapterView.OnItemSelectedListener {
        e() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            Object item = adapterView.getItemAtPosition(position);
            SearchActivity.this.f1135c = item.toString();
            qb0.f4806b = item.toString();
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class f implements AdapterView.OnItemSelectedListener {
        f() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            Object item = adapterView.getItemAtPosition(position);
            SearchActivity.this.f1138d = item.toString();
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class g implements View.OnClickListener {
        final /* synthetic */ int a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ Spinner f1141a;

        g(int i, Spinner spinner) {
            this.a = i;
            this.f1141a = spinner;
        }

        public void onClick(View v) {
            boolean tr;
            if (this.a <= 6) {
                tr = !TextUtils.isEmpty(SearchActivity.this.f1138d);
            } else {
                tr = true;
            }
            if (this.f1141a.getSelectedItem().toString().equals("اختر الباقة") || !tr) {
                Snackbar.k0(SearchActivity.this.f1115a, "الرجاء اختيار اسم الباقة", 0).V();
            } else {
                new AlertDialog.Builder(SearchActivity.this, R.style.CustomAlertDialog).setIcon(17301543).setTitle((CharSequence) "تنبية..!").setMessage((CharSequence) "هل تريد اضافة باقة لهذا المستخدم").setPositiveButton((CharSequence) "نعم", (DialogInterface.OnClickListener) new a()).setNegativeButton((CharSequence) "لا", (DialogInterface.OnClickListener) null).show();
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

    class t extends AsyncTask<String, Integer, String> {

        /* renamed from: a  reason: collision with other field name */
        String f1152a = "";

        /* renamed from: a  reason: collision with other field name */
        List<String> f1153a = new ArrayList();

        /* renamed from: a  reason: collision with other field name */
        boolean f1154a = false;

        t() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            SearchActivity.this.f.setText("0%");
            SearchActivity.this.f1126a.c("جاري حذف الكروت المحددة");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                int ncoun = SearchActivity.this.f1123a.size();
                int version = qb0.f4798a.getVersion() != null ? Integer.parseInt(qb0.f4798a.getVersion().substring(0, 1)) : 6;
                if (SearchActivity.this.f1123a.size() <= 0) {
                    return null;
                }
                int iadd = 0;
                while (true) {
                    if (iadd >= ncoun) {
                        break;
                    }
                    if (SearchActivity.this.f1123a.get(iadd).isSelected()) {
                        if (version >= 7) {
                            SearchActivity.this.f1121a.q("/user-manager/user/remove numbers=" + SearchActivity.this.f1123a.get(iadd).getId() + "");
                        } else {
                            SearchActivity.this.f1121a.q("/tool/user-manager/user/remove .id=" + SearchActivity.this.f1123a.get(iadd).getId() + "");
                        }
                        SearchActivity.this.f1131b.add(SearchActivity.this.f1123a.get(iadd));
                        this.f1153a.add(SearchActivity.this.f1123a.get(iadd).getId());
                        ArrayList<UsermanagerCards> arrayList = qb0.f4807b;
                        qb0.f4807b.remove(arrayList.get(arrayList.indexOf(SearchActivity.this.f1123a.get(iadd))));
                        if (qb0.f4807b.get(SearchActivity.this.c).getUptime_used() == null) {
                            qb0.c--;
                        } else {
                            qb0.b--;
                        }
                    }
                    publishProgress(new Integer[]{Integer.valueOf((int) ((((float) iadd) / ((float) ncoun)) * 100.0f))});
                    if (SearchActivity.this.f1127a) {
                        break;
                    }
                    iadd++;
                }
                SearchActivity.this.f1125a.B0(this.f1153a, 0);
                return null;
            } catch (Exception e) {
                try {
                    this.f1152a = e.getMessage();
                    this.f1154a = true;
                    return null;
                } catch (Exception e2) {
                    this.f1152a = e2.getMessage();
                    this.f1154a = true;
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void onProgressUpdate(Integer... values) {
            TextView textView = SearchActivity.this.f;
            textView.setText(values[0] + "%");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            SearchActivity.this.f1126a.a();
            try {
                if (this.f1154a) {
                    Toast.makeText(SearchActivity.this, this.f1152a, 0).show();
                }
                if (SearchActivity.this.f1131b.size() > 0) {
                    int del_count = 0;
                    for (int i = 0; i < SearchActivity.this.f1131b.size(); i++) {
                        SearchActivity searchActivity = SearchActivity.this;
                        searchActivity.f1123a.remove(searchActivity.f1131b.get(i));
                        del_count++;
                    }
                }
                if (qb0.f4807b.size() > 0) {
                    SearchActivity searchActivity2 = SearchActivity.this;
                    searchActivity2.f1137d.setText(searchActivity2.getString(R.string.cards_count, new Object[]{Integer.valueOf(qb0.f4807b.size())}));
                }
                SearchActivity.this.f1111a.clear();
                SearchActivity searchActivity3 = SearchActivity.this;
                searchActivity3.f1123a = searchActivity3.o();
                SearchActivity searchActivity4 = SearchActivity.this;
                SearchActivity searchActivity5 = SearchActivity.this;
                searchActivity4.f1111a = new ae(searchActivity5, searchActivity5.f1123a);
                SearchActivity searchActivity6 = SearchActivity.this;
                searchActivity6.f1115a.setAdapter(searchActivity6.f1111a);
                SearchActivity searchActivity7 = SearchActivity.this;
                searchActivity7.f1115a.setOnItemClickListener(searchActivity7);
                SearchActivity.this.f1131b.clear();
            } catch (Exception e) {
            }
        }
    }
}
