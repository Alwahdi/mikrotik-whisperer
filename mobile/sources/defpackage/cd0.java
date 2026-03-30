package defpackage;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;

/* renamed from: cd0  reason: default package */
public class cd0 implements DataInput {
    private byte a;

    /* renamed from: a  reason: collision with other field name */
    private long f329a;

    /* renamed from: a  reason: collision with other field name */
    private final dd0 f330a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f331a;

    public cd0(cd0 source) {
        this((dd0) new is(source.f330a));
    }

    public cd0(dd0 byteSource) {
        this.f331a = false;
        this.f330a = byteSource;
    }

    public cd0(String filename, boolean forceRead, boolean plainRandomAccess) {
        this(new ed0().i(forceRead).j(plainRandomAccess).b(filename));
    }

    public cd0(byte[] arrayIn) {
        this(new ed0().h(arrayIn));
    }

    public void c(byte b) {
        this.a = b;
        this.f331a = true;
    }

    public int read() {
        if (this.f331a) {
            this.f331a = false;
            return this.a & 255;
        }
        dd0 dd0 = this.f330a;
        long j = this.f329a;
        this.f329a = 1 + j;
        return dd0.a(j);
    }

    public int read(byte[] b, int off, int len) {
        int byteSourceCount;
        if (len == 0) {
            return 0;
        }
        int count = 0;
        if (this.f331a && len > 0) {
            this.f331a = false;
            b[off] = this.a;
            len--;
            count = 0 + 1;
            off++;
        }
        if (len > 0 && (byteSourceCount = this.f330a.c(this.f329a, b, off, len)) > 0) {
            count += byteSourceCount;
            this.f329a += (long) byteSourceCount;
        }
        if (count == 0) {
            return -1;
        }
        return count;
    }

    public int read(byte[] b) {
        return read(b, 0, b.length);
    }

    public void readFully(byte[] b) {
        readFully(b, 0, b.length);
    }

    public void readFully(byte[] b, int off, int len) {
        int n = 0;
        do {
            int count = read(b, off + n, len - n);
            if (count >= 0) {
                n += count;
            } else {
                throw new EOFException();
            }
        } while (n < len);
    }

    public long skip(long n) {
        if (n <= 0) {
            return 0;
        }
        int adj = 0;
        if (this.f331a) {
            this.f331a = false;
            if (n == 1) {
                return 1;
            }
            n--;
            adj = 1;
        }
        long pos = a();
        long len = b();
        long newpos = pos + n;
        if (newpos > len) {
            newpos = len;
        }
        n(newpos);
        return (newpos - pos) + ((long) adj);
    }

    public int skipBytes(int n) {
        return (int) skip((long) n);
    }

    public void d() {
        n(0);
    }

    public void close() {
        this.f331a = false;
        this.f330a.close();
    }

    public long b() {
        return this.f330a.b();
    }

    public void n(long pos) {
        this.f329a = pos;
        this.f331a = false;
    }

    public long a() {
        return this.f329a - (this.f331a ? 1 : 0);
    }

    public boolean readBoolean() {
        int ch = read();
        if (ch >= 0) {
            return ch != 0;
        }
        throw new EOFException();
    }

    public byte readByte() {
        int ch = read();
        if (ch >= 0) {
            return (byte) ch;
        }
        throw new EOFException();
    }

    public int readUnsignedByte() {
        int ch = read();
        if (ch >= 0) {
            return ch;
        }
        throw new EOFException();
    }

    public short readShort() {
        int ch1 = read();
        int ch2 = read();
        if ((ch1 | ch2) >= 0) {
            return (short) ((ch1 << 8) + ch2);
        }
        throw new EOFException();
    }

    public final short i() {
        int ch1 = read();
        int ch2 = read();
        if ((ch1 | ch2) >= 0) {
            return (short) ((ch2 << 8) + (ch1 << 0));
        }
        throw new EOFException();
    }

    public int readUnsignedShort() {
        int ch1 = read();
        int ch2 = read();
        if ((ch1 | ch2) >= 0) {
            return (ch1 << 8) + ch2;
        }
        throw new EOFException();
    }

    public final int m() {
        int ch1 = read();
        int ch2 = read();
        if ((ch1 | ch2) >= 0) {
            return (ch2 << 8) + (ch1 << 0);
        }
        throw new EOFException();
    }

    public char readChar() {
        int ch1 = read();
        int ch2 = read();
        if ((ch1 | ch2) >= 0) {
            return (char) ((ch1 << 8) + ch2);
        }
        throw new EOFException();
    }

    public int readInt() {
        int ch1 = read();
        int ch2 = read();
        int ch3 = read();
        int ch4 = read();
        if ((ch1 | ch2 | ch3 | ch4) >= 0) {
            return (ch1 << 24) + (ch2 << 16) + (ch3 << 8) + ch4;
        }
        throw new EOFException();
    }

    public final int g() {
        int ch1 = read();
        int ch2 = read();
        int ch3 = read();
        int ch4 = read();
        if ((ch1 | ch2 | ch3 | ch4) >= 0) {
            return (ch4 << 24) + (ch3 << 16) + (ch2 << 8) + (ch1 << 0);
        }
        throw new EOFException();
    }

    public final long k() {
        long ch1 = (long) read();
        long ch2 = (long) read();
        long ch3 = (long) read();
        long ch4 = (long) read();
        if ((ch1 | ch2 | ch3 | ch4) >= 0) {
            return (ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4 << 0);
        }
        throw new EOFException();
    }

    public final long l() {
        long ch1 = (long) read();
        long ch2 = (long) read();
        long ch3 = (long) read();
        long ch4 = (long) read();
        if ((ch1 | ch2 | ch3 | ch4) >= 0) {
            return (ch4 << 24) + (ch3 << 16) + (ch2 << 8) + (ch1 << 0);
        }
        throw new EOFException();
    }

    public long readLong() {
        return (((long) readInt()) << 32) + (((long) readInt()) & 4294967295L);
    }

    public final long h() {
        return (((long) g()) << 32) + (((long) g()) & 4294967295L);
    }

    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    public final float f() {
        return Float.intBitsToFloat(g());
    }

    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    public final double e() {
        return Double.longBitsToDouble(h());
    }

    public String readLine() {
        StringBuilder input = new StringBuilder();
        int c = -1;
        boolean eol = false;
        while (!eol) {
            int read = read();
            c = read;
            switch (read) {
                case -1:
                case 10:
                    eol = true;
                    break;
                case 13:
                    eol = true;
                    long cur = a();
                    if (read() == 10) {
                        break;
                    } else {
                        n(cur);
                        break;
                    }
                default:
                    input.append((char) c);
                    break;
            }
        }
        if (c == -1 && input.length() == 0) {
            return null;
        }
        return input.toString();
    }

    public String readUTF() {
        return DataInputStream.readUTF(this);
    }

    public String j(int length, String encoding) {
        byte[] buf = new byte[length];
        readFully(buf);
        try {
            return new String(buf, encoding);
        } catch (Exception e) {
            throw new mj(e);
        }
    }
}
