package defpackage;

import com.google.protobuf.f;
import com.google.protobuf.p;
import io.grpc.m;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;

/* renamed from: kb0  reason: default package */
public abstract class kb0 {
    static volatile fk a = fk.a();

    public static <T extends p> m.c<T> b(T defaultInstance) {
        return new a(defaultInstance);
    }

    static long a(InputStream from, OutputStream to) {
        v90.n(from);
        v90.n(to);
        byte[] buf = new byte[8192];
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

    /* renamed from: kb0$a */
    private static final class a<T extends p> implements m.c {
        private static final ThreadLocal<Reference<byte[]>> a = new ThreadLocal<>();

        /* renamed from: a  reason: collision with other field name */
        private final T f4111a;

        /* renamed from: a  reason: collision with other field name */
        private final n50<T> f4112a;

        a(T defaultInstance) {
            this.f4111a = defaultInstance;
            this.f4112a = defaultInstance.h();
        }

        /* renamed from: e */
        public InputStream a(T value) {
            return new jb0(value, this.f4112a);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x003c, code lost:
            if (r5.length >= r1) goto L_0x0049;
         */
        /* renamed from: c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public T b(java.io.InputStream r10) {
            /*
                r9 = this;
                boolean r0 = r10 instanceof defpackage.jb0
                if (r0 == 0) goto L_0x0018
                r0 = r10
                jb0 r0 = (defpackage.jb0) r0
                n50 r1 = r0.o()
                n50<T> r2 = r9.f4112a
                if (r1 != r2) goto L_0x0018
                r1 = r10
                jb0 r1 = (defpackage.jb0) r1     // Catch:{ IllegalStateException -> 0x0017 }
                com.google.protobuf.p r1 = r1.f()     // Catch:{ IllegalStateException -> 0x0017 }
                return r1
            L_0x0017:
                r1 = move-exception
            L_0x0018:
                r0 = 0
                boolean r1 = r10 instanceof defpackage.hw     // Catch:{ IOException -> 0x00ab }
                if (r1 == 0) goto L_0x0087
                int r1 = r10.available()     // Catch:{ IOException -> 0x00ab }
                if (r1 <= 0) goto L_0x0082
                r2 = 4194304(0x400000, float:5.877472E-39)
                if (r1 > r2) goto L_0x0082
                java.lang.ThreadLocal<java.lang.ref.Reference<byte[]>> r2 = a     // Catch:{ IOException -> 0x00ab }
                java.lang.Object r3 = r2.get()     // Catch:{ IOException -> 0x00ab }
                java.lang.ref.Reference r3 = (java.lang.ref.Reference) r3     // Catch:{ IOException -> 0x00ab }
                r4 = r3
                if (r3 == 0) goto L_0x003e
                java.lang.Object r3 = r4.get()     // Catch:{ IOException -> 0x00ab }
                byte[] r3 = (byte[]) r3     // Catch:{ IOException -> 0x00ab }
                r5 = r3
                if (r3 == 0) goto L_0x003e
                int r3 = r5.length     // Catch:{ IOException -> 0x00ab }
                if (r3 >= r1) goto L_0x0049
            L_0x003e:
                byte[] r3 = new byte[r1]     // Catch:{ IOException -> 0x00ab }
                r5 = r3
                java.lang.ref.WeakReference r3 = new java.lang.ref.WeakReference     // Catch:{ IOException -> 0x00ab }
                r3.<init>(r5)     // Catch:{ IOException -> 0x00ab }
                r2.set(r3)     // Catch:{ IOException -> 0x00ab }
            L_0x0049:
                r2 = r1
            L_0x004a:
                if (r2 <= 0) goto L_0x0058
                int r3 = r1 - r2
                int r6 = r10.read(r5, r3, r2)     // Catch:{ IOException -> 0x00ab }
                r7 = -1
                if (r6 != r7) goto L_0x0056
                goto L_0x0058
            L_0x0056:
                int r2 = r2 - r6
                goto L_0x004a
            L_0x0058:
                if (r2 != 0) goto L_0x0061
                r3 = 0
                com.google.protobuf.f r3 = com.google.protobuf.f.h(r5, r3, r1)     // Catch:{ IOException -> 0x00ab }
                r0 = r3
            L_0x0060:
                goto L_0x0087
            L_0x0061:
                int r3 = r1 - r2
                java.lang.RuntimeException r6 = new java.lang.RuntimeException     // Catch:{ IOException -> 0x00ab }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ab }
                r7.<init>()     // Catch:{ IOException -> 0x00ab }
                java.lang.String r8 = "size inaccurate: "
                r7.append(r8)     // Catch:{ IOException -> 0x00ab }
                r7.append(r1)     // Catch:{ IOException -> 0x00ab }
                java.lang.String r8 = " != "
                r7.append(r8)     // Catch:{ IOException -> 0x00ab }
                r7.append(r3)     // Catch:{ IOException -> 0x00ab }
                java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x00ab }
                r6.<init>(r7)     // Catch:{ IOException -> 0x00ab }
                throw r6     // Catch:{ IOException -> 0x00ab }
            L_0x0082:
                if (r1 != 0) goto L_0x0060
                T r2 = r9.f4111a     // Catch:{ IOException -> 0x00ab }
                return r2
            L_0x0087:
                if (r0 != 0) goto L_0x008e
                com.google.protobuf.f r0 = com.google.protobuf.f.f(r10)
            L_0x008e:
                r1 = 2147483647(0x7fffffff, float:NaN)
                r0.O(r1)
                com.google.protobuf.p r1 = r9.d(r0)     // Catch:{ m -> 0x0099 }
                return r1
            L_0x0099:
                r1 = move-exception
                io.grpc.p r2 = io.grpc.p.o
                java.lang.String r3 = "Invalid protobuf byte sequence"
                io.grpc.p r2 = r2.q(r3)
                io.grpc.p r2 = r2.p(r1)
                io.grpc.r r2 = r2.d()
                throw r2
            L_0x00ab:
                r1 = move-exception
                java.lang.RuntimeException r2 = new java.lang.RuntimeException
                r2.<init>(r1)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.kb0.a.b(java.io.InputStream):com.google.protobuf.p");
        }

        private T d(f stream) {
            T message = (p) this.f4112a.b(stream, kb0.a);
            try {
                stream.a(0);
                return message;
            } catch (com.google.protobuf.m e) {
                e.i(message);
                throw e;
            }
        }
    }
}
