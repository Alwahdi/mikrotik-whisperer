package androidx.core.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.WeakHashMap;

public final class DisplayManagerCompat {
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    private static final WeakHashMap<Context, DisplayManagerCompat> sInstances = new WeakHashMap<>();
    private final Context mContext;

    private DisplayManagerCompat(Context context) {
        this.mContext = context;
    }

    @NonNull
    public static DisplayManagerCompat getInstance(@NonNull Context context) {
        DisplayManagerCompat instance;
        WeakHashMap<Context, DisplayManagerCompat> weakHashMap = sInstances;
        synchronized (weakHashMap) {
            instance = weakHashMap.get(context);
            if (instance == null) {
                instance = new DisplayManagerCompat(context);
                weakHashMap.put(context, instance);
            }
        }
        return instance;
    }

    @Nullable
    public Display getDisplay(int displayId) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Api17Impl.getDisplay((DisplayManager) this.mContext.getSystemService("display"), displayId);
        }
        Display display = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
        if (display.getDisplayId() == displayId) {
            return display;
        }
        return null;
    }

    @NonNull
    public Display[] getDisplays() {
        if (Build.VERSION.SDK_INT >= 17) {
            return Api17Impl.getDisplays((DisplayManager) this.mContext.getSystemService("display"));
        }
        return new Display[]{((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay()};
    }

    @NonNull
    public Display[] getDisplays(@Nullable String category) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Api17Impl.getDisplays((DisplayManager) this.mContext.getSystemService("display"));
        }
        if (category == null) {
            return new Display[0];
        }
        return new Display[]{((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay()};
    }

    @RequiresApi(17)
    static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        static Display getDisplay(DisplayManager displayManager, int displayId) {
            return displayManager.getDisplay(displayId);
        }

        @DoNotInline
        static Display[] getDisplays(DisplayManager displayManager) {
            return displayManager.getDisplays();
        }
    }
}
