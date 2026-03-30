package defpackage;

import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* renamed from: rf  reason: default package */
public class rf implements cj0 {
    private static final Logger a = Logger.getLogger(ls0.class.getName());

    /* renamed from: a  reason: collision with other field name */
    private final h5 f4890a;

    /* renamed from: a  reason: collision with other field name */
    private final hj f4891a;

    /* renamed from: a  reason: collision with other field name */
    private final Executor f4892a;

    /* renamed from: a  reason: collision with other field name */
    private final xo0 f4893a;

    /* renamed from: a  reason: collision with other field name */
    private final yv0 f4894a;

    public rf(Executor executor, h5 backendRegistry, yv0 workScheduler, hj eventStore, xo0 guard) {
        this.f4892a = executor;
        this.f4890a = backendRegistry;
        this.f4894a = workScheduler;
        this.f4891a = eventStore;
        this.f4893a = guard;
    }

    public void a(es0 transportContext, aj event, os0 callback) {
        this.f4892a.execute(of.a(this, transportContext, callback, event));
    }

    static /* synthetic */ void c(rf rfVar, es0 transportContext, os0 callback, aj event) {
        try {
            ds0 transportBackend = rfVar.f4890a.a(transportContext.b());
            if (transportBackend == null) {
                String errorMsg = String.format("Transport backend '%s' is not registered", new Object[]{transportContext.b()});
                a.warning(errorMsg);
                callback.a(new IllegalArgumentException(errorMsg));
                return;
            }
            rfVar.f4893a.c(pf.b(rfVar, transportContext, transportBackend.a(event)));
            callback.a((Exception) null);
        } catch (Exception e) {
            Logger logger = a;
            logger.warning("Error scheduling event " + e.getMessage());
            callback.a(e);
        }
    }

    static /* synthetic */ Object b(rf rfVar, es0 transportContext, aj decoratedEvent) {
        rfVar.f4891a.z(transportContext, decoratedEvent);
        rfVar.f4894a.a(transportContext, 1);
        return null;
    }
}
