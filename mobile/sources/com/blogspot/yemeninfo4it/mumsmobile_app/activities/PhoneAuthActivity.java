package com.blogspot.yemeninfo4it.mumsmobile_app.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.h;
import com.google.firebase.firestore.p;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class PhoneAuthActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewGroup a;

    /* renamed from: a  reason: collision with other field name */
    private Button f871a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public EditText f872a;

    /* renamed from: a  reason: collision with other field name */
    ImageView f873a;

    /* renamed from: a  reason: collision with other field name */
    private TextView f874a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public FirebaseAuth f875a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public h.a f876a;

    /* renamed from: a  reason: collision with other field name */
    private h.b f877a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public String f878a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public od f879a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public boolean f880a = false;
    private ViewGroup b;

    /* renamed from: b  reason: collision with other field name */
    private Button f881b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public EditText f882b;

    /* renamed from: b  reason: collision with other field name */
    private TextView f883b;

    /* renamed from: b  reason: collision with other field name */
    String f884b;

    /* renamed from: b  reason: collision with other field name */
    boolean f885b = false;
    private Button c;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with other field name */
    public EditText f886c;
    private Button d;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_phone_auth);
        if (savedInstanceState != null) {
            onRestoreInstanceState(savedInstanceState);
        }
        y();
        this.a = (ViewGroup) findViewById(R.id.phoneAuthFields);
        this.b = (ViewGroup) findViewById(R.id.signedInButtons);
        this.f874a = (TextView) findViewById(R.id.status);
        this.f883b = (TextView) findViewById(R.id.detail);
        this.f873a = (ImageView) findViewById(R.id.countryImage);
        this.f872a = (EditText) findViewById(R.id.fieldPhoneNumber);
        this.f882b = (EditText) findViewById(R.id.numkey);
        this.f886c = (EditText) findViewById(R.id.fieldVerificationCode);
        this.f871a = (Button) findViewById(R.id.buttonStartVerification);
        this.f881b = (Button) findViewById(R.id.buttonVerifyPhone);
        this.c = (Button) findViewById(R.id.buttonResend);
        this.d = (Button) findViewById(R.id.signOutButton);
        this.f871a.setOnClickListener(this);
        this.f881b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.f879a = od.l("Select Country");
        List<md> b2 = md.b();
        Collections.sort(b2, new a());
        this.f879a.n(b2);
        C();
        FirebaseAuth instance = FirebaseAuth.getInstance();
        this.f875a = instance;
        if (qb0.f4817d && instance.e() != null) {
            this.f875a.h();
            G(1);
        }
        this.f877a = new b();
    }

    class a implements Comparator<md> {
        a() {
        }

        /* renamed from: a */
        public int compare(md s1, md s2) {
            return s1.h().compareToIgnoreCase(s2.h());
        }
    }

    class b extends h.b {
        b() {
        }

        public void c(com.google.firebase.auth.g credential) {
            Log.d("PhoneAuthActivity", "onVerificationCompleted:" + credential);
            boolean unused = PhoneAuthActivity.this.f880a = false;
            PhoneAuthActivity.this.J(4, credential);
            PhoneAuthActivity.this.D(credential);
        }

        public void d(wl e) {
            Log.w("PhoneAuthActivity", "onVerificationFailed", e);
            boolean unused = PhoneAuthActivity.this.f880a = false;
            if (e instanceof ol) {
                PhoneAuthActivity.this.f872a.setError("خطا في رقم الموبايل");
            } else if (e instanceof cm) {
                String a2 = ml0.a(PhoneAuthActivity.this, "device_id");
                PhoneAuthActivity phoneAuthActivity = PhoneAuthActivity.this;
                phoneAuthActivity.j(a2 + "@mums.com", "123456");
                Snackbar.k0(PhoneAuthActivity.this.findViewById(16908290), "تجاوزت الحدد الادنى يرجى الانتظار 24 ساعه لإعادة الطلب", -1).V();
            } else if (PhoneAuthActivity.this.f882b.getText().toString().equals("+967")) {
                String a3 = ml0.a(PhoneAuthActivity.this, "device_id");
                PhoneAuthActivity phoneAuthActivity2 = PhoneAuthActivity.this;
                phoneAuthActivity2.j(a3 + "@mums.com", "123456");
            }
            PhoneAuthActivity.this.G(3);
        }

        public void b(String verificationId, h.a token) {
            Log.d("PhoneAuthActivity", "onCodeSent:" + verificationId);
            String unused = PhoneAuthActivity.this.f878a = verificationId;
            h.a unused2 = PhoneAuthActivity.this.f876a = token;
            PhoneAuthActivity.this.G(2);
        }

        public void a(String verificationId) {
            Log.d("PhoneAuthActivity", "onCodeSent:" + verificationId);
            Toast.makeText(PhoneAuthActivity.this, "يتعذر ارسال رسالة التحقق .. يرجى المحاولة بعد نصف ساعه", 0).show();
            PhoneAuthActivity.this.G(7);
        }
    }

    class c implements o40<w4> {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ String f887a;
        final /* synthetic */ String b;

        c(String str, String str2) {
            this.f887a = str;
            this.b = str2;
        }

        public void a(eq0<w4> task) {
            if (task.r()) {
                dm j = task.n().j();
                qb0.j = PhoneAuthActivity.this.f872a.getText().toString();
                qb0.k = PhoneAuthActivity.this.f882b.getText().toString();
                if (qb0.f4817d) {
                    PhoneAuthActivity.this.startActivity(new Intent(PhoneAuthActivity.this, ForgetPasswordActivity.class));
                } else {
                    PhoneAuthActivity.this.startActivity(new Intent(PhoneAuthActivity.this, Sing_Activity.class));
                }
            } else if (task.m().toString().contains("already in use")) {
                PhoneAuthActivity.this.f875a.g(this.f887a, this.b).b(new a());
                Toast.makeText(PhoneAuthActivity.this, "هذا الحساب موجود من قبل", 0).show();
            }
        }

        class a implements o40<w4> {
            a() {
            }

            public void a(eq0<w4> task) {
                if (task.r()) {
                    Log.d("PhoneAuthActivity", "signInWithEmail:success");
                    dm j = task.n().j();
                    qb0.j = PhoneAuthActivity.this.f872a.getText().toString();
                    qb0.k = PhoneAuthActivity.this.f882b.getText().toString();
                    if (qb0.f4817d) {
                        PhoneAuthActivity.this.startActivity(new Intent(PhoneAuthActivity.this, ForgetPasswordActivity.class));
                    } else {
                        PhoneAuthActivity.this.startActivity(new Intent(PhoneAuthActivity.this, Sing_Activity.class));
                    }
                } else {
                    Log.w("PhoneAuthActivity", "signInWithEmail:failure", task.m());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void j(String email, String password) {
        this.f875a.d(email, password).b(new c(email, password));
    }

    class d implements pd {
        d() {
        }

        public void a(String name, String code, String dialCode, int flagDrawableResID) {
            PhoneAuthActivity.this.f882b.setText(dialCode);
            PhoneAuthActivity.this.f873a.setImageResource(flagDrawableResID);
            PhoneAuthActivity.this.f879a.dismiss();
        }
    }

    private void C() {
        this.f879a.o(new d());
        this.f873a.setOnClickListener(new e());
        this.f882b.setOnClickListener(new f());
        z();
    }

    class e implements View.OnClickListener {
        e() {
        }

        public void onClick(View v) {
            PhoneAuthActivity.this.f879a.show(PhoneAuthActivity.this.getSupportFragmentManager(), "COUNTRY_PICKER");
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        public void onClick(View v) {
            PhoneAuthActivity.this.f879a.show(PhoneAuthActivity.this.getSupportFragmentManager(), "COUNTRY_PICKER");
        }
    }

    private void z() {
        Locale locale = getResources().getConfiguration().locale;
        md country = md.e(this);
        if (country != null) {
            this.f873a.setImageResource(country.g());
            this.f882b.setText(country.f());
            this.f884b = country.f();
            return;
        }
        md us = new md("YE", "Yemen", "+967", R.drawable.flag_ye);
        this.f873a.setImageResource(us.g());
        this.f882b.setText(us.f());
        this.f884b = us.f();
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(jv0.b(newBase));
    }

    public void onStart() {
        super.onStart();
        K(this.f875a.e());
        if (this.f880a && L()) {
            qb0.j = this.f872a.getText().toString();
            qb0.k = this.f882b.getText().toString();
            F(this.f882b.getText().toString() + "" + this.f872a.getText().toString());
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("key_verify_in_progress", this.f880a);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this.f880a = savedInstanceState.getBoolean("key_verify_in_progress");
    }

    private void F(String phoneNumber) {
        com.google.firebase.auth.h.b().c(phoneNumber, 60, TimeUnit.SECONDS, this, this.f877a);
        this.f880a = true;
    }

    private void M(String verificationId, String code) {
        D(com.google.firebase.auth.h.a(verificationId, code));
    }

    private void B(String phoneNumber, h.a token) {
        com.google.firebase.auth.h.b().d(phoneNumber, 60, TimeUnit.SECONDS, this, this.f877a, token);
    }

    class g implements o40<w4> {
        g() {
        }

        public void a(eq0<w4> task) {
            if (task.r()) {
                Log.d("PhoneAuthActivity", "signInWithCredential:success");
                dm j = task.n().j();
                qb0.j = PhoneAuthActivity.this.f872a.getText().toString();
                qb0.k = PhoneAuthActivity.this.f882b.getText().toString();
                if (qb0.f4817d) {
                    PhoneAuthActivity.this.startActivity(new Intent(PhoneAuthActivity.this, ForgetPasswordActivity.class));
                } else {
                    PhoneAuthActivity.this.startActivity(new Intent(PhoneAuthActivity.this, Sing_Activity.class));
                }
            } else {
                Log.w("PhoneAuthActivity", "signInWithCredential:failure", task.m());
                if (task.m() instanceof ol) {
                    PhoneAuthActivity.this.f886c.setError("Invalid code.");
                }
                PhoneAuthActivity.this.G(5);
            }
        }
    }

    /* access modifiers changed from: private */
    public void D(com.google.firebase.auth.g credential) {
        this.f875a.f(credential).c(this, new g());
    }

    private void E() {
        this.f875a.h();
        G(1);
    }

    /* access modifiers changed from: private */
    public void G(int uiState) {
        I(uiState, this.f875a.e(), (com.google.firebase.auth.g) null);
    }

    private void K(dm user) {
        if (user != null) {
            H(6, user);
        } else {
            G(1);
        }
    }

    private void H(int uiState, dm user) {
        I(uiState, user, (com.google.firebase.auth.g) null);
    }

    /* access modifiers changed from: private */
    public void J(int uiState, com.google.firebase.auth.g cred) {
        I(uiState, (dm) null, cred);
    }

    private void I(int uiState, dm user, com.google.firebase.auth.g cred) {
        switch (uiState) {
            case 1:
                x(this.f871a, this.f872a);
                w(this.f881b, this.c, this.f886c);
                this.f883b.setText((CharSequence) null);
                break;
            case 2:
                x(this.f881b, this.c, this.f872a, this.f886c);
                w(this.f871a);
                this.f883b.setText(R.string.status_code_sent);
                this.f883b.setTextColor(getResources().getColor(R.color.attachment_icon_pdf));
                break;
            case 3:
                x(this.f871a, this.f881b, this.c, this.f872a, this.f886c);
                this.f883b.setText(R.string.status_verification_failed);
                this.f883b.setTextColor(getResources().getColor(R.color.red));
                break;
            case 4:
                w(this.f871a, this.f881b, this.c, this.f872a, this.f886c);
                this.f883b.setText(R.string.status_verification_succeeded);
                this.f883b.setTextColor(getResources().getColor(R.color.attachment_icon_pdf));
                if (cred != null) {
                    if (cred.s() == null) {
                        this.f886c.setText(R.string.instant_validation);
                        break;
                    } else {
                        this.f886c.setText(cred.s());
                        break;
                    }
                }
                break;
            case 5:
                this.f883b.setText(R.string.status_sign_in_failed);
                break;
            case 7:
                x(this.f871a, this.f881b, this.c, this.f872a, this.f886c);
                this.f883b.setText("يتعذر الإرسال ..يرجى المحاولة بعد نصف ساعة");
                this.f883b.setTextColor(getResources().getColor(R.color.red));
                break;
        }
        if (user == null) {
            this.a.setVisibility(0);
            this.b.setVisibility(8);
            this.f874a.setText(R.string.signed_out);
            return;
        }
        this.a.setVisibility(8);
        this.b.setVisibility(0);
        x(this.f872a, this.f886c);
        this.f872a.setText((CharSequence) null);
        this.f886c.setText((CharSequence) null);
        this.f874a.setText(R.string.signed_in);
        this.f883b.setText("");
    }

    private boolean L() {
        if (!TextUtils.isEmpty(this.f872a.getText().toString())) {
            return true;
        }
        this.f872a.setError("خطا في رقم الموبايل");
        return false;
    }

    private void x(View... views) {
        for (View v : views) {
            v.setVisibility(0);
        }
    }

    private void w(View... views) {
        for (View v : views) {
            v.setVisibility(8);
        }
    }

    public boolean A() {
        try {
            com.google.firebase.firestore.h.g().a("Users").a(this.f872a.getText().toString()).e(p.SERVER).b(new h());
        } catch (Exception ex) {
            this.f885b = false;
            Toast.makeText(this, ex.getMessage().toString() + " حصت مشكلة بالاتصال ..قم بالضغط مره اخرى على تسجيل ", 0).show();
        }
        return this.f885b;
    }

    class h implements o40<com.google.firebase.firestore.f> {
        static {
            Class<PhoneAuthActivity> cls = PhoneAuthActivity.class;
        }

        h() {
        }

        public void a(eq0<com.google.firebase.firestore.f> task) {
            try {
                com.google.firebase.firestore.f document = task.n();
                if (document != null) {
                    if (document.g()) {
                        PhoneAuthActivity.this.f885b = false;
                    } else {
                        PhoneAuthActivity.this.f885b = true;
                    }
                    return;
                }
                throw new AssertionError();
            } catch (Exception ex) {
                PhoneAuthActivity phoneAuthActivity = PhoneAuthActivity.this;
                phoneAuthActivity.f885b = false;
                Toast.makeText(phoneAuthActivity, ex.getMessage() + "تاكد من الاتصال بالانترنت - قم بإيقاف اي برنامج vpn ", 0).show();
            }
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonResend /*2131296399*/:
                B(this.f882b.getText().toString() + "" + this.f872a.getText().toString(), this.f876a);
                return;
            case R.id.buttonStartVerification /*2131296401*/:
                if (L()) {
                    if (!qb0.f4817d) {
                        this.f872a.setEnabled(false);
                        F(this.f882b.getText().toString() + "" + this.f872a.getText().toString());
                        return;
                    } else if (A()) {
                        F(this.f882b.getText().toString() + "" + this.f872a.getText().toString());
                        return;
                    } else {
                        Toast.makeText(this, "هذا الحساب غير موجود", 0).show();
                        return;
                    }
                } else {
                    return;
                }
            case R.id.buttonVerifyPhone /*2131296402*/:
                String code = this.f886c.getText().toString();
                if (TextUtils.isEmpty(code)) {
                    this.f886c.setError("الرجاء تعبئة الحقل");
                    return;
                } else {
                    M(this.f878a, code);
                    return;
                }
            case R.id.signOutButton /*2131296979*/:
                E();
                return;
            default:
                return;
        }
    }

    public void y() {
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
