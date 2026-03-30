package io.grpc.internal;

import java.io.Closeable;
import java.net.SocketAddress;
import java.util.concurrent.ScheduledExecutorService;

public interface q extends Closeable {
    bc M(SocketAddress socketAddress, a aVar, io.grpc.a aVar2);

    void close();

    ScheduledExecutorService u();

    public static final class a {
        private String a = "unknown-authority";

        /* renamed from: a  reason: collision with other field name */
        private v4 f3565a = v4.a;

        /* renamed from: a  reason: collision with other field name */
        private xq f3566a;
        private String b;

        public String a() {
            return this.a;
        }

        public a e(String authority) {
            this.a = (String) v90.o(authority, "authority");
            return this;
        }

        public v4 b() {
            return this.f3565a;
        }

        public a f(v4 eagAttributes) {
            v90.o(eagAttributes, "eagAttributes");
            this.f3565a = eagAttributes;
            return this;
        }

        public String d() {
            return this.b;
        }

        public a h(String userAgent) {
            this.b = userAgent;
            return this;
        }

        public xq c() {
            return this.f3566a;
        }

        public a g(xq connectProxiedSocketAddr) {
            this.f3566a = connectProxiedSocketAddr;
            return this;
        }

        public int hashCode() {
            return f40.b(this.a, this.f3565a, this.b, this.f3566a);
        }

        public boolean equals(Object o) {
            if (!(o instanceof a)) {
                return false;
            }
            a that = (a) o;
            if (!this.a.equals(that.a) || !this.f3565a.equals(that.f3565a) || !f40.a(this.b, that.b) || !f40.a(this.f3566a, that.f3566a)) {
                return false;
            }
            return true;
        }
    }
}
