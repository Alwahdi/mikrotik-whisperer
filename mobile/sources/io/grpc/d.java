package io.grpc;

import io.grpc.b;
import java.util.Arrays;
import java.util.List;

public abstract class d {
    private static final b<Object, Object> a = new a();

    public static e8 b(e8 channel, w8... interceptors) {
        return a(channel, Arrays.asList(interceptors));
    }

    public static e8 a(e8 channel, List<? extends w8> interceptors) {
        v90.o(channel, "channel");
        for (w8 interceptor : interceptors) {
            channel = new b(channel, interceptor, (c) null);
        }
        return channel;
    }

    private static class b extends e8 {
        private final e8 a;

        /* renamed from: a  reason: collision with other field name */
        private final w8 f3266a;

        /* synthetic */ b(e8 x0, w8 x1, c x2) {
            this(x0, x1);
        }

        private b(e8 channel, w8 interceptor) {
            this.a = channel;
            this.f3266a = (w8) v90.o(interceptor, "interceptor");
        }

        public <ReqT, RespT> b<ReqT, RespT> h(m<ReqT, RespT> method, n7 callOptions) {
            return this.f3266a.a(method, callOptions, this.a);
        }

        public String a() {
            return this.a.a();
        }
    }

    class a extends b<Object, Object> {
        a() {
        }

        public void d(b.a<Object> aVar, l headers) {
        }

        public void b(int numMessages) {
        }

        public void a() {
        }

        public void c(Object message) {
        }
    }
}
