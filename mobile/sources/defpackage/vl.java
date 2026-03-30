package defpackage;

import com.google.firebase.heartbeatinfo.c;
import io.grpc.l;

/* renamed from: vl  reason: default package */
public class vl implements gq {
    private static final l.g<String> a;
    private static final l.g<String> b;

    /* renamed from: a  reason: collision with other field name */
    private final String f5395a = "fire-fst";

    /* renamed from: a  reason: collision with other field name */
    private final mb0<c> f5396a;

    /* renamed from: b  reason: collision with other field name */
    private final mb0<zt0> f5397b;

    static {
        l.d<String> dVar = l.a;
        a = l.g.e("x-firebase-client-log-type", dVar);
        b = l.g.e("x-firebase-client", dVar);
    }

    public vl(mb0<zt0> userAgentPublisherProvider, mb0<c> heartBeatInfoProvider) {
        this.f5397b = userAgentPublisherProvider;
        this.f5396a = heartBeatInfoProvider;
    }

    public void a(l metadata) {
        int heartBeatCode;
        if (this.f5396a.get() != null && this.f5397b.get() != null && (heartBeatCode = this.f5396a.get().a("fire-fst").getCode()) != 0) {
            metadata.o(a, Integer.toString(heartBeatCode));
            metadata.o(b, this.f5397b.get().a());
        }
    }
}
