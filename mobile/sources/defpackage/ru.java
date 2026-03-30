package defpackage;

/* renamed from: ru  reason: default package */
public class ru extends RuntimeException {
    private final Throwable a;

    public ru(String message) {
        this(message, (Throwable) null);
    }

    public ru(String message, Throwable cause) {
        super(message);
        this.a = cause;
    }

    public Throwable getCause() {
        return this.a;
    }
}
