package defpackage;

/* renamed from: bp0  reason: default package */
abstract /* synthetic */ class bp0 {
    public static final boolean c(String propertyName, boolean defaultValue) {
        String d = zo0.d(propertyName);
        return d != null ? Boolean.parseBoolean(d) : defaultValue;
    }

    public static /* synthetic */ int d(String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return zo0.b(str, i, i2, i3);
    }

    public static final int a(String propertyName, int defaultValue, int minValue, int maxValue) {
        return (int) zo0.c(propertyName, (long) defaultValue, (long) minValue, (long) maxValue);
    }

    public static /* synthetic */ long e(String str, long j, long j2, long j3, int i, Object obj) {
        long j4;
        long j5;
        if ((i & 4) != 0) {
            j4 = 1;
        } else {
            j4 = j2;
        }
        if ((i & 8) != 0) {
            j5 = Long.MAX_VALUE;
        } else {
            j5 = j3;
        }
        return zo0.c(str, j, j4, j5);
    }

    public static final long b(String propertyName, long defaultValue, long minValue, long maxValue) {
        String value = zo0.d(propertyName);
        if (value == null) {
            return defaultValue;
        }
        Long a = co0.a(value);
        if (a != null) {
            long parsed = a.longValue();
            boolean z = false;
            if (minValue <= parsed && parsed <= maxValue) {
                z = true;
            }
            if (z) {
                return parsed;
            }
            throw new IllegalStateException(("System property '" + propertyName + "' should be in range " + minValue + ".." + maxValue + ", but is '" + parsed + '\'').toString());
        }
        throw new IllegalStateException(("System property '" + propertyName + "' has unrecognized value '" + value + '\'').toString());
    }
}
