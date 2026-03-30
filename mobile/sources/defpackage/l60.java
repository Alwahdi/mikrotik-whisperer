package defpackage;

import com.itextpdf.text.AccessibleElementId;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfStructureElement;
import defpackage.nq0;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

/* renamed from: l60  reason: default package */
public class l60 extends gh {
    protected static final DecimalFormat a = new DecimalFormat("0000000000000000");

    /* renamed from: a  reason: collision with other field name */
    protected d60 f4200a;

    /* renamed from: a  reason: collision with other field name */
    protected e50 f4201a;

    /* renamed from: a  reason: collision with other field name */
    protected e70 f4202a = null;

    /* renamed from: a  reason: collision with other field name */
    protected gp0 f4203a;

    /* renamed from: a  reason: collision with other field name */
    protected j60 f4204a;

    /* renamed from: a  reason: collision with other field name */
    private Stack<Float> f4205a = new Stack<>();

    /* renamed from: a  reason: collision with other field name */
    protected TreeMap<String, a> f4206a = new TreeMap<>();

    /* renamed from: a  reason: collision with other field name */
    protected b f4207a = new b();

    /* renamed from: a  reason: collision with other field name */
    protected d f4208a = new d();

    /* renamed from: a  reason: collision with other field name */
    protected n80 f4209a;

    /* renamed from: a  reason: collision with other field name */
    private nq0 f4210a;

    /* renamed from: a  reason: collision with other field name */
    protected p70 f4211a;

    /* renamed from: a  reason: collision with other field name */
    protected tr f4212a = null;

    /* renamed from: a  reason: collision with other field name */
    protected u50 f4213a = null;

    /* renamed from: a  reason: collision with other field name */
    protected u80 f4214a = new u80();

    /* renamed from: a  reason: collision with other field name */
    protected v80 f4215a;

    /* renamed from: a  reason: collision with other field name */
    w50 f4216a;
    protected d60 b;

    /* renamed from: b  reason: collision with other field name */
    protected j60 f4217b = null;

    /* renamed from: b  reason: collision with other field name */
    protected ArrayList<e70> f4218b = new ArrayList<>();

    /* renamed from: b  reason: collision with other field name */
    private HashMap<g0, o80> f4219b = new HashMap<>();

    /* renamed from: b  reason: collision with other field name */
    protected p70 f4220b;

    /* renamed from: b  reason: collision with other field name */
    protected pd0 f4221b = null;

    /* renamed from: b  reason: collision with other field name */
    protected u50 f4222b;
    protected int c = 0;

    /* renamed from: c  reason: collision with other field name */
    private ArrayList<bi> f4223c = new ArrayList<>();

    /* renamed from: c  reason: collision with other field name */
    private HashMap<g0, nq0.a> f4224c = new HashMap<>();
    protected int d;

    /* renamed from: d  reason: collision with other field name */
    protected String f4225d;

    /* renamed from: d  reason: collision with other field name */
    private HashMap<g0, g0> f4226d = new HashMap<>();
    protected int e = -1;

    /* renamed from: e  reason: collision with other field name */
    protected HashMap<Object, int[]> f4227e = new HashMap<>();
    protected float f = 0.0f;

    /* renamed from: f  reason: collision with other field name */
    protected HashMap<Object, Integer> f4228f = new HashMap<>();
    protected float g = 0.0f;

    /* renamed from: g  reason: collision with other field name */
    protected HashMap<String, o70> f4229g = new HashMap<>();

    /* renamed from: g  reason: collision with other field name */
    private boolean f4230g = false;
    protected float h;

    /* renamed from: h  reason: collision with other field name */
    protected HashMap<String, o70> f4231h = new HashMap<>();

    /* renamed from: h  reason: collision with other field name */
    protected boolean f4232h = false;
    protected float i;

    /* renamed from: i  reason: collision with other field name */
    protected HashMap<String, f80> f4233i = new HashMap<>();

    /* renamed from: i  reason: collision with other field name */
    protected boolean f4234i = false;
    protected float j;

    /* renamed from: j  reason: collision with other field name */
    protected HashMap<String, f80> f4235j = new HashMap<>();

    /* renamed from: j  reason: collision with other field name */
    protected boolean f4236j = true;
    protected float k;

    /* renamed from: k  reason: collision with other field name */
    private boolean f4237k = true;
    protected float l = -1.0f;

    /* renamed from: l  reason: collision with other field name */
    protected boolean f4238l = false;

    /* renamed from: l60$b */
    public static class b {
        float a = 0.0f;
        float b = 0.0f;
        float c = 0.0f;
        float d = 0.0f;
        float e = 0.0f;
        float f = 0.0f;
        float g = 0.0f;
        float h = 0.0f;
        float i = 0.0f;
    }

    /* renamed from: l60$d */
    public static class d extends j60 {
        d() {
            X();
            U();
        }

        /* access modifiers changed from: package-private */
        public void Z(String title) {
            Q(h70.Zb, new n80(title, "UnicodeBig"));
        }

        /* access modifiers changed from: package-private */
        public void Y(String subject) {
            Q(h70.rb, new n80(subject, "UnicodeBig"));
        }

        /* access modifiers changed from: package-private */
        public void W(String keywords) {
            Q(h70.Y5, new n80(keywords, "UnicodeBig"));
        }

        /* access modifiers changed from: package-private */
        public void T(String author) {
            Q(h70.X, new n80(author, "UnicodeBig"));
        }

        /* access modifiers changed from: package-private */
        public void V(String creator) {
            Q(h70.M1, new n80(creator, "UnicodeBig"));
        }

        /* access modifiers changed from: package-private */
        public void X() {
            Q(h70.j9, new n80(av0.a().d()));
        }

        /* access modifiers changed from: package-private */
        public void U() {
            n80 date = new g60();
            Q(h70.L1, date);
            Q(h70.Z6, date);
        }

        /* access modifiers changed from: package-private */
        public void a0(String key, String value) {
            if (!key.equals("Producer") && !key.equals("CreationDate")) {
                Q(new h70(key), new n80(value, "UnicodeBig"));
            }
        }
    }

    /* renamed from: l60$c */
    static class c extends j60 {
        v80 a;

        c(z60 pages, v80 writer) {
            super(j60.f);
            this.a = writer;
            Q(h70.q8, pages);
        }

        /* access modifiers changed from: package-private */
        public void T(TreeMap<String, a> localDestinations, HashMap<String, o70> documentLevelJS, HashMap<String, o70> documentFileAttachment, v80 writer) {
            if (!localDestinations.isEmpty() || !documentLevelJS.isEmpty() || !documentFileAttachment.isEmpty()) {
                try {
                    j60 names = new j60();
                    if (!localDestinations.isEmpty()) {
                        HashMap<String, PdfObject> destmap = new HashMap<>();
                        for (Map.Entry<String, PdfDocument.Destination> entry : localDestinations.entrySet()) {
                            String name = entry.getKey();
                            a dest = (a) entry.getValue();
                            if (dest.a != null) {
                                destmap.put(name, dest.f4241a);
                            }
                        }
                        if (destmap.size() > 0) {
                            names.Q(h70.q2, writer.y(i70.a(destmap, writer)).a());
                        }
                    }
                    if (!documentLevelJS.isEmpty()) {
                        names.Q(h70.R5, writer.y(i70.a(documentLevelJS, writer)).a());
                    }
                    if (!documentFileAttachment.isEmpty()) {
                        names.Q(h70.a3, writer.y(i70.a(documentFileAttachment, writer)).a());
                    }
                    if (names.size() > 0) {
                        Q(h70.j7, writer.y(names).a());
                    }
                } catch (IOException e) {
                    throw new mj(e);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void V(u50 action) {
            Q(h70.T7, action);
        }

        /* access modifiers changed from: package-private */
        public void U(j60 actions) {
            try {
                Q(h70.d, this.a.y(actions).a());
            } catch (Exception e) {
                throw new mj(e);
            }
        }
    }

    public l60() {
        i();
        f();
    }

    public void B(v80 writer) {
        if (this.f4215a == null) {
            this.f4215a = writer;
            this.f4216a = new w50(writer);
            return;
        }
        throw new ih(i10.b("you.can.only.add.a.writer.to.a.pdfdocument.once", new Object[0]));
    }

    /* access modifiers changed from: protected */
    public void h0() {
        this.f4205a.push(Float.valueOf(this.f));
    }

    /* access modifiers changed from: protected */
    public void g0() {
        this.f = this.f4205a.pop().floatValue();
        if (this.f4205a.size() > 0) {
            this.f = this.f4205a.peek().floatValue();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:156:0x05b7, code lost:
        r12.e = r13.v();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x05bd, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x05be, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean c(defpackage.bi r13) {
        /*
            r12 = this;
            v80 r0 = r12.f4215a
            r1 = 0
            if (r0 == 0) goto L_0x000c
            boolean r0 = r0.f()
            if (r0 == 0) goto L_0x000c
            return r1
        L_0x000c:
            int r0 = r13.v()     // Catch:{ Exception -> 0x05bf }
            r2 = 37
            if (r0 == r2) goto L_0x0017
            r12.I()     // Catch:{ Exception -> 0x05bf }
        L_0x0017:
            int r0 = r13.v()     // Catch:{ Exception -> 0x05bf }
            r2 = 0
            r3 = 1
            r4 = 0
            switch(r0) {
                case 0: goto L_0x05a3;
                case 1: goto L_0x0596;
                case 2: goto L_0x0589;
                case 3: goto L_0x057c;
                case 4: goto L_0x056f;
                case 5: goto L_0x0569;
                case 6: goto L_0x0563;
                case 7: goto L_0x0556;
                case 8: goto L_0x054b;
                case 10: goto L_0x0511;
                case 11: goto L_0x04f4;
                case 12: goto L_0x0399;
                case 13: goto L_0x0277;
                case 14: goto L_0x0216;
                case 15: goto L_0x0172;
                case 16: goto L_0x0277;
                case 17: goto L_0x014e;
                case 23: goto L_0x012f;
                case 29: goto L_0x00ce;
                case 30: goto L_0x00c2;
                case 32: goto L_0x0082;
                case 33: goto L_0x0082;
                case 34: goto L_0x0082;
                case 35: goto L_0x0082;
                case 36: goto L_0x0082;
                case 37: goto L_0x0072;
                case 38: goto L_0x0068;
                case 50: goto L_0x005e;
                case 55: goto L_0x002f;
                case 666: goto L_0x0023;
                default: goto L_0x0021;
            }     // Catch:{ Exception -> 0x05bf }
        L_0x0021:
            goto L_0x05be
        L_0x0023:
            v80 r0 = r12.f4215a     // Catch:{ Exception -> 0x05bf }
            if (r0 == 0) goto L_0x05b7
            r1 = r13
            ew0 r1 = (defpackage.ew0) r1     // Catch:{ Exception -> 0x05bf }
            r1.a(r0, r12)     // Catch:{ Exception -> 0x05bf }
            goto L_0x05b7
        L_0x002f:
            r4 = r13
            xh r4 = (defpackage.xh) r4     // Catch:{ Exception -> 0x05bf }
            d60 r5 = r12.b     // Catch:{ Exception -> 0x05bf }
            float r6 = r12.W()     // Catch:{ Exception -> 0x05bf }
            float r7 = r12.V()     // Catch:{ Exception -> 0x05bf }
            float r8 = r12.X()     // Catch:{ Exception -> 0x05bf }
            float r9 = r12.Y()     // Catch:{ Exception -> 0x05bf }
            float r0 = r12.Y()     // Catch:{ Exception -> 0x05bf }
            float r10 = r12.g     // Catch:{ Exception -> 0x05bf }
            float r0 = r0 - r10
            java.util.Stack<java.lang.Float> r10 = r12.f4205a     // Catch:{ Exception -> 0x05bf }
            int r10 = r10.size()     // Catch:{ Exception -> 0x05bf }
            if (r10 <= 0) goto L_0x0055
            float r2 = r12.f     // Catch:{ Exception -> 0x05bf }
        L_0x0055:
            float r10 = r0 - r2
            r4.a(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x05bf }
            r12.f4237k = r1     // Catch:{ Exception -> 0x05bf }
            goto L_0x05b7
        L_0x005e:
            defpackage.b6.a(r13)     // Catch:{ Exception -> 0x05bf }
            r0 = r4
            r0.a(r12)     // Catch:{ Exception -> 0x05bf }
            goto L_0x05b7
        L_0x0068:
            defpackage.b6.a(r13)     // Catch:{ Exception -> 0x05bf }
            d60 r0 = r12.b     // Catch:{ Exception -> 0x05bf }
            r0.C0(r4)     // Catch:{ Exception -> 0x05bf }
            goto L_0x05be
        L_0x0072:
            r12.G()     // Catch:{ Exception -> 0x05bf }
            r12.J()     // Catch:{ Exception -> 0x05bf }
            defpackage.b6.a(r13)     // Catch:{ Exception -> 0x05bf }
            r12.x(r4)     // Catch:{ Exception -> 0x05bf }
            r12.f4237k = r1     // Catch:{ Exception -> 0x05bf }
            goto L_0x05b7
        L_0x0082:
            v80 r0 = r12.f4215a     // Catch:{ Exception -> 0x05bf }
            boolean r0 = b0(r0)     // Catch:{ Exception -> 0x05bf }
            if (r0 == 0) goto L_0x009e
            r0 = r13
            tr r0 = (defpackage.tr) r0     // Catch:{ Exception -> 0x05bf }
            boolean r0 = r0.N0()     // Catch:{ Exception -> 0x05bf }
            if (r0 != 0) goto L_0x009e
            r12.J()     // Catch:{ Exception -> 0x05bf }
            d60 r0 = r12.f4200a     // Catch:{ Exception -> 0x05bf }
            r1 = r13
            tr r1 = (defpackage.tr) r1     // Catch:{ Exception -> 0x05bf }
            r0.x0(r1)     // Catch:{ Exception -> 0x05bf }
        L_0x009e:
            r0 = r13
            tr r0 = (defpackage.tr) r0     // Catch:{ Exception -> 0x05bf }
            r12.v(r0)     // Catch:{ Exception -> 0x05bf }
            v80 r0 = r12.f4215a     // Catch:{ Exception -> 0x05bf }
            boolean r0 = b0(r0)     // Catch:{ Exception -> 0x05bf }
            if (r0 == 0) goto L_0x05b7
            r0 = r13
            tr r0 = (defpackage.tr) r0     // Catch:{ Exception -> 0x05bf }
            boolean r0 = r0.N0()     // Catch:{ Exception -> 0x05bf }
            if (r0 != 0) goto L_0x05b7
            r12.J()     // Catch:{ Exception -> 0x05bf }
            d60 r0 = r12.f4200a     // Catch:{ Exception -> 0x05bf }
            r1 = r13
            tr r1 = (defpackage.tr) r1     // Catch:{ Exception -> 0x05bf }
            r0.H(r1)     // Catch:{ Exception -> 0x05bf }
            goto L_0x05b7
        L_0x00c2:
            r0 = r13
            pd0 r0 = (defpackage.pd0) r0     // Catch:{ Exception -> 0x05bf }
            d60 r2 = r12.b     // Catch:{ Exception -> 0x05bf }
            r2.C0(r0)     // Catch:{ Exception -> 0x05bf }
            r12.f4237k = r1     // Catch:{ Exception -> 0x05bf }
            goto L_0x05b7
        L_0x00ce:
            e70 r0 = r12.f4202a     // Catch:{ Exception -> 0x05bf }
            if (r0 != 0) goto L_0x00d5
            r12.E()     // Catch:{ Exception -> 0x05bf }
        L_0x00d5:
            r0 = r13
            h3 r0 = (defpackage.h3) r0     // Catch:{ Exception -> 0x05bf }
            pd0 r4 = new pd0     // Catch:{ Exception -> 0x05bf }
            r4.<init>(r2, r2)     // Catch:{ Exception -> 0x05bf }
            r2 = r4
            e70 r4 = r12.f4202a     // Catch:{ Exception -> 0x05bf }
            if (r4 == 0) goto L_0x0120
            pd0 r4 = new pd0     // Catch:{ Exception -> 0x05bf }
            float r5 = r12.X()     // Catch:{ Exception -> 0x05bf }
            e70 r6 = r12.f4202a     // Catch:{ Exception -> 0x05bf }
            float r6 = r6.A()     // Catch:{ Exception -> 0x05bf }
            float r5 = r5 - r6
            float r5 = r0.g(r5)     // Catch:{ Exception -> 0x05bf }
            float r6 = r12.Y()     // Catch:{ Exception -> 0x05bf }
            float r7 = r12.g     // Catch:{ Exception -> 0x05bf }
            float r6 = r6 - r7
            r7 = 1101004800(0x41a00000, float:20.0)
            float r6 = r6 - r7
            float r6 = r0.o(r6)     // Catch:{ Exception -> 0x05bf }
            float r8 = r12.X()     // Catch:{ Exception -> 0x05bf }
            e70 r9 = r12.f4202a     // Catch:{ Exception -> 0x05bf }
            float r9 = r9.A()     // Catch:{ Exception -> 0x05bf }
            float r8 = r8 - r9
            float r8 = r8 + r7
            float r7 = r0.m(r8)     // Catch:{ Exception -> 0x05bf }
            float r8 = r12.Y()     // Catch:{ Exception -> 0x05bf }
            float r9 = r12.g     // Catch:{ Exception -> 0x05bf }
            float r8 = r8 - r9
            float r8 = r0.i(r8)     // Catch:{ Exception -> 0x05bf }
            r4.<init>(r5, r6, r7, r8)     // Catch:{ Exception -> 0x05bf }
            r2 = r4
        L_0x0120:
            v80 r4 = r12.f4215a     // Catch:{ Exception -> 0x05bf }
            v50 r4 = defpackage.w50.d(r4, r0, r2)     // Catch:{ Exception -> 0x05bf }
            w50 r5 = r12.f4216a     // Catch:{ Exception -> 0x05bf }
            r5.c(r4)     // Catch:{ Exception -> 0x05bf }
            r12.f4237k = r1     // Catch:{ Exception -> 0x05bf }
            goto L_0x05b7
        L_0x012f:
            r0 = r13
            u70 r0 = (defpackage.u70) r0     // Catch:{ Exception -> 0x05bf }
            int r2 = r0.z0()     // Catch:{ Exception -> 0x05bf }
            int r4 = r0.I()     // Catch:{ Exception -> 0x05bf }
            if (r2 > r4) goto L_0x013e
            goto L_0x05b7
        L_0x013e:
            r12.G()     // Catch:{ Exception -> 0x05bf }
            r12.J()     // Catch:{ Exception -> 0x05bf }
            r12.y(r0)     // Catch:{ Exception -> 0x05bf }
            r12.f4237k = r1     // Catch:{ Exception -> 0x05bf }
            r12.e0()     // Catch:{ Exception -> 0x05bf }
            goto L_0x05b7
        L_0x014e:
            defpackage.b6.a(r13)     // Catch:{ Exception -> 0x05bf }
            r0 = r4
            java.lang.String r1 = r0.P()     // Catch:{ Exception -> 0x05bf }
            float r2 = r0.G()     // Catch:{ Exception -> 0x05bf }
            r12.f = r2     // Catch:{ Exception -> 0x05bf }
            r12.h0()     // Catch:{ Exception -> 0x05bf }
            if (r1 == 0) goto L_0x0168
            u50 r2 = new u50     // Catch:{ Exception -> 0x05bf }
            r2.<init>((java.lang.String) r1)     // Catch:{ Exception -> 0x05bf }
            r12.f4213a = r2     // Catch:{ Exception -> 0x05bf }
        L_0x0168:
            r13.a(r12)     // Catch:{ Exception -> 0x05bf }
            r12.f4213a = r4     // Catch:{ Exception -> 0x05bf }
            r12.g0()     // Catch:{ Exception -> 0x05bf }
            goto L_0x05b7
        L_0x0172:
            defpackage.b6.a(r13)     // Catch:{ Exception -> 0x05bf }
            r0 = r4
            v80 r1 = r12.f4215a     // Catch:{ Exception -> 0x05bf }
            boolean r1 = b0(r1)     // Catch:{ Exception -> 0x05bf }
            if (r1 == 0) goto L_0x0186
            r12.J()     // Catch:{ Exception -> 0x05bf }
            d60 r1 = r12.f4200a     // Catch:{ Exception -> 0x05bf }
            r1.x0(r0)     // Catch:{ Exception -> 0x05bf }
        L_0x0186:
            float r1 = r0.c()     // Catch:{ Exception -> 0x05bf }
            float r2 = r12.f     // Catch:{ Exception -> 0x05bf }
            com.itextpdf.text.b r4 = r0.E()     // Catch:{ Exception -> 0x05bf }
            r12.z(r1, r2, r4)     // Catch:{ Exception -> 0x05bf }
            int r1 = r0.R()     // Catch:{ Exception -> 0x05bf }
            r12.c = r1     // Catch:{ Exception -> 0x05bf }
            l60$b r1 = r12.f4207a     // Catch:{ Exception -> 0x05bf }
            float r2 = r1.c     // Catch:{ Exception -> 0x05bf }
            float r4 = r0.U()     // Catch:{ Exception -> 0x05bf }
            float r2 = r2 + r4
            r1.c = r2     // Catch:{ Exception -> 0x05bf }
            l60$b r1 = r12.f4207a     // Catch:{ Exception -> 0x05bf }
            float r2 = r1.e     // Catch:{ Exception -> 0x05bf }
            float r4 = r0.V()     // Catch:{ Exception -> 0x05bf }
            float r2 = r2 + r4
            r1.e = r2     // Catch:{ Exception -> 0x05bf }
            float r1 = r0.J()     // Catch:{ Exception -> 0x05bf }
            r12.f = r1     // Catch:{ Exception -> 0x05bf }
            r12.h0()     // Catch:{ Exception -> 0x05bf }
            r12.E()     // Catch:{ Exception -> 0x05bf }
            e70 r1 = r12.f4202a     // Catch:{ Exception -> 0x05bf }
            r1.y(r0)     // Catch:{ Exception -> 0x05bf }
            r13.a(r12)     // Catch:{ Exception -> 0x05bf }
            float r1 = r0.X()     // Catch:{ Exception -> 0x05bf }
            float r2 = r0.J()     // Catch:{ Exception -> 0x05bf }
            com.itextpdf.text.b r4 = r0.E()     // Catch:{ Exception -> 0x05bf }
            r12.A(r1, r2, r4, r3)     // Catch:{ Exception -> 0x05bf }
            e70 r1 = r12.f4202a     // Catch:{ Exception -> 0x05bf }
            boolean r1 = r1.m()     // Catch:{ Exception -> 0x05bf }
            if (r1 == 0) goto L_0x01df
            e70 r1 = r12.f4202a     // Catch:{ Exception -> 0x05bf }
            r1.w()     // Catch:{ Exception -> 0x05bf }
        L_0x01df:
            r12.E()     // Catch:{ Exception -> 0x05bf }
            l60$b r1 = r12.f4207a     // Catch:{ Exception -> 0x05bf }
            float r2 = r1.c     // Catch:{ Exception -> 0x05bf }
            float r4 = r0.U()     // Catch:{ Exception -> 0x05bf }
            float r2 = r2 - r4
            r1.c = r2     // Catch:{ Exception -> 0x05bf }
            l60$b r1 = r12.f4207a     // Catch:{ Exception -> 0x05bf }
            float r2 = r1.e     // Catch:{ Exception -> 0x05bf }
            float r4 = r0.V()     // Catch:{ Exception -> 0x05bf }
            float r2 = r2 - r4
            r1.e = r2     // Catch:{ Exception -> 0x05bf }
            r12.g0()     // Catch:{ Exception -> 0x05bf }
            v80 r1 = r12.f4215a     // Catch:{ Exception -> 0x05bf }
            boolean r1 = b0(r1)     // Catch:{ Exception -> 0x05bf }
            if (r1 == 0) goto L_0x05b7
            r12.J()     // Catch:{ Exception -> 0x05bf }
            d60 r1 = r12.f4200a     // Catch:{ Exception -> 0x05bf }
            jx r2 = r0.h0()     // Catch:{ Exception -> 0x05bf }
            r1.H(r2)     // Catch:{ Exception -> 0x05bf }
            d60 r1 = r12.f4200a     // Catch:{ Exception -> 0x05bf }
            r1.H(r0)     // Catch:{ Exception -> 0x05bf }
            goto L_0x05b7
        L_0x0216:
            defpackage.b6.a(r13)     // Catch:{ Exception -> 0x05bf }
            r0 = r4
            v80 r1 = r12.f4215a     // Catch:{ Exception -> 0x05bf }
            boolean r1 = b0(r1)     // Catch:{ Exception -> 0x05bf }
            if (r1 == 0) goto L_0x022a
            r12.J()     // Catch:{ Exception -> 0x05bf }
            d60 r1 = r12.f4200a     // Catch:{ Exception -> 0x05bf }
            r1.x0(r0)     // Catch:{ Exception -> 0x05bf }
        L_0x022a:
            boolean r1 = r0.k()     // Catch:{ Exception -> 0x05bf }
            if (r1 == 0) goto L_0x0233
            r0.m()     // Catch:{ Exception -> 0x05bf }
        L_0x0233:
            l60$b r1 = r12.f4207a     // Catch:{ Exception -> 0x05bf }
            float r2 = r1.c     // Catch:{ Exception -> 0x05bf }
            float r4 = r0.e()     // Catch:{ Exception -> 0x05bf }
            float r2 = r2 + r4
            r1.c = r2     // Catch:{ Exception -> 0x05bf }
            l60$b r1 = r12.f4207a     // Catch:{ Exception -> 0x05bf }
            float r2 = r1.e     // Catch:{ Exception -> 0x05bf }
            float r4 = r0.f()     // Catch:{ Exception -> 0x05bf }
            float r2 = r2 + r4
            r1.e = r2     // Catch:{ Exception -> 0x05bf }
            r13.a(r12)     // Catch:{ Exception -> 0x05bf }
            l60$b r1 = r12.f4207a     // Catch:{ Exception -> 0x05bf }
            float r2 = r1.c     // Catch:{ Exception -> 0x05bf }
            float r4 = r0.e()     // Catch:{ Exception -> 0x05bf }
            float r2 = r2 - r4
            r1.c = r2     // Catch:{ Exception -> 0x05bf }
            l60$b r1 = r12.f4207a     // Catch:{ Exception -> 0x05bf }
            float r2 = r1.e     // Catch:{ Exception -> 0x05bf }
            float r4 = r0.f()     // Catch:{ Exception -> 0x05bf }
            float r2 = r2 - r4
            r1.e = r2     // Catch:{ Exception -> 0x05bf }
            r12.E()     // Catch:{ Exception -> 0x05bf }
            v80 r1 = r12.f4215a     // Catch:{ Exception -> 0x05bf }
            boolean r1 = b0(r1)     // Catch:{ Exception -> 0x05bf }
            if (r1 == 0) goto L_0x05b7
            r12.J()     // Catch:{ Exception -> 0x05bf }
            d60 r1 = r12.f4200a     // Catch:{ Exception -> 0x05bf }
            r1.H(r0)     // Catch:{ Exception -> 0x05bf }
            goto L_0x05b7
        L_0x0277:
            defpackage.b6.a(r13)     // Catch:{ Exception -> 0x05bf }
            r0 = r4
            v80 r2 = r12.f4215a     // Catch:{ Exception -> 0x05bf }
            a80 r2 = r2.j0()     // Catch:{ Exception -> 0x05bf }
            boolean r4 = r0.F()     // Catch:{ Exception -> 0x05bf }
            if (r4 == 0) goto L_0x028f
            k50 r4 = r0.D()     // Catch:{ Exception -> 0x05bf }
            if (r4 == 0) goto L_0x028f
            r4 = 1
            goto L_0x0290
        L_0x028f:
            r4 = 0
        L_0x0290:
            r10 = r4
            boolean r4 = r0.G()     // Catch:{ Exception -> 0x05bf }
            if (r4 == 0) goto L_0x029a
            r12.e()     // Catch:{ Exception -> 0x05bf }
        L_0x029a:
            if (r10 == 0) goto L_0x02e5
            float r4 = r12.Y()     // Catch:{ Exception -> 0x05bf }
            float r5 = r12.g     // Catch:{ Exception -> 0x05bf }
            float r4 = r4 - r5
            pd0 r5 = r12.f3085a     // Catch:{ Exception -> 0x05bf }
            int r5 = r5.I()     // Catch:{ Exception -> 0x05bf }
            r6 = 90
            if (r5 == r6) goto L_0x02b1
            r6 = 180(0xb4, float:2.52E-43)
            if (r5 != r6) goto L_0x02b9
        L_0x02b1:
            pd0 r6 = r12.f3085a     // Catch:{ Exception -> 0x05bf }
            float r6 = r6.D()     // Catch:{ Exception -> 0x05bf }
            float r4 = r6 - r4
        L_0x02b9:
            h60 r6 = new h60     // Catch:{ Exception -> 0x05bf }
            r7 = 2
            r6.<init>(r7, r4)     // Catch:{ Exception -> 0x05bf }
        L_0x02bf:
            p70 r7 = r12.f4220b     // Catch:{ Exception -> 0x05bf }
            int r7 = r7.Z()     // Catch:{ Exception -> 0x05bf }
            int r8 = r0.m()     // Catch:{ Exception -> 0x05bf }
            if (r7 < r8) goto L_0x02d4
            p70 r7 = r12.f4220b     // Catch:{ Exception -> 0x05bf }
            p70 r7 = r7.a0()     // Catch:{ Exception -> 0x05bf }
            r12.f4220b = r7     // Catch:{ Exception -> 0x05bf }
            goto L_0x02bf
        L_0x02d4:
            p70 r7 = new p70     // Catch:{ Exception -> 0x05bf }
            p70 r8 = r12.f4220b     // Catch:{ Exception -> 0x05bf }
            k50 r9 = r0.c()     // Catch:{ Exception -> 0x05bf }
            boolean r11 = r0.E()     // Catch:{ Exception -> 0x05bf }
            r7.<init>(r8, r6, r9, r11)     // Catch:{ Exception -> 0x05bf }
            r12.f4220b = r7     // Catch:{ Exception -> 0x05bf }
        L_0x02e5:
            r12.E()     // Catch:{ Exception -> 0x05bf }
            l60$b r4 = r12.f4207a     // Catch:{ Exception -> 0x05bf }
            float r5 = r4.b     // Catch:{ Exception -> 0x05bf }
            float r6 = r0.A()     // Catch:{ Exception -> 0x05bf }
            float r5 = r5 + r6
            r4.b = r5     // Catch:{ Exception -> 0x05bf }
            l60$b r4 = r12.f4207a     // Catch:{ Exception -> 0x05bf }
            float r5 = r4.f     // Catch:{ Exception -> 0x05bf }
            float r6 = r0.B()     // Catch:{ Exception -> 0x05bf }
            float r5 = r5 + r6
            r4.f = r5     // Catch:{ Exception -> 0x05bf }
            boolean r4 = r0.F()     // Catch:{ Exception -> 0x05bf }
            r11 = 16
            if (r4 == 0) goto L_0x0336
            if (r2 == 0) goto L_0x0336
            int r4 = r13.v()     // Catch:{ Exception -> 0x05bf }
            if (r4 != r11) goto L_0x031f
            v80 r4 = r12.f4215a     // Catch:{ Exception -> 0x05bf }
            float r5 = r12.Y()     // Catch:{ Exception -> 0x05bf }
            float r6 = r12.g     // Catch:{ Exception -> 0x05bf }
            float r5 = r5 - r6
            k50 r6 = r0.D()     // Catch:{ Exception -> 0x05bf }
            r2.b(r4, r12, r5, r6)     // Catch:{ Exception -> 0x05bf }
            goto L_0x0336
        L_0x031f:
            v80 r5 = r12.f4215a     // Catch:{ Exception -> 0x05bf }
            float r4 = r12.Y()     // Catch:{ Exception -> 0x05bf }
            float r6 = r12.g     // Catch:{ Exception -> 0x05bf }
            float r7 = r4 - r6
            int r8 = r0.m()     // Catch:{ Exception -> 0x05bf }
            k50 r9 = r0.D()     // Catch:{ Exception -> 0x05bf }
            r4 = r2
            r6 = r12
            r4.j(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x05bf }
        L_0x0336:
            if (r10 == 0) goto L_0x0343
            r12.f4234i = r3     // Catch:{ Exception -> 0x05bf }
            k50 r4 = r0.D()     // Catch:{ Exception -> 0x05bf }
            r12.c(r4)     // Catch:{ Exception -> 0x05bf }
            r12.f4234i = r1     // Catch:{ Exception -> 0x05bf }
        L_0x0343:
            l60$b r1 = r12.f4207a     // Catch:{ Exception -> 0x05bf }
            float r4 = r1.b     // Catch:{ Exception -> 0x05bf }
            float r5 = r0.z()     // Catch:{ Exception -> 0x05bf }
            float r4 = r4 + r5
            r1.b = r4     // Catch:{ Exception -> 0x05bf }
            r13.a(r12)     // Catch:{ Exception -> 0x05bf }
            r12.J()     // Catch:{ Exception -> 0x05bf }
            l60$b r1 = r12.f4207a     // Catch:{ Exception -> 0x05bf }
            float r4 = r1.b     // Catch:{ Exception -> 0x05bf }
            float r5 = r0.A()     // Catch:{ Exception -> 0x05bf }
            float r6 = r0.z()     // Catch:{ Exception -> 0x05bf }
            float r5 = r5 + r6
            float r4 = r4 - r5
            r1.b = r4     // Catch:{ Exception -> 0x05bf }
            l60$b r1 = r12.f4207a     // Catch:{ Exception -> 0x05bf }
            float r4 = r1.f     // Catch:{ Exception -> 0x05bf }
            float r5 = r0.B()     // Catch:{ Exception -> 0x05bf }
            float r4 = r4 - r5
            r1.f = r4     // Catch:{ Exception -> 0x05bf }
            boolean r1 = r0.isComplete()     // Catch:{ Exception -> 0x05bf }
            if (r1 == 0) goto L_0x05b7
            if (r2 == 0) goto L_0x05b7
            int r1 = r13.v()     // Catch:{ Exception -> 0x05bf }
            if (r1 != r11) goto L_0x038b
            v80 r1 = r12.f4215a     // Catch:{ Exception -> 0x05bf }
            float r4 = r12.Y()     // Catch:{ Exception -> 0x05bf }
            float r5 = r12.g     // Catch:{ Exception -> 0x05bf }
            float r4 = r4 - r5
            r2.e(r1, r12, r4)     // Catch:{ Exception -> 0x05bf }
            goto L_0x05b7
        L_0x038b:
            v80 r1 = r12.f4215a     // Catch:{ Exception -> 0x05bf }
            float r4 = r12.Y()     // Catch:{ Exception -> 0x05bf }
            float r5 = r12.g     // Catch:{ Exception -> 0x05bf }
            float r4 = r4 - r5
            r2.c(r1, r12, r4)     // Catch:{ Exception -> 0x05bf }
            goto L_0x05b7
        L_0x0399:
            gp0 r0 = r12.f4203a     // Catch:{ Exception -> 0x05bf }
            r4 = r13
            com.itextpdf.text.d r4 = (com.itextpdf.text.d) r4     // Catch:{ Exception -> 0x05bf }
            r4.I()     // Catch:{ Exception -> 0x05bf }
            r4 = r13
            k50 r4 = (defpackage.k50) r4     // Catch:{ Exception -> 0x05bf }
            v80 r5 = r12.f4215a     // Catch:{ Exception -> 0x05bf }
            boolean r5 = b0(r5)     // Catch:{ Exception -> 0x05bf }
            if (r5 == 0) goto L_0x03b4
            r12.J()     // Catch:{ Exception -> 0x05bf }
            d60 r5 = r12.f4200a     // Catch:{ Exception -> 0x05bf }
            r5.x0(r4)     // Catch:{ Exception -> 0x05bf }
        L_0x03b4:
            float r5 = r4.c()     // Catch:{ Exception -> 0x05bf }
            float r6 = r12.f     // Catch:{ Exception -> 0x05bf }
            com.itextpdf.text.b r7 = r4.E()     // Catch:{ Exception -> 0x05bf }
            r12.z(r5, r6, r7)     // Catch:{ Exception -> 0x05bf }
            int r5 = r4.R()     // Catch:{ Exception -> 0x05bf }
            r12.c = r5     // Catch:{ Exception -> 0x05bf }
            float r5 = r4.J()     // Catch:{ Exception -> 0x05bf }
            r12.f = r5     // Catch:{ Exception -> 0x05bf }
            r12.h0()     // Catch:{ Exception -> 0x05bf }
            r12.E()     // Catch:{ Exception -> 0x05bf }
            float r5 = r12.g     // Catch:{ Exception -> 0x05bf }
            float r6 = r12.C()     // Catch:{ Exception -> 0x05bf }
            float r5 = r5 + r6
            float r6 = r12.Y()     // Catch:{ Exception -> 0x05bf }
            float r7 = r12.V()     // Catch:{ Exception -> 0x05bf }
            float r6 = r6 - r7
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x03ea
            r12.e()     // Catch:{ Exception -> 0x05bf }
        L_0x03ea:
            l60$b r5 = r12.f4207a     // Catch:{ Exception -> 0x05bf }
            float r6 = r5.a     // Catch:{ Exception -> 0x05bf }
            float r7 = r4.U()     // Catch:{ Exception -> 0x05bf }
            float r6 = r6 + r7
            r5.a = r6     // Catch:{ Exception -> 0x05bf }
            l60$b r5 = r12.f4207a     // Catch:{ Exception -> 0x05bf }
            float r6 = r5.e     // Catch:{ Exception -> 0x05bf }
            float r7 = r4.V()     // Catch:{ Exception -> 0x05bf }
            float r6 = r6 + r7
            r5.e = r6     // Catch:{ Exception -> 0x05bf }
            r12.E()     // Catch:{ Exception -> 0x05bf }
            v80 r5 = r12.f4215a     // Catch:{ Exception -> 0x05bf }
            a80 r5 = r5.j0()     // Catch:{ Exception -> 0x05bf }
            if (r5 == 0) goto L_0x041b
            boolean r6 = r12.f4234i     // Catch:{ Exception -> 0x05bf }
            if (r6 != 0) goto L_0x041b
            v80 r6 = r12.f4215a     // Catch:{ Exception -> 0x05bf }
            float r7 = r12.Y()     // Catch:{ Exception -> 0x05bf }
            float r8 = r12.g     // Catch:{ Exception -> 0x05bf }
            float r7 = r7 - r8
            r5.h(r6, r12, r7)     // Catch:{ Exception -> 0x05bf }
        L_0x041b:
            boolean r6 = r4.W()     // Catch:{ Exception -> 0x05bf }
            if (r6 == 0) goto L_0x0476
            r12.E()     // Catch:{ Exception -> 0x05bf }
            u70 r6 = new u70     // Catch:{ Exception -> 0x05bf }
            r6.<init>((int) r3)     // Catch:{ Exception -> 0x05bf }
            boolean r7 = r4.W()     // Catch:{ Exception -> 0x05bf }
            r6.p0(r7)     // Catch:{ Exception -> 0x05bf }
            r7 = 1120403456(0x42c80000, float:100.0)
            r6.x0(r7)     // Catch:{ Exception -> 0x05bf }
            q70 r7 = new q70     // Catch:{ Exception -> 0x05bf }
            r7.<init>()     // Catch:{ Exception -> 0x05bf }
            r7.Z(r4)     // Catch:{ Exception -> 0x05bf }
            r7.R(r1)     // Catch:{ Exception -> 0x05bf }
            r7.E0(r2)     // Catch:{ Exception -> 0x05bf }
            r6.e(r7)     // Catch:{ Exception -> 0x05bf }
            l60$b r2 = r12.f4207a     // Catch:{ Exception -> 0x05bf }
            float r8 = r2.a     // Catch:{ Exception -> 0x05bf }
            float r9 = r4.U()     // Catch:{ Exception -> 0x05bf }
            float r8 = r8 - r9
            r2.a = r8     // Catch:{ Exception -> 0x05bf }
            l60$b r2 = r12.f4207a     // Catch:{ Exception -> 0x05bf }
            float r8 = r2.e     // Catch:{ Exception -> 0x05bf }
            float r9 = r4.V()     // Catch:{ Exception -> 0x05bf }
            float r8 = r8 - r9
            r2.e = r8     // Catch:{ Exception -> 0x05bf }
            r12.c(r6)     // Catch:{ Exception -> 0x05bf }
            l60$b r2 = r12.f4207a     // Catch:{ Exception -> 0x05bf }
            float r8 = r2.a     // Catch:{ Exception -> 0x05bf }
            float r9 = r4.U()     // Catch:{ Exception -> 0x05bf }
            float r8 = r8 + r9
            r2.a = r8     // Catch:{ Exception -> 0x05bf }
            l60$b r2 = r12.f4207a     // Catch:{ Exception -> 0x05bf }
            float r8 = r2.e     // Catch:{ Exception -> 0x05bf }
            float r9 = r4.V()     // Catch:{ Exception -> 0x05bf }
            float r8 = r8 + r9
            r2.e = r8     // Catch:{ Exception -> 0x05bf }
            goto L_0x04a4
        L_0x0476:
            e70 r2 = r12.f4202a     // Catch:{ Exception -> 0x05bf }
            float r6 = r4.T()     // Catch:{ Exception -> 0x05bf }
            r2.x(r6)     // Catch:{ Exception -> 0x05bf }
            float r2 = r12.g     // Catch:{ Exception -> 0x05bf }
            r13.a(r12)     // Catch:{ Exception -> 0x05bf }
            r12.E()     // Catch:{ Exception -> 0x05bf }
            float r6 = r12.g     // Catch:{ Exception -> 0x05bf }
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 != 0) goto L_0x0495
            java.util.ArrayList<e70> r6 = r12.f4218b     // Catch:{ Exception -> 0x05bf }
            int r6 = r6.size()     // Catch:{ Exception -> 0x05bf }
            if (r6 <= 0) goto L_0x04a4
        L_0x0495:
            float r6 = r4.X()     // Catch:{ Exception -> 0x05bf }
            float r7 = r4.J()     // Catch:{ Exception -> 0x05bf }
            com.itextpdf.text.b r8 = r4.E()     // Catch:{ Exception -> 0x05bf }
            r12.A(r6, r7, r8, r3)     // Catch:{ Exception -> 0x05bf }
        L_0x04a4:
            if (r5 == 0) goto L_0x04b6
            boolean r2 = r12.f4234i     // Catch:{ Exception -> 0x05bf }
            if (r2 != 0) goto L_0x04b6
            v80 r2 = r12.f4215a     // Catch:{ Exception -> 0x05bf }
            float r6 = r12.Y()     // Catch:{ Exception -> 0x05bf }
            float r7 = r12.g     // Catch:{ Exception -> 0x05bf }
            float r6 = r6 - r7
            r5.i(r2, r12, r6)     // Catch:{ Exception -> 0x05bf }
        L_0x04b6:
            r12.c = r1     // Catch:{ Exception -> 0x05bf }
            java.util.ArrayList<bi> r1 = r12.f4223c     // Catch:{ Exception -> 0x05bf }
            if (r1 == 0) goto L_0x04c5
            int r1 = r1.size()     // Catch:{ Exception -> 0x05bf }
            if (r1 == 0) goto L_0x04c5
            r12.I()     // Catch:{ Exception -> 0x05bf }
        L_0x04c5:
            l60$b r1 = r12.f4207a     // Catch:{ Exception -> 0x05bf }
            float r2 = r1.a     // Catch:{ Exception -> 0x05bf }
            float r6 = r4.U()     // Catch:{ Exception -> 0x05bf }
            float r2 = r2 - r6
            r1.a = r2     // Catch:{ Exception -> 0x05bf }
            l60$b r1 = r12.f4207a     // Catch:{ Exception -> 0x05bf }
            float r2 = r1.e     // Catch:{ Exception -> 0x05bf }
            float r6 = r4.V()     // Catch:{ Exception -> 0x05bf }
            float r2 = r2 - r6
            r1.e = r2     // Catch:{ Exception -> 0x05bf }
            r12.E()     // Catch:{ Exception -> 0x05bf }
            r12.g0()     // Catch:{ Exception -> 0x05bf }
            v80 r1 = r12.f4215a     // Catch:{ Exception -> 0x05bf }
            boolean r1 = b0(r1)     // Catch:{ Exception -> 0x05bf }
            if (r1 == 0) goto L_0x05b7
            r12.J()     // Catch:{ Exception -> 0x05bf }
            d60 r1 = r12.f4200a     // Catch:{ Exception -> 0x05bf }
            r1.H(r4)     // Catch:{ Exception -> 0x05bf }
            goto L_0x05b7
        L_0x04f4:
            gp0 r0 = r12.f4203a     // Catch:{ Exception -> 0x05bf }
            r1 = r13
            com.itextpdf.text.d r1 = (com.itextpdf.text.d) r1     // Catch:{ Exception -> 0x05bf }
            r1.I()     // Catch:{ Exception -> 0x05bf }
            r1 = r13
            com.itextpdf.text.d r1 = (com.itextpdf.text.d) r1     // Catch:{ Exception -> 0x05bf }
            float r1 = r1.J()     // Catch:{ Exception -> 0x05bf }
            r12.f = r1     // Catch:{ Exception -> 0x05bf }
            r12.h0()     // Catch:{ Exception -> 0x05bf }
            r13.a(r12)     // Catch:{ Exception -> 0x05bf }
            r12.g0()     // Catch:{ Exception -> 0x05bf }
            goto L_0x05b7
        L_0x0511:
            e70 r0 = r12.f4202a     // Catch:{ Exception -> 0x05bf }
            if (r0 != 0) goto L_0x0518
            r12.E()     // Catch:{ Exception -> 0x05bf }
        L_0x0518:
            b60 r0 = new b60     // Catch:{ Exception -> 0x05bf }
            r2 = r13
            com.itextpdf.text.a r2 = (com.itextpdf.text.a) r2     // Catch:{ Exception -> 0x05bf }
            u50 r4 = r12.f4213a     // Catch:{ Exception -> 0x05bf }
            gp0 r5 = r12.f4203a     // Catch:{ Exception -> 0x05bf }
            r0.<init>(r2, r4, r5)     // Catch:{ Exception -> 0x05bf }
        L_0x0524:
            e70 r2 = r12.f4202a     // Catch:{ Exception -> 0x05bf }
            float r4 = r12.f     // Catch:{ Exception -> 0x05bf }
            b60 r2 = r2.b(r0, r4)     // Catch:{ Exception -> 0x05bf }
            r4 = r2
            if (r2 == 0) goto L_0x053d
            r12.E()     // Catch:{ Exception -> 0x05bf }
            boolean r2 = r0.y()     // Catch:{ Exception -> 0x05bf }
            r0 = r4
            if (r2 != 0) goto L_0x053c
            r0.K()     // Catch:{ Exception -> 0x05bf }
        L_0x053c:
            goto L_0x0524
        L_0x053d:
            r12.f4237k = r1     // Catch:{ Exception -> 0x05bf }
            java.lang.String r1 = "NEWPAGE"
            boolean r1 = r0.u(r1)     // Catch:{ Exception -> 0x05bf }
            if (r1 == 0) goto L_0x05b7
            r12.e()     // Catch:{ Exception -> 0x05bf }
            goto L_0x05b7
        L_0x054b:
            r0 = r13
            j10 r0 = (defpackage.j10) r0     // Catch:{ Exception -> 0x05bf }
            java.lang.String r0 = r0.b()     // Catch:{ Exception -> 0x05bf }
            r12.l0(r0)     // Catch:{ Exception -> 0x05bf }
            goto L_0x05b7
        L_0x0556:
            l60$d r0 = r12.f4208a     // Catch:{ Exception -> 0x05bf }
            r1 = r13
            j10 r1 = (defpackage.j10) r1     // Catch:{ Exception -> 0x05bf }
            java.lang.String r1 = r1.b()     // Catch:{ Exception -> 0x05bf }
            r0.V(r1)     // Catch:{ Exception -> 0x05bf }
            goto L_0x05b7
        L_0x0563:
            l60$d r0 = r12.f4208a     // Catch:{ Exception -> 0x05bf }
            r0.U()     // Catch:{ Exception -> 0x05bf }
            goto L_0x05b7
        L_0x0569:
            l60$d r0 = r12.f4208a     // Catch:{ Exception -> 0x05bf }
            r0.X()     // Catch:{ Exception -> 0x05bf }
            goto L_0x05b7
        L_0x056f:
            l60$d r0 = r12.f4208a     // Catch:{ Exception -> 0x05bf }
            r1 = r13
            j10 r1 = (defpackage.j10) r1     // Catch:{ Exception -> 0x05bf }
            java.lang.String r1 = r1.b()     // Catch:{ Exception -> 0x05bf }
            r0.T(r1)     // Catch:{ Exception -> 0x05bf }
            goto L_0x05b7
        L_0x057c:
            l60$d r0 = r12.f4208a     // Catch:{ Exception -> 0x05bf }
            r1 = r13
            j10 r1 = (defpackage.j10) r1     // Catch:{ Exception -> 0x05bf }
            java.lang.String r1 = r1.b()     // Catch:{ Exception -> 0x05bf }
            r0.W(r1)     // Catch:{ Exception -> 0x05bf }
            goto L_0x05b7
        L_0x0589:
            l60$d r0 = r12.f4208a     // Catch:{ Exception -> 0x05bf }
            r1 = r13
            j10 r1 = (defpackage.j10) r1     // Catch:{ Exception -> 0x05bf }
            java.lang.String r1 = r1.b()     // Catch:{ Exception -> 0x05bf }
            r0.Y(r1)     // Catch:{ Exception -> 0x05bf }
            goto L_0x05b7
        L_0x0596:
            l60$d r0 = r12.f4208a     // Catch:{ Exception -> 0x05bf }
            r1 = r13
            j10 r1 = (defpackage.j10) r1     // Catch:{ Exception -> 0x05bf }
            java.lang.String r1 = r1.b()     // Catch:{ Exception -> 0x05bf }
            r0.Z(r1)     // Catch:{ Exception -> 0x05bf }
            goto L_0x05b7
        L_0x05a3:
            l60$d r0 = r12.f4208a     // Catch:{ Exception -> 0x05bf }
            r1 = r13
            j10 r1 = (defpackage.j10) r1     // Catch:{ Exception -> 0x05bf }
            java.lang.String r1 = r1.c()     // Catch:{ Exception -> 0x05bf }
            r2 = r13
            j10 r2 = (defpackage.j10) r2     // Catch:{ Exception -> 0x05bf }
            java.lang.String r2 = r2.b()     // Catch:{ Exception -> 0x05bf }
            r0.a0(r1, r2)     // Catch:{ Exception -> 0x05bf }
        L_0x05b7:
            int r0 = r13.v()     // Catch:{ Exception -> 0x05bf }
            r12.e = r0     // Catch:{ Exception -> 0x05bf }
            return r3
        L_0x05be:
            return r1
        L_0x05bf:
            r0 = move-exception
            ih r1 = new ih
            r1.<init>((java.lang.Exception) r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l60.c(bi):boolean");
    }

    public void open() {
        if (!this.f3086a) {
            super.open();
            this.f4215a.open();
            p70 p70 = new p70(this.f4215a);
            this.f4211a = p70;
            this.f4220b = p70;
        }
        try {
            if (b0(this.f4215a)) {
                this.f4232h = true;
            }
            Z();
        } catch (ih de) {
            throw new mj(de);
        }
    }

    public void close() {
        if (!this.f3089b) {
            try {
                if (b0(this.f4215a)) {
                    I();
                    J();
                    this.f4215a.P();
                    this.f4215a.Q();
                    if (a0()) {
                        int pageReferenceCount = this.f4215a.f5323a.size();
                        if (pageReferenceCount > 0) {
                            v80 v80 = this.f4215a;
                            if (v80.f5315a == pageReferenceCount) {
                                v80.f5323a.remove(pageReferenceCount - 1);
                            }
                        }
                    }
                } else {
                    this.f4215a.P();
                }
                if (this.f4212a != null) {
                    e();
                }
                F();
                if (b0(this.f4215a)) {
                    this.f4215a.Y().H(this);
                }
                if (!this.f4216a.f()) {
                    a80 pageEvent = this.f4215a.j0();
                    if (pageEvent != null) {
                        pageEvent.g(this.f4215a, this);
                    }
                    super.close();
                    this.f4215a.o(this.f4206a);
                    D();
                    p0();
                    this.f4215a.close();
                    return;
                }
                throw new RuntimeException(i10.b("not.all.annotations.could.be.added.to.the.document.the.document.doesn.t.have.enough.pages", new Object[0]));
            } catch (Exception e2) {
                throw mj.a(e2);
            }
        }
    }

    public boolean e() {
        if (a0()) {
            m0();
            return false;
        } else if (!this.f3086a || this.f3089b) {
            throw new RuntimeException(i10.b("the.document.is.not.open", new Object[0]));
        } else {
            ArrayList<br> F = F();
            super.e();
            b bVar = this.f4207a;
            bVar.d = 0.0f;
            bVar.g = 0.0f;
            try {
                if (b0(this.f4215a)) {
                    K();
                    this.f4215a.Z().J0(F);
                }
                Z();
                return true;
            } catch (ih de) {
                throw new mj(de);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0158 A[Catch:{ ih -> 0x019c, IOException -> 0x0195 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0177 A[Catch:{ ih -> 0x019c, IOException -> 0x0195 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<defpackage.br> F() {
        /*
            r14 = this;
            java.lang.String r0 = "crop"
            java.lang.String r1 = "art"
            boolean r2 = r14.a0()
            r3 = 0
            if (r2 == 0) goto L_0x000c
            return r3
        L_0x000c:
            r2 = 0
            r14.I()     // Catch:{ ih -> 0x01a3 }
            r4 = -1
            r14.e = r4
            v80 r4 = r14.f4215a
            a80 r4 = r4.j0()
            if (r4 == 0) goto L_0x0021
            v80 r5 = r14.f4215a
            r4.d(r5, r14)
        L_0x0021:
            r14.J()     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            pd0 r5 = r14.f3085a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            int r5 = r5.I()     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            v80 r6 = r14.f4215a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            boolean r6 = r6.w0()     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            if (r6 == 0) goto L_0x0086
            java.util.HashMap<java.lang.String, f80> r6 = r14.f4233i     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            boolean r6 = r6.containsKey(r1)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            java.lang.String r7 = "trim"
            if (r6 == 0) goto L_0x0054
            java.util.HashMap<java.lang.String, f80> r6 = r14.f4233i     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            boolean r6 = r6.containsKey(r7)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            if (r6 != 0) goto L_0x0045
            goto L_0x0054
        L_0x0045:
            x80 r0 = new x80     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            java.lang.String r1 = "only.one.of.artbox.or.trimbox.can.exist.in.the.page"
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            java.lang.String r1 = defpackage.i10.b(r1, r3)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            r0.<init>(r1)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            throw r0     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
        L_0x0054:
            java.util.HashMap<java.lang.String, f80> r6 = r14.f4233i     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            boolean r1 = r6.containsKey(r1)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            if (r1 != 0) goto L_0x0086
            java.util.HashMap<java.lang.String, f80> r1 = r14.f4233i     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            boolean r1 = r1.containsKey(r7)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            if (r1 != 0) goto L_0x0086
            java.util.HashMap<java.lang.String, f80> r1 = r14.f4233i     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            boolean r1 = r1.containsKey(r0)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            if (r1 == 0) goto L_0x0076
            java.util.HashMap<java.lang.String, f80> r1 = r14.f4233i     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            java.lang.Object r0 = r1.get(r0)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            r1.put(r7, r0)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            goto L_0x0086
        L_0x0076:
            java.util.HashMap<java.lang.String, f80> r0 = r14.f4233i     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            f80 r1 = new f80     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            pd0 r6 = r14.f3085a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            int r8 = r6.I()     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            r1.<init>((defpackage.pd0) r6, (int) r8)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            r0.put(r7, r1)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
        L_0x0086:
            e50 r0 = r14.f4201a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            v80 r1 = r14.f4215a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            j60 r1 = r1.X()     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            r0.c(r1)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            v80 r0 = r14.f4215a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            boolean r0 = r0.y0()     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            if (r0 == 0) goto L_0x00aa
            j60 r0 = new j60     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            r0.<init>()     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            h70 r1 = defpackage.h70.S1     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            h70 r6 = defpackage.h70.s2     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            r0.Q(r1, r6)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            e50 r1 = r14.f4201a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            r1.c(r0)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
        L_0x00aa:
            e50 r0 = r14.f4201a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            j60 r0 = r0.i()     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            z70 r1 = new z70     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            f80 r6 = new f80     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            pd0 r7 = r14.f3085a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            r6.<init>((defpackage.pd0) r7, (int) r5)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            java.util.HashMap<java.lang.String, f80> r7 = r14.f4233i     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            r1.<init>(r6, r7, r0, r5)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            v80 r6 = r14.f4215a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            boolean r6 = b0(r6)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            if (r6 == 0) goto L_0x00ce
            h70 r6 = defpackage.h70.Cb     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            h70 r7 = defpackage.h70.ta     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            r1.Q(r6, r7)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            goto L_0x00d9
        L_0x00ce:
            h70 r6 = defpackage.h70.Cb     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            v80 r7 = r14.f4215a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            h70 r7 = r7.s0()     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            r1.Q(r6, r7)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
        L_0x00d9:
            v80 r6 = r14.f4215a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            j60 r6 = r6.i0()     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            r1.R(r6)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            v80 r6 = r14.f4215a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            r6.D0()     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            j60 r6 = r14.f4217b     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            if (r6 == 0) goto L_0x00fc
            h70 r7 = defpackage.h70.d     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            v80 r8 = r14.f4215a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            y60 r6 = r8.y(r6)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            z60 r6 = r6.a()     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            r1.Q(r7, r6)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            r14.f4217b = r3     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
        L_0x00fc:
            w50 r6 = r14.f4216a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            boolean r6 = r6.f()     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            if (r6 == 0) goto L_0x0119
            w50 r6 = r14.f4216a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            v80 r7 = r14.f4215a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            pd0 r8 = r14.f3085a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            x50 r6 = r6.i(r7, r8)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            int r7 = r6.size()     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            if (r7 == 0) goto L_0x0119
            h70 r7 = defpackage.h70.H     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            r1.Q(r7, r6)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
        L_0x0119:
            v80 r6 = r14.f4215a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            boolean r6 = b0(r6)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            if (r6 == 0) goto L_0x0135
            h70 r6 = defpackage.h70.nb     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            k70 r7 = new k70     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            v80 r8 = r14.f4215a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            z60 r8 = r8.V()     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            int r8 = r14.T(r8)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            r7.<init>((int) r8)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            r1.Q(r6, r7)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
        L_0x0135:
            d60 r6 = r14.f4200a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            int r6 = r6.M1()     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            int r7 = r14.d     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            if (r6 > r7) goto L_0x014b
            v80 r6 = r14.f4215a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            boolean r6 = b0(r6)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            if (r6 == 0) goto L_0x0148
            goto L_0x014b
        L_0x0148:
            r14.f4200a = r3     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            goto L_0x0150
        L_0x014b:
            d60 r6 = r14.f4200a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            r6.V()     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
        L_0x0150:
            v80 r6 = r14.f4215a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            boolean r6 = b0(r6)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            if (r6 == 0) goto L_0x0163
            v80 r6 = r14.f4215a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            d60 r6 = r6.Y()     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            java.util.ArrayList r6 = r6.P0()     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            r2 = r6
        L_0x0163:
            v80 r6 = r14.f4215a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            e60 r13 = new e60     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            v80 r7 = r14.f4215a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            d60 r8 = r7.Z()     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            d60 r9 = r14.b     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            v80 r7 = r14.f4215a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            boolean r7 = b0(r7)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            if (r7 != 0) goto L_0x0179
            d60 r3 = r14.f4200a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
        L_0x0179:
            r10 = r3
            v80 r3 = r14.f4215a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            d60 r11 = r3.Y()     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            pd0 r12 = r14.f3085a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            r7 = r13
            r7.<init>(r8, r9, r10, r11, r12)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            r6.i(r1, r13)     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            w50 r3 = r14.f4216a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            r3.h()     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            v80 r3 = r14.f4215a     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            r3.C0()     // Catch:{ ih -> 0x019c, IOException -> 0x0195 }
            return r2
        L_0x0195:
            r0 = move-exception
            mj r1 = new mj
            r1.<init>(r0)
            throw r1
        L_0x019c:
            r0 = move-exception
            mj r1 = new mj
            r1.<init>(r0)
            throw r1
        L_0x01a3:
            r0 = move-exception
            mj r1 = new mj
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l60.F():java.util.ArrayList");
    }

    public boolean d(pd0 pageSize) {
        v80 v80 = this.f4215a;
        if (v80 != null && v80.f()) {
            return false;
        }
        this.f4221b = new pd0(pageSize);
        return true;
    }

    public boolean a(float marginLeft, float marginRight, float marginTop, float marginBottom) {
        v80 v80 = this.f4215a;
        if (v80 != null && v80.f()) {
            return false;
        }
        this.h = marginLeft;
        this.i = marginRight;
        this.j = marginTop;
        this.k = marginBottom;
        return true;
    }

    /* access modifiers changed from: protected */
    public void Z() {
        this.f3079a++;
        this.f4201a = new e50();
        if (b0(this.f4215a)) {
            this.b = this.f4215a.Z().c0();
            this.f4215a.Y().f2716a = this.b;
        } else {
            this.b = new d60(this.f4215a);
        }
        m0();
        this.l = -1.0f;
        b bVar = this.f4207a;
        bVar.g = 0.0f;
        bVar.d = 0.0f;
        bVar.i = 0.0f;
        bVar.h = 0.0f;
        this.g = 0.0f;
        this.f4233i = new HashMap<>(this.f4235j);
        if (!(this.f3085a.f() == null && !this.f3085a.O() && this.f3085a.i() == null)) {
            c(this.f3085a);
        }
        float oldleading = this.f;
        int oldAlignment = this.c;
        this.f4237k = true;
        try {
            tr trVar = this.f4212a;
            if (trVar != null) {
                v(trVar);
                this.f4212a = null;
            }
            this.f = oldleading;
            this.c = oldAlignment;
            E();
            a80 pageEvent = this.f4215a.j0();
            if (pageEvent != null) {
                if (this.f4236j) {
                    pageEvent.f(this.f4215a, this);
                }
                pageEvent.k(this.f4215a, this);
            }
            this.f4236j = false;
        } catch (Exception e2) {
            throw new mj(e2);
        }
    }

    /* access modifiers changed from: protected */
    public void e0() {
        this.e = -1;
        E();
        ArrayList<e70> arrayList = this.f4218b;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.f4218b.add(this.f4202a);
            this.g += this.f4202a.n();
        }
        this.f4202a = new e70(W(), X(), this.c, this.f);
    }

    /* access modifiers changed from: protected */
    public float C() {
        float tempHeight = this.f4202a.n();
        float f2 = this.f;
        if (tempHeight != f2) {
            return tempHeight + f2;
        }
        return tempHeight;
    }

    /* access modifiers changed from: protected */
    public void E() {
        if (this.f4218b == null) {
            this.f4218b = new ArrayList<>();
        }
        e70 e70 = this.f4202a;
        if (e70 != null && e70.z() > 0) {
            if (this.g + C() > Y() - V() && this.g != 0.0f) {
                e70 overflowLine = this.f4202a;
                this.f4202a = null;
                e();
                this.f4202a = overflowLine;
                overflowLine.a = W();
            }
            this.g += this.f4202a.n();
            this.f4218b.add(this.f4202a);
            this.f4237k = false;
        }
        float f2 = this.l;
        if (f2 > -1.0f && this.g > f2) {
            this.l = -1.0f;
            b bVar = this.f4207a;
            bVar.g = 0.0f;
            bVar.d = 0.0f;
        }
        this.f4202a = new e70(W(), X(), this.c, this.f);
    }

    /* access modifiers changed from: protected */
    public void G() {
        try {
            int i2 = this.e;
            if (i2 == 11 || i2 == 10) {
                e0();
                J();
            }
        } catch (ih ex) {
            throw new mj(ex);
        }
    }

    /* access modifiers changed from: protected */
    public float J() {
        if (this.f4218b == null) {
            return 0.0f;
        }
        e70 e70 = this.f4202a;
        if (e70 != null && e70.z() > 0) {
            this.f4218b.add(this.f4202a);
            this.f4202a = new e70(W(), X(), this.c, this.f);
        }
        if (this.f4218b.isEmpty()) {
            return 0.0f;
        }
        Object[] currentValues = new Object[2];
        currentValues[1] = new Float(0.0f);
        Iterator i$ = this.f4218b.iterator();
        r60 currentFont = null;
        float displacement = 0.0f;
        while (i$.hasNext()) {
            e70 l2 = i$.next();
            float o = l2.o() - W();
            b bVar = this.f4207a;
            float moveTextX = o + bVar.a + bVar.c + bVar.b;
            this.f4200a.t0(moveTextX, -l2.n());
            l2.d();
            if (l2.u() != null) {
                com.itextpdf.text.a symbol = l2.u();
                if (!b0(this.f4215a)) {
                    ia.U(this.b, 0, new com.itextpdf.text.d(symbol), this.f4200a.n0() - l2.s(), this.f4200a.o0(), 0.0f);
                    if (0 != 0) {
                        this.b.H((br) null);
                    }
                } else {
                    l2.t().i0();
                    throw null;
                }
            }
            currentValues[0] = currentFont;
            if (b0(this.f4215a)) {
                l2.t();
            }
            o0(l2, this.f4200a, this.b, currentValues, this.f4215a.p0());
            currentFont = (r60) currentValues[0];
            displacement += l2.n();
            this.f4200a.t0(-moveTextX, 0.0f);
        }
        this.f4218b = new ArrayList<>();
        return displacement;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v0, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v0, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v2, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r39v0, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r38v0, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v0, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r60v0, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v0, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r54v2, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v4, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r54v3, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r54v5, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r54v6, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v27, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v9, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v16, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: w5} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r60v1, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v2, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r60v2, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v3, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v11, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v21, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r60v3, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v22, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r52v0, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v5, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r43v2, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v25, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v42, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r60v4, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v23, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: float[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v21, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v6, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v43, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v33, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r62v5, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r63v5, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r60v5, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v8, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v24, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v12, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v34, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v33, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v34, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v35, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v35, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v38, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v39, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v40, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v44, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v44, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v45, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v31, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v45, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v50, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v51, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v46, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v47, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v42, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v49, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v50, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r48v9, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v43, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v62, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v63, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v64, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r57v1, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v26, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r59v6, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r57v2, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v66, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v46, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v47, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v48, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v49, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v57, resolved type: w5} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v18, resolved type: float[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r46v3, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r47v7, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v93, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v40, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v50, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v54, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v11, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v63, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v64, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v65, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v17, resolved type: float[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v20, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v12, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v19, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v21, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v22, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r47v9, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v70, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v23, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r46v5, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v24, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r46v6, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v66, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v68, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v25, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v27, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v45, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r44v6, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v28, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v29, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r44v7, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r44v8, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v37, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v47, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r44v9, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r52v2, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v48, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r48v15, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r49v3, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v64, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v5, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v39, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v49, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r54v13, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v10, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v11, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v1, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r39v1, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r38v1, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r37v2, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r38v2, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r39v2, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v17, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v51, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v1, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v2, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v18, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v52, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v2, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v3, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v15, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v18, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v68, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v132, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v4, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v3, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v21, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v54, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v9, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v24, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v56, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v4, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v10, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v5, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v18, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v29, resolved type: float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v57, resolved type: float} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x085f  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x089b  */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x089f  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x08a7  */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x08ae  */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x08b7  */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x08c9  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x09e6  */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x09eb  */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x09f0  */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x09f6  */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x09ff  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a13  */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x0a16  */
    /* JADX WARNING: Removed duplicated region for block: B:334:0x0a20  */
    /* JADX WARNING: Removed duplicated region for block: B:353:0x0a8e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public float o0(defpackage.e70 r71, defpackage.d60 r72, defpackage.d60 r73, java.lang.Object[] r74, float r75) {
        /*
            r70 = this;
            r7 = r70
            r8 = r71
            r9 = r72
            r14 = r73
            r15 = 0
            r0 = r74[r15]
            r60 r0 = (defpackage.r60) r0
            r12 = 1
            r1 = r74[r12]
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            r2 = 0
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 2143289344(0x7fc00000, float:NaN)
            r5 = 0
            r6 = 0
            r10 = 0
            float r11 = r72.n0()
            float r13 = r71.k()
            float r11 = r11 + r13
            int r13 = r71.v()
            int r15 = r71.i()
            boolean r17 = r71.m()
            if (r17 == 0) goto L_0x003c
            if (r13 != 0) goto L_0x0039
            if (r15 <= r12) goto L_0x003c
        L_0x0039:
            r17 = 1
            goto L_0x003e
        L_0x003c:
            r17 = 0
        L_0x003e:
            r26 = r17
            int r12 = r71.l()
            r18 = r10
            if (r12 <= 0) goto L_0x0061
            float r20 = r71.A()
            float r10 = (float) r12
            float r10 = r20 / r10
            r20 = r0
            r27 = r1
            r28 = r2
            r25 = r3
            r29 = r11
            r11 = r5
            r69 = r10
            r10 = r6
            r6 = r69
            goto L_0x0151
        L_0x0061:
            if (r26 == 0) goto L_0x0127
            if (r12 != 0) goto L_0x0127
            boolean r10 = r71.p()
            if (r10 == 0) goto L_0x00ab
            float r10 = r71.A()
            r20 = r0
            float r0 = (float) r13
            float r0 = r0 * r75
            r22 = r2
            float r2 = (float) r15
            float r0 = r0 + r2
            r2 = 1065353216(0x3f800000, float:1.0)
            float r0 = r0 - r2
            float r0 = r0 * r1
            int r0 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x00af
            boolean r0 = r71.q()
            if (r0 == 0) goto L_0x009a
            float r0 = r71.A()
            float r2 = (float) r13
            float r2 = r2 * r75
            float r10 = (float) r15
            float r2 = r2 + r10
            r10 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 - r10
            float r2 = r2 * r1
            float r0 = r0 - r2
            r2 = 0
            r9.t0(r0, r2)
        L_0x009a:
            float r5 = r75 * r1
            r6 = r1
            r27 = r1
            r25 = r3
            r10 = r6
            r29 = r11
            r6 = r18
            r28 = r22
            r11 = r5
            goto L_0x0151
        L_0x00ab:
            r20 = r0
            r22 = r2
        L_0x00af:
            float r0 = r71.A()
            int r2 = r71.z()
            r10 = 1
            int r2 = r2 - r10
            b60 r2 = r8.f(r2)
            if (r2 == 0) goto L_0x0106
            java.lang.String r10 = r2.toString()
            int r23 = r10.length()
            if (r23 <= 0) goto L_0x00ff
            int r23 = r10.length()
            r24 = r1
            r17 = 1
            int r1 = r23 + -1
            char r1 = r10.charAt(r1)
            r23 = r1
            r25 = r3
            java.lang.String r3 = ".,;:'"
            int r1 = r3.indexOf(r1)
            if (r1 < 0) goto L_0x00fa
            r1 = r0
            r60 r3 = r2.d()
            r27 = r2
            r2 = r23
            float r3 = r3.i(r2)
            r23 = 1053609165(0x3ecccccd, float:0.4)
            float r3 = r3 * r23
            float r0 = r0 + r3
            float r3 = r0 - r1
            r2 = r3
            goto L_0x010e
        L_0x00fa:
            r27 = r2
            r2 = r23
            goto L_0x010c
        L_0x00ff:
            r24 = r1
            r27 = r2
            r25 = r3
            goto L_0x010c
        L_0x0106:
            r24 = r1
            r27 = r2
            r25 = r3
        L_0x010c:
            r2 = r22
        L_0x010e:
            float r1 = (float) r13
            float r1 = r1 * r75
            float r3 = (float) r15
            float r1 = r1 + r3
            r3 = 1065353216(0x3f800000, float:1.0)
            float r1 = r1 - r3
            float r1 = r0 / r1
            float r5 = r75 * r1
            r6 = r1
            r27 = r1
            r28 = r2
            r10 = r6
            r29 = r11
            r6 = r18
            r11 = r5
            goto L_0x0151
        L_0x0127:
            r20 = r0
            r24 = r1
            r22 = r2
            r25 = r3
            int r0 = r8.f2866a
            if (r0 == 0) goto L_0x0142
            r1 = -1
            if (r0 != r1) goto L_0x0137
            goto L_0x0142
        L_0x0137:
            r10 = r6
            r29 = r11
            r6 = r18
            r28 = r22
            r27 = r24
            r11 = r5
            goto L_0x0151
        L_0x0142:
            float r0 = r71.A()
            float r11 = r11 - r0
            r10 = r6
            r29 = r11
            r6 = r18
            r28 = r22
            r27 = r24
            r11 = r5
        L_0x0151:
            int r5 = r71.h()
            r0 = 0
            float r1 = r72.n0()
            r30 = r1
            float r3 = r72.o0()
            r2 = 0
            r18 = 0
            r22 = 0
            java.util.Iterator r31 = r71.r()
            r32 = r2
            r33 = r4
            r4 = r20
            r2 = r0
            r20 = r18
            r18 = r1
        L_0x0174:
            boolean r0 = r31.hasNext()
            if (r0 == 0) goto L_0x0a64
            java.lang.Object r0 = r31.next()
            r1 = r0
            b60 r1 = (defpackage.b60) r1
            v80 r0 = r7.f4215a
            boolean r0 = b0(r0)
            if (r0 == 0) goto L_0x0194
            br r0 = r1.f180a
            if (r0 == 0) goto L_0x0194
            r9.x0(r0)
            r0 = 1
            r34 = r0
            goto L_0x0196
        L_0x0194:
            r34 = r22
        L_0x0196:
            w5 r0 = r1.c()
            r60 r22 = r1.d()
            r23 = r0
            float r0 = r22.g()
            boolean r22 = r1.x()
            r24 = r15
            if (r22 == 0) goto L_0x01bf
            float r22 = r1.t()
            float r0 = r1.t()
            r35 = 0
            r37 = r0
            r36 = r4
            r38 = r22
            r39 = r35
            goto L_0x01e1
        L_0x01bf:
            r60 r22 = r1.d()
            y5 r15 = r22.c()
            r36 = r4
            r4 = 1
            float r22 = r15.l(r4, r0)
            r60 r4 = r1.d()
            y5 r4 = r4.c()
            r15 = 3
            float r4 = r4.l(r15, r0)
            r37 = r0
            r39 = r4
            r38 = r22
        L_0x01e1:
            r15 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r4 = "HSCALE"
            java.lang.String r0 = "SKEW"
            r22 = r15
            java.lang.String r15 = "WORD_SPACING"
            r40 = r12
            java.lang.String r12 = "CHAR_SPACING"
            r41 = r13
            if (r2 > r5) goto L_0x07f7
            if (r26 == 0) goto L_0x01fa
            float r25 = r1.r(r10, r11)
            goto L_0x01fe
        L_0x01fa:
            float r25 = r1.N()
        L_0x01fe:
            boolean r42 = r1.B()
            if (r42 == 0) goto L_0x07c8
            int r13 = r2 + 1
            b60 r13 = r8.f(r13)
            boolean r43 = r1.z()
            if (r43 == 0) goto L_0x0282
            r25 = r6
            r43 = r0
            java.lang.String r0 = "SEPARATOR"
            java.lang.Object r0 = r1.e(r0)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            r44 = r0
            r0 = 0
            r45 = r44[r0]
            xh r45 = (defpackage.xh) r45
            r0 = 1
            r46 = r44[r0]
            java.lang.Boolean r46 = (java.lang.Boolean) r46
            boolean r0 = r46.booleanValue()
            if (r0 == 0) goto L_0x025d
            float r47 = r3 + r39
            float r0 = r71.k()
            float r48 = r30 + r0
            float r49 = r38 - r39
            r50 = r23
            r8 = r43
            r0 = r45
            r43 = r1
            r1 = r73
            r51 = r2
            r2 = r30
            r52 = r3
            r3 = r47
            r23 = r11
            r53 = r36
            r11 = r4
            r4 = r48
            r36 = r5
            r5 = r49
            r54 = r6
            r6 = r52
            r0.a(r1, r2, r3, r4, r5, r6)
            goto L_0x0294
        L_0x025d:
            r51 = r2
            r52 = r3
            r54 = r6
            r50 = r23
            r53 = r36
            r8 = r43
            r43 = r1
            r36 = r5
            r23 = r11
            r11 = r4
            r6 = r52
            float r3 = r6 + r39
            float r4 = r18 + r25
            float r5 = r38 - r39
            r0 = r45
            r1 = r73
            r2 = r18
            r0.a(r1, r2, r3, r4, r5, r6)
            goto L_0x0294
        L_0x0282:
            r8 = r0
            r43 = r1
            r51 = r2
            r52 = r3
            r54 = r6
            r50 = r23
            r53 = r36
            r36 = r5
            r23 = r11
            r11 = r4
        L_0x0294:
            boolean r0 = r43.C()
            if (r0 == 0) goto L_0x0323
            java.lang.String r0 = "TABSETTINGS"
            r6 = r43
            boolean r0 = r6.u(r0)
            if (r0 == 0) goto L_0x02db
            com.itextpdf.text.e r43 = r6.n()
            if (r43 == 0) goto L_0x02d5
            float r0 = r43.d()
            float r20 = r0 + r30
            xh r0 = r43.c()
            if (r0 == 0) goto L_0x02d1
            xh r0 = r43.c()
            r5 = r52
            float r3 = r5 + r39
            float r44 = r38 - r39
            r1 = r73
            r2 = r18
            r4 = r20
            r5 = r44
            r44 = r10
            r10 = r6
            r6 = r52
            r0.a(r1, r2, r3, r4, r5, r6)
            goto L_0x02da
        L_0x02d1:
            r44 = r10
            r10 = r6
            goto L_0x02da
        L_0x02d5:
            r44 = r10
            r10 = r6
            r20 = r18
        L_0x02da:
            goto L_0x0318
        L_0x02db:
            r44 = r10
            r10 = r6
            java.lang.String r0 = "TAB"
            java.lang.Object r0 = r10.e(r0)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            r43 = r0
            r0 = 0
            r1 = r43[r0]
            r45 = r1
            xh r45 = (defpackage.xh) r45
            r0 = 1
            r1 = r43[r0]
            java.lang.Float r1 = (java.lang.Float) r1
            float r0 = r1.floatValue()
            r1 = 3
            r2 = r43[r1]
            java.lang.Float r2 = (java.lang.Float) r2
            float r1 = r2.floatValue()
            float r20 = r0 + r1
            int r0 = (r20 > r18 ? 1 : (r20 == r18 ? 0 : -1))
            if (r0 <= 0) goto L_0x0318
            r6 = r52
            float r3 = r6 + r39
            float r5 = r38 - r39
            r0 = r45
            r1 = r73
            r2 = r18
            r4 = r20
            r0.a(r1, r2, r3, r4, r5, r6)
        L_0x0318:
            r0 = r18
            r18 = r20
            r20 = r0
            r6 = r18
            r43 = r20
            goto L_0x032b
        L_0x0323:
            r44 = r10
            r10 = r43
            r6 = r18
            r43 = r20
        L_0x032b:
            java.lang.String r0 = "BACKGROUND"
            boolean r1 = r10.u(r0)
            if (r1 == 0) goto L_0x03c7
            java.lang.Object r1 = r10.e(r0)
            java.lang.Object[] r1 = (java.lang.Object[]) r1
            r2 = 0
            r3 = r1[r2]
            if (r3 == 0) goto L_0x03c0
            boolean r2 = r73.f0()
            if (r2 == 0) goto L_0x034f
            v80 r3 = r7.f4215a
            boolean r3 = b0(r3)
            if (r3 == 0) goto L_0x034f
            r73.V()
        L_0x034f:
            r73.Q0()
            r3 = r27
            if (r13 == 0) goto L_0x035d
            boolean r0 = r13.u(r0)
            if (r0 == 0) goto L_0x035d
            r3 = 0
        L_0x035d:
            if (r13 != 0) goto L_0x0361
            float r3 = r3 + r28
        L_0x0361:
            r0 = 0
            r4 = r1[r0]
            w5 r4 = (defpackage.w5) r4
            r14.U0(r4)
            r5 = 1
            r16 = r1[r5]
            float[] r16 = (float[]) r16
            r18 = r16
            r16 = r18[r0]
            float r0 = r6 - r16
            r45 = r12
            r12 = r52
            float r16 = r12 + r39
            r20 = r18[r5]
            float r16 = r16 - r20
            float r20 = r10.p()
            float r5 = r16 + r20
            float r20 = r25 - r3
            r16 = 0
            r17 = r18[r16]
            float r20 = r20 + r17
            r17 = 2
            r47 = r18[r17]
            r48 = r1
            float r1 = r20 + r47
            float r20 = r38 - r39
            r17 = 1
            r46 = r18[r17]
            float r20 = r20 + r46
            r35 = 3
            r46 = r18[r35]
            r47 = r3
            float r3 = r20 + r46
            r14.B0(r0, r5, r1, r3)
            r73.Z()
            r0 = 0
            r14.e1(r0)
            r73.K0()
            if (r2 == 0) goto L_0x03cb
            v80 r0 = r7.f4215a
            boolean r0 = b0(r0)
            if (r0 == 0) goto L_0x03cb
            r0 = 1
            r14.B(r0)
            goto L_0x03cb
        L_0x03c0:
            r48 = r1
            r45 = r12
            r12 = r52
            goto L_0x03cb
        L_0x03c7:
            r45 = r12
            r12 = r52
        L_0x03cb:
            java.lang.String r0 = "UNDERLINE"
            boolean r1 = r10.u(r0)
            r18 = 4
            if (r1 == 0) goto L_0x048b
            boolean r1 = r73.f0()
            if (r1 == 0) goto L_0x03e6
            v80 r2 = r7.f4215a
            boolean r2 = b0(r2)
            if (r2 == 0) goto L_0x03e6
            r73.V()
        L_0x03e6:
            r2 = r27
            if (r13 == 0) goto L_0x03f1
            boolean r3 = r13.u(r0)
            if (r3 == 0) goto L_0x03f1
            r2 = 0
        L_0x03f1:
            if (r13 != 0) goto L_0x03f5
            float r2 = r2 + r28
        L_0x03f5:
            java.lang.Object r0 = r10.e(r0)
            java.lang.Object[][] r0 = (java.lang.Object[][]) r0
            r3 = 0
            r4 = 0
        L_0x03fd:
            int r5 = r0.length
            if (r4 >= r5) goto L_0x0473
            r5 = r0[r4]
            r16 = 0
            r20 = r5[r16]
            r3 = r20
            w5 r3 = (defpackage.w5) r3
            r17 = 1
            r20 = r5[r17]
            float[] r20 = (float[]) r20
            if (r3 != 0) goto L_0x0414
            r3 = r50
        L_0x0414:
            if (r3 == 0) goto L_0x0419
            r14.Y0(r3)
        L_0x0419:
            r16 = 0
            r46 = r20[r16]
            r60 r47 = r10.d()
            float r47 = r47.g()
            r17 = 1
            r48 = r20[r17]
            float r47 = r47 * r48
            r48 = r0
            float r0 = r46 + r47
            r14.p1(r0)
            r0 = 2
            r46 = r20[r0]
            r60 r0 = r10.d()
            float r0 = r0.g()
            r35 = 3
            r47 = r20[r35]
            float r0 = r0 * r47
            float r46 = r46 + r0
            r0 = r20[r18]
            int r0 = (int) r0
            if (r0 == 0) goto L_0x044d
            r14.g1(r0)
        L_0x044d:
            r47 = r5
            float r5 = r12 + r46
            r14.v0(r6, r5)
            float r5 = r6 + r25
            float r5 = r5 - r2
            r49 = r2
            float r2 = r12 + r46
            r14.s0(r5, r2)
            r73.O1()
            if (r3 == 0) goto L_0x0466
            r73.G0()
        L_0x0466:
            if (r0 == 0) goto L_0x046c
            r2 = 0
            r14.g1(r2)
        L_0x046c:
            int r4 = r4 + 1
            r0 = r48
            r2 = r49
            goto L_0x03fd
        L_0x0473:
            r48 = r0
            r49 = r2
            r5 = 1065353216(0x3f800000, float:1.0)
            r14.p1(r5)
            if (r1 == 0) goto L_0x048d
            v80 r0 = r7.f4215a
            boolean r0 = b0(r0)
            if (r0 == 0) goto L_0x048d
            r0 = 1
            r14.B(r0)
            goto L_0x048d
        L_0x048b:
            r5 = 1065353216(0x3f800000, float:1.0)
        L_0x048d:
            java.lang.String r0 = "ACTION"
            boolean r1 = r10.u(r0)
            if (r1 == 0) goto L_0x053b
            r1 = r27
            if (r13 == 0) goto L_0x04a0
            boolean r2 = r13.u(r0)
            if (r2 == 0) goto L_0x04a0
            r1 = 0
        L_0x04a0:
            if (r13 != 0) goto L_0x04a4
            float r1 = r1 + r28
        L_0x04a4:
            r2 = 0
            boolean r3 = r10.x()
            if (r3 == 0) goto L_0x04d5
            v80 r3 = r7.f4215a
            float r4 = r10.j()
            float r57 = r12 + r4
            float r4 = r6 + r25
            float r58 = r4 - r1
            float r4 = r10.h()
            float r4 = r4 + r12
            float r19 = r10.j()
            float r59 = r4 + r19
            java.lang.Object r0 = r10.e(r0)
            r60 = r0
            u50 r60 = (defpackage.u50) r60
            r61 = 0
            r55 = r3
            r56 = r6
            v50 r0 = r55.K(r56, r57, r58, r59, r60, r61)
            goto L_0x04fd
        L_0x04d5:
            v80 r3 = r7.f4215a
            float r4 = r12 + r39
            float r19 = r10.p()
            float r57 = r4 + r19
            float r4 = r6 + r25
            float r58 = r4 - r1
            float r4 = r12 + r38
            float r19 = r10.p()
            float r59 = r4 + r19
            java.lang.Object r0 = r10.e(r0)
            r60 = r0
            u50 r60 = (defpackage.u50) r60
            r61 = 0
            r55 = r3
            r56 = r6
            v50 r0 = r55.K(r56, r57, r58, r59, r60, r61)
        L_0x04fd:
            r2 = 1
            r9.f(r0, r2)
            v80 r2 = r7.f4215a
            boolean r2 = b0(r2)
            if (r2 == 0) goto L_0x053b
            br r2 = r10.f180a
            if (r2 == 0) goto L_0x053b
            g0 r2 = r2.s()
            o80 r2 = r7.Q(r2)
            if (r2 == 0) goto L_0x053b
            int r3 = r7.T(r0)
            h70 r4 = defpackage.h70.mb
            k70 r5 = new k70
            r5.<init>((int) r3)
            r0.Q(r4, r5)
            v80 r4 = r7.f4215a
            z60 r4 = r4.V()
            r2.b0(r0, r4)
            v80 r4 = r7.f4215a
            p80 r4 = r4.r0()
            z60 r5 = r2.Y()
            r4.Y(r3, r5)
        L_0x053b:
            java.lang.String r0 = "REMOTEGOTO"
            boolean r1 = r10.u(r0)
            if (r1 == 0) goto L_0x05bd
            r1 = r27
            if (r13 == 0) goto L_0x054e
            boolean r2 = r13.u(r0)
            if (r2 == 0) goto L_0x054e
            r1 = 0
        L_0x054e:
            if (r13 != 0) goto L_0x0555
            float r1 = r1 + r28
            r20 = r1
            goto L_0x0557
        L_0x0555:
            r20 = r1
        L_0x0557:
            java.lang.Object r0 = r10.e(r0)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            r46 = r0
            r0 = 0
            r1 = r46[r0]
            r47 = r1
            java.lang.String r47 = (java.lang.String) r47
            r0 = 1
            r1 = r46[r0]
            boolean r1 = r1 instanceof java.lang.String
            if (r1 == 0) goto L_0x0594
            r1 = r46[r0]
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2
            float r3 = r12 + r39
            float r0 = r10.p()
            float r4 = r3 + r0
            float r0 = r6 + r25
            float r5 = r0 - r20
            float r3 = r12 + r38
            float r0 = r10.p()
            float r48 = r3 + r0
            r0 = r70
            r1 = r47
            r3 = r6
            r19 = 1065353216(0x3f800000, float:1.0)
            r14 = r6
            r6 = r48
            r0.j0(r1, r2, r3, r4, r5, r6)
            goto L_0x05c0
        L_0x0594:
            r14 = r6
            r19 = 1065353216(0x3f800000, float:1.0)
            r0 = 1
            r1 = r46[r0]
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r2 = r1.intValue()
            float r3 = r12 + r39
            float r0 = r10.p()
            float r4 = r3 + r0
            float r6 = r14 + r25
            float r5 = r6 - r20
            float r3 = r12 + r38
            float r0 = r10.p()
            float r6 = r3 + r0
            r0 = r70
            r1 = r47
            r3 = r14
            r0.i0(r1, r2, r3, r4, r5, r6)
            goto L_0x05c0
        L_0x05bd:
            r14 = r6
            r19 = 1065353216(0x3f800000, float:1.0)
        L_0x05c0:
            java.lang.String r0 = "LOCALGOTO"
            boolean r1 = r10.u(r0)
            if (r1 == 0) goto L_0x05ee
            r1 = r27
            if (r13 == 0) goto L_0x05d3
            boolean r2 = r13.u(r0)
            if (r2 == 0) goto L_0x05d3
            r1 = 0
        L_0x05d3:
            if (r13 != 0) goto L_0x05d9
            float r1 = r1 + r28
            r6 = r1
            goto L_0x05da
        L_0x05d9:
            r6 = r1
        L_0x05da:
            java.lang.Object r0 = r10.e(r0)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            float r0 = r14 + r25
            float r4 = r0 - r6
            float r5 = r12 + r37
            r0 = r70
            r2 = r14
            r3 = r12
            r0.d0(r1, r2, r3, r4, r5)
        L_0x05ee:
            java.lang.String r0 = "LOCALDESTINATION"
            boolean r1 = r10.u(r0)
            if (r1 == 0) goto L_0x0609
            java.lang.Object r0 = r10.e(r0)
            java.lang.String r0 = (java.lang.String) r0
            h60 r1 = new h60
            float r3 = r12 + r37
            r2 = 0
            r6 = 0
            r1.<init>(r2, r14, r3, r6)
            r7.c0(r0, r1)
            goto L_0x060a
        L_0x0609:
            r6 = 0
        L_0x060a:
            java.lang.String r0 = "GENERICTAG"
            boolean r1 = r10.u(r0)
            if (r1 == 0) goto L_0x063e
            r1 = r27
            if (r13 == 0) goto L_0x061d
            boolean r2 = r13.u(r0)
            if (r2 == 0) goto L_0x061d
            r1 = 0
        L_0x061d:
            if (r13 != 0) goto L_0x0621
            float r1 = r1 + r28
        L_0x0621:
            pd0 r2 = new pd0
            float r3 = r14 + r25
            float r3 = r3 - r1
            float r4 = r12 + r37
            r2.<init>(r14, r12, r3, r4)
            v80 r3 = r7.f4215a
            a80 r3 = r3.j0()
            if (r3 == 0) goto L_0x063e
            v80 r4 = r7.f4215a
            java.lang.Object r0 = r10.e(r0)
            java.lang.String r0 = (java.lang.String) r0
            r3.a(r4, r7, r2, r0)
        L_0x063e:
            java.lang.String r0 = "PDFANNOTATION"
            boolean r1 = r10.u(r0)
            if (r1 == 0) goto L_0x0674
            r1 = r27
            if (r13 == 0) goto L_0x0651
            boolean r2 = r13.u(r0)
            if (r2 == 0) goto L_0x0651
            r1 = 0
        L_0x0651:
            if (r13 != 0) goto L_0x0655
            float r1 = r1 + r28
        L_0x0655:
            java.lang.Object r0 = r10.e(r0)
            v50 r0 = (defpackage.v50) r0
            v50 r0 = defpackage.s60.h0(r0)
            h70 r2 = defpackage.h70.E9
            f80 r3 = new f80
            float r4 = r12 + r39
            float r5 = r14 + r25
            float r5 = r5 - r1
            float r6 = r12 + r38
            r3.<init>(r14, r4, r5, r6)
            r0.Q(r2, r3)
            r2 = 1
            r9.f(r0, r2)
        L_0x0674:
            java.lang.Object r0 = r10.e(r8)
            float[] r0 = (float[]) r0
            r46 = r0
            java.lang.Object r0 = r10.e(r11)
            r47 = r0
            java.lang.Float r47 = (java.lang.Float) r47
            if (r46 != 0) goto L_0x068e
            if (r47 == 0) goto L_0x0689
            goto L_0x068e
        L_0x0689:
            r0 = r22
            r21 = 0
            goto L_0x06bc
        L_0x068e:
            r0 = 0
            r1 = 0
            if (r46 == 0) goto L_0x069d
            r2 = 0
            r0 = r46[r2]
            r2 = 1
            r1 = r46[r2]
            r20 = r0
            r48 = r1
            goto L_0x06a1
        L_0x069d:
            r20 = r0
            r48 = r1
        L_0x06a1:
            if (r47 == 0) goto L_0x06a9
            float r0 = r47.floatValue()
            r22 = r0
        L_0x06a9:
            r4 = 1065353216(0x3f800000, float:1.0)
            r0 = r72
            r1 = r22
            r2 = r20
            r3 = r48
            r5 = r14
            r21 = 0
            r6 = r12
            r0.E1(r1, r2, r3, r4, r5, r6)
            r0 = r22
        L_0x06bc:
            if (r26 != 0) goto L_0x06e7
            boolean r1 = r10.u(r15)
            if (r1 == 0) goto L_0x06d1
            java.lang.Object r1 = r10.e(r15)
            java.lang.Float r1 = (java.lang.Float) r1
            float r2 = r1.floatValue()
            r9.I1(r2)
        L_0x06d1:
            r1 = r45
            boolean r2 = r10.u(r1)
            if (r2 == 0) goto L_0x06e9
            java.lang.Object r2 = r10.e(r1)
            java.lang.Float r2 = (java.lang.Float) r2
            float r3 = r2.floatValue()
            r9.T0(r3)
            goto L_0x06e9
        L_0x06e7:
            r1 = r45
        L_0x06e9:
            boolean r2 = r10.x()
            if (r2 == 0) goto L_0x07a0
            tr r2 = r10.g()
            float r3 = r10.l()
            float r4 = r10.k()
            float[] r4 = r2.X0(r4)
            float r5 = r10.i()
            float r6 = r14 + r5
            r5 = r4[r18]
            float r6 = r6 - r5
            r4[r18] = r6
            float r5 = r10.j()
            float r5 = r5 + r12
            r6 = 5
            r20 = r4[r6]
            float r5 = r5 - r20
            r4[r6] = r5
            r5 = 0
            boolean r20 = r73.f0()
            if (r20 == 0) goto L_0x0725
            boolean r6 = r2 instanceof defpackage.yr
            if (r6 != 0) goto L_0x0725
            r5 = 1
            r73.V()
        L_0x0725:
            r45 = r0
            r6 = 0
            r0 = r4[r6]
            double r6 = (double) r0
            r17 = r1
            r0 = 1
            r1 = r4[r0]
            double r0 = (double) r1
            r42 = r3
            r25 = 2
            r3 = r4[r25]
            r48 = r8
            double r8 = (double) r3
            r35 = r10
            r3 = 3
            r10 = r4[r3]
            r55 = r8
            double r8 = (double) r10
            r10 = r4[r18]
            r57 = r8
            double r8 = (double) r10
            r10 = 5
            r10 = r4[r10]
            r49 = r4
            double r3 = (double) r10
            r52 = 0
            r59 = r35
            r62 = r44
            r10 = r73
            r64 = r11
            r63 = r23
            r11 = r2
            r60 = r12
            r44 = r13
            r65 = r17
            r35 = r41
            r41 = r2
            r2 = 1
            r12 = r6
            r6 = r73
            r66 = r14
            r67 = r15
            r7 = r24
            r68 = 3
            r14 = r0
            r16 = r55
            r18 = r57
            r20 = r8
            r22 = r3
            r24 = r52
            r25 = r34
            r10.k(r11, r12, r14, r16, r18, r20, r22, r24, r25)
            if (r5 == 0) goto L_0x0785
            r6.B(r2)
        L_0x0785:
            float r0 = r66 + r27
            float r1 = r59.l()
            float r0 = r0 + r1
            float r1 = r72.n0()
            float r0 = r0 - r1
            r1 = r72
            r3 = 0
            r1.t0(r0, r3)
            r25 = r42
            r20 = r43
            r15 = r45
            r18 = r66
            goto L_0x07ee
        L_0x07a0:
            r6 = r73
            r45 = r0
            r65 = r1
            r48 = r8
            r1 = r9
            r59 = r10
            r64 = r11
            r60 = r12
            r66 = r14
            r67 = r15
            r63 = r23
            r7 = r24
            r35 = r41
            r62 = r44
            r2 = 1
            r3 = 0
            r68 = 3
            r44 = r13
            r20 = r43
            r15 = r45
            r18 = r66
            goto L_0x07ee
        L_0x07c8:
            r48 = r0
            r59 = r1
            r51 = r2
            r60 = r3
            r64 = r4
            r54 = r6
            r1 = r9
            r62 = r10
            r63 = r11
            r65 = r12
            r6 = r14
            r67 = r15
            r50 = r23
            r7 = r24
            r53 = r36
            r35 = r41
            r2 = 1
            r3 = 0
            r68 = 3
            r36 = r5
            r15 = r22
        L_0x07ee:
            float r18 = r18 + r25
            int r0 = r51 + 1
            r25 = r15
            r4 = r18
            goto L_0x0821
        L_0x07f7:
            r48 = r0
            r59 = r1
            r51 = r2
            r60 = r3
            r64 = r4
            r54 = r6
            r1 = r9
            r62 = r10
            r63 = r11
            r65 = r12
            r6 = r14
            r67 = r15
            r50 = r23
            r7 = r24
            r53 = r36
            r35 = r41
            r2 = 1
            r3 = 0
            r68 = 3
            r36 = r5
            r4 = r18
            r25 = r22
            r0 = r51
        L_0x0821:
            boolean r5 = r59.x()
            if (r5 != 0) goto L_0x0843
            r60 r5 = r59.d()
            r8 = r53
            int r5 = r5.compareTo(r8)
            if (r5 == 0) goto L_0x0845
            r60 r5 = r59.d()
            y5 r8 = r5.c()
            float r9 = r5.g()
            r1.c1(r8, r9)
            goto L_0x0846
        L_0x0843:
            r8 = r53
        L_0x0845:
            r5 = r8
        L_0x0846:
            r8 = 0
            java.lang.String r9 = "TEXTRENDERMODE"
            r10 = r59
            java.lang.Object r9 = r10.e(r9)
            java.lang.Object[] r9 = (java.lang.Object[]) r9
            r11 = 0
            r12 = 1065353216(0x3f800000, float:1.0)
            r13 = 0
            java.lang.String r14 = "SUBSUPSCRIPT"
            java.lang.Object r14 = r10.e(r14)
            java.lang.Float r14 = (java.lang.Float) r14
            if (r9 == 0) goto L_0x089b
            r15 = 0
            r16 = r9[r15]
            java.lang.Integer r16 = (java.lang.Integer) r16
            int r16 = r16.intValue()
            r11 = r16 & 3
            if (r11 == 0) goto L_0x086f
            r1.F1(r11)
        L_0x086f:
            if (r11 == r2) goto L_0x0878
            r15 = 2
            if (r11 != r15) goto L_0x0875
            goto L_0x0878
        L_0x0875:
            r15 = 1065353216(0x3f800000, float:1.0)
            goto L_0x089d
        L_0x0878:
            r15 = r9[r2]
            java.lang.Float r15 = (java.lang.Float) r15
            float r12 = r15.floatValue()
            r15 = 1065353216(0x3f800000, float:1.0)
            int r16 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r16 == 0) goto L_0x0889
            r1.p1(r12)
        L_0x0889:
            r16 = 2
            r16 = r9[r16]
            r13 = r16
            w5 r13 = (defpackage.w5) r13
            if (r13 != 0) goto L_0x0895
            r13 = r50
        L_0x0895:
            if (r13 == 0) goto L_0x089d
            r1.Y0(r13)
            goto L_0x089d
        L_0x089b:
            r15 = 1065353216(0x3f800000, float:1.0)
        L_0x089d:
            if (r14 == 0) goto L_0x08a3
            float r8 = r14.floatValue()
        L_0x08a3:
            r2 = r50
            if (r2 == 0) goto L_0x08aa
            r1.U0(r2)
        L_0x08aa:
            int r16 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r16 == 0) goto L_0x08b1
            r1.H1(r8)
        L_0x08b1:
            boolean r16 = r10.x()
            if (r16 == 0) goto L_0x08c9
            r32 = 1
            r16 = r0
            r19 = r5
            r24 = r7
            r18 = r9
            r22 = r14
            r0 = r62
            r5 = r63
            goto L_0x09e1
        L_0x08c9:
            boolean r16 = r10.w()
            r18 = 1148846080(0x447a0000, float:1000.0)
            if (r16 == 0) goto L_0x08f3
            r80 r16 = new r80
            r16.<init>()
            r19 = r16
            r15 = r54
            float r3 = -r15
            float r3 = r3 * r18
            r16 = r0
            r60 r0 = r10.f184a
            float r0 = r0.g()
            float r3 = r3 / r0
            float r3 = r3 / r25
            r0 = r19
            r0.a(r3)
            r1.J1(r0)
            r19 = r5
            goto L_0x091c
        L_0x08f3:
            r16 = r0
            r15 = r54
            boolean r0 = r10.C()
            if (r0 == 0) goto L_0x092a
            int r0 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x092a
            r80 r0 = new r80
            r0.<init>()
            float r3 = r20 - r4
            float r3 = r3 * r18
            r19 = r5
            r60 r5 = r10.f184a
            float r5 = r5.g()
            float r3 = r3 / r5
            float r3 = r3 / r25
            r0.a(r3)
            r1.J1(r0)
        L_0x091c:
            r24 = r7
            r18 = r9
            r22 = r14
            r54 = r15
            r0 = r62
            r5 = r63
            goto L_0x09e1
        L_0x092a:
            r19 = r5
            if (r26 == 0) goto L_0x09b7
            if (r35 <= 0) goto L_0x09b7
            boolean r0 = r10.A()
            if (r0 == 0) goto L_0x09b7
            int r0 = (r25 > r33 ? 1 : (r25 == r33 ? 0 : -1))
            if (r0 == 0) goto L_0x0951
            r33 = r25
            r5 = r63
            float r0 = r5 / r25
            r1.I1(r0)
            r0 = r62
            float r3 = r0 / r25
            float r21 = r72.a0()
            float r3 = r3 + r21
            r1.T0(r3)
            goto L_0x0955
        L_0x0951:
            r0 = r62
            r5 = r63
        L_0x0955:
            java.lang.String r3 = r10.toString()
            r6 = 32
            r24 = r7
            int r7 = r3.indexOf(r6)
            if (r7 >= 0) goto L_0x096d
            r1.K1(r3)
            r18 = r9
            r22 = r14
            r54 = r15
            goto L_0x09b6
        L_0x096d:
            float r6 = -r5
            float r6 = r6 * r18
            r18 = r9
            r60 r9 = r10.f184a
            float r9 = r9.g()
            float r6 = r6 / r9
            float r6 = r6 / r25
            r80 r9 = new r80
            r22 = r14
            r54 = r15
            r14 = 0
            java.lang.String r15 = r3.substring(r14, r7)
            r9.<init>(r15)
            r14 = r7
        L_0x098a:
            int r15 = r14 + 1
            r23 = r7
            r7 = 32
            int r15 = r3.indexOf(r7, r15)
            r21 = r15
            if (r15 < 0) goto L_0x09a7
            r9.a(r6)
            r15 = r21
            java.lang.String r7 = r3.substring(r14, r15)
            r9.b(r7)
            r14 = r15
            r7 = r15
            goto L_0x098a
        L_0x09a7:
            r15 = r21
            r9.a(r6)
            java.lang.String r7 = r3.substring(r14)
            r9.b(r7)
            r1.J1(r9)
        L_0x09b6:
            goto L_0x09e1
        L_0x09b7:
            r24 = r7
            r18 = r9
            r22 = r14
            r54 = r15
            r0 = r62
            r5 = r63
            if (r26 == 0) goto L_0x09da
            int r3 = (r25 > r33 ? 1 : (r25 == r33 ? 0 : -1))
            if (r3 == 0) goto L_0x09da
            r33 = r25
            float r3 = r5 / r25
            r1.I1(r3)
            float r3 = r0 / r25
            float r6 = r72.a0()
            float r3 = r3 + r6
            r1.T0(r3)
        L_0x09da:
            java.lang.String r3 = r10.toString()
            r1.K1(r3)
        L_0x09e1:
            r3 = 0
            int r6 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x09e9
            r1.H1(r3)
        L_0x09e9:
            if (r2 == 0) goto L_0x09ee
            r72.H0()
        L_0x09ee:
            if (r11 == 0) goto L_0x09f4
            r3 = 0
            r1.F1(r3)
        L_0x09f4:
            if (r13 == 0) goto L_0x09f9
            r72.I0()
        L_0x09f9:
            r3 = 1065353216(0x3f800000, float:1.0)
            int r6 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x0a02
            r1.p1(r3)
        L_0x0a02:
            r6 = r48
            boolean r6 = r10.u(r6)
            if (r6 != 0) goto L_0x0a16
            r6 = r64
            boolean r6 = r10.u(r6)
            if (r6 == 0) goto L_0x0a13
            goto L_0x0a16
        L_0x0a13:
            r7 = r60
            goto L_0x0a1e
        L_0x0a16:
            r6 = 1
            r7 = r60
            r1.D1(r4, r7)
            r32 = r6
        L_0x0a1e:
            if (r26 != 0) goto L_0x0a36
            r6 = r65
            boolean r6 = r10.u(r6)
            if (r6 == 0) goto L_0x0a2b
            r1.T0(r0)
        L_0x0a2b:
            r6 = r67
            boolean r6 = r10.u(r6)
            if (r6 == 0) goto L_0x0a36
            r1.I1(r5)
        L_0x0a36:
            r6 = r70
            v80 r9 = r6.f4215a
            boolean r9 = b0(r9)
            if (r9 == 0) goto L_0x0a47
            br r9 = r10.f180a
            if (r9 == 0) goto L_0x0a47
            r1.H(r9)
        L_0x0a47:
            r8 = r71
            r14 = r73
            r10 = r0
            r9 = r1
            r18 = r4
            r11 = r5
            r3 = r7
            r2 = r16
            r4 = r19
            r15 = r24
            r22 = r34
            r13 = r35
            r5 = r36
            r12 = r40
            r7 = r6
            r6 = r54
            goto L_0x0174
        L_0x0a64:
            r51 = r2
            r8 = r4
            r36 = r5
            r54 = r6
            r6 = r7
            r1 = r9
            r0 = r10
            r5 = r11
            r40 = r12
            r35 = r13
            r24 = r15
            r7 = r3
            if (r26 == 0) goto L_0x0a8a
            r2 = 0
            r1.I1(r2)
            r1.T0(r2)
            boolean r2 = r71.p()
            if (r2 == 0) goto L_0x0a8a
            r27 = 0
            r2 = r27
            goto L_0x0a8c
        L_0x0a8a:
            r2 = r27
        L_0x0a8c:
            if (r32 == 0) goto L_0x0a98
            float r3 = r72.n0()
            float r3 = r30 - r3
            r4 = 0
            r1.t0(r3, r4)
        L_0x0a98:
            r3 = 0
            r74[r3] = r8
            java.lang.Float r3 = new java.lang.Float
            r3.<init>(r2)
            r4 = 1
            r74[r4] = r3
            return r29
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l60.o0(e70, d60, d60, java.lang.Object[], float):float");
    }

    /* access modifiers changed from: protected */
    public float W() {
        b bVar = this.f4207a;
        return o(bVar.a + bVar.c + bVar.d + bVar.b);
    }

    /* access modifiers changed from: protected */
    public float X() {
        b bVar = this.f4207a;
        return q(bVar.e + bVar.f + bVar.g);
    }

    /* access modifiers changed from: protected */
    public float Y() {
        return t(this.f4207a.h);
    }

    /* access modifiers changed from: package-private */
    public float V() {
        return k(this.f4207a.i);
    }

    /* access modifiers changed from: protected */
    public void z(float extraspace, float oldleading, com.itextpdf.text.b f2) {
        A(extraspace, oldleading, f2, false);
    }

    /* access modifiers changed from: protected */
    public void A(float extraspace, float oldleading, com.itextpdf.text.b f2, boolean spacingAfter) {
        if (extraspace != 0.0f && !this.f4237k) {
            if (this.g + (spacingAfter ? extraspace : C()) > Y() - V()) {
                e();
                return;
            }
            this.f = extraspace;
            E();
            if (f2.p() || f2.o()) {
                f2 = new com.itextpdf.text.b(f2);
                f2.r(f2.l() & -5 & -9);
            }
            com.itextpdf.text.a space = new com.itextpdf.text.a(" ", f2);
            if (spacingAfter && this.f4237k) {
                space = new com.itextpdf.text.a("", f2);
            }
            space.a(this);
            E();
            this.f = oldleading;
        }
    }

    /* access modifiers changed from: package-private */
    public d N() {
        return this.f4208a;
    }

    /* access modifiers changed from: package-private */
    public c L(z60 pages) {
        c catalog = new c(pages, this.f4215a);
        if (this.f4211a.V().size() > 0) {
            catalog.Q(h70.p8, h70.Vc);
            catalog.Q(h70.e8, this.f4211a.W());
        }
        this.f4215a.n0().a(catalog);
        this.f4214a.a(catalog);
        catalog.T(this.f4206a, M(), this.f4231h, this.f4215a);
        String str = this.f4225d;
        if (str != null) {
            catalog.V(O(str));
        } else {
            u50 u50 = this.f4222b;
            if (u50 != null) {
                catalog.V(u50);
            }
        }
        j60 j60 = this.f4204a;
        if (j60 != null) {
            catalog.U(j60);
        }
        if (this.f4216a.g()) {
            try {
                catalog.Q(h70.g, this.f4215a.y(this.f4216a.e()).a());
            } catch (IOException e2) {
                throw new mj(e2);
            }
        }
        n80 n80 = this.f4209a;
        if (n80 != null) {
            catalog.Q(h70.d6, n80);
        }
        return catalog;
    }

    /* access modifiers changed from: package-private */
    public void D() {
        if (this.f4211a.V().size() != 0) {
            n0(this.f4211a);
        }
    }

    /* access modifiers changed from: package-private */
    public void n0(p70 outline) {
        ArrayList<p70> V = outline.V();
        p70 parent = outline.a0();
        if (!V.isEmpty()) {
            for (int k2 = 0; k2 < V.size(); k2++) {
                n0(V.get(k2));
            }
            if (parent == null) {
                return;
            }
            if (outline.Y()) {
                parent.b0(outline.U() + parent.U() + 1);
                return;
            }
            parent.b0(parent.U() + 1);
            outline.b0(-outline.U());
        } else if (parent != null) {
            parent.b0(parent.U() + 1);
        }
    }

    /* access modifiers changed from: package-private */
    public void p0() {
        if (this.f4211a.V().size() != 0) {
            f0(this.f4211a);
            v80 v80 = this.f4215a;
            p70 p70 = this.f4211a;
            v80.z(p70, p70.W());
        }
    }

    /* access modifiers changed from: package-private */
    public void f0(p70 outline) {
        outline.d0(this.f4215a.m0());
        if (outline.a0() != null) {
            outline.Q(h70.u8, outline.a0().W());
        }
        ArrayList<p70> V = outline.V();
        int size = V.size();
        for (int k2 = 0; k2 < size; k2++) {
            f0(V.get(k2));
        }
        for (int k3 = 0; k3 < size; k3++) {
            if (k3 > 0) {
                V.get(k3).Q(h70.X8, V.get(k3 - 1).W());
            }
            if (k3 < size - 1) {
                V.get(k3).Q(h70.r7, V.get(k3 + 1).W());
            }
        }
        if (size > 0) {
            outline.Q(h70.L3, V.get(0).W());
            outline.Q(h70.f6, V.get(size - 1).W());
        }
        for (int k4 = 0; k4 < size; k4++) {
            p70 kid = V.get(k4);
            this.f4215a.z(kid, kid.W());
        }
    }

    /* access modifiers changed from: package-private */
    public void d0(String name, float llx, float lly, float urx, float ury) {
        this.f4216a.c(this.f4215a.K(llx, lly, urx, ury, O(name), (h70) null));
    }

    /* access modifiers changed from: package-private */
    public void j0(String filename, String name, float llx, float lly, float urx, float ury) {
        this.f4216a.c(this.f4215a.K(llx, lly, urx, ury, new u50(filename, name), (h70) null));
    }

    /* access modifiers changed from: package-private */
    public void i0(String filename, int page, float llx, float lly, float urx, float ury) {
        w(this.f4215a.K(llx, lly, urx, ury, new u50(filename, page), (h70) null));
    }

    /* access modifiers changed from: package-private */
    public u50 O(String name) {
        a dest = this.f4206a.get(name);
        if (dest == null) {
            dest = new a();
        }
        if (dest.f4240a != null) {
            return dest.f4240a;
        }
        if (dest.f4241a == null) {
            dest.f4241a = this.f4215a.m0();
        }
        u50 action = new u50(dest.f4241a);
        dest.f4240a = action;
        this.f4206a.put(name, dest);
        return action;
    }

    /* access modifiers changed from: package-private */
    public boolean c0(String name, h60 destination) {
        a dest = this.f4206a.get(name);
        if (dest == null) {
            dest = new a();
        }
        if (dest.a != null) {
            return false;
        }
        dest.a = destination;
        this.f4206a.put(name, dest);
        if (destination.W()) {
            return true;
        }
        destination.V(this.f4215a.V());
        return true;
    }

    /* access modifiers changed from: package-private */
    public HashMap<String, o70> M() {
        return this.f4229g;
    }

    /* access modifiers changed from: package-private */
    public void w(v50 annot) {
        this.f4237k = false;
        this.f4216a.a(annot);
    }

    /* access modifiers changed from: package-private */
    public void l0(String language) {
        this.f4209a = new n80(language);
    }

    /* access modifiers changed from: protected */
    public void m0() {
        this.f3085a = this.f4221b;
        if (!this.f3091c || (m() & 1) != 0) {
            this.a = this.h;
            this.b = this.i;
        } else {
            this.b = this.h;
            this.a = this.i;
        }
        if (!this.f3092d || (m() & 1) != 0) {
            this.c = this.j;
            this.d = this.k;
        } else {
            this.c = this.k;
            this.d = this.j;
        }
        if (!b0(this.f4215a)) {
            d60 d60 = new d60(this.f4215a);
            this.f4200a = d60;
            d60.D0();
        } else {
            this.f4200a = this.b;
        }
        this.f4200a.A();
        this.f4200a.t0(n(), r());
        if (b0(this.f4215a)) {
            this.d = this.f4200a.M1();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a0() {
        if (b0(this.f4215a)) {
            v80 v80 = this.f4215a;
            if (v80 == null) {
                return true;
            }
            if (v80.Y().N1(false) == 0 && this.f4215a.Z().N1(false) == 0 && this.f4200a.N1(false) - this.d == 0 && (this.f4237k || this.f4215a.f())) {
                return true;
            }
            return false;
        }
        v80 v802 = this.f4215a;
        if (v802 == null) {
            return true;
        }
        if (v802.Y().M1() == 0 && this.f4215a.Z().M1() == 0 && (this.f4237k || this.f4215a.f())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public e50 P() {
        return this.f4201a;
    }

    public int T(Object obj) {
        int[] i2 = this.f4227e.get(obj);
        if (i2 == null) {
            i2 = new int[]{this.f4227e.size(), 0};
            this.f4227e.put(obj, i2);
        }
        return i2[0];
    }

    public int[] U(Object obj) {
        int[] i2 = this.f4227e.get(obj);
        if (i2 == null) {
            i2 = new int[]{this.f4227e.size(), 0};
            this.f4227e.put(obj, i2);
        }
        int markPoint = i2[1];
        i2[1] = i2[1] + 1;
        return new int[]{i2[0], markPoint};
    }

    /* access modifiers changed from: protected */
    public void v(tr image) {
        float diff;
        float startPosition;
        tr trVar = image;
        if (image.J0()) {
            this.b.g(trVar);
            this.f4237k = false;
            return;
        }
        if (this.g != 0.0f && (Y() - this.g) - image.A0() < V()) {
            if (this.f4238l || this.f4212a != null) {
                e();
                if (this.g != 0.0f && (Y() - this.g) - image.A0() < V()) {
                    this.f4212a = trVar;
                    return;
                }
            } else {
                this.f4212a = trVar;
                return;
            }
        }
        this.f4237k = false;
        if (trVar == this.f4212a) {
            this.f4212a = null;
        }
        boolean textwrap = (image.c0() & 4) == 4 && (image.c0() & 1) != 1;
        boolean underlying = (image.c0() & 8) == 8;
        float f2 = this.f;
        float diff2 = f2 / 2.0f;
        if (textwrap) {
            diff = diff2 + f2;
        } else {
            diff = diff2;
        }
        float lowerleft = ((Y() - this.g) - image.A0()) - diff;
        float[] mt = image.W0();
        float startPosition2 = W() - mt[4];
        if ((image.c0() & 2) == 2) {
            startPosition2 = (X() - image.B0()) - mt[4];
        }
        if ((image.c0() & 1) == 1) {
            startPosition2 = (W() + (((X() - W()) - image.B0()) / 2.0f)) - mt[4];
        }
        if (image.I0()) {
            startPosition2 = image.Z();
        }
        if (textwrap) {
            float f3 = this.l;
            if (f3 < 0.0f || f3 < this.g + image.A0() + diff) {
                this.l = this.g + image.A0() + diff;
            }
            if ((image.c0() & 2) == 2) {
                this.f4207a.g += image.B0() + image.m0();
            } else {
                this.f4207a.d += image.B0() + image.n0();
            }
            startPosition = startPosition2;
        } else if ((image.c0() & 2) == 2) {
            startPosition = startPosition2 - image.n0();
        } else if ((image.c0() & 1) == 1) {
            startPosition = startPosition2 + (image.m0() - image.n0());
        } else {
            startPosition = startPosition2 + image.m0();
        }
        this.b.m(image, mt[0], mt[1], mt[2], mt[3], startPosition, lowerleft - mt[5]);
        if (!textwrap && !underlying) {
            this.g += image.A0() + diff;
            J();
            this.f4200a.t0(0.0f, -(image.A0() + diff));
            e0();
        }
    }

    /* access modifiers changed from: package-private */
    public void y(u70 ptable) {
        ia ct = new ia(b0(this.f4215a) ? this.f4200a : this.f4215a.Y());
        ct.M(ptable.R());
        if (ptable.K() && !H(ptable, 0.0f) && this.g > 0.0f) {
            e();
            if (b0(this.f4215a)) {
                ct.B(this.f4200a);
            }
        }
        if (this.g == 0.0f) {
            ct.y(false);
        }
        ct.a(ptable);
        boolean he = ptable.b0();
        ptable.n0(true);
        int loop = 0;
        while (true) {
            ct.N(W(), V(), X(), Y() - this.g);
            if ((ct.p() & 1) != 0) {
                if (b0(this.f4215a)) {
                    this.f4200a.D1(W(), ct.o());
                } else {
                    this.f4200a.t0(0.0f, (ct.o() - Y()) + this.g);
                }
                this.g = Y() - ct.o();
                ptable.n0(he);
                return;
            }
            if (Y() - this.g == ct.o()) {
                loop++;
            } else {
                loop = 0;
            }
            if (loop != 3) {
                this.g = Y() - ct.o();
                e();
                ptable.s0(false);
                if (b0(this.f4215a)) {
                    ct.B(this.f4200a);
                }
            } else {
                throw new ih(i10.b("infinite.table.loop", new Object[0]));
            }
        }
    }

    private void x(k60 div) {
        if (this.f4223c == null) {
            this.f4223c = new ArrayList<>();
        }
        this.f4223c.add(div);
    }

    private void I() {
        ArrayList<bi> arrayList = this.f4223c;
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList<bi> arrayList2 = this.f4223c;
            this.f4223c = null;
            hm fl = new hm(arrayList2, false);
            int loop = 0;
            while (true) {
                float W = W();
                fl.d(W(), V(), X(), Y() - this.g);
                try {
                    if ((fl.c(b0(this.f4215a) ? this.f4200a : this.f4215a.Y(), false) & 1) != 0) {
                        if (b0(this.f4215a)) {
                            this.f4200a.D1(W(), fl.b());
                        } else {
                            this.f4200a.t0(0.0f, (fl.b() - Y()) + this.g);
                        }
                        this.g = Y() - fl.b();
                        return;
                    }
                    if (Y() - this.g == fl.b() || a0()) {
                        loop++;
                    } else {
                        loop = 0;
                    }
                    if (loop != 2) {
                        e();
                    } else {
                        return;
                    }
                } catch (Exception e2) {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean H(u70 table, float margin) {
        if (!table.c0()) {
            table.w0(((X() - W()) * table.W()) / 100.0f);
        }
        G();
        float floatValue = Float.valueOf(table.e0() ? table.U() - table.H() : table.U()).floatValue();
        float f2 = 0.0f;
        if (this.g > 0.0f) {
            f2 = table.C0();
        }
        return floatValue + f2 <= ((Y() - this.g) - V()) - margin;
    }

    private static boolean b0(v80 writer) {
        return writer != null && writer.z0();
    }

    /* renamed from: l60$a */
    public class a {
        public h60 a;

        /* renamed from: a  reason: collision with other field name */
        public u50 f4240a;

        /* renamed from: a  reason: collision with other field name */
        public z60 f4241a;

        public a() {
        }
    }

    /* access modifiers changed from: protected */
    public void k0(g0 id, o80 element) {
        this.f4219b.put(id, element);
    }

    /* access modifiers changed from: protected */
    public o80 Q(g0 id) {
        return R(id, true);
    }

    /* access modifiers changed from: protected */
    public o80 R(g0 id, boolean toSaveFetchedElement) {
        nq0.a pos;
        o80 element = this.f4219b.get(id);
        if (!this.f4230g || element != null || (pos = this.f4224c.get(id)) == null) {
            return element;
        }
        try {
            this.f4210a.a(pos);
            throw null;
        } catch (IOException e2) {
            throw new mj(e2);
        } catch (ClassNotFoundException e3) {
            throw new mj(e3);
        }
    }

    /* access modifiers changed from: protected */
    public void K() {
        if (this.f4230g) {
            for (Map.Entry<AccessibleElementId, PdfStructureElement> entry : this.f4219b.entrySet()) {
                if (!((o80) entry.getValue()).Z().equals(h70.G2)) {
                    try {
                        o80 el = (o80) entry.getValue();
                        j60 parentDict = el.V();
                        o80 parent = null;
                        if (parentDict instanceof o80) {
                            parent = (o80) parentDict;
                        }
                        if (parent != null) {
                            this.f4226d.put(entry.getKey(), parent.U());
                        }
                        this.f4210a.b(el);
                        throw null;
                    } catch (IOException e2) {
                        throw new mj(e2);
                    }
                }
            }
        }
    }

    public Set<g0> S() {
        Set<AccessibleElementId> elements = new HashSet<>();
        elements.addAll(this.f4224c.keySet());
        elements.addAll(this.f4219b.keySet());
        return elements;
    }
}
