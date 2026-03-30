package io.grpc.internal;

import java.io.Closeable;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;

class i0 implements Closeable {
    /* access modifiers changed from: private */
    public int a;

    /* renamed from: a  reason: collision with other field name */
    private long f3444a;

    /* renamed from: a  reason: collision with other field name */
    private final b f3445a = new b(this, (a) null);

    /* renamed from: a  reason: collision with other field name */
    private c f3446a = c.HEADER;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final CRC32 f3447a = new CRC32();

    /* renamed from: a  reason: collision with other field name */
    private Inflater f3448a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final sb f3449a = new sb();

    /* renamed from: a  reason: collision with other field name */
    private boolean f3450a = false;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f3451a = new byte[512];
    /* access modifiers changed from: private */
    public int b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f3452b = true;
    private int c;
    private int d;
    private int e = 0;
    private int f = 0;

    private enum c {
        HEADER,
        HEADER_EXTRA_LEN,
        HEADER_EXTRA,
        HEADER_NAME,
        HEADER_COMMENT,
        HEADER_CRC,
        INITIALIZE_INFLATER,
        INFLATING,
        INFLATER_NEEDS_INPUT,
        TRAILER
    }

    i0() {
    }

    static /* synthetic */ int J(i0 x0, int x1) {
        int i = x0.e + x1;
        x0.e = i;
        return i;
    }

    static /* synthetic */ int o(i0 x0, int x1) {
        int i = x0.a + x1;
        x0.a = i;
        return i;
    }

    private class b {
        private b() {
        }

        /* synthetic */ b(i0 x0, a x1) {
            this();
        }

        /* access modifiers changed from: private */
        public int h() {
            int b;
            if (i0.this.b - i0.this.a > 0) {
                b = i0.this.f3451a[i0.this.a] & 255;
                i0.o(i0.this, 1);
            } else {
                b = i0.this.f3449a.readUnsignedByte();
            }
            i0.this.f3447a.update(b);
            i0.J(i0.this, 1);
            return b;
        }

        /* access modifiers changed from: private */
        public void l(int length) {
            int bytesToSkip = length;
            int bytesRemainingInInflaterInput = i0.this.b - i0.this.a;
            if (bytesRemainingInInflaterInput > 0) {
                int bytesToGetFromInflaterInput = Math.min(bytesRemainingInInflaterInput, bytesToSkip);
                i0.this.f3447a.update(i0.this.f3451a, i0.this.a, bytesToGetFromInflaterInput);
                i0.o(i0.this, bytesToGetFromInflaterInput);
                bytesToSkip -= bytesToGetFromInflaterInput;
            }
            if (bytesToSkip > 0) {
                byte[] buf = new byte[512];
                int total = 0;
                while (total < bytesToSkip) {
                    int toRead = Math.min(bytesToSkip - total, buf.length);
                    i0.this.f3449a.m(buf, 0, toRead);
                    i0.this.f3447a.update(buf, 0, toRead);
                    total += toRead;
                }
            }
            i0.J(i0.this, length);
        }

        /* access modifiers changed from: private */
        public int k() {
            return (i0.this.b - i0.this.a) + i0.this.f3449a.b();
        }

        /* access modifiers changed from: private */
        public boolean g() {
            while (k() > 0) {
                if (h() == 0) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: private */
        public int j() {
            return h() | (h() << 8);
        }

        /* access modifiers changed from: private */
        public long i() {
            return (((long) j()) << 16) | ((long) j());
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b0() {
        v90.u(!this.f3450a, "GzipInflatingBuffer is closed");
        return this.f3452b;
    }

    /* access modifiers changed from: package-private */
    public boolean X() {
        v90.u(!this.f3450a, "GzipInflatingBuffer is closed");
        if (this.f3445a.k() == 0 && this.f3446a == c.HEADER) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void K(id0 buffer) {
        v90.u(!this.f3450a, "GzipInflatingBuffer is closed");
        this.f3449a.f(buffer);
        this.f3452b = false;
    }

    public void close() {
        if (!this.f3450a) {
            this.f3450a = true;
            this.f3449a.close();
            Inflater inflater = this.f3448a;
            if (inflater != null) {
                inflater.end();
                this.f3448a = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int U() {
        int savedBytesConsumed = this.e;
        this.e = 0;
        return savedBytesConsumed;
    }

    /* access modifiers changed from: package-private */
    public int V() {
        int savedDeflatedBytesConsumed = this.f;
        this.f = 0;
        return savedDeflatedBytesConsumed;
    }

    /* access modifiers changed from: package-private */
    public int Z(byte[] b2, int offset, int length) {
        boolean z = true;
        v90.u(!this.f3450a, "GzipInflatingBuffer is closed");
        int bytesRead = 0;
        boolean madeProgress = true;
        while (madeProgress) {
            int i = length - bytesRead;
            int missingBytes = i;
            if (i > 0) {
                switch (a.a[this.f3446a.ordinal()]) {
                    case 1:
                        madeProgress = c0();
                        break;
                    case 2:
                        madeProgress = g0();
                        break;
                    case 3:
                        madeProgress = f0();
                        break;
                    case 4:
                        madeProgress = h0();
                        break;
                    case 5:
                        madeProgress = d0();
                        break;
                    case 6:
                        madeProgress = e0();
                        break;
                    case 7:
                        madeProgress = a0();
                        break;
                    case 8:
                        bytesRead += Y(b2, offset + bytesRead, missingBytes);
                        if (this.f3446a != c.TRAILER) {
                            madeProgress = true;
                            break;
                        } else {
                            madeProgress = i0();
                            break;
                        }
                    case 9:
                        madeProgress = P();
                        break;
                    case 10:
                        madeProgress = i0();
                        break;
                    default:
                        throw new AssertionError("Invalid state: " + this.f3446a);
                }
            } else {
                if (madeProgress && (this.f3446a != c.HEADER || this.f3445a.k() >= 10)) {
                    z = false;
                }
                this.f3452b = z;
                return bytesRead;
            }
        }
        z = false;
        this.f3452b = z;
        return bytesRead;
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            a = iArr;
            try {
                iArr[c.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[c.HEADER_EXTRA_LEN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[c.HEADER_EXTRA.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[c.HEADER_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[c.HEADER_COMMENT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[c.HEADER_CRC.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[c.INITIALIZE_INFLATER.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                a[c.INFLATING.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                a[c.INFLATER_NEEDS_INPUT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                a[c.TRAILER.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    private boolean c0() {
        if (this.f3445a.k() < 10) {
            return false;
        }
        if (this.f3445a.j() != 35615) {
            throw new ZipException("Not in GZIP format");
        } else if (this.f3445a.h() == 8) {
            this.c = this.f3445a.h();
            this.f3445a.l(6);
            this.f3446a = c.HEADER_EXTRA_LEN;
            return true;
        } else {
            throw new ZipException("Unsupported compression method");
        }
    }

    private boolean g0() {
        if ((this.c & 4) != 4) {
            this.f3446a = c.HEADER_NAME;
            return true;
        } else if (this.f3445a.k() < 2) {
            return false;
        } else {
            this.d = this.f3445a.j();
            this.f3446a = c.HEADER_EXTRA;
            return true;
        }
    }

    private boolean f0() {
        int d2 = this.f3445a.k();
        int i = this.d;
        if (d2 < i) {
            return false;
        }
        this.f3445a.l(i);
        this.f3446a = c.HEADER_NAME;
        return true;
    }

    private boolean h0() {
        if ((this.c & 8) != 8) {
            this.f3446a = c.HEADER_COMMENT;
            return true;
        } else if (!this.f3445a.g()) {
            return false;
        } else {
            this.f3446a = c.HEADER_COMMENT;
            return true;
        }
    }

    private boolean d0() {
        if ((this.c & 16) != 16) {
            this.f3446a = c.HEADER_CRC;
            return true;
        } else if (!this.f3445a.g()) {
            return false;
        } else {
            this.f3446a = c.HEADER_CRC;
            return true;
        }
    }

    private boolean e0() {
        if ((this.c & 2) != 2) {
            this.f3446a = c.INITIALIZE_INFLATER;
            return true;
        } else if (this.f3445a.k() < 2) {
            return false;
        } else {
            if ((65535 & ((int) this.f3447a.getValue())) == this.f3445a.j()) {
                this.f3446a = c.INITIALIZE_INFLATER;
                return true;
            }
            throw new ZipException("Corrupt GZIP header");
        }
    }

    private boolean a0() {
        Inflater inflater = this.f3448a;
        if (inflater == null) {
            this.f3448a = new Inflater(true);
        } else {
            inflater.reset();
        }
        this.f3447a.reset();
        int i = this.b;
        int i2 = this.a;
        int bytesRemainingInInflaterInput = i - i2;
        if (bytesRemainingInInflaterInput > 0) {
            this.f3448a.setInput(this.f3451a, i2, bytesRemainingInInflaterInput);
            this.f3446a = c.INFLATING;
        } else {
            this.f3446a = c.INFLATER_NEEDS_INPUT;
        }
        return true;
    }

    private int Y(byte[] b2, int off, int len) {
        v90.u(this.f3448a != null, "inflater is null");
        try {
            int inflaterTotalIn = this.f3448a.getTotalIn();
            int n = this.f3448a.inflate(b2, off, len);
            int bytesConsumedDelta = this.f3448a.getTotalIn() - inflaterTotalIn;
            this.e += bytesConsumedDelta;
            this.f += bytesConsumedDelta;
            this.a += bytesConsumedDelta;
            this.f3447a.update(b2, off, n);
            if (this.f3448a.finished()) {
                this.f3444a = this.f3448a.getBytesWritten() & 4294967295L;
                this.f3446a = c.TRAILER;
            } else if (this.f3448a.needsInput()) {
                this.f3446a = c.INFLATER_NEEDS_INPUT;
            }
            return n;
        } catch (DataFormatException e2) {
            throw new DataFormatException("Inflater data format exception: " + e2.getMessage());
        }
    }

    private boolean P() {
        v90.u(this.f3448a != null, "inflater is null");
        v90.u(this.a == this.b, "inflaterInput has unconsumed bytes");
        int bytesToAdd = Math.min(this.f3449a.b(), 512);
        if (bytesToAdd == 0) {
            return false;
        }
        this.a = 0;
        this.b = bytesToAdd;
        this.f3449a.m(this.f3451a, 0, bytesToAdd);
        this.f3448a.setInput(this.f3451a, this.a, bytesToAdd);
        this.f3446a = c.INFLATING;
        return true;
    }

    private boolean i0() {
        if (this.f3448a != null && this.f3445a.k() <= 18) {
            this.f3448a.end();
            this.f3448a = null;
        }
        if (this.f3445a.k() < 8) {
            return false;
        }
        if (this.f3447a.getValue() == this.f3445a.i() && this.f3444a == this.f3445a.i()) {
            this.f3447a.reset();
            this.f3446a = c.HEADER;
            return true;
        }
        throw new ZipException("Corrupt GZIP trailer");
    }
}
