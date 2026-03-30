package defpackage;

import java.util.HashMap;
import java.util.Map;

/* renamed from: b10  reason: default package */
public final class b10 extends c90 {
    private final c10 a = new c10(this);

    /* renamed from: a  reason: collision with other field name */
    private final d10 f132a = new d10(this);

    /* renamed from: a  reason: collision with other field name */
    private final Map<yt0, a10> f133a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    private td0 f134a;

    /* renamed from: a  reason: collision with other field name */
    private final z00 f135a = new z00();
    private boolean b;

    public static b10 j() {
        b10 persistence = new b10();
        persistence.n(new y00(persistence));
        return persistence;
    }

    private b10() {
    }

    public void i() {
        n4.d(!this.b, "MemoryPersistence double-started!", new Object[0]);
        this.b = true;
    }

    public boolean f() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public td0 c() {
        return this.f134a;
    }

    private void n(td0 delegate) {
        this.f134a = delegate;
    }

    /* access modifiers changed from: package-private */
    public x20 b(yt0 user) {
        a10 queue = this.f133a.get(user);
        if (queue != null) {
            return queue;
        }
        a10 queue2 = new a10(this);
        this.f133a.put(user, queue2);
        return queue2;
    }

    /* access modifiers changed from: package-private */
    public Iterable<a10> k() {
        return this.f133a.values();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public d10 e() {
        return this.f132a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public c10 d() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public ks a() {
        return this.f135a;
    }

    /* access modifiers changed from: package-private */
    public void h(String action, Runnable operation) {
        this.f134a.e();
        try {
            operation.run();
        } finally {
            this.f134a.k();
        }
    }

    /* access modifiers changed from: package-private */
    public <T> T g(String action, po0<T> operation) {
        this.f134a.e();
        try {
            return operation.get();
        } finally {
            this.f134a.k();
        }
    }
}
