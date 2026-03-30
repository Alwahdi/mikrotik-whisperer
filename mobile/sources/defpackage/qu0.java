package defpackage;

import android.os.Handler;
import android.os.Looper;
import com.google.firebase.firestore.i;
import com.google.protobuf.e;
import io.grpc.p;
import io.grpc.q;
import io.grpc.r;
import java.util.Comparator;
import java.util.Random;

/* renamed from: qu0  reason: default package */
public abstract class qu0 {
    private static final Comparator a = new a();

    /* renamed from: a  reason: collision with other field name */
    private static final Random f4862a = new Random();

    /* renamed from: a  reason: collision with other field name */
    private static final sc<Void, Void> f4863a = pu0.b();

    public static int b(boolean b1, boolean b2) {
        if (b1 == b2) {
            return 0;
        }
        if (b1) {
            return 1;
        }
        return -1;
    }

    public static int d(int i1, int i2) {
        if (i1 < i2) {
            return -1;
        }
        if (i1 > i2) {
            return 1;
        }
        return 0;
    }

    public static int f(long i1, long i2) {
        return r30.a(i1, i2);
    }

    public static int e(int i1, int i2) {
        return r30.a((long) i1, (long) i2);
    }

    public static int c(double i1, double i2) {
        return r30.c(i1, i2);
    }

    public static int g(double doubleValue, long longValue) {
        return r30.b(doubleValue, longValue);
    }

    /* renamed from: qu0$a */
    class a implements Comparator<Comparable<?>> {
        a() {
        }

        /* renamed from: a */
        public int compare(Comparable left, Comparable right) {
            return left.compareTo(right);
        }
    }

    public static <T extends Comparable<T>> Comparator<T> a() {
        return a;
    }

    public static i j(p error) {
        q statusException = error.c();
        return new i(statusException.getMessage(), i.a.fromValue(error.m().value()), statusException);
    }

    private static Exception h(Exception e) {
        if (e instanceof q) {
            return j(((q) e).a());
        }
        if (e instanceof r) {
            return j(((r) e).a());
        }
        return e;
    }

    static /* synthetic */ Void l(eq0 task) {
        if (task.r()) {
            return (Void) task.n();
        }
        Exception e = h(task.m());
        if (e instanceof i) {
            throw e;
        }
        throw new i(e.getMessage(), i.a.UNKNOWN, e);
    }

    public static sc<Void, Void> o() {
        return f4863a;
    }

    public static String m(e bytes) {
        int size = bytes.size();
        StringBuilder result = new StringBuilder(size * 2);
        for (int i = 0; i < size; i++) {
            int value = bytes.b(i) & 255;
            result.append(Character.forDigit(value >>> 4, 16));
            result.append(Character.forDigit(value & 15, 16));
        }
        return result.toString();
    }

    public static String n(Object obj) {
        return obj == null ? "null" : obj.getClass().getName();
    }

    public static void i(RuntimeException exception) {
        new Handler(Looper.getMainLooper()).post(ou0.a(exception));
    }

    static /* synthetic */ void k(RuntimeException exception) {
        throw exception;
    }
}
