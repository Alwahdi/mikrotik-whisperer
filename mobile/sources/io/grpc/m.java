package io.grpc;

import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class m<ReqT, RespT> {
    private final c<ReqT> a;

    /* renamed from: a  reason: collision with other field name */
    private final d f3807a;

    /* renamed from: a  reason: collision with other field name */
    private final Object f3808a;

    /* renamed from: a  reason: collision with other field name */
    private final String f3809a;

    /* renamed from: a  reason: collision with other field name */
    private final AtomicReferenceArray<Object> f3810a;

    /* renamed from: a  reason: collision with other field name */
    private final boolean f3811a;
    private final c<RespT> b;

    /* renamed from: b  reason: collision with other field name */
    private final String f3812b;

    /* renamed from: b  reason: collision with other field name */
    private final boolean f3813b;
    private final boolean c;

    public interface c<T> {
        InputStream a(T t);

        T b(InputStream inputStream);
    }

    public enum d {
        UNARY,
        CLIENT_STREAMING,
        SERVER_STREAMING,
        BIDI_STREAMING,
        UNKNOWN;

        public final boolean clientSendsOneMessage() {
            return this == UNARY || this == SERVER_STREAMING;
        }

        public final boolean serverSendsOneMessage() {
            return this == UNARY || this == CLIENT_STREAMING;
        }
    }

    private m(d type, String fullMethodName, c<ReqT> requestMarshaller, c<RespT> responseMarshaller, Object schemaDescriptor, boolean idempotent, boolean safe, boolean sampledToLocalTracing) {
        this.f3810a = new AtomicReferenceArray<>(2);
        if (!safe || idempotent) {
            this.f3807a = (d) v90.o(type, "type");
            this.f3809a = (String) v90.o(fullMethodName, "fullMethodName");
            this.f3812b = a(fullMethodName);
            this.a = (c) v90.o(requestMarshaller, "requestMarshaller");
            this.b = (c) v90.o(responseMarshaller, "responseMarshaller");
            this.f3808a = schemaDescriptor;
            this.f3811a = idempotent;
            this.f3813b = safe;
            this.c = sampledToLocalTracing;
            return;
        }
        throw new AssertionError("safe should imply idempotent");
    }

    public d e() {
        return this.f3807a;
    }

    public String c() {
        return this.f3809a;
    }

    public String d() {
        return this.f3812b;
    }

    public RespT i(InputStream input) {
        return this.b.b(input);
    }

    public InputStream j(ReqT requestMessage) {
        return this.a.a(requestMessage);
    }

    public boolean f() {
        return this.f3813b;
    }

    public static String b(String fullServiceName, String methodName) {
        return ((String) v90.o(fullServiceName, "fullServiceName")) + "/" + ((String) v90.o(methodName, "methodName"));
    }

    public static String a(String fullMethodName) {
        int index = ((String) v90.o(fullMethodName, "fullMethodName")).lastIndexOf(47);
        if (index == -1) {
            return null;
        }
        return fullMethodName.substring(0, index);
    }

    public static <ReqT, RespT> b<ReqT, RespT> g() {
        return h((c) null, (c) null);
    }

    public static <ReqT, RespT> b<ReqT, RespT> h(c<ReqT> requestMarshaller, c<RespT> responseMarshaller) {
        return new b().c(requestMarshaller).d(responseMarshaller);
    }

    public static final class b<ReqT, RespT> {
        private c<ReqT> a;

        /* renamed from: a  reason: collision with other field name */
        private d f3814a;

        /* renamed from: a  reason: collision with other field name */
        private Object f3815a;

        /* renamed from: a  reason: collision with other field name */
        private String f3816a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f3817a;
        private c<RespT> b;

        /* renamed from: b  reason: collision with other field name */
        private boolean f3818b;
        private boolean c;

        private b() {
        }

        public b<ReqT, RespT> c(c<ReqT> requestMarshaller) {
            this.a = requestMarshaller;
            return this;
        }

        public b<ReqT, RespT> d(c<RespT> responseMarshaller) {
            this.b = responseMarshaller;
            return this;
        }

        public b<ReqT, RespT> f(d type) {
            this.f3814a = type;
            return this;
        }

        public b<ReqT, RespT> b(String fullMethodName) {
            this.f3816a = fullMethodName;
            return this;
        }

        public b<ReqT, RespT> e(boolean value) {
            this.c = value;
            return this;
        }

        public m<ReqT, RespT> a() {
            return new m(this.f3814a, this.f3816a, this.a, this.b, this.f3815a, this.f3817a, this.f3818b, this.c);
        }
    }

    public String toString() {
        return f20.c(this).d("fullMethodName", this.f3809a).d("type", this.f3807a).e("idempotent", this.f3811a).e("safe", this.f3813b).e("sampledToLocalTracing", this.c).d("requestMarshaller", this.a).d("responseMarshaller", this.b).d("schemaDescriptor", this.f3808a).h().toString();
    }
}
