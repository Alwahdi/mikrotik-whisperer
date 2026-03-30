package com.blogspot.yemeninfo4it.mumsmobile_app.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.google.firebase.firestore.f;
import com.google.firebase.firestore.h;
import com.google.firebase.firestore.p;
import com.google.firebase.iid.FirebaseInstanceId;

public class ForgetPasswordActivity extends AppCompatActivity {
    Button a;

    /* renamed from: a  reason: collision with other field name */
    TextView f739a;

    /* renamed from: a  reason: collision with other field name */
    String f740a = "s";
    TextView b;

    /* renamed from: b  reason: collision with other field name */
    String f741b = "no";
    TextView c;

    /* renamed from: c  reason: collision with other field name */
    String f742c = "";
    TextView d;

    /* renamed from: d  reason: collision with other field name */
    String f743d = "";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.forgetpassword_activity);
        l();
        this.f739a = (TextView) findViewById(R.id.recived_password);
        this.d = (TextView) findViewById(R.id.ed_mobile_number);
        this.a = (Button) findViewById(R.id.re_submit);
        this.b = (TextView) findViewById(R.id.back_imgf);
        this.c = (TextView) findViewById(R.id.goto_login_btn);
        this.a.setOnClickListener(new a());
        this.c.setOnClickListener(new b());
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View v) {
            if (ForgetPasswordActivity.this.d.getText().toString().trim().length() > 5) {
                ForgetPasswordActivity.this.m();
            } else {
                Toast.makeText(ForgetPasswordActivity.this, "قم بكتابة رقم الموبايل بشكل صحيح", 0).show();
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View v) {
            Intent intent = new Intent(ForgetPasswordActivity.this, FirebaseLoginActivity.class);
            intent.setFlags(268468224);
            ForgetPasswordActivity.this.startActivity(intent);
            ForgetPasswordActivity.this.finish();
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(jv0.b(newBase));
    }

    public void onBackPressed() {
        Intent intent = new Intent(this, FirebaseLoginActivity.class);
        intent.setFlags(268468224);
        startActivity(intent);
        finish();
    }

    public void m() {
        try {
            h.g().a("Users").a(this.d.getText().toString()).e(p.SERVER).b(new c());
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage().toString() + " حصت مشكلة بالاتصال ..قم بالضغط مره اخرى على تسجيل ", 0).show();
        }
    }

    class c implements o40<f> {
        c() {
        }

        public void a(eq0<f> task) {
            try {
                f document = task.n();
                if (document.g()) {
                    ForgetPasswordActivity.this.f743d = (String) document.j().get(ForgetPasswordActivity.this.getString(R.string.macaddress));
                    if (ForgetPasswordActivity.this.j().equals(ForgetPasswordActivity.this.f743d)) {
                        ForgetPasswordActivity.this.f740a = (String) document.j().get(ForgetPasswordActivity.this.getString(R.string.password));
                        ForgetPasswordActivity.this.f739a.setVisibility(0);
                        ForgetPasswordActivity forgetPasswordActivity = ForgetPasswordActivity.this;
                        forgetPasswordActivity.f739a.setText(forgetPasswordActivity.f740a);
                        ForgetPasswordActivity.this.b.setText("تم كتابة كلمة السر بالاسفل .. قم بنسخها");
                        Toast.makeText(ForgetPasswordActivity.this, "تم جلب كلمة السر", 0).show();
                        return;
                    }
                    Toast.makeText(ForgetPasswordActivity.this, "هذا الحساب غير مرتبط بجهازك", 0).show();
                    return;
                }
                Toast.makeText(ForgetPasswordActivity.this, "الحساب غير موجود", 0).show();
            } catch (Exception ex) {
                ForgetPasswordActivity forgetPasswordActivity2 = ForgetPasswordActivity.this;
                Toast.makeText(forgetPasswordActivity2, ex.getMessage().toString() + " حصت مشكلة بالاتصال .. ", 0).show();
            }
        }
    }

    public void l() {
        try {
            if (ml0.a(this, "device_token").equals("") || ml0.a(this, "device_token") == null) {
                String device_token = FirebaseInstanceId.b().c();
                ml0.b(this, "device_token", "" + FirebaseInstanceId.b().c());
                Log.d("FCM", "Failed to complete token refresh: " + device_token);
            } else {
                String device_token2 = ml0.a(this, "device_token");
                Log.d("FCM", "GCM Registration Token: " + device_token2);
            }
        } catch (Exception e) {
            Log.d("FCM", "Failed to complete token refresh");
        }
        try {
            String device_UDID = Settings.Secure.getString(getContentResolver(), "android_id");
            Log.d("FCM", "Device UDID:" + device_UDID);
            ml0.b(this, "device_id", "" + device_UDID);
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.d("FCM", "Failed to complete device UDID");
        }
    }

    /* access modifiers changed from: private */
    public String j() {
        return ml0.a(this, "device_id");
    }
}
