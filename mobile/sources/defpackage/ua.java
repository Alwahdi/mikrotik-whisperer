package defpackage;

/* renamed from: ua  reason: default package */
public final class ua implements rc<Object> {
    public static final ua a = new ua();

    private ua() {
    }

    public yc getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public void resumeWith(Object result) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
