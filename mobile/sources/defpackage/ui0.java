package defpackage;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.savedstate.SavedStateRegistry;

/* renamed from: ui0  reason: default package */
public final /* synthetic */ class ui0 implements SavedStateRegistry.SavedStateProvider {
    public final /* synthetic */ SavedStateHandle a;

    public /* synthetic */ ui0(SavedStateHandle savedStateHandle) {
        this.a = savedStateHandle;
    }

    public final Bundle saveState() {
        return SavedStateHandle.savedStateProvider$lambda$0(this.a);
    }
}
