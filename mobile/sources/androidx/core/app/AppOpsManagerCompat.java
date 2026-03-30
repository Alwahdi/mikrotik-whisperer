package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public final class AppOpsManagerCompat {
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_ERRORED = 2;
    public static final int MODE_IGNORED = 1;

    private AppOpsManagerCompat() {
    }

    @Nullable
    public static String permissionToOp(@NonNull String permission) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.permissionToOp(permission);
        }
        return null;
    }

    public static int noteOp(@NonNull Context context, @NonNull String op, int uid, @NonNull String packageName) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Api19Impl.noteOp((AppOpsManager) context.getSystemService("appops"), op, uid, packageName);
        }
        return 1;
    }

    public static int noteOpNoThrow(@NonNull Context context, @NonNull String op, int uid, @NonNull String packageName) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Api19Impl.noteOpNoThrow((AppOpsManager) context.getSystemService("appops"), op, uid, packageName);
        }
        return 1;
    }

    public static int noteProxyOp(@NonNull Context context, @NonNull String op, @NonNull String proxiedPackageName) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.noteProxyOp((AppOpsManager) Api23Impl.getSystemService(context, AppOpsManager.class), op, proxiedPackageName);
        }
        return 1;
    }

    public static int noteProxyOpNoThrow(@NonNull Context context, @NonNull String op, @NonNull String proxiedPackageName) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.noteProxyOpNoThrow((AppOpsManager) Api23Impl.getSystemService(context, AppOpsManager.class), op, proxiedPackageName);
        }
        return 1;
    }

    public static int checkOrNoteProxyOp(@NonNull Context context, int proxyUid, @NonNull String op, @NonNull String proxiedPackageName) {
        if (Build.VERSION.SDK_INT < 29) {
            return noteProxyOpNoThrow(context, op, proxiedPackageName);
        }
        AppOpsManager appOpsManager = Api29Impl.getSystemService(context);
        int checkProxiedOpResult = Api29Impl.checkOpNoThrow(appOpsManager, op, Binder.getCallingUid(), proxiedPackageName);
        if (checkProxiedOpResult != 0) {
            return checkProxiedOpResult;
        }
        return Api29Impl.checkOpNoThrow(appOpsManager, op, proxyUid, Api29Impl.getOpPackageName(context));
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        @Nullable
        static AppOpsManager getSystemService(@NonNull Context context) {
            return (AppOpsManager) context.getSystemService(AppOpsManager.class);
        }

        @DoNotInline
        static int checkOpNoThrow(@Nullable AppOpsManager appOpsManager, @NonNull String op, int uid, @NonNull String packageName) {
            if (appOpsManager == null) {
                return 1;
            }
            return appOpsManager.checkOpNoThrow(op, uid, packageName);
        }

        @DoNotInline
        @NonNull
        static String getOpPackageName(@NonNull Context context) {
            return context.getOpPackageName();
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static String permissionToOp(String permission) {
            return AppOpsManager.permissionToOp(permission);
        }

        @DoNotInline
        static <T> T getSystemService(Context context, Class<T> serviceClass) {
            return context.getSystemService(serviceClass);
        }

        @DoNotInline
        static int noteProxyOp(AppOpsManager appOpsManager, String op, String proxiedPackageName) {
            return appOpsManager.noteProxyOp(op, proxiedPackageName);
        }

        @DoNotInline
        static int noteProxyOpNoThrow(AppOpsManager appOpsManager, String op, String proxiedPackageName) {
            return appOpsManager.noteProxyOpNoThrow(op, proxiedPackageName);
        }
    }

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static int noteOpNoThrow(AppOpsManager appOpsManager, String op, int uid, String packageName) {
            return appOpsManager.noteOpNoThrow(op, uid, packageName);
        }

        @DoNotInline
        static int noteOp(AppOpsManager appOpsManager, String op, int uid, String packageName) {
            return appOpsManager.noteOp(op, uid, packageName);
        }
    }
}
