package com.blogspot.yemeninfo4it.mumsmobile_app.activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.DeleteUser;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.ProfileModel;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards;
import com.google.android.material.snackbar.Snackbar;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.HttpStatus;

public class DeleteUserActivity extends AppCompatActivity {
    public static String b = null;
    public static String c = null;
    public static String d = null;
    /* access modifiers changed from: private */
    public ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    Context f647a;

    /* renamed from: a  reason: collision with other field name */
    Button f648a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public CheckBox f649a;

    /* renamed from: a  reason: collision with other field name */
    LinearLayout f650a;

    /* renamed from: a  reason: collision with other field name */
    ListView f651a;

    /* renamed from: a  reason: collision with other field name */
    RadioButton f652a;

    /* renamed from: a  reason: collision with other field name */
    Spinner f653a;

    /* renamed from: a  reason: collision with other field name */
    TextView f654a;

    /* renamed from: a  reason: collision with other field name */
    m f655a;

    /* renamed from: a  reason: collision with other field name */
    j3 f656a;

    /* renamed from: a  reason: collision with other field name */
    String f657a = null;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<DeleteUser> f658a;

    /* renamed from: a  reason: collision with other field name */
    je f659a;

    /* renamed from: a  reason: collision with other field name */
    ue f660a;

    /* renamed from: a  reason: collision with other field name */
    zd f661a;

    /* renamed from: a  reason: collision with other field name */
    zf f662a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public boolean f663a = false;

    /* renamed from: b  reason: collision with other field name */
    Button f664b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public CheckBox f665b;

    /* renamed from: b  reason: collision with other field name */
    LinearLayout f666b;

    /* renamed from: b  reason: collision with other field name */
    ListView f667b;

    /* renamed from: b  reason: collision with other field name */
    RadioButton f668b;

    /* renamed from: b  reason: collision with other field name */
    Spinner f669b;

    /* renamed from: b  reason: collision with other field name */
    TextView f670b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public final ArrayList<DeleteUser> f671b = new ArrayList<>();

    /* renamed from: c  reason: collision with other field name */
    RadioButton f672c;

    /* renamed from: c  reason: collision with other field name */
    Spinner f673c;

    /* renamed from: c  reason: collision with other field name */
    TextView f674c;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with other field name */
    public final ArrayList<UsermanagerCards> f675c = new ArrayList<>();

    /* renamed from: d  reason: collision with other field name */
    TextView f676d;

    /* renamed from: d  reason: collision with other field name */
    ArrayList<UsermanagerCards> f677d = null;
    TextView e;

    /* renamed from: e  reason: collision with other field name */
    ArrayList<ProfileModel> f678e;
    TextView f;

    /* renamed from: f  reason: collision with other field name */
    ArrayList<UsermanagerCards> f679f;
    TextView g;
    TextView h;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.delete_user);
        try {
            this.f647a = this;
            this.f656a = qb0.d();
            this.f658a = new ArrayList<>();
            this.f660a = new ue(this.f647a);
            this.f677d = new ArrayList<>();
            this.f678e = new ArrayList<>();
            this.f679f = new ArrayList<>();
            this.f648a = (Button) findViewById(R.id.btn_delete_all);
            this.f654a = (TextView) findViewById(R.id.loadexpir);
            this.f649a = (CheckBox) findViewById(R.id.chk_select_all);
            this.f653a = (Spinner) findViewById(R.id.spinner_select);
            this.f651a = (ListView) findViewById(R.id.listView_deluser);
            this.f674c = (TextView) findViewById(R.id.countuser);
            this.e = (TextView) findViewById(R.id.deleted_count);
            this.f664b = (Button) findViewById(R.id.btn_delete_all2);
            this.f670b = (TextView) findViewById(R.id.loadexpir2);
            this.f667b = (ListView) findViewById(R.id.myCustomListView);
            this.f665b = (CheckBox) findViewById(R.id.chk_select_all2);
            this.f669b = (Spinner) findViewById(R.id.spinner_select2);
            this.f = (TextView) findViewById(R.id.countuser2);
            this.g = (TextView) findViewById(R.id.deleted_count2);
            this.f661a = new zd(this);
            this.a = new ProgressDialog(this);
            this.h = (TextView) this.f661a.b().findViewById(R.id.cancel_btn);
            this.f676d = (TextView) findViewById(R.id.header_text_title);
            this.f650a = (LinearLayout) findViewById(R.id.main_layout);
            this.f666b = (LinearLayout) findViewById(R.id.main_layout2);
            this.f673c = (Spinner) findViewById(R.id.profilename);
            this.f652a = (RadioButton) findViewById(R.id.validity_rad);
            this.f668b = (RadioButton) findViewById(R.id.tramit_rad);
            this.f672c = (RadioButton) findViewById(R.id.time_rad);
            TextView textView = (TextView) findViewById(R.id.header_text_title);
            this.f676d = textView;
            textView.setText("الكروت المنتهية يوزر مانجر");
            List<String> list1 = new ArrayList<>();
            list1.add("اختار البروفايل");
            if (qb0.p != null) {
                for (int i2 = 0; i2 < qb0.p.size(); i2++) {
                    list1.add(qb0.p.get(i2).getUname());
                }
                ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<>(this, R.layout.spinner_item, list1);
                dataAdapter1.setDropDownViewResource(R.layout.spinner_item);
                this.f673c.setAdapter(dataAdapter1);
            }
            this.h.setOnClickListener(new bg(this));
            this.f654a.setOnClickListener(new c());
            this.f670b.setOnClickListener(new d());
            this.f648a.setOnClickListener(new e());
            this.f664b.setOnClickListener(new f());
            this.f649a.setOnClickListener(new g());
            this.f665b.setOnClickListener(new h());
            this.f653a.setOnItemSelectedListener(new i());
            this.f673c.setOnItemSelectedListener(new j());
            this.f652a.setOnClickListener(new k());
            this.f668b.setOnClickListener(new a());
            this.f672c.setOnClickListener(new b());
        } catch (Exception e2) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v(View v) {
        this.f661a.a();
        this.f663a = true;
    }

    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View v) {
            DeleteUserActivity.this.x();
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        public void onClick(View v) {
            try {
                if (!DeleteUserActivity.this.f673c.getSelectedItem().toString().equals("اختار البروفايل")) {
                    DeleteUserActivity.this.g.setText("");
                    DeleteUserActivity.this.u();
                    return;
                }
                Toast.makeText(DeleteUserActivity.this, "الرجاء تحديد الباقة", 0).show();
            } catch (Exception e) {
            }
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        public void onClick(View v) {
            try {
                if (DeleteUserActivity.this.f658a.size() > 0) {
                    new AlertDialog.Builder(DeleteUserActivity.this).setIcon(17301543).setTitle("تنبية..!").setMessage("هل تريد حذف الكروت المنتهية التي قمت بتحديدها").setPositiveButton("نعم", new a()).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
                } else {
                    Toast.makeText(DeleteUserActivity.this.getApplicationContext(), "لا يوجد كروت منتهية", 0).show();
                }
            } catch (Exception e) {
                DeleteUserActivity deleteUserActivity = DeleteUserActivity.this;
                Toast.makeText(deleteUserActivity, e.getMessage() + "error", 0).show();
            }
        }

        class a implements DialogInterface.OnClickListener {
            a() {
            }

            public void onClick(DialogInterface dialog, int which) {
                boolean unused = DeleteUserActivity.this.f663a = false;
                DeleteUserActivity.this.f655a = new m();
                DeleteUserActivity.this.f655a.execute(new Void[0]);
            }
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        public void onClick(View v) {
            try {
                if (DeleteUserActivity.this.f679f.size() > 0) {
                    new AlertDialog.Builder(DeleteUserActivity.this).setIcon(17301543).setTitle("تنبية..!").setMessage("هل تريد حذف الكروت المنتهية التي قمت بتحديدها").setPositiveButton("نعم", new a()).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
                } else {
                    Toast.makeText(DeleteUserActivity.this.getApplicationContext(), "لا يوجد كروت منتهية", 0).show();
                }
            } catch (Exception e) {
                DeleteUserActivity deleteUserActivity = DeleteUserActivity.this;
                Toast.makeText(deleteUserActivity, e.getMessage() + "error", 0).show();
            }
        }

        class a implements DialogInterface.OnClickListener {
            a() {
            }

            public void onClick(DialogInterface dialog, int which) {
                boolean unused = DeleteUserActivity.this.f663a = false;
                new l().execute(new Void[0]);
            }
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        public void onClick(View v) {
            try {
                if (DeleteUserActivity.this.f658a.size() > 0) {
                    if (DeleteUserActivity.this.f649a.isChecked()) {
                        Iterator it = DeleteUserActivity.this.f658a.iterator();
                        while (it.hasNext()) {
                            ((DeleteUser) it.next()).setSelected(true);
                        }
                    } else {
                        Iterator it2 = DeleteUserActivity.this.f658a.iterator();
                        while (it2.hasNext()) {
                            ((DeleteUser) it2.next()).setSelected(false);
                        }
                    }
                    DeleteUserActivity.this.f662a.notifyDataSetChanged();
                    return;
                }
                Snackbar.k0(v, "لا توجد سجلات للتحديد", 0).V();
            } catch (Exception e) {
                DeleteUserActivity deleteUserActivity = DeleteUserActivity.this;
                Toast.makeText(deleteUserActivity, e.getMessage() + "error", 0).show();
            }
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        public void onClick(View v) {
            try {
                if (DeleteUserActivity.this.f679f.size() > 0) {
                    if (DeleteUserActivity.this.f665b.isChecked()) {
                        Iterator<UsermanagerCards> it = DeleteUserActivity.this.f679f.iterator();
                        while (it.hasNext()) {
                            it.next().setSelected(true);
                        }
                    } else {
                        Iterator<UsermanagerCards> it2 = DeleteUserActivity.this.f679f.iterator();
                        while (it2.hasNext()) {
                            it2.next().setSelected(false);
                        }
                    }
                    DeleteUserActivity.this.f659a.notifyDataSetChanged();
                    return;
                }
                Snackbar.k0(v, "لا توجد سجلات للتحديد", -1).V();
            } catch (Exception e) {
                DeleteUserActivity deleteUserActivity = DeleteUserActivity.this;
                Toast.makeText(deleteUserActivity, e.getMessage() + "error", 0).show();
            }
        }
    }

    class i implements AdapterView.OnItemSelectedListener {
        i() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            try {
                Object item = adapterView.getItemAtPosition(position);
                if (!item.toString().equals("عدد السجلات للتحديد")) {
                    int i = 1;
                    int s = DeleteUserActivity.this.t(item.toString());
                    if (DeleteUserActivity.this.f658a.size() > 0) {
                        Iterator it = DeleteUserActivity.this.f658a.iterator();
                        while (it.hasNext()) {
                            DeleteUser model = (DeleteUser) it.next();
                            if (i <= s) {
                                model.setSelected(true);
                            } else {
                                model.setSelected(false);
                            }
                            i++;
                        }
                        DeleteUserActivity.this.f662a.notifyDataSetChanged();
                    }
                }
            } catch (Exception e) {
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class j implements AdapterView.OnItemSelectedListener {
        j() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            try {
                Object item = adapterView.getItemAtPosition(position);
                if (!item.toString().equals("اختار البروفايل")) {
                    DeleteUserActivity.this.f657a = item.toString();
                    List<Map<String, Object>> strList = qb0.f(DeleteUserActivity.this.f657a);
                    if (strList.size() > 0) {
                        DeleteUserActivity.c = (String) strList.get(0).get("transmit_limit");
                        DeleteUserActivity.b = (String) strList.get(0).get("time_limit");
                        DeleteUserActivity.d = (String) strList.get(0).get("download_limit");
                        DeleteUserActivity.this.w();
                        return;
                    }
                    DeleteUserActivity deleteUserActivity = DeleteUserActivity.this;
                    new n(deleteUserActivity.f657a).execute(new String[0]);
                }
            } catch (Exception e) {
                Toast.makeText(DeleteUserActivity.this, e.getMessage(), 0).show();
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class k implements View.OnClickListener {
        k() {
        }

        public void onClick(View v) {
            DeleteUserActivity.this.f652a.setChecked(true);
            DeleteUserActivity.this.f668b.setChecked(false);
            DeleteUserActivity.this.f672c.setChecked(false);
            DeleteUserActivity.this.f650a.setVisibility(0);
            DeleteUserActivity.this.f666b.setVisibility(8);
            DeleteUserActivity.this.f668b.setTextColor(Color.parseColor("#25536e"));
            DeleteUserActivity.this.f652a.setTextColor(Color.parseColor("#ffffff"));
            DeleteUserActivity.this.f672c.setTextColor(Color.parseColor("#25536e"));
            if (DeleteUserActivity.this.f658a.size() < 1) {
                DeleteUserActivity.this.x();
            }
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View v) {
            DeleteUserActivity.this.f652a.setChecked(false);
            DeleteUserActivity.this.f668b.setChecked(true);
            DeleteUserActivity.this.f672c.setChecked(false);
            DeleteUserActivity.this.f666b.setVisibility(0);
            DeleteUserActivity.this.f650a.setVisibility(8);
            DeleteUserActivity.this.f668b.setTextColor(Color.parseColor("#ffffff"));
            DeleteUserActivity.this.f652a.setTextColor(Color.parseColor("#25536e"));
            DeleteUserActivity.this.f672c.setTextColor(Color.parseColor("#25536e"));
            DeleteUserActivity deleteUserActivity = DeleteUserActivity.this;
            if (deleteUserActivity.f657a != null) {
                deleteUserActivity.w();
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View v) {
            DeleteUserActivity.this.f672c.setChecked(true);
            DeleteUserActivity.this.f652a.setChecked(false);
            DeleteUserActivity.this.f668b.setChecked(false);
            DeleteUserActivity.this.f666b.setVisibility(0);
            DeleteUserActivity.this.f650a.setVisibility(8);
            DeleteUserActivity.this.f668b.setTextColor(Color.parseColor("#25536e"));
            DeleteUserActivity.this.f652a.setTextColor(Color.parseColor("#25536e"));
            DeleteUserActivity.this.f672c.setTextColor(Color.parseColor("#ffffff"));
            DeleteUserActivity deleteUserActivity = DeleteUserActivity.this;
            if (deleteUserActivity.f657a != null) {
                deleteUserActivity.w();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void w() {
        String str;
        try {
            this.f679f.clear();
            this.f665b.setChecked(false);
            if (this.f668b.isChecked()) {
                String str2 = c;
                if (str2 != null && !str2.equals("0")) {
                    u();
                }
            } else if (this.f672c.isChecked() && (str = b) != null && !str.equals("0s")) {
                u();
            }
        } catch (Exception e2) {
            Toast.makeText(this, e2.getMessage() + "error", 0).show();
        }
    }

    /* access modifiers changed from: package-private */
    public void x() {
        try {
            ArrayList<DeleteUser> arrayList = qb0.r;
            if (arrayList == null) {
                Toast.makeText(this, "لا توجد كروت منتهية او لم يتم تحميل الكروت من اليوزر مانجر", 0).show();
            } else if (arrayList.size() > 0) {
                this.f658a = qb0.r;
                zf zfVar = new zf(this, this.f658a);
                this.f662a = zfVar;
                this.f651a.setAdapter(zfVar);
                y();
                TextView textView = this.f674c;
                textView.setText("عدد الكروت المنتهية: " + this.f658a.size());
            } else {
                Toast.makeText(this, "لا توجد كروت منتهية", 0).show();
            }
        } catch (Exception e2) {
            Toast.makeText(this, e2.getMessage() + "error", 0).show();
        }
    }

    /* access modifiers changed from: package-private */
    public void u() {
        DecimalFormat df = (DecimalFormat) NumberFormat.getNumberInstance(Locale.ENGLISH);
        df.applyPattern("#.##");
        ArrayList<UsermanagerCards> arrayList = qb0.f4807b;
        if (arrayList == null) {
            Toast.makeText(this, "لا توجد كروت منتهية او لم يتم تحميل الكروت من اليوزر مانجر", 0).show();
        } else if (arrayList.size() > 0) {
            try {
                qb0.j();
            } catch (Exception e2) {
            }
            if (this.f668b.isChecked()) {
                this.f679f.clear();
                for (int i2 = 0; i2 < qb0.f4807b.size(); i2++) {
                    if (!(qb0.f4807b.get(i2).getUpload_used() == null || qb0.f4807b.get(i2).getDownload_used() == null)) {
                        double t = Double.parseDouble(c) / 1048576.0d;
                        double aa = Double.parseDouble(df.format(Double.parseDouble(qb0.f4807b.get(i2).getDownload_used()) / 1048576.0d)) + Double.parseDouble(df.format(Double.parseDouble(qb0.f4807b.get(i2).getUpload_used()) / 1048576.0d));
                        if (qb0.f4807b.get(i2).getProfilename().equals(this.f673c.getSelectedItem().toString()) && aa == Double.parseDouble(df.format(t))) {
                            this.f679f.add(qb0.f4807b.get(i2));
                        }
                    }
                }
                je jeVar = new je(this, this.f679f);
                this.f659a = jeVar;
                this.f667b.setAdapter(jeVar);
                TextView textView = this.f;
                textView.setText("عدد الكروت منتهية التحميل: " + this.f679f.size());
            } else if (this.f672c.isChecked()) {
                this.f679f.clear();
                for (int i3 = 0; i3 < qb0.f4807b.size(); i3++) {
                    if (qb0.f4807b.get(i3).getUptime_used() != null && qb0.f4807b.get(i3).getProfilename().equals(this.f673c.getSelectedItem().toString()) && qb0.f4807b.get(i3).getUptime_used().equals(b)) {
                        this.f679f.add(qb0.f4807b.get(i3));
                    }
                }
                je jeVar2 = new je(this, this.f679f);
                this.f659a = jeVar2;
                this.f667b.setAdapter(jeVar2);
                TextView textView2 = this.f;
                textView2.setText("عدد الكروت منتهية الوقت: " + this.f679f.size());
            }
        } else {
            Toast.makeText(this, "لا توجد كروت منتهية", 0).show();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        try {
            qb0.j();
        } catch (Exception e2) {
        }
        i40.e(this);
    }

    public void y() {
        try {
            ArrayList<DeleteUser> arrayList = qb0.r;
            if (arrayList == null) {
                this.f653a.setVisibility(8);
            } else if (arrayList.size() >= 200) {
                this.f653a.setVisibility(0);
                List<String> list2 = new ArrayList<>();
                list2.add("عدد السجلات للتحديد");
                list2.add("تحديد 50 كرت");
                list2.add("تحديد 100 كرت");
                list2.add("تحديد 200 كرت");
                list2.add("تحديد 500 كرت");
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, 17367048, list2);
                dataAdapter.setDropDownViewResource(17367049);
                this.f653a.setAdapter(dataAdapter);
            } else {
                this.f653a.setVisibility(8);
            }
        } catch (Exception e2) {
        }
    }

    public int t(String a2) {
        try {
            if (a2.equals("تحديد 50 كرت")) {
                return 50;
            }
            if (a2.equals("تحديد 100 كرت")) {
                return 100;
            }
            if (a2.equals("تحديد 200 كرت")) {
                return 200;
            }
            if (a2.equals("تحديد 500 كرت")) {
                return HttpStatus.SC_INTERNAL_SERVER_ERROR;
            }
            return 0;
        } catch (Exception e2) {
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(jv0.b(newBase));
    }

    class m extends AsyncTask<Void, Void, String> {

        /* renamed from: a  reason: collision with other field name */
        String f682a = "";

        /* renamed from: a  reason: collision with other field name */
        List<String> f683a = new ArrayList();

        /* renamed from: a  reason: collision with other field name */
        boolean f684a = false;

        m() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            DeleteUserActivity.this.f661a.c("جاري حذف الكروت المنتهية");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Void... params) {
            try {
                int ncoun = DeleteUserActivity.this.f658a.size();
                if (DeleteUserActivity.this.f658a.size() <= 0) {
                    return null;
                }
                int version = qb0.f4798a.getVersion() != null ? Integer.parseInt(qb0.f4798a.getVersion().substring(0, 1)) : 6;
                int iadd = 0;
                while (true) {
                    if (iadd >= ncoun) {
                        break;
                    } else if (DeleteUserActivity.this.f663a) {
                        break;
                    } else {
                        if (((DeleteUser) DeleteUserActivity.this.f658a.get(iadd)).isSelected()) {
                            if (version >= 7) {
                                j3 j3Var = DeleteUserActivity.this.f656a;
                                j3Var.q("/user-manager/user/remove numbers=" + ((DeleteUser) DeleteUserActivity.this.f658a.get(iadd)).getId() + "");
                            } else {
                                j3 j3Var2 = DeleteUserActivity.this.f656a;
                                j3Var2.q("/tool/user-manager/user/remove .id=" + ((DeleteUser) DeleteUserActivity.this.f658a.get(iadd)).getId() + "");
                            }
                            DeleteUserActivity.this.f671b.add((DeleteUser) DeleteUserActivity.this.f658a.get(iadd));
                            this.f683a.add(((DeleteUser) DeleteUserActivity.this.f658a.get(iadd)).getId());
                        }
                        iadd++;
                    }
                }
                DeleteUserActivity.this.f660a.B0(this.f683a, 0);
                return null;
            } catch (Exception e) {
                try {
                    this.f682a = e.getMessage();
                    this.f684a = true;
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.f682a = e2.getMessage();
                    this.f684a = true;
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            DeleteUserActivity.this.f661a.a();
            try {
                if (this.f684a) {
                    Toast.makeText(DeleteUserActivity.this.f647a, this.f682a, 0).show();
                }
                if (DeleteUserActivity.this.f671b.size() > 0) {
                    int del_count = 0;
                    for (int i = 0; i < DeleteUserActivity.this.f671b.size(); i++) {
                        DeleteUserActivity.this.f658a.remove(DeleteUserActivity.this.f671b.get(i));
                        qb0.r.remove(DeleteUserActivity.this.f671b.get(i));
                        del_count++;
                    }
                    TextView textView = DeleteUserActivity.this.e;
                    textView.setText(" تم حذف :" + del_count + " كرت ");
                }
                ArrayList<DeleteUser> arrayList = qb0.r;
                if (arrayList != null) {
                    ArrayList unused = DeleteUserActivity.this.f658a = arrayList;
                    TextView textView2 = DeleteUserActivity.this.f674c;
                    textView2.setText("عدد الكروت المنتهية: " + DeleteUserActivity.this.f658a.size());
                    DeleteUserActivity deleteUserActivity = DeleteUserActivity.this;
                    DeleteUserActivity deleteUserActivity2 = DeleteUserActivity.this;
                    deleteUserActivity.f662a = new zf(deleteUserActivity2, deleteUserActivity2.f658a);
                    DeleteUserActivity deleteUserActivity3 = DeleteUserActivity.this;
                    deleteUserActivity3.f651a.setAdapter(deleteUserActivity3.f662a);
                    if (qb0.r.size() > 0) {
                        DeleteUserActivity.this.y();
                    }
                } else {
                    DeleteUserActivity.this.f674c.setText("عدد الكروت المنتهية: 0");
                }
                DeleteUserActivity.this.f671b.clear();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(DeleteUserActivity.this, e.getMessage(), 0).show();
            }
        }
    }

    class l extends AsyncTask<Void, Void, String> {

        /* renamed from: a  reason: collision with other field name */
        String f680a = "";

        /* renamed from: a  reason: collision with other field name */
        boolean f681a = false;

        l() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            DeleteUserActivity.this.f661a.c("جاري حذف الكروت المنتهية");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Void... params) {
            try {
                int ncoun = DeleteUserActivity.this.f679f.size();
                int version = qb0.f4798a.getVersion() != null ? Integer.parseInt(qb0.f4798a.getVersion().substring(0, 1)) : 6;
                if (DeleteUserActivity.this.f679f.size() <= 0) {
                    return null;
                }
                for (int iadd = 0; iadd < ncoun; iadd++) {
                    if (DeleteUserActivity.this.f663a) {
                        return null;
                    }
                    if (DeleteUserActivity.this.f679f.get(iadd).isSelected()) {
                        if (version >= 7) {
                            j3 j3Var = DeleteUserActivity.this.f656a;
                            j3Var.q("/user-manager/user/remove numbers=" + DeleteUserActivity.this.f679f.get(iadd).getId() + "");
                        } else {
                            j3 j3Var2 = DeleteUserActivity.this.f656a;
                            j3Var2.q("/tool/user-manager/user/remove .id=" + DeleteUserActivity.this.f679f.get(iadd).getId() + "");
                        }
                        DeleteUserActivity.this.f675c.add(DeleteUserActivity.this.f679f.get(iadd));
                    }
                }
                return null;
            } catch (Exception e) {
                try {
                    this.f680a = e.getMessage();
                    this.f681a = true;
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.f680a = e2.getMessage();
                    this.f681a = true;
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            DeleteUserActivity.this.f661a.a();
            try {
                if (this.f681a) {
                    Toast.makeText(DeleteUserActivity.this.f647a, this.f680a, 0).show();
                }
                if (DeleteUserActivity.this.f675c.size() > 0) {
                    int del_count = 0;
                    for (int i = 0; i < DeleteUserActivity.this.f675c.size(); i++) {
                        DeleteUserActivity deleteUserActivity = DeleteUserActivity.this;
                        ArrayList<UsermanagerCards> arrayList = deleteUserActivity.f679f;
                        ArrayList<UsermanagerCards> arrayList2 = qb0.f4807b;
                        arrayList2.remove(arrayList2.indexOf(arrayList.get(arrayList.indexOf(deleteUserActivity.f675c.get(i)))));
                        qb0.b--;
                        del_count++;
                    }
                    DeleteUserActivity.this.g.setText(" تم حذف :" + del_count + " كرت ");
                    DeleteUserActivity.this.w();
                }
                DeleteUserActivity.this.f675c.clear();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(DeleteUserActivity.this, e.getMessage(), 0).show();
            }
        }
    }

    class n extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        String f685a;

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f686a = null;

        /* renamed from: a  reason: collision with other field name */
        boolean f687a = false;
        String b = "";

        /* renamed from: b  reason: collision with other field name */
        List<Map<String, String>> f688b = null;

        public n(String task_selected_profile) {
            this.f685a = task_selected_profile;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            DeleteUserActivity.this.a.setTitle("يرجى الانتظار..");
            DeleteUserActivity.this.a.setMessage("جاري جلب البيانات");
            DeleteUserActivity.this.a.setCancelable(false);
            DeleteUserActivity.this.a.setIndeterminate(false);
            DeleteUserActivity.this.a.show();
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v28, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v50, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.lang.String} */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r17) {
            /*
                r16 = this;
                r1 = r16
                r2 = 0
                r3 = 1
                com.blogspot.yemeninfo4it.mumsmobile_app.activities.DeleteUserActivity r0 = com.blogspot.yemeninfo4it.mumsmobile_app.activities.DeleteUserActivity.this     // Catch:{ Exception -> 0x0188 }
                j3 r0 = r0.f656a     // Catch:{ Exception -> 0x0188 }
                boolean r0 = r0.w()     // Catch:{ Exception -> 0x0188 }
                if (r0 == 0) goto L_0x0187
                com.blogspot.yemeninfo4it.mumsmobile_app.model.Interface r0 = defpackage.qb0.f4798a     // Catch:{ Exception -> 0x0188 }
                java.lang.String r0 = r0.getVersion()     // Catch:{ Exception -> 0x0188 }
                r4 = 0
                if (r0 == 0) goto L_0x0026
                com.blogspot.yemeninfo4it.mumsmobile_app.model.Interface r0 = defpackage.qb0.f4798a     // Catch:{ Exception -> 0x0188 }
                java.lang.String r0 = r0.getVersion()     // Catch:{ Exception -> 0x0188 }
                java.lang.String r0 = r0.substring(r4, r3)     // Catch:{ Exception -> 0x0188 }
                int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0188 }
                goto L_0x0027
            L_0x0026:
                r0 = 6
            L_0x0027:
                r5 = 7
                java.lang.String r6 = "uptime-limit"
                java.lang.String r7 = "0"
                java.lang.String r8 = "' return .id,transfer-limit,uptime-limit,download-limit"
                java.lang.String r9 = "ODAIData"
                java.lang.String r10 = "limitation"
                java.lang.String r11 = "' return limitation"
                java.lang.String r12 = ""
                java.lang.String r13 = "download-limit"
                java.lang.String r14 = "transfer-limit"
                if (r0 < r5) goto L_0x00e1
                r5 = r12
                com.blogspot.yemeninfo4it.mumsmobile_app.activities.DeleteUserActivity r12 = com.blogspot.yemeninfo4it.mumsmobile_app.activities.DeleteUserActivity.this     // Catch:{ Exception -> 0x0188 }
                j3 r12 = r12.f656a     // Catch:{ Exception -> 0x0188 }
                java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0188 }
                r15.<init>()     // Catch:{ Exception -> 0x0188 }
                java.lang.String r3 = "/user-manager/profile-limitation/print where profile='"
                r15.append(r3)     // Catch:{ Exception -> 0x0188 }
                java.lang.String r3 = r1.f685a     // Catch:{ Exception -> 0x0188 }
                r15.append(r3)     // Catch:{ Exception -> 0x0188 }
                r15.append(r11)     // Catch:{ Exception -> 0x0188 }
                java.lang.String r3 = r15.toString()     // Catch:{ Exception -> 0x0188 }
                java.util.List r3 = r12.q(r3)     // Catch:{ Exception -> 0x0188 }
                r1.f686a = r3     // Catch:{ Exception -> 0x0188 }
                java.lang.Object r3 = r3.get(r4)     // Catch:{ Exception -> 0x0188 }
                java.util.Map r3 = (java.util.Map) r3     // Catch:{ Exception -> 0x0188 }
                java.lang.Object r3 = r3.get(r10)     // Catch:{ Exception -> 0x0188 }
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0188 }
                android.util.Log.d(r9, r3)     // Catch:{ Exception -> 0x0188 }
                com.blogspot.yemeninfo4it.mumsmobile_app.activities.DeleteUserActivity r5 = com.blogspot.yemeninfo4it.mumsmobile_app.activities.DeleteUserActivity.this     // Catch:{ Exception -> 0x0188 }
                j3 r5 = r5.f656a     // Catch:{ Exception -> 0x0188 }
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0188 }
                r9.<init>()     // Catch:{ Exception -> 0x0188 }
                java.lang.String r10 = "/user-manager/limitation/print where name='"
                r9.append(r10)     // Catch:{ Exception -> 0x0188 }
                r9.append(r3)     // Catch:{ Exception -> 0x0188 }
                r9.append(r8)     // Catch:{ Exception -> 0x0188 }
                java.lang.String r8 = r9.toString()     // Catch:{ Exception -> 0x0188 }
                java.util.List r5 = r5.q(r8)     // Catch:{ Exception -> 0x0188 }
                r1.f688b = r5     // Catch:{ Exception -> 0x0188 }
                java.lang.Object r5 = r5.get(r4)     // Catch:{ Exception -> 0x0188 }
                java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x0188 }
                java.lang.Object r5 = r5.get(r14)     // Catch:{ Exception -> 0x0188 }
                if (r5 != 0) goto L_0x0097
                goto L_0x00a6
            L_0x0097:
                java.util.List<java.util.Map<java.lang.String, java.lang.String>> r5 = r1.f688b     // Catch:{ Exception -> 0x0188 }
                java.lang.Object r5 = r5.get(r4)     // Catch:{ Exception -> 0x0188 }
                java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x0188 }
                java.lang.Object r5 = r5.get(r14)     // Catch:{ Exception -> 0x0188 }
                r7 = r5
                java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0188 }
            L_0x00a6:
                com.blogspot.yemeninfo4it.mumsmobile_app.activities.DeleteUserActivity.c = r7     // Catch:{ Exception -> 0x0188 }
                java.util.List<java.util.Map<java.lang.String, java.lang.String>> r5 = r1.f688b     // Catch:{ Exception -> 0x0188 }
                java.lang.Object r5 = r5.get(r4)     // Catch:{ Exception -> 0x0188 }
                java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x0188 }
                java.lang.Object r5 = r5.get(r6)     // Catch:{ Exception -> 0x0188 }
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0188 }
                com.blogspot.yemeninfo4it.mumsmobile_app.activities.DeleteUserActivity.b = r5     // Catch:{ Exception -> 0x0188 }
                java.util.List<java.util.Map<java.lang.String, java.lang.String>> r5 = r1.f688b     // Catch:{ Exception -> 0x0188 }
                java.lang.Object r5 = r5.get(r4)     // Catch:{ Exception -> 0x0188 }
                java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x0188 }
                java.lang.Object r5 = r5.get(r13)     // Catch:{ Exception -> 0x0188 }
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0188 }
                com.blogspot.yemeninfo4it.mumsmobile_app.activities.DeleteUserActivity.d = r5     // Catch:{ Exception -> 0x0188 }
                java.lang.String r5 = r1.f685a     // Catch:{ Exception -> 0x0188 }
                java.lang.String r6 = com.blogspot.yemeninfo4it.mumsmobile_app.activities.DeleteUserActivity.c     // Catch:{ Exception -> 0x0188 }
                java.lang.String r7 = com.blogspot.yemeninfo4it.mumsmobile_app.activities.DeleteUserActivity.b     // Catch:{ Exception -> 0x0188 }
                java.util.List<java.util.Map<java.lang.String, java.lang.String>> r8 = r1.f688b     // Catch:{ Exception -> 0x0188 }
                java.lang.Object r4 = r8.get(r4)     // Catch:{ Exception -> 0x0188 }
                java.util.Map r4 = (java.util.Map) r4     // Catch:{ Exception -> 0x0188 }
                java.lang.Object r4 = r4.get(r13)     // Catch:{ Exception -> 0x0188 }
                java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0188 }
                defpackage.qb0.g(r5, r6, r7, r4)     // Catch:{ Exception -> 0x0188 }
                goto L_0x0185
            L_0x00e1:
                r3 = r12
                com.blogspot.yemeninfo4it.mumsmobile_app.activities.DeleteUserActivity r5 = com.blogspot.yemeninfo4it.mumsmobile_app.activities.DeleteUserActivity.this     // Catch:{ Exception -> 0x0188 }
                j3 r5 = r5.f656a     // Catch:{ Exception -> 0x0188 }
                java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0188 }
                r12.<init>()     // Catch:{ Exception -> 0x0188 }
                java.lang.String r15 = "/tool/user-manager/profile/profile-limitation/print where profile='"
                r12.append(r15)     // Catch:{ Exception -> 0x0188 }
                java.lang.String r15 = r1.f685a     // Catch:{ Exception -> 0x0188 }
                r12.append(r15)     // Catch:{ Exception -> 0x0188 }
                r12.append(r11)     // Catch:{ Exception -> 0x0188 }
                java.lang.String r11 = r12.toString()     // Catch:{ Exception -> 0x0188 }
                java.util.List r5 = r5.q(r11)     // Catch:{ Exception -> 0x0188 }
                r1.f686a = r5     // Catch:{ Exception -> 0x0188 }
                java.lang.Object r5 = r5.get(r4)     // Catch:{ Exception -> 0x0188 }
                java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x0188 }
                java.lang.Object r5 = r5.get(r10)     // Catch:{ Exception -> 0x0188 }
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0188 }
                r3 = r5
                android.util.Log.d(r9, r3)     // Catch:{ Exception -> 0x0188 }
                com.blogspot.yemeninfo4it.mumsmobile_app.activities.DeleteUserActivity r5 = com.blogspot.yemeninfo4it.mumsmobile_app.activities.DeleteUserActivity.this     // Catch:{ Exception -> 0x0188 }
                j3 r5 = r5.f656a     // Catch:{ Exception -> 0x0188 }
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0188 }
                r9.<init>()     // Catch:{ Exception -> 0x0188 }
                java.lang.String r10 = "/tool/user-manager/profile/limitation/print where name='"
                r9.append(r10)     // Catch:{ Exception -> 0x0188 }
                r9.append(r3)     // Catch:{ Exception -> 0x0188 }
                r9.append(r8)     // Catch:{ Exception -> 0x0188 }
                java.lang.String r8 = r9.toString()     // Catch:{ Exception -> 0x0188 }
                java.util.List r5 = r5.q(r8)     // Catch:{ Exception -> 0x0188 }
                r1.f688b = r5     // Catch:{ Exception -> 0x0188 }
                java.lang.Object r5 = r5.get(r4)     // Catch:{ Exception -> 0x0188 }
                java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x0188 }
                java.lang.Object r5 = r5.get(r14)     // Catch:{ Exception -> 0x0188 }
                if (r5 != 0) goto L_0x013d
                goto L_0x014c
            L_0x013d:
                java.util.List<java.util.Map<java.lang.String, java.lang.String>> r5 = r1.f688b     // Catch:{ Exception -> 0x0188 }
                java.lang.Object r5 = r5.get(r4)     // Catch:{ Exception -> 0x0188 }
                java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x0188 }
                java.lang.Object r5 = r5.get(r14)     // Catch:{ Exception -> 0x0188 }
                r7 = r5
                java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0188 }
            L_0x014c:
                com.blogspot.yemeninfo4it.mumsmobile_app.activities.DeleteUserActivity.c = r7     // Catch:{ Exception -> 0x0188 }
                java.util.List<java.util.Map<java.lang.String, java.lang.String>> r5 = r1.f688b     // Catch:{ Exception -> 0x0188 }
                java.lang.Object r5 = r5.get(r4)     // Catch:{ Exception -> 0x0188 }
                java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x0188 }
                java.lang.Object r5 = r5.get(r6)     // Catch:{ Exception -> 0x0188 }
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0188 }
                com.blogspot.yemeninfo4it.mumsmobile_app.activities.DeleteUserActivity.b = r5     // Catch:{ Exception -> 0x0188 }
                java.util.List<java.util.Map<java.lang.String, java.lang.String>> r5 = r1.f688b     // Catch:{ Exception -> 0x0188 }
                java.lang.Object r5 = r5.get(r4)     // Catch:{ Exception -> 0x0188 }
                java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x0188 }
                java.lang.Object r5 = r5.get(r13)     // Catch:{ Exception -> 0x0188 }
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0188 }
                com.blogspot.yemeninfo4it.mumsmobile_app.activities.DeleteUserActivity.d = r5     // Catch:{ Exception -> 0x0188 }
                java.lang.String r5 = r1.f685a     // Catch:{ Exception -> 0x0188 }
                java.lang.String r6 = com.blogspot.yemeninfo4it.mumsmobile_app.activities.DeleteUserActivity.c     // Catch:{ Exception -> 0x0188 }
                java.lang.String r7 = com.blogspot.yemeninfo4it.mumsmobile_app.activities.DeleteUserActivity.b     // Catch:{ Exception -> 0x0188 }
                java.util.List<java.util.Map<java.lang.String, java.lang.String>> r8 = r1.f688b     // Catch:{ Exception -> 0x0188 }
                java.lang.Object r4 = r8.get(r4)     // Catch:{ Exception -> 0x0188 }
                java.util.Map r4 = (java.util.Map) r4     // Catch:{ Exception -> 0x0188 }
                java.lang.Object r4 = r4.get(r13)     // Catch:{ Exception -> 0x0188 }
                java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0188 }
                defpackage.qb0.g(r5, r6, r7, r4)     // Catch:{ Exception -> 0x0188 }
            L_0x0185:
                goto L_0x0192
            L_0x0187:
                return r2
            L_0x0188:
                r0 = move-exception
                java.lang.String r3 = r0.getMessage()     // Catch:{ Exception -> 0x0193 }
                r1.b = r3     // Catch:{ Exception -> 0x0193 }
                r3 = 1
                r1.f687a = r3     // Catch:{ Exception -> 0x0193 }
            L_0x0192:
                goto L_0x019d
            L_0x0193:
                r0 = move-exception
                java.lang.String r3 = r0.getMessage()
                r1.b = r3
                r3 = 1
                r1.f687a = r3
            L_0x019d:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blogspot.yemeninfo4it.mumsmobile_app.activities.DeleteUserActivity.n.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            DeleteUserActivity.this.a.dismiss();
            try {
                if (this.f687a) {
                    Toast.makeText(DeleteUserActivity.this.f647a, this.b, 0).show();
                } else {
                    DeleteUserActivity.this.w();
                }
            } catch (Exception e) {
                e.printStackTrace();
                Context context = DeleteUserActivity.this.f647a;
                Toast.makeText(context, this.b + e.getMessage(), 0).show();
            }
        }
    }
}
