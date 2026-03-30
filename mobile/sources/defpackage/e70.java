package defpackage;

import com.itextpdf.text.a;
import com.itextpdf.text.e;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: e70  reason: default package */
public class e70 {
    protected float a;

    /* renamed from: a  reason: collision with other field name */
    protected int f2866a;

    /* renamed from: a  reason: collision with other field name */
    protected e f2867a = null;

    /* renamed from: a  reason: collision with other field name */
    protected ArrayList<b60> f2868a;

    /* renamed from: a  reason: collision with other field name */
    protected lx f2869a;

    /* renamed from: a  reason: collision with other field name */
    protected boolean f2870a = false;
    protected float b;

    /* renamed from: b  reason: collision with other field name */
    protected boolean f2871b = false;
    protected float c;
    protected float d;
    protected float e = Float.NaN;
    protected float f = Float.NaN;

    e70(float left, float right, int alignment, float height) {
        this.a = left;
        float f2 = right - left;
        this.b = f2;
        this.d = f2;
        this.f2866a = alignment;
        this.c = height;
        this.f2868a = new ArrayList<>();
    }

    e70(float left, float originalWidth, float remainingWidth, int alignment, boolean newlineSplit, ArrayList<b60> line, boolean isRTL) {
        this.a = left;
        this.d = originalWidth;
        this.b = remainingWidth;
        this.f2866a = alignment;
        this.f2868a = line;
        this.f2870a = newlineSplit;
        this.f2871b = isRTL;
    }

    /* access modifiers changed from: package-private */
    public b60 b(b60 chunk, float currentLeading) {
        if (chunk != null && !chunk.toString().equals("") && !chunk.toString().equals(" ") && (this.c < currentLeading || this.f2868a.isEmpty())) {
            this.c = currentLeading;
        }
        return a(chunk);
    }

    /* access modifiers changed from: package-private */
    public b60 a(b60 chunk) {
        if (chunk == null || chunk.toString().equals("")) {
            return null;
        }
        b60 overflow = chunk.I(this.b);
        this.f2870a = chunk.y() || overflow == null;
        if (chunk.C()) {
            Object[] tab = (Object[]) chunk.e("TAB");
            if (chunk.u("TABSETTINGS")) {
                boolean isWhiteSpace = ((Boolean) tab[1]).booleanValue();
                if (isWhiteSpace && this.f2868a.isEmpty()) {
                    return null;
                }
                d();
                this.e = Float.NaN;
                e o = b60.o(chunk, this.d - this.b);
                this.f2867a = o;
                float d2 = o.d();
                float f2 = this.d;
                if (d2 > f2) {
                    if (isWhiteSpace) {
                        overflow = null;
                    } else if (((double) Math.abs(f2 - this.b)) < 0.001d) {
                        c(chunk);
                        overflow = null;
                    } else {
                        overflow = chunk;
                    }
                    this.b = 0.0f;
                } else {
                    chunk.H(this.f2867a);
                    if (this.f2871b || this.f2867a.a() != e.b.LEFT) {
                        this.f = this.d - this.b;
                    } else {
                        this.b = this.d - this.f2867a.d();
                        this.f2867a = null;
                        this.f = Float.NaN;
                    }
                    c(chunk);
                }
            } else {
                Float tabStopPosition = Float.valueOf(((Float) tab[1]).floatValue());
                if (((Boolean) tab[2]).booleanValue() && tabStopPosition.floatValue() < this.d - this.b) {
                    return chunk;
                }
                chunk.a(this.a);
                this.b = this.d - tabStopPosition.floatValue();
                c(chunk);
            }
        } else if (chunk.D() > 0 || chunk.x()) {
            if (overflow != null) {
                chunk.L();
            }
            this.b -= chunk.N();
            c(chunk);
        } else if (this.f2868a.size() < 1) {
            b60 chunk2 = overflow;
            b60 overflow2 = chunk2.M(this.b);
            this.b -= chunk2.N();
            if (chunk2.D() > 0) {
                c(chunk2);
                return overflow2;
            }
            if (overflow2 != null) {
                c(overflow2);
            }
            return null;
        } else {
            float f3 = this.b;
            ArrayList<b60> arrayList = this.f2868a;
            this.b = f3 + arrayList.get(arrayList.size() - 1).L();
        }
        return overflow;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
        r0 = r6.toString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(defpackage.b60 r6) {
        /*
            r5 = this;
            boolean r0 = r6.f191b
            if (r0 == 0) goto L_0x002e
            boolean r0 = r6.x()
            if (r0 == 0) goto L_0x0022
            tr r0 = r6.g()
            float r1 = r6.h()
            float r2 = r6.j()
            float r1 = r1 + r2
            float r2 = r0.A()
            float r1 = r1 + r2
            float r2 = r0.c()
            float r1 = r1 + r2
            goto L_0x0026
        L_0x0022:
            float r1 = r6.m()
        L_0x0026:
            float r0 = r5.c
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x002e
            r5.c = r1
        L_0x002e:
            com.itextpdf.text.e r0 = r5.f2867a
            if (r0 == 0) goto L_0x0067
            com.itextpdf.text.e$b r0 = r0.a()
            com.itextpdf.text.e$b r1 = com.itextpdf.text.e.b.ANCHOR
            if (r0 != r1) goto L_0x0067
            float r0 = r5.e
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 == 0) goto L_0x0067
            java.lang.String r0 = r6.toString()
            com.itextpdf.text.e r1 = r5.f2867a
            char r1 = r1.b()
            int r1 = r0.indexOf(r1)
            r2 = -1
            if (r1 == r2) goto L_0x0067
            int r2 = r0.length()
            java.lang.String r2 = r0.substring(r1, r2)
            float r2 = r6.O(r2)
            float r3 = r5.d
            float r4 = r5.b
            float r3 = r3 - r4
            float r3 = r3 - r2
            r5.e = r3
        L_0x0067:
            java.util.ArrayList<b60> r0 = r5.f2868a
            r0.add(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e70.c(b60):void");
    }

    public int z() {
        return this.f2868a.size();
    }

    public Iterator<b60> r() {
        return this.f2868a.iterator();
    }

    /* access modifiers changed from: package-private */
    public float n() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public float o() {
        if (this.f2871b) {
            switch (this.f2866a) {
                case 1:
                    return this.a + (this.b / 2.0f);
                case 2:
                    return this.a;
                case 3:
                    return this.a + (m() ? 0.0f : this.b);
                default:
                    return this.a + this.b;
            }
        } else {
            if (l() <= 0) {
                switch (this.f2866a) {
                    case 1:
                        return this.a + (this.b / 2.0f);
                    case 2:
                        return this.a + this.b;
                }
            }
            return this.a;
        }
    }

    public boolean m() {
        int i = this.f2866a;
        return ((i == 3 && !this.f2870a) || i == 8) && this.b != 0.0f;
    }

    public void w() {
        if (this.f2866a == 3) {
            this.f2866a = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public void x(float extra) {
        this.a += extra;
        this.b -= extra;
        this.d -= extra;
    }

    /* access modifiers changed from: package-private */
    public float A() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public int v() {
        int numberOfSpaces = 0;
        Iterator i$ = this.f2868a.iterator();
        while (i$.hasNext()) {
            String tmp = i$.next().toString();
            int length = tmp.length();
            for (int i = 0; i < length; i++) {
                if (tmp.charAt(i) == ' ') {
                    numberOfSpaces++;
                }
            }
        }
        return numberOfSpaces;
    }

    public void y(lx listItem) {
    }

    public a u() {
        return null;
    }

    public float s() {
        return 0.0f;
    }

    public lx t() {
        return this.f2869a;
    }

    public String toString() {
        StringBuffer tmp = new StringBuffer();
        Iterator i$ = this.f2868a.iterator();
        while (i$.hasNext()) {
            tmp.append(i$.next().toString());
        }
        return tmp.toString();
    }

    public int i() {
        int total = 0;
        Iterator i$ = this.f2868a.iterator();
        while (i$.hasNext()) {
            total += i$.next().E();
        }
        return total;
    }

    public boolean p() {
        return this.f2870a && this.f2866a != 8;
    }

    public int h() {
        int lastIdx = this.f2868a.size() - 1;
        while (lastIdx >= 0 && !this.f2868a.get(lastIdx).B()) {
            lastIdx--;
        }
        return lastIdx;
    }

    public b60 f(int idx) {
        if (idx < 0 || idx >= this.f2868a.size()) {
            return null;
        }
        return this.f2868a.get(idx);
    }

    public float k() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public float[] j(float fixedLeading, float multipliedLeading) {
        float normal_leading = 0.0f;
        float image_leading = -10000.0f;
        for (int k = 0; k < this.f2868a.size(); k++) {
            b60 chunk = this.f2868a.get(k);
            if (chunk.x()) {
                tr img = chunk.g();
                if (chunk.b()) {
                    image_leading = Math.max(chunk.h() + chunk.j() + img.c(), image_leading);
                }
            } else if (chunk.b()) {
                normal_leading = Math.max(chunk.m(), normal_leading);
            } else {
                normal_leading = Math.max((chunk.d().g() * multipliedLeading) + fixedLeading, normal_leading);
            }
        }
        float[] fArr = new float[2];
        fArr[0] = normal_leading > 0.0f ? normal_leading : fixedLeading;
        fArr[1] = image_leading;
        return fArr;
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        return this.f2871b;
    }

    /* access modifiers changed from: package-private */
    public int l() {
        int s = 0;
        Iterator i$ = this.f2868a.iterator();
        while (i$.hasNext()) {
            b60 ck = i$.next();
            if (ck.C()) {
                if (!ck.u("TABSETTINGS")) {
                    return -1;
                }
            } else if (ck.w()) {
                s++;
            }
        }
        return s;
    }

    public float e() {
        float ascender = 0.0f;
        for (int k = 0; k < this.f2868a.size(); k++) {
            b60 ck = this.f2868a.get(k);
            if (ck.x()) {
                ascender = Math.max(ascender, ck.h() + ck.j());
            } else {
                r60 font = ck.d();
                float textRise = ck.p();
                float f2 = 0.0f;
                if (textRise > 0.0f) {
                    f2 = textRise;
                }
                ascender = Math.max(ascender, f2 + font.c().l(1, font.g()));
            }
        }
        return ascender;
    }

    public float g() {
        float descender = 0.0f;
        for (int k = 0; k < this.f2868a.size(); k++) {
            b60 ck = this.f2868a.get(k);
            if (ck.x()) {
                descender = Math.min(descender, ck.j());
            } else {
                r60 font = ck.d();
                float textRise = ck.p();
                float f2 = 0.0f;
                if (textRise < 0.0f) {
                    f2 = textRise;
                }
                descender = Math.min(descender, f2 + font.c().l(3, font.g()));
            }
        }
        return descender;
    }

    public void d() {
        e eVar = this.f2867a;
        if (eVar != null) {
            float f2 = this.d;
            float f3 = this.b;
            float f4 = this.f;
            float tabStopPosition = eVar.e(f4, f2 - f3, this.e);
            float f5 = this.d;
            float f6 = (f5 - tabStopPosition) - ((f2 - f3) - f4);
            this.b = f6;
            if (f6 < 0.0f) {
                tabStopPosition += f6;
            }
            if (!this.f2871b) {
                this.f2867a.g(tabStopPosition);
            } else {
                this.f2867a.g((f5 - f6) - this.f);
            }
            this.f2867a = null;
            this.f = Float.NaN;
        }
    }
}
