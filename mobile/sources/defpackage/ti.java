package defpackage;

import defpackage.v4;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: ti  reason: default package */
public final class ti {
    public static final v4.c<String> a = v4.c.a("io.grpc.EquivalentAddressGroup.authorityOverride");

    /* renamed from: a  reason: collision with other field name */
    private final int f5099a;

    /* renamed from: a  reason: collision with other field name */
    private final List<SocketAddress> f5100a;

    /* renamed from: a  reason: collision with other field name */
    private final v4 f5101a;

    public ti(List<SocketAddress> addrs) {
        this(addrs, v4.a);
    }

    public ti(List<SocketAddress> addrs, v4 attrs) {
        v90.e(!addrs.isEmpty(), "addrs is empty");
        List<SocketAddress> unmodifiableList = Collections.unmodifiableList(new ArrayList(addrs));
        this.f5100a = unmodifiableList;
        this.f5101a = (v4) v90.o(attrs, "attrs");
        this.f5099a = unmodifiableList.hashCode();
    }

    public ti(SocketAddress addr) {
        this(addr, v4.a);
    }

    public ti(SocketAddress addr, v4 attrs) {
        this((List<SocketAddress>) Collections.singletonList(addr), attrs);
    }

    public List<SocketAddress> a() {
        return this.f5100a;
    }

    public v4 b() {
        return this.f5101a;
    }

    public String toString() {
        return "[" + this.f5100a + "/" + this.f5101a + "]";
    }

    public int hashCode() {
        return this.f5099a;
    }

    public boolean equals(Object other) {
        if (!(other instanceof ti)) {
            return false;
        }
        ti that = (ti) other;
        if (this.f5100a.size() != that.f5100a.size()) {
            return false;
        }
        for (int i = 0; i < this.f5100a.size(); i++) {
            if (!this.f5100a.get(i).equals(that.f5100a.get(i))) {
                return false;
            }
        }
        if (!this.f5101a.equals(that.f5101a)) {
            return false;
        }
        return true;
    }
}
