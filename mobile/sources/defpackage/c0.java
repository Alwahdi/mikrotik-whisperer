package defpackage;

import defpackage.c0;
import java.util.concurrent.Executor;

/* renamed from: c0  reason: default package */
public abstract class c0<S extends c0<S>> {
    private final e8 a;

    /* renamed from: a  reason: collision with other field name */
    private final n7 f279a;

    /* access modifiers changed from: protected */
    public abstract S a(e8 e8Var, n7 n7Var);

    protected c0(e8 channel) {
        this(channel, n7.a);
    }

    protected c0(e8 channel, n7 callOptions) {
        this.a = (e8) v90.o(channel, "channel");
        this.f279a = (n7) v90.o(callOptions, "callOptions");
    }

    public final n7 b() {
        return this.f279a;
    }

    public final S d(Executor executor) {
        return a(this.a, this.f279a.m(executor));
    }

    public final S c(m7 credentials) {
        return a(this.a, this.f279a.k(credentials));
    }
}
