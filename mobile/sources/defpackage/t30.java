package defpackage;

import androidx.core.location.LocationRequestCompat;

/* renamed from: t30  reason: default package */
public class t30 implements yr0 {
    private s30 a;

    public t30(s30 operand) {
        this.a = operand;
    }

    public rk a(rk previousValue, pr0 localWriteTime) {
        s30 baseValue = b(previousValue);
        if ((baseValue instanceof et) && (this.a instanceof et)) {
            return et.h(Long.valueOf(h(((et) baseValue).e(), g())));
        }
        if (baseValue instanceof et) {
            return th.h(Double.valueOf(((double) ((et) baseValue).e()) + f()));
        }
        n4.d(baseValue instanceof th, "Expected NumberValue to be of type DoubleValue, but was ", previousValue.getClass().getCanonicalName());
        return th.h(Double.valueOf(((th) baseValue).e() + f()));
    }

    public rk c(rk previousValue, rk transformResult) {
        return transformResult;
    }

    public rk e() {
        return this.a;
    }

    /* renamed from: d */
    public s30 b(rk previousValue) {
        if (previousValue instanceof s30) {
            return (s30) previousValue;
        }
        return et.h(0L);
    }

    private long h(long x, long y) {
        long r = x + y;
        if (((x ^ r) & (y ^ r)) >= 0) {
            return r;
        }
        if (r >= 0) {
            return Long.MIN_VALUE;
        }
        return LocationRequestCompat.PASSIVE_INTERVAL;
    }

    private double f() {
        s30 s30 = this.a;
        if (s30 instanceof th) {
            return ((th) s30).e();
        }
        if (s30 instanceof et) {
            return (double) ((et) s30).e();
        }
        throw n4.a("Expected 'operand' to be of Number type, but was " + this.a.getClass().getCanonicalName(), new Object[0]);
    }

    private long g() {
        s30 s30 = this.a;
        if (s30 instanceof th) {
            return (long) ((th) s30).e();
        }
        if (s30 instanceof et) {
            return ((et) s30).e();
        }
        throw n4.a("Expected 'operand' to be of Number type, but was " + this.a.getClass().getCanonicalName(), new Object[0]);
    }
}
