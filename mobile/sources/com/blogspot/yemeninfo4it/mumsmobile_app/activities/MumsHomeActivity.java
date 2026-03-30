package com.blogspot.yemeninfo4it.mumsmobile_app.activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.blogspot.yemeninfo4it.mumsmobile_app.AsyncClasses.UserManagerAsync;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.ActiveUser;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.DeleteUser;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Interface;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanCustomer;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanProfile;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards;
import com.blogspot.yemeninfo4it.mumsmobile_app.service.MyLocation;
import com.google.android.material.tabs.TabLayout;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MumsHomeActivity extends AppCompatActivity {
    ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    Context f841a;

    /* renamed from: a  reason: collision with other field name */
    Handler f842a;

    /* renamed from: a  reason: collision with other field name */
    ImageView f843a;

    /* renamed from: a  reason: collision with other field name */
    LinearLayout f844a;

    /* renamed from: a  reason: collision with other field name */
    RadioButton f845a;

    /* renamed from: a  reason: collision with other field name */
    TextView f846a;

    /* renamed from: a  reason: collision with other field name */
    ViewPager2 f847a;

    /* renamed from: a  reason: collision with other field name */
    UserManagerAsync f848a;

    /* renamed from: a  reason: collision with other field name */
    n f849a;

    /* renamed from: a  reason: collision with other field name */
    o f850a;

    /* renamed from: a  reason: collision with other field name */
    p f851a;

    /* renamed from: a  reason: collision with other field name */
    TabLayout f852a;

    /* renamed from: a  reason: collision with other field name */
    CircularProgressBar f853a;

    /* renamed from: a  reason: collision with other field name */
    j3 f854a;

    /* renamed from: a  reason: collision with other field name */
    ArrayList<ActiveUser> f855a;

    /* renamed from: a  reason: collision with other field name */
    Map<String, String> f856a;

    /* renamed from: a  reason: collision with other field name */
    lu0 f857a;

    /* renamed from: a  reason: collision with other field name */
    ue f858a;
    ProgressDialog b;

    /* renamed from: b  reason: collision with other field name */
    LinearLayout f859b;

    /* renamed from: b  reason: collision with other field name */
    RadioButton f860b;

    /* renamed from: b  reason: collision with other field name */
    TextView f861b;

    /* renamed from: b  reason: collision with other field name */
    ArrayList<UsermanProfile> f862b;
    TextView c;

    /* renamed from: c  reason: collision with other field name */
    ArrayList<UsermanCustomer> f863c;
    TextView d;

    /* renamed from: d  reason: collision with other field name */
    ArrayList<UsermanagerCards> f864d;
    TextView e;

    /* renamed from: e  reason: collision with other field name */
    ArrayList<HotspotCard> f865e;
    TextView f;

    /* renamed from: f  reason: collision with other field name */
    ArrayList<DeleteUser> f866f;
    TextView g;
    TextView h;
    TextView i;
    TextView j;
    TextView k;
    TextView l;
    TextView m;
    TextView n;

    public native String ErtM();

    static {
        System.loadLibrary("native-lib");
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        Bundle bundle = getIntent().getExtras();
        boolean z = bundle.getBoolean(ErtM());
        this.f841a = this;
        this.f854a = qb0.d();
        this.f855a = new ArrayList<>();
        this.f862b = new ArrayList<>();
        this.f863c = new ArrayList<>();
        this.f864d = new ArrayList<>();
        this.f865e = new ArrayList<>();
        this.f866f = new ArrayList<>();
        this.f842a = new Handler();
        this.f858a = new ue(this.f841a);
        getWindow().setSoftInputMode(3);
        this.c = (TextView) findViewById(R.id.activeacount);
        this.d = (TextView) findViewById(R.id.disconnected);
        this.e = (TextView) findViewById(R.id.card_used_count);
        this.f = (TextView) findViewById(R.id.card_unused_count);
        this.g = (TextView) findViewById(R.id.expire_card_used_count);
        this.h = (TextView) findViewById(R.id.cpu_txt_value);
        this.k = (TextView) findViewById(R.id.hots_totle_card_used_count);
        this.i = (TextView) findViewById(R.id.hots_card_used_count);
        this.j = (TextView) findViewById(R.id.hots_card_unused_count);
        this.f844a = (LinearLayout) findViewById(R.id.userman_cards_details);
        this.f859b = (LinearLayout) findViewById(R.id.hots_cards_details);
        this.l = (TextView) findViewById(R.id.uptime_txt);
        this.f845a = (RadioButton) findViewById(R.id.userman_check);
        this.f860b = (RadioButton) findViewById(R.id.hots_check);
        this.m = (TextView) findViewById(R.id.userman_check1);
        this.n = (TextView) findViewById(R.id.hots_check1);
        this.f847a = (ViewPager2) findViewById(R.id.viewpager1);
        this.f852a = (TabLayout) findViewById(R.id.tablayout1);
        this.f846a = (TextView) findViewById(R.id.show_aboutme);
        this.f861b = (TextView) findViewById(R.id.app_name_version);
        this.f843a = (ImageView) findViewById(R.id.logout_btn);
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.a = progressDialog;
        progressDialog.setProgressStyle(1);
        ProgressDialog progressDialog2 = new ProgressDialog(this);
        this.b = progressDialog2;
        progressDialog2.setProgressStyle(1);
        this.f853a = (CircularProgressBar) findViewById(R.id.circularProgressBar);
        this.f852a.setTabGravity(0);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/HacenCasablanca.ttf");
        TabLayout tabLayout = this.f852a;
        tabLayout.i(tabLayout.D().o("القائمة"));
        TabLayout tabLayout2 = this.f852a;
        tabLayout2.i(tabLayout2.D().o("المستخدمين النشطين"));
        TabLayout tabLayout3 = this.f852a;
        tabLayout3.i(tabLayout3.D().o("اجهزة البث"));
        TabLayout tabLayout4 = this.f852a;
        tabLayout4.i(tabLayout4.D().o("قائمة الحظر"));
        TabLayout tabLayout5 = this.f852a;
        tabLayout5.i(tabLayout5.D().o("معلومات الراوتر"));
        this.f861b.setText("MUMS Mobile(8.0)");
        this.f861b.setOnClickListener(new e());
        if (!qb0.f4813c) {
            qb0.a(this);
        }
        if (qb0.s.size() <= 0) {
            qb0.a(this);
        }
        this.f847a.setPageTransformer(new gw0());
        this.f847a.setAdapter(new ip0(getSupportFragmentManager(), getLifecycle()));
        this.f847a.setOrientation(0);
        try {
            Field recyclerViewField = ViewPager2.class.getDeclaredField("mRecyclerView");
            recyclerViewField.setAccessible(true);
            RecyclerView recyclerView = (RecyclerView) recyclerViewField.get(this.f847a);
            Field touchSlopField = RecyclerView.class.getDeclaredField("mTouchSlop");
            touchSlopField.setAccessible(true);
            touchSlopField.set(recyclerView, Integer.valueOf(((Integer) touchSlopField.get(recyclerView)).intValue() * 5));
        } catch (Exception e2) {
        }
        try {
            G(this.f852a, 20, 40);
            this.f847a.setOffscreenPageLimit(5);
            this.f852a.h(new f());
            this.f847a.registerOnPageChangeCallback(new g());
            for (int i2 = 0; i2 < this.f852a.getTabCount(); i2++) {
                TabLayout.g tab = this.f852a.A(i2);
                if (tab != null) {
                    TextView tabTextView = new TextView(this);
                    tab.m(tabTextView);
                    tabTextView.getLayoutParams().width = -2;
                    tabTextView.getLayoutParams().height = -2;
                    tabTextView.setTypeface(tf);
                    tabTextView.setText(tab.i());
                    tabTextView.setTextColor(Color.parseColor("#e46665"));
                    if (i2 == 0) {
                        tabTextView.setTextColor(Color.parseColor("#306695"));
                    }
                }
            }
            try {
                this.f858a.b0();
            } catch (Exception e3) {
            }
            try {
                LocalBroadcastManager.getInstance(this).registerReceiver(new h(), new IntentFilter(MyLocation.b));
            } catch (Exception e4) {
                Toast.makeText(getApplicationContext(), e4.getMessage(), 0).show();
            }
            try {
                LocalBroadcastManager.getInstance(this).registerReceiver(new i(), new IntentFilter(bf0.b));
            } catch (Exception e5) {
                Toast.makeText(getApplicationContext(), e5.getMessage(), 0).show();
            }
            this.f845a.setOnClickListener(new j());
            this.f860b.setOnClickListener(new k());
            this.d.setOnClickListener(new l());
            this.m.setOnClickListener(new m());
            this.n.setOnClickListener(new a());
            this.f852a.h(new b());
            this.f846a.setOnClickListener(new q20(this));
            this.f843a.setOnClickListener(new n20(this));
            try {
                this.f853a.setOnProgressChangeListener(new j20(this));
            } catch (Exception e6) {
            }
            if (!qb0.f4809b) {
                o oVar = new o();
                this.f850a = oVar;
                oVar.execute(new String[0]);
            } else if (qb0.f4807b == null) {
                Interface interfaceR = qb0.f4798a;
                if (interfaceR != null) {
                    int a2 = interfaceR.getVersion() != null ? Integer.parseInt(qb0.f4798a.getVersion().substring(0, 1)) : 6;
                    this.l.setText(qb0.f4798a.getuptime());
                    if (a2 >= 7) {
                        lu0 lu0 = new lu0(this);
                        this.f857a = lu0;
                        lu0.execute(new Void[0]);
                    } else {
                        UserManagerAsync userManagerAsync = new UserManagerAsync(this);
                        this.f848a = userManagerAsync;
                        userManagerAsync.execute(new Void[0]);
                    }
                } else {
                    UserManagerAsync userManagerAsync2 = new UserManagerAsync(this);
                    this.f848a = userManagerAsync2;
                    userManagerAsync2.execute(new Void[0]);
                }
            }
            try {
                if (Build.VERSION.SDK_INT >= 31) {
                    n nVar = new n();
                    this.f849a = nVar;
                    nVar.execute(new String[0]);
                }
            } catch (Exception e7) {
            }
            p pVar = new p();
            this.f851a = pVar;
            pVar.execute(new Void[0]);
            try {
                bundle.containsKey("restart");
            } catch (Exception e8) {
            }
        } catch (Exception e9) {
            e9.printStackTrace();
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        public void onClick(View v) {
        }
    }

    class f implements TabLayout.d {
        f() {
        }

        public void c(TabLayout.g tab) {
            MumsHomeActivity.this.f847a.setCurrentItem(tab.g());
        }

        public void b(TabLayout.g tab) {
        }

        public void a(TabLayout.g tab) {
        }
    }

    class g extends ViewPager2.OnPageChangeCallback {
        g() {
        }

        public void onPageSelected(int position) {
            TabLayout tabLayout = MumsHomeActivity.this.f852a;
            tabLayout.J(tabLayout.A(position));
        }
    }

    class h extends BroadcastReceiver {
        h() {
        }

        public void onReceive(Context context, Intent intent) {
            String active_count = intent.getStringExtra("active_count");
            if (!active_count.equals("BROKEN")) {
                MumsHomeActivity.this.d.setText("متصل");
                MumsHomeActivity.this.d.setTextColor(Color.parseColor("#26B355"));
                TextView textView = MumsHomeActivity.this.c;
                textView.setText("المستخدمين النشطين : " + active_count);
                return;
            }
            MumsHomeActivity.this.d.setText("تم قطع الاتصال");
            MumsHomeActivity.this.d.setTextColor(Color.parseColor("#FF5722"));
        }
    }

    class i extends BroadcastReceiver {
        i() {
        }

        public void onReceive(Context context, Intent intent) {
            String uptime = intent.getStringExtra("uptime");
            TextView textView = MumsHomeActivity.this.l;
            textView.setText(context.getString(R.string.run_uptim) + uptime.replace("s", " ثانية ").replace("h", " ساعةو ").replace("m", " دقيقةو ").replace("d", " يوم و "));
        }
    }

    class j implements View.OnClickListener {
        j() {
        }

        public void onClick(View v) {
            MumsHomeActivity.this.f845a.setChecked(true);
            MumsHomeActivity.this.f860b.setChecked(false);
            MumsHomeActivity.this.f844a.setVisibility(0);
            MumsHomeActivity.this.f859b.setVisibility(8);
        }
    }

    class k implements View.OnClickListener {
        k() {
        }

        public void onClick(View v) {
            MumsHomeActivity.this.f845a.setChecked(false);
            MumsHomeActivity.this.f860b.setChecked(true);
            MumsHomeActivity.this.f844a.setVisibility(8);
            MumsHomeActivity.this.f859b.setVisibility(0);
        }
    }

    class l implements View.OnClickListener {
        l() {
        }

        public void onClick(View v) {
            if (MumsHomeActivity.this.d.getText().toString().equals("تم قطع الاتصال")) {
                new fp(MumsHomeActivity.this.f841a).execute(new Void[0]);
            }
        }
    }

    class m implements View.OnClickListener {
        m() {
        }

        public void onClick(View v) {
            MumsHomeActivity mumsHomeActivity = MumsHomeActivity.this;
            mumsHomeActivity.m.setBackground(mumsHomeActivity.getResources().getDrawable(R.drawable.btn_checked));
            MumsHomeActivity.this.m.setTextColor(Color.parseColor("#306695"));
            MumsHomeActivity mumsHomeActivity2 = MumsHomeActivity.this;
            mumsHomeActivity2.n.setBackground(mumsHomeActivity2.getResources().getDrawable(R.drawable.btn_unchecked));
            MumsHomeActivity.this.n.setTextColor(Color.parseColor("#FFFFFF"));
            MumsHomeActivity.this.f844a.setVisibility(0);
            MumsHomeActivity.this.f859b.setVisibility(8);
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View v) {
            MumsHomeActivity mumsHomeActivity = MumsHomeActivity.this;
            mumsHomeActivity.m.setBackground(mumsHomeActivity.getResources().getDrawable(R.drawable.btn_unchecked));
            MumsHomeActivity.this.m.setTextColor(Color.parseColor("#FFFFFF"));
            MumsHomeActivity mumsHomeActivity2 = MumsHomeActivity.this;
            mumsHomeActivity2.n.setBackground(mumsHomeActivity2.getResources().getDrawable(R.drawable.btn_checked));
            MumsHomeActivity.this.n.setTextColor(Color.parseColor("#306695"));
            MumsHomeActivity.this.f844a.setVisibility(8);
            MumsHomeActivity.this.f859b.setVisibility(0);
        }
    }

    class b implements TabLayout.d {
        b() {
        }

        public void c(TabLayout.g tab) {
            MumsHomeActivity.this.f847a.setCurrentItem(tab.g());
            TextView text = (TextView) tab.e();
            Typeface tf = Typeface.createFromAsset(MumsHomeActivity.this.getAssets(), "fonts/HacenCasablanca.ttf");
            text.setTextColor(Color.parseColor("#306695"));
            text.setTypeface(tf, 1);
        }

        public void b(TabLayout.g tab) {
            TextView text = (TextView) tab.e();
            Typeface tf = Typeface.createFromAsset(MumsHomeActivity.this.getAssets(), "fonts/HacenCasablanca.ttf");
            text.setTextColor(Color.parseColor("#e46665"));
            text.setTypeface(tf, 0);
        }

        public void a(TabLayout.g tab) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B(View v) {
        try {
            t();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D(View v) {
        try {
            new AlertDialog.Builder(this, R.style.CustomAlertDialog).setIcon(17301543).setTitle("تنبية !").setMessage("هل تريد تسجيل الخروج؟").setPositiveButton("نعم", new k20(this)).setNegativeButton("لا", (DialogInterface.OnClickListener) null).show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C(DialogInterface dialog, int which) {
        if (qb0.f4807b != null) {
            qb0.f4807b = null;
        }
        if (qb0.f4834l != null) {
            qb0.f4834l = null;
        }
        if (qb0.r != null) {
            qb0.r = null;
        }
        if (qb0.p != null) {
            qb0.p = null;
        }
        if (qb0.f4822f != null) {
            qb0.f4822f = null;
        }
        qb0.f4804a = null;
        try {
            Intent intentn = new Intent(this.f841a, MyLocation.class);
            intentn.putExtra("com.google.android.gms.location.sample.locationupdatesforegroundservice.started_from_notification", true);
            startService(intentn);
        } catch (Exception e2) {
        }
        try {
            this.f854a.close();
        } catch (k3 e3) {
        }
        qb0.c(this.f841a);
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            TextView textView = MumsHomeActivity.this.h;
            textView.setText("% " + ((int) MumsHomeActivity.this.f853a.getProgress()));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ jt0 E(Float progress) {
        try {
            runOnUiThread(new c());
        } catch (Exception e2) {
        }
        return jt0.a;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        try {
            if (!qb0.f4813c) {
                qb0.a(this);
            }
            if (qb0.r != null) {
                TextView textView = this.g;
                textView.setText("عدد الكروت منتهية الصلاحية:" + qb0.r.size());
            }
            if (qb0.f4807b != null) {
                TextView textView2 = this.e;
                textView2.setText("الكروت المستخدمة:" + qb0.b);
                TextView textView3 = this.f;
                textView3.setText("الكروت الغير مستخدمة:" + qb0.c);
            }
            try {
                if (qb0.f4834l != null) {
                    TextView textView4 = this.k;
                    textView4.setText("مجموع عدد الكروت :" + (qb0.d + qb0.e));
                    TextView textView5 = this.i;
                    textView5.setText("الكروت المستخدمة :" + qb0.d);
                    TextView textView6 = this.j;
                    textView6.setText("الكروت الغير مستخدمة :" + qb0.e);
                }
            } catch (Exception e2) {
            }
        } catch (Exception e3) {
            Toast.makeText(this, e3.getMessage(), 0).show();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        try {
            p pVar = this.f851a;
            if (pVar != null) {
                pVar.cancel(true);
            }
            o oVar = this.f850a;
            if (oVar != null) {
                oVar.cancel(true);
            }
        } catch (Exception e2) {
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(jv0.b(newBase));
    }

    public void sendOnChannel2(View v) {
    }

    public void G(TabLayout tabLayout, int externalMargin, int internalMargin) {
        View tabStrip = tabLayout.getChildAt(0);
        if (tabStrip instanceof ViewGroup) {
            ViewGroup tabStripGroup = (ViewGroup) tabStrip;
            int childCount = ((ViewGroup) tabStrip).getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View tabView = tabStripGroup.getChildAt(i2);
                tabView.setMinimumWidth(0);
                tabView.setPadding(0, tabView.getPaddingTop(), 0, tabView.getPaddingBottom());
                if (tabView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) tabView.getLayoutParams();
                    if (i2 == 0) {
                        F(layoutParams, externalMargin, internalMargin);
                    } else if (i2 == childCount - 1) {
                        F(layoutParams, internalMargin, externalMargin);
                    } else {
                        F(layoutParams, internalMargin, internalMargin);
                    }
                }
            }
            tabLayout.requestLayout();
        }
    }

    private void F(ViewGroup.MarginLayoutParams layoutParams, int start, int end) {
        layoutParams.setMarginStart(start);
        layoutParams.setMarginEnd(end);
        layoutParams.leftMargin = start;
        layoutParams.rightMargin = end;
    }

    class n extends AsyncTask<String, String, String> {

        /* renamed from: a  reason: collision with other field name */
        String f867a = "";

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f868a = null;

        /* renamed from: a  reason: collision with other field name */
        boolean f869a = false;

        n() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            this.f869a = false;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                if (!MumsHomeActivity.this.f854a.w()) {
                    return null;
                }
                this.f868a = MumsHomeActivity.this.f854a.q(qb0.s.get(0).getAc());
                return null;
            } catch (Exception e) {
                try {
                    this.f869a = true;
                    this.f867a = e.getMessage();
                    return null;
                } catch (Exception e2) {
                    this.f869a = true;
                    this.f867a = e2.getMessage();
                    return null;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            try {
                if (this.f868a != null) {
                    TextView textView = MumsHomeActivity.this.c;
                    textView.setText("المستخدمين النشطين : " + ((String) this.f868a.get(0).get("ret")));
                }
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(MumsHomeActivity.this.getApplicationContext(), e.getMessage(), 0).show();
            }
        }
    }

    public void t() {
        try {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this, R.style.CustomAlertDialog);
            View myView = getLayoutInflater().inflate(R.layout.about_me_pop, (ViewGroup) null);
            dialogBuilder.setView(myView);
            dialogBuilder.create().show();
            ((LinearLayout) myView.findViewById(R.id.whatsapp)).setOnClickListener(new r20(this));
            ((LinearLayout) myView.findViewById(R.id.facebook)).setOnClickListener(new m20(this));
            ((LinearLayout) myView.findViewById(R.id.facebook2)).setOnClickListener(new o20(this));
            ((LinearLayout) myView.findViewById(R.id.mobile_btn)).setOnClickListener(new d());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v(View v) {
        try {
            Intent i2 = new Intent("android.intent.action.VIEW");
            i2.setData(Uri.parse("https://api.whatsapp.com/send?phone=+967733474886"));
            startActivity(i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w(View v) {
        try {
            Intent i2 = new Intent("android.intent.action.VIEW");
            i2.setData(Uri.parse("https://www.facebook.com/odai.dammag"));
            startActivity(i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x(View v) {
        try {
            Intent i2 = new Intent("android.intent.action.VIEW");
            i2.setData(Uri.parse("https://www.facebook.com/yemeninfo4it"));
            startActivity(i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        public void onClick(View v) {
            try {
                Intent intent = new Intent("android.intent.action.DIAL");
                intent.setData(Uri.parse("tel:+967733474886"));
                MumsHomeActivity.this.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class o extends AsyncTask<String, Void, String> {

        /* renamed from: a  reason: collision with other field name */
        List<Map<String, String>> f870a = null;
        List<Map<String, String>> b = null;

        public o() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(String... params) {
            try {
                MumsHomeActivity.this.f854a.J(120000);
                if (!MumsHomeActivity.this.f854a.w()) {
                    return null;
                }
                this.f870a = MumsHomeActivity.this.f854a.q("/tool/user-manager/customer/print return login");
                this.b = MumsHomeActivity.this.f854a.q("/tool/user-manager/profile/print return .id,name,price");
                return null;
            } catch (Exception e) {
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            try {
                List<Map<String, String>> list = this.f870a;
                if (list != null) {
                    for (Map<String, String> res : list) {
                        MumsHomeActivity.this.f863c.add(new UsermanCustomer(res.get("login")));
                    }
                    qb0.q = MumsHomeActivity.this.f863c;
                }
                if (this.f870a != null) {
                    for (Map<String, String> res2 : this.b) {
                        MumsHomeActivity.this.f862b.add(new UsermanProfile(res2.get(".id"), res2.get("name"), res2.get("price")));
                    }
                    qb0.p = MumsHomeActivity.this.f862b;
                }
            } catch (Exception e) {
                e.printStackTrace();
                MumsHomeActivity mumsHomeActivity = MumsHomeActivity.this;
                Toast.makeText(mumsHomeActivity, e.getMessage() + " At Load UserManager", 1).show();
            }
        }
    }

    public class p extends AsyncTask<Void, Void, String> {
        public p() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Void... params) {
            try {
                if (!MumsHomeActivity.this.f854a.w()) {
                    return null;
                }
                MumsHomeActivity.this.f854a.o("/system/resource/monitor", new a());
                return null;
            } catch (Exception e) {
                try {
                    Log.e("ODAIERROR2", "error");
                    return null;
                } catch (Exception e2) {
                    return null;
                }
            }
        }

        class a implements ue0 {
            a() {
            }

            public void c(Map<String, String> result) {
                MumsHomeActivity mumsHomeActivity = MumsHomeActivity.this;
                mumsHomeActivity.f856a = result;
                mumsHomeActivity.runOnUiThread(new d(this, result));
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void e(Map result) {
                if (qb0.f4830i && result.get("cpu-used") != null) {
                    CircularProgressBar circularProgressBar = MumsHomeActivity.this.f853a;
                    String str = (String) result.get("cpu-used");
                    Objects.requireNonNull(str);
                    String str2 = str;
                    circularProgressBar.setProgress((float) Integer.parseInt(str));
                }
            }

            public void b(s10 e) {
                Log.e("ODAIERROR", "An error occurred: " + e.getMessage());
            }

            public void a() {
                Log.e("ODAIERROR_c", "Asynchronous command has finished");
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String result) {
        }
    }

    public void onBackPressed() {
        u();
    }

    public void u() {
        try {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this, R.style.CustomAlertDialog);
            View myView = getLayoutInflater().inflate(R.layout.exit_pop, (ViewGroup) null);
            dialogBuilder.setView(myView);
            androidx.appcompat.app.AlertDialog b2 = dialogBuilder.create();
            b2.show();
            ((TextView) myView.findViewById(R.id.yes1)).setOnClickListener(s20.a);
            ((TextView) myView.findViewById(R.id.with_keep)).setOnClickListener(new p20(this));
            ((TextView) myView.findViewById(R.id.no1)).setOnClickListener(new l20(b2));
        } catch (Exception e2) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z(View v) {
        finish();
    }
}
