package defpackage;

import androidx.core.view.InputDeviceCompat;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.apache.http.HttpStatus;

/* renamed from: l10  reason: default package */
public class l10 {
    int a;

    /* renamed from: a  reason: collision with other field name */
    public d60 f4189a;

    /* renamed from: a  reason: collision with other field name */
    p10 f4190a = new p10();

    /* renamed from: a  reason: collision with other field name */
    public rs f4191a;
    int b;
    int c;
    int d;
    int e;

    public l10(InputStream in, d60 cb) {
        this.f4189a = cb;
        this.f4191a = new rs(in);
    }

    public void e() {
        int i;
        int i2;
        String str;
        int i3;
        float f;
        double d2;
        double d3;
        int i4;
        int i5;
        int i6;
        int i7;
        String str2;
        int i8;
        l10 l10 = this;
        int i9 = 0;
        if (l10.f4191a.d() == -1698247209) {
            l10.f4191a.f();
            l10.a = l10.f4191a.e();
            l10.b = l10.f4191a.e();
            l10.c = l10.f4191a.e();
            l10.d = l10.f4191a.e();
            int f2 = l10.f4191a.f();
            l10.e = f2;
            l10.f4190a.C((((float) (l10.c - l10.a)) / ((float) f2)) * 72.0f);
            l10.f4190a.D((((float) (l10.d - l10.b)) / ((float) l10.e)) * 72.0f);
            l10.f4190a.z(l10.a);
            l10.f4190a.A(l10.b);
            l10.f4190a.u(l10.c - l10.a);
            l10.f4190a.v(l10.d - l10.b);
            l10.f4191a.d();
            l10.f4191a.f();
            l10.f4191a.g(18);
            boolean z = true;
            l10.f4189a.g1(1);
            l10.f4189a.n1(1);
            while (true) {
                int a2 = l10.f4191a.a();
                int d4 = l10.f4191a.d();
                if (d4 < 3) {
                    l10.f4190a.b(l10.f4189a);
                    return;
                }
                int f3 = l10.f4191a.f();
                switch (f3) {
                    case 0:
                        i2 = a2;
                        i = d4;
                        break;
                    case 30:
                        i2 = a2;
                        i = d4;
                        l10.f4190a.o(l10.f4189a);
                        break;
                    case 247:
                    case 322:
                    case 1791:
                        i2 = a2;
                        i = d4;
                        l10.f4190a.a(new n10());
                        break;
                    case 258:
                        i2 = a2;
                        i = d4;
                        l10.f4190a.q(l10.f4191a.f());
                        break;
                    case 262:
                        i2 = a2;
                        i = d4;
                        l10.f4190a.B(l10.f4191a.f());
                        break;
                    case 295:
                        i2 = a2;
                        i = d4;
                        l10.f4190a.n(l10.f4191a.e(), l10.f4189a);
                        break;
                    case HttpStatus.SC_MOVED_PERMANENTLY /*301*/:
                        i2 = a2;
                        i = d4;
                        l10.f4190a.p(l10.f4191a.f(), l10.f4189a);
                        break;
                    case HttpStatus.SC_MOVED_TEMPORARILY /*302*/:
                        i2 = a2;
                        i = d4;
                        l10.f4190a.E(l10.f4191a.f());
                        break;
                    case 496:
                        i2 = a2;
                        i = d4;
                        l10.f4190a.c(l10.f4191a.f());
                        break;
                    case InputDeviceCompat.SOURCE_DPAD:
                        i2 = a2;
                        i = d4;
                        l10.f4190a.r(l10.f4191a.c());
                        break;
                    case 521:
                        i2 = a2;
                        i = d4;
                        l10.f4190a.t(l10.f4191a.c());
                        break;
                    case 523:
                        i2 = a2;
                        i = d4;
                        l10.f4190a.A(l10.f4191a.e());
                        l10.f4190a.z(l10.f4191a.e());
                        break;
                    case 524:
                        i2 = a2;
                        i = d4;
                        l10.f4190a.v(l10.f4191a.e());
                        l10.f4190a.u(l10.f4191a.e());
                        break;
                    case 531:
                        i2 = a2;
                        i = d4;
                        int e2 = l10.f4191a.e();
                        int e3 = l10.f4191a.e();
                        q90 i10 = l10.f4190a.i();
                        l10.f4189a.v0(l10.f4190a.G(i10.a), l10.f4190a.H(i10.b));
                        l10.f4189a.s0(l10.f4190a.G(e3), l10.f4190a.H(e2));
                        l10.f4189a.O1();
                        l10.f4190a.s(new q90(e3, e2));
                        break;
                    case 532:
                        i2 = a2;
                        i = d4;
                        l10.f4190a.s(new q90(l10.f4191a.e(), l10.f4191a.e()));
                        break;
                    case 762:
                        i2 = a2;
                        i = d4;
                        o10 o10 = new o10();
                        o10.e(l10.f4191a);
                        l10.f4190a.a(o10);
                        break;
                    case 763:
                        i2 = a2;
                        i = d4;
                        m10 m10 = new m10();
                        m10.e(l10.f4191a);
                        l10.f4190a.a(m10);
                        break;
                    case 764:
                        i2 = a2;
                        i = d4;
                        k10 k10 = new k10();
                        k10.d(l10.f4191a);
                        l10.f4190a.a(k10);
                        break;
                    case 804:
                        i2 = a2;
                        i = d4;
                        if (!l10.c(false)) {
                            int f4 = l10.f4191a.f();
                            int e4 = l10.f4191a.e();
                            int e5 = l10.f4191a.e();
                            l10.f4189a.v0(l10.f4190a.G(e4), l10.f4190a.H(e5));
                            for (int i11 = 1; i11 < f4; i11++) {
                                l10.f4189a.s0(l10.f4190a.G(l10.f4191a.e()), l10.f4190a.H(l10.f4191a.e()));
                            }
                            l10.f4189a.s0(l10.f4190a.G(e4), l10.f4190a.H(e5));
                            f();
                            break;
                        } else {
                            break;
                        }
                    case 805:
                        i2 = a2;
                        i = d4;
                        l10.f4190a.w(l10.f4189a);
                        int f5 = l10.f4191a.f();
                        l10.f4189a.v0(l10.f4190a.G(l10.f4191a.e()), l10.f4190a.H(l10.f4191a.e()));
                        for (int i12 = 1; i12 < f5; i12++) {
                            l10.f4189a.s0(l10.f4190a.G(l10.f4191a.e()), l10.f4190a.H(l10.f4191a.e()));
                        }
                        l10.f4189a.O1();
                        break;
                    case 1046:
                        i2 = a2;
                        i = d4;
                        float H = l10.f4190a.H(l10.f4191a.e());
                        float G = l10.f4190a.G(l10.f4191a.e());
                        float H2 = l10.f4190a.H(l10.f4191a.e());
                        float G2 = l10.f4190a.G(l10.f4191a.e());
                        l10.f4189a.B0(G2, H, G - G2, H2 - H);
                        l10.f4189a.X();
                        l10.f4189a.w0();
                        break;
                    case 1048:
                        i2 = a2;
                        i = d4;
                        if (!l10.c(l10.f4190a.k())) {
                            int e6 = l10.f4191a.e();
                            int e7 = l10.f4191a.e();
                            int e8 = l10.f4191a.e();
                            int e9 = l10.f4191a.e();
                            l10.f4189a.t(l10.f4190a.G(e9), l10.f4190a.H(e6), l10.f4190a.G(e7), l10.f4190a.H(e8), 0.0f, 360.0f);
                            f();
                            break;
                        } else {
                            break;
                        }
                    case 1051:
                        i2 = a2;
                        i = d4;
                        if (!l10.c(true)) {
                            float H3 = l10.f4190a.H(l10.f4191a.e());
                            float G3 = l10.f4190a.G(l10.f4191a.e());
                            float H4 = l10.f4190a.H(l10.f4191a.e());
                            float G4 = l10.f4190a.G(l10.f4191a.e());
                            l10.f4189a.B0(G4, H3, G3 - G4, H4 - H3);
                            f();
                            break;
                        } else {
                            break;
                        }
                    case 1055:
                        i2 = a2;
                        i = d4;
                        w5 c2 = l10.f4191a.c();
                        int e10 = l10.f4191a.e();
                        int e11 = l10.f4191a.e();
                        l10.f4189a.Q0();
                        l10.f4189a.U0(c2);
                        l10.f4189a.B0(l10.f4190a.G(e11), l10.f4190a.H(e10), 0.2f, 0.2f);
                        l10.f4189a.Z();
                        l10.f4189a.K0();
                        break;
                    case 1313:
                        i2 = a2;
                        i = d4;
                        int f6 = l10.f4191a.f();
                        byte[] bArr = new byte[f6];
                        int i13 = 0;
                        while (i13 < f6) {
                            byte b2 = (byte) l10.f4191a.b();
                            if (b2 != 0) {
                                bArr[i13] = b2;
                                i13++;
                            }
                        }
                        try {
                            i3 = 0;
                            try {
                                str = new String(bArr, 0, i13, "Cp1252");
                            } catch (UnsupportedEncodingException e12) {
                                str = new String(bArr, i3, i13);
                                l10.f4191a.g((65534 & (f6 + 1)) - i13);
                                d(l10.f4191a.e(), l10.f4191a.e(), 0, 0, 0, 0, 0, str);
                                rs rsVar = l10.f4191a;
                                rsVar.g((i * 2) - (rsVar.a() - i2));
                                i9 = 0;
                                z = true;
                            }
                        } catch (UnsupportedEncodingException e13) {
                            i3 = 0;
                            str = new String(bArr, i3, i13);
                            l10.f4191a.g((65534 & (f6 + 1)) - i13);
                            d(l10.f4191a.e(), l10.f4191a.e(), 0, 0, 0, 0, 0, str);
                            rs rsVar2 = l10.f4191a;
                            rsVar2.g((i * 2) - (rsVar2.a() - i2));
                            i9 = 0;
                            z = true;
                        }
                        l10.f4191a.g((65534 & (f6 + 1)) - i13);
                        d(l10.f4191a.e(), l10.f4191a.e(), 0, 0, 0, 0, 0, str);
                    case 1336:
                        i2 = a2;
                        i = d4;
                        if (!l10.c(false)) {
                            int f7 = l10.f4191a.f();
                            int[] iArr = new int[f7];
                            for (int i14 = 0; i14 < f7; i14++) {
                                iArr[i14] = l10.f4191a.f();
                            }
                            for (int i15 = 0; i15 < f7; i15++) {
                                int i16 = iArr[i15];
                                int e14 = l10.f4191a.e();
                                int e15 = l10.f4191a.e();
                                l10.f4189a.v0(l10.f4190a.G(e14), l10.f4190a.H(e15));
                                for (int i17 = 1; i17 < i16; i17++) {
                                    l10.f4189a.s0(l10.f4190a.G(l10.f4191a.e()), l10.f4190a.H(l10.f4191a.e()));
                                }
                                l10.f4189a.s0(l10.f4190a.G(e14), l10.f4190a.H(e15));
                            }
                            f();
                            break;
                        } else {
                            break;
                        }
                    case 1564:
                        i2 = a2;
                        i = d4;
                        if (!l10.c(true)) {
                            float H5 = l10.f4190a.H(0) - l10.f4190a.H(l10.f4191a.e());
                            float G5 = l10.f4190a.G(l10.f4191a.e()) - l10.f4190a.G(0);
                            float H6 = l10.f4190a.H(l10.f4191a.e());
                            float G6 = l10.f4190a.G(l10.f4191a.e());
                            float H7 = l10.f4190a.H(l10.f4191a.e());
                            float G7 = l10.f4190a.G(l10.f4191a.e());
                            l10.f4189a.M0(G7, H6, G6 - G7, H7 - H6, (H5 + G5) / 4.0f);
                            f();
                            break;
                        } else {
                            break;
                        }
                    case 2071:
                        i2 = a2;
                        i = d4;
                        if (!l10.c(l10.f4190a.k())) {
                            float H8 = l10.f4190a.H(l10.f4191a.e());
                            float G8 = l10.f4190a.G(l10.f4191a.e());
                            float H9 = l10.f4190a.H(l10.f4191a.e());
                            float G9 = l10.f4190a.G(l10.f4191a.e());
                            float H10 = l10.f4190a.H(l10.f4191a.e());
                            float G10 = l10.f4190a.G(l10.f4191a.e());
                            float H11 = l10.f4190a.H(l10.f4191a.e());
                            float G11 = l10.f4190a.G(l10.f4191a.e());
                            float f8 = (G10 + G11) / 2.0f;
                            float f9 = (H11 + H10) / 2.0f;
                            float b3 = b(f8, f9, G9, H9);
                            float b4 = b(f8, f9, G8, H8) - b3;
                            if (b4 <= 0.0f) {
                                f = b4 + 360.0f;
                            } else {
                                f = b4;
                            }
                            l10.f4189a.t(G11, H10, G10, H11, b3, f);
                            l10.f4189a.O1();
                            break;
                        } else {
                            break;
                        }
                    case 2074:
                        i2 = a2;
                        i = d4;
                        if (!l10.c(l10.f4190a.k())) {
                            float H12 = l10.f4190a.H(l10.f4191a.e());
                            float G12 = l10.f4190a.G(l10.f4191a.e());
                            float H13 = l10.f4190a.H(l10.f4191a.e());
                            float G13 = l10.f4190a.G(l10.f4191a.e());
                            float H14 = l10.f4190a.H(l10.f4191a.e());
                            float G14 = l10.f4190a.G(l10.f4191a.e());
                            float H15 = l10.f4190a.H(l10.f4191a.e());
                            float G15 = l10.f4190a.G(l10.f4191a.e());
                            float f10 = (G14 + G15) / 2.0f;
                            float f11 = (H15 + H14) / 2.0f;
                            double b5 = (double) b(f10, f11, G13, H13);
                            double b6 = ((double) b(f10, f11, G12, H12)) - b5;
                            if (b6 <= 0.0d) {
                                d2 = b6 + 360.0d;
                            } else {
                                d2 = b6;
                            }
                            ArrayList<double[]> C = d60.C((double) G15, (double) H14, (double) G14, (double) H15, b5, d2);
                            if (!C.isEmpty()) {
                                double[] dArr = C.get(0);
                                l10.f4189a.v0(f10, f11);
                                l10.f4189a.r0(dArr[0], dArr[1]);
                                for (int i18 = 0; i18 < C.size(); i18++) {
                                    double[] dArr2 = C.get(i18);
                                    l10.f4189a.S(dArr2[2], dArr2[3], dArr2[4], dArr2[5], dArr2[6], dArr2[7]);
                                }
                                l10.f4189a.s0(f10, f11);
                                f();
                                break;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    case 2096:
                        if (!l10.c(l10.f4190a.k())) {
                            float H16 = l10.f4190a.H(l10.f4191a.e());
                            float G16 = l10.f4190a.G(l10.f4191a.e());
                            float H17 = l10.f4190a.H(l10.f4191a.e());
                            float G17 = l10.f4190a.G(l10.f4191a.e());
                            float H18 = l10.f4190a.H(l10.f4191a.e());
                            float G18 = l10.f4190a.G(l10.f4191a.e());
                            float H19 = l10.f4190a.H(l10.f4191a.e());
                            float G19 = l10.f4190a.G(l10.f4191a.e());
                            i2 = a2;
                            i = d4;
                            double d5 = (double) ((G18 + G19) / 2.0f);
                            double d6 = (double) ((H19 + H18) / 2.0f);
                            double a3 = a(d5, d6, (double) G17, (double) H17);
                            double a4 = a(d5, d6, (double) G16, (double) H16) - a3;
                            if (a4 <= 0.0d) {
                                d3 = a4 + 360.0d;
                            } else {
                                d3 = a4;
                            }
                            ArrayList<double[]> C2 = d60.C((double) G19, (double) H18, (double) G18, (double) H19, a3, d3);
                            if (!C2.isEmpty()) {
                                double[] dArr3 = C2.get(0);
                                double d7 = dArr3[0];
                                double d8 = dArr3[1];
                                l10 = this;
                                l10.f4189a.u0(d7, d8);
                                for (int i19 = 0; i19 < C2.size(); i19++) {
                                    double[] dArr4 = C2.get(i19);
                                    l10.f4189a.S(dArr4[2], dArr4[3], dArr4[4], dArr4[5], dArr4[6], dArr4[7]);
                                }
                                l10.f4189a.r0(d7, d8);
                                f();
                                break;
                            } else {
                                l10 = this;
                                break;
                            }
                        } else {
                            i2 = a2;
                            i = d4;
                            break;
                        }
                    case 2610:
                        int e16 = l10.f4191a.e();
                        int e17 = l10.f4191a.e();
                        int f12 = l10.f4191a.f();
                        int f13 = l10.f4191a.f();
                        if ((f13 & 6) != 0) {
                            int e18 = l10.f4191a.e();
                            int e19 = l10.f4191a.e();
                            int e20 = l10.f4191a.e();
                            i4 = l10.f4191a.e();
                            i5 = e20;
                            i6 = e19;
                            i7 = e18;
                        } else {
                            i7 = 0;
                            i6 = 0;
                            i5 = 0;
                            i4 = 0;
                        }
                        byte[] bArr2 = new byte[f12];
                        int i20 = 0;
                        while (i20 < f12) {
                            byte b7 = (byte) l10.f4191a.b();
                            if (b7 != 0) {
                                bArr2[i20] = b7;
                                i20++;
                            }
                        }
                        try {
                            i8 = 0;
                            try {
                                str2 = new String(bArr2, 0, i20, "Cp1252");
                            } catch (UnsupportedEncodingException e21) {
                            }
                        } catch (UnsupportedEncodingException e22) {
                            i8 = 0;
                            str2 = new String(bArr2, i8, i20);
                            d(e17, e16, f13, i7, i6, i5, i4, str2);
                            i2 = a2;
                            i = d4;
                            rs rsVar22 = l10.f4191a;
                            rsVar22.g((i * 2) - (rsVar22.a() - i2));
                            i9 = 0;
                            z = true;
                        }
                        d(e17, e16, f13, i7, i6, i5, i4, str2);
                        i2 = a2;
                        i = d4;
                    case 2881:
                    case 3907:
                        l10.f4191a.d();
                        if (f3 == 3907) {
                            l10.f4191a.f();
                        }
                        int e23 = l10.f4191a.e();
                        int e24 = l10.f4191a.e();
                        int e25 = l10.f4191a.e();
                        int e26 = l10.f4191a.e();
                        float H20 = l10.f4190a.H(l10.f4191a.e()) - l10.f4190a.H(i9);
                        float G20 = l10.f4190a.G(l10.f4191a.e()) - l10.f4190a.G(i9);
                        float H21 = l10.f4190a.H(l10.f4191a.e());
                        float G21 = l10.f4190a.G(l10.f4191a.e());
                        int a5 = (d4 * 2) - (l10.f4191a.a() - a2);
                        byte[] bArr3 = new byte[a5];
                        for (int i21 = 0; i21 < a5; i21++) {
                            bArr3[i21] = (byte) l10.f4191a.b();
                        }
                        try {
                            tr f14 = o6.f(new ByteArrayInputStream(bArr3), z, a5);
                            l10.f4189a.Q0();
                            l10.f4189a.B0(G21, H21, G20, H20);
                            l10.f4189a.G();
                            l10.f4189a.w0();
                            float f15 = (float) e24;
                            float f16 = (float) e23;
                            f14.Y0((f14.M() * G20) / f15, ((-H20) * f14.D()) / f16);
                            f14.b1(G21 - ((G20 * ((float) e26)) / f15), (H21 + ((H20 * ((float) e25)) / f16)) - f14.A0());
                            l10.f4189a.g(f14);
                            l10.f4189a.K0();
                            i2 = a2;
                            i = d4;
                            break;
                        } catch (Exception e27) {
                            i2 = a2;
                            i = d4;
                            break;
                        }
                    default:
                        i2 = a2;
                        i = d4;
                        break;
                }
                rs rsVar222 = l10.f4191a;
                rsVar222.g((i * 2) - (rsVar222.a() - i2));
                i9 = 0;
                z = true;
            }
        } else {
            throw new ih(i10.b("not.a.placeable.windows.metafile", new Object[0]));
        }
    }

    public void d(int x, int y, int flag, int x1, int y1, int x2, int y2, String text) {
        float tx;
        float ty;
        float descender;
        String str = text;
        m10 font = this.f4190a.g();
        float refX = this.f4190a.G(x);
        float refY = this.f4190a.H(y);
        float angle = this.f4190a.F(font.b());
        float sin = (float) Math.sin((double) angle);
        float cos = (float) Math.cos((double) angle);
        float fontSize = font.d(this.f4190a);
        y5 bf = font.c();
        int align = this.f4190a.m();
        float textWidth = bf.w(str, fontSize);
        float descender2 = bf.l(3, fontSize);
        float ury = bf.l(8, fontSize);
        this.f4189a.Q0();
        float ury2 = ury;
        float f = angle;
        float descender3 = descender2;
        float textWidth2 = textWidth;
        float textWidth3 = -sin;
        y5 bf2 = bf;
        float f2 = sin;
        float fontSize2 = fontSize;
        float f3 = cos;
        this.f4189a.P(cos, sin, textWidth3, cos, refX, refY);
        if ((align & 6) == 6) {
            tx = (-textWidth2) / 2.0f;
        } else if ((align & 2) == 2) {
            tx = -textWidth2;
        } else {
            tx = 0.0f;
        }
        if ((align & 24) == 24) {
            ty = 0.0f;
            descender = descender3;
        } else if ((align & 8) == 8) {
            descender = descender3;
            ty = -descender;
        } else {
            descender = descender3;
            ty = -ury2;
        }
        if (this.f4190a.d() == 2) {
            this.f4189a.U0(this.f4190a.e());
            this.f4189a.B0(tx, ty + descender, textWidth2, ury2 - descender);
            this.f4189a.Z();
        }
        this.f4189a.U0(this.f4190a.j());
        this.f4189a.A();
        this.f4189a.c1(bf2, fontSize2);
        this.f4189a.D1(tx, ty);
        this.f4189a.K1(str);
        this.f4189a.V();
        if (font.g()) {
            this.f4189a.B0(tx, ty - (fontSize2 / 4.0f), textWidth2, fontSize2 / 15.0f);
            this.f4189a.Z();
        }
        if (font.f()) {
            this.f4189a.B0(tx, (fontSize2 / 3.0f) + ty, textWidth2, fontSize2 / 15.0f);
            this.f4189a.Z();
        }
        this.f4189a.K0();
    }

    public boolean c(boolean isRectangle) {
        o10 pen = this.f4190a.h();
        k10 brush = this.f4190a.f();
        boolean result = true;
        boolean noPen = pen.d() == 5;
        int style = brush.c();
        boolean isBrush = style == 0 || (style == 2 && this.f4190a.d() == 2);
        if (!noPen || isBrush) {
            result = false;
        }
        if (!noPen) {
            if (isRectangle) {
                this.f4190a.x(this.f4189a);
            } else {
                this.f4190a.w(this.f4189a);
            }
        }
        return result;
    }

    public void f() {
        o10 pen = this.f4190a.h();
        k10 brush = this.f4190a.f();
        int penStyle = pen.d();
        int brushStyle = brush.c();
        if (penStyle == 5) {
            this.f4189a.J();
            if (this.f4190a.l() == 1) {
                this.f4189a.Y();
            } else {
                this.f4189a.Z();
            }
        } else {
            if (!(brushStyle == 0 || (brushStyle == 2 && this.f4190a.d() == 2))) {
                this.f4189a.M();
            } else if (this.f4190a.l() == 1) {
                this.f4189a.K();
            } else {
                this.f4189a.L();
            }
        }
    }

    static float b(float xCenter, float yCenter, float xDot, float yDot) {
        return (float) a((double) xCenter, (double) yCenter, (double) xDot, (double) yDot);
    }

    static double a(double xCenter, double yCenter, double xDot, double yDot) {
        double s = Math.atan2(yDot - yCenter, xDot - xCenter);
        if (s < 0.0d) {
            s += 6.283185307179586d;
        }
        return (double) ((float) ((s / 3.141592653589793d) * 180.0d));
    }
}
