package defpackage;

import android.util.Log;
import java.util.Locale;

/* renamed from: vy  reason: default package */
public class vy {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final String f5421a;

    /* renamed from: a  reason: collision with other field name */
    private final qp f5422a;
    private final String b;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public vy(java.lang.String r7, java.lang.String... r8) {
        /*
            r6 = this;
            int r0 = r8.length
            if (r0 != 0) goto L_0x0007
            java.lang.String r8 = ""
            goto L_0x0037
        L_0x0007:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 91
            r0.append(r1)
            int r1 = r8.length
            r2 = 0
        L_0x0013:
            if (r2 >= r1) goto L_0x0029
            r3 = r8[r2]
            int r4 = r0.length()
            r5 = 1
            if (r4 <= r5) goto L_0x0023
            java.lang.String r4 = ","
            r0.append(r4)
        L_0x0023:
            r0.append(r3)
            int r2 = r2 + 1
            goto L_0x0013
        L_0x0029:
            r8 = 93
            r0.append(r8)
            r8 = 32
            r0.append(r8)
            java.lang.String r8 = r0.toString()
        L_0x0037:
            r6.<init>((java.lang.String) r7, (java.lang.String) r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vy.<init>(java.lang.String, java.lang.String[]):void");
    }

    private vy(String str, String str2) {
        this.b = str2;
        this.f5421a = str;
        this.f5422a = new qp(str);
        int i = 2;
        while (7 >= i && !Log.isLoggable(this.f5421a, i)) {
            i++;
        }
        this.a = i;
    }

    public boolean e(int i) {
        return this.a <= i;
    }

    public void f(String str, Object... objArr) {
        if (e(2)) {
            Log.v(this.f5421a, c(str, objArr));
        }
    }

    public void d(String str, Object... objArr) {
        Log.i(this.f5421a, c(str, objArr));
    }

    public void b(String str, Object... objArr) {
        Log.e(this.f5421a, c(str, objArr));
    }

    public void a(String str, Throwable th, Object... objArr) {
        Log.e(this.f5421a, c(str, objArr), th);
    }

    public void g(String str, Throwable th, Object... objArr) {
        Log.wtf(this.f5421a, c(str, objArr), th);
    }

    public void h(Throwable th) {
        Log.wtf(this.f5421a, th);
    }

    private final String c(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.b.concat(str);
    }
}
