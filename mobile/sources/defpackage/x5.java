package defpackage;

import java.io.IOException;
import java.math.RoundingMode;
import java.util.Arrays;

/* renamed from: x5  reason: default package */
public abstract class x5 {
    private static final x5 a = new c("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
    private static final x5 b = new c("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
    private static final x5 c = new e("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
    private static final x5 d = new e("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
    private static final x5 e = new b("base16()", "0123456789ABCDEF");

    /* access modifiers changed from: package-private */
    public abstract int d(byte[] bArr, CharSequence charSequence);

    /* access modifiers changed from: package-private */
    public abstract void g(Appendable appendable, byte[] bArr, int i, int i2);

    /* access modifiers changed from: package-private */
    public abstract int i(int i);

    /* access modifiers changed from: package-private */
    public abstract int j(int i);

    public abstract x5 k();

    /* access modifiers changed from: package-private */
    public abstract CharSequence l(CharSequence charSequence);

    x5() {
    }

    /* renamed from: x5$d */
    public static final class d extends IOException {
        d(String message) {
            super(message);
        }
    }

    public String e(byte[] bytes) {
        return f(bytes, 0, bytes.length);
    }

    public final String f(byte[] bytes, int off, int len) {
        v90.s(off, off + len, bytes.length);
        StringBuilder result = new StringBuilder(j(len));
        try {
            g(result, bytes, off, len);
            return result.toString();
        } catch (IOException impossible) {
            throw new AssertionError(impossible);
        }
    }

    private static byte[] h(byte[] result, int length) {
        if (length == result.length) {
            return result;
        }
        byte[] trunc = new byte[length];
        System.arraycopy(result, 0, trunc, 0, length);
        return trunc;
    }

    public final byte[] b(CharSequence chars) {
        try {
            return c(chars);
        } catch (d badInput) {
            throw new IllegalArgumentException(badInput);
        }
    }

    /* access modifiers changed from: package-private */
    public final byte[] c(CharSequence chars) {
        CharSequence chars2 = l(chars);
        byte[] tmp = new byte[i(chars2.length())];
        return h(tmp, d(tmp, chars2));
    }

    public static x5 a() {
        return a;
    }

    /* renamed from: x5$a */
    private static final class a {
        final int a;

        /* renamed from: a  reason: collision with other field name */
        private final String f5571a;

        /* renamed from: a  reason: collision with other field name */
        private final byte[] f5572a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public final char[] f5573a;

        /* renamed from: a  reason: collision with other field name */
        private final boolean[] f5574a;
        final int b;
        final int c;
        final int d;

        a(String name, char[] chars) {
            this.f5571a = (String) v90.n(name);
            this.f5573a = (char[]) v90.n(chars);
            try {
                int d2 = at.d(chars.length, RoundingMode.UNNECESSARY);
                this.b = d2;
                int gcd = Math.min(8, Integer.lowestOneBit(d2));
                try {
                    this.c = 8 / gcd;
                    this.d = d2 / gcd;
                    this.a = chars.length - 1;
                    byte[] decodabet = new byte[128];
                    Arrays.fill(decodabet, (byte) -1);
                    for (int i = 0; i < chars.length; i++) {
                        char c2 = chars[i];
                        boolean z = false;
                        v90.f(c2 < decodabet.length, "Non-ASCII character: %s", c2);
                        if (decodabet[c2] == -1) {
                            z = true;
                        }
                        v90.f(z, "Duplicate character: %s", c2);
                        decodabet[c2] = (byte) i;
                    }
                    this.f5572a = decodabet;
                    boolean[] validPadding = new boolean[this.c];
                    for (int i2 = 0; i2 < this.d; i2++) {
                        validPadding[at.a(i2 * 8, this.b, RoundingMode.CEILING)] = true;
                    }
                    this.f5574a = validPadding;
                } catch (ArithmeticException e) {
                    throw new IllegalArgumentException("Illegal alphabet " + new String(chars), e);
                }
            } catch (ArithmeticException e2) {
                throw new IllegalArgumentException("Illegal alphabet length " + chars.length, e2);
            }
        }

        /* access modifiers changed from: package-private */
        public char c(int bits) {
            return this.f5573a[bits];
        }

        /* access modifiers changed from: package-private */
        public boolean d(int index) {
            return this.f5574a[index % this.c];
        }

        /* access modifiers changed from: package-private */
        public int b(char ch) {
            if (ch <= 127) {
                byte result = this.f5572a[ch];
                if (result != -1) {
                    return result;
                }
                if (ch <= ' ' || ch == 127) {
                    throw new d("Unrecognized character: 0x" + Integer.toHexString(ch));
                }
                throw new d("Unrecognized character: " + ch);
            }
            throw new d("Unrecognized character: 0x" + Integer.toHexString(ch));
        }

        public boolean e(char c2) {
            byte[] bArr = this.f5572a;
            return c2 < bArr.length && bArr[c2] != -1;
        }

        public String toString() {
            return this.f5571a;
        }

        public boolean equals(Object other) {
            if (other instanceof a) {
                return Arrays.equals(this.f5573a, ((a) other).f5573a);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f5573a);
        }
    }

    /* renamed from: x5$e */
    static class e extends x5 {
        final Character a;

        /* renamed from: a  reason: collision with other field name */
        final a f5575a;

        e(String name, String alphabetChars, Character paddingChar) {
            this(new a(name, alphabetChars.toCharArray()), paddingChar);
        }

        e(a alphabet, Character paddingChar) {
            this.f5575a = (a) v90.n(alphabet);
            v90.j(paddingChar == null || !alphabet.e(paddingChar.charValue()), "Padding character %s was already in alphabet", paddingChar);
            this.a = paddingChar;
        }

        /* access modifiers changed from: package-private */
        public int j(int bytes) {
            a aVar = this.f5575a;
            return aVar.c * at.a(bytes, aVar.d, RoundingMode.CEILING);
        }

        /* access modifiers changed from: package-private */
        public void g(Appendable target, byte[] bytes, int off, int len) {
            v90.n(target);
            v90.s(off, off + len, bytes.length);
            int i = 0;
            while (i < len) {
                m(target, bytes, off + i, Math.min(this.f5575a.d, len - i));
                i += this.f5575a.d;
            }
        }

        /* access modifiers changed from: package-private */
        public void m(Appendable target, byte[] bytes, int off, int len) {
            v90.n(target);
            v90.s(off, off + len, bytes.length);
            v90.d(len <= this.f5575a.d);
            long bitBuffer = 0;
            for (int i = 0; i < len; i++) {
                bitBuffer = (bitBuffer | ((long) (bytes[off + i] & 255))) << 8;
            }
            int bitOffset = ((len + 1) * 8) - this.f5575a.b;
            int bitsProcessed = 0;
            while (bitsProcessed < len * 8) {
                a aVar = this.f5575a;
                target.append(aVar.c(((int) (bitBuffer >>> (bitOffset - bitsProcessed))) & aVar.a));
                bitsProcessed += this.f5575a.b;
            }
            if (this.a != null) {
                while (bitsProcessed < this.f5575a.d * 8) {
                    target.append(this.a.charValue());
                    bitsProcessed += this.f5575a.b;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int i(int chars) {
            return (int) (((((long) this.f5575a.b) * ((long) chars)) + 7) / 8);
        }

        /* access modifiers changed from: package-private */
        public CharSequence l(CharSequence chars) {
            v90.n(chars);
            Character ch = this.a;
            if (ch == null) {
                return chars;
            }
            char padChar = ch.charValue();
            int l = chars.length() - 1;
            while (l >= 0 && chars.charAt(l) == padChar) {
                l--;
            }
            return chars.subSequence(0, l + 1);
        }

        /* access modifiers changed from: package-private */
        public int d(byte[] target, CharSequence chars) {
            a aVar;
            v90.n(target);
            CharSequence chars2 = l(chars);
            if (this.f5575a.d(chars2.length())) {
                int bytesWritten = 0;
                int charIdx = 0;
                while (charIdx < chars2.length()) {
                    long chunk = 0;
                    int charsProcessed = 0;
                    int i = 0;
                    while (true) {
                        aVar = this.f5575a;
                        if (i >= aVar.c) {
                            break;
                        }
                        chunk <<= aVar.b;
                        if (charIdx + i < chars2.length()) {
                            chunk |= (long) this.f5575a.b(chars2.charAt(charsProcessed + charIdx));
                            charsProcessed++;
                        }
                        i++;
                    }
                    int i2 = aVar.d;
                    int minOffset = (i2 * 8) - (aVar.b * charsProcessed);
                    int offset = (i2 - 1) * 8;
                    while (offset >= minOffset) {
                        target[bytesWritten] = (byte) ((int) ((chunk >>> offset) & 255));
                        offset -= 8;
                        bytesWritten++;
                    }
                    charIdx += this.f5575a.c;
                }
                return bytesWritten;
            }
            throw new d("Invalid input length " + chars2.length());
        }

        public x5 k() {
            return this.a == null ? this : n(this.f5575a, (Character) null);
        }

        /* access modifiers changed from: package-private */
        public x5 n(a alphabet, Character paddingChar) {
            return new e(alphabet, paddingChar);
        }

        public String toString() {
            StringBuilder builder = new StringBuilder("BaseEncoding.");
            builder.append(this.f5575a.toString());
            if (8 % this.f5575a.b != 0) {
                if (this.a == null) {
                    builder.append(".omitPadding()");
                } else {
                    builder.append(".withPadChar('");
                    builder.append(this.a);
                    builder.append("')");
                }
            }
            return builder.toString();
        }

        public boolean equals(Object other) {
            if (!(other instanceof e)) {
                return false;
            }
            e that = (e) other;
            if (!this.f5575a.equals(that.f5575a) || !f40.a(this.a, that.a)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f5575a.hashCode() ^ f40.b(this.a);
        }
    }

    /* renamed from: x5$b */
    static final class b extends e {
        final char[] a;

        b(String name, String alphabetChars) {
            this(new a(name, alphabetChars.toCharArray()));
        }

        private b(a alphabet) {
            super(alphabet, (Character) null);
            this.a = new char[512];
            v90.d(alphabet.f5573a.length == 16);
            for (int i = 0; i < 256; i++) {
                this.a[i] = alphabet.c(i >>> 4);
                this.a[i | 256] = alphabet.c(i & 15);
            }
        }

        /* access modifiers changed from: package-private */
        public void g(Appendable target, byte[] bytes, int off, int len) {
            v90.n(target);
            v90.s(off, off + len, bytes.length);
            for (int i = 0; i < len; i++) {
                int b = bytes[off + i] & 255;
                target.append(this.a[b]);
                target.append(this.a[b | 256]);
            }
        }

        /* access modifiers changed from: package-private */
        public int d(byte[] target, CharSequence chars) {
            v90.n(target);
            if (chars.length() % 2 != 1) {
                int bytesWritten = 0;
                int i = 0;
                while (i < chars.length()) {
                    target[bytesWritten] = (byte) ((this.f5575a.b(chars.charAt(i)) << 4) | this.f5575a.b(chars.charAt(i + 1)));
                    i += 2;
                    bytesWritten++;
                }
                return bytesWritten;
            }
            throw new d("Invalid input length " + chars.length());
        }

        /* access modifiers changed from: package-private */
        public x5 n(a alphabet, Character paddingChar) {
            return new b(alphabet);
        }
    }

    /* renamed from: x5$c */
    static final class c extends e {
        c(String name, String alphabetChars, Character paddingChar) {
            this(new a(name, alphabetChars.toCharArray()), paddingChar);
        }

        private c(a alphabet, Character paddingChar) {
            super(alphabet, paddingChar);
            v90.d(alphabet.f5573a.length == 64);
        }

        /* access modifiers changed from: package-private */
        public void g(Appendable target, byte[] bytes, int off, int len) {
            v90.n(target);
            v90.s(off, off + len, bytes.length);
            int i = off;
            int remaining = len;
            while (remaining >= 3) {
                int i2 = i + 1;
                int i3 = i2 + 1;
                int chunk = ((bytes[i] & 255) << 16) | ((bytes[i2] & 255) << 8) | (bytes[i3] & 255);
                target.append(this.f5575a.c(chunk >>> 18));
                target.append(this.f5575a.c((chunk >>> 12) & 63));
                target.append(this.f5575a.c((chunk >>> 6) & 63));
                target.append(this.f5575a.c(chunk & 63));
                remaining -= 3;
                i = i3 + 1;
            }
            if (i < off + len) {
                m(target, bytes, i, (off + len) - i);
            }
        }

        /* access modifiers changed from: package-private */
        public int d(byte[] target, CharSequence chars) {
            v90.n(target);
            CharSequence chars2 = l(chars);
            if (this.f5575a.d(chars2.length())) {
                int chunk = 0;
                int i = 0;
                while (i < chars2.length()) {
                    int i2 = i + 1;
                    int i3 = i2 + 1;
                    int chunk2 = (this.f5575a.b(chars2.charAt(i)) << 18) | (this.f5575a.b(chars2.charAt(i2)) << 12);
                    int bytesWritten = chunk + 1;
                    target[chunk] = (byte) (chunk2 >>> 16);
                    if (i3 < chars2.length()) {
                        int i4 = i3 + 1;
                        int chunk3 = (this.f5575a.b(chars2.charAt(i3)) << 6) | chunk2;
                        int chunk4 = bytesWritten + 1;
                        target[bytesWritten] = (byte) ((chunk3 >>> 8) & 255);
                        if (i4 < chars2.length()) {
                            target[chunk4] = (byte) ((chunk3 | this.f5575a.b(chars2.charAt(i4))) & 255);
                            chunk = chunk4 + 1;
                            i = i4 + 1;
                        } else {
                            chunk = chunk4;
                            i = i4;
                        }
                    } else {
                        chunk = bytesWritten;
                        i = i3;
                    }
                }
                return chunk;
            }
            throw new d("Invalid input length " + chars2.length());
        }

        /* access modifiers changed from: package-private */
        public x5 n(a alphabet, Character paddingChar) {
            return new c(alphabet, paddingChar);
        }
    }
}
