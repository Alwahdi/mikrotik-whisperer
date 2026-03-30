package defpackage;

import com.google.firebase.auth.a;
import com.google.firebase.auth.c;
import com.google.firebase.auth.d;
import com.google.firebase.auth.e;
import com.google.firebase.auth.i;
import com.google.firebase.auth.j;

/* renamed from: e31  reason: default package */
public abstract class e31 {
    public static f71 a(a aVar, String str) {
        y90.j(aVar);
        if (e.class.isAssignableFrom(aVar.getClass())) {
            return e.t((e) aVar, str);
        }
        if (c.class.isAssignableFrom(aVar.getClass())) {
            return c.s((c) aVar, str);
        }
        if (j.class.isAssignableFrom(aVar.getClass())) {
            return j.s((j) aVar, str);
        }
        if (d.class.isAssignableFrom(aVar.getClass())) {
            return d.s((d) aVar, str);
        }
        if (i.class.isAssignableFrom(aVar.getClass())) {
            return i.s((i) aVar, str);
        }
        if (l71.class.isAssignableFrom(aVar.getClass())) {
            return l71.v((l71) aVar, str);
        }
        throw new IllegalArgumentException("Unsupported credential type.");
    }
}
