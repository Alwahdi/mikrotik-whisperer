package defpackage;

import java.util.Arrays;

/* renamed from: f20  reason: default package */
public abstract class f20 {
    public static <T> T a(T first, T second) {
        if (first != null) {
            return first;
        }
        if (second != null) {
            return second;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static b c(Object self) {
        return new b(self.getClass().getSimpleName());
    }

    public static b b(Class<?> clazz) {
        return new b(clazz.getSimpleName());
    }

    /* renamed from: f20$b */
    public static final class b {
        private final a a;

        /* renamed from: a  reason: collision with other field name */
        private final String f2938a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f2939a;
        private a b;

        private b(String className) {
            a aVar = new a();
            this.a = aVar;
            this.b = aVar;
            this.f2939a = false;
            this.f2938a = (String) v90.n(className);
        }

        public b h() {
            this.f2939a = true;
            return this;
        }

        public b d(String name, Object value) {
            return g(name, value);
        }

        public b e(String name, boolean value) {
            return g(name, String.valueOf(value));
        }

        public b a(String name, double value) {
            return g(name, String.valueOf(value));
        }

        public b b(String name, int value) {
            return g(name, String.valueOf(value));
        }

        public b c(String name, long value) {
            return g(name, String.valueOf(value));
        }

        public String toString() {
            boolean omitNullValuesSnapshot = this.f2939a;
            String nextSeparator = "";
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f2938a);
            StringBuilder builder = sb.append('{');
            for (a valueHolder = this.a.a; valueHolder != null; valueHolder = valueHolder.a) {
                Object value = valueHolder.f2940a;
                if (!omitNullValuesSnapshot || value != null) {
                    builder.append(nextSeparator);
                    nextSeparator = ", ";
                    String str = valueHolder.f2941a;
                    if (str != null) {
                        builder.append(str);
                        builder.append('=');
                    }
                    if (value == null || !value.getClass().isArray()) {
                        builder.append(value);
                    } else {
                        String arrayString = Arrays.deepToString(new Object[]{value});
                        builder.append(arrayString, 1, arrayString.length() - 1);
                    }
                }
            }
            builder.append('}');
            return builder.toString();
        }

        private a f() {
            a valueHolder = new a();
            this.b.a = valueHolder;
            this.b = valueHolder;
            return valueHolder;
        }

        private b g(String name, Object value) {
            a valueHolder = f();
            valueHolder.f2940a = value;
            valueHolder.f2941a = (String) v90.n(name);
            return this;
        }

        /* renamed from: f20$b$a */
        private static final class a {
            a a;

            /* renamed from: a  reason: collision with other field name */
            Object f2940a;

            /* renamed from: a  reason: collision with other field name */
            String f2941a;

            private a() {
            }
        }
    }
}
