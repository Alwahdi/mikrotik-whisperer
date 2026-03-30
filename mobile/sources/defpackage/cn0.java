package defpackage;

import defpackage.a9;
import io.grpc.l;
import io.grpc.p;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: cn0  reason: default package */
public final class cn0 {
    public static final cn0 a = new cn0(new mn0[0]);

    /* renamed from: a  reason: collision with other field name */
    private final AtomicBoolean f345a = new AtomicBoolean(false);

    /* renamed from: a  reason: collision with other field name */
    private final mn0[] f346a;

    public static cn0 h(n7 callOptions, v4 transportAttrs, l headers) {
        List<a9.a> i = callOptions.i();
        if (i.isEmpty()) {
            return a;
        }
        a9.b info = a9.b.a().c(transportAttrs).b(callOptions).a();
        mn0[] tracers = new mn0[i.size()];
        for (int i2 = 0; i2 < tracers.length; i2++) {
            tracers[i2] = i.get(i2).a(info, headers);
        }
        return new cn0(tracers);
    }

    cn0(mn0[] tracers) {
        this.f346a = tracers;
    }

    public void c() {
        for (mn0 tracer : this.f346a) {
            ((a9) tracer).l();
        }
    }

    public void a() {
        for (mn0 tracer : this.f346a) {
            ((a9) tracer).j();
        }
    }

    public void b(l trailers) {
        for (mn0 tracer : this.f346a) {
            ((a9) tracer).k(trailers);
        }
    }

    public void m(p status) {
        if (this.f345a.compareAndSet(false, true)) {
            for (mn0 tracer : this.f346a) {
                tracer.i(status);
            }
        }
    }

    public void i(int seqNo) {
        for (mn0 tracer : this.f346a) {
            tracer.e(seqNo);
        }
    }

    public void d(int seqNo) {
        for (mn0 tracer : this.f346a) {
            tracer.a(seqNo);
        }
    }

    public void j(int seqNo, long optionalWireSize, long optionalUncompressedSize) {
        for (mn0 tracer : this.f346a) {
            tracer.f(seqNo, optionalWireSize, optionalUncompressedSize);
        }
    }

    public void e(int seqNo, long optionalWireSize, long optionalUncompressedSize) {
        for (mn0 tracer : this.f346a) {
            tracer.b(seqNo, optionalWireSize, optionalUncompressedSize);
        }
    }

    public void k(long bytes) {
        for (mn0 tracer : this.f346a) {
            tracer.g(bytes);
        }
    }

    public void l(long bytes) {
        for (mn0 tracer : this.f346a) {
            tracer.h(bytes);
        }
    }

    public void f(long bytes) {
        for (mn0 tracer : this.f346a) {
            tracer.c(bytes);
        }
    }

    public void g(long bytes) {
        for (mn0 tracer : this.f346a) {
            tracer.d(bytes);
        }
    }
}
