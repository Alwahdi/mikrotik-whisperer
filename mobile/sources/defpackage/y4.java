package defpackage;

import android.content.Context;

/* renamed from: y4  reason: default package */
final class y4 extends rd {
    private final Context a;

    /* renamed from: a  reason: collision with other field name */
    private final c9 f5814a;

    /* renamed from: a  reason: collision with other field name */
    private final String f5815a;
    private final c9 b;

    y4(Context applicationContext, c9 wallClock, c9 monotonicClock, String backendName) {
        if (applicationContext != null) {
            this.a = applicationContext;
            if (wallClock != null) {
                this.f5814a = wallClock;
                if (monotonicClock != null) {
                    this.b = monotonicClock;
                    if (backendName != null) {
                        this.f5815a = backendName;
                        return;
                    }
                    throw new NullPointerException("Null backendName");
                }
                throw new NullPointerException("Null monotonicClock");
            }
            throw new NullPointerException("Null wallClock");
        }
        throw new NullPointerException("Null applicationContext");
    }

    public Context b() {
        return this.a;
    }

    public c9 e() {
        return this.f5814a;
    }

    public c9 d() {
        return this.b;
    }

    public String c() {
        return this.f5815a;
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.a + ", wallClock=" + this.f5814a + ", monotonicClock=" + this.b + ", backendName=" + this.f5815a + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof rd)) {
            return false;
        }
        rd that = (rd) o;
        if (!this.a.equals(that.b()) || !this.f5814a.equals(that.e()) || !this.b.equals(that.d()) || !this.f5815a.equals(that.c())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((1 * 1000003) ^ this.a.hashCode()) * 1000003) ^ this.f5814a.hashCode()) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.f5815a.hashCode();
    }
}
