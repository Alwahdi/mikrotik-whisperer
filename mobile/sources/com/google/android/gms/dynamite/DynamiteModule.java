package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.util.DynamiteApi;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public final class DynamiteModule {
    private static int a = -1;

    /* renamed from: a  reason: collision with other field name */
    private static final b.a f1396a = new a();

    /* renamed from: a  reason: collision with other field name */
    public static final b f1397a = new b();

    /* renamed from: a  reason: collision with other field name */
    private static Boolean f1398a;

    /* renamed from: a  reason: collision with other field name */
    private static String f1399a;

    /* renamed from: a  reason: collision with other field name */
    private static final ThreadLocal<c> f1400a = new ThreadLocal<>();

    /* renamed from: a  reason: collision with other field name */
    private static o81 f1401a;

    /* renamed from: a  reason: collision with other field name */
    private static x71 f1402a;
    public static final b b = new c();
    public static final b c = new d();
    public static final b d = new e();
    public static final b e = new f();
    private static final b f = new g();

    /* renamed from: a  reason: collision with other field name */
    private final Context f1403a;

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    public interface b {

        public interface a {
            int a(Context context, String str);

            int b(Context context, String str, boolean z);
        }

        /* renamed from: com.google.android.gms.dynamite.DynamiteModule$b$b  reason: collision with other inner class name */
        public static class C0010b {
            public int a = 0;
            public int b = 0;
            public int c = 0;
        }

        C0010b a(Context context, String str, a aVar);
    }

    private static class c {
        public Cursor a;

        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    public static DynamiteModule d(Context context, b bVar, String str) {
        b.C0010b a2;
        ThreadLocal<c> threadLocal = f1400a;
        c cVar = threadLocal.get();
        c cVar2 = new c((a) null);
        threadLocal.set(cVar2);
        try {
            a2 = bVar.a(context, str, f1396a);
            int i = a2.a;
            int i2 = a2.b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length());
            sb.append("Considering local module ");
            sb.append(str);
            sb.append(":");
            sb.append(i);
            sb.append(" and remote module ");
            sb.append(str);
            sb.append(":");
            sb.append(i2);
            Log.i("DynamiteModule", sb.toString());
            int i3 = a2.c;
            if (i3 == 0 || ((i3 == -1 && a2.a == 0) || (i3 == 1 && a2.b == 0))) {
                int i4 = a2.a;
                int i5 = a2.b;
                StringBuilder sb2 = new StringBuilder(91);
                sb2.append("No acceptable module found. Local version is ");
                sb2.append(i4);
                sb2.append(" and remote version is ");
                sb2.append(i5);
                sb2.append(".");
                throw new a(sb2.toString(), (a) null);
            } else if (i3 == -1) {
                DynamiteModule l = l(context, str);
                Cursor cursor = cVar2.a;
                if (cursor != null) {
                    cursor.close();
                }
                threadLocal.set(cVar);
                return l;
            } else if (i3 == 1) {
                DynamiteModule f2 = f(context, str, a2.b);
                Cursor cursor2 = cVar2.a;
                if (cursor2 != null) {
                    cursor2.close();
                }
                threadLocal.set(cVar);
                return f2;
            } else {
                int i6 = a2.c;
                StringBuilder sb3 = new StringBuilder(47);
                sb3.append("VersionPolicy returned invalid code:");
                sb3.append(i6);
                throw new a(sb3.toString(), (a) null);
            }
        } catch (a e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to load remote module: ".concat(valueOf) : new String("Failed to load remote module: "));
            int i7 = a2.a;
            if (i7 == 0 || bVar.a(context, str, new d(i7, 0)).c != -1) {
                throw new a("Remote load failed. No local fallback found.", e2, (a) null);
            }
            DynamiteModule l2 = l(context, str);
            Cursor cursor3 = cVar2.a;
            if (cursor3 != null) {
                cursor3.close();
            }
            f1400a.set(cVar);
            return l2;
        } catch (Throwable th) {
            Cursor cursor4 = cVar2.a;
            if (cursor4 != null) {
                cursor4.close();
            }
            f1400a.set(cVar);
            throw th;
        }
    }

    public static class a extends Exception {
        private a(String str) {
            super(str);
        }

        private a(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ a(String str, a aVar) {
            this(str);
        }

        /* synthetic */ a(String str, Throwable th, a aVar) {
            this(str, th);
        }
    }

    private static class d implements b.a {
        private final int a;
        private final int b = 0;

        public d(int i, int i2) {
            this.a = i;
        }

        public final int b(Context context, String str, boolean z) {
            return 0;
        }

        public final int a(Context context, String str) {
            return this.a;
        }
    }

    public static int a(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get((Object) null).equals(str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf = String.valueOf(declaredField.get((Object) null));
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(str).length());
            sb2.append("Module descriptor id '");
            sb2.append(valueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e("DynamiteModule", sb2.toString());
            return 0;
        } catch (ClassNotFoundException e2) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e3) {
            String valueOf2 = String.valueOf(e3.getMessage());
            Log.e("DynamiteModule", valueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x0037=Splitter:B:19:0x0037, B:36:0x007c=Splitter:B:36:0x007c} */
    public static int e(android.content.Context r8, java.lang.String r9, boolean r10) {
        /*
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r0 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r0)     // Catch:{ all -> 0x00f2 }
            java.lang.Boolean r1 = f1398a     // Catch:{ all -> 0x00ef }
            if (r1 != 0) goto L_0x00bc
            android.content.Context r1 = r8.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x0093, IllegalAccessException -> 0x0091, NoSuchFieldException -> 0x008f }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0093, IllegalAccessException -> 0x0091, NoSuchFieldException -> 0x008f }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r2 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r2 = r2.getName()     // Catch:{ ClassNotFoundException -> 0x0093, IllegalAccessException -> 0x0091, NoSuchFieldException -> 0x008f }
            java.lang.Class r1 = r1.loadClass(r2)     // Catch:{ ClassNotFoundException -> 0x0093, IllegalAccessException -> 0x0091, NoSuchFieldException -> 0x008f }
            java.lang.String r2 = "sClassLoader"
            java.lang.reflect.Field r2 = r1.getDeclaredField(r2)     // Catch:{ ClassNotFoundException -> 0x0093, IllegalAccessException -> 0x0091, NoSuchFieldException -> 0x008f }
            monitor-enter(r1)     // Catch:{ ClassNotFoundException -> 0x0093, IllegalAccessException -> 0x0091, NoSuchFieldException -> 0x008f }
            r3 = 0
            java.lang.Object r4 = r2.get(r3)     // Catch:{ all -> 0x008c }
            java.lang.ClassLoader r4 = (java.lang.ClassLoader) r4     // Catch:{ all -> 0x008c }
            if (r4 == 0) goto L_0x003a
            java.lang.ClassLoader r2 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x008c }
            if (r4 != r2) goto L_0x0032
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x008c }
            goto L_0x0089
        L_0x0032:
            g(r4)     // Catch:{ a -> 0x0036 }
            goto L_0x0037
        L_0x0036:
            r2 = move-exception
        L_0x0037:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x008c }
            goto L_0x0089
        L_0x003a:
            java.lang.String r4 = "com.google.android.gms"
            android.content.Context r5 = r8.getApplicationContext()     // Catch:{ all -> 0x008c }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ all -> 0x008c }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x008c }
            if (r4 == 0) goto L_0x0054
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x008c }
            r2.set(r3, r4)     // Catch:{ all -> 0x008c }
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x008c }
            goto L_0x0089
        L_0x0054:
            int r4 = k(r8, r9, r10)     // Catch:{ a -> 0x007f }
            java.lang.String r5 = f1399a     // Catch:{ a -> 0x007f }
            if (r5 == 0) goto L_0x007c
            boolean r5 = r5.isEmpty()     // Catch:{ a -> 0x007f }
            if (r5 == 0) goto L_0x0063
            goto L_0x007c
        L_0x0063:
            com.google.android.gms.dynamite.h r5 = new com.google.android.gms.dynamite.h     // Catch:{ a -> 0x007f }
            java.lang.String r6 = f1399a     // Catch:{ a -> 0x007f }
            java.lang.ClassLoader r7 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ a -> 0x007f }
            r5.<init>(r6, r7)     // Catch:{ a -> 0x007f }
            g(r5)     // Catch:{ a -> 0x007f }
            r2.set(r3, r5)     // Catch:{ a -> 0x007f }
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ a -> 0x007f }
            f1398a = r5     // Catch:{ a -> 0x007f }
            monitor-exit(r1)     // Catch:{ all -> 0x008c }
            monitor-exit(r0)     // Catch:{ all -> 0x00ef }
            return r4
        L_0x007c:
            monitor-exit(r1)     // Catch:{ all -> 0x008c }
            monitor-exit(r0)     // Catch:{ all -> 0x00ef }
            return r4
        L_0x007f:
            r4 = move-exception
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x008c }
            r2.set(r3, r4)     // Catch:{ all -> 0x008c }
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x008c }
        L_0x0089:
            monitor-exit(r1)     // Catch:{ all -> 0x008c }
            r1 = r2
            goto L_0x00ba
        L_0x008c:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x008c }
            throw r2     // Catch:{ ClassNotFoundException -> 0x0093, IllegalAccessException -> 0x0091, NoSuchFieldException -> 0x008f }
        L_0x008f:
            r1 = move-exception
            goto L_0x0094
        L_0x0091:
            r1 = move-exception
            goto L_0x0094
        L_0x0093:
            r1 = move-exception
        L_0x0094:
            java.lang.String r2 = "DynamiteModule"
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00ef }
            java.lang.String r3 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00ef }
            int r3 = r3.length()     // Catch:{ all -> 0x00ef }
            int r3 = r3 + 30
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ef }
            r4.<init>(r3)     // Catch:{ all -> 0x00ef }
            java.lang.String r3 = "Failed to load module via V2: "
            r4.append(r3)     // Catch:{ all -> 0x00ef }
            r4.append(r1)     // Catch:{ all -> 0x00ef }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x00ef }
            android.util.Log.w(r2, r1)     // Catch:{ all -> 0x00ef }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00ef }
        L_0x00ba:
            f1398a = r1     // Catch:{ all -> 0x00ef }
        L_0x00bc:
            monitor-exit(r0)     // Catch:{ all -> 0x00ef }
            boolean r0 = r1.booleanValue()     // Catch:{ all -> 0x00f2 }
            if (r0 == 0) goto L_0x00ea
            int r8 = k(r8, r9, r10)     // Catch:{ a -> 0x00c8 }
            return r8
        L_0x00c8:
            r9 = move-exception
            java.lang.String r10 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version: "
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x00f2 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x00f2 }
            int r1 = r9.length()     // Catch:{ all -> 0x00f2 }
            if (r1 == 0) goto L_0x00e0
            java.lang.String r9 = r0.concat(r9)     // Catch:{ all -> 0x00f2 }
            goto L_0x00e5
        L_0x00e0:
            java.lang.String r9 = new java.lang.String     // Catch:{ all -> 0x00f2 }
            r9.<init>(r0)     // Catch:{ all -> 0x00f2 }
        L_0x00e5:
            android.util.Log.w(r10, r9)     // Catch:{ all -> 0x00f2 }
            r8 = 0
            return r8
        L_0x00ea:
            int r8 = i(r8, r9, r10)     // Catch:{ all -> 0x00f2 }
            return r8
        L_0x00ef:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00ef }
            throw r9     // Catch:{ all -> 0x00f2 }
        L_0x00f2:
            r9 = move-exception
            defpackage.qd.a(r8, r9)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.e(android.content.Context, java.lang.String, boolean):int");
    }

    private static int i(Context context, String str, boolean z) {
        x71 m = m(context);
        if (m == null) {
            return 0;
        }
        try {
            if (m.C() >= 2) {
                return m.V(d40.h0(context), str, z);
            }
            Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
            return m.e(d40.h0(context), str, z);
        } catch (RemoteException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int k(android.content.Context r8, java.lang.String r9, boolean r10) {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            if (r10 == 0) goto L_0x000d
            java.lang.String r8 = "api_force_staging"
            goto L_0x000f
        L_0x000d:
            java.lang.String r8 = "api"
        L_0x000f:
            java.lang.String r10 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            int r10 = r10.length()     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            int r10 = r10 + 42
            java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            int r2 = r2.length()     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            int r10 = r10 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r2.<init>(r10)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            java.lang.String r10 = "content://com.google.android.gms.chimera/"
            r2.append(r10)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r2.append(r8)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            java.lang.String r8 = "/"
            r2.append(r8)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r2.append(r9)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            java.lang.String r8 = r2.toString()     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            android.net.Uri r2 = android.net.Uri.parse(r8)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            if (r8 == 0) goto L_0x008b
            boolean r9 = r8.moveToFirst()     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            if (r9 == 0) goto L_0x008b
            r9 = 0
            int r9 = r8.getInt(r9)     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            if (r9 <= 0) goto L_0x0084
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r10 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r10)     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            r1 = 2
            java.lang.String r1 = r8.getString(r1)     // Catch:{ all -> 0x0081 }
            f1399a = r1     // Catch:{ all -> 0x0081 }
            java.lang.String r1 = "loaderVersion"
            int r1 = r8.getColumnIndex(r1)     // Catch:{ all -> 0x0081 }
            if (r1 < 0) goto L_0x006f
            int r1 = r8.getInt(r1)     // Catch:{ all -> 0x0081 }
            a = r1     // Catch:{ all -> 0x0081 }
        L_0x006f:
            monitor-exit(r10)     // Catch:{ all -> 0x0081 }
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$c> r10 = f1400a     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            java.lang.Object r10 = r10.get()     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            com.google.android.gms.dynamite.DynamiteModule$c r10 = (com.google.android.gms.dynamite.DynamiteModule.c) r10     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            if (r10 == 0) goto L_0x0084
            android.database.Cursor r1 = r10.a     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            if (r1 != 0) goto L_0x0084
            r10.a = r8     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            goto L_0x0085
        L_0x0081:
            r9 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0081 }
            throw r9     // Catch:{ Exception -> 0x009e, all -> 0x009a }
        L_0x0084:
            r0 = r8
        L_0x0085:
            if (r0 == 0) goto L_0x008a
            r0.close()
        L_0x008a:
            return r9
        L_0x008b:
            java.lang.String r9 = "DynamiteModule"
            java.lang.String r10 = "Failed to retrieve remote module version."
            android.util.Log.w(r9, r10)     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            com.google.android.gms.dynamite.DynamiteModule$a r9 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            java.lang.String r10 = "Failed to connect to dynamite module ContentResolver."
            r9.<init>((java.lang.String) r10, (com.google.android.gms.dynamite.a) r0)     // Catch:{ Exception -> 0x009e, all -> 0x009a }
            throw r9     // Catch:{ Exception -> 0x009e, all -> 0x009a }
        L_0x009a:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto L_0x00b6
        L_0x009e:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L_0x00a7
        L_0x00a3:
            r8 = move-exception
            goto L_0x00b6
        L_0x00a5:
            r8 = move-exception
            r9 = r0
        L_0x00a7:
            boolean r10 = r8 instanceof com.google.android.gms.dynamite.DynamiteModule.a     // Catch:{ all -> 0x00b4 }
            if (r10 == 0) goto L_0x00ac
            throw r8     // Catch:{ all -> 0x00b4 }
        L_0x00ac:
            com.google.android.gms.dynamite.DynamiteModule$a r10 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch:{ all -> 0x00b4 }
            java.lang.String r1 = "V2 version check failed"
            r10.<init>(r1, r8, r0)     // Catch:{ all -> 0x00b4 }
            throw r10     // Catch:{ all -> 0x00b4 }
        L_0x00b4:
            r8 = move-exception
            r0 = r9
        L_0x00b6:
            if (r0 == 0) goto L_0x00bb
            r0.close()
        L_0x00bb:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.k(android.content.Context, java.lang.String, boolean):int");
    }

    public static int c(Context context, String str) {
        return e(context, str, false);
    }

    private static DynamiteModule l(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static DynamiteModule f(Context context, String str, int i) {
        Boolean bool;
        kr krVar;
        try {
            synchronized (DynamiteModule.class) {
                bool = f1398a;
            }
            if (bool == null) {
                throw new a("Failed to determine which loading route to use.", (a) null);
            } else if (bool.booleanValue()) {
                return j(context, str, i);
            } else {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
                sb.append("Selected remote version of ");
                sb.append(str);
                sb.append(", version >= ");
                sb.append(i);
                Log.i("DynamiteModule", sb.toString());
                x71 m = m(context);
                if (m != null) {
                    if (m.C() >= 2) {
                        krVar = m.d0(d40.h0(context), str, i);
                    } else {
                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                        krVar = m.O(d40.h0(context), str, i);
                    }
                    if (d40.c(krVar) != null) {
                        return new DynamiteModule((Context) d40.c(krVar));
                    }
                    throw new a("Failed to load remote module.", (a) null);
                }
                throw new a("Failed to create IDynamiteLoader.", (a) null);
            }
        } catch (RemoteException e2) {
            throw new a("Failed to load remote module.", e2, (a) null);
        } catch (a e3) {
            throw e3;
        } catch (Throwable th) {
            qd.a(context, th);
            throw new a("Failed to load remote module.", th, (a) null);
        }
    }

    private static x71 m(Context context) {
        x71 x71;
        synchronized (DynamiteModule.class) {
            x71 x712 = f1402a;
            if (x712 != null) {
                return x712;
            }
            if (up.e().f(context) != 0) {
                return null;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    x71 = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (queryLocalInterface instanceof x71) {
                        x71 = (x71) queryLocalInterface;
                    } else {
                        x71 = new i(iBinder);
                    }
                }
                if (x71 != null) {
                    f1402a = x71;
                    return x71;
                }
            } catch (Exception e2) {
                String valueOf = String.valueOf(e2.getMessage());
                Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
            }
        }
        return null;
    }

    public final Context b() {
        return this.f1403a;
    }

    private static DynamiteModule j(Context context, String str, int i) {
        o81 o81;
        kr krVar;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i);
        Log.i("DynamiteModule", sb.toString());
        synchronized (DynamiteModule.class) {
            o81 = f1401a;
        }
        if (o81 != null) {
            c cVar = f1400a.get();
            if (cVar == null || cVar.a == null) {
                throw new a("No result cursor", (a) null);
            }
            Context applicationContext = context.getApplicationContext();
            Cursor cursor = cVar.a;
            d40.h0(null);
            if (h().booleanValue()) {
                Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                krVar = o81.B(d40.h0(applicationContext), str, i, d40.h0(cursor));
            } else {
                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                krVar = o81.n(d40.h0(applicationContext), str, i, d40.h0(cursor));
            }
            Context context2 = (Context) d40.c(krVar);
            if (context2 != null) {
                return new DynamiteModule(context2);
            }
            throw new a("Failed to get module context", (a) null);
        }
        throw new a("DynamiteLoaderV2 was not cached.", (a) null);
    }

    private static Boolean h() {
        Boolean valueOf;
        synchronized (DynamiteModule.class) {
            valueOf = Boolean.valueOf(a >= 2);
        }
        return valueOf;
    }

    private static void g(ClassLoader classLoader) {
        o81 o81;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                o81 = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof o81) {
                    o81 = (o81) queryLocalInterface;
                } else {
                    o81 = new j(iBinder);
                }
            }
            f1401a = o81;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new a("Failed to instantiate dynamite loader", e2, (a) null);
        }
    }

    private DynamiteModule(Context context) {
        this.f1403a = (Context) y90.j(context);
    }
}
