package io.grpc.internal;

import io.grpc.internal.a;
import io.grpc.j;
import io.grpc.k;
import io.grpc.l;
import io.grpc.p;
import java.nio.charset.Charset;

public abstract class k0 extends a.c {
    private static final j.a<Integer> a;

    /* renamed from: a  reason: collision with other field name */
    private static final l.g<Integer> f3465a;

    /* renamed from: a  reason: collision with other field name */
    private l f3466a;

    /* renamed from: a  reason: collision with other field name */
    private p f3467a;

    /* renamed from: a  reason: collision with other field name */
    private Charset f3468a = j8.c;
    private boolean i;

    /* access modifiers changed from: protected */
    public abstract void O(p pVar, boolean z, l lVar);

    public /* bridge */ /* synthetic */ void c(boolean z) {
        super.c(z);
    }

    class a implements j.a<Integer> {
        a() {
        }

        /* renamed from: d */
        public byte[] a(Integer value) {
            throw new UnsupportedOperationException();
        }

        /* renamed from: c */
        public Integer b(byte[] serialized) {
            if (serialized.length >= 3) {
                return Integer.valueOf(((serialized[0] - 48) * 100) + ((serialized[1] - 48) * 10) + (serialized[2] - 48));
            }
            throw new NumberFormatException("Malformed status code " + new String(serialized, j.a));
        }
    }

    static {
        a aVar = new a();
        a = aVar;
        f3465a = j.b(":status", aVar);
    }

    protected k0(int maxMessageSize, cn0 statsTraceCtx, m1 transportTracer) {
        super(maxMessageSize, statsTraceCtx, transportTracer);
    }

    /* access modifiers changed from: protected */
    public void S(l headers) {
        v90.o(headers, "headers");
        p pVar = this.f3467a;
        if (pVar != null) {
            this.f3467a = pVar.e("headers: " + headers);
            return;
        }
        try {
            if (this.i) {
                p q = p.o.q("Received headers twice");
                this.f3467a = q;
                if (q != null) {
                    this.f3467a = q.e("headers: " + headers);
                    this.f3466a = headers;
                    this.f3468a = N(headers);
                    return;
                }
                return;
            }
            Integer httpStatus = (Integer) headers.f(f3465a);
            if (httpStatus == null || httpStatus.intValue() < 100 || httpStatus.intValue() >= 200) {
                this.i = true;
                p U = U(headers);
                this.f3467a = U;
                if (U == null) {
                    Q(headers);
                    D(headers);
                    p pVar2 = this.f3467a;
                    if (pVar2 != null) {
                        this.f3467a = pVar2.e("headers: " + headers);
                        this.f3466a = headers;
                        this.f3468a = N(headers);
                    }
                } else if (U != null) {
                    this.f3467a = U.e("headers: " + headers);
                    this.f3466a = headers;
                    this.f3468a = N(headers);
                }
            }
        } finally {
            p pVar3 = this.f3467a;
            if (pVar3 != null) {
                this.f3467a = pVar3.e("headers: " + headers);
                this.f3466a = headers;
                this.f3468a = N(headers);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void R(id0 frame, boolean endOfStream) {
        p pVar = this.f3467a;
        if (pVar != null) {
            this.f3467a = pVar.e("DATA-----------------------------\n" + jd0.d(frame, this.f3468a));
            frame.close();
            if (this.f3467a.n().length() > 1000 || endOfStream) {
                O(this.f3467a, false, this.f3466a);
            }
        } else if (!this.i) {
            O(p.o.q("headers not received before payload"), false, new l());
        } else {
            C(frame);
            if (endOfStream) {
                this.f3467a = p.o.q("Received unexpected EOS on DATA frame from server.");
                l lVar = new l();
                this.f3466a = lVar;
                M(this.f3467a, false, lVar);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void T(l trailers) {
        v90.o(trailers, "trailers");
        if (this.f3467a == null && !this.i) {
            p U = U(trailers);
            this.f3467a = U;
            if (U != null) {
                this.f3466a = trailers;
            }
        }
        p pVar = this.f3467a;
        if (pVar != null) {
            p e = pVar.e("trailers: " + trailers);
            this.f3467a = e;
            O(e, false, this.f3466a);
            return;
        }
        p status = P(trailers);
        Q(trailers);
        E(trailers, status);
    }

    private p P(l trailers) {
        p status;
        p status2 = (p) trailers.f(k.b);
        if (status2 != null) {
            return status2.q((String) trailers.f(k.a));
        }
        if (this.i) {
            return p.c.q("missing GRPC status in response");
        }
        Integer httpStatus = (Integer) trailers.f(f3465a);
        if (httpStatus != null) {
            status = h0.j(httpStatus.intValue());
        } else {
            status = p.o.q("missing HTTP status code");
        }
        return status.e("missing GRPC status, inferred error from HTTP status code");
    }

    private p U(l headers) {
        Integer httpStatus = (Integer) headers.f(f3465a);
        if (httpStatus == null) {
            return p.o.q("Missing HTTP status code");
        }
        String contentType = (String) headers.f(h0.f);
        if (h0.k(contentType)) {
            return null;
        }
        p j = h0.j(httpStatus.intValue());
        return j.e("invalid content-type: " + contentType);
    }

    private static Charset N(l headers) {
        String contentType = (String) headers.f(h0.f);
        if (contentType != null) {
            String[] split = contentType.split("charset=", 2);
            try {
                return Charset.forName(split[split.length - 1].trim());
            } catch (Exception e) {
            }
        }
        return j8.c;
    }

    private static void Q(l metadata) {
        metadata.d(f3465a);
        metadata.d(k.b);
        metadata.d(k.a);
    }
}
