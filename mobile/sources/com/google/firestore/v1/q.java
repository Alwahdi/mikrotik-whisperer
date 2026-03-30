package com.google.firestore.v1;

import com.google.firestore.v1.a;
import com.google.firestore.v1.l;
import com.google.protobuf.e;
import com.google.protobuf.f;
import com.google.protobuf.g;
import com.google.protobuf.i;
import com.google.protobuf.l;
import com.google.protobuf.m;
import com.google.protobuf.p;
import com.google.protobuf.v;
import defpackage.qw;
import java.io.IOException;

public final class q extends i<q, b> implements h10 {
    /* access modifiers changed from: private */
    public static final q a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<q> f2541a;

    /* renamed from: a  reason: collision with other field name */
    private Object f2542a;
    private int c = 0;

    private q() {
    }

    public enum c implements l.a {
        NULL_VALUE(11),
        BOOLEAN_VALUE(1),
        INTEGER_VALUE(2),
        DOUBLE_VALUE(3),
        TIMESTAMP_VALUE(10),
        STRING_VALUE(17),
        BYTES_VALUE(18),
        REFERENCE_VALUE(5),
        GEO_POINT_VALUE(8),
        ARRAY_VALUE(9),
        MAP_VALUE(6),
        VALUETYPE_NOT_SET(0);
        
        private final int value;

        private c(int value2) {
            this.value = value2;
        }

        @Deprecated
        public static c valueOf(int value2) {
            return forNumber(value2);
        }

        public static c forNumber(int value2) {
            switch (value2) {
                case 0:
                    return VALUETYPE_NOT_SET;
                case 1:
                    return BOOLEAN_VALUE;
                case 2:
                    return INTEGER_VALUE;
                case 3:
                    return DOUBLE_VALUE;
                case 5:
                    return REFERENCE_VALUE;
                case 6:
                    return MAP_VALUE;
                case 8:
                    return GEO_POINT_VALUE;
                case 9:
                    return ARRAY_VALUE;
                case 10:
                    return TIMESTAMP_VALUE;
                case 11:
                    return NULL_VALUE;
                case 17:
                    return STRING_VALUE;
                case 18:
                    return BYTES_VALUE;
                default:
                    return null;
            }
        }

        public int getNumber() {
            return this.value;
        }
    }

    public c h0() {
        return c.forNumber(this.c);
    }

    /* access modifiers changed from: private */
    public void r0(int value) {
        this.c = 11;
        this.f2542a = Integer.valueOf(value);
    }

    public boolean X() {
        if (this.c == 1) {
            return ((Boolean) this.f2542a).booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void l0(boolean value) {
        this.c = 1;
        this.f2542a = Boolean.valueOf(value);
    }

    public long c0() {
        if (this.c == 2) {
            return ((Long) this.f2542a).longValue();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public void p0(long value) {
        this.c = 2;
        this.f2542a = Long.valueOf(value);
    }

    public double a0() {
        if (this.c == 3) {
            return ((Double) this.f2542a).doubleValue();
        }
        return 0.0d;
    }

    /* access modifiers changed from: private */
    public void n0(double value) {
        this.c = 3;
        this.f2542a = Double.valueOf(value);
    }

    public v g0() {
        if (this.c == 10) {
            return (v) this.f2542a;
        }
        return v.N();
    }

    /* access modifiers changed from: private */
    public void u0(v value) {
        if (value != null) {
            this.f2542a = value;
            this.c = 10;
            return;
        }
        throw new NullPointerException();
    }

    public String f0() {
        if (this.c == 17) {
            return (String) this.f2542a;
        }
        return "";
    }

    /* access modifiers changed from: private */
    public void t0(String value) {
        if (value != null) {
            this.c = 17;
            this.f2542a = value;
            return;
        }
        throw new NullPointerException();
    }

    public e Y() {
        if (this.c == 18) {
            return (e) this.f2542a;
        }
        return e.f2563a;
    }

    /* access modifiers changed from: private */
    public void m0(e value) {
        if (value != null) {
            this.c = 18;
            this.f2542a = value;
            return;
        }
        throw new NullPointerException();
    }

    public String e0() {
        if (this.c == 5) {
            return (String) this.f2542a;
        }
        return "";
    }

    /* access modifiers changed from: private */
    public void s0(String value) {
        if (value != null) {
            this.c = 5;
            this.f2542a = value;
            return;
        }
        throw new NullPointerException();
    }

    public qw b0() {
        if (this.c == 8) {
            return (qw) this.f2542a;
        }
        return qw.N();
    }

    /* access modifiers changed from: private */
    public void o0(qw value) {
        if (value != null) {
            this.f2542a = value;
            this.c = 8;
            return;
        }
        throw new NullPointerException();
    }

    public a W() {
        if (this.c == 9) {
            return (a) this.f2542a;
        }
        return a.O();
    }

    /* access modifiers changed from: private */
    public void k0(a value) {
        if (value != null) {
            this.f2542a = value;
            this.c = 9;
            return;
        }
        throw new NullPointerException();
    }

    public l d0() {
        if (this.c == 6) {
            return (l) this.f2542a;
        }
        return l.M();
    }

    /* access modifiers changed from: private */
    public void q0(l value) {
        if (value != null) {
            this.f2542a = value;
            this.c = 6;
            return;
        }
        throw new NullPointerException();
    }

    public void b(g output) {
        if (this.c == 1) {
            output.R(1, ((Boolean) this.f2542a).booleanValue());
        }
        if (this.c == 2) {
            output.j0(2, ((Long) this.f2542a).longValue());
        }
        if (this.c == 3) {
            output.X(3, ((Double) this.f2542a).doubleValue());
        }
        if (this.c == 5) {
            output.r0(5, e0());
        }
        if (this.c == 6) {
            output.l0(6, (l) this.f2542a);
        }
        if (this.c == 8) {
            output.l0(8, (qw) this.f2542a);
        }
        if (this.c == 9) {
            output.l0(9, (a) this.f2542a);
        }
        if (this.c == 10) {
            output.l0(10, (v) this.f2542a);
        }
        if (this.c == 11) {
            output.Z(11, ((Integer) this.f2542a).intValue());
        }
        if (this.c == 17) {
            output.r0(17, f0());
        }
        if (this.c == 18) {
            output.V(18, (e) this.f2542a);
        }
    }

    public int d() {
        int size = this.b;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (this.c == 1) {
            size2 = 0 + g.e(1, ((Boolean) this.f2542a).booleanValue());
        }
        if (this.c == 2) {
            size2 += g.t(2, ((Long) this.f2542a).longValue());
        }
        if (this.c == 3) {
            size2 += g.j(3, ((Double) this.f2542a).doubleValue());
        }
        if (this.c == 5) {
            size2 += g.D(5, e0());
        }
        if (this.c == 6) {
            size2 += g.w(6, (l) this.f2542a);
        }
        if (this.c == 8) {
            size2 += g.w(8, (qw) this.f2542a);
        }
        if (this.c == 9) {
            size2 += g.w(9, (a) this.f2542a);
        }
        if (this.c == 10) {
            size2 += g.w(10, (v) this.f2542a);
        }
        if (this.c == 11) {
            size2 += g.l(11, ((Integer) this.f2542a).intValue());
        }
        if (this.c == 17) {
            size2 += g.D(17, f0());
        }
        if (this.c == 18) {
            size2 += g.h(18, (e) this.f2542a);
        }
        this.b = size2;
        return size2;
    }

    public static b i0() {
        return (b) a.a();
    }

    public static final class b extends i.b<q, b> implements h10 {
        /* synthetic */ b(a x0) {
            this();
        }

        private b() {
            super(q.a);
        }

        public b F(int value) {
            s();
            ((q) this.b).r0(value);
            return this;
        }

        public b y(boolean value) {
            s();
            ((q) this.b).l0(value);
            return this;
        }

        public b D(long value) {
            s();
            ((q) this.b).p0(value);
            return this;
        }

        public b A(double value) {
            s();
            ((q) this.b).n0(value);
            return this;
        }

        public b I(v value) {
            s();
            ((q) this.b).u0(value);
            return this;
        }

        public b H(String value) {
            s();
            ((q) this.b).t0(value);
            return this;
        }

        public b z(e value) {
            s();
            ((q) this.b).m0(value);
            return this;
        }

        public b G(String value) {
            s();
            ((q) this.b).s0(value);
            return this;
        }

        public b B(qw value) {
            s();
            ((q) this.b).o0(value);
            return this;
        }

        public b x(a value) {
            s();
            ((q) this.b).k0(value);
            return this;
        }

        public b E(l value) {
            s();
            ((q) this.b).q0(value);
            return this;
        }
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[i.g.values().length];
            b = iArr;
            try {
                iArr[i.g.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[i.g.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                b[i.g.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                b[i.g.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                b[i.g.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                b[i.g.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                b[i.g.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                b[i.g.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            int[] iArr2 = new int[c.values().length];
            a = iArr2;
            try {
                iArr2[c.NULL_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                a[c.BOOLEAN_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                a[c.INTEGER_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                a[c.DOUBLE_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                a[c.TIMESTAMP_VALUE.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                a[c.STRING_VALUE.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
            try {
                a[c.BYTES_VALUE.ordinal()] = 7;
            } catch (NoSuchFieldError e15) {
            }
            try {
                a[c.REFERENCE_VALUE.ordinal()] = 8;
            } catch (NoSuchFieldError e16) {
            }
            try {
                a[c.GEO_POINT_VALUE.ordinal()] = 9;
            } catch (NoSuchFieldError e17) {
            }
            try {
                a[c.ARRAY_VALUE.ordinal()] = 10;
            } catch (NoSuchFieldError e18) {
            }
            try {
                a[c.MAP_VALUE.ordinal()] = 11;
            } catch (NoSuchFieldError e19) {
            }
            try {
                a[c.VALUETYPE_NOT_SET.ordinal()] = 12;
            } catch (NoSuchFieldError e20) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Object p(i.g method, Object arg0, Object arg1) {
        int i;
        int i2 = 18;
        int i3 = 11;
        boolean z = true;
        switch (a.b[method.ordinal()]) {
            case 1:
                return new q();
            case 2:
                return a;
            case 3:
                return null;
            case 4:
                return new b((a) null);
            case 5:
                i.h visitor = (i.h) arg0;
                q other = (q) arg1;
                switch (a.a[other.h0().ordinal()]) {
                    case 1:
                        if (this.c != 11) {
                            z = false;
                        }
                        this.f2542a = visitor.o(z, this.f2542a, other.f2542a);
                        break;
                    case 2:
                        if (this.c != 1) {
                            z = false;
                        }
                        this.f2542a = visitor.k(z, this.f2542a, other.f2542a);
                        break;
                    case 3:
                        if (this.c != 2) {
                            z = false;
                        }
                        this.f2542a = visitor.e(z, this.f2542a, other.f2542a);
                        break;
                    case 4:
                        if (this.c != 3) {
                            z = false;
                        }
                        this.f2542a = visitor.j(z, this.f2542a, other.f2542a);
                        break;
                    case 5:
                        if (this.c != 10) {
                            z = false;
                        }
                        this.f2542a = visitor.i(z, this.f2542a, other.f2542a);
                        break;
                    case 6:
                        if (this.c != 17) {
                            z = false;
                        }
                        this.f2542a = visitor.d(z, this.f2542a, other.f2542a);
                        break;
                    case 7:
                        if (this.c != 18) {
                            z = false;
                        }
                        this.f2542a = visitor.h(z, this.f2542a, other.f2542a);
                        break;
                    case 8:
                        if (this.c != 5) {
                            z = false;
                        }
                        this.f2542a = visitor.d(z, this.f2542a, other.f2542a);
                        break;
                    case 9:
                        if (this.c != 8) {
                            z = false;
                        }
                        this.f2542a = visitor.i(z, this.f2542a, other.f2542a);
                        break;
                    case 10:
                        if (this.c != 9) {
                            z = false;
                        }
                        this.f2542a = visitor.i(z, this.f2542a, other.f2542a);
                        break;
                    case 11:
                        if (this.c != 6) {
                            z = false;
                        }
                        this.f2542a = visitor.i(z, this.f2542a, other.f2542a);
                        break;
                    case 12:
                        if (this.c == 0) {
                            z = false;
                        }
                        visitor.s(z);
                        break;
                }
                if (visitor == i.f.a && (i = other.c) != 0) {
                    this.c = i;
                }
                return this;
            case 6:
                f input = (f) arg0;
                fk extensionRegistry = (fk) arg1;
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.J();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 8:
                                this.c = 1;
                                this.f2542a = Boolean.valueOf(input.l());
                                break;
                            case 16:
                                this.c = 2;
                                this.f2542a = Long.valueOf(input.t());
                                break;
                            case 25:
                                this.c = 3;
                                this.f2542a = Double.valueOf(input.n());
                                break;
                            case 42:
                                String s = input.I();
                                this.c = 5;
                                this.f2542a = s;
                                break;
                            case 50:
                                l.b subBuilder = null;
                                if (this.c == 6) {
                                    subBuilder = (l.b) ((l) this.f2542a).a();
                                }
                                p u = input.u(l.S(), extensionRegistry);
                                this.f2542a = u;
                                if (subBuilder != null) {
                                    subBuilder.w((l) u);
                                    this.f2542a = subBuilder.f();
                                }
                                this.c = 6;
                                break;
                            case 66:
                                qw.b subBuilder2 = null;
                                if (this.c == 8) {
                                    subBuilder2 = (qw.b) ((qw) this.f2542a).a();
                                }
                                p u2 = input.u(qw.R(), extensionRegistry);
                                this.f2542a = u2;
                                if (subBuilder2 != null) {
                                    subBuilder2.w((qw) u2);
                                    this.f2542a = subBuilder2.f();
                                }
                                this.c = 8;
                                break;
                            case 74:
                                a.b subBuilder3 = null;
                                if (this.c == 9) {
                                    subBuilder3 = (a.b) ((a) this.f2542a).a();
                                }
                                p u3 = input.u(a.S(), extensionRegistry);
                                this.f2542a = u3;
                                if (subBuilder3 != null) {
                                    subBuilder3.w((a) u3);
                                    this.f2542a = subBuilder3.f();
                                }
                                this.c = 9;
                                break;
                            case 82:
                                v.b subBuilder4 = null;
                                if (this.c == 10) {
                                    subBuilder4 = (v.b) ((v) this.f2542a).a();
                                }
                                p u4 = input.u(v.R(), extensionRegistry);
                                this.f2542a = u4;
                                if (subBuilder4 != null) {
                                    subBuilder4.w((v) u4);
                                    this.f2542a = subBuilder4.f();
                                }
                                this.c = 10;
                                break;
                            case 88:
                                int rawValue = input.o();
                                this.c = i3;
                                this.f2542a = Integer.valueOf(rawValue);
                                break;
                            case 138:
                                String s2 = input.I();
                                this.c = 17;
                                this.f2542a = s2;
                                break;
                            case 146:
                                this.c = i2;
                                this.f2542a = input.m();
                                break;
                            default:
                                if (input.P(tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                        i2 = 18;
                        i3 = 11;
                    } catch (m e) {
                        throw new RuntimeException(e.i(this));
                    } catch (IOException e2) {
                        throw new RuntimeException(new m(e2.getMessage()).i(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (f2541a == null) {
                    synchronized (q.class) {
                        if (f2541a == null) {
                            f2541a = new i.c(a);
                        }
                    }
                }
                return f2541a;
            default:
                throw new UnsupportedOperationException();
        }
        return a;
    }

    static {
        q qVar = new q();
        a = qVar;
        qVar.x();
    }

    public static q Z() {
        return a;
    }

    public static n50<q> j0() {
        return a.h();
    }
}
