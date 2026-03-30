package defpackage;

/* renamed from: kg  reason: default package */
final class kg extends RuntimeException {
    private final yc a;

    public kg(yc context) {
        this.a = context;
    }

    public String getLocalizedMessage() {
        return this.a.toString();
    }

    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
