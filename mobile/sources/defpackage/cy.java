package defpackage;

import java.util.List;
import java.util.Set;

/* renamed from: cy  reason: default package */
final /* synthetic */ class cy implements po0 {
    private final List a;

    /* renamed from: a  reason: collision with other field name */
    private final Set f2679a;

    /* renamed from: a  reason: collision with other field name */
    private final ky f2680a;

    /* renamed from: a  reason: collision with other field name */
    private final pr0 f2681a;

    private cy(ky kyVar, Set set, List list, pr0 pr0) {
        this.f2680a = kyVar;
        this.f2679a = set;
        this.a = list;
        this.f2681a = pr0;
    }

    public static po0 a(ky kyVar, Set set, List list, pr0 pr0) {
        return new cy(kyVar, set, list, pr0);
    }

    public Object get() {
        return ky.u(this.f2680a, this.f2679a, this.a, this.f2681a);
    }
}
