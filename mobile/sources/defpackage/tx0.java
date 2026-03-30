package defpackage;

import android.app.Activity;
import android.content.Intent;

/* renamed from: tx0  reason: default package */
final class tx0 extends lg {
    private final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    private final /* synthetic */ Activity f5178a;

    /* renamed from: a  reason: collision with other field name */
    private final /* synthetic */ Intent f5179a;

    tx0(Intent intent, Activity activity, int i) {
        this.f5179a = intent;
        this.f5178a = activity;
        this.a = i;
    }

    public final void b() {
        Intent intent = this.f5179a;
        if (intent != null) {
            this.f5178a.startActivityForResult(intent, this.a);
        }
    }
}
