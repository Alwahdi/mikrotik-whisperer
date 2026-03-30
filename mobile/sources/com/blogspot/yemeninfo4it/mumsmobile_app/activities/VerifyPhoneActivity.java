package com.blogspot.yemeninfo4it.mumsmobile_app.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.g;
import com.google.firebase.auth.h;
import java.util.concurrent.TimeUnit;

public class VerifyPhoneActivity extends AppCompatActivity {
    /* access modifiers changed from: private */
    public EditText a;

    /* renamed from: a  reason: collision with other field name */
    private FirebaseAuth f1265a;

    /* renamed from: a  reason: collision with other field name */
    private h.b f1266a = new b();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public String f1267a;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_verify_phone);
        this.f1265a = FirebaseAuth.getInstance();
        this.a = (EditText) findViewById(R.id.editTextCode);
        m(getIntent().getStringExtra("mobile"));
        findViewById(R.id.buttonSignIn).setOnClickListener(new a());
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View v) {
            String code = VerifyPhoneActivity.this.a.getText().toString().trim();
            if (code.isEmpty() || code.length() < 6) {
                VerifyPhoneActivity.this.a.setError("Enter valid code");
                VerifyPhoneActivity.this.a.requestFocus();
                return;
            }
            VerifyPhoneActivity.this.o(code);
        }
    }

    private void m(String mobile) {
        h.b().e(mobile, 60, TimeUnit.SECONDS, jq0.a, this.f1266a);
    }

    class b extends h.b {
        b() {
        }

        public void c(g phoneAuthCredential) {
            String code = phoneAuthCredential.s();
            if (code != null) {
                VerifyPhoneActivity.this.a.setText(code);
                VerifyPhoneActivity.this.o(code);
            }
        }

        public void d(wl e) {
            VerifyPhoneActivity verifyPhoneActivity = VerifyPhoneActivity.this;
            Toast.makeText(verifyPhoneActivity, e.getMessage() + "uuuuuuu", 1).show();
        }

        public void b(String s, h.a forceResendingToken) {
            super.b(s, forceResendingToken);
            String unused = VerifyPhoneActivity.this.f1267a = s;
        }
    }

    /* access modifiers changed from: private */
    public void o(String code) {
        n(h.a(this.f1267a, code));
    }

    class c implements o40<w4> {
        c() {
        }

        public void a(eq0<w4> task) {
            if (task.r()) {
                Snackbar.k0(VerifyPhoneActivity.this.findViewById(16908290), "Ok", -1).V();
                return;
            }
            String message = "Somthing is wrong, we will fix it soon...";
            if (task.m() instanceof ol) {
                message = "Invalid code entered...";
            }
            Snackbar snackbar = Snackbar.k0(VerifyPhoneActivity.this.findViewById(R.id.parent), message, 0);
            snackbar.m0("Dismiss", new a());
            snackbar.V();
        }

        class a implements View.OnClickListener {
            a() {
            }

            public void onClick(View v) {
            }
        }
    }

    private void n(g credential) {
        this.f1265a.f(credential).c(this, new c());
    }
}
