package io.grpc.internal;

import io.grpc.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;

final class r {
    private volatile e a = e.IDLE;

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<a> f3664a = new ArrayList<>();

    r() {
    }

    /* access modifiers changed from: package-private */
    public void c(Runnable callback, Executor executor, e source) {
        v90.o(callback, "callback");
        v90.o(executor, "executor");
        v90.o(source, "source");
        a stateChangeListener = new a(callback, executor);
        if (this.a != source) {
            stateChangeListener.a();
        } else {
            this.f3664a.add(stateChangeListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(e newState) {
        v90.o(newState, "newState");
        if (this.a != newState && this.a != e.SHUTDOWN) {
            this.a = newState;
            if (!this.f3664a.isEmpty()) {
                ArrayList<a> arrayList = this.f3664a;
                this.f3664a = new ArrayList<>();
                Iterator<a> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public e a() {
        e stateCopy = this.a;
        if (stateCopy != null) {
            return stateCopy;
        }
        throw new UnsupportedOperationException("Channel state API is not implemented");
    }

    private static final class a {
        final Runnable a;

        /* renamed from: a  reason: collision with other field name */
        final Executor f3665a;

        a(Runnable callback, Executor executor) {
            this.a = callback;
            this.f3665a = executor;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f3665a.execute(this.a);
        }
    }
}
