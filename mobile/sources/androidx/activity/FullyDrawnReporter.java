package androidx.activity;

import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public final class FullyDrawnReporter {
    private final Executor executor;
    private final Object lock = new Object();
    @GuardedBy("lock")
    private final List<tn<jt0>> onReportCallbacks = new ArrayList();
    private final tn<jt0> reportFullyDrawn;
    @GuardedBy("lock")
    private boolean reportPosted;
    private final Runnable reportRunnable = new sn(this);
    @GuardedBy("lock")
    private boolean reportedFullyDrawn;
    @GuardedBy("lock")
    private int reporterCount;

    public FullyDrawnReporter(Executor executor2, tn<jt0> reportFullyDrawn2) {
        lu.f(executor2, "executor");
        lu.f(reportFullyDrawn2, "reportFullyDrawn");
        this.executor = executor2;
        this.reportFullyDrawn = reportFullyDrawn2;
    }

    public final boolean isFullyDrawnReported() {
        boolean z;
        synchronized (this.lock) {
            z = this.reportedFullyDrawn;
        }
        return z;
    }

    /* access modifiers changed from: private */
    public static final void reportRunnable$lambda$2(FullyDrawnReporter this$0) {
        lu.f(this$0, "this$0");
        synchronized (this$0.lock) {
            this$0.reportPosted = false;
            if (this$0.reporterCount == 0 && !this$0.reportedFullyDrawn) {
                this$0.reportFullyDrawn.invoke();
                this$0.fullyDrawnReported();
            }
            jt0 jt0 = jt0.a;
        }
    }

    public final void addReporter() {
        synchronized (this.lock) {
            if (!this.reportedFullyDrawn) {
                this.reporterCount++;
            }
            jt0 jt0 = jt0.a;
        }
    }

    public final void removeReporter() {
        int i;
        synchronized (this.lock) {
            if (!this.reportedFullyDrawn && (i = this.reporterCount) > 0) {
                this.reporterCount = i - 1;
                postWhenReportersAreDone();
            }
            jt0 jt0 = jt0.a;
        }
    }

    public final void addOnReportDrawnListener(tn<jt0> callback) {
        boolean callImmediately;
        lu.f(callback, "callback");
        synchronized (this.lock) {
            if (this.reportedFullyDrawn) {
                callImmediately = true;
            } else {
                this.onReportCallbacks.add(callback);
                callImmediately = false;
            }
        }
        if (callImmediately) {
            callback.invoke();
        }
    }

    public final void removeOnReportDrawnListener(tn<jt0> callback) {
        lu.f(callback, "callback");
        synchronized (this.lock) {
            this.onReportCallbacks.remove(callback);
            jt0 jt0 = jt0.a;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void fullyDrawnReported() {
        synchronized (this.lock) {
            this.reportedFullyDrawn = true;
            for (tn it : this.onReportCallbacks) {
                it.invoke();
            }
            this.onReportCallbacks.clear();
            jt0 jt0 = jt0.a;
        }
    }

    private final void postWhenReportersAreDone() {
        if (!this.reportPosted && this.reporterCount == 0) {
            this.reportPosted = true;
            this.executor.execute(this.reportRunnable);
        }
    }
}
