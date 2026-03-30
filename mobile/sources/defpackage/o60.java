package defpackage;

import java.io.OutputStream;
import java.security.MessageDigest;

/* renamed from: o60  reason: default package */
public abstract class o60 {
    static long a = System.currentTimeMillis();

    /* renamed from: a  reason: collision with other field name */
    private static final byte[] f4493a = {40, -65, 78, 94, 78, 117, -118, 65, 100, 0, 78, 86, -1, -6, 1, 8, 46, 46, 0, -74, -48, 104, 62, Byte.MIN_VALUE, 47, 12, -87, -2, 100, 83, 105, 122};
    private static final byte[] b = {115, 65, 108, 84};
    private static final byte[] c = {-1, -1, -1, -1};

    public abstract int a(int i);

    public abstract byte[] d(byte[] bArr);

    public abstract a50 e(OutputStream outputStream);

    public abstract boolean f();

    public abstract void g(int i, int i2);

    public static byte[] b() {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            long time = System.currentTimeMillis();
            long mem = Runtime.getRuntime().freeMemory();
            StringBuilder sb = new StringBuilder();
            sb.append(time);
            sb.append("+");
            sb.append(mem);
            sb.append("+");
            long j = a;
            a = 1 + j;
            sb.append(j);
            return md5.digest(sb.toString().getBytes());
        } catch (Exception e) {
            throw new mj(e);
        }
    }

    public static o70 c(byte[] id, boolean modified) {
        w6 buf = new w6(90);
        if (id.length == 0) {
            id = b();
        }
        buf.f('[').f('<');
        for (byte U : id) {
            buf.U(U);
        }
        buf.f('>').f('<');
        if (modified) {
            id = b();
        }
        for (byte U2 : id) {
            buf.U(U2);
        }
        buf.f('>').f(']');
        buf.close();
        return new f70(buf.c0());
    }
}
