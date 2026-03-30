package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: me0  reason: default package */
public final class me0 extends a6<me0> {
    public static final me0 a = new me0(Collections.emptyList());

    private me0(List<String> segments) {
        super(segments);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public me0 e(List<String> segments) {
        return new me0(segments);
    }

    public static me0 s(List<String> segments) {
        return segments.isEmpty() ? a : new me0(segments);
    }

    public static me0 t(String path) {
        if (!path.contains("//")) {
            String[] rawSegments = path.split("/");
            ArrayList<String> segments = new ArrayList<>(rawSegments.length);
            for (String segment : rawSegments) {
                if (!segment.isEmpty()) {
                    segments.add(segment);
                }
            }
            return new me0(segments);
        }
        throw new IllegalArgumentException("Invalid path (" + path + "). Paths must not contain // in them.");
    }

    public String c() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.a.size(); i++) {
            if (i > 0) {
                builder.append("/");
            }
            builder.append(this.a.get(i));
        }
        return builder.toString();
    }
}
