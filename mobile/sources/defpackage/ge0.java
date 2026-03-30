package defpackage;

import defpackage.qq;
import org.apache.http.client.methods.HttpGet;

/* renamed from: ge0  reason: default package */
public final class ge0 {
    private final Object a;

    /* renamed from: a  reason: collision with other field name */
    private final String f3066a;

    /* renamed from: a  reason: collision with other field name */
    private final qq f3067a;

    /* renamed from: a  reason: collision with other field name */
    private final yq f3068a;

    private ge0(b builder) {
        this.f3068a = builder.f3072a;
        this.f3066a = builder.f3070a;
        this.f3067a = builder.f3071a.c();
        he0 unused = builder.a;
        this.a = builder.f3069a != null ? builder.f3069a : this;
    }

    public yq b() {
        return this.f3068a;
    }

    public qq a() {
        return this.f3067a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f3066a);
        sb.append(", url=");
        sb.append(this.f3068a);
        sb.append(", tag=");
        Object obj = this.a;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: ge0$b */
    public static class b {
        /* access modifiers changed from: private */
        public he0 a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public Object f3069a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public String f3070a = HttpGet.METHOD_NAME;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public qq.b f3071a = new qq.b();
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public yq f3072a;

        public b h(yq url) {
            if (url != null) {
                this.f3072a = url;
                return this;
            }
            throw new IllegalArgumentException("url == null");
        }

        public b g(String name, String value) {
            this.f3071a.f(name, value);
            return this;
        }

        public ge0 f() {
            if (this.f3072a != null) {
                return new ge0(this);
            }
            throw new IllegalStateException("url == null");
        }
    }
}
