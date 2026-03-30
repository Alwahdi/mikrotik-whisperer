package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import androidx.core.os.TraceCompat;
import androidx.emoji2.text.EmojiCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class EmojiCompatInitializer implements Initializer<Boolean> {
    private static final long STARTUP_THREAD_CREATION_DELAY_MS = 500;
    private static final String S_INITIALIZER_THREAD_NAME = "EmojiCompatInitializer";

    @NonNull
    public Boolean create(@NonNull Context context) {
        if (Build.VERSION.SDK_INT < 19) {
            return false;
        }
        EmojiCompat.init((EmojiCompat.Config) new BackgroundDefaultConfig(context));
        delayUntilFirstResume(context);
        return true;
    }

    /* access modifiers changed from: package-private */
    @RequiresApi(19)
    public void delayUntilFirstResume(@NonNull Context context) {
        final Lifecycle lifecycle = ((LifecycleOwner) AppInitializer.getInstance(context).initializeComponent(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.addObserver(new DefaultLifecycleObserver() {
            public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
                nf.a(this, lifecycleOwner);
            }

            public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
                nf.b(this, lifecycleOwner);
            }

            public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
                nf.c(this, lifecycleOwner);
            }

            public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
                nf.e(this, lifecycleOwner);
            }

            public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
                nf.f(this, lifecycleOwner);
            }

            public void onResume(@NonNull LifecycleOwner owner) {
                EmojiCompatInitializer.this.loadEmojiCompatAfterDelay();
                lifecycle.removeObserver(this);
            }
        });
    }

    /* access modifiers changed from: package-private */
    @RequiresApi(19)
    public void loadEmojiCompatAfterDelay() {
        ConcurrencyHelpers.mainHandlerAsync().postDelayed(new LoadEmojiCompatRunnable(), STARTUP_THREAD_CREATION_DELAY_MS);
    }

    @NonNull
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    static class LoadEmojiCompatRunnable implements Runnable {
        LoadEmojiCompatRunnable() {
        }

        public void run() {
            try {
                TraceCompat.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                if (EmojiCompat.isConfigured()) {
                    EmojiCompat.get().load();
                }
            } finally {
                TraceCompat.endSection();
            }
        }
    }

    @RequiresApi(19)
    static class BackgroundDefaultConfig extends EmojiCompat.Config {
        protected BackgroundDefaultConfig(Context context) {
            super(new BackgroundDefaultLoader(context));
            setMetadataLoadStrategy(1);
        }
    }

    @RequiresApi(19)
    static class BackgroundDefaultLoader implements EmojiCompat.MetadataRepoLoader {
        private final Context mContext;

        BackgroundDefaultLoader(Context context) {
            this.mContext = context.getApplicationContext();
        }

        public void load(@NonNull EmojiCompat.MetadataRepoLoaderCallback loaderCallback) {
            ThreadPoolExecutor executor = ConcurrencyHelpers.createBackgroundPriorityExecutor(EmojiCompatInitializer.S_INITIALIZER_THREAD_NAME);
            executor.execute(new b(this, loaderCallback, executor));
        }

        /* access modifiers changed from: package-private */
        @WorkerThread
        /* renamed from: doLoad */
        public void lambda$load$0(@NonNull final EmojiCompat.MetadataRepoLoaderCallback loaderCallback, @NonNull final ThreadPoolExecutor executor) {
            try {
                FontRequestEmojiCompatConfig config = DefaultEmojiCompatConfig.create(this.mContext);
                if (config != null) {
                    config.setLoadingExecutor(executor);
                    config.getMetadataRepoLoader().load(new EmojiCompat.MetadataRepoLoaderCallback() {
                        public void onLoaded(@NonNull MetadataRepo metadataRepo) {
                            try {
                                loaderCallback.onLoaded(metadataRepo);
                            } finally {
                                executor.shutdown();
                            }
                        }

                        public void onFailed(@Nullable Throwable throwable) {
                            try {
                                loaderCallback.onFailed(throwable);
                            } finally {
                                executor.shutdown();
                            }
                        }
                    });
                    return;
                }
                throw new RuntimeException("EmojiCompat font provider not available on this device.");
            } catch (Throwable t) {
                loaderCallback.onFailed(t);
                executor.shutdown();
            }
        }
    }
}
