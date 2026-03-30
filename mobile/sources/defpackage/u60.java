package defpackage;

import java.io.OutputStream;

/* renamed from: u60  reason: default package */
public class u60 extends j60 {
    public static final h70 g = new h70("Normal");
    public static final h70 h = new h70("Compatible");
    public static final h70 i = new h70("Multiply");
    public static final h70 j = new h70("Screen");
    public static final h70 k = new h70("Overlay");
    public static final h70 l = new h70("Darken");
    public static final h70 m = new h70("Lighten");
    public static final h70 n = new h70("ColorDodge");
    public static final h70 o = new h70("ColorBurn");
    public static final h70 p = new h70("HardLight");
    public static final h70 q = new h70("SoftLight");
    public static final h70 r = new h70("Difference");
    public static final h70 s = new h70("Exclusion");

    public void U(float ca) {
        Q(h70.E0, new k70(ca));
    }

    public void T(float ca) {
        Q(h70.F0, new k70(ca));
    }

    public void F(v80 writer, OutputStream os) {
        v80.H(writer, 6, this);
        super.F(writer, os);
    }
}
