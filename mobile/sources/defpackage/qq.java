package defpackage;

import java.util.ArrayList;
import java.util.List;

/* renamed from: qq  reason: default package */
public final class qq {
    private final String[] a;

    private qq(b builder) {
        this.a = (String[]) builder.a.toArray(new String[builder.a.size()]);
    }

    public int b() {
        return this.a.length / 2;
    }

    public String a(int index) {
        int nameIndex = index * 2;
        if (nameIndex < 0) {
            return null;
        }
        String[] strArr = this.a;
        if (nameIndex >= strArr.length) {
            return null;
        }
        return strArr[nameIndex];
    }

    public String c(int index) {
        int valueIndex = (index * 2) + 1;
        if (valueIndex < 0) {
            return null;
        }
        String[] strArr = this.a;
        if (valueIndex >= strArr.length) {
            return null;
        }
        return strArr[valueIndex];
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        int size = b();
        for (int i = 0; i < size; i++) {
            result.append(a(i));
            result.append(": ");
            result.append(c(i));
            result.append("\n");
        }
        return result.toString();
    }

    /* renamed from: qq$b */
    public static final class b {
        /* access modifiers changed from: private */
        public final List<String> a = new ArrayList(20);

        /* access modifiers changed from: package-private */
        public b b(String name, String value) {
            this.a.add(name);
            this.a.add(value.trim());
            return this;
        }

        public b e(String name) {
            int i = 0;
            while (i < this.a.size()) {
                if (name.equalsIgnoreCase(this.a.get(i))) {
                    this.a.remove(i);
                    this.a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public b f(String name, String value) {
            d(name, value);
            e(name);
            b(name, value);
            return this;
        }

        private void d(String name, String value) {
            if (name == null) {
                throw new IllegalArgumentException("name == null");
            } else if (!name.isEmpty()) {
                int length = name.length();
                for (int i = 0; i < length; i++) {
                    char c = name.charAt(i);
                    if (c <= 31 || c >= 127) {
                        throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header name: %s", new Object[]{Integer.valueOf(c), Integer.valueOf(i), name}));
                    }
                }
                if (value != null) {
                    int length2 = value.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        char c2 = value.charAt(i2);
                        if (c2 <= 31 || c2 >= 127) {
                            throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header value: %s", new Object[]{Integer.valueOf(c2), Integer.valueOf(i2), value}));
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("value == null");
            } else {
                throw new IllegalArgumentException("name is empty");
            }
        }

        public qq c() {
            return new qq(this);
        }
    }
}
