package com.itextpdf.text.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.InflaterInputStream;

public abstract class c {
    protected static kd a;

    /* renamed from: a  reason: collision with other field name */
    private static final uy f2641a;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f2642a = false;

    /* renamed from: a  reason: collision with other field name */
    static final byte[] f2643a = n60.c("endstream", (String) null);

    /* renamed from: a  reason: collision with other field name */
    static final h70[] f2644a = {h70.Q6, h70.ka, h70.N9, h70.Q1};
    public static boolean b = false;

    /* renamed from: b  reason: collision with other field name */
    static final byte[] f2645b = n60.c("endobj", (String) null);

    static {
        Class<c> cls = c.class;
        f2641a = wy.a(cls);
        a = ld.a(cls);
    }

    public static o70 b(o70 obj) {
        if (obj == null) {
            return null;
        }
        if (!obj.z()) {
            return obj;
        }
        try {
            b6.a(obj);
            b50 ref = null;
            ref.I();
            ref.J();
            throw null;
        } catch (Exception e) {
            throw new mj(e);
        }
    }

    public static o70 c(o70 obj, o70 parent) {
        if (obj == null) {
            return null;
        }
        if (obj.z()) {
            return b(obj);
        }
        if (parent != null) {
            b50 ref = parent.r();
        }
        return obj;
    }

    public static byte[] a(byte[] in, boolean strict) {
        InflaterInputStream zip = new InflaterInputStream(new ByteArrayInputStream(in));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] b2 = new byte[(strict ? 4092 : 1)];
        while (true) {
            try {
                int read = zip.read(b2);
                int n = read;
                if (read < 0) {
                    break;
                }
                out.write(b2, 0, n);
            } catch (Exception e) {
                if (strict) {
                    try {
                        zip.close();
                    } catch (IOException e2) {
                    }
                    try {
                        out.close();
                    } catch (IOException e3) {
                    }
                    return null;
                }
                byte[] byteArray = out.toByteArray();
                try {
                    zip.close();
                } catch (IOException e4) {
                }
                try {
                    out.close();
                } catch (IOException e5) {
                }
                return byteArray;
            } catch (Throwable th) {
                try {
                    zip.close();
                } catch (IOException e6) {
                }
                try {
                    out.close();
                } catch (IOException e7) {
                }
                throw th;
            }
        }
        zip.close();
        out.close();
        byte[] byteArray2 = out.toByteArray();
        try {
            zip.close();
        } catch (IOException e8) {
        }
        try {
            out.close();
        } catch (IOException e9) {
        }
        return byteArray2;
    }
}
