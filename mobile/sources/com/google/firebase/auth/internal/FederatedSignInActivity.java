package com.google.firebase.auth.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;

@KeepName
public class FederatedSignInActivity extends FragmentActivity {
    private static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static Handler f2158a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public static Runnable f2159a;

    /* renamed from: a  reason: collision with other field name */
    private static final zz0 f2160a = zz0.a();

    /* renamed from: a  reason: collision with other field name */
    private boolean f2161a = false;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if ("com.google.firebase.auth.internal.SIGN_IN".equals(action) || "com.google.firebase.auth.internal.LINK".equals(action) || "com.google.firebase.auth.internal.REAUTHENTICATE".equals(action)) {
            long a2 = hf.b().a();
            if (a2 - a < 30000) {
                Log.e("IdpSignInActivity", "Could not start operation - already in progress");
                return;
            }
            a = a2;
            if (bundle != null) {
                this.f2161a = bundle.getBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN");
                return;
            }
            return;
        }
        String valueOf = String.valueOf(action);
        Log.e("IdpSignInActivity", valueOf.length() != 0 ? "Could not do operation - unknown action: ".concat(valueOf) : new String("Could not do operation - unknown action: "));
        k();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN", this.f2161a);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Intent intent = getIntent();
        boolean z = false;
        if ("com.google.firebase.auth.internal.WEB_SIGN_IN_FAILED".equals(intent.getAction())) {
            Log.e("IdpSignInActivity", "Web sign-in failed, finishing");
            if (z01.b(intent)) {
                l(z01.c(intent));
            } else {
                k();
            }
            z = true;
        } else if (intent.hasExtra("com.google.firebase.auth.internal.OPERATION") && intent.hasExtra("com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST")) {
            String stringExtra = intent.getStringExtra("com.google.firebase.auth.internal.OPERATION");
            if ("com.google.firebase.auth.internal.SIGN_IN".equals(stringExtra) || "com.google.firebase.auth.internal.LINK".equals(stringExtra) || "com.google.firebase.auth.internal.REAUTHENTICATE".equals(stringExtra)) {
                f71 f71 = (f71) hi0.b(intent, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST", f71.CREATOR);
                String stringExtra2 = intent.getStringExtra("com.google.firebase.auth.internal.EXTRA_TENANT_ID");
                f71.p(stringExtra2);
                a = 0;
                this.f2161a = false;
                Intent intent2 = new Intent();
                hi0.e(f71, intent2, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST");
                intent2.putExtra("com.google.firebase.auth.internal.OPERATION", stringExtra);
                intent2.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
                if (!LocalBroadcastManager.getInstance(this).sendBroadcast(intent2)) {
                    l01.d(getApplicationContext(), f71, stringExtra, stringExtra2);
                } else {
                    f2160a.b(this);
                }
                finish();
                z = true;
            }
        }
        if (!z) {
            if (!this.f2161a) {
                Intent intent3 = new Intent("com.google.firebase.auth.api.gms.ui.START_WEB_SIGN_IN");
                intent3.setPackage("com.google.android.gms");
                intent3.putExtras(getIntent().getExtras());
                intent3.putExtra("com.google.firebase.auth.internal.OPERATION", getIntent().getAction());
                try {
                    startActivityForResult(intent3, 40963);
                } catch (ActivityNotFoundException e) {
                    Log.w("IdpSignInActivity", "Could not launch web sign-in Intent. Google Play service is unavailable");
                    l(new Status(17499, "Could not launch web sign-in Intent. Google Play service is unavailable"));
                }
                this.f2161a = true;
                return;
            }
            f2159a = new a(this);
            if (f2158a == null) {
                f2158a = new f81();
            }
            f2158a.postDelayed(f2159a, 800);
        }
    }

    public void onNewIntent(Intent intent) {
        Runnable runnable;
        super.onNewIntent(intent);
        Handler handler = f2158a;
        if (!(handler == null || (runnable = f2159a) == null)) {
            handler.removeCallbacks(runnable);
            f2159a = null;
        }
        setIntent(intent);
    }

    /* access modifiers changed from: private */
    public final void k() {
        a = 0;
        this.f2161a = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (!LocalBroadcastManager.getInstance(this).sendBroadcast(intent)) {
            l01.c(this, ea1.a("WEB_CONTEXT_CANCELED"));
        } else {
            f2160a.b(this);
        }
        finish();
    }

    private final void l(Status status) {
        a = 0;
        this.f2161a = false;
        Intent intent = new Intent();
        z01.a(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (!LocalBroadcastManager.getInstance(this).sendBroadcast(intent)) {
            l01.c(getApplicationContext(), status);
        } else {
            f2160a.b(this);
        }
        finish();
    }
}
