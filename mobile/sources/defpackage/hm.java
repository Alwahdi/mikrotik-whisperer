package defpackage;

import com.itextpdf.text.Element;
import java.util.ArrayList;
import java.util.List;

/* renamed from: hm  reason: default package */
public class hm {
    protected float a;

    /* renamed from: a  reason: collision with other field name */
    protected final ia f3168a;

    /* renamed from: a  reason: collision with other field name */
    protected final List<bi> f3169a;

    /* renamed from: a  reason: collision with other field name */
    protected final boolean f3170a;
    protected float b;
    protected float c;
    protected float d;
    protected float e;
    protected float f;
    protected float g;
    protected float h;

    public float b() {
        return this.e;
    }

    public hm(List<bi> elements, boolean useAscender) {
        ia iaVar = new ia((d60) null);
        this.f3168a = iaVar;
        iaVar.T(useAscender);
        this.f3170a = useAscender;
        this.f3169a = elements;
    }

    public void d(float llx, float lly, float urx, float ury) {
        this.c = Math.min(llx, urx);
        this.a = Math.max(lly, ury);
        this.b = Math.min(lly, ury);
        float max = Math.max(llx, urx);
        this.d = max;
        this.f = this.c;
        this.g = max;
        this.e = this.a;
        this.h = 0.0f;
    }

    public int c(d60 canvas, boolean simulate) {
        this.f3168a.B(canvas);
        int status = 1;
        ArrayList<Element> floatingElements = new ArrayList<>();
        List arrayList = simulate ? new ArrayList(this.f3169a) : this.f3169a;
        while (!arrayList.isEmpty()) {
            arrayList.get(0);
            floatingElements.add(arrayList.get(0));
            arrayList.remove(0);
        }
        if ((true && true) && !floatingElements.isEmpty()) {
            status = a(floatingElements, simulate);
        }
        arrayList.addAll(0, floatingElements);
        return status;
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x015b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0174  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(java.util.List<defpackage.bi> r17, boolean r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = 1
            float r4 = r0.e
            r5 = 0
            r6 = 0
            ia r7 = r0.f3168a
            if (r2 == 0) goto L_0x0015
            ia r8 = r0.f3168a
            ia r7 = defpackage.ia.d(r8)
        L_0x0015:
            float r8 = r0.a
            float r9 = r0.e
            r10 = 0
            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r8 != 0) goto L_0x0020
            r8 = 1
            goto L_0x0021
        L_0x0020:
            r8 = 0
        L_0x0021:
            boolean r9 = r17.isEmpty()
            r11 = 0
            if (r9 != 0) goto L_0x01b5
            java.lang.Object r9 = r1.get(r10)
            bi r9 = (defpackage.bi) r9
            r1.remove(r10)
            float r12 = r0.b
            r13 = 0
            int r12 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r12 <= 0) goto L_0x0044
            r3 = 2
            r1.add(r10, r9)
            if (r7 == 0) goto L_0x01b5
            r7.S(r13)
            goto L_0x01b5
        L_0x0044:
            boolean r12 = r9 instanceof defpackage.km0
            if (r12 == 0) goto L_0x0067
            if (r8 == 0) goto L_0x005b
            boolean r12 = r7.t()
            if (r12 == 0) goto L_0x005b
            r12 = r9
            km0 r12 = (defpackage.km0) r12
            float r12 = r12.m()
            int r12 = (r12 > r11 ? 1 : (r12 == r11 ? 0 : -1))
            if (r12 == 0) goto L_0x0067
        L_0x005b:
            float r12 = r0.e
            r14 = r9
            km0 r14 = (defpackage.km0) r14
            float r14 = r14.c()
            float r12 = r12 - r14
            r0.e = r12
        L_0x0067:
            if (r2 == 0) goto L_0x007d
            boolean r12 = r9 instanceof defpackage.u70
            if (r12 == 0) goto L_0x0079
            u70 r12 = new u70
            r14 = r9
            u70 r14 = (defpackage.u70) r14
            r12.<init>((defpackage.u70) r14)
            r7.a(r12)
            goto L_0x0080
        L_0x0079:
            r7.a(r9)
            goto L_0x0080
        L_0x007d:
            r7.a(r9)
        L_0x0080:
            float r12 = r0.e
            int r14 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r14 <= 0) goto L_0x008e
            float r14 = r0.f
            float r15 = r0.g
            r7.N(r14, r12, r15, r4)
            goto L_0x0097
        L_0x008e:
            float r14 = r0.f
            float r15 = r0.g
            float r13 = r0.b
            r7.N(r14, r12, r15, r13)
        L_0x0097:
            r7.E(r11)
            int r3 = r7.q(r2)
            float r12 = r0.e
            int r12 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r12 <= 0) goto L_0x011b
            float r12 = r0.f
            float r13 = r0.c
            int r12 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            if (r12 > 0) goto L_0x00b4
            float r12 = r0.g
            float r14 = r0.d
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 >= 0) goto L_0x011b
        L_0x00b4:
            r12 = r3 & 1
            if (r12 != 0) goto L_0x011b
            r0.e = r4
            r0.f = r13
            float r12 = r0.d
            r0.g = r12
            int r14 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r14 == 0) goto L_0x00cc
            int r14 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r14 == 0) goto L_0x00cc
            float r12 = r12 - r13
            r0.h = r12
            goto L_0x00dc
        L_0x00cc:
            float r12 = r0.h
            int r12 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r12 <= 0) goto L_0x00d4
            r0.h = r5
        L_0x00d4:
            float r12 = r0.h
            int r12 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r12 <= 0) goto L_0x00dc
            r0.h = r6
        L_0x00dc:
            r5 = 0
            r6 = 0
            if (r2 == 0) goto L_0x00ef
            boolean r12 = r9 instanceof defpackage.u70
            if (r12 == 0) goto L_0x00ef
            u70 r12 = new u70
            r13 = r9
            u70 r13 = (defpackage.u70) r13
            r12.<init>((defpackage.u70) r13)
            r7.a(r12)
        L_0x00ef:
            float r12 = r0.f
            float r13 = r0.e
            float r14 = r0.g
            float r15 = r0.b
            r7.N(r12, r13, r14, r15)
            int r3 = r7.q(r2)
            float r12 = r7.o()
            float r13 = r7.j()
            float r12 = r12 + r13
            r0.e = r12
            float r4 = r7.k()
            float r13 = r0.h
            int r4 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r4 <= 0) goto L_0x0119
            float r4 = r7.k()
            r0.h = r4
        L_0x0119:
            r4 = r12
            goto L_0x0157
        L_0x011b:
            int r12 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r12 <= 0) goto L_0x0125
            float r12 = r7.k()
            float r6 = r6 + r12
            goto L_0x013f
        L_0x0125:
            int r12 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r12 <= 0) goto L_0x012f
            float r12 = r7.k()
            float r5 = r5 + r12
            goto L_0x013f
        L_0x012f:
            float r12 = r7.k()
            float r13 = r0.h
            int r12 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            if (r12 <= 0) goto L_0x013f
            float r12 = r7.k()
            r0.h = r12
        L_0x013f:
            float r12 = r7.o()
            float r13 = r7.j()
            float r12 = r12 + r13
            float r4 = java.lang.Math.min(r12, r4)
            float r12 = r7.o()
            float r13 = r7.j()
            float r12 = r12 + r13
            r0.e = r12
        L_0x0157:
            r12 = r3 & 1
            if (r12 != 0) goto L_0x0174
            if (r2 != 0) goto L_0x016c
            java.util.List r12 = r7.i()
            r1.addAll(r10, r12)
            java.util.List r10 = r7.i()
            r10.clear()
            goto L_0x01b5
        L_0x016c:
            r1.add(r10, r9)
            r12 = 0
            r7.S(r12)
            goto L_0x01b5
        L_0x0174:
            r12 = 0
            r7.S(r12)
            boolean r11 = r9 instanceof defpackage.k50
            if (r11 == 0) goto L_0x0191
            r11 = r9
            k50 r11 = (defpackage.k50) r11
            java.util.Iterator r12 = r11.iterator()
        L_0x0183:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x0191
            java.lang.Object r13 = r12.next()
            bi r13 = (defpackage.bi) r13
            goto L_0x0183
        L_0x0191:
            if (r8 == 0) goto L_0x01b2
            java.util.List r11 = r9.t()
            int r11 = r11.size()
            if (r11 != 0) goto L_0x01b2
            boolean r11 = r9 instanceof defpackage.k50
            if (r11 == 0) goto L_0x01ab
            r11 = r9
            k50 r11 = (defpackage.k50) r11
            java.lang.Object r12 = r11.get(r10)
            bi r12 = (defpackage.bi) r12
            goto L_0x01b1
        L_0x01ab:
            boolean r11 = r9 instanceof defpackage.km0
            if (r11 == 0) goto L_0x01b1
            r8 = 0
            goto L_0x01b3
        L_0x01b1:
            goto L_0x01b3
        L_0x01b2:
            r8 = 0
        L_0x01b3:
            goto L_0x0021
        L_0x01b5:
            int r9 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r9 == 0) goto L_0x01c5
            int r9 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r9 == 0) goto L_0x01c5
            float r9 = r0.d
            float r10 = r0.c
            float r9 = r9 - r10
            r0.h = r9
            goto L_0x01d5
        L_0x01c5:
            float r9 = r0.h
            int r9 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r9 <= 0) goto L_0x01cd
            r0.h = r5
        L_0x01cd:
            float r9 = r0.h
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 <= 0) goto L_0x01d5
            r0.h = r6
        L_0x01d5:
            r0.e = r4
            float r9 = r0.c
            r0.f = r9
            float r9 = r0.d
            r0.g = r9
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hm.a(java.util.List, boolean):int");
    }
}
