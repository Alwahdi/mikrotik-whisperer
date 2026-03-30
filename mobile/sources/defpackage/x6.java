package defpackage;

import java.lang.reflect.Method;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* renamed from: x6  reason: default package */
class x6 implements dd0 {
    private final ByteBuffer a;

    public x6(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    public int a(long position) {
        if (position <= 2147483647L) {
            try {
                if (position >= ((long) this.a.limit())) {
                    return -1;
                }
                return this.a.get((int) position) & 255;
            } catch (BufferUnderflowException e) {
                return -1;
            }
        } else {
            throw new IllegalArgumentException("Position must be less than Integer.MAX_VALUE");
        }
    }

    public int c(long position, byte[] bytes, int off, int len) {
        if (position > 2147483647L) {
            throw new IllegalArgumentException("Position must be less than Integer.MAX_VALUE");
        } else if (position >= ((long) this.a.limit())) {
            return -1;
        } else {
            this.a.position((int) position);
            int bytesFromThisBuffer = Math.min(len, this.a.remaining());
            this.a.get(bytes, off, bytesFromThisBuffer);
            return bytesFromThisBuffer;
        }
    }

    public long b() {
        return (long) this.a.limit();
    }

    public void close() {
        d(this.a);
    }

    private static boolean d(ByteBuffer buffer) {
        if (buffer == null || !buffer.isDirect()) {
            return false;
        }
        return ((Boolean) AccessController.doPrivileged(new a(buffer))).booleanValue();
    }

    /* renamed from: x6$a */
    static class a implements PrivilegedAction<Boolean> {
        final /* synthetic */ ByteBuffer a;

        a(ByteBuffer byteBuffer) {
            this.a = byteBuffer;
        }

        /* renamed from: a */
        public Boolean run() {
            Boolean success = Boolean.FALSE;
            try {
                Method getCleanerMethod = this.a.getClass().getMethod("cleaner", (Class[]) null);
                getCleanerMethod.setAccessible(true);
                Object cleaner = getCleanerMethod.invoke(this.a, (Object[]) null);
                cleaner.getClass().getMethod("clean", (Class[]) null).invoke(cleaner, (Object[]) null);
                return Boolean.TRUE;
            } catch (Exception e) {
                return success;
            }
        }
    }
}
