package defpackage;

import java.util.concurrent.CancellationException;

/* renamed from: fv  reason: default package */
public final class fv extends CancellationException implements vc<fv> {
    public final transient ev a;

    public fv(String message, Throwable cause, ev job) {
        super(message);
        this.a = job;
        if (cause != null) {
            initCause(cause);
        }
    }

    public Throwable fillInStackTrace() {
        if (af.c()) {
            return super.fillInStackTrace();
        }
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    /* renamed from: b */
    public fv a() {
        if (!af.c()) {
            return null;
        }
        String message = getMessage();
        lu.c(message);
        return new fv(message, this, this.a);
    }

    public String toString() {
        return super.toString() + "; job=" + this.a;
    }

    public boolean equals(Object other) {
        return other == this || ((other instanceof fv) && lu.a(((fv) other).getMessage(), getMessage()) && lu.a(((fv) other).a, this.a) && lu.a(((fv) other).getCause(), getCause()));
    }

    public int hashCode() {
        String message = getMessage();
        lu.c(message);
        int hashCode = ((message.hashCode() * 31) + this.a.hashCode()) * 31;
        Throwable cause = getCause();
        return hashCode + (cause != null ? cause.hashCode() : 0);
    }
}
