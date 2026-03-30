package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: ts0  reason: default package */
class ts0 {
    static final String[] a = {"cvt ", "fpgm", "glyf", "head", "hhea", "hmtx", "loca", "maxp", "prep"};
    static final String[] b = {"cmap", "cvt ", "fpgm", "glyf", "head", "hhea", "hmtx", "loca", "maxp", "prep"};
    static final int[] c = {0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4};

    /* renamed from: c  reason: collision with other field name */
    static final String[] f5154c = {"OS/2", "cmap", "cvt ", "fpgm", "glyf", "head", "hhea", "hmtx", "loca", "maxp", "name, prep"};

    /* renamed from: a  reason: collision with other field name */
    protected int f5155a;

    /* renamed from: a  reason: collision with other field name */
    protected cd0 f5156a;

    /* renamed from: a  reason: collision with other field name */
    protected String f5157a;

    /* renamed from: a  reason: collision with other field name */
    protected ArrayList<Integer> f5158a;

    /* renamed from: a  reason: collision with other field name */
    protected HashMap<String, int[]> f5159a;

    /* renamed from: a  reason: collision with other field name */
    protected HashSet<Integer> f5160a;

    /* renamed from: a  reason: collision with other field name */
    protected boolean f5161a;

    /* renamed from: a  reason: collision with other field name */
    protected byte[] f5162a;

    /* renamed from: a  reason: collision with other field name */
    protected int[] f5163a;

    /* renamed from: b  reason: collision with other field name */
    protected int f5164b;

    /* renamed from: b  reason: collision with other field name */
    protected boolean f5165b;

    /* renamed from: b  reason: collision with other field name */
    protected byte[] f5166b;

    /* renamed from: b  reason: collision with other field name */
    protected int[] f5167b;

    /* renamed from: c  reason: collision with other field name */
    protected int f5168c;

    /* renamed from: c  reason: collision with other field name */
    protected boolean f5169c;

    /* renamed from: c  reason: collision with other field name */
    protected byte[] f5170c;
    protected int d;
    protected int e;

    ts0(String fileName, cd0 rf, HashSet<Integer> glyphsUsed, int directoryOffset, boolean includeCmap, boolean includeExtras) {
        this.f5157a = fileName;
        this.f5156a = rf;
        this.f5160a = glyphsUsed;
        this.f5161a = includeCmap;
        this.f5165b = includeExtras;
        this.e = directoryOffset;
        this.f5158a = new ArrayList<>(glyphsUsed);
    }

    /* access modifiers changed from: package-private */
    public byte[] h() {
        try {
            this.f5156a.d();
            e();
            i();
            f();
            d();
            g();
            a();
            return this.f5170c;
        } finally {
            try {
                this.f5156a.close();
            } catch (Exception e2) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
        String[] tableNames;
        String str;
        int fullFontSize;
        String str2;
        int len;
        int[] tableLocation;
        int fullFontSize2 = 0;
        if (this.f5165b) {
            tableNames = f5154c;
        } else if (this.f5161a) {
            tableNames = b;
        } else {
            tableNames = a;
        }
        int tablesUsed = 2;
        int k = 0;
        while (true) {
            str = "loca";
            if (k >= tableNames.length) {
                break;
            }
            String name = tableNames[k];
            if (!name.equals("glyf") && !name.equals(str) && (tableLocation = this.f5159a.get(name)) != null) {
                tablesUsed++;
                fullFontSize2 += (tableLocation[2] + 3) & -4;
            }
            k++;
        }
        int ref = (tablesUsed * 16) + 12;
        int fullFontSize3 = fullFontSize2 + this.f5162a.length + this.f5166b.length + ref;
        this.f5170c = new byte[fullFontSize3];
        int i = 0;
        this.d = 0;
        k(65536);
        l(tablesUsed);
        int selector = c[tablesUsed];
        l((1 << selector) * 16);
        l(selector);
        l((tablesUsed - (1 << selector)) * 16);
        for (String name2 : tableNames) {
            int[] tableLocation2 = this.f5159a.get(name2);
            if (tableLocation2 != null) {
                m(name2);
                if (name2.equals("glyf")) {
                    k(b(this.f5166b));
                    len = this.f5164b;
                } else if (name2.equals(str)) {
                    k(b(this.f5162a));
                    len = this.f5168c;
                } else {
                    k(tableLocation2[0]);
                    len = tableLocation2[2];
                }
                k(ref);
                k(len);
                ref += (len + 3) & -4;
            }
        }
        int k2 = 0;
        while (k2 < tableNames.length) {
            String name3 = tableNames[k2];
            int[] tableLocation3 = this.f5159a.get(name3);
            if (tableLocation3 == null) {
                fullFontSize = fullFontSize3;
                str2 = str;
            } else if (name3.equals("glyf")) {
                byte[] bArr = this.f5166b;
                fullFontSize = fullFontSize3;
                System.arraycopy(bArr, i, this.f5170c, this.d, bArr.length);
                this.d += this.f5166b.length;
                this.f5166b = null;
                str2 = str;
            } else {
                fullFontSize = fullFontSize3;
                if (name3.equals(str) != 0) {
                    byte[] bArr2 = this.f5162a;
                    System.arraycopy(bArr2, i, this.f5170c, this.d, bArr2.length);
                    this.d += this.f5162a.length;
                    this.f5162a = null;
                    str2 = str;
                } else {
                    str2 = str;
                    this.f5156a.n((long) tableLocation3[1]);
                    this.f5156a.readFully(this.f5170c, this.d, tableLocation3[2]);
                    this.d += (tableLocation3[2] + 3) & -4;
                }
            }
            k2++;
            str = str2;
            fullFontSize3 = fullFontSize;
            i = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void e() {
        this.f5159a = new HashMap<>();
        this.f5156a.n((long) this.e);
        if (this.f5156a.readInt() == 65536) {
            int num_tables = this.f5156a.readUnsignedShort();
            this.f5156a.skipBytes(6);
            for (int k = 0; k < num_tables; k++) {
                this.f5159a.put(j(4), new int[]{this.f5156a.readInt(), this.f5156a.readInt(), this.f5156a.readInt()});
            }
            return;
        }
        throw new ih(i10.b("1.is.not.a.true.type.file", this.f5157a));
    }

    /* access modifiers changed from: protected */
    public void i() {
        int[] tableLocation = this.f5159a.get("head");
        if (tableLocation != null) {
            this.f5156a.n((long) (tableLocation[1] + 51));
            this.f5169c = this.f5156a.readUnsignedShort() == 0;
            int[] tableLocation2 = this.f5159a.get("loca");
            if (tableLocation2 != null) {
                this.f5156a.n((long) tableLocation2[1]);
                if (this.f5169c) {
                    int entries = tableLocation2[2] / 2;
                    this.f5163a = new int[entries];
                    for (int k = 0; k < entries; k++) {
                        this.f5163a[k] = this.f5156a.readUnsignedShort() * 2;
                    }
                    return;
                }
                int entries2 = tableLocation2[2] / 4;
                this.f5163a = new int[entries2];
                for (int k2 = 0; k2 < entries2; k2++) {
                    this.f5163a[k2] = this.f5156a.readInt();
                }
                return;
            }
            throw new ih(i10.b("table.1.does.not.exist.in.2", "loca", this.f5157a));
        }
        throw new ih(i10.b("table.1.does.not.exist.in.2", "head", this.f5157a));
    }

    /* access modifiers changed from: protected */
    public void d() {
        this.f5167b = new int[this.f5163a.length];
        int[] activeGlyphs = new int[this.f5158a.size()];
        for (int k = 0; k < activeGlyphs.length; k++) {
            activeGlyphs[k] = this.f5158a.get(k).intValue();
        }
        Arrays.sort(activeGlyphs);
        int glyfSize = 0;
        for (int glyph : activeGlyphs) {
            int[] iArr = this.f5163a;
            glyfSize += iArr[glyph + 1] - iArr[glyph];
        }
        this.f5164b = glyfSize;
        this.f5166b = new byte[((glyfSize + 3) & -4)];
        int glyfPtr = 0;
        int listGlyf = 0;
        int k2 = 0;
        while (true) {
            int[] iArr2 = this.f5167b;
            if (k2 < iArr2.length) {
                iArr2[k2] = glyfPtr;
                if (listGlyf < activeGlyphs.length && activeGlyphs[listGlyf] == k2) {
                    listGlyf++;
                    iArr2[k2] = glyfPtr;
                    int[] iArr3 = this.f5163a;
                    int start = iArr3[k2];
                    int len = iArr3[k2 + 1] - start;
                    if (len > 0) {
                        this.f5156a.n((long) (this.f5155a + start));
                        this.f5156a.readFully(this.f5166b, glyfPtr, len);
                        glyfPtr += len;
                    }
                }
                k2++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void g() {
        if (this.f5169c) {
            this.f5168c = this.f5167b.length * 2;
        } else {
            this.f5168c = this.f5167b.length * 4;
        }
        byte[] bArr = new byte[((this.f5168c + 3) & -4)];
        this.f5162a = bArr;
        this.f5170c = bArr;
        this.d = 0;
        int k = 0;
        while (true) {
            int[] iArr = this.f5167b;
            if (k < iArr.length) {
                if (this.f5169c) {
                    l(iArr[k] / 2);
                } else {
                    k(iArr[k]);
                }
                k++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void f() {
        int[] tableLocation = this.f5159a.get("glyf");
        if (tableLocation != null) {
            if (!this.f5160a.contains(0)) {
                this.f5160a.add(0);
                this.f5158a.add(0);
            }
            this.f5155a = tableLocation[1];
            for (int k = 0; k < this.f5158a.size(); k++) {
                c(this.f5158a.get(k).intValue());
            }
            return;
        }
        throw new ih(i10.b("table.1.does.not.exist.in.2", "glyf", this.f5157a));
    }

    /* access modifiers changed from: protected */
    public void c(int glyph) {
        int skip;
        int[] iArr = this.f5163a;
        int start = iArr[glyph];
        if (start != iArr[glyph + 1]) {
            this.f5156a.n((long) (this.f5155a + start));
            if (this.f5156a.readShort() < 0) {
                this.f5156a.skipBytes(8);
                while (true) {
                    int flags = this.f5156a.readUnsignedShort();
                    Integer cGlyph = Integer.valueOf(this.f5156a.readUnsignedShort());
                    if (!this.f5160a.contains(cGlyph)) {
                        this.f5160a.add(cGlyph);
                        this.f5158a.add(cGlyph);
                    }
                    if ((flags & 32) != 0) {
                        if ((flags & 1) != 0) {
                            skip = 4;
                        } else {
                            skip = 2;
                        }
                        if ((flags & 8) != 0) {
                            skip += 2;
                        } else if ((flags & 64) != 0) {
                            skip += 4;
                        }
                        if ((flags & 128) != 0) {
                            skip += 8;
                        }
                        this.f5156a.skipBytes(skip);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public String j(int length) {
        byte[] buf = new byte[length];
        this.f5156a.readFully(buf);
        try {
            return new String(buf, "Cp1252");
        } catch (Exception e2) {
            throw new mj(e2);
        }
    }

    /* access modifiers changed from: protected */
    public void l(int n) {
        byte[] bArr = this.f5170c;
        int i = this.d;
        int i2 = i + 1;
        this.d = i2;
        bArr[i] = (byte) (n >> 8);
        this.d = i2 + 1;
        bArr[i2] = (byte) n;
    }

    /* access modifiers changed from: protected */
    public void k(int n) {
        byte[] bArr = this.f5170c;
        int i = this.d;
        int i2 = i + 1;
        this.d = i2;
        bArr[i] = (byte) (n >> 24);
        int i3 = i2 + 1;
        this.d = i3;
        bArr[i2] = (byte) (n >> 16);
        int i4 = i3 + 1;
        this.d = i4;
        bArr[i3] = (byte) (n >> 8);
        this.d = i4 + 1;
        bArr[i4] = (byte) n;
    }

    /* access modifiers changed from: protected */
    public void m(String s) {
        byte[] b2 = n60.c(s, "Cp1252");
        System.arraycopy(b2, 0, this.f5170c, this.d, b2.length);
        this.d += b2.length;
    }

    /* access modifiers changed from: protected */
    public int b(byte[] b2) {
        int len = b2.length / 4;
        int v0 = 0;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        int ptr = 0;
        for (int k = 0; k < len; k++) {
            int ptr2 = ptr + 1;
            v3 += b2[ptr] & 255;
            int ptr3 = ptr2 + 1;
            v2 += b2[ptr2] & 255;
            int ptr4 = ptr3 + 1;
            v1 += b2[ptr3] & 255;
            ptr = ptr4 + 1;
            v0 += b2[ptr4] & 255;
        }
        return (v1 << 8) + v0 + (v2 << 16) + (v3 << 24);
    }
}
