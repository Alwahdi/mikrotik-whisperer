package defpackage;

import android.view.View;
import defpackage.au;

/* renamed from: a  reason: default package */
public final class a implements au {
    public os intercept(au.a chain) {
        lu.g(chain, "chain");
        ns request = chain.b();
        View fallbackView = request.c().onCreateView(request.e(), request.d(), request.b(), request.a());
        return new os(fallbackView, fallbackView != null ? fallbackView.getClass().getName() : request.d(), request.b(), request.a());
    }
}
