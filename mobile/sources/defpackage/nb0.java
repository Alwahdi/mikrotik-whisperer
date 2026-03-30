package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import java.lang.reflect.Method;

/* renamed from: nb0  reason: default package */
public abstract class nb0 {
    private static final Object a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static Method f4422a = null;

    /* renamed from: a  reason: collision with other field name */
    private static final up f4423a = up.e();

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Exception} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Exception} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Exception} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r8) {
        /*
            java.lang.String r0 = "Context must not be null"
            defpackage.y90.k(r8, r0)
            up r0 = f4423a
            r1 = 11925000(0xb5f608, float:1.6710484E-38)
            r0.i(r8, r1)
            android.content.Context r0 = b(r8)
            if (r0 != 0) goto L_0x0017
            android.content.Context r0 = c(r8)
        L_0x0017:
            r1 = 8
            if (r0 == 0) goto L_0x0090
            java.lang.Object r2 = a
            monitor-enter(r2)
            java.lang.reflect.Method r3 = f4422a     // Catch:{ Exception -> 0x004c }
            r4 = 0
            r5 = 1
            if (r3 != 0) goto L_0x003d
            java.lang.ClassLoader r3 = r0.getClassLoader()     // Catch:{ Exception -> 0x004c }
            java.lang.String r6 = "com.google.android.gms.common.security.ProviderInstallerImpl"
            java.lang.Class r3 = r3.loadClass(r6)     // Catch:{ Exception -> 0x004c }
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x004c }
            java.lang.Class<android.content.Context> r7 = android.content.Context.class
            r6[r4] = r7     // Catch:{ Exception -> 0x004c }
            java.lang.String r7 = "insertProvider"
            java.lang.reflect.Method r3 = r3.getMethod(r7, r6)     // Catch:{ Exception -> 0x004c }
            f4422a = r3     // Catch:{ Exception -> 0x004c }
        L_0x003d:
            java.lang.reflect.Method r3 = f4422a     // Catch:{ Exception -> 0x004c }
            r6 = 0
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x004c }
            r5[r4] = r0     // Catch:{ Exception -> 0x004c }
            r3.invoke(r6, r5)     // Catch:{ Exception -> 0x004c }
            monitor-exit(r2)     // Catch:{ all -> 0x004a }
            return
        L_0x004a:
            r8 = move-exception
            goto L_0x008e
        L_0x004c:
            r0 = move-exception
            java.lang.Throwable r3 = r0.getCause()     // Catch:{ all -> 0x004a }
            java.lang.String r4 = "ProviderInstaller"
            r5 = 6
            boolean r4 = android.util.Log.isLoggable(r4, r5)     // Catch:{ all -> 0x004a }
            if (r4 == 0) goto L_0x0080
            if (r3 != 0) goto L_0x0061
            java.lang.String r4 = r0.getMessage()     // Catch:{ all -> 0x004a }
            goto L_0x0065
        L_0x0061:
            java.lang.String r4 = r3.getMessage()     // Catch:{ all -> 0x004a }
        L_0x0065:
            java.lang.String r5 = "ProviderInstaller"
            java.lang.String r6 = "Failed to install provider: "
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x004a }
            int r7 = r4.length()     // Catch:{ all -> 0x004a }
            if (r7 == 0) goto L_0x0078
            java.lang.String r4 = r6.concat(r4)     // Catch:{ all -> 0x004a }
            goto L_0x007d
        L_0x0078:
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x004a }
            r4.<init>(r6)     // Catch:{ all -> 0x004a }
        L_0x007d:
            android.util.Log.e(r5, r4)     // Catch:{ all -> 0x004a }
        L_0x0080:
            if (r3 != 0) goto L_0x0084
            goto L_0x0085
        L_0x0084:
            r0 = r3
        L_0x0085:
            defpackage.qd.a(r8, r0)     // Catch:{ all -> 0x004a }
            xp r8 = new xp     // Catch:{ all -> 0x004a }
            r8.<init>(r1)     // Catch:{ all -> 0x004a }
            throw r8     // Catch:{ all -> 0x004a }
        L_0x008e:
            monitor-exit(r2)     // Catch:{ all -> 0x004a }
            throw r8
        L_0x0090:
            java.lang.String r8 = "ProviderInstaller"
            java.lang.String r0 = "Failed to get remote context"
            android.util.Log.e(r8, r0)
            xp r8 = new xp
            r8.<init>(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nb0.a(android.content.Context):void");
    }

    private static Context b(Context context) {
        try {
            return DynamiteModule.d(context, DynamiteModule.d, "providerinstaller").b();
        } catch (DynamiteModule.a e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("ProviderInstaller", valueOf.length() != 0 ? "Failed to load providerinstaller module: ".concat(valueOf) : new String("Failed to load providerinstaller module: "));
            return null;
        }
    }

    private static Context c(Context context) {
        try {
            return aq.c(context);
        } catch (Resources.NotFoundException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("ProviderInstaller", valueOf.length() != 0 ? "Failed to load GMS Core context for providerinstaller: ".concat(valueOf) : new String("Failed to load GMS Core context for providerinstaller: "));
            qd.a(context, e);
            return null;
        }
    }
}
