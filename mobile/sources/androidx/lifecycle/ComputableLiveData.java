package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class ComputableLiveData<T> {
    private final LiveData<T> _liveData;
    private final AtomicBoolean computing;
    private final Executor executor;
    private final AtomicBoolean invalid;
    public final Runnable invalidationRunnable;
    private final LiveData<T> liveData;
    public final Runnable refreshRunnable;

    public ComputableLiveData() {
        this((Executor) null, 1, (Cif) null);
    }

    @VisibleForTesting
    public static /* synthetic */ void getInvalidationRunnable$lifecycle_livedata_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getRefreshRunnable$lifecycle_livedata_release$annotations() {
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public abstract T compute();

    public ComputableLiveData(Executor executor2) {
        lu.f(executor2, "executor");
        this.executor = executor2;
        ComputableLiveData$_liveData$1 computableLiveData$_liveData$1 = new ComputableLiveData$_liveData$1(this);
        this._liveData = computableLiveData$_liveData$1;
        this.liveData = computableLiveData$_liveData$1;
        this.invalid = new AtomicBoolean(true);
        this.computing = new AtomicBoolean(false);
        this.refreshRunnable = new vb(this);
        this.invalidationRunnable = new wb(this);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ComputableLiveData(java.util.concurrent.Executor r1, int r2, defpackage.Cif r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto L_0x000d
            java.util.concurrent.Executor r1 = androidx.arch.core.executor.ArchTaskExecutor.getIOThreadExecutor()
            java.lang.String r2 = "getIOThreadExecutor()"
            defpackage.lu.e(r1, r2)
        L_0x000d:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.ComputableLiveData.<init>(java.util.concurrent.Executor, int, if):void");
    }

    public final Executor getExecutor$lifecycle_livedata_release() {
        return this.executor;
    }

    public LiveData<T> getLiveData() {
        return this.liveData;
    }

    public final AtomicBoolean getInvalid$lifecycle_livedata_release() {
        return this.invalid;
    }

    public final AtomicBoolean getComputing$lifecycle_livedata_release() {
        return this.computing;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x0011  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void refreshRunnable$lambda$0(androidx.lifecycle.ComputableLiveData r5) {
        /*
            java.lang.String r0 = "this$0"
            defpackage.lu.f(r5, r0)
            r0 = 0
        L_0x0006:
            r0 = 0
            java.util.concurrent.atomic.AtomicBoolean r1 = r5.computing
            r2 = 0
            r3 = 1
            boolean r1 = r1.compareAndSet(r2, r3)
            if (r1 == 0) goto L_0x0038
            r1 = 0
        L_0x0013:
            java.util.concurrent.atomic.AtomicBoolean r4 = r5.invalid     // Catch:{ all -> 0x0031 }
            boolean r4 = r4.compareAndSet(r3, r2)     // Catch:{ all -> 0x0031 }
            if (r4 == 0) goto L_0x0022
            r0 = 1
            java.lang.Object r4 = r5.compute()     // Catch:{ all -> 0x0031 }
            r1 = r4
            goto L_0x0013
        L_0x0022:
            if (r0 == 0) goto L_0x002b
            androidx.lifecycle.LiveData r3 = r5.getLiveData()     // Catch:{ all -> 0x0031 }
            r3.postValue(r1)     // Catch:{ all -> 0x0031 }
        L_0x002b:
            java.util.concurrent.atomic.AtomicBoolean r1 = r5.computing
            r1.set(r2)
            goto L_0x0038
        L_0x0031:
            r1 = move-exception
            java.util.concurrent.atomic.AtomicBoolean r3 = r5.computing
            r3.set(r2)
            throw r1
        L_0x0038:
            if (r0 == 0) goto L_0x0042
            java.util.concurrent.atomic.AtomicBoolean r1 = r5.invalid
            boolean r1 = r1.get()
            if (r1 != 0) goto L_0x0006
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.ComputableLiveData.refreshRunnable$lambda$0(androidx.lifecycle.ComputableLiveData):void");
    }

    /* access modifiers changed from: private */
    public static final void invalidationRunnable$lambda$1(ComputableLiveData this$0) {
        lu.f(this$0, "this$0");
        boolean isActive = this$0.getLiveData().hasActiveObservers();
        if (this$0.invalid.compareAndSet(false, true) && isActive) {
            this$0.executor.execute(this$0.refreshRunnable);
        }
    }

    public void invalidate() {
        ArchTaskExecutor.getInstance().executeOnMainThread(this.invalidationRunnable);
    }
}
