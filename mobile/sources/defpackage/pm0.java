package defpackage;

/* renamed from: pm0  reason: default package */
public final class pm0 {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final f8 f4719a;

    /* renamed from: a  reason: collision with other field name */
    private final b f4720a;

    /* renamed from: a  reason: collision with other field name */
    private final boolean f4721a;

    /* renamed from: pm0$b */
    private interface b {
    }

    private pm0(b strategy) {
        this(strategy, false, f8.c(), Integer.MAX_VALUE);
    }

    private pm0(b strategy, boolean omitEmptyStrings, f8 trimmer, int limit) {
        this.f4720a = strategy;
        this.f4721a = omitEmptyStrings;
        this.f4719a = trimmer;
        this.a = limit;
    }

    public static pm0 a(char separator) {
        return b(f8.b(separator));
    }

    public static pm0 b(f8 separatorMatcher) {
        v90.n(separatorMatcher);
        return new pm0(new a(separatorMatcher));
    }

    /* renamed from: pm0$a */
    static class a implements b {
        final /* synthetic */ f8 a;

        a(f8 f8Var) {
            this.a = f8Var;
        }
    }

    public pm0 c() {
        return d(f8.e());
    }

    public pm0 d(f8 trimmer) {
        v90.n(trimmer);
        return new pm0(this.f4720a, this.f4721a, trimmer, this.a);
    }
}
