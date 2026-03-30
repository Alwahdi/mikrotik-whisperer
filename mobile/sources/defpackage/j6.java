package defpackage;

import com.itextpdf.text.e;
import com.itextpdf.text.pdf.PdfChunk;
import java.util.ArrayList;
import java.util.List;

/* renamed from: j6  reason: default package */
public class j6 {
    protected static final ys a;

    /* renamed from: a  reason: collision with other field name */
    protected int f4033a;

    /* renamed from: a  reason: collision with other field name */
    protected ArrayList<b60> f4034a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    protected boolean f4035a = false;

    /* renamed from: a  reason: collision with other field name */
    protected byte[] f4036a = new byte[256];

    /* renamed from: a  reason: collision with other field name */
    protected char[] f4037a = new char[256];

    /* renamed from: a  reason: collision with other field name */
    protected int[] f4038a = new int[256];

    /* renamed from: a  reason: collision with other field name */
    protected b60[] f4039a = new b60[256];
    protected int b = 256;

    /* renamed from: b  reason: collision with other field name */
    protected boolean f4040b;

    /* renamed from: b  reason: collision with other field name */
    protected byte[] f4041b = new byte[0];

    /* renamed from: b  reason: collision with other field name */
    protected char[] f4042b = new char[0];

    /* renamed from: b  reason: collision with other field name */
    protected int[] f4043b = new int[0];

    /* renamed from: b  reason: collision with other field name */
    protected b60[] f4044b = new b60[0];
    protected int c = 0;
    protected int d = 0;
    protected int e = 0;
    protected int f = 0;
    protected int g;
    protected int h = 0;
    protected int i = 0;
    protected int j = 0;
    protected int k = 0;
    protected int l;

    static {
        ys ysVar = new ys();
        a = ysVar;
        ysVar.d(40, 41);
        ysVar.d(41, 40);
        ysVar.d(60, 62);
        ysVar.d(62, 60);
        ysVar.d(91, 93);
        ysVar.d(93, 91);
        ysVar.d(123, 125);
        ysVar.d(125, 123);
        ysVar.d(171, 187);
        ysVar.d(187, 171);
        ysVar.d(8249, 8250);
        ysVar.d(8250, 8249);
        ysVar.d(8261, 8262);
        ysVar.d(8262, 8261);
        ysVar.d(8317, 8318);
        ysVar.d(8318, 8317);
        ysVar.d(8333, 8334);
        ysVar.d(8334, 8333);
        ysVar.d(8712, 8715);
        ysVar.d(8713, 8716);
        ysVar.d(8714, 8717);
        ysVar.d(8715, 8712);
        ysVar.d(8716, 8713);
        ysVar.d(8717, 8714);
        ysVar.d(8725, 10741);
        ysVar.d(8764, 8765);
        ysVar.d(8765, 8764);
        ysVar.d(8771, 8909);
        ysVar.d(8786, 8787);
        ysVar.d(8787, 8786);
        ysVar.d(8788, 8789);
        ysVar.d(8789, 8788);
        ysVar.d(8804, 8805);
        ysVar.d(8805, 8804);
        ysVar.d(8806, 8807);
        ysVar.d(8807, 8806);
        ysVar.d(8808, 8809);
        ysVar.d(8809, 8808);
        ysVar.d(8810, 8811);
        ysVar.d(8811, 8810);
        ysVar.d(8814, 8815);
        ysVar.d(8815, 8814);
        ysVar.d(8816, 8817);
        ysVar.d(8817, 8816);
        ysVar.d(8818, 8819);
        ysVar.d(8819, 8818);
        ysVar.d(8820, 8821);
        ysVar.d(8821, 8820);
        ysVar.d(8822, 8823);
        ysVar.d(8823, 8822);
        ysVar.d(8824, 8825);
        ysVar.d(8825, 8824);
        ysVar.d(8826, 8827);
        ysVar.d(8827, 8826);
        ysVar.d(8828, 8829);
        ysVar.d(8829, 8828);
        ysVar.d(8830, 8831);
        ysVar.d(8831, 8830);
        ysVar.d(8832, 8833);
        ysVar.d(8833, 8832);
        ysVar.d(8834, 8835);
        ysVar.d(8835, 8834);
        ysVar.d(8836, 8837);
        ysVar.d(8837, 8836);
        ysVar.d(8838, 8839);
        ysVar.d(8839, 8838);
        ysVar.d(8840, 8841);
        ysVar.d(8841, 8840);
        ysVar.d(8842, 8843);
        ysVar.d(8843, 8842);
        ysVar.d(8847, 8848);
        ysVar.d(8848, 8847);
        ysVar.d(8849, 8850);
        ysVar.d(8850, 8849);
        ysVar.d(8856, 10680);
        ysVar.d(8866, 8867);
        ysVar.d(8867, 8866);
        ysVar.d(8870, 10974);
        ysVar.d(8872, 10980);
        ysVar.d(8873, 10979);
        ysVar.d(8875, 10981);
        ysVar.d(8880, 8881);
        ysVar.d(8881, 8880);
        ysVar.d(8882, 8883);
        ysVar.d(8883, 8882);
        ysVar.d(8884, 8885);
        ysVar.d(8885, 8884);
        ysVar.d(8886, 8887);
        ysVar.d(8887, 8886);
        ysVar.d(8905, 8906);
        ysVar.d(8906, 8905);
        ysVar.d(8907, 8908);
        ysVar.d(8908, 8907);
        ysVar.d(8909, 8771);
        ysVar.d(8912, 8913);
        ysVar.d(8913, 8912);
        ysVar.d(8918, 8919);
        ysVar.d(8919, 8918);
        ysVar.d(8920, 8921);
        ysVar.d(8921, 8920);
        ysVar.d(8922, 8923);
        ysVar.d(8923, 8922);
        ysVar.d(8924, 8925);
        ysVar.d(8925, 8924);
        ysVar.d(8926, 8927);
        ysVar.d(8927, 8926);
        ysVar.d(8928, 8929);
        ysVar.d(8929, 8928);
        ysVar.d(8930, 8931);
        ysVar.d(8931, 8930);
        ysVar.d(8932, 8933);
        ysVar.d(8933, 8932);
        ysVar.d(8934, 8935);
        ysVar.d(8935, 8934);
        ysVar.d(8936, 8937);
        ysVar.d(8937, 8936);
        ysVar.d(8938, 8939);
        ysVar.d(8939, 8938);
        ysVar.d(8940, 8941);
        ysVar.d(8941, 8940);
        ysVar.d(8944, 8945);
        ysVar.d(8945, 8944);
        ysVar.d(8946, 8954);
        ysVar.d(8947, 8955);
        ysVar.d(8948, 8956);
        ysVar.d(8950, 8957);
        ysVar.d(8951, 8958);
        ysVar.d(8954, 8946);
        ysVar.d(8955, 8947);
        ysVar.d(8956, 8948);
        ysVar.d(8957, 8950);
        ysVar.d(8958, 8951);
        ysVar.d(8968, 8969);
        ysVar.d(8969, 8968);
        ysVar.d(8970, 8971);
        ysVar.d(8971, 8970);
        ysVar.d(9001, 9002);
        ysVar.d(9002, 9001);
        ysVar.d(10088, 10089);
        ysVar.d(10089, 10088);
        ysVar.d(10090, 10091);
        ysVar.d(10091, 10090);
        ysVar.d(10092, 10093);
        ysVar.d(10093, 10092);
        ysVar.d(10094, 10095);
        ysVar.d(10095, 10094);
        ysVar.d(10096, 10097);
        ysVar.d(10097, 10096);
        ysVar.d(10098, 10099);
        ysVar.d(10099, 10098);
        ysVar.d(10100, 10101);
        ysVar.d(10101, 10100);
        ysVar.d(10197, 10198);
        ysVar.d(10198, 10197);
        ysVar.d(10205, 10206);
        ysVar.d(10206, 10205);
        ysVar.d(10210, 10211);
        ysVar.d(10211, 10210);
        ysVar.d(10212, 10213);
        ysVar.d(10213, 10212);
        ysVar.d(10214, 10215);
        ysVar.d(10215, 10214);
        ysVar.d(10216, 10217);
        ysVar.d(10217, 10216);
        ysVar.d(10218, 10219);
        ysVar.d(10219, 10218);
        ysVar.d(10627, 10628);
        ysVar.d(10628, 10627);
        ysVar.d(10629, 10630);
        ysVar.d(10630, 10629);
        ysVar.d(10631, 10632);
        ysVar.d(10632, 10631);
        ysVar.d(10633, 10634);
        ysVar.d(10634, 10633);
        ysVar.d(10635, 10636);
        ysVar.d(10636, 10635);
        ysVar.d(10637, 10640);
        ysVar.d(10638, 10639);
        ysVar.d(10639, 10638);
        ysVar.d(10640, 10637);
        ysVar.d(10641, 10642);
        ysVar.d(10642, 10641);
        ysVar.d(10643, 10644);
        ysVar.d(10644, 10643);
        ysVar.d(10645, 10646);
        ysVar.d(10646, 10645);
        ysVar.d(10647, 10648);
        ysVar.d(10648, 10647);
        ysVar.d(10680, 8856);
        ysVar.d(10688, 10689);
        ysVar.d(10689, 10688);
        ysVar.d(10692, 10693);
        ysVar.d(10693, 10692);
        ysVar.d(10703, 10704);
        ysVar.d(10704, 10703);
        ysVar.d(10705, 10706);
        ysVar.d(10706, 10705);
        ysVar.d(10708, 10709);
        ysVar.d(10709, 10708);
        ysVar.d(10712, 10713);
        ysVar.d(10713, 10712);
        ysVar.d(10714, 10715);
        ysVar.d(10715, 10714);
        ysVar.d(10741, 8725);
        ysVar.d(10744, 10745);
        ysVar.d(10745, 10744);
        ysVar.d(10748, 10749);
        ysVar.d(10749, 10748);
        ysVar.d(10795, 10796);
        ysVar.d(10796, 10795);
        ysVar.d(10797, 10796);
        ysVar.d(10798, 10797);
        ysVar.d(10804, 10805);
        ysVar.d(10805, 10804);
        ysVar.d(10812, 10813);
        ysVar.d(10813, 10812);
        ysVar.d(10852, 10853);
        ysVar.d(10853, 10852);
        ysVar.d(10873, 10874);
        ysVar.d(10874, 10873);
        ysVar.d(10877, 10878);
        ysVar.d(10878, 10877);
        ysVar.d(10879, 10880);
        ysVar.d(10880, 10879);
        ysVar.d(10881, 10882);
        ysVar.d(10882, 10881);
        ysVar.d(10883, 10884);
        ysVar.d(10884, 10883);
        ysVar.d(10891, 10892);
        ysVar.d(10892, 10891);
        ysVar.d(10897, 10898);
        ysVar.d(10898, 10897);
        ysVar.d(10899, 10900);
        ysVar.d(10900, 10899);
        ysVar.d(10901, 10902);
        ysVar.d(10902, 10901);
        ysVar.d(10903, 10904);
        ysVar.d(10904, 10903);
        ysVar.d(10905, 10906);
        ysVar.d(10906, 10905);
        ysVar.d(10907, 10908);
        ysVar.d(10908, 10907);
        ysVar.d(10913, 10914);
        ysVar.d(10914, 10913);
        ysVar.d(10918, 10919);
        ysVar.d(10919, 10918);
        ysVar.d(10920, 10921);
        ysVar.d(10921, 10920);
        ysVar.d(10922, 10923);
        ysVar.d(10923, 10922);
        ysVar.d(10924, 10925);
        ysVar.d(10925, 10924);
        ysVar.d(10927, 10928);
        ysVar.d(10928, 10927);
        ysVar.d(10931, 10932);
        ysVar.d(10932, 10931);
        ysVar.d(10939, 10940);
        ysVar.d(10940, 10939);
        ysVar.d(10941, 10942);
        ysVar.d(10942, 10941);
        ysVar.d(10943, 10944);
        ysVar.d(10944, 10943);
        ysVar.d(10945, 10946);
        ysVar.d(10946, 10945);
        ysVar.d(10947, 10948);
        ysVar.d(10948, 10947);
        ysVar.d(10949, 10950);
        ysVar.d(10950, 10949);
        ysVar.d(10957, 10958);
        ysVar.d(10958, 10957);
        ysVar.d(10959, 10960);
        ysVar.d(10960, 10959);
        ysVar.d(10961, 10962);
        ysVar.d(10962, 10961);
        ysVar.d(10963, 10964);
        ysVar.d(10964, 10963);
        ysVar.d(10965, 10966);
        ysVar.d(10966, 10965);
        ysVar.d(10974, 8870);
        ysVar.d(10979, 8873);
        ysVar.d(10980, 8872);
        ysVar.d(10981, 8875);
        ysVar.d(10988, 10989);
        ysVar.d(10989, 10988);
        ysVar.d(10999, 11000);
        ysVar.d(11000, 10999);
        ysVar.d(11001, 11002);
        ysVar.d(11002, 11001);
        ysVar.d(12296, 12297);
        ysVar.d(12297, 12296);
        ysVar.d(12298, 12299);
        ysVar.d(12299, 12298);
        ysVar.d(12300, 12301);
        ysVar.d(12301, 12300);
        ysVar.d(12302, 12303);
        ysVar.d(12303, 12302);
        ysVar.d(12304, 12305);
        ysVar.d(12305, 12304);
        ysVar.d(12308, 12309);
        ysVar.d(12309, 12308);
        ysVar.d(12310, 12311);
        ysVar.d(12311, 12310);
        ysVar.d(12312, 12313);
        ysVar.d(12313, 12312);
        ysVar.d(12314, 12315);
        ysVar.d(12315, 12314);
        ysVar.d(65288, 65289);
        ysVar.d(65289, 65288);
        ysVar.d(65308, 65310);
        ysVar.d(65310, 65308);
        ysVar.d(65339, 65341);
        ysVar.d(65341, 65339);
        ysVar.d(65371, 65373);
        ysVar.d(65373, 65371);
        ysVar.d(65375, 65376);
        ysVar.d(65376, 65375);
        ysVar.d(65378, 65379);
        ysVar.d(65379, 65378);
    }

    public j6() {
    }

    public j6(j6 org2) {
        this.f4033a = org2.f4033a;
        this.b = org2.b;
        this.f4037a = (char[]) org2.f4037a.clone();
        this.f4039a = (b60[]) org2.f4039a.clone();
        this.c = org2.c;
        this.f4036a = (byte[]) org2.f4036a.clone();
        this.f4038a = (int[]) org2.f4038a.clone();
        this.f4034a = new ArrayList<>(org2.f4034a);
        this.d = org2.d;
        this.e = org2.e;
        this.f = org2.f;
        this.g = org2.g;
        this.f4042b = (char[]) org2.f4042b.clone();
        this.f4044b = (b60[]) org2.f4044b.clone();
        this.h = org2.h;
        this.f4041b = (byte[]) org2.f4041b.clone();
        this.f4043b = (int[]) org2.f4043b.clone();
        this.i = org2.i;
        this.j = org2.j;
        this.k = org2.k;
        this.f4040b = org2.f4040b;
        this.l = org2.l;
    }

    public boolean k() {
        return this.f >= this.c && this.d >= this.f4034a.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0061, code lost:
        r1 = r11.e + 1;
        r11.e = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0066, code lost:
        if (r1 < r6) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0068, code lost:
        r11.e = 0;
        r11.d++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        if (r11.c != 0) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0074, code lost:
        r11.f4039a[0] = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0078, code lost:
        r1 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean g(int r12) {
        /*
            r11 = this;
            r11.f4033a = r12
            r0 = 0
            r11.f = r0
            r11.c = r0
            r1 = 0
        L_0x0008:
            int r2 = r11.d
            java.util.ArrayList<b60> r3 = r11.f4034a
            int r3 = r3.size()
            r4 = 1
            if (r2 >= r3) goto L_0x0084
            java.util.ArrayList<b60> r2 = r11.f4034a
            int r3 = r11.d
            java.lang.Object r2 = r2.get(r3)
            b60 r2 = (defpackage.b60) r2
            r60 r3 = r2.d()
            y5 r3 = r3.c()
            java.lang.String r5 = r2.toString()
            int r6 = r5.length()
        L_0x002d:
            int r7 = r11.e
            if (r7 >= r6) goto L_0x0079
            char r7 = r5.charAt(r7)
            int r8 = r3.s(r7)
            char r8 = (char) r8
            r9 = 10
            r10 = 13
            if (r8 == r10) goto L_0x004c
            if (r8 != r9) goto L_0x0043
            goto L_0x004c
        L_0x0043:
            r11.b(r7, r2)
            int r7 = r11.e
            int r7 = r7 + r4
            r11.e = r7
            goto L_0x002d
        L_0x004c:
            if (r8 != r10) goto L_0x0061
            int r1 = r11.e
            int r3 = r1 + 1
            if (r3 >= r6) goto L_0x0061
            int r1 = r1 + 1
            char r1 = r5.charAt(r1)
            if (r1 != r9) goto L_0x0061
            int r1 = r11.e
            int r1 = r1 + r4
            r11.e = r1
        L_0x0061:
            int r1 = r11.e
            int r1 = r1 + r4
            r11.e = r1
            if (r1 < r6) goto L_0x006f
            r11.e = r0
            int r1 = r11.d
            int r1 = r1 + r4
            r11.d = r1
        L_0x006f:
            int r1 = r11.c
            if (r1 != 0) goto L_0x0078
            b60[] r1 = r11.f4039a
            r1[r0] = r2
        L_0x0078:
            r1 = 1
        L_0x0079:
            if (r1 == 0) goto L_0x007c
            goto L_0x0084
        L_0x007c:
            r11.e = r0
            int r2 = r11.d
            int r2 = r2 + r4
            r11.d = r2
            goto L_0x0008
        L_0x0084:
            int r2 = r11.c
            if (r2 != 0) goto L_0x0089
            return r1
        L_0x0089:
            int r2 = r2 - r4
            int r1 = r11.u(r0, r2)
            int r1 = r1 + r4
            r11.c = r1
            if (r1 != 0) goto L_0x0094
            return r4
        L_0x0094:
            if (r12 == r4) goto L_0x00db
            byte[] r2 = r11.f4036a
            int r2 = r2.length
            if (r2 >= r1) goto L_0x00a5
            int r2 = r11.b
            byte[] r3 = new byte[r2]
            r11.f4036a = r3
            int[] r2 = new int[r2]
            r11.f4038a = r2
        L_0x00a5:
            char[] r2 = r11.f4037a
            int r3 = r11.l
            defpackage.u3.i(r2, r0, r1, r3)
            switch(r12) {
                case 2: goto L_0x00b4;
                case 3: goto L_0x00b1;
                default: goto L_0x00af;
            }
        L_0x00af:
            r12 = -1
            goto L_0x00b6
        L_0x00b1:
            r12 = 1
            goto L_0x00b6
        L_0x00b4:
            r12 = 0
        L_0x00b6:
            k6 r1 = new k6
            char[] r2 = r11.f4037a
            int r3 = r11.c
            r1.<init>(r2, r0, r3, r12)
            byte[] r12 = r1.e()
            r1 = 0
        L_0x00c4:
            int r2 = r11.c
            if (r1 >= r2) goto L_0x00d5
            byte[] r2 = r11.f4036a
            byte r3 = r12[r1]
            r2[r1] = r3
            int[] r2 = r11.f4038a
            r2[r1] = r1
            int r1 = r1 + 1
            goto L_0x00c4
        L_0x00d5:
            r11.e()
            r11.n()
        L_0x00db:
            int r12 = r11.c
            int r12 = r12 - r4
            int r12 = r11.v(r0, r12)
            int r12 = r12 + r4
            r11.c = r12
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.j6.g(int):boolean");
    }

    public void a(b60 chunk) {
        this.f4034a.add(chunk);
    }

    public void b(char c2, b60 chunk) {
        int i2 = this.c;
        int i3 = this.b;
        if (i2 >= i3) {
            char[] tempText = this.f4037a;
            b60[] tempDetailChunks = this.f4039a;
            int i4 = i3 * 2;
            this.b = i4;
            char[] cArr = new char[i4];
            this.f4037a = cArr;
            this.f4039a = new b60[i4];
            System.arraycopy(tempText, 0, cArr, 0, i2);
            System.arraycopy(tempDetailChunks, 0, this.f4039a, 0, this.c);
        }
        char[] cArr2 = this.f4037a;
        int i5 = this.c;
        cArr2[i5] = c2;
        b60[] b60Arr = this.f4039a;
        this.c = i5 + 1;
        b60Arr[i5] = chunk;
    }

    public void s() {
        int i2 = this.d;
        if (i2 > 0) {
            if (i2 < this.f4034a.size()) {
                while (true) {
                    this.d--;
                    int i3 = this.d;
                    if (i3 < 0) {
                        break;
                    }
                    this.f4034a.remove(i3);
                }
            } else {
                this.f4034a.clear();
            }
            this.d = 0;
        }
        this.g = this.f4033a;
        int i4 = this.c;
        this.h = i4;
        this.i = this.d;
        this.j = this.e;
        int i5 = this.f;
        this.k = i5;
        boolean z = i5 < i4;
        this.f4040b = z;
        if (!z) {
            if (this.f4042b.length < i4) {
                this.f4042b = new char[i4];
                this.f4044b = new b60[i4];
            }
            System.arraycopy(this.f4037a, 0, this.f4042b, 0, i4);
            System.arraycopy(this.f4039a, 0, this.f4044b, 0, this.c);
        }
        if (this.f4033a != 1) {
            int length = this.f4041b.length;
            int i6 = this.c;
            if (length < i6) {
                this.f4041b = new byte[i6];
                this.f4043b = new int[i6];
            }
            byte[] bArr = this.f4036a;
            int i7 = this.f;
            System.arraycopy(bArr, i7, this.f4041b, i7, i6 - i7);
            int[] iArr = this.f4038a;
            int i8 = this.f;
            System.arraycopy(iArr, i8, this.f4043b, i8, this.c - i8);
        }
    }

    public void r() {
        this.f4033a = this.g;
        int i2 = this.h;
        this.c = i2;
        this.d = this.i;
        this.e = this.j;
        this.f = this.k;
        if (!this.f4040b) {
            System.arraycopy(this.f4042b, 0, this.f4037a, 0, i2);
            System.arraycopy(this.f4044b, 0, this.f4039a, 0, this.c);
        }
        if (this.f4033a != 1) {
            byte[] bArr = this.f4041b;
            int i3 = this.f;
            System.arraycopy(bArr, i3, this.f4036a, i3, this.c - i3);
            int[] iArr = this.f4043b;
            int i4 = this.f;
            System.arraycopy(iArr, i4, this.f4038a, i4, this.c - i4);
        }
    }

    public void n() {
        int mirror;
        for (int k2 = 0; k2 < this.c; k2++) {
            if ((this.f4036a[k2] & 1) == 1 && (mirror = a.b(this.f4037a[k2])) != 0) {
                this.f4037a[k2] = (char) mirror;
            }
        }
    }

    public void e() {
        char c2;
        char[] cArr;
        char c3;
        int src = 0;
        int dest = 0;
        while (true) {
            int i2 = this.c;
            if (src < i2 && ((c3 = cArr[src]) < 1536 || c3 > 1791)) {
                if (src != dest) {
                    cArr[dest] = (cArr = this.f4037a)[src];
                    b60[] b60Arr = this.f4039a;
                    b60Arr[dest] = b60Arr[src];
                    byte[] bArr = this.f4036a;
                    bArr[dest] = bArr[src];
                }
                src++;
                dest++;
            } else if (src >= i2) {
                this.c = dest;
                return;
            } else {
                int startArabicIdx = src;
                while (true) {
                    src++;
                    if (src >= this.c || (c2 = this.f4037a[src]) < 1536 || c2 > 1791) {
                        int arabicWordSize = src - startArabicIdx;
                        char[] cArr2 = this.f4037a;
                        int size = u3.a(cArr2, startArabicIdx, arabicWordSize, cArr2, dest, arabicWordSize, this.l);
                    }
                }
                int arabicWordSize2 = src - startArabicIdx;
                char[] cArr22 = this.f4037a;
                int size2 = u3.a(cArr22, startArabicIdx, arabicWordSize2, cArr22, dest, arabicWordSize2, this.l);
                if (startArabicIdx != dest) {
                    int k2 = 0;
                    while (k2 < size2) {
                        b60[] b60Arr2 = this.f4039a;
                        b60Arr2[dest] = b60Arr2[startArabicIdx];
                        byte[] bArr2 = this.f4036a;
                        bArr2[dest] = bArr2[startArabicIdx];
                        k2++;
                        dest++;
                        startArabicIdx++;
                    }
                } else {
                    dest += size2;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0215  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public defpackage.e70 o(float r34, float r35, int r36, int r37, int r38, float r39, float r40, float r41) {
        /*
            r33 = this;
            r15 = r33
            r14 = r37
            r13 = 0
            r15.f4035a = r13
            r12 = r38
            r15.l = r12
            r33.s()
            r11 = 1
            r0 = 3
            if (r14 != r0) goto L_0x0014
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            r24 = r0
            int r0 = r15.f
            int r1 = r15.c
            if (r0 < r1) goto L_0x004f
            boolean r0 = r15.g(r14)
            if (r0 != 0) goto L_0x0025
            r1 = 0
            return r1
        L_0x0025:
            int r1 = r15.c
            if (r1 != 0) goto L_0x004f
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r9 = r1
            b60 r1 = new b60
            b60[] r2 = r15.f4039a
            r2 = r2[r13]
            java.lang.String r3 = ""
            r1.<init>((java.lang.String) r3, (defpackage.b60) r2)
            r10 = r1
            r9.add(r10)
            e70 r11 = new e70
            r2 = 0
            r3 = 0
            r6 = 1
            r1 = r11
            r4 = r35
            r5 = r36
            r7 = r9
            r8 = r24
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r11
        L_0x004f:
            r10 = r35
            r0 = -1
            int r1 = r15.f
            if (r1 == 0) goto L_0x005f
            int r2 = r15.c
            int r2 = r2 - r11
            int r1 = r15.t(r1, r2)
            r15.f = r1
        L_0x005f:
            int r9 = r15.f
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r6 = 2143289344(0x7fc00000, float:NaN)
            r8 = 2143289344(0x7fc00000, float:NaN)
            r16 = 0
            r25 = r5
            r26 = r6
            r27 = r8
            r8 = r35
            r6 = r4
        L_0x007a:
            int r4 = r15.f
            int r5 = r15.c
            if (r4 >= r5) goto L_0x02aa
            b60[] r5 = r15.f4039a
            r5 = r5[r4]
            boolean r2 = r5.x()
            if (r2 == 0) goto L_0x00cf
            int r2 = (r39 > r40 ? 1 : (r39 == r40 ? 0 : -1))
            if (r2 >= 0) goto L_0x00cf
            tr r2 = r5.g()
            boolean r4 = r2.S0()
            if (r4 == 0) goto L_0x00cf
            r4 = 1073741824(0x40000000, float:2.0)
            float r17 = r41 * r4
            float r17 = r40 + r17
            float r18 = r2.A0()
            float r17 = r17 - r18
            float r18 = r5.j()
            float r17 = r17 - r18
            float r18 = r2.c()
            float r17 = r17 - r18
            int r17 = (r17 > r39 ? 1 : (r17 == r39 ? 0 : -1))
            if (r17 >= 0) goto L_0x00cf
            float r4 = r4 * r41
            float r4 = r40 + r4
            float r17 = r5.j()
            float r4 = r4 - r17
            float r17 = r2.c()
            float r4 = r4 - r17
            float r4 = r4 - r39
            float r17 = r2.A0()
            float r4 = r4 / r17
            r5.G(r4)
        L_0x00cf:
            char[] r2 = r15.f4037a
            int r4 = r15.f
            boolean r28 = defpackage.tu0.i(r2, r4)
            if (r28 == 0) goto L_0x00e7
            char[] r2 = r15.f4037a
            int r4 = r15.f
            int r2 = defpackage.tu0.d(r2, r4)
            int r1 = r5.q(r2)
            r4 = r1
            goto L_0x00f2
        L_0x00e7:
            char[] r2 = r15.f4037a
            int r4 = r15.f
            char r2 = r2[r4]
            int r1 = r5.q(r2)
            r4 = r1
        L_0x00f2:
            boolean r1 = defpackage.b60.F(r4)
            if (r1 == 0) goto L_0x00ff
            r2 = r4
            r13 = r5
            r4 = 0
            r5 = r34
            goto L_0x029e
        L_0x00ff:
            if (r28 == 0) goto L_0x0106
            float r1 = r5.f(r4)
            goto L_0x011b
        L_0x0106:
            boolean r1 = r5.x()
            if (r1 == 0) goto L_0x0111
            float r1 = r5.l()
            goto L_0x011b
        L_0x0111:
            char[] r1 = r15.f4037a
            int r2 = r15.f
            char r1 = r1[r2]
            float r1 = r5.f(r1)
        L_0x011b:
            float r2 = r8 - r1
            r3 = 0
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x0141
            if (r6 != 0) goto L_0x0141
            boolean r2 = r5.x()
            if (r2 == 0) goto L_0x0141
            tr r2 = r5.g()
            boolean r16 = r2.T0()
            if (r16 == 0) goto L_0x0141
            float r16 = r2.M()
            float r3 = r8 / r16
            r5.G(r3)
            r1 = r8
            r29 = r1
            goto L_0x0143
        L_0x0141:
            r29 = r1
        L_0x0143:
            boolean r1 = r5.C()
            if (r1 == 0) goto L_0x0215
            java.lang.String r1 = "TABSETTINGS"
            boolean r1 = r5.u(r1)
            if (r1 == 0) goto L_0x01c2
            int r3 = r15.f
            if (r25 == 0) goto L_0x016d
            r0 = r33
            r1 = r25
            r2 = r27
            r16 = r3
            r3 = r10
            r30 = r4
            r4 = r8
            r13 = r5
            r5 = r26
            r31 = r6
            r6 = r24
            float r8 = r0.p(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x0174
        L_0x016d:
            r16 = r3
            r30 = r4
            r13 = r5
            r31 = r6
        L_0x0174:
            float r0 = r10 - r8
            com.itextpdf.text.e r0 = defpackage.b60.o(r13, r0)
            float r1 = r0.d()
            int r1 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r1 <= 0) goto L_0x0191
            r25 = 0
            r5 = r34
            r6 = r8
            r2 = r13
            r0 = r16
            r3 = r29
            r1 = r30
            r4 = 0
            goto L_0x02b2
        L_0x0191:
            r13.H(r0)
            if (r24 != 0) goto L_0x01b3
            com.itextpdf.text.e$b r1 = r0.a()
            com.itextpdf.text.e$b r2 = com.itextpdf.text.e.b.LEFT
            if (r1 != r2) goto L_0x01b3
            float r1 = r0.d()
            float r8 = r10 - r1
            r25 = 0
            r27 = 2143289344(0x7fc00000, float:NaN)
            r26 = 2143289344(0x7fc00000, float:NaN)
            r5 = r34
            r0 = r16
            r2 = r30
            r4 = 0
            goto L_0x0293
        L_0x01b3:
            float r27 = r10 - r8
            r26 = 2143289344(0x7fc00000, float:NaN)
            r5 = r34
            r25 = r0
            r0 = r16
            r2 = r30
            r4 = 0
            goto L_0x0293
        L_0x01c2:
            r30 = r4
            r13 = r5
            r31 = r6
            java.lang.String r1 = "TAB"
            java.lang.Object r1 = r13.e(r1)
            java.lang.Object[] r1 = (java.lang.Object[]) r1
            r2 = r1[r11]
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            r3 = 2
            r3 = r1[r3]
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0203
            float r4 = r10 - r8
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x0203
            e70 r4 = new e70
            r17 = 0
            r21 = 1
            int r5 = r15.f
            int r5 = r5 - r11
            java.util.ArrayList r22 = r15.c(r9, r5)
            r16 = r4
            r18 = r10
            r19 = r8
            r20 = r36
            r23 = r24
            r16.<init>(r17, r18, r19, r20, r21, r22, r23)
            return r4
        L_0x0203:
            b60[] r4 = r15.f4039a
            int r5 = r15.f
            r4 = r4[r5]
            r5 = r34
            r4.a(r5)
            float r8 = r10 - r2
            r2 = r30
            r4 = 0
            goto L_0x0293
        L_0x0215:
            r30 = r4
            r13 = r5
            r31 = r6
            r5 = r34
            boolean r1 = r13.z()
            if (r1 == 0) goto L_0x023c
            java.lang.String r1 = "SEPARATOR"
            java.lang.Object r1 = r13.e(r1)
            java.lang.Object[] r1 = (java.lang.Object[]) r1
            r4 = 0
            r2 = r1[r4]
            xh r2 = (defpackage.xh) r2
            r3 = r1[r11]
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r6 = r3.booleanValue()
            if (r6 == 0) goto L_0x0239
        L_0x0239:
            r2 = r30
            goto L_0x0293
        L_0x023c:
            r4 = 0
            int r1 = r15.f
            int r2 = r15.c
            char[] r3 = r15.f4037a
            b60[] r6 = r15.f4039a
            r16 = r13
            r17 = r9
            r18 = r1
            r19 = r2
            r20 = r3
            r21 = r6
            boolean r1 = r16.v(r17, r18, r19, r20, r21)
            if (r1 == 0) goto L_0x0263
            r2 = r30
            char r3 = (char) r2
            boolean r3 = java.lang.Character.isWhitespace(r3)
            if (r3 == 0) goto L_0x0265
            int r0 = r15.f
            goto L_0x0265
        L_0x0263:
            r2 = r30
        L_0x0265:
            float r3 = r8 - r29
            r6 = 0
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 >= 0) goto L_0x0272
            r1 = r2
            r6 = r8
            r2 = r13
            r3 = r29
            goto L_0x02b2
        L_0x0272:
            if (r25 == 0) goto L_0x028d
            com.itextpdf.text.e$b r3 = r25.a()
            com.itextpdf.text.e$b r6 = com.itextpdf.text.e.b.ANCHOR
            if (r3 != r6) goto L_0x028d
            boolean r3 = java.lang.Float.isNaN(r26)
            if (r3 == 0) goto L_0x028d
            char r3 = r25.b()
            char r6 = (char) r2
            if (r3 != r6) goto L_0x028d
            float r3 = r10 - r8
            r26 = r3
        L_0x028d:
            float r8 = r8 - r29
            if (r1 == 0) goto L_0x0293
            int r0 = r15.f
        L_0x0293:
            r1 = r13
            if (r28 == 0) goto L_0x029b
            int r3 = r15.f
            int r3 = r3 + r11
            r15.f = r3
        L_0x029b:
            r6 = r1
            r3 = r29
        L_0x029e:
            int r1 = r15.f
            int r1 = r1 + r11
            r15.f = r1
            r1 = r2
            r2 = r13
            r16 = r28
            r13 = 0
            goto L_0x007a
        L_0x02aa:
            r5 = r34
            r31 = r6
            r4 = 0
            r6 = r8
            r28 = r16
        L_0x02b2:
            r13 = r31
            if (r13 != 0) goto L_0x02df
            int r4 = r15.f
            int r4 = r4 + r11
            r15.f = r4
            if (r28 == 0) goto L_0x02c0
            int r4 = r4 + r11
            r15.f = r4
        L_0x02c0:
            e70 r4 = new e70
            r17 = 0
            r19 = 0
            r21 = 0
            int r8 = r15.f
            r35 = r1
            int r1 = r8 + -1
            int r8 = r8 - r11
            java.util.ArrayList r22 = r15.c(r1, r8)
            r16 = r4
            r18 = r10
            r20 = r36
            r23 = r24
            r16.<init>(r17, r18, r19, r20, r21, r22, r23)
            return r4
        L_0x02df:
            r35 = r1
            if (r25 == 0) goto L_0x02ff
            r8 = r33
            r1 = r9
            r9 = r25
            r22 = r10
            r10 = r27
            r4 = 1
            r11 = r22
            r12 = r6
            r32 = r13
            r16 = 0
            r13 = r26
            r14 = r24
            r4 = r15
            r15 = r7
            float r6 = r8.p(r9, r10, r11, r12, r13, r14, r15)
            goto L_0x0307
        L_0x02ff:
            r1 = r9
            r22 = r10
            r32 = r13
            r4 = r15
            r16 = 0
        L_0x0307:
            java.util.Iterator r8 = r7.iterator()
        L_0x030c:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0325
            java.lang.Object r9 = r8.next()
            com.itextpdf.text.e r9 = (com.itextpdf.text.e) r9
            r10 = r22
            float r11 = r10 - r6
            float r12 = r9.d()
            float r11 = r11 - r12
            r9.g(r11)
            goto L_0x030c
        L_0x0325:
            r10 = r22
            int r8 = r4.f
            int r9 = r4.c
            if (r8 < r9) goto L_0x0345
            e70 r8 = new e70
            r15 = 0
            r19 = 1
            r11 = 1
            int r9 = r9 - r11
            java.util.ArrayList r20 = r4.c(r1, r9)
            r14 = r8
            r16 = r10
            r17 = r6
            r18 = r36
            r21 = r24
            r14.<init>(r15, r16, r17, r18, r19, r20, r21)
            return r8
        L_0x0345:
            r9 = 1
            int r8 = r8 - r9
            int r8 = r4.v(r1, r8)
            if (r8 >= r1) goto L_0x0366
            e70 r11 = new e70
            r15 = 0
            r19 = 0
            int r12 = r4.f
            int r12 = r12 - r9
            java.util.ArrayList r20 = r4.c(r1, r12)
            r14 = r11
            r16 = r10
            r17 = r6
            r18 = r36
            r21 = r24
            r14.<init>(r15, r16, r17, r18, r19, r20, r21)
            return r11
        L_0x0366:
            int r9 = r4.f
            r11 = 1
            int r9 = r9 - r11
            if (r8 != r9) goto L_0x0401
            java.lang.String r9 = "HYPHENATION"
            r11 = r32
            java.lang.Object r9 = r11.e(r9)
            ar r9 = (defpackage.ar) r9
            if (r9 == 0) goto L_0x03fc
            int[] r12 = r4.j(r1, r8)
            if (r12 == 0) goto L_0x03f7
            r13 = r12[r16]
            int r14 = r4.f
            r15 = 1
            int r14 = r14 - r15
            float r13 = r4.h(r13, r14)
            float r13 = r13 + r6
            java.lang.String r14 = new java.lang.String
            r22 = r2
            char[] r2 = r4.f4037a
            r23 = r3
            r3 = r12[r16]
            r18 = r12[r15]
            r15 = r12[r16]
            int r15 = r18 - r15
            r14.<init>(r2, r3, r15)
            r60 r2 = r11.d()
            y5 r2 = r2.c()
            r60 r3 = r11.d()
            float r3 = r3.g()
            java.lang.String r2 = r9.a(r14, r2, r3, r13)
            java.lang.String r3 = r9.b()
            int r14 = r2.length()
            if (r14 <= 0) goto L_0x0407
            b60 r14 = new b60
            r14.<init>((java.lang.String) r2, (defpackage.b60) r11)
            r15 = r14
            r14 = 1
            r17 = r12[r14]
            int r18 = r3.length()
            int r14 = r17 - r18
            r4.f = r14
            e70 r29 = new e70
            r17 = 0
            float r14 = r11.O(r2)
            float r18 = r13 - r14
            r20 = 0
            r14 = r12[r16]
            r16 = 1
            int r14 = r14 + -1
            java.util.ArrayList r21 = r4.d(r1, r14, r15)
            r14 = r29
            r30 = r15
            r15 = r17
            r16 = r10
            r17 = r18
            r18 = r36
            r19 = r20
            r20 = r21
            r21 = r24
            r14.<init>(r15, r16, r17, r18, r19, r20, r21)
            return r29
        L_0x03f7:
            r22 = r2
            r23 = r3
            goto L_0x0407
        L_0x03fc:
            r22 = r2
            r23 = r3
            goto L_0x0407
        L_0x0401:
            r22 = r2
            r23 = r3
            r11 = r32
        L_0x0407:
            r2 = -1
            if (r0 != r2) goto L_0x040d
            r3 = 1
            r4.f4035a = r3
        L_0x040d:
            if (r0 == r2) goto L_0x043b
            if (r0 < r8) goto L_0x0412
            goto L_0x043b
        L_0x0412:
            int r2 = r0 + 1
            r4.f = r2
            int r2 = r4.v(r1, r0)
            if (r2 >= r1) goto L_0x0421
            int r3 = r4.f
            r8 = 1
            int r2 = r3 + -1
        L_0x0421:
            e70 r3 = new e70
            r15 = 0
            float r8 = r4.i(r1, r2, r10)
            float r17 = r10 - r8
            r19 = 0
            java.util.ArrayList r20 = r4.c(r1, r2)
            r14 = r3
            r16 = r10
            r18 = r36
            r21 = r24
            r14.<init>(r15, r16, r17, r18, r19, r20, r21)
            return r3
        L_0x043b:
            e70 r2 = new e70
            r15 = 0
            int r3 = r8 + 1
            int r9 = r4.f
            r12 = 1
            int r9 = r9 - r12
            float r3 = r4.i(r3, r9, r10)
            float r17 = r6 + r3
            r19 = 0
            java.util.ArrayList r20 = r4.c(r1, r8)
            r14 = r2
            r16 = r10
            r18 = r36
            r21 = r24
            r14.<init>(r15, r16, r17, r18, r19, r20, r21)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.j6.o(float, float, int, int, int, float, float, float):e70");
    }

    private float p(e tabStop, float tabPosition, float originalWidth, float width, float tabStopAnchorPosition, boolean isRTL, List<e> rtlTabsToBeAligned) {
        float tabStopPosition = tabStop.e(tabPosition, originalWidth - width, tabStopAnchorPosition);
        float width2 = width - (tabStopPosition - tabPosition);
        if (width2 < 0.0f) {
            tabStopPosition += width2;
            width2 = 0.0f;
        }
        if (!isRTL) {
            tabStop.g(tabStopPosition);
        } else {
            tabStop.g(tabPosition);
            rtlTabsToBeAligned.add(tabStop);
        }
        return width2;
    }

    public boolean m() {
        return this.f4035a;
    }

    public float h(int startIdx, int lastIdx) {
        return i(startIdx, lastIdx, 0.0f);
    }

    public float i(int startIdx, int lastIdx, float originalWidth) {
        float width = 0.0f;
        e tabStop = null;
        float tabStopAnchorPosition = Float.NaN;
        float tabPosition = Float.NaN;
        while (startIdx <= lastIdx) {
            boolean surrogate = tu0.i(this.f4037a, startIdx);
            if (this.f4039a[startIdx].C() && this.f4039a[startIdx].u("TABSETTINGS")) {
                if (tabStop != null) {
                    float tabStopPosition = tabStop.e(tabPosition, width, tabStopAnchorPosition);
                    width = tabStopPosition + (width - tabPosition);
                    tabStop.g(tabStopPosition);
                }
                e tabStop2 = this.f4039a[startIdx].n();
                if (tabStop2 == null) {
                    tabStop = b60.o(this.f4039a[startIdx], width);
                    tabPosition = width;
                    tabStopAnchorPosition = Float.NaN;
                } else {
                    if (this.f4033a == 3) {
                        width = originalWidth - tabStop2.d();
                    } else {
                        width = tabStop2.d();
                    }
                    tabStop = null;
                    tabPosition = Float.NaN;
                    tabStopAnchorPosition = Float.NaN;
                }
            } else if (surrogate) {
                width += this.f4039a[startIdx].f(tu0.d(this.f4037a, startIdx));
                startIdx++;
            } else {
                char c2 = this.f4037a[startIdx];
                b60 ck = this.f4039a[startIdx];
                if (!b60.F(ck.q(c2))) {
                    if (tabStop != null && tabStop.a() != e.b.ANCHOR && Float.isNaN(tabStopAnchorPosition) && tabStop.b() == ((char) ck.q(c2))) {
                        tabStopAnchorPosition = width;
                    }
                    width += this.f4039a[startIdx].f(c2);
                }
            }
            startIdx++;
        }
        if (tabStop == null) {
            return width;
        }
        float tabStopPosition2 = tabStop.e(tabPosition, width, tabStopAnchorPosition);
        float width2 = tabStopPosition2 + (width - tabPosition);
        tabStop.g(tabStopPosition2);
        return width2;
    }

    public ArrayList<b60> c(int startIdx, int endIdx) {
        return d(startIdx, endIdx, (b60) null);
    }

    public ArrayList<b60> d(int startIdx, int endIdx, b60 extraPdfChunk) {
        boolean z = true;
        if (this.f4033a == 1) {
            z = false;
        }
        boolean bidi = z;
        if (bidi) {
            q(startIdx, endIdx);
        }
        ArrayList<PdfChunk> ar = new ArrayList<>();
        b60 refCk = this.f4039a[startIdx];
        StringBuffer buf = new StringBuffer();
        while (startIdx <= endIdx) {
            int idx = bidi ? this.f4038a[startIdx] : startIdx;
            char c2 = this.f4037a[idx];
            b60 ck = this.f4039a[idx];
            if (!b60.F(ck.q(c2))) {
                if (ck.x() || ck.z() || ck.C()) {
                    if (buf.length() > 0) {
                        ar.add(new b60(buf.toString(), refCk));
                        buf = new StringBuffer();
                    }
                    ar.add(ck);
                } else if (ck == refCk) {
                    buf.append(c2);
                } else {
                    if (buf.length() > 0) {
                        ar.add(new b60(buf.toString(), refCk));
                        buf = new StringBuffer();
                    }
                    if (!ck.x() && !ck.z() && !ck.C()) {
                        buf.append(c2);
                    }
                    refCk = ck;
                }
            }
            startIdx++;
        }
        if (buf.length() > 0) {
            ar.add(new b60(buf.toString(), refCk));
        }
        if (extraPdfChunk != null) {
            ar.add(extraPdfChunk);
        }
        return ar;
    }

    public int[] j(int startIdx, int idx) {
        int last = idx;
        int first = idx;
        while (last < this.c && (Character.isLetter(this.f4037a[last]) || Character.isDigit(this.f4037a[last]) || this.f4037a[last] == 173)) {
            last++;
        }
        if (last == idx) {
            return null;
        }
        while (first >= startIdx && (Character.isLetter(this.f4037a[first]) || Character.isDigit(this.f4037a[first]) || this.f4037a[first] == 173)) {
            first--;
        }
        return new int[]{first + 1, last};
    }

    public int u(int startIdx, int endIdx) {
        int idx = endIdx;
        while (idx >= startIdx && l((char) this.f4039a[idx].q(this.f4037a[idx]))) {
            idx--;
        }
        return idx;
    }

    public int v(int startIdx, int endIdx) {
        int idx = endIdx;
        while (idx >= startIdx) {
            char c2 = (char) this.f4039a[idx].q(this.f4037a[idx]);
            if (!l(c2) && !b60.F(c2) && (!this.f4039a[idx].C() || !this.f4039a[idx].u("TABSETTINGS") || !((Boolean) ((Object[]) this.f4039a[idx].e("TAB"))[1]).booleanValue())) {
                break;
            }
            idx--;
        }
        return idx;
    }

    public int t(int startIdx, int endIdx) {
        int idx = startIdx;
        while (idx <= endIdx) {
            char c2 = (char) this.f4039a[idx].q(this.f4037a[idx]);
            if (!l(c2) && !b60.F(c2) && (!this.f4039a[idx].C() || !this.f4039a[idx].u("TABSETTINGS") || !((Boolean) ((Object[]) this.f4039a[idx].e("TAB"))[1]).booleanValue())) {
                break;
            }
            idx++;
        }
        return idx;
    }

    public void q(int start, int end) {
        byte maxLevel = this.f4036a[start];
        byte minLevel = maxLevel;
        byte onlyOddLevels = maxLevel;
        byte onlyEvenLevels = maxLevel;
        for (int k2 = start + 1; k2 <= end; k2++) {
            byte b2 = this.f4036a[k2];
            if (b2 > maxLevel) {
                maxLevel = b2;
            } else if (b2 < minLevel) {
                minLevel = b2;
            }
            onlyOddLevels = (byte) (onlyOddLevels & b2);
            onlyEvenLevels = (byte) (onlyEvenLevels | b2);
        }
        if ((onlyEvenLevels & 1) != 0) {
            if ((onlyOddLevels & 1) == 1) {
                f(start, end + 1);
                return;
            }
            byte minLevel2 = (byte) (minLevel | 1);
            while (maxLevel >= minLevel2) {
                int pstart = start;
                while (true) {
                    if (pstart <= end && this.f4036a[pstart] < maxLevel) {
                        pstart++;
                    } else if (pstart > end) {
                        break;
                    } else {
                        int pend = pstart + 1;
                        while (pend <= end && this.f4036a[pend] >= maxLevel) {
                            pend++;
                        }
                        f(pstart, pend);
                        pstart = pend + 1;
                    }
                }
                maxLevel = (byte) (maxLevel - 1);
            }
        }
    }

    public void f(int start, int end) {
        int mid = (start + end) / 2;
        int end2 = end - 1;
        while (start < mid) {
            int[] iArr = this.f4038a;
            int temp = iArr[start];
            iArr[start] = iArr[end2];
            iArr[end2] = temp;
            start++;
            end2--;
        }
    }

    public static boolean l(char c2) {
        return c2 <= ' ';
    }
}
