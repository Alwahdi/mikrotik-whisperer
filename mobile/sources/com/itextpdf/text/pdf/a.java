package com.itextpdf.text.pdf;

import androidx.core.view.InputDeviceCompat;

public class a {
    public static final boolean[] a;

    /* renamed from: a  reason: collision with other field name */
    private final cd0 f2636a;

    /* renamed from: a  reason: collision with other field name */
    protected C0036a f2637a;

    /* renamed from: a  reason: collision with other field name */
    protected String f2638a;

    /* renamed from: a  reason: collision with other field name */
    private final StringBuilder f2639a = new StringBuilder();

    /* renamed from: a  reason: collision with other field name */
    protected boolean f2640a;

    /* renamed from: com.itextpdf.text.pdf.a$a  reason: collision with other inner class name */
    public enum C0036a {
        NUMBER,
        STRING,
        NAME,
        COMMENT,
        START_ARRAY,
        END_ARRAY,
        START_DIC,
        END_DIC,
        REF,
        OTHER,
        ENDOFFILE
    }

    static {
        boolean[] zArr = new boolean[InputDeviceCompat.SOURCE_KEYBOARD];
        // fill-array-data instruction
        zArr[0] = 1;
        zArr[1] = 1;
        zArr[2] = 0;
        zArr[3] = 0;
        zArr[4] = 0;
        zArr[5] = 0;
        zArr[6] = 0;
        zArr[7] = 0;
        zArr[8] = 0;
        zArr[9] = 0;
        zArr[10] = 1;
        zArr[11] = 1;
        zArr[12] = 0;
        zArr[13] = 1;
        zArr[14] = 1;
        zArr[15] = 0;
        zArr[16] = 0;
        zArr[17] = 0;
        zArr[18] = 0;
        zArr[19] = 0;
        zArr[20] = 0;
        zArr[21] = 0;
        zArr[22] = 0;
        zArr[23] = 0;
        zArr[24] = 0;
        zArr[25] = 0;
        zArr[26] = 0;
        zArr[27] = 0;
        zArr[28] = 0;
        zArr[29] = 0;
        zArr[30] = 0;
        zArr[31] = 0;
        zArr[32] = 0;
        zArr[33] = 1;
        zArr[34] = 0;
        zArr[35] = 0;
        zArr[36] = 0;
        zArr[37] = 0;
        zArr[38] = 1;
        zArr[39] = 0;
        zArr[40] = 0;
        zArr[41] = 1;
        zArr[42] = 1;
        zArr[43] = 0;
        zArr[44] = 0;
        zArr[45] = 0;
        zArr[46] = 0;
        zArr[47] = 0;
        zArr[48] = 1;
        zArr[49] = 0;
        zArr[50] = 0;
        zArr[51] = 0;
        zArr[52] = 0;
        zArr[53] = 0;
        zArr[54] = 0;
        zArr[55] = 0;
        zArr[56] = 0;
        zArr[57] = 0;
        zArr[58] = 0;
        zArr[59] = 0;
        zArr[60] = 0;
        zArr[61] = 1;
        zArr[62] = 0;
        zArr[63] = 1;
        zArr[64] = 0;
        zArr[65] = 0;
        zArr[66] = 0;
        zArr[67] = 0;
        zArr[68] = 0;
        zArr[69] = 0;
        zArr[70] = 0;
        zArr[71] = 0;
        zArr[72] = 0;
        zArr[73] = 0;
        zArr[74] = 0;
        zArr[75] = 0;
        zArr[76] = 0;
        zArr[77] = 0;
        zArr[78] = 0;
        zArr[79] = 0;
        zArr[80] = 0;
        zArr[81] = 0;
        zArr[82] = 0;
        zArr[83] = 0;
        zArr[84] = 0;
        zArr[85] = 0;
        zArr[86] = 0;
        zArr[87] = 0;
        zArr[88] = 0;
        zArr[89] = 0;
        zArr[90] = 0;
        zArr[91] = 0;
        zArr[92] = 1;
        zArr[93] = 0;
        zArr[94] = 1;
        zArr[95] = 0;
        zArr[96] = 0;
        zArr[97] = 0;
        zArr[98] = 0;
        zArr[99] = 0;
        zArr[100] = 0;
        zArr[101] = 0;
        zArr[102] = 0;
        zArr[103] = 0;
        zArr[104] = 0;
        zArr[105] = 0;
        zArr[106] = 0;
        zArr[107] = 0;
        zArr[108] = 0;
        zArr[109] = 0;
        zArr[110] = 0;
        zArr[111] = 0;
        zArr[112] = 0;
        zArr[113] = 0;
        zArr[114] = 0;
        zArr[115] = 0;
        zArr[116] = 0;
        zArr[117] = 0;
        zArr[118] = 0;
        zArr[119] = 0;
        zArr[120] = 0;
        zArr[121] = 0;
        zArr[122] = 0;
        zArr[123] = 0;
        zArr[124] = 0;
        zArr[125] = 0;
        zArr[126] = 0;
        zArr[127] = 0;
        zArr[128] = 0;
        zArr[129] = 0;
        zArr[130] = 0;
        zArr[131] = 0;
        zArr[132] = 0;
        zArr[133] = 0;
        zArr[134] = 0;
        zArr[135] = 0;
        zArr[136] = 0;
        zArr[137] = 0;
        zArr[138] = 0;
        zArr[139] = 0;
        zArr[140] = 0;
        zArr[141] = 0;
        zArr[142] = 0;
        zArr[143] = 0;
        zArr[144] = 0;
        zArr[145] = 0;
        zArr[146] = 0;
        zArr[147] = 0;
        zArr[148] = 0;
        zArr[149] = 0;
        zArr[150] = 0;
        zArr[151] = 0;
        zArr[152] = 0;
        zArr[153] = 0;
        zArr[154] = 0;
        zArr[155] = 0;
        zArr[156] = 0;
        zArr[157] = 0;
        zArr[158] = 0;
        zArr[159] = 0;
        zArr[160] = 0;
        zArr[161] = 0;
        zArr[162] = 0;
        zArr[163] = 0;
        zArr[164] = 0;
        zArr[165] = 0;
        zArr[166] = 0;
        zArr[167] = 0;
        zArr[168] = 0;
        zArr[169] = 0;
        zArr[170] = 0;
        zArr[171] = 0;
        zArr[172] = 0;
        zArr[173] = 0;
        zArr[174] = 0;
        zArr[175] = 0;
        zArr[176] = 0;
        zArr[177] = 0;
        zArr[178] = 0;
        zArr[179] = 0;
        zArr[180] = 0;
        zArr[181] = 0;
        zArr[182] = 0;
        zArr[183] = 0;
        zArr[184] = 0;
        zArr[185] = 0;
        zArr[186] = 0;
        zArr[187] = 0;
        zArr[188] = 0;
        zArr[189] = 0;
        zArr[190] = 0;
        zArr[191] = 0;
        zArr[192] = 0;
        zArr[193] = 0;
        zArr[194] = 0;
        zArr[195] = 0;
        zArr[196] = 0;
        zArr[197] = 0;
        zArr[198] = 0;
        zArr[199] = 0;
        zArr[200] = 0;
        zArr[201] = 0;
        zArr[202] = 0;
        zArr[203] = 0;
        zArr[204] = 0;
        zArr[205] = 0;
        zArr[206] = 0;
        zArr[207] = 0;
        zArr[208] = 0;
        zArr[209] = 0;
        zArr[210] = 0;
        zArr[211] = 0;
        zArr[212] = 0;
        zArr[213] = 0;
        zArr[214] = 0;
        zArr[215] = 0;
        zArr[216] = 0;
        zArr[217] = 0;
        zArr[218] = 0;
        zArr[219] = 0;
        zArr[220] = 0;
        zArr[221] = 0;
        zArr[222] = 0;
        zArr[223] = 0;
        zArr[224] = 0;
        zArr[225] = 0;
        zArr[226] = 0;
        zArr[227] = 0;
        zArr[228] = 0;
        zArr[229] = 0;
        zArr[230] = 0;
        zArr[231] = 0;
        zArr[232] = 0;
        zArr[233] = 0;
        zArr[234] = 0;
        zArr[235] = 0;
        zArr[236] = 0;
        zArr[237] = 0;
        zArr[238] = 0;
        zArr[239] = 0;
        zArr[240] = 0;
        zArr[241] = 0;
        zArr[242] = 0;
        zArr[243] = 0;
        zArr[244] = 0;
        zArr[245] = 0;
        zArr[246] = 0;
        zArr[247] = 0;
        zArr[248] = 0;
        zArr[249] = 0;
        zArr[250] = 0;
        zArr[251] = 0;
        zArr[252] = 0;
        zArr[253] = 0;
        zArr[254] = 0;
        zArr[255] = 0;
        zArr[256] = 0;
        a = zArr;
    }

    public a(cd0 file) {
        this.f2636a = file;
    }

    public void b() {
        this.f2636a.close();
    }

    public static final boolean g(int ch) {
        return h(ch, true);
    }

    public static final boolean h(int ch, boolean isWhitespace) {
        return (isWhitespace && ch == 0) || ch == 9 || ch == 10 || ch == 12 || ch == 13 || ch == 32;
    }

    public C0036a e() {
        return this.f2637a;
    }

    public String d() {
        return this.f2638a;
    }

    public void a(int ch) {
        if (ch != -1) {
            this.f2636a.c((byte) ch);
        }
    }

    public void j(String error) {
        throw new tu(i10.b("1.at.file.pointer.2", error, String.valueOf(this.f2636a.a())));
    }

    public static int c(int v) {
        if (v >= 48 && v <= 57) {
            return v - 48;
        }
        if (v >= 65 && v <= 70) {
            return (v - 65) + 10;
        }
        if (v < 97 || v > 102) {
            return -1;
        }
        return (v - 97) + 10;
    }

    public boolean i() {
        int ch;
        int ch2;
        int ch3;
        do {
            ch = this.f2636a.read();
            if (ch == -1 || !g(ch)) {
            }
            ch = this.f2636a.read();
            break;
        } while (!g(ch));
        if (ch == -1) {
            this.f2637a = C0036a.ENDOFFILE;
            return false;
        }
        this.f2639a.setLength(0);
        this.f2638a = "";
        switch (ch) {
            case 37:
                this.f2637a = C0036a.COMMENT;
                do {
                    ch2 = this.f2636a.read();
                    if (!(ch2 == -1 || ch2 == 13)) {
                    }
                } while (ch2 != 10);
                break;
            case 40:
                this.f2639a.setLength(0);
                this.f2637a = C0036a.STRING;
                this.f2640a = false;
                int nesting = 0;
                while (true) {
                    ch3 = this.f2636a.read();
                    if (ch3 != -1) {
                        if (ch3 == 40) {
                            nesting++;
                        } else if (ch3 == 41) {
                            nesting--;
                        } else if (ch3 == 92) {
                            boolean lineBreak = false;
                            ch3 = this.f2636a.read();
                            switch (ch3) {
                                case 10:
                                    lineBreak = true;
                                    break;
                                case 13:
                                    lineBreak = true;
                                    ch3 = this.f2636a.read();
                                    if (ch3 != 10) {
                                        a(ch3);
                                        break;
                                    }
                                    break;
                                case 40:
                                case 41:
                                case 92:
                                    break;
                                case 98:
                                    ch3 = 8;
                                    break;
                                case 102:
                                    ch3 = 12;
                                    break;
                                case 110:
                                    ch3 = 10;
                                    break;
                                case 114:
                                    ch3 = 13;
                                    break;
                                case 116:
                                    ch3 = 9;
                                    break;
                                default:
                                    if (ch3 >= 48 && ch3 <= 55) {
                                        int octal = ch3 - 48;
                                        int ch4 = this.f2636a.read();
                                        if (ch4 >= 48 && ch4 <= 55) {
                                            int octal2 = ((octal << 3) + ch4) - 48;
                                            int ch5 = this.f2636a.read();
                                            if (ch5 >= 48 && ch5 <= 55) {
                                                ch3 = (((octal2 << 3) + ch5) - 48) & 255;
                                                break;
                                            } else {
                                                a(ch5);
                                                ch3 = octal2;
                                                break;
                                            }
                                        } else {
                                            a(ch4);
                                            ch3 = octal;
                                            break;
                                        }
                                    }
                            }
                            if (lineBreak) {
                                continue;
                            } else if (ch3 < 0) {
                            }
                        } else if (ch3 == 13) {
                            ch3 = this.f2636a.read();
                            if (ch3 >= 0) {
                                if (ch3 != 10) {
                                    a(ch3);
                                    ch3 = 10;
                                }
                            }
                        }
                        if (nesting != -1) {
                            this.f2639a.append((char) ch3);
                        }
                    }
                }
                if (ch3 == -1) {
                    j(i10.b("error.reading.string", new Object[0]));
                    break;
                }
                break;
            case 47:
                this.f2639a.setLength(0);
                this.f2637a = C0036a.NAME;
                while (true) {
                    int ch6 = this.f2636a.read();
                    if (a[ch6 + 1]) {
                        a(ch6);
                        break;
                    } else {
                        if (ch6 == 35) {
                            ch6 = (c(this.f2636a.read()) << 4) + c(this.f2636a.read());
                        }
                        this.f2639a.append((char) ch6);
                    }
                }
            case 60:
                int v1 = this.f2636a.read();
                if (v1 != 60) {
                    this.f2639a.setLength(0);
                    this.f2637a = C0036a.STRING;
                    this.f2640a = true;
                    int v2 = 0;
                    while (true) {
                        if (g(v1)) {
                            v1 = this.f2636a.read();
                        } else if (v1 != 62 && (v1 = c(v1)) >= 0) {
                            v2 = this.f2636a.read();
                            while (g(v2)) {
                                v2 = this.f2636a.read();
                            }
                            if (v2 == 62) {
                                this.f2639a.append((char) (v1 << 4));
                            } else {
                                v2 = c(v2);
                                if (v2 >= 0) {
                                    this.f2639a.append((char) ((v1 << 4) + v2));
                                    v1 = this.f2636a.read();
                                }
                            }
                        }
                    }
                    if (v1 < 0 || v2 < 0) {
                        j(i10.b("error.reading.string", new Object[0]));
                        break;
                    }
                } else {
                    this.f2637a = C0036a.START_DIC;
                    break;
                }
            case 62:
                if (this.f2636a.read() != 62) {
                    j(i10.b("greaterthan.not.expected", new Object[0]));
                }
                this.f2637a = C0036a.END_DIC;
                break;
            case 91:
                this.f2637a = C0036a.START_ARRAY;
                break;
            case 93:
                this.f2637a = C0036a.END_ARRAY;
                break;
            default:
                this.f2639a.setLength(0);
                if (ch == 45 || ch == 43 || ch == 46 || (ch >= 48 && ch <= 57)) {
                    this.f2637a = C0036a.NUMBER;
                    boolean isReal = false;
                    int numberOfMinuses = 0;
                    if (ch == 45) {
                        do {
                            numberOfMinuses++;
                            ch = this.f2636a.read();
                        } while (ch == 45);
                        this.f2639a.append('-');
                    } else {
                        this.f2639a.append((char) ch);
                        ch = this.f2636a.read();
                    }
                    while (ch != -1 && ((ch >= 48 && ch <= 57) || ch == 46)) {
                        if (ch == 46) {
                            isReal = true;
                        }
                        this.f2639a.append((char) ch);
                        ch = this.f2636a.read();
                    }
                    if (numberOfMinuses > 1 && !isReal) {
                        this.f2639a.setLength(0);
                        this.f2639a.append('0');
                    }
                } else {
                    this.f2637a = C0036a.OTHER;
                    do {
                        this.f2639a.append((char) ch);
                        ch = this.f2636a.read();
                    } while (!a[ch + 1]);
                }
                if (ch != -1) {
                    a(ch);
                    break;
                }
                break;
        }
        StringBuilder sb = this.f2639a;
        if (sb != null) {
            this.f2638a = sb.toString();
        }
        return true;
    }

    public boolean f() {
        return this.f2640a;
    }
}
