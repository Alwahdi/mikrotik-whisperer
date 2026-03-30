package androidx.activity;

import androidx.annotation.MainThread;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class OnBackPressedCallback {
    private final CopyOnWriteArrayList<Cancellable> cancellables = new CopyOnWriteArrayList<>();
    private tn<jt0> enabledChangedCallback;
    private boolean isEnabled;

    @MainThread
    public abstract void handleOnBackPressed();

    public OnBackPressedCallback(boolean enabled) {
        this.isEnabled = enabled;
    }

    @MainThread
    public final boolean isEnabled() {
        return this.isEnabled;
    }

    @MainThread
    public final void setEnabled(boolean value) {
        this.isEnabled = value;
        tn<jt0> tnVar = this.enabledChangedCallback;
        if (tnVar != null) {
            tnVar.invoke();
        }
    }

    public final tn<jt0> getEnabledChangedCallback$activity_release() {
        return this.enabledChangedCallback;
    }

    public final void setEnabledChangedCallback$activity_release(tn<jt0> tnVar) {
        this.enabledChangedCallback = tnVar;
    }

    @MainThread
    public final void remove() {
        for (Cancellable it : this.cancellables) {
            it.cancel();
        }
    }

    @MainThread
    public void handleOnBackStarted(BackEventCompat backEvent) {
        lu.f(backEvent, "backEvent");
    }

    @MainThread
    public void handleOnBackProgressed(BackEventCompat backEvent) {
        lu.f(backEvent, "backEvent");
    }

    @MainThread
    public void handleOnBackCancelled() {
    }

    public final void addCancellable(Cancellable cancellable) {
        lu.f(cancellable, "cancellable");
        this.cancellables.add(cancellable);
    }

    public final void removeCancellable(Cancellable cancellable) {
        lu.f(cancellable, "cancellable");
        this.cancellables.remove(cancellable);
    }
}
