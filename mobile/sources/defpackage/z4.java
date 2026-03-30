package defpackage;

import com.google.android.datatransport.Event;
import com.google.android.datatransport.a;

/* renamed from: z4  reason: default package */
final class z4<T> extends wi<T> {
    private final a a;

    /* renamed from: a  reason: collision with other field name */
    private final Integer f5970a;

    /* renamed from: a  reason: collision with other field name */
    private final T f5971a;

    z4(Integer code, T payload, a priority) {
        this.f5970a = code;
        if (payload != null) {
            this.f5971a = payload;
            if (priority != null) {
                this.a = priority;
                return;
            }
            throw new NullPointerException("Null priority");
        }
        throw new NullPointerException("Null payload");
    }

    public Integer a() {
        return this.f5970a;
    }

    public T b() {
        return this.f5971a;
    }

    public a c() {
        return this.a;
    }

    public String toString() {
        return "Event{code=" + this.f5970a + ", payload=" + this.f5971a + ", priority=" + this.a + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof wi)) {
            return false;
        }
        Event<?> that = (wi) o;
        Integer num = this.f5970a;
        if (num != null ? num.equals(that.a()) : that.a() == null) {
            if (!this.f5971a.equals(that.b()) || !this.a.equals(that.c())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int h$ = 1 * 1000003;
        Integer num = this.f5970a;
        return ((((h$ ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f5971a.hashCode()) * 1000003) ^ this.a.hashCode();
    }
}
