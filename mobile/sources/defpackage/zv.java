package defpackage;

import java.util.List;
import java.util.Map;
import kotlin.reflect.a;

/* renamed from: zv  reason: default package */
public interface zv<R> extends yv {
    R call(Object... objArr);

    R callBy(Map<Object, ? extends Object> map);

    List<Object> getParameters();

    gw getReturnType();

    List<Object> getTypeParameters();

    a getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();
}
