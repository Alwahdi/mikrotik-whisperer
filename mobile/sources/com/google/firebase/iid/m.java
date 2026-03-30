package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import java.io.IOException;

final class m implements Runnable {
    private final long a;

    /* renamed from: a  reason: collision with other field name */
    private final PowerManager.WakeLock f2437a;

    /* renamed from: a  reason: collision with other field name */
    private final FirebaseInstanceId f2438a;

    /* renamed from: a  reason: collision with other field name */
    private final n f2439a;

    m(FirebaseInstanceId firebaseInstanceId, tz0 tz0, n nVar, long j) {
        this.f2438a = firebaseInstanceId;
        this.f2439a = nVar;
        this.a = j;
        PowerManager.WakeLock newWakeLock = ((PowerManager) a().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f2437a = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    public final void run() {
        if (h.b().c(a())) {
            this.f2437a.acquire();
        }
        try {
            this.f2438a.n(true);
            if (!this.f2438a.y()) {
                this.f2438a.n(false);
                if (h.b().c(a())) {
                    this.f2437a.release();
                }
            } else if (!h.b().f(a()) || b()) {
                if (!c() || !this.f2439a.b(this.f2438a)) {
                    this.f2438a.l(this.a);
                } else {
                    this.f2438a.n(false);
                }
                if (h.b().c(a())) {
                    this.f2437a.release();
                }
            } else {
                new l(this).a();
                if (h.b().c(a())) {
                    this.f2437a.release();
                }
            }
        } catch (IOException e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 93);
            sb.append("Topic sync or token retrieval failed on hard failure exceptions: ");
            sb.append(message);
            sb.append(". Won't retry the operation.");
            Log.e("FirebaseInstanceId", sb.toString());
            this.f2438a.n(false);
            if (h.b().c(a())) {
                this.f2437a.release();
            }
        } catch (Throwable th) {
            if (h.b().c(a())) {
                this.f2437a.release();
            }
            throw th;
        }
    }

    private final boolean c() {
        j p = this.f2438a.p();
        if (!this.f2438a.o(p)) {
            return true;
        }
        try {
            String t = this.f2438a.t();
            if (t == null) {
                Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                return false;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Token successfully retrieved");
            }
            if ((p == null || !t.equals(p.f2431a)) && "[DEFAULT]".equals(this.f2438a.e().l())) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(this.f2438a.e().l());
                    Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Invoking onNewToken for app: ".concat(valueOf) : new String("Invoking onNewToken for app: "));
                }
                Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
                intent.putExtra("token", t);
                Context a2 = a();
                Intent intent2 = new Intent(a2, FirebaseInstanceIdReceiver.class);
                intent2.setAction("com.google.firebase.MESSAGING_EVENT");
                intent2.putExtra("wrapped_intent", intent);
                a2.sendBroadcast(intent2);
            }
            return true;
        } catch (IOException e) {
            if ("SERVICE_NOT_AVAILABLE".equals(e.getMessage()) || "INTERNAL_SERVER_ERROR".equals(e.getMessage())) {
                Log.w("FirebaseInstanceId", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            } else if (e.getMessage() == null) {
                String message = e.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 52);
                sb.append("Token retrieval failed: ");
                sb.append(message);
                sb.append(". Will retry token retrieval");
                Log.w("FirebaseInstanceId", sb.toString());
                return false;
            } else {
                throw e;
            }
        } catch (SecurityException e2) {
            Log.w("FirebaseInstanceId", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final Context a() {
        return this.f2438a.e().i();
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        ConnectivityManager connectivityManager = (ConnectivityManager) a().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
