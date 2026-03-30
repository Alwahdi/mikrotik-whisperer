package defpackage;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.savedstate.SavedStateRegistry;

/* renamed from: fb  reason: default package */
public final /* synthetic */ class fb implements SavedStateRegistry.SavedStateProvider {
    public final /* synthetic */ ComponentActivity a;

    public /* synthetic */ fb(ComponentActivity componentActivity) {
        this.a = componentActivity;
    }

    public final Bundle saveState() {
        return this.a.lambda$new$1();
    }
}
