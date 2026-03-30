package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class b {
    static final /* synthetic */ AtomicReferenceFieldUpdater a;
    static final /* synthetic */ AtomicReferenceFieldUpdater b;
    private static final /* synthetic */ AtomicReferenceFieldUpdater c;
    volatile /* synthetic */ Object _next = this;
    volatile /* synthetic */ Object _prev = this;
    private volatile /* synthetic */ Object _removedRef = null;

    static {
        Class<Object> cls = Object.class;
        Class<b> cls2 = b.class;
        a = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_next");
        b = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_prev");
        c = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_removedRef");
    }

    private final c q() {
        c cVar = (c) this._removedRef;
        if (cVar != null) {
            return cVar;
        }
        c it = new c(this);
        c.lazySet(this, it);
        return it;
    }

    public static abstract class a extends t4<b> {
        public final b a;
        public b b;

        public a(b newNode) {
            this.a = newNode;
        }

        /* renamed from: h */
        public void d(b affected, Object failure) {
            boolean success = failure == null;
            b update = success ? this.a : this.b;
            if (update != null && w.a(b.a, affected, this, update) && success) {
                b bVar = this.a;
                b bVar2 = this.b;
                lu.c(bVar2);
                bVar.j(bVar2);
            }
        }
    }

    public boolean n() {
        return k() instanceof c;
    }

    public final Object k() {
        while (true) {
            Object next = this._next;
            if (!(next instanceof u40)) {
                return next;
            }
            ((u40) next).c(this);
        }
    }

    public final b l() {
        return a.b(k());
    }

    public final b m() {
        b h = h((u40) null);
        return h == null ? i((b) this._prev) : h;
    }

    private final b i(b current) {
        b bVar = current;
        while (bVar.n()) {
            bVar = (b) bVar._prev;
        }
        return bVar;
    }

    public final boolean g(b node) {
        b.lazySet(node, this);
        a.lazySet(node, this);
        while (k() == this) {
            if (w.a(a, this, this, node)) {
                node.j(this);
                return true;
            }
        }
        return false;
    }

    public final int r(b node, b next, a condAdd) {
        b.lazySet(node, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        atomicReferenceFieldUpdater.lazySet(node, next);
        condAdd.b = next;
        if (!w.a(atomicReferenceFieldUpdater, this, next, condAdd)) {
            return 0;
        }
        return condAdd.c(this) == null ? 1 : 2;
    }

    public boolean o() {
        return p() == null;
    }

    public final b p() {
        Object next;
        do {
            next = k();
            if (next instanceof c) {
                return ((c) next).a;
            }
            if (next == this) {
                return (b) next;
            }
        } while (!w.a(a, this, next, ((b) next).q()));
        ((b) next).h((u40) null);
        return null;
    }

    /* access modifiers changed from: private */
    public final void j(b next) {
        b nextPrev;
        b $this$loop$iv = next;
        do {
            nextPrev = (b) $this$loop$iv._prev;
            if (k() != next) {
                return;
            }
        } while (!w.a(b, next, nextPrev, this));
        if (n()) {
            next.h((u40) null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: u40} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: u40} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: kotlinx.coroutines.internal.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: kotlinx.coroutines.internal.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: kotlinx.coroutines.internal.c} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlinx.coroutines.internal.b h(defpackage.u40 r7) {
        /*
            r6 = this;
        L_0x0001:
            java.lang.Object r0 = r6._prev
            kotlinx.coroutines.internal.b r0 = (kotlinx.coroutines.internal.b) r0
            r1 = r0
            r2 = 0
        L_0x0007:
            java.lang.Object r3 = r1._next
            if (r3 != r6) goto L_0x001a
            if (r0 != r1) goto L_0x0010
            return r1
        L_0x0010:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = b
            boolean r4 = defpackage.w.a(r4, r6, r0, r1)
            if (r4 != 0) goto L_0x0019
            goto L_0x0001
        L_0x0019:
            return r1
        L_0x001a:
            boolean r4 = r6.n()
            r5 = 0
            if (r4 == 0) goto L_0x0022
            return r5
        L_0x0022:
            if (r3 != r7) goto L_0x0025
            return r1
        L_0x0025:
            boolean r4 = r3 instanceof defpackage.u40
            if (r4 == 0) goto L_0x003c
            if (r7 == 0) goto L_0x0035
            r4 = r3
            u40 r4 = (defpackage.u40) r4
            boolean r4 = r7.b(r4)
            if (r4 == 0) goto L_0x0035
            return r5
        L_0x0035:
            r4 = r3
            u40 r4 = (defpackage.u40) r4
            r4.c(r1)
            goto L_0x0001
        L_0x003c:
            boolean r4 = r3 instanceof kotlinx.coroutines.internal.c
            if (r4 == 0) goto L_0x0059
            if (r2 == 0) goto L_0x0053
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = a
            r5 = r3
            kotlinx.coroutines.internal.c r5 = (kotlinx.coroutines.internal.c) r5
            kotlinx.coroutines.internal.b r5 = r5.a
            boolean r4 = defpackage.w.a(r4, r2, r1, r5)
            if (r4 != 0) goto L_0x0050
            goto L_0x0001
        L_0x0050:
            r1 = r2
            r2 = 0
            goto L_0x0007
        L_0x0053:
            java.lang.Object r4 = r1._prev
            r1 = r4
            kotlinx.coroutines.internal.b r1 = (kotlinx.coroutines.internal.b) r1
            goto L_0x0007
        L_0x0059:
            r2 = r1
            r1 = r3
            kotlinx.coroutines.internal.b r1 = (kotlinx.coroutines.internal.b) r1
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.b.h(u40):kotlinx.coroutines.internal.b");
    }

    /* renamed from: kotlinx.coroutines.internal.b$b  reason: collision with other inner class name */
    /* synthetic */ class C0052b extends fb0 {
        C0052b(Object obj) {
            super(obj, ef.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", 1);
        }

        public Object get() {
            return ef.a(this.receiver);
        }
    }

    public String toString() {
        return new C0052b(this) + '@' + ef.b(this);
    }
}
