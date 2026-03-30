package io.grpc.okhttp;

import io.grpc.okhttp.h;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class b implements qn {
    private static final Logger a = Logger.getLogger(g.class.getName());

    /* renamed from: a  reason: collision with other field name */
    private final a f3825a;

    /* renamed from: a  reason: collision with other field name */
    private final h f3826a;

    /* renamed from: a  reason: collision with other field name */
    private final qn f3827a;

    interface a {
        void a(Throwable th);
    }

    b(a transportExceptionHandler, qn frameWriter) {
        this(transportExceptionHandler, frameWriter, new h(Level.FINE, (Class<?>) g.class));
    }

    b(a transportExceptionHandler, qn frameWriter, h frameLogger) {
        this.f3825a = (a) v90.o(transportExceptionHandler, "transportExceptionHandler");
        this.f3827a = (qn) v90.o(frameWriter, "frameWriter");
        this.f3826a = (h) v90.o(frameLogger, "frameLogger");
    }

    public void B() {
        try {
            this.f3827a.B();
        } catch (IOException e) {
            this.f3825a.a(e);
        }
    }

    public void g(el0 peerSettings) {
        this.f3826a.j(h.a.OUTBOUND);
        try {
            this.f3827a.g(peerSettings);
        } catch (IOException e) {
            this.f3825a.a(e);
        }
    }

    public void flush() {
        try {
            this.f3827a.flush();
        } catch (IOException e) {
            this.f3825a.a(e);
        }
    }

    public void i(boolean outFinished, boolean inFinished, int streamId, int associatedStreamId, List<pq> headerBlock) {
        try {
            this.f3827a.i(outFinished, inFinished, streamId, associatedStreamId, headerBlock);
        } catch (IOException e) {
            this.f3825a.a(e);
        }
    }

    public void d(int streamId, io.grpc.okhttp.internal.framed.a errorCode) {
        this.f3826a.h(h.a.OUTBOUND, streamId, errorCode);
        try {
            this.f3827a.d(streamId, errorCode);
        } catch (IOException e) {
            this.f3825a.a(e);
        }
    }

    public int t() {
        return this.f3827a.t();
    }

    public void E(boolean outFinished, int streamId, r6 source, int byteCount) {
        this.f3826a.b(h.a.OUTBOUND, streamId, source.O(), byteCount, outFinished);
        try {
            this.f3827a.E(outFinished, streamId, source, byteCount);
        } catch (IOException e) {
            this.f3825a.a(e);
        }
    }

    public void k(el0 okHttpSettings) {
        this.f3826a.i(h.a.OUTBOUND, okHttpSettings);
        try {
            this.f3827a.k(okHttpSettings);
        } catch (IOException e) {
            this.f3825a.a(e);
        }
    }

    public void e(boolean ack, int payload1, int payload2) {
        if (ack) {
            this.f3826a.f(h.a.OUTBOUND, (4294967295L & ((long) payload2)) | (((long) payload1) << 32));
        } else {
            this.f3826a.e(h.a.OUTBOUND, (4294967295L & ((long) payload2)) | (((long) payload1) << 32));
        }
        try {
            this.f3827a.e(ack, payload1, payload2);
        } catch (IOException e) {
            this.f3825a.a(e);
        }
    }

    public void h(int lastGoodStreamId, io.grpc.okhttp.internal.framed.a errorCode, byte[] debugData) {
        this.f3826a.c(h.a.OUTBOUND, lastGoodStreamId, errorCode, a7.i(debugData));
        try {
            this.f3827a.h(lastGoodStreamId, errorCode, debugData);
            this.f3827a.flush();
        } catch (IOException e) {
            this.f3825a.a(e);
        }
    }

    public void a(int streamId, long windowSizeIncrement) {
        this.f3826a.k(h.a.OUTBOUND, streamId, windowSizeIncrement);
        try {
            this.f3827a.a(streamId, windowSizeIncrement);
        } catch (IOException e) {
            this.f3825a.a(e);
        }
    }

    public void close() {
        try {
            this.f3827a.close();
        } catch (IOException e) {
            a.log(c(e), "Failed closing connection", e);
        }
    }

    static Level c(Throwable t) {
        if (t.getClass().equals(IOException.class)) {
            return Level.FINE;
        }
        return Level.INFO;
    }
}
