package androidx.activity;

import kotlin.coroutines.jvm.internal.b;

@bf(c = "androidx.activity.FullyDrawnReporterKt", f = "FullyDrawnReporter.kt", l = {185}, m = "reportWhenComplete")
final class FullyDrawnReporterKt$reportWhenComplete$1 extends b {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    FullyDrawnReporterKt$reportWhenComplete$1(rc<? super FullyDrawnReporterKt$reportWhenComplete$1> rcVar) {
        super(rcVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FullyDrawnReporterKt.reportWhenComplete((FullyDrawnReporter) null, (vn<? super rc<? super jt0>, ? extends Object>) null, this);
    }
}
