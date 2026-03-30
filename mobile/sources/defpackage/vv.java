package defpackage;

import androidx.core.location.LocationRequestCompat;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* renamed from: vv  reason: default package */
public abstract class vv {
    private static final long a = TimeUnit.SECONDS.toNanos(1);

    public static List<?> e(Map<String, ?> obj, String key) {
        if (key == null) {
            throw new AssertionError();
        } else if (!obj.containsKey(key)) {
            return null;
        } else {
            Object obj2 = obj.get(key);
            if (obj2 instanceof List) {
                return (List) obj2;
            }
            throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not List", new Object[]{obj2, key, obj}));
        }
    }

    public static List<Map<String, ?>> f(Map<String, ?> obj, String key) {
        List<?> list = e(obj, key);
        if (list == null) {
            return null;
        }
        return a(list);
    }

    public static List<String> g(Map<String, ?> obj, String key) {
        List<?> list = e(obj, key);
        if (list == null) {
            return null;
        }
        return b(list);
    }

    public static Map<String, ?> j(Map<String, ?> obj, String key) {
        if (key == null) {
            throw new AssertionError();
        } else if (!obj.containsKey(key)) {
            return null;
        } else {
            Object obj2 = obj.get(key);
            if (obj2 instanceof Map) {
                return (Map) obj2;
            }
            throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not object", new Object[]{obj2, key, obj}));
        }
    }

    public static Double h(Map<String, ?> obj, String key) {
        if (key == null) {
            throw new AssertionError();
        } else if (!obj.containsKey(key)) {
            return null;
        } else {
            Object obj2 = obj.get(key);
            if (obj2 instanceof Double) {
                return (Double) obj2;
            }
            throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not Double", new Object[]{obj2, key, obj}));
        }
    }

    public static Integer i(Map<String, ?> obj, String key) {
        Double d = h(obj, key);
        if (d == null) {
            return null;
        }
        int i = d.intValue();
        if (((double) i) == d.doubleValue()) {
            return Integer.valueOf(i);
        }
        throw new ClassCastException("Number expected to be integer: " + d);
    }

    public static String k(Map<String, ?> obj, String key) {
        if (key == null) {
            throw new AssertionError();
        } else if (!obj.containsKey(key)) {
            return null;
        } else {
            Object obj2 = obj.get(key);
            if (obj2 instanceof String) {
                return (String) obj2;
            }
            throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not String", new Object[]{obj2, key, obj}));
        }
    }

    public static Long l(Map<String, ?> obj, String key) {
        String value = k(obj, key);
        if (value == null) {
            return null;
        }
        try {
            return Long.valueOf(n(value));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Boolean d(Map<String, ?> obj, String key) {
        if (key == null) {
            throw new AssertionError();
        } else if (!obj.containsKey(key)) {
            return null;
        } else {
            Object obj2 = obj.get(key);
            if (obj2 instanceof Boolean) {
                return (Boolean) obj2;
            }
            throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not Boolean", new Object[]{obj2, key, obj}));
        }
    }

    public static List<Map<String, ?>> a(List<?> rawList) {
        int i = 0;
        while (i < rawList.size()) {
            if (rawList.get(i) instanceof Map) {
                i++;
            } else {
                throw new ClassCastException(String.format("value %s for idx %d in %s is not object", new Object[]{rawList.get(i), Integer.valueOf(i), rawList}));
            }
        }
        return rawList;
    }

    public static List<String> b(List<?> rawList) {
        int i = 0;
        while (i < rawList.size()) {
            if (rawList.get(i) instanceof String) {
                i++;
            } else {
                throw new ClassCastException(String.format("value '%s' for idx %d in '%s' is not string", new Object[]{rawList.get(i), Integer.valueOf(i), rawList}));
            }
        }
        return rawList;
    }

    private static long n(String value) {
        if (value.isEmpty() || value.charAt(value.length() - 1) != 's') {
            throw new ParseException("Invalid duration string: " + value, 0);
        }
        boolean negative = false;
        if (value.charAt(0) == '-') {
            negative = true;
            value = value.substring(1);
        }
        String secondValue = value.substring(0, value.length() - 1);
        String nanoValue = "";
        int pointPosition = secondValue.indexOf(46);
        if (pointPosition != -1) {
            nanoValue = secondValue.substring(pointPosition + 1);
            secondValue = secondValue.substring(0, pointPosition);
        }
        long seconds = Long.parseLong(secondValue);
        int nanos = nanoValue.isEmpty() ? 0 : o(nanoValue);
        if (seconds >= 0) {
            if (negative) {
                seconds = -seconds;
                nanos = -nanos;
            }
            try {
                return m(seconds, nanos);
            } catch (IllegalArgumentException e) {
                throw new ParseException("Duration value is out of range.", 0);
            }
        } else {
            throw new ParseException("Invalid duration string: " + value, 0);
        }
    }

    private static int o(String value) {
        int result = 0;
        for (int i = 0; i < 9; i++) {
            result *= 10;
            if (i < value.length()) {
                if (value.charAt(i) < '0' || value.charAt(i) > '9') {
                    throw new ParseException("Invalid nanoseconds.", 0);
                }
                result += value.charAt(i) - '0';
            }
        }
        return result;
    }

    private static long m(long seconds, int nanos) {
        long j = a;
        if (((long) nanos) <= (-j) || ((long) nanos) >= j) {
            seconds = ez.a(seconds, ((long) nanos) / j);
            nanos = (int) (((long) nanos) % j);
        }
        if (seconds > 0 && nanos < 0) {
            nanos = (int) (((long) nanos) + j);
            seconds--;
        }
        if (seconds < 0 && nanos > 0) {
            nanos = (int) (((long) nanos) - j);
            seconds++;
        }
        if (c(seconds, nanos)) {
            return p(TimeUnit.SECONDS.toNanos(seconds), (long) nanos);
        }
        throw new IllegalArgumentException(String.format("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", new Object[]{Long.valueOf(seconds), Integer.valueOf(nanos)}));
    }

    private static boolean c(long seconds, int nanos) {
        if (seconds < -315576000000L || seconds > 315576000000L || ((long) nanos) < -999999999 || ((long) nanos) >= a) {
            return false;
        }
        if (seconds >= 0 && nanos >= 0) {
            return true;
        }
        if (seconds > 0 || nanos > 0) {
            return false;
        }
        return true;
    }

    private static long p(long a2, long b) {
        long naiveSum = a2 + b;
        boolean z = true;
        boolean z2 = (a2 ^ b) < 0;
        if ((a2 ^ naiveSum) < 0) {
            z = false;
        }
        if (z2 || z) {
            return naiveSum;
        }
        return ((naiveSum >>> 63) ^ 1) + LocationRequestCompat.PASSIVE_INTERVAL;
    }
}
