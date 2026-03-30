package com.google.android.material.transformation;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.transformation.FabTransformationBehavior;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {
    private Map<View, Integer> a;

    public FabTransformationSheetBehavior() {
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /* access modifiers changed from: protected */
    public FabTransformationBehavior.b v(Context context, boolean expanded) {
        int specRes;
        if (expanded) {
            specRes = xb0.mtrl_fab_transformation_sheet_expand_spec;
        } else {
            specRes = xb0.mtrl_fab_transformation_sheet_collapse_spec;
        }
        FabTransformationBehavior.b spec = new FabTransformationBehavior.b();
        spec.a = g20.c(context, specRes);
        spec.f2140a = new s90(17, 0.0f, 0.0f);
        return spec;
    }

    /* access modifiers changed from: protected */
    public boolean d(View dependency, View child, boolean expanded, boolean animated) {
        x(child, expanded);
        return super.d(dependency, child, expanded, animated);
    }

    private void x(View sheet, boolean expanded) {
        ViewParent viewParent = sheet.getParent();
        if (viewParent instanceof CoordinatorLayout) {
            CoordinatorLayout parent = (CoordinatorLayout) viewParent;
            int childCount = parent.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && expanded) {
                this.a = new HashMap(childCount);
            }
            for (int i = 0; i < childCount; i++) {
                View child = parent.getChildAt(i);
                boolean hasScrimBehavior = (child.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) && (((CoordinatorLayout.LayoutParams) child.getLayoutParams()).getBehavior() instanceof FabTransformationScrimBehavior);
                if (child != sheet && !hasScrimBehavior) {
                    if (!expanded) {
                        Map<View, Integer> map = this.a;
                        if (map != null && map.containsKey(child)) {
                            ViewCompat.setImportantForAccessibility(child, this.a.get(child).intValue());
                        }
                    } else {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.a.put(child, Integer.valueOf(child.getImportantForAccessibility()));
                        }
                        ViewCompat.setImportantForAccessibility(child, 4);
                    }
                }
            }
            if (!expanded) {
                this.a = null;
            }
        }
    }
}
