package defpackage;

import androidx.core.internal.view.SupportMenu;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfOCG;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.c;
import defpackage.l60;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* renamed from: v80  reason: default package */
public class v80 extends fh {
    protected static kd a = ld.a(v80.class);
    public static final h70 b = new h70("1.2");

    /* renamed from: b  reason: collision with other field name */
    private static final List<h70> f5312b;
    public static final h70 c = new h70("1.3");

    /* renamed from: c  reason: collision with other field name */
    private static final List<h70> f5313c;
    public static final h70 d = new h70("1.4");
    public static final h70 e = new h70("1.5");
    public static final h70 f = new h70("1.6");
    public static final h70 g = new h70("1.7");
    public static final h70 h = h70.yd;
    public static final h70 i = h70.Kd;
    public static final h70 j = h70.L2;
    public static final h70 k;
    public static final h70 l = h70.J2;
    public static final h70 m = h70.C7;
    public static final h70 n = h70.B0;

    /* renamed from: a  reason: collision with other field name */
    private float f5314a = 2.5f;

    /* renamed from: a  reason: collision with other field name */
    protected int f5315a = 1;

    /* renamed from: a  reason: collision with other field name */
    protected long f5316a = 0;

    /* renamed from: a  reason: collision with other field name */
    protected a70 f5317a = u0();

    /* renamed from: a  reason: collision with other field name */
    private a80 f5318a;

    /* renamed from: a  reason: collision with other field name */
    protected b80 f5319a = new b80(this);

    /* renamed from: a  reason: collision with other field name */
    protected d60 f5320a;

    /* renamed from: a  reason: collision with other field name */
    protected h70 f5321a = null;

    /* renamed from: a  reason: collision with other field name */
    protected j60 f5322a;

    /* renamed from: a  reason: collision with other field name */
    protected ArrayList<z60> f5323a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    protected HashMap<z60, Object[]> f5324a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    protected HashSet<j80> f5325a = new HashSet<>();

    /* renamed from: a  reason: collision with other field name */
    protected LinkedHashMap<y5, jn> f5326a = new LinkedHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    protected LinkedHashSet<m70> f5327a = new LinkedHashSet<>();

    /* renamed from: a  reason: collision with other field name */
    protected List<HashMap<String, Object>> f5328a;

    /* renamed from: a  reason: collision with other field name */
    protected l60 f5329a;

    /* renamed from: a  reason: collision with other field name */
    protected n70 f5330a;

    /* renamed from: a  reason: collision with other field name */
    protected o60 f5331a;

    /* renamed from: a  reason: collision with other field name */
    protected p80 f5332a;

    /* renamed from: a  reason: collision with other field name */
    protected t80 f5333a = new t80();

    /* renamed from: a  reason: collision with other field name */
    protected a f5334a;

    /* renamed from: a  reason: collision with other field name */
    protected vs0 f5335a = null;

    /* renamed from: a  reason: collision with other field name */
    protected w9 f5336a;

    /* renamed from: a  reason: collision with other field name */
    protected x50 f5337a = new x50();

    /* renamed from: a  reason: collision with other field name */
    protected byte[] f5338a = null;

    /* renamed from: b  reason: collision with other field name */
    protected int f5339b = -1;

    /* renamed from: b  reason: collision with other field name */
    protected d60 f5340b;

    /* renamed from: b  reason: collision with other field name */
    protected j60 f5341b = new j60();

    /* renamed from: b  reason: collision with other field name */
    protected ArrayList<m70> f5342b = new ArrayList<>();

    /* renamed from: b  reason: collision with other field name */
    protected HashMap<c, e80> f5343b = new HashMap<>();

    /* renamed from: b  reason: collision with other field name */
    protected HashSet<i80> f5344b = new HashSet<>();

    /* renamed from: b  reason: collision with other field name */
    protected w9 f5345b;

    /* renamed from: b  reason: collision with other field name */
    protected x50 f5346b = new x50();

    /* renamed from: b  reason: collision with other field name */
    protected byte[] f5347b = null;

    /* renamed from: c  reason: collision with other field name */
    protected int f5348c = 1;

    /* renamed from: c  reason: collision with other field name */
    protected j60 f5349c;

    /* renamed from: c  reason: collision with other field name */
    protected HashMap<er, w9> f5350c = new HashMap<>();

    /* renamed from: c  reason: collision with other field name */
    protected w9 f5351c;

    /* renamed from: d  reason: collision with other field name */
    protected int f5352d = 1;

    /* renamed from: d  reason: collision with other field name */
    protected j60 f5353d = new j60();

    /* renamed from: d  reason: collision with other field name */
    protected HashMap<d80, h70> f5354d = new HashMap<>();

    /* renamed from: d  reason: collision with other field name */
    protected boolean f5355d = false;

    /* renamed from: e  reason: collision with other field name */
    protected int f5356e = 1;

    /* renamed from: e  reason: collision with other field name */
    protected j60 f5357e = new j60();

    /* renamed from: e  reason: collision with other field name */
    protected HashMap<j60, o70[]> f5358e = new HashMap<>();

    /* renamed from: e  reason: collision with other field name */
    protected boolean f5359e = false;

    /* renamed from: f  reason: collision with other field name */
    protected int f5360f = 1;

    /* renamed from: f  reason: collision with other field name */
    protected HashMap<Object, o70[]> f5361f = new HashMap<>();

    /* renamed from: f  reason: collision with other field name */
    private boolean f5362f;

    /* renamed from: g  reason: collision with other field name */
    protected int f5363g = 1;

    /* renamed from: g  reason: collision with other field name */
    protected HashMap<w9, w9> f5364g = new HashMap<>();

    /* renamed from: g  reason: collision with other field name */
    private boolean f5365g;

    /* renamed from: h  reason: collision with other field name */
    protected int f5366h = 1;

    /* renamed from: h  reason: collision with other field name */
    private final HashMap<Long, h70> f5367h = new HashMap<>();

    /* renamed from: i  reason: collision with other field name */
    protected HashMap<m80, z60> f5368i = new HashMap<>();

    /* renamed from: v80$a */
    public static class a {
        protected int a;

        /* renamed from: a  reason: collision with other field name */
        protected long f5369a;

        /* renamed from: a  reason: collision with other field name */
        protected final TreeSet<C0060a> f5370a;

        /* renamed from: a  reason: collision with other field name */
        protected final v80 f5371a;

        /* renamed from: a  reason: collision with other field name */
        protected w6 f5372a;
        protected int b;

        /* renamed from: b  reason: collision with other field name */
        protected w6 f5373b;
        protected int c = 0;

        /* renamed from: v80$a$a  reason: collision with other inner class name */
        public static class C0060a implements Comparable<C0060a> {
            private final int a;

            /* renamed from: a  reason: collision with other field name */
            private final long f5374a;
            private final int b;
            private final int c;

            public C0060a(int refnum, long offset, int generation) {
                this.a = 0;
                this.f5374a = offset;
                this.b = refnum;
                this.c = generation;
            }

            public C0060a(int refnum, long offset) {
                this.a = 1;
                this.f5374a = offset;
                this.b = refnum;
                this.c = 0;
            }

            public C0060a(int type, int refnum, long offset, int generation) {
                this.a = type;
                this.f5374a = offset;
                this.b = refnum;
                this.c = generation;
            }

            public int b() {
                return this.b;
            }

            public void d(OutputStream os) {
                StringBuffer off = new StringBuffer("0000000000").append(this.f5374a);
                off.delete(0, off.length() - 10);
                StringBuffer gen = new StringBuffer("00000").append(this.c);
                gen.delete(0, gen.length() - 5);
                off.append(' ');
                off.append(gen);
                off.append(this.c == 65535 ? " f \n" : " n \n");
                os.write(fh.b(off.toString()));
            }

            public void c(int midSize, OutputStream os) {
                os.write((byte) this.a);
                while (true) {
                    midSize--;
                    if (midSize >= 0) {
                        os.write((byte) ((int) ((this.f5374a >>> (midSize * 8)) & 255)));
                    } else {
                        os.write((byte) ((this.c >>> 8) & 255));
                        os.write((byte) (this.c & 255));
                        return;
                    }
                }
            }

            /* renamed from: a */
            public int compareTo(C0060a other) {
                int i = this.b;
                int i2 = other.b;
                if (i < i2) {
                    return -1;
                }
                return i == i2 ? 0 : 1;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof C0060a) || this.b != ((C0060a) obj).b) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return this.b;
            }
        }

        protected a(v80 writer) {
            TreeSet<C0060a> treeSet = new TreeSet<>();
            this.f5370a = treeSet;
            treeSet.add(new C0060a(0, 0, SupportMenu.USER_MASK));
            this.f5369a = writer.g0().c();
            this.a = 1;
            this.f5371a = writer;
        }

        /* access modifiers changed from: protected */
        public C0060a g(o70 obj, int nObj) {
            if (this.c >= 200) {
                h();
            }
            if (this.f5372a == null) {
                this.f5372a = new w6();
                this.f5373b = new w6();
                this.b = i();
                this.c = 0;
            }
            int p = this.f5373b.b0();
            int idx = this.c;
            this.c = idx + 1;
            v80 v80 = this.f5371a;
            o60 enc = v80.f5331a;
            v80.f5331a = null;
            obj.F(v80, this.f5373b);
            this.f5371a.f5331a = enc;
            this.f5373b.f(' ');
            this.f5372a.w(nObj).f(' ').w(p).f(' ');
            return new C0060a(2, nObj, (long) this.b, idx);
        }

        public void h() {
            if (this.c != 0) {
                int first = this.f5372a.b0();
                this.f5372a.C(this.f5373b);
                m80 stream = new m80(this.f5372a.c0());
                stream.T(this.f5371a.T());
                stream.Q(h70.Bc, h70.F7);
                stream.Q(h70.b7, new k70(this.c));
                stream.Q(h70.L3, new k70(first));
                b(stream, this.b);
                this.f5372a = null;
                this.f5373b = null;
                this.c = 0;
            }
        }

        /* access modifiers changed from: package-private */
        public y60 a(o70 object) {
            return b(object, i());
        }

        /* access modifiers changed from: package-private */
        public y60 f(o70 object, boolean inObjStm) {
            return c(object, i(), 0, inObjStm);
        }

        public z60 j() {
            return new z60(0, i());
        }

        /* access modifiers changed from: protected */
        public int i() {
            int n = this.a;
            this.a = n + 1;
            this.f5370a.add(new C0060a(n, 0, SupportMenu.USER_MASK));
            return n;
        }

        /* access modifiers changed from: package-private */
        public y60 d(o70 object, z60 ref) {
            return e(object, ref, true);
        }

        /* access modifiers changed from: package-private */
        public y60 e(o70 object, z60 ref, boolean inObjStm) {
            return c(object, ref.I(), ref.H(), inObjStm);
        }

        /* access modifiers changed from: package-private */
        public y60 b(o70 object, int refNumber) {
            return c(object, refNumber, 0, true);
        }

        /* access modifiers changed from: protected */
        public y60 c(o70 object, int refNumber, int generation, boolean inObjStm) {
            if (inObjStm && object.o() && this.f5371a.v0()) {
                C0060a pxref = g(object, refNumber);
                y60 indirect = new y60(refNumber, object, this.f5371a);
                if (!this.f5370a.add(pxref)) {
                    this.f5370a.remove(pxref);
                    this.f5370a.add(pxref);
                }
                return indirect;
            } else if (this.f5371a.v0()) {
                y60 indirect2 = new y60(refNumber, object, this.f5371a);
                m(indirect2, refNumber);
                return indirect2;
            } else {
                y60 indirect3 = new y60(refNumber, generation, object, this.f5371a);
                n(indirect3, refNumber, generation);
                return indirect3;
            }
        }

        /* access modifiers changed from: protected */
        public void m(y60 indirect, int refNumber) {
            C0060a pxref = new C0060a(refNumber, this.f5369a);
            if (!this.f5370a.add(pxref)) {
                this.f5370a.remove(pxref);
                this.f5370a.add(pxref);
            }
            indirect.b(this.f5371a.g0());
            this.f5369a = this.f5371a.g0().c();
        }

        /* access modifiers changed from: protected */
        public void n(y60 indirect, int refNumber, int generation) {
            C0060a pxref = new C0060a(refNumber, this.f5369a, generation);
            if (!this.f5370a.add(pxref)) {
                this.f5370a.remove(pxref);
                this.f5370a.add(pxref);
            }
            indirect.b(this.f5371a.g0());
            this.f5369a = this.f5371a.g0().c();
        }

        public long k() {
            return this.f5369a;
        }

        public int l() {
            return Math.max(this.f5370a.last().b() + 1, this.a);
        }

        public void o(OutputStream os, z60 root, z60 info, z60 encryption, o70 fileID, long prevxref) {
            int first;
            OutputStream outputStream = os;
            z60 z60 = info;
            z60 z602 = encryption;
            o70 o70 = fileID;
            long j = prevxref;
            int refNumber = 0;
            if (this.f5371a.v0()) {
                h();
                refNumber = i();
                this.f5370a.add(new C0060a(refNumber, this.f5369a));
            }
            C0060a entry = this.f5370a.first();
            int first2 = entry.b();
            int len = 0;
            ArrayList<Integer> sections = new ArrayList<>();
            Iterator i$ = this.f5370a.iterator();
            while (i$.hasNext()) {
                entry = i$.next();
                if (first2 + len == entry.b()) {
                    len++;
                } else {
                    sections.add(Integer.valueOf(first2));
                    sections.add(Integer.valueOf(len));
                    first2 = entry.b();
                    len = 1;
                }
            }
            sections.add(Integer.valueOf(first2));
            sections.add(Integer.valueOf(len));
            if (this.f5371a.v0()) {
                int mid = 5;
                long mask = 1095216660480L;
                while (true) {
                    if (mid <= 1) {
                        first = first2;
                        break;
                    }
                    C0060a entry2 = entry;
                    first = first2;
                    if ((this.f5369a & mask) != 0) {
                        break;
                    }
                    mask >>>= 8;
                    mid--;
                    entry = entry2;
                    first2 = first;
                }
                w6 buf = new w6();
                Iterator i$2 = this.f5370a.iterator();
                while (i$2.hasNext()) {
                    i$2.next().c(mid, buf);
                }
                m80 xr = new m80(buf.c0());
                xr.T(this.f5371a.T());
                int i = len;
                xr.Q(h70.Ma, new k70(l()));
                xr.Q(h70.ja, root);
                if (z60 != null) {
                    xr.Q(h70.F5, z60);
                }
                if (z602 != null) {
                    xr.Q(h70.e3, z602);
                }
                if (o70 != null) {
                    xr.Q(h70.r5, o70);
                }
                xr.Q(h70.ud, new x50(new int[]{1, mid, 2}));
                xr.Q(h70.Bc, h70.Td);
                x50 idx = new x50();
                int k = 0;
                while (k < sections.size()) {
                    idx.I(new k70(sections.get(k).intValue()));
                    k++;
                    z60 z603 = encryption;
                }
                xr.Q(h70.D5, idx);
                if (j > 0) {
                    xr.Q(h70.X8, new k70(j));
                }
                v80 v80 = this.f5371a;
                o60 enc = v80.f5331a;
                v80.f5331a = null;
                new y60(refNumber, xr, this.f5371a).b(this.f5371a.g0());
                this.f5371a.f5331a = enc;
                int i2 = first;
                return;
            }
            int i3 = first2;
            int i4 = len;
            z60 z604 = root;
            outputStream.write(fh.b("xref\n"));
            Iterator<C0060a> it = this.f5370a.iterator();
            for (int k2 = 0; k2 < sections.size(); k2 += 2) {
                int first3 = sections.get(k2).intValue();
                int len2 = sections.get(k2 + 1).intValue();
                outputStream.write(fh.b(String.valueOf(first3)));
                outputStream.write(fh.b(" "));
                outputStream.write(fh.b(String.valueOf(len2)));
                outputStream.write(10);
                while (true) {
                    int len3 = len2 - 1;
                    if (len2 <= 0) {
                        break;
                    }
                    entry = it.next();
                    entry.d(outputStream);
                    len2 = len3;
                }
            }
            C0060a aVar = entry;
        }
    }

    /* renamed from: v80$b */
    public static class b extends j60 {
        long a;

        public b(int size, long offset, z60 root, z60 info, z60 encryption, o70 fileID, long prevxref) {
            this.a = offset;
            Q(h70.Ma, new k70(size));
            Q(h70.ja, root);
            if (info != null) {
                Q(h70.F5, info);
            }
            if (encryption != null) {
                Q(h70.e3, encryption);
            }
            if (fileID != null) {
                Q(h70.r5, fileID);
            }
            if (prevxref > 0) {
                Q(h70.X8, new k70(prevxref));
            }
        }

        public void F(v80 writer, OutputStream os) {
            v80.H(writer, 8, this);
            os.write(fh.b("trailer\n"));
            super.F((v80) null, os);
            os.write(10);
            v80.F0(os);
            os.write(fh.b("startxref\n"));
            os.write(fh.b(String.valueOf(this.a)));
            os.write(fh.b("\n%%EOF\n"));
        }
    }

    static {
        h70 h70 = h70.Jd;
        k = h70;
        h70 h702 = h70.G2;
        h70 h703 = h70.x8;
        h70 h704 = h70.M;
        h70 h705 = h70.za;
        h70 h706 = h70.A2;
        h70 h707 = h70.q0;
        h70 h708 = h70.K0;
        h70 h709 = h70.cc;
        h70 h7010 = h70.dc;
        h70 h7011 = h70.D5;
        h70 h7012 = h70.w7;
        h70 h7013 = h70.h9;
        h70 h7014 = h70.k8;
        h70 h7015 = h70.N4;
        h70 h7016 = h70.O4;
        h70 h7017 = h70.P4;
        h70 h7018 = h70.Q4;
        h70 h7019 = h70.R4;
        h70 h7020 = h70.S4;
        h70 h7021 = h70.T4;
        h70 h7022 = h70.a6;
        h70 h7023 = h70.k6;
        h70 h7024 = h70.o6;
        h70 h7025 = h70.l6;
        h70 h7026 = h70.Bb;
        h70 h7027 = h70.Fb;
        h70 h7028 = h70.Ob;
        h70 h7029 = h70.Eb;
        h70 h7030 = h70.Ta;
        h70 h7031 = h70.t9;
        h70 h7032 = h70.y7;
        h70 h7033 = h70.G9;
        h70 h7034 = h70.h0;
        h70 h7035 = h70.j1;
        h70 h7036 = h70.t6;
        h70 h7037 = h70.H3;
        h70 h7038 = h70.p4;
        h70 h7039 = h70.n4;
        f5312b = Arrays.asList(new h70[]{h702, h703, h704, h705, h706, h707, h708, h709, h7010, h7011, h7012, h7013, h7014, h7015, h7016, h7017, h7018, h7019, h7020, h7021, h7022, h7023, h7024, h7025, h7026, h7027, h7028, h7029, h7030, h7031, h7032, h7033, h7034, h7035, h7036, h7037, h7038, h7039});
        f5313c = Arrays.asList(new h70[]{h702, h703, h704, h705, h706, h707, h708, h709, h7010, h7011, h7012, h7013, h7014, h7015, h7016, h7017, h7018, h7019, h7020, h7021, h7022, h7023, h7024, h7025, h7026, h7027, h7028, h7029, h70.Pb, h70.Db, h70.Nb, h7030, h7031, h7032, h7033, h7034, h7035, h7036, h70.G, h70.qa, h70.x9, h70.pa, h70.oa, h70.wd, h70.Ld, h70, h7037, h7038, h7039});
    }

    /* access modifiers changed from: protected */
    public kd U() {
        return a;
    }

    protected v80(l60 document, OutputStream os) {
        super(document, os);
        this.f5329a = document;
        d60 d60 = new d60(this);
        this.f5340b = d60;
        this.f5320a = d60.c0();
    }

    public static v80 e0(gh document, OutputStream os) {
        l60 pdf = new l60();
        document.g(pdf);
        v80 writer = new v80(pdf, os);
        pdf.B(writer);
        return writer;
    }

    /* access modifiers changed from: package-private */
    public l60 l0() {
        return this.f5329a;
    }

    public j60 d0() {
        return this.f5329a.N();
    }

    public d60 Y() {
        if (this.f2972a) {
            return this.f5320a;
        }
        throw new RuntimeException(i10.b("the.document.is.not.open", new Object[0]));
    }

    public d60 Z() {
        if (this.f2972a) {
            return this.f5340b;
        }
        throw new RuntimeException(i10.b("the.document.is.not.open", new Object[0]));
    }

    /* access modifiers changed from: package-private */
    public void C0() {
        this.f5320a.D0();
        this.f5340b.D0();
    }

    /* access modifiers changed from: package-private */
    public void o(TreeMap<String, l60.a> desto) {
        for (Map.Entry<String, PdfDocument.Destination> entry : desto.entrySet()) {
            String name = entry.getKey();
            l60.a dest = (l60.a) entry.getValue();
            h60 destination = dest.a;
            if (dest.f4241a == null) {
                dest.f4241a = m0();
            }
            if (destination == null) {
                z(new n80("invalid_" + name), dest.f4241a);
            } else {
                z(destination, dest.f4241a);
            }
        }
    }

    public y60 y(o70 object) {
        y60 iobj = this.f5334a.a(object);
        E(iobj);
        return iobj;
    }

    public y60 B(o70 object, boolean inObjStm) {
        y60 iobj = this.f5334a.f(object, inObjStm);
        E(iobj);
        return iobj;
    }

    public y60 z(o70 object, z60 ref) {
        y60 iobj = this.f5334a.d(object, ref);
        E(iobj);
        return iobj;
    }

    public y60 A(o70 object, z60 ref, boolean inObjStm) {
        y60 iobj = this.f5334a.e(object, ref, inObjStm);
        E(iobj);
        return iobj;
    }

    /* access modifiers changed from: protected */
    public void E(y60 iobj) {
    }

    public z60 m0() {
        return this.f5334a.j();
    }

    public z40 g0() {
        return this.f2971a;
    }

    /* access modifiers changed from: protected */
    public j60 R(z60 rootObj) {
        j60 catalog = this.f5329a.L(rootObj);
        D(catalog);
        if (!this.f5327a.isEmpty()) {
            O(false);
            catalog.Q(h70.K7, this.f5330a);
        }
        return catalog;
    }

    /* access modifiers changed from: protected */
    public void D(j60 catalog) {
        if (this.f5359e) {
            try {
                r0().T();
                for (g0 elementId : this.f5329a.S()) {
                    o80 element = this.f5329a.R(elementId, false);
                    z(element, element.Y());
                }
                catalog.Q(h70.ob, this.f5332a.V());
                j60 mi = new j60();
                h70 h70 = h70.K6;
                z50 z50 = z50.a;
                mi.Q(h70, z50);
                if (this.f5362f) {
                    mi.Q(h70.Xc, z50);
                }
                catalog.Q(h70.L6, mi);
            } catch (Exception e2) {
                throw new mj(e2);
            }
        }
    }

    public j60 b0() {
        if (this.f5322a == null) {
            this.f5322a = new j60();
        }
        return this.f5322a;
    }

    public j60 i0() {
        return this.f5341b;
    }

    public void D0() {
        this.f5341b = new j60();
    }

    public z60 k0(int page) {
        int page2 = page - 1;
        if (page2 < 0) {
            throw new IndexOutOfBoundsException(i10.b("the.page.number.must.be.gt.eq.1", new Object[0]));
        } else if (page2 < this.f5323a.size()) {
            z60 ref = this.f5323a.get(page2);
            if (ref != null) {
                return ref;
            }
            z60 ref2 = this.f5334a.j();
            this.f5323a.set(page2, ref2);
            return ref2;
        } else {
            int empty = page2 - this.f5323a.size();
            for (int k2 = 0; k2 < empty; k2++) {
                this.f5323a.add((Object) null);
            }
            z60 ref3 = this.f5334a.j();
            this.f5323a.add(ref3);
            return ref3;
        }
    }

    /* access modifiers changed from: package-private */
    public z60 V() {
        return k0(this.f5315a);
    }

    public int W() {
        return this.f5315a;
    }

    public h70 s0() {
        return this.f5321a;
    }

    /* access modifiers changed from: package-private */
    public z60 i(z70 page, e60 contents) {
        if (this.f2972a) {
            try {
                page.T(y(contents).a());
                j60 j60 = this.f5349c;
                if (j60 != null) {
                    page.Q(h70.J4, j60);
                    this.f5349c = null;
                } else if (this.f5365g) {
                    j60 pp = new j60();
                    h70 h70 = h70.Bc;
                    h70 h702 = h70.J4;
                    pp.Q(h70, h702);
                    pp.Q(h70.ta, h70.mc);
                    pp.Q(h70.S1, h70.s2);
                    page.Q(h702, pp);
                }
                this.f5319a.a(page);
                this.f5315a++;
                return null;
            } catch (IOException ioe) {
                throw new mj(ioe);
            }
        } else {
            throw new p60(i10.b("the.document.is.not.open", new Object[0]));
        }
    }

    public a80 j0() {
        return this.f5318a;
    }

    public void open() {
        super.open();
        try {
            this.f5333a.e(this.f2971a);
            this.f5334a = new a(this);
            if (x0() && ((y80) this.f5317a).f()) {
                j60 sec = new j60();
                sec.Q(h70.y4, new x50(new float[]{2.2f, 2.2f, 2.2f}));
                sec.Q(h70.H6, new x50(new float[]{0.4124f, 0.2126f, 0.0193f, 0.3576f, 0.7152f, 0.1192f, 0.1805f, 0.0722f, 0.9505f}));
                sec.Q(h70.Hd, new x50(new float[]{0.9505f, 1.0f, 1.089f}));
                x50 arr = new x50((o70) h70.H0);
                arr.I(sec);
                E0(h70.k2, y(arr).a());
            }
        } catch (IOException ioe) {
            throw new mj(ioe);
        }
    }

    public void close() {
        if (this.f2972a) {
            boolean isModified = true;
            if (this.f5315a - 1 == this.f5323a.size()) {
                this.f5329a.close();
                try {
                    p();
                    Iterator i$ = this.f5327a.iterator();
                    while (i$.hasNext()) {
                        m70 layer = (m70) i$.next();
                        z(layer.c(), layer.d());
                    }
                    j60 catalog = R(this.f5319a.b());
                    if (!this.f5327a.isEmpty()) {
                        H(this, 7, this.f5330a);
                    }
                    byte[] bArr = this.f5347b;
                    if (bArr == null) {
                    }
                    if (bArr != null) {
                        m80 xmp = new m80(this.f5347b);
                        h70 h70 = h70.Bc;
                        h70 h702 = h70.U6;
                        xmp.Q(h70, h702);
                        xmp.Q(h70.tb, h70.Qd);
                        catalog.Q(h702, this.f5334a.a(xmp).a());
                    }
                    d0().Q(h70.j9, new n80(av0.a().d()));
                    if (x0()) {
                        J(d0());
                        I(b0());
                    }
                    j60 j60 = this.f5322a;
                    if (j60 != null) {
                        catalog.P(j60);
                    }
                    G0(catalog, false);
                    y60 indirectCatalog = B(catalog, false);
                    y60 infoObj = B(d0(), false);
                    this.f5334a.h();
                    byte[] bArr2 = this.f5338a;
                    if (bArr2 == null) {
                        isModified = false;
                    }
                    if (!isModified) {
                        bArr2 = o60.b();
                    }
                    o70 fileID = o60.c(bArr2, isModified);
                    this.f5334a.o(this.f2971a, indirectCatalog.a(), infoObj.a(), (z60) null, fileID, this.f5316a);
                    if (this.f5355d) {
                        F0(this.f2971a);
                        this.f2971a.write(fh.b("startxref\n"));
                        this.f2971a.write(fh.b(String.valueOf(this.f5334a.k())));
                        this.f2971a.write(fh.b("\n%%EOF\n"));
                    } else {
                        new b(this.f5334a.l(), this.f5334a.k(), indirectCatalog.a(), infoObj.a(), (z60) null, fileID, this.f5316a).F(this, this.f2971a);
                    }
                    super.close();
                } catch (IOException ioe) {
                    throw new mj(ioe);
                } catch (Throwable th) {
                    super.close();
                    throw th;
                }
            } else {
                throw new RuntimeException("The page " + this.f5323a.size() + " was requested but the document has only " + (this.f5315a - 1) + " pages.");
            }
        }
        U().a(this.f2971a.c());
    }

    /* access modifiers changed from: protected */
    public void C() {
        for (Object[] objs : this.f5324a.values()) {
            q80 template = (q80) objs[1];
            if (template != null) {
                template.Z1();
            }
            if (template != null && template.e2() == 1) {
                z(template.W1(this.f5339b), template.Z1());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void p() {
        for (jn details : this.f5326a.values()) {
            details.i(this);
        }
        C();
        Iterator i$ = this.f5343b.values().iterator();
        if (!i$.hasNext()) {
            for (w9 color : this.f5350c.values()) {
                z(color.c(this), color.b());
            }
            for (d80 pat : this.f5354d.keySet()) {
                z(pat.m2(this.f5339b), pat.Z1());
            }
            Iterator i$2 = this.f5325a.iterator();
            while (i$2.hasNext()) {
                i$2.next().T();
            }
            Iterator i$3 = this.f5344b.iterator();
            while (i$3.hasNext()) {
                i$3.next().a();
            }
            for (Map.Entry<PdfDictionary, PdfObject[]> entry : this.f5358e.entrySet()) {
                z((j60) entry.getKey(), (z60) ((o70[]) entry.getValue())[1]);
            }
            for (Map.Entry<Object, PdfObject[]> entry2 : this.f5361f.entrySet()) {
                Object prop = entry2.getKey();
                o70[] obj = (o70[]) entry2.getValue();
                if (prop instanceof j60) {
                    z((j60) prop, (z60) obj[1]);
                }
            }
            return;
        }
        i$.next().b();
        throw null;
    }

    /* access modifiers changed from: protected */
    public void G0(j60 catalog, boolean namedAsNames) {
        List<HashMap<String, Object>> list = this.f5328a;
        if (list != null && !list.isEmpty()) {
            j60 top = new j60();
            z60 topRef = m0();
            Object[] kids = sl0.b(this, topRef, this.f5328a, namedAsNames);
            top.Q(h70.L3, (z60) kids[0]);
            top.Q(h70.f6, (z60) kids[1]);
            top.Q(h70.G1, new k70(((Integer) kids[2]).intValue()));
            z(top, topRef);
            catalog.Q(h70.e8, topRef);
        }
    }

    /* access modifiers changed from: package-private */
    public t80 n0() {
        return this.f5333a;
    }

    public void k(v50 annot) {
        this.f5329a.w(annot);
    }

    /* access modifiers changed from: protected */
    public a70 u0() {
        return new y80(this);
    }

    public int h0() {
        a70 a70 = this.f5317a;
        if (a70 instanceof y80) {
            return ((w80) a70).d();
        }
        return 0;
    }

    public boolean x0() {
        a70 a70 = this.f5317a;
        if (a70 instanceof y80) {
            return ((w80) a70).c();
        }
        return false;
    }

    public boolean w0() {
        return this.f5317a.a();
    }

    /* access modifiers changed from: package-private */
    public o60 a0() {
        return this.f5331a;
    }

    public boolean v0() {
        return this.f5355d;
    }

    public int T() {
        return this.f5339b;
    }

    /* JADX WARNING: type inference failed for: r7v1, types: [java.lang.Throwable, jh] */
    /* access modifiers changed from: package-private */
    public jn r(y5 bf) {
        jn ret = this.f5326a.get(bf);
        if (ret != null) {
            return ret;
        }
        H(this, 4, bf);
        if (bf.m() != 4) {
            StringBuilder sb = new StringBuilder();
            sb.append("F");
            int i2 = this.f5348c;
            this.f5348c = i2 + 1;
            sb.append(i2);
            jn ret2 = new jn(new h70(sb.toString()), this.f5334a.j(), bf);
            this.f5326a.put(bf, ret2);
            return ret2;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("F");
        int i3 = this.f5348c;
        this.f5348c = i3 + 1;
        sb2.append(i3);
        new h70(sb2.toString());
        b6.a(bf);
        ? r7 = 0;
        r7.F();
        throw r7;
    }

    /* access modifiers changed from: package-private */
    public void N(j60 fonts) {
        for (jn ft : this.f5326a.values()) {
            if (fonts.I(ft.e()) != null) {
                ft.h(false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public h70 n(q80 template, h70 forcedName) {
        h70 name;
        z60 ref = template.Z1();
        Object[] obj = this.f5324a.get(ref);
        if (obj != null) {
            return (h70) obj[0];
        }
        if (forcedName == null) {
            try {
                name = new h70("Xf" + this.f5352d);
                this.f5352d = this.f5352d + 1;
            } catch (Exception e2) {
                throw new mj(e2);
            }
        } else {
            name = forcedName;
        }
        if (template.e2() != 2) {
            this.f5324a.put(ref, new Object[]{name, template});
            return name;
        }
        b6.a(template);
        x60 ip = null;
        ip.l2().a();
        throw null;
    }

    /* access modifiers changed from: package-private */
    public h70 S() {
        StringBuilder sb = new StringBuilder();
        sb.append("CS");
        int i2 = this.f5356e;
        this.f5356e = i2 + 1;
        sb.append(i2);
        return new h70(sb.toString());
    }

    /* access modifiers changed from: package-private */
    public w9 q(er spc) {
        w9 ret = this.f5350c.get(spc);
        if (ret != null) {
            return ret;
        }
        w9 ret2 = new w9(S(), this.f5334a.j(), spc);
        this.f5350c.put(spc, ret2);
        return ret2;
    }

    /* access modifiers changed from: package-private */
    public h70 t(d80 painter) {
        h70 name = this.f5354d.get(painter);
        if (name != null) {
            return name;
        }
        try {
            h70 name2 = new h70("P" + this.f5360f);
            this.f5360f = this.f5360f + 1;
            this.f5354d.put(painter, name2);
            return name2;
        } catch (Exception e2) {
            throw new mj(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public void x(j80 shading) {
        if (!this.f5325a.contains(shading)) {
            shading.Y(this.f5360f);
            this.f5360f++;
            this.f5325a.add(shading);
            w(shading.X());
        }
    }

    /* access modifiers changed from: package-private */
    public void w(i80 shading) {
        if (!this.f5344b.contains(shading)) {
            this.f5344b.add(shading);
            shading.b(this.f5344b.size());
        }
    }

    /* access modifiers changed from: package-private */
    public o70[] s(j60 gstate) {
        if (!this.f5358e.containsKey(gstate)) {
            HashMap<j60, o70[]> hashMap = this.f5358e;
            hashMap.put(gstate, new o70[]{new h70("GS" + (this.f5358e.size() + 1)), m0()});
        }
        return this.f5358e.get(gstate);
    }

    /* access modifiers changed from: package-private */
    public o70[] v(Object prop, z60 refi) {
        if (!this.f5361f.containsKey(prop)) {
            HashMap<Object, o70[]> hashMap = this.f5361f;
            hashMap.put(prop, new o70[]{new h70("Pr" + (this.f5361f.size() + 1)), refi});
        }
        return this.f5361f.get(prop);
    }

    /* access modifiers changed from: package-private */
    public boolean B0(Object prop) {
        return this.f5361f.containsKey(prop);
    }

    public boolean A0(br element) {
        if ((this.f5363g & 1) == 0 || element.isInline() || h70.O.equals(element.j())) {
            return true;
        }
        return false;
    }

    public void F(br element, br parent) {
        if (parent != null && (parent.j() == null || h70.O.equals(parent.j()))) {
            element.b((h70) null);
        } else if ((this.f5363g & 1) != 0 && element.isInline() && element.j() == null) {
            if (parent == null || !parent.isInline()) {
                throw new IllegalArgumentException(i10.b("inline.elements.with.role.null.are.not.allowed", new Object[0]));
            }
        }
    }

    public boolean z0() {
        return this.f5359e;
    }

    /* access modifiers changed from: protected */
    public void Q() {
    }

    /* access modifiers changed from: protected */
    public void P() {
    }

    public p80 r0() {
        if (this.f5359e && this.f5332a == null) {
            this.f5332a = new p80(this);
        }
        return this.f5332a;
    }

    private static void f0(x50 order, d70 layer) {
        if (layer.X()) {
            if (layer.V() == null) {
                order.I(layer.d());
            }
            ArrayList<d70> T = layer.T();
            if (T != null) {
                x50 kids = new x50();
                if (layer.V() != null) {
                    kids.I(new n80(layer.V(), "UnicodeBig"));
                }
                for (int k2 = 0; k2 < T.size(); k2++) {
                    b6.a(T.get(k2));
                    f0(kids, (d70) null);
                }
                if (kids.size() > 0) {
                    order.I(kids);
                }
            }
        }
    }

    private void j(h70 event, h70 category) {
        x50 arr = new x50();
        Iterator i$ = this.f5327a.iterator();
        while (i$.hasNext()) {
            d70 layer = (d70) ((m70) i$.next());
            j60 usage = layer.K(h70.Rc);
            if (!(usage == null || usage.I(category) == null)) {
                arr.I(layer.d());
            }
        }
        if (arr.size() != 0) {
            j60 d2 = this.f5330a.K(h70.W1);
            h70 h70 = h70.Q;
            x50 arras = d2.J(h70);
            if (arras == null) {
                arras = new x50();
                d2.Q(h70, arras);
            }
            j60 as = new j60();
            as.Q(h70.v3, event);
            as.Q(h70.M0, new x50((o70) category));
            as.Q(h70.I7, arr);
            arras.I(as);
        }
    }

    /* access modifiers changed from: protected */
    public void O(boolean erase) {
        if (this.f5330a == null) {
            this.f5330a = new n70();
        }
        if (erase) {
            this.f5330a.S(h70.I7);
            this.f5330a.S(h70.W1);
        }
        if (this.f5330a.I(h70.I7) == null) {
            x50 gr = new x50();
            Iterator i$ = this.f5327a.iterator();
            while (i$.hasNext()) {
                gr.I(((d70) ((m70) i$.next())).d());
            }
            this.f5330a.Q(h70.I7, gr);
        }
        if (this.f5330a.I(h70.W1) == null) {
            ArrayList<PdfOCG> docOrder = new ArrayList<>(this.f5342b);
            Iterator<PdfOCG> it = docOrder.iterator();
            while (it.hasNext()) {
                ((d70) it.next()).U();
            }
            x50 order = new x50();
            Iterator i$2 = docOrder.iterator();
            while (i$2.hasNext()) {
                f0(order, (d70) ((m70) i$2.next()));
            }
            j60 d2 = new j60();
            this.f5330a.Q(h70.W1, d2);
            d2.Q(h70.a8, order);
            if (docOrder.size() > 0) {
                docOrder.get(0);
            }
            x50 gr2 = new x50();
            Iterator i$3 = this.f5327a.iterator();
            while (i$3.hasNext()) {
                d70 layer = (d70) ((m70) i$3.next());
                if (!layer.W()) {
                    gr2.I(layer.d());
                }
            }
            if (gr2.size() > 0) {
                d2.Q(h70.P7, gr2);
            }
            if (this.f5337a.size() > 0) {
                d2.Q(h70.z9, this.f5337a);
            }
            if (this.f5346b.size() > 0) {
                d2.Q(h70.z6, this.f5346b);
            }
            h70 h70 = h70.jd;
            j(h70, h70.ae);
            j(h70, h70);
            h70 h702 = h70.Z8;
            j(h702, h702);
            h70 h703 = h70.t3;
            j(h703, h703);
            d2.Q(h70.v6, h70.qd);
        }
    }

    public float p0() {
        return this.f5314a;
    }

    public j60 X() {
        return this.f5353d;
    }

    public void E0(h70 key, o70 cs) {
        if (cs == null || cs.B()) {
            this.f5353d.S(key);
        }
        this.f5353d.Q(key, cs);
    }

    /* access modifiers changed from: package-private */
    public w9 u(w5 color) {
        int type = dk.i(color);
        if (type == 4 || type == 5) {
            throw new RuntimeException(i10.b("an.uncolored.tile.pattern.can.not.have.another.pattern.or.shading.as.color", new Object[0]));
        }
        switch (type) {
            case 0:
                if (this.f5336a == null) {
                    this.f5336a = new w9(S(), this.f5334a.j(), (er) null);
                    x50 array = new x50((o70) h70.z8);
                    array.I(h70.s2);
                    z(array, this.f5336a.b());
                }
                return this.f5336a;
            case 1:
                if (this.f5345b == null) {
                    this.f5345b = new w9(S(), this.f5334a.j(), (er) null);
                    x50 array2 = new x50((o70) h70.z8);
                    array2.I(h70.r2);
                    z(array2, this.f5345b.b());
                }
                return this.f5345b;
            case 2:
                if (this.f5351c == null) {
                    this.f5351c = new w9(S(), this.f5334a.j(), (er) null);
                    x50 array3 = new x50((o70) h70.z8);
                    array3.I(h70.t2);
                    z(array3, this.f5351c.b());
                }
                return this.f5351c;
            case 3:
                w9 details = q(((qm0) color).k());
                w9 patternDetails = this.f5364g.get(details);
                if (patternDetails != null) {
                    return patternDetails;
                }
                w9 patternDetails2 = new w9(S(), this.f5334a.j(), (er) null);
                x50 array4 = new x50((o70) h70.z8);
                array4.I(details.b());
                z(array4, patternDetails2.b());
                this.f5364g.put(details, patternDetails2);
                return patternDetails2;
            default:
                try {
                    throw new RuntimeException(i10.b("invalid.color.type", new Object[0]));
                } catch (Exception e2) {
                    throw new RuntimeException(e2.getMessage());
                }
        }
    }

    public h70 l(tr image) {
        return m(image, (z60) null);
    }

    public h70 m(tr image, z60 fixedRef) {
        h70 name;
        byte[] globals;
        if (this.f5367h.containsKey(image.y0())) {
            return this.f5367h.get(image.y0());
        }
        if (image.N0()) {
            name = new h70("img" + this.f5367h.size());
            if (image instanceof zr) {
                try {
                    ((zr) image).u1(q80.S1(this, 0.0f, 0.0f));
                } catch (Exception e2) {
                    throw new ih(e2);
                }
            }
        } else {
            z60 dref = image.i0();
            if (dref != null) {
                h70 rname = new h70("img" + this.f5367h.size());
                this.f5367h.put(image.y0(), rname);
                this.f5357e.Q(rname, dref);
                return rname;
            }
            tr maskImage = image.k0();
            z60 maskRef = null;
            if (maskImage != null) {
                maskRef = c0(this.f5367h.get(maskImage.y0()));
            }
            w60 i2 = new w60(image, "img" + this.f5367h.size(), maskRef);
            if ((image instanceof wr) && (globals = ((wr) image).t1()) != null) {
                j60 decodeparms = new j60();
                decodeparms.Q(h70.T5, o0(globals));
                i2.Q(h70.f2, decodeparms);
            }
            if (image.K0()) {
                z60 iccRef = g(new v60(image.j0(), image.h0()));
                x50 iccArray = new x50();
                iccArray.I(h70.q5);
                iccArray.I(iccRef);
                h70 h70 = h70.n1;
                x50 colorspace = i2.J(h70);
                if (colorspace == null) {
                    i2.Q(h70, iccArray);
                } else if (colorspace.size() <= 1 || !h70.E5.equals(colorspace.S(0))) {
                    i2.Q(h70, iccArray);
                } else {
                    colorspace.U(1, iccArray);
                }
            }
            h(i2, fixedRef);
            name = i2.Z();
        }
        this.f5367h.put(image.y0(), name);
        return name;
    }

    /* access modifiers changed from: package-private */
    public z60 h(w60 pdfImage, z60 fixedRef) {
        if (this.f5357e.H(pdfImage.Z())) {
            return (z60) this.f5357e.I(pdfImage.Z());
        }
        H(this, 5, pdfImage);
        if (fixedRef == null) {
            try {
                fixedRef = y(pdfImage).a();
            } catch (IOException ioe) {
                throw new mj(ioe);
            }
        } else {
            z(pdfImage, fixedRef);
        }
        this.f5357e.Q(pdfImage.Z(), fixedRef);
        return fixedRef;
    }

    /* access modifiers changed from: package-private */
    public z60 c0(h70 name) {
        return (z60) this.f5357e.I(name);
    }

    /* access modifiers changed from: protected */
    public z60 g(v60 icc) {
        try {
            return y(icc).a();
        } catch (IOException ioe) {
            throw new mj(ioe);
        }
    }

    /* access modifiers changed from: protected */
    public z60 o0(byte[] content) {
        if (content == null) {
            return null;
        }
        for (m80 stream : this.f5368i.keySet()) {
            if (Arrays.equals(content, stream.q())) {
                return this.f5368i.get(stream);
            }
        }
        m80 stream2 = new m80(content);
        try {
            y60 ref = y(stream2);
            this.f5368i.put(stream2, ref.a());
            return ref.a();
        } catch (IOException e2) {
            return null;
        }
    }

    public boolean y0() {
        return this.f5365g;
    }

    protected static void F0(OutputStream os) {
        av0 version = av0.a();
        String k2 = version.b();
        if (k2 == null) {
            k2 = "iText";
        }
        os.write(fh.b(String.format("%%%s-%s\n", new Object[]{k2, version.c()})));
    }

    /* access modifiers changed from: protected */
    public vs0 t0() {
        if (this.f5335a == null) {
            this.f5335a = new vs0(this);
        }
        return this.f5335a;
    }

    public v50 M(pd0 rect, h70 subtype) {
        v50 a2 = new v50(this, rect);
        if (subtype != null) {
            a2.Q(h70.tb, subtype);
        }
        return a2;
    }

    public v50 L(float llx, float lly, float urx, float ury, n80 title, n80 content, h70 subtype) {
        h70 h70 = subtype;
        v50 a2 = new v50(this, llx, lly, urx, ury, title, content);
        if (h70 != null) {
            a2.Q(h70.tb, h70);
        }
        return a2;
    }

    public v50 K(float llx, float lly, float urx, float ury, u50 action, h70 subtype) {
        v50 a2 = new v50(this, llx, lly, urx, ury, action);
        if (subtype != null) {
            a2.Q(h70.tb, subtype);
        }
        return a2;
    }

    public static void H(v80 writer, int key, Object obj1) {
        if (writer != null) {
            writer.G(key, obj1);
        }
    }

    public void G(int key, Object obj1) {
        this.f5317a.b(key, obj1);
    }

    private void J(j60 info) {
        if (x0()) {
            h70 h70 = h70.M4;
            if (info.I(h70) == null) {
                if (((y80) this.f5317a).e()) {
                    info.Q(h70, new n80("PDF/X-1:2001"));
                    info.Q(new h70("GTS_PDFXConformance"), new n80("PDF/X-1a:2001"));
                } else if (((y80) this.f5317a).f()) {
                    info.Q(h70, new n80("PDF/X-3:2002"));
                }
            }
            h70 h702 = h70.Zb;
            if (info.I(h702) == null) {
                info.Q(h702, new n80("Pdf document"));
            }
            h70 h703 = h70.M1;
            if (info.I(h703) == null) {
                info.Q(h703, new n80("Unknown"));
            }
            h70 h704 = h70.pc;
            if (info.I(h704) == null) {
                info.Q(h704, new h70("False"));
            }
        }
    }

    private void I(j60 extraCatalog) {
        if (x0()) {
            h70 h70 = h70.i8;
            if (extraCatalog.I(h70) == null) {
                j60 out = new j60(h70.h8);
                out.Q(h70.f8, new n80("SWOP CGATS TR 001-1995"));
                out.Q(h70.g8, new n80("CGATS TR 001"));
                out.Q(h70.I9, new n80("http://www.color.org"));
                out.Q(h70.F5, new n80(""));
                out.Q(h70.ta, h70.L4);
                extraCatalog.Q(h70, new x50((o70) out));
            }
        }
    }

    public List<h70> q0() {
        if (this.f5333a.b() < '7') {
            return f5312b;
        }
        return f5313c;
    }
}
