package defpackage;

import defpackage.ux;
import io.grpc.e;
import io.grpc.p;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: f90  reason: default package */
final class f90 extends ux {
    /* access modifiers changed from: private */
    public final ux.d a;

    /* renamed from: a  reason: collision with other field name */
    private ux.h f2956a;

    f90(ux.d helper) {
        this.a = (ux.d) v90.o(helper, "helper");
    }

    public void c(ux.g resolvedAddresses) {
        List<ti> a2 = resolvedAddresses.a();
        ux.h hVar = this.f2956a;
        if (hVar == null) {
            ux.h subchannel = this.a.a(ux.b.c().c(a2).a());
            subchannel.g(new a(subchannel));
            this.f2956a = subchannel;
            this.a.d(e.CONNECTING, new c(ux.e.h(subchannel)));
            subchannel.e();
            return;
        }
        hVar.h(a2);
    }

    /* renamed from: f90$a */
    class a implements ux.j {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ ux.h f2957a;

        a(ux.h hVar) {
            this.f2957a = hVar;
        }

        public void a(fc stateInfo) {
            f90.this.h(this.f2957a, stateInfo);
        }
    }

    public void b(p error) {
        ux.h hVar = this.f2956a;
        if (hVar != null) {
            hVar.f();
            this.f2956a = null;
        }
        this.a.d(e.TRANSIENT_FAILURE, new c(ux.e.f(error)));
    }

    /* access modifiers changed from: private */
    public void h(ux.h subchannel, fc stateInfo) {
        ux.i picker;
        e currentState = stateInfo.c();
        if (currentState != e.SHUTDOWN) {
            switch (b.a[currentState.ordinal()]) {
                case 1:
                    picker = new d(subchannel);
                    break;
                case 2:
                    picker = new c(ux.e.g());
                    break;
                case 3:
                    picker = new c(ux.e.h(subchannel));
                    break;
                case 4:
                    picker = new c(ux.e.f(stateInfo.d()));
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported state:" + currentState);
            }
            this.a.d(currentState, picker);
        }
    }

    /* renamed from: f90$b */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[e.values().length];
            a = iArr;
            try {
                iArr[e.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[e.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[e.READY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[e.TRANSIENT_FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public void e() {
        ux.h hVar = this.f2956a;
        if (hVar != null) {
            hVar.f();
        }
    }

    public void d() {
        ux.h hVar = this.f2956a;
        if (hVar != null) {
            hVar.e();
        }
    }

    /* renamed from: f90$c */
    private static final class c extends ux.i {
        private final ux.e a;

        c(ux.e result) {
            this.a = (ux.e) v90.o(result, "result");
        }

        public ux.e a(ux.f args) {
            return this.a;
        }

        public String toString() {
            return f20.b(c.class).d("result", this.a).toString();
        }
    }

    /* renamed from: f90$d */
    private final class d extends ux.i {

        /* renamed from: a  reason: collision with other field name */
        private final AtomicBoolean f2958a = new AtomicBoolean(false);
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public final ux.h f2959a;

        d(ux.h subchannel) {
            this.f2959a = (ux.h) v90.o(subchannel, "subchannel");
        }

        /* renamed from: f90$d$a */
        class a implements Runnable {
            a() {
            }

            public void run() {
                d.this.f2959a.e();
            }
        }

        public ux.e a(ux.f args) {
            if (this.f2958a.compareAndSet(false, true)) {
                f90.this.a.c().execute(new a());
            }
            return ux.e.g();
        }
    }
}
