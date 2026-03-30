package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.api.Status;

/* renamed from: l01  reason: default package */
public final class l01 {
    private static final l01 a = new l01();

    /* renamed from: a  reason: collision with other field name */
    private static final t11<String> f4186a = t11.m("firebaseAppName", "firebaseUserUid", "operation", "tenantId", "verifyAssertionRequest", "statusCode", "statusMessage", "timestamp");
    private static long b = 3600000;

    /* renamed from: a  reason: collision with other field name */
    private long f4187a = 0;

    /* renamed from: a  reason: collision with other field name */
    private eq0<w4> f4188a;

    private l01() {
    }

    public static l01 a() {
        return a;
    }

    public static void d(Context context, f71 f71, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putString("verifyAssertionRequest", hi0.f(f71));
        edit.putString("operation", str);
        edit.putString("tenantId", str2);
        edit.putLong("timestamp", hf.b().a());
        edit.commit();
    }

    public static void c(Context context, Status status) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putInt("statusCode", status.m());
        edit.putString("statusMessage", status.p());
        edit.putLong("timestamp", hf.b().a());
        edit.commit();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0073, code lost:
        if (r4.equals("com.google.firebase.auth.internal.SIGN_IN") != false) goto L_0x008b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(com.google.firebase.auth.FirebaseAuth r12) {
        /*
            r11 = this;
            defpackage.y90.j(r12)
            gl r0 = r12.q()
            android.content.Context r0 = r0.i()
            java.lang.String r1 = "com.google.firebase.auth.internal.ProcessDeathHelper"
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)
            java.lang.String r1 = "firebaseAppName"
            java.lang.String r3 = ""
            java.lang.String r1 = r0.getString(r1, r3)
            gl r4 = r12.q()
            java.lang.String r4 = r4.l()
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L_0x002a
            return
        L_0x002a:
            java.lang.String r1 = "verifyAssertionRequest"
            boolean r4 = r0.contains(r1)
            r5 = 0
            java.lang.String r7 = "timestamp"
            if (r4 == 0) goto L_0x00e3
            java.lang.String r1 = r0.getString(r1, r3)
            android.os.Parcelable$Creator<f71> r4 = defpackage.f71.CREATOR
            gi0 r1 = defpackage.hi0.c(r1, r4)
            f71 r1 = (defpackage.f71) r1
            java.lang.String r4 = "operation"
            java.lang.String r4 = r0.getString(r4, r3)
            java.lang.String r8 = "tenantId"
            r9 = 0
            java.lang.String r8 = r0.getString(r8, r9)
            java.lang.String r10 = "firebaseUserUid"
            java.lang.String r3 = r0.getString(r10, r3)
            long r5 = r0.getLong(r7, r5)
            r11.f4187a = r5
            if (r8 == 0) goto L_0x0064
            r12.n(r8)
            r1.p(r8)
        L_0x0064:
            r5 = -1
            int r6 = r4.hashCode()
            switch(r6) {
                case -1843829902: goto L_0x0080;
                case -286760092: goto L_0x0076;
                case 1731327805: goto L_0x006d;
                default: goto L_0x006c;
            }
        L_0x006c:
            goto L_0x008a
        L_0x006d:
            java.lang.String r6 = "com.google.firebase.auth.internal.SIGN_IN"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x006c
            goto L_0x008b
        L_0x0076:
            java.lang.String r2 = "com.google.firebase.auth.internal.LINK"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x006c
            r2 = 1
            goto L_0x008b
        L_0x0080:
            java.lang.String r2 = "com.google.firebase.auth.internal.REAUTHENTICATE"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x006c
            r2 = 2
            goto L_0x008b
        L_0x008a:
            r2 = -1
        L_0x008b:
            switch(r2) {
                case 0: goto L_0x00d3;
                case 1: goto L_0x00b2;
                case 2: goto L_0x0091;
                default: goto L_0x008e;
            }
        L_0x008e:
            r11.f4188a = r9
            goto L_0x00df
        L_0x0091:
            dm r2 = r12.e()
            java.lang.String r2 = r2.r()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00af
            dm r12 = r12.e()
            l71 r1 = defpackage.l71.w(r1)
            eq0 r12 = r12.u(r1)
            r11.f4188a = r12
            goto L_0x00df
        L_0x00af:
            r11.f4188a = r9
            goto L_0x00df
        L_0x00b2:
            dm r2 = r12.e()
            java.lang.String r2 = r2.r()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00d0
            dm r12 = r12.e()
            l71 r1 = defpackage.l71.w(r1)
            eq0 r12 = r12.t(r1)
            r11.f4188a = r12
            goto L_0x00df
        L_0x00d0:
            r11.f4188a = r9
            goto L_0x00df
        L_0x00d3:
            l71 r1 = defpackage.l71.w(r1)
            eq0 r12 = r12.f(r1)
            r11.f4188a = r12
        L_0x00df:
            e(r0)
            return
        L_0x00e3:
            java.lang.String r12 = "statusCode"
            boolean r1 = r0.contains(r12)
            if (r1 == 0) goto L_0x0111
            r1 = 17062(0x42a6, float:2.3909E-41)
            int r12 = r0.getInt(r12, r1)
            java.lang.String r1 = "statusMessage"
            java.lang.String r1 = r0.getString(r1, r3)
            com.google.android.gms.common.api.Status r2 = new com.google.android.gms.common.api.Status
            r2.<init>(r12, r1)
            long r3 = r0.getLong(r7, r5)
            r11.f4187a = r3
            e(r0)
            wl r12 = defpackage.y41.b(r2)
            eq0 r12 = defpackage.lq0.d(r12)
            r11.f4188a = r12
            return
        L_0x0111:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l01.f(com.google.firebase.auth.FirebaseAuth):void");
    }

    public final void b(Context context) {
        y90.j(context);
        e(context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
        this.f4188a = null;
        this.f4187a = 0;
    }

    private static void e(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        t11<String> t11 = f4186a;
        int size = t11.size();
        int i = 0;
        while (i < size) {
            String str = t11.get(i);
            i++;
            edit.remove(str);
        }
        edit.commit();
    }
}
