package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: y81  reason: default package */
public class y81 extends dm {
    public static final Parcelable.Creator<y81> CREATOR = new k91();
    private g91 a;

    /* renamed from: a  reason: collision with other field name */
    private i01 f5858a;

    /* renamed from: a  reason: collision with other field name */
    private i81 f5859a;

    /* renamed from: a  reason: collision with other field name */
    private Boolean f5860a;

    /* renamed from: a  reason: collision with other field name */
    private String f5861a;

    /* renamed from: a  reason: collision with other field name */
    private List<i81> f5862a;

    /* renamed from: a  reason: collision with other field name */
    private l71 f5863a;

    /* renamed from: a  reason: collision with other field name */
    private s61 f5864a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f5865a;
    private String b;

    /* renamed from: b  reason: collision with other field name */
    private List<String> f5866b;
    private String c;

    y81(s61 s61, i81 i81, String str, String str2, List<i81> list, List<String> list2, String str3, Boolean bool, g91 g91, boolean z, l71 l71, i01 i01) {
        this.f5864a = s61;
        this.f5859a = i81;
        this.f5861a = str;
        this.b = str2;
        this.f5862a = list;
        this.f5866b = list2;
        this.c = str3;
        this.f5860a = bool;
        this.a = g91;
        this.f5865a = z;
        this.f5863a = l71;
        this.f5858a = i01;
    }

    public y81(gl glVar, List<? extends eu0> list) {
        y90.j(glVar);
        this.f5861a = glVar.l();
        this.b = "com.google.firebase.auth.internal.DefaultFirebaseUser";
        this.c = "2";
        v(list);
    }

    public final String B() {
        Map map;
        s61 s61 = this.f5864a;
        if (s61 == null || s61.t() == null || (map = (Map) g01.a(this.f5864a.t()).a().get("firebase")) == null) {
            return null;
        }
        return (String) map.get("tenant");
    }

    public final y81 H(String str) {
        this.c = str;
        return this;
    }

    public String i() {
        return this.f5859a.i();
    }

    public final gl A() {
        return gl.k(this.f5861a);
    }

    public final List<i81> L() {
        return this.f5862a;
    }

    public String r() {
        return this.f5859a.s();
    }

    public boolean s() {
        hp a2;
        Boolean bool = this.f5860a;
        if (bool == null || bool.booleanValue()) {
            s61 s61 = this.f5864a;
            String str = "";
            if (!(s61 == null || (a2 = g01.a(s61.t())) == null)) {
                str = a2.b();
            }
            boolean z = true;
            if (p().size() > 1 || (str != null && str.equals("custom"))) {
                z = false;
            }
            this.f5860a = Boolean.valueOf(z);
        }
        return this.f5860a.booleanValue();
    }

    public final List<String> w() {
        return this.f5866b;
    }

    public final dm v(List<? extends eu0> list) {
        y90.j(list);
        this.f5862a = new ArrayList(list.size());
        this.f5866b = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            eu0 eu0 = (eu0) list.get(i);
            if (eu0.i().equals("firebase")) {
                this.f5859a = (i81) eu0;
            } else {
                this.f5866b.add(eu0.i());
            }
            this.f5862a.add((i81) eu0);
        }
        if (this.f5859a == null) {
            this.f5859a = this.f5862a.get(0);
        }
        return this;
    }

    public List<? extends eu0> p() {
        return this.f5862a;
    }

    public final s61 D() {
        return this.f5864a;
    }

    public final String F() {
        return D().t();
    }

    public final String E() {
        return this.f5864a.w();
    }

    public final void x(s61 s61) {
        this.f5864a = (s61) y90.j(s61);
    }

    public final void J(g91 g91) {
        this.a = g91;
    }

    public em m() {
        return this.a;
    }

    public final void K(boolean z) {
        this.f5865a = z;
    }

    public final boolean M() {
        return this.f5865a;
    }

    public final void I(l71 l71) {
        this.f5863a = l71;
    }

    public final l71 N() {
        return this.f5863a;
    }

    public final void z(List<ga1> list) {
        this.f5858a = i01.p(list);
    }

    public final List<ga1> O() {
        i01 i01 = this.f5858a;
        if (i01 != null) {
            return i01.m();
        }
        return t11.j();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.k(parcel, 1, D(), i, false);
        fi0.k(parcel, 2, this.f5859a, i, false);
        fi0.l(parcel, 3, this.f5861a, false);
        fi0.l(parcel, 4, this.b, false);
        fi0.o(parcel, 5, this.f5862a, false);
        fi0.m(parcel, 6, w(), false);
        fi0.l(parcel, 7, this.c, false);
        fi0.d(parcel, 8, Boolean.valueOf(s()), false);
        fi0.k(parcel, 9, m(), i, false);
        fi0.c(parcel, 10, this.f5865a);
        fi0.k(parcel, 11, this.f5863a, i, false);
        fi0.k(parcel, 12, this.f5858a, i, false);
        fi0.b(parcel, a2);
    }

    public final /* synthetic */ ja1 G() {
        return new o91(this);
    }

    public final /* synthetic */ dm y() {
        this.f5860a = false;
        return this;
    }
}
