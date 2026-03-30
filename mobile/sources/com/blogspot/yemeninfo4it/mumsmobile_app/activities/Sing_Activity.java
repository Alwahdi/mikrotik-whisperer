package com.blogspot.yemeninfo4it.mumsmobile_app.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UserData;
import com.google.firebase.firestore.h;
import com.google.firebase.firestore.p;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.IOException;
import java.net.NetworkInterface;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Sing_Activity extends AppCompatActivity {
    int a = 1;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f1168a;

    /* renamed from: a  reason: collision with other field name */
    Context f1169a;

    /* renamed from: a  reason: collision with other field name */
    Button f1170a;

    /* renamed from: a  reason: collision with other field name */
    EditText f1171a;

    /* renamed from: a  reason: collision with other field name */
    ImageView f1172a;

    /* renamed from: a  reason: collision with other field name */
    TextView f1173a;

    /* renamed from: a  reason: collision with other field name */
    g f1174a;

    /* renamed from: a  reason: collision with other field name */
    final String f1175a = "mLog";

    /* renamed from: a  reason: collision with other field name */
    ArrayList<UserData> f1176a;

    /* renamed from: a  reason: collision with other field name */
    ue f1177a;

    /* renamed from: a  reason: collision with other field name */
    boolean f1178a = false;
    EditText b;

    /* renamed from: b  reason: collision with other field name */
    TextView f1179b;

    /* renamed from: b  reason: collision with other field name */
    String f1180b = null;

    /* renamed from: b  reason: collision with other field name */
    boolean f1181b = false;
    EditText c;

    /* renamed from: c  reason: collision with other field name */
    boolean f1182c = false;
    EditText d;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView((int) R.layout.singin_layout);
            this.f1169a = this;
            n();
            int i = Build.VERSION.SDK_INT;
            if (i >= 21) {
                getWindow().getDecorView().setSystemUiVisibility(1280);
            }
            this.f1168a = new ProgressDialog(this);
            if (i >= 23) {
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA", "android.permission.ACCESS_WIFI_STATE"}, 0);
            }
            this.f1176a = new ArrayList<>();
            this.f1177a = new ue(this);
            this.f1172a = (ImageView) findViewById(R.id.eye_img);
            this.f1171a = (EditText) findViewById(R.id.ed_password);
            this.f1170a = (Button) findViewById(R.id.login_btn);
            this.b = (EditText) findViewById(R.id.ed_mobile_number);
            this.f1179b = (TextView) findViewById(R.id.have_account);
            this.c = (EditText) findViewById(R.id.name);
            this.d = (EditText) findViewById(R.id.countryNumber);
            this.f1173a = (TextView) findViewById(R.id.back_img);
            this.d.setText(qb0.k);
            this.b.setText(qb0.j);
            this.f1172a.setOnClickListener(new a());
            this.f1179b.setOnClickListener(new b());
            this.f1170a.setOnClickListener(new c());
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage().toString(), 0).show();
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View v) {
            Sing_Activity sing_Activity = Sing_Activity.this;
            if (sing_Activity.a == 1) {
                sing_Activity.f1171a.setTransformationMethod((TransformationMethod) null);
                Sing_Activity sing_Activity2 = Sing_Activity.this;
                sing_Activity2.f1172a.setImageDrawable(ContextCompat.getDrawable(sing_Activity2, R.drawable.ic_eye_close));
                Sing_Activity.this.f1172a.setTag(0);
                Sing_Activity.this.a = 0;
                return;
            }
            sing_Activity.a = 1;
            sing_Activity.f1171a.setTransformationMethod(new PasswordTransformationMethod());
            Sing_Activity sing_Activity3 = Sing_Activity.this;
            sing_Activity3.f1172a.setImageDrawable(ContextCompat.getDrawable(sing_Activity3, R.drawable.ic_eye_open));
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View v) {
            Sing_Activity.this.startActivity(new Intent(Sing_Activity.this, FirebaseLoginActivity.class));
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View v) {
            String transmation_limit_tx = Sing_Activity.this.c.getText().toString();
            String passwordE = Sing_Activity.this.f1171a.getText().toString();
            String countryNu = Sing_Activity.this.d.getText().toString();
            String ed_mobile_num = Sing_Activity.this.b.getText().toString();
            if (TextUtils.isEmpty(transmation_limit_tx)) {
                Sing_Activity.this.c.setError("الرجاء تعبئة هذا الحقل");
            } else if (TextUtils.isEmpty(passwordE)) {
                Sing_Activity.this.f1171a.setError("الرجاء تعبئة هذا الحقل");
            } else if (TextUtils.isEmpty(countryNu)) {
                Sing_Activity.this.d.setError("الرجاء تعبئة هذا الحقل");
            } else if (TextUtils.isEmpty(ed_mobile_num)) {
                Sing_Activity.this.b.setError("الرجاء تعبئة هذا الحقل");
            } else {
                Sing_Activity.this.f1168a.setTitle("يرجى الانتظار..");
                Sing_Activity.this.f1168a.setMessage("يتم التحقق من البيانات..");
                try {
                    if (Sing_Activity.this.j().isEmpty()) {
                        String sdasd = Sing_Activity.o();
                    }
                } catch (Exception e) {
                    String sdasd2 = Sing_Activity.o();
                }
                Sing_Activity.this.f1168a.show();
                Sing_Activity sing_Activity = Sing_Activity.this;
                if (sing_Activity.f1180b != null) {
                    sing_Activity.m(sing_Activity.b.getText().toString());
                    return;
                }
                sing_Activity.f1174a = new g();
                Sing_Activity.this.f1174a.execute(new Void[0]);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(jv0.b(newBase));
    }

    class g extends AsyncTask<Void, Void, Void> {
        int a;

        /* renamed from: a  reason: collision with other field name */
        long f1184a;

        /* renamed from: a  reason: collision with other field name */
        String f1186a;

        /* renamed from: a  reason: collision with other field name */
        String[] f1187a;
        String b;
        String c;
        String d;

        g() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voids) {
            try {
                HttpResponse response = new DefaultHttpClient().execute(new HttpGet("https://google.com/"));
                StatusLine statusLine = response.getStatusLine();
                if (statusLine.getStatusCode() == 200) {
                    String value = response.getFirstHeader("Date").getValue();
                    this.f1186a = value;
                    String[] split = value.split(" ");
                    this.f1187a = split;
                    int counter = 0;
                    for (String a2 : split) {
                        counter++;
                        Log.e("Time - " + counter, a2.trim());
                        this.a = Sing_Activity.this.p(this.f1187a[2]);
                    }
                    this.b = this.f1187a[1] + "/" + this.a + "/" + this.f1187a[3];
                    String[] Timee = this.f1187a[4].split(":");
                    int hour = Integer.parseInt(Timee[0]);
                    Log.e("Timeee", hour + " -- " + Timee[1] + " --" + Timee[2]);
                    this.f1184a = (long) (Integer.parseInt(Timee[2]) + Integer.parseInt(Timee[1]) + hour);
                    this.c = this.f1187a[3] + "-" + this.a + "-" + this.f1187a[1] + " " + hour + ":" + Timee[1] + ":" + Timee[2];
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
                Sing_Activity sing_Activity = Sing_Activity.this;
                sing_Activity.f1180b = str;
                sing_Activity.m(sing_Activity.b.getText().toString());
                return;
            }
            Sing_Activity sing_Activity2 = Sing_Activity.this;
            Toast.makeText(sing_Activity2, sing_Activity2.getString(R.string.connect_internet2), 1).show();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int p(java.lang.String r3) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.blogspot.yemeninfo4it.mumsmobile_app.activities.Sing_Activity.p(java.lang.String):int");
    }

    public void m(String k) {
        try {
            String mac = j();
            try {
                if (mac.isEmpty()) {
                    mac = o();
                }
            } catch (Exception e2) {
                mac = o();
            }
            if (!mac.isEmpty()) {
                h.g().a("mac").a(mac).d().b(new d(k));
            } else {
                Toast.makeText(this, getString(R.string.cannt_regis), 0).show();
            }
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage().toString(), 0).show();
        }
    }

    class d implements o40<com.google.firebase.firestore.f> {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ String f1183a;

        d(String str) {
            this.f1183a = str;
        }

        public void a(eq0<com.google.firebase.firestore.f> task) {
            try {
                if (!task.n().g()) {
                    h.g().a("Users").a(this.f1183a).e(p.SERVER).b(new a());
                    return;
                }
                Sing_Activity.this.f1168a.dismiss();
                Sing_Activity sing_Activity = Sing_Activity.this;
                Toast.makeText(sing_Activity, sing_Activity.getString(R.string.no_registar), 0).show();
            } catch (Exception ex) {
                Sing_Activity sing_Activity2 = Sing_Activity.this;
                sing_Activity2.f1181b = false;
                Toast.makeText(sing_Activity2, ex.getMessage().toString() + " حصت مشكلة بالاتصال .. ", 0).show();
            }
        }

        class a implements o40<com.google.firebase.firestore.f> {
            a() {
            }

            public void a(eq0<com.google.firebase.firestore.f> task) {
                try {
                    if (task.r()) {
                        if (!task.n().g()) {
                            Sing_Activity sing_Activity = Sing_Activity.this;
                            sing_Activity.f1178a = false;
                            if (sing_Activity.c.getText().toString().trim().isEmpty() || Sing_Activity.this.f1171a.getText().toString().trim().isEmpty() || Sing_Activity.this.d.getText().toString().trim().isEmpty() || Sing_Activity.this.b.getText().toString().trim().isEmpty()) {
                                Sing_Activity sing_Activity2 = Sing_Activity.this;
                                Toast.makeText(sing_Activity2, sing_Activity2.getString(R.string.fill_all), 0).show();
                            } else {
                                h db2 = h.g();
                                String mac = Sing_Activity.this.j();
                                try {
                                    if (mac.isEmpty()) {
                                        mac = Sing_Activity.o();
                                    }
                                } catch (Exception e) {
                                    mac = Sing_Activity.o();
                                }
                                Map<String, Object> timestamp = new HashMap<>();
                                timestamp.put("timestamp", com.google.firebase.firestore.g.b());
                                String devicetoken = FirebaseInstanceId.b().c();
                                String obj = Sing_Activity.this.c.getText().toString();
                                String obj2 = Sing_Activity.this.f1171a.getText().toString();
                                db2.a("Users").a(d.this.f1183a).l(new UserData(obj, obj2, Sing_Activity.this.d.getText().toString() + Sing_Activity.this.b.getText().toString(), Sing_Activity.this.f1180b, mac, "open", timestamp, devicetoken)).g(new b()).e(new C0007a());
                            }
                        } else {
                            Sing_Activity sing_Activity3 = Sing_Activity.this;
                            sing_Activity3.f1178a = true;
                            sing_Activity3.f1168a.dismiss();
                            Sing_Activity sing_Activity4 = Sing_Activity.this;
                            Toast.makeText(sing_Activity4, sing_Activity4.getString(R.string.you_cant), 1).show();
                        }
                        return;
                    }
                    Sing_Activity sing_Activity5 = Sing_Activity.this;
                    Toast.makeText(sing_Activity5, sing_Activity5.getString(R.string.connect_internet), 1).show();
                } catch (Exception e2) {
                    Toast.makeText(Sing_Activity.this, e2.getMessage(), 1).show();
                    Sing_Activity.this.f1168a.dismiss();
                }
            }

            class b implements t40<Void> {
                b() {
                }

                /* renamed from: a */
                public void e(Void aVoid) {
                    Sing_Activity.this.f1168a.dismiss();
                    Sing_Activity.this.f1177a.a0("user_data");
                    Sing_Activity sing_Activity = Sing_Activity.this;
                    sing_Activity.f1177a.U(sing_Activity.c.getText().toString(), Sing_Activity.this.f1171a.getText().toString(), Sing_Activity.this.b.getText().toString(), "no");
                    Sing_Activity.this.q();
                    Sing_Activity sing_Activity2 = Sing_Activity.this;
                    Toast.makeText(sing_Activity2, sing_Activity2.getString(R.string.ok_secuss), 0).show();
                    Sing_Activity.this.startActivity(new Intent(Sing_Activity.this, FirebaseLoginActivity.class));
                }
            }

            /* renamed from: com.blogspot.yemeninfo4it.mumsmobile_app.activities.Sing_Activity$d$a$a  reason: collision with other inner class name */
            class C0007a implements r40 {
                C0007a() {
                }

                public void b(Exception e) {
                    Sing_Activity.this.f1168a.dismiss();
                    Sing_Activity sing_Activity = Sing_Activity.this;
                    Toast.makeText(sing_Activity, Sing_Activity.this.getString(R.string.conn_prob) + e.getMessage(), 0).show();
                }
            }
        }
    }

    public String j() {
        return ml0.a(this, "device_id");
    }

    public void q() {
        String mac = j();
        try {
            if (mac.isEmpty()) {
                mac = o();
            }
        } catch (Exception e2) {
            mac = o();
        }
        try {
            h db = h.g();
            String devicetoken = FirebaseInstanceId.b().c();
            Map<String, Object> timestamp = new HashMap<>();
            timestamp.put("timestamp", com.google.firebase.firestore.g.b());
            String obj = this.c.getText().toString();
            String obj2 = this.f1171a.getText().toString();
            db.a("mac").a(mac).l(new UserData(obj, obj2, this.d.getText().toString() + this.b.getText().toString(), this.f1180b, mac, "open", timestamp, devicetoken)).g(new f()).e(new e());
        } catch (Exception e3) {
            String mac2 = o();
        }
    }

    class f implements t40<Void> {
        f() {
        }

        /* renamed from: a */
        public void e(Void aVoid) {
            Sing_Activity sing_Activity = Sing_Activity.this;
            Toast.makeText(sing_Activity, sing_Activity.getString(R.string.ok_secuss), 0).show();
        }
    }

    class e implements r40 {
        e() {
        }

        public void b(Exception e) {
            Sing_Activity.this.f1168a.dismiss();
        }
    }

    public static String o() {
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

    public void n() {
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
