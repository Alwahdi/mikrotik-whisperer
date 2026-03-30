package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import com.google.firebase.auth.b;
import com.google.firebase.auth.g;

/* renamed from: k51  reason: default package */
public final class k51 extends f11 implements j51 {
    k51(IBinder iBinder) {
        super(iBinder, "com.google.firebase.auth.api.internal.IFirebaseAuthService");
    }

    public final void t(String str, i51 i51) {
        Parcel a = a();
        a.writeString(str);
        e41.b(a, i51);
        b(1, a);
    }

    public final void q(f71 f71, i51 i51) {
        Parcel a = a();
        e41.c(a, f71);
        e41.b(a, i51);
        b(3, a);
    }

    public final void Z(String str, String str2, i51 i51) {
        Parcel a = a();
        a.writeString(str);
        a.writeString(str2);
        e41.b(a, i51);
        b(7, a);
    }

    public final void M(String str, String str2, i51 i51) {
        Parcel a = a();
        a.writeString(str);
        a.writeString(str2);
        e41.b(a, i51);
        b(8, a);
    }

    public final void v(String str, String str2, String str3, i51 i51) {
        Parcel a = a();
        a.writeString(str);
        a.writeString(str2);
        a.writeString(str3);
        e41.b(a, i51);
        b(11, a);
    }

    public final void u(String str, f71 f71, i51 i51) {
        Parcel a = a();
        a.writeString(str);
        e41.c(a, f71);
        e41.b(a, i51);
        b(12, a);
    }

    public final void G(d71 d71, i51 i51) {
        Parcel a = a();
        e41.c(a, d71);
        e41.b(a, i51);
        b(22, a);
    }

    public final void y(g gVar, i51 i51) {
        Parcel a = a();
        e41.c(a, gVar);
        e41.b(a, i51);
        b(23, a);
    }

    public final void s(String str, g gVar, i51 i51) {
        Parcel a = a();
        a.writeString(str);
        e41.c(a, gVar);
        e41.b(a, i51);
        b(24, a);
    }

    public final void c0(b bVar, i51 i51) {
        Parcel a = a();
        e41.c(a, bVar);
        e41.b(a, i51);
        b(29, a);
    }

    public final void L(n31 n31, i51 i51) {
        Parcel a = a();
        e41.c(a, n31);
        e41.b(a, i51);
        b(101, a);
    }

    public final void i(l41 l41, i51 i51) {
        Parcel a = a();
        e41.c(a, l41);
        e41.b(a, i51);
        b(103, a);
    }

    public final void w(k31 k31, i51 i51) {
        Parcel a = a();
        e41.c(a, k31);
        e41.b(a, i51);
        b(107, a);
    }

    public final void U(n41 n41, i51 i51) {
        Parcel a = a();
        e41.c(a, n41);
        e41.b(a, i51);
        b(108, a);
    }

    public final void T(q31 q31, i51 i51) {
        Parcel a = a();
        e41.c(a, q31);
        e41.b(a, i51);
        b(111, a);
    }

    public final void f0(s31 s31, i51 i51) {
        Parcel a = a();
        e41.c(a, s31);
        e41.b(a, i51);
        b(112, a);
    }

    public final void Y(j41 j41, i51 i51) {
        Parcel a = a();
        e41.c(a, j41);
        e41.b(a, i51);
        b(122, a);
    }

    public final void N(t41 t41, i51 i51) {
        Parcel a = a();
        e41.c(a, t41);
        e41.b(a, i51);
        b(123, a);
    }

    public final void a0(v31 v31, i51 i51) {
        Parcel a = a();
        e41.c(a, v31);
        e41.b(a, i51);
        b(124, a);
    }

    public final void R(p41 p41, i51 i51) {
        Parcel a = a();
        e41.c(a, p41);
        e41.b(a, i51);
        b(129, a);
    }
}
