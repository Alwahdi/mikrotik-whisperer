package defpackage;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/* renamed from: pv  reason: default package */
public class pv extends tr {
    InputStream a;

    /* renamed from: a  reason: collision with other field name */
    ArrayList<a> f4732a = null;
    byte[] c;
    boolean i = false;
    int l;
    int m;
    int n;

    public pv(URL url) {
        super(url);
        w1();
    }

    private int t1(int n2) {
        int v = 0;
        for (int i2 = n2 - 1; i2 >= 0; i2--) {
            v += this.a.read() << (i2 << 3);
        }
        return v;
    }

    public void u1() {
        this.l = t1(4);
        this.m = t1(4);
        int i2 = this.l;
        if (i2 == 1) {
            if (t1(4) == 0) {
                int t1 = t1(4);
                this.l = t1;
                if (t1 == 0) {
                    throw new IOException(i10.b("unsupported.box.size.eq.eq.0", new Object[0]));
                }
                return;
            }
            throw new IOException(i10.b("cannot.handle.box.sizes.higher.than.2.32", new Object[0]));
        } else if (i2 == 0) {
            throw new b(i10.b("unsupported.box.size.eq.eq.0", new Object[0]));
        }
    }

    /* JADX INFO: finally extract failed */
    private void w1() {
        this.c = 33;
        this.g = 8;
        this.a = null;
        try {
            if (this.f5139a == null) {
                this.a = this.f5134a.openStream();
            } else {
                this.a = new ByteArrayInputStream(this.f5139a);
            }
            int t1 = t1(4);
            this.l = t1;
            if (t1 == 12) {
                this.i = true;
                int t12 = t1(4);
                this.m = t12;
                if (1783636000 != t12) {
                    throw new IOException(i10.b("expected.jp.marker", new Object[0]));
                } else if (218793738 == t1(4)) {
                    u1();
                    if (1718909296 == this.m) {
                        tu0.j(this.a, this.l - 8);
                        u1();
                        do {
                            int i2 = this.m;
                            if (1785737832 != i2) {
                                if (i2 != 1785737827) {
                                    tu0.j(this.a, this.l - 8);
                                    u1();
                                } else {
                                    throw new IOException(i10.b("expected.jp2h.marker", new Object[0]));
                                }
                            }
                        } while (1785737832 != this.m);
                        u1();
                        if (1768449138 == this.m) {
                            float t13 = (float) t1(4);
                            this.o = t13;
                            Y(t13);
                            float t14 = (float) t1(4);
                            this.n = t14;
                            W(t14);
                            this.n = t1(2);
                            this.d = -1;
                            this.d = t1(1);
                            tu0.j(this.a, 3);
                            u1();
                            int i3 = this.m;
                            if (i3 == 1651532643) {
                                int i4 = this.l;
                                byte[] bArr = new byte[(i4 - 8)];
                                this.c = bArr;
                                this.a.read(bArr, 0, i4 - 8);
                            } else if (i3 == 1668246642) {
                                do {
                                    if (this.f4732a == null) {
                                        this.f4732a = new ArrayList<>();
                                    }
                                    this.f4732a.add(v1());
                                    try {
                                        u1();
                                    } catch (b e) {
                                    }
                                } while (1668246642 == this.m);
                            }
                        } else {
                            throw new IOException(i10.b("expected.ihdr.marker", new Object[0]));
                        }
                    } else {
                        throw new IOException(i10.b("expected.ftyp.marker", new Object[0]));
                    }
                } else {
                    throw new IOException(i10.b("error.with.jp.marker", new Object[0]));
                }
            } else if (t1 == -11534511) {
                tu0.j(this.a, 4);
                int x1 = t1(4);
                int y1 = t1(4);
                int x0 = t1(4);
                int y0 = t1(4);
                tu0.j(this.a, 16);
                this.f5149j = t1(2);
                this.d = 8;
                float f = (float) (y1 - y0);
                this.o = f;
                Y(f);
                float f2 = (float) (x1 - x0);
                this.n = f2;
                W(f2);
            } else {
                throw new IOException(i10.b("not.a.valid.jpeg2000.file", new Object[0]));
            }
            InputStream inputStream = this.a;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e2) {
                }
                this.a = null;
            }
            this.l = M();
            this.m = D();
        } catch (Throwable th) {
            InputStream inputStream2 = this.a;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (Exception e3) {
                }
                this.a = null;
            }
            throw th;
        }
    }

    private a v1() {
        int readBytes = 8;
        a colr = new a();
        for (int i2 = 0; i2 < 3; i2++) {
            colr.add(Integer.valueOf(t1(1)));
            readBytes++;
        }
        if (colr.a() == 1) {
            colr.add(Integer.valueOf(t1(4)));
            readBytes += 4;
        } else {
            colr.add(0);
        }
        int i3 = this.l;
        if (i3 - readBytes > 0) {
            byte[] colorProfile = new byte[(i3 - readBytes)];
            this.a.read(colorProfile, 0, i3 - readBytes);
            colr.b(colorProfile);
        }
        return colr;
    }

    /* renamed from: pv$a */
    public static class a extends ArrayList<Integer> {
        private byte[] a;

        public int a() {
            return ((Integer) get(0)).intValue();
        }

        /* access modifiers changed from: package-private */
        public void b(byte[] colorProfile) {
            this.a = colorProfile;
        }
    }

    /* renamed from: pv$b */
    private class b extends IOException {
        public b(String s) {
            super(s);
        }
    }
}
