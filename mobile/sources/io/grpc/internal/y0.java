package io.grpc.internal;

import defpackage.b30;
import java.net.URI;

final class y0 extends b30.c {
    private final b30.c a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final String f3790a;

    y0(b30.c delegate, String authorityOverride) {
        this.a = delegate;
        this.f3790a = authorityOverride;
    }

    public b30 b(URI targetUri, b30.a args) {
        b30 resolver = this.a.b(targetUri, args);
        if (resolver == null) {
            return null;
        }
        return new a(resolver);
    }

    class a extends g0 {
        a(b30 delegate) {
            super(delegate);
        }

        public String a() {
            return y0.this.f3790a;
        }
    }

    public String a() {
        return this.a.a();
    }
}
