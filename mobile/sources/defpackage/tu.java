package defpackage;

import java.io.IOException;

/* renamed from: tu  reason: default package */
public class tu extends IOException {
    private final Throwable a;

    public tu(String message) {
        this(message, (Throwable) null);
    }

    public tu(String message, Throwable cause) {
        super(message);
        this.a = cause;
    }

    public Throwable getCause() {
        return this.a;
    }
}
