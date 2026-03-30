package defpackage;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: jp  reason: default package */
public class jp {
    private static volatile jp a;

    /* renamed from: a  reason: collision with other field name */
    private final Set<yw> f4084a = new HashSet();

    jp() {
    }

    /* access modifiers changed from: package-private */
    public Set<yw> b() {
        Set<yw> unmodifiableSet;
        synchronized (this.f4084a) {
            unmodifiableSet = Collections.unmodifiableSet(this.f4084a);
        }
        return unmodifiableSet;
    }

    public static jp a() {
        jp localRef = a;
        if (localRef == null) {
            synchronized (jp.class) {
                localRef = a;
                if (localRef == null) {
                    jp jpVar = new jp();
                    localRef = jpVar;
                    a = jpVar;
                }
            }
        }
        return localRef;
    }
}
