package defpackage;

/* renamed from: v8  reason: default package */
final class v8 extends wd {
    private static final a a = new a();

    /* renamed from: a  reason: collision with other field name */
    public static final v8 f5311a = new v8();

    /* renamed from: v8$a */
    public static final class a extends ClassValue<vn<? super Throwable, ? extends Throwable>> {
        a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public vn<Throwable, Throwable> computeValue(Class<?> type) {
            if (type != null) {
                return pj.b(type);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<out kotlin.Throwable>");
        }
    }

    private v8() {
    }

    public vn<Throwable, Throwable> a(Class<? extends Throwable> key) {
        return (vn) a.get(key);
    }
}
