package androidx.activity;

import android.view.View;

public final class ViewTreeFullyDrawnReporterOwner {
    public static final void set(View $this$setViewTreeFullyDrawnReporterOwner, FullyDrawnReporterOwner fullyDrawnReporterOwner) {
        lu.f($this$setViewTreeFullyDrawnReporterOwner, "<this>");
        lu.f(fullyDrawnReporterOwner, "fullyDrawnReporterOwner");
        $this$setViewTreeFullyDrawnReporterOwner.setTag(R.id.report_drawn, fullyDrawnReporterOwner);
    }

    public static final FullyDrawnReporterOwner get(View $this$findViewTreeFullyDrawnReporterOwner) {
        lu.f($this$findViewTreeFullyDrawnReporterOwner, "<this>");
        return (FullyDrawnReporterOwner) kk0.h(kk0.i(ik0.e($this$findViewTreeFullyDrawnReporterOwner, ViewTreeFullyDrawnReporterOwner$findViewTreeFullyDrawnReporterOwner$1.INSTANCE), ViewTreeFullyDrawnReporterOwner$findViewTreeFullyDrawnReporterOwner$2.INSTANCE));
    }
}
