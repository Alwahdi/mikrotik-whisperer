package defpackage;

/* renamed from: dd  reason: default package */
public abstract class dd {
    public static final void a(yc context, Throwable exception) {
        try {
            bd it = (bd) context.get(bd.a);
            if (it != null) {
                it.q(context, exception);
            } else {
                cd.a(context, exception);
            }
        } catch (Throwable t) {
            cd.a(context, b(exception, t));
        }
    }

    public static final Throwable b(Throwable originalException, Throwable thrownException) {
        if (originalException == thrownException) {
            return originalException;
        }
        Throwable $this$handlerException_u24lambda_u2d1 = new RuntimeException("Exception while trying to handle coroutine exception", thrownException);
        rj.a($this$handlerException_u24lambda_u2d1, originalException);
        return $this$handlerException_u24lambda_u2d1;
    }
}
