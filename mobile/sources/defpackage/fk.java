package defpackage;

import java.util.Collections;
import java.util.Map;

/* renamed from: fk  reason: default package */
public class fk {
    static final fk a = new fk(true);

    /* renamed from: a  reason: collision with other field name */
    private static final Class<?> f2973a = b();

    /* renamed from: a  reason: collision with other field name */
    private static volatile boolean f2974a = false;

    /* renamed from: a  reason: collision with other field name */
    private final Map<Object, Object> f2975a = Collections.emptyMap();

    static Class<?> b() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static fk a() {
        return ek.a();
    }

    fk(boolean empty) {
    }
}
