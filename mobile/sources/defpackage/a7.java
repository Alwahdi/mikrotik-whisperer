package defpackage;

import java.io.Serializable;
import java.util.Arrays;

/* renamed from: a7  reason: default package */
public class a7 implements Serializable, Comparable<a7> {
    public static final a7 a = i(new byte[0]);

    /* renamed from: a  reason: collision with other field name */
    static final char[] f25a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: a  reason: collision with other field name */
    transient int f26a;

    /* renamed from: a  reason: collision with other field name */
    transient String f27a;

    /* renamed from: a  reason: collision with other field name */
    final byte[] f28a;

    a7(byte[] data) {
        this.f28a = data;
    }

    public static a7 i(byte... data) {
        if (data != null) {
            return new a7((byte[]) data.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static a7 d(String s) {
        if (s != null) {
            a7 byteString = new a7(s.getBytes(su0.a));
            byteString.f27a = s;
            return byteString;
        }
        throw new IllegalArgumentException("s == null");
    }

    public String s() {
        String result = this.f27a;
        if (result != null) {
            return result;
        }
        String str = new String(this.f28a, su0.a);
        this.f27a = str;
        return str;
    }

    public String a() {
        return t5.a(this.f28a);
    }

    public String h() {
        byte[] bArr = this.f28a;
        char[] result = new char[(bArr.length * 2)];
        int c = 0;
        for (byte b : bArr) {
            int c2 = c + 1;
            char[] cArr = f25a;
            result[c] = cArr[(b >> 4) & 15];
            c = c2 + 1;
            result[c2] = cArr[b & 15];
        }
        return new String(result);
    }

    public a7 q() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f28a;
            if (i >= bArr.length) {
                return this;
            }
            byte c = bArr[i];
            if (c < 65 || c > 90) {
                i++;
            } else {
                byte[] lowercase = (byte[]) bArr.clone();
                lowercase[i] = (byte) (c + 32);
                for (int i2 = i + 1; i2 < lowercase.length; i2++) {
                    byte c2 = lowercase[i2];
                    if (c2 >= 65 && c2 <= 90) {
                        lowercase[i2] = (byte) (c2 + 32);
                    }
                }
                return new a7(lowercase);
            }
        }
    }

    public a7 p(int beginIndex, int endIndex) {
        if (beginIndex >= 0) {
            byte[] bArr = this.f28a;
            if (endIndex <= bArr.length) {
                int subLen = endIndex - beginIndex;
                if (subLen < 0) {
                    throw new IllegalArgumentException("endIndex < beginIndex");
                } else if (beginIndex == 0 && endIndex == bArr.length) {
                    return this;
                } else {
                    byte[] copy = new byte[subLen];
                    System.arraycopy(bArr, beginIndex, copy, 0, subLen);
                    return new a7(copy);
                }
            } else {
                throw new IllegalArgumentException("endIndex > length(" + this.f28a.length + ")");
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0");
        }
    }

    public byte e(int pos) {
        return this.f28a[pos];
    }

    public int l() {
        return this.f28a.length;
    }

    public byte[] r() {
        return (byte[]) this.f28a.clone();
    }

    /* access modifiers changed from: package-private */
    public void t(r6 buffer) {
        byte[] bArr = this.f28a;
        buffer.m0(bArr, 0, bArr.length);
    }

    public boolean j(int offset, a7 other, int otherOffset, int byteCount) {
        return other.k(otherOffset, this.f28a, offset, byteCount);
    }

    public boolean k(int offset, byte[] other, int otherOffset, int byteCount) {
        if (offset >= 0) {
            byte[] bArr = this.f28a;
            return offset <= bArr.length - byteCount && otherOffset >= 0 && otherOffset <= other.length - byteCount && su0.a(bArr, offset, other, otherOffset, byteCount);
        }
    }

    public final boolean o(a7 prefix) {
        return j(0, prefix, 0, prefix.l());
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof a7) {
            int l = ((a7) o).l();
            byte[] bArr = this.f28a;
            if (l != bArr.length || !((a7) o).k(0, bArr, 0, bArr.length)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = this.f26a;
        if (result != 0) {
            return result;
        }
        int hashCode = Arrays.hashCode(this.f28a);
        this.f26a = hashCode;
        return hashCode;
    }

    /* renamed from: c */
    public int compareTo(a7 byteString) {
        int sizeA = l();
        int sizeB = byteString.l();
        int i = 0;
        int size = Math.min(sizeA, sizeB);
        while (i < size) {
            int byteA = e(i) & 255;
            int byteB = byteString.e(i) & 255;
            if (byteA == byteB) {
                i++;
            } else if (byteA < byteB) {
                return -1;
            } else {
                return 1;
            }
        }
        if (sizeA == sizeB) {
            return 0;
        }
        if (sizeA < sizeB) {
            return -1;
        }
        return 1;
    }

    public String toString() {
        if (this.f28a.length == 0) {
            return "[size=0]";
        }
        String text = s();
        int i = b(text, 64);
        if (i != -1) {
            String safeText = text.substring(0, i).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            if (i < text.length()) {
                return "[size=" + this.f28a.length + " text=" + safeText + "…]";
            }
            return "[text=" + safeText + "]";
        } else if (this.f28a.length <= 64) {
            return "[hex=" + h() + "]";
        } else {
            return "[size=" + this.f28a.length + " hex=" + p(0, 64).h() + "…]";
        }
    }

    static int b(String s, int codePointCount) {
        int i = 0;
        int j = 0;
        int length = s.length();
        while (i < length) {
            if (j == codePointCount) {
                return i;
            }
            int c = s.codePointAt(i);
            if ((Character.isISOControl(c) && c != 10 && c != 13) || c == 65533) {
                return -1;
            }
            j++;
            i += Character.charCount(c);
        }
        return s.length();
    }
}
