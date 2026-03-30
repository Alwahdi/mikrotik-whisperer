package defpackage;

import defpackage.au;
import java.util.List;

/* renamed from: b  reason: default package */
public final class b implements au.a {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final List<au> f129a;

    /* renamed from: a  reason: collision with other field name */
    private final ns f130a;

    public b(List<? extends au> interceptors, int index, ns request) {
        lu.g(interceptors, "interceptors");
        lu.g(request, "request");
        this.f129a = interceptors;
        this.a = index;
        this.f130a = request;
    }

    public ns b() {
        return this.f130a;
    }

    public os a(ns request) {
        lu.g(request, "request");
        if (this.a < this.f129a.size()) {
            return this.f129a.get(this.a).intercept(new b(this.f129a, this.a + 1, request));
        }
        throw new AssertionError("no interceptors added to the chain");
    }
}
