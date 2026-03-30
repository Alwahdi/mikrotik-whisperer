package defpackage;

import defpackage.yc;

/* renamed from: zc  reason: default package */
public abstract class zc {
    public static final yc e(hd $this$newCoroutineContext, yc context) {
        yc combined = a($this$newCoroutineContext.getCoroutineContext(), context, true);
        yc debug = af.c() ? combined.plus(new fd(af.b().incrementAndGet())) : combined;
        return (combined == xg.a() || combined.get(tc.a) != null) ? debug : debug.plus(xg.a());
    }

    public static final yc d(yc $this$newCoroutineContext, yc addedContext) {
        if (!c(addedContext)) {
            return $this$newCoroutineContext.plus(addedContext);
        }
        return a($this$newCoroutineContext, addedContext, false);
    }

    /* renamed from: zc$c */
    static final class c extends ow implements jo<Boolean, yc.b, Boolean> {
        public static final c a = new c();

        c() {
            super(2);
        }

        public final Boolean b(boolean result, yc.b it) {
            return Boolean.valueOf(result);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
            return b(((Boolean) p1).booleanValue(), (yc.b) p2);
        }
    }

    private static final boolean c(yc $this$hasCopyableElements) {
        return ((Boolean) $this$hasCopyableElements.fold(false, c.a)).booleanValue();
    }

    private static final yc a(yc originalContext, yc appendContext, boolean isNewCoroutine) {
        boolean hasElementsLeft = c(originalContext);
        boolean hasElementsRight = c(appendContext);
        if (!hasElementsLeft && !hasElementsRight) {
            return originalContext.plus(appendContext);
        }
        sd0 leftoverContext = new sd0();
        leftoverContext.a = appendContext;
        gi giVar = gi.a;
        yc folded = (yc) originalContext.fold(giVar, new b(leftoverContext, isNewCoroutine));
        if (hasElementsRight) {
            leftoverContext.a = ((yc) leftoverContext.a).fold(giVar, a.a);
        }
        return folded.plus((yc) leftoverContext.a);
    }

    /* renamed from: zc$b */
    static final class b extends ow implements jo<yc, yc.b, yc> {
        final /* synthetic */ sd0<yc> a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ boolean f6017a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(sd0<yc> sd0, boolean z) {
            super(2);
            this.a = sd0;
            this.f6017a = z;
        }

        /* renamed from: b */
        public final yc invoke(yc result, yc.b element) {
            return result.plus(element);
        }
    }

    /* renamed from: zc$a */
    static final class a extends ow implements jo<yc, yc.b, yc> {
        public static final a a = new a();

        a() {
            super(2);
        }

        /* renamed from: b */
        public final yc invoke(yc result, yc.b element) {
            return result.plus(element);
        }
    }

    public static final et0<?> g(rc<?> $this$updateUndispatchedCompletion, yc context, Object oldValue) {
        if (!($this$updateUndispatchedCompletion instanceof id)) {
            return null;
        }
        if (!(context.get(gt0.a) != null)) {
            return null;
        }
        et0 completion = f((id) $this$updateUndispatchedCompletion);
        if (completion != null) {
            completion.r0(context, oldValue);
        }
        return completion;
    }

    public static final et0<?> f(id $this$undispatchedCompletion) {
        id completion = $this$undispatchedCompletion;
        while (!(completion instanceof ug) && (completion = completion.getCallerFrame()) != null) {
            if (completion instanceof et0) {
                return (et0) completion;
            }
        }
        return null;
    }

    public static final String b(yc $this$coroutineName) {
        fd coroutineId;
        if (!af.c() || (coroutineId = (fd) $this$coroutineName.get(fd.a)) == null) {
            return null;
        }
        b6.a($this$coroutineName.get(gd.a));
        return "coroutine" + '#' + coroutineId.X();
    }
}
