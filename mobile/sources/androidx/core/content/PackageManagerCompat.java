package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.os.UserManagerCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;
import java.util.concurrent.Executors;

public final class PackageManagerCompat {
    public static final String ACTION_PERMISSION_REVOCATION_SETTINGS = "android.intent.action.AUTO_REVOKE_PERMISSIONS";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String LOG_TAG = "PackageManagerCompat";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface UnusedAppRestrictionsStatus {
    }

    private PackageManagerCompat() {
    }

    @NonNull
    public static ox<Integer> getUnusedAppRestrictionsStatus(@NonNull Context context) {
        ResolvableFuture<Integer> resultFuture = ResolvableFuture.create();
        if (!UserManagerCompat.isUserUnlocked(context)) {
            resultFuture.set(0);
            Log.e(LOG_TAG, "User is in locked direct boot mode");
            return resultFuture;
        } else if (!areUnusedAppRestrictionsAvailable(context.getPackageManager())) {
            resultFuture.set(1);
            return resultFuture;
        } else {
            int targetSdkVersion = context.getApplicationInfo().targetSdkVersion;
            if (targetSdkVersion < 30) {
                resultFuture.set(0);
                Log.e(LOG_TAG, "Target SDK version below API 30");
                return resultFuture;
            }
            int i = Build.VERSION.SDK_INT;
            int i2 = 4;
            if (i >= 31) {
                if (Api30Impl.areUnusedAppRestrictionsEnabled(context)) {
                    if (targetSdkVersion >= 31) {
                        i2 = 5;
                    }
                    resultFuture.set(Integer.valueOf(i2));
                } else {
                    resultFuture.set(2);
                }
                return resultFuture;
            } else if (i == 30) {
                if (!Api30Impl.areUnusedAppRestrictionsEnabled(context)) {
                    i2 = 2;
                }
                resultFuture.set(Integer.valueOf(i2));
                return resultFuture;
            } else {
                UnusedAppRestrictionsBackportServiceConnection backportServiceConnection = new UnusedAppRestrictionsBackportServiceConnection(context);
                Objects.requireNonNull(backportServiceConnection);
                resultFuture.addListener(new a(backportServiceConnection), Executors.newSingleThreadExecutor());
                backportServiceConnection.connectAndFetchResult(resultFuture);
                return resultFuture;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static boolean areUnusedAppRestrictionsAvailable(@NonNull PackageManager packageManager) {
        int i = Build.VERSION.SDK_INT;
        boolean restrictionsBuiltIntoOs = i >= 30;
        boolean isOsMThroughQ = i >= 23 && i < 30;
        boolean hasBackportFeature = getPermissionRevocationVerifierApp(packageManager) != null;
        if (restrictionsBuiltIntoOs) {
            return true;
        }
        if (!isOsMThroughQ || !hasBackportFeature) {
            return false;
        }
        return true;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static String getPermissionRevocationVerifierApp(@NonNull PackageManager packageManager) {
        String verifierPackageName = null;
        for (ResolveInfo intentResolver : packageManager.queryIntentActivities(new Intent(ACTION_PERMISSION_REVOCATION_SETTINGS).setData(Uri.fromParts("package", "com.example", (String) null)), 0)) {
            String packageName = intentResolver.activityInfo.packageName;
            if (packageManager.checkPermission("android.permission.PACKAGE_VERIFICATION_AGENT", packageName) == 0) {
                if (verifierPackageName != null) {
                    return verifierPackageName;
                }
                verifierPackageName = packageName;
            }
        }
        return verifierPackageName;
    }

    @RequiresApi(30)
    private static class Api30Impl {
        private Api30Impl() {
        }

        static boolean areUnusedAppRestrictionsEnabled(@NonNull Context context) {
            return !context.getPackageManager().isAutoRevokeWhitelisted();
        }
    }
}
