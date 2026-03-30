package me.legrange.mikrotik.impl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import javax.net.SocketFactory;

public final class b extends j3 {
    private int a = 30000;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public DataInputStream f4329a = null;

    /* renamed from: a  reason: collision with other field name */
    private DataOutputStream f4330a = null;

    /* renamed from: a  reason: collision with other field name */
    private Integer f4331a = 0;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public Socket f4332a = null;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final Map<String, ue0> f4333a = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with other field name */
    private C0055b f4334a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public c f4335a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public boolean f4336a = false;

    public static j3 f(SocketFactory fact, String host, int port, int timeOut) {
        b con = new b();
        con.b0(host, port, fact, timeOut);
        return con;
    }

    public boolean w() {
        return this.f4336a;
    }

    public void C(String username, String password, boolean neworold) {
        if (neworold) {
            if (!username.trim().isEmpty()) {
                d cmd = new d("/login");
                cmd.a("name", username);
                cmd.a("password", password);
                List<Map<String, String>> list = Z(cmd, this.a);
                if (!list.isEmpty()) {
                    Map<String, String> res = list.get(0);
                    if (res.containsKey("ret")) {
                        String chal = n.d(n.e("00") + new String(password.toCharArray()) + n.e(res.get("ret")));
                        q("/login name=" + username + " response=00" + chal);
                        return;
                    }
                    return;
                }
                return;
            }
            throw new k3("API username cannot be empty");
        } else if (!username.trim().isEmpty()) {
            String chal2 = n.d(n.e("00") + new String(password.toCharArray()) + n.e(q("/login").get(0).get("ret")));
            q("/login name=" + username + " response=00" + chal2);
        } else {
            throw new k3("API username cannot be empty");
        }
    }

    public List<Map<String, String>> q(String cmd) {
        return Z(i.p(cmd), this.a);
    }

    public String o(String cmd, ue0 lis) {
        return Y(i.p(cmd), lis);
    }

    public void J(int timeout) {
        if (timeout > 0) {
            this.a = timeout;
        } else {
            throw new s10(String.format("Invalid timeout value '%d'; must be postive", new Object[]{Integer.valueOf(timeout)}));
        }
    }

    public void close() {
        if (this.f4336a) {
            this.f4336a = false;
            this.f4334a.interrupt();
            this.f4335a.interrupt();
            try {
                this.f4329a.close();
                this.f4330a.close();
                this.f4332a.close();
            } catch (IOException ex) {
                throw new k3(String.format("Error closing socket: %s", new Object[]{ex.getMessage()}), ex);
            }
        } else {
            throw new k3("Not/no longer connected to remote Mikrotik");
        }
    }

    private List<Map<String, String>> Z(d cmd, int timeout) {
        d l = new d();
        Y(cmd, l);
        return l.f(timeout);
    }

    private String Y(d cmd, ue0 lis) {
        String tag = a0();
        cmd.j(tag);
        this.f4333a.put(tag, lis);
        try {
            n.g(cmd, this.f4330a);
            return tag;
        } catch (UnsupportedEncodingException ex) {
            throw new c(ex.getMessage(), ex);
        } catch (IOException ex2) {
            throw new k3(ex2.getMessage(), ex2);
        }
    }

    private b() {
    }

    private void b0(String host, int port, SocketFactory fact, int conTimeout) {
        try {
            InetAddress ia = InetAddress.getByName(host.trim());
            Socket createSocket = fact.createSocket();
            this.f4332a = createSocket;
            createSocket.connect(new InetSocketAddress(ia, port), conTimeout);
            this.f4329a = new DataInputStream(this.f4332a.getInputStream());
            this.f4330a = new DataOutputStream(this.f4332a.getOutputStream());
            this.f4336a = true;
            c cVar = new c();
            this.f4335a = cVar;
            cVar.setDaemon(true);
            this.f4335a.start();
            C0055b bVar = new C0055b();
            this.f4334a = bVar;
            bVar.setDaemon(true);
            this.f4334a.start();
        } catch (UnknownHostException ex) {
            this.f4336a = false;
            throw new k3(String.format("Unknown host '%s'", new Object[]{host}), ex);
        } catch (IOException ex2) {
            this.f4336a = false;
            throw new k3(String.format("Error connecting to %s:%d : %s", new Object[]{host, Integer.valueOf(port), ex2.getMessage()}), ex2);
        }
    }

    private synchronized String a0() {
        Integer valueOf;
        valueOf = Integer.valueOf(this.f4331a.intValue() + 1);
        this.f4331a = valueOf;
        return Integer.toHexString(valueOf.intValue());
    }

    private class c extends Thread {
        private final LinkedBlockingQueue a;

        private c() {
            super("Mikrotik API Reader");
            this.a = new LinkedBlockingQueue(40);
        }

        /* access modifiers changed from: private */
        public String e() {
            try {
                Object val = this.a.take();
                if (val instanceof k3) {
                    throw ((k3) val);
                } else if (!(val instanceof c)) {
                    return (String) val;
                } else {
                    throw ((c) val);
                }
            } catch (InterruptedException ex) {
                throw new k3("Interrupted while reading data from queue.", ex);
            }
        }

        /* access modifiers changed from: private */
        public boolean c() {
            return this.a.isEmpty();
        }

        public void run() {
            while (b.this.f4336a) {
                try {
                    d(n.a(b.this.f4329a));
                } catch (c ex) {
                    d(ex);
                } catch (k3 ex2) {
                    if (b.this.f4336a || !b.this.f4332a.isClosed()) {
                        d(ex2);
                    }
                }
            }
        }

        private void d(Object data) {
            try {
                this.a.put(data);
            } catch (InterruptedException e) {
            }
        }
    }

    /* renamed from: me.legrange.mikrotik.impl.b$b  reason: collision with other inner class name */
    private class C0055b extends Thread {
        private String a;

        /* renamed from: a  reason: collision with other field name */
        private final List<String> f4337a;

        private C0055b() {
            super("Mikrotik API Result Processor");
            this.f4337a = new LinkedList();
        }

        public void run() {
            j res;
            while (b.this.f4336a) {
                try {
                    res = d();
                } catch (a ex) {
                    String tag = ex.a();
                    if (tag != null) {
                        res = new f(tag, ex.getMessage());
                    }
                } catch (s10 e) {
                }
                try {
                    ue0 l = (ue0) b.this.f4333a.get(res.a());
                    if (l != null) {
                        if (res instanceof k) {
                            l.c((k) res);
                        } else if (res instanceof e) {
                            if (l instanceof d) {
                                ((d) l).e((e) res);
                            } else {
                                l.a();
                            }
                            b.this.f4333a.remove(res.a());
                        } else if (res instanceof f) {
                            l.b(new a((f) res));
                        }
                    }
                } catch (Exception e2) {
                }
            }
        }

        private void b() {
            if (this.f4337a.isEmpty()) {
                this.f4337a.addAll(Arrays.asList(b.this.f4335a.e().split("\n")));
            }
            this.a = this.f4337a.remove(0);
        }

        private boolean a() {
            return !this.f4337a.isEmpty() || !b.this.f4335a.c();
        }

        private String c() {
            if (this.f4337a.isEmpty()) {
                this.f4337a.addAll(Arrays.asList(b.this.f4335a.e().split("\n")));
            }
            return this.f4337a.get(0);
        }

        private j d() {
            if (this.a == null) {
                b();
            }
            String str = this.a;
            char c = 65535;
            switch (str.hashCode()) {
                case 0:
                    if (str.equals("")) {
                        c = 4;
                        break;
                    }
                    break;
                case 35348:
                    if (str.equals("!re")) {
                        c = 0;
                        break;
                    }
                    break;
                case 33565475:
                    if (str.equals("!done")) {
                        c = 1;
                        break;
                    }
                    break;
                case 33671138:
                    if (str.equals("!halt")) {
                        c = 3;
                        break;
                    }
                    break;
                case 34044622:
                    if (str.equals("!trap")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return g();
                case 1:
                    return e();
                case 2:
                    return f();
                case 3:
                    return f();
                default:
                    throw new c(String.format("Unexpected line '%s'", new Object[]{this.a}));
            }
        }

        private k g() {
            b();
            int l = 0;
            k res = new k();
            while (true) {
                if (this.a.startsWith("!")) {
                    break;
                }
                l++;
                if (this.a.startsWith("=")) {
                    String[] parts = this.a.split("=", 3);
                    if (parts.length != 3) {
                        throw new c(String.format("Malformed line '%s'", new Object[]{this.a}));
                    } else if (!parts[2].endsWith("\r")) {
                        res.put(parts[1], h(parts[2]));
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(parts[2]);
                        while (!this.f4337a.isEmpty()) {
                            b();
                            sb.append(this.a);
                        }
                        res.put(parts[1], sb.toString());
                    }
                } else if (this.a.startsWith(".tag=")) {
                    String[] parts2 = this.a.split("=", 2);
                    if (parts2.length == 2) {
                        res.b(parts2[1]);
                    }
                } else {
                    throw new c(String.format("Unexpected line '%s'", new Object[]{this.a}));
                }
                if (!a()) {
                    this.a = null;
                    break;
                }
                b();
            }
            return res;
        }

        private String h(String first) {
            StringBuilder buf = new StringBuilder(first);
            this.a = null;
            while (a()) {
                String peek = c();
                if (peek.startsWith("!") || peek.startsWith("=") || peek.startsWith(".tag=")) {
                    break;
                }
                b();
                buf.append("\n");
                buf.append(this.a);
            }
            return buf.toString();
        }

        private e e() {
            e done = new e((String) null);
            if (a()) {
                b();
                while (true) {
                    if (!this.a.startsWith("!")) {
                        if (this.a.startsWith(".tag=")) {
                            String[] parts = this.a.split("=", 2);
                            if (parts.length == 2) {
                                done.b(parts[1]);
                            }
                        } else if (this.a.startsWith("=ret")) {
                            String[] parts2 = this.a.split("=", 3);
                            if (parts2.length == 3) {
                                done.d(parts2[2]);
                            } else {
                                throw new c(String.format("Malformed line '%s'", new Object[]{this.a}));
                            }
                        }
                        if (!a()) {
                            this.a = null;
                            break;
                        }
                        b();
                    } else {
                        break;
                    }
                }
            }
            return done;
        }

        private f f() {
            b();
            f err = new f();
            if (a()) {
                while (true) {
                    if (!this.a.startsWith("!")) {
                        if (this.a.startsWith(".tag=")) {
                            String[] parts = this.a.split("=", 2);
                            if (parts.length == 2) {
                                err.b(parts[1]);
                            }
                        } else if (this.a.startsWith("=message=")) {
                            err.d(this.a.split("=", 3)[2]);
                        }
                        if (!a()) {
                            this.a = null;
                            break;
                        }
                        b();
                    } else {
                        break;
                    }
                }
            }
            return err;
        }
    }

    private static class d implements ue0 {
        private final List<Map<String, String>> a;

        /* renamed from: a  reason: collision with other field name */
        private s10 f4340a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f4341a;

        private d() {
            this.a = new LinkedList();
            this.f4341a = false;
        }

        public synchronized void b(s10 ex) {
            this.f4340a = ex;
            notifyAll();
        }

        public synchronized void a() {
            this.f4341a = true;
            notifyAll();
        }

        /* access modifiers changed from: package-private */
        public synchronized void e(e done) {
            if (done.c() != null) {
                k res = new k();
                res.put("ret", done.c());
                this.a.add(res);
            }
            this.f4341a = true;
            notifyAll();
        }

        public void c(Map<String, String> result) {
            this.a.add(result);
        }

        /* access modifiers changed from: private */
        public List<Map<String, String>> f(int timeout) {
            try {
                synchronized (this) {
                    int waitTime = timeout;
                    while (!this.f4341a && waitTime > 0) {
                        long start = System.currentTimeMillis();
                        wait((long) waitTime);
                        waitTime -= (int) (System.currentTimeMillis() - start);
                        if (waitTime <= 0 && !this.f4341a) {
                            this.f4340a = new k3(String.format("Command timed out after %d ms", new Object[]{Integer.valueOf(timeout)}));
                        }
                    }
                }
                if (this.f4340a == null) {
                    return this.a;
                }
                throw new s10(this.f4340a.getMessage(), this.f4340a);
            } catch (InterruptedException ex) {
                throw new k3(ex.getMessage(), ex);
            }
        }
    }
}
