package defpackage;

import defpackage.pn;
import defpackage.vq;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: wq  reason: default package */
public final class wq implements wu0 {
    /* access modifiers changed from: private */
    public static final a7 a = a7.d("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public static final Logger f5532a = Logger.getLogger(b.class.getName());

    public pn b(t6 source, boolean client) {
        return new c(source, 4096, client);
    }

    public qn a(s6 sink, boolean client) {
        return new d(sink, client);
    }

    /* renamed from: wq$c */
    static final class c implements pn {
        private final t6 a;

        /* renamed from: a  reason: collision with other field name */
        final vq.a f5536a;

        /* renamed from: a  reason: collision with other field name */
        private final a f5537a;

        /* renamed from: a  reason: collision with other field name */
        private final boolean f5538a;

        c(t6 source, int headerTableSize, boolean client) {
            this.a = source;
            this.f5538a = client;
            a aVar = new a(source);
            this.f5537a = aVar;
            this.f5536a = new vq.a(headerTableSize, aVar);
        }

        public boolean W(pn.a handler) {
            try {
                this.a.y(9);
                int length = wq.m(this.a);
                if (length < 0 || length > 16384) {
                    throw wq.k("FRAME_SIZE_ERROR: %s", Integer.valueOf(length));
                }
                byte type = (byte) (this.a.readByte() & 255);
                byte flags = (byte) (this.a.readByte() & 255);
                int streamId = this.a.readInt() & Integer.MAX_VALUE;
                if (wq.f5532a.isLoggable(Level.FINE)) {
                    wq.f5532a.fine(b.b(true, streamId, length, type, flags));
                }
                switch (type) {
                    case 0:
                        c(handler, length, flags, streamId);
                        break;
                    case 1:
                        q(handler, length, flags, streamId);
                        break;
                    case 2:
                        J(handler, length, flags, streamId);
                        break;
                    case 3:
                        P(handler, length, flags, streamId);
                        break;
                    case 4:
                        U(handler, length, flags, streamId);
                        break;
                    case 5:
                        K(handler, length, flags, streamId);
                        break;
                    case 6:
                        w(handler, length, flags, streamId);
                        break;
                    case 7:
                        f(handler, length, flags, streamId);
                        break;
                    case 8:
                        V(handler, length, flags, streamId);
                        break;
                    default:
                        this.a.Q((long) length);
                        break;
                }
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        private void q(pn.a handler, int length, byte flags, int streamId) {
            short padding = 0;
            if (streamId != 0) {
                boolean endStream = (flags & 1) != 0;
                if ((flags & 8) != 0) {
                    padding = (short) (this.a.readByte() & 255);
                }
                if ((flags & 32) != 0) {
                    C(handler, streamId);
                    length -= 5;
                }
                handler.g(false, endStream, streamId, -1, o(wq.l(length, flags, padding), padding, flags, streamId), io.grpc.okhttp.internal.framed.b.HTTP_20_HEADERS);
                return;
            }
            throw wq.k("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }

        private List<pq> o(int length, short padding, byte flags, int streamId) {
            a aVar = this.f5537a;
            aVar.c = length;
            aVar.f5533a = length;
            aVar.f5535a = padding;
            aVar.a = flags;
            aVar.b = streamId;
            this.f5536a.l();
            return this.f5536a.e();
        }

        private void c(pn.a handler, int length, byte flags, int streamId) {
            boolean gzipped = true;
            short padding = 0;
            boolean inFinished = (flags & 1) != 0;
            if ((flags & 32) == 0) {
                gzipped = false;
            }
            if (!gzipped) {
                if ((flags & 8) != 0) {
                    padding = (short) (this.a.readByte() & 255);
                }
                handler.l(inFinished, streamId, this.a, wq.l(length, flags, padding));
                this.a.Q((long) padding);
                return;
            }
            throw wq.k("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }

        private void J(pn.a handler, int length, byte flags, int streamId) {
            if (length != 5) {
                throw wq.k("TYPE_PRIORITY length: %d != 5", Integer.valueOf(length));
            } else if (streamId != 0) {
                C(handler, streamId);
            } else {
                throw wq.k("TYPE_PRIORITY streamId == 0", new Object[0]);
            }
        }

        private void C(pn.a handler, int streamId) {
            int w1 = this.a.readInt();
            handler.j(streamId, Integer.MAX_VALUE & w1, (this.a.readByte() & 255) + 1, (Integer.MIN_VALUE & w1) != 0);
        }

        private void P(pn.a handler, int length, byte flags, int streamId) {
            if (length != 4) {
                throw wq.k("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(length));
            } else if (streamId != 0) {
                int errorCodeInt = this.a.readInt();
                io.grpc.okhttp.internal.framed.a errorCode = io.grpc.okhttp.internal.framed.a.fromHttp2(errorCodeInt);
                if (errorCode != null) {
                    handler.d(streamId, errorCode);
                } else {
                    throw wq.k("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(errorCodeInt));
                }
            } else {
                throw wq.k("TYPE_RST_STREAM streamId == 0", new Object[0]);
            }
        }

        private void U(pn.a handler, int length, byte flags, int streamId) {
            if (streamId != 0) {
                throw wq.k("TYPE_SETTINGS streamId != 0", new Object[0]);
            } else if ((flags & 1) != 0) {
                if (length == 0) {
                    handler.k();
                    return;
                }
                throw wq.k("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            } else if (length % 6 == 0) {
                el0 settings = new el0();
                for (int i = 0; i < length; i += 6) {
                    short id = this.a.readShort();
                    int value = this.a.readInt();
                    switch (id) {
                        case 1:
                        case 6:
                            break;
                        case 2:
                            if (!(value == 0 || value == 1)) {
                                throw wq.k("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                            }
                        case 3:
                            id = 4;
                            break;
                        case 4:
                            id = 7;
                            if (value < 0) {
                                throw wq.k("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            }
                            break;
                        case 5:
                            if (value < 16384 || value > 16777215) {
                                throw wq.k("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(value));
                            }
                    }
                    settings.e(id, 0, value);
                }
                handler.i(false, settings);
                if (settings.b() >= 0) {
                    this.f5536a.g(settings.b());
                }
            } else {
                throw wq.k("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(length));
            }
        }

        private void K(pn.a handler, int length, byte flags, int streamId) {
            short padding = 0;
            if (streamId != 0) {
                if ((flags & 8) != 0) {
                    padding = (short) (this.a.readByte() & 255);
                }
                handler.f(streamId, this.a.readInt() & Integer.MAX_VALUE, o(wq.l(length - 4, flags, padding), padding, flags, streamId));
                return;
            }
            throw wq.k("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }

        private void w(pn.a handler, int length, byte flags, int streamId) {
            boolean ack = false;
            if (length != 8) {
                throw wq.k("TYPE_PING length != 8: %s", Integer.valueOf(length));
            } else if (streamId == 0) {
                int payload1 = this.a.readInt();
                int payload2 = this.a.readInt();
                if ((flags & 1) != 0) {
                    ack = true;
                }
                handler.e(ack, payload1, payload2);
            } else {
                throw wq.k("TYPE_PING streamId != 0", new Object[0]);
            }
        }

        private void f(pn.a handler, int length, byte flags, int streamId) {
            if (length < 8) {
                throw wq.k("TYPE_GOAWAY length < 8: %s", Integer.valueOf(length));
            } else if (streamId == 0) {
                int lastStreamId = this.a.readInt();
                int errorCodeInt = this.a.readInt();
                int opaqueDataLength = length - 8;
                io.grpc.okhttp.internal.framed.a errorCode = io.grpc.okhttp.internal.framed.a.fromHttp2(errorCodeInt);
                if (errorCode != null) {
                    a7 debugData = a7.a;
                    if (opaqueDataLength > 0) {
                        debugData = this.a.n((long) opaqueDataLength);
                    }
                    handler.h(lastStreamId, errorCode, debugData);
                    return;
                }
                throw wq.k("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(errorCodeInt));
            } else {
                throw wq.k("TYPE_GOAWAY streamId != 0", new Object[0]);
            }
        }

        private void V(pn.a handler, int length, byte flags, int streamId) {
            if (length == 4) {
                long increment = ((long) this.a.readInt()) & 2147483647L;
                if (increment != 0) {
                    handler.a(streamId, increment);
                    return;
                }
                throw wq.k("windowSizeIncrement was 0", new Object[0]);
            }
            throw wq.k("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(length));
        }

        public void close() {
            this.a.close();
        }
    }

    /* renamed from: wq$d */
    static final class d implements qn {
        private int a = 16384;

        /* renamed from: a  reason: collision with other field name */
        private final r6 f5539a;

        /* renamed from: a  reason: collision with other field name */
        private final s6 f5540a;

        /* renamed from: a  reason: collision with other field name */
        private final vq.b f5541a;

        /* renamed from: a  reason: collision with other field name */
        private final boolean f5542a;
        private boolean b;

        d(s6 sink, boolean client) {
            this.f5540a = sink;
            this.f5542a = client;
            r6 r6Var = new r6();
            this.f5539a = r6Var;
            this.f5541a = new vq.b(r6Var);
        }

        public synchronized void flush() {
            if (!this.b) {
                this.f5540a.flush();
            } else {
                throw new IOException("closed");
            }
        }

        public synchronized void g(el0 peerSettings) {
            if (!this.b) {
                this.a = peerSettings.c(this.a);
                f(0, 0, (byte) 4, (byte) 1);
                this.f5540a.flush();
            } else {
                throw new IOException("closed");
            }
        }

        public synchronized void B() {
            if (this.b) {
                throw new IOException("closed");
            } else if (this.f5542a) {
                if (wq.f5532a.isLoggable(Level.FINE)) {
                    wq.f5532a.fine(String.format(">> CONNECTION %s", new Object[]{wq.a.h()}));
                }
                this.f5540a.D(wq.a.r());
                this.f5540a.flush();
            }
        }

        public synchronized void i(boolean outFinished, boolean inFinished, int streamId, int associatedStreamId, List<pq> headerBlock) {
            if (!inFinished) {
                try {
                    if (!this.b) {
                        o(outFinished, streamId, headerBlock);
                    } else {
                        throw new IOException("closed");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                throw new UnsupportedOperationException();
            }
        }

        /* access modifiers changed from: package-private */
        public void o(boolean outFinished, int streamId, List<pq> headerBlock) {
            if (!this.b) {
                this.f5541a.e(headerBlock);
                long byteCount = this.f5539a.g0();
                int length = (int) Math.min((long) this.a, byteCount);
                byte flags = byteCount == ((long) length) ? (byte) 4 : 0;
                if (outFinished) {
                    flags = (byte) (flags | 1);
                }
                f(streamId, length, (byte) 1, flags);
                this.f5540a.G(this.f5539a, (long) length);
                if (byteCount > ((long) length)) {
                    q(streamId, byteCount - ((long) length));
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }

        private void q(int streamId, long byteCount) {
            while (byteCount > 0) {
                int length = (int) Math.min((long) this.a, byteCount);
                byteCount -= (long) length;
                f(streamId, length, (byte) 9, byteCount == 0 ? (byte) 4 : 0);
                this.f5540a.G(this.f5539a, (long) length);
            }
        }

        public synchronized void d(int streamId, io.grpc.okhttp.internal.framed.a errorCode) {
            if (this.b) {
                throw new IOException("closed");
            } else if (errorCode.httpCode != -1) {
                f(streamId, 4, (byte) 3, (byte) 0);
                this.f5540a.x(errorCode.httpCode);
                this.f5540a.flush();
            } else {
                throw new IllegalArgumentException();
            }
        }

        public int t() {
            return this.a;
        }

        public synchronized void E(boolean outFinished, int streamId, r6 source, int byteCount) {
            if (!this.b) {
                byte flags = 0;
                if (outFinished) {
                    flags = (byte) (0 | 1);
                }
                c(streamId, flags, source, byteCount);
            } else {
                throw new IOException("closed");
            }
        }

        /* access modifiers changed from: package-private */
        public void c(int streamId, byte flags, r6 buffer, int byteCount) {
            f(streamId, byteCount, (byte) 0, flags);
            if (byteCount > 0) {
                this.f5540a.G(buffer, (long) byteCount);
            }
        }

        public synchronized void k(el0 settings) {
            if (!this.b) {
                f(0, settings.f() * 6, (byte) 4, (byte) 0);
                for (int i = 0; i < 10; i++) {
                    if (settings.d(i)) {
                        int id = i;
                        if (id == 4) {
                            id = 3;
                        } else if (id == 7) {
                            id = 4;
                        }
                        this.f5540a.A(id);
                        this.f5540a.x(settings.a(i));
                    }
                }
                this.f5540a.flush();
            } else {
                throw new IOException("closed");
            }
        }

        public synchronized void e(boolean ack, int payload1, int payload2) {
            if (!this.b) {
                f(0, 8, (byte) 6, ack ? (byte) 1 : 0);
                this.f5540a.x(payload1);
                this.f5540a.x(payload2);
                this.f5540a.flush();
            } else {
                throw new IOException("closed");
            }
        }

        public synchronized void h(int lastGoodStreamId, io.grpc.okhttp.internal.framed.a errorCode, byte[] debugData) {
            if (this.b) {
                throw new IOException("closed");
            } else if (errorCode.httpCode != -1) {
                f(0, debugData.length + 8, (byte) 7, (byte) 0);
                this.f5540a.x(lastGoodStreamId);
                this.f5540a.x(errorCode.httpCode);
                if (debugData.length > 0) {
                    this.f5540a.D(debugData);
                }
                this.f5540a.flush();
            } else {
                throw wq.j("errorCode.httpCode == -1", new Object[0]);
            }
        }

        public synchronized void a(int streamId, long windowSizeIncrement) {
            if (this.b) {
                throw new IOException("closed");
            } else if (windowSizeIncrement == 0 || windowSizeIncrement > 2147483647L) {
                throw wq.j("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(windowSizeIncrement));
            } else {
                f(streamId, 4, (byte) 8, (byte) 0);
                this.f5540a.x((int) windowSizeIncrement);
                this.f5540a.flush();
            }
        }

        public synchronized void close() {
            this.b = true;
            this.f5540a.close();
        }

        /* access modifiers changed from: package-private */
        public void f(int streamId, int length, byte type, byte flags) {
            if (wq.f5532a.isLoggable(Level.FINE)) {
                wq.f5532a.fine(b.b(false, streamId, length, type, flags));
            }
            int i = this.a;
            if (length > i) {
                throw wq.j("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i), Integer.valueOf(length));
            } else if ((Integer.MIN_VALUE & streamId) == 0) {
                wq.n(this.f5540a, length);
                this.f5540a.I(type & 255);
                this.f5540a.I(flags & 255);
                this.f5540a.x(Integer.MAX_VALUE & streamId);
            } else {
                throw wq.j("reserved bit set: %s", Integer.valueOf(streamId));
            }
        }
    }

    /* access modifiers changed from: private */
    public static IllegalArgumentException j(String message, Object... args) {
        throw new IllegalArgumentException(String.format(message, args));
    }

    /* access modifiers changed from: private */
    public static IOException k(String message, Object... args) {
        throw new IOException(String.format(message, args));
    }

    /* renamed from: wq$a */
    static final class a implements jm0 {
        byte a;

        /* renamed from: a  reason: collision with other field name */
        int f5533a;

        /* renamed from: a  reason: collision with other field name */
        private final t6 f5534a;

        /* renamed from: a  reason: collision with other field name */
        short f5535a;
        int b;
        int c;

        public a(t6 source) {
            this.f5534a = source;
        }

        public long T(r6 sink, long byteCount) {
            while (true) {
                int i = this.c;
                if (i == 0) {
                    this.f5534a.Q((long) this.f5535a);
                    this.f5535a = 0;
                    if ((this.a & 4) != 0) {
                        return -1;
                    }
                    c();
                } else {
                    long read = this.f5534a.T(sink, Math.min(byteCount, (long) i));
                    if (read == -1) {
                        return -1;
                    }
                    this.c -= (int) read;
                    return read;
                }
            }
        }

        public void close() {
        }

        private void c() {
            int previousStreamId = this.b;
            int f = wq.m(this.f5534a);
            this.c = f;
            this.f5533a = f;
            byte type = (byte) (this.f5534a.readByte() & 255);
            this.a = (byte) (this.f5534a.readByte() & 255);
            if (wq.f5532a.isLoggable(Level.FINE)) {
                wq.f5532a.fine(b.b(true, this.b, this.f5533a, type, this.a));
            }
            int readInt = this.f5534a.readInt() & Integer.MAX_VALUE;
            this.b = readInt;
            if (type != 9) {
                throw wq.k("%s != TYPE_CONTINUATION", Byte.valueOf(type));
            } else if (readInt != previousStreamId) {
                throw wq.k("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    /* access modifiers changed from: private */
    public static int l(int length, byte flags, short padding) {
        if ((flags & 8) != 0) {
            length--;
        }
        if (padding <= length) {
            return (short) (length - padding);
        }
        throw k("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(padding), Integer.valueOf(length));
    }

    /* renamed from: wq$b */
    static final class b {
        private static final String[] a = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        private static final String[] b = new String[64];
        private static final String[] c = new String[256];

        static String b(boolean inbound, int streamId, int length, byte type, byte flags) {
            String[] strArr = a;
            String formattedType = type < strArr.length ? strArr[type] : String.format("0x%02x", new Object[]{Byte.valueOf(type)});
            String formattedFlags = a(type, flags);
            Object[] objArr = new Object[5];
            objArr[0] = inbound ? "<<" : ">>";
            objArr[1] = Integer.valueOf(streamId);
            objArr[2] = Integer.valueOf(length);
            objArr[3] = formattedType;
            objArr[4] = formattedFlags;
            return String.format("%s 0x%08x %5d %-13s %s", objArr);
        }

        static String a(byte type, byte flags) {
            String result;
            if (flags == 0) {
                return "";
            }
            switch (type) {
                case 2:
                case 3:
                case 7:
                case 8:
                    return c[flags];
                case 4:
                case 6:
                    return flags == 1 ? "ACK" : c[flags];
                default:
                    String[] strArr = b;
                    if (flags < strArr.length) {
                        result = strArr[flags];
                    } else {
                        result = c[flags];
                    }
                    if (type == 5 && (flags & 4) != 0) {
                        return result.replace("HEADERS", "PUSH_PROMISE");
                    }
                    if (type != 0 || (flags & 32) == 0) {
                        return result;
                    }
                    return result.replace("PRIORITY", "COMPRESSED");
            }
        }

        static {
            int i = 0;
            while (true) {
                String[] strArr = c;
                if (i >= strArr.length) {
                    break;
                }
                strArr[i] = String.format("%8s", new Object[]{Integer.toBinaryString(i)}).replace(' ', '0');
                i++;
            }
            String[] strArr2 = b;
            strArr2[0] = "";
            strArr2[1] = "END_STREAM";
            int[] prefixFlags = {1};
            strArr2[8] = "PADDED";
            for (int prefixFlag : prefixFlags) {
                String[] strArr3 = b;
                strArr3[prefixFlag | 8] = strArr3[prefixFlag] + "|PADDED";
            }
            String[] strArr4 = b;
            strArr4[4] = "END_HEADERS";
            strArr4[32] = "PRIORITY";
            strArr4[36] = "END_HEADERS|PRIORITY";
            for (int frameFlag : new int[]{4, 32, 36}) {
                for (int prefixFlag2 : prefixFlags) {
                    String[] strArr5 = b;
                    strArr5[prefixFlag2 | frameFlag] = strArr5[prefixFlag2] + '|' + strArr5[frameFlag];
                    strArr5[prefixFlag2 | frameFlag | 8] = strArr5[prefixFlag2] + '|' + strArr5[frameFlag] + "|PADDED";
                }
            }
            int i2 = 0;
            while (true) {
                String[] strArr6 = b;
                if (i2 < strArr6.length) {
                    if (strArr6[i2] == null) {
                        strArr6[i2] = c[i2];
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static int m(t6 source) {
        return ((source.readByte() & 255) << 16) | ((source.readByte() & 255) << 8) | (source.readByte() & 255);
    }

    /* access modifiers changed from: private */
    public static void n(s6 sink, int i) {
        sink.I((i >>> 16) & 255);
        sink.I((i >>> 8) & 255);
        sink.I(i & 255);
    }
}
