package io.grpc.internal;

import io.grpc.p;
import java.io.InputStream;

abstract class b0 implements z8 {
    /* access modifiers changed from: protected */
    public abstract z8 p();

    b0() {
    }

    public void f(int numMessages) {
        p().f(numMessages);
    }

    public void g(InputStream message) {
        p().g(message);
    }

    public void flush() {
        p().flush();
    }

    public void o() {
        p().o();
    }

    public void e(tb compressor) {
        p().e(compressor);
    }

    public void b(p reason) {
        p().b(reason);
    }

    public void m() {
        p().m();
    }

    public void j(String authority) {
        p().j(authority);
    }

    public void l(boolean fullStreamDecompression) {
        p().l(fullStreamDecompression);
    }

    public void d(gf decompressorRegistry) {
        p().d(decompressorRegistry);
    }

    public void k(o listener) {
        p().k(listener);
    }

    public void c(int maxSize) {
        p().c(maxSize);
    }

    public void a(int maxSize) {
        p().a(maxSize);
    }

    public void h(ze deadline) {
        p().h(deadline);
    }

    public String toString() {
        return f20.c(this).d("delegate", p()).toString();
    }

    public void n(vs insight) {
        p().n(insight);
    }
}
