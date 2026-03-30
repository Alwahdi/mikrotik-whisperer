package com.blogspot.yemeninfo4it.mumsmobile_app.activities;

import android.app.AlertDialog;
import android.app.ForegroundServiceStartNotAllowedException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.discover.Discover;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.ConnectData;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Interface;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.LoginData;
import com.blogspot.yemeninfo4it.mumsmobile_app.service.MyLocation;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.firebase.firestore.p;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.net.SocketFactory;
import org.apache.http.cookie.ClientCookie;

public class MikrotikLoginActivity extends AppCompatActivity {
    public static EditText a;

    /* renamed from: a  reason: collision with other field name */
    public static BottomSheetBehavior f806a;
    public static EditText b;

    /* renamed from: b  reason: collision with other field name */
    private static String f807b = null;
    public static EditText c;
    public static EditText d;

    /* renamed from: a  reason: collision with other field name */
    Context f808a;

    /* renamed from: a  reason: collision with other field name */
    Button f809a;

    /* renamed from: a  reason: collision with other field name */
    CheckBox f810a;

    /* renamed from: a  reason: collision with other field name */
    ImageView f811a;

    /* renamed from: a  reason: collision with other field name */
    LinearLayout f812a;

    /* renamed from: a  reason: collision with other field name */
    RadioButton f813a;

    /* renamed from: a  reason: collision with other field name */
    Spinner f814a;

    /* renamed from: a  reason: collision with other field name */
    TextView f815a;

    /* renamed from: a  reason: collision with other field name */
    CoordinatorLayout f816a;

    /* renamed from: a  reason: collision with other field name */
    RecyclerView f817a;

    /* renamed from: a  reason: collision with other field name */
    az f818a;

    /* renamed from: a  reason: collision with other field name */
    h f819a;

    /* renamed from: a  reason: collision with other field name */
    i f820a;

    /* renamed from: a  reason: collision with other field name */
    ConnectData f821a;

    /* renamed from: a  reason: collision with other field name */
    protected j3 f822a;

    /* renamed from: a  reason: collision with other field name */
    final String f823a = "mLog";

    /* renamed from: a  reason: collision with other field name */
    ArrayList<LoginData> f824a;

    /* renamed from: a  reason: collision with other field name */
    ue f825a;

    /* renamed from: a  reason: collision with other field name */
    zd f826a;

    /* renamed from: b  reason: collision with other field name */
    ImageView f827b;

    /* renamed from: b  reason: collision with other field name */
    LinearLayout f828b;

    /* renamed from: b  reason: collision with other field name */
    RadioButton f829b;

    /* renamed from: b  reason: collision with other field name */
    TextView f830b;

    /* renamed from: c  reason: collision with other field name */
    ImageView f831c;

    /* renamed from: c  reason: collision with other field name */
    LinearLayout f832c;

    /* renamed from: c  reason: collision with other field name */
    TextView f833c;

    public native String VretS();

    static {
        System.loadLibrary("native-lib");
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_login);
        Bundle bundle = getIntent().getExtras();
        boolean myBooleanVariable = bundle.getBoolean(VretS());
        int i2 = 1;
        try {
            this.f808a = this;
            this.f824a = new ArrayList<>();
            if (!myBooleanVariable) {
                System.exit(0);
            }
            s();
            if (Build.VERSION.SDK_INT >= 21) {
                getWindow().getDecorView().setSystemUiVisibility(1280);
            }
            this.f825a = new ue(this);
            zd zdVar = new zd(this);
            this.f826a = zdVar;
            TextView textView = (TextView) zdVar.b().findViewById(R.id.cancel_btn);
            this.f830b = textView;
            textView.setVisibility(8);
            this.f817a = (RecyclerView) findViewById(R.id.recycler_logindata);
            a = (EditText) findViewById(R.id.ipaddress);
            b = (EditText) findViewById(R.id.username);
            c = (EditText) findViewById(R.id.password);
            d = (EditText) findViewById(R.id.port);
            this.f815a = (TextView) findViewById(R.id.records);
            this.f811a = (ImageView) findViewById(R.id.bottom_shet_close);
            this.f827b = (ImageView) findViewById(R.id.bottom_shet_down_up);
            this.f816a = (CoordinatorLayout) findViewById(R.id.coordinateLayout);
            this.f814a = (Spinner) findViewById(R.id.login_data);
            this.f833c = (TextView) findViewById(R.id.discover_txy);
            this.f831c = (ImageView) findViewById(R.id.eye_img);
            this.f813a = (RadioButton) findViewById(R.id.newV);
            this.f829b = (RadioButton) findViewById(R.id.oldV);
            this.f809a = (Button) findViewById(R.id.go_login);
            this.f810a = (CheckBox) findViewById(R.id.keep_data_check);
            this.f832c = (LinearLayout) findViewById(R.id.bottom_sheet);
            this.f812a = (LinearLayout) findViewById(R.id.no_recorde);
            this.f828b = (LinearLayout) findViewById(R.id.recorde_found);
            f806a = BottomSheetBehavior.H(this.f832c);
            this.f821a = new ConnectData();
            if (!qb0.f4813c) {
                qb0.a(this);
            }
            qb0.b(this);
            this.f831c.setTag(1);
            List<String> list4 = new ArrayList<>();
            Cursor data = this.f825a.k0();
            if (data.getCount() > 0) {
                list4.add("اختار من السجلات المحفوظة");
                while (data.moveToNext()) {
                    if (data.getString(i2) != null) {
                        list4.add(data.getString(i2));
                        ArrayList<LoginData> arrayList = this.f824a;
                        LoginData loginData = r10;
                        LoginData loginData2 = new LoginData(data.getString(i2), data.getString(2), data.getString(3), data.getString(4), "assa");
                        arrayList.add(loginData);
                        i2 = 1;
                    } else {
                        i2 = 1;
                    }
                }
            } else {
                list4.add("لا يوجد سجلات محفوظة");
            }
            ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<>(this, R.layout.spinner_item, list4);
            dataAdapter3.setDropDownViewResource(R.layout.spinner_item);
            this.f814a.setAdapter(dataAdapter3);
            this.f817a.setLayoutManager(new LinearLayoutManager(this.f808a));
            az azVar = new az(this.f808a, this.f824a);
            this.f818a = azVar;
            this.f817a.setAdapter(azVar);
            this.f817a.setItemAnimator(new DefaultItemAnimator());
            try {
                if (this.f824a.size() > 0) {
                    this.f828b.setVisibility(0);
                    this.f812a.setVisibility(8);
                } else {
                    this.f828b.setVisibility(8);
                    this.f812a.setVisibility(0);
                }
            } catch (Exception e2) {
            }
            this.f813a.setOnClickListener(new u10(this));
            this.f829b.setOnClickListener(new v10(this));
            this.f833c.setOnClickListener(new w10(this));
            this.f831c.setOnClickListener(new a());
            q();
            this.f809a.setOnClickListener(new b());
            this.f814a.setOnItemSelectedListener(new c());
            f806a.Y(new d());
            this.f815a.setOnClickListener(x10.a);
            this.f811a.setOnClickListener(z10.a);
            this.f816a.setOnClickListener(y10.a);
            if (!ml0.a(this.f808a, "r_ip").isEmpty()) {
                a.setText(ml0.a(this.f808a, "r_ip"));
                b.setText(ml0.a(this.f808a, "r_username"));
                c.setText(ml0.a(this.f808a, "r_password"));
                d.setText(ml0.a(this.f808a, "r_port"));
                this.f810a.setChecked(true);
            }
            try {
                String bund_ipaddress = bundle.getString("txtIp");
                if (bund_ipaddress != null) {
                    a.setText(bund_ipaddress);
                    d.setText("8728");
                    b.getText().clear();
                    c.getText().clear();
                }
            } catch (Exception e3) {
            }
        } catch (Exception e4) {
            Toast.makeText(this, e4.toString() + "error", 1).show();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u(View v) {
        this.f813a.setChecked(true);
        this.f829b.setChecked(false);
        qb0.f4809b = true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v(View v) {
        this.f829b.setChecked(true);
        this.f813a.setChecked(false);
        qb0.f4809b = false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w(View v) {
        startActivity(new Intent(this.f808a, Discover.class));
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View v) {
            if (MikrotikLoginActivity.this.f831c.getTag().equals(1)) {
                MikrotikLoginActivity.c.setTransformationMethod((TransformationMethod) null);
                MikrotikLoginActivity mikrotikLoginActivity = MikrotikLoginActivity.this;
                mikrotikLoginActivity.f831c.setImageDrawable(ContextCompat.getDrawable(mikrotikLoginActivity.f808a, R.drawable.ic_eye_close));
                MikrotikLoginActivity.this.f831c.setTag(0);
                return;
            }
            MikrotikLoginActivity.this.f831c.setTag(1);
            MikrotikLoginActivity.c.setTransformationMethod(new PasswordTransformationMethod());
            MikrotikLoginActivity mikrotikLoginActivity2 = MikrotikLoginActivity.this;
            mikrotikLoginActivity2.f831c.setImageDrawable(ContextCompat.getDrawable(mikrotikLoginActivity2.f808a, R.drawable.ic_eye_open));
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View v) {
            String unamecode = MikrotikLoginActivity.b.getText().toString();
            String obj = MikrotikLoginActivity.c.getText().toString();
            String portcode = MikrotikLoginActivity.d.getText().toString();
            String ipcode = MikrotikLoginActivity.a.getText().toString();
            if (TextUtils.isEmpty(unamecode)) {
                MikrotikLoginActivity.b.setError("الرجاء تعبئة حقل اسم المستخدم");
            } else if (TextUtils.isEmpty(portcode)) {
                MikrotikLoginActivity.d.setError("الرجاء تعبئة حقل المنفذ");
            } else if (TextUtils.isEmpty(ipcode)) {
                MikrotikLoginActivity.a.setError("الرجاء تعبئة حقل الايبي");
            } else {
                MikrotikLoginActivity.this.f819a = new h();
                MikrotikLoginActivity.this.f819a.execute(new Void[0]);
            }
        }
    }

    class c implements AdapterView.OnItemSelectedListener {
        c() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            Object item = adapterView.getItemAtPosition(position);
            if (!item.toString().equals("اختار من السجلات المحفوظة") && !item.toString().equals("لا يوجد سجلات محفوظة")) {
                Cursor data = MikrotikLoginActivity.this.f825a.l0(item.toString());
                while (data.moveToNext()) {
                    MikrotikLoginActivity.a.setText(data.getString(1));
                    MikrotikLoginActivity.b.setText(data.getString(2));
                    MikrotikLoginActivity.c.setText(data.getString(3));
                    MikrotikLoginActivity.d.setText(data.getString(4));
                }
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class d extends BottomSheetBehavior.f {
        d() {
        }

        public void c(View bottomSheet, int newState) {
            switch (newState) {
                case 3:
                    MikrotikLoginActivity.this.f811a.setVisibility(0);
                    MikrotikLoginActivity.this.f827b.setImageResource(R.drawable.ic_down);
                    return;
                case 4:
                    MikrotikLoginActivity.this.f811a.setVisibility(8);
                    MikrotikLoginActivity.this.f827b.setImageResource(R.drawable.ic_up);
                    return;
                default:
                    return;
            }
        }

        public void b(View bottomSheet, float slideOffset) {
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void x(View v) {
        if (f806a.K() != 3) {
            f806a.m0(3);
        } else {
            f806a.m0(4);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void y(View v) {
        if (f806a.K() == 3) {
            f806a.m0(4);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void z(View v) {
        if (f806a.K() == 3) {
            f806a.m0(4);
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(jv0.b(newBase));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        try {
            if (!qb0.f4813c) {
                qb0.a(this);
            }
            qb0.b(this);
        } catch (Exception e2) {
        }
    }

    public void onBackPressed() {
        new AlertDialog.Builder(this, R.style.CustomAlertDialog).setIcon(17301543).setTitle("خروج !").setMessage("هل تريد الخروج من البرنامج ؟ ").setPositiveButton("نعم", new e()).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
    }

    class e implements DialogInterface.OnClickListener {
        e() {
        }

        public void onClick(DialogInterface dialog, int which) {
            MikrotikLoginActivity.this.finish();
        }
    }

    public class h extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with other field name */
        String f835a = "";

        /* renamed from: a  reason: collision with other field name */
        ArrayList<Interface> f836a = new ArrayList<>();

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f837a = null;

        /* renamed from: a  reason: collision with other field name */
        boolean f838a = false;
        List<Map<String, String>> b = null;

        public h() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            MikrotikLoginActivity.this.f826a.c("جاري الدخول الى الراوتر..");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... params) {
            try {
                if (!qb0.f4813c) {
                    return null;
                }
                MikrotikLoginActivity.this.f822a = j3.f(SocketFactory.getDefault(), MikrotikLoginActivity.a.getText().toString().trim(), Integer.parseInt(MikrotikLoginActivity.d.getText().toString().trim()), 10000);
                MikrotikLoginActivity.this.f822a.C(MikrotikLoginActivity.b.getText().toString(), MikrotikLoginActivity.c.getText().toString(), true);
                if (!MikrotikLoginActivity.this.f822a.w()) {
                    return null;
                }
                this.f838a = true;
                qb0.i(MikrotikLoginActivity.this.f822a);
                j3 a2 = qb0.d();
                this.b = a2.q("/system/resource/print return free-memory,uptime,total-memory,board-name,version");
                this.f837a = a2.q("/system/script/print where name=ex_dis_user_new");
                MikrotikLoginActivity.this.f821a.setIp(MikrotikLoginActivity.a.getText().toString());
                MikrotikLoginActivity.this.f821a.setUname(MikrotikLoginActivity.b.getText().toString());
                MikrotikLoginActivity.this.f821a.setPass(MikrotikLoginActivity.c.getText().toString());
                MikrotikLoginActivity.this.f821a.setPort(MikrotikLoginActivity.d.getText().toString());
                if (MikrotikLoginActivity.this.f813a.isChecked()) {
                    qb0.f4809b = true;
                    qb0.f4830i = false;
                } else {
                    qb0.f4809b = false;
                    qb0.f4830i = true;
                }
                qb0.f4797a = MikrotikLoginActivity.this.f821a;
                return null;
            } catch (Exception e) {
                try {
                    this.f835a = e.getMessage();
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
            MikrotikLoginActivity.this.f826a.a();
            if (this.f838a) {
                try {
                    List<Map<String, String>> list = this.b;
                    if (list != null) {
                        qb0.f4798a = new Interface((String) list.get(0).get("free-memory"), (String) this.b.get(0).get("uptime"), (String) this.b.get(0).get("total-memory"), (String) this.b.get(0).get("total-memory"), (String) this.b.get(0).get("board-name"), (String) this.b.get(0).get(ClientCookie.VERSION_ATTR));
                    }
                    List<Map<String, String>> list2 = this.f837a;
                    if (list2 != null && list2.size() < 1) {
                        MikrotikLoginActivity mikrotikLoginActivity = MikrotikLoginActivity.this;
                        mikrotikLoginActivity.f820a = new i();
                        MikrotikLoginActivity.this.f820a.execute(new Void[0]);
                    }
                } catch (Exception e) {
                    Toast.makeText(MikrotikLoginActivity.this, e.getMessage(), 0).show();
                }
                MikrotikLoginActivity.this.f825a.a0("user_manager_sales_cach");
                if (MikrotikLoginActivity.this.f810a.isChecked()) {
                    MikrotikLoginActivity mikrotikLoginActivity2 = MikrotikLoginActivity.this;
                    ml0.b(mikrotikLoginActivity2.f808a, "r_ip", mikrotikLoginActivity2.f821a.getIp());
                    MikrotikLoginActivity mikrotikLoginActivity3 = MikrotikLoginActivity.this;
                    ml0.b(mikrotikLoginActivity3.f808a, "r_username", mikrotikLoginActivity3.f821a.getUname());
                    MikrotikLoginActivity mikrotikLoginActivity4 = MikrotikLoginActivity.this;
                    ml0.b(mikrotikLoginActivity4.f808a, "r_password", mikrotikLoginActivity4.f821a.getPass());
                    MikrotikLoginActivity mikrotikLoginActivity5 = MikrotikLoginActivity.this;
                    ml0.b(mikrotikLoginActivity5.f808a, "r_port", mikrotikLoginActivity5.f821a.getPort());
                    MikrotikLoginActivity mikrotikLoginActivity6 = MikrotikLoginActivity.this;
                    mikrotikLoginActivity6.f825a.K(mikrotikLoginActivity6.f821a.getIp(), MikrotikLoginActivity.this.f821a.getUname(), MikrotikLoginActivity.this.f821a.getPass(), MikrotikLoginActivity.this.f821a.getPort());
                } else {
                    ml0.b(MikrotikLoginActivity.this.f808a, "r_ip", "");
                    ml0.b(MikrotikLoginActivity.this.f808a, "r_username", "");
                    ml0.b(MikrotikLoginActivity.this.f808a, "r_password", "");
                    ml0.b(MikrotikLoginActivity.this.f808a, "r_port", "");
                }
                try {
                    Intent intent2 = new Intent(MikrotikLoginActivity.this.f808a, MyLocation.class);
                    int i = Build.VERSION.SDK_INT;
                    if (i < 26) {
                        MikrotikLoginActivity.this.startService(intent2);
                    } else if (i >= 31) {
                        try {
                            if (ContextCompat.checkSelfPermission(MikrotikLoginActivity.this, "android.permission.POST_NOTIFICATIONS") == 0) {
                                try {
                                    MikrotikLoginActivity.this.startService(intent2);
                                } catch (ForegroundServiceStartNotAllowedException e2) {
                                    Toast.makeText(MikrotikLoginActivity.this, e2.getMessage(), 1).show();
                                }
                            }
                        } catch (Exception e3) {
                            Toast.makeText(MikrotikLoginActivity.this, e3.getMessage(), 1).show();
                        }
                    } else {
                        MikrotikLoginActivity.this.f808a.startForegroundService(intent2);
                    }
                } catch (Exception e4) {
                    Toast.makeText(MikrotikLoginActivity.this, e4.getMessage(), 1).show();
                }
                Intent intent = new Intent(MikrotikLoginActivity.this, MumsHomeActivity.class);
                intent.putExtra("ip", MikrotikLoginActivity.a.getText().toString());
                intent.putExtra("uname", MikrotikLoginActivity.b.getText().toString());
                intent.putExtra("pass", MikrotikLoginActivity.c.getText().toString());
                intent.putExtra(ClientCookie.PORT_ATTR, MikrotikLoginActivity.d.getText().toString());
                intent.putExtra(MikrotikLoginActivity.this.VretS(), true);
                MikrotikLoginActivity.this.startActivity(intent);
                MikrotikLoginActivity.this.finish();
                return;
            }
            Toast.makeText(MikrotikLoginActivity.this, this.f835a, 1).show();
        }
    }

    class i extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with other field name */
        String f839a = "";

        /* renamed from: a  reason: collision with other field name */
        boolean f840a = false;

        i() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... params) {
            try {
                j3 con = qb0.d();
                con.J(10000);
                con.q("/system/script/add name=ex_dis_user_new policy=read,write source=" + "'{:global today;{:local date [ /system clock get date ];:local montharray ( \"jan\",\"feb\",\"mar\",\"apr\",\"may\",\"jun\",\"jul\",\"aug\",\"sep\",\"oct\",\"nov\",\"dec\" );:local monthdays ( 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 );:local days [ :pick $date 4 6 ];:local monthtxt [ :pick $date 0 3 ];:local year [ :pick $date 7 11 ];:local months ([ :find $montharray $monthtxt]);:for nodays from=0 to=$months do={:set days ( $days + [ :pick $monthdays $nodays ] )};:set days ($days + $year * 365);:set today $days;};:foreach i in [ /ip hotspot user find where disabled=no ] do={:if ([ :find [ /ip hotspot user get $i comment ] ] = 0 && [ :find [ /ip hotspot user get $i email ] ] = 0) do={:local datee [ /ip hotspot user get $i comment ];:local mums [ :pick $datee 0 4 ]; :if ( $mums = \"mums\" ) do={ :local date [ :pick $datee 5 16 ];:local oldemail [ /ip hotspot user get $i email ];:local atmark [ :find $oldemail \"@\" ];:local dotmark [ :find $oldemail \".\" ];:if ( $atmark >= 0 && $dotmark >= 0 ) do={:local validity [ :pick $oldemail 0 $atmark];:local rest [ :pick $oldemail ($atmark + 1) [ :len $oldemail] ];:if ( [:tonum $validity] != \"\" ) do={:if ( [:tonum $validity] != \"0\" ) do={:local montharray ( \"jan\",\"feb\",\"mar\",\"apr\",\"may\",\"jun\",\"jul\",\"aug\",\"sep\",\"oct\",\"nov\",\"dec\" );:local monthdays ( 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 );:local days [ :pick $date 4 6 ];:local monthtxt [ :pick $date 0 3 ];:local year [ :pick $date 7 11 ];:local months ( [ :find $montharray $monthtxt ] );:for nodays from=0 to=$months do={:set days ( $days + [ :pick $monthdays $nodays ] )};:set days ($days + $year * 365);:if ( ($days + $validity) < $today ) do={ :local name [/ip hotspot user get $i name];:log info \"HOTSPOT VALITITY EXPIRE: Disabling Hotspot user $name first logged in $date\";[ /ip hotspot user disable $i ];}}}}}}}}'" + " owner=" + qb0.f4797a.getUname() + "");
                return null;
            } catch (Exception e) {
                try {
                    this.f839a = e.getMessage();
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
            try {
                super.onPostExecute(result);
            } catch (Exception e) {
                Toast.makeText(MikrotikLoginActivity.this, e.getMessage(), 1).show();
            }
        }
    }

    public void s() {
        try {
            if (ml0.a(this, "device_token").equals("") || ml0.a(this, "device_token") == null) {
                String device_token = FirebaseInstanceId.b().c();
                ml0.b(this, "device_token", "" + FirebaseInstanceId.b().c());
                Log.d("FCM", "Failed to complete token refresh: " + device_token);
            } else {
                String device_token2 = ml0.a(this, "device_token");
                Log.d("FCM", "GCM Registration Token: " + device_token2);
            }
        } catch (Exception e2) {
            Log.d("FCM", "Failed to complete token refresh");
        }
        try {
            String device_UDID = Settings.Secure.getString(getContentResolver(), "android_id");
            Log.d("FCM", "Device UDID:" + device_UDID);
            ml0.b(this, "device_id", "" + device_UDID);
        } catch (Exception e3) {
            e3.printStackTrace();
            Log.d("FCM", "Failed to complete device UDID");
        }
    }

    private void q() {
        try {
            com.google.firebase.firestore.h.g().a("Version").a("v").e(p.SERVER).b(new f());
        } catch (Exception e2) {
        }
    }

    class f implements o40<com.google.firebase.firestore.f> {
        f() {
        }

        public void a(eq0<com.google.firebase.firestore.f> task) {
            if (task.r()) {
                com.google.firebase.firestore.f document = task.n();
                if (document == null) {
                    throw new AssertionError();
                } else if (document.g()) {
                    Map<String, Object> j = document.j();
                    Objects.requireNonNull(j);
                    String v = (String) j.get(ClientCookie.VERSION_ATTR);
                    if (v != null) {
                        double vv = Double.parseDouble(v);
                        String url = (String) document.j().get("url");
                        if (Double.parseDouble("8.0") < vv) {
                            MikrotikLoginActivity.this.r(url);
                            return;
                        }
                        return;
                    }
                    throw new AssertionError();
                }
            }
        }
    }

    public void r(String url) {
        try {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
            View myView = getLayoutInflater().inflate(R.layout.exit_pop, (ViewGroup) null);
            dialogBuilder.setView(myView);
            TextView button1 = (TextView) myView.findViewById(R.id.yes1);
            button1.setText("تحميل الان");
            ((TextView) myView.findViewById(R.id.with_keep)).setVisibility(8);
            TextView button3 = (TextView) myView.findViewById(R.id.no1);
            button3.setText("إلغاء");
            ((TextView) myView.findViewById(R.id.msg_txt)).setText("يوجد تحديث جديد للبرنامج ..يمكنك تحميله الان.");
            androidx.appcompat.app.AlertDialog b2 = dialogBuilder.create();
            b2.show();
            button1.setOnClickListener(new g(url));
            button3.setOnClickListener(new t10(b2));
        } catch (Exception e2) {
        }
    }

    class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ String f834a;

        g(String str) {
            this.f834a = str;
        }

        public void onClick(View v) {
            try {
                Intent i = new Intent("android.intent.action.VIEW");
                i.setData(Uri.parse(this.f834a));
                MikrotikLoginActivity.this.startActivity(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
