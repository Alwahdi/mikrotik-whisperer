package defpackage;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import com.blogspot.yemeninfo4it.mumsmobile_app.AsyncClasses.HotspotAsync;
import com.blogspot.yemeninfo4it.mumsmobile_app.AsyncClasses.UserManagerAsync;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddHostpotActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.AddUserActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.DeleteUserActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.ExpierHotspotActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.HotspotManagerActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.SalesActivityNew;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.SalesArchiveActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.SalesHotsActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.SalesHotsArchevActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.SalesPointActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.SearchActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.activities.UsermanProfileActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.ConnectData;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Interface;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Payment;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Sessions;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanCustomer;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanProfile;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: y2  reason: default package */
public class y2 extends Fragment {
    int a = 6;

    /* renamed from: a  reason: collision with other field name */
    Context f5787a;

    /* renamed from: a  reason: collision with other field name */
    Intent f5788a;

    /* renamed from: a  reason: collision with other field name */
    TextView f5789a;

    /* renamed from: a  reason: collision with other field name */
    LinearLayoutCompat f5790a;

    /* renamed from: a  reason: collision with other field name */
    ConnectData f5791a;

    /* renamed from: a  reason: collision with other field name */
    j3 f5792a;

    /* renamed from: a  reason: collision with other field name */
    final String f5793a = "mLog";

    /* renamed from: a  reason: collision with other field name */
    ArrayList<Interface> f5794a;

    /* renamed from: a  reason: collision with other field name */
    s50 f5795a;

    /* renamed from: a  reason: collision with other field name */
    ue f5796a;

    /* renamed from: a  reason: collision with other field name */
    wk0 f5797a;

    /* renamed from: a  reason: collision with other field name */
    j f5798a;

    /* renamed from: a  reason: collision with other field name */
    k f5799a;

    /* renamed from: a  reason: collision with other field name */
    l f5800a;

    /* renamed from: a  reason: collision with other field name */
    m f5801a;

    /* renamed from: a  reason: collision with other field name */
    zd f5802a;
    LinearLayoutCompat b;

    /* renamed from: b  reason: collision with other field name */
    String f5803b = "";

    /* renamed from: b  reason: collision with other field name */
    ArrayList<Sessions> f5804b;
    LinearLayoutCompat c;

    /* renamed from: c  reason: collision with other field name */
    ArrayList<Payment> f5805c;
    LinearLayoutCompat d;

    /* renamed from: d  reason: collision with other field name */
    ArrayList<UsermanProfile> f5806d;
    LinearLayoutCompat e;

    /* renamed from: e  reason: collision with other field name */
    ArrayList<UsermanCustomer> f5807e;
    LinearLayoutCompat f;

    /* renamed from: f  reason: collision with other field name */
    ArrayList<UsermanagerCards> f5808f;
    LinearLayoutCompat g;
    LinearLayoutCompat h;
    LinearLayoutCompat i;
    LinearLayoutCompat j;
    LinearLayoutCompat k;
    LinearLayoutCompat l;
    LinearLayoutCompat m;
    LinearLayoutCompat n;
    LinearLayoutCompat o;
    LinearLayoutCompat p;
    LinearLayoutCompat q;
    LinearLayoutCompat r;
    LinearLayoutCompat s;
    LinearLayoutCompat t;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_all_home, container, false);
        this.f5787a = getContext();
        this.f5792a = qb0.d();
        this.f5791a = new ConnectData();
        this.f5808f = new ArrayList<>();
        this.f5794a = new ArrayList<>();
        this.f5806d = new ArrayList<>();
        this.f5807e = new ArrayList<>();
        this.f5796a = new ue(getContext());
        this.f5788a = new Intent(getActivity(), AddUserActivity.class);
        this.f5804b = new ArrayList<>();
        this.f5805c = new ArrayList<>();
        zd zdVar = new zd(getActivity());
        this.f5802a = zdVar;
        TextView textView = (TextView) zdVar.b().findViewById(R.id.cancel_btn);
        this.f5789a = textView;
        textView.setVisibility(8);
        this.f = (LinearLayoutCompat) view.findViewById(R.id.reloaduserman);
        this.g = (LinearLayoutCompat) view.findViewById(R.id.reloaduserhotspot);
        this.j = (LinearLayoutCompat) view.findViewById(R.id.expir_user);
        this.i = (LinearLayoutCompat) view.findViewById(R.id.adduser_hotspot);
        this.k = (LinearLayoutCompat) view.findViewById(R.id.hospot);
        this.h = (LinearLayoutCompat) view.findViewById(R.id.userman_cards);
        this.e = (LinearLayoutCompat) view.findViewById(R.id.adduser);
        this.d = (LinearLayoutCompat) view.findViewById(R.id.deleteuser_hotspot);
        this.l = (LinearLayoutCompat) view.findViewById(R.id.maphots);
        this.m = (LinearLayoutCompat) view.findViewById(R.id.mapuserman);
        this.n = (LinearLayoutCompat) view.findViewById(R.id.mapuserman_archive);
        this.q = (LinearLayoutCompat) view.findViewById(R.id.userman_cards_archive);
        this.o = (LinearLayoutCompat) view.findViewById(R.id.backupuserman2);
        this.p = (LinearLayoutCompat) view.findViewById(R.id.backupuserman);
        this.r = (LinearLayoutCompat) view.findViewById(R.id.rebuilduserman);
        this.s = (LinearLayoutCompat) view.findViewById(R.id.usermanprofiles);
        this.t = (LinearLayoutCompat) view.findViewById(R.id.hots_sales_archive);
        this.f5790a = (LinearLayoutCompat) view.findViewById(R.id.backupconfig);
        this.b = (LinearLayoutCompat) view.findViewById(R.id.reboot);
        this.c = (LinearLayoutCompat) view.findViewById(R.id.slspoint);
        this.a = qb0.f4798a.getVersion() != null ? Integer.parseInt(qb0.f4798a.getVersion().substring(0, 1)) : 6;
        this.e.setOnClickListener(new a());
        this.f.setOnClickListener(new b());
        this.g.setOnClickListener(new c());
        this.h.setOnClickListener(new d());
        this.d.setOnClickListener(new w2(this));
        this.j.setOnClickListener(new j2(this));
        this.i.setOnClickListener(new u2(this));
        this.k.setOnClickListener(new k2(this));
        this.m.setOnClickListener(new n2(this));
        this.n.setOnClickListener(new f());
        this.q.setOnClickListener(new g());
        this.l.setOnClickListener(new x2(this));
        this.t.setOnClickListener(new m2(this));
        this.s.setOnClickListener(new t2(this));
        this.p.setOnClickListener(new i2(this));
        this.b.setOnClickListener(new l2(this));
        this.c.setOnClickListener(new v2(this));
        this.f5790a.setOnClickListener(new o2(this));
        this.r.setOnClickListener(new h());
        this.o.setOnClickListener(new i());
        return view;
    }

    /* renamed from: y2$a */
    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View v) {
            y2 y2Var = y2.this;
            y2Var.startActivity(y2Var.f5788a);
            i40.d(y2.this.getActivity());
        }
    }

    /* renamed from: y2$b */
    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View v) {
            new AlertDialog.Builder(y2.this.getActivity(), R.style.CustomAlertDialog).setIcon(17301543).setTitle("تنبية !").setMessage("هل تريد إعادة تحميل كروت اليوز مانجر ").setPositiveButton("نعم", new a()).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
        }

        /* renamed from: y2$b$a */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            public void onClick(DialogInterface dialog, int which) {
                if (qb0.f4798a == null) {
                    new UserManagerAsync(y2.this.getActivity()).execute(new Void[0]);
                } else if (y2.this.a >= 7) {
                    new lu0(y2.this.getActivity()).execute(new Void[0]);
                } else {
                    new UserManagerAsync(y2.this.getActivity()).execute(new Void[0]);
                }
            }
        }
    }

    /* renamed from: y2$c */
    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View v) {
            new AlertDialog.Builder(y2.this.getActivity(), R.style.CustomAlertDialog).setIcon(17301543).setTitle("تنبية !").setMessage("هل تريد إعادة تحميل كروت هوتس بوت من السيرفر ؟").setPositiveButton("نعم", new a()).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
        }

        /* renamed from: y2$c$a */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            public void onClick(DialogInterface dialog, int which) {
                new HotspotAsync(y2.this.getActivity()).execute(new Void[0]);
            }
        }
    }

    /* renamed from: y2$d */
    class d implements View.OnClickListener {
        d() {
        }

        public void onClick(View v) {
            y2.this.startActivity(new Intent(y2.this.getActivity(), SearchActivity.class));
            i40.e(y2.this.getActivity());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z(View v) {
        startActivity(new Intent(getActivity(), ExpierHotspotActivity.class));
        i40.a(getActivity());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A(View v) {
        startActivity(new Intent(getActivity(), DeleteUserActivity.class));
        i40.b(getActivity());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I(View v) {
        startActivity(new Intent(getActivity(), AddHostpotActivity.class));
        i40.b(getActivity());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J(View v) {
        startActivity(new Intent(getActivity(), HotspotManagerActivity.class));
        i40.b(getActivity());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M(View v) {
        if (qb0.f4815d == null || qb0.f4833k == null) {
            new AlertDialog.Builder(getActivity(), R.style.CustomAlertDialog).setIcon(17301543).setTitle("تنبية !").setMessage("هل انت متاكد من انك تريد تحميل المبيعات ؟ ").setPositiveButton("نعم", new p2(this)).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
        } else {
            new AlertDialog.Builder(getActivity(), R.style.CustomAlertDialog).setIcon(17301543).setTitle("تنبية !").setMessage("لقد تم تحميل المبيعات.. تريد عرض المبيعات التي تم تحميلها مسبقا ؟ ").setPositiveButton("نعم", new e()).setNegativeButton("لا ..تحميل من جديد", new r2(this)).show();
        }
    }

    /* renamed from: y2$e */
    class e implements DialogInterface.OnClickListener {
        e() {
        }

        public void onClick(DialogInterface dialog, int which) {
            y2.this.startActivity(new Intent(y2.this.getActivity(), SalesActivityNew.class));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K(DialogInterface dialog, int which) {
        qb0.f4819e = new ArrayList<>();
        qb0.f4833k = new ArrayList<>();
        wk0 wk0 = new wk0(this.f5787a);
        this.f5797a = wk0;
        wk0.execute(new Void[0]);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L(DialogInterface dialog, int which) {
        if (qb0.f4815d != null) {
            s50 s50 = new s50(this.f5787a);
            this.f5795a = s50;
            s50.execute(new Void[0]);
            return;
        }
        wk0 wk0 = new wk0(this.f5787a);
        this.f5797a = wk0;
        wk0.execute(new Void[0]);
    }

    /* renamed from: y2$f */
    class f implements View.OnClickListener {
        f() {
        }

        public void onClick(View v) {
            y2.this.startActivity(new Intent(y2.this.getActivity(), SalesArchiveActivity.class));
        }
    }

    /* renamed from: y2$g */
    class g implements View.OnClickListener {
        g() {
        }

        public void onClick(View v) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N(View v) {
        try {
            if (qb0.f4834l != null) {
                startActivity(new Intent(getActivity(), SalesHotsActivity.class));
                i40.c(getActivity());
                return;
            }
            Toast.makeText(getContext(), "لا يوجد كروت او مبيعات في الهوتسبوت ", 1).show();
        } catch (Exception e2) {
            Context context = getContext();
            Toast.makeText(context, e2.getMessage() + " خطأ ", 1).show();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O(View v) {
        try {
            startActivity(new Intent(getActivity(), SalesHotsArchevActivity.class));
            i40.c(getActivity());
        } catch (Exception e2) {
            Context context = getContext();
            Toast.makeText(context, e2.getMessage() + " خطأ ", 1).show();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P(View v) {
        startActivity(new Intent(getActivity(), UsermanProfileActivity.class));
        i40.e(getActivity());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C(View v) {
        new AlertDialog.Builder(getContext(), R.style.CustomAlertDialog).setIcon(17301543).setTitle("تنبية !").setMessage("هل انت متاكد وتريد المتابعة").setPositiveButton("نعم", new s2(this)).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B(DialogInterface dialog, int which) {
        m mVar = new m();
        this.f5801a = mVar;
        mVar.execute(new String[0]);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E(View v) {
        new AlertDialog.Builder(getContext(), R.style.CustomAlertDialog).setIcon(17301543).setTitle("تنبية !").setMessage("هل انت متاكد من إعادة تشغيل الرواتر").setPositiveButton("نعم", new h2(this)).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D(DialogInterface dialog, int which) {
        k kVar = new k();
        this.f5799a = kVar;
        kVar.execute(new String[0]);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F(View v) {
        startActivity(new Intent(getActivity(), SalesPointActivity.class));
        i40.e(getActivity());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H(View v) {
        new AlertDialog.Builder(getContext(), R.style.CustomAlertDialog).setIcon(17301543).setTitle("تنبية !").setMessage("هل انت متاكد من انك تريد حفظ اعدادات الراوتر").setPositiveButton("نعم", new q2(this)).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G(DialogInterface dialog, int which) {
        j jVar = new j();
        this.f5798a = jVar;
        jVar.execute(new String[0]);
    }

    /* renamed from: y2$h */
    class h implements View.OnClickListener {
        h() {
        }

        public void onClick(View v) {
            new AlertDialog.Builder(y2.this.getContext(), R.style.CustomAlertDialog).setIcon(17301543).setTitle("تنبية !").setMessage("هل انت متاكد وتريد المتابعة").setPositiveButton("نعم", new a()).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
        }

        /* renamed from: y2$h$a */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            public void onClick(DialogInterface dialog, int which) {
                y2.this.f5800a = new l();
                y2.this.f5800a.execute(new String[0]);
            }
        }
    }

    /* renamed from: y2$i */
    class i implements View.OnClickListener {
        i() {
        }

        public void onClick(View v) {
            Toast.makeText(y2.this.getContext(), "قريبا", 1).show();
        }
    }

    /* renamed from: y2$l */
    class l extends AsyncTask<String, String, Void> {
        List<Map<String, String>> a = null;

        l() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            y2.this.f5802a.c("إنتظر! يتم الان إعادة البناء..");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(String... params) {
            try {
                if (!y2.this.f5792a.w()) {
                    return null;
                }
                y2 y2Var = y2.this;
                if (y2Var.a <= 6) {
                    this.a = y2Var.f5792a.q("/tool/user-manager/database/rebuild");
                    return null;
                }
                this.a = y2Var.f5792a.q("/user-manager/database/optimize-db");
                return null;
            } catch (Exception e) {
                try {
                    Log.d("mLog", e.toString() + "error");
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    Log.d("mLog", e2.toString() + " :ddddddd");
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Void result) {
            y2.this.f5802a.a();
            try {
                Toast.makeText(y2.this.getContext(), "تم العملية", 1).show();
            } catch (Exception e) {
                Context context = y2.this.getContext();
                Toast.makeText(context, " حدثت مشكلة " + e.getMessage(), 1).show();
            }
        }
    }

    /* renamed from: y2$m */
    class m extends AsyncTask<String, String, Void> {
        List<Map<String, String>> a = null;

        m() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            y2.this.f5802a.c("إنتظر! جاري الحفظ ...");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(String... params) {
            try {
                Calendar c = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.US);
                String strDate = "MUMS-" + sdf.format(c.getTime());
                y2.this.f5792a.J(150000);
                if (!y2.this.f5792a.w()) {
                    return null;
                }
                y2 y2Var = y2.this;
                if (y2Var.a <= 6) {
                    this.a = y2Var.f5792a.q("/tool/user-manager/database/save name='" + strDate + "'");
                    return null;
                }
                this.a = y2Var.f5792a.q("/user-manager/database/save name='" + strDate + "'");
                return null;
            } catch (Exception e) {
                try {
                    Log.d("mLog", e.toString() + "error");
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Void result) {
            super.onPostExecute(result);
            y2.this.f5802a.a();
            try {
                Toast.makeText(y2.this.getContext(), "تم العملية", 1).show();
            } catch (Exception e) {
                Context context = y2.this.getContext();
                Toast.makeText(context, e.getMessage() + "حصلت مشكلة ", 1).show();
            }
        }
    }

    /* renamed from: y2$k */
    class k extends AsyncTask<String, String, Void> {
        List<Map<String, String>> a = null;

        k() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            y2.this.f5802a.c("يرجى الانتظار..جاري إعادة التشغيل");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(String... params) {
            try {
                y2.this.f5792a.J(10000);
                y2.this.f5792a.q("/system/reboot");
                return null;
            } catch (Exception e) {
                try {
                    Log.d("mLog", e.toString() + "error");
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Void result) {
            y2.this.f5802a.a();
            try {
                Toast.makeText(y2.this.getContext(), "تم إعادة التشغيل", 1).show();
            } catch (Exception e) {
                Context context = y2.this.getContext();
                Toast.makeText(context, e.getMessage() + "حصلت مشكلة ", 1).show();
            }
        }
    }

    /* renamed from: y2$j */
    class j extends AsyncTask<String, String, Void> {
        List<Map<String, String>> a = null;

        j() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            y2.this.f5802a.c("يرجى الانتظار..جاري تنفيذ طلبك");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(String... params) {
            try {
                String strDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH).format(Calendar.getInstance().getTime());
                y2 y2Var = y2.this;
                y2Var.f5803b = "MUMS-" + strDate;
                y2.this.f5792a.J(150000);
                if (!y2.this.f5792a.w()) {
                    return null;
                }
                j3 j3Var = y2.this.f5792a;
                j3Var.q("/export file='" + y2.this.f5803b + "'");
                return null;
            } catch (Exception e) {
                try {
                    Log.d("mLog", e.toString() + "error");
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Void result) {
            y2.this.f5802a.a();
            try {
                Context context = y2.this.getContext();
                Toast.makeText(context, "تم حفظ نسخة احتياطية بإسم " + y2.this.f5803b, 1).show();
            } catch (Exception e) {
                Context context2 = y2.this.getContext();
                Toast.makeText(context2, e.getMessage() + "حصلت مشكلة ", 1).show();
            }
        }
    }
}
