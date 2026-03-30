package defpackage;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/* renamed from: ip  reason: default package */
public class ip {
    protected int a;

    /* renamed from: a  reason: collision with other field name */
    protected DataInputStream f3964a;

    /* renamed from: a  reason: collision with other field name */
    protected URL f3965a;

    /* renamed from: a  reason: collision with other field name */
    protected ArrayList<a> f3966a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    protected boolean f3967a;

    /* renamed from: a  reason: collision with other field name */
    protected byte[] f3968a = new byte[256];

    /* renamed from: a  reason: collision with other field name */
    protected short[] f3969a;
    protected int b;

    /* renamed from: b  reason: collision with other field name */
    protected boolean f3970b;

    /* renamed from: b  reason: collision with other field name */
    protected byte[] f3971b;
    protected int c;

    /* renamed from: c  reason: collision with other field name */
    protected boolean f3972c;

    /* renamed from: c  reason: collision with other field name */
    protected byte[] f3973c;
    protected int d;

    /* renamed from: d  reason: collision with other field name */
    protected boolean f3974d = false;

    /* renamed from: d  reason: collision with other field name */
    protected byte[] f3975d;
    protected int e;

    /* renamed from: e  reason: collision with other field name */
    protected byte[] f3976e;
    protected int f;

    /* renamed from: f  reason: collision with other field name */
    protected byte[] f3977f;
    protected int g;

    /* renamed from: g  reason: collision with other field name */
    protected byte[] f3978g;
    protected int h;
    protected int i;
    protected int j = 0;
    protected int k = 0;
    protected int l = 0;
    protected int m;
    protected int n;
    protected int o;
    protected int p;

    public ip(URL url) {
        this.f3965a = url;
        InputStream is = null;
        try {
            InputStream is2 = url.openStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            while (true) {
                int read = is2.read(bytes);
                int read2 = read;
                if (read != -1) {
                    baos.write(bytes, 0, read2);
                } else {
                    is2.close();
                    InputStream is3 = new ByteArrayInputStream(baos.toByteArray());
                    baos.flush();
                    baos.close();
                    d(is3);
                    is3.close();
                    return;
                }
            }
        } catch (Throwable th) {
            if (is != null) {
                is.close();
            }
            throw th;
        }
    }

    public tr b(int frame) {
        return this.f3966a.get(frame - 1).f3979a;
    }

    /* access modifiers changed from: package-private */
    public void d(InputStream is) {
        this.f3964a = new DataInputStream(new BufferedInputStream(is));
        i();
        g();
        if (this.f3966a.isEmpty()) {
            throw new IOException(i10.b("the.file.does.not.contain.any.valid.image", new Object[0]));
        }
    }

    /* access modifiers changed from: protected */
    public void i() {
        StringBuilder id = new StringBuilder("");
        for (int i2 = 0; i2 < 6; i2++) {
            id.append((char) this.f3964a.read());
        }
        if (id.toString().startsWith("GIF8")) {
            k();
            if (this.f3967a) {
                this.f3976e = f(this.o);
                return;
            }
            return;
        }
        throw new IOException(i10.b("gif.signature.nor.found", new Object[0]));
    }

    /* access modifiers changed from: protected */
    public void k() {
        this.a = l();
        this.b = l();
        int packed = this.f3964a.read();
        this.f3967a = (packed & 128) != 0;
        this.o = (packed & 7) + 1;
        this.c = this.f3964a.read();
        this.d = this.f3964a.read();
    }

    /* access modifiers changed from: protected */
    public int l() {
        return this.f3964a.read() | (this.f3964a.read() << 8);
    }

    /* access modifiers changed from: protected */
    public int e() {
        int read = this.f3964a.read();
        this.j = read;
        if (read <= 0) {
            this.j = 0;
            return 0;
        }
        int read2 = this.f3964a.read(this.f3968a, 0, read);
        this.j = read2;
        return read2;
    }

    /* access modifiers changed from: protected */
    public byte[] f(int bpc) {
        byte[] table = new byte[((1 << c(bpc)) * 3)];
        this.f3964a.readFully(table, 0, (1 << bpc) * 3);
        return table;
    }

    protected static int c(int bpc) {
        switch (bpc) {
            case 1:
            case 2:
            case 4:
                return bpc;
            case 3:
                return 4;
            default:
                return 8;
        }
    }

    /* access modifiers changed from: protected */
    public void g() {
        boolean done = false;
        while (!done) {
            switch (this.f3964a.read()) {
                case 33:
                    switch (this.f3964a.read()) {
                        case 249:
                            h();
                            break;
                        case 255:
                            e();
                            n();
                            break;
                        default:
                            n();
                            break;
                    }
                case 44:
                    j();
                    break;
                default:
                    done = true;
                    break;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void j() {
        this.f = l();
        this.g = l();
        this.h = l();
        this.i = l();
        int packed = this.f3964a.read();
        this.f3970b = (packed & 128) != 0;
        this.f3972c = (packed & 64) != 0;
        this.e = 2 << (packed & 7);
        this.n = c(this.o);
        if (this.f3970b) {
            this.f3977f = f((packed & 7) + 1);
            this.n = c((packed & 7) + 1);
        } else {
            this.f3977f = this.f3976e;
        }
        if (this.f3974d && this.m >= this.f3977f.length / 3) {
            this.f3974d = false;
        }
        if (this.f3974d && this.n == 1) {
            byte[] tp = new byte[12];
            System.arraycopy(this.f3977f, 0, tp, 0, 6);
            this.f3977f = tp;
            this.n = 2;
        }
        if (!a()) {
            n();
        }
        try {
            tr img = new xr(this.h, this.i, 1, this.n, this.f3975d);
            x50 colorspace = new x50();
            colorspace.I(h70.E5);
            colorspace.I(h70.s2);
            colorspace.I(new k70((this.f3977f.length / 3) - 1));
            colorspace.I(new n80(this.f3977f));
            j60 ad = new j60();
            ad.Q(h70.n1, colorspace);
            img.c1(ad);
            if (this.f3974d) {
                int i2 = this.m;
                img.o1(new int[]{i2, i2});
            }
            img.k1(3);
            img.j1(this.f3978g);
            img.p1(this.f3965a);
            a gf = new a();
            gf.f3979a = img;
            gf.a = this.f;
            gf.b = this.g;
            this.f3966a.add(gf);
        } catch (Exception e2) {
            throw new mj(e2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v35, resolved type: byte} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a() {
        /*
            r34 = this;
            r0 = r34
            r1 = -1
            int r2 = r0.h
            int r3 = r0.i
            int r4 = r2 * r3
            r5 = 0
            short[] r6 = r0.f3969a
            r7 = 4096(0x1000, float:5.74E-42)
            if (r6 != 0) goto L_0x0014
            short[] r6 = new short[r7]
            r0.f3969a = r6
        L_0x0014:
            byte[] r6 = r0.f3971b
            if (r6 != 0) goto L_0x001c
            byte[] r6 = new byte[r7]
            r0.f3971b = r6
        L_0x001c:
            byte[] r6 = r0.f3973c
            if (r6 != 0) goto L_0x0026
            r6 = 4097(0x1001, float:5.741E-42)
            byte[] r6 = new byte[r6]
            r0.f3973c = r6
        L_0x0026:
            int r6 = r0.n
            int r2 = r2 * r6
            int r2 = r2 + 7
            r6 = 8
            int r2 = r2 / r6
            r0.p = r2
            int r2 = r2 * r3
            byte[] r2 = new byte[r2]
            r0.f3975d = r2
            r2 = 1
            boolean r3 = r0.f3972c
            r8 = 1
            if (r3 == 0) goto L_0x003e
            goto L_0x003f
        L_0x003e:
            r6 = 1
        L_0x003f:
            r3 = r6
            r6 = 0
            r9 = 0
            java.io.DataInputStream r10 = r0.f3964a
            int r10 = r10.read()
            int r11 = r8 << r10
            int r12 = r11 + 1
            int r13 = r11 + 2
            r14 = r1
            int r15 = r10 + 1
            int r16 = r8 << r15
            int r16 = r16 + -1
            r17 = 0
            r7 = r17
        L_0x0059:
            r17 = 0
            if (r7 >= r11) goto L_0x006e
            short[] r8 = r0.f3969a
            r8[r7] = r17
            byte[] r8 = r0.f3971b
            r20 = r2
            byte r2 = (byte) r7
            r8[r7] = r2
            int r7 = r7 + 1
            r2 = r20
            r8 = 1
            goto L_0x0059
        L_0x006e:
            r20 = r2
            r2 = r17
            r8 = r17
            r21 = r17
            r22 = r17
            r23 = r17
            r24 = 0
            r31 = r21
            r21 = r2
            r2 = r31
            r32 = r23
            r23 = r5
            r5 = r32
            r33 = r24
            r24 = r7
            r7 = r33
        L_0x008e:
            if (r7 >= r4) goto L_0x01fb
            if (r8 != 0) goto L_0x0182
            if (r5 >= r15) goto L_0x00c1
            if (r22 != 0) goto L_0x00ac
            int r22 = r34.e()
            if (r22 > 0) goto L_0x00aa
            r18 = 1
            r26 = r1
            r25 = r4
            r27 = r5
            r30 = r10
            r5 = r18
            goto L_0x0207
        L_0x00aa:
            r21 = 0
        L_0x00ac:
            r25 = r4
            byte[] r4 = r0.f3968a
            byte r4 = r4[r21]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r5
            int r17 = r17 + r4
            int r5 = r5 + 8
            r4 = 1
            int r21 = r21 + 1
            int r22 = r22 + -1
            r4 = r25
            goto L_0x008e
        L_0x00c1:
            r25 = r4
            r4 = r17 & r16
            int r17 = r17 >> r15
            int r5 = r5 - r15
            if (r4 > r13) goto L_0x0170
            if (r4 != r12) goto L_0x00d8
            r26 = r1
            r29 = r2
            r28 = r4
            r27 = r5
            r30 = r10
            goto L_0x017a
        L_0x00d8:
            if (r4 != r11) goto L_0x00ea
            int r15 = r10 + 1
            r19 = 1
            int r24 = r19 << r15
            int r16 = r24 + -1
            int r13 = r11 + 2
            r14 = r1
            r24 = r4
            r4 = r25
            goto L_0x008e
        L_0x00ea:
            if (r14 != r1) goto L_0x0107
            r26 = r1
            byte[] r1 = r0.f3973c
            int r24 = r8 + 1
            r27 = r5
            byte[] r5 = r0.f3971b
            byte r5 = r5[r4]
            r1[r8] = r5
            r14 = r4
            r2 = r4
            r8 = r24
            r1 = r26
            r5 = r27
            r24 = r4
            r4 = r25
            goto L_0x008e
        L_0x0107:
            r26 = r1
            r27 = r5
            r1 = r4
            if (r4 != r13) goto L_0x011b
            byte[] r5 = r0.f3973c
            int r24 = r8 + 1
            r28 = r4
            byte r4 = (byte) r2
            r5[r8] = r4
            r4 = r14
            r8 = r24
            goto L_0x011d
        L_0x011b:
            r28 = r4
        L_0x011d:
            if (r4 <= r11) goto L_0x0134
            byte[] r5 = r0.f3973c
            int r24 = r8 + 1
            r29 = r2
            byte[] r2 = r0.f3971b
            byte r2 = r2[r4]
            r5[r8] = r2
            short[] r2 = r0.f3969a
            short r4 = r2[r4]
            r8 = r24
            r2 = r29
            goto L_0x011d
        L_0x0134:
            r29 = r2
            byte[] r2 = r0.f3971b
            byte r5 = r2[r4]
            r5 = r5 & 255(0xff, float:3.57E-43)
            r24 = r4
            r4 = 4096(0x1000, float:5.74E-42)
            if (r13 < r4) goto L_0x0149
            r2 = r5
            r30 = r10
            r5 = r23
            goto L_0x0207
        L_0x0149:
            byte[] r4 = r0.f3973c
            int r28 = r8 + 1
            r30 = r10
            byte r10 = (byte) r5
            r4[r8] = r10
            short[] r4 = r0.f3969a
            short r8 = (short) r14
            r4[r13] = r8
            byte r4 = (byte) r5
            r2[r13] = r4
            int r13 = r13 + 1
            r2 = r13 & r16
            if (r2 != 0) goto L_0x0169
            r2 = 4096(0x1000, float:5.74E-42)
            if (r13 >= r2) goto L_0x016b
            int r15 = r15 + 1
            int r16 = r16 + r13
            goto L_0x016b
        L_0x0169:
            r2 = 4096(0x1000, float:5.74E-42)
        L_0x016b:
            r4 = r1
            r14 = r4
            r8 = r28
            goto L_0x0190
        L_0x0170:
            r26 = r1
            r29 = r2
            r28 = r4
            r27 = r5
            r30 = r10
        L_0x017a:
            r5 = r23
            r24 = r28
            r2 = r29
            goto L_0x0207
        L_0x0182:
            r26 = r1
            r29 = r2
            r25 = r4
            r30 = r10
            r2 = 4096(0x1000, float:5.74E-42)
            r27 = r5
            r5 = r29
        L_0x0190:
            int r8 = r8 + -1
            int r7 = r7 + 1
            byte[] r1 = r0.f3973c
            byte r1 = r1[r8]
            r0.m(r9, r6, r1)
            int r9 = r9 + 1
            int r1 = r0.h
            if (r9 < r1) goto L_0x01ef
            r9 = 0
            int r6 = r6 + r3
            int r1 = r0.i
            if (r6 < r1) goto L_0x01e3
            boolean r4 = r0.f3972c
            if (r4 == 0) goto L_0x01d4
        L_0x01ab:
            r1 = 1
            int r20 = r20 + 1
            switch(r20) {
                case 2: goto L_0x01c2;
                case 3: goto L_0x01bd;
                case 4: goto L_0x01b8;
                default: goto L_0x01b1;
            }
        L_0x01b1:
            int r1 = r0.i
            r4 = 1
            int r1 = r1 - r4
            r3 = 0
            r6 = r1
            goto L_0x01c5
        L_0x01b8:
            r1 = 1
            r3 = 2
            r6 = r1
            r4 = 1
            goto L_0x01c5
        L_0x01bd:
            r1 = 2
            r3 = 4
            r6 = r1
            r4 = 1
            goto L_0x01c5
        L_0x01c2:
            r1 = 4
            r6 = r1
            r4 = 1
        L_0x01c5:
            int r1 = r0.i
            if (r6 >= r1) goto L_0x01ab
            r2 = r5
            r4 = r25
            r1 = r26
            r5 = r27
            r10 = r30
            goto L_0x008e
        L_0x01d4:
            r4 = 1
            int r6 = r1 + -1
            r3 = 0
            r2 = r5
            r4 = r25
            r1 = r26
            r5 = r27
            r10 = r30
            goto L_0x008e
        L_0x01e3:
            r4 = 1
            r2 = r5
            r4 = r25
            r1 = r26
            r5 = r27
            r10 = r30
            goto L_0x008e
        L_0x01ef:
            r4 = 1
            r2 = r5
            r4 = r25
            r1 = r26
            r5 = r27
            r10 = r30
            goto L_0x008e
        L_0x01fb:
            r26 = r1
            r29 = r2
            r25 = r4
            r30 = r10
            r27 = r5
            r5 = r23
        L_0x0207:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ip.a():boolean");
    }

    /* access modifiers changed from: protected */
    public void m(int x, int y, int v) {
        int i2 = this.n;
        if (i2 == 8) {
            this.f3975d[(this.h * y) + x] = (byte) v;
            return;
        }
        int pos = (this.p * y) + (x / (8 / i2));
        byte[] bArr = this.f3975d;
        bArr[pos] = (byte) (bArr[pos] | (v << ((8 - ((x % (8 / i2)) * i2)) - i2)));
    }

    /* access modifiers changed from: protected */
    public void h() {
        this.f3964a.read();
        int packed = this.f3964a.read();
        int i2 = (packed & 28) >> 2;
        this.k = i2;
        boolean z = true;
        if (i2 == 0) {
            this.k = 1;
        }
        if ((packed & 1) == 0) {
            z = false;
        }
        this.f3974d = z;
        this.l = l() * 10;
        this.m = this.f3964a.read();
        this.f3964a.read();
    }

    /* access modifiers changed from: protected */
    public void n() {
        do {
            e();
        } while (this.j > 0);
    }

    /* renamed from: ip$a */
    static class a {
        int a;

        /* renamed from: a  reason: collision with other field name */
        tr f3979a;
        int b;

        a() {
        }
    }
}
