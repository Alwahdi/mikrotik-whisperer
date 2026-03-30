package defpackage;

import java.util.Set;

/* renamed from: gs0  reason: default package */
final class gs0 implements fs0 {
    private final es0 a;

    /* renamed from: a  reason: collision with other field name */
    private final Set<qi> f3124a;

    /* renamed from: a  reason: collision with other field name */
    private final ks0 f3125a;

    gs0(Set<qi> supportedPayloadEncodings, es0 transportContext, ks0 transportInternal) {
        this.f3124a = supportedPayloadEncodings;
        this.a = transportContext;
        this.f3125a = transportInternal;
    }

    public <T> cs0<T> a(String name, Class<T> cls, qi payloadEncoding, as0<T, byte[]> payloadTransformer) {
        if (this.f3124a.contains(payloadEncoding)) {
            return new js0(this.a, name, payloadEncoding, payloadTransformer, this.f3125a);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", new Object[]{payloadEncoding, this.f3124a}));
    }
}
