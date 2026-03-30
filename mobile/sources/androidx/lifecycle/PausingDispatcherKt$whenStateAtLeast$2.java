package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

@bf(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.kt", l = {203}, m = "invokeSuspend")
final class PausingDispatcherKt$whenStateAtLeast$2 extends to0 implements jo<hd, rc<? super T>, Object> {
    final /* synthetic */ jo<hd, rc<? super T>, Object> $block;
    final /* synthetic */ Lifecycle.State $minState;
    final /* synthetic */ Lifecycle $this_whenStateAtLeast;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PausingDispatcherKt$whenStateAtLeast$2(Lifecycle lifecycle, Lifecycle.State state, jo<? super hd, ? super rc<? super T>, ? extends Object> joVar, rc<? super PausingDispatcherKt$whenStateAtLeast$2> rcVar) {
        super(2, rcVar);
        this.$this_whenStateAtLeast = lifecycle;
        this.$minState = state;
        this.$block = joVar;
    }

    public final rc<jt0> create(Object obj, rc<?> rcVar) {
        PausingDispatcherKt$whenStateAtLeast$2 pausingDispatcherKt$whenStateAtLeast$2 = new PausingDispatcherKt$whenStateAtLeast$2(this.$this_whenStateAtLeast, this.$minState, this.$block, rcVar);
        pausingDispatcherKt$whenStateAtLeast$2.L$0 = obj;
        return pausingDispatcherKt$whenStateAtLeast$2;
    }

    public final Object invoke(hd hdVar, rc<? super T> rcVar) {
        return ((PausingDispatcherKt$whenStateAtLeast$2) create(hdVar, rcVar)).invokeSuspend(jt0.a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0058, code lost:
        r2.finish();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005c, code lost:
        return r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = defpackage.ou.d()
            int r1 = r9.label
            switch(r1) {
                case 0: goto L_0x001f;
                case 1: goto L_0x0011;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0011:
            r0 = r9
            java.lang.Object r1 = r0.L$0
            androidx.lifecycle.LifecycleController r1 = (androidx.lifecycle.LifecycleController) r1
            defpackage.te0.b(r10)     // Catch:{ all -> 0x001d }
            r2 = r1
            r1 = r0
            r0 = r10
            goto L_0x0058
        L_0x001d:
            r2 = move-exception
            goto L_0x0062
        L_0x001f:
            defpackage.te0.b(r10)
            r1 = r9
            java.lang.Object r2 = r1.L$0
            hd r2 = (defpackage.hd) r2
            yc r3 = r2.getCoroutineContext()
            ev$b r4 = defpackage.ev.a
            yc$b r3 = r3.get(r4)
            ev r3 = (defpackage.ev) r3
            if (r3 == 0) goto L_0x0066
            r2 = r3
            androidx.lifecycle.PausingDispatcher r3 = new androidx.lifecycle.PausingDispatcher
            r3.<init>()
            androidx.lifecycle.LifecycleController r4 = new androidx.lifecycle.LifecycleController
            androidx.lifecycle.Lifecycle r5 = r1.$this_whenStateAtLeast
            androidx.lifecycle.Lifecycle$State r6 = r1.$minState
            androidx.lifecycle.DispatchQueue r7 = r3.dispatchQueue
            r4.<init>(r5, r6, r7, r2)
            r2 = r4
            jo<hd, rc<? super T>, java.lang.Object> r4 = r1.$block     // Catch:{ all -> 0x005d }
            r1.L$0 = r2     // Catch:{ all -> 0x005d }
            r5 = 1
            r1.label = r5     // Catch:{ all -> 0x005d }
            java.lang.Object r4 = defpackage.u6.c(r3, r4, r1)     // Catch:{ all -> 0x005d }
            if (r4 != r0) goto L_0x0056
            return r0
        L_0x0056:
            r0 = r10
            r10 = r4
        L_0x0058:
            r2.finish()
            return r10
        L_0x005d:
            r0 = move-exception
            r8 = r2
            r2 = r0
            r0 = r1
            r1 = r8
        L_0x0062:
            r1.finish()
            throw r2
        L_0x0066:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "when[State] methods should have a parent job"
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
