package defpackage;

import android.content.Context;

/* renamed from: fl  reason: default package */
final /* synthetic */ class fl implements mb0 {
    private final Context a;

    /* renamed from: a  reason: collision with other field name */
    private final gl f2976a;

    private fl(gl glVar, Context context) {
        this.f2976a = glVar;
        this.a = context;
    }

    public static mb0 a(gl glVar, Context context) {
        return new fl(glVar, context);
    }

    public Object get() {
        return gl.u(this.f2976a, this.a);
    }
}
