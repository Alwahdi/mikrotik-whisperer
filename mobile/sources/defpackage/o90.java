package defpackage;

import com.itextpdf.text.pdf.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

/* renamed from: o90  reason: default package */
public class o90 {
    public static final int[] a = {137, 80, 78, 71, 13, 10, 26, 10};

    /* renamed from: a  reason: collision with other field name */
    private static final h70[] f4499a = {h70.G8, h70.J9, h70.ua, h70.e};

    /* renamed from: a  reason: collision with other field name */
    float f4500a;

    /* renamed from: a  reason: collision with other field name */
    int f4501a;

    /* renamed from: a  reason: collision with other field name */
    dr f4502a;

    /* renamed from: a  reason: collision with other field name */
    h70 f4503a;

    /* renamed from: a  reason: collision with other field name */
    j60 f4504a = new j60();

    /* renamed from: a  reason: collision with other field name */
    DataInputStream f4505a;

    /* renamed from: a  reason: collision with other field name */
    InputStream f4506a;

    /* renamed from: a  reason: collision with other field name */
    a f4507a = new a();

    /* renamed from: a  reason: collision with other field name */
    boolean f4508a;

    /* renamed from: a  reason: collision with other field name */
    byte[] f4509a;
    float b = 1.0f;

    /* renamed from: b  reason: collision with other field name */
    int f4510b;

    /* renamed from: b  reason: collision with other field name */
    boolean f4511b;

    /* renamed from: b  reason: collision with other field name */
    byte[] f4512b;
    float c;

    /* renamed from: c  reason: collision with other field name */
    int f4513c;

    /* renamed from: c  reason: collision with other field name */
    boolean f4514c = false;

    /* renamed from: c  reason: collision with other field name */
    byte[] f4515c;
    float d;

    /* renamed from: d  reason: collision with other field name */
    int f4516d;

    /* renamed from: d  reason: collision with other field name */
    byte[] f4517d;
    float e;

    /* renamed from: e  reason: collision with other field name */
    int f4518e;
    float f;

    /* renamed from: f  reason: collision with other field name */
    int f4519f;
    float g;

    /* renamed from: g  reason: collision with other field name */
    int f4520g;
    float h;

    /* renamed from: h  reason: collision with other field name */
    int f4521h;
    float i;

    /* renamed from: i  reason: collision with other field name */
    int f4522i;
    float j;

    /* renamed from: j  reason: collision with other field name */
    int f4523j = -1;
    int k = -1;
    int l = -1;
    int m;
    int n;

    o90(InputStream is) {
        this.f4506a = is;
    }

    public static tr m(URL url) {
        InputStream is = null;
        try {
            is = url.openStream();
            tr img = l(is);
            img.p1(url);
            return img;
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    public static tr l(InputStream is) {
        return new o90(is).k();
    }

    /* access modifiers changed from: package-private */
    public boolean b(String s) {
        if (s.length() != 4) {
            return false;
        }
        for (int k2 = 0; k2 < 4; k2++) {
            char c2 = s.charAt(k2);
            if ((c2 < 'a' || c2 > 'z') && (c2 < 'A' || c2 > 'Z')) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void t() {
        int i2 = 0;
        while (true) {
            int[] iArr = a;
            int i3 = 0;
            if (i2 >= iArr.length) {
                int i4 = 4096;
                byte[] buffer = new byte[4096];
                while (true) {
                    int len = n(this.f4506a);
                    String marker = p(this.f4506a);
                    if (len >= 0 && b(marker)) {
                        if ("IDAT".equals(marker)) {
                            while (len != 0) {
                                int size = this.f4506a.read(buffer, i3, Math.min(len, i4));
                                if (size >= 0) {
                                    this.f4507a.write(buffer, i3, size);
                                    len -= size;
                                } else {
                                    return;
                                }
                            }
                            continue;
                        } else if ("tRNS".equals(marker)) {
                            switch (this.f4516d) {
                                case 0:
                                    if (len >= 2) {
                                        len -= 2;
                                        int gray = q(this.f4506a);
                                        if (this.f4513c != 16) {
                                            this.f4504a.Q(h70.M6, new f70("[" + gray + " " + gray + "]"));
                                            break;
                                        } else {
                                            this.f4523j = gray;
                                            break;
                                        }
                                    }
                                    break;
                                case 2:
                                    if (len >= 6) {
                                        len -= 6;
                                        int red = q(this.f4506a);
                                        int green = q(this.f4506a);
                                        int blue = q(this.f4506a);
                                        if (this.f4513c != 16) {
                                            this.f4504a.Q(h70.M6, new f70("[" + red + " " + red + " " + green + " " + green + " " + blue + " " + blue + "]"));
                                            break;
                                        } else {
                                            this.f4523j = red;
                                            this.k = green;
                                            this.l = blue;
                                            break;
                                        }
                                    }
                                    break;
                                case 3:
                                    if (len > 0) {
                                        this.f4515c = new byte[len];
                                        for (int k2 = 0; k2 < len; k2++) {
                                            this.f4515c[k2] = (byte) this.f4506a.read();
                                        }
                                        len = 0;
                                        break;
                                    }
                                    break;
                            }
                            tu0.j(this.f4506a, len);
                        } else if ("IHDR".equals(marker)) {
                            this.f4501a = n(this.f4506a);
                            this.f4510b = n(this.f4506a);
                            this.f4513c = this.f4506a.read();
                            this.f4516d = this.f4506a.read();
                            this.f4518e = this.f4506a.read();
                            this.f4519f = this.f4506a.read();
                            this.f4520g = this.f4506a.read();
                        } else {
                            boolean z = true;
                            if ("PLTE".equals(marker)) {
                                if (this.f4516d == 3) {
                                    x50 colorspace = new x50();
                                    colorspace.I(h70.E5);
                                    colorspace.I(i());
                                    colorspace.I(new k70((len / 3) - 1));
                                    w6 colortable = new w6();
                                    while (true) {
                                        int len2 = len - 1;
                                        if (len > 0) {
                                            colortable.V(this.f4506a.read());
                                            len = len2;
                                        } else {
                                            byte[] c0 = colortable.c0();
                                            this.f4517d = c0;
                                            colorspace.I(new n80(c0));
                                            this.f4504a.Q(h70.n1, colorspace);
                                            int i5 = len2;
                                        }
                                    }
                                } else {
                                    tu0.j(this.f4506a, len);
                                }
                            } else if ("pHYs".equals(marker)) {
                                int dx = n(this.f4506a);
                                int dy = n(this.f4506a);
                                if (this.f4506a.read() == 1) {
                                    this.f4521h = (int) ((((float) dx) * 0.0254f) + 0.5f);
                                    this.f4522i = (int) ((((float) dy) * 0.0254f) + 0.5f);
                                } else if (dy != 0) {
                                    this.f4500a = ((float) dx) / ((float) dy);
                                }
                            } else if ("cHRM".equals(marker)) {
                                this.c = ((float) n(this.f4506a)) / 100000.0f;
                                this.d = ((float) n(this.f4506a)) / 100000.0f;
                                this.e = ((float) n(this.f4506a)) / 100000.0f;
                                this.f = ((float) n(this.f4506a)) / 100000.0f;
                                this.g = ((float) n(this.f4506a)) / 100000.0f;
                                this.h = ((float) n(this.f4506a)) / 100000.0f;
                                this.i = ((float) n(this.f4506a)) / 100000.0f;
                                this.j = ((float) n(this.f4506a)) / 100000.0f;
                                if (Math.abs(this.c) < 1.0E-4f || Math.abs(this.d) < 1.0E-4f || Math.abs(this.e) < 1.0E-4f || Math.abs(this.f) < 1.0E-4f || Math.abs(this.g) < 1.0E-4f || Math.abs(this.h) < 1.0E-4f || Math.abs(this.i) < 1.0E-4f || Math.abs(this.j) < 1.0E-4f) {
                                    z = false;
                                }
                                this.f4514c = z;
                            } else if ("sRGB".equals(marker)) {
                                this.f4503a = f4499a[this.f4506a.read()];
                                this.b = 2.2f;
                                this.c = 0.3127f;
                                this.d = 0.329f;
                                this.e = 0.64f;
                                this.f = 0.33f;
                                this.g = 0.3f;
                                this.h = 0.6f;
                                this.i = 0.15f;
                                this.j = 0.06f;
                                this.f4514c = true;
                            } else if ("gAMA".equals(marker)) {
                                int gm = n(this.f4506a);
                                if (gm != 0) {
                                    this.b = 100000.0f / ((float) gm);
                                    if (!this.f4514c) {
                                        this.c = 0.3127f;
                                        this.d = 0.329f;
                                        this.e = 0.64f;
                                        this.f = 0.33f;
                                        this.g = 0.3f;
                                        this.h = 0.6f;
                                        this.i = 0.15f;
                                        this.j = 0.06f;
                                        this.f4514c = true;
                                    }
                                }
                            } else if ("iCCP".equals(marker)) {
                                do {
                                    len--;
                                } while (this.f4506a.read() != 0);
                                this.f4506a.read();
                                int len3 = len - 1;
                                byte[] icccom = new byte[len3];
                                int p = 0;
                                int len4 = len3;
                                while (len4 > 0) {
                                    int r = this.f4506a.read(icccom, p, len4);
                                    if (r >= 0) {
                                        p += r;
                                        len4 -= r;
                                    } else {
                                        throw new IOException(i10.b("premature.end.of.file", new Object[0]));
                                    }
                                }
                                try {
                                    this.f4502a = dr.b(c.a(icccom, true));
                                } catch (RuntimeException e2) {
                                    this.f4502a = null;
                                }
                                int i6 = len4;
                            } else if (!"IEND".equals(marker)) {
                                tu0.j(this.f4506a, len);
                            } else {
                                return;
                            }
                        }
                        tu0.j(this.f4506a, 4);
                        i4 = 4096;
                        i3 = 0;
                    }
                }
                throw new IOException(i10.b("corrupted.png.file", new Object[0]));
            } else if (iArr[i2] == this.f4506a.read()) {
                i2++;
            } else {
                throw new IOException(i10.b("file.is.not.a.valid.png", new Object[0]));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v3, resolved type: x50} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: f70} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public defpackage.o70 i() {
        /*
            r20 = this;
            r0 = r20
            dr r1 = r0.f4502a
            if (r1 == 0) goto L_0x0012
            int r1 = r0.f4516d
            r1 = r1 & 2
            if (r1 != 0) goto L_0x000f
            h70 r1 = defpackage.h70.r2
            return r1
        L_0x000f:
            h70 r1 = defpackage.h70.s2
            return r1
        L_0x0012:
            float r1 = r0.b
            r2 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x002a
            boolean r1 = r0.f4514c
            if (r1 != 0) goto L_0x002a
            int r1 = r0.f4516d
            r1 = r1 & 2
            if (r1 != 0) goto L_0x0027
            h70 r1 = defpackage.h70.r2
            return r1
        L_0x0027:
            h70 r1 = defpackage.h70.s2
            return r1
        L_0x002a:
            x50 r1 = new x50
            r1.<init>()
            j60 r3 = new j60
            r3.<init>()
            int r4 = r0.f4516d
            r4 = r4 & 2
            java.lang.String r5 = "[1 1 1]"
            if (r4 != 0) goto L_0x0065
            float r4 = r0.b
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0045
            h70 r2 = defpackage.h70.r2
            return r2
        L_0x0045:
            h70 r2 = defpackage.h70.G0
            r1.I(r2)
            h70 r2 = defpackage.h70.y4
            k70 r4 = new k70
            float r6 = r0.b
            r4.<init>((float) r6)
            r3.Q(r2, r4)
            h70 r2 = defpackage.h70.Hd
            f70 r4 = new f70
            r4.<init>((java.lang.String) r5)
            r3.Q(r2, r4)
            r1.I(r3)
            goto L_0x019f
        L_0x0065:
            f70 r4 = new f70
            r4.<init>((java.lang.String) r5)
            h70 r5 = defpackage.h70.H0
            r1.I(r5)
            float r5 = r0.b
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x008f
            x50 r5 = new x50
            r5.<init>()
            k70 r6 = new k70
            float r7 = r0.b
            r6.<init>((float) r7)
            r5.I(r6)
            r5.I(r6)
            r5.I(r6)
            h70 r7 = defpackage.h70.y4
            r3.Q(r7, r5)
        L_0x008f:
            boolean r5 = r0.f4514c
            if (r5 == 0) goto L_0x0195
            float r5 = r0.d
            float r6 = r0.g
            float r7 = r0.i
            float r8 = r6 - r7
            float r9 = r0.f
            float r8 = r8 * r9
            float r10 = r0.e
            float r11 = r10 - r7
            float r12 = r0.h
            float r11 = r11 * r12
            float r8 = r8 - r11
            float r11 = r10 - r6
            float r13 = r0.j
            float r11 = r11 * r13
            float r8 = r8 + r11
            float r8 = r8 * r5
            float r11 = r6 - r7
            float r11 = r11 * r5
            float r14 = r0.c
            float r15 = r14 - r7
            float r15 = r15 * r12
            float r11 = r11 - r15
            float r15 = r14 - r6
            float r15 = r15 * r13
            float r11 = r11 + r15
            float r11 = r11 * r9
            float r11 = r11 / r8
            float r15 = r11 * r10
            float r15 = r15 / r9
            float r16 = r2 - r10
            float r16 = r16 / r9
            float r16 = r16 - r2
            float r2 = r11 * r16
            float r0 = -r12
            float r16 = r10 - r7
            float r16 = r16 * r5
            float r18 = r14 - r7
            float r18 = r18 * r9
            float r16 = r16 - r18
            float r9 = r14 - r10
            float r9 = r9 * r13
            float r16 = r16 + r9
            float r0 = r0 * r16
            float r0 = r0 / r8
            float r9 = r0 * r6
            float r9 = r9 / r12
            r16 = 1065353216(0x3f800000, float:1.0)
            float r17 = r16 - r6
            float r17 = r17 / r12
            float r18 = r17 - r16
            r16 = r4
            float r4 = r0 * r18
            float r18 = r10 - r6
            float r18 = r18 * r5
            float r6 = r14 - r6
            float r6 = r6 * r5
            float r18 = r18 - r6
            float r14 = r14 - r10
            float r14 = r14 * r12
            float r18 = r18 + r14
            float r18 = r18 * r13
            float r5 = r18 / r8
            float r6 = r5 * r7
            float r6 = r6 / r13
            r10 = 1065353216(0x3f800000, float:1.0)
            float r7 = r10 - r7
            float r7 = r7 / r13
            float r7 = r7 - r10
            float r7 = r7 * r5
            float r10 = r15 + r9
            float r10 = r10 + r6
            r12 = 1065353216(0x3f800000, float:1.0)
            float r13 = r2 + r4
            float r13 = r13 + r7
            x50 r14 = new x50
            r14.<init>()
            r17 = r8
            k70 r8 = new k70
            r8.<init>((float) r10)
            r14.I(r8)
            k70 r8 = new k70
            r8.<init>((float) r12)
            r14.I(r8)
            k70 r8 = new k70
            r8.<init>((float) r13)
            r14.I(r8)
            r8 = r14
            x50 r16 = new x50
            r16.<init>()
            r18 = r16
            r16 = r8
            k70 r8 = new k70
            r8.<init>((float) r15)
            r19 = r10
            r10 = r18
            r10.I(r8)
            k70 r8 = new k70
            r8.<init>((float) r11)
            r10.I(r8)
            k70 r8 = new k70
            r8.<init>((float) r2)
            r10.I(r8)
            k70 r8 = new k70
            r8.<init>((float) r9)
            r10.I(r8)
            k70 r8 = new k70
            r8.<init>((float) r0)
            r10.I(r8)
            k70 r8 = new k70
            r8.<init>((float) r4)
            r10.I(r8)
            k70 r8 = new k70
            r8.<init>((float) r6)
            r10.I(r8)
            k70 r8 = new k70
            r8.<init>((float) r5)
            r10.I(r8)
            k70 r8 = new k70
            r8.<init>((float) r7)
            r10.I(r8)
            h70 r8 = defpackage.h70.H6
            r3.Q(r8, r10)
            r4 = r16
            goto L_0x0197
        L_0x0195:
            r16 = r4
        L_0x0197:
            h70 r0 = defpackage.h70.Hd
            r3.Q(r0, r4)
            r1.I(r3)
        L_0x019f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.o90.i():o70");
    }

    /* JADX WARNING: type inference failed for: r5v5, types: [tr] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public defpackage.tr k() {
        /*
            r15 = this;
            r15.t()
            r15.a()
            r0 = 0
            r1 = 0
            r2 = 0
            r15.f4511b = r2     // Catch:{ Exception -> 0x0199 }
            byte[] r3 = r15.f4515c     // Catch:{ Exception -> 0x0199 }
            r4 = 1
            if (r3 == 0) goto L_0x002a
            r3 = 0
        L_0x0011:
            byte[] r5 = r15.f4515c     // Catch:{ Exception -> 0x0199 }
            int r6 = r5.length     // Catch:{ Exception -> 0x0199 }
            if (r3 >= r6) goto L_0x002a
            byte r5 = r5[r3]     // Catch:{ Exception -> 0x0199 }
            r6 = 255(0xff, float:3.57E-43)
            r5 = r5 & r6
            if (r5 != 0) goto L_0x0020
            int r0 = r0 + 1
            r1 = r3
        L_0x0020:
            if (r5 == 0) goto L_0x0027
            if (r5 == r6) goto L_0x0027
            r15.f4511b = r4     // Catch:{ Exception -> 0x0199 }
            goto L_0x002a
        L_0x0027:
            int r3 = r3 + 1
            goto L_0x0011
        L_0x002a:
            int r3 = r15.f4516d     // Catch:{ Exception -> 0x0199 }
            r5 = 4
            r3 = r3 & r5
            if (r3 == 0) goto L_0x0032
            r15.f4511b = r4     // Catch:{ Exception -> 0x0199 }
        L_0x0032:
            boolean r3 = r15.f4511b     // Catch:{ Exception -> 0x0199 }
            if (r3 != 0) goto L_0x003e
            if (r0 > r4) goto L_0x003c
            int r6 = r15.f4523j     // Catch:{ Exception -> 0x0199 }
            if (r6 < 0) goto L_0x003e
        L_0x003c:
            r6 = 1
            goto L_0x003f
        L_0x003e:
            r6 = 0
        L_0x003f:
            r15.f4508a = r6     // Catch:{ Exception -> 0x0199 }
            if (r3 != 0) goto L_0x0071
            if (r6 != 0) goto L_0x0071
            if (r0 != r4) goto L_0x0071
            j60 r3 = r15.f4504a     // Catch:{ Exception -> 0x0199 }
            h70 r6 = defpackage.h70.M6     // Catch:{ Exception -> 0x0199 }
            f70 r7 = new f70     // Catch:{ Exception -> 0x0199 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0199 }
            r8.<init>()     // Catch:{ Exception -> 0x0199 }
            java.lang.String r9 = "["
            r8.append(r9)     // Catch:{ Exception -> 0x0199 }
            r8.append(r1)     // Catch:{ Exception -> 0x0199 }
            java.lang.String r9 = " "
            r8.append(r9)     // Catch:{ Exception -> 0x0199 }
            r8.append(r1)     // Catch:{ Exception -> 0x0199 }
            java.lang.String r9 = "]"
            r8.append(r9)     // Catch:{ Exception -> 0x0199 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0199 }
            r7.<init>((java.lang.String) r8)     // Catch:{ Exception -> 0x0199 }
            r3.Q(r6, r7)     // Catch:{ Exception -> 0x0199 }
        L_0x0071:
            int r3 = r15.f4520g     // Catch:{ Exception -> 0x0199 }
            r6 = 16
            if (r3 == r4) goto L_0x0088
            int r3 = r15.f4513c     // Catch:{ Exception -> 0x0199 }
            if (r3 == r6) goto L_0x0088
            int r3 = r15.f4516d     // Catch:{ Exception -> 0x0199 }
            r3 = r3 & r5
            if (r3 != 0) goto L_0x0088
            boolean r3 = r15.f4511b     // Catch:{ Exception -> 0x0199 }
            if (r3 != 0) goto L_0x0088
            boolean r3 = r15.f4508a     // Catch:{ Exception -> 0x0199 }
            if (r3 == 0) goto L_0x0089
        L_0x0088:
            r2 = 1
        L_0x0089:
            int r3 = r15.f4516d     // Catch:{ Exception -> 0x0199 }
            r7 = 2
            r8 = 3
            switch(r3) {
                case 0: goto L_0x009d;
                case 1: goto L_0x0090;
                case 2: goto L_0x009a;
                case 3: goto L_0x0097;
                case 4: goto L_0x0094;
                case 5: goto L_0x0090;
                case 6: goto L_0x0091;
                default: goto L_0x0090;
            }     // Catch:{ Exception -> 0x0199 }
        L_0x0090:
            goto L_0x00a0
        L_0x0091:
            r15.m = r5     // Catch:{ Exception -> 0x0199 }
            goto L_0x00a0
        L_0x0094:
            r15.m = r7     // Catch:{ Exception -> 0x0199 }
            goto L_0x00a0
        L_0x0097:
            r15.m = r4     // Catch:{ Exception -> 0x0199 }
            goto L_0x00a0
        L_0x009a:
            r15.m = r8     // Catch:{ Exception -> 0x0199 }
            goto L_0x00a0
        L_0x009d:
            r15.m = r4     // Catch:{ Exception -> 0x0199 }
        L_0x00a0:
            if (r2 == 0) goto L_0x00a5
            r15.d()     // Catch:{ Exception -> 0x0199 }
        L_0x00a5:
            int r3 = r15.m     // Catch:{ Exception -> 0x0199 }
            int r5 = r15.f4516d     // Catch:{ Exception -> 0x0199 }
            r9 = r5 & 4
            if (r9 == 0) goto L_0x00af
            int r3 = r3 + -1
        L_0x00af:
            int r9 = r15.f4513c     // Catch:{ Exception -> 0x0199 }
            if (r9 != r6) goto L_0x00b7
            r9 = 8
            r6 = r9
            goto L_0x00b8
        L_0x00b7:
            r6 = r9
        L_0x00b8:
            byte[] r9 = r15.f4509a     // Catch:{ Exception -> 0x0199 }
            if (r9 == 0) goto L_0x00d6
            if (r5 != r8) goto L_0x00cd
            xr r5 = new xr     // Catch:{ Exception -> 0x0199 }
            int r10 = r15.f4501a     // Catch:{ Exception -> 0x0199 }
            int r11 = r15.f4510b     // Catch:{ Exception -> 0x0199 }
            byte[] r14 = r15.f4509a     // Catch:{ Exception -> 0x0199 }
            r9 = r5
            r12 = r3
            r13 = r6
            r9.<init>(r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0199 }
            goto L_0x012d
        L_0x00cd:
            int r5 = r15.f4501a     // Catch:{ Exception -> 0x0199 }
            int r8 = r15.f4510b     // Catch:{ Exception -> 0x0199 }
            tr r5 = defpackage.tr.o0(r5, r8, r3, r6, r9)     // Catch:{ Exception -> 0x0199 }
            goto L_0x012d
        L_0x00d6:
            xr r5 = new xr     // Catch:{ Exception -> 0x0199 }
            int r10 = r15.f4501a     // Catch:{ Exception -> 0x0199 }
            int r11 = r15.f4510b     // Catch:{ Exception -> 0x0199 }
            o90$a r9 = r15.f4507a     // Catch:{ Exception -> 0x0199 }
            byte[] r14 = r9.toByteArray()     // Catch:{ Exception -> 0x0199 }
            r9 = r5
            r12 = r3
            r13 = r6
            r9.<init>(r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0199 }
            r5.e1(r4)     // Catch:{ Exception -> 0x0199 }
            j60 r9 = new j60     // Catch:{ Exception -> 0x0199 }
            r9.<init>()     // Catch:{ Exception -> 0x0199 }
            h70 r10 = defpackage.h70.l0     // Catch:{ Exception -> 0x0199 }
            k70 r11 = new k70     // Catch:{ Exception -> 0x0199 }
            int r12 = r15.f4513c     // Catch:{ Exception -> 0x0199 }
            r11.<init>((int) r12)     // Catch:{ Exception -> 0x0199 }
            r9.Q(r10, r11)     // Catch:{ Exception -> 0x0199 }
            h70 r10 = defpackage.h70.S8     // Catch:{ Exception -> 0x0199 }
            k70 r11 = new k70     // Catch:{ Exception -> 0x0199 }
            r12 = 15
            r11.<init>((int) r12)     // Catch:{ Exception -> 0x0199 }
            r9.Q(r10, r11)     // Catch:{ Exception -> 0x0199 }
            h70 r10 = defpackage.h70.x1     // Catch:{ Exception -> 0x0199 }
            k70 r11 = new k70     // Catch:{ Exception -> 0x0199 }
            int r12 = r15.f4501a     // Catch:{ Exception -> 0x0199 }
            r11.<init>((int) r12)     // Catch:{ Exception -> 0x0199 }
            r9.Q(r10, r11)     // Catch:{ Exception -> 0x0199 }
            h70 r10 = defpackage.h70.m1     // Catch:{ Exception -> 0x0199 }
            k70 r11 = new k70     // Catch:{ Exception -> 0x0199 }
            int r12 = r15.f4516d     // Catch:{ Exception -> 0x0199 }
            if (r12 == r8) goto L_0x011f
            r12 = r12 & r7
            if (r12 != 0) goto L_0x0120
        L_0x011f:
            r8 = 1
        L_0x0120:
            r11.<init>((int) r8)     // Catch:{ Exception -> 0x0199 }
            r9.Q(r10, r11)     // Catch:{ Exception -> 0x0199 }
            j60 r8 = r15.f4504a     // Catch:{ Exception -> 0x0199 }
            h70 r10 = defpackage.h70.f2     // Catch:{ Exception -> 0x0199 }
            r8.Q(r10, r9)     // Catch:{ Exception -> 0x0199 }
        L_0x012d:
            j60 r8 = r15.f4504a     // Catch:{ Exception -> 0x0199 }
            h70 r9 = defpackage.h70.n1     // Catch:{ Exception -> 0x0199 }
            o70 r8 = r8.I(r9)     // Catch:{ Exception -> 0x0199 }
            if (r8 != 0) goto L_0x0140
            j60 r8 = r15.f4504a     // Catch:{ Exception -> 0x0199 }
            o70 r10 = r15.i()     // Catch:{ Exception -> 0x0199 }
            r8.Q(r9, r10)     // Catch:{ Exception -> 0x0199 }
        L_0x0140:
            h70 r8 = r15.f4503a     // Catch:{ Exception -> 0x0199 }
            if (r8 == 0) goto L_0x014b
            j60 r9 = r15.f4504a     // Catch:{ Exception -> 0x0199 }
            h70 r10 = defpackage.h70.K5     // Catch:{ Exception -> 0x0199 }
            r9.Q(r10, r8)     // Catch:{ Exception -> 0x0199 }
        L_0x014b:
            j60 r8 = r15.f4504a     // Catch:{ Exception -> 0x0199 }
            int r8 = r8.size()     // Catch:{ Exception -> 0x0199 }
            if (r8 <= 0) goto L_0x0158
            j60 r8 = r15.f4504a     // Catch:{ Exception -> 0x0199 }
            r5.c1(r8)     // Catch:{ Exception -> 0x0199 }
        L_0x0158:
            dr r8 = r15.f4502a     // Catch:{ Exception -> 0x0199 }
            if (r8 == 0) goto L_0x015f
            r5.s1(r8)     // Catch:{ Exception -> 0x0199 }
        L_0x015f:
            boolean r8 = r15.f4511b     // Catch:{ Exception -> 0x0199 }
            if (r8 == 0) goto L_0x0175
            int r8 = r15.f4501a     // Catch:{ Exception -> 0x0199 }
            int r9 = r15.f4510b     // Catch:{ Exception -> 0x0199 }
            r10 = 8
            byte[] r11 = r15.f4512b     // Catch:{ Exception -> 0x0199 }
            tr r8 = defpackage.tr.o0(r8, r9, r4, r10, r11)     // Catch:{ Exception -> 0x0199 }
            r8.V0()     // Catch:{ Exception -> 0x0199 }
            r5.g1(r8)     // Catch:{ Exception -> 0x0199 }
        L_0x0175:
            boolean r8 = r15.f4508a     // Catch:{ Exception -> 0x0199 }
            if (r8 == 0) goto L_0x0189
            int r8 = r15.f4501a     // Catch:{ Exception -> 0x0199 }
            int r9 = r15.f4510b     // Catch:{ Exception -> 0x0199 }
            byte[] r10 = r15.f4512b     // Catch:{ Exception -> 0x0199 }
            tr r4 = defpackage.tr.o0(r8, r9, r4, r4, r10)     // Catch:{ Exception -> 0x0199 }
            r4.V0()     // Catch:{ Exception -> 0x0199 }
            r5.g1(r4)     // Catch:{ Exception -> 0x0199 }
        L_0x0189:
            int r4 = r15.f4521h     // Catch:{ Exception -> 0x0199 }
            int r8 = r15.f4522i     // Catch:{ Exception -> 0x0199 }
            r5.f1(r4, r8)     // Catch:{ Exception -> 0x0199 }
            float r4 = r15.f4500a     // Catch:{ Exception -> 0x0199 }
            r5.r1(r4)     // Catch:{ Exception -> 0x0199 }
            r5.k1(r7)     // Catch:{ Exception -> 0x0199 }
            return r5
        L_0x0199:
            r0 = move-exception
            mj r1 = new mj
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.o90.k():tr");
    }

    /* access modifiers changed from: package-private */
    public void d() {
        int nbitDepth;
        int size;
        int nbitDepth2 = this.f4513c;
        if (nbitDepth2 == 16) {
            nbitDepth = 8;
        } else {
            nbitDepth = nbitDepth2;
        }
        int size2 = -1;
        int i2 = this.f4513c == 16 ? 2 : 1;
        this.n = i2;
        switch (this.f4516d) {
            case 0:
                size = (((this.f4501a * nbitDepth) + 7) / 8) * this.f4510b;
                break;
            case 2:
                this.n = i2 * 3;
                size = this.f4501a * 3 * this.f4510b;
                break;
            case 3:
                if (this.f4520g == 1) {
                    size2 = (((this.f4501a * nbitDepth) + 7) / 8) * this.f4510b;
                }
                this.n = 1;
                size = size2;
                break;
            case 4:
                this.n = i2 * 2;
                size = this.f4501a * this.f4510b;
                break;
            case 6:
                this.n = i2 * 4;
                size = this.f4501a * 3 * this.f4510b;
                break;
            default:
                size = -1;
                break;
        }
        if (size >= 0) {
            this.f4509a = new byte[size];
        }
        if (this.f4511b) {
            this.f4512b = new byte[(this.f4501a * this.f4510b)];
        } else if (this.f4508a) {
            this.f4512b = new byte[(((this.f4501a + 7) / 8) * this.f4510b)];
        }
        this.f4505a = new DataInputStream(new InflaterInputStream(new ByteArrayInputStream(this.f4507a.c(), 0, this.f4507a.size()), new Inflater()));
        if (this.f4520g != 1) {
            f(0, 0, 1, 1, this.f4501a, this.f4510b);
        } else {
            f(0, 0, 8, 8, (this.f4501a + 7) / 8, (this.f4510b + 7) / 8);
            f(4, 0, 8, 8, (this.f4501a + 3) / 8, (this.f4510b + 7) / 8);
            f(0, 4, 4, 8, (this.f4501a + 3) / 4, (this.f4510b + 3) / 8);
            f(2, 0, 4, 4, (this.f4501a + 1) / 4, (this.f4510b + 3) / 4);
            f(0, 2, 2, 4, (this.f4501a + 1) / 2, (this.f4510b + 1) / 4);
            f(1, 0, 2, 2, this.f4501a / 2, (this.f4510b + 1) / 2);
            f(0, 1, 1, 2, this.f4501a, this.f4510b / 2);
        }
        try {
            this.f4505a.close();
        } catch (IOException e2) {
            wy.a(getClass()).b("Datastream of PngImage#decodeIdat didn't close properly.");
        }
    }

    /* access modifiers changed from: package-private */
    public void f(int xOffset, int yOffset, int xStep, int yStep, int passWidth, int passHeight) {
        int filter;
        int i2 = passHeight;
        if (passWidth != 0 && i2 != 0) {
            int bytesPerRow = (((this.m * passWidth) * this.f4513c) + 7) / 8;
            byte[] curr = new byte[bytesPerRow];
            byte[] prior = new byte[bytesPerRow];
            int srcY = 0;
            int dstY = yOffset;
            while (srcY < i2) {
                int filter2 = 0;
                try {
                    filter2 = this.f4505a.read();
                    this.f4505a.readFully(curr, 0, bytesPerRow);
                    filter = filter2;
                } catch (Exception e2) {
                    filter = filter2;
                }
                switch (filter) {
                    case 0:
                        break;
                    case 1:
                        g(curr, bytesPerRow, this.n);
                        break;
                    case 2:
                        h(curr, prior, bytesPerRow);
                        break;
                    case 3:
                        c(curr, prior, bytesPerRow, this.n);
                        break;
                    case 4:
                        e(curr, prior, bytesPerRow, this.n);
                        break;
                    default:
                        throw new RuntimeException(i10.b("png.filter.unknown", new Object[0]));
                }
                s(curr, xOffset, xStep, dstY, passWidth);
                byte[] tmp = prior;
                prior = curr;
                curr = tmp;
                srcY++;
                dstY += yStep;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r2v19, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r2v22, types: [byte] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void s(byte[] r24, int r25, int r26, int r27, int r28) {
        /*
            r23 = this;
            r0 = r23
            r1 = r28
            int[] r10 = r23.o(r24)
            r2 = 0
            int r3 = r0.f4516d
            switch(r3) {
                case 0: goto L_0x0013;
                case 1: goto L_0x000e;
                case 2: goto L_0x0010;
                case 3: goto L_0x0013;
                case 4: goto L_0x0013;
                case 5: goto L_0x000e;
                case 6: goto L_0x0010;
                default: goto L_0x000e;
            }
        L_0x000e:
            r11 = r2
            goto L_0x0015
        L_0x0010:
            r2 = 3
            r11 = r2
            goto L_0x0015
        L_0x0013:
            r2 = 1
            r11 = r2
        L_0x0015:
            byte[] r2 = r0.f4509a
            r12 = 16
            r13 = 8
            r14 = 0
            if (r2 == 0) goto L_0x0052
            r2 = r25
            int r3 = r0.f4501a
            int r3 = r3 * r11
            int r4 = r0.f4513c
            if (r4 != r12) goto L_0x002a
            r4 = 8
        L_0x002a:
            int r3 = r3 * r4
            int r3 = r3 + 7
            int r15 = r3 / 8
            r3 = 0
            r16 = r2
            r9 = r3
        L_0x0034:
            if (r9 >= r1) goto L_0x004f
            byte[] r2 = r0.f4509a
            int r3 = r0.m
            int r4 = r3 * r9
            int r8 = r0.f4513c
            r3 = r10
            r5 = r11
            r6 = r16
            r7 = r27
            r17 = r9
            r9 = r15
            u(r2, r3, r4, r5, r6, r7, r8, r9)
            int r16 = r16 + r26
            int r9 = r17 + 1
            goto L_0x0034
        L_0x004f:
            r17 = r9
            goto L_0x0055
        L_0x0052:
            r9 = 0
            r16 = 0
        L_0x0055:
            boolean r2 = r0.f4511b
            r3 = 1
            if (r2 == 0) goto L_0x00d2
            int r2 = r0.f4516d
            r2 = r2 & 4
            if (r2 == 0) goto L_0x0097
            int r2 = r0.f4513c
            if (r2 != r12) goto L_0x0074
            r2 = 0
        L_0x0065:
            if (r2 >= r1) goto L_0x0074
            int r3 = r0.m
            int r3 = r3 * r2
            int r3 = r3 + r11
            r4 = r10[r3]
            int r4 = r4 >>> r13
            r10[r3] = r4
            int r2 = r2 + 1
            goto L_0x0065
        L_0x0074:
            int r12 = r0.f4501a
            r2 = r25
            r3 = 0
            r13 = r2
            r14 = r3
        L_0x007b:
            if (r14 >= r1) goto L_0x0095
            byte[] r2 = r0.f4512b
            int r3 = r0.m
            int r3 = r3 * r14
            int r4 = r3 + r11
            r5 = 1
            r8 = 8
            r3 = r10
            r6 = r13
            r7 = r27
            r9 = r12
            u(r2, r3, r4, r5, r6, r7, r8, r9)
            int r13 = r13 + r26
            int r14 = r14 + 1
            goto L_0x007b
        L_0x0095:
            goto L_0x0199
        L_0x0097:
            int r12 = r0.f4501a
            int[] r13 = new int[r3]
            r2 = r25
            r3 = 0
            r15 = r2
            r9 = r3
        L_0x00a0:
            if (r9 >= r1) goto L_0x00cb
            r8 = r10[r9]
            byte[] r2 = r0.f4515c
            int r3 = r2.length
            if (r8 >= r3) goto L_0x00ae
            byte r2 = r2[r8]
            r13[r14] = r2
            goto L_0x00b2
        L_0x00ae:
            r2 = 255(0xff, float:3.57E-43)
            r13[r14] = r2
        L_0x00b2:
            byte[] r2 = r0.f4512b
            r4 = 0
            r5 = 1
            r16 = 8
            r3 = r13
            r6 = r15
            r7 = r27
            r17 = r8
            r8 = r16
            r16 = r9
            r9 = r12
            u(r2, r3, r4, r5, r6, r7, r8, r9)
            int r15 = r15 + r26
            int r9 = r16 + 1
            goto L_0x00a0
        L_0x00cb:
            r16 = r9
            r13 = r15
            r14 = r16
            goto L_0x0199
        L_0x00d2:
            boolean r2 = r0.f4508a
            if (r2 == 0) goto L_0x0196
            int r2 = r0.f4516d
            switch(r2) {
                case 0: goto L_0x0161;
                case 1: goto L_0x00db;
                case 2: goto L_0x0118;
                case 3: goto L_0x00e0;
                default: goto L_0x00db;
            }
        L_0x00db:
            r14 = r9
            r13 = r16
            goto L_0x0199
        L_0x00e0:
            int r2 = r0.f4501a
            int r2 = r2 + 7
            int r2 = r2 / r13
            int[] r4 = new int[r3]
            r5 = r25
            r6 = 0
            r13 = r5
        L_0x00eb:
            if (r6 >= r1) goto L_0x0115
            r5 = r10[r6]
            byte[] r7 = r0.f4515c
            int r8 = r7.length
            if (r5 >= r8) goto L_0x00fa
            byte r7 = r7[r5]
            if (r7 != 0) goto L_0x00fa
            r7 = 1
            goto L_0x00fb
        L_0x00fa:
            r7 = 0
        L_0x00fb:
            r4[r14] = r7
            byte[] r15 = r0.f4512b
            r17 = 0
            r18 = 1
            r21 = 1
            r16 = r4
            r19 = r13
            r20 = r27
            r22 = r2
            u(r15, r16, r17, r18, r19, r20, r21, r22)
            int r13 = r13 + r26
            int r6 = r6 + 1
            goto L_0x00eb
        L_0x0115:
            r14 = r6
            goto L_0x0199
        L_0x0118:
            r2 = r9
            r4 = r16
            int r5 = r0.f4501a
            int r5 = r5 + 7
            int r5 = r5 / r13
            int[] r6 = new int[r3]
            r4 = r25
            r2 = 0
            r13 = r4
        L_0x0126:
            if (r2 >= r1) goto L_0x015f
            int r4 = r0.m
            int r4 = r4 * r2
            r7 = r10[r4]
            int r8 = r0.f4523j
            if (r7 != r8) goto L_0x0144
            int r7 = r4 + 1
            r7 = r10[r7]
            int r8 = r0.k
            if (r7 != r8) goto L_0x0144
            int r7 = r4 + 2
            r7 = r10[r7]
            int r8 = r0.l
            if (r7 != r8) goto L_0x0144
            r7 = 1
            goto L_0x0145
        L_0x0144:
            r7 = 0
        L_0x0145:
            r6[r14] = r7
            byte[] r15 = r0.f4512b
            r17 = 0
            r18 = 1
            r21 = 1
            r16 = r6
            r19 = r13
            r20 = r27
            r22 = r5
            u(r15, r16, r17, r18, r19, r20, r21, r22)
            int r13 = r13 + r26
            int r2 = r2 + 1
            goto L_0x0126
        L_0x015f:
            r14 = r2
            goto L_0x0199
        L_0x0161:
            r2 = r9
            r4 = r16
            int r5 = r0.f4501a
            int r5 = r5 + 7
            int r5 = r5 / r13
            int[] r6 = new int[r3]
            r4 = r25
            r2 = 0
            r13 = r4
        L_0x016f:
            if (r2 >= r1) goto L_0x0194
            r4 = r10[r2]
            int r7 = r0.f4523j
            if (r4 != r7) goto L_0x0179
            r7 = 1
            goto L_0x017a
        L_0x0179:
            r7 = 0
        L_0x017a:
            r6[r14] = r7
            byte[] r15 = r0.f4512b
            r17 = 0
            r18 = 1
            r21 = 1
            r16 = r6
            r19 = r13
            r20 = r27
            r22 = r5
            u(r15, r16, r17, r18, r19, r20, r21, r22)
            int r13 = r13 + r26
            int r2 = r2 + 1
            goto L_0x016f
        L_0x0194:
            r14 = r2
            goto L_0x0199
        L_0x0196:
            r14 = r9
            r13 = r16
        L_0x0199:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.o90.s(byte[], int, int, int, int):void");
    }

    static void u(byte[] image, int[] data, int offset, int size, int x, int y, int bitDepth, int bytesPerRow) {
        if (bitDepth == 8) {
            int pos = (bytesPerRow * y) + (size * x);
            for (int k2 = 0; k2 < size; k2++) {
                image[pos + k2] = (byte) data[k2 + offset];
            }
        } else if (bitDepth == 16) {
            int pos2 = (bytesPerRow * y) + (size * x);
            for (int k3 = 0; k3 < size; k3++) {
                image[pos2 + k3] = (byte) (data[k3 + offset] >>> 8);
            }
        } else {
            int pos3 = (bytesPerRow * y) + (x / (8 / bitDepth));
            image[pos3] = (byte) (image[pos3] | (data[offset] << ((8 - ((x % (8 / bitDepth)) * bitDepth)) - bitDepth)));
        }
    }

    /* access modifiers changed from: package-private */
    public int[] o(byte[] curr) {
        int i2 = this.f4513c;
        switch (i2) {
            case 8:
                int[] out = new int[curr.length];
                for (int k2 = 0; k2 < out.length; k2++) {
                    out[k2] = curr[k2] & 255;
                }
                return out;
            case 16:
                int[] out2 = new int[(curr.length / 2)];
                for (int k3 = 0; k3 < out2.length; k3++) {
                    out2[k3] = ((curr[k3 * 2] & 255) << 8) + (curr[(k3 * 2) + 1] & 255);
                }
                return out2;
            default:
                int[] out3 = new int[((curr.length * 8) / i2)];
                int idx = 0;
                int passes = 8 / i2;
                int mask = (1 << i2) - 1;
                for (int k4 = 0; k4 < curr.length; k4++) {
                    int j2 = passes - 1;
                    while (j2 >= 0) {
                        out3[idx] = (curr[k4] >>> (this.f4513c * j2)) & mask;
                        j2--;
                        idx++;
                    }
                }
                return out3;
        }
    }

    private int j() {
        int i2 = this.f4516d;
        if (i2 == 0 || i2 == 4) {
            return 1;
        }
        return 3;
    }

    private void a() {
        dr drVar = this.f4502a;
        if (drVar != null && drVar.d() != j()) {
            wy.a(getClass()).b(i10.b("unexpected.color.space.in.embedded.icc.profile", new Object[0]));
            this.f4502a = null;
        }
    }

    private static void g(byte[] curr, int count, int bpp) {
        for (int i2 = bpp; i2 < count; i2++) {
            curr[i2] = (byte) ((curr[i2] & 255) + (curr[i2 - bpp] & 255));
        }
    }

    private static void h(byte[] curr, byte[] prev, int count) {
        for (int i2 = 0; i2 < count; i2++) {
            curr[i2] = (byte) ((curr[i2] & 255) + (prev[i2] & 255));
        }
    }

    private static void c(byte[] curr, byte[] prev, int count, int bpp) {
        for (int i2 = 0; i2 < bpp; i2++) {
            curr[i2] = (byte) (((prev[i2] & 255) / 2) + (curr[i2] & 255));
        }
        for (int i3 = bpp; i3 < count; i3++) {
            curr[i3] = (byte) ((((curr[i3 - bpp] & 255) + (prev[i3] & 255)) / 2) + (curr[i3] & 255));
        }
    }

    private static int r(int a2, int b2, int c2) {
        int p = (a2 + b2) - c2;
        int pa = Math.abs(p - a2);
        int pb = Math.abs(p - b2);
        int pc = Math.abs(p - c2);
        if (pa <= pb && pa <= pc) {
            return a2;
        }
        if (pb <= pc) {
            return b2;
        }
        return c2;
    }

    private static void e(byte[] curr, byte[] prev, int count, int bpp) {
        for (int i2 = 0; i2 < bpp; i2++) {
            curr[i2] = (byte) ((curr[i2] & 255) + (prev[i2] & 255));
        }
        for (int i3 = bpp; i3 < count; i3++) {
            curr[i3] = (byte) (r(curr[i3 - bpp] & 255, prev[i3] & 255, prev[i3 - bpp] & 255) + (curr[i3] & 255));
        }
    }

    /* renamed from: o90$a */
    static class a extends ByteArrayOutputStream {
        a() {
        }

        public byte[] c() {
            return this.buf;
        }
    }

    public static final int n(InputStream is) {
        return (is.read() << 24) + (is.read() << 16) + (is.read() << 8) + is.read();
    }

    public static final int q(InputStream is) {
        return (is.read() << 8) + is.read();
    }

    public static final String p(InputStream is) {
        StringBuffer buf = new StringBuffer();
        for (int i2 = 0; i2 < 4; i2++) {
            buf.append((char) is.read());
        }
        return buf.toString();
    }
}
