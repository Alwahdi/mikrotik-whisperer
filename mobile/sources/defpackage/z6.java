package defpackage;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Deque;

/* renamed from: z6  reason: default package */
public abstract class z6 {
    private static final OutputStream a = new a();

    static byte[] c() {
        return new byte[8192];
    }

    public static long b(InputStream from, OutputStream to) {
        v90.n(from);
        v90.n(to);
        byte[] buf = c();
        long total = 0;
        while (true) {
            int r = from.read(buf);
            if (r == -1) {
                return total;
            }
            to.write(buf, 0, r);
            total += (long) r;
        }
    }

    private static byte[] e(InputStream in, Deque<byte[]> bufs, int totalLen) {
        int bufSize = 8192;
        while (totalLen < 2147483639) {
            byte[] buf = new byte[Math.min(bufSize, 2147483639 - totalLen)];
            bufs.add(buf);
            int off = 0;
            while (off < buf.length) {
                int r = in.read(buf, off, buf.length - off);
                if (r == -1) {
                    return a(bufs, totalLen);
                }
                off += r;
                totalLen += r;
            }
            bufSize = at.e(bufSize, 2);
        }
        if (in.read() == -1) {
            return a(bufs, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    private static byte[] a(Deque<byte[]> bufs, int totalLen) {
        byte[] result = new byte[totalLen];
        int remaining = totalLen;
        while (remaining > 0) {
            byte[] buf = bufs.removeFirst();
            int bytesToCopy = Math.min(remaining, buf.length);
            System.arraycopy(buf, 0, result, totalLen - remaining, bytesToCopy);
            remaining -= bytesToCopy;
        }
        return result;
    }

    public static byte[] d(InputStream in) {
        v90.n(in);
        return e(in, new ArrayDeque(20), 0);
    }

    /* renamed from: z6$a */
    static class a extends OutputStream {
        a() {
        }

        public void write(int b) {
        }

        public void write(byte[] b) {
            v90.n(b);
        }

        public void write(byte[] b, int off, int len) {
            v90.n(b);
        }

        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }
    }
}
