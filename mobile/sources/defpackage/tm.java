package defpackage;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: tm  reason: default package */
public final class tm<T, U> extends n<T, U> {
    final mo<? super T, ? extends rb0<? extends U>> a;

    /* renamed from: a  reason: collision with other field name */
    final boolean f5104a;
    final int b;
    final int c;

    public tm(km<T> source, mo<? super T, ? extends rb0<? extends U>> mapper, boolean delayErrors, int maxConcurrency, int bufferSize) {
        super(source);
        this.a = mapper;
        this.f5104a = delayErrors;
        this.b = maxConcurrency;
        this.c = bufferSize;
    }

    /* access modifiers changed from: protected */
    public void z(ho0<? super U> s) {
        if (!cn.b(this.a, s, this.a)) {
            this.a.y(E(s, this.a, this.f5104a, this.b, this.c));
        }
    }

    public static <T, U> en<T> E(ho0<? super U> s, mo<? super T, ? extends rb0<? extends U>> mapper, boolean delayErrors, int maxConcurrency, int bufferSize) {
        return new b(s, mapper, delayErrors, maxConcurrency, bufferSize);
    }

    /* renamed from: tm$b */
    static final class b<T, U> extends AtomicInteger implements en<T>, jo0 {
        static final a<?, ?>[] a = new a[0];
        static final a<?, ?>[] b = new a[0];

        /* renamed from: a  reason: collision with other field name */
        final int f5110a;

        /* renamed from: a  reason: collision with other field name */
        long f5111a;

        /* renamed from: a  reason: collision with other field name */
        final ho0<? super U> f5112a;

        /* renamed from: a  reason: collision with other field name */
        final AtomicLong f5113a;

        /* renamed from: a  reason: collision with other field name */
        final AtomicReference<a<?, ?>[]> f5114a;

        /* renamed from: a  reason: collision with other field name */
        jo0 f5115a;

        /* renamed from: a  reason: collision with other field name */
        final mo<? super T, ? extends rb0<? extends U>> f5116a;

        /* renamed from: a  reason: collision with other field name */
        volatile tl0<U> f5117a;

        /* renamed from: a  reason: collision with other field name */
        final u4 f5118a = new u4();

        /* renamed from: a  reason: collision with other field name */
        final boolean f5119a;

        /* renamed from: b  reason: collision with other field name */
        final int f5120b;

        /* renamed from: b  reason: collision with other field name */
        long f5121b;

        /* renamed from: b  reason: collision with other field name */
        volatile boolean f5122b;
        int c;

        /* renamed from: c  reason: collision with other field name */
        volatile boolean f5123c;
        int d;
        final int e;

        b(ho0<? super U> actual, mo<? super T, ? extends rb0<? extends U>> mapper, boolean delayErrors, int maxConcurrency, int bufferSize) {
            AtomicReference<a<?, ?>[]> atomicReference = new AtomicReference<>();
            this.f5114a = atomicReference;
            this.f5113a = new AtomicLong();
            this.f5112a = actual;
            this.f5116a = mapper;
            this.f5119a = delayErrors;
            this.f5110a = maxConcurrency;
            this.f5120b = bufferSize;
            this.e = Math.max(1, maxConcurrency >> 1);
            atomicReference.lazySet(a);
        }

        public void d(jo0 s) {
            if (io.reactivex.internal.subscriptions.b.validate(this.f5115a, s)) {
                this.f5115a = s;
                this.f5112a.d(this);
                if (!this.f5123c) {
                    int i = this.f5110a;
                    if (i == Integer.MAX_VALUE) {
                        s.request(LocationRequestCompat.PASSIVE_INTERVAL);
                    } else {
                        s.request((long) i);
                    }
                }
            }
        }

        public void c(T t) {
            if (!this.f5122b) {
                try {
                    rb0 rb0 = (rb0) a40.c(this.f5116a.apply(t), "The mapper returned a null Publisher");
                    if (rb0 instanceof Callable) {
                        try {
                            U u = ((Callable) rb0).call();
                            if (u != null) {
                                r(u);
                            } else if (this.f5110a != Integer.MAX_VALUE && !this.f5123c) {
                                int i = this.d + 1;
                                this.d = i;
                                int i2 = this.e;
                                if (i == i2) {
                                    this.d = 0;
                                    this.f5115a.request((long) i2);
                                }
                            }
                        } catch (Throwable ex) {
                            oj.b(ex);
                            this.f5118a.a(ex);
                            j();
                        }
                    } else {
                        long j = this.f5111a;
                        this.f5111a = 1 + j;
                        FlowableFlatMap.InnerSubscriber<T, U> inner = new a<>(this, j);
                        if (b(inner)) {
                            rb0.a(inner);
                        }
                    }
                } catch (Throwable e2) {
                    oj.b(e2);
                    this.f5115a.cancel();
                    onError(e2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(a<T, U> inner) {
            FlowableFlatMap.InnerSubscriber<?, ?>[] a2;
            FlowableFlatMap.InnerSubscriber<?, ?>[] b2;
            do {
                a2 = (a[]) this.f5114a.get();
                if (a2 == b) {
                    inner.dispose();
                    return false;
                }
                int n = a2.length;
                b2 = new a[(n + 1)];
                System.arraycopy(a2, 0, b2, 0, n);
                b2[n] = inner;
            } while (!this.f5114a.compareAndSet(a2, b2));
            return true;
        }

        /* access modifiers changed from: package-private */
        public void p(a<T, U> inner) {
            FlowableFlatMap.InnerSubscriber<?, ?>[] a2;
            FlowableFlatMap.InnerSubscriber<?, ?>[] b2;
            do {
                a2 = (a[]) this.f5114a.get();
                if (a2 != b && a2 != a) {
                    int n = a2.length;
                    int j = -1;
                    int i = 0;
                    while (true) {
                        if (i >= n) {
                            break;
                        } else if (a2[i] == inner) {
                            j = i;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (j >= 0) {
                        if (n == 1) {
                            b2 = a;
                        } else {
                            FlowableFlatMap.InnerSubscriber<?, ?>[] b3 = new a[(n - 1)];
                            System.arraycopy(a2, 0, b3, 0, j);
                            System.arraycopy(a2, j + 1, b3, j, (n - j) - 1);
                            b2 = b3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.f5114a.compareAndSet(a2, b2));
        }

        /* access modifiers changed from: package-private */
        public ul0<U> m() {
            SimplePlainQueue<U> q = this.f5117a;
            if (q == null) {
                if (this.f5110a == Integer.MAX_VALUE) {
                    q = new sm0<>(this.f5120b);
                } else {
                    q = new rm0<>(this.f5110a);
                }
                this.f5117a = q;
            }
            return q;
        }

        /* access modifiers changed from: package-private */
        public void r(U value) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long r = this.f5113a.get();
                SimpleQueue<U> q = this.f5117a;
                if (r == 0 || (q != null && !q.isEmpty())) {
                    if (q == null) {
                        q = m();
                    }
                    if (!q.offer(value)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return;
                    }
                } else {
                    this.f5112a.c(value);
                    if (r != LocationRequestCompat.PASSIVE_INTERVAL) {
                        this.f5113a.decrementAndGet();
                    }
                    if (this.f5110a != Integer.MAX_VALUE && !this.f5123c) {
                        int i = this.d + 1;
                        this.d = i;
                        int i2 = this.e;
                        if (i == i2) {
                            this.d = 0;
                            this.f5115a.request((long) i2);
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!m().offer(value)) {
                onError(new IllegalStateException("Scalar queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            k();
        }

        /* access modifiers changed from: package-private */
        public ul0<U> l(a<T, U> inner) {
            SimpleQueue<U> q = inner.f5107a;
            if (q != null) {
                return q;
            }
            SimpleQueue<U> q2 = new rm0<>(this.f5120b);
            inner.f5107a = q2;
            return q2;
        }

        /* access modifiers changed from: package-private */
        public void q(U value, a<T, U> inner) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                SimpleQueue<U> q = inner.f5107a;
                if (q == null) {
                    q = new rm0<>(this.f5120b);
                    inner.f5107a = q;
                }
                if (!q.offer(value)) {
                    onError(new a20("Inner queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                long r = this.f5113a.get();
                SimpleQueue<U> q2 = inner.f5107a;
                if (r == 0 || (q2 != null && !q2.isEmpty())) {
                    if (q2 == null) {
                        q2 = l(inner);
                    }
                    if (!q2.offer(value)) {
                        onError(new a20("Inner queue full?!"));
                        return;
                    }
                } else {
                    this.f5112a.c(value);
                    if (r != LocationRequestCompat.PASSIVE_INTERVAL) {
                        this.f5113a.decrementAndGet();
                    }
                    inner.b(1);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            k();
        }

        public void onError(Throwable t) {
            if (this.f5122b) {
                of0.l(t);
            } else if (this.f5118a.a(t)) {
                this.f5122b = true;
                j();
            } else {
                of0.l(t);
            }
        }

        public void a() {
            if (!this.f5122b) {
                this.f5122b = true;
                j();
            }
        }

        public void request(long n) {
            if (io.reactivex.internal.subscriptions.b.validate(n)) {
                m5.a(this.f5113a, n);
                j();
            }
        }

        public void cancel() {
            SimpleQueue<U> q;
            if (!this.f5123c) {
                this.f5123c = true;
                this.f5115a.cancel();
                i();
                if (getAndIncrement() == 0 && (q = this.f5117a) != null) {
                    q.clear();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void j() {
            if (getAndIncrement() == 0) {
                k();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:158:0x01f6 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x00f7  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void k() {
            /*
                r33 = this;
                r1 = r33
                ho0<? super U> r2 = r1.f5112a
                r0 = 1
                r3 = r0
            L_0x0006:
                boolean r0 = r33.e()
                if (r0 == 0) goto L_0x000d
                return
            L_0x000d:
                tl0<U> r0 = r1.f5117a
                java.util.concurrent.atomic.AtomicLong r4 = r1.f5113a
                long r4 = r4.get()
                r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r9 != 0) goto L_0x0020
                r6 = 1
                goto L_0x0021
            L_0x0020:
                r6 = 0
            L_0x0021:
                r9 = 0
                r11 = 1
                r13 = 0
                if (r0 == 0) goto L_0x0077
            L_0x0029:
                r15 = 0
                r7 = 0
                r17 = r15
            L_0x002e:
                int r15 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
                if (r15 == 0) goto L_0x0052
                java.lang.Object r7 = r0.poll()
                boolean r15 = r33.e()
                if (r15 == 0) goto L_0x003d
                return
            L_0x003d:
                if (r7 != 0) goto L_0x0044
                r19 = r9
                r8 = r17
                goto L_0x0056
            L_0x0044:
                r2.c(r7)
                long r9 = r9 + r11
                r19 = r9
                r8 = r17
                long r17 = r8 + r11
                long r4 = r4 - r11
                r9 = r19
                goto L_0x002e
            L_0x0052:
                r19 = r9
                r8 = r17
            L_0x0056:
                int r10 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
                if (r10 == 0) goto L_0x0069
                if (r6 == 0) goto L_0x0062
                r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                goto L_0x0069
            L_0x0062:
                java.util.concurrent.atomic.AtomicLong r10 = r1.f5113a
                long r11 = -r8
                long r4 = r10.addAndGet(r11)
            L_0x0069:
                int r10 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
                if (r10 == 0) goto L_0x0075
                if (r7 != 0) goto L_0x0070
                goto L_0x0075
            L_0x0070:
                r9 = r19
                r11 = 1
                goto L_0x0029
            L_0x0075:
                r9 = r19
            L_0x0077:
                boolean r7 = r1.f5122b
                tl0<U> r8 = r1.f5117a
                java.util.concurrent.atomic.AtomicReference<tm$a<?, ?>[]> r0 = r1.f5114a
                java.lang.Object r0 = r0.get()
                r11 = r0
                tm$a[] r11 = (defpackage.tm.a[]) r11
                int r12 = r11.length
                if (r7 == 0) goto L_0x00a5
                if (r8 == 0) goto L_0x008f
                boolean r0 = r8.isEmpty()
                if (r0 == 0) goto L_0x00a5
            L_0x008f:
                if (r12 != 0) goto L_0x00a5
                u4 r0 = r1.f5118a
                java.lang.Throwable r0 = r0.b()
                java.lang.Throwable r13 = defpackage.nj.a
                if (r0 == r13) goto L_0x00a4
                if (r0 != 0) goto L_0x00a1
                r2.a()
                goto L_0x00a4
            L_0x00a1:
                r2.onError(r0)
            L_0x00a4:
                return
            L_0x00a5:
                r0 = 0
                if (r12 == 0) goto L_0x020b
                long r13 = r1.f5121b
                int r15 = r1.c
                if (r12 <= r15) goto L_0x00c0
                r21 = r0
                r0 = r11[r15]
                r22 = r4
                long r4 = r0.f5105a
                int r0 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
                if (r0 == 0) goto L_0x00bb
                goto L_0x00c4
            L_0x00bb:
                r24 = r7
                r25 = r8
                goto L_0x00f1
            L_0x00c0:
                r21 = r0
                r22 = r4
            L_0x00c4:
                if (r12 > r15) goto L_0x00c7
                r15 = 0
            L_0x00c7:
                r0 = r15
                r4 = 0
            L_0x00c9:
                if (r4 >= r12) goto L_0x00e4
                r5 = r11[r0]
                r24 = r7
                r25 = r8
                long r7 = r5.f5105a
                int r5 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
                if (r5 != 0) goto L_0x00d8
                goto L_0x00e8
            L_0x00d8:
                int r0 = r0 + 1
                if (r0 != r12) goto L_0x00dd
                r0 = 0
            L_0x00dd:
                int r4 = r4 + 1
                r7 = r24
                r8 = r25
                goto L_0x00c9
            L_0x00e4:
                r24 = r7
                r25 = r8
            L_0x00e8:
                r15 = r0
                r1.c = r0
                r4 = r11[r0]
                long r4 = r4.f5105a
                r1.f5121b = r4
            L_0x00f1:
                r0 = r15
                r4 = 0
                r5 = r4
                r4 = r0
            L_0x00f5:
                if (r5 >= r12) goto L_0x01f6
                boolean r0 = r33.e()
                if (r0 == 0) goto L_0x00fe
                return
            L_0x00fe:
                r7 = r11[r4]
                r0 = 0
            L_0x0101:
                boolean r8 = r33.e()
                if (r8 == 0) goto L_0x0108
                return
            L_0x0108:
                ul0<U> r8 = r7.f5107a
                if (r8 != 0) goto L_0x0116
                r30 = r2
                r32 = r5
                r31 = r6
                r28 = r13
                goto L_0x01b5
            L_0x0116:
                r26 = 0
                r28 = r13
                r13 = r26
                r26 = r22
                r22 = r0
            L_0x0120:
                r18 = 0
                int r0 = (r26 > r18 ? 1 : (r26 == r18 ? 0 : -1))
                if (r0 == 0) goto L_0x0175
                java.lang.Object r0 = r8.poll()     // Catch:{ all -> 0x0143 }
                if (r0 != 0) goto L_0x0130
                r30 = r2
                goto L_0x0179
            L_0x0130:
                r2.c(r0)
                boolean r22 = r33.e()
                if (r22 == 0) goto L_0x013a
                return
            L_0x013a:
                r16 = 1
                long r26 = r26 - r16
                long r13 = r13 + r16
                r22 = r0
                goto L_0x0120
            L_0x0143:
                r0 = move-exception
                r23 = r0
                r0 = r23
                defpackage.oj.b(r0)
                r7.dispose()
                r30 = r2
                u4 r2 = r1.f5118a
                r2.a(r0)
                boolean r2 = r1.f5119a
                if (r2 != 0) goto L_0x015e
                jo0 r2 = r1.f5115a
                r2.cancel()
            L_0x015e:
                boolean r2 = r33.e()
                if (r2 == 0) goto L_0x0165
                return
            L_0x0165:
                r1.p(r7)
                r2 = 1
                int r5 = r5 + 1
                r21 = r2
                r31 = r6
                r22 = r26
                r13 = 1
                goto L_0x01ec
            L_0x0175:
                r30 = r2
                r0 = r22
            L_0x0179:
                r18 = 0
                int r2 = (r13 > r18 ? 1 : (r13 == r18 ? 0 : -1))
                if (r2 == 0) goto L_0x019c
                if (r6 != 0) goto L_0x018d
                java.util.concurrent.atomic.AtomicLong r2 = r1.f5113a
                r32 = r5
                r31 = r6
                long r5 = -r13
                long r5 = r2.addAndGet(r5)
                goto L_0x0196
            L_0x018d:
                r32 = r5
                r31 = r6
                r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            L_0x0196:
                r7.b(r13)
                r22 = r5
                goto L_0x01a2
            L_0x019c:
                r32 = r5
                r31 = r6
                r22 = r26
            L_0x01a2:
                r5 = 0
                int r2 = (r22 > r5 ? 1 : (r22 == r5 ? 0 : -1))
                if (r2 == 0) goto L_0x01b5
                if (r0 != 0) goto L_0x01ab
                goto L_0x01b5
            L_0x01ab:
                r13 = r28
                r2 = r30
                r6 = r31
                r5 = r32
                goto L_0x0101
            L_0x01b5:
                boolean r2 = r7.f5108a
                ul0<U> r5 = r7.f5107a
                if (r2 == 0) goto L_0x01d7
                if (r5 == 0) goto L_0x01c7
                boolean r6 = r5.isEmpty()
                if (r6 == 0) goto L_0x01c4
                goto L_0x01c7
            L_0x01c4:
                r13 = 1
                goto L_0x01d9
            L_0x01c7:
                r1.p(r7)
                boolean r6 = r33.e()
                if (r6 == 0) goto L_0x01d1
                return
            L_0x01d1:
                r13 = 1
                long r9 = r9 + r13
                r21 = 1
                goto L_0x01d9
            L_0x01d7:
                r13 = 1
            L_0x01d9:
                r16 = 0
                int r6 = (r22 > r16 ? 1 : (r22 == r16 ? 0 : -1))
                if (r6 != 0) goto L_0x01e2
                r0 = r21
                goto L_0x0200
            L_0x01e2:
                int r4 = r4 + 1
                if (r4 != r12) goto L_0x01ea
                r4 = 0
                r5 = r32
                goto L_0x01ec
            L_0x01ea:
                r5 = r32
            L_0x01ec:
                r2 = 1
                int r5 = r5 + r2
                r13 = r28
                r2 = r30
                r6 = r31
                goto L_0x00f5
            L_0x01f6:
                r30 = r2
                r32 = r5
                r31 = r6
                r28 = r13
                r0 = r21
            L_0x0200:
                r1.c = r4
                r2 = r11[r4]
                long r5 = r2.f5105a
                r1.f5121b = r5
                r4 = r22
                goto L_0x0217
            L_0x020b:
                r21 = r0
                r30 = r2
                r22 = r4
                r31 = r6
                r24 = r7
                r25 = r8
            L_0x0217:
                r6 = 0
                int r2 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
                if (r2 == 0) goto L_0x0226
                boolean r2 = r1.f5123c
                if (r2 != 0) goto L_0x0226
                jo0 r2 = r1.f5115a
                r2.request(r9)
            L_0x0226:
                if (r0 == 0) goto L_0x022c
                r2 = r30
                goto L_0x0006
            L_0x022c:
                int r2 = -r3
                int r3 = r1.addAndGet(r2)
                if (r3 != 0) goto L_0x0235
                return
            L_0x0235:
                r2 = r30
                goto L_0x0006
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.tm.b.k():void");
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            if (this.f5123c) {
                h();
                return true;
            } else if (this.f5119a || this.f5118a.get() == null) {
                return false;
            } else {
                h();
                Throwable ex = this.f5118a.b();
                if (ex != nj.a) {
                    this.f5112a.onError(ex);
                }
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public void h() {
            SimpleQueue<U> q = this.f5117a;
            if (q != null) {
                q.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void i() {
            FlowableFlatMap.InnerSubscriber<?, ?>[] a2;
            FlowableFlatMap.InnerSubscriber<?, ?>[] a3 = (a[]) this.f5114a.get();
            FlowableFlatMap.InnerSubscriber<?, ?>[] innerSubscriberArr = b;
            if (a3 != innerSubscriberArr && (a2 = (a[]) this.f5114a.getAndSet(innerSubscriberArr)) != innerSubscriberArr) {
                for (FlowableFlatMap.InnerSubscriber<?, ?> inner : a2) {
                    inner.dispose();
                }
                Throwable ex = this.f5118a.b();
                if (ex != null && ex != nj.a) {
                    of0.l(ex);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void o(a<T, U> inner, Throwable t) {
            if (this.f5118a.a(t)) {
                inner.f5108a = true;
                if (!this.f5119a) {
                    this.f5115a.cancel();
                    for (FlowableFlatMap.InnerSubscriber<?, ?> a2 : (a[]) this.f5114a.getAndSet(b)) {
                        a2.dispose();
                    }
                }
                j();
                return;
            }
            of0.l(t);
        }
    }

    /* renamed from: tm$a */
    static final class a<T, U> extends AtomicReference<jo0> implements en<U>, yg {
        final int a;

        /* renamed from: a  reason: collision with other field name */
        final long f5105a;

        /* renamed from: a  reason: collision with other field name */
        final b<T, U> f5106a;

        /* renamed from: a  reason: collision with other field name */
        volatile ul0<U> f5107a;

        /* renamed from: a  reason: collision with other field name */
        volatile boolean f5108a;
        final int b;

        /* renamed from: b  reason: collision with other field name */
        long f5109b;
        int c;

        a(b<T, U> parent, long id) {
            this.f5105a = id;
            this.f5106a = parent;
            int i = parent.f5120b;
            this.b = i;
            this.a = i >> 2;
        }

        public void d(jo0 s) {
            if (io.reactivex.internal.subscriptions.b.setOnce(this, s)) {
                if (s instanceof wb0) {
                    QueueSubscription<U> qs = (wb0) s;
                    int m = qs.requestFusion(7);
                    if (m == 1) {
                        this.c = m;
                        this.f5107a = qs;
                        this.f5108a = true;
                        this.f5106a.j();
                        return;
                    } else if (m == 2) {
                        this.c = m;
                        this.f5107a = qs;
                    }
                }
                s.request((long) this.b);
            }
        }

        public void c(U t) {
            if (this.c != 2) {
                this.f5106a.q(t, this);
            } else {
                this.f5106a.j();
            }
        }

        public void onError(Throwable t) {
            lazySet(io.reactivex.internal.subscriptions.b.CANCELLED);
            this.f5106a.o(this, t);
        }

        public void a() {
            this.f5108a = true;
            this.f5106a.j();
        }

        /* access modifiers changed from: package-private */
        public void b(long n) {
            if (this.c != 1) {
                long p = this.f5109b + n;
                if (p >= ((long) this.a)) {
                    this.f5109b = 0;
                    ((jo0) get()).request(p);
                    return;
                }
                this.f5109b = p;
            }
        }

        public void dispose() {
            io.reactivex.internal.subscriptions.b.cancel(this);
        }
    }
}
