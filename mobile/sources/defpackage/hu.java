package defpackage;

import java.util.concurrent.atomic.AtomicLong;

/* renamed from: hu  reason: default package */
public final class hu {
    private static final AtomicLong a = new AtomicLong();

    /* renamed from: a  reason: collision with other field name */
    private final long f3180a;

    /* renamed from: a  reason: collision with other field name */
    private final String f3181a;
    private final String b;

    public static hu a(Class<?> type, String details) {
        return b(c(type), details);
    }

    public static hu b(String typeName, String details) {
        return new hu(typeName, details, e());
    }

    static long e() {
        return a.incrementAndGet();
    }

    hu(String typeName, String details, long id) {
        v90.o(typeName, "typeName");
        v90.e(!typeName.isEmpty(), "empty type");
        this.f3181a = typeName;
        this.b = details;
        this.f3180a = id;
    }

    public long d() {
        return this.f3180a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(f());
        if (this.b != null) {
            sb.append(": (");
            sb.append(this.b);
            sb.append(')');
        }
        return sb.toString();
    }

    private static String c(Class<?> type) {
        String className = ((Class) v90.o(type, "type")).getSimpleName();
        if (!className.isEmpty()) {
            return className;
        }
        return type.getName().substring(type.getPackage().getName().length() + 1);
    }

    public String f() {
        return this.f3181a + "<" + this.f3180a + ">";
    }
}
