package defpackage;

import java.util.concurrent.TimeUnit;

/* renamed from: nr0  reason: default package */
public interface nr0 {
    public static final nr0 a = new a();

    long a();

    /* renamed from: nr0$a */
    class a implements nr0 {
        a() {
        }

        public long a() {
            return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
        }
    }
}
