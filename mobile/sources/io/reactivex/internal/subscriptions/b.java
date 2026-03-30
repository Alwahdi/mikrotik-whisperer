package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public enum b implements jo0 {
    CANCELLED;

    public void request(long n) {
    }

    public void cancel() {
    }

    public static boolean validate(jo0 current, jo0 next) {
        if (next == null) {
            of0.l(new NullPointerException("next is null"));
            return false;
        } else if (current == null) {
            return true;
        } else {
            next.cancel();
            reportSubscriptionSet();
            return false;
        }
    }

    public static void reportSubscriptionSet() {
        of0.l(new lb0("Subscription already set!"));
    }

    public static boolean validate(long n) {
        if (n > 0) {
            return true;
        }
        of0.l(new IllegalArgumentException("n > 0 required but it was " + n));
        return false;
    }

    public static void reportMoreProduced(long n) {
        of0.l(new lb0("More produced than requested: " + n));
    }

    public static boolean isCancelled(jo0 s) {
        return s == CANCELLED;
    }

    public static boolean set(AtomicReference<jo0> field, jo0 s) {
        jo0 current;
        do {
            current = field.get();
            if (current == CANCELLED) {
                if (s == null) {
                    return false;
                }
                s.cancel();
                return false;
            }
        } while (!field.compareAndSet(current, s));
        if (current == null) {
            return true;
        }
        current.cancel();
        return true;
    }

    public static boolean setOnce(AtomicReference<jo0> field, jo0 s) {
        a40.c(s, "s is null");
        if (field.compareAndSet((Object) null, s)) {
            return true;
        }
        s.cancel();
        if (field.get() == CANCELLED) {
            return false;
        }
        reportSubscriptionSet();
        return false;
    }

    public static boolean replace(AtomicReference<jo0> field, jo0 s) {
        jo0 current;
        do {
            current = field.get();
            if (current == CANCELLED) {
                if (s == null) {
                    return false;
                }
                s.cancel();
                return false;
            }
        } while (!field.compareAndSet(current, s));
        return true;
    }

    public static boolean cancel(AtomicReference<jo0> field) {
        jo0 current;
        jo0 current2 = field.get();
        b bVar = CANCELLED;
        if (current2 == bVar || (current = field.getAndSet(bVar)) == bVar) {
            return false;
        }
        if (current == null) {
            return true;
        }
        current.cancel();
        return true;
    }

    public static boolean deferredSetOnce(AtomicReference<jo0> field, AtomicLong requested, jo0 s) {
        if (!setOnce(field, s)) {
            return false;
        }
        long r = requested.getAndSet(0);
        if (r == 0) {
            return true;
        }
        s.request(r);
        return true;
    }

    public static void deferredRequest(AtomicReference<jo0> field, AtomicLong requested, long n) {
        jo0 s = field.get();
        if (s != null) {
            s.request(n);
        } else if (validate(n)) {
            m5.a(requested, n);
            jo0 s2 = field.get();
            if (s2 != null) {
                long r = requested.getAndSet(0);
                if (r != 0) {
                    s2.request(r);
                }
            }
        }
    }
}
