package com.google.firebase.firestore.remote;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.util.c;
import io.grpc.ClientCall;
import io.grpc.b;
import io.grpc.g;
import io.grpc.l;
import io.grpc.m;
import io.grpc.p;

class n {
    private static final l.g<String> a;
    private static final l.g<String> b;

    /* renamed from: a  reason: collision with other field name */
    private final v f2354a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final c f2355a;

    /* renamed from: a  reason: collision with other field name */
    private final gq f2356a;

    /* renamed from: a  reason: collision with other field name */
    private final String f2357a;

    /* renamed from: a  reason: collision with other field name */
    private final vd f2358a;

    static {
        l.d<String> dVar = l.a;
        a = l.g.e("x-goog-api-client", dVar);
        b = l.g.e("google-cloud-resource-prefix", dVar);
    }

    n(c asyncQueue, Context context, vd credentialsProvider, we databaseInfo, gq metadataProvider) {
        this.f2355a = asyncQueue;
        this.f2356a = metadataProvider;
        this.f2358a = credentialsProvider;
        this.f2354a = new v(asyncQueue, context, databaseInfo, new l(credentialsProvider));
        ve databaseId = databaseInfo.a();
        this.f2357a = String.format("projects/%s/databases/%s", new Object[]{databaseId.d(), databaseId.c()});
    }

    /* access modifiers changed from: package-private */
    public <ReqT, RespT> io.grpc.b<ReqT, RespT> e(m<ReqT, RespT> method, w<RespT> observer) {
        ClientCall<ReqT, RespT>[] call = {null};
        Task<ClientCall<ReqT, RespT>> clientCall = this.f2354a.b(method);
        clientCall.d(this.f2355a.h(), m.b(this, call, observer));
        return new b(call, clientCall);
    }

    static /* synthetic */ void c(n nVar, io.grpc.b[] call, w observer, eq0 result) {
        call[0] = (io.grpc.b) result.n();
        call[0].d(new a(observer, call), nVar.d());
        observer.b();
        call[0].b(1);
    }

    class a extends b.a {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ w f2359a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ io.grpc.b[] f2360a;

        a(w wVar, io.grpc.b[] bVarArr) {
            this.f2359a = wVar;
            this.f2360a = bVarArr;
        }

        public void b(l headers) {
            try {
                this.f2359a.d(headers);
            } catch (Throwable t) {
                n.this.f2355a.l(t);
            }
        }

        public void c(Object message) {
            try {
                this.f2359a.c(message);
                this.f2360a[0].b(1);
            } catch (Throwable t) {
                n.this.f2355a.l(t);
            }
        }

        public void a(p status, l trailers) {
            try {
                this.f2359a.a(status);
            } catch (Throwable t) {
                n.this.f2355a.l(t);
            }
        }

        public void d() {
        }
    }

    class b extends g<ReqT, RespT> {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ eq0 f2361a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ io.grpc.b[] f2362a;

        b(io.grpc.b[] bVarArr, eq0 eq0) {
            this.f2362a = bVarArr;
            this.f2361a = eq0;
        }

        /* access modifiers changed from: protected */
        public io.grpc.b<ReqT, RespT> e() {
            n4.d(this.f2362a[0] != null, "ClientCall used before onOpen() callback", new Object[0]);
            return this.f2362a[0];
        }

        public void a() {
            if (this.f2362a[0] == null) {
                this.f2361a.h(n.this.f2355a.h(), o.a());
            } else {
                super.a();
            }
        }
    }

    public void b() {
        this.f2358a.b();
    }

    private l d() {
        l headers = new l();
        headers.o(a, "gl-java/ fire/21.4.0 grpc/");
        headers.o(b, this.f2357a);
        gq gqVar = this.f2356a;
        if (gqVar != null) {
            gqVar.a(headers);
        }
        return headers;
    }
}
