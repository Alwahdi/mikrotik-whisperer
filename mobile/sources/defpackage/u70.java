package defpackage;

import com.itextpdf.text.d;
import com.itextpdf.text.pdf.PdfPRow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: u70  reason: default package */
public class u70 implements pw, km0, br {
    protected float a = 0.0f;

    /* renamed from: a  reason: collision with other field name */
    protected int f5199a = 0;

    /* renamed from: a  reason: collision with other field name */
    protected g0 f5200a = new g0();

    /* renamed from: a  reason: collision with other field name */
    protected h70 f5201a = h70.Bb;

    /* renamed from: a  reason: collision with other field name */
    protected ArrayList<t70> f5202a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    protected HashMap<h70, o70> f5203a = null;

    /* renamed from: a  reason: collision with other field name */
    protected q70 f5204a = new q70((d) null);

    /* renamed from: a  reason: collision with other field name */
    private final uy f5205a = wy.a(u70.class);

    /* renamed from: a  reason: collision with other field name */
    private v70 f5206a = null;

    /* renamed from: a  reason: collision with other field name */
    protected w70 f5207a;

    /* renamed from: a  reason: collision with other field name */
    private x70 f5208a = null;

    /* renamed from: a  reason: collision with other field name */
    private y70 f5209a = null;

    /* renamed from: a  reason: collision with other field name */
    private boolean f5210a = false;

    /* renamed from: a  reason: collision with other field name */
    protected float[] f5211a;

    /* renamed from: a  reason: collision with other field name */
    protected q70[] f5212a;

    /* renamed from: a  reason: collision with other field name */
    private boolean[] f5213a = {false, false};
    protected float b = 0.0f;

    /* renamed from: b  reason: collision with other field name */
    protected int f5214b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f5215b = false;

    /* renamed from: b  reason: collision with other field name */
    protected float[] f5216b;
    protected float c = 80.0f;

    /* renamed from: c  reason: collision with other field name */
    private int f5217c = 1;

    /* renamed from: c  reason: collision with other field name */
    protected boolean f5218c = false;
    protected float d;

    /* renamed from: d  reason: collision with other field name */
    protected int f5219d = 1;

    /* renamed from: d  reason: collision with other field name */
    private boolean f5220d = false;
    protected float e;

    /* renamed from: e  reason: collision with other field name */
    private int f5221e;

    /* renamed from: e  reason: collision with other field name */
    private boolean f5222e = true;
    protected float f;

    /* renamed from: f  reason: collision with other field name */
    private int f5223f;

    /* renamed from: f  reason: collision with other field name */
    private boolean f5224f;
    private boolean g = true;
    private boolean h;
    protected boolean i = true;
    protected boolean j = true;
    protected boolean k = true;
    protected boolean l = true;

    protected u70() {
    }

    public u70(int numColumns) {
        if (numColumns > 0) {
            this.f5211a = new float[numColumns];
            for (int k2 = 0; k2 < numColumns; k2++) {
                this.f5211a[k2] = 1.0f;
            }
            this.f5216b = new float[this.f5211a.length];
            n();
            this.f5212a = new q70[this.f5216b.length];
            this.h = false;
            return;
        }
        throw new IllegalArgumentException(i10.b("the.number.of.columns.in.pdfptable.constructor.must.be.greater.than.zero", new Object[0]));
    }

    public u70(u70 table) {
        w(table);
        int k2 = 0;
        while (true) {
            q70[] q70Arr = this.f5212a;
            if (k2 >= q70Arr.length) {
                break;
            }
            q70[] q70Arr2 = table.f5212a;
            if (q70Arr2[k2] == null) {
                break;
            }
            q70Arr[k2] = new q70(q70Arr2[k2]);
            k2++;
        }
        for (int k3 = 0; k3 < table.f5202a.size(); k3++) {
            t70 row = table.f5202a.get(k3);
            if (row != null) {
                row = new t70(row);
            }
            this.f5202a.add(row);
        }
    }

    public void Y() {
        this.f5205a.a("Initialize row and cell heights");
        Iterator i$ = P().iterator();
        while (i$.hasNext()) {
            t70 row = i$.next();
            if (row != null) {
                row.b = false;
                for (q70 cell : row.d()) {
                    if (cell != null) {
                        cell.z0(0.0f);
                    }
                }
            }
        }
    }

    public static u70 y0(u70 table) {
        u70 nt = new u70();
        nt.w(table);
        return nt;
    }

    /* access modifiers changed from: protected */
    public void w(u70 sourceTable) {
        this.l = sourceTable.l;
        this.f5211a = new float[sourceTable.L()];
        this.f5216b = new float[sourceTable.L()];
        System.arraycopy(sourceTable.f5211a, 0, this.f5211a, 0, L());
        System.arraycopy(sourceTable.f5216b, 0, this.f5216b, 0, L());
        this.b = sourceTable.b;
        this.a = sourceTable.a;
        this.f5199a = 0;
        this.f5207a = sourceTable.f5207a;
        this.f5219d = sourceTable.f5219d;
        q70 q70 = sourceTable.f5204a;
        if (q70 instanceof s70) {
            this.f5204a = new s70((s70) q70);
        } else {
            this.f5204a = new q70(q70);
        }
        this.f5212a = new q70[sourceTable.f5212a.length];
        this.f5218c = sourceTable.f5218c;
        this.f5222e = sourceTable.f5222e;
        this.e = sourceTable.e;
        this.d = sourceTable.d;
        this.f5214b = sourceTable.f5214b;
        this.f5221e = sourceTable.f5221e;
        this.f5220d = sourceTable.f5220d;
        this.f5213a = sourceTable.f5213a;
        this.f5224f = sourceTable.f5224f;
        this.c = sourceTable.c;
        this.g = sourceTable.g;
        this.f5210a = sourceTable.f5210a;
        this.f5215b = sourceTable.f5215b;
        this.f5217c = sourceTable.f5217c;
        this.h = sourceTable.h;
        this.i = sourceTable.i;
        this.k = sourceTable.k;
        this.f5200a = sourceTable.f5200a;
        this.f5201a = sourceTable.f5201a;
        if (sourceTable.f5203a != null) {
            this.f5203a = new HashMap<>(sourceTable.f5203a);
        }
        this.f5209a = sourceTable.G();
        this.f5206a = sourceTable.z();
        this.f5208a = sourceTable.D();
    }

    /* access modifiers changed from: protected */
    public void n() {
        if (this.b > 0.0f) {
            float total = 0.0f;
            int numCols = L();
            for (int k2 = 0; k2 < numCols; k2++) {
                total += this.f5211a[k2];
            }
            for (int k3 = 0; k3 < numCols; k3++) {
                this.f5216b[k3] = (this.b * this.f5211a[k3]) / total;
            }
        }
    }

    public void w0(float totalWidth) {
        if (this.b != totalWidth) {
            this.b = totalWidth;
            this.a = 0.0f;
            n();
            k();
        }
    }

    public float V() {
        return this.b;
    }

    public float k() {
        if (this.b <= 0.0f) {
            return 0.0f;
        }
        this.a = 0.0f;
        for (int k2 = 0; k2 < this.f5202a.size(); k2++) {
            this.a += O(k2, true);
        }
        return this.a;
    }

    public q70 e(q70 cell) {
        q70 ncell;
        int i2;
        q70[] q70Arr;
        this.j = false;
        if (cell instanceof s70) {
            ncell = new s70((s70) cell);
        } else {
            ncell = new q70(cell);
        }
        int colspan = Math.min(Math.max(ncell.d0(), 1), this.f5212a.length - this.f5199a);
        ncell.A0(colspan);
        if (colspan != 1) {
            this.f5218c = true;
        }
        if (ncell.q0() == 1) {
            ncell.K0(this.f5219d);
        }
        A0();
        boolean cellAdded = false;
        int i3 = this.f5199a;
        q70[] q70Arr2 = this.f5212a;
        if (i3 < q70Arr2.length) {
            q70Arr2[i3] = ncell;
            this.f5199a = i3 + colspan;
            cellAdded = true;
        }
        A0();
        while (true) {
            i2 = this.f5199a;
            q70Arr = this.f5212a;
            if (i2 < q70Arr.length) {
                break;
            }
            int numCols = L();
            if (this.f5219d == 3) {
                q70[] rtlRow = new q70[numCols];
                int rev = this.f5212a.length;
                int k2 = 0;
                while (true) {
                    q70[] q70Arr3 = this.f5212a;
                    if (k2 >= q70Arr3.length) {
                        break;
                    }
                    q70 rcell = q70Arr3[k2];
                    int cspan = rcell.d0();
                    rev -= cspan;
                    rtlRow[rev] = rcell;
                    k2 = k2 + (cspan - 1) + 1;
                }
                this.f5212a = rtlRow;
            }
            t70 row = new t70(this.f5212a);
            if (this.b > 0.0f) {
                row.z(this.f5216b);
                this.a += row.f();
            }
            this.f5202a.add(row);
            this.f5212a = new q70[numCols];
            this.f5199a = 0;
            A0();
            this.j = true;
        }
        if (!cellAdded) {
            q70Arr[i2] = ncell;
            this.f5199a = i2 + colspan;
        }
        return ncell;
    }

    private void A0() {
        int direction = 1;
        if (this.f5219d == 3) {
            direction = -1;
        }
        while (k0(this.f5202a.size(), this.f5199a)) {
            this.f5199a += direction;
        }
    }

    /* access modifiers changed from: package-private */
    public q70 o(int row, int col) {
        q70[] cells = this.f5202a.get(row).d();
        for (int i2 = 0; i2 < cells.length; i2++) {
            if (cells[i2] != null && col >= i2 && col < cells[i2].d0() + i2) {
                return cells[i2];
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean k0(int currRow, int currCol) {
        q70 aboveCell;
        if (currCol >= L() || currCol < 0 || currRow < 1) {
            return false;
        }
        int row = currRow - 1;
        if (this.f5202a.get(row) == null) {
            return false;
        }
        q70 aboveCell2 = o(row, currCol);
        while (aboveCell == null && row > 0) {
            row--;
            if (this.f5202a.get(row) == null) {
                return false;
            }
            aboveCell2 = o(row, currCol);
        }
        int distance = currRow - row;
        if (aboveCell.p0() == 1 && distance > 1) {
            int col = currCol - 1;
            t70 aboveRow = this.f5202a.get(row + 1);
            distance--;
            aboveCell = aboveRow.d()[col];
            while (aboveCell == null && col > 0) {
                col--;
                aboveCell = aboveRow.d()[col];
            }
        }
        if (aboveCell == null || aboveCell.p0() <= distance) {
            return false;
        }
        return true;
    }

    public float E0(int colStart, int colEnd, int rowStart, int rowEnd, float xPos, float yPos, d60[] canvases, boolean reusable) {
        int rowStart2;
        int rowEnd2;
        int colStart2;
        int colEnd2;
        t70 row;
        List<PdfPRow> rows;
        int k2;
        t70 row2;
        int colStart3 = colStart;
        int i2 = colEnd;
        int rowEnd3 = rowEnd;
        if (this.b > 0.0f) {
            int totalRows = this.f5202a.size();
            if (rowStart < 0) {
                rowStart2 = 0;
            } else {
                rowStart2 = rowStart;
            }
            if (rowEnd3 < 0) {
                rowEnd2 = totalRows;
            } else {
                rowEnd2 = Math.min(rowEnd3, totalRows);
            }
            if (rowStart2 >= rowEnd2) {
                return yPos;
            }
            int totalCols = L();
            if (colStart3 < 0) {
                colStart2 = 0;
            } else {
                colStart2 = Math.min(colStart3, totalCols);
            }
            if (i2 < 0) {
                colEnd2 = totalCols;
            } else {
                colEnd2 = Math.min(i2, totalCols);
            }
            char c2 = 3;
            if (this.f5205a.e(com.itextpdf.text.log.a.INFO)) {
                this.f5205a.a(String.format("Writing row %s to %s; column %s to %s", new Object[]{Integer.valueOf(rowStart2), Integer.valueOf(rowEnd2), Integer.valueOf(colStart2), Integer.valueOf(colEnd2)}));
            }
            float yPosStart = yPos;
            if (this.l) {
                C(Float.MAX_VALUE, rowStart2);
            }
            List<PdfPRow> rows2 = Q(rowStart2, rowEnd2);
            Iterator<PdfPRow> i$ = rows2.iterator();
            float yPos2 = yPos;
            v70 currentBlock = null;
            int k3 = rowStart2;
            while (i$.hasNext()) {
                t70 row3 = (t70) i$.next();
                if (G().f5309a != null && G().f5309a.contains(row3) && currentBlock == null) {
                    currentBlock = j0(G(), canvases[c2]);
                } else if (z().f5309a != null && z().f5309a.contains(row3) && currentBlock == null) {
                    currentBlock = j0(z(), canvases[c2]);
                } else if (D().f5309a != null && D().f5309a.contains(row3) && currentBlock == null) {
                    currentBlock = j0(D(), canvases[c2]);
                }
                if (row3 != null) {
                    row = row3;
                    k2 = k3;
                    rows = rows2;
                    row3.D(colStart2, colEnd2, xPos, yPos2, canvases, reusable);
                    yPos2 -= row.f();
                } else {
                    row = row3;
                    k2 = k3;
                    rows = rows2;
                }
                if (G().f5309a != null) {
                    row2 = row;
                    if (G().f5309a.contains(row2) && (k2 == rowEnd2 - 1 || !G().f5309a.contains(rows.get(k2 + 1)))) {
                        currentBlock = q(G(), canvases[3]);
                        k3 = k2 + 1;
                        rows2 = rows;
                        c2 = 3;
                    }
                } else {
                    row2 = row;
                }
                if (z().f5309a != null && z().f5309a.contains(row2) && (k2 == rowEnd2 - 1 || !z().f5309a.contains(rows.get(k2 + 1)))) {
                    currentBlock = q(z(), canvases[3]);
                    k3 = k2 + 1;
                    rows2 = rows;
                    c2 = 3;
                } else if (D().f5309a == null || !D().f5309a.contains(row2)) {
                    k3 = k2 + 1;
                    rows2 = rows;
                    c2 = 3;
                } else if (k2 == rowEnd2 - 1 || !D().f5309a.contains(rows.get(k2 + 1))) {
                    currentBlock = q(D(), canvases[3]);
                    k3 = k2 + 1;
                    rows2 = rows;
                    c2 = 3;
                } else {
                    k3 = k2 + 1;
                    rows2 = rows;
                    c2 = 3;
                }
            }
            int k4 = k3;
            List<PdfPRow> rows3 = rows2;
            if (this.f5207a != null && colStart2 == 0 && colEnd2 == totalCols) {
                float[] heights = new float[((rowEnd2 - rowStart2) + 1)];
                heights[0] = yPosStart;
                int k5 = 0;
                while (k5 < rowEnd2 - rowStart2) {
                    t70 row4 = (t70) rows3.get(k5);
                    float hr = 0.0f;
                    if (row4 != null) {
                        hr = row4.f();
                    }
                    heights[k5 + 1] = heights[k5] - hr;
                    k5++;
                }
                float[] fArr = heights;
                this.f5207a.a(this, B(xPos, rowStart2, rowEnd2, this.f5224f), heights, this.f5224f ? this.f5214b : 0, rowStart2, canvases);
                int i3 = k5;
            } else {
                int i4 = k4;
            }
            return yPos2;
        }
        throw new RuntimeException(i10.b("the.table.width.must.be.greater.than.zero", new Object[0]));
    }

    private v70 j0(v70 block, d60 canvas) {
        if (!canvas.f2719a.q0().contains(block.j())) {
            return null;
        }
        canvas.x0(block);
        return block;
    }

    private v70 q(v70 block, d60 canvas) {
        if (!canvas.f2719a.q0().contains(block.j())) {
            return null;
        }
        canvas.H(block);
        return null;
    }

    public float D0(int colStart, int colEnd, int rowStart, int rowEnd, float xPos, float yPos, d60 canvas, boolean reusable) {
        int colStart2;
        int colEnd2;
        int colStart3 = colStart;
        int colEnd3 = colEnd;
        int totalCols = L();
        if (colStart3 < 0) {
            colStart2 = 0;
        } else {
            colStart2 = Math.min(colStart3, totalCols);
        }
        if (colEnd3 < 0) {
            colEnd2 = totalCols;
        } else {
            colEnd2 = Math.min(colEnd3, totalCols);
        }
        boolean clip = (colStart2 == 0 && colEnd2 == totalCols) ? false : true;
        if (clip) {
            float w = 0.0f;
            for (int k2 = colStart2; k2 < colEnd2; k2++) {
                w += this.f5216b[k2];
            }
            canvas.Q0();
            float rx = 10000.0f;
            float lx = colStart2 == 0 ? 10000.0f : 0.0f;
            if (colEnd2 != totalCols) {
                rx = 0.0f;
            }
            canvas.B0(xPos - lx, -10000.0f, w + lx + rx, 20000.0f);
            canvas.G();
            canvas.w0();
        } else {
            d60 d60 = canvas;
        }
        d60[] canvases = i(canvas);
        float y = E0(colStart2, colEnd2, rowStart, rowEnd, xPos, yPos, canvases, reusable);
        y(canvases);
        if (clip) {
            canvas.K0();
        }
        return y;
    }

    public static d60[] i(d60 canvas) {
        return new d60[]{canvas, canvas.c0(), canvas.c0(), canvas.c0()};
    }

    public static void y(d60[] canvases) {
        d60 canvas = canvases[0];
        y50 artifact = new y50();
        canvas.x0(artifact);
        canvas.Q0();
        canvas.d(canvases[1]);
        canvas.K0();
        canvas.Q0();
        canvas.g1(2);
        canvas.I0();
        canvas.d(canvases[2]);
        canvas.K0();
        canvas.H(artifact);
        canvas.d(canvases[3]);
    }

    public int z0() {
        return this.f5202a.size();
    }

    public float U() {
        return this.a;
    }

    public float N(int idx) {
        return O(idx, false);
    }

    /* access modifiers changed from: protected */
    public float O(int idx, boolean firsttime) {
        t70 row;
        if (this.b <= 0.0f || idx < 0 || idx >= this.f5202a.size() || (row = this.f5202a.get(idx)) == null) {
            return 0.0f;
        }
        if (firsttime) {
            row.z(this.f5216b);
        }
        float height = row.f();
        for (int i2 = 0; i2 < this.f5211a.length; i2++) {
            if (k0(idx, i2)) {
                int rs = 1;
                while (k0(idx - rs, i2)) {
                    rs++;
                }
                q70 cell = this.f5202a.get(idx - rs).d()[i2];
                float tmp = 0.0f;
                if (cell != null && cell.p0() == rs + 1) {
                    tmp = cell.n0();
                    while (rs > 0) {
                        tmp -= N(idx - rs);
                        rs--;
                    }
                }
                if (tmp > height) {
                    height = tmp;
                }
            }
        }
        row.y(height);
        return height;
    }

    public boolean X(int rowIdx) {
        if (rowIdx < this.f5202a.size() && M(rowIdx).i()) {
            return true;
        }
        t70 previousRow = rowIdx > 0 ? M(rowIdx - 1) : null;
        if (previousRow != null && previousRow.i()) {
            return true;
        }
        for (int i2 = 0; i2 < L(); i2++) {
            if (k0(rowIdx - 1, i2)) {
                return true;
            }
        }
        return false;
    }

    public void i0() {
        int i2 = this.f5221e;
        int i3 = this.f5214b;
        if (i2 > i3) {
            this.f5221e = i3;
        }
    }

    public float H() {
        float total = 0.0f;
        int size = Math.min(this.f5202a.size(), this.f5214b);
        for (int k2 = 0; k2 < size; k2++) {
            t70 row = this.f5202a.get(k2);
            if (row != null) {
                total += row.f();
            }
        }
        return total;
    }

    public float E() {
        float total = 0.0f;
        int start = Math.max(0, this.f5214b - this.f5221e);
        int size = Math.min(this.f5202a.size(), this.f5214b);
        for (int k2 = start; k2 < size; k2++) {
            t70 row = this.f5202a.get(k2);
            if (row != null) {
                total += row.f();
            }
        }
        return total;
    }

    public void x() {
        ArrayList<PdfPRow> rows2 = new ArrayList<>();
        for (int k2 = 0; k2 < this.f5214b; k2++) {
            rows2.add(this.f5202a.get(k2));
        }
        this.f5202a = rows2;
        this.a = 0.0f;
        if (this.b > 0.0f) {
            this.a = H();
        }
    }

    public int L() {
        return this.f5211a.length;
    }

    public int I() {
        return this.f5214b;
    }

    public void m0(int headerRows) {
        if (headerRows < 0) {
            headerRows = 0;
        }
        this.f5214b = headerRows;
    }

    public List<com.itextpdf.text.a> t() {
        return new ArrayList();
    }

    public int v() {
        return 23;
    }

    public boolean r() {
        return true;
    }

    public boolean a(ci listener) {
        try {
            return listener.c(this);
        } catch (ih e2) {
            return false;
        }
    }

    public float W() {
        return this.c;
    }

    public void x0(float widthPercentage) {
        this.c = widthPercentage;
    }

    public int J() {
        return this.f5217c;
    }

    public void o0(int horizontalAlignment) {
        this.f5217c = horizontalAlignment;
    }

    public t70 M(int idx) {
        return this.f5202a.get(idx);
    }

    public ArrayList<t70> P() {
        return this.f5202a;
    }

    public ArrayList<t70> Q(int start, int end) {
        ArrayList<PdfPRow> list = new ArrayList<>();
        if (start < 0 || end > z0()) {
            return list;
        }
        for (int i2 = start; i2 < end; i2++) {
            list.add(g(i2, end));
        }
        return list;
    }

    /* access modifiers changed from: protected */
    public t70 g(int start, int end) {
        t70 row = M(start);
        if (row.m()) {
            return row;
        }
        t70 row2 = new t70(row);
        q70[] cells = row2.d();
        for (int i2 = 0; i2 < cells.length; i2++) {
            q70 cell = cells[i2];
            if (!(cell == null || cell.p0() == 1)) {
                int stop = Math.min(end, cell.p0() + start);
                float extra = 0.0f;
                for (int k2 = start + 1; k2 < stop; k2++) {
                    extra += M(k2).f();
                }
                row2.w(i2, extra);
            }
        }
        row2.t(true);
        return row2;
    }

    public w70 T() {
        return this.f5207a;
    }

    /* access modifiers changed from: package-private */
    public float[][] B(float xPos, int firstRow, int lastRow, boolean includeHeaders) {
        int n;
        if (includeHeaders) {
            firstRow = Math.max(firstRow, this.f5214b);
            lastRow = Math.max(lastRow, this.f5214b);
        }
        float[][] widths = new float[(((includeHeaders ? this.f5214b : 0) + lastRow) - firstRow)][];
        if (this.f5218c) {
            int n2 = 0;
            if (includeHeaders) {
                for (int k2 = 0; k2 < this.f5214b; k2++) {
                    t70 row = this.f5202a.get(k2);
                    if (row == null) {
                        n2++;
                    } else {
                        widths[n2] = row.e(xPos, this.f5216b);
                        n2++;
                    }
                }
            }
            while (firstRow < lastRow) {
                t70 row2 = this.f5202a.get(firstRow);
                if (row2 == null) {
                    n = n2 + 1;
                } else {
                    widths[n2] = row2.e(xPos, this.f5216b);
                    n = n2 + 1;
                }
                firstRow++;
            }
        } else {
            int numCols = L();
            float[] width = new float[(numCols + 1)];
            width[0] = xPos;
            for (int k3 = 0; k3 < numCols; k3++) {
                width[k3 + 1] = width[k3] + this.f5216b[k3];
            }
            for (int k4 = 0; k4 < widths.length; k4++) {
                widths[k4] = width;
            }
        }
        return widths;
    }

    public boolean e0() {
        return this.f5210a;
    }

    public boolean f0() {
        return this.f5215b;
    }

    public void s0(boolean skipFirstHeader) {
        this.f5210a = skipFirstHeader;
    }

    public int R() {
        return this.f5219d;
    }

    public boolean c0() {
        return this.f5220d;
    }

    public void q0(boolean lockedWidth) {
        this.f5220d = lockedWidth;
    }

    public boolean h0() {
        return this.f5222e;
    }

    public void u0(float spacing) {
        this.d = spacing;
    }

    public void t0(float spacing) {
        this.e = spacing;
    }

    public float C0() {
        return this.d;
    }

    public float B0() {
        return this.e;
    }

    public float m() {
        return this.f;
    }

    public boolean Z() {
        return this.f5213a[0];
    }

    public boolean a0(boolean newPageFollows) {
        if (newPageFollows) {
            return this.f5213a[0];
        }
        return this.f5213a[1];
    }

    public boolean b0() {
        return this.f5224f;
    }

    public void n0(boolean headersInEvent) {
        this.f5224f = headersInEvent;
    }

    public boolean g0() {
        return this.g;
    }

    public void v0(boolean splitLate) {
        this.g = splitLate;
    }

    public void p0(boolean keepTogether) {
        this.h = keepTogether;
    }

    public boolean K() {
        return this.h;
    }

    public int F() {
        return this.f5221e;
    }

    public void d() {
        x();
        if (this.f5223f > 0) {
            s0(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void f(int numberOfWrittenRows) {
        this.f5223f += numberOfWrittenRows;
    }

    public boolean isComplete() {
        return this.i;
    }

    public void l0(boolean complete) {
        this.i = complete;
    }

    public float c() {
        return this.d;
    }

    public float S() {
        return this.e;
    }

    public boolean d0() {
        return this.k;
    }

    public void r0(boolean loopCheck) {
        this.k = loopCheck;
    }

    public o70 l(h70 key) {
        HashMap<h70, o70> hashMap = this.f5203a;
        if (hashMap != null) {
            return hashMap.get(key);
        }
        return null;
    }

    public void p(h70 key, o70 value) {
        if (this.f5203a == null) {
            this.f5203a = new HashMap<>();
        }
        this.f5203a.put(key, value);
    }

    public HashMap<h70, o70> u() {
        return this.f5203a;
    }

    public h70 j() {
        return this.f5201a;
    }

    public void b(h70 role) {
        this.f5201a = role;
    }

    public g0 s() {
        return this.f5200a;
    }

    public void h(g0 id) {
        this.f5200a = id;
    }

    public boolean isInline() {
        return false;
    }

    public y70 G() {
        if (this.f5209a == null) {
            this.f5209a = new y70();
        }
        return this.f5209a;
    }

    public v70 z() {
        if (this.f5206a == null) {
            this.f5206a = new v70();
        }
        return this.f5206a;
    }

    public x70 D() {
        if (this.f5208a == null) {
            this.f5208a = new x70();
        }
        return this.f5208a;
    }

    public int A(int rowIdx, int colIdx) {
        int lastRow = rowIdx;
        while (M(lastRow).d()[colIdx] == null && lastRow > 0) {
            lastRow--;
        }
        return lastRow;
    }

    /* renamed from: u70$b */
    public static class b {
        public final float a;

        /* renamed from: a  reason: collision with other field name */
        public final int f5226a;

        /* renamed from: a  reason: collision with other field name */
        private final Map<Integer, Float> f5227a;
        public final float b;

        /* renamed from: b  reason: collision with other field name */
        public final int f5228b;

        public b(int firstRow, int lastRow, float height, float completedRowsHeight, Map<Integer, Float> correctedHeightsForLastRow) {
            this.f5226a = firstRow;
            this.f5228b = lastRow;
            this.a = height;
            this.b = completedRowsHeight;
            this.f5227a = correctedHeightsForLastRow;
        }

        public void a(u70 table, int k) {
            t70 row = table.M(k);
            Float value = this.f5227a.get(Integer.valueOf(k));
            if (value != null) {
                row.x(value.floatValue());
            }
        }
    }

    /* renamed from: u70$a */
    public static class a {
        public float a = 0.0f;

        /* renamed from: a  reason: collision with other field name */
        public int f5225a = 1;
        public int b = 1;

        public void a(q70 cell, float completedRowsHeight, float rowHeight) {
            this.f5225a = cell.p0();
            this.b = cell.d0();
            this.a = Math.max(cell.s0() ? cell.a0() : cell.n0(), rowHeight) + completedRowsHeight;
        }

        public void c(float completedRowsHeight, float rowHeight) {
            this.f5225a--;
        }

        public boolean b() {
            return this.f5225a == 1;
        }
    }

    public b C(float availableHeight, int startIdx) {
        float rowHeight;
        int i2;
        int i3 = startIdx;
        if (this.f5205a.e(com.itextpdf.text.log.a.INFO)) {
            this.f5205a.a(String.format("getFittingRows(%s, %s)", new Object[]{Float.valueOf(availableHeight), Integer.valueOf(startIdx)}));
        }
        if (i3 <= 0 || i3 >= this.f5202a.size() || M(i3).d()[0] != null) {
            int cols = L();
            a[] states = new a[cols];
            for (int i4 = 0; i4 < cols; i4++) {
                states[i4] = new a();
            }
            Map<Integer, Float> correctedHeightsForLastRow = new HashMap<>();
            float completedRowsHeight = 0.0f;
            float totalHeight = 0.0f;
            int k2 = startIdx;
            while (k2 < z0()) {
                t70 row = M(k2);
                float rowHeight2 = row.g();
                float maxCompletedRowsHeight = 0.0f;
                int i5 = 0;
                while (i5 < cols) {
                    q70 cell = row.d()[i5];
                    a state = states[i5];
                    if (cell == null) {
                        state.c(completedRowsHeight, rowHeight2);
                        rowHeight = rowHeight2;
                    } else {
                        state.a(cell, completedRowsHeight, rowHeight2);
                        if (this.f5205a.e(com.itextpdf.text.log.a.INFO)) {
                            rowHeight = rowHeight2;
                            this.f5205a.a(String.format("Height after beginCell: %s (cell: %s)", new Object[]{Float.valueOf(state.a), Float.valueOf(cell.a0())}));
                        } else {
                            rowHeight = rowHeight2;
                        }
                    }
                    if (state.b() && state.a > maxCompletedRowsHeight) {
                        maxCompletedRowsHeight = state.a;
                    }
                    int j2 = 1;
                    while (true) {
                        i2 = state.b;
                        if (j2 >= i2) {
                            break;
                        }
                        states[i5 + j2].a = state.a;
                        j2++;
                    }
                    i5 += i2;
                    rowHeight2 = rowHeight;
                }
                float maxTotalHeight = 0.0f;
                a[] arr$ = states;
                int len$ = arr$.length;
                int i$ = 0;
                while (i$ < len$) {
                    a state2 = arr$[i$];
                    a[] arr$2 = arr$;
                    if (state2.a > maxTotalHeight) {
                        maxTotalHeight = state2.a;
                    }
                    i$++;
                    arr$ = arr$2;
                }
                row.x(maxCompletedRowsHeight - completedRowsHeight);
                if (availableHeight - (g0() ? maxTotalHeight : maxCompletedRowsHeight) < 0.0f) {
                    break;
                }
                correctedHeightsForLastRow.put(Integer.valueOf(k2), Float.valueOf(maxTotalHeight - completedRowsHeight));
                completedRowsHeight = maxCompletedRowsHeight;
                totalHeight = maxTotalHeight;
                k2++;
            }
            this.l = false;
            return new b(startIdx, k2 - 1, totalHeight, completedRowsHeight, correctedHeightsForLastRow);
        }
        throw new AssertionError();
    }
}
