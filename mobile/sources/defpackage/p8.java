package defpackage;

import android.widget.CompoundButton;
import com.google.android.material.chip.Chip;

/* renamed from: p8  reason: default package */
public final /* synthetic */ class p8 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ Chip a;

    public /* synthetic */ p8(Chip chip) {
        this.a = chip;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.a.t(compoundButton, z);
    }
}
