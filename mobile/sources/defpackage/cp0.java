package defpackage;

import java.io.Serializable;
import java.util.Hashtable;

/* renamed from: cp0  reason: default package */
public class cp0 implements Serializable {
    private static final int[] a = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* renamed from: a  reason: collision with other field name */
    int f2667a;

    /* renamed from: a  reason: collision with other field name */
    long f2668a = 8;

    /* renamed from: a  reason: collision with other field name */
    Hashtable<Integer, Integer> f2669a = new Hashtable<>();

    /* renamed from: a  reason: collision with other field name */
    boolean f2670a;

    /* renamed from: a  reason: collision with other field name */
    ep0[] f2671a;
    long b = 0;

    private static boolean f(int endian) {
        return endian == 18761 || endian == 19789;
    }

    public cp0(cd0 stream, int directory) {
        long global_save_offset = stream.a();
        stream.n(0);
        int endian = stream.readUnsignedShort();
        if (f(endian)) {
            this.f2670a = endian == 19789;
            if (m(stream) == 42) {
                long ifd_offset = l(stream);
                int i = 0;
                while (i < directory) {
                    if (ifd_offset != 0) {
                        stream.n(ifd_offset);
                        stream.skip((long) (m(stream) * 12));
                        ifd_offset = l(stream);
                        i++;
                    } else {
                        throw new IllegalArgumentException(i10.b("directory.number.too.large", new Object[0]));
                    }
                }
                stream.n(ifd_offset);
                d(stream);
                stream.n(global_save_offset);
                return;
            }
            throw new IllegalArgumentException(i10.b("bad.magic.number.should.be.42", new Object[0]));
        }
        throw new IllegalArgumentException(i10.b("bad.endianness.tag.not.0x4949.or.0x4d4d", new Object[0]));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [byte[], char[], short[]], vars: [r0v7 ?, r0v8 ?, r0v9 ?, r0v10 ?, r0v11 ?, r0v12 ?, r0v15 ?, r0v16 ?, r0v17 ?, r0v20 ?, r0v21 ?, r0v22 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    private void d(defpackage.cd0 r20) {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            long r3 = r20.b()
            long r5 = r20.a()
            r1.f2668a = r5
            int r0 = r19.m(r20)
            r1.f2667a = r0
            ep0[] r0 = new defpackage.ep0[r0]
            r1.f2671a = r0
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x001c:
            int r0 = r1.f2667a
            if (r8 >= r0) goto L_0x0173
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0173
            int r9 = r19.m(r20)
            int r10 = r19.m(r20)
            long r11 = r19.l(r20)
            int r12 = (int) r11
            long r13 = r20.a()
            r15 = 4
            long r13 = r13 + r15
            r11 = 1
            int[] r0 = a     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0053 }
            r0 = r0[r10]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0053 }
            int r0 = r0 * r12
            r15 = 4
            if (r0 <= r15) goto L_0x0051
            long r5 = r19.l(r20)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0053 }
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x004f
            r2.n(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0053 }
            goto L_0x0051
        L_0x004f:
            r0 = 0
            goto L_0x0052
        L_0x0051:
            r0 = 1
        L_0x0052:
            goto L_0x0055
        L_0x0053:
            r0 = move-exception
            r0 = 0
        L_0x0055:
            if (r0 == 0) goto L_0x016a
            java.util.Hashtable<java.lang.Integer, java.lang.Integer> r0 = r1.f2669a
            java.lang.Integer r5 = java.lang.Integer.valueOf(r9)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r8)
            r0.put(r5, r6)
            r0 = 0
            r5 = 2
            switch(r10) {
                case 1: goto L_0x011e;
                case 2: goto L_0x011e;
                case 3: goto L_0x010d;
                case 4: goto L_0x00fd;
                case 5: goto L_0x00d6;
                case 6: goto L_0x011e;
                case 7: goto L_0x011e;
                case 8: goto L_0x00c5;
                case 9: goto L_0x00b4;
                case 10: goto L_0x008d;
                case 11: goto L_0x007c;
                case 12: goto L_0x006b;
                default: goto L_0x0069;
            }
        L_0x0069:
            goto L_0x0161
        L_0x006b:
            double[] r0 = new double[r12]
            r5 = 0
        L_0x006e:
            if (r5 >= r12) goto L_0x0079
            double r17 = r19.h(r20)
            r0[r5] = r17
            int r5 = r5 + 1
            goto L_0x006e
        L_0x0079:
            goto L_0x0161
        L_0x007c:
            float[] r0 = new float[r12]
            r5 = 0
        L_0x007f:
            if (r5 >= r12) goto L_0x008a
            float r6 = r19.i(r20)
            r0[r5] = r6
            int r5 = r5 + 1
            goto L_0x007f
        L_0x008a:
            goto L_0x0161
        L_0x008d:
            int[] r0 = new int[r5]
            r0[r11] = r5
            r0[r7] = r12
            java.lang.Class<int> r5 = int.class
            java.lang.Object r0 = java.lang.reflect.Array.newInstance(r5, r0)
            int[][] r0 = (int[][]) r0
            r5 = 0
        L_0x009c:
            if (r5 >= r12) goto L_0x00b1
            r6 = r0[r5]
            int r17 = r19.j(r20)
            r6[r7] = r17
            r6 = r0[r5]
            int r17 = r19.j(r20)
            r6[r11] = r17
            int r5 = r5 + 1
            goto L_0x009c
        L_0x00b1:
            goto L_0x0161
        L_0x00b4:
            int[] r0 = new int[r12]
            r5 = 0
        L_0x00b7:
            if (r5 >= r12) goto L_0x00c2
            int r6 = r19.j(r20)
            r0[r5] = r6
            int r5 = r5 + 1
            goto L_0x00b7
        L_0x00c2:
            goto L_0x0161
        L_0x00c5:
            short[] r0 = new short[r12]
            r5 = 0
        L_0x00c8:
            if (r5 >= r12) goto L_0x00d3
            short r6 = r19.k(r20)
            r0[r5] = r6
            int r5 = r5 + 1
            goto L_0x00c8
        L_0x00d3:
            goto L_0x0161
        L_0x00d6:
            int[] r0 = new int[r5]
            r0[r11] = r5
            r0[r7] = r12
            java.lang.Class<long> r5 = long.class
            java.lang.Object r0 = java.lang.reflect.Array.newInstance(r5, r0)
            long[][] r0 = (long[][]) r0
            r5 = 0
        L_0x00e5:
            if (r5 >= r12) goto L_0x00fa
            r6 = r0[r5]
            long r17 = r19.l(r20)
            r6[r7] = r17
            r6 = r0[r5]
            long r17 = r19.l(r20)
            r6[r11] = r17
            int r5 = r5 + 1
            goto L_0x00e5
        L_0x00fa:
            goto L_0x0161
        L_0x00fd:
            long[] r0 = new long[r12]
            r5 = 0
        L_0x0100:
            if (r5 >= r12) goto L_0x010b
            long r17 = r19.l(r20)
            r0[r5] = r17
            int r5 = r5 + 1
            goto L_0x0100
        L_0x010b:
            goto L_0x0161
        L_0x010d:
            char[] r0 = new char[r12]
            r5 = 0
        L_0x0110:
            if (r5 >= r12) goto L_0x011c
            int r6 = r19.m(r20)
            char r6 = (char) r6
            r0[r5] = r6
            int r5 = r5 + 1
            goto L_0x0110
        L_0x011c:
            goto L_0x0161
        L_0x011e:
            byte[] r0 = new byte[r12]
            r2.readFully(r0, r7, r12)
            if (r10 != r5) goto L_0x015f
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6 = 0
            r11 = 0
        L_0x012d:
            if (r6 >= r12) goto L_0x0149
        L_0x012f:
            if (r6 >= r12) goto L_0x013c
            int r17 = r6 + 1
            byte r6 = r0[r6]
            if (r6 == 0) goto L_0x013a
            r6 = r17
            goto L_0x012f
        L_0x013a:
            r6 = r17
        L_0x013c:
            java.lang.String r7 = new java.lang.String
            int r15 = r6 - r11
            r7.<init>(r0, r11, r15)
            r5.add(r7)
            r11 = r6
            r7 = 0
            goto L_0x012d
        L_0x0149:
            int r12 = r5.size()
            java.lang.String[] r0 = new java.lang.String[r12]
            r6 = 0
        L_0x0150:
            if (r6 >= r12) goto L_0x015d
            java.lang.Object r7 = r5.get(r6)
            java.lang.String r7 = (java.lang.String) r7
            r0[r6] = r7
            int r6 = r6 + 1
            goto L_0x0150
        L_0x015d:
            goto L_0x0161
        L_0x015f:
        L_0x0161:
            ep0[] r5 = r1.f2671a
            ep0 r6 = new ep0
            r6.<init>(r9, r10, r12, r0)
            r5[r8] = r6
        L_0x016a:
            r2.n(r13)
            int r8 = r8 + 1
            r9 = r13
            r7 = 0
            goto L_0x001c
        L_0x0173:
            long r2 = r19.l(r20)     // Catch:{ Exception -> 0x017a }
            r1.b = r2     // Catch:{ Exception -> 0x017a }
            goto L_0x017f
        L_0x017a:
            r0 = move-exception
            r2 = 0
            r1.b = r2
        L_0x017f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cp0.d(cd0):void");
    }

    public ep0 a(int tag) {
        Integer i = this.f2669a.get(Integer.valueOf(tag));
        if (i == null) {
            return null;
        }
        return this.f2671a[i.intValue()];
    }

    public boolean e(int tag) {
        return this.f2669a.containsKey(Integer.valueOf(tag));
    }

    public long c(int tag, int index) {
        return this.f2671a[this.f2669a.get(Integer.valueOf(tag)).intValue()].e(index);
    }

    public long b(int tag) {
        return c(tag, 0);
    }

    private short k(cd0 stream) {
        if (this.f2670a) {
            return stream.readShort();
        }
        return stream.i();
    }

    private int m(cd0 stream) {
        if (this.f2670a) {
            return stream.readUnsignedShort();
        }
        return stream.m();
    }

    private int j(cd0 stream) {
        if (this.f2670a) {
            return stream.readInt();
        }
        return stream.g();
    }

    private long l(cd0 stream) {
        if (this.f2670a) {
            return stream.k();
        }
        return stream.l();
    }

    private float i(cd0 stream) {
        if (this.f2670a) {
            return stream.readFloat();
        }
        return stream.f();
    }

    private double h(cd0 stream) {
        if (this.f2670a) {
            return stream.readDouble();
        }
        return stream.e();
    }
}
