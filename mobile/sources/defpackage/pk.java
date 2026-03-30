package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: pk  reason: default package */
public final class pk extends a6<pk> {
    public static final pk a = t("__name__");
    public static final pk b = new pk(Collections.emptyList());

    private pk(List<String> segments) {
        super(segments);
    }

    public static pk t(String fieldName) {
        return new pk(Collections.singletonList(fieldName));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public pk e(List<String> segments) {
        return new pk(segments);
    }

    public static pk s(String path) {
        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int i = 0;
        boolean inBackticks = false;
        while (i < path.length()) {
            char c = path.charAt(i);
            if (c == '\\') {
                if (i + 1 != path.length()) {
                    i++;
                    builder.append(path.charAt(i));
                } else {
                    throw new IllegalArgumentException("Trailing escape character is not allowed");
                }
            } else if (c == '.') {
                if (!inBackticks) {
                    String elem = builder.toString();
                    if (!elem.isEmpty()) {
                        builder = new StringBuilder();
                        res.add(elem);
                    } else {
                        throw new IllegalArgumentException("Invalid field path (" + path + "). Paths must not be empty, begin with '.', end with '.', or contain '..'");
                    }
                } else {
                    builder.append(c);
                }
            } else if (c == '`') {
                inBackticks = !inBackticks;
            } else {
                builder.append(c);
            }
            i++;
        }
        String lastElem = builder.toString();
        if (!lastElem.isEmpty()) {
            res.add(lastElem);
            return new pk(res);
        }
        throw new IllegalArgumentException("Invalid field path (" + path + "). Paths must not be empty, begin with '.', end with '.', or contain '..'");
    }

    private static boolean v(String identifier) {
        if (identifier.isEmpty()) {
            return false;
        }
        char first = identifier.charAt(0);
        if (first != '_' && ((first < 'a' || first > 'z') && (first < 'A' || first > 'Z'))) {
            return false;
        }
        for (int i = 1; i < identifier.length(); i++) {
            char c = identifier.charAt(i);
            if (c != '_' && ((c < 'a' || c > 'z') && ((c < 'A' || c > 'Z') && (c < '0' || c > '9')))) {
                return false;
            }
        }
        return true;
    }

    public String c() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.a.size(); i++) {
            if (i > 0) {
                builder.append(".");
            }
            String escaped = this.a.get(i).replace("\\", "\\\\").replace("`", "\\`");
            if (!v(escaped)) {
                escaped = '`' + escaped + '`';
            }
            builder.append(escaped);
        }
        return builder.toString();
    }

    public boolean u() {
        return equals(a);
    }
}
