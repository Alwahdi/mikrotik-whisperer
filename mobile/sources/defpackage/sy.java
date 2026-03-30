package defpackage;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: sy  reason: default package */
public final class sy<E> {
    private static final /* synthetic */ AtomicLongFieldUpdater a;

    /* renamed from: a  reason: collision with other field name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f5061a;

    /* renamed from: a  reason: collision with other field name */
    public static final a f5062a = new a((Cif) null);

    /* renamed from: a  reason: collision with other field name */
    public static final uo0 f5063a = new uo0("REMOVE_FROZEN");
    private volatile /* synthetic */ Object _next = null;
    private volatile /* synthetic */ long _state = 0;

    /* renamed from: a  reason: collision with other field name */
    private final int f5064a;

    /* renamed from: a  reason: collision with other field name */
    private /* synthetic */ AtomicReferenceArray f5065a;

    /* renamed from: a  reason: collision with other field name */
    private final boolean f5066a;
    private final int b;

    public sy(int capacity, boolean singleConsumer) {
        this.f5064a = capacity;
        this.f5066a = singleConsumer;
        int i = capacity - 1;
        this.b = i;
        this.f5065a = new AtomicReferenceArray(capacity);
        boolean z = false;
        if (i <= 1073741823) {
            if (!((i & capacity) == 0 ? true : z)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final boolean g() {
        a aVar = f5062a;
        long $this$withState$iv = this._state;
        if (((int) ((1073741823 & $this$withState$iv) >> 0)) == ((int) ((1152921503533105152L & $this$withState$iv) >> 30))) {
            return true;
        }
        return false;
    }

    public final int f() {
        a aVar = f5062a;
        long $this$withState$iv = this._state;
        return (((int) ((1152921503533105152L & $this$withState$iv) >> 30)) - ((int) ((1073741823 & $this$withState$iv) >> 0))) & 1073741823;
    }

    public final boolean d() {
        long cur$iv;
        long state;
        do {
            cur$iv = this._state;
            state = cur$iv;
            if ((state & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & state) != 0) {
                return false;
            }
        } while (!a.compareAndSet(this, cur$iv, state | 2305843009213693952L));
        return true;
    }

    public final int a(E element) {
        sy e;
        E e2 = element;
        while (true) {
            long state = this._state;
            if ((3458764513820540928L & state) != 0) {
                return f5062a.a(state);
            }
            a aVar = f5062a;
            long $this$withState$iv = state;
            int head$iv = (int) (($this$withState$iv & 1073741823) >> 0);
            int tail$iv = (int) (($this$withState$iv & 1152921503533105152L) >> 30);
            int head = head$iv;
            int tail = tail$iv;
            int mask = this.b;
            if (((tail + 2) & mask) == (head & mask)) {
                return 1;
            }
            if (this.f5066a || this.f5065a.get(tail & mask) == null) {
                int tail2 = tail;
                int mask2 = mask;
                int i = head$iv;
                int i2 = tail$iv;
                if (a.compareAndSet(this, state, f5062a.c(state, (tail + 1) & 1073741823))) {
                    this.f5065a.set(tail2 & mask2, e2);
                    sy cur = this;
                    while ((cur._state & 1152921504606846976L) != 0 && (e = cur.i().e(tail2, e2)) != null) {
                        cur = e;
                    }
                    return 0;
                }
            } else {
                int i3 = this.f5064a;
                if (i3 < 1024 || (1073741823 & (tail - head)) > (i3 >> 1)) {
                    return 1;
                }
            }
        }
        return 1;
    }

    private final sy<E> e(int index, E element) {
        Object old = this.f5065a.get(this.b & index);
        if (!(old instanceof b) || ((b) old).a != index) {
            return null;
        }
        this.f5065a.set(this.b & index, element);
        return this;
    }

    public final Object j() {
        int $i$f$loop;
        sy $this$loop$iv = this;
        int $i$f$loop2 = 0;
        while (true) {
            long state = $this$loop$iv._state;
            if ((1152921504606846976L & state) != 0) {
                return f5063a;
            }
            a aVar = f5062a;
            long $this$withState$iv = state;
            int head$iv = (int) ((1073741823 & $this$withState$iv) >> 0);
            int tail$iv = (int) ((1152921503533105152L & $this$withState$iv) >> 30);
            int head = head$iv;
            int i = this.b;
            sy $this$loop$iv2 = $this$loop$iv;
            if ((tail$iv & i) == (head & i)) {
                return null;
            }
            Object element = this.f5065a.get(i & head);
            if (element == null) {
                if (this.f5066a) {
                    return null;
                }
                $i$f$loop = $i$f$loop2;
            } else if (element instanceof b) {
                return null;
            } else {
                int newHead = 1073741823 & (head + 1);
                int newHead2 = newHead;
                Object element2 = element;
                $i$f$loop = $i$f$loop2;
                int head2 = head;
                int i2 = head$iv;
                int i3 = tail$iv;
                if (a.compareAndSet(this, state, f5062a.b(state, newHead))) {
                    this.f5065a.set(this.b & head2, (Object) null);
                    return element2;
                } else if (this.f5066a) {
                    sy cur = this;
                    while (true) {
                        sy k = cur.k(head2, newHead2);
                        if (k == null) {
                            return element2;
                        }
                        cur = k;
                    }
                }
            }
            $this$loop$iv = $this$loop$iv2;
            $i$f$loop2 = $i$f$loop;
        }
    }

    private final sy<E> k(int oldHead, int newHead) {
        sy $this$loop$iv = this;
        while (true) {
            long state = $this$loop$iv._state;
            a aVar = f5062a;
            long $this$withState$iv = state;
            boolean z = false;
            int head$iv = (int) ((1073741823 & $this$withState$iv) >> 0);
            int tail$iv = (int) ((1152921503533105152L & $this$withState$iv) >> 30);
            int head = head$iv;
            if (af.a()) {
                if (head == oldHead) {
                    z = true;
                }
                if (!z) {
                    throw new AssertionError();
                }
            } else {
                int i = oldHead;
            }
            if ((state & 1152921504606846976L) != 0) {
                return i();
            }
            sy $this$loop$iv2 = $this$loop$iv;
            int head2 = head;
            int i2 = head$iv;
            int i3 = tail$iv;
            if (a.compareAndSet(this, state, f5062a.b(state, newHead))) {
                this.f5065a.set(head2 & this.b, (Object) null);
                return null;
            }
            $this$loop$iv = $this$loop$iv2;
        }
    }

    public final sy<E> i() {
        return c(h());
    }

    private final long h() {
        long cur$iv;
        long upd$iv;
        do {
            cur$iv = this._state;
            long state = cur$iv;
            if ((state & 1152921504606846976L) != 0) {
                return state;
            }
            upd$iv = state | 1152921504606846976L;
        } while (!a.compareAndSet(this, cur$iv, upd$iv));
        return upd$iv;
    }

    private final sy<E> c(long state) {
        while (true) {
            sy next = (sy) this._next;
            if (next != null) {
                return next;
            }
            w.a(f5061a, this, (Object) null, b(state));
        }
    }

    private final sy<E> b(long state) {
        sy next = new sy(this.f5064a * 2, this.f5066a);
        a this_$iv = f5062a;
        long $this$withState$iv = state;
        int tail = (int) ((1152921503533105152L & $this$withState$iv) >> 30);
        int index = (int) ((1073741823 & $this$withState$iv) >> 0);
        while (true) {
            int i = this.b;
            if ((index & i) != (tail & i)) {
                Object value = this.f5065a.get(i & index);
                if (value == null) {
                    value = new b(index);
                }
                next.f5065a.set(next.b & index, value);
                index++;
            } else {
                a aVar = this_$iv;
                long j = $this$withState$iv;
                next._state = f5062a.d(state, 1152921504606846976L);
                return next;
            }
        }
    }

    /* renamed from: sy$b */
    public static final class b {
        public final int a;

        public b(int index) {
            this.a = index;
        }
    }

    /* renamed from: sy$a */
    public static final class a {
        public /* synthetic */ a(Cif ifVar) {
            this();
        }

        private a() {
        }

        public final long d(long $this$wo, long other) {
            return (~other) & $this$wo;
        }

        public final long b(long $this$updateHead, int newHead) {
            return d($this$updateHead, 1073741823) | (((long) newHead) << 0);
        }

        public final long c(long $this$updateTail, int newTail) {
            return d($this$updateTail, 1152921503533105152L) | (((long) newTail) << 30);
        }

        public final int a(long $this$addFailReason) {
            return (2305843009213693952L & $this$addFailReason) != 0 ? 2 : 1;
        }
    }

    static {
        Class<sy> cls = sy.class;
        f5061a = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_next");
        a = AtomicLongFieldUpdater.newUpdater(cls, "_state");
    }
}
