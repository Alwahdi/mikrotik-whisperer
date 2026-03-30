package androidx.arch.core.executor;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DefaultTaskExecutor extends TaskExecutor {
    private final ExecutorService mDiskIO = Executors.newFixedThreadPool(4, new ThreadFactory() {
        private static final String THREAD_NAME_STEM = "arch_disk_io_";
        private final AtomicInteger mThreadId = new AtomicInteger(0);

        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setName(THREAD_NAME_STEM + this.mThreadId.getAndIncrement());
            return t;
        }
    });
    private final Object mLock = new Object();
    @Nullable
    private volatile Handler mMainHandler;

    public void executeOnDiskIO(@NonNull Runnable runnable) {
        this.mDiskIO.execute(runnable);
    }

    public void postToMainThread(@NonNull Runnable runnable) {
        if (this.mMainHandler == null) {
            synchronized (this.mLock) {
                if (this.mMainHandler == null) {
                    this.mMainHandler = createAsync(Looper.getMainLooper());
                }
            }
        }
        this.mMainHandler.post(runnable);
    }

    public boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @NonNull
    private static Handler createAsync(@NonNull Looper looper) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return Api28Impl.createAsync(looper);
        }
        if (i >= 17) {
            Class<Handler> cls = Handler.class;
            try {
                return cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, true});
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException e) {
            } catch (InvocationTargetException e2) {
                return new Handler(looper);
            }
        }
        return new Handler(looper);
    }

    @RequiresApi(28)
    private static class Api28Impl {
        private Api28Impl() {
        }

        @NonNull
        public static Handler createAsync(@NonNull Looper looper) {
            return Handler.createAsync(looper);
        }
    }
}
