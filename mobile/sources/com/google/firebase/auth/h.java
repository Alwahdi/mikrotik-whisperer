package com.google.firebase.auth;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class h {
    private FirebaseAuth a;

    public static class a extends x {
        public static final Parcelable.Creator<a> CREATOR = new n();

        a() {
        }

        public void writeToParcel(Parcel parcel, int i) {
            fi0.b(parcel, fi0.a(parcel));
        }

        public static a m() {
            return new a();
        }
    }

    public static abstract class b {
        private static final vy a = new vy("PhoneAuthProvider", new String[0]);

        public abstract void c(g gVar);

        public abstract void d(wl wlVar);

        public void b(String str, a aVar) {
        }

        public void a(String str) {
            a.d("Sms auto retrieval timed-out.", new Object[0]);
        }
    }

    private h(FirebaseAuth firebaseAuth) {
        this.a = firebaseAuth;
    }

    public static h b() {
        return new h(FirebaseAuth.getInstance(gl.j()));
    }

    public void c(String str, long j, TimeUnit timeUnit, Activity activity, b bVar) {
        f(y90.f(str), j, timeUnit, (Activity) y90.j(activity), jq0.a, (b) y90.j(bVar), (a) null);
    }

    public void e(String str, long j, TimeUnit timeUnit, Executor executor, b bVar) {
        f(y90.f(str), j, timeUnit, (Activity) null, (Executor) y90.j(executor), (b) y90.j(bVar), (a) null);
    }

    public void d(String str, long j, TimeUnit timeUnit, Activity activity, b bVar, a aVar) {
        f(y90.f(str), j, timeUnit, (Activity) y90.j(activity), jq0.a, (b) y90.j(bVar), aVar);
    }

    private final void f(String str, long j, TimeUnit timeUnit, Activity activity, Executor executor, b bVar, a aVar) {
        this.a.o(str, j, timeUnit, bVar, activity, executor, aVar != null, (String) null);
    }

    public static g a(String str, String str2) {
        return new g(str, str2, false, (String) null, true, (String) null, (String) null);
    }
}
