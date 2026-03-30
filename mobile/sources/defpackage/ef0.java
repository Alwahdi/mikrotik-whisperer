package defpackage;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.MainFragment;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: ef0  reason: default package */
public class ef0 extends PopupMenu implements PopupMenu.OnMenuItemClickListener {
    int a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f2906a;

    /* renamed from: a  reason: collision with other field name */
    Context f2907a;

    /* renamed from: a  reason: collision with other field name */
    List<String> f2908a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    public or f2909a;
    List<String> b = new ArrayList();

    public ef0(RecyclerView.ViewHolder viewHolder, or tableView) {
        super(viewHolder.itemView.getContext(), viewHolder.itemView);
        this.f2909a = tableView;
        this.f2907a = viewHolder.itemView.getContext();
        this.a = viewHolder.getAdapterPosition();
        c();
    }

    private void c() {
        b();
        setOnMenuItemClickListener(this);
    }

    /* renamed from: ef0$d */
    class d extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f2911a = null;

        d() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            ef0.this.f2906a.setTitle("يرجى الانتظار");
            ef0.this.f2906a.setMessage("جاري تنفيذ العملية");
            ef0.this.f2906a.setCancelable(false);
            ef0.this.f2906a.show();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                j3 con = j3.c(qb0.f4797a.getIp(), Integer.valueOf(Integer.parseInt(qb0.f4797a.getPort())));
                con.C(qb0.f4797a.getUname(), qb0.f4797a.getPass(), true);
                con.w();
                con.q("/tool/user-manager/user/create-and-activate-profile numbers=" + qb0.f4807b.get(qb0.a).getUname().toString() + " profile=" + qb0.f4806b + " customer=" + qb0.f4810c + "");
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
            ef0.this.f2906a.dismiss();
        }
    }

    /* renamed from: ef0$e */
    class e extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f2912a = null;

        e() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            ef0.this.f2906a.setTitle("يرجى الانتظار");
            ef0.this.f2906a.setMessage("جاري تنفيذ العملية");
            ef0.this.f2906a.setCancelable(false);
            ef0.this.f2906a.show();
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
            ef0.this.f2906a.dismiss();
        }
    }

    private void b() {
        getMenu().add(0, 1, 10, qb0.f4807b.get(qb0.a).getUname());
        getMenu().add(0, 1, 0, "حذف المستخدم");
        getMenu().add(0, 2, 1, "اضافة باقة");
        getMenu().add(0, 3, 2, "تعطيل");
    }

    public void d() {
        try {
            this.f2908a.add("اختر الباقة");
            for (int i = 0; i < qb0.p.size(); i++) {
                this.f2908a.add(qb0.p.get(i).getUname());
            }
            for (int i2 = 0; i2 < qb0.q.size(); i2++) {
                this.b.add(qb0.q.get(i2).getUname());
            }
            MainFragment mm = new MainFragment();
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this.f2907a);
            View myView = mm.getLayoutInflater().inflate(R.layout.feedback_popup, (ViewGroup) null);
            dialogBuilder.setView(myView);
            Spinner profilelist = (Spinner) myView.findViewById(R.id.profilelist);
            Spinner customerlist = (Spinner) myView.findViewById(R.id.customerlist);
            TextView textView = (TextView) myView.findViewById(R.id.addtonametxt);
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this.f2907a, 17367048, this.f2908a);
            dataAdapter.setDropDownViewResource(17367049);
            profilelist.setAdapter(dataAdapter);
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<>(this.f2907a, 17367048, this.b);
            dataAdapter2.setDropDownViewResource(17367049);
            customerlist.setAdapter(dataAdapter2);
            AlertDialog b2 = dialogBuilder.create();
            qb0.f4810c = customerlist.getSelectedItem().toString();
            qb0.f4810c = customerlist.getSelectedItem().toString();
            b2.show();
            profilelist.setOnItemSelectedListener(new a());
            customerlist.setOnItemSelectedListener(new b());
            ((Button) myView.findViewById(R.id.addprofiletouser)).setOnClickListener(new c(profilelist));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: ef0$a */
    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            Object item = adapterView.getItemAtPosition(position);
            qb0.f4806b = item.toString();
            qb0.f4806b = item.toString();
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: ef0$b */
    class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            qb0.f4810c = adapterView.getItemAtPosition(position).toString();
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: ef0$c */
    class c implements View.OnClickListener {
        final /* synthetic */ Spinner a;

        c(Spinner spinner) {
            this.a = spinner;
        }

        public void onClick(View v) {
            if (this.a.getSelectedItem().toString().equals("اختر الباقة") || TextUtils.isEmpty(qb0.f4810c)) {
                Toast.makeText(ef0.this.f2907a, "الرجاء اختيار اسم الباقة", 1).show();
            } else {
                new d().execute(new String[0]);
            }
        }
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                this.f2906a = new ProgressDialog(this.f2907a);
                new e().execute(new String[0]);
                this.f2909a.getAdapter().w(qb0.a);
                this.f2909a.b(15);
                return true;
            case 2:
                d();
                return true;
            default:
                return true;
        }
    }
}
