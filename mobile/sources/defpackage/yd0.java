package defpackage;

import kotlin.jvm.internal.b;

/* renamed from: yd0  reason: default package */
public class yd0 {
    public bw c(Class javaClass, String moduleName) {
        return new d50(javaClass, moduleName);
    }

    public aw b(Class javaClass) {
        return new u8(javaClass);
    }

    public String g(ow lambda) {
        return f(lambda);
    }

    public String f(wo lambda) {
        String result = lambda.getClass().getGenericInterfaces()[0].toString();
        return result.startsWith("kotlin.jvm.functions.") ? result.substring("kotlin.jvm.functions.".length()) : result;
    }

    public cw a(b f) {
        return f;
    }

    public dw d(eb0 p) {
        return p;
    }

    public ew e(gb0 p) {
        return p;
    }
}
