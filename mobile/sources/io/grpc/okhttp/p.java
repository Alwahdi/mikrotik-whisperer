package io.grpc.okhttp;

import io.grpc.j;
import io.grpc.l;
import java.util.List;
import java.util.logging.Logger;

abstract class p {
    private static final Logger a = Logger.getLogger(p.class.getName());

    public static l a(List<pq> http2Headers) {
        return j.c(b(http2Headers));
    }

    public static l c(List<pq> http2Headers) {
        return j.c(b(http2Headers));
    }

    private static byte[][] b(List<pq> http2Headers) {
        byte[][] headerValues = new byte[(http2Headers.size() * 2)][];
        int i = 0;
        for (pq header : http2Headers) {
            int i2 = i + 1;
            headerValues[i] = header.f4727a.r();
            i = i2 + 1;
            headerValues[i2] = header.b.r();
        }
        return hs0.e(headerValues);
    }
}
