package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.io.File;

class BenchmarkOperation {
    private BenchmarkOperation() {
    }

    static void dropShaderCache(@NonNull Context context, @NonNull ProfileInstallReceiver.ResultDiagnostics callback) {
        File shaderDirectory;
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            shaderDirectory = Api24ContextHelper.getDeviceProtectedCodeCacheDir(context);
        } else if (i >= 23) {
            shaderDirectory = Api21ContextHelper.getCodeCacheDir(context);
        } else {
            shaderDirectory = context.getCacheDir();
        }
        if (deleteFilesRecursively(shaderDirectory)) {
            callback.onResultReceived(14, (Object) null);
        } else {
            callback.onResultReceived(15, (Object) null);
        }
    }

    static boolean deleteFilesRecursively(File file) {
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            if (children == null) {
                return false;
            }
            boolean success = true;
            int length = children.length;
            for (int i = 0; i < length; i++) {
                success = deleteFilesRecursively(children[i]) && success;
            }
            return success;
        }
        file.delete();
        return true;
    }

    @RequiresApi(api = 21)
    private static class Api21ContextHelper {
        private Api21ContextHelper() {
        }

        static File getCodeCacheDir(Context context) {
            return context.getCodeCacheDir();
        }
    }

    @RequiresApi(api = 24)
    private static class Api24ContextHelper {
        private Api24ContextHelper() {
        }

        static File getDeviceProtectedCodeCacheDir(Context context) {
            return context.createDeviceProtectedStorageContext().getCodeCacheDir();
        }
    }
}
