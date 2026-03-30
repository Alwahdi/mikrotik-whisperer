package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: e40  reason: default package */
public abstract class e40 {
    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a c(Object obj) {
        return new a(obj);
    }

    /* renamed from: e40$a */
    public static final class a {
        private final Object a;

        /* renamed from: a  reason: collision with other field name */
        private final List<String> f2843a;

        private a(Object obj) {
            this.a = y90.j(obj);
            this.f2843a = new ArrayList();
        }

        public final a a(String str, Object obj) {
            List<String> list = this.f2843a;
            String str2 = (String) y90.j(str);
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(valueOf).length());
            sb.append(str2);
            sb.append("=");
            sb.append(valueOf);
            list.add(sb.toString());
            return this;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.a.getClass().getSimpleName());
            sb.append('{');
            int size = this.f2843a.size();
            for (int i = 0; i < size; i++) {
                sb.append(this.f2843a.get(i));
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }
}
