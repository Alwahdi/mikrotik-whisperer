package defpackage;

import androidx.core.internal.view.SupportMenu;
import defpackage.y5;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.apache.http.HttpStatus;

/* renamed from: ss0  reason: default package */
class ss0 extends y5 {
    static final String[] b = {"1252 Latin 1", "1250 Latin 2: Eastern Europe", "1251 Cyrillic", "1253 Greek", "1254 Turkish", "1255 Hebrew", "1256 Arabic", "1257 Windows Baltic", "1258 Vietnamese", null, null, null, null, null, null, null, "874 Thai", "932 JIS/Japan", "936 Chinese: Simplified chars--PRC and Singapore", "949 Korean Wansung", "950 Chinese: Traditional chars--Taiwan and Hong Kong", "1361 Korean Johab", null, null, null, null, null, null, null, "Macintosh Character Set (US Roman)", "OEM Character Set", "Symbol Character Set", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "869 IBM Greek", "866 MS-DOS Russian", "865 MS-DOS Nordic", "864 Arabic", "863 MS-DOS Canadian French", "862 Hebrew", "861 MS-DOS Icelandic", "860 MS-DOS Portuguese", "857 IBM Turkish", "855 IBM Cyrillic; primarily Russian", "852 Latin 2", "775 MS-DOS Baltic", "737 Greek; former 437 G", "708 Arabic; ASMO 708", "850 WE/Latin 1", "437 US"};
    protected double a;

    /* renamed from: a  reason: collision with other field name */
    protected cd0 f5020a;

    /* renamed from: a  reason: collision with other field name */
    protected a f5021a = new a();

    /* renamed from: a  reason: collision with other field name */
    protected b f5022a = new b();

    /* renamed from: a  reason: collision with other field name */
    protected c f5023a = new c();

    /* renamed from: a  reason: collision with other field name */
    protected String[][] f5024a;

    /* renamed from: b  reason: collision with other field name */
    protected String f5025b;

    /* renamed from: b  reason: collision with other field name */
    protected HashMap<String, int[]> f5026b;

    /* renamed from: b  reason: collision with other field name */
    protected ys f5027b = new ys();

    /* renamed from: b  reason: collision with other field name */
    protected int[][] f5028b;

    /* renamed from: b  reason: collision with other field name */
    protected String[][] f5029b;
    protected int c;

    /* renamed from: c  reason: collision with other field name */
    protected String f5030c;

    /* renamed from: c  reason: collision with other field name */
    protected HashMap<Integer, int[]> f5031c;

    /* renamed from: c  reason: collision with other field name */
    protected String[][] f5032c;
    protected int d;

    /* renamed from: d  reason: collision with other field name */
    protected String f5033d = "";

    /* renamed from: d  reason: collision with other field name */
    protected HashMap<Integer, int[]> f5034d;

    /* renamed from: d  reason: collision with other field name */
    protected String[][] f5035d;
    protected int e;

    /* renamed from: e  reason: collision with other field name */
    protected String f5036e;

    /* renamed from: e  reason: collision with other field name */
    protected HashMap<Integer, int[]> f5037e;
    protected int f;

    /* renamed from: f  reason: collision with other field name */
    protected int[] f5038f;
    protected int g;
    protected int h;

    /* renamed from: h  reason: collision with other field name */
    protected boolean f5039h = false;
    protected boolean i = false;
    protected boolean j = false;

    /* renamed from: ss0$a */
    protected static class a {
        int a;

        /* renamed from: a  reason: collision with other field name */
        short f5040a;
        int b;

        /* renamed from: b  reason: collision with other field name */
        short f5041b;
        int c;

        /* renamed from: c  reason: collision with other field name */
        short f5042c;
        short d;

        protected a() {
        }
    }

    /* renamed from: ss0$b */
    protected static class b {
        int a;

        /* renamed from: a  reason: collision with other field name */
        short f5043a;
        int b;

        /* renamed from: b  reason: collision with other field name */
        short f5044b;
        short c;
        short d;
        short e;
        short f;
        short g;
        short h;

        protected b() {
        }
    }

    /* renamed from: ss0$c */
    protected static class c {
        int a;

        /* renamed from: a  reason: collision with other field name */
        short f5045a;

        /* renamed from: a  reason: collision with other field name */
        byte[] f5046a = new byte[10];
        int b;

        /* renamed from: b  reason: collision with other field name */
        short f5047b;

        /* renamed from: b  reason: collision with other field name */
        byte[] f5048b = new byte[4];
        int c;

        /* renamed from: c  reason: collision with other field name */
        short f5049c;
        int d;

        /* renamed from: d  reason: collision with other field name */
        short f5050d;
        int e;

        /* renamed from: e  reason: collision with other field name */
        short f5051e;
        int f;

        /* renamed from: f  reason: collision with other field name */
        short f5052f;
        int g;

        /* renamed from: g  reason: collision with other field name */
        short f5053g;
        int h;

        /* renamed from: h  reason: collision with other field name */
        short f5054h;
        int i;

        /* renamed from: i  reason: collision with other field name */
        short f5055i;
        int j;

        /* renamed from: j  reason: collision with other field name */
        short f5056j;
        short k;
        short l;
        short m;
        short n;
        short o;
        short p;

        protected c() {
        }
    }

    protected ss0() {
    }

    ss0(String ttFile, String enc, boolean emb, byte[] ttfAfm, boolean justNames, boolean forceRead) {
        this.f5039h = justNames;
        String nameBase = y5.i(ttFile);
        String ttcName = T(nameBase);
        if (nameBase.length() < ttFile.length()) {
            this.f5033d = ttFile.substring(nameBase.length());
        }
        this.f5821a = enc;
        this.f5824a = emb;
        this.f5025b = ttcName;
        this.f5820a = 1;
        this.f5030c = "";
        if (ttcName.length() < nameBase.length()) {
            this.f5030c = nameBase.substring(ttcName.length() + 1);
        }
        if (this.f5025b.toLowerCase().endsWith(".ttf") || this.f5025b.toLowerCase().endsWith(".otf") || this.f5025b.toLowerCase().endsWith(".ttc")) {
            U(ttfAfm, forceRead);
            if (justNames || !this.f5824a || this.f5023a.f5047b != 2) {
                if (!this.f5821a.startsWith("#")) {
                    n60.c(" ", enc);
                }
                c();
                return;
            }
            throw new ih(i10.b("1.cannot.be.embedded.due.to.licensing.restrictions", this.f5025b + this.f5033d));
        }
        throw new ih(i10.b("1.is.not.a.ttf.otf.or.ttc.font.file", this.f5025b + this.f5033d));
    }

    protected static String T(String name) {
        int idx = name.toLowerCase().indexOf(".ttc,");
        if (idx < 0) {
            return name;
        }
        return name.substring(0, idx + 4);
    }

    /* access modifiers changed from: package-private */
    public void J() {
        int[] table_location = this.f5026b.get("head");
        boolean z = true;
        if (table_location != null) {
            this.f5020a.n((long) (table_location[0] + 16));
            this.f5021a.a = this.f5020a.readUnsignedShort();
            this.f5021a.b = this.f5020a.readUnsignedShort();
            this.f5020a.skipBytes(16);
            this.f5021a.f5040a = this.f5020a.readShort();
            this.f5021a.f5041b = this.f5020a.readShort();
            this.f5021a.f5042c = this.f5020a.readShort();
            this.f5021a.d = this.f5020a.readShort();
            this.f5021a.c = this.f5020a.readUnsignedShort();
            int[] table_location2 = this.f5026b.get("hhea");
            if (table_location2 != null) {
                this.f5020a.n((long) (table_location2[0] + 4));
                this.f5022a.f5043a = this.f5020a.readShort();
                this.f5022a.f5044b = this.f5020a.readShort();
                this.f5022a.c = this.f5020a.readShort();
                this.f5022a.a = this.f5020a.readUnsignedShort();
                this.f5022a.d = this.f5020a.readShort();
                this.f5022a.e = this.f5020a.readShort();
                this.f5022a.f = this.f5020a.readShort();
                this.f5022a.g = this.f5020a.readShort();
                this.f5022a.h = this.f5020a.readShort();
                this.f5020a.skipBytes(12);
                this.f5022a.b = this.f5020a.readUnsignedShort();
                int[] table_location3 = this.f5026b.get("OS/2");
                if (table_location3 != null) {
                    this.f5020a.n((long) table_location3[0]);
                    int version = this.f5020a.readUnsignedShort();
                    this.f5023a.f5045a = this.f5020a.readShort();
                    this.f5023a.a = this.f5020a.readUnsignedShort();
                    this.f5023a.b = this.f5020a.readUnsignedShort();
                    this.f5023a.f5047b = this.f5020a.readShort();
                    this.f5023a.f5049c = this.f5020a.readShort();
                    this.f5023a.f5050d = this.f5020a.readShort();
                    this.f5023a.f5051e = this.f5020a.readShort();
                    this.f5023a.f5052f = this.f5020a.readShort();
                    this.f5023a.f5053g = this.f5020a.readShort();
                    this.f5023a.f5054h = this.f5020a.readShort();
                    this.f5023a.f5055i = this.f5020a.readShort();
                    this.f5023a.f5056j = this.f5020a.readShort();
                    this.f5023a.k = this.f5020a.readShort();
                    this.f5023a.l = this.f5020a.readShort();
                    this.f5023a.m = this.f5020a.readShort();
                    this.f5020a.readFully(this.f5023a.f5046a);
                    this.f5020a.skipBytes(16);
                    this.f5020a.readFully(this.f5023a.f5048b);
                    this.f5023a.c = this.f5020a.readUnsignedShort();
                    this.f5023a.d = this.f5020a.readUnsignedShort();
                    this.f5023a.e = this.f5020a.readUnsignedShort();
                    this.f5023a.n = this.f5020a.readShort();
                    this.f5023a.o = this.f5020a.readShort();
                    c cVar = this.f5023a;
                    short s = cVar.o;
                    if (s > 0) {
                        cVar.o = (short) (-s);
                    }
                    cVar.p = this.f5020a.readShort();
                    this.f5023a.f = this.f5020a.readUnsignedShort();
                    this.f5023a.g = this.f5020a.readUnsignedShort();
                    c cVar2 = this.f5023a;
                    cVar2.h = 0;
                    cVar2.i = 0;
                    if (version > 0) {
                        cVar2.h = this.f5020a.readInt();
                        this.f5023a.i = this.f5020a.readInt();
                    }
                    if (version > 1) {
                        this.f5020a.skipBytes(2);
                        this.f5023a.j = this.f5020a.readShort();
                    } else {
                        this.f5023a.j = (int) (((double) this.f5021a.b) * 0.7d);
                    }
                } else if (!(this.f5026b.get("hhea") == null || this.f5026b.get("head") == null)) {
                    int i2 = this.f5021a.c;
                    if (i2 == 0) {
                        c cVar3 = this.f5023a;
                        cVar3.a = 700;
                        cVar3.b = 5;
                    } else if (i2 == 5) {
                        c cVar4 = this.f5023a;
                        cVar4.a = HttpStatus.SC_BAD_REQUEST;
                        cVar4.b = 3;
                    } else if (i2 == 6) {
                        c cVar5 = this.f5023a;
                        cVar5.a = HttpStatus.SC_BAD_REQUEST;
                        cVar5.b = 7;
                    } else {
                        c cVar6 = this.f5023a;
                        cVar6.a = HttpStatus.SC_BAD_REQUEST;
                        cVar6.b = 5;
                    }
                    c cVar7 = this.f5023a;
                    cVar7.f5047b = 0;
                    cVar7.f5050d = 0;
                    cVar7.f5052f = 0;
                    cVar7.f5054h = 0;
                    cVar7.f5056j = 0;
                    cVar7.k = 0;
                    cVar7.l = 0;
                    b bVar = this.f5022a;
                    short s2 = bVar.f5043a;
                    cVar7.n = (short) ((int) (((double) s2) - (((double) s2) * 0.21d)));
                    cVar7.o = (short) ((int) (-(((double) Math.abs(bVar.f5044b)) - (((double) Math.abs(this.f5022a.f5044b)) * 0.07d))));
                    c cVar8 = this.f5023a;
                    b bVar2 = this.f5022a;
                    cVar8.p = (short) (bVar2.c * 2);
                    cVar8.f = bVar2.f5043a;
                    cVar8.g = bVar2.f5044b;
                    cVar8.h = 0;
                    cVar8.i = 0;
                    cVar8.j = (int) (((double) this.f5021a.b) * 0.7d);
                }
                int[] table_location4 = this.f5026b.get("post");
                if (table_location4 == null) {
                    b bVar3 = this.f5022a;
                    this.a = ((-Math.atan2((double) bVar3.h, (double) bVar3.g)) * 180.0d) / 3.141592653589793d;
                } else {
                    this.f5020a.n((long) (table_location4[0] + 4));
                    this.a = ((double) this.f5020a.readShort()) + (((double) this.f5020a.readUnsignedShort()) / 16384.0d);
                    this.g = this.f5020a.readShort();
                    this.h = this.f5020a.readShort();
                    if (this.f5020a.readInt() == 0) {
                        z = false;
                    }
                    this.j = z;
                }
                int[] table_location5 = this.f5026b.get("maxp");
                if (table_location5 == null) {
                    this.f = 65536;
                    return;
                }
                this.f5020a.n((long) (table_location5[0] + 4));
                this.f = this.f5020a.readUnsignedShort();
                return;
            }
            throw new ih(i10.b("table.1.does.not.exist.in.2", "hhea", this.f5025b + this.f5033d));
        }
        throw new ih(i10.b("table.1.does.not.exist.in.2", "head", this.f5025b + this.f5033d));
    }

    /* access modifiers changed from: package-private */
    public String L() {
        int[] table_location = this.f5026b.get("name");
        if (table_location != null) {
            this.f5020a.n((long) (table_location[0] + 2));
            int numRecords = this.f5020a.readUnsignedShort();
            int startOfStorage = this.f5020a.readUnsignedShort();
            for (int k = 0; k < numRecords; k++) {
                int platformID = this.f5020a.readUnsignedShort();
                int readUnsignedShort = this.f5020a.readUnsignedShort();
                int readUnsignedShort2 = this.f5020a.readUnsignedShort();
                int nameID = this.f5020a.readUnsignedShort();
                int length = this.f5020a.readUnsignedShort();
                int offset = this.f5020a.readUnsignedShort();
                if (nameID == 6) {
                    this.f5020a.n((long) (table_location[0] + startOfStorage + offset));
                    if (platformID == 0 || platformID == 3) {
                        return f0(length);
                    }
                    return e0(length);
                }
            }
            return new File(this.f5025b).getName().replace(' ', '-');
        }
        throw new ih(i10.b("table.1.does.not.exist.in.2", "name", this.f5025b + this.f5033d));
    }

    /* access modifiers changed from: package-private */
    public String[][] R(int id) {
        int numRecords;
        int[] table_location;
        String name;
        int[] table_location2 = this.f5026b.get("name");
        if (table_location2 != null) {
            this.f5020a.n((long) (table_location2[0] + 2));
            int numRecords2 = this.f5020a.readUnsignedShort();
            int startOfStorage = this.f5020a.readUnsignedShort();
            ArrayList<String[]> names = new ArrayList<>();
            int k = 0;
            while (k < numRecords2) {
                int platformID = this.f5020a.readUnsignedShort();
                int platformEncodingID = this.f5020a.readUnsignedShort();
                int languageID = this.f5020a.readUnsignedShort();
                int nameID = this.f5020a.readUnsignedShort();
                int length = this.f5020a.readUnsignedShort();
                int offset = this.f5020a.readUnsignedShort();
                if (nameID == id) {
                    int pos = (int) this.f5020a.a();
                    table_location = table_location2;
                    numRecords = numRecords2;
                    this.f5020a.n((long) (table_location2[0] + startOfStorage + offset));
                    if (platformID == 0 || platformID == 3 || (platformID == 2 && platformEncodingID == 1)) {
                        name = f0(length);
                    } else {
                        name = e0(length);
                    }
                    names.add(new String[]{String.valueOf(platformID), String.valueOf(platformEncodingID), String.valueOf(languageID), name});
                    String str = name;
                    this.f5020a.n((long) pos);
                } else {
                    table_location = table_location2;
                    numRecords = numRecords2;
                }
                k++;
                table_location2 = table_location;
                numRecords2 = numRecords;
            }
            int i2 = id;
            int[] iArr = table_location2;
            int i3 = numRecords2;
            String[][] thisName = new String[names.size()][];
            for (int k2 = 0; k2 < names.size(); k2++) {
                thisName[k2] = names.get(k2);
            }
            return thisName;
        }
        throw new ih(i10.b("table.1.does.not.exist.in.2", "name", this.f5025b + this.f5033d));
    }

    /* access modifiers changed from: package-private */
    public String[][] K() {
        String name;
        int[] table_location = this.f5026b.get("name");
        char c2 = 0;
        if (table_location != null) {
            this.f5020a.n((long) (table_location[0] + 2));
            int numRecords = this.f5020a.readUnsignedShort();
            int startOfStorage = this.f5020a.readUnsignedShort();
            ArrayList<String[]> names = new ArrayList<>();
            int k = 0;
            while (k < numRecords) {
                int platformID = this.f5020a.readUnsignedShort();
                int platformEncodingID = this.f5020a.readUnsignedShort();
                int languageID = this.f5020a.readUnsignedShort();
                int nameID = this.f5020a.readUnsignedShort();
                int length = this.f5020a.readUnsignedShort();
                int offset = this.f5020a.readUnsignedShort();
                int startOfStorage2 = startOfStorage;
                int pos = (int) this.f5020a.a();
                this.f5020a.n((long) (table_location[c2] + startOfStorage2 + offset));
                if (platformID == 0 || platformID == 3 || (platformID == 2 && platformEncodingID == 1)) {
                    name = f0(length);
                } else {
                    name = e0(length);
                }
                names.add(new String[]{String.valueOf(nameID), String.valueOf(platformID), String.valueOf(platformEncodingID), String.valueOf(languageID), name});
                this.f5020a.n((long) pos);
                k++;
                table_location = table_location;
                numRecords = numRecords;
                startOfStorage = startOfStorage2;
                c2 = 0;
            }
            int i2 = numRecords;
            int i3 = startOfStorage;
            String[][] thisName = new String[names.size()][];
            for (int k2 = 0; k2 < names.size(); k2++) {
                thisName[k2] = names.get(k2);
            }
            return thisName;
        }
        throw new ih(i10.b("table.1.does.not.exist.in.2", "name", this.f5025b + this.f5033d));
    }

    /* access modifiers changed from: package-private */
    public void H() {
        int[] table_location = this.f5026b.get("CFF ");
        if (table_location != null) {
            this.i = true;
            this.c = table_location[0];
            this.d = table_location[1];
        }
    }

    /* access modifiers changed from: package-private */
    public void U(byte[] ttfAfm, boolean preload) {
        this.f5026b = new HashMap<>();
        if (ttfAfm == null) {
            this.f5020a = new cd0(this.f5025b, preload, gh.f);
        } else {
            this.f5020a = new cd0(ttfAfm);
        }
        try {
            if (this.f5030c.length() > 0) {
                int dirIdx = Integer.parseInt(this.f5030c);
                if (dirIdx < 0) {
                    throw new ih(i10.b("the.font.index.for.1.must.be.positive", this.f5025b));
                } else if (e0(4).equals("ttcf")) {
                    this.f5020a.skipBytes(4);
                    int dirCount = this.f5020a.readInt();
                    if (dirIdx < dirCount) {
                        this.f5020a.skipBytes(dirIdx * 4);
                        this.e = this.f5020a.readInt();
                    } else {
                        throw new ih(i10.b("the.font.index.for.1.must.be.between.0.and.2.it.was.3", this.f5025b, String.valueOf(dirCount - 1), String.valueOf(dirIdx)));
                    }
                } else {
                    throw new ih(i10.b("1.is.not.a.valid.ttc.file", this.f5025b));
                }
            }
            this.f5020a.n((long) this.e);
            int ttId = this.f5020a.readInt();
            if (ttId != 65536) {
                if (ttId != 1330926671) {
                    throw new ih(i10.b("1.is.not.a.valid.ttf.or.otf.file", this.f5025b));
                }
            }
            int num_tables = this.f5020a.readUnsignedShort();
            this.f5020a.skipBytes(6);
            for (int k = 0; k < num_tables; k++) {
                String tag = e0(4);
                this.f5020a.skipBytes(4);
                this.f5026b.put(tag, new int[]{this.f5020a.readInt(), this.f5020a.readInt()});
            }
            H();
            this.f5036e = L();
            this.f5029b = R(4);
            String[][] otfFamilyName = R(16);
            if (otfFamilyName.length > 0) {
                this.f5035d = otfFamilyName;
            } else {
                this.f5035d = R(1);
            }
            String[][] otfSubFamily = R(17);
            if (otfFamilyName.length > 0) {
                this.f5024a = otfSubFamily;
            } else {
                this.f5024a = R(2);
            }
            this.f5032c = K();
            if (!this.f5039h) {
                J();
                c0();
                W();
                d0();
                V();
            }
        } finally {
            if (!this.f5824a) {
                this.f5020a.close();
                this.f5020a = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public String e0(int length) {
        return this.f5020a.j(length, "Cp1252");
    }

    /* access modifiers changed from: protected */
    public String f0(int length) {
        StringBuffer buf = new StringBuffer();
        int length2 = length / 2;
        for (int k = 0; k < length2; k++) {
            buf.append(this.f5020a.readChar());
        }
        return buf.toString();
    }

    /* access modifiers changed from: protected */
    public void c0() {
        int[] table_location = this.f5026b.get("hmtx");
        if (table_location != null) {
            this.f5020a.n((long) table_location[0]);
            this.f5038f = new int[this.f5022a.b];
            for (int k = 0; k < this.f5022a.b; k++) {
                this.f5038f[k] = (this.f5020a.readUnsignedShort() * 1000) / this.f5021a.b;
                int readShort = (this.f5020a.readShort() * 1000) / this.f5021a.b;
            }
            return;
        }
        throw new ih(i10.b("table.1.does.not.exist.in.2", "hmtx", this.f5025b + this.f5033d));
    }

    /* access modifiers changed from: protected */
    public int P(int glyph) {
        int[] iArr = this.f5038f;
        if (glyph >= iArr.length) {
            glyph = iArr.length - 1;
        }
        return iArr[glyph];
    }

    private void V() {
        int[] locaTable;
        int[] tableLocation = this.f5026b.get("head");
        if (tableLocation != null) {
            this.f5020a.n((long) (tableLocation[0] + 51));
            boolean locaShortTable = this.f5020a.readUnsignedShort() == 0;
            int[] tableLocation2 = this.f5026b.get("loca");
            if (tableLocation2 != null) {
                this.f5020a.n((long) tableLocation2[0]);
                if (locaShortTable) {
                    int entries = tableLocation2[1] / 2;
                    locaTable = new int[entries];
                    for (int k = 0; k < entries; k++) {
                        locaTable[k] = this.f5020a.readUnsignedShort() * 2;
                    }
                } else {
                    int entries2 = tableLocation2[1] / 4;
                    locaTable = new int[entries2];
                    for (int k2 = 0; k2 < entries2; k2++) {
                        locaTable[k2] = this.f5020a.readInt();
                    }
                }
                int[] tableLocation3 = this.f5026b.get("glyf");
                if (tableLocation3 != null) {
                    int tableGlyphOffset = tableLocation3[0];
                    this.f5028b = new int[(locaTable.length - 1)][];
                    for (int glyph = 0; glyph < locaTable.length - 1; glyph++) {
                        int start = locaTable[glyph];
                        if (start != locaTable[glyph + 1]) {
                            this.f5020a.n((long) (tableGlyphOffset + start + 2));
                            this.f5028b[glyph] = new int[]{(this.f5020a.readShort() * 1000) / this.f5021a.b, (this.f5020a.readShort() * 1000) / this.f5021a.b, (this.f5020a.readShort() * 1000) / this.f5021a.b, (this.f5020a.readShort() * 1000) / this.f5021a.b};
                        }
                    }
                    return;
                }
                throw new ih(i10.b("table.1.does.not.exist.in.2", "glyf", this.f5025b + this.f5033d));
            }
            return;
        }
        throw new ih(i10.b("table.1.does.not.exist.in.2", "head", this.f5025b + this.f5033d));
    }

    /* access modifiers changed from: package-private */
    public void W() {
        int[] table_location = this.f5026b.get("cmap");
        if (table_location != null) {
            this.f5020a.n((long) table_location[0]);
            this.f5020a.skipBytes(2);
            int num_tables = this.f5020a.readUnsignedShort();
            this.f5830b = false;
            int map10 = 0;
            int map31 = 0;
            int map30 = 0;
            int mapExt = 0;
            for (int k = 0; k < num_tables; k++) {
                int platId = this.f5020a.readUnsignedShort();
                int platSpecId = this.f5020a.readUnsignedShort();
                int offset = this.f5020a.readInt();
                if (platId == 3 && platSpecId == 0) {
                    this.f5830b = true;
                    map30 = offset;
                } else if (platId == 3 && platSpecId == 1) {
                    map31 = offset;
                } else if (platId == 3 && platSpecId == 10) {
                    mapExt = offset;
                }
                if (platId == 1 && platSpecId == 0) {
                    map10 = offset;
                }
            }
            if (map10 > 0) {
                this.f5020a.n((long) (table_location[0] + map10));
                switch (this.f5020a.readUnsignedShort()) {
                    case 0:
                        this.f5031c = Y();
                        break;
                    case 4:
                        this.f5031c = a0();
                        break;
                    case 6:
                        this.f5031c = b0();
                        break;
                }
            }
            if (map31 > 0) {
                this.f5020a.n((long) (table_location[0] + map31));
                if (this.f5020a.readUnsignedShort() == 4) {
                    this.f5034d = a0();
                }
            }
            if (map30 > 0) {
                this.f5020a.n((long) (table_location[0] + map30));
                if (this.f5020a.readUnsignedShort() == 4) {
                    this.f5031c = a0();
                }
            }
            if (mapExt > 0) {
                this.f5020a.n((long) (table_location[0] + mapExt));
                switch (this.f5020a.readUnsignedShort()) {
                    case 0:
                        this.f5037e = Y();
                        return;
                    case 4:
                        this.f5037e = a0();
                        return;
                    case 6:
                        this.f5037e = b0();
                        return;
                    case 12:
                        this.f5037e = Z();
                        return;
                    default:
                        return;
                }
            }
        } else {
            throw new ih(i10.b("table.1.does.not.exist.in.2", "cmap", this.f5025b + this.f5033d));
        }
    }

    /* access modifiers changed from: package-private */
    public HashMap<Integer, int[]> Z() {
        HashMap<Integer, int[]> h2 = new HashMap<>();
        this.f5020a.skipBytes(2);
        int readInt = this.f5020a.readInt();
        this.f5020a.skipBytes(4);
        int nGroups = this.f5020a.readInt();
        for (int k = 0; k < nGroups; k++) {
            int startCharCode = this.f5020a.readInt();
            int endCharCode = this.f5020a.readInt();
            int startGlyphID = this.f5020a.readInt();
            for (int i2 = startCharCode; i2 <= endCharCode; i2++) {
                int[] r = new int[2];
                r[0] = startGlyphID;
                r[1] = P(r[0]);
                h2.put(Integer.valueOf(i2), r);
                startGlyphID++;
            }
        }
        return h2;
    }

    /* access modifiers changed from: package-private */
    public HashMap<Integer, int[]> Y() {
        HashMap<Integer, int[]> h2 = new HashMap<>();
        this.f5020a.skipBytes(4);
        for (int k = 0; k < 256; k++) {
            int[] r = new int[2];
            r[0] = this.f5020a.readUnsignedByte();
            r[1] = P(r[0]);
            h2.put(Integer.valueOf(k), r);
        }
        return h2;
    }

    /* access modifiers changed from: package-private */
    public HashMap<Integer, int[]> a0() {
        int glyph;
        HashMap<Integer, int[]> h2 = new HashMap<>();
        int table_lenght = this.f5020a.readUnsignedShort();
        this.f5020a.skipBytes(2);
        int segCount = this.f5020a.readUnsignedShort() / 2;
        this.f5020a.skipBytes(6);
        int[] endCount = new int[segCount];
        for (int k = 0; k < segCount; k++) {
            endCount[k] = this.f5020a.readUnsignedShort();
        }
        this.f5020a.skipBytes(2);
        int[] startCount = new int[segCount];
        for (int k2 = 0; k2 < segCount; k2++) {
            startCount[k2] = this.f5020a.readUnsignedShort();
        }
        int[] idDelta = new int[segCount];
        for (int k3 = 0; k3 < segCount; k3++) {
            idDelta[k3] = this.f5020a.readUnsignedShort();
        }
        int[] idRO = new int[segCount];
        for (int k4 = 0; k4 < segCount; k4++) {
            idRO[k4] = this.f5020a.readUnsignedShort();
        }
        int[] glyphId = new int[(((table_lenght / 2) - 8) - (segCount * 4))];
        for (int k5 = 0; k5 < glyphId.length; k5++) {
            glyphId[k5] = this.f5020a.readUnsignedShort();
        }
        for (int k6 = 0; k6 < segCount; k6++) {
            int j2 = startCount[k6];
            while (j2 <= endCount[k6] && j2 != 65535) {
                if (idRO[k6] == 0) {
                    glyph = 65535 & (idDelta[k6] + j2);
                } else {
                    int idx = ((((idRO[k6] / 2) + k6) - segCount) + j2) - startCount[k6];
                    if (idx >= glyphId.length) {
                        j2++;
                    } else {
                        glyph = 65535 & (glyphId[idx] + idDelta[k6]);
                    }
                }
                int[] r = new int[2];
                r[0] = glyph;
                r[1] = P(r[0]);
                h2.put(Integer.valueOf((!this.f5830b || (65280 & j2) != 61440) ? j2 : j2 & 255), r);
                j2++;
            }
        }
        return h2;
    }

    /* access modifiers changed from: package-private */
    public HashMap<Integer, int[]> b0() {
        HashMap<Integer, int[]> h2 = new HashMap<>();
        this.f5020a.skipBytes(4);
        int start_code = this.f5020a.readUnsignedShort();
        int code_count = this.f5020a.readUnsignedShort();
        for (int k = 0; k < code_count; k++) {
            int[] r = new int[2];
            r[0] = this.f5020a.readUnsignedShort();
            r[1] = P(r[0]);
            h2.put(Integer.valueOf(k + start_code), r);
        }
        return h2;
    }

    /* access modifiers changed from: package-private */
    public void d0() {
        int[] table_location = this.f5026b.get("kern");
        if (table_location != null) {
            this.f5020a.n((long) (table_location[0] + 2));
            int nTables = this.f5020a.readUnsignedShort();
            int checkpoint = table_location[0] + 4;
            int length = 0;
            for (int k = 0; k < nTables; k++) {
                checkpoint += length;
                this.f5020a.n((long) checkpoint);
                this.f5020a.skipBytes(2);
                length = this.f5020a.readUnsignedShort();
                if ((65527 & this.f5020a.readUnsignedShort()) == 1) {
                    int nPairs = this.f5020a.readUnsignedShort();
                    this.f5020a.skipBytes(6);
                    for (int j2 = 0; j2 < nPairs; j2++) {
                        this.f5027b.d(this.f5020a.readInt(), (this.f5020a.readShort() * 1000) / this.f5021a.b);
                    }
                }
            }
        }
    }

    public int n(int char1, int char2) {
        int[] metrics = Q(char1);
        if (metrics == null) {
            return 0;
        }
        int c1 = metrics[0];
        int[] metrics2 = Q(char2);
        if (metrics2 == null) {
            return 0;
        }
        return this.f5027b.b((c1 << 16) + metrics2[0]);
    }

    /* access modifiers changed from: package-private */
    public int q(int c2, String name) {
        int[] metric = Q(c2);
        if (metric == null) {
            return 0;
        }
        return metric[1];
    }

    /* access modifiers changed from: protected */
    public j60 N(z60 fontStream, String subsetPrefix, z60 cidset) {
        j60 dic = new j60(h70.e4);
        dic.Q(h70.P, new k70((this.f5023a.n * 1000) / this.f5021a.b));
        dic.Q(h70.I0, new k70((this.f5023a.j * 1000) / this.f5021a.b));
        dic.Q(h70.n2, new k70((this.f5023a.o * 1000) / this.f5021a.b));
        h70 h70 = h70.d4;
        a aVar = this.f5021a;
        int i2 = aVar.b;
        dic.Q(h70, new f80((float) ((aVar.f5040a * 1000) / i2), (float) ((aVar.f5041b * 1000) / i2), (float) ((aVar.f5042c * 1000) / i2), (float) ((aVar.d * 1000) / i2)));
        if (cidset != null) {
            dic.Q(h70.b1, cidset);
        }
        if (!this.i) {
            h70 h702 = h70.k4;
            dic.Q(h702, new h70(subsetPrefix + this.f5036e + this.f5033d));
        } else if (this.f5821a.startsWith("Identity-")) {
            h70 h703 = h70.k4;
            dic.Q(h703, new h70(subsetPrefix + this.f5036e + "-" + this.f5821a));
        } else {
            h70 h704 = h70.k4;
            dic.Q(h704, new h70(subsetPrefix + this.f5036e + this.f5033d));
        }
        dic.Q(h70.O5, new k70(this.a));
        dic.Q(h70.hb, new k70(80));
        if (fontStream != null) {
            if (this.i) {
                dic.Q(h70.i4, fontStream);
            } else {
                dic.Q(h70.h4, fontStream);
            }
        }
        int flags = 0;
        if (this.j) {
            flags = 0 | 1;
        }
        int flags2 = flags | (this.f5830b ? 4 : 32);
        int i3 = this.f5021a.c;
        if ((i3 & 2) != 0) {
            flags2 |= 64;
        }
        if ((i3 & 1) != 0) {
            flags2 |= 262144;
        }
        dic.Q(h70.X3, new k70(flags2));
        return dic;
    }

    /* access modifiers changed from: protected */
    public j60 M(z60 fontDescriptor, String subsetPrefix, int firstChar, int lastChar, byte[] shortTag) {
        j60 dic = new j60(h70.c4);
        if (this.i) {
            dic.Q(h70.tb, h70.Dc);
            h70 h70 = h70.c0;
            dic.Q(h70, new h70(this.f5036e + this.f5033d));
        } else {
            dic.Q(h70.tb, h70.rc);
            h70 h702 = h70.c0;
            dic.Q(h702, new h70(subsetPrefix + this.f5036e + this.f5033d));
        }
        if (!this.f5830b) {
            int k = firstChar;
            while (true) {
                if (k > lastChar) {
                    break;
                } else if (!this.f5827a[k].equals(".notdef")) {
                    firstChar = k;
                    break;
                } else {
                    k++;
                }
            }
            if (this.f5821a.equals("Cp1252") || this.f5821a.equals("MacRoman")) {
                dic.Q(h70.d3, this.f5821a.equals("Cp1252") ? h70.Dd : h70.J6);
            } else {
                j60 enc = new j60(h70.d3);
                x50 dif = new x50();
                boolean gap = true;
                for (int k2 = firstChar; k2 <= lastChar; k2++) {
                    if (shortTag[k2] != 0) {
                        if (gap) {
                            dif.I(new k70(k2));
                            gap = false;
                        }
                        dif.I(new h70(this.f5827a[k2]));
                    } else {
                        gap = true;
                    }
                }
                enc.Q(h70.w2, dif);
                dic.Q(h70.d3, enc);
            }
        }
        dic.Q(h70.M3, new k70(firstChar));
        dic.Q(h70.g6, new k70(lastChar));
        x50 wd = new x50();
        for (int k3 = firstChar; k3 <= lastChar; k3++) {
            if (shortTag[k3] == 0) {
                wd.I(new k70(0));
            } else {
                wd.I(new k70(this.f5826a[k3]));
            }
        }
        dic.Q(h70.Bd, wd);
        if (fontDescriptor != null) {
            dic.Q(h70.e4, fontDescriptor);
        }
        return dic;
    }

    /* access modifiers changed from: protected */
    public byte[] O() {
        cd0 rf2 = null;
        try {
            rf2 = new cd0(this.f5020a);
            rf2.d();
            byte[] b2 = new byte[((int) rf2.b())];
            rf2.readFully(b2);
            try {
                rf2.close();
            } catch (Exception e2) {
            }
            return b2;
        } catch (Throwable th) {
            if (rf2 != null) {
                try {
                    rf2.close();
                } catch (Exception e3) {
                }
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public synchronized byte[] S(HashSet glyphs, boolean subsetp) {
        return new ts0(this.f5025b, new cd0(this.f5020a), glyphs, this.e, true, !subsetp).h();
    }

    protected static int[] I(ArrayList<int[]> ranges) {
        ArrayList<int[]> simp = new ArrayList<>();
        for (int k = 0; k < ranges.size(); k++) {
            int[] r = ranges.get(k);
            for (int j2 = 0; j2 < r.length; j2 += 2) {
                simp.add(new int[]{Math.max(0, Math.min(r[j2], r[j2 + 1])), Math.min(SupportMenu.USER_MASK, Math.max(r[j2], r[j2 + 1]))});
            }
        }
        for (int k1 = 0; k1 < simp.size() - 1; k1++) {
            int k2 = k1 + 1;
            while (k2 < simp.size()) {
                int[] r1 = simp.get(k1);
                int[] r2 = simp.get(k2);
                if ((r1[0] >= r2[0] && r1[0] <= r2[1]) || (r1[1] >= r2[0] && r1[0] <= r2[1])) {
                    r1[0] = Math.min(r1[0], r2[0]);
                    r1[1] = Math.max(r1[1], r2[1]);
                    simp.remove(k2);
                    k2--;
                }
                k2++;
            }
        }
        int[] s = new int[(simp.size() * 2)];
        for (int k3 = 0; k3 < simp.size(); k3++) {
            int[] r3 = simp.get(k3);
            s[k3 * 2] = r3[0];
            s[(k3 * 2) + 1] = r3[1];
        }
        return s;
    }

    /* access modifiers changed from: protected */
    public void F(HashMap<Integer, int[]> longTag, boolean includeMetrics, boolean subsetp) {
        HashMap<Integer, int[]> usemap;
        if (!subsetp) {
            ArrayList<int[]> arrayList = this.f5822a;
            if (arrayList != null || this.e > 0) {
                int[] rg = (arrayList != null || this.e <= 0) ? I(arrayList) : new int[]{0, SupportMenu.USER_MASK};
                boolean z = this.f5830b;
                if (!z && this.f5034d != null) {
                    usemap = this.f5034d;
                } else if (z && this.f5031c != null) {
                    usemap = this.f5031c;
                } else if (this.f5034d != null) {
                    usemap = this.f5034d;
                } else {
                    usemap = this.f5031c;
                }
                for (Map.Entry<Integer, int[]> e2 : usemap.entrySet()) {
                    int[] v = e2.getValue();
                    Integer gi = Integer.valueOf(v[0]);
                    if (!longTag.containsKey(gi)) {
                        int c2 = e2.getKey().intValue();
                        boolean skip = true;
                        int k = 0;
                        while (true) {
                            if (k < rg.length) {
                                if (c2 >= rg[k] && c2 <= rg[k + 1]) {
                                    skip = false;
                                    break;
                                }
                                k += 2;
                            } else {
                                break;
                            }
                        }
                        if (!skip) {
                            longTag.put(gi, includeMetrics ? new int[]{v[0], v[1], c2} : null);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void G(HashSet<Integer> longTag, boolean subsetp) {
        HashMap<Integer, int[]> usemap;
        if (!subsetp) {
            ArrayList<int[]> arrayList = this.f5822a;
            if (arrayList != null || this.e > 0) {
                int[] rg = (arrayList != null || this.e <= 0) ? I(arrayList) : new int[]{0, SupportMenu.USER_MASK};
                boolean z = this.f5830b;
                if (!z && this.f5034d != null) {
                    usemap = this.f5034d;
                } else if (z && this.f5031c != null) {
                    usemap = this.f5031c;
                } else if (this.f5034d != null) {
                    usemap = this.f5034d;
                } else {
                    usemap = this.f5031c;
                }
                for (Map.Entry<Integer, int[]> e2 : usemap.entrySet()) {
                    Integer gi = Integer.valueOf(e2.getValue()[0]);
                    if (!longTag.contains(gi)) {
                        int c2 = e2.getKey().intValue();
                        boolean skip = true;
                        int k = 0;
                        while (true) {
                            if (k < rg.length) {
                                if (c2 >= rg[k] && c2 <= rg[k + 1]) {
                                    skip = false;
                                    break;
                                }
                                k += 2;
                            } else {
                                break;
                            }
                        }
                        if (!skip) {
                            longTag.add(gi);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void E(v80 writer, z60 ref, Object[] params) {
        int lastChar;
        int firstChar;
        String subsetPrefix;
        z60 ind_font;
        byte[] b2;
        v80 v80 = writer;
        int firstChar2 = params[0].intValue();
        int lastChar2 = params[1].intValue();
        byte[] shortTag = params[2];
        boolean subsetp = params[3].booleanValue() && this.f5833e;
        if (!subsetp) {
            int lastChar3 = shortTag.length - 1;
            for (int k = 0; k < shortTag.length; k++) {
                shortTag[k] = 1;
            }
            firstChar = 0;
            lastChar = lastChar3;
        } else {
            firstChar = firstChar2;
            lastChar = lastChar2;
        }
        z60 ind_font2 = null;
        y60 obj = null;
        String subsetPrefix2 = "";
        if (!this.f5824a) {
            subsetPrefix = subsetPrefix2;
        } else if (this.i) {
            obj = v80.y(new y5.a(X(), "Type1C", this.f5829b));
            ind_font2 = obj.a();
            subsetPrefix = subsetPrefix2;
        } else {
            if (subsetp) {
                subsetPrefix2 = y5.h();
            }
            HashSet<Integer> glyphs = new HashSet<>();
            for (int k2 = firstChar; k2 <= lastChar; k2++) {
                if (shortTag[k2] != 0) {
                    int[] metrics = null;
                    if (this.f5823a != null) {
                        int[] cd = mp.a(this.f5827a[k2]);
                        if (cd != null) {
                            metrics = Q(cd[0]);
                        }
                    } else if (this.f5830b) {
                        metrics = Q(k2);
                    } else {
                        metrics = Q(this.f5825a[k2]);
                    }
                    if (metrics != null) {
                        glyphs.add(Integer.valueOf(metrics[0]));
                    }
                }
            }
            G(glyphs, subsetp);
            if (!subsetp && this.e == 0 && this.f5822a == null) {
                b2 = O();
            } else {
                b2 = S(new HashSet(glyphs), subsetp);
            }
            obj = v80.y(new y5.a(b2, new int[]{b2.length}, this.f5829b));
            ind_font2 = obj.a();
            subsetPrefix = subsetPrefix2;
        }
        o70 pobj = N(ind_font2, subsetPrefix, (z60) null);
        if (pobj != null) {
            y60 obj2 = v80.y(pobj);
            ind_font = obj2.a();
            y60 y60 = obj2;
        } else {
            ind_font = ind_font2;
            y60 y602 = obj;
        }
        v80.z(M(ind_font, subsetPrefix, firstChar, lastChar, shortTag), ref);
    }

    /* access modifiers changed from: protected */
    public byte[] X() {
        cd0 rf2 = new cd0(this.f5020a);
        byte[] b2 = new byte[this.d];
        try {
            rf2.d();
            rf2.n((long) this.c);
            rf2.readFully(b2);
            return b2;
        } finally {
            try {
                rf2.close();
            } catch (Exception e2) {
            }
        }
    }

    public float l(int key, float fontSize) {
        switch (key) {
            case 1:
                return (((float) this.f5023a.n) * fontSize) / ((float) this.f5021a.b);
            case 2:
                return (((float) this.f5023a.j) * fontSize) / ((float) this.f5021a.b);
            case 3:
                return (((float) this.f5023a.o) * fontSize) / ((float) this.f5021a.b);
            case 4:
                return (float) this.a;
            case 5:
                a aVar = this.f5021a;
                return (((float) aVar.f5040a) * fontSize) / ((float) aVar.b);
            case 6:
                a aVar2 = this.f5021a;
                return (((float) aVar2.f5041b) * fontSize) / ((float) aVar2.b);
            case 7:
                a aVar3 = this.f5021a;
                return (((float) aVar3.f5042c) * fontSize) / ((float) aVar3.b);
            case 8:
                a aVar4 = this.f5021a;
                return (((float) aVar4.d) * fontSize) / ((float) aVar4.b);
            case 9:
                return (((float) this.f5022a.f5043a) * fontSize) / ((float) this.f5021a.b);
            case 10:
                return (((float) this.f5022a.f5044b) * fontSize) / ((float) this.f5021a.b);
            case 11:
                return (((float) this.f5022a.c) * fontSize) / ((float) this.f5021a.b);
            case 12:
                return (((float) this.f5022a.a) * fontSize) / ((float) this.f5021a.b);
            case 13:
                return (((float) (this.g - (this.h / 2))) * fontSize) / ((float) this.f5021a.b);
            case 14:
                return (((float) this.h) * fontSize) / ((float) this.f5021a.b);
            case 15:
                return (((float) this.f5023a.l) * fontSize) / ((float) this.f5021a.b);
            case 16:
                return (((float) this.f5023a.k) * fontSize) / ((float) this.f5021a.b);
            case 17:
                return (((float) this.f5023a.f5050d) * fontSize) / ((float) this.f5021a.b);
            case 18:
                return (((float) (-this.f5023a.f5052f)) * fontSize) / ((float) this.f5021a.b);
            case 19:
                return (((float) this.f5023a.f5054h) * fontSize) / ((float) this.f5021a.b);
            case 20:
                return (((float) this.f5023a.f5056j) * fontSize) / ((float) this.f5021a.b);
            case 21:
                return (float) this.f5023a.a;
            case 22:
                return (float) this.f5023a.b;
            default:
                return 0.0f;
        }
    }

    public int[] Q(int c2) {
        HashMap<Integer, int[]> hashMap;
        HashMap<Integer, int[]> hashMap2;
        HashMap<Integer, int[]> hashMap3 = this.f5037e;
        if (hashMap3 != null) {
            return hashMap3.get(Integer.valueOf(c2));
        }
        boolean z = this.f5830b;
        if (!z && (hashMap2 = this.f5034d) != null) {
            return hashMap2.get(Integer.valueOf(c2));
        }
        if (z && (hashMap = this.f5031c) != null) {
            return hashMap.get(Integer.valueOf(c2));
        }
        HashMap<Integer, int[]> hashMap4 = this.f5034d;
        if (hashMap4 != null) {
            return hashMap4.get(Integer.valueOf(c2));
        }
        HashMap<Integer, int[]> hashMap5 = this.f5031c;
        if (hashMap5 != null) {
            return hashMap5.get(Integer.valueOf(c2));
        }
        return null;
    }

    public String o() {
        return this.f5036e;
    }

    public String[][] k() {
        return this.f5035d;
    }

    public boolean y() {
        return this.f5027b.g() > 0;
    }

    /* access modifiers changed from: protected */
    public int[] p(int c2, String name) {
        HashMap<Integer, int[]> map;
        int[] metric;
        int[][] iArr;
        if (name == null || this.f5034d == null) {
            map = this.f5031c;
        } else {
            map = this.f5034d;
        }
        if (map == null || (metric = map.get(Integer.valueOf(c2))) == null || (iArr = this.f5028b) == null) {
            return null;
        }
        return iArr[metric[0]];
    }
}
