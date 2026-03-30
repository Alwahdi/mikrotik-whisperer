package io.reactivex.internal.disposables;

import java.util.concurrent.atomic.AtomicReference;

public enum a implements yg {
    DISPOSED;

    public static boolean isDisposed(yg d) {
        return d == DISPOSED;
    }

    public static boolean set(AtomicReference<yg> field, yg d) {
        yg current;
        do {
            current = field.get();
            if (current == DISPOSED) {
                if (d == null) {
                    return false;
                }
                d.dispose();
                return false;
            }
        } while (!field.compareAndSet(current, d));
        if (current == null) {
            return true;
        }
        current.dispose();
        return true;
    }

    public static boolean setOnce(AtomicReference<yg> field, yg d) {
        a40.c(d, "d is null");
        if (field.compareAndSet((Object) null, d)) {
            return true;
        }
        d.dispose();
        if (field.get() == DISPOSED) {
            return false;
        }
        reportDisposableSet();
        return false;
    }

    public static boolean replace(AtomicReference<yg> field, yg d) {
        yg current;
        do {
            current = field.get();
            if (current == DISPOSED) {
                if (d == null) {
                    return false;
                }
                d.dispose();
                return false;
            }
        } while (!field.compareAndSet(current, d));
        return true;
    }

    public static boolean dispose(AtomicReference<yg> field) {
        yg current;
        yg current2 = field.get();
        yg d = DISPOSED;
        if (current2 == d || (current = field.getAndSet(d)) == d) {
            return false;
        }
        if (current == null) {
            return true;
        }
        current.dispose();
        return true;
    }

    public static boolean validate(yg current, yg next) {
        if (next == null) {
            of0.l(new NullPointerException("next is null"));
            return false;
        } else if (current == null) {
            return true;
        } else {
            next.dispose();
            reportDisposableSet();
            return false;
        }
    }

    public static void reportDisposableSet() {
        of0.l(new lb0("Disposable already set!"));
    }

    public static boolean trySet(AtomicReference<yg> field, yg d) {
        if (field.compareAndSet((Object) null, d)) {
            return true;
        }
        if (field.get() != DISPOSED) {
            return false;
        }
        d.dispose();
        return false;
    }

    public void dispose() {
    }

    public boolean isDisposed() {
        return true;
    }
}
