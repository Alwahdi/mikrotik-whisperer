package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.util.i;
import defpackage.m7;
import io.grpc.l;
import io.grpc.p;
import java.util.concurrent.Executor;

final class l extends m7 {
    private static final l.g<String> a = l.g.e("Authorization", io.grpc.l.a);

    /* renamed from: a  reason: collision with other field name */
    private final vd f2351a;

    l(vd provider) {
        this.f2351a = provider;
    }

    public void a(m7.b requestInfo, Executor executor, m7.a metadataApplier) {
        this.f2351a.a().h(executor, j.a(metadataApplier)).f(executor, k.a(metadataApplier));
    }

    static /* synthetic */ void b(m7.a metadataApplier, String token) {
        i.a("FirestoreCallCredentials", "Successfully fetched token.", new Object[0]);
        io.grpc.l metadata = new io.grpc.l();
        if (token != null) {
            l.g<String> gVar = a;
            metadata.o(gVar, "Bearer " + token);
        }
        metadataApplier.a(metadata);
    }

    static /* synthetic */ void c(m7.a metadataApplier, Exception exception) {
        if (exception instanceof el) {
            i.a("FirestoreCallCredentials", "Firebase Auth API not available, not using authentication.", new Object[0]);
            metadataApplier.a(new io.grpc.l());
        } else if (exception instanceof am) {
            i.a("FirestoreCallCredentials", "No user signed in, not using authentication.", new Object[0]);
            metadataApplier.a(new io.grpc.l());
        } else {
            i.d("FirestoreCallCredentials", "Failed to get token: %s.", exception);
            metadataApplier.b(p.i.p(exception));
        }
    }
}
