package androidx.activity.contextaware;

import android.content.Context;
import defpackage.se0;

public final class ContextAwareKt$withContextAvailable$2$listener$1 implements OnContextAvailableListener {
    final /* synthetic */ r7<R> $co;
    final /* synthetic */ vn<Context, R> $onContextAvailable;

    public ContextAwareKt$withContextAvailable$2$listener$1(r7<R> $co2, vn<Context, R> $onContextAvailable2) {
        this.$co = $co2;
        this.$onContextAvailable = $onContextAvailable2;
    }

    public void onContextAvailable(Context context) {
        Object obj;
        lu.f(context, "context");
        r7<R> r7Var = this.$co;
        vn<Context, R> vnVar = this.$onContextAvailable;
        try {
            se0.a aVar = se0.a;
            obj = se0.a(vnVar.invoke(context));
        } catch (Throwable th) {
            se0.a aVar2 = se0.a;
            obj = se0.a(te0.a(th));
        }
        r7Var.resumeWith(obj);
    }
}
