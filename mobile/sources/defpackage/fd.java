package defpackage;

import defpackage.yc;

/* renamed from: fd  reason: default package */
public final class fd extends k implements wq0<String> {
    public static final a a = new a((Cif) null);

    /* renamed from: a  reason: collision with other field name */
    private final long f2966a;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof fd) && this.f2966a == ((fd) obj).f2966a;
    }

    public int hashCode() {
        return ed.a(this.f2966a);
    }

    public final long X() {
        return this.f2966a;
    }

    /* renamed from: fd$a */
    public static final class a implements yc.c<fd> {
        public /* synthetic */ a(Cif ifVar) {
            this();
        }

        private a() {
        }
    }

    public fd(long id) {
        super(a);
        this.f2966a = id;
    }

    public String toString() {
        return "CoroutineId(" + this.f2966a + ')';
    }

    /* renamed from: Z */
    public String U(yc context) {
        b6.a(context.get(gd.a));
        Thread currentThread = Thread.currentThread();
        String oldName = currentThread.getName();
        int lastIndex = eo0.s(oldName, " @", 0, false, 6, (Object) null);
        if (lastIndex < 0) {
            lastIndex = oldName.length();
        }
        StringBuilder sb = new StringBuilder("coroutine".length() + lastIndex + 10);
        StringBuilder $this$updateThreadContext_u24lambda_u2d0 = sb;
        String substring = oldName.substring(0, lastIndex);
        lu.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        $this$updateThreadContext_u24lambda_u2d0.append(substring);
        $this$updateThreadContext_u24lambda_u2d0.append(" @");
        $this$updateThreadContext_u24lambda_u2d0.append("coroutine");
        $this$updateThreadContext_u24lambda_u2d0.append('#');
        $this$updateThreadContext_u24lambda_u2d0.append(this.f2966a);
        String sb2 = sb.toString();
        lu.e(sb2, "StringBuilder(capacity).…builderAction).toString()");
        currentThread.setName(sb2);
        return oldName;
    }

    /* renamed from: Y */
    public void f(yc context, String oldState) {
        Thread.currentThread().setName(oldState);
    }
}
