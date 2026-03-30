package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;
import org.apache.http.protocol.HTTP;

public abstract class l {
    public static final f a;

    /* renamed from: a  reason: collision with other field name */
    public static final ByteBuffer f2582a;

    /* renamed from: a  reason: collision with other field name */
    static final Charset f2583a = Charset.forName(HTTP.UTF_8);

    /* renamed from: a  reason: collision with other field name */
    public static final byte[] f2584a;
    static final Charset b = Charset.forName("ISO-8859-1");

    public interface a {
        int getNumber();
    }

    public interface b<T extends a> {
    }

    public interface c extends d<Integer> {
        int getInt(int i);

        void k(int i);

        c y(int i);
    }

    public interface d<E> extends List<E>, RandomAccess {
        boolean e();

        void i();

        d<E> w(int i);
    }

    static {
        byte[] bArr = new byte[0];
        f2584a = bArr;
        f2582a = ByteBuffer.wrap(bArr);
        a = f.g(bArr);
    }

    public static int d(long n) {
        return (int) ((n >>> 32) ^ n);
    }

    public static int a(boolean b2) {
        return b2 ? 1231 : 1237;
    }

    public static int b(byte[] bytes) {
        return c(bytes, 0, bytes.length);
    }

    static int c(byte[] bytes, int offset, int length) {
        int h = e(length, bytes, offset, length);
        if (h == 0) {
            return 1;
        }
        return h;
    }

    static int e(int h, byte[] bytes, int offset, int length) {
        for (int i = offset; i < offset + length; i++) {
            h = (h * 31) + bytes[i];
        }
        return h;
    }
}
