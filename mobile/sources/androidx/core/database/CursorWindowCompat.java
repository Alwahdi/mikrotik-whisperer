package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public final class CursorWindowCompat {
    private CursorWindowCompat() {
    }

    @NonNull
    public static CursorWindow create(@Nullable String name, long windowSizeBytes) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return Api28Impl.createCursorWindow(name, windowSizeBytes);
        }
        if (i >= 15) {
            return Api15Impl.createCursorWindow(name);
        }
        return new CursorWindow(false);
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static CursorWindow createCursorWindow(String name, long windowSizeBytes) {
            return new CursorWindow(name, windowSizeBytes);
        }
    }

    @RequiresApi(15)
    static class Api15Impl {
        private Api15Impl() {
        }

        @DoNotInline
        static CursorWindow createCursorWindow(String name) {
            return new CursorWindow(name);
        }
    }
}
