package com.blogspot.yemeninfo4it.mumsmobile_app.activities;

import android.app.ProgressDialog;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.mk_log;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Mer;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UserData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.IOException;
import java.net.NetworkInterface;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class FirebaseLoginActivity extends mk_log {
    public static ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    Button f715a;

    /* renamed from: a  reason: collision with other field name */
    EditText f716a;

    /* renamed from: a  reason: collision with other field name */
    ImageView f717a;

    /* renamed from: a  reason: collision with other field name */
    TextView f718a;

    /* renamed from: a  reason: collision with other field name */
    p f719a;

    /* renamed from: a  reason: collision with other field name */
    FirebaseAuth f720a;

    /* renamed from: a  reason: collision with other field name */
    ArrayList<UserData> f721a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public od f722a;

    /* renamed from: a  reason: collision with other field name */
    ue f723a;

    /* renamed from: a  reason: collision with other field name */
    boolean f724a = false;
    int b = 1;

    /* renamed from: b  reason: collision with other field name */
    EditText f725b;

    /* renamed from: b  reason: collision with other field name */
    ImageView f726b;

    /* renamed from: b  reason: collision with other field name */
    TextView f727b;

    /* renamed from: b  reason: collision with other field name */
    String f728b = "s";
    EditText c;

    /* renamed from: c  reason: collision with other field name */
    TextView f729c;

    /* renamed from: c  reason: collision with other field name */
    String f730c = "no";
    EditText d;

    /* renamed from: d  reason: collision with other field name */
    TextView f731d;

    /* renamed from: d  reason: collision with other field name */
    String f732d = "";
    String e = "";
    String f;
    String g = null;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.firebase_login);
        s();
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                getWindow().getDecorView().setSystemUiVisibility(1280);
            }
            this.f720a = FirebaseAuth.getInstance();
            a = new ProgressDialog(this);
            this.f721a = new ArrayList<>();
            this.f723a = new ue(this);
            this.f717a = (ImageView) findViewById(R.id.eye_img);
            this.f726b = (ImageView) findViewById(R.id.countryImage);
            this.f716a = (EditText) findViewById(R.id.ed_password);
            this.f715a = (Button) findViewById(R.id.login_btn);
            this.f725b = (EditText) findViewById(R.id.ed_mobile_number);
            this.f727b = (TextView) findViewById(R.id.donnot_have_account);
            this.f729c = (TextView) findViewById(R.id.forgot_password);
            this.f731d = (TextView) findViewById(R.id.mykey_btn);
            this.c = (EditText) findViewById(R.id.name);
            this.d = (EditText) findViewById(R.id.countryNumber);
            this.f718a = (TextView) findViewById(R.id.back_img);
            this.f722a = od.l("Select Country");
            List<md> b2 = md.b();
            Collections.sort(b2, new g());
            this.f722a.n(b2);
            w();
            this.f727b.setOnClickListener(new h());
            this.f717a.setOnClickListener(new i());
            this.f729c.setOnClickListener(new j());
            this.f715a.setOnClickListener(new k());
            this.f731d.setOnClickListener(new l());
        } catch (Exception e2) {
            Toast.makeText(this, e2.getMessage().toString(), 1).show();
        }
    }

    class g implements Comparator<md> {
        g() {
        }

        /* renamed from: a */
        public int compare(md s1, md s2) {
            return s1.h().compareToIgnoreCase(s2.h());
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        public void onClick(View v) {
            qb0.f4817d = false;
            FirebaseLoginActivity.this.startActivity(new Intent(FirebaseLoginActivity.this, PhoneAuthActivity.class));
        }
    }

    class i implements View.OnClickListener {
        i() {
        }

        public void onClick(View v) {
            FirebaseLoginActivity firebaseLoginActivity = FirebaseLoginActivity.this;
            if (firebaseLoginActivity.b == 1) {
                firebaseLoginActivity.f716a.setTransformationMethod((TransformationMethod) null);
                FirebaseLoginActivity firebaseLoginActivity2 = FirebaseLoginActivity.this;
                firebaseLoginActivity2.f717a.setImageDrawable(ContextCompat.getDrawable(firebaseLoginActivity2, R.drawable.ic_eye_close));
                FirebaseLoginActivity.this.f717a.setTag(0);
                FirebaseLoginActivity.this.b = 0;
                return;
            }
            firebaseLoginActivity.b = 1;
            firebaseLoginActivity.f716a.setTransformationMethod(new PasswordTransformationMethod());
            FirebaseLoginActivity firebaseLoginActivity3 = FirebaseLoginActivity.this;
            firebaseLoginActivity3.f717a.setImageDrawable(ContextCompat.getDrawable(firebaseLoginActivity3, R.drawable.ic_eye_open));
        }
    }

    class j implements View.OnClickListener {
        j() {
        }

        public void onClick(View v) {
            FirebaseLoginActivity.this.startActivity(new Intent(FirebaseLoginActivity.this, ForgetPasswordActivity.class));
        }
    }

    class k implements View.OnClickListener {
        k() {
        }

        public void onClick(View v) {
            String unamecode = FirebaseLoginActivity.this.f716a.getText().toString();
            String passcode = FirebaseLoginActivity.this.f725b.getText().toString();
            if (TextUtils.isEmpty(unamecode)) {
                FirebaseLoginActivity.this.f716a.setError("الرجاء تعبئة حقل كلمة السر");
            } else if (TextUtils.isEmpty(passcode)) {
                FirebaseLoginActivity.this.f725b.setError("الرجاء تعبئة حقل رقم الموبايل");
            } else {
                FirebaseLoginActivity firebaseLoginActivity = FirebaseLoginActivity.this;
                firebaseLoginActivity.r(firebaseLoginActivity.f725b.getText().toString());
            }
        }
    }

    class l implements View.OnClickListener {
        l() {
        }

        public void onClick(View v) {
            FirebaseLoginActivity.this.o();
        }
    }

    public String n() {
        return ml0.a(this, "device_id");
    }

    class p extends AsyncTask<Void, Void, Void> {
        int a;

        /* renamed from: a  reason: collision with other field name */
        long f735a;

        /* renamed from: a  reason: collision with other field name */
        String f737a;

        /* renamed from: a  reason: collision with other field name */
        String[] f738a;
        String b;
        String c;
        String d;

        p() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voids) {
            try {
                HttpResponse response = new DefaultHttpClient().execute(new HttpGet("https://google.com/"));
                StatusLine statusLine = response.getStatusLine();
                if (statusLine.getStatusCode() == 200) {
                    String value = response.getFirstHeader("Date").getValue();
                    this.f737a = value;
                    String[] split = value.split(" ");
                    this.f738a = split;
                    int counter = 0;
                    for (String a2 : split) {
                        counter++;
                        Log.e("Time - " + counter, a2.trim());
                        this.a = FirebaseLoginActivity.this.u(this.f738a[2]);
                    }
                    this.b = this.f738a[1] + "/" + this.a + "/" + this.f738a[3];
                    String[] Timee = this.f738a[4].split(":");
                    int hour = Integer.parseInt(Timee[0]);
                    Log.e("Timeee", hour + " -- " + Timee[1] + " --" + Timee[2]);
                    this.f735a = (long) (Integer.parseInt(Timee[2]) + Integer.parseInt(Timee[1]) + hour);
                    this.c = this.f738a[3] + "-" + this.a + "-" + this.f738a[1] + " " + hour + ":" + Timee[1] + ":" + Timee[2];
                    Locale locale = Locale.ENGLISH;
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                    Date myDate = simpleDateFormat.parse(this.c);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", locale);
                    sdf.setTimeZone(TimeZone.getTimeZone("Asia/Aden"));
                    this.d = String.valueOf(sdf.format(myDate));
                    return null;
                }
                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            } catch (ClientProtocolException e) {
                Log.d("Response", e.getMessage());
                return null;
            } catch (IOException e2) {
                Log.d("Response", e2.getMessage());
                return null;
            } catch (ParseException e3) {
                e3.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            String str = this.d;
            if (str != null) {
                FirebaseLoginActivity firebaseLoginActivity = FirebaseLoginActivity.this;
                firebaseLoginActivity.g = str;
                firebaseLoginActivity.k(firebaseLoginActivity.f732d, str, firebaseLoginActivity.f725b.getText().toString());
                return;
            }
            FirebaseLoginActivity firebaseLoginActivity2 = FirebaseLoginActivity.this;
            Toast.makeText(firebaseLoginActivity2, firebaseLoginActivity2.getString(R.string.connect_internet), 1).show();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int u(java.lang.String r3) {
        /*
            r2 = this;
            r0 = 0
            int r1 = r3.hashCode()
            switch(r1) {
                case 66051: goto L_0x007e;
                case 66195: goto L_0x0074;
                case 68578: goto L_0x0069;
                case 70499: goto L_0x005f;
                case 74231: goto L_0x0055;
                case 74849: goto L_0x004b;
                case 74851: goto L_0x0041;
                case 77118: goto L_0x0037;
                case 77125: goto L_0x002d;
                case 78517: goto L_0x0022;
                case 79104: goto L_0x0016;
                case 83006: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0088
        L_0x000a:
            java.lang.String r1 = "Sep"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0008
            r1 = 8
            goto L_0x0089
        L_0x0016:
            java.lang.String r1 = "Oct"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0008
            r1 = 9
            goto L_0x0089
        L_0x0022:
            java.lang.String r1 = "Nov"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0008
            r1 = 10
            goto L_0x0089
        L_0x002d:
            java.lang.String r1 = "May"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0008
            r1 = 4
            goto L_0x0089
        L_0x0037:
            java.lang.String r1 = "Mar"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0008
            r1 = 2
            goto L_0x0089
        L_0x0041:
            java.lang.String r1 = "Jun"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0008
            r1 = 5
            goto L_0x0089
        L_0x004b:
            java.lang.String r1 = "Jul"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0008
            r1 = 6
            goto L_0x0089
        L_0x0055:
            java.lang.String r1 = "Jan"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x0089
        L_0x005f:
            java.lang.String r1 = "Feb"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0008
            r1 = 1
            goto L_0x0089
        L_0x0069:
            java.lang.String r1 = "Dec"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0008
            r1 = 11
            goto L_0x0089
        L_0x0074:
            java.lang.String r1 = "Aug"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0008
            r1 = 7
            goto L_0x0089
        L_0x007e:
            java.lang.String r1 = "Apr"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0008
            r1 = 3
            goto L_0x0089
        L_0x0088:
            r1 = -1
        L_0x0089:
            switch(r1) {
                case 0: goto L_0x00a8;
                case 1: goto L_0x00a6;
                case 2: goto L_0x00a4;
                case 3: goto L_0x00a2;
                case 4: goto L_0x00a0;
                case 5: goto L_0x009e;
                case 6: goto L_0x009c;
                case 7: goto L_0x0099;
                case 8: goto L_0x0096;
                case 9: goto L_0x0093;
                case 10: goto L_0x0090;
                case 11: goto L_0x008d;
                default: goto L_0x008c;
            }
        L_0x008c:
            goto L_0x00aa
        L_0x008d:
            r0 = 12
            goto L_0x00aa
        L_0x0090:
            r0 = 11
            goto L_0x00aa
        L_0x0093:
            r0 = 10
            goto L_0x00aa
        L_0x0096:
            r0 = 9
            goto L_0x00aa
        L_0x0099:
            r0 = 8
            goto L_0x00aa
        L_0x009c:
            r0 = 7
            goto L_0x00aa
        L_0x009e:
            r0 = 6
            goto L_0x00aa
        L_0x00a0:
            r0 = 5
            goto L_0x00aa
        L_0x00a2:
            r0 = 4
            goto L_0x00aa
        L_0x00a4:
            r0 = 3
            goto L_0x00aa
        L_0x00a6:
            r0 = 2
            goto L_0x00aa
        L_0x00a8:
            r0 = 1
        L_0x00aa:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blogspot.yemeninfo4it.mumsmobile_app.activities.FirebaseLoginActivity.u(java.lang.String):int");
    }

    class m implements pd {
        m() {
        }

        public void a(String name, String code, String dialCode, int flagDrawableResID) {
            FirebaseLoginActivity.this.d.setText(dialCode);
            FirebaseLoginActivity.this.f726b.setImageResource(flagDrawableResID);
            FirebaseLoginActivity.this.f722a.dismiss();
        }
    }

    private void w() {
        this.f722a.o(new m());
        this.f726b.setOnClickListener(new n());
        this.d.setOnClickListener(new o());
        v();
    }

    class n implements View.OnClickListener {
        n() {
        }

        public void onClick(View v) {
            FirebaseLoginActivity.this.f722a.show(FirebaseLoginActivity.this.getSupportFragmentManager(), "COUNTRY_PICKER");
        }
    }

    class o implements View.OnClickListener {
        o() {
        }

        public void onClick(View v) {
            FirebaseLoginActivity.this.f722a.show(FirebaseLoginActivity.this.getSupportFragmentManager(), "COUNTRY_PICKER");
        }
    }

    private void v() {
        md country = md.e(this);
        if (country != null) {
            this.f726b.setImageResource(country.g());
            this.d.setText(country.f());
            this.f = country.f();
            return;
        }
        md us = new md("YE", "Yemen", "+967", R.drawable.flag_ye);
        this.f726b.setImageResource(us.g());
        this.d.setText(us.f());
        this.f = us.f();
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(jv0.b(newBase));
    }

    public void r(String k2) {
        try {
            a.setTitle("يرجى الانتظار..");
            a.setMessage("يتم التحقق من البيانات..");
            a.show();
            com.google.firebase.firestore.h.g().a("Users").a(k2).e(com.google.firebase.firestore.p.SERVER).b(new a());
        } catch (Exception e2) {
            Toast.makeText(this, e2.getMessage() + " - 88888", 1).show();
        }
    }

    class a implements o40<com.google.firebase.firestore.f> {
        a() {
        }

        public void a(eq0<com.google.firebase.firestore.f> task) {
            try {
                if (task.r()) {
                    com.google.firebase.firestore.f document = task.n();
                    if (document.g()) {
                        FirebaseLoginActivity.this.f728b = (String) document.j().get(FirebaseLoginActivity.this.getString(R.string.password));
                        FirebaseLoginActivity.this.f730c = (String) document.j().get(FirebaseLoginActivity.this.getString(R.string.status));
                        FirebaseLoginActivity.this.f732d = (String) document.j().get(FirebaseLoginActivity.this.getString(R.string.startdate));
                        FirebaseLoginActivity.this.e = (String) document.j().get(FirebaseLoginActivity.this.getString(R.string.macaddress));
                        try {
                            com.google.firebase.firestore.h.g().a("codes").a("cd").d().b(new C0005a());
                        } catch (Exception e) {
                            FirebaseLoginActivity.a.dismiss();
                            FirebaseLoginActivity firebaseLoginActivity = FirebaseLoginActivity.this;
                            Toast.makeText(firebaseLoginActivity, FirebaseLoginActivity.this.getString(R.string.connect_internet) + " - قم بإيقاف اي برنامج vpn -", 1).show();
                        }
                    } else {
                        FirebaseLoginActivity.a.dismiss();
                        Toast.makeText(FirebaseLoginActivity.this, "خطا في تسجيل الدخول-هذا الحساب غير موجود", 1).show();
                    }
                    return;
                }
                FirebaseLoginActivity.a.dismiss();
                FirebaseLoginActivity firebaseLoginActivity2 = FirebaseLoginActivity.this;
                Toast.makeText(firebaseLoginActivity2, FirebaseLoginActivity.this.getString(R.string.connect_internet) + " - قم بإيقاف اي برنامج vpn -", 1).show();
            } catch (Exception e2) {
                FirebaseLoginActivity firebaseLoginActivity3 = FirebaseLoginActivity.this;
                Toast.makeText(firebaseLoginActivity3, e2.getMessage() + "تاكد من الاتصال بالانترنت - قم بإيقاف اي برنامج vpn ", 1).show();
                FirebaseLoginActivity.a.dismiss();
            }
        }

        /* renamed from: com.blogspot.yemeninfo4it.mumsmobile_app.activities.FirebaseLoginActivity$a$a  reason: collision with other inner class name */
        class C0005a implements o40<com.google.firebase.firestore.f> {
            C0005a() {
            }

            public void a(eq0<com.google.firebase.firestore.f> task) {
                if (task.r()) {
                    com.google.firebase.firestore.f document = task.n();
                    qb0.s.add(new Mer((String) document.j().get("adh"), (String) document.j().get("adm"), (String) document.j().get("ah"), (String) document.j().get("amng"), (String) document.j().get("ac"), (String) document.j().get("asa")));
                    String mac2 = FirebaseLoginActivity.this.n();
                    try {
                        if (mac2.isEmpty()) {
                            mac2 = FirebaseLoginActivity.t();
                        }
                    } catch (Exception e) {
                        mac2 = FirebaseLoginActivity.t();
                    }
                    FirebaseLoginActivity firebaseLoginActivity = FirebaseLoginActivity.this;
                    if (firebaseLoginActivity.f730c.equals(firebaseLoginActivity.l())) {
                        if (FirebaseLoginActivity.this.e.equals(mac2)) {
                            FirebaseLoginActivity firebaseLoginActivity2 = FirebaseLoginActivity.this;
                            if (firebaseLoginActivity2.f728b.equals(firebaseLoginActivity2.f716a.getText().toString())) {
                                FirebaseLoginActivity firebaseLoginActivity3 = FirebaseLoginActivity.this;
                                firebaseLoginActivity3.m(firebaseLoginActivity3.f725b.getText().toString());
                            } else {
                                FirebaseLoginActivity.a.dismiss();
                                Toast.makeText(FirebaseLoginActivity.this, R.string.passowrd_error, 1).show();
                            }
                        } else {
                            FirebaseLoginActivity.a.dismiss();
                            Toast.makeText(FirebaseLoginActivity.this, R.string.user_asing_to_other, 1).show();
                        }
                    } else if (FirebaseLoginActivity.this.e.equals(mac2)) {
                        FirebaseLoginActivity firebaseLoginActivity4 = FirebaseLoginActivity.this;
                        if (firebaseLoginActivity4.f728b.equals(firebaseLoginActivity4.f716a.getText().toString())) {
                            FirebaseLoginActivity.this.f719a = new p();
                            FirebaseLoginActivity.this.f719a.execute(new Void[0]);
                        } else {
                            FirebaseLoginActivity.this.f724a = false;
                            FirebaseLoginActivity.a.dismiss();
                            Toast.makeText(FirebaseLoginActivity.this, R.string.passowrd_error, 1).show();
                        }
                    } else {
                        FirebaseLoginActivity.this.f724a = false;
                        FirebaseLoginActivity.a.dismiss();
                        Toast.makeText(FirebaseLoginActivity.this, R.string.user_asing_to_other, 1).show();
                    }
                    Log.d("ODAI", "Cached document data: " + document.j());
                    return;
                }
                FirebaseLoginActivity.a.dismiss();
                FirebaseLoginActivity firebaseLoginActivity5 = FirebaseLoginActivity.this;
                Toast.makeText(firebaseLoginActivity5, FirebaseLoginActivity.this.getString(R.string.connect_internet) + " - قم بإيقاف اي برنامج vpn -", 1).show();
            }
        }
    }

    public static String t() {
        try {
            for (NetworkInterface nif : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (nif.getName().equalsIgnoreCase("wlan0")) {
                    byte[] macBytes = nif.getHardwareAddress();
                    if (macBytes == null) {
                        return "";
                    }
                    StringBuilder res1 = new StringBuilder();
                    for (byte b2 : macBytes) {
                        res1.append(Integer.toHexString(b2 & 255) + ":");
                    }
                    if (res1.length() > 0) {
                        res1.deleteCharAt(res1.length() - 1);
                    }
                    return res1.toString();
                }
            }
            return "02:00:00:00:00:00";
        } catch (Exception e2) {
            return "02:00:00:00:00:00";
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

    public void o() {
        try {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
            View myView = getLayoutInflater().inflate(R.layout.code_pop, (ViewGroup) null);
            dialogBuilder.setView(myView);
            LinearLayout facebook = (LinearLayout) myView.findViewById(R.id.facebook);
            LinearLayout whatsapp = (LinearLayout) myView.findViewById(R.id.whatsapp);
            LinearLayout mobile_btn = (LinearLayout) myView.findViewById(R.id.mobile_btn);
            EditText mykey = (EditText) myView.findViewById(R.id.mykey);
            TextView mm = (TextView) myView.findViewById(R.id.mm);
            TextView copy_txt = (TextView) myView.findViewById(R.id.copy_txt);
            dialogBuilder.create().show();
            String mkey = n();
            try {
                if (mkey.isEmpty()) {
                    mkey = t();
                }
            } catch (Exception e2) {
                mkey = t();
            }
            try {
                mykey.setText(iw0.d(mkey));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            copy_txt.setOnClickListener(new b(mykey));
            mm.setOnClickListener(new c(mykey));
            whatsapp.setOnClickListener(new d());
            facebook.setOnClickListener(new e());
            mobile_btn.setOnClickListener(new f());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    class b implements View.OnClickListener {
        final /* synthetic */ EditText a;

        b(EditText editText) {
            this.a = editText;
        }

        public void onClick(View v) {
            try {
                if (this.a.getText().toString().trim().length() > 0) {
                    ((ClipboardManager) FirebaseLoginActivity.this.getSystemService("clipboard")).setText(this.a.getText());
                    Toast.makeText(FirebaseLoginActivity.this, "تم النسخ", 0).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class c implements View.OnClickListener {
        final /* synthetic */ EditText a;

        c(EditText editText) {
            this.a = editText;
        }

        public void onClick(View v) {
            try {
                Toast.makeText(FirebaseLoginActivity.this, iw0.a(this.a.getText().toString()), 0).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        public void onClick(View v) {
            try {
                Intent i2 = new Intent("android.intent.action.VIEW");
                i2.setData(Uri.parse("https://api.whatsapp.com/send?phone=+967733474886"));
                FirebaseLoginActivity.this.startActivity(i2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        public void onClick(View v) {
            try {
                Intent i = new Intent("android.intent.action.VIEW");
                i.setData(Uri.parse("https://www.facebook.com/odai.dammag"));
                FirebaseLoginActivity.this.startActivity(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        public void onClick(View v) {
            try {
                Intent intent = new Intent("android.intent.action.DIAL");
                intent.setData(Uri.parse("tel:+967733474886"));
                FirebaseLoginActivity.this.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
