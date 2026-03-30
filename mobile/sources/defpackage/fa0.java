package defpackage;

import androidx.core.util.Predicate;
import java.util.Objects;

/* renamed from: fa0  reason: default package */
public abstract /* synthetic */ class fa0<T> {
    public static Predicate a(Predicate _this, Predicate other) {
        Objects.requireNonNull(other);
        return new ba0(_this, other);
    }

    public static /* synthetic */ boolean d(Predicate _this, Predicate other, Object t) {
        return _this.test(t) && other.test(t);
    }

    public static Predicate b(Predicate _this) {
        return new aa0(_this);
    }

    public static /* synthetic */ boolean e(Predicate _this, Object t) {
        return !_this.test(t);
    }

    public static Predicate c(Predicate _this, Predicate other) {
        Objects.requireNonNull(other);
        return new ca0(_this, other);
    }

    public static /* synthetic */ boolean f(Predicate _this, Predicate other, Object t) {
        return _this.test(t) || other.test(t);
    }

    public static <T> Predicate<T> l(Object targetRef) {
        if (targetRef == null) {
            return ea0.a;
        }
        return new da0(targetRef);
    }

    public static <T> Predicate<T> o(Predicate<? super T> target) {
        Objects.requireNonNull(target);
        return target.negate();
    }
}
