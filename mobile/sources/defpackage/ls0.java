package defpackage;

import android.content.Context;
import java.util.Collections;
import java.util.Set;

/* renamed from: ls0  reason: default package */
public class ls0 implements ks0 {
    private static volatile ms0 a = null;

    /* renamed from: a  reason: collision with other field name */
    private final c9 f4276a;

    /* renamed from: a  reason: collision with other field name */
    private final cj0 f4277a;

    /* renamed from: a  reason: collision with other field name */
    private final ut0 f4278a;
    private final c9 b;

    ls0(c9 eventClock, c9 uptimeClock, cj0 scheduler, ut0 uploader, vv0 initializer) {
        this.f4276a = eventClock;
        this.b = uptimeClock;
        this.f4277a = scheduler;
        this.f4278a = uploader;
        initializer.a();
    }

    public static void f(Context applicationContext) {
        if (a == null) {
            synchronized (ls0.class) {
                if (a == null) {
                    a = me.o().b(applicationContext).a();
                }
            }
        }
    }

    public static ls0 c() {
        ms0 localRef = a;
        if (localRef != null) {
            return localRef.f();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public fs0 g(gg destination) {
        return new gs0(d(destination), es0.a().b(destination.getName()).c(destination.a()).a(), this);
    }

    private static Set<qi> d(gg destination) {
        if (destination instanceof ni) {
            return Collections.unmodifiableSet(((ni) destination).b());
        }
        return Collections.singleton(qi.b("proto"));
    }

    public ut0 e() {
        return this.f4278a;
    }

    public void a(zj0 request, os0 callback) {
        this.f4277a.a(request.f().e(request.c().c()), b(request), callback);
    }

    private aj b(zj0 request) {
        return aj.a().i(this.f4276a.a()).k(this.b.a()).j(request.g()).h(new pi(request.b(), request.d())).g(request.c().a()).d();
    }
}
