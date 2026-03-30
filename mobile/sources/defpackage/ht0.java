package defpackage;

import com.google.protobuf.m;
import com.google.protobuf.p;
import java.util.List;

/* renamed from: ht0  reason: default package */
public class ht0 extends RuntimeException {
    private final List<String> a = null;

    public ht0(p message) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public m a() {
        return new m(getMessage());
    }
}
