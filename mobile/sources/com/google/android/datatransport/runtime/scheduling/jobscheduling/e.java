package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.c;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class e {

    public enum c {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    /* access modifiers changed from: package-private */
    public abstract c9 d();

    /* access modifiers changed from: package-private */
    public abstract Map<com.google.android.datatransport.a, b> g();

    public static abstract class b {

        public static abstract class a {
            public abstract b a();

            public abstract a b(long j);

            public abstract a c(Set<c> set);

            public abstract a d(long j);
        }

        /* access modifiers changed from: package-private */
        public abstract long b();

        /* access modifiers changed from: package-private */
        public abstract Set<c> c();

        /* access modifiers changed from: package-private */
        public abstract long d();

        public static a a() {
            return new c.b().c(Collections.emptySet());
        }
    }

    public static e e(c9 clock) {
        return a().a(com.google.android.datatransport.a.DEFAULT, b.a().b(30000).d(86400000).a()).a(com.google.android.datatransport.a.HIGHEST, b.a().b(1000).d(86400000).a()).a(com.google.android.datatransport.a.VERY_LOW, b.a().b(86400000).d(86400000).c(h(c.NETWORK_UNMETERED, c.DEVICE_IDLE)).a()).c(clock).b();
    }

    public static a a() {
        return new a();
    }

    static e c(c9 clock, Map<com.google.android.datatransport.a, b> values) {
        return new b(clock, values);
    }

    public static class a {
        private c9 a;

        /* renamed from: a  reason: collision with other field name */
        private Map<com.google.android.datatransport.a, b> f1373a = new HashMap();

        public a c(c9 clock) {
            this.a = clock;
            return this;
        }

        public a a(com.google.android.datatransport.a priority, b value) {
            this.f1373a.put(priority, value);
            return this;
        }

        public e b() {
            if (this.a == null) {
                throw new NullPointerException("missing required property: clock");
            } else if (this.f1373a.keySet().size() >= com.google.android.datatransport.a.values().length) {
                Map<com.google.android.datatransport.a, b> map = this.f1373a;
                this.f1373a = new HashMap();
                return e.c(this.a, map);
            } else {
                throw new IllegalStateException("Not all priorities have been configured");
            }
        }
    }

    public long f(com.google.android.datatransport.a priority, long minTimestamp, int attemptNumber) {
        b config = g().get(priority);
        return Math.min(Math.max(((long) Math.pow(2.0d, (double) (attemptNumber - 1))) * config.b(), minTimestamp - d().a()), config.d());
    }

    public JobInfo.Builder b(JobInfo.Builder builder, com.google.android.datatransport.a priority, long minimumTimestamp, int attemptNumber) {
        builder.setMinimumLatency(f(priority, minimumTimestamp, attemptNumber));
        i(builder, g().get(priority).c());
        return builder;
    }

    private void i(JobInfo.Builder builder, Set<c> flags) {
        if (flags.contains(c.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (flags.contains(c.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (flags.contains(c.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }

    private static <T> Set<T> h(T... values) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(values)));
    }
}
