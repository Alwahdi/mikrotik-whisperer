package defpackage;

import com.itextpdf.text.d;
import com.itextpdf.text.log.a;
import java.util.HashMap;

/* renamed from: t70  reason: default package */
public class t70 implements br {
    protected float a;

    /* renamed from: a  reason: collision with other field name */
    protected g0 f5076a;

    /* renamed from: a  reason: collision with other field name */
    protected h70 f5077a;

    /* renamed from: a  reason: collision with other field name */
    protected HashMap<h70, o70> f5078a;

    /* renamed from: a  reason: collision with other field name */
    private final uy f5079a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5080a;

    /* renamed from: a  reason: collision with other field name */
    protected float[] f5081a;

    /* renamed from: a  reason: collision with other field name */
    private int[] f5082a;

    /* renamed from: a  reason: collision with other field name */
    protected q70[] f5083a;
    protected boolean b;

    /* renamed from: b  reason: collision with other field name */
    protected float[] f5084b;
    protected boolean c;

    public t70(q70[] cells) {
        this(cells, (t70) null);
    }

    public t70(q70[] cells, t70 source) {
        this.f5079a = wy.a(t70.class);
        this.f5080a = false;
        this.a = 0.0f;
        this.b = false;
        this.c = false;
        this.f5077a = h70.Fb;
        this.f5078a = null;
        this.f5076a = new g0();
        this.f5083a = cells;
        this.f5081a = new float[cells.length];
        k();
        if (source != null) {
            this.f5076a = source.f5076a;
            this.f5077a = source.f5077a;
            if (source.f5078a != null) {
                this.f5078a = new HashMap<>(source.f5078a);
            }
        }
    }

    public t70(t70 row) {
        q70[] q70Arr;
        this.f5079a = wy.a(t70.class);
        this.f5080a = false;
        this.a = 0.0f;
        this.b = false;
        this.c = false;
        this.f5077a = h70.Fb;
        this.f5078a = null;
        this.f5076a = new g0();
        this.f5080a = row.f5080a;
        this.a = row.a;
        this.b = row.b;
        this.f5083a = new q70[row.f5083a.length];
        int k = 0;
        while (true) {
            q70Arr = this.f5083a;
            if (k >= q70Arr.length) {
                break;
            }
            q70[] q70Arr2 = row.f5083a;
            if (q70Arr2[k] != null) {
                if (q70Arr2[k] instanceof s70) {
                    q70Arr[k] = new s70((s70) q70Arr2[k]);
                } else {
                    q70Arr[k] = new q70(q70Arr2[k]);
                }
            }
            k++;
        }
        float[] fArr = new float[q70Arr.length];
        this.f5081a = fArr;
        System.arraycopy(row.f5081a, 0, fArr, 0, q70Arr.length);
        k();
        this.f5076a = row.f5076a;
        this.f5077a = row.f5077a;
        if (row.f5078a != null) {
            this.f5078a = new HashMap<>(row.f5078a);
        }
    }

    public boolean z(float[] widths) {
        int length = widths.length;
        q70[] q70Arr = this.f5083a;
        if (length != q70Arr.length) {
            return false;
        }
        System.arraycopy(widths, 0, this.f5081a, 0, q70Arr.length);
        float total = 0.0f;
        this.b = false;
        int k = 0;
        while (k < widths.length) {
            q70 cell = this.f5083a[k];
            if (cell == null) {
                total += widths[k];
            } else {
                cell.V(total);
                int last = cell.d0() + k;
                while (k < last) {
                    total += widths[k];
                    k++;
                }
                k--;
                cell.W(total);
                cell.Y(0.0f);
            }
            k++;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void k() {
        this.f5084b = new float[this.f5083a.length];
        int i = 0;
        while (true) {
            float[] fArr = this.f5084b;
            if (i < fArr.length) {
                fArr[i] = 0.0f;
                i++;
            } else {
                return;
            }
        }
    }

    public void w(int cell, float height) {
        if (cell >= 0 && cell < this.f5083a.length) {
            this.f5084b[cell] = height;
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
        float height;
        this.a = 0.0f;
        this.f5079a.a("calculateHeights");
        int k = 0;
        while (true) {
            q70[] q70Arr = this.f5083a;
            if (k < q70Arr.length) {
                q70 cell = q70Arr[k];
                if (cell != null) {
                    if (cell.t0()) {
                        height = cell.b0();
                    } else {
                        height = cell.n0();
                    }
                    if (height > this.a && cell.p0() == 1) {
                        this.a = height;
                    }
                }
                k++;
            } else {
                this.b = true;
                return;
            }
        }
    }

    public boolean n() {
        return this.f5080a;
    }

    public void C(float xPos, float yPos, float currentMaxHeight, q70 cell, d60[] canvases) {
        w5 background = cell.f();
        if (background != null || cell.O()) {
            float right = cell.G() + xPos;
            float top = cell.J() + yPos;
            float left = cell.E() + xPos;
            float bottom = top - currentMaxHeight;
            if (background != null) {
                d60 backgr = canvases[1];
                backgr.U0(background);
                backgr.B0(left, bottom, right - left, top - bottom);
                backgr.Z();
            }
            if (cell.O()) {
                pd0 newRect = new pd0(left, bottom, right, top);
                newRect.e(cell);
                newRect.Q((w5) null);
                canvases[2].C0(newRect);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void r(d60[] canvases, float a2, float b2, float c2, float d, float e, float f) {
        if (this.f5082a == null) {
            this.f5082a = new int[(4 * 2)];
        }
        for (int k = 0; k < 4; k++) {
            w6 bb = canvases[k].g0();
            this.f5082a[k * 2] = bb.b0();
            canvases[k].Q0();
            canvases[k].P(a2, b2, c2, d, e, f);
            this.f5082a[(k * 2) + 1] = bb.b0();
        }
    }

    /* access modifiers changed from: protected */
    public void q(d60[] canvases) {
        for (int k = 0; k < 4; k++) {
            w6 bb = canvases[k].g0();
            int p1 = bb.b0();
            canvases[k].K0();
            int[] iArr = this.f5082a;
            if (p1 == iArr[(k * 2) + 1]) {
                bb.a0(iArr[k * 2]);
            }
        }
    }

    public static float v(ia ct, float left, float bottom, float right, float top) {
        if (left > right) {
            right = left;
        }
        if (bottom > top) {
            top = bottom;
        }
        ct.N(left, bottom, right, top);
        return top;
    }

    public void D(int colStart, int colEnd, float xPos, float yPos, d60[] canvases, boolean reusable) {
        int colEnd2;
        int colStart2;
        int newStart;
        float xPos2;
        int k;
        float tly;
        q70 cell;
        float calcHeight;
        ia ct;
        ia ct2;
        float pivotX;
        float pivotX2;
        int k2;
        float rightLimit;
        float leftLimit;
        ia ct3;
        float tly2;
        float tly3;
        float tly4;
        ia ct4;
        int i;
        tr img;
        int i2 = colEnd;
        d60[] d60Arr = canvases;
        if (!this.b) {
            a();
        }
        if (i2 < 0) {
            colEnd2 = this.f5083a.length;
        } else {
            colEnd2 = Math.min(i2, this.f5083a.length);
        }
        if (colStart < 0) {
            colStart2 = 0;
        } else {
            colStart2 = colStart;
        }
        if (colStart2 < colEnd2) {
            int newStart2 = colStart2;
            float xPos3 = xPos;
            while (newStart2 >= 0 && this.f5083a[newStart2] == null) {
                if (newStart2 > 0) {
                    xPos3 -= this.f5081a[newStart2 - 1];
                }
                newStart2--;
            }
            if (newStart2 < 0) {
                newStart = 0;
            } else {
                newStart = newStart2;
            }
            q70[] q70Arr = this.f5083a;
            if (q70Arr[newStart] != null) {
                xPos2 = xPos3 - q70Arr[newStart].E();
            } else {
                xPos2 = xPos3;
            }
            char c2 = 3;
            if (o(d60Arr[3])) {
                d60Arr[3].x0(this);
            }
            float f = 0.0f;
            int k3 = newStart;
            float pivotX3 = 0.0f;
            while (k3 < colEnd2) {
                q70 cell2 = this.f5083a[k3];
                if (cell2 != null) {
                    if (o(d60Arr[c2])) {
                        d60Arr[c2].x0(cell2);
                    }
                    float currentMaxHeight = this.a + this.f5084b[k3];
                    q70 cell3 = cell2;
                    C(xPos2, yPos, currentMaxHeight, cell2, canvases);
                    tr img2 = cell3.m0();
                    float tly5 = (cell3.J() + yPos) - cell3.i0();
                    if (cell3.D() <= currentMaxHeight) {
                        switch (cell3.r0()) {
                            case 5:
                                tly = ((cell3.J() + yPos) + ((cell3.D() - currentMaxHeight) / 2.0f)) - cell3.i0();
                                break;
                            case 6:
                                tly = (((cell3.J() + yPos) - currentMaxHeight) + cell3.D()) - cell3.i0();
                                break;
                        }
                    }
                    tly = tly5;
                    if (img2 != null) {
                        if (cell3.I() != 0) {
                            img = tr.s0(img2);
                            img.l1(img.l0() + ((float) ((((double) cell3.I()) * 3.141592653589793d) / 180.0d)));
                        } else {
                            img = img2;
                        }
                        boolean vf = false;
                        if (cell3.D() > currentMaxHeight) {
                            if (img.S0()) {
                                img.Z0(100.0f);
                                img.Z0(100.0f * (((currentMaxHeight - cell3.i0()) - cell3.f0()) / img.A0()));
                                vf = true;
                            }
                        }
                        float left = cell3.E() + xPos2 + cell3.g0();
                        if (vf) {
                            switch (cell3.l0()) {
                                case 1:
                                    left = (((((cell3.E() + cell3.g0()) + cell3.G()) - cell3.h0()) - img.B0()) / 2.0f) + xPos2;
                                    break;
                                case 2:
                                    left = ((cell3.G() + xPos2) - cell3.h0()) - img.B0();
                                    break;
                            }
                            tly = (cell3.J() + yPos) - cell3.i0();
                        }
                        img.b1(left, tly - img.A0());
                        try {
                            if (o(d60Arr[c2])) {
                                d60Arr[c2].x0(img);
                            }
                            d60Arr[c2].g(img);
                            if (o(d60Arr[c2])) {
                                d60Arr[c2].H(img);
                            }
                            tr trVar = img;
                            k = k3;
                        } catch (ih e) {
                            throw new mj(e);
                        }
                    } else {
                        if (cell3.I() == 90) {
                            k2 = k3;
                        } else if (cell3.I() == 270) {
                            k2 = k3;
                        } else {
                            float fixedHeight = cell3.j0();
                            float rightLimit2 = (cell3.G() + xPos2) - cell3.h0();
                            float leftLimit2 = cell3.E() + xPos2 + cell3.g0();
                            if (cell3.w0()) {
                                switch (cell3.l0()) {
                                    case 1:
                                        rightLimit = rightLimit2 + 10000.0f;
                                        leftLimit = leftLimit2 - 10000.0f;
                                        break;
                                    case 2:
                                        if (cell3.I() != 180) {
                                            rightLimit = rightLimit2;
                                            leftLimit = leftLimit2 - 20000.0f;
                                            break;
                                        } else {
                                            rightLimit = rightLimit2 + 20000.0f;
                                            leftLimit = leftLimit2;
                                            break;
                                        }
                                    default:
                                        if (cell3.I() != 180) {
                                            rightLimit = rightLimit2 + 20000.0f;
                                            leftLimit = leftLimit2;
                                            break;
                                        } else {
                                            rightLimit = rightLimit2;
                                            leftLimit = leftLimit2 - 20000.0f;
                                            break;
                                        }
                                }
                            } else {
                                rightLimit = rightLimit2;
                                leftLimit = leftLimit2;
                            }
                            if (reusable) {
                                ct3 = ia.d(cell3.e0());
                            } else {
                                ct3 = cell3.e0();
                            }
                            ct3.C(d60Arr);
                            float bry = tly - ((currentMaxHeight - cell3.i0()) - cell3.f0());
                            if (fixedHeight <= f || cell3.D() <= currentMaxHeight) {
                                tly3 = tly;
                                tly2 = bry;
                            } else {
                                tly3 = (cell3.J() + yPos) - cell3.i0();
                                tly2 = ((cell3.J() + yPos) - currentMaxHeight) + cell3.f0();
                            }
                            if (tly3 <= tly2 && !ct3.X()) {
                                tly4 = tly3;
                                k = k3;
                            } else if (leftLimit < rightLimit) {
                                ct3.N(leftLimit, tly2 - 0.001f, rightLimit, tly3);
                                if (cell3.I() == 180) {
                                    tly4 = tly3;
                                    ct4 = ct3;
                                    float f2 = leftLimit;
                                    float f3 = rightLimit;
                                    i = 180;
                                    k = k3;
                                    r(canvases, -1.0f, 0.0f, 0.0f, -1.0f, leftLimit + rightLimit, (((yPos + yPos) - currentMaxHeight) + cell3.f0()) - cell3.i0());
                                } else {
                                    tly4 = tly3;
                                    ct4 = ct3;
                                    float f4 = leftLimit;
                                    float f5 = rightLimit;
                                    k = k3;
                                    i = 180;
                                }
                                try {
                                    ct4.p();
                                    if (cell3.I() == i) {
                                        q(d60Arr);
                                    }
                                } catch (ih e2) {
                                    throw new mj(e2);
                                } catch (Throwable th) {
                                    if (cell3.I() == i) {
                                        q(d60Arr);
                                    }
                                    throw th;
                                }
                            } else {
                                tly4 = tly3;
                                ia iaVar = ct3;
                                float f6 = leftLimit;
                                float f7 = rightLimit;
                                k = k3;
                            }
                            pivotX3 = tly2;
                            float f8 = tly4;
                        }
                        float netWidth = (currentMaxHeight - cell3.i0()) - cell3.f0();
                        float netHeight = (cell3.M() - cell3.g0()) - cell3.h0();
                        ia ct5 = ia.d(cell3.e0());
                        ct5.C(d60Arr);
                        ct5.N(0.0f, 0.0f, 0.001f + netWidth, -netHeight);
                        try {
                            ct5.q(true);
                            float calcHeight2 = -ct5.o();
                            if (netWidth <= 0.0f || netHeight <= 0.0f) {
                                calcHeight2 = 0.0f;
                            }
                            if (calcHeight2 > 0.0f) {
                                if (cell3.y0()) {
                                    calcHeight = calcHeight2 - ct5.j();
                                } else {
                                    calcHeight = calcHeight2;
                                }
                                if (reusable) {
                                    ct = ia.d(cell3.e0());
                                } else {
                                    ct = cell3.e0();
                                }
                                ct.C(d60Arr);
                                ct.N(-0.003f, -0.001f, netWidth + 0.003f, calcHeight);
                                if (cell3.I() == 90) {
                                    float pivotY = ((cell3.J() + yPos) - currentMaxHeight) + cell3.f0();
                                    switch (cell3.r0()) {
                                        case 5:
                                            pivotX2 = cell3.E() + xPos2 + ((((cell3.M() + cell3.g0()) - cell3.h0()) + calcHeight) / 2.0f);
                                            break;
                                        case 6:
                                            pivotX2 = ((cell3.E() + xPos2) + cell3.M()) - cell3.h0();
                                            break;
                                        default:
                                            float f9 = pivotX3;
                                            pivotX2 = cell3.E() + xPos2 + cell3.g0() + calcHeight;
                                            break;
                                    }
                                    ct2 = ct;
                                    float f10 = calcHeight;
                                    pivotX3 = pivotX2;
                                    float f11 = netHeight;
                                    r(canvases, 0.0f, 1.0f, -1.0f, 0.0f, pivotX3, pivotY);
                                    float f12 = pivotY;
                                } else {
                                    ct2 = ct;
                                    float calcHeight3 = calcHeight;
                                    float f13 = netHeight;
                                    float pivotY2 = (cell3.J() + yPos) - cell3.i0();
                                    switch (cell3.r0()) {
                                        case 5:
                                            pivotX = cell3.E() + xPos2 + ((((cell3.M() + cell3.g0()) - cell3.h0()) - calcHeight3) / 2.0f);
                                            break;
                                        case 6:
                                            pivotX = cell3.E() + xPos2 + cell3.g0();
                                            break;
                                        default:
                                            float f14 = pivotX3;
                                            pivotX = (((cell3.E() + xPos2) + cell3.M()) - cell3.h0()) - calcHeight3;
                                            break;
                                    }
                                    pivotX3 = pivotX;
                                    r(canvases, 0.0f, -1.0f, 1.0f, 0.0f, pivotX3, pivotY2);
                                    float f15 = pivotY2;
                                }
                                try {
                                    ct2.p();
                                    q(d60Arr);
                                } catch (ih e3) {
                                    throw new mj(e3);
                                } catch (Throwable th2) {
                                    q(d60Arr);
                                    throw th2;
                                }
                            }
                        } catch (ih e4) {
                            q70 q70 = cell3;
                            float f16 = netHeight;
                            throw new mj(e4);
                        }
                    }
                    r70 evt = cell3.c0();
                    if (evt != null) {
                        cell = cell3;
                        evt.a(cell, new pd0(cell3.E() + xPos2, (cell3.J() + yPos) - currentMaxHeight, cell3.G() + xPos2, cell3.J() + yPos), d60Arr);
                    } else {
                        cell = cell3;
                    }
                    if (o(d60Arr[3])) {
                        d60Arr[3].H(cell);
                    }
                    k3 = k + 1;
                    c2 = 3;
                    f = 0.0f;
                }
                k = k3;
                k3 = k + 1;
                c2 = 3;
                f = 0.0f;
            }
            if (o(d60Arr[3])) {
                d60Arr[3].H(this);
            }
        }
    }

    public float f() {
        if (!this.b) {
            a();
        }
        return this.a;
    }

    public void y(float maxHeight) {
        this.a = maxHeight;
    }

    /* access modifiers changed from: package-private */
    public float[] e(float xPos, float[] absoluteWidths) {
        int n = 1;
        int k = 0;
        while (true) {
            q70[] q70Arr = this.f5083a;
            if (k < q70Arr.length) {
                if (q70Arr[k] == null) {
                    while (true) {
                        q70[] q70Arr2 = this.f5083a;
                        if (k >= q70Arr2.length || q70Arr2[k] != null) {
                            break;
                        }
                        n++;
                        k++;
                    }
                } else {
                    n++;
                    k += q70Arr[k].d0();
                }
            } else {
                break;
            }
        }
        float[] width = new float[n];
        width[0] = xPos;
        int n2 = 1;
        int k2 = 0;
        while (true) {
            q70[] q70Arr3 = this.f5083a;
            if (k2 >= q70Arr3.length || n2 >= width.length) {
                return width;
            }
            if (q70Arr3[k2] != null) {
                int colspan = q70Arr3[k2].d0();
                width[n2] = width[n2 - 1];
                int i = 0;
                while (i < colspan && k2 < absoluteWidths.length) {
                    width[n2] = width[n2] + absoluteWidths[k2];
                    i++;
                    k2++;
                }
                n2++;
            } else {
                width[n2] = width[n2 - 1];
                while (true) {
                    q70[] q70Arr4 = this.f5083a;
                    if (k2 >= q70Arr4.length || q70Arr4[k2] != null) {
                        n2++;
                    } else {
                        width[n2] = width[n2] + absoluteWidths[k2];
                        k2++;
                    }
                }
                n2++;
            }
        }
        return width;
    }

    public void c(u70 table, int idx) {
        if (table != null) {
            for (int i = 0; i < this.f5083a.length; i++) {
                int lastRow = idx;
                q70 copy = table.M(lastRow).d()[i];
                while (copy == null && lastRow > 0) {
                    lastRow--;
                    copy = table.M(lastRow).d()[i];
                }
                q70[] q70Arr = this.f5083a;
                if (!(q70Arr[i] == null || copy == null)) {
                    q70Arr[i].B0(copy.e0());
                    this.b = false;
                }
            }
        }
    }

    public t70 A(u70 table, int rowIndex, float new_height) {
        float[] minHs;
        float y;
        float bottom;
        u70 u70 = table;
        if (this.f5079a.e(a.INFO)) {
            this.f5079a.a(String.format("Splitting row %s available height: %s", new Object[]{Integer.valueOf(rowIndex), Float.valueOf(new_height)}));
        }
        q70[] q70Arr = this.f5083a;
        q70[] newCells = new q70[q70Arr.length];
        float[] calHs = new float[q70Arr.length];
        float[] fixHs = new float[q70Arr.length];
        float[] minHs2 = new float[q70Arr.length];
        int k = 0;
        int status = 0;
        boolean allEmpty = true;
        float padding = 0.0f;
        while (true) {
            q70[] q70Arr2 = this.f5083a;
            if (k < q70Arr2.length) {
                float newHeight = new_height;
                q70 cell = q70Arr2[k];
                if (cell == null) {
                    int index = rowIndex;
                    if (u70.k0(index, k) != 0) {
                        while (true) {
                            index--;
                            if (u70.k0(index, k) != 0) {
                                newHeight += u70.M(index).f();
                            } else {
                                t70 row = u70.M(index);
                                if (!(row == null || row.d()[k] == null)) {
                                    newCells[k] = new q70(row.d()[k]);
                                    newCells[k].B0((ia) null);
                                    newCells[k].J0((row.d()[k].p0() - rowIndex) + index);
                                    allEmpty = false;
                                }
                                minHs = minHs2;
                            }
                        }
                    } else {
                        minHs = minHs2;
                    }
                } else {
                    calHs[k] = cell.b0();
                    fixHs[k] = cell.j0();
                    minHs2[k] = cell.o0();
                    tr img = cell.m0();
                    q70 newCell = new q70(cell);
                    if (img != null) {
                        padding = cell.f0() + cell.i0() + 2.0f;
                        if ((img.S0() || img.A0() + padding < newHeight) && newHeight > padding) {
                            newCell.I0((d) null);
                            allEmpty = false;
                        }
                        tr trVar = img;
                        minHs = minHs2;
                    } else {
                        ia ct = ia.d(cell.e0());
                        float left = cell.E() + cell.g0();
                        float bottom2 = (cell.J() + cell.f0()) - newHeight;
                        tr trVar2 = img;
                        float right = cell.G() - cell.h0();
                        minHs = minHs2;
                        float top = cell.J() - cell.i0();
                        switch (cell.I()) {
                            case 90:
                            case 270:
                                float f = bottom2;
                                y = v(ct, bottom2, left, top, right);
                                break;
                            default:
                                float f2 = padding;
                                float y2 = bottom2 + 1.0E-5f;
                                if (cell.w0()) {
                                    float f3 = bottom2;
                                    bottom = 20000.0f;
                                } else {
                                    float f4 = bottom2;
                                    bottom = right;
                                }
                                y = v(ct, left, y2, bottom, top);
                                break;
                        }
                        try {
                            status = ct.q(true);
                            boolean thisEmpty = ct.o() == y;
                            if (thisEmpty) {
                                newCell.B0(ia.d(cell.e0()));
                                ct.E(0.0f);
                            } else if ((status & 1) == 0) {
                                newCell.B0(ct);
                                ct.E(0.0f);
                            } else {
                                newCell.I0((d) null);
                            }
                            allEmpty = allEmpty && thisEmpty;
                            padding = y;
                        } catch (ih e) {
                            ih ihVar = e;
                            int status2 = status;
                            ih e2 = ihVar;
                            int i = status2;
                            throw new mj(e2);
                        }
                    }
                    newCells[k] = newCell;
                    cell.z0(newHeight);
                }
                k++;
                u70 = table;
                minHs2 = minHs;
            } else {
                float[] minHs3 = minHs2;
                if (allEmpty) {
                    int k2 = 0;
                    while (true) {
                        q70[] q70Arr3 = this.f5083a;
                        if (k2 >= q70Arr3.length) {
                            return null;
                        }
                        q70 cell2 = q70Arr3[k2];
                        if (cell2 != null) {
                            cell2.z0(calHs[k2]);
                            if (fixHs[k2] > 0.0f) {
                                cell2.C0(fixHs[k2]);
                            } else {
                                cell2.D0(minHs3[k2]);
                            }
                        }
                        k2++;
                    }
                } else {
                    a();
                    t70 split = new t70(newCells, this);
                    split.f5081a = (float[]) this.f5081a.clone();
                    return split;
                }
            }
        }
    }

    public float g() {
        return this.a;
    }

    public void x(float maxHeight) {
        y(maxHeight);
        this.b = true;
    }

    public void B(u70 original, int originalIdx, u70 part, int partIdx) {
        if (original != null && part != null) {
            int i = 0;
            while (true) {
                q70[] q70Arr = this.f5083a;
                if (i >= q70Arr.length) {
                    return;
                }
                if (q70Arr[i] == null) {
                    int splittedRowIdx = original.A(originalIdx, i);
                    int copyRowIdx = part.A(partIdx, i);
                    q70 splitted = original.M(splittedRowIdx).d()[i];
                    q70 copy = part.M(copyRowIdx).d()[i];
                    if (splitted != null) {
                        if (copy != null) {
                            this.f5083a[i] = new q70(copy);
                            int rowspanOnPreviousPage = (partIdx - copyRowIdx) + 1;
                            this.f5083a[i].J0(copy.p0() - rowspanOnPreviousPage);
                            splitted.J0(rowspanOnPreviousPage);
                            this.b = false;
                        } else {
                            throw new AssertionError();
                        }
                    }
                    i++;
                } else {
                    i += q70Arr[i].d0();
                }
            }
        }
    }

    public q70[] d() {
        return this.f5083a;
    }

    public boolean i() {
        int i = 0;
        while (true) {
            q70[] q70Arr = this.f5083a;
            if (i >= q70Arr.length) {
                return false;
            }
            if (q70Arr[i] != null && q70Arr[i].p0() > 1) {
                return true;
            }
            i++;
        }
    }

    public boolean m() {
        return this.c;
    }

    public void t(boolean adjusted) {
        this.c = adjusted;
    }

    public o70 l(h70 key) {
        HashMap<h70, o70> hashMap = this.f5078a;
        if (hashMap != null) {
            return hashMap.get(key);
        }
        return null;
    }

    public void p(h70 key, o70 value) {
        if (this.f5078a == null) {
            this.f5078a = new HashMap<>();
        }
        this.f5078a.put(key, value);
    }

    public HashMap<h70, o70> u() {
        return this.f5078a;
    }

    public h70 j() {
        return this.f5077a;
    }

    public void b(h70 role) {
        this.f5077a = role;
    }

    public g0 s() {
        return this.f5076a;
    }

    public void h(g0 id) {
        this.f5076a = id;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r1.f2719a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean o(defpackage.d60 r1) {
        /*
            if (r1 == 0) goto L_0x000e
            v80 r0 = r1.f2719a
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.z0()
            if (r0 == 0) goto L_0x000e
            r0 = 1
            goto L_0x000f
        L_0x000e:
            r0 = 0
        L_0x000f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.t70.o(d60):boolean");
    }

    public boolean isInline() {
        return false;
    }
}
