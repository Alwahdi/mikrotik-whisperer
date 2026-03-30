package com.google.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

abstract class x {
    private static final long a = ((long) a());

    /* renamed from: a  reason: collision with other field name */
    private static final Unsafe f2612a = g();

    /* renamed from: a  reason: collision with other field name */
    private static final boolean f2613a = l();
    private static final long b = c(b(Buffer.class, "address"));

    /* renamed from: b  reason: collision with other field name */
    private static final boolean f2614b = k();

    static boolean h() {
        return f2614b;
    }

    static boolean i() {
        return f2613a;
    }

    static long d() {
        return a;
    }

    static byte e(byte[] target, long offset) {
        return f2612a.getByte(target, offset);
    }

    static void j(byte[] target, long offset, byte value) {
        f2612a.putByte(target, offset, value);
    }

    static long f(byte[] target, long offset) {
        return f2612a.getLong(target, offset);
    }

    private static Unsafe g() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable th) {
            return null;
        }
    }

    static class a implements PrivilegedExceptionAction<Unsafe> {
        a() {
        }

        /* renamed from: a */
        public Unsafe run() {
            Class<Unsafe> k = Unsafe.class;
            for (Field f : k.getDeclaredFields()) {
                f.setAccessible(true);
                Object x = f.get((Object) null);
                if (k.isInstance(x)) {
                    return k.cast(x);
                }
            }
            return null;
        }
    }

    private static boolean k() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = f2612a;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> clazz = unsafe.getClass();
            clazz.getMethod("arrayBaseOffset", new Class[]{Class.class});
            Class cls2 = Long.TYPE;
            clazz.getMethod("getByte", new Class[]{cls, cls2});
            clazz.getMethod("putByte", new Class[]{cls, cls2, Byte.TYPE});
            clazz.getMethod("getLong", new Class[]{cls, cls2});
            clazz.getMethod("copyMemory", new Class[]{cls, cls2, cls, cls2, cls2});
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean l() {
        Unsafe unsafe = f2612a;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> clazz = unsafe.getClass();
            clazz.getMethod("objectFieldOffset", new Class[]{Field.class});
            Class cls = Long.TYPE;
            clazz.getMethod("getByte", new Class[]{cls});
            clazz.getMethod("getLong", new Class[]{Object.class, cls});
            clazz.getMethod("putByte", new Class[]{cls, Byte.TYPE});
            clazz.getMethod("getLong", new Class[]{cls});
            clazz.getMethod("copyMemory", new Class[]{cls, cls, cls});
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private static int a() {
        if (f2614b) {
            return f2612a.arrayBaseOffset(byte[].class);
        }
        return -1;
    }

    private static long c(Field field) {
        Unsafe unsafe;
        if (field == null || (unsafe = f2612a) == null) {
            return -1;
        }
        return unsafe.objectFieldOffset(field);
    }

    private static Field b(Class<?> clazz, String fieldName) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field;
        } catch (Throwable th) {
            return null;
        }
    }
}
