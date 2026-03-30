package defpackage;

import android.content.Context;
import javax.inject.Provider;

/* renamed from: pj0  reason: default package */
public final class pj0 implements ik<oj0> {
    private final Provider<Context> a;
    private final Provider<Integer> b;

    public pj0(Provider<Context> contextProvider, Provider<Integer> schemaVersionProvider) {
        this.a = contextProvider;
        this.b = schemaVersionProvider;
    }

    /* renamed from: b */
    public oj0 get() {
        return new oj0(this.a.get(), this.b.get().intValue());
    }

    public static pj0 a(Provider<Context> contextProvider, Provider<Integer> schemaVersionProvider) {
        return new pj0(contextProvider, schemaVersionProvider);
    }
}
