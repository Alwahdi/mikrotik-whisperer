package defpackage;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import cat.ereza.customactivityoncrash.activity.DefaultErrorActivity;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipFile;

/* renamed from: xd  reason: default package */
public abstract class xd {
    /* access modifiers changed from: private */
    public static Application a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public static WeakReference<Activity> f5735a = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public static final Deque<String> f5736a = new ArrayDeque(50);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public static w7 f5737a = new w7();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public static boolean f5738a = true;

    /* renamed from: xd$c */
    public interface c extends Serializable {
        void g();

        void n();

        void x();
    }

    public static void E(Context context) {
        if (context == null) {
            try {
                Log.e("CustomActivityOnCrash", "Install failed: context is null!");
            } catch (Throwable t) {
                Log.e("CustomActivityOnCrash", "An unknown error occurred while installing CustomActivityOnCrash, it may not have been properly initialized. Please report this as a bug if needed.", t);
            }
        } else {
            Thread.UncaughtExceptionHandler oldHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (oldHandler == null || !oldHandler.getClass().getName().startsWith("cat.ereza.customactivityoncrash")) {
                if (oldHandler != null && !oldHandler.getClass().getName().startsWith("com.android.internal.os")) {
                    Log.e("CustomActivityOnCrash", "IMPORTANT WARNING! You already have an UncaughtExceptionHandler, are you sure this is correct? If you use a custom UncaughtExceptionHandler, you must initialize it AFTER CustomActivityOnCrash! Installing anyway, but your original handler will not be called.");
                }
                a = (Application) context.getApplicationContext();
                Thread.setDefaultUncaughtExceptionHandler(new a(oldHandler));
                a.registerActivityLifecycleCallbacks(new b());
            } else {
                Log.e("CustomActivityOnCrash", "CustomActivityOnCrash was already installed, doing nothing!");
            }
            Log.i("CustomActivityOnCrash", "CustomActivityOnCrash has been installed.");
        }
    }

    /* renamed from: xd$a */
    static class a implements Thread.UncaughtExceptionHandler {
        final /* synthetic */ Thread.UncaughtExceptionHandler a;

        a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.a = uncaughtExceptionHandler;
        }

        public void uncaughtException(Thread thread, Throwable throwable) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
            if (xd.f5737a.F()) {
                Log.e("CustomActivityOnCrash", "App has crashed, executing CustomActivityOnCrash's UncaughtExceptionHandler", throwable);
                if (xd.D(xd.a)) {
                    Log.e("CustomActivityOnCrash", "App already crashed recently, not starting custom error activity because we could enter a restart loop. Are you sure that your app does not crash directly on init?", throwable);
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.a;
                    if (uncaughtExceptionHandler2 != null) {
                        uncaughtExceptionHandler2.uncaughtException(thread, throwable);
                        return;
                    }
                } else {
                    xd.K(xd.a, new Date().getTime());
                    Class<? extends Activity> errorActivityClass = xd.f5737a.A();
                    if (errorActivityClass == null) {
                        errorActivityClass = xd.B(xd.a);
                    }
                    if (xd.F(throwable, errorActivityClass)) {
                        Log.e("CustomActivityOnCrash", "Your application class or your error activity have crashed, the custom activity will not be launched!");
                        Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.a;
                        if (uncaughtExceptionHandler3 != null) {
                            uncaughtExceptionHandler3.uncaughtException(thread, throwable);
                            return;
                        }
                    } else if (xd.f5737a.z() == 1 || !xd.f5738a) {
                        Intent intent = new Intent(xd.a, errorActivityClass);
                        StringWriter sw = new StringWriter();
                        throwable.printStackTrace(new PrintWriter(sw));
                        String stackTraceString = sw.toString();
                        if (stackTraceString.length() > 131071) {
                            stackTraceString = stackTraceString.substring(0, 131071 - " [stack trace too large]".length()) + " [stack trace too large]";
                        }
                        intent.putExtra("cat.ereza.customactivityoncrash.EXTRA_STACK_TRACE", stackTraceString);
                        if (xd.f5737a.J()) {
                            StringBuilder activityLogStringBuilder = new StringBuilder();
                            while (!xd.f5736a.isEmpty()) {
                                activityLogStringBuilder.append((String) xd.f5736a.poll());
                            }
                            intent.putExtra("cat.ereza.customactivityoncrash.EXTRA_ACTIVITY_LOG", activityLogStringBuilder.toString());
                        }
                        if (xd.f5737a.I() && xd.f5737a.E() == null) {
                            xd.f5737a.K(xd.C(xd.a));
                        }
                        intent.putExtra("cat.ereza.customactivityoncrash.EXTRA_CONFIG", xd.f5737a);
                        intent.setFlags(268468224);
                        if (xd.f5737a.C() != null) {
                            xd.f5737a.C().g();
                        }
                        xd.a.startActivity(intent);
                    } else if (xd.f5737a.z() == 2 && (uncaughtExceptionHandler = this.a) != null) {
                        uncaughtExceptionHandler.uncaughtException(thread, throwable);
                        return;
                    }
                }
                Activity lastActivity = (Activity) xd.f5735a.get();
                if (lastActivity != null) {
                    lastActivity.finish();
                    xd.f5735a.clear();
                }
                xd.G();
                return;
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler4 = this.a;
            if (uncaughtExceptionHandler4 != null) {
                uncaughtExceptionHandler4.uncaughtException(thread, throwable);
            }
        }
    }

    /* renamed from: xd$b */
    static class b implements Application.ActivityLifecycleCallbacks {
        int a = 0;

        /* renamed from: a  reason: collision with other field name */
        final DateFormat f5739a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

        b() {
        }

        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            if (activity.getClass() != xd.f5737a.A()) {
                WeakReference unused = xd.f5735a = new WeakReference(activity);
            }
            if (xd.f5737a.J()) {
                Deque j = xd.f5736a;
                j.add(this.f5739a.format(new Date()) + ": " + activity.getClass().getSimpleName() + " created\n");
            }
        }

        public void onActivityStarted(Activity activity) {
            boolean z = true;
            int i = this.a + 1;
            this.a = i;
            if (i != 0) {
                z = false;
            }
            boolean unused = xd.f5738a = z;
        }

        public void onActivityResumed(Activity activity) {
            if (xd.f5737a.J()) {
                Deque j = xd.f5736a;
                j.add(this.f5739a.format(new Date()) + ": " + activity.getClass().getSimpleName() + " resumed\n");
            }
        }

        public void onActivityPaused(Activity activity) {
            if (xd.f5737a.J()) {
                Deque j = xd.f5736a;
                j.add(this.f5739a.format(new Date()) + ": " + activity.getClass().getSimpleName() + " paused\n");
            }
        }

        public void onActivityStopped(Activity activity) {
            boolean z = true;
            int i = this.a - 1;
            this.a = i;
            if (i != 0) {
                z = false;
            }
            boolean unused = xd.f5738a = z;
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (xd.f5737a.J()) {
                Deque j = xd.f5736a;
                j.add(this.f5739a.format(new Date()) + ": " + activity.getClass().getSimpleName() + " destroyed\n");
            }
        }
    }

    public static String z(Intent intent) {
        return intent.getStringExtra("cat.ereza.customactivityoncrash.EXTRA_STACK_TRACE");
    }

    public static w7 t(Intent intent) {
        w7 config = (w7) intent.getSerializableExtra("cat.ereza.customactivityoncrash.EXTRA_CONFIG");
        if (config.G() && z(intent) != null) {
            Log.e("CustomActivityOnCrash", "The previous app process crashed. This is the stack trace of the crash:\n" + z(intent));
        }
        return config;
    }

    public static String p(Intent intent) {
        return intent.getStringExtra("cat.ereza.customactivityoncrash.EXTRA_ACTIVITY_LOG");
    }

    public static String q(Context context, Intent intent) {
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        String buildDateAsString = r(context, dateFormat);
        String errorDetails = "" + "Build version: " + A(context) + " \n";
        if (buildDateAsString != null) {
            errorDetails = errorDetails + "Build date: " + buildDateAsString + " \n";
        }
        String errorDetails2 = (((errorDetails + "Current date: " + dateFormat.format(currentDate) + " \n") + "Device: " + u() + " \n \n") + "Stack trace:  \n") + z(intent);
        String activityLog = p(intent);
        if (activityLog == null) {
            return errorDetails2;
        }
        return (errorDetails2 + "\nUser actions: \n") + activityLog;
    }

    public static void I(Activity activity, Intent intent, w7 config) {
        intent.addFlags(270565376);
        if (intent.getComponent() != null) {
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
        }
        if (config.C() != null) {
            config.C().x();
        }
        activity.finish();
        activity.startActivity(intent);
        G();
    }

    public static void H(Activity activity, w7 config) {
        I(activity, new Intent(activity, config.E()), config);
    }

    public static void o(Activity activity, w7 config) {
        if (config.C() != null) {
            config.C().n();
        }
        activity.finish();
        G();
    }

    public static w7 s() {
        return f5737a;
    }

    public static void J(w7 config) {
        f5737a = config;
    }

    /* access modifiers changed from: private */
    public static boolean F(Throwable throwable, Class<? extends Activity> activityClass) {
        Throwable cause;
        do {
            for (StackTraceElement element : throwable.getStackTrace()) {
                if ((element.getClassName().equals("android.app.ActivityThread") && element.getMethodName().equals("handleBindApplication")) || element.getClassName().equals(activityClass.getName())) {
                    return true;
                }
            }
            cause = throwable.getCause();
            throwable = cause;
        } while (cause != null);
        return false;
    }

    private static String r(Context context, DateFormat dateFormat) {
        long buildDate;
        try {
            ZipFile zf = new ZipFile(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir);
            buildDate = zf.getEntry("classes.dex").getTime();
            zf.close();
        } catch (Exception e) {
            buildDate = 0;
        }
        if (buildDate > 312764400000L) {
            return dateFormat.format(new Date(buildDate));
        }
        return null;
    }

    private static String A(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            return "Unknown";
        }
    }

    private static String u() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return n(model);
        }
        return n(manufacturer) + " " + model;
    }

    private static String n(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char first = s.charAt(0);
        if (Character.isUpperCase(first)) {
            return s;
        }
        return Character.toUpperCase(first) + s.substring(1);
    }

    /* access modifiers changed from: private */
    public static Class<? extends Activity> C(Context context) {
        Class<? extends Activity> resolvedActivityClass = y(context);
        if (resolvedActivityClass == null) {
            return x(context);
        }
        return resolvedActivityClass;
    }

    private static Class<? extends Activity> y(Context context) {
        List<ResolveInfo> resolveInfos = context.getPackageManager().queryIntentActivities(new Intent().setAction("cat.ereza.customactivityoncrash.RESTART").setPackage(context.getPackageName()), 64);
        if (resolveInfos == null || resolveInfos.size() <= 0) {
            return null;
        }
        try {
            return Class.forName(resolveInfos.get(0).activityInfo.name);
        } catch (ClassNotFoundException e) {
            Log.e("CustomActivityOnCrash", "Failed when resolving the restart activity class via intent filter, stack trace follows!", e);
            return null;
        }
    }

    private static Class<? extends Activity> x(Context context) {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (intent == null || intent.getComponent() == null) {
            return null;
        }
        try {
            return Class.forName(intent.getComponent().getClassName());
        } catch (ClassNotFoundException e) {
            Log.e("CustomActivityOnCrash", "Failed when resolving the restart activity class via getLaunchIntentForPackage, stack trace follows!", e);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static Class<? extends Activity> B(Context context) {
        Class<? extends Activity> resolvedActivityClass = v(context);
        if (resolvedActivityClass == null) {
            return DefaultErrorActivity.class;
        }
        return resolvedActivityClass;
    }

    private static Class<? extends Activity> v(Context context) {
        List<ResolveInfo> resolveInfos = context.getPackageManager().queryIntentActivities(new Intent().setAction("cat.ereza.customactivityoncrash.ERROR").setPackage(context.getPackageName()), 64);
        if (resolveInfos == null || resolveInfos.size() <= 0) {
            return null;
        }
        try {
            return Class.forName(resolveInfos.get(0).activityInfo.name);
        } catch (ClassNotFoundException e) {
            Log.e("CustomActivityOnCrash", "Failed when resolving the error activity class via intent filter, stack trace follows!", e);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void G() {
        Process.killProcess(Process.myPid());
        System.exit(10);
    }

    /* access modifiers changed from: private */
    public static void K(Context context, long timestamp) {
        context.getSharedPreferences("custom_activity_on_crash", 0).edit().putLong("last_crash_timestamp", timestamp).commit();
    }

    private static long w(Context context) {
        return context.getSharedPreferences("custom_activity_on_crash", 0).getLong("last_crash_timestamp", -1);
    }

    /* access modifiers changed from: private */
    public static boolean D(Context context) {
        long lastTimestamp = w(context);
        long currentTimestamp = new Date().getTime();
        return lastTimestamp <= currentTimestamp && currentTimestamp - lastTimestamp < ((long) f5737a.D());
    }
}
