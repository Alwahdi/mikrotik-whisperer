package defpackage;

/* renamed from: js0  reason: default package */
final class js0<T> implements cs0<T> {
    private final as0<T, byte[]> a;

    /* renamed from: a  reason: collision with other field name */
    private final es0 f4090a;

    /* renamed from: a  reason: collision with other field name */
    private final String f4091a;

    /* renamed from: a  reason: collision with other field name */
    private final ks0 f4092a;

    /* renamed from: a  reason: collision with other field name */
    private final qi f4093a;

    js0(es0 transportContext, String name, qi payloadEncoding, as0<T, byte[]> transformer, ks0 transportInternal) {
        this.f4090a = transportContext;
        this.f4091a = name;
        this.f4093a = payloadEncoding;
        this.a = transformer;
        this.f4092a = transportInternal;
    }

    static /* synthetic */ void b(Exception e) {
    }

    public void a(wi<T> event) {
        c(event, is0.b());
    }

    public void c(wi<T> event, os0 callback) {
        this.f4092a.a(zj0.a().e(this.f4090a).c(event).f(this.f4091a).d(this.a).b(this.f4093a).a(), callback);
    }
}
