package com.blogspot.yemeninfo4it.mumsmobile_app.activities;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.mk;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Mer;
import com.google.firebase.firestore.f;
import com.google.firebase.firestore.h;
import com.google.firebase.firestore.p;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.IOException;
import java.net.NetworkInterface;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Splash_screen extends mk {
    View a;

    /* renamed from: a  reason: collision with other field name */
    ImageView f1188a;

    /* renamed from: a  reason: collision with other field name */
    TextView f1189a;

    /* renamed from: a  reason: collision with other field name */
    c f1190a;

    /* renamed from: a  reason: collision with other field name */
    ue f1191a;
    final int b = 4000;

    /* renamed from: b  reason: collision with other field name */
    TextView f1192b;
    int c = 0;

    /* renamed from: c  reason: collision with other field name */
    TextView f1193c;

    /* renamed from: c  reason: collision with other field name */
    String f1194c = "";
    TextView d;

    /* renamed from: d  reason: collision with other field name */
    String f1195d = "";
    TextView e;

    /* renamed from: e  reason: collision with other field name */
    String f1196e = "";
    TextView f;

    /* renamed from: f  reason: collision with other field name */
    String f1197f = null;

    public native void mdM(int i);

    static {
        System.loadLibrary("native-lib");
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_splash_screen);
        u();
        this.f1191a = new ue(this);
        this.f1188a = (ImageView) findViewById(R.id.logo);
        this.f1189a = (TextView) findViewById(R.id.spl_txt);
        this.e = (TextView) findViewById(R.id.splash_tit);
        this.f = (TextView) findViewById(R.id.myname);
        this.f1193c = (TextView) findViewById(R.id.error_txt);
        this.d = (TextView) findViewById(R.id.re_start);
        this.f1192b = (TextView) findViewById(R.id.call_domain);
        this.a = findViewById(R.id.progressavi);
        this.f1193c.setText("جاري جلب البيانات..");
        this.a.setVisibility(0);
        this.f.setText("برمجة وتصميم م.عدي دماج-00967733474886");
        this.f1189a.setText("نسخة الجوال");
        this.e.setText("Mikrotik User Manager System (MUMS)");
        this.f1192b.setText("مدونة يمن انفو-YemenInfo4IT.blogspot.com");
        try {
            y();
            C();
            this.f1193c.setOnClickListener(mm0.a);
            this.f1192b.setOnClickListener(new lm0(this));
            this.d.setOnClickListener(new a());
            new Handler().postDelayed(new nm0(this), 4000);
        } catch (Exception e2) {
            Toast.makeText(this, e2.toString(), 1).show();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void z(View v) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A(View v) {
        Intent i = new Intent("android.intent.action.VIEW");
        i.setData(Uri.parse("https://yemeninfo4it.blogspot.com/"));
        startActivity(i);
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View v) {
            Splash_screen.this.f1193c.setText("جاري جلب البيانات..");
            Splash_screen.this.a.setVisibility(0);
            Splash_screen.this.d.setVisibility(8);
            Splash_screen splash_screen = Splash_screen.this;
            if (ml0.a(splash_screen, splash_screen.f1276a).equalsIgnoreCase("1")) {
                Splash_screen.this.x();
                return;
            }
            Splash_screen.this.startActivity(new Intent(Splash_screen.this, FirebaseLoginActivity.class));
            Splash_screen.this.finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B() {
        if (ml0.a(this, this.f1276a).equalsIgnoreCase("1")) {
            x();
            return;
        }
        startActivity(new Intent(this, FirebaseLoginActivity.class));
        finish();
    }

    class c extends AsyncTask<Void, Void, Void> {
        int a;

        /* renamed from: a  reason: collision with other field name */
        long f1198a;

        /* renamed from: a  reason: collision with other field name */
        String f1200a;

        /* renamed from: a  reason: collision with other field name */
        String[] f1201a;
        String b;
        String c;
        String d;

        c() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voids) {
            try {
                HttpResponse response = new DefaultHttpClient().execute(new HttpGet("https://google.com/"));
                StatusLine statusLine = response.getStatusLine();
                if (statusLine.getStatusCode() == 200) {
                    String value = response.getFirstHeader("Date").getValue();
                    this.f1200a = value;
                    String[] split = value.split(" ");
                    this.f1201a = split;
                    int counter = 0;
                    for (String str : split) {
                        counter++;
                        this.a = Splash_screen.this.w(this.f1201a[2]);
                    }
                    this.b = this.f1201a[1] + "/" + this.a + "/" + this.f1201a[3];
                    String[] Timee = this.f1201a[4].split(":");
                    int hour = Integer.parseInt(Timee[0]);
                    this.f1198a = (long) (Integer.parseInt(Timee[2]) + Integer.parseInt(Timee[1]) + hour);
                    this.c = this.f1201a[3] + "-" + this.a + "-" + this.f1201a[1] + " " + hour + ":" + Timee[1] + ":" + Timee[2];
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
            Splash_screen splash_screen = Splash_screen.this;
            splash_screen.c++;
            String str = this.d;
            if (str != null) {
                splash_screen.f1197f = str;
                splash_screen.l(splash_screen.f1196e, str);
                return;
            }
            Toast.makeText(splash_screen, splash_screen.getString(R.string.connect_internet), 1).show();
            Splash_screen splash_screen2 = Splash_screen.this;
            if (splash_screen2.c < 5) {
                splash_screen2.f1190a = new c();
                Splash_screen.this.f1190a.execute(new Void[0]);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int w(java.lang.String r3) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.blogspot.yemeninfo4it.mumsmobile_app.activities.Splash_screen.w(java.lang.String):int");
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(jv0.b(newBase));
    }

    public void x() {
        try {
            if (!ml0.a(this, "pho").isEmpty()) {
                t(ml0.a(this, "pho"));
                return;
            }
            startActivity(new Intent(this, FirebaseLoginActivity.class));
            finish();
        } catch (Exception e2) {
            Toast.makeText(this, e2.toString(), 1).show();
        }
    }

    private void t(String k) {
        try {
            h.g().a("Users").a(k).e(p.SERVER).b(new b());
        } catch (Exception e2) {
            TextView textView = this.f1193c;
            textView.setText(getString(R.string.connect_internet) + " يرجى اعادة تشغيل البرنامج ");
            Toast.makeText(this, e2.getMessage() + " - " + getString(R.string.connect_internet), 1).show();
        }
    }

    class b implements o40<f> {
        b() {
        }

        public void a(eq0<f> task) {
            if (task.r()) {
                f document = task.n();
                if (document.g()) {
                    Splash_screen.this.f1194c = (String) document.j().get(Splash_screen.this.getString(R.string.macaddress));
                    Splash_screen.this.f1195d = (String) document.j().get(Splash_screen.this.getString(R.string.status));
                    Splash_screen.this.f1196e = (String) document.j().get(Splash_screen.this.getString(R.string.startdate));
                    try {
                        h.g().a("codes").a("cd").d().b(new a());
                    } catch (Exception e) {
                        TextView textView = Splash_screen.this.f1193c;
                        textView.setText(Splash_screen.this.getString(R.string.connect_internet) + " يرجى اعادة تشغيل البرنامج ");
                        Splash_screen.this.d.setVisibility(0);
                        Splash_screen splash_screen = Splash_screen.this;
                        Toast.makeText(splash_screen, splash_screen.getString(R.string.connect_internet), 1).show();
                    }
                } else {
                    Splash_screen.this.o();
                }
                Log.d("ODAI", "Cached document data: " + document.j());
                return;
            }
            TextView textView2 = Splash_screen.this.f1193c;
            textView2.setText(Splash_screen.this.getString(R.string.connect_internet) + " يرجى اعادة تشغيل البرنامج ");
            Splash_screen.this.d.setVisibility(0);
            Splash_screen splash_screen2 = Splash_screen.this;
            Toast.makeText(splash_screen2, splash_screen2.getString(R.string.connect_internet), 1).show();
        }

        class a implements o40<f> {
            a() {
            }

            public void a(eq0<f> task) {
                if (task.r()) {
                    f document = task.n();
                    qb0.s.add(new Mer((String) document.j().get("adh"), (String) document.j().get("adm"), (String) document.j().get("ah"), (String) document.j().get("amng"), (String) document.j().get("ac"), (String) document.j().get("asa")));
                    String sdsdds = Splash_screen.this.k();
                    try {
                        if (sdsdds.isEmpty()) {
                            sdsdds = Splash_screen.v();
                        }
                    } catch (Exception e) {
                        sdsdds = Splash_screen.v();
                    }
                    if (Splash_screen.this.f1194c.equals(sdsdds)) {
                        Splash_screen splash_screen = Splash_screen.this;
                        if (splash_screen.f1195d.equals(splash_screen.m())) {
                            Toast.makeText(Splash_screen.this, qb0.s.get(0).getAdh(), 1);
                            Splash_screen.this.n();
                            Splash_screen.this.mdM(1);
                            Splash_screen.this.finish();
                        } else {
                            Splash_screen.this.f1190a = new c();
                            Splash_screen.this.f1190a.execute(new Void[0]);
                        }
                    } else {
                        Splash_screen.this.o();
                    }
                    Log.d("ODAI", "Cached document data: " + document.j());
                    return;
                }
                TextView textView = Splash_screen.this.f1193c;
                textView.setText(Splash_screen.this.getString(R.string.connect_internet) + " يرجى اعادة تشغيل البرنامج ");
                Splash_screen.this.d.setVisibility(0);
                Splash_screen splash_screen2 = Splash_screen.this;
                Toast.makeText(splash_screen2, splash_screen2.getString(R.string.connect_internet), 1).show();
            }
        }
    }

    public void y() {
        this.f1188a.setAlpha(1.0f);
        this.f1188a.startAnimation(AnimationUtils.loadAnimation(this, R.anim.mi_fade_in));
    }

    private void C() {
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.f1189a, "alpha", new float[]{0.0f, 1.0f});
        localObjectAnimator.setStartDelay(1700);
        localObjectAnimator.setDuration(1000);
        localObjectAnimator.start();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    public static String v() {
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

    public void u() {
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
}
