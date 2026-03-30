package defpackage;

import java.util.List;
import java.util.Map;
import javax.net.SocketFactory;
import me.legrange.mikrotik.impl.b;

/* renamed from: j3  reason: default package */
public abstract class j3 implements AutoCloseable {
    public abstract void C(String str, String str2, boolean z);

    public abstract void J(int i);

    public abstract void close();

    public abstract String o(String str, ue0 ue0);

    public abstract List<Map<String, String>> q(String str);

    public abstract boolean w();

    public static j3 f(SocketFactory fact, String host, int port, int timeout) {
        return b.f(fact, host, port, timeout);
    }

    public static j3 c(String host, Integer port) {
        return f(SocketFactory.getDefault(), host, port.intValue(), 30000);
    }
}
