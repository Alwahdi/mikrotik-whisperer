package com.google.protobuf;

abstract class y {
    private static final a a = (d.d() ? new d() : new b());

    public static boolean l(byte[] bytes, int index, int limit) {
        return a.b(bytes, index, limit);
    }

    /* access modifiers changed from: private */
    public static int h(int byte1) {
        if (byte1 > -12) {
            return -1;
        }
        return byte1;
    }

    /* access modifiers changed from: private */
    public static int i(int byte1, int byte2) {
        if (byte1 > -12 || byte2 > -65) {
            return -1;
        }
        return (byte2 << 8) ^ byte1;
    }

    /* access modifiers changed from: private */
    public static int j(int byte1, int byte2, int byte3) {
        if (byte1 > -12 || byte2 > -65 || byte3 > -65) {
            return -1;
        }
        return ((byte2 << 8) ^ byte1) ^ (byte3 << 16);
    }

    /* access modifiers changed from: private */
    public static int k(byte[] bytes, int index, int limit) {
        byte byte1 = bytes[index - 1];
        switch (limit - index) {
            case 0:
                return h(byte1);
            case 1:
                return i(byte1, bytes[index]);
            case 2:
                return j(byte1, bytes[index], bytes[index + 1]);
            default:
                throw new AssertionError();
        }
    }

    static class c extends IllegalArgumentException {
        c(int index, int length) {
            super("Unpaired surrogate at index " + index + " of " + length);
        }
    }

    static int f(CharSequence sequence) {
        int utf16Length = sequence.length();
        int utf8Length = utf16Length;
        int i = 0;
        while (i < utf16Length && sequence.charAt(i) < 128) {
            i++;
        }
        while (true) {
            if (i < utf16Length) {
                char c2 = sequence.charAt(i);
                if (c2 >= 2048) {
                    utf8Length += g(sequence, i);
                    break;
                }
                utf8Length += (127 - c2) >>> 31;
                i++;
            } else {
                break;
            }
        }
        if (utf8Length >= utf16Length) {
            return utf8Length;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) utf8Length) + 4294967296L));
    }

    private static int g(CharSequence sequence, int start) {
        int utf16Length = sequence.length();
        int utf8Length = 0;
        int i = start;
        while (i < utf16Length) {
            char c2 = sequence.charAt(i);
            if (c2 < 2048) {
                utf8Length += (127 - c2) >>> 31;
            } else {
                utf8Length += 2;
                if (55296 <= c2 && c2 <= 57343) {
                    if (Character.codePointAt(sequence, i) >= 65536) {
                        i++;
                    } else {
                        throw new c(i, utf16Length);
                    }
                }
            }
            i++;
        }
        return utf8Length;
    }

    static int e(CharSequence in, byte[] out, int offset, int length) {
        return a.a(in, out, offset, length);
    }

    static abstract class a {
        /* access modifiers changed from: package-private */
        public abstract int a(CharSequence charSequence, byte[] bArr, int i, int i2);

        /* access modifiers changed from: package-private */
        public abstract int c(int i, byte[] bArr, int i2, int i3);

        a() {
        }

        /* access modifiers changed from: package-private */
        public final boolean b(byte[] bytes, int index, int limit) {
            return c(0, bytes, index, limit) == 0;
        }
    }

    static final class b extends a {
        b() {
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r1v5, types: [byte, int] */
        /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r4v10, types: [byte, int] */
        /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r4v4, types: [byte, int] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int c(int r8, byte[] r9, int r10, int r11) {
            /*
                r7 = this;
                if (r8 == 0) goto L_0x0089
                if (r10 < r11) goto L_0x0005
                return r8
            L_0x0005:
                byte r0 = (byte) r8
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L_0x001d
                r1 = -62
                if (r0 < r1) goto L_0x001c
                int r1 = r10 + 1
                byte r10 = r9[r10]
                if (r10 <= r3) goto L_0x0019
                r10 = r1
                goto L_0x001c
            L_0x0019:
                r10 = r1
                goto L_0x0089
            L_0x001c:
                return r2
            L_0x001d:
                r4 = -16
                if (r0 >= r4) goto L_0x004c
                int r4 = r8 >> 8
                int r4 = ~r4
                byte r4 = (byte) r4
                if (r4 != 0) goto L_0x0033
                int r5 = r10 + 1
                byte r4 = r9[r10]
                if (r5 < r11) goto L_0x0032
                int r10 = com.google.protobuf.y.i(r0, r4)
                return r10
            L_0x0032:
                r10 = r5
            L_0x0033:
                if (r4 > r3) goto L_0x004b
                r5 = -96
                if (r0 != r1) goto L_0x003b
                if (r4 < r5) goto L_0x004b
            L_0x003b:
                r1 = -19
                if (r0 != r1) goto L_0x0041
                if (r4 >= r5) goto L_0x004b
            L_0x0041:
                int r1 = r10 + 1
                byte r10 = r9[r10]
                if (r10 <= r3) goto L_0x0049
                r10 = r1
                goto L_0x004b
            L_0x0049:
                r10 = r1
                goto L_0x0089
            L_0x004b:
                return r2
            L_0x004c:
                int r1 = r8 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                r4 = 0
                if (r1 != 0) goto L_0x0060
                int r5 = r10 + 1
                byte r1 = r9[r10]
                if (r5 < r11) goto L_0x005e
                int r10 = com.google.protobuf.y.i(r0, r1)
                return r10
            L_0x005e:
                r10 = r5
                goto L_0x0063
            L_0x0060:
                int r5 = r8 >> 16
                byte r4 = (byte) r5
            L_0x0063:
                if (r4 != 0) goto L_0x0071
                int r5 = r10 + 1
                byte r4 = r9[r10]
                if (r5 < r11) goto L_0x0070
                int r10 = com.google.protobuf.y.j(r0, r1, r4)
                return r10
            L_0x0070:
                r10 = r5
            L_0x0071:
                if (r1 > r3) goto L_0x0088
                int r5 = r0 << 28
                int r6 = r1 + 112
                int r5 = r5 + r6
                int r5 = r5 >> 30
                if (r5 != 0) goto L_0x0088
                if (r4 > r3) goto L_0x0088
                int r5 = r10 + 1
                byte r10 = r9[r10]
                if (r10 <= r3) goto L_0x0086
                r10 = r5
                goto L_0x0088
            L_0x0086:
                r10 = r5
                goto L_0x0089
            L_0x0088:
                return r2
            L_0x0089:
                int r0 = d(r9, r10, r11)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.y.b.c(int, byte[], int, int):int");
        }

        /* access modifiers changed from: package-private */
        public int a(CharSequence in, byte[] out, int offset, int length) {
            int utf16Length = in.length();
            int j = offset;
            int i = 0;
            int limit = offset + length;
            while (i < utf16Length && i + j < limit) {
                char charAt = in.charAt(i);
                char c = charAt;
                if (charAt >= 128) {
                    break;
                }
                out[j + i] = (byte) c;
                i++;
            }
            if (i == utf16Length) {
                return j + utf16Length;
            }
            int j2 = j + i;
            while (i < utf16Length) {
                char c2 = in.charAt(i);
                if (c2 < 128 && j2 < limit) {
                    out[j2] = (byte) c2;
                    j2++;
                } else if (c2 < 2048 && j2 <= limit - 2) {
                    int j3 = j2 + 1;
                    out[j2] = (byte) ((c2 >>> 6) | 960);
                    j2 = j3 + 1;
                    out[j3] = (byte) ((c2 & '?') | 128);
                } else if ((c2 < 55296 || 57343 < c2) && j2 <= limit - 3) {
                    int j4 = j2 + 1;
                    out[j2] = (byte) ((c2 >>> 12) | 480);
                    int j5 = j4 + 1;
                    out[j4] = (byte) (((c2 >>> 6) & 63) | 128);
                    out[j5] = (byte) ((c2 & '?') | 128);
                    j2 = j5 + 1;
                } else if (j2 <= limit - 4) {
                    if (i + 1 != in.length()) {
                        i++;
                        char charAt2 = in.charAt(i);
                        char low = charAt2;
                        if (Character.isSurrogatePair(c2, charAt2)) {
                            int codePoint = Character.toCodePoint(c2, low);
                            int j6 = j2 + 1;
                            out[j2] = (byte) ((codePoint >>> 18) | 240);
                            int j7 = j6 + 1;
                            out[j6] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int j8 = j7 + 1;
                            out[j7] = (byte) (((codePoint >>> 6) & 63) | 128);
                            j2 = j8 + 1;
                            out[j8] = (byte) ((codePoint & 63) | 128);
                        }
                    }
                    throw new c(i - 1, utf16Length);
                } else if (55296 > c2 || c2 > 57343 || (i + 1 != in.length() && Character.isSurrogatePair(c2, in.charAt(i + 1)))) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + c2 + " at index " + j2);
                } else {
                    throw new c(i, utf16Length);
                }
                i++;
            }
            return j2;
        }

        private static int d(byte[] bytes, int index, int limit) {
            while (index < limit && bytes[index] >= 0) {
                index++;
            }
            if (index >= limit) {
                return 0;
            }
            return e(bytes, index, limit);
        }

        private static int e(byte[] bytes, int index, int limit) {
            while (index < limit) {
                int index2 = index + 1;
                byte index3 = bytes[index];
                int byte1 = index3;
                if (index3 >= 0) {
                    index = index2;
                } else if (byte1 < -32) {
                    if (index2 >= limit) {
                        return byte1;
                    }
                    if (byte1 >= -62) {
                        index = index2 + 1;
                        if (bytes[index2] > -65) {
                            int i = index;
                        }
                    }
                    return -1;
                } else if (byte1 < -16) {
                    if (index2 >= limit - 1) {
                        return y.k(bytes, index2, limit);
                    }
                    int index4 = index2 + 1;
                    byte index5 = bytes[index2];
                    int byte2 = index5;
                    if (index5 <= -65 && ((byte1 != -32 || byte2 >= -96) && (byte1 != -19 || byte2 < -96))) {
                        index = index4 + 1;
                        if (bytes[index4] > -65) {
                            int i2 = index;
                        }
                    }
                    return -1;
                } else if (index2 >= limit - 2) {
                    return y.k(bytes, index2, limit);
                } else {
                    int index6 = index2 + 1;
                    byte index7 = bytes[index2];
                    int byte22 = index7;
                    if (index7 <= -65 && (((byte1 << 28) + (byte22 + 112)) >> 30) == 0) {
                        int index8 = index6 + 1;
                        if (bytes[index6] <= -65) {
                            index = index8 + 1;
                            if (bytes[index8] > -65) {
                            }
                        }
                    }
                    return -1;
                }
            }
            return 0;
        }
    }

    static final class d extends a {
        d() {
        }

        static boolean d() {
            return x.h() && x.i();
        }

        /* access modifiers changed from: package-private */
        public int c(int state, byte[] bytes, int index, int limit) {
            int i = state;
            byte[] bArr = bytes;
            int i2 = index;
            int i3 = limit;
            if ((i2 | i3 | (bArr.length - i3)) >= 0) {
                long offset = x.d() + ((long) i2);
                long offsetLimit = x.d() + ((long) i3);
                if (i != 0) {
                    if (offset >= offsetLimit) {
                        return i;
                    }
                    int byte1 = (byte) i;
                    if (byte1 < -32) {
                        if (byte1 >= -62) {
                            long offset2 = 1 + offset;
                            if (x.e(bArr, offset) > -65) {
                                long j = offset2;
                            } else {
                                offset = offset2;
                            }
                        }
                        return -1;
                    } else if (byte1 < -16) {
                        int byte2 = (byte) (~(i >> 8));
                        if (byte2 == 0) {
                            long offset3 = offset + 1;
                            byte2 = x.e(bArr, offset);
                            if (offset3 >= offsetLimit) {
                                return y.i(byte1, byte2);
                            }
                            offset = offset3;
                        }
                        if (byte2 <= -65 && ((byte1 != -32 || byte2 >= -96) && (byte1 != -19 || byte2 < -96))) {
                            long offset4 = 1 + offset;
                            if (x.e(bArr, offset) > -65) {
                                long j2 = offset4;
                            } else {
                                offset = offset4;
                            }
                        }
                        return -1;
                    } else {
                        int byte22 = (byte) (~(i >> 8));
                        int byte3 = 0;
                        if (byte22 == 0) {
                            long offset5 = offset + 1;
                            byte22 = x.e(bArr, offset);
                            if (offset5 >= offsetLimit) {
                                return y.i(byte1, byte22);
                            }
                            offset = offset5;
                        } else {
                            byte3 = (byte) (i >> 16);
                        }
                        if (byte3 == 0) {
                            long offset6 = offset + 1;
                            byte3 = x.e(bArr, offset);
                            if (offset6 >= offsetLimit) {
                                return y.j(byte1, byte22, byte3);
                            }
                            offset = offset6;
                        }
                        if (byte22 <= -65 && (((byte1 << 28) + (byte22 + 112)) >> 30) == 0 && byte3 <= -65) {
                            long offset7 = 1 + offset;
                            if (x.e(bArr, offset) > -65) {
                                long j3 = offset7;
                            } else {
                                offset = offset7;
                            }
                        }
                        return -1;
                    }
                }
                return e(bArr, offset, (int) (offsetLimit - offset));
            }
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(index), Integer.valueOf(limit)}));
        }

        /* access modifiers changed from: package-private */
        public int a(CharSequence in, byte[] out, int offset, int length) {
            long outIx;
            char c;
            long j;
            long outIx2;
            CharSequence charSequence = in;
            byte[] bArr = out;
            int i = offset;
            int i2 = length;
            long outIx3 = x.d() + ((long) i);
            long outLimit = ((long) i2) + outIx3;
            int inLimit = in.length();
            if (inLimit > i2 || bArr.length - i2 < i) {
                long j2 = outLimit;
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(inLimit - 1) + " at index " + (offset + length));
            }
            int inIx = 0;
            while (true) {
                c = 128;
                j = 1;
                if (inIx >= inLimit) {
                    break;
                }
                char charAt = charSequence.charAt(inIx);
                char c2 = charAt;
                if (charAt >= 128) {
                    break;
                }
                x.j(bArr, outIx, (byte) c2);
                inIx++;
                outIx3 = outIx + 1;
            }
            if (inIx == inLimit) {
                return (int) (outIx - x.d());
            }
            while (inIx < inLimit) {
                char c3 = charSequence.charAt(inIx);
                if (c3 < c && outIx < outLimit) {
                    x.j(bArr, outIx, (byte) c3);
                    outIx += j;
                    c = 128;
                    outIx2 = outLimit;
                } else if (c3 < 2048 && outIx <= outLimit - 2) {
                    long outIx4 = outIx + j;
                    x.j(bArr, outIx, (byte) ((c3 >>> 6) | 960));
                    outIx = outIx4 + j;
                    x.j(bArr, outIx4, (byte) ((c3 & '?') | 128));
                    outIx2 = outLimit;
                    c = 128;
                } else if ((c3 < 55296 || 57343 < c3) && outIx <= outLimit - 3) {
                    long outIx5 = outIx + 1;
                    x.j(bArr, outIx, (byte) ((c3 >>> 12) | 480));
                    long outIx6 = outIx5 + 1;
                    x.j(bArr, outIx5, (byte) (((c3 >>> 6) & 63) | 128));
                    x.j(bArr, outIx6, (byte) ((c3 & '?') | 128));
                    outIx2 = outLimit;
                    outIx = outIx6 + 1;
                    c = 128;
                } else if (outIx <= outLimit - 4) {
                    if (inIx + 1 != inLimit) {
                        inIx++;
                        char charAt2 = charSequence.charAt(inIx);
                        char low = charAt2;
                        if (Character.isSurrogatePair(c3, charAt2)) {
                            int codePoint = Character.toCodePoint(c3, low);
                            outIx2 = outLimit;
                            long outIx7 = outIx + 1;
                            x.j(bArr, outIx, (byte) ((codePoint >>> 18) | 240));
                            long outIx8 = outIx7 + 1;
                            c = 128;
                            x.j(bArr, outIx7, (byte) (((codePoint >>> 12) & 63) | 128));
                            long outIx9 = outIx8 + 1;
                            x.j(bArr, outIx8, (byte) (((codePoint >>> 6) & 63) | 128));
                            outIx = outIx9 + 1;
                            x.j(bArr, outIx9, (byte) ((codePoint & 63) | 128));
                        }
                    }
                    throw new c(inIx - 1, inLimit);
                } else {
                    if (55296 > c3 || c3 > 57343 || (inIx + 1 != inLimit && Character.isSurrogatePair(c3, charSequence.charAt(inIx + 1)))) {
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + c3 + " at index " + outIx);
                    }
                    throw new c(inIx, inLimit);
                }
                inIx++;
                int i3 = offset;
                int i4 = length;
                outLimit = outIx2;
                j = 1;
            }
            return (int) (outIx - x.d());
        }

        private static int f(byte[] bytes, long offset, int maxChars) {
            int remaining = maxChars;
            if (remaining < 16) {
                return 0;
            }
            int unaligned = ((int) offset) & 7;
            int j = unaligned;
            while (j > 0) {
                long offset2 = 1 + offset;
                if (x.e(bytes, offset) < 0) {
                    return unaligned - j;
                }
                j--;
                offset = offset2;
            }
            int remaining2 = remaining - unaligned;
            while (remaining2 >= 8 && (x.f(bytes, offset) & -9187201950435737472L) == 0) {
                offset += 8;
                remaining2 -= 8;
            }
            return maxChars - remaining2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x006a, code lost:
            return -1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int e(byte[] r11, long r12, int r14) {
            /*
                int r0 = f(r11, r12, r14)
                int r14 = r14 - r0
                long r1 = (long) r0
                long r12 = r12 + r1
            L_0x0007:
                r1 = 0
            L_0x0008:
                r2 = 1
                if (r14 <= 0) goto L_0x001a
                long r4 = r12 + r2
                byte r12 = com.google.protobuf.x.e(r11, r12)
                r1 = r12
                if (r12 < 0) goto L_0x0019
                int r14 = r14 + -1
                r12 = r4
                goto L_0x0008
            L_0x0019:
                r12 = r4
            L_0x001a:
                if (r14 != 0) goto L_0x001e
                r2 = 0
                return r2
            L_0x001e:
                int r14 = r14 + -1
                r4 = -32
                r5 = -65
                r6 = -1
                if (r1 >= r4) goto L_0x003c
                if (r14 != 0) goto L_0x002a
                return r1
            L_0x002a:
                int r14 = r14 + -1
                r4 = -62
                if (r1 < r4) goto L_0x003b
                long r2 = r2 + r12
                byte r12 = com.google.protobuf.x.e(r11, r12)
                if (r12 <= r5) goto L_0x0039
                r12 = r2
                goto L_0x003b
            L_0x0039:
                r12 = r2
                goto L_0x0099
            L_0x003b:
                return r6
            L_0x003c:
                r7 = -16
                if (r1 >= r7) goto L_0x006b
                r7 = 2
                if (r14 >= r7) goto L_0x0048
                int r2 = g(r11, r1, r12, r14)
                return r2
            L_0x0048:
                int r14 = r14 + -2
                long r7 = r12 + r2
                byte r12 = com.google.protobuf.x.e(r11, r12)
                r13 = r12
                if (r12 > r5) goto L_0x006a
                r12 = -96
                if (r1 != r4) goto L_0x0059
                if (r13 < r12) goto L_0x006a
            L_0x0059:
                r4 = -19
                if (r1 != r4) goto L_0x005f
                if (r13 >= r12) goto L_0x006a
            L_0x005f:
                long r2 = r2 + r7
                byte r12 = com.google.protobuf.x.e(r11, r7)
                if (r12 <= r5) goto L_0x0068
                r7 = r2
                goto L_0x006a
            L_0x0068:
                r12 = r2
                goto L_0x0099
            L_0x006a:
                return r6
            L_0x006b:
                r4 = 3
                if (r14 >= r4) goto L_0x0073
                int r2 = g(r11, r1, r12, r14)
                return r2
            L_0x0073:
                int r14 = r14 + -3
                long r7 = r12 + r2
                byte r12 = com.google.protobuf.x.e(r11, r12)
                r13 = r12
                if (r12 > r5) goto L_0x009c
                int r12 = r1 << 28
                int r4 = r13 + 112
                int r12 = r12 + r4
                int r12 = r12 >> 30
                if (r12 != 0) goto L_0x009c
                long r9 = r7 + r2
                byte r12 = com.google.protobuf.x.e(r11, r7)
                if (r12 > r5) goto L_0x009b
                long r7 = r9 + r2
                byte r12 = com.google.protobuf.x.e(r11, r9)
                if (r12 <= r5) goto L_0x0098
                goto L_0x009c
            L_0x0098:
                r12 = r7
            L_0x0099:
                goto L_0x0007
            L_0x009b:
                r7 = r9
            L_0x009c:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.y.d.e(byte[], long, int):int");
        }

        private static int g(byte[] bytes, int byte1, long offset, int remaining) {
            switch (remaining) {
                case 0:
                    return y.h(byte1);
                case 1:
                    return y.i(byte1, x.e(bytes, offset));
                case 2:
                    return y.j(byte1, x.e(bytes, offset), x.e(bytes, 1 + offset));
                default:
                    throw new AssertionError();
            }
        }
    }
}
