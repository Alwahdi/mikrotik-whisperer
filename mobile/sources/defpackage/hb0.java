package defpackage;

import kotlin.jvm.internal.a;

/* renamed from: hb0  reason: default package */
public class hb0 extends gb0 {
    public hb0(bw owner, String name, String signature) {
        super(a.NO_RECEIVER, ((t8) owner).a(), name, signature, (owner instanceof aw) ^ true ? 1 : 0);
    }

    public Object get(Object receiver) {
        return e().call(receiver);
    }
}
