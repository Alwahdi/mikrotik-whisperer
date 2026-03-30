package defpackage;

import java.io.Serializable;

/* renamed from: ep0  reason: default package */
public class ep0 implements Comparable<ep0>, Serializable {
    int a;

    /* renamed from: a  reason: collision with other field name */
    Object f2923a;
    int b;
    int c;

    public ep0(int tag, int type, int count, Object data) {
        this.a = tag;
        this.b = type;
        this.c = count;
        this.f2923a = data;
    }

    public int j() {
        return this.a;
    }

    public int k() {
        return this.b;
    }

    public byte[] b() {
        return (byte[]) this.f2923a;
    }

    public char[] c() {
        return (char[]) this.f2923a;
    }

    public long[] h() {
        return (long[]) this.f2923a;
    }

    public int d(int index) {
        switch (this.b) {
            case 1:
            case 7:
                return ((byte[]) this.f2923a)[index] & 255;
            case 3:
                return ((char[]) this.f2923a)[index] & 65535;
            case 6:
                return ((byte[]) this.f2923a)[index];
            case 8:
                return ((short[]) this.f2923a)[index];
            case 9:
                return ((int[]) this.f2923a)[index];
            default:
                throw new ClassCastException();
        }
    }

    public long e(int index) {
        switch (this.b) {
            case 1:
            case 7:
                return (long) (((byte[]) this.f2923a)[index] & 255);
            case 3:
                return (long) (((char[]) this.f2923a)[index] & 65535);
            case 4:
                return ((long[]) this.f2923a)[index];
            case 6:
                return (long) ((byte[]) this.f2923a)[index];
            case 8:
                return (long) ((short[]) this.f2923a)[index];
            case 9:
                return (long) ((int[]) this.f2923a)[index];
            default:
                throw new ClassCastException();
        }
    }

    public long[] i(int index) {
        if (this.b == 4) {
            return h();
        }
        return ((long[][]) this.f2923a)[index];
    }

    /* renamed from: a */
    public int compareTo(ep0 o) {
        if (o != null) {
            int oTag = o.j();
            int i = this.a;
            if (i < oTag) {
                return -1;
            }
            if (i > oTag) {
                return 1;
            }
            return 0;
        }
        throw new IllegalArgumentException();
    }
}
