package io.grpc.internal;

import defpackage.m7;
import io.grpc.internal.q;
import io.grpc.l;
import io.grpc.m;
import io.grpc.p;
import java.net.SocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

final class j implements q {
    private final q a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final Executor f3453a;

    j(q delegate, Executor appExecutor) {
        this.a = (q) v90.o(delegate, "delegate");
        this.f3453a = (Executor) v90.o(appExecutor, "appExecutor");
    }

    public bc M(SocketAddress serverAddress, q.a options, io.grpc.a channelLogger) {
        return new a(this.a.M(serverAddress, options, channelLogger), options.a());
    }

    public ScheduledExecutorService u() {
        return this.a.u();
    }

    public void close() {
        this.a.close();
    }

    private class a extends d0 {
        private final bc a;

        /* renamed from: a  reason: collision with other field name */
        private final String f3455a;

        a(bc delegate, String authority) {
            this.a = (bc) v90.o(delegate, "delegate");
            this.f3455a = (String) v90.o(authority, "authority");
        }

        /* access modifiers changed from: protected */
        public bc a() {
            return this.a;
        }

        public z8 f(m<?, ?> method, l headers, n7 callOptions) {
            m7 creds = callOptions.c();
            if (creds == null) {
                return this.a.f(method, headers, callOptions);
            }
            w0 applier = new w0(this.a, method, headers, callOptions);
            try {
                creds.a(new C0045a(method, callOptions), (Executor) f20.a(callOptions.e(), j.this.f3453a), applier);
            } catch (Throwable t) {
                applier.b(p.i.q("Credentials should use fail() instead of throwing exceptions").p(t));
            }
            return applier.d();
        }

        /* renamed from: io.grpc.internal.j$a$a  reason: collision with other inner class name */
        class C0045a extends m7.b {

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ m f3456a;

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ n7 f3457a;

            C0045a(m mVar, n7 n7Var) {
                this.f3456a = mVar;
                this.f3457a = n7Var;
            }
        }
    }
}
