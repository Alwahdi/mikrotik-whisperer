package defpackage;

/* renamed from: vs0  reason: default package */
public class vs0 {
    protected v80 a = null;

    public vs0(v80 writer) {
        this.a = writer;
    }

    /* JADX WARNING: type inference failed for: r3v10, types: [java.lang.Object[]] */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b2, code lost:
        r0 = r9;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(defpackage.us0 r17, defpackage.z60 r18, java.lang.Object[] r19, byte[] r20) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            r3 = 0
            r0 = r19[r3]
            r4 = r0
            java.util.HashMap r4 = (java.util.HashMap) r4
            boolean r0 = r2.f5833e
            r5 = 1
            r2.F(r4, r5, r0)
            java.util.Collection r0 = r4.values()
            int[][] r6 = new int[r3][]
            java.lang.Object[] r0 = r0.toArray(r6)
            r6 = r0
            int[][] r6 = (int[][]) r6
            java.util.Arrays.sort(r6, r2)
            boolean r0 = r2.i
            r7 = 0
            if (r0 == 0) goto L_0x0080
            byte[] r8 = r17.X()
            boolean r0 = r2.f5833e
            if (r0 != 0) goto L_0x0031
            java.util.ArrayList<int[]> r0 = r2.f5822a
            if (r0 == 0) goto L_0x006c
        L_0x0031:
            d7 r0 = new d7
            cd0 r9 = new cd0
            r9.<init>((byte[]) r8)
            r0.<init>(r9, r4)
            r9 = r0
            java.lang.String[] r0 = r9.g()     // Catch:{ Exception -> 0x0048 }
            r0 = r0[r3]     // Catch:{ Exception -> 0x0048 }
            byte[] r0 = r9.N(r0)     // Catch:{ Exception -> 0x0048 }
            r8 = r0
            goto L_0x006c
        L_0x0048:
            r0 = move-exception
            java.lang.Class<vs0> r10 = defpackage.vs0.class
            uy r10 = defpackage.wy.a(r10)
            java.lang.String r11 = "Issue in CFF font subsetting.Subsetting was disabled"
            r10.d(r11, r0)
            r2.D(r3)
            boolean r10 = r2.f5833e
            r2.F(r4, r5, r10)
            java.util.Collection r5 = r4.values()
            int[][] r3 = new int[r3][]
            java.lang.Object[] r3 = r5.toArray(r3)
            r6 = r3
            int[][] r6 = (int[][]) r6
            java.util.Arrays.sort(r6, r2)
        L_0x006c:
            y5$a r0 = new y5$a
            java.lang.String r3 = "CIDFontType0C"
            int r5 = r2.f5829b
            r0.<init>((byte[]) r8, (java.lang.String) r3, (int) r5)
            v80 r3 = r1.a
            y60 r3 = r3.y(r0)
            z60 r5 = r3.a()
            goto L_0x00cd
        L_0x0080:
            boolean r0 = r2.f5833e
            if (r0 != 0) goto L_0x008e
            int r0 = r2.e
            if (r0 == 0) goto L_0x0089
            goto L_0x008e
        L_0x0089:
            byte[] r0 = r17.O()
            goto L_0x00b3
        L_0x008e:
            cd0 r8 = r2.f5020a
            monitor-enter(r8)
            ts0 r0 = new ts0     // Catch:{ all -> 0x0114 }
            java.lang.String r10 = r2.f5025b     // Catch:{ all -> 0x0114 }
            cd0 r11 = new cd0     // Catch:{ all -> 0x0114 }
            cd0 r9 = r2.f5020a     // Catch:{ all -> 0x0114 }
            r11.<init>((defpackage.cd0) r9)     // Catch:{ all -> 0x0114 }
            java.util.HashSet r12 = new java.util.HashSet     // Catch:{ all -> 0x0114 }
            java.util.Set r9 = r4.keySet()     // Catch:{ all -> 0x0114 }
            r12.<init>(r9)     // Catch:{ all -> 0x0114 }
            int r13 = r2.e     // Catch:{ all -> 0x0114 }
            r14 = 1
            r15 = 0
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x0114 }
            byte[] r9 = r0.h()     // Catch:{ all -> 0x0114 }
            monitor-exit(r8)     // Catch:{ all -> 0x0110 }
            r0 = r9
        L_0x00b3:
            int[] r5 = new int[r5]
            int r8 = r0.length
            r5[r3] = r8
            r3 = r5
            y5$a r5 = new y5$a
            int r8 = r2.f5829b
            r5.<init>((byte[]) r0, (int[]) r3, (int) r8)
            v80 r8 = r1.a
            y60 r8 = r8.y(r5)
            z60 r9 = r8.a()
            r0 = r5
            r3 = r8
            r5 = r9
        L_0x00cd:
            java.lang.String r8 = ""
            boolean r9 = r2.f5833e
            if (r9 == 0) goto L_0x00d7
            java.lang.String r8 = defpackage.y5.h()
        L_0x00d7:
            j60 r7 = r2.N(r5, r8, r7)
            v80 r9 = r1.a
            y60 r3 = r9.y(r7)
            z60 r5 = r3.a()
            j60 r0 = r2.h0(r5, r8, r6)
            v80 r9 = r1.a
            y60 r3 = r9.y(r0)
            z60 r5 = r3.a()
            m80 r0 = r2.l0(r6)
            r9 = 0
            if (r0 == 0) goto L_0x0104
            v80 r10 = r1.a
            y60 r3 = r10.y(r0)
            z60 r9 = r3.a()
        L_0x0104:
            j60 r0 = r2.i0(r5, r8, r9)
            v80 r10 = r1.a
            r11 = r18
            r10.z(r0, r11)
            return
        L_0x0110:
            r0 = move-exception
            r11 = r18
            goto L_0x0118
        L_0x0114:
            r0 = move-exception
            r11 = r18
            r9 = r7
        L_0x0118:
            monitor-exit(r8)     // Catch:{ all -> 0x011a }
            throw r0
        L_0x011a:
            r0 = move-exception
            goto L_0x0118
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vs0.a(us0, z60, java.lang.Object[], byte[]):void");
    }
}
