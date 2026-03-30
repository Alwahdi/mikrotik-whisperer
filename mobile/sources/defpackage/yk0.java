package defpackage;

import java.util.Set;

/* renamed from: yk0  reason: default package */
public abstract class yk0 {
    static boolean a(Set<?> s, Object object) {
        if (s == object) {
            return true;
        }
        if (!(object instanceof Set)) {
            return false;
        }
        Set<?> o = (Set) object;
        try {
            if (s.size() != o.size() || !s.containsAll(o)) {
                return false;
            }
            return true;
        } catch (ClassCastException | NullPointerException e) {
            return false;
        }
    }
}
