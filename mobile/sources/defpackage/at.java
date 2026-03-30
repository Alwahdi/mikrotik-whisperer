package defpackage;

import java.math.RoundingMode;

/* renamed from: at  reason: default package */
public abstract class at {
    static final byte[] a = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};

    /* renamed from: a  reason: collision with other field name */
    static final int[] f122a = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
    static final int[] b = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};
    private static final int[] c = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};
    static int[] d = {Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    public static boolean b(int x) {
        boolean z = false;
        boolean z2 = x > 0;
        if (((x - 1) & x) == 0) {
            z = true;
        }
        return z & z2;
    }

    static int c(int x, int y) {
        return (~(~(x - y))) >>> 31;
    }

    /* renamed from: at$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    public static int d(int x, RoundingMode mode) {
        u00.b("x", x);
        switch (a.a[mode.ordinal()]) {
            case 1:
                u00.c(b(x));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(x - 1);
            case 6:
            case 7:
            case 8:
                int leadingZeros = Integer.numberOfLeadingZeros(x);
                return c(-1257966797 >>> leadingZeros, x) + (31 - leadingZeros);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(x);
    }

    public static int a(int p, int q, RoundingMode mode) {
        v90.n(mode);
        if (q != 0) {
            int div = p / q;
            int rem = p - (q * div);
            if (rem == 0) {
                return div;
            }
            boolean increment = true;
            int signum = ((p ^ q) >> 31) | 1;
            switch (a.a[mode.ordinal()]) {
                case 1:
                    if (rem != 0) {
                        increment = false;
                    }
                    u00.c(increment);
                    break;
                case 2:
                    break;
                case 3:
                    if (signum >= 0) {
                        increment = false;
                        break;
                    }
                    break;
                case 4:
                    increment = true;
                    break;
                case 5:
                    if (signum <= 0) {
                        increment = false;
                        break;
                    }
                    break;
                case 6:
                case 7:
                case 8:
                    int absRem = Math.abs(rem);
                    int cmpRemToHalfDivisor = absRem - (Math.abs(q) - absRem);
                    if (cmpRemToHalfDivisor != 0) {
                        if (cmpRemToHalfDivisor <= 0) {
                            increment = false;
                            break;
                        }
                    } else if (mode != RoundingMode.HALF_UP) {
                        if (!(mode == RoundingMode.HALF_EVEN) || !((div & 1) != 0)) {
                            increment = false;
                            break;
                        }
                    }
                    break;
                default:
                    throw new AssertionError();
            }
            increment = false;
            return increment ? div + signum : div;
        }
        throw new ArithmeticException("/ by zero");
    }

    public static int e(int a2, int b2) {
        return pu.a(((long) a2) * ((long) b2));
    }
}
