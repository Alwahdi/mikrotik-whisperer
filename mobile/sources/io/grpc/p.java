package io.grpc;

import defpackage.f20;
import io.grpc.l;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public final class p {
    static final l.g<p> a = l.g.g("grpc-status", false, new c());

    /* renamed from: a  reason: collision with other field name */
    private static final l.j<String> f3952a;

    /* renamed from: a  reason: collision with other field name */
    public static final p f3953a = b.OK.toStatus();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public static final List<p> f3954a = f();

    /* renamed from: a  reason: collision with other field name */
    private static final boolean f3955a = Boolean.parseBoolean(System.getProperty("io.grpc.Status.failOnEqualsForTest", "false"));
    static final l.g<String> b;

    /* renamed from: b  reason: collision with other field name */
    public static final p f3956b = b.CANCELLED.toStatus();
    public static final p c = b.UNKNOWN.toStatus();
    public static final p d = b.INVALID_ARGUMENT.toStatus();
    public static final p e = b.DEADLINE_EXCEEDED.toStatus();
    public static final p f = b.NOT_FOUND.toStatus();
    public static final p g = b.ALREADY_EXISTS.toStatus();
    public static final p h = b.PERMISSION_DENIED.toStatus();
    public static final p i = b.UNAUTHENTICATED.toStatus();
    public static final p j = b.RESOURCE_EXHAUSTED.toStatus();
    public static final p k = b.FAILED_PRECONDITION.toStatus();
    public static final p l = b.ABORTED.toStatus();
    public static final p m = b.OUT_OF_RANGE.toStatus();
    public static final p n = b.UNIMPLEMENTED.toStatus();
    public static final p o = b.INTERNAL.toStatus();
    public static final p p = b.UNAVAILABLE.toStatus();
    public static final p q = b.DATA_LOSS.toStatus();

    /* renamed from: a  reason: collision with other field name */
    private final b f3957a;

    /* renamed from: a  reason: collision with other field name */
    private final String f3958a;

    /* renamed from: a  reason: collision with other field name */
    private final Throwable f3959a;

    static {
        d dVar = new d();
        f3952a = dVar;
        b = l.g.g("grpc-message", false, dVar);
    }

    public enum b {
        OK(0),
        CANCELLED(1),
        UNKNOWN(2),
        INVALID_ARGUMENT(3),
        DEADLINE_EXCEEDED(4),
        NOT_FOUND(5),
        ALREADY_EXISTS(6),
        PERMISSION_DENIED(7),
        RESOURCE_EXHAUSTED(8),
        FAILED_PRECONDITION(9),
        ABORTED(10),
        OUT_OF_RANGE(11),
        UNIMPLEMENTED(12),
        INTERNAL(13),
        UNAVAILABLE(14),
        DATA_LOSS(15),
        UNAUTHENTICATED(16);
        
        private final int value;
        private final byte[] valueAscii;

        private b(int value2) {
            this.value = value2;
            this.valueAscii = Integer.toString(value2).getBytes(j8.a);
        }

        public int value() {
            return this.value;
        }

        public p toStatus() {
            return (p) p.f3954a.get(this.value);
        }

        /* access modifiers changed from: private */
        public byte[] valueAscii() {
            return this.valueAscii;
        }
    }

    private static List<p> f() {
        TreeMap<Integer, Status> canonicalizer = new TreeMap<>();
        b[] values = b.values();
        int length = values.length;
        int i2 = 0;
        while (i2 < length) {
            b code = values[i2];
            p replaced = (p) canonicalizer.put(Integer.valueOf(code.value()), new p(code));
            if (replaced == null) {
                i2++;
            } else {
                throw new IllegalStateException("Code value duplication between " + replaced.m().name() + " & " + code.name());
            }
        }
        return Collections.unmodifiableList(new ArrayList(canonicalizer.values()));
    }

    public static p h(int codeValue) {
        if (codeValue >= 0) {
            List<p> list = f3954a;
            if (codeValue <= list.size()) {
                return list.get(codeValue);
            }
        }
        p pVar = c;
        return pVar.q("Unknown code " + codeValue);
    }

    /* access modifiers changed from: private */
    public static p i(byte[] asciiCodeValue) {
        if (asciiCodeValue.length == 1 && asciiCodeValue[0] == 48) {
            return f3953a;
        }
        return j(asciiCodeValue);
    }

    private static p j(byte[] asciiCodeValue) {
        int index = 0;
        int codeValue = 0;
        switch (asciiCodeValue.length) {
            case 2:
                if (asciiCodeValue[0] >= 48 && asciiCodeValue[0] <= 57) {
                    codeValue = 0 + ((asciiCodeValue[0] - 48) * 10);
                    index = 0 + 1;
                }
            case 1:
                if (asciiCodeValue[index] >= 48 && asciiCodeValue[index] <= 57) {
                    int codeValue2 = codeValue + (asciiCodeValue[index] - 48);
                    List<p> list = f3954a;
                    if (codeValue2 < list.size()) {
                        return list.get(codeValue2);
                    }
                }
                break;
        }
        p pVar = c;
        return pVar.q("Unknown code " + new String(asciiCodeValue, j8.a));
    }

    public static p k(Throwable t) {
        for (Throwable cause = (Throwable) v90.o(t, "t"); cause != null; cause = cause.getCause()) {
            if (cause instanceof q) {
                return ((q) cause).a();
            }
            if (cause instanceof r) {
                return ((r) cause).a();
            }
        }
        return c.p(t);
    }

    static String g(p status) {
        if (status.f3958a == null) {
            return status.f3957a.toString();
        }
        return status.f3957a + ": " + status.f3958a;
    }

    private p(b code) {
        this(code, (String) null, (Throwable) null);
    }

    private p(b code, String description, Throwable cause) {
        this.f3957a = (b) v90.o(code, "code");
        this.f3958a = description;
        this.f3959a = cause;
    }

    public p p(Throwable cause) {
        if (f40.a(this.f3959a, cause)) {
            return this;
        }
        return new p(this.f3957a, this.f3958a, cause);
    }

    public p q(String description) {
        if (f40.a(this.f3958a, description)) {
            return this;
        }
        return new p(this.f3957a, description, this.f3959a);
    }

    public p e(String additionalDetail) {
        if (additionalDetail == null) {
            return this;
        }
        if (this.f3958a == null) {
            return new p(this.f3957a, additionalDetail, this.f3959a);
        }
        b bVar = this.f3957a;
        return new p(bVar, this.f3958a + "\n" + additionalDetail, this.f3959a);
    }

    public b m() {
        return this.f3957a;
    }

    public String n() {
        return this.f3958a;
    }

    public Throwable l() {
        return this.f3959a;
    }

    public boolean o() {
        return b.OK == this.f3957a;
    }

    public r d() {
        return new r(this);
    }

    public q c() {
        return new q(this);
    }

    public String toString() {
        f20.b d2 = f20.c(this).d("code", this.f3957a.name()).d("description", this.f3958a);
        Throwable th = this.f3959a;
        Object obj = th;
        if (th != null) {
            obj = hr0.e(th);
        }
        return d2.d("cause", obj).toString();
    }

    private static final class c implements l.j<p> {
        private c() {
        }

        /* renamed from: d */
        public byte[] a(p status) {
            return status.m().valueAscii();
        }

        /* renamed from: c */
        public p b(byte[] serialized) {
            return p.i(serialized);
        }
    }

    private static final class d implements l.j<String> {
        private static final byte[] a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};

        private d() {
        }

        /* renamed from: f */
        public byte[] a(String value) {
            byte[] valueBytes = value.getBytes(j8.c);
            for (int i = 0; i < valueBytes.length; i++) {
                if (c(valueBytes[i])) {
                    return g(valueBytes, i);
                }
            }
            return valueBytes;
        }

        private static boolean c(byte b) {
            return b < 32 || b >= 126 || b == 37;
        }

        private static byte[] g(byte[] valueBytes, int ri) {
            byte[] escapedBytes = new byte[(((valueBytes.length - ri) * 3) + ri)];
            if (ri != 0) {
                System.arraycopy(valueBytes, 0, escapedBytes, 0, ri);
            }
            int wi = ri;
            while (ri < valueBytes.length) {
                byte b = valueBytes[ri];
                if (c(b)) {
                    escapedBytes[wi] = 37;
                    byte[] bArr = a;
                    escapedBytes[wi + 1] = bArr[(b >> 4) & 15];
                    escapedBytes[wi + 2] = bArr[b & 15];
                    wi += 3;
                } else {
                    escapedBytes[wi] = b;
                    wi++;
                }
                ri++;
            }
            byte[] dest = new byte[wi];
            System.arraycopy(escapedBytes, 0, dest, 0, wi);
            return dest;
        }

        /* renamed from: d */
        public String b(byte[] value) {
            for (int i = 0; i < value.length; i++) {
                byte b = value[i];
                if (b < 32 || b >= 126 || (b == 37 && i + 2 < value.length)) {
                    return e(value);
                }
            }
            return new String(value, 0);
        }

        private static String e(byte[] value) {
            ByteBuffer buf = ByteBuffer.allocate(value.length);
            int i = 0;
            while (i < value.length) {
                if (value[i] == 37 && i + 2 < value.length) {
                    try {
                        buf.put((byte) Integer.parseInt(new String(value, i + 1, 2, j8.a), 16));
                        i += 3;
                    } catch (NumberFormatException e) {
                    }
                }
                buf.put(value[i]);
                i++;
            }
            return new String(buf.array(), 0, buf.position(), j8.c);
        }
    }

    public boolean equals(Object obj) {
        if (!f3955a) {
            return super.equals(obj);
        }
        throw new AssertionError("Status.equals called; disable this by setting io.grpc.Status.failOnEqualsForTest");
    }

    public int hashCode() {
        return super.hashCode();
    }
}
