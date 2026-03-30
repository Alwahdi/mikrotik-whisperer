package defpackage;

/* renamed from: rj  reason: default package */
abstract class rj {
    public static void a(Throwable $this$addSuppressed, Throwable exception) {
        lu.f($this$addSuppressed, "<this>");
        lu.f(exception, "exception");
        if ($this$addSuppressed != exception) {
            l90.a.a($this$addSuppressed, exception);
        }
    }
}
