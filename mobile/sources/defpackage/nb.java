package defpackage;

import java.util.Set;

/* renamed from: nb  reason: default package */
final /* synthetic */ class nb implements mb0 {
    private final Set a;

    private nb(Set set) {
        this.a = set;
    }

    public static mb0 a(Set set) {
        return new nb(set);
    }

    public Object get() {
        return pb.g(this.a);
    }
}
