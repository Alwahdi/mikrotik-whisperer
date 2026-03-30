package defpackage;

import com.itextpdf.text.a;
import com.itextpdf.text.e;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: b60  reason: default package */
public class b60 {
    private static final HashSet<String> a;

    /* renamed from: a  reason: collision with other field name */
    private static final char[] f178a = {' '};
    private static final HashSet<String> b;

    /* renamed from: a  reason: collision with other field name */
    protected float f179a;

    /* renamed from: a  reason: collision with other field name */
    protected br f180a;

    /* renamed from: a  reason: collision with other field name */
    protected String f181a;

    /* renamed from: a  reason: collision with other field name */
    protected HashMap<String, Object> f182a;

    /* renamed from: a  reason: collision with other field name */
    protected om0 f183a;

    /* renamed from: a  reason: collision with other field name */
    protected r60 f184a;

    /* renamed from: a  reason: collision with other field name */
    protected tr f185a;

    /* renamed from: a  reason: collision with other field name */
    protected y5 f186a;

    /* renamed from: a  reason: collision with other field name */
    protected boolean f187a;

    /* renamed from: b  reason: collision with other field name */
    protected float f188b;

    /* renamed from: b  reason: collision with other field name */
    protected String f189b;

    /* renamed from: b  reason: collision with other field name */
    protected HashMap<String, Object> f190b;

    /* renamed from: b  reason: collision with other field name */
    protected boolean f191b;
    protected float c;
    protected float d;

    static {
        HashSet<String> hashSet = new HashSet<>();
        a = hashSet;
        HashSet<String> hashSet2 = new HashSet<>();
        b = hashSet2;
        hashSet.add("ACTION");
        hashSet.add("UNDERLINE");
        hashSet.add("REMOTEGOTO");
        hashSet.add("LOCALGOTO");
        hashSet.add("LOCALDESTINATION");
        hashSet.add("GENERICTAG");
        hashSet.add("NEWPAGE");
        hashSet.add("IMAGE");
        hashSet.add("BACKGROUND");
        hashSet.add("PDFANNOTATION");
        hashSet.add("SKEW");
        hashSet.add("HSCALE");
        hashSet.add("SEPARATOR");
        hashSet.add("TAB");
        hashSet.add("TABSETTINGS");
        hashSet.add("CHAR_SPACING");
        hashSet.add("WORD_SPACING");
        hashSet.add("LINEHEIGHT");
        hashSet2.add("SUBSUPSCRIPT");
        hashSet2.add("SPLITCHARACTER");
        hashSet2.add("HYPHENATION");
        hashSet2.add("TEXTRENDERMODE");
    }

    b60(String string, b60 other) {
        this.f181a = "";
        this.f189b = "Cp1252";
        this.f182a = new HashMap<>();
        this.f190b = new HashMap<>();
        this.f179a = 1.0f;
        this.f191b = false;
        this.d = 0.0f;
        this.f180a = null;
        this.f181a = string;
        this.f184a = other.f184a;
        HashMap<String, Object> hashMap = other.f182a;
        this.f182a = hashMap;
        this.f190b = other.f190b;
        this.f186a = other.f186a;
        this.f191b = other.f191b;
        this.d = other.d;
        Object[] obj = (Object[]) hashMap.get("IMAGE");
        if (obj == null) {
            this.f185a = null;
        } else {
            this.f185a = (tr) obj[0];
            this.f188b = ((Float) obj[1]).floatValue();
            this.c = ((Float) obj[2]).floatValue();
            this.f191b = ((Boolean) obj[3]).booleanValue();
        }
        this.f189b = this.f184a.c().j();
        om0 om0 = (om0) this.f190b.get("SPLITCHARACTER");
        this.f183a = om0;
        if (om0 == null) {
            this.f183a = tf.a;
        }
        this.f180a = other.f180a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    b60(com.itextpdf.text.a r17, defpackage.u50 r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            r16.<init>()
            java.lang.String r2 = ""
            r0.f181a = r2
            java.lang.String r3 = "Cp1252"
            r0.f189b = r3
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r0.f182a = r3
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r0.f190b = r3
            r3 = 1065353216(0x3f800000, float:1.0)
            r0.f179a = r3
            r3 = 0
            r0.f191b = r3
            r4 = 0
            r0.d = r4
            r4 = 0
            r0.f180a = r4
            java.lang.String r5 = r17.f()
            r0.f181a = r5
            com.itextpdf.text.b r5 = r17.g()
            float r6 = r5.k()
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 != 0) goto L_0x0040
            r6 = 1094713344(0x41400000, float:12.0)
        L_0x0040:
            y5 r7 = r5.c()
            r0.f186a = r7
            int r7 = r5.l()
            r8 = -1
            if (r7 != r8) goto L_0x004e
            r7 = 0
        L_0x004e:
            y5 r8 = r0.f186a
            r9 = 3
            r10 = 1
            r11 = 2
            if (r8 != 0) goto L_0x005c
            y5 r8 = r5.d(r3)
            r0.f186a = r8
            goto L_0x008c
        L_0x005c:
            r8 = r7 & 1
            if (r8 == 0) goto L_0x007c
            java.util.HashMap<java.lang.String, java.lang.Object> r8 = r0.f182a
            java.lang.Object[] r12 = new java.lang.Object[r9]
            java.lang.Integer r13 = java.lang.Integer.valueOf(r11)
            r12[r3] = r13
            java.lang.Float r13 = new java.lang.Float
            r14 = 1106247680(0x41f00000, float:30.0)
            float r14 = r6 / r14
            r13.<init>(r14)
            r12[r10] = r13
            r12[r11] = r4
            java.lang.String r13 = "TEXTRENDERMODE"
            r8.put(r13, r12)
        L_0x007c:
            r8 = r7 & 2
            if (r8 == 0) goto L_0x008c
            java.util.HashMap<java.lang.String, java.lang.Object> r8 = r0.f182a
            float[] r12 = new float[r11]
            r12 = {0, 1046063444} // fill-array
            java.lang.String r13 = "SKEW"
            r8.put(r13, r12)
        L_0x008c:
            r60 r8 = new r60
            y5 r12 = r0.f186a
            r8.<init>(r12, r6)
            r0.f184a = r8
            java.util.HashMap r8 = r17.e()
            if (r8 == 0) goto L_0x00ef
            java.util.Set r12 = r8.entrySet()
            java.util.Iterator r12 = r12.iterator()
        L_0x00a3:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x00da
            java.lang.Object r13 = r12.next()
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13
            java.lang.Object r14 = r13.getKey()
            java.lang.String r14 = (java.lang.String) r14
            java.util.HashSet<java.lang.String> r15 = a
            boolean r15 = r15.contains(r14)
            if (r15 == 0) goto L_0x00c7
            java.util.HashMap<java.lang.String, java.lang.Object> r15 = r0.f182a
            java.lang.Object r9 = r13.getValue()
            r15.put(r14, r9)
            goto L_0x00d8
        L_0x00c7:
            java.util.HashSet<java.lang.String> r9 = b
            boolean r9 = r9.contains(r14)
            if (r9 == 0) goto L_0x00d8
            java.util.HashMap<java.lang.String, java.lang.Object> r9 = r0.f190b
            java.lang.Object r15 = r13.getValue()
            r9.put(r14, r15)
        L_0x00d8:
            r9 = 3
            goto L_0x00a3
        L_0x00da:
            java.lang.String r9 = "GENERICTAG"
            java.lang.Object r12 = r8.get(r9)
            boolean r2 = r2.equals(r12)
            if (r2 == 0) goto L_0x00ef
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r0.f182a
            java.lang.String r12 = r17.f()
            r2.put(r9, r12)
        L_0x00ef:
            boolean r2 = r5.p()
            r9 = 5
            java.lang.String r12 = "UNDERLINE"
            if (r2 == 0) goto L_0x0114
            java.lang.Object[] r2 = new java.lang.Object[r11]
            r2[r3] = r4
            float[] r13 = new float[r9]
            r13 = {0, 1032358025, 0, -1096111445, 0} // fill-array
            r2[r10] = r13
            java.util.HashMap<java.lang.String, java.lang.Object> r13 = r0.f182a
            java.lang.Object r13 = r13.get(r12)
            java.lang.Object[][] r13 = (java.lang.Object[][]) r13
            java.lang.Object[][] r13 = defpackage.tu0.a(r13, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r14 = r0.f182a
            r14.put(r12, r13)
        L_0x0114:
            boolean r2 = r5.o()
            if (r2 == 0) goto L_0x0136
            java.lang.Object[] r2 = new java.lang.Object[r11]
            r2[r3] = r4
            float[] r9 = new float[r9]
            r9 = {0, 1032358025, 0, 1051372203, 0} // fill-array
            r2[r10] = r9
            java.util.HashMap<java.lang.String, java.lang.Object> r9 = r0.f182a
            java.lang.Object r9 = r9.get(r12)
            java.lang.Object[][] r9 = (java.lang.Object[][]) r9
            java.lang.Object[][] r9 = defpackage.tu0.a(r9, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r13 = r0.f182a
            r13.put(r12, r9)
        L_0x0136:
            if (r1 == 0) goto L_0x013f
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r0.f182a
            java.lang.String r9 = "ACTION"
            r2.put(r9, r1)
        L_0x013f:
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r0.f190b
            w5 r9 = r5.h()
            java.lang.String r12 = "COLOR"
            r2.put(r12, r9)
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r0.f190b
            r60 r9 = r0.f184a
            y5 r9 = r9.c()
            java.lang.String r9 = r9.j()
            java.lang.String r12 = "ENCODING"
            r2.put(r12, r9)
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r0.f182a
            java.lang.String r9 = "LINEHEIGHT"
            java.lang.Object r2 = r2.get(r9)
            java.lang.Float r2 = (java.lang.Float) r2
            if (r2 == 0) goto L_0x016f
            r0.f191b = r10
            float r9 = r2.floatValue()
            r0.d = r9
        L_0x016f:
            java.util.HashMap<java.lang.String, java.lang.Object> r9 = r0.f182a
            java.lang.String r12 = "IMAGE"
            java.lang.Object r9 = r9.get(r12)
            java.lang.Object[] r9 = (java.lang.Object[]) r9
            java.lang.String r12 = "HSCALE"
            if (r9 != 0) goto L_0x0180
            r0.f185a = r4
            goto L_0x01aa
        L_0x0180:
            java.util.HashMap<java.lang.String, java.lang.Object> r4 = r0.f182a
            r4.remove(r12)
            r3 = r9[r3]
            tr r3 = (defpackage.tr) r3
            r0.f185a = r3
            r3 = r9[r10]
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            r0.f188b = r3
            r3 = r9[r11]
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            r0.c = r3
            r3 = 3
            r3 = r9[r3]
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            r0.f191b = r3
        L_0x01aa:
            java.util.HashMap<java.lang.String, java.lang.Object> r3 = r0.f182a
            java.lang.Object r3 = r3.get(r12)
            java.lang.Float r3 = (java.lang.Float) r3
            if (r3 == 0) goto L_0x01bd
            r60 r4 = r0.f184a
            float r10 = r3.floatValue()
            r4.e(r10)
        L_0x01bd:
            r60 r4 = r0.f184a
            y5 r4 = r4.c()
            java.lang.String r4 = r4.j()
            r0.f189b = r4
            java.util.HashMap<java.lang.String, java.lang.Object> r4 = r0.f190b
            java.lang.String r10 = "SPLITCHARACTER"
            java.lang.Object r4 = r4.get(r10)
            om0 r4 = (defpackage.om0) r4
            r0.f183a = r4
            if (r4 != 0) goto L_0x01db
            om0 r4 = defpackage.tf.a
            r0.f183a = r4
        L_0x01db:
            r4 = r17
            r0.f180a = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.b60.<init>(com.itextpdf.text.a, u50):void");
    }

    b60(a chunk, u50 action, gp0 tabSettings) {
        this(chunk, action);
        if (tabSettings != null && this.f182a.get("TABSETTINGS") == null) {
            this.f182a.put("TABSETTINGS", tabSettings);
        }
    }

    public int q(int c2) {
        return this.f186a.s(c2);
    }

    /* access modifiers changed from: protected */
    public int s(String text, int start) {
        int len = text.length();
        while (start < len && Character.isLetter(text.charAt(start))) {
            start++;
        }
        return start;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0139, code lost:
        r0.f187a = true;
        r3 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x013e, code lost:
        if (r24 != 13) goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0142, code lost:
        if ((r5 + 1) >= r10) goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x014a, code lost:
        if (r1[r5 + 1] != 10) goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x014c, code lost:
        r3 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x014d, code lost:
        r11 = r0.f181a.substring(r5 + r3);
        r13 = r0.f181a.substring(0, r5);
        r0.f181a = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0162, code lost:
        if (r13.length() >= 1) goto L_0x0168;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0164, code lost:
        r0.f181a = " ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x016d, code lost:
        return new defpackage.b60(r11, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public defpackage.b60 I(float r30) {
        /*
            r29 = this;
            r0 = r29
            r1 = 0
            r0.f187a = r1
            tr r2 = r0.f185a
            java.lang.String r3 = ""
            r4 = 0
            if (r2 == 0) goto L_0x002e
            float r1 = r2.B0()
            int r1 = (r1 > r30 ? 1 : (r1 == r30 ? 0 : -1))
            if (r1 <= 0) goto L_0x002d
            b60 r1 = new b60
            java.lang.String r2 = "￼"
            r1.<init>((java.lang.String) r2, (defpackage.b60) r0)
            r0.f181a = r3
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r0.f182a = r2
            r0.f185a = r4
            r60 r2 = defpackage.r60.b()
            r0.f184a = r2
            return r1
        L_0x002d:
            return r4
        L_0x002e:
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r0.f190b
            java.lang.String r5 = "HYPHENATION"
            java.lang.Object r2 = r2.get(r5)
            ar r2 = (defpackage.ar) r2
            r5 = 0
            r6 = -1
            r7 = 0
            r8 = -1
            r9 = 0
            java.lang.String r10 = r0.f181a
            int r10 = r10.length()
            java.lang.String r11 = r0.f181a
            char[] r15 = r11.toCharArray()
            r11 = 0
            r60 r12 = r0.f184a
            y5 r14 = r12.c()
            r17 = 0
            int r12 = r14.m()
            r13 = 2
            r1 = 32
            r4 = 1
            if (r12 != r13) goto L_0x00db
            int r12 = r14.s(r1)
            if (r12 == r1) goto L_0x00db
        L_0x0062:
            if (r5 >= r10) goto L_0x00d3
            char r13 = r15[r5]
            int r12 = r14.s(r13)
            char r12 = (char) r12
            r11 = 10
            if (r12 != r11) goto L_0x0092
            r0.f187a = r4
            java.lang.String r1 = r0.f181a
            int r3 = r5 + 1
            java.lang.String r1 = r1.substring(r3)
            java.lang.String r3 = r0.f181a
            r11 = 0
            java.lang.String r3 = r3.substring(r11, r5)
            r0.f181a = r3
            int r3 = r3.length()
            if (r3 >= r4) goto L_0x008c
            java.lang.String r3 = "\u0001"
            r0.f181a = r3
        L_0x008c:
            b60 r3 = new b60
            r3.<init>((java.lang.String) r1, (defpackage.b60) r0)
            return r3
        L_0x0092:
            float r11 = r0.f(r13)
            float r7 = r7 + r11
            if (r12 != r1) goto L_0x009c
            int r8 = r5 + 1
            r9 = r7
        L_0x009c:
            int r11 = (r7 > r30 ? 1 : (r7 == r30 ? 0 : -1))
            if (r11 <= 0) goto L_0x00a6
            r11 = r12
            r22 = r14
            r1 = r15
            goto L_0x0170
        L_0x00a6:
            om0 r11 = r0.f183a
            r16 = 0
            b60[] r1 = new defpackage.b60[r4]
            r18 = 0
            r1[r18] = r0
            r20 = r12
            r12 = r16
            r21 = r13
            r13 = r5
            r22 = r14
            r14 = r10
            r23 = r15
            r16 = r1
            boolean r1 = r11.a(r12, r13, r14, r15, r16)
            if (r1 == 0) goto L_0x00c7
            int r1 = r5 + 1
            r6 = r1
        L_0x00c7:
            int r5 = r5 + 1
            r11 = r20
            r14 = r22
            r15 = r23
            r1 = 32
            goto L_0x0062
        L_0x00d3:
            r22 = r14
            r23 = r15
            r1 = r23
            goto L_0x0170
        L_0x00db:
            r22 = r14
            r23 = r15
        L_0x00df:
            if (r5 >= r10) goto L_0x016e
            r1 = r23
            char r15 = r1[r5]
            r11 = 13
            if (r15 == r11) goto L_0x0137
            r12 = 10
            if (r15 != r12) goto L_0x00f0
            r24 = r15
            goto L_0x0139
        L_0x00f0:
            boolean r17 = defpackage.tu0.i(r1, r5)
            if (r17 == 0) goto L_0x0106
            char r11 = r1[r5]
            int r12 = r5 + 1
            char r12 = r1[r12]
            int r11 = defpackage.tu0.b(r11, r12)
            float r11 = r0.f(r11)
            float r7 = r7 + r11
            goto L_0x010b
        L_0x0106:
            float r11 = r0.f(r15)
            float r7 = r7 + r11
        L_0x010b:
            r14 = 32
            if (r15 != r14) goto L_0x0112
            int r8 = r5 + 1
            r9 = r7
        L_0x0112:
            if (r17 == 0) goto L_0x0116
            int r5 = r5 + 1
        L_0x0116:
            int r11 = (r7 > r30 ? 1 : (r7 == r30 ? 0 : -1))
            if (r11 <= 0) goto L_0x011c
            r11 = r15
            goto L_0x0170
        L_0x011c:
            om0 r11 = r0.f183a
            r12 = 0
            r16 = 0
            r13 = r5
            r19 = 32
            r14 = r10
            r24 = r15
            r15 = r1
            boolean r11 = r11.a(r12, r13, r14, r15, r16)
            if (r11 == 0) goto L_0x0130
            int r6 = r5 + 1
        L_0x0130:
            int r5 = r5 + 1
            r23 = r1
            r11 = r24
            goto L_0x00df
        L_0x0137:
            r24 = r15
        L_0x0139:
            r0.f187a = r4
            r3 = 1
            r12 = r24
            if (r12 != r11) goto L_0x014d
            int r11 = r5 + 1
            if (r11 >= r10) goto L_0x014d
            int r11 = r5 + 1
            char r11 = r1[r11]
            r13 = 10
            if (r11 != r13) goto L_0x014d
            r3 = 2
        L_0x014d:
            java.lang.String r11 = r0.f181a
            int r13 = r5 + r3
            java.lang.String r11 = r11.substring(r13)
            java.lang.String r13 = r0.f181a
            r14 = 0
            java.lang.String r13 = r13.substring(r14, r5)
            r0.f181a = r13
            int r13 = r13.length()
            if (r13 >= r4) goto L_0x0168
            java.lang.String r4 = " "
            r0.f181a = r4
        L_0x0168:
            b60 r4 = new b60
            r4.<init>((java.lang.String) r11, (defpackage.b60) r0)
            return r4
        L_0x016e:
            r1 = r23
        L_0x0170:
            if (r5 != r10) goto L_0x0174
            r3 = 0
            return r3
        L_0x0174:
            if (r6 >= 0) goto L_0x0180
            java.lang.String r4 = r0.f181a
            r0.f181a = r3
            b60 r3 = new b60
            r3.<init>((java.lang.String) r4, (defpackage.b60) r0)
            return r3
        L_0x0180:
            if (r8 <= r6) goto L_0x0197
            om0 r3 = r0.f183a
            r24 = 0
            r25 = 0
            r26 = 1
            char[] r27 = f178a
            r28 = 0
            r23 = r3
            boolean r3 = r23.a(r24, r25, r26, r27, r28)
            if (r3 == 0) goto L_0x0197
            r6 = r8
        L_0x0197:
            if (r2 == 0) goto L_0x0206
            if (r8 < 0) goto L_0x0206
            if (r8 >= r5) goto L_0x0206
            java.lang.String r3 = r0.f181a
            int r3 = r0.s(r3, r8)
            if (r3 <= r8) goto L_0x0203
            java.lang.String r4 = r0.f181a
            java.lang.String r4 = r4.substring(r8, r3)
            r60 r12 = r0.f184a
            y5 r12 = r12.c()
            r60 r13 = r0.f184a
            float r13 = r13.g()
            float r14 = r30 - r9
            java.lang.String r4 = r2.a(r4, r12, r13, r14)
            java.lang.String r12 = r2.b()
            int r13 = r4.length()
            if (r13 <= 0) goto L_0x0200
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r12)
            java.lang.String r14 = r0.f181a
            java.lang.String r14 = r14.substring(r3)
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = r0.f181a
            r23 = r1
            r1 = 0
            java.lang.String r1 = r15.substring(r1, r8)
            r14.append(r1)
            r14.append(r4)
            java.lang.String r1 = r14.toString()
            java.lang.String r1 = r0.J(r1)
            r0.f181a = r1
            b60 r1 = new b60
            r1.<init>((java.lang.String) r13, (defpackage.b60) r0)
            return r1
        L_0x0200:
            r23 = r1
            goto L_0x0208
        L_0x0203:
            r23 = r1
            goto L_0x0208
        L_0x0206:
            r23 = r1
        L_0x0208:
            java.lang.String r1 = r0.f181a
            java.lang.String r1 = r1.substring(r6)
            java.lang.String r3 = r0.f181a
            r4 = 0
            java.lang.String r3 = r3.substring(r4, r6)
            java.lang.String r3 = r0.J(r3)
            r0.f181a = r3
            b60 r3 = new b60
            r3.<init>((java.lang.String) r1, (defpackage.b60) r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.b60.I(float):b60");
    }

    /* access modifiers changed from: package-private */
    public b60 M(float width) {
        tr trVar = this.f185a;
        if (trVar == null) {
            int currentPosition = 0;
            float currentWidth = 0.0f;
            if (width < this.f184a.h()) {
                String returnValue = this.f181a.substring(1);
                this.f181a = this.f181a.substring(0, 1);
                return new b60(returnValue, this);
            }
            int length = this.f181a.length();
            boolean surrogate = false;
            while (currentPosition < length) {
                surrogate = tu0.h(this.f181a, currentPosition);
                if (surrogate) {
                    currentWidth += f(tu0.c(this.f181a, currentPosition));
                } else {
                    currentWidth += f(this.f181a.charAt(currentPosition));
                }
                if (currentWidth > width) {
                    break;
                }
                if (surrogate) {
                    currentPosition++;
                }
                currentPosition++;
            }
            if (currentPosition == length) {
                return null;
            }
            if (currentPosition == 0) {
                currentPosition = 1;
                if (surrogate) {
                    currentPosition = 1 + 1;
                }
            }
            String returnValue2 = this.f181a.substring(currentPosition);
            this.f181a = this.f181a.substring(0, currentPosition);
            return new b60(returnValue2, this);
        } else if (trVar.B0() <= width) {
            return null;
        } else {
            if (this.f185a.T0()) {
                G(width / this.f185a.M());
                return null;
            }
            b60 pc = new b60("", this);
            this.f181a = "";
            this.f182a.remove("IMAGE");
            this.f185a = null;
            this.f184a = r60.b();
            return pc;
        }
    }

    /* access modifiers changed from: package-private */
    public r60 d() {
        return this.f184a;
    }

    /* access modifiers changed from: package-private */
    public w5 c() {
        return (w5) this.f190b.get("COLOR");
    }

    /* access modifiers changed from: package-private */
    public float N() {
        return O(this.f181a);
    }

    /* access modifiers changed from: package-private */
    public float O(String str) {
        if (u("SEPARATOR")) {
            return 0.0f;
        }
        if (x()) {
            return l();
        }
        float width = this.f184a.j(str);
        if (u("CHAR_SPACING")) {
            width += ((float) str.length()) * ((Float) e("CHAR_SPACING")).floatValue();
        }
        if (!u("WORD_SPACING")) {
            return width;
        }
        int numberOfSpaces = 0;
        int idx = -1;
        while (true) {
            int indexOf = str.indexOf(32, idx + 1);
            idx = indexOf;
            if (indexOf < 0) {
                return width + (((float) numberOfSpaces) * ((Float) e("WORD_SPACING")).floatValue());
            }
            numberOfSpaces++;
        }
    }

    /* access modifiers changed from: package-private */
    public float t() {
        if (x()) {
            return h();
        }
        return this.f184a.g();
    }

    public boolean y() {
        return this.f187a;
    }

    public float r(float charSpacing, float wordSpacing) {
        tr trVar = this.f185a;
        if (trVar != null) {
            return trVar.B0() + charSpacing;
        }
        int numberOfSpaces = 0;
        int idx = -1;
        while (true) {
            int indexOf = this.f181a.indexOf(32, idx + 1);
            idx = indexOf;
            if (indexOf < 0) {
                return this.f184a.j(this.f181a) + (((float) this.f181a.length()) * charSpacing) + (((float) numberOfSpaces) * wordSpacing);
            }
            numberOfSpaces++;
        }
    }

    public float p() {
        Float f = (Float) e("SUBSUPSCRIPT");
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    public float L() {
        y5 ft = this.f184a.c();
        if (ft.m() != 2 || ft.s(32) == 32) {
            if (this.f181a.length() <= 1 || !this.f181a.endsWith(" ")) {
                return 0.0f;
            }
            String str = this.f181a;
            this.f181a = str.substring(0, str.length() - 1);
            return this.f184a.i(32);
        } else if (this.f181a.length() <= 1 || !this.f181a.endsWith("\u0001")) {
            return 0.0f;
        } else {
            String str2 = this.f181a;
            this.f181a = str2.substring(0, str2.length() - 1);
            return this.f184a.i(1);
        }
    }

    public float K() {
        y5 ft = this.f184a.c();
        if (ft.m() != 2 || ft.s(32) == 32) {
            if (this.f181a.length() <= 1 || !this.f181a.startsWith(" ")) {
                return 0.0f;
            }
            this.f181a = this.f181a.substring(1);
            return this.f184a.i(32);
        } else if (this.f181a.length() <= 1 || !this.f181a.startsWith("\u0001")) {
            return 0.0f;
        } else {
            this.f181a = this.f181a.substring(1);
            return this.f184a.i(1);
        }
    }

    /* access modifiers changed from: package-private */
    public Object e(String name) {
        if (this.f182a.containsKey(name)) {
            return this.f182a.get(name);
        }
        return this.f190b.get(name);
    }

    /* access modifiers changed from: package-private */
    public boolean u(String name) {
        if (this.f182a.containsKey(name)) {
            return true;
        }
        return this.f190b.containsKey(name);
    }

    /* access modifiers changed from: package-private */
    public boolean B() {
        return !this.f182a.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public boolean z() {
        return u("SEPARATOR");
    }

    /* access modifiers changed from: package-private */
    public boolean w() {
        if (u("SEPARATOR")) {
            return true ^ ((Boolean) ((Object[]) e("SEPARATOR"))[1]).booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean C() {
        return u("TAB");
    }

    /* access modifiers changed from: package-private */
    public void a(float newValue) {
        Object[] o = (Object[]) this.f182a.get("TAB");
        if (o != null) {
            this.f182a.put("TAB", new Object[]{o[0], o[1], o[2], new Float(newValue)});
        }
    }

    static e o(b60 tab, float tabPosition) {
        Object[] o = (Object[]) tab.f182a.get("TAB");
        if (o == null) {
            return null;
        }
        Float tabInterval = (Float) o[0];
        if (!Float.isNaN(tabInterval.floatValue())) {
            return e.f(tabPosition, tabInterval.floatValue());
        }
        b6.a(tab.f182a.get("TABSETTINGS"));
        return gp0.b(tabPosition, (gp0) null);
    }

    /* access modifiers changed from: package-private */
    public e n() {
        return (e) this.f182a.get("TABSTOP");
    }

    /* access modifiers changed from: package-private */
    public void H(e tabStop) {
        this.f182a.put("TABSTOP", tabStop);
    }

    /* access modifiers changed from: package-private */
    public boolean x() {
        return this.f185a != null;
    }

    /* access modifiers changed from: package-private */
    public tr g() {
        return this.f185a;
    }

    /* access modifiers changed from: package-private */
    public float h() {
        return this.f185a.A0() * this.f179a;
    }

    /* access modifiers changed from: package-private */
    public float l() {
        return this.f185a.B0() * this.f179a;
    }

    public float k() {
        return this.f179a;
    }

    public void G(float imageScalePercentage) {
        this.f179a = imageScalePercentage;
    }

    /* access modifiers changed from: package-private */
    public float i() {
        return this.f188b;
    }

    /* access modifiers changed from: package-private */
    public float j() {
        return this.c;
    }

    public String toString() {
        return this.f181a;
    }

    /* access modifiers changed from: package-private */
    public boolean A() {
        return this.f189b.equals("UnicodeBigUnmarked") || this.f189b.equals("Identity-H");
    }

    /* access modifiers changed from: package-private */
    public int D() {
        return this.f181a.length();
    }

    /* access modifiers changed from: package-private */
    public int E() {
        if (!"Identity-H".equals(this.f189b)) {
            return this.f181a.length();
        }
        int total = 0;
        int len = this.f181a.length();
        int k = 0;
        while (k < len) {
            if (tu0.f(this.f181a.charAt(k))) {
                k++;
            }
            total++;
            k++;
        }
        return total;
    }

    /* access modifiers changed from: package-private */
    public boolean v(int start, int current, int end, char[] cc, b60[] ck) {
        return this.f183a.a(start, current, end, cc, ck);
    }

    /* access modifiers changed from: package-private */
    public String J(String string) {
        y5 ft = this.f184a.c();
        if (ft.m() != 2 || ft.s(32) == 32) {
            while (true) {
                if (!string.endsWith(" ") && !string.endsWith("\t")) {
                    break;
                }
                string = string.substring(0, string.length() - 1);
            }
        } else {
            while (string.endsWith("\u0001")) {
                string = string.substring(0, string.length() - 1);
            }
        }
        return string;
    }

    public boolean b() {
        return this.f191b;
    }

    public float m() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public float f(int c2) {
        if (F(c2)) {
            return 0.0f;
        }
        if (u("CHAR_SPACING")) {
            return this.f184a.i(c2) + (((Float) e("CHAR_SPACING")).floatValue() * this.f184a.d());
        }
        if (x()) {
            return l();
        }
        return this.f184a.i(c2);
    }

    public static boolean F(int c2) {
        return (c2 >= 8203 && c2 <= 8207) || (c2 >= 8234 && c2 <= 8238) || c2 == 173;
    }
}
