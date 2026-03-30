package defpackage;

import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* renamed from: w6  reason: default package */
public class w6 extends OutputStream {
    private static final DecimalFormatSymbols a = new DecimalFormatSymbols(Locale.US);

    /* renamed from: a  reason: collision with other field name */
    public static boolean f5454a = false;

    /* renamed from: a  reason: collision with other field name */
    private static final char[] f5455a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /* renamed from: a  reason: collision with other field name */
    private static byte[][] f5456a = new byte[0][];
    private static int b = 0;

    /* renamed from: b  reason: collision with other field name */
    private static final byte[] f5457b = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: a  reason: collision with other field name */
    protected int f5458a;

    /* renamed from: a  reason: collision with other field name */
    protected byte[] f5459a;

    public w6() {
        this(128);
    }

    public w6(int size) {
        this.f5459a = new byte[(size < 1 ? 128 : size)];
    }

    public w6 V(int b2) {
        int newcount = this.f5458a + 1;
        byte[] bArr = this.f5459a;
        if (newcount > bArr.length) {
            byte[] newbuf = new byte[Math.max(bArr.length << 1, newcount)];
            System.arraycopy(this.f5459a, 0, newbuf, 0, this.f5458a);
            this.f5459a = newbuf;
        }
        this.f5459a[this.f5458a] = (byte) b2;
        this.f5458a = newcount;
        return this;
    }

    public w6 P(byte[] b2, int off, int len) {
        if (off < 0 || off > b2.length || len < 0 || off + len > b2.length || off + len < 0 || len == 0) {
            return this;
        }
        int newcount = this.f5458a + len;
        byte[] bArr = this.f5459a;
        if (newcount > bArr.length) {
            byte[] newbuf = new byte[Math.max(bArr.length << 1, newcount)];
            System.arraycopy(this.f5459a, 0, newbuf, 0, this.f5458a);
            this.f5459a = newbuf;
        }
        System.arraycopy(b2, off, this.f5459a, this.f5458a, len);
        this.f5458a = newcount;
        return this;
    }

    public w6 K(byte[] b2) {
        return P(b2, 0, b2.length);
    }

    public w6 J(String str) {
        if (str != null) {
            return K(fh.b(str));
        }
        return this;
    }

    public w6 f(char c) {
        return V(c);
    }

    public w6 C(w6 buf) {
        return P(buf.f5459a, 0, buf.f5458a);
    }

    public w6 w(int i) {
        return o((double) i);
    }

    public w6 c(byte b2) {
        return V(b2);
    }

    public w6 U(byte b2) {
        byte[] bArr = f5457b;
        c(bArr[(b2 >> 4) & 15]);
        return c(bArr[b2 & 15]);
    }

    public w6 q(float i) {
        return o((double) i);
    }

    public w6 o(double d) {
        J(Y(d, this));
        return this;
    }

    public static String X(double d) {
        return Y(d, (w6) null);
    }

    public static String Y(double d, w6 buf) {
        double d2 = d;
        w6 w6Var = buf;
        if (f5454a) {
            String sform = new DecimalFormat("0.######", a).format(d2);
            if (w6Var == null) {
                return sform;
            }
            w6Var.J(sform);
            return null;
        }
        boolean negative = false;
        if (Math.abs(d) >= 1.5E-5d) {
            if (d2 < 0.0d) {
                negative = true;
                d2 = -d2;
            }
            if (d2 < 1.0d) {
                double d3 = d2 + 5.0E-6d;
                if (d3 >= 1.0d) {
                    if (negative) {
                        if (w6Var == null) {
                            return "-1";
                        }
                        w6Var.c((byte) 45);
                        w6Var.c((byte) 49);
                        return null;
                    } else if (w6Var == null) {
                        return "1";
                    } else {
                        w6Var.c((byte) 49);
                        return null;
                    }
                } else if (w6Var != null) {
                    int v = (int) (100000.0d * d3);
                    if (negative) {
                        w6Var.c((byte) 45);
                    }
                    w6Var.c((byte) 48);
                    w6Var.c((byte) 46);
                    w6Var.c((byte) ((v / 10000) + 48));
                    if (v % 10000 != 0) {
                        w6Var.c((byte) (((v / 1000) % 10) + 48));
                        if (v % 1000 != 0) {
                            w6Var.c((byte) (((v / 100) % 10) + 48));
                            if (v % 100 != 0) {
                                w6Var.c((byte) (((v / 10) % 10) + 48));
                                if (v % 10 != 0) {
                                    w6Var.c((byte) ((v % 10) + 48));
                                }
                            }
                        }
                    }
                    return null;
                } else {
                    int v2 = (int) (((double) 100000) * d3);
                    StringBuilder res = new StringBuilder();
                    if (negative) {
                        res.append('-');
                    }
                    res.append("0.");
                    for (int x = 100000; v2 < x / 10; x /= 10) {
                        res.append('0');
                    }
                    res.append(v2);
                    int cut = res.length();
                    while (true) {
                        cut--;
                        if (res.charAt(cut) != '0') {
                            res.setLength(cut + 1);
                            return res.toString();
                        }
                    }
                }
            } else if (d2 <= 32767.0d) {
                int v3 = (int) (100.0d * (d2 + 0.005d));
                int i = b;
                if (v3 < i) {
                    byte[][] bArr = f5456a;
                    if (bArr[v3] != null) {
                        if (w6Var != null) {
                            if (negative) {
                                w6Var.c((byte) 45);
                            }
                            w6Var.K(f5456a[v3]);
                            return null;
                        }
                        String tmp = n60.d(bArr[v3], (String) null);
                        if (!negative) {
                            return tmp;
                        }
                        return "-" + tmp;
                    }
                }
                if (w6Var != null) {
                    if (v3 < i) {
                        int size = 0;
                        if (v3 >= 1000000) {
                            size = 0 + 5;
                        } else if (v3 >= 100000) {
                            size = 0 + 4;
                        } else if (v3 >= 10000) {
                            size = 0 + 3;
                        } else if (v3 >= 1000) {
                            size = 0 + 2;
                        } else if (v3 >= 100) {
                            size = 0 + 1;
                        }
                        if (v3 % 100 != 0) {
                            size += 2;
                        }
                        if (v3 % 10 != 0) {
                            size++;
                        }
                        byte[] cache = new byte[size];
                        int add = 0;
                        if (v3 >= 1000000) {
                            cache[0] = f5457b[v3 / 1000000];
                            add = 0 + 1;
                        }
                        if (v3 >= 100000) {
                            cache[add] = f5457b[(v3 / 100000) % 10];
                            add++;
                        }
                        if (v3 >= 10000) {
                            cache[add] = f5457b[(v3 / 10000) % 10];
                            add++;
                        }
                        if (v3 >= 1000) {
                            cache[add] = f5457b[(v3 / 1000) % 10];
                            add++;
                        }
                        if (v3 >= 100) {
                            cache[add] = f5457b[(v3 / 100) % 10];
                            add++;
                        }
                        if (v3 % 100 != 0) {
                            int add2 = add + 1;
                            cache[add] = 46;
                            int add3 = add2 + 1;
                            byte[] bArr2 = f5457b;
                            cache[add2] = bArr2[(v3 / 10) % 10];
                            if (v3 % 10 != 0) {
                                cache[add3] = bArr2[v3 % 10];
                                int i2 = add3 + 1;
                            }
                        }
                        f5456a[v3] = cache;
                    }
                    if (negative) {
                        w6Var.c((byte) 45);
                    }
                    if (v3 >= 1000000) {
                        w6Var.c(f5457b[v3 / 1000000]);
                    }
                    if (v3 >= 100000) {
                        w6Var.c(f5457b[(v3 / 100000) % 10]);
                    }
                    if (v3 >= 10000) {
                        w6Var.c(f5457b[(v3 / 10000) % 10]);
                    }
                    if (v3 >= 1000) {
                        w6Var.c(f5457b[(v3 / 1000) % 10]);
                    }
                    if (v3 >= 100) {
                        w6Var.c(f5457b[(v3 / 100) % 10]);
                    }
                    if (v3 % 100 == 0) {
                        return null;
                    }
                    w6Var.c((byte) 46);
                    byte[] bArr3 = f5457b;
                    w6Var.c(bArr3[(v3 / 10) % 10]);
                    if (v3 % 10 == 0) {
                        return null;
                    }
                    w6Var.c(bArr3[v3 % 10]);
                    return null;
                }
                StringBuilder res2 = new StringBuilder();
                if (negative) {
                    res2.append('-');
                }
                if (v3 >= 1000000) {
                    res2.append(f5455a[v3 / 1000000]);
                }
                if (v3 >= 100000) {
                    res2.append(f5455a[(v3 / 100000) % 10]);
                }
                if (v3 >= 10000) {
                    res2.append(f5455a[(v3 / 10000) % 10]);
                }
                if (v3 >= 1000) {
                    res2.append(f5455a[(v3 / 1000) % 10]);
                }
                if (v3 >= 100) {
                    res2.append(f5455a[(v3 / 100) % 10]);
                }
                if (v3 % 100 != 0) {
                    res2.append('.');
                    char[] cArr = f5455a;
                    res2.append(cArr[(v3 / 10) % 10]);
                    if (v3 % 10 != 0) {
                        res2.append(cArr[v3 % 10]);
                    }
                }
                return res2.toString();
            } else {
                long v4 = (long) (d2 + 0.5d);
                if (!negative) {
                    return Long.toString(v4);
                }
                return "-" + Long.toString(v4);
            }
        } else if (w6Var == null) {
            return "0";
        } else {
            w6Var.c((byte) 48);
            return null;
        }
    }

    public void Z() {
        this.f5458a = 0;
    }

    public byte[] c0() {
        int i = this.f5458a;
        byte[] newbuf = new byte[i];
        System.arraycopy(this.f5459a, 0, newbuf, 0, i);
        return newbuf;
    }

    public int b0() {
        return this.f5458a;
    }

    public void a0(int size) {
        if (size > this.f5458a || size < 0) {
            throw new IndexOutOfBoundsException(i10.b("the.new.size.must.be.positive.and.lt.eq.of.the.current.size", new Object[0]));
        }
        this.f5458a = size;
    }

    public String toString() {
        return new String(this.f5459a, 0, this.f5458a);
    }

    public void d0(OutputStream out) {
        out.write(this.f5459a, 0, this.f5458a);
    }

    public void write(int b2) {
        c((byte) b2);
    }

    public void write(byte[] b2, int off, int len) {
        P(b2, off, len);
    }
}
