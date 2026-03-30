package io.reactivex.internal.disposables;

public enum b implements vb0, yg {
    INSTANCE,
    NEVER;

    public void dispose() {
    }

    public boolean isDisposed() {
        return this == INSTANCE;
    }

    public static void complete(h40<?> s) {
        s.b(INSTANCE);
        s.a();
    }

    public static void complete(x00<?> s) {
        s.b(INSTANCE);
        s.a();
    }

    public static void error(Throwable e, h40<?> s) {
        s.b(INSTANCE);
        s.onError(e);
    }

    public static void complete(sa s) {
        s.b(INSTANCE);
        s.a();
    }

    public static void error(Throwable e, sa s) {
        s.b(INSTANCE);
        s.onError(e);
    }

    public static void error(Throwable e, zl0<?> s) {
        s.b(INSTANCE);
        s.onError(e);
    }

    public static void error(Throwable e, x00<?> s) {
        s.b(INSTANCE);
        s.onError(e);
    }

    public boolean offer(Object value) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(Object v1, Object v2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public Object poll() throws Exception {
        return null;
    }

    public boolean isEmpty() {
        return true;
    }

    public void clear() {
    }

    public int requestFusion(int mode) {
        return mode & 2;
    }
}
