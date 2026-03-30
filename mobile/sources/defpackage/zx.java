package defpackage;

import com.google.firebase.firestore.core.b0;
import com.google.firebase.firestore.model.b;
import com.google.firebase.firestore.model.c;
import com.google.firebase.firestore.model.d;
import com.google.firebase.firestore.model.e;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.proto.a;
import com.google.firebase.firestore.proto.b;
import com.google.firebase.firestore.proto.c;
import com.google.firebase.firestore.proto.d;
import com.google.firebase.firestore.remote.a0;
import com.google.firestore.v1.c;
import defpackage.dw0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: zx  reason: default package */
public final class zx {
    private final a0 a;

    public zx(a0 rpcSerializer) {
        this.a = rpcSerializer;
    }

    /* access modifiers changed from: package-private */
    public com.google.firebase.firestore.proto.a h(c document) {
        a.b builder = com.google.firebase.firestore.proto.a.U();
        if (document instanceof d) {
            d noDocument = (d) document;
            builder.z(j(noDocument));
            builder.y(noDocument.d());
        } else if (document instanceof b) {
            b existingDocument = (b) document;
            if (existingDocument.f() != null) {
                builder.x(existingDocument.f());
            } else {
                builder.x(g(existingDocument));
            }
            builder.y(existingDocument.g());
        } else if (document instanceof e) {
            builder.A(l((e) document));
            builder.y(true);
        } else {
            throw n4.a("Unknown document type %s", document.getClass().getCanonicalName());
        }
        return (com.google.firebase.firestore.proto.a) builder.q();
    }

    /* access modifiers changed from: package-private */
    public c b(com.google.firebase.firestore.proto.a proto) {
        switch (a.a[proto.Q().ordinal()]) {
            case 1:
                return a(proto.P(), proto.R());
            case 2:
                return d(proto.S(), proto.R());
            case 3:
                return f(proto.T());
            default:
                throw n4.a("Unknown MaybeDocument %s", proto);
        }
    }

    private com.google.firestore.v1.c g(b document) {
        c.b builder = com.google.firestore.v1.c.W();
        builder.y(this.a.M(document.a()));
        Iterator<Map.Entry<String, rk>> it = document.d().l().iterator();
        while (it.hasNext()) {
            Map.Entry<String, FieldValue> entry = it.next();
            builder.x(entry.getKey(), this.a.Z((rk) entry.getValue()));
        }
        builder.z(this.a.X(document.b().b()));
        return (com.google.firestore.v1.c) builder.q();
    }

    private b a(com.google.firestore.v1.c document, boolean hasCommittedMutations) {
        b.a aVar;
        mh key = this.a.m(document.S());
        hm0 version = this.a.y(document.T());
        if (hasCommittedMutations) {
            aVar = b.a.COMMITTED_MUTATIONS;
        } else {
            aVar = b.a.SYNCED;
        }
        a0 a0Var = this.a;
        a0Var.getClass();
        return new b(key, version, aVar, document, yx.a(a0Var));
    }

    private com.google.firebase.firestore.proto.b j(d document) {
        b.C0023b builder = com.google.firebase.firestore.proto.b.Q();
        builder.x(this.a.M(document.a()));
        builder.y(this.a.X(document.b().b()));
        return (com.google.firebase.firestore.proto.b) builder.q();
    }

    private d d(com.google.firebase.firestore.proto.b proto, boolean hasCommittedMutations) {
        return new d(this.a.m(proto.O()), this.a.y(proto.P()), hasCommittedMutations);
    }

    private com.google.firebase.firestore.proto.d l(e document) {
        d.b builder = com.google.firebase.firestore.proto.d.Q();
        builder.x(this.a.M(document.a()));
        builder.y(this.a.X(document.b().b()));
        return (com.google.firebase.firestore.proto.d) builder.q();
    }

    private e f(com.google.firebase.firestore.proto.d proto) {
        return new e(this.a.m(proto.O()), this.a.y(proto.P()));
    }

    /* access modifiers changed from: package-private */
    public dw0 i(v20 batch) {
        dw0.b result = dw0.Z();
        result.z(batch.e());
        result.A(this.a.X(batch.g()));
        for (u20 mutation : batch.d()) {
            result.x(this.a.Q(mutation));
        }
        for (u20 mutation2 : batch.h()) {
            result.y(this.a.Q(mutation2));
        }
        return (dw0) result.q();
    }

    /* access modifiers changed from: package-private */
    public v20 c(dw0 batch) {
        int batchId = batch.V();
        pr0 localWriteTime = this.a.v(batch.W());
        int baseMutationsCount = batch.U();
        List<Mutation> baseMutations = new ArrayList<>(baseMutationsCount);
        for (int i = 0; i < baseMutationsCount; i++) {
            baseMutations.add(this.a.o(batch.T(i)));
        }
        int mutationsCount = batch.Y();
        List<Mutation> mutations = new ArrayList<>(mutationsCount);
        for (int i2 = 0; i2 < mutationsCount; i2++) {
            mutations.add(this.a.o(batch.X(i2)));
        }
        return new v20(batchId, localWriteTime, baseMutations, mutations);
    }

    /* access modifiers changed from: package-private */
    public com.google.firebase.firestore.proto.c k(bq0 targetData) {
        com.google.firebase.firestore.local.a aVar = com.google.firebase.firestore.local.a.LISTEN;
        n4.d(aVar.equals(targetData.b()), "Only queries with purpose %s may be stored, got %s", aVar, targetData.b());
        c.b result = com.google.firebase.firestore.proto.c.c0();
        result.F(targetData.g()).A(targetData.d()).z(this.a.a0(targetData.a())).E(this.a.a0(targetData.e())).D(targetData.c());
        b0 target = targetData.f();
        if (target.j()) {
            result.y(this.a.G(target));
        } else {
            result.B(this.a.U(target));
        }
        return (com.google.firebase.firestore.proto.c) result.q();
    }

    /* access modifiers changed from: package-private */
    public bq0 e(com.google.firebase.firestore.proto.c targetProto) {
        b0 target;
        int targetId = targetProto.a0();
        hm0 version = this.a.y(targetProto.Z());
        hm0 lastLimboFreeSnapshotVersion = this.a.y(targetProto.V());
        com.google.protobuf.e resumeToken = targetProto.Y();
        long sequenceNumber = targetProto.W();
        switch (a.b[targetProto.b0().ordinal()]) {
            case 1:
                target = this.a.f(targetProto.U());
                break;
            case 2:
                target = this.a.t(targetProto.X());
                break;
            default:
                throw n4.a("Unknown targetType %d", targetProto.b0());
        }
        return new bq0(target, targetId, sequenceNumber, com.google.firebase.firestore.local.a.LISTEN, version, lastLimboFreeSnapshotVersion, resumeToken);
    }

    /* renamed from: zx$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[c.C0024c.values().length];
            b = iArr;
            try {
                iArr[c.C0024c.DOCUMENTS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[c.C0024c.QUERY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            int[] iArr2 = new int[a.c.values().length];
            a = iArr2;
            try {
                iArr2[a.c.DOCUMENT.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[a.c.NO_DOCUMENT.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[a.c.UNKNOWN_DOCUMENT.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
        }
    }
}
