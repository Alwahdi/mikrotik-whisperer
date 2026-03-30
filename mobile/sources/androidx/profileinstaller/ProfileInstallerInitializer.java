package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ProfileInstallerInitializer implements Initializer<Result> {
    private static final int DELAY_MS = 5000;

    public static class Result {
    }

    @NonNull
    public Result create(@NonNull Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return new Result();
        }
        delayAfterFirstFrame(context.getApplicationContext());
        return new Result();
    }

    /* access modifiers changed from: package-private */
    @RequiresApi(16)
    public void delayAfterFirstFrame(@NonNull Context appContext) {
        Choreographer16Impl.postFrameCallback(new bb0(this, appContext));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: installAfterDelay */
    public void lambda$delayAfterFirstFrame$0(@NonNull Context appContext) {
        Handler handler;
        if (Build.VERSION.SDK_INT >= 28) {
            handler = Handler28Impl.createAsync(Looper.getMainLooper());
        } else {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.postDelayed(new za0(appContext), (long) (new Random().nextInt(Math.max(1000, 1)) + DELAY_MS));
    }

    @NonNull
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }

    /* access modifiers changed from: private */
    public static void writeInBackground(@NonNull Context context) {
        new ThreadPoolExecutor(0, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new ab0(context));
    }

    @RequiresApi(16)
    private static class Choreographer16Impl {
        private Choreographer16Impl() {
        }

        @DoNotInline
        public static void postFrameCallback(Runnable r) {
            Choreographer.getInstance().postFrameCallback(new a(r));
        }
    }

    @RequiresApi(28)
    private static class Handler28Impl {
        private Handler28Impl() {
        }

        @DoNotInline
        public static Handler createAsync(Looper looper) {
            return Handler.createAsync(looper);
        }
    }
}
