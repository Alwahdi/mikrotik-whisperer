package defpackage;

import javax.security.auth.x500.X500Principal;

/* renamed from: dh  reason: default package */
final class dh {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final String f2757a;

    /* renamed from: a  reason: collision with other field name */
    private char[] f2758a;
    private int b;
    private int c;
    private int d;
    private int e;

    public dh(X500Principal principal) {
        String name = principal.getName("RFC2253");
        this.f2757a = name;
        this.a = name.length();
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0015 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String g() {
        /*
            r7 = this;
        L_0x0000:
            int r0 = r7.b
            int r1 = r7.a
            r2 = 32
            if (r0 >= r1) goto L_0x0013
            char[] r3 = r7.f2758a
            char r3 = r3[r0]
            if (r3 != r2) goto L_0x0013
            int r0 = r0 + 1
            r7.b = r0
            goto L_0x0000
        L_0x0013:
            if (r0 != r1) goto L_0x0017
            r0 = 0
            return r0
        L_0x0017:
            r7.c = r0
            int r0 = r0 + 1
            r7.b = r0
        L_0x001d:
            int r0 = r7.b
            int r1 = r7.a
            r3 = 61
            if (r0 >= r1) goto L_0x0034
            char[] r4 = r7.f2758a
            char r5 = r4[r0]
            if (r5 == r3) goto L_0x0034
            char r4 = r4[r0]
            if (r4 == r2) goto L_0x0034
            int r0 = r0 + 1
            r7.b = r0
            goto L_0x001d
        L_0x0034:
            java.lang.String r4 = "Unexpected end of DN: "
            if (r0 >= r1) goto L_0x00d9
            r7.d = r0
            char[] r1 = r7.f2758a
            char r0 = r1[r0]
            if (r0 != r2) goto L_0x0075
        L_0x0040:
            int r0 = r7.b
            int r1 = r7.a
            if (r0 >= r1) goto L_0x0055
            char[] r5 = r7.f2758a
            char r6 = r5[r0]
            if (r6 == r3) goto L_0x0055
            char r5 = r5[r0]
            if (r5 != r2) goto L_0x0055
            int r0 = r0 + 1
            r7.b = r0
            goto L_0x0040
        L_0x0055:
            char[] r5 = r7.f2758a
            char r5 = r5[r0]
            if (r5 != r3) goto L_0x005e
            if (r0 == r1) goto L_0x005e
            goto L_0x0075
        L_0x005e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r2 = r7.f2757a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0075:
            int r0 = r7.b
            int r0 = r0 + 1
            r7.b = r0
        L_0x007b:
            int r0 = r7.b
            int r1 = r7.a
            if (r0 >= r1) goto L_0x008c
            char[] r1 = r7.f2758a
            char r1 = r1[r0]
            if (r1 != r2) goto L_0x008c
            int r0 = r0 + 1
            r7.b = r0
            goto L_0x007b
        L_0x008c:
            int r0 = r7.d
            int r1 = r7.c
            int r2 = r0 - r1
            r3 = 4
            if (r2 <= r3) goto L_0x00ce
            char[] r2 = r7.f2758a
            int r4 = r1 + 3
            char r4 = r2[r4]
            r5 = 46
            if (r4 != r5) goto L_0x00ce
            char r4 = r2[r1]
            r5 = 79
            if (r4 == r5) goto L_0x00ab
            char r4 = r2[r1]
            r5 = 111(0x6f, float:1.56E-43)
            if (r4 != r5) goto L_0x00ce
        L_0x00ab:
            int r4 = r1 + 1
            char r4 = r2[r4]
            r5 = 73
            if (r4 == r5) goto L_0x00bb
            int r4 = r1 + 1
            char r4 = r2[r4]
            r5 = 105(0x69, float:1.47E-43)
            if (r4 != r5) goto L_0x00ce
        L_0x00bb:
            int r4 = r1 + 2
            char r4 = r2[r4]
            r5 = 68
            if (r4 == r5) goto L_0x00cb
            int r4 = r1 + 2
            char r2 = r2[r4]
            r4 = 100
            if (r2 != r4) goto L_0x00ce
        L_0x00cb:
            int r1 = r1 + r3
            r7.c = r1
        L_0x00ce:
            java.lang.String r1 = new java.lang.String
            char[] r2 = r7.f2758a
            int r3 = r7.c
            int r0 = r0 - r3
            r1.<init>(r2, r3, r0)
            return r1
        L_0x00d9:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r2 = r7.f2757a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dh.g():java.lang.String");
    }

    private String h() {
        int i = this.b + 1;
        this.b = i;
        this.c = i;
        this.d = i;
        while (true) {
            int i2 = this.b;
            if (i2 != this.a) {
                char[] cArr = this.f2758a;
                if (cArr[i2] == '\"') {
                    this.b = i2 + 1;
                    while (true) {
                        int i3 = this.b;
                        if (i3 >= this.a || this.f2758a[i3] != ' ') {
                            char[] cArr2 = this.f2758a;
                            int i4 = this.c;
                        } else {
                            this.b = i3 + 1;
                        }
                    }
                    char[] cArr22 = this.f2758a;
                    int i42 = this.c;
                    return new String(cArr22, i42, this.d - i42);
                }
                if (cArr[i2] == '\\') {
                    cArr[this.d] = d();
                } else {
                    cArr[this.d] = cArr[i2];
                }
                this.b++;
                this.d++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.f2757a);
            }
        }
    }

    private String f() {
        int i;
        int i2 = this.b;
        if (i2 + 4 < this.a) {
            this.c = i2;
            this.b = i2 + 1;
            while (true) {
                i = this.b;
                if (i == this.a) {
                    break;
                }
                char[] cArr = this.f2758a;
                if (cArr[i] == '+' || cArr[i] == ',' || cArr[i] == ';') {
                    break;
                } else if (cArr[i] == ' ') {
                    this.d = i;
                    this.b = i + 1;
                    while (true) {
                        int i3 = this.b;
                        if (i3 >= this.a || this.f2758a[i3] != ' ') {
                            break;
                        }
                        this.b = i3 + 1;
                    }
                } else {
                    if (cArr[i] >= 'A' && cArr[i] <= 'F') {
                        cArr[i] = (char) (cArr[i] + ' ');
                    }
                    this.b = i + 1;
                }
            }
            this.d = i;
            int i4 = this.d;
            int i5 = this.c;
            int hexLen = i4 - i5;
            if (hexLen < 5 || (hexLen & 1) == 0) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f2757a);
            }
            byte[] encoded = new byte[(hexLen / 2)];
            int p = i5 + 1;
            for (int i6 = 0; i6 < encoded.length; i6++) {
                encoded[i6] = (byte) c(p);
                p += 2;
            }
            return new String(this.f2758a, this.c, hexLen);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f2757a);
    }

    private String a() {
        int i;
        int i2;
        int i3 = this.b;
        this.c = i3;
        this.d = i3;
        while (true) {
            int i4 = this.b;
            if (i4 < this.a) {
                char[] cArr = this.f2758a;
                switch (cArr[i4]) {
                    case ' ':
                        int i5 = this.d;
                        this.e = i5;
                        this.b = i4 + 1;
                        this.d = i5 + 1;
                        cArr[i5] = ' ';
                        while (true) {
                            i = this.b;
                            i2 = this.a;
                            if (i < i2) {
                                char[] cArr2 = this.f2758a;
                                if (cArr2[i] == ' ') {
                                    int i6 = this.d;
                                    this.d = i6 + 1;
                                    cArr2[i6] = ' ';
                                    this.b = i + 1;
                                }
                            }
                        }
                        if (i == i2) {
                            break;
                        } else {
                            char[] cArr3 = this.f2758a;
                            if (!(cArr3[i] == ',' || cArr3[i] == '+' || cArr3[i] == ';')) {
                                break;
                            }
                        }
                    case '+':
                    case ',':
                    case ';':
                        int i7 = this.c;
                        return new String(cArr, i7, this.d - i7);
                    case '\\':
                        int i8 = this.d;
                        this.d = i8 + 1;
                        cArr[i8] = d();
                        this.b++;
                        break;
                    default:
                        int i9 = this.d;
                        this.d = i9 + 1;
                        cArr[i9] = cArr[i4];
                        this.b = i4 + 1;
                        break;
                }
            } else {
                char[] cArr4 = this.f2758a;
                int i10 = this.c;
                return new String(cArr4, i10, this.d - i10);
            }
        }
        char[] cArr5 = this.f2758a;
        int i11 = this.c;
        return new String(cArr5, i11, this.e - i11);
    }

    private char d() {
        int i = this.b + 1;
        this.b = i;
        if (i != this.a) {
            char[] cArr = this.f2758a;
            switch (cArr[i]) {
                case ' ':
                case '\"':
                case '#':
                case '%':
                case '*':
                case '+':
                case ',':
                case ';':
                case '<':
                case '=':
                case '>':
                case '\\':
                case '_':
                    return cArr[i];
                default:
                    return e();
            }
        } else {
            throw new IllegalStateException("Unexpected end of DN: " + this.f2757a);
        }
    }

    private char e() {
        int count;
        int res;
        int res2 = c(this.b);
        this.b++;
        if (res2 < 128) {
            return (char) res2;
        }
        if (res2 < 192 || res2 > 247) {
            return '?';
        }
        if (res2 <= 223) {
            count = 1;
            res = res2 & 31;
        } else if (res2 <= 239) {
            count = 2;
            res = res2 & 15;
        } else {
            count = 3;
            res = res2 & 7;
        }
        for (int i = 0; i < count; i++) {
            int i2 = this.b + 1;
            this.b = i2;
            if (i2 == this.a || this.f2758a[i2] != '\\') {
                return '?';
            }
            int i3 = i2 + 1;
            this.b = i3;
            int b2 = c(i3);
            this.b++;
            if ((b2 & 192) != 128) {
                return '?';
            }
            res = (res << 6) + (b2 & 63);
        }
        return (char) res;
    }

    private int c(int position) {
        int b1;
        int b2;
        if (position + 1 < this.a) {
            char[] cArr = this.f2758a;
            char b12 = cArr[position];
            if (b12 >= '0' && b12 <= '9') {
                b1 = b12 - '0';
            } else if (b12 >= 'a' && b12 <= 'f') {
                b1 = b12 - 'W';
            } else if (b12 < 'A' || b12 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f2757a);
            } else {
                b1 = b12 - '7';
            }
            char b22 = cArr[position + 1];
            if (b22 >= '0' && b22 <= '9') {
                b2 = b22 - '0';
            } else if (b22 >= 'a' && b22 <= 'f') {
                b2 = b22 - 'W';
            } else if (b22 < 'A' || b22 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f2757a);
            } else {
                b2 = b22 - '7';
            }
            return (b1 << 4) + b2;
        }
        throw new IllegalStateException("Malformed DN: " + this.f2757a);
    }

    public String b(String attributeType) {
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f2758a = this.f2757a.toCharArray();
        String attType = g();
        if (attType == null) {
            return null;
        }
        do {
            String attValue = "";
            int i = this.b;
            if (i == this.a) {
                return null;
            }
            switch (this.f2758a[i]) {
                case '\"':
                    attValue = h();
                    break;
                case '#':
                    attValue = f();
                    break;
                case '+':
                case ',':
                case ';':
                    break;
                default:
                    attValue = a();
                    break;
            }
            if (attributeType.equalsIgnoreCase(attType)) {
                return attValue;
            }
            int i2 = this.b;
            if (i2 >= this.a) {
                return null;
            }
            char[] cArr = this.f2758a;
            if (cArr[i2] == ',' || cArr[i2] == ';' || cArr[i2] == '+') {
                this.b = i2 + 1;
                attType = g();
            } else {
                throw new IllegalStateException("Malformed DN: " + this.f2757a);
            }
        } while (attType != null);
        throw new IllegalStateException("Malformed DN: " + this.f2757a);
    }
}
