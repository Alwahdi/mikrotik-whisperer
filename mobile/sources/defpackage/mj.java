package defpackage;

import java.io.PrintStream;
import java.io.PrintWriter;

/* renamed from: mj  reason: default package */
public class mj extends RuntimeException {
    private Exception a;

    /* renamed from: a  reason: collision with other field name */
    private String f4361a;

    public mj(Exception ex) {
        super(ex);
        this.a = ex;
        this.f4361a = ex instanceof RuntimeException ? "" : "ExceptionConverter: ";
    }

    public static final RuntimeException a(Exception ex) {
        if (ex instanceof RuntimeException) {
            return (RuntimeException) ex;
        }
        return new mj(ex);
    }

    public String getMessage() {
        return this.a.getMessage();
    }

    public String getLocalizedMessage() {
        return this.a.getLocalizedMessage();
    }

    public String toString() {
        return this.f4361a + this.a;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream s) {
        synchronized (s) {
            s.print(this.f4361a);
            this.a.printStackTrace(s);
        }
    }

    public void printStackTrace(PrintWriter s) {
        synchronized (s) {
            s.print(this.f4361a);
            this.a.printStackTrace(s);
        }
    }

    public Throwable fillInStackTrace() {
        return this;
    }
}
