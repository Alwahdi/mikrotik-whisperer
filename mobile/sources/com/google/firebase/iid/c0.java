package com.google.firebase.iid;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.heartbeatinfo.c;
import java.io.IOException;
import java.util.concurrent.Executor;

final class c0 {
    private final c a;

    /* renamed from: a  reason: collision with other field name */
    private final f f2413a;

    /* renamed from: a  reason: collision with other field name */
    private final gl f2414a;

    /* renamed from: a  reason: collision with other field name */
    private final Executor f2415a;

    /* renamed from: a  reason: collision with other field name */
    private final tz0 f2416a;

    /* renamed from: a  reason: collision with other field name */
    private final zt0 f2417a;

    c0(gl glVar, tz0 tz0, Executor executor, zt0 zt0, c cVar) {
        this(glVar, tz0, executor, new f(glVar.i(), tz0), zt0, cVar);
    }

    private c0(gl glVar, tz0 tz0, Executor executor, f fVar, zt0 zt0, c cVar) {
        this.f2414a = glVar;
        this.f2416a = tz0;
        this.f2413a = fVar;
        this.f2415a = executor;
        this.f2417a = zt0;
        this.a = cVar;
    }

    public final eq0<String> b(String str, String str2, String str3) {
        return g(c(str, str2, str3, new Bundle()));
    }

    public final eq0<Void> h(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        String valueOf3 = String.valueOf("/topics/");
        String valueOf4 = String.valueOf(str3);
        return a(g(c(str, str2, valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), bundle)));
    }

    public final eq0<Void> i(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        bundle.putString("delete", "1");
        String valueOf3 = String.valueOf("/topics/");
        String valueOf4 = String.valueOf(str3);
        return a(g(c(str, str2, valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), bundle)));
    }

    private final eq0<Bundle> c(String str, String str2, String str3, Bundle bundle) {
        bundle.putString("scope", str3);
        bundle.putString("sender", str2);
        bundle.putString("subtype", str2);
        bundle.putString("appid", str);
        bundle.putString("gmp_app_id", this.f2414a.m().c());
        bundle.putString("gmsv", Integer.toString(this.f2416a.g()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f2416a.e());
        bundle.putString("app_ver_name", this.f2416a.f());
        String b = zw.a().b("firebase-iid");
        if ("UNKNOWN".equals(b)) {
            int i = up.a;
            StringBuilder sb = new StringBuilder(19);
            sb.append("unknown_");
            sb.append(i);
            b = sb.toString();
        }
        String valueOf = String.valueOf(b);
        bundle.putString("cliv", valueOf.length() != 0 ? "fiid-".concat(valueOf) : new String("fiid-"));
        c.a a2 = this.a.a("fire-iid");
        if (a2 != c.a.NONE) {
            bundle.putString("Firebase-Client-Log-Type", Integer.toString(a2.getCode()));
            bundle.putString("Firebase-Client", this.f2417a.a());
        }
        gq0 gq0 = new gq0();
        this.f2415a.execute(new e0(this, bundle, gq0));
        return gq0.a();
    }

    /* access modifiers changed from: private */
    public static String d(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("registration_id");
            if (string != null) {
                return string;
            }
            String string2 = bundle.getString("unregistered");
            if (string2 != null) {
                return string2;
            }
            String string3 = bundle.getString("error");
            if ("RST".equals(string3)) {
                throw new IOException("INSTANCE_ID_RESET");
            } else if (string3 != null) {
                throw new IOException(string3);
            } else {
                String valueOf = String.valueOf(bundle);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 21);
                sb.append("Unexpected response: ");
                sb.append(valueOf);
                Log.w("FirebaseInstanceId", sb.toString(), new Throwable());
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
        } else {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
    }

    private final <T> eq0<Void> a(eq0<T> eq0) {
        return eq0.j(a.b(), new d0(this));
    }

    private final eq0<String> g(eq0<Bundle> eq0) {
        return eq0.j(this.f2415a, new g0(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void f(Bundle bundle, gq0 gq0) {
        try {
            gq0.c(this.f2413a.a(bundle));
        } catch (IOException e) {
            gq0.b(e);
        }
    }
}
