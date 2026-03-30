package io.reactivex.internal.subscriptions;

public enum a implements wb0<Object> {
    INSTANCE;

    public void request(long n) {
        b.validate(n);
    }

    public void cancel() {
    }

    public String toString() {
        return "EmptySubscription";
    }

    public static void error(Throwable e, ho0<?> s) {
        s.d(INSTANCE);
        s.onError(e);
    }

    public static void complete(ho0<?> s) {
        s.d(INSTANCE);
        s.a();
    }

    public Object poll() {
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

    public boolean offer(Object value) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(Object v1, Object v2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
