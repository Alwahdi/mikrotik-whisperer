package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: l40  reason: default package */
public abstract class l40 {
    static final Logger a = Logger.getLogger(l40.class.getName());

    public static t6 b(jm0 source) {
        return new md0(source);
    }

    public static s6 a(fm0 sink) {
        return new ld0(sink);
    }

    private static fm0 d(OutputStream out, or0 timeout) {
        if (out == null) {
            throw new IllegalArgumentException("out == null");
        } else if (timeout != null) {
            return new a(timeout, out);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    /* renamed from: l40$a */
    class a implements fm0 {
        final /* synthetic */ OutputStream a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ or0 f4195a;

        a(or0 or0, OutputStream outputStream) {
            this.f4195a = or0;
            this.a = outputStream;
        }

        public void G(r6 source, long byteCount) {
            su0.b(source.f4882a, 0, byteCount);
            while (byteCount > 0) {
                this.f4195a.c();
                vj0 head = source.f4883a;
                int toCopy = (int) Math.min(byteCount, (long) (head.b - head.a));
                this.a.write(head.f5389a, head.a, toCopy);
                int i = head.a + toCopy;
                head.a = i;
                byteCount -= (long) toCopy;
                source.f4882a -= (long) toCopy;
                if (i == head.b) {
                    source.f4883a = head.b();
                    wj0.a(head);
                }
            }
        }

        public void flush() {
            this.a.flush();
        }

        public void close() {
            this.a.close();
        }

        public String toString() {
            return "sink(" + this.a + ")";
        }
    }

    public static fm0 e(Socket socket) {
        if (socket != null) {
            q4 timeout = h(socket);
            return timeout.n(d(socket.getOutputStream(), timeout));
        }
        throw new IllegalArgumentException("socket == null");
    }

    private static jm0 f(InputStream in, or0 timeout) {
        if (in == null) {
            throw new IllegalArgumentException("in == null");
        } else if (timeout != null) {
            return new b(timeout, in);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    /* renamed from: l40$b */
    class b implements jm0 {
        final /* synthetic */ InputStream a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ or0 f4196a;

        b(or0 or0, InputStream inputStream) {
            this.f4196a = or0;
            this.a = inputStream;
        }

        public long T(r6 sink, long byteCount) {
            if (byteCount < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + byteCount);
            } else if (byteCount == 0) {
                return 0;
            } else {
                try {
                    this.f4196a.c();
                    vj0 tail = sink.j0(1);
                    int bytesRead = this.a.read(tail.f5389a, tail.b, (int) Math.min(byteCount, (long) (8192 - tail.b)));
                    if (bytesRead == -1) {
                        return -1;
                    }
                    tail.b += bytesRead;
                    sink.f4882a += (long) bytesRead;
                    return (long) bytesRead;
                } catch (AssertionError e) {
                    if (l40.c(e)) {
                        throw new IOException(e);
                    }
                    throw e;
                }
            }
        }

        public void close() {
            this.a.close();
        }

        public String toString() {
            return "source(" + this.a + ")";
        }
    }

    public static jm0 g(Socket socket) {
        if (socket != null) {
            q4 timeout = h(socket);
            return timeout.o(f(socket.getInputStream(), timeout));
        }
        throw new IllegalArgumentException("socket == null");
    }

    /* renamed from: l40$c */
    class c extends q4 {
        final /* synthetic */ Socket a;

        c(Socket socket) {
            this.a = socket;
        }

        /* access modifiers changed from: protected */
        public IOException k(IOException cause) {
            InterruptedIOException ioe = new SocketTimeoutException("timeout");
            if (cause != null) {
                ioe.initCause(cause);
            }
            return ioe;
        }

        /* access modifiers changed from: protected */
        public void p() {
            try {
                this.a.close();
            } catch (Exception e) {
                Logger logger = l40.a;
                Level level = Level.WARNING;
                logger.log(level, "Failed to close timed out socket " + this.a, e);
            } catch (AssertionError e2) {
                if (l40.c(e2)) {
                    Logger logger2 = l40.a;
                    Level level2 = Level.WARNING;
                    logger2.log(level2, "Failed to close timed out socket " + this.a, e2);
                    return;
                }
                throw e2;
            }
        }
    }

    private static q4 h(Socket socket) {
        return new c(socket);
    }

    static boolean c(AssertionError e) {
        return (e.getCause() == null || e.getMessage() == null || !e.getMessage().contains("getsockname failed")) ? false : true;
    }
}
