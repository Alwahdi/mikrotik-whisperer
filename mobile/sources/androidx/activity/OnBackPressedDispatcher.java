package androidx.activity;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.DoNotInline;
import androidx.annotation.MainThread;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public final class OnBackPressedDispatcher {
    private boolean backInvokedCallbackRegistered;
    private final Runnable fallbackOnBackPressed;
    private boolean hasEnabledCallbacks;
    /* access modifiers changed from: private */
    public OnBackPressedCallback inProgressCallback;
    private OnBackInvokedDispatcher invokedDispatcher;
    private OnBackInvokedCallback onBackInvokedCallback;
    /* access modifiers changed from: private */
    public final z3<OnBackPressedCallback> onBackPressedCallbacks;
    private final Consumer<Boolean> onHasEnabledCallbacksChanged;

    public OnBackPressedDispatcher() {
        this((Runnable) null, 1, (Cif) null);
    }

    public OnBackPressedDispatcher(Runnable fallbackOnBackPressed2, Consumer<Boolean> onHasEnabledCallbacksChanged2) {
        OnBackInvokedCallback onBackInvokedCallback2;
        this.fallbackOnBackPressed = fallbackOnBackPressed2;
        this.onHasEnabledCallbacksChanged = onHasEnabledCallbacksChanged2;
        this.onBackPressedCallbacks = new z3<>();
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            if (i >= 34) {
                onBackInvokedCallback2 = Api34Impl.INSTANCE.createOnBackAnimationCallback(new vn<BackEventCompat, jt0>(this) {
                    final /* synthetic */ OnBackPressedDispatcher this$0;

                    {
                        this.this$0 = r2;
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        invoke((BackEventCompat) p1);
                        return jt0.a;
                    }

                    public final void invoke(BackEventCompat backEvent) {
                        lu.f(backEvent, "backEvent");
                        this.this$0.onBackStarted(backEvent);
                    }
                }, new vn<BackEventCompat, jt0>(this) {
                    final /* synthetic */ OnBackPressedDispatcher this$0;

                    {
                        this.this$0 = r2;
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        invoke((BackEventCompat) p1);
                        return jt0.a;
                    }

                    public final void invoke(BackEventCompat backEvent) {
                        lu.f(backEvent, "backEvent");
                        this.this$0.onBackProgressed(backEvent);
                    }
                }, new tn<jt0>(this) {
                    final /* synthetic */ OnBackPressedDispatcher this$0;

                    {
                        this.this$0 = r2;
                    }

                    public final void invoke() {
                        this.this$0.onBackPressed();
                    }
                }, new tn<jt0>(this) {
                    final /* synthetic */ OnBackPressedDispatcher this$0;

                    {
                        this.this$0 = r2;
                    }

                    public final void invoke() {
                        this.this$0.onBackCancelled();
                    }
                });
            } else {
                onBackInvokedCallback2 = Api33Impl.INSTANCE.createOnBackInvokedCallback(new tn<jt0>(this) {
                    final /* synthetic */ OnBackPressedDispatcher this$0;

                    {
                        this.this$0 = r2;
                    }

                    public final void invoke() {
                        this.this$0.onBackPressed();
                    }
                });
            }
            this.onBackInvokedCallback = onBackInvokedCallback2;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OnBackPressedDispatcher(Runnable runnable, int i, Cif ifVar) {
        this((i & 1) != 0 ? null : runnable);
    }

    public OnBackPressedDispatcher(Runnable fallbackOnBackPressed2) {
        this(fallbackOnBackPressed2, (Consumer<Boolean>) null);
    }

    @RequiresApi(33)
    public final void setOnBackInvokedDispatcher(OnBackInvokedDispatcher invoker) {
        lu.f(invoker, "invoker");
        this.invokedDispatcher = invoker;
        updateBackInvokedCallbackState(this.hasEnabledCallbacks);
    }

    @RequiresApi(33)
    private final void updateBackInvokedCallbackState(boolean shouldBeRegistered) {
        OnBackInvokedDispatcher dispatcher = this.invokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback2 = this.onBackInvokedCallback;
        if (dispatcher != null && onBackInvokedCallback2 != null) {
            if (shouldBeRegistered && !this.backInvokedCallbackRegistered) {
                Api33Impl.INSTANCE.registerOnBackInvokedCallback(dispatcher, 0, onBackInvokedCallback2);
                this.backInvokedCallbackRegistered = true;
            } else if (!shouldBeRegistered && this.backInvokedCallbackRegistered) {
                Api33Impl.INSTANCE.unregisterOnBackInvokedCallback(dispatcher, onBackInvokedCallback2);
                this.backInvokedCallbackRegistered = false;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateEnabledCallbacks() {
        boolean hadEnabledCallbacks = this.hasEnabledCallbacks;
        z3<OnBackPressedCallback> z3Var = this.onBackPressedCallbacks;
        boolean z = false;
        if (!(z3Var instanceof Collection) || !z3Var.isEmpty()) {
            Iterator<T> it = z3Var.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((OnBackPressedCallback) it.next()).isEnabled()) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        boolean hasEnabledCallbacks2 = z;
        this.hasEnabledCallbacks = hasEnabledCallbacks2;
        if (hasEnabledCallbacks2 != hadEnabledCallbacks) {
            Consumer<Boolean> consumer = this.onHasEnabledCallbacksChanged;
            if (consumer != null) {
                consumer.accept(Boolean.valueOf(hasEnabledCallbacks2));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                updateBackInvokedCallbackState(hasEnabledCallbacks2);
            }
        }
    }

    @MainThread
    public final void addCallback(OnBackPressedCallback onBackPressedCallback) {
        lu.f(onBackPressedCallback, "onBackPressedCallback");
        addCancellableCallback$activity_release(onBackPressedCallback);
    }

    @MainThread
    public final Cancellable addCancellableCallback$activity_release(OnBackPressedCallback onBackPressedCallback) {
        lu.f(onBackPressedCallback, "onBackPressedCallback");
        this.onBackPressedCallbacks.add(onBackPressedCallback);
        OnBackPressedCancellable cancellable = new OnBackPressedCancellable(this, onBackPressedCallback);
        onBackPressedCallback.addCancellable(cancellable);
        updateEnabledCallbacks();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new OnBackPressedDispatcher$addCancellableCallback$1(this));
        return cancellable;
    }

    @MainThread
    public final void addCallback(LifecycleOwner owner, OnBackPressedCallback onBackPressedCallback) {
        lu.f(owner, "owner");
        lu.f(onBackPressedCallback, "onBackPressedCallback");
        Lifecycle lifecycle = owner.getLifecycle();
        if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
            onBackPressedCallback.addCancellable(new LifecycleOnBackPressedCancellable(this, lifecycle, onBackPressedCallback));
            updateEnabledCallbacks();
            onBackPressedCallback.setEnabledChangedCallback$activity_release(new OnBackPressedDispatcher$addCallback$1(this));
        }
    }

    @MainThread
    public final boolean hasEnabledCallbacks() {
        return this.hasEnabledCallbacks;
    }

    @VisibleForTesting
    @MainThread
    public final void dispatchOnBackStarted(BackEventCompat backEvent) {
        lu.f(backEvent, "backEvent");
        onBackStarted(backEvent);
    }

    /* access modifiers changed from: private */
    @MainThread
    public final void onBackStarted(BackEventCompat backEvent) {
        OnBackPressedCallback it;
        List $this$lastOrNull$iv = this.onBackPressedCallbacks;
        ListIterator iterator$iv = $this$lastOrNull$iv.listIterator($this$lastOrNull$iv.size());
        while (true) {
            if (!iterator$iv.hasPrevious()) {
                it = null;
                break;
            }
            it = iterator$iv.previous();
            if (it.isEnabled()) {
                break;
            }
        }
        OnBackPressedCallback callback = it;
        this.inProgressCallback = callback;
        if (callback != null) {
            callback.handleOnBackStarted(backEvent);
        }
    }

    @VisibleForTesting
    @MainThread
    public final void dispatchOnBackProgressed(BackEventCompat backEvent) {
        lu.f(backEvent, "backEvent");
        onBackProgressed(backEvent);
    }

    /* access modifiers changed from: private */
    @MainThread
    public final void onBackProgressed(BackEventCompat backEvent) {
        OnBackPressedCallback it;
        List $this$lastOrNull$iv = this.onBackPressedCallbacks;
        ListIterator iterator$iv = $this$lastOrNull$iv.listIterator($this$lastOrNull$iv.size());
        while (true) {
            if (!iterator$iv.hasPrevious()) {
                it = null;
                break;
            }
            it = iterator$iv.previous();
            if (it.isEnabled()) {
                break;
            }
        }
        OnBackPressedCallback callback = it;
        if (callback != null) {
            callback.handleOnBackProgressed(backEvent);
        }
    }

    @MainThread
    public final void onBackPressed() {
        Object element$iv;
        List $this$lastOrNull$iv = this.onBackPressedCallbacks;
        ListIterator iterator$iv = $this$lastOrNull$iv.listIterator($this$lastOrNull$iv.size());
        while (true) {
            if (!iterator$iv.hasPrevious()) {
                element$iv = null;
                break;
            }
            element$iv = iterator$iv.previous();
            if (((OnBackPressedCallback) element$iv).isEnabled()) {
                break;
            }
        }
        OnBackPressedCallback callback = (OnBackPressedCallback) element$iv;
        this.inProgressCallback = null;
        if (callback != null) {
            callback.handleOnBackPressed();
            return;
        }
        Runnable runnable = this.fallbackOnBackPressed;
        if (runnable != null) {
            runnable.run();
        }
    }

    @VisibleForTesting
    @MainThread
    public final void dispatchOnBackCancelled() {
        onBackCancelled();
    }

    /* access modifiers changed from: private */
    @MainThread
    public final void onBackCancelled() {
        Object element$iv;
        List $this$lastOrNull$iv = this.onBackPressedCallbacks;
        ListIterator iterator$iv = $this$lastOrNull$iv.listIterator($this$lastOrNull$iv.size());
        while (true) {
            if (!iterator$iv.hasPrevious()) {
                element$iv = null;
                break;
            }
            element$iv = iterator$iv.previous();
            if (((OnBackPressedCallback) element$iv).isEnabled()) {
                break;
            }
        }
        OnBackPressedCallback callback = (OnBackPressedCallback) element$iv;
        this.inProgressCallback = null;
        if (callback != null) {
            callback.handleOnBackCancelled();
        }
    }

    private final class OnBackPressedCancellable implements Cancellable {
        private final OnBackPressedCallback onBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        public OnBackPressedCancellable(OnBackPressedDispatcher this$02, OnBackPressedCallback onBackPressedCallback2) {
            lu.f(onBackPressedCallback2, "onBackPressedCallback");
            this.this$0 = this$02;
            this.onBackPressedCallback = onBackPressedCallback2;
        }

        public void cancel() {
            this.this$0.onBackPressedCallbacks.remove(this.onBackPressedCallback);
            if (lu.a(this.this$0.inProgressCallback, this.onBackPressedCallback)) {
                this.onBackPressedCallback.handleOnBackCancelled();
                this.this$0.inProgressCallback = null;
            }
            this.onBackPressedCallback.removeCancellable(this);
            tn<jt0> enabledChangedCallback$activity_release = this.onBackPressedCallback.getEnabledChangedCallback$activity_release();
            if (enabledChangedCallback$activity_release != null) {
                enabledChangedCallback$activity_release.invoke();
            }
            this.onBackPressedCallback.setEnabledChangedCallback$activity_release((tn<jt0>) null);
        }
    }

    private final class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, Cancellable {
        private Cancellable currentCancellable;
        private final Lifecycle lifecycle;
        private final OnBackPressedCallback onBackPressedCallback;
        final /* synthetic */ OnBackPressedDispatcher this$0;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher this$02, Lifecycle lifecycle2, OnBackPressedCallback onBackPressedCallback2) {
            lu.f(lifecycle2, "lifecycle");
            lu.f(onBackPressedCallback2, "onBackPressedCallback");
            this.this$0 = this$02;
            this.lifecycle = lifecycle2;
            this.onBackPressedCallback = onBackPressedCallback2;
            lifecycle2.addObserver(this);
        }

        public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
            lu.f(source, "source");
            lu.f(event, NotificationCompat.CATEGORY_EVENT);
            if (event == Lifecycle.Event.ON_START) {
                this.currentCancellable = this.this$0.addCancellableCallback$activity_release(this.onBackPressedCallback);
            } else if (event == Lifecycle.Event.ON_STOP) {
                Cancellable cancellable = this.currentCancellable;
                if (cancellable != null) {
                    cancellable.cancel();
                }
            } else if (event == Lifecycle.Event.ON_DESTROY) {
                cancel();
            }
        }

        public void cancel() {
            this.lifecycle.removeObserver(this);
            this.onBackPressedCallback.removeCancellable(this);
            Cancellable cancellable = this.currentCancellable;
            if (cancellable != null) {
                cancellable.cancel();
            }
            this.currentCancellable = null;
        }
    }

    @RequiresApi(33)
    public static final class Api33Impl {
        public static final Api33Impl INSTANCE = new Api33Impl();

        private Api33Impl() {
        }

        @DoNotInline
        public final void registerOnBackInvokedCallback(Object dispatcher, int priority, Object callback) {
            lu.f(dispatcher, "dispatcher");
            lu.f(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).registerOnBackInvokedCallback(priority, (OnBackInvokedCallback) callback);
        }

        @DoNotInline
        public final void unregisterOnBackInvokedCallback(Object dispatcher, Object callback) {
            lu.f(dispatcher, "dispatcher");
            lu.f(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).unregisterOnBackInvokedCallback((OnBackInvokedCallback) callback);
        }

        /* access modifiers changed from: private */
        public static final void createOnBackInvokedCallback$lambda$0(tn $onBackInvoked) {
            lu.f($onBackInvoked, "$onBackInvoked");
            $onBackInvoked.invoke();
        }

        @DoNotInline
        public final OnBackInvokedCallback createOnBackInvokedCallback(tn<jt0> onBackInvoked) {
            lu.f(onBackInvoked, "onBackInvoked");
            return new m40(onBackInvoked);
        }
    }

    @RequiresApi(34)
    public static final class Api34Impl {
        public static final Api34Impl INSTANCE = new Api34Impl();

        private Api34Impl() {
        }

        @DoNotInline
        public final OnBackInvokedCallback createOnBackAnimationCallback(vn<? super BackEventCompat, jt0> onBackStarted, vn<? super BackEventCompat, jt0> onBackProgressed, tn<jt0> onBackInvoked, tn<jt0> onBackCancelled) {
            lu.f(onBackStarted, "onBackStarted");
            lu.f(onBackProgressed, "onBackProgressed");
            lu.f(onBackInvoked, "onBackInvoked");
            lu.f(onBackCancelled, "onBackCancelled");
            return new OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1(onBackStarted, onBackProgressed, onBackInvoked, onBackCancelled);
        }
    }
}
