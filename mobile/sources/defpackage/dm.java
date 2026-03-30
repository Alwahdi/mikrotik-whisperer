package defpackage;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.a;
import java.util.List;

/* renamed from: dm  reason: default package */
public abstract class dm extends x implements eu0 {
    public abstract gl A();

    public abstract String B();

    public abstract s61 D();

    public abstract String E();

    public abstract String F();

    public abstract ja1 G();

    public abstract em m();

    public abstract List<? extends eu0> p();

    public abstract String r();

    public abstract boolean s();

    public abstract dm v(List<? extends eu0> list);

    public abstract List<String> w();

    public abstract void x(s61 s61);

    public abstract dm y();

    public abstract void z(List<ga1> list);

    public eq0<w4> u(a aVar) {
        y90.j(aVar);
        return FirebaseAuth.getInstance(A()).r(this, aVar);
    }

    public eq0<w4> t(a aVar) {
        y90.j(aVar);
        return FirebaseAuth.getInstance(A()).u(this, aVar);
    }
}
