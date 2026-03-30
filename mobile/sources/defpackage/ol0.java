package defpackage;

import android.view.View;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* renamed from: ol0  reason: default package */
public final /* synthetic */ class ol0 implements AccessibilityViewCommand {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ SideSheetBehavior f4554a;

    public /* synthetic */ ol0(SideSheetBehavior sideSheetBehavior, int i) {
        this.f4554a = sideSheetBehavior;
        this.a = i;
    }

    public final boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        return this.f4554a.M(this.a, view, commandArguments);
    }
}
