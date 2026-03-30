package defpackage;

import org.apache.http.cookie.ClientCookie;

/* renamed from: c7  reason: default package */
public abstract class c7 {
    static final String[] a = {ClientCookie.VERSION_ATTR, "Notice", "FullName", "FamilyName", "Weight", "FontBBox", "BlueValues", "OtherBlues", "FamilyBlues", "FamilyOtherBlues", "StdHW", "StdVW", "UNKNOWN_12", "UniqueID", "XUID", "charset", "Encoding", "CharStrings", "Private", "Subrs", "defaultWidthX", "nominalWidthX", "UNKNOWN_22", "UNKNOWN_23", "UNKNOWN_24", "UNKNOWN_25", "UNKNOWN_26", "UNKNOWN_27", "UNKNOWN_28", "UNKNOWN_29", "UNKNOWN_30", "UNKNOWN_31", "Copyright", "isFixedPitch", "ItalicAngle", "UnderlinePosition", "UnderlineThickness", "PaintType", "CharstringType", "FontMatrix", "StrokeWidth", "BlueScale", "BlueShift", "BlueFuzz", "StemSnapH", "StemSnapV", "ForceBold", "UNKNOWN_12_15", "UNKNOWN_12_16", "LanguageGroup", "ExpansionFactor", "initialRandomSeed", "SyntheticBase", "PostScript", "BaseFontName", "BaseFontBlend", "UNKNOWN_12_24", "UNKNOWN_12_25", "UNKNOWN_12_26", "UNKNOWN_12_27", "UNKNOWN_12_28", "UNKNOWN_12_29", "ROS", "CIDFontVersion", "CIDFontRevision", "CIDFontType", "CIDCount", "UIDBase", "FDArray", "FDSelect", "FontName"};
    static final String[] b = {".notdef", "space", "exclam", "quotedbl", "numbersign", "dollar", "percent", "ampersand", "quoteright", "parenleft", "parenright", "asterisk", "plus", "comma", "hyphen", "period", "slash", "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "colon", "semicolon", "less", "equal", "greater", "question", "at", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "bracketleft", "backslash", "bracketright", "asciicircum", "underscore", "quoteleft", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "braceleft", "bar", "braceright", "asciitilde", "exclamdown", "cent", "sterling", "fraction", "yen", "florin", "section", "currency", "quotesingle", "quotedblleft", "guillemotleft", "guilsinglleft", "guilsinglright", "fi", "fl", "endash", "dagger", "daggerdbl", "periodcentered", "paragraph", "bullet", "quotesinglbase", "quotedblbase", "quotedblright", "guillemotright", "ellipsis", "perthousand", "questiondown", "grave", "acute", "circumflex", "tilde", "macron", "breve", "dotaccent", "dieresis", "ring", "cedilla", "hungarumlaut", "ogonek", "caron", "emdash", "AE", "ordfeminine", "Lslash", "Oslash", "OE", "ordmasculine", "ae", "dotlessi", "lslash", "oslash", "oe", "germandbls", "onesuperior", "logicalnot", "mu", "trademark", "Eth", "onehalf", "plusminus", "Thorn", "onequarter", "divide", "brokenbar", "degree", "thorn", "threequarters", "twosuperior", "registered", "minus", "eth", "multiply", "threesuperior", "copyright", "Aacute", "Acircumflex", "Adieresis", "Agrave", "Aring", "Atilde", "Ccedilla", "Eacute", "Ecircumflex", "Edieresis", "Egrave", "Iacute", "Icircumflex", "Idieresis", "Igrave", "Ntilde", "Oacute", "Ocircumflex", "Odieresis", "Ograve", "Otilde", "Scaron", "Uacute", "Ucircumflex", "Udieresis", "Ugrave", "Yacute", "Ydieresis", "Zcaron", "aacute", "acircumflex", "adieresis", "agrave", "aring", "atilde", "ccedilla", "eacute", "ecircumflex", "edieresis", "egrave", "iacute", "icircumflex", "idieresis", "igrave", "ntilde", "oacute", "ocircumflex", "odieresis", "ograve", "otilde", "scaron", "uacute", "ucircumflex", "udieresis", "ugrave", "yacute", "ydieresis", "zcaron", "exclamsmall", "Hungarumlautsmall", "dollaroldstyle", "dollarsuperior", "ampersandsmall", "Acutesmall", "parenleftsuperior", "parenrightsuperior", "twodotenleader", "onedotenleader", "zerooldstyle", "oneoldstyle", "twooldstyle", "threeoldstyle", "fouroldstyle", "fiveoldstyle", "sixoldstyle", "sevenoldstyle", "eightoldstyle", "nineoldstyle", "commasuperior", "threequartersemdash", "periodsuperior", "questionsmall", "asuperior", "bsuperior", "centsuperior", "dsuperior", "esuperior", "isuperior", "lsuperior", "msuperior", "nsuperior", "osuperior", "rsuperior", "ssuperior", "tsuperior", "ff", "ffi", "ffl", "parenleftinferior", "parenrightinferior", "Circumflexsmall", "hyphensuperior", "Gravesmall", "Asmall", "Bsmall", "Csmall", "Dsmall", "Esmall", "Fsmall", "Gsmall", "Hsmall", "Ismall", "Jsmall", "Ksmall", "Lsmall", "Msmall", "Nsmall", "Osmall", "Psmall", "Qsmall", "Rsmall", "Ssmall", "Tsmall", "Usmall", "Vsmall", "Wsmall", "Xsmall", "Ysmall", "Zsmall", "colonmonetary", "onefitted", "rupiah", "Tildesmall", "exclamdownsmall", "centoldstyle", "Lslashsmall", "Scaronsmall", "Zcaronsmall", "Dieresissmall", "Brevesmall", "Caronsmall", "Dotaccentsmall", "Macronsmall", "figuredash", "hypheninferior", "Ogoneksmall", "Ringsmall", "Cedillasmall", "questiondownsmall", "oneeighth", "threeeighths", "fiveeighths", "seveneighths", "onethird", "twothirds", "zerosuperior", "foursuperior", "fivesuperior", "sixsuperior", "sevensuperior", "eightsuperior", "ninesuperior", "zeroinferior", "oneinferior", "twoinferior", "threeinferior", "fourinferior", "fiveinferior", "sixinferior", "seveninferior", "eightinferior", "nineinferior", "centinferior", "dollarinferior", "periodinferior", "commainferior", "Agravesmall", "Aacutesmall", "Acircumflexsmall", "Atildesmall", "Adieresissmall", "Aringsmall", "AEsmall", "Ccedillasmall", "Egravesmall", "Eacutesmall", "Ecircumflexsmall", "Edieresissmall", "Igravesmall", "Iacutesmall", "Icircumflexsmall", "Idieresissmall", "Ethsmall", "Ntildesmall", "Ogravesmall", "Oacutesmall", "Ocircumflexsmall", "Otildesmall", "Odieresissmall", "OEsmall", "Oslashsmall", "Ugravesmall", "Uacutesmall", "Ucircumflexsmall", "Udieresissmall", "Yacutesmall", "Thornsmall", "Ydieresissmall", "001.000", "001.001", "001.002", "001.003", "Black", "Bold", "Book", "Light", "Medium", "Regular", "Roman", "Semibold"};

    /* renamed from: a  reason: collision with other field name */
    int f290a;

    /* renamed from: a  reason: collision with other field name */
    protected cd0 f291a;

    /* renamed from: a  reason: collision with other field name */
    protected String f292a;

    /* renamed from: a  reason: collision with other field name */
    protected int[] f293a;

    /* renamed from: a  reason: collision with other field name */
    protected c[] f294a;

    /* renamed from: a  reason: collision with other field name */
    protected Object[] f295a = new Object[48];

    /* renamed from: b  reason: collision with other field name */
    protected int f296b = 0;

    /* renamed from: b  reason: collision with other field name */
    protected int[] f297b;
    private int c;

    /* renamed from: c  reason: collision with other field name */
    protected int[] f298c;
    protected int d;

    /* renamed from: d  reason: collision with other field name */
    protected int[] f299d;
    protected int e;
    protected int f;
    protected int g;

    /* renamed from: c7$d */
    protected static final class d extends g {
    }

    public String k(char sid) {
        String[] strArr = b;
        if (sid < strArr.length) {
            return strArr[sid];
        }
        if (sid >= (strArr.length + this.f298c.length) - 1) {
            return null;
        }
        int j2 = sid - strArr.length;
        int p2 = i();
        l(this.f298c[j2]);
        StringBuffer s = new StringBuffer();
        for (int k2 = this.f298c[j2]; k2 < this.f298c[j2 + 1]; k2++) {
            s.append(b());
        }
        l(p2);
        return s.toString();
    }

    /* access modifiers changed from: package-private */
    public char b() {
        try {
            return (char) (this.f291a.readByte() & 255);
        } catch (Exception e2) {
            throw new mj(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public char a() {
        try {
            return this.f291a.readChar();
        } catch (Exception e2) {
            throw new mj(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public int h(int offSize) {
        int offset = 0;
        for (int i2 = 0; i2 < offSize; i2++) {
            offset = (offset * 256) + b();
        }
        return offset;
    }

    /* access modifiers changed from: package-private */
    public void l(int offset) {
        try {
            this.f291a.n((long) offset);
        } catch (Exception e2) {
            throw new mj(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public short j() {
        try {
            return this.f291a.readShort();
        } catch (Exception e2) {
            throw new mj(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public int f() {
        try {
            return this.f291a.readInt();
        } catch (Exception e2) {
            throw new mj(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public int i() {
        try {
            return (int) this.f291a.a();
        } catch (Exception e2) {
            throw new mj(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public int[] e(int nextIndexOffset) {
        l(nextIndexOffset);
        int count = a();
        int[] offsets = new int[(count + 1)];
        if (count == 0) {
            offsets[0] = -1;
            int nextIndexOffset2 = nextIndexOffset + 2;
            return offsets;
        }
        int indexOffSize = b();
        for (int j2 = 0; j2 <= count; j2++) {
            offsets[j2] = ((((nextIndexOffset + 2) + 1) + ((count + 1) * indexOffSize)) - 1) + h(indexOffSize);
        }
        return offsets;
    }

    /* access modifiers changed from: protected */
    public void c() {
        for (int i2 = 0; i2 < this.f296b; i2++) {
            this.f295a[i2] = null;
        }
        this.f296b = 0;
        this.f292a = null;
        boolean gotKey = false;
        while (!gotKey) {
            char b0 = b();
            if (b0 == 29) {
                this.f295a[this.f296b] = Integer.valueOf(f());
                this.f296b++;
            } else if (b0 == 28) {
                this.f295a[this.f296b] = Integer.valueOf(j());
                this.f296b++;
            } else if (b0 >= ' ' && b0 <= 246) {
                this.f295a[this.f296b] = Integer.valueOf((byte) (b0 - 139));
                this.f296b++;
            } else if (b0 >= 247 && b0 <= 250) {
                this.f295a[this.f296b] = Integer.valueOf((short) (((b0 - 247) * 256) + b() + 108));
                this.f296b++;
            } else if (b0 >= 251 && b0 <= 254) {
                this.f295a[this.f296b] = Integer.valueOf((short) ((((-(b0 - 251)) * 256) - b()) - 108));
                this.f296b++;
            } else if (b0 == 30) {
                StringBuilder item = new StringBuilder("");
                boolean done = false;
                char buffer = 0;
                byte avail = 0;
                int nibble = 0;
                while (!done) {
                    if (avail == 0) {
                        buffer = b();
                        avail = 2;
                    }
                    if (avail == 1) {
                        nibble = buffer / 16;
                        avail = (byte) (avail - 1);
                    }
                    if (avail == 2) {
                        nibble = buffer % 16;
                        avail = (byte) (avail - 1);
                    }
                    switch (nibble) {
                        case 10:
                            item.append(".");
                            break;
                        case 11:
                            item.append("E");
                            break;
                        case 12:
                            item.append("E-");
                            break;
                        case 14:
                            item.append("-");
                            break;
                        case 15:
                            done = true;
                            break;
                        default:
                            if (nibble >= 0 && nibble <= 9) {
                                item.append(String.valueOf(nibble));
                                break;
                            } else {
                                item.append("<NIBBLE ERROR: ");
                                item.append(nibble);
                                item.append('>');
                                done = true;
                                break;
                            }
                            break;
                    }
                }
                this.f295a[this.f296b] = item.toString();
                this.f296b++;
            } else if (b0 <= 21) {
                gotKey = true;
                if (b0 != 12) {
                    this.f292a = a[b0];
                } else {
                    this.f292a = a[b() + ' '];
                }
            }
        }
    }

    /* renamed from: c7$g */
    protected static abstract class g {
        protected int a = -1;

        protected g() {
        }

        public void b(int[] currentOffset) {
            this.a = currentOffset[0];
        }

        public void a(byte[] buffer) {
        }

        public void c() {
        }
    }

    /* renamed from: c7$i */
    protected static abstract class i extends g {
        public int b;

        protected i() {
        }

        public void d(int offset) {
            this.b = offset;
        }
    }

    /* renamed from: c7$j */
    protected static final class j extends g {
        private cd0 a;
        public int b;
        public int c;

        public j(cd0 buf, int offset, int length) {
            this.b = offset;
            this.c = length;
            this.a = buf;
        }

        public void b(int[] currentOffset) {
            super.b(currentOffset);
            currentOffset[0] = currentOffset[0] + this.c;
        }

        public void a(byte[] buffer) {
            try {
                this.a.n((long) this.b);
                for (int i = this.a; i < this.a + this.c; i++) {
                    buffer[i] = this.a.readByte();
                }
            } catch (Exception e) {
                throw new mj(e);
            }
        }
    }

    /* renamed from: c7$f */
    protected static final class f extends i {
        public final int c;

        public f(int size, int value) {
            this.c = size;
            this.b = value;
        }

        public f(int size) {
            this.c = size;
        }

        public void b(int[] currentOffset) {
            super.b(currentOffset);
            currentOffset[0] = currentOffset[0] + this.c;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0015, code lost:
            r4[r3.a + r0] = (byte) ((r3.b >>> 16) & 255);
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0023, code lost:
            r4[r3.a + r0] = (byte) ((r3.b >>> 8) & 255);
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0031, code lost:
            r4[r3.a + r0] = (byte) ((r3.b >>> 0) & 255);
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(byte[] r4) {
            /*
                r3 = this;
                r0 = 0
                int r1 = r3.c
                switch(r1) {
                    case 1: goto L_0x0031;
                    case 2: goto L_0x0023;
                    case 3: goto L_0x0015;
                    case 4: goto L_0x0007;
                    default: goto L_0x0006;
                }
            L_0x0006:
                goto L_0x003f
            L_0x0007:
                int r1 = r3.a
                int r1 = r1 + r0
                int r2 = r3.b
                int r2 = r2 >>> 24
                r2 = r2 & 255(0xff, float:3.57E-43)
                byte r2 = (byte) r2
                r4[r1] = r2
                int r0 = r0 + 1
            L_0x0015:
                int r1 = r3.a
                int r1 = r1 + r0
                int r2 = r3.b
                int r2 = r2 >>> 16
                r2 = r2 & 255(0xff, float:3.57E-43)
                byte r2 = (byte) r2
                r4[r1] = r2
                int r0 = r0 + 1
            L_0x0023:
                int r1 = r3.a
                int r1 = r1 + r0
                int r2 = r3.b
                int r2 = r2 >>> 8
                r2 = r2 & 255(0xff, float:3.57E-43)
                byte r2 = (byte) r2
                r4[r1] = r2
                int r0 = r0 + 1
            L_0x0031:
                int r1 = r3.a
                int r1 = r1 + r0
                int r2 = r3.b
                int r2 = r2 >>> 0
                r2 = r2 & 255(0xff, float:3.57E-43)
                byte r2 = (byte) r2
                r4[r1] = r2
                int r0 = r0 + 1
            L_0x003f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.c7.f.a(byte[]):void");
        }
    }

    /* renamed from: c7$e */
    protected static final class e extends g {
        private d a;

        /* renamed from: a  reason: collision with other field name */
        private i f312a;

        public e(i offItem, d indexBase) {
            this.f312a = offItem;
            this.a = indexBase;
        }

        public void c() {
            this.f312a.d((this.a - this.a.a) + 1);
        }
    }

    /* renamed from: c7$l */
    protected static final class l extends g {
        private d a;

        /* renamed from: a  reason: collision with other field name */
        private i f313a;

        public l(i offItem, d indexBase) {
            this.f313a = offItem;
            this.a = indexBase;
        }

        public void c() {
            this.f313a.d(this.a - this.a.a);
        }
    }

    /* renamed from: c7$b */
    protected static final class b extends i {
        public final int c = 5;

        public void b(int[] currentOffset) {
            super.b(currentOffset);
            currentOffset[0] = currentOffset[0] + this.c;
        }

        public void a(byte[] buffer) {
            if (this.c == 5) {
                int i = this.a;
                buffer[i] = 29;
                int i2 = this.b;
                buffer[i + 1] = (byte) ((i2 >>> 24) & 255);
                buffer[i + 2] = (byte) ((i2 >>> 16) & 255);
                buffer[i + 3] = (byte) ((i2 >>> 8) & 255);
                buffer[i + 4] = (byte) ((i2 >>> 0) & 255);
            }
        }
    }

    /* renamed from: c7$n */
    protected static final class n extends g {
        public int b;

        public n(int value) {
            this.b = value;
        }

        public void b(int[] currentOffset) {
            super.b(currentOffset);
            currentOffset[0] = currentOffset[0] + 3;
        }

        public void a(byte[] buffer) {
            int i = this.a;
            int i2 = this.b;
            buffer[i + 0] = (byte) ((i2 >>> 16) & 255);
            buffer[i + 1] = (byte) ((i2 >>> 8) & 255);
            buffer[i + 2] = (byte) ((i2 >>> 0) & 255);
        }
    }

    /* renamed from: c7$o */
    protected static final class o extends g {
        public int b;

        public o(int value) {
            this.b = value;
        }

        public void b(int[] currentOffset) {
            super.b(currentOffset);
            currentOffset[0] = currentOffset[0] + 4;
        }

        public void a(byte[] buffer) {
            int i = this.a;
            int i2 = this.b;
            buffer[i + 0] = (byte) ((i2 >>> 24) & 255);
            buffer[i + 1] = (byte) ((i2 >>> 16) & 255);
            buffer[i + 2] = (byte) ((i2 >>> 8) & 255);
            buffer[i + 3] = (byte) ((i2 >>> 0) & 255);
        }
    }

    /* renamed from: c7$m */
    protected static final class m extends g {
        public char a;

        public m(char value) {
            this.a = value;
        }

        public void b(int[] currentOffset) {
            super.b(currentOffset);
            currentOffset[0] = currentOffset[0] + 2;
        }

        public void a(byte[] buffer) {
            int i = this.a;
            char c = this.a;
            buffer[i + 0] = (byte) ((c >>> 8) & 255);
            buffer[i + 1] = (byte) ((c >>> 0) & 255);
        }
    }

    /* renamed from: c7$p */
    protected static final class p extends g {
        public char a;

        public p(char value) {
            this.a = value;
        }

        public void b(int[] currentOffset) {
            super.b(currentOffset);
            currentOffset[0] = currentOffset[0] + 1;
        }

        public void a(byte[] buffer) {
            buffer[this.a + 0] = (byte) ((this.a >>> 0) & 255);
        }
    }

    /* renamed from: c7$k */
    protected static final class k extends g {
        public String a;

        public k(String s) {
            this.a = s;
        }

        public void b(int[] currentOffset) {
            super.b(currentOffset);
            currentOffset[0] = currentOffset[0] + this.a.length();
        }

        public void a(byte[] buffer) {
            for (int i = 0; i < this.a.length(); i++) {
                buffer[this.a + i] = (byte) (this.a.charAt(i) & 255);
            }
        }
    }

    /* renamed from: c7$a */
    protected static final class a extends g {
        public final int b;
        public int c = 5;

        public a(int value) {
            this.b = value;
        }

        public void b(int[] currentOffset) {
            super.b(currentOffset);
            currentOffset[0] = currentOffset[0] + this.c;
        }

        public void a(byte[] buffer) {
            if (this.c == 5) {
                int i = this.a;
                buffer[i] = 29;
                int i2 = this.b;
                buffer[i + 1] = (byte) ((i2 >>> 24) & 255);
                buffer[i + 2] = (byte) ((i2 >>> 16) & 255);
                buffer[i + 3] = (byte) ((i2 >>> 8) & 255);
                buffer[i + 4] = (byte) ((i2 >>> 0) & 255);
            }
        }
    }

    /* renamed from: c7$h */
    protected static final class h extends g {
        i a;

        public h(i pointerToMarker) {
            this.a = pointerToMarker;
        }

        public void c() {
            this.a.d(this.a);
        }
    }

    /* access modifiers changed from: protected */
    public j d(int indexOffset) {
        l(indexOffset);
        int count = a();
        if (count == 0) {
            return new j(this.f291a, indexOffset, 2);
        }
        int indexOffSize = b();
        l(indexOffset + 2 + 1 + (count * indexOffSize));
        return new j(this.f291a, indexOffset, ((count + 1) * indexOffSize) + 3 + (h(indexOffSize) - 1));
    }

    public String[] g() {
        String[] names = new String[this.f294a.length];
        int i2 = 0;
        while (true) {
            c[] cVarArr = this.f294a;
            if (i2 >= cVarArr.length) {
                return names;
            }
            names[i2] = cVarArr[i2].f301a;
            i2++;
        }
    }

    /* renamed from: c7$c */
    protected final class c {
        public int a = -1;

        /* renamed from: a  reason: collision with other field name */
        public String f301a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f302a = false;

        /* renamed from: a  reason: collision with other field name */
        public int[] f303a;

        /* renamed from: a  reason: collision with other field name */
        public int[][] f304a;
        public int b = -1;

        /* renamed from: b  reason: collision with other field name */
        public String f305b;

        /* renamed from: b  reason: collision with other field name */
        public int[] f306b;
        public int c = -1;

        /* renamed from: c  reason: collision with other field name */
        public int[] f307c;
        public int d = -1;

        /* renamed from: d  reason: collision with other field name */
        public int[] f308d;
        public int e = -1;

        /* renamed from: e  reason: collision with other field name */
        public int[] f309e;
        public int f = -1;

        /* renamed from: f  reason: collision with other field name */
        public int[] f310f;
        public int g = -1;

        /* renamed from: g  reason: collision with other field name */
        public int[] f311g;
        public int h = -1;
        public int i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n = 2;
        public int o;
        public int p;

        protected c() {
        }
    }

    public c7(cd0 inputbuffer) {
        this.f291a = inputbuffer;
        l(0);
        char b2 = b();
        char b3 = b();
        int hdrSize = b();
        this.c = b();
        this.d = hdrSize;
        int[] e2 = e(hdrSize);
        this.f293a = e2;
        int i2 = e2[e2.length - 1];
        this.e = i2;
        int[] e3 = e(i2);
        this.f297b = e3;
        int i3 = e3[e3.length - 1];
        this.f = i3;
        int[] e4 = e(i3);
        this.f298c = e4;
        int i4 = e4[e4.length - 1];
        this.g = i4;
        this.f299d = e(i4);
        this.f294a = new c[(this.f293a.length - 1)];
        for (int j2 = 0; j2 < this.f293a.length - 1; j2++) {
            this.f294a[j2] = new c();
            l(this.f293a[j2]);
            this.f294a[j2].f301a = "";
            for (int k2 = this.f293a[j2]; k2 < this.f293a[j2 + 1]; k2++) {
                StringBuilder sb = new StringBuilder();
                c cVar = this.f294a[j2];
                sb.append(cVar.f301a);
                sb.append(b());
                cVar.f301a = sb.toString();
            }
        }
        int j3 = 0;
        while (true) {
            int[] iArr = this.f297b;
            if (j3 < iArr.length - 1) {
                l(iArr[j3]);
                while (i() < this.f297b[j3 + 1]) {
                    c();
                    String str = this.f292a;
                    if (str == "FullName") {
                        this.f294a[j3].f305b = k((char) ((Integer) this.f295a[0]).intValue());
                    } else if (str == "ROS") {
                        this.f294a[j3].f302a = true;
                    } else if (str == "Private") {
                        this.f294a[j3].b = ((Integer) this.f295a[0]).intValue();
                        this.f294a[j3].a = ((Integer) this.f295a[1]).intValue();
                    } else if (str == "charset") {
                        this.f294a[j3].f = ((Integer) this.f295a[0]).intValue();
                    } else if (str == "CharStrings") {
                        this.f294a[j3].d = ((Integer) this.f295a[0]).intValue();
                        int p2 = i();
                        c[] cVarArr = this.f294a;
                        cVarArr[j3].f307c = e(cVarArr[j3].d);
                        l(p2);
                    } else if (str == "FDArray") {
                        this.f294a[j3].g = ((Integer) this.f295a[0]).intValue();
                    } else if (str == "FDSelect") {
                        this.f294a[j3].h = ((Integer) this.f295a[0]).intValue();
                    } else if (str == "CharstringType") {
                        this.f294a[j3].n = ((Integer) this.f295a[0]).intValue();
                    }
                }
                c[] cVarArr2 = this.f294a;
                if (cVarArr2[j3].a >= 0) {
                    l(cVarArr2[j3].a);
                    while (true) {
                        int i5 = i();
                        c[] cVarArr3 = this.f294a;
                        if (i5 >= cVarArr3[j3].a + cVarArr3[j3].b) {
                            break;
                        }
                        c();
                        if (this.f292a == "Subrs") {
                            this.f294a[j3].c = ((Integer) this.f295a[0]).intValue() + this.f294a[j3].a;
                        }
                    }
                }
                c[] cVarArr4 = this.f294a;
                if (cVarArr4[j3].g >= 0) {
                    int[] fdarrayOffsets = e(cVarArr4[j3].g);
                    c[] cVarArr5 = this.f294a;
                    cVarArr5[j3].f303a = new int[(fdarrayOffsets.length - 1)];
                    cVarArr5[j3].f306b = new int[(fdarrayOffsets.length - 1)];
                    for (int k3 = 0; k3 < fdarrayOffsets.length - 1; k3++) {
                        l(fdarrayOffsets[k3]);
                        while (i() < fdarrayOffsets[k3 + 1]) {
                            c();
                            if (this.f292a == "Private") {
                                this.f294a[j3].f306b[k3] = ((Integer) this.f295a[0]).intValue();
                                this.f294a[j3].f303a[k3] = ((Integer) this.f295a[1]).intValue();
                            }
                        }
                    }
                }
                j3++;
            } else {
                return;
            }
        }
    }
}
