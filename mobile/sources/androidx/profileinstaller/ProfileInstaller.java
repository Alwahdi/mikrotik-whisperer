package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

public class ProfileInstaller {
    public static final int DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST = 2;
    public static final int DIAGNOSTIC_CURRENT_PROFILE_EXISTS = 1;
    public static final int DIAGNOSTIC_PROFILE_IS_COMPRESSED = 5;
    public static final int DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST = 4;
    public static final int DIAGNOSTIC_REF_PROFILE_EXISTS = 3;
    private static final DiagnosticsCallback EMPTY_DIAGNOSTICS = new DiagnosticsCallback() {
        public void onDiagnosticReceived(int code, @Nullable Object data) {
        }

        public void onResultReceived(int code, @Nullable Object data) {
        }
    };
    @NonNull
    static final DiagnosticsCallback LOG_DIAGNOSTICS = new DiagnosticsCallback() {
        static final String TAG = "ProfileInstaller";

        public void onDiagnosticReceived(int code, @Nullable Object data) {
            String msg = "";
            switch (code) {
                case 1:
                    msg = "DIAGNOSTIC_CURRENT_PROFILE_EXISTS";
                    break;
                case 2:
                    msg = "DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST";
                    break;
                case 3:
                    msg = "DIAGNOSTIC_REF_PROFILE_EXISTS";
                    break;
                case 4:
                    msg = "DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST";
                    break;
                case 5:
                    msg = "DIAGNOSTIC_PROFILE_IS_COMPRESSED";
                    break;
            }
            Log.d(TAG, msg);
        }

        public void onResultReceived(int code, @Nullable Object data) {
            String msg = "";
            switch (code) {
                case 1:
                    msg = "RESULT_INSTALL_SUCCESS";
                    break;
                case 2:
                    msg = "RESULT_ALREADY_INSTALLED";
                    break;
                case 3:
                    msg = "RESULT_UNSUPPORTED_ART_VERSION";
                    break;
                case 4:
                    msg = "RESULT_NOT_WRITABLE";
                    break;
                case 5:
                    msg = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                    break;
                case 6:
                    msg = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                    break;
                case 7:
                    msg = "RESULT_IO_EXCEPTION";
                    break;
                case 8:
                    msg = "RESULT_PARSE_EXCEPTION";
                    break;
                case 10:
                    msg = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                    break;
                case 11:
                    msg = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                    break;
            }
            switch (code) {
                case 6:
                case 7:
                case 8:
                    Log.e(TAG, msg, (Throwable) data);
                    return;
                default:
                    Log.d(TAG, msg);
                    return;
            }
        }
    };
    private static final String PROFILE_BASE_DIR = "/data/misc/profiles/cur/0";
    private static final String PROFILE_FILE = "primary.prof";
    private static final String PROFILE_INSTALLER_SKIP_FILE_NAME = "profileinstaller_profileWrittenFor_lastUpdateTime.dat";
    private static final String PROFILE_META_LOCATION = "dexopt/baseline.profm";
    private static final String PROFILE_SOURCE_LOCATION = "dexopt/baseline.prof";
    public static final int RESULT_ALREADY_INSTALLED = 2;
    public static final int RESULT_BASELINE_PROFILE_NOT_FOUND = 6;
    public static final int RESULT_BENCHMARK_OPERATION_FAILURE = 15;
    public static final int RESULT_BENCHMARK_OPERATION_SUCCESS = 14;
    public static final int RESULT_BENCHMARK_OPERATION_UNKNOWN = 16;
    public static final int RESULT_DELETE_SKIP_FILE_SUCCESS = 11;
    public static final int RESULT_DESIRED_FORMAT_UNSUPPORTED = 5;
    public static final int RESULT_INSTALL_SKIP_FILE_SUCCESS = 10;
    public static final int RESULT_INSTALL_SUCCESS = 1;
    public static final int RESULT_IO_EXCEPTION = 7;
    public static final int RESULT_META_FILE_REQUIRED_BUT_NOT_FOUND = 9;
    public static final int RESULT_NOT_WRITABLE = 4;
    public static final int RESULT_PARSE_EXCEPTION = 8;
    public static final int RESULT_SAVE_PROFILE_SIGNALLED = 12;
    public static final int RESULT_SAVE_PROFILE_SKIPPED = 13;
    public static final int RESULT_UNSUPPORTED_ART_VERSION = 3;
    private static final String TAG = "ProfileInstaller";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DiagnosticCode {
    }

    public interface DiagnosticsCallback {
        void onDiagnosticReceived(int i, @Nullable Object obj);

        void onResultReceived(int i, @Nullable Object obj);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ResultCode {
    }

    private ProfileInstaller() {
    }

    static void result(@NonNull Executor executor, @NonNull DiagnosticsCallback diagnostics, int code, @Nullable Object data) {
        executor.execute(new ya0(diagnostics, code, data));
    }

    static void diagnostic(@NonNull Executor executor, @NonNull DiagnosticsCallback diagnostics, int code, @Nullable Object data) {
        executor.execute(new xa0(diagnostics, code, data));
    }

    @WorkerThread
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static boolean hasAlreadyWrittenProfileForThisInstall(PackageInfo packageInfo, File appFilesDir, DiagnosticsCallback diagnostics) {
        DataInputStream dataInputStream;
        File skipFile = new File(appFilesDir, PROFILE_INSTALLER_SKIP_FILE_NAME);
        boolean z = false;
        if (!skipFile.exists()) {
            return false;
        }
        try {
            dataInputStream = new DataInputStream(new FileInputStream(skipFile));
            long lastProfileWritePackageUpdateTime = dataInputStream.readLong();
            dataInputStream.close();
            if (lastProfileWritePackageUpdateTime == packageInfo.lastUpdateTime) {
                z = true;
            }
            boolean result = z;
            if (result) {
                diagnostics.onResultReceived(2, (Object) null);
            }
            return result;
        } catch (IOException e) {
            return false;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static void noteProfileWrittenFor(@NonNull PackageInfo packageInfo, @NonNull File appFilesDir) {
        DataOutputStream os;
        try {
            os = new DataOutputStream(new FileOutputStream(new File(appFilesDir, PROFILE_INSTALLER_SKIP_FILE_NAME)));
            os.writeLong(packageInfo.lastUpdateTime);
            os.close();
            return;
        } catch (IOException e) {
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static boolean deleteProfileWrittenFor(@NonNull File appFilesDir) {
        return new File(appFilesDir, PROFILE_INSTALLER_SKIP_FILE_NAME).delete();
    }

    private static boolean transcodeAndWrite(@NonNull AssetManager assets, @NonNull String packageName, @NonNull PackageInfo packageInfo, @NonNull File filesDir, @NonNull String apkName, @NonNull Executor executor, @NonNull DiagnosticsCallback diagnostics) {
        if (Build.VERSION.SDK_INT < 19) {
            result(executor, diagnostics, 3, (Object) null);
            return false;
        }
        Executor executor2 = executor;
        DiagnosticsCallback diagnosticsCallback = diagnostics;
        String str = packageName;
        DeviceProfileWriter deviceProfileWriter = new DeviceProfileWriter(assets, executor, diagnostics, apkName, PROFILE_SOURCE_LOCATION, PROFILE_META_LOCATION, new File(new File(PROFILE_BASE_DIR, packageName), PROFILE_FILE));
        if (!deviceProfileWriter.deviceAllowsProfileInstallerAotWrites()) {
            return false;
        }
        boolean success = deviceProfileWriter.read().transcodeIfNeeded().write();
        if (success) {
            noteProfileWrittenFor(packageInfo, filesDir);
        }
        return success;
    }

    @WorkerThread
    public static void writeProfile(@NonNull Context context) {
        writeProfile(context, wa0.a, EMPTY_DIAGNOSTICS);
    }

    @WorkerThread
    public static void writeProfile(@NonNull Context context, @NonNull Executor executor, @NonNull DiagnosticsCallback diagnostics) {
        writeProfile(context, executor, diagnostics, false);
    }

    @WorkerThread
    static void writeProfile(@NonNull Context context, @NonNull Executor executor, @NonNull DiagnosticsCallback diagnostics, boolean forceWriteProfile) {
        Context context2 = context;
        DiagnosticsCallback diagnosticsCallback = diagnostics;
        Context appContext = context.getApplicationContext();
        String packageName = appContext.getPackageName();
        ApplicationInfo appInfo = appContext.getApplicationInfo();
        AssetManager assetManager = appContext.getAssets();
        String apkName = new File(appInfo.sourceDir).getName();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (forceWriteProfile || !hasAlreadyWrittenProfileForThisInstall(packageInfo, filesDir, diagnosticsCallback)) {
                Log.d(TAG, "Installing profile for " + context.getPackageName());
                File file = filesDir;
                Context context3 = appContext;
                ProfileVerifier.writeProfileVerification(context2, transcodeAndWrite(assetManager, packageName, packageInfo, filesDir, apkName, executor, diagnostics) && forceWriteProfile);
                return;
            }
            Log.d(TAG, "Skipping profile installation for " + context.getPackageName());
            ProfileVerifier.writeProfileVerification(context2, false);
            File file2 = filesDir;
            Context context4 = appContext;
        } catch (PackageManager.NameNotFoundException e) {
            Context context5 = appContext;
            diagnosticsCallback.onResultReceived(7, e);
            ProfileVerifier.writeProfileVerification(context2, false);
        }
    }

    @WorkerThread
    static void writeSkipFile(@NonNull Context context, @NonNull Executor executor, @NonNull DiagnosticsCallback diagnostics) {
        try {
            noteProfileWrittenFor(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
            result(executor, diagnostics, 10, (Object) null);
        } catch (PackageManager.NameNotFoundException e) {
            result(executor, diagnostics, 7, e);
        }
    }

    @WorkerThread
    static void deleteSkipFile(@NonNull Context context, @NonNull Executor executor, @NonNull DiagnosticsCallback diagnostics) {
        deleteProfileWrittenFor(context.getFilesDir());
        result(executor, diagnostics, 11, (Object) null);
    }
}
