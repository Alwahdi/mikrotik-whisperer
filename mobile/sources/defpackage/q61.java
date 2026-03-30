package defpackage;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.a;

/* renamed from: q61  reason: default package */
public final class q61<ResultT, CallbackT> implements x51<ResultT> {
    private final gq0<ResultT> a;

    /* renamed from: a  reason: collision with other field name */
    private final w51<ResultT, CallbackT> f4772a;

    public q61(w51<ResultT, CallbackT> w51, gq0<ResultT> gq0) {
        this.f4772a = w51;
        this.a = gq0;
    }

    public final void a(ResultT resultt, Status status) {
        dm dmVar;
        y90.k(this.a, "completion source cannot be null");
        if (status != null) {
            w51<ResultT, CallbackT> w51 = this.f4772a;
            if (w51.f5444a != null) {
                gq0<ResultT> gq0 = this.a;
                FirebaseAuth instance = FirebaseAuth.getInstance(w51.f5438a);
                w51<ResultT, CallbackT> w512 = this.f4772a;
                p51 p51 = w512.f5444a;
                if ("reauthenticateWithCredential".equals(w512.d()) || "reauthenticateWithCredentialWithData".equals(this.f4772a.d())) {
                    dmVar = this.f4772a.f5437a;
                } else {
                    dmVar = null;
                }
                gq0.b(y41.e(instance, p51, dmVar));
                return;
            }
            a aVar = w51.f5436a;
            if (aVar != null) {
                this.a.b(y41.a(status, aVar, w51.c, w51.d));
            } else {
                this.a.b(y41.b(status));
            }
        } else {
            this.a.c(resultt);
        }
    }
}
