package defpackage;

import defpackage.vc;
import java.lang.Throwable;

/* renamed from: vc  reason: default package */
public interface vc<T extends Throwable & vc<T>> {
    T a();
}
