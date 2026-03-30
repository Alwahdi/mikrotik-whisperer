package defpackage;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* renamed from: xq  reason: default package */
public final class xq extends ob0 {
    private final String a;

    /* renamed from: a  reason: collision with other field name */
    private final InetSocketAddress f5749a;

    /* renamed from: a  reason: collision with other field name */
    private final SocketAddress f5750a;
    private final String b;

    private xq(SocketAddress proxyAddress, InetSocketAddress targetAddress, String username, String password) {
        v90.o(proxyAddress, "proxyAddress");
        v90.o(targetAddress, "targetAddress");
        if (proxyAddress instanceof InetSocketAddress) {
            v90.w(!((InetSocketAddress) proxyAddress).isUnresolved(), "The proxy address %s is not resolved", proxyAddress);
        }
        this.f5750a = proxyAddress;
        this.f5749a = targetAddress;
        this.a = username;
        this.b = password;
    }

    public String a() {
        return this.b;
    }

    public String d() {
        return this.a;
    }

    public SocketAddress b() {
        return this.f5750a;
    }

    public InetSocketAddress c() {
        return this.f5749a;
    }

    public boolean equals(Object o) {
        if (!(o instanceof xq)) {
            return false;
        }
        xq that = (xq) o;
        if (!f40.a(this.f5750a, that.f5750a) || !f40.a(this.f5749a, that.f5749a) || !f40.a(this.a, that.a) || !f40.a(this.b, that.b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return f40.b(this.f5750a, this.f5749a, this.a, this.b);
    }

    public String toString() {
        return f20.c(this).d("proxyAddr", this.f5750a).d("targetAddr", this.f5749a).d("username", this.a).e("hasPassword", this.b != null).toString();
    }

    public static b e() {
        return new b();
    }

    /* renamed from: xq$b */
    public static final class b {
        private String a;

        /* renamed from: a  reason: collision with other field name */
        private InetSocketAddress f5751a;

        /* renamed from: a  reason: collision with other field name */
        private SocketAddress f5752a;
        private String b;

        private b() {
        }

        public b c(SocketAddress proxyAddress) {
            this.f5752a = (SocketAddress) v90.o(proxyAddress, "proxyAddress");
            return this;
        }

        public b d(InetSocketAddress targetAddress) {
            this.f5751a = (InetSocketAddress) v90.o(targetAddress, "targetAddress");
            return this;
        }

        public b e(String username) {
            this.a = username;
            return this;
        }

        public b b(String password) {
            this.b = password;
            return this;
        }

        public xq a() {
            return new xq(this.f5752a, this.f5751a, this.a, this.b);
        }
    }
}
