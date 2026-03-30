package defpackage;

import android.view.View;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: xp0  reason: default package */
public abstract class xp0 {
    public static void a(View view, int width) {
        ((RecyclerView.LayoutParams) view.getLayoutParams()).width = width;
        view.measure(View.MeasureSpec.makeMeasureSpec(width, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), BasicMeasure.EXACTLY));
        view.requestLayout();
    }
}
