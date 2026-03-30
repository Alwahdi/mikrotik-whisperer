package defpackage;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.a;
import com.google.firebase.auth.b;
import com.google.firebase.auth.g;
import com.google.firebase.auth.h;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* renamed from: p01  reason: default package */
public final class p01 extends a01<n51> {
    private final Context a;

    /* renamed from: a  reason: collision with other field name */
    private final Future<yz0<n51>> f4654a = c();

    /* renamed from: a  reason: collision with other field name */
    private final n51 f4655a;

    p01(Context context, n51 n51) {
        this.a = context;
        this.f4655a = n51;
    }

    /* access modifiers changed from: package-private */
    public final Future<yz0<n51>> c() {
        Future<yz0<n51>> future = this.f4654a;
        if (future != null) {
            return future;
        }
        return i61.a().a(k81.b).submit(new s41(this.f4655a, this.a));
    }

    public final eq0<hp> h(gl glVar, dm dmVar, String str, a11 a11) {
        w11 w11 = (w11) new w11(str).e(glVar).f(dmVar).h(a11).i(a11);
        return m(b(w11), w11);
    }

    public final eq0<w4> i(gl glVar, a aVar, String str, ny0 ny0) {
        r31 r31 = (r31) new r31(aVar, str).e(glVar).h(ny0);
        return m(e(r31), r31);
    }

    public final eq0<w4> p(gl glVar, dm dmVar, a aVar, String str, a11 a11) {
        s21 s21 = (s21) new s21(aVar, str).e(glVar).f(dmVar).h(a11).i(a11);
        return m(e(s21), s21);
    }

    public final void o(gl glVar, d71 d71, h.b bVar, Activity activity, Executor executor) {
        q41 q41 = (q41) new q41(d71).e(glVar).g(bVar, activity, executor);
        m(e(q41), q41);
    }

    public final eq0<w4> l(gl glVar, String str, String str2, String str3, ny0 ny0) {
        o11 o11 = (o11) new o11(str, str2, str3).e(glVar).h(ny0);
        return m(e(o11), o11);
    }

    public final eq0<w4> t(gl glVar, String str, String str2, String str3, ny0 ny0) {
        w31 w31 = (w31) new w31(str, str2, str3).e(glVar).h(ny0);
        return m(e(w31), w31);
    }

    public final eq0<w4> j(gl glVar, b bVar, ny0 ny0) {
        z31 z31 = (z31) new z31(bVar).e(glVar).h(ny0);
        return m(e(z31), z31);
    }

    public final eq0<w4> s(gl glVar, dm dmVar, String str, String str2, String str3, a11 a11) {
        i31 i31 = (i31) new i31(str, str2, str3).e(glVar).f(dmVar).h(a11).i(a11);
        return m(e(i31), i31);
    }

    public final eq0<w4> q(gl glVar, dm dmVar, b bVar, a11 a11) {
        w21 w21 = (w21) new w21(bVar).e(glVar).f(dmVar).h(a11).i(a11);
        return m(e(w21), w21);
    }

    public final eq0<w4> k(gl glVar, g gVar, String str, ny0 ny0) {
        i41 i41 = (i41) new i41(gVar, str).e(glVar).h(ny0);
        return m(e(i41), i41);
    }

    public final eq0<w4> r(gl glVar, dm dmVar, g gVar, String str, a11 a11) {
        l31 l31 = (l31) new l31(gVar, str).e(glVar).f(dmVar).h(a11).i(a11);
        return m(e(l31), l31);
    }

    public final eq0<w4> g(gl glVar, dm dmVar, a aVar, a11 a11) {
        y90.j(glVar);
        y90.j(aVar);
        y90.j(dmVar);
        y90.j(a11);
        List<String> w = dmVar.w();
        if (w != null && w.contains(aVar.m())) {
            return lq0.d(y41.b(new Status(17015)));
        }
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            if (!bVar.w()) {
                a21 a21 = (a21) new a21(bVar).e(glVar).f(dmVar).h(a11).i(a11);
                return m(e(a21), a21);
            }
            m21 m21 = (m21) new m21(bVar).e(glVar).f(dmVar).h(a11).i(a11);
            return m(e(m21), m21);
        } else if (aVar instanceof g) {
            i21 i21 = (i21) new i21((g) aVar).e(glVar).f(dmVar).h(a11).i(a11);
            return m(e(i21), i21);
        } else {
            y90.j(glVar);
            y90.j(aVar);
            y90.j(dmVar);
            y90.j(a11);
            e21 e21 = (e21) new e21(aVar).e(glVar).f(dmVar).h(a11).i(a11);
            return m(e(e21), e21);
        }
    }

    static y81 n(gl glVar, b61 b61) {
        y90.j(glVar);
        y90.j(b61);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new i81(b61, "firebase"));
        List<w61> y = b61.y();
        if (y != null && !y.isEmpty()) {
            for (int i = 0; i < y.size(); i++) {
                arrayList.add(new i81(y.get(i)));
            }
        }
        y81 y81 = new y81(glVar, arrayList);
        y81.J(new g91(b61.w(), b61.v()));
        y81.K(b61.x());
        y81.I(b61.z());
        y81.z(k01.a(b61.A()));
        return y81;
    }

    private final <ResultT> eq0<ResultT> m(eq0<ResultT> eq0, f01<w41, ResultT> f01) {
        return eq0.k(new o01(this, f01));
    }
}
