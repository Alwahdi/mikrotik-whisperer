package defpackage;

import com.google.android.gms.common.api.Status;
import defpackage.c01;
import defpackage.i3;
import java.util.concurrent.Future;

/* renamed from: a01  reason: default package */
public abstract class a01<T extends c01> {
    private static vy a = new vy("BiChannelGoogleApi", "FirebaseAuth: ");

    /* renamed from: a  reason: collision with other field name */
    private yz0<T> f0a;

    /* access modifiers changed from: package-private */
    public abstract Future<yz0<T>> c();

    public final <ResultT, A extends i3.b> eq0<ResultT> b(f01<A, ResultT> f01) {
        rp a2 = a(f01.d());
        if (a2 == null) {
            return d();
        }
        if (((c01) a2.e()).a) {
            f01.a();
        }
        return a2.b(f01.b());
    }

    public final <ResultT, A extends i3.b> eq0<ResultT> e(f01<A, ResultT> f01) {
        rp a2 = a(f01.d());
        if (a2 == null) {
            return d();
        }
        if (((c01) a2.e()).a) {
            f01.a();
        }
        return a2.c(f01.b());
    }

    private static <ResultT> eq0<ResultT> d() {
        return lq0.d(y41.b(new Status(17499, "Unable to connect to GoogleApi instance - Google Play Services may be unavailable")));
    }

    private final rp<T> a(String str) {
        yz0 f = f();
        if (f.a.a(str)) {
            vy vyVar = a;
            String valueOf = String.valueOf(f.b);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 43);
            sb.append("getGoogleApiForMethod() returned Fallback: ");
            sb.append(valueOf);
            vyVar.d(sb.toString(), new Object[0]);
            return f.b;
        }
        vy vyVar2 = a;
        String valueOf2 = String.valueOf(f.f5965a);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 38);
        sb2.append("getGoogleApiForMethod() returned Gms: ");
        sb2.append(valueOf2);
        vyVar2.d(sb2.toString(), new Object[0]);
        return f.f5965a;
    }

    private final yz0<T> f() {
        yz0<T> yz0;
        synchronized (this) {
            if (this.f0a == null) {
                try {
                    this.f0a = (yz0) c().get();
                } catch (Exception e) {
                    String valueOf = String.valueOf(e.getMessage());
                    throw new RuntimeException(valueOf.length() != 0 ? "There was an error while initializing the connection to Google Play Services: ".concat(valueOf) : new String("There was an error while initializing the connection to Google Play Services: "));
                }
            }
            yz0 = this.f0a;
        }
        return yz0;
    }
}
