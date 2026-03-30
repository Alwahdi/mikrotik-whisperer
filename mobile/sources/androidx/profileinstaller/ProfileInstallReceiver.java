package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.profileinstaller.ProfileInstaller;

public class ProfileInstallReceiver extends BroadcastReceiver {
    @NonNull
    public static final String ACTION_BENCHMARK_OPERATION = "androidx.profileinstaller.action.BENCHMARK_OPERATION";
    @NonNull
    public static final String ACTION_INSTALL_PROFILE = "androidx.profileinstaller.action.INSTALL_PROFILE";
    @NonNull
    public static final String ACTION_SAVE_PROFILE = "androidx.profileinstaller.action.SAVE_PROFILE";
    @NonNull
    public static final String ACTION_SKIP_FILE = "androidx.profileinstaller.action.SKIP_FILE";
    @NonNull
    private static final String EXTRA_BENCHMARK_OPERATION = "EXTRA_BENCHMARK_OPERATION";
    @NonNull
    private static final String EXTRA_BENCHMARK_OPERATION_DROP_SHADER_CACHE = "DROP_SHADER_CACHE";
    @NonNull
    private static final String EXTRA_SKIP_FILE_OPERATION = "EXTRA_SKIP_FILE_OPERATION";
    @NonNull
    private static final String EXTRA_SKIP_FILE_OPERATION_DELETE = "DELETE_SKIP_FILE";
    @NonNull
    private static final String EXTRA_SKIP_FILE_OPERATION_WRITE = "WRITE_SKIP_FILE";

    public void onReceive(@NonNull Context context, @Nullable Intent intent) {
        Bundle extras;
        if (intent != null) {
            String action = intent.getAction();
            if (ACTION_INSTALL_PROFILE.equals(action)) {
                ProfileInstaller.writeProfile(context, wa0.a, new ResultDiagnostics(), true);
            } else if (ACTION_SKIP_FILE.equals(action)) {
                Bundle extras2 = intent.getExtras();
                if (extras2 != null) {
                    String operation = extras2.getString(EXTRA_SKIP_FILE_OPERATION);
                    if (EXTRA_SKIP_FILE_OPERATION_WRITE.equals(operation)) {
                        ProfileInstaller.writeSkipFile(context, wa0.a, new ResultDiagnostics());
                    } else if (EXTRA_SKIP_FILE_OPERATION_DELETE.equals(operation)) {
                        ProfileInstaller.deleteSkipFile(context, wa0.a, new ResultDiagnostics());
                    }
                }
            } else if (ACTION_SAVE_PROFILE.equals(action)) {
                saveProfile(new ResultDiagnostics());
            } else if (ACTION_BENCHMARK_OPERATION.equals(action) && (extras = intent.getExtras()) != null) {
                String operation2 = extras.getString(EXTRA_BENCHMARK_OPERATION);
                ResultDiagnostics diagnostics = new ResultDiagnostics();
                if (EXTRA_BENCHMARK_OPERATION_DROP_SHADER_CACHE.equals(operation2)) {
                    BenchmarkOperation.dropShaderCache(context, diagnostics);
                } else {
                    diagnostics.onResultReceived(16, (Object) null);
                }
            }
        }
    }

    static void saveProfile(@NonNull ProfileInstaller.DiagnosticsCallback callback) {
        if (Build.VERSION.SDK_INT >= 24) {
            Process.sendSignal(Process.myPid(), 10);
            callback.onResultReceived(12, (Object) null);
            return;
        }
        callback.onResultReceived(13, (Object) null);
    }

    class ResultDiagnostics implements ProfileInstaller.DiagnosticsCallback {
        ResultDiagnostics() {
        }

        public void onDiagnosticReceived(int code, @Nullable Object data) {
            ProfileInstaller.LOG_DIAGNOSTICS.onDiagnosticReceived(code, data);
        }

        public void onResultReceived(int code, @Nullable Object data) {
            ProfileInstaller.LOG_DIAGNOSTICS.onResultReceived(code, data);
            ProfileInstallReceiver.this.setResultCode(code);
        }
    }
}
