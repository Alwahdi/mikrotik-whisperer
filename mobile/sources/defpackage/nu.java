package defpackage;

/* renamed from: nu  reason: default package */
abstract class nu {
    public static <T> rc<jt0> a(vn<? super rc<? super T>, ? extends Object> $this$createCoroutineUnintercepted, rc<? super T> completion) {
        rc<jt0> rcVar;
        lu.f($this$createCoroutineUnintercepted, "<this>");
        lu.f(completion, "completion");
        rc probeCompletion = df.a(completion);
        if ($this$createCoroutineUnintercepted instanceof kotlin.coroutines.jvm.internal.a) {
            return ((kotlin.coroutines.jvm.internal.a) $this$createCoroutineUnintercepted).create(probeCompletion);
        }
        yc context$iv = probeCompletion.getContext();
        if (context$iv == gi.a) {
            rcVar = new a(probeCompletion, $this$createCoroutineUnintercepted);
        } else {
            rcVar = new b(probeCompletion, context$iv, $this$createCoroutineUnintercepted);
        }
        return rcVar;
    }

    public static <R, T> rc<jt0> b(jo<? super R, ? super rc<? super T>, ? extends Object> $this$createCoroutineUnintercepted, R receiver, rc<? super T> completion) {
        rc<jt0> rcVar;
        lu.f($this$createCoroutineUnintercepted, "<this>");
        lu.f(completion, "completion");
        rc probeCompletion = df.a(completion);
        if ($this$createCoroutineUnintercepted instanceof kotlin.coroutines.jvm.internal.a) {
            return ((kotlin.coroutines.jvm.internal.a) $this$createCoroutineUnintercepted).create(receiver, probeCompletion);
        }
        yc context$iv = probeCompletion.getContext();
        if (context$iv == gi.a) {
            rcVar = new c(probeCompletion, $this$createCoroutineUnintercepted, receiver);
        } else {
            rcVar = new d(probeCompletion, context$iv, $this$createCoroutineUnintercepted, receiver);
        }
        return rcVar;
    }

    public static <T> rc<T> c(rc<? super T> $this$intercepted) {
        rc<Object> intercepted;
        lu.f($this$intercepted, "<this>");
        kotlin.coroutines.jvm.internal.b bVar = $this$intercepted instanceof kotlin.coroutines.jvm.internal.b ? (kotlin.coroutines.jvm.internal.b) $this$intercepted : null;
        return (bVar == null || (intercepted = bVar.intercepted()) == null) ? $this$intercepted : intercepted;
    }

    /* renamed from: nu$a */
    public static final class a extends qe0 {
        private int a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ vn f4460a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(rc $completion, vn vnVar) {
            super($completion);
            this.f4460a = vnVar;
            lu.d($completion, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        /* access modifiers changed from: protected */
        public Object invokeSuspend(Object result) {
            switch (this.a) {
                case 0:
                    this.a = 1;
                    te0.b(result);
                    lu.d(this.f4460a, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$0>, kotlin.Any?>");
                    return ((vn) zs0.a(this.f4460a, 1)).invoke(this);
                case 1:
                    this.a = 2;
                    te0.b(result);
                    return result;
                default:
                    throw new IllegalStateException("This coroutine had already completed".toString());
            }
        }
    }

    /* renamed from: nu$c */
    public static final class c extends qe0 {
        private int a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ Object f4462a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ jo f4463a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(rc $completion, jo joVar, Object obj) {
            super($completion);
            this.f4463a = joVar;
            this.f4462a = obj;
            lu.d($completion, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        /* access modifiers changed from: protected */
        public Object invokeSuspend(Object result) {
            switch (this.a) {
                case 0:
                    this.a = 1;
                    te0.b(result);
                    lu.d(this.f4463a, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                    return ((jo) zs0.a(this.f4463a, 2)).invoke(this.f4462a, this);
                case 1:
                    this.a = 2;
                    te0.b(result);
                    return result;
                default:
                    throw new IllegalStateException("This coroutine had already completed".toString());
            }
        }
    }

    /* renamed from: nu$b */
    public static final class b extends kotlin.coroutines.jvm.internal.b {
        private int a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ vn f4461a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(rc $completion, yc $context, vn vnVar) {
            super($completion, $context);
            this.f4461a = vnVar;
            lu.d($completion, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        /* access modifiers changed from: protected */
        public Object invokeSuspend(Object result) {
            switch (this.a) {
                case 0:
                    this.a = 1;
                    te0.b(result);
                    lu.d(this.f4461a, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$0>, kotlin.Any?>");
                    return ((vn) zs0.a(this.f4461a, 1)).invoke(this);
                case 1:
                    this.a = 2;
                    te0.b(result);
                    return result;
                default:
                    throw new IllegalStateException("This coroutine had already completed".toString());
            }
        }
    }

    /* renamed from: nu$d */
    public static final class d extends kotlin.coroutines.jvm.internal.b {
        private int a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ Object f4464a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ jo f4465a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(rc $completion, yc $context, jo joVar, Object obj) {
            super($completion, $context);
            this.f4465a = joVar;
            this.f4464a = obj;
            lu.d($completion, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        /* access modifiers changed from: protected */
        public Object invokeSuspend(Object result) {
            switch (this.a) {
                case 0:
                    this.a = 1;
                    te0.b(result);
                    lu.d(this.f4465a, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                    return ((jo) zs0.a(this.f4465a, 2)).invoke(this.f4464a, this);
                case 1:
                    this.a = 2;
                    te0.b(result);
                    return result;
                default:
                    throw new IllegalStateException("This coroutine had already completed".toString());
            }
        }
    }
}
