package defpackage;

import android.content.Context;
import androidx.activity.ComponentActivity;
import androidx.activity.contextaware.OnContextAvailableListener;

/* renamed from: eb  reason: default package */
public final /* synthetic */ class eb implements OnContextAvailableListener {
    public final /* synthetic */ ComponentActivity a;

    public /* synthetic */ eb(ComponentActivity componentActivity) {
        this.a = componentActivity;
    }

    public final void onContextAvailable(Context context) {
        this.a.lambda$new$2(context);
    }
}
