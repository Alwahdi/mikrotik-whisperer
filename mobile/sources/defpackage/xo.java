package defpackage;

import kotlin.jvm.internal.a;
import kotlin.jvm.internal.b;

/* renamed from: xo  reason: default package */
public abstract class xo extends b {
    public xo(int arity, Class owner, String name, String signature, int flags) {
        super(arity, a.NO_RECEIVER, owner, name, signature, flags);
    }

    public xo(int arity, Object receiver, Class owner, String name, String signature, int flags) {
        super(arity, receiver, owner, name, signature, flags);
    }
}
