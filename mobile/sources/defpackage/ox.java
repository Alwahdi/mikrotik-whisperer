package defpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* renamed from: ox  reason: default package */
public interface ox<V> extends Future<V> {
    void addListener(Runnable runnable, Executor executor);
}
