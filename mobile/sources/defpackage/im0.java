package defpackage;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: im0  reason: default package */
public class im0 {
    private static final String a = im0.class.getSimpleName();

    /* renamed from: a  reason: collision with other field name */
    private AtomicBoolean f3262a = new AtomicBoolean(false);

    /* renamed from: a  reason: collision with other field name */
    private AtomicLong f3263a = new AtomicLong();
    private AtomicLong b = new AtomicLong();

    public static long f(long[] response) {
        return (response[3] - response[0]) - (response[2] - response[1]);
    }

    public static long e(long[] response) {
        return ((response[1] - response[0]) + (response[2] - response[3])) / 2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01da A[SYNTHETIC, Splitter:B:55:0x01da] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized long[] i(java.lang.String r43, float r44, float r45, int r46, int r47) {
        /*
            r42 = this;
            r1 = r42
            r2 = r43
            r3 = r44
            r4 = r45
            r5 = r46
            monitor-enter(r42)
            r6 = 0
            r0 = 48
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x01bf }
            java.net.InetAddress r7 = java.net.InetAddress.getByName(r43)     // Catch:{ Exception -> 0x01bf }
            java.net.DatagramPacket r8 = new java.net.DatagramPacket     // Catch:{ Exception -> 0x01bf }
            int r9 = r0.length     // Catch:{ Exception -> 0x01bf }
            r10 = 123(0x7b, float:1.72E-43)
            r8.<init>(r0, r9, r7, r10)     // Catch:{ Exception -> 0x01bf }
            r1.n(r0)     // Catch:{ Exception -> 0x01bf }
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01bf }
            long r11 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x01bf }
            r13 = 40
            r1.m(r0, r13, r9)     // Catch:{ Exception -> 0x01bf }
            java.net.DatagramSocket r14 = new java.net.DatagramSocket     // Catch:{ Exception -> 0x01bf }
            r14.<init>()     // Catch:{ Exception -> 0x01bf }
            r6 = r14
            r14 = r47
            r6.setSoTimeout(r14)     // Catch:{ Exception -> 0x01bf }
            r6.send(r8)     // Catch:{ Exception -> 0x01bf }
            r15 = 8
            long[] r13 = new long[r15]     // Catch:{ Exception -> 0x01bf }
            java.net.DatagramPacket r15 = new java.net.DatagramPacket     // Catch:{ Exception -> 0x01bf }
            r18 = r7
            int r7 = r0.length     // Catch:{ Exception -> 0x01bf }
            r15.<init>(r0, r7)     // Catch:{ Exception -> 0x01bf }
            r7 = r15
            r6.receive(r7)     // Catch:{ Exception -> 0x01bf }
            long r19 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x01bf }
            r15 = 7
            r13[r15] = r19     // Catch:{ Exception -> 0x01bf }
            r15 = 24
            long r22 = r1.h(r0, r15)     // Catch:{ Exception -> 0x01bf }
            r15 = 32
            long r24 = r1.h(r0, r15)     // Catch:{ Exception -> 0x01bf }
            r15 = 40
            long r15 = r1.h(r0, r15)     // Catch:{ Exception -> 0x01bf }
            long r26 = r19 - r11
            long r26 = r9 + r26
            r28 = 0
            r13[r28] = r22     // Catch:{ Exception -> 0x01bf }
            r29 = r7
            r7 = 1
            r13[r7] = r24     // Catch:{ Exception -> 0x01bf }
            r30 = 2
            r13[r30] = r15     // Catch:{ Exception -> 0x01bf }
            r7 = 3
            r13[r7] = r26     // Catch:{ Exception -> 0x01bf }
            r7 = 4
            long r31 = r1.g(r0, r7)     // Catch:{ Exception -> 0x01bf }
            r13[r7] = r31     // Catch:{ Exception -> 0x01bf }
            r31 = r8
            r32 = r9
            r8 = r13[r7]     // Catch:{ Exception -> 0x01bf }
            double r8 = r1.b(r8)     // Catch:{ Exception -> 0x01bf }
            r34 = r11
            double r10 = (double) r3     // Catch:{ Exception -> 0x01bf }
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 > 0) goto L_0x01a8
            r10 = 8
            long r10 = r1.g(r0, r10)     // Catch:{ Exception -> 0x01bf }
            r12 = 5
            r13[r12] = r10     // Catch:{ Exception -> 0x01bf }
            r10 = r13[r12]     // Catch:{ Exception -> 0x01bf }
            double r10 = r1.b(r10)     // Catch:{ Exception -> 0x01bf }
            r17 = r13
            double r12 = (double) r4     // Catch:{ Exception -> 0x01bf }
            int r37 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r37 > 0) goto L_0x0197
            byte r12 = r0[r28]     // Catch:{ Exception -> 0x01bf }
            r13 = 7
            r12 = r12 & r13
            byte r12 = (byte) r12
            if (r12 == r7) goto L_0x00cd
            r7 = 5
            if (r12 != r7) goto L_0x00b0
            goto L_0x00cd
        L_0x00b0:
            su r7 = new su     // Catch:{ Exception -> 0x00ca, all -> 0x00c7 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ca, all -> 0x00c7 }
            r13.<init>()     // Catch:{ Exception -> 0x00ca, all -> 0x00c7 }
            java.lang.String r14 = "untrusted mode value for TrueTime: "
            r13.append(r14)     // Catch:{ Exception -> 0x00ca, all -> 0x00c7 }
            r13.append(r12)     // Catch:{ Exception -> 0x00ca, all -> 0x00c7 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x00ca, all -> 0x00c7 }
            r7.<init>(r13)     // Catch:{ Exception -> 0x00ca, all -> 0x00c7 }
            throw r7     // Catch:{ Exception -> 0x00ca, all -> 0x00c7 }
        L_0x00c7:
            r0 = move-exception
            goto L_0x01d8
        L_0x00ca:
            r0 = move-exception
            goto L_0x01c0
        L_0x00cd:
            r7 = 1
            byte r13 = r0[r7]     // Catch:{ Exception -> 0x01bf }
            r13 = r13 & 255(0xff, float:3.57E-43)
            r36 = r8
            long r7 = (long) r13     // Catch:{ Exception -> 0x01bf }
            r9 = 6
            r17[r9] = r7     // Catch:{ Exception -> 0x01bf }
            r7 = 1
            if (r13 < r7) goto L_0x017a
            r7 = 15
            if (r13 > r7) goto L_0x017a
            byte r7 = r0[r28]     // Catch:{ Exception -> 0x01bf }
            int r7 = r7 >> r9
            r8 = 3
            r7 = r7 & r8
            byte r7 = (byte) r7     // Catch:{ Exception -> 0x01bf }
            if (r7 == r8) goto L_0x016a
            long r8 = r26 - r22
            long r38 = r15 - r24
            long r8 = r8 - r38
            long r8 = java.lang.Math.abs(r8)     // Catch:{ Exception -> 0x01bf }
            double r8 = (double) r8     // Catch:{ Exception -> 0x01bf }
            r38 = r15
            double r14 = (double) r5     // Catch:{ Exception -> 0x01bf }
            int r16 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r16 >= 0) goto L_0x0158
            long r14 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01bf }
            long r14 = r22 - r14
            long r14 = java.lang.Math.abs(r14)     // Catch:{ Exception -> 0x01bf }
            r40 = 10000(0x2710, double:4.9407E-320)
            int r16 = (r14 > r40 ? 1 : (r14 == r40 ? 0 : -1))
            if (r16 >= 0) goto L_0x0137
            r16 = r0
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.f3262a     // Catch:{ Exception -> 0x01bf }
            r21 = r7
            r7 = 1
            r0.set(r7)     // Catch:{ Exception -> 0x01bf }
            java.lang.String r0 = a     // Catch:{ Exception -> 0x01bf }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01bf }
            r7.<init>()     // Catch:{ Exception -> 0x01bf }
            r28 = r12
            java.lang.String r12 = "---- SNTP successful response from "
            r7.append(r12)     // Catch:{ Exception -> 0x01bf }
            r7.append(r2)     // Catch:{ Exception -> 0x01bf }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x01bf }
            defpackage.ps0.c(r0, r7)     // Catch:{ Exception -> 0x01bf }
            r0 = r17
            r1.a(r0)     // Catch:{ Exception -> 0x01bf }
            r6.close()     // Catch:{ all -> 0x01de }
            monitor-exit(r42)
            return r0
        L_0x0137:
            r16 = r0
            r21 = r7
            r28 = r12
            r0 = r17
            su r7 = new su     // Catch:{ Exception -> 0x01bf }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01bf }
            r12.<init>()     // Catch:{ Exception -> 0x01bf }
            r17 = r0
            java.lang.String r0 = "Request was sent more than 10 seconds back "
            r12.append(r0)     // Catch:{ Exception -> 0x01bf }
            r12.append(r14)     // Catch:{ Exception -> 0x01bf }
            java.lang.String r0 = r12.toString()     // Catch:{ Exception -> 0x01bf }
            r7.<init>(r0)     // Catch:{ Exception -> 0x01bf }
            throw r7     // Catch:{ Exception -> 0x01bf }
        L_0x0158:
            r16 = r0
            r21 = r7
            r28 = r12
            su r0 = new su     // Catch:{ Exception -> 0x01bf }
            java.lang.String r7 = "%s too large for comfort %f [actual] >= %f [expected]"
            java.lang.String r12 = "server_response_delay"
            float r14 = (float) r8     // Catch:{ Exception -> 0x01bf }
            float r15 = (float) r5     // Catch:{ Exception -> 0x01bf }
            r0.<init>(r7, r12, r14, r15)     // Catch:{ Exception -> 0x01bf }
            throw r0     // Catch:{ Exception -> 0x01bf }
        L_0x016a:
            r21 = r7
            r28 = r12
            r38 = r15
            r16 = r0
            su r0 = new su     // Catch:{ Exception -> 0x01bf }
            java.lang.String r7 = "unsynchronized server responded for TrueTime"
            r0.<init>(r7)     // Catch:{ Exception -> 0x01bf }
            throw r0     // Catch:{ Exception -> 0x01bf }
        L_0x017a:
            r28 = r12
            r38 = r15
            r16 = r0
            su r0 = new su     // Catch:{ Exception -> 0x01bf }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01bf }
            r7.<init>()     // Catch:{ Exception -> 0x01bf }
            java.lang.String r8 = "untrusted stratum value for TrueTime: "
            r7.append(r8)     // Catch:{ Exception -> 0x01bf }
            r7.append(r13)     // Catch:{ Exception -> 0x01bf }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x01bf }
            r0.<init>(r7)     // Catch:{ Exception -> 0x01bf }
            throw r0     // Catch:{ Exception -> 0x01bf }
        L_0x0197:
            r36 = r8
            r38 = r15
            r16 = r0
            su r0 = new su     // Catch:{ Exception -> 0x01bf }
            java.lang.String r7 = "Invalid response from NTP server. %s violation. %f [actual] > %f [expected]"
            java.lang.String r8 = "root_dispersion"
            float r9 = (float) r10     // Catch:{ Exception -> 0x01bf }
            r0.<init>(r7, r8, r9, r4)     // Catch:{ Exception -> 0x01bf }
            throw r0     // Catch:{ Exception -> 0x01bf }
        L_0x01a8:
            r36 = r8
            r17 = r13
            r38 = r15
            r16 = r0
            su r0 = new su     // Catch:{ Exception -> 0x01bf }
            java.lang.String r7 = "Invalid response from NTP server. %s violation. %f [actual] > %f [expected]"
            java.lang.String r8 = "root_delay"
            r9 = r36
            float r11 = (float) r9     // Catch:{ Exception -> 0x01bf }
            r0.<init>(r7, r8, r11, r3)     // Catch:{ Exception -> 0x01bf }
            throw r0     // Catch:{ Exception -> 0x01bf }
        L_0x01bd:
            r0 = move-exception
            goto L_0x01d8
        L_0x01bf:
            r0 = move-exception
        L_0x01c0:
            java.lang.String r7 = a     // Catch:{ all -> 0x01bd }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x01bd }
            r8.<init>()     // Catch:{ all -> 0x01bd }
            java.lang.String r9 = "---- SNTP request failed for "
            r8.append(r9)     // Catch:{ all -> 0x01bd }
            r8.append(r2)     // Catch:{ all -> 0x01bd }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x01bd }
            defpackage.ps0.a(r7, r8)     // Catch:{ all -> 0x01bd }
            throw r0     // Catch:{ all -> 0x01bd }
        L_0x01d8:
            if (r6 == 0) goto L_0x01dd
            r6.close()     // Catch:{ all -> 0x01de }
        L_0x01dd:
            throw r0     // Catch:{ all -> 0x01de }
        L_0x01de:
            r0 = move-exception
            monitor-exit(r42)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.im0.i(java.lang.String, float, float, int, int):long[]");
    }

    /* access modifiers changed from: package-private */
    public void a(long[] response) {
        this.b.set(j(response));
        this.f3263a.set(response[7]);
    }

    /* access modifiers changed from: package-private */
    public long j(long[] response) {
        return response[3] + e(response);
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return this.f3262a.get();
    }

    /* access modifiers changed from: package-private */
    public long d() {
        return this.b.get();
    }

    /* access modifiers changed from: package-private */
    public long c() {
        return this.f3263a.get();
    }

    private void n(byte[] buffer) {
        buffer[0] = 27;
    }

    private void m(byte[] buffer, int offset, long time) {
        long seconds = time / 1000;
        long seconds2 = seconds + 2208988800L;
        int offset2 = offset + 1;
        buffer[offset] = (byte) ((int) (seconds2 >> 24));
        int offset3 = offset2 + 1;
        buffer[offset2] = (byte) ((int) (seconds2 >> 16));
        int offset4 = offset3 + 1;
        buffer[offset3] = (byte) ((int) (seconds2 >> 8));
        int offset5 = offset4 + 1;
        buffer[offset4] = (byte) ((int) (seconds2 >> 0));
        long fraction = (4294967296L * (time - (seconds * 1000))) / 1000;
        int offset6 = offset5 + 1;
        buffer[offset5] = (byte) ((int) (fraction >> 24));
        int offset7 = offset6 + 1;
        buffer[offset6] = (byte) ((int) (fraction >> 16));
        int offset8 = offset7 + 1;
        buffer[offset7] = (byte) ((int) (fraction >> 8));
        int i = offset8 + 1;
        buffer[offset8] = (byte) ((int) (Math.random() * 255.0d));
    }

    private long h(byte[] buffer, int offset) {
        return ((g(buffer, offset) - 2208988800L) * 1000) + ((1000 * g(buffer, offset + 4)) / 4294967296L);
    }

    private long g(byte[] buffer, int offset) {
        return (((long) k(buffer[offset])) << 24) + (((long) k(buffer[offset + 1])) << 16) + (((long) k(buffer[offset + 2])) << 8) + ((long) k(buffer[offset + 3]));
    }

    private int k(byte b2) {
        return b2 & 255;
    }

    private double b(long fix) {
        return ((double) fix) / 65.536d;
    }
}
