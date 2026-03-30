package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: zv0  reason: default package */
public abstract class zv0 {
    private static final int a = Process.myUid();

    /* renamed from: a  reason: collision with other field name */
    private static final Method f6051a = l();
    private static final Method b = m();
    private static final Method c = n();
    private static final Method d = h();
    private static final Method e = i();
    private static final Method f = j();
    private static final Method g = k();

    private static WorkSource e(int i, String str) {
        WorkSource workSource = new WorkSource();
        g(workSource, i, str);
        return workSource;
    }

    public static WorkSource a(Context context, String str) {
        if (context == null || context.getPackageManager() == null || str == null) {
            return null;
        }
        try {
            ApplicationInfo b2 = aw0.a(context).b(str, 0);
            if (b2 != null) {
                return e(b2.uid, str);
            }
            String valueOf = String.valueOf(str);
            Log.e("WorkSourceUtil", valueOf.length() != 0 ? "Could not get applicationInfo from package: ".concat(valueOf) : new String("Could not get applicationInfo from package: "));
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            String valueOf2 = String.valueOf(str);
            Log.e("WorkSourceUtil", valueOf2.length() != 0 ? "Could not find package: ".concat(valueOf2) : new String("Could not find package: "));
            return null;
        }
    }

    private static void g(WorkSource workSource, int i, String str) {
        Method method = b;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, new Object[]{Integer.valueOf(i), str});
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        } else {
            Method method2 = f6051a;
            if (method2 != null) {
                try {
                    method2.invoke(workSource, new Object[]{Integer.valueOf(i)});
                } catch (Exception e3) {
                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e3);
                }
            }
        }
    }

    private static int d(WorkSource workSource) {
        Method method = c;
        if (method != null) {
            try {
                return ((Integer) method.invoke(workSource, new Object[0])).intValue();
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        }
        return 0;
    }

    private static String f(WorkSource workSource, int i) {
        Method method = e;
        if (method == null) {
            return null;
        }
        try {
            return (String) method.invoke(workSource, new Object[]{Integer.valueOf(i)});
        } catch (Exception e2) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            return null;
        }
    }

    public static List<String> b(WorkSource workSource) {
        int d2 = workSource == null ? 0 : d(workSource);
        if (d2 == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < d2; i++) {
            String f2 = f(workSource, i);
            if (!tn0.b(f2)) {
                arrayList.add(f2);
            }
        }
        return arrayList;
    }

    public static boolean c(Context context) {
        if (context == null || context.getPackageManager() == null || aw0.a(context).a("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    private static Method l() {
        try {
            return WorkSource.class.getMethod("add", new Class[]{Integer.TYPE});
        } catch (Exception e2) {
            return null;
        }
    }

    private static Method m() {
        if (n90.d()) {
            try {
                return WorkSource.class.getMethod("add", new Class[]{Integer.TYPE, String.class});
            } catch (Exception e2) {
            }
        }
        return null;
    }

    private static Method n() {
        try {
            return WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception e2) {
            return null;
        }
    }

    private static Method h() {
        try {
            return WorkSource.class.getMethod("get", new Class[]{Integer.TYPE});
        } catch (Exception e2) {
            return null;
        }
    }

    private static Method i() {
        if (n90.d()) {
            try {
                return WorkSource.class.getMethod("getName", new Class[]{Integer.TYPE});
            } catch (Exception e2) {
            }
        }
        return null;
    }

    private static final Method j() {
        if (n90.i()) {
            try {
                return WorkSource.class.getMethod("createWorkChain", new Class[0]);
            } catch (Exception e2) {
                Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", e2);
            }
        }
        return null;
    }

    private static final Method k() {
        if (n90.i()) {
            try {
                return Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", new Class[]{Integer.TYPE, String.class});
            } catch (Exception e2) {
                Log.w("WorkSourceUtil", "Missing WorkChain class", e2);
            }
        }
        return null;
    }
}
