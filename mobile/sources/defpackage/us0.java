package defpackage;

import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import com.itextpdf.text.pdf.fonts.otf.a;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: us0  reason: default package */
class us0 extends ss0 implements Comparator<int[]> {
    private static final List<a> a = Arrays.asList(new a[]{a.BENGALI});

    /* renamed from: a  reason: collision with other field name */
    private static final byte[] f5263a = {Byte.MIN_VALUE, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: a  reason: collision with other field name */
    private a f5264a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, lp> f5265a;

    us0(String ttFile, String enc, boolean emb, byte[] ttfAfm, boolean forceRead) {
        String nameBase = y5.i(ttFile);
        String ttcName = ss0.T(nameBase);
        if (nameBase.length() < ttFile.length()) {
            this.f5033d = ttFile.substring(nameBase.length());
        }
        this.f5821a = enc;
        this.f5824a = emb;
        this.f5025b = ttcName;
        this.f5030c = "";
        if (ttcName.length() < nameBase.length()) {
            this.f5030c = nameBase.substring(ttcName.length() + 1);
        }
        this.f5820a = 3;
        if ((this.f5025b.toLowerCase().endsWith(".ttf") || this.f5025b.toLowerCase().endsWith(".otf") || this.f5025b.toLowerCase().endsWith(".ttc")) && ((enc.equals("Identity-H") || enc.equals("Identity-V")) && emb)) {
            U(ttfAfm, forceRead);
            if (this.f5023a.f5047b != 2) {
                if ((this.f5034d == null && !this.f5830b) || (this.f5031c == null && this.f5830b)) {
                    this.f5832d = true;
                }
                if (this.f5830b) {
                    this.f5830b = false;
                    String tempEncoding = this.f5821a;
                    this.f5821a = "";
                    c();
                    this.f5821a = tempEncoding;
                    this.f5830b = true;
                }
                this.g = enc.endsWith("V");
                return;
            }
            throw new ih(i10.b("1.cannot.be.embedded.due.to.licensing.restrictions", this.f5025b + this.f5033d));
        }
        throw new ih(i10.b("1.2.is.not.a.ttf.font.file", this.f5025b, this.f5033d));
    }

    /* access modifiers changed from: package-private */
    public void U(byte[] ttfAfm, boolean preload) {
        super.U(ttfAfm, preload);
    }

    public int t(int char1) {
        if (this.g) {
            return 1000;
        }
        if (!this.f5830b) {
            return q(char1, this.f5821a);
        }
        if ((char1 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) == 0 || (65280 & char1) == 61440) {
            return q(char1 & 255, (String) null);
        }
        return 0;
    }

    public int u(String text) {
        if (this.g) {
            return text.length() * 1000;
        }
        int total = 0;
        if (this.f5830b) {
            for (char c : text.toCharArray()) {
                if ((c & 65280) == 0 || (65280 & c) == 61440) {
                    total += q(c & 255, (String) null);
                }
            }
        } else {
            int len = text.length();
            int k = 0;
            while (k < len) {
                if (tu0.h(text, k)) {
                    total += q(tu0.c(text, k), this.f5821a);
                    k++;
                } else {
                    total += q(text.charAt(k), this.f5821a);
                }
                k++;
            }
        }
        return total;
    }

    public m80 l0(Object[] metrics) {
        if (metrics.length == 0) {
            return null;
        }
        StringBuffer buf = new StringBuffer("/CIDInit /ProcSet findresource begin\n12 dict begin\nbegincmap\n/CIDSystemInfo\n<< /Registry (TTX+0)\n/Ordering (T42UV)\n/Supplement 0\n>> def\n/CMapName /TTX+0 def\n/CMapType 2 def\n1 begincodespacerange\n<0000><FFFF>\nendcodespacerange\n");
        int size = 0;
        for (int k = 0; k < metrics.length; k++) {
            if (size == 0) {
                if (k != 0) {
                    buf.append("endbfrange\n");
                }
                size = Math.min(100, metrics.length - k);
                buf.append(size);
                buf.append(" beginbfrange\n");
            }
            size--;
            int[] metric = metrics[k];
            String fromTo = m0(metric[0]);
            buf.append(fromTo);
            buf.append(fromTo);
            buf.append(m0(metric[2]));
            buf.append(10);
        }
        buf.append("endbfrange\nendcmap\nCMapName currentdict /CMap defineresource pop\nend end\n");
        m80 stream = new m80(n60.c(buf.toString(), (String) null));
        stream.T(this.f5829b);
        return stream;
    }

    private static String n0(int n) {
        String s = "0000" + Integer.toHexString(n);
        return s.substring(s.length() - 4);
    }

    static String m0(int n) {
        if (n < 65536) {
            return "<" + n0(n) + ">";
        }
        int n2 = n - 65536;
        return "[<" + n0((n2 / 1024) + 55296) + n0((n2 % 1024) + 56320) + ">]";
    }

    public j60 h0(z60 fontDescriptor, String subsetPrefix, Object[] metrics) {
        j60 dic = new j60(h70.c4);
        if (this.i) {
            dic.Q(h70.tb, h70.Z0);
            dic.Q(h70.c0, new h70(subsetPrefix + this.f5036e + "-" + this.f5821a));
        } else {
            dic.Q(h70.tb, h70.a1);
            dic.Q(h70.c0, new h70(subsetPrefix + this.f5036e));
        }
        dic.Q(h70.e4, fontDescriptor);
        if (!this.i) {
            dic.Q(h70.d1, h70.s5);
        }
        j60 cdic = new j60();
        cdic.Q(h70.H9, new n80("Adobe"));
        cdic.Q(h70.b8, new n80("Identity"));
        cdic.Q(h70.vb, new k70(0));
        dic.Q(h70.c1, cdic);
        if (!this.g) {
            dic.Q(h70.S2, new k70(1000));
            StringBuffer buf = new StringBuffer("[");
            int lastNumber = -10;
            boolean firstTime = true;
            for (int[] metric : metrics) {
                if (metric[1] != 1000) {
                    int m = metric[0];
                    if (m == lastNumber + 1) {
                        buf.append(' ');
                        buf.append(metric[1]);
                    } else {
                        if (!firstTime) {
                            buf.append(']');
                        }
                        firstTime = false;
                        buf.append(m);
                        buf.append('[');
                        buf.append(metric[1]);
                    }
                    lastNumber = m;
                }
            }
            if (buf.length() > 1) {
                buf.append("]]");
                dic.Q(h70.ud, new f70(buf.toString()));
            }
        }
        return dic;
    }

    public j60 i0(z60 descendant, String subsetPrefix, z60 toUnicode) {
        j60 dic = new j60(h70.c4);
        dic.Q(h70.tb, h70.Cc);
        if (this.i) {
            h70 h70 = h70.c0;
            dic.Q(h70, new h70(subsetPrefix + this.f5036e + "-" + this.f5821a));
        } else {
            h70 h702 = h70.c0;
            dic.Q(h702, new h70(subsetPrefix + this.f5036e));
        }
        dic.Q(h70.d3, new h70(this.f5821a));
        dic.Q(h70.m2, new x50((o70) descendant));
        if (toUnicode != null) {
            dic.Q(h70.gc, toUnicode);
        }
        return dic;
    }

    /* renamed from: g0 */
    public int compare(int[] o1, int[] o2) {
        int m1 = o1[0];
        int m2 = o2[0];
        if (m1 < m2) {
            return -1;
        }
        if (m1 == m2) {
            return 0;
        }
        return 1;
    }

    /* access modifiers changed from: package-private */
    public void E(v80 writer, z60 ref, Object[] params) {
        writer.t0().a(this, ref, params, f5263a);
    }

    public byte[] b(String text) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public byte[] a(int char1) {
        return null;
    }

    public int[] Q(int c) {
        HashMap<Integer, int[]> map;
        Character ch;
        HashMap<Integer, int[]> hashMap = this.f5037e;
        if (hashMap != null) {
            return hashMap.get(Integer.valueOf(c));
        }
        boolean z = this.f5830b;
        if (z) {
            map = this.f5031c;
        } else {
            map = this.f5034d;
        }
        if (map == null) {
            return null;
        }
        if (!z) {
            int[] result = map.get(Integer.valueOf(c));
            if (result != null || (ch = u3.f((char) c)) == null) {
                return result;
            }
            return map.get(Integer.valueOf(ch.charValue()));
        } else if ((c & InputDeviceCompat.SOURCE_ANY) == 0 || (c & InputDeviceCompat.SOURCE_ANY) == 61440) {
            return map.get(Integer.valueOf(c & 255));
        } else {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Map<String, lp> j0() {
        return this.f5265a;
    }

    /* access modifiers changed from: package-private */
    public a k0() {
        return this.f5264a;
    }
}
