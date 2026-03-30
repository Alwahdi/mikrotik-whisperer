package defpackage;

import com.google.android.datatransport.runtime.backends.b;
import defpackage.xo0;

/* renamed from: rt0  reason: default package */
final /* synthetic */ class rt0 implements xo0.a {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final b f4944a;

    /* renamed from: a  reason: collision with other field name */
    private final es0 f4945a;

    /* renamed from: a  reason: collision with other field name */
    private final Iterable f4946a;

    /* renamed from: a  reason: collision with other field name */
    private final ut0 f4947a;

    private rt0(ut0 ut0, b bVar, Iterable iterable, es0 es0, int i) {
        this.f4947a = ut0;
        this.f4944a = bVar;
        this.f4946a = iterable;
        this.f4945a = es0;
        this.a = i;
    }

    public static xo0.a b(ut0 ut0, b bVar, Iterable iterable, es0 es0, int i) {
        return new rt0(ut0, bVar, iterable, es0, i);
    }

    public Object a() {
        return ut0.c(this.f4947a, this.f4944a, this.f4946a, this.f4945a, this.a);
    }
}
