package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.firebase.heartbeatinfo.c;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FirebaseInstanceId {
    private static final long a = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: a  reason: collision with other field name */
    private static k f2398a;

    /* renamed from: a  reason: collision with other field name */
    private static ScheduledExecutorService f2399a;

    /* renamed from: a  reason: collision with other field name */
    private final a f2400a;

    /* renamed from: a  reason: collision with other field name */
    private final c0 f2401a;

    /* renamed from: a  reason: collision with other field name */
    private final e f2402a;

    /* renamed from: a  reason: collision with other field name */
    private final n f2403a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final gl f2404a;

    /* renamed from: a  reason: collision with other field name */
    private final Executor f2405a;

    /* renamed from: a  reason: collision with other field name */
    private final tz0 f2406a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f2407a;

    public static FirebaseInstanceId b() {
        return getInstance(gl.j());
    }

    @NonNull
    @Keep
    public static FirebaseInstanceId getInstance(@NonNull gl glVar) {
        return (FirebaseInstanceId) glVar.g(FirebaseInstanceId.class);
    }

    private class a {

        /* renamed from: a  reason: collision with other field name */
        private final io0 f2408a;

        /* renamed from: a  reason: collision with other field name */
        private Boolean f2409a;

        /* renamed from: a  reason: collision with other field name */
        private zi<oe> f2410a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f2411a;
        private boolean b;

        a(io0 io0) {
            this.f2408a = io0;
        }

        private final synchronized void b() {
            if (!this.b) {
                this.f2411a = d();
                Boolean c = c();
                this.f2409a = c;
                if (c == null && this.f2411a) {
                    b0 b0Var = new b0(this);
                    this.f2410a = b0Var;
                    this.f2408a.a(oe.class, b0Var);
                }
                this.b = true;
            }
        }

        /* access modifiers changed from: package-private */
        public final synchronized boolean a() {
            b();
            Boolean bool = this.f2409a;
            if (bool == null) {
                return this.f2411a && FirebaseInstanceId.this.f2404a.s();
            }
            return bool.booleanValue();
        }

        private final Boolean c() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            Context i = FirebaseInstanceId.this.f2404a.i();
            SharedPreferences sharedPreferences = i.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = i.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(i.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException e) {
                return null;
            }
        }

        private final boolean d() {
            try {
                int i = FirebaseMessaging.a;
                return true;
            } catch (ClassNotFoundException e) {
                Context i2 = FirebaseInstanceId.this.f2404a.i();
                Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
                intent.setPackage(i2.getPackageName());
                ResolveInfo resolveService = i2.getPackageManager().resolveService(intent, 0);
                if (resolveService == null || resolveService.serviceInfo == null) {
                    return false;
                }
                return true;
            }
        }
    }

    FirebaseInstanceId(gl glVar, io0 io0, zt0 zt0, c cVar) {
        this(glVar, new tz0(glVar.i()), a.c(), a.c(), io0, zt0, cVar);
    }

    private FirebaseInstanceId(gl glVar, tz0 tz0, Executor executor, Executor executor2, io0 io0, zt0 zt0, c cVar) {
        this.f2407a = false;
        if (tz0.c(glVar) != null) {
            synchronized (FirebaseInstanceId.class) {
                if (f2398a == null) {
                    f2398a = new k(glVar.i());
                }
            }
            this.f2404a = glVar;
            this.f2406a = tz0;
            this.f2401a = new c0(glVar, tz0, executor, zt0, cVar);
            this.f2405a = executor2;
            this.f2403a = new n(f2398a);
            this.f2400a = new a(io0);
            this.f2402a = new e(executor);
            executor2.execute(new y(this));
            return;
        }
        throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
    }

    /* access modifiers changed from: private */
    public final void B() {
        if (o(p()) || this.f2403a.a()) {
            C();
        }
    }

    /* access modifiers changed from: package-private */
    public final gl e() {
        return this.f2404a;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void n(boolean z) {
        this.f2407a = z;
    }

    private final synchronized void C() {
        if (!this.f2407a) {
            l(0);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void l(long j) {
        m(new m(this, this.f2406a, this.f2403a, Math.min(Math.max(30, j << 1), a)), j);
        this.f2407a = true;
    }

    static void m(Runnable runnable, long j) {
        synchronized (FirebaseInstanceId.class) {
            if (f2399a == null) {
                f2399a = new ScheduledThreadPoolExecutor(1, new e30("FirebaseInstanceId"));
            }
            f2399a.schedule(runnable, j, TimeUnit.SECONDS);
        }
    }

    public String a() {
        B();
        return D();
    }

    private static String D() {
        return f2398a.f("").b();
    }

    private final eq0<xs> g(String str, String str2) {
        return lq0.e(null).l(this.f2405a, new x(this, str, v(str2)));
    }

    public String c() {
        j p = p();
        if (o(p)) {
            C();
        }
        return j.b(p);
    }

    public String d(String str, String str2) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return ((xs) k(g(str, str2))).a();
        }
        throw new IOException("MAIN_THREAD");
    }

    /* access modifiers changed from: package-private */
    public final j p() {
        return q(tz0.c(this.f2404a), "*");
    }

    private static j q(String str, String str2) {
        return f2398a.a("", str, str2);
    }

    /* access modifiers changed from: package-private */
    public final String t() {
        return d(tz0.c(this.f2404a), "*");
    }

    private final <T> T k(eq0<T> eq0) {
        try {
            return lq0.b(eq0, 30000, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                    x();
                }
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e);
            }
        } catch (InterruptedException | TimeoutException e2) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
    }

    /* access modifiers changed from: package-private */
    public final void s(String str) {
        j p = p();
        if (!o(p)) {
            k(this.f2401a.h(D(), p.f2431a, str));
            return;
        }
        throw new IOException("token not available");
    }

    /* access modifiers changed from: package-private */
    public final void u(String str) {
        j p = p();
        if (!o(p)) {
            k(this.f2401a.i(D(), p.f2431a, str));
            return;
        }
        throw new IOException("token not available");
    }

    static boolean w() {
        if (!Log.isLoggable("FirebaseInstanceId", 3)) {
            return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void x() {
        f2398a.g();
        if (this.f2400a.a()) {
            C();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean y() {
        return this.f2406a.a() != 0;
    }

    /* access modifiers changed from: package-private */
    public final void z() {
        f2398a.i("");
        C();
    }

    private static String v(String str) {
        if (str.isEmpty() || str.equalsIgnoreCase("fcm") || str.equalsIgnoreCase("gcm")) {
            return "*";
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    public final boolean o(j jVar) {
        return jVar == null || jVar.d(this.f2406a.e());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ eq0 h(String str, String str2, eq0 eq0) {
        String D = D();
        j q = q(str, str2);
        if (!o(q)) {
            return lq0.e(new l0(D, q.f2431a));
        }
        return this.f2402a.b(str, str2, new a0(this, D, str, str2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ eq0 i(String str, String str2, String str3) {
        return this.f2401a.b(str, str2, str3).s(this.f2405a, new z(this, str2, str3, str));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ eq0 j(String str, String str2, String str3, String str4) {
        f2398a.e("", str, str2, str4, this.f2406a.e());
        return lq0.e(new l0(str3, str4));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void A() {
        if (this.f2400a.a()) {
            B();
        }
    }
}
