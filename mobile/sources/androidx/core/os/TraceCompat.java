package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

@Deprecated
public final class TraceCompat {
    private static final String TAG = "TraceCompat";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    static {
        Class<String> cls = String.class;
        int i = Build.VERSION.SDK_INT;
        if (i >= 18 && i < 29) {
            try {
                sTraceTagApp = Trace.class.getField("TRACE_TAG_APP").getLong((Object) null);
                Class cls2 = Long.TYPE;
                sIsTagEnabledMethod = Trace.class.getMethod("isTagEnabled", new Class[]{cls2});
                Class cls3 = Integer.TYPE;
                sAsyncTraceBeginMethod = Trace.class.getMethod("asyncTraceBegin", new Class[]{cls2, cls, cls3});
                sAsyncTraceEndMethod = Trace.class.getMethod("asyncTraceEnd", new Class[]{cls2, cls, cls3});
                sTraceCounterMethod = Trace.class.getMethod("traceCounter", new Class[]{cls2, cls, cls3});
            } catch (Exception e) {
                Log.i(TAG, "Unable to initialize via reflection.", e);
            }
        }
    }

    public static boolean isEnabled() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            return Api29Impl.isEnabled();
        }
        if (i >= 18) {
            try {
                return ((Boolean) sIsTagEnabledMethod.invoke((Object) null, new Object[]{Long.valueOf(sTraceTagApp)})).booleanValue();
            } catch (Exception e) {
                Log.v(TAG, "Unable to invoke isTagEnabled() via reflection.");
            }
        }
        return false;
    }

    public static void beginSection(@NonNull String sectionName) {
        if (Build.VERSION.SDK_INT >= 18) {
            Api18Impl.beginSection(sectionName);
        }
    }

    public static void endSection() {
        if (Build.VERSION.SDK_INT >= 18) {
            Api18Impl.endSection();
        }
    }

    public static void beginAsyncSection(@NonNull String methodName, int cookie) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            Api29Impl.beginAsyncSection(methodName, cookie);
        } else if (i >= 18) {
            try {
                sAsyncTraceBeginMethod.invoke((Object) null, new Object[]{Long.valueOf(sTraceTagApp), methodName, Integer.valueOf(cookie)});
            } catch (Exception e) {
                Log.v(TAG, "Unable to invoke asyncTraceBegin() via reflection.");
            }
        }
    }

    public static void endAsyncSection(@NonNull String methodName, int cookie) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            Api29Impl.endAsyncSection(methodName, cookie);
        } else if (i >= 18) {
            try {
                sAsyncTraceEndMethod.invoke((Object) null, new Object[]{Long.valueOf(sTraceTagApp), methodName, Integer.valueOf(cookie)});
            } catch (Exception e) {
                Log.v(TAG, "Unable to invoke endAsyncSection() via reflection.");
            }
        }
    }

    public static void setCounter(@NonNull String counterName, int counterValue) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            Api29Impl.setCounter(counterName, (long) counterValue);
        } else if (i >= 18) {
            try {
                sTraceCounterMethod.invoke((Object) null, new Object[]{Long.valueOf(sTraceTagApp), counterName, Integer.valueOf(counterValue)});
            } catch (Exception e) {
                Log.v(TAG, "Unable to invoke traceCounter() via reflection.");
            }
        }
    }

    private TraceCompat() {
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static boolean isEnabled() {
            return Trace.isEnabled();
        }

        @DoNotInline
        static void endAsyncSection(String methodName, int cookie) {
            Trace.endAsyncSection(methodName, cookie);
        }

        @DoNotInline
        static void beginAsyncSection(String methodName, int cookie) {
            Trace.beginAsyncSection(methodName, cookie);
        }

        @DoNotInline
        static void setCounter(String counterName, long counterValue) {
            Trace.setCounter(counterName, counterValue);
        }
    }

    @RequiresApi(18)
    static class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        static void beginSection(String sectionName) {
            Trace.beginSection(sectionName);
        }

        @DoNotInline
        static void endSection() {
            Trace.endSection();
        }
    }
}
