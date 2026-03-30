package defpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: w60  reason: default package */
public class w60 extends m80 {
    protected tr a = null;
    protected h70 g = null;

    public w60(tr image, String name, z60 maskRef) {
        String errorID;
        this.a = image;
        if (name == null) {
            Y(image);
        } else {
            this.g = new h70(name);
        }
        Q(h70.Bc, h70.Rd);
        Q(h70.tb, h70.w5);
        Q(h70.Ad, new k70(image.M()));
        Q(h70.Y4, new k70(image.D()));
        if (image.x0() != null) {
            Q(h70.G7, image.x0().d());
        }
        if (image.Q0() && (image.e0() == 1 || image.e0() > 255)) {
            Q(h70.A5, z50.a);
        }
        if (maskRef != null) {
            if (image.U0()) {
                Q(h70.Na, maskRef);
            } else {
                Q(h70.M6, maskRef);
            }
        }
        if (image.Q0() && image.P0()) {
            Q(h70.e2, new f70("[1 0]"));
        }
        if (image.O0()) {
            Q(h70.L5, z50.a);
        }
        InputStream is = null;
        try {
            int[] transparency = image.F0();
            if (transparency != null && !image.Q0() && maskRef == null) {
                StringBuilder s = new StringBuilder("[");
                for (int append : transparency) {
                    s.append(append);
                    s.append(" ");
                }
                s.append("]");
                Q(h70.M6, new f70(s.toString()));
            }
            if (image.M0()) {
                int colorspace = image.g0();
                byte[] z0 = image.z0();
                this.f4495a = z0;
                Q(h70.m6, new k70(z0.length));
                int bpc = image.e0();
                if (bpc > 255) {
                    if (!image.Q0()) {
                        Q(h70.n1, h70.r2);
                    }
                    Q(h70.l0, new k70(1));
                    Q(h70.K3, h70.O0);
                    int k = bpc - 257;
                    j60 decodeparms = new j60();
                    if (k != 0) {
                        decodeparms.Q(h70.X5, new k70(k));
                    }
                    if ((colorspace & 1) != 0) {
                        decodeparms.Q(h70.o0, z50.a);
                    }
                    if ((colorspace & 2) != 0) {
                        decodeparms.Q(h70.c3, z50.a);
                    }
                    if ((colorspace & 4) != 0) {
                        decodeparms.Q(h70.j3, z50.a);
                    }
                    if ((colorspace & 8) != 0) {
                        decodeparms.Q(h70.i3, z50.b);
                    }
                    decodeparms.Q(h70.x1, new k70(image.M()));
                    decodeparms.Q(h70.ma, new k70(image.D()));
                    Q(h70.f2, decodeparms);
                } else {
                    switch (colorspace) {
                        case 1:
                            Q(h70.n1, h70.r2);
                            if (image.P0()) {
                                Q(h70.e2, new f70("[1 0]"));
                                break;
                            }
                            break;
                        case 3:
                            Q(h70.n1, h70.s2);
                            if (image.P0()) {
                                Q(h70.e2, new f70("[1 0 1 0 1 0]"));
                                break;
                            }
                            break;
                        default:
                            Q(h70.n1, h70.t2);
                            if (image.P0()) {
                                Q(h70.e2, new f70("[1 0 1 0 1 0 1 0]"));
                                break;
                            }
                            break;
                    }
                    j60 additional = image.b0();
                    if (additional != null) {
                        R(additional);
                    }
                    if (image.Q0() && (image.e0() == 1 || image.e0() > 8)) {
                        S(h70.n1);
                    }
                    Q(h70.l0, new k70(image.e0()));
                    if (image.L0()) {
                        Q(h70.K3, h70.a4);
                    } else {
                        T(image.h0());
                    }
                }
                if (is != null) {
                    try {
                        is.close();
                    } catch (Exception e) {
                    }
                }
            } else {
                if (image.z0() == null) {
                    is = image.G0().openStream();
                    errorID = image.G0().toString();
                } else {
                    is = new ByteArrayInputStream(image.z0());
                    errorID = "Byte array";
                }
                switch (image.v()) {
                    case 32:
                        Q(h70.K3, h70.b2);
                        if (image.f0() == 0) {
                            j60 decodeparms2 = new j60();
                            decodeparms2.Q(h70.o1, new k70(0));
                            Q(h70.f2, decodeparms2);
                        }
                        switch (image.g0()) {
                            case 1:
                                Q(h70.n1, h70.r2);
                                break;
                            case 3:
                                Q(h70.n1, h70.s2);
                                break;
                            default:
                                Q(h70.n1, h70.t2);
                                if (image.P0()) {
                                    Q(h70.e2, new f70("[1 0 1 0 1 0 1 0]"));
                                    break;
                                }
                                break;
                        }
                        Q(h70.l0, new k70(8));
                        if (image.z0() == null) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            this.a = byteArrayOutputStream;
                            a0(is, byteArrayOutputStream, -1);
                            break;
                        } else {
                            byte[] z02 = image.z0();
                            this.f4495a = z02;
                            Q(h70.m6, new k70(z02.length));
                            if (is != null) {
                                try {
                                    is.close();
                                    return;
                                } catch (Exception e2) {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                    case 33:
                        Q(h70.K3, h70.U5);
                        if (image.g0() > 0) {
                            switch (image.g0()) {
                                case 1:
                                    Q(h70.n1, h70.r2);
                                    break;
                                case 3:
                                    Q(h70.n1, h70.s2);
                                    break;
                                default:
                                    Q(h70.n1, h70.t2);
                                    break;
                            }
                            Q(h70.l0, new k70(image.e0()));
                        }
                        if (image.z0() == null) {
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                            this.a = byteArrayOutputStream2;
                            a0(is, byteArrayOutputStream2, -1);
                            break;
                        } else {
                            byte[] z03 = image.z0();
                            this.f4495a = z03;
                            Q(h70.m6, new k70(z03.length));
                            if (is != null) {
                                try {
                                    is.close();
                                    return;
                                } catch (Exception e3) {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                    case 36:
                        Q(h70.K3, h70.S5);
                        Q(h70.n1, h70.r2);
                        Q(h70.l0, new k70(1));
                        if (image.z0() == null) {
                            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                            this.a = byteArrayOutputStream3;
                            a0(is, byteArrayOutputStream3, -1);
                            break;
                        } else {
                            byte[] z04 = image.z0();
                            this.f4495a = z04;
                            Q(h70.m6, new k70(z04.length));
                            if (is != null) {
                                try {
                                    is.close();
                                    return;
                                } catch (Exception e4) {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                    default:
                        throw new o5(i10.b("1.is.an.unknown.image.format", errorID));
                }
                if (image.h0() > 0) {
                    T(image.h0());
                }
                Q(h70.m6, new k70(this.a.size()));
                if (is != null) {
                    try {
                        is.close();
                    } catch (Exception e5) {
                    }
                }
            }
        } catch (IOException ioe) {
            throw new o5(ioe.getMessage());
        } catch (Throwable th) {
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e6) {
                }
            }
            throw th;
        }
    }

    public h70 Z() {
        return this.g;
    }

    static void a0(InputStream in, OutputStream out, int len) {
        byte[] buffer = new byte[4096];
        if (len < 0) {
            len = 2147418112;
        }
        while (len != 0) {
            int size = in.read(buffer, 0, Math.min(len, 4096));
            if (size >= 0) {
                out.write(buffer, 0, size);
                len -= size;
            } else {
                return;
            }
        }
    }

    private void Y(tr img) {
        this.g = new h70("img" + Long.toHexString(img.y0().longValue()));
    }
}
