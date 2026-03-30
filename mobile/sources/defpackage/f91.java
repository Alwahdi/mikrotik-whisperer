package defpackage;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* renamed from: f91  reason: default package */
final class f91 implements Runnable {
    private final /* synthetic */ a91 a;

    /* renamed from: a  reason: collision with other field name */
    private final /* synthetic */ eq0 f2960a;

    f91(a91 a91, eq0 eq0) {
        this.a = a91;
        this.f2960a = eq0;
    }

    public final void run() {
        try {
            eq0 a2 = this.a.f37a.a(this.f2960a.n());
            if (a2 == null) {
                this.a.b(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = jq0.b;
            a2.h(executor, this.a);
            a2.f(executor, this.a);
            a2.a(executor, this.a);
        } catch (mf0 e) {
            if (e.getCause() instanceof Exception) {
                this.a.b((Exception) e.getCause());
            } else {
                this.a.b(e);
            }
        } catch (CancellationException e2) {
            this.a.c();
        } catch (Exception e3) {
            this.a.b(e3);
        }
    }
}
