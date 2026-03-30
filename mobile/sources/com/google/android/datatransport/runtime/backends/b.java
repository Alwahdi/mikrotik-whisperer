package com.google.android.datatransport.runtime.backends;

public abstract class b {

    public enum a {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR
    }

    public abstract long b();

    public abstract a c();

    public static b e() {
        return new a(a.TRANSIENT_ERROR, -1);
    }

    public static b a() {
        return new a(a.FATAL_ERROR, -1);
    }

    public static b d(long nextRequestWaitMillis) {
        return new a(a.OK, nextRequestWaitMillis);
    }
}
