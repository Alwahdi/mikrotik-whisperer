package io.grpc.okhttp;

import io.grpc.okhttp.OkHttpFrameLogger;
import java.util.EnumMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class h {
    private final Level a;

    /* renamed from: a  reason: collision with other field name */
    private final Logger f3917a;

    enum a {
        INBOUND,
        OUTBOUND
    }

    h(Level level, Class<?> clazz) {
        this(level, Logger.getLogger(clazz.getName()));
    }

    h(Level level, Logger logger) {
        this.a = (Level) v90.o(level, "level");
        this.f3917a = (Logger) v90.o(logger, "logger");
    }

    private static String m(el0 settings) {
        EnumMap<OkHttpFrameLogger.SettingParams, Integer> map = new EnumMap<>(b.class);
        for (b p : b.values()) {
            if (settings.d(p.getBit())) {
                map.put(p, Integer.valueOf(settings.a(p.getBit())));
            }
        }
        return map.toString();
    }

    private static String l(r6 buf) {
        if (buf.g0() <= 64) {
            return buf.h0().h();
        }
        int length = (int) Math.min(buf.g0(), 64);
        return buf.i0(length).h() + "...";
    }

    private boolean a() {
        return this.f3917a.isLoggable(this.a);
    }

    /* access modifiers changed from: package-private */
    public void b(a direction, int streamId, r6 data, int length, boolean endStream) {
        if (a()) {
            Logger logger = this.f3917a;
            Level level = this.a;
            logger.log(level, direction + " DATA: streamId=" + streamId + " endStream=" + endStream + " length=" + length + " bytes=" + l(data));
        }
    }

    /* access modifiers changed from: package-private */
    public void d(a direction, int streamId, List<pq> headers, boolean endStream) {
        if (a()) {
            Logger logger = this.f3917a;
            Level level = this.a;
            logger.log(level, direction + " HEADERS: streamId=" + streamId + " headers=" + headers + " endStream=" + endStream);
        }
    }

    /* access modifiers changed from: package-private */
    public void h(a direction, int streamId, io.grpc.okhttp.internal.framed.a errorCode) {
        if (a()) {
            Logger logger = this.f3917a;
            Level level = this.a;
            logger.log(level, direction + " RST_STREAM: streamId=" + streamId + " errorCode=" + errorCode);
        }
    }

    /* access modifiers changed from: package-private */
    public void j(a direction) {
        if (a()) {
            Logger logger = this.f3917a;
            Level level = this.a;
            logger.log(level, direction + " SETTINGS: ack=true");
        }
    }

    /* access modifiers changed from: package-private */
    public void i(a direction, el0 settings) {
        if (a()) {
            Logger logger = this.f3917a;
            Level level = this.a;
            logger.log(level, direction + " SETTINGS: ack=false settings=" + m(settings));
        }
    }

    /* access modifiers changed from: package-private */
    public void e(a direction, long data) {
        if (a()) {
            Logger logger = this.f3917a;
            Level level = this.a;
            logger.log(level, direction + " PING: ack=false bytes=" + data);
        }
    }

    /* access modifiers changed from: package-private */
    public void f(a direction, long data) {
        if (a()) {
            Logger logger = this.f3917a;
            Level level = this.a;
            logger.log(level, direction + " PING: ack=true bytes=" + data);
        }
    }

    /* access modifiers changed from: package-private */
    public void g(a direction, int streamId, int promisedStreamId, List<pq> headers) {
        if (a()) {
            Logger logger = this.f3917a;
            Level level = this.a;
            logger.log(level, direction + " PUSH_PROMISE: streamId=" + streamId + " promisedStreamId=" + promisedStreamId + " headers=" + headers);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(a direction, int lastStreamId, io.grpc.okhttp.internal.framed.a errorCode, a7 debugData) {
        if (a()) {
            Logger logger = this.f3917a;
            Level level = this.a;
            logger.log(level, direction + " GO_AWAY: lastStreamId=" + lastStreamId + " errorCode=" + errorCode + " length=" + debugData.l() + " bytes=" + l(new r6().k0(debugData)));
        }
    }

    /* access modifiers changed from: package-private */
    public void k(a direction, int streamId, long windowSizeIncrement) {
        if (a()) {
            Logger logger = this.f3917a;
            Level level = this.a;
            logger.log(level, direction + " WINDOW_UPDATE: streamId=" + streamId + " windowSizeIncrement=" + windowSizeIncrement);
        }
    }

    private enum b {
        HEADER_TABLE_SIZE(1),
        ENABLE_PUSH(2),
        MAX_CONCURRENT_STREAMS(4),
        MAX_FRAME_SIZE(5),
        MAX_HEADER_LIST_SIZE(6),
        INITIAL_WINDOW_SIZE(7);
        
        private final int bit;

        private b(int bit2) {
            this.bit = bit2;
        }

        public int getBit() {
            return this.bit;
        }
    }
}
