package defpackage;

/* renamed from: ta  reason: default package */
final class ta {
    public final Object a;

    /* renamed from: a  reason: collision with other field name */
    public final Throwable f5093a;

    /* renamed from: a  reason: collision with other field name */
    public final o7 f5094a;

    /* renamed from: a  reason: collision with other field name */
    public final vn<Throwable, jt0> f5095a;
    public final Object b;

    public static /* synthetic */ ta b(ta taVar, Object obj, o7 o7Var, vn<Throwable, jt0> vnVar, Object obj2, Throwable th, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = taVar.a;
        }
        if ((i & 2) != 0) {
            o7Var = taVar.f5094a;
        }
        o7 o7Var2 = o7Var;
        if ((i & 4) != 0) {
            vnVar = taVar.f5095a;
        }
        vn<Throwable, jt0> vnVar2 = vnVar;
        if ((i & 8) != 0) {
            obj2 = taVar.b;
        }
        Object obj4 = obj2;
        if ((i & 16) != 0) {
            th = taVar.f5093a;
        }
        return taVar.a(obj, o7Var2, vnVar2, obj4, th);
    }

    public final ta a(Object obj, o7 o7Var, vn<? super Throwable, jt0> vnVar, Object obj2, Throwable th) {
        return new ta(obj, o7Var, vnVar, obj2, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ta)) {
            return false;
        }
        ta taVar = (ta) obj;
        return lu.a(this.a, taVar.a) && lu.a(this.f5094a, taVar.f5094a) && lu.a(this.f5095a, taVar.f5095a) && lu.a(this.b, taVar.b) && lu.a(this.f5093a, taVar.f5093a);
    }

    public int hashCode() {
        Object obj = this.a;
        int i = 0;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        o7 o7Var = this.f5094a;
        int hashCode2 = (hashCode + (o7Var == null ? 0 : o7Var.hashCode())) * 31;
        vn<Throwable, jt0> vnVar = this.f5095a;
        int hashCode3 = (hashCode2 + (vnVar == null ? 0 : vnVar.hashCode())) * 31;
        Object obj2 = this.b;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f5093a;
        if (th != null) {
            i = th.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.a + ", cancelHandler=" + this.f5094a + ", onCancellation=" + this.f5095a + ", idempotentResume=" + this.b + ", cancelCause=" + this.f5093a + ')';
    }

    public ta(Object result, o7 cancelHandler, vn<? super Throwable, jt0> onCancellation, Object idempotentResume, Throwable cancelCause) {
        this.a = result;
        this.f5094a = cancelHandler;
        this.f5095a = onCancellation;
        this.b = idempotentResume;
        this.f5093a = cancelCause;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ta(java.lang.Object r8, defpackage.o7 r9, defpackage.vn r10, java.lang.Object r11, java.lang.Throwable r12, int r13, defpackage.Cif r14) {
        /*
            r7 = this;
            r14 = r13 & 2
            r0 = 0
            if (r14 == 0) goto L_0x0007
            r3 = r0
            goto L_0x0008
        L_0x0007:
            r3 = r9
        L_0x0008:
            r9 = r13 & 4
            if (r9 == 0) goto L_0x000e
            r4 = r0
            goto L_0x000f
        L_0x000e:
            r4 = r10
        L_0x000f:
            r9 = r13 & 8
            if (r9 == 0) goto L_0x0015
            r5 = r0
            goto L_0x0016
        L_0x0015:
            r5 = r11
        L_0x0016:
            r9 = r13 & 16
            if (r9 == 0) goto L_0x001c
            r6 = r0
            goto L_0x001d
        L_0x001c:
            r6 = r12
        L_0x001d:
            r1 = r7
            r2 = r8
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ta.<init>(java.lang.Object, o7, vn, java.lang.Object, java.lang.Throwable, int, if):void");
    }

    public final boolean c() {
        return this.f5093a != null;
    }

    public final void d(s7<?> cont, Throwable cause) {
        o7 it = this.f5094a;
        if (it != null) {
            cont.i(it, cause);
        }
        vn it2 = this.f5095a;
        if (it2 != null) {
            cont.k(it2, cause);
        }
    }
}
