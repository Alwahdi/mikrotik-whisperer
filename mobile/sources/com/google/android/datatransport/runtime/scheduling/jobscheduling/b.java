package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.a;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.e;
import java.util.Map;

final class b extends e {
    private final c9 a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<a, e.b> f1369a;

    b(c9 clock, Map<a, e.b> values) {
        if (clock != null) {
            this.a = clock;
            if (values != null) {
                this.f1369a = values;
                return;
            }
            throw new NullPointerException("Null values");
        }
        throw new NullPointerException("Null clock");
    }

    /* access modifiers changed from: package-private */
    public c9 d() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public Map<a, e.b> g() {
        return this.f1369a;
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.a + ", values=" + this.f1369a + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof e)) {
            return false;
        }
        e that = (e) o;
        if (!this.a.equals(that.d()) || !this.f1369a.equals(that.g())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((1 * 1000003) ^ this.a.hashCode()) * 1000003) ^ this.f1369a.hashCode();
    }
}
