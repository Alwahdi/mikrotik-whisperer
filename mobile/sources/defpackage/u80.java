package defpackage;

/* renamed from: u80  reason: default package */
public class u80 {
    public static final h70[] a = {h70.i5, h70.h5, h70.j5, h70.V3, h70.Q0, h70.z2, h70.v7, h70.y2, h70.ld, h70.md, h70.a9, h70.b9, h70.f9, h70.O2, h70.K8, h70.e9, h70.A7};
    public static final h70[] b = {h70.Tc, h70.Vc, h70.Zc, h70.Uc};
    public static final h70[] c = {h70.b6, h70.v9};
    public static final h70[] d = {h70.Q6, h70.Q1, h70.r0, h70.qc, h70.N};
    public static final h70[] e = {h70.L, h70.u7};
    public static final h70[] f = {h70.Ka, h70.P2, h70.Q2};

    /* renamed from: a  reason: collision with other field name */
    private int f5233a = 0;

    /* renamed from: a  reason: collision with other field name */
    private j60 f5234a = new j60();

    public void a(j60 catalog) {
        h70 h70 = h70.o8;
        catalog.S(h70);
        int i = this.f5233a;
        if ((i & 1) != 0) {
            catalog.Q(h70, h70.La);
        } else if ((i & 2) != 0) {
            catalog.Q(h70, h70.R7);
        } else if ((i & 4) != 0) {
            catalog.Q(h70, h70.wc);
        } else if ((i & 8) != 0) {
            catalog.Q(h70, h70.xc);
        } else if ((i & 16) != 0) {
            catalog.Q(h70, h70.yc);
        } else if ((i & 32) != 0) {
            catalog.Q(h70, h70.zc);
        }
        h70 h702 = h70.p8;
        catalog.S(h702);
        int i2 = this.f5233a;
        if ((i2 & 64) != 0) {
            catalog.Q(h702, h70.Tc);
        } else if ((i2 & 128) != 0) {
            catalog.Q(h702, h70.Vc);
        } else if ((i2 & 256) != 0) {
            catalog.Q(h702, h70.Zc);
        } else if ((i2 & 512) != 0) {
            catalog.Q(h702, h70.u4);
        } else if ((i2 & 1024) != 0) {
            catalog.Q(h702, h70.Uc);
        } else if ((i2 & 2048) != 0) {
            catalog.Q(h702, h70.Sc);
        }
        h70 h703 = h70.nd;
        catalog.S(h703);
        if (this.f5234a.size() > 0) {
            catalog.Q(h703, this.f5234a);
        }
    }
}
