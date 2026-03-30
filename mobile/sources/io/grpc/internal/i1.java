package io.grpc.internal;

import io.grpc.internal.h1;

public final class i1<T> implements b40<T> {
    private final h1.d<T> a;

    private i1(h1.d<T> resource) {
        this.a = resource;
    }

    public static <T> i1<T> c(h1.d<T> resource) {
        return new i1<>(resource);
    }

    public T b() {
        return h1.d(this.a);
    }

    public T a(Object object) {
        h1.f(this.a, object);
        return null;
    }
}
