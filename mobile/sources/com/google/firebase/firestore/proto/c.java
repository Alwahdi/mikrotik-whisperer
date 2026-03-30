package com.google.firebase.firestore.proto;

import com.google.firestore.v1.o;
import com.google.protobuf.e;
import com.google.protobuf.f;
import com.google.protobuf.g;
import com.google.protobuf.i;
import com.google.protobuf.l;
import com.google.protobuf.m;
import com.google.protobuf.p;
import com.google.protobuf.v;
import java.io.IOException;

public final class c extends i<c, b> implements h10 {
    /* access modifiers changed from: private */
    public static final c a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<c> f2292a;

    /* renamed from: a  reason: collision with other field name */
    private long f2293a;

    /* renamed from: a  reason: collision with other field name */
    private e f2294a = e.f2563a;

    /* renamed from: a  reason: collision with other field name */
    private v f2295a;

    /* renamed from: a  reason: collision with other field name */
    private Object f2296a;
    private v b;
    private int c = 0;
    private int d;

    private c() {
    }

    /* renamed from: com.google.firebase.firestore.proto.c$c  reason: collision with other inner class name */
    public enum C0024c implements l.a {
        QUERY(5),
        DOCUMENTS(6),
        TARGETTYPE_NOT_SET(0);
        
        private final int value;

        private C0024c(int value2) {
            this.value = value2;
        }

        @Deprecated
        public static C0024c valueOf(int value2) {
            return forNumber(value2);
        }

        public static C0024c forNumber(int value2) {
            switch (value2) {
                case 0:
                    return TARGETTYPE_NOT_SET;
                case 5:
                    return QUERY;
                case 6:
                    return DOCUMENTS;
                default:
                    return null;
            }
        }

        public int getNumber() {
            return this.value;
        }
    }

    public C0024c b0() {
        return C0024c.forNumber(this.c);
    }

    public int a0() {
        return this.d;
    }

    /* access modifiers changed from: private */
    public void k0(int value) {
        this.d = value;
    }

    public v Z() {
        v vVar = this.f2295a;
        return vVar == null ? v.N() : vVar;
    }

    /* access modifiers changed from: private */
    public void j0(v value) {
        if (value != null) {
            this.f2295a = value;
            return;
        }
        throw new NullPointerException();
    }

    public e Y() {
        return this.f2294a;
    }

    /* access modifiers changed from: private */
    public void i0(e value) {
        if (value != null) {
            this.f2294a = value;
            return;
        }
        throw new NullPointerException();
    }

    public long W() {
        return this.f2293a;
    }

    /* access modifiers changed from: private */
    public void g0(long value) {
        this.f2293a = value;
    }

    public o.d X() {
        if (this.c == 5) {
            return (o.d) this.f2296a;
        }
        return o.d.N();
    }

    /* access modifiers changed from: private */
    public void h0(o.d value) {
        if (value != null) {
            this.f2296a = value;
            this.c = 5;
            return;
        }
        throw new NullPointerException();
    }

    public o.c U() {
        if (this.c == 6) {
            return (o.c) this.f2296a;
        }
        return o.c.O();
    }

    /* access modifiers changed from: private */
    public void e0(o.c value) {
        if (value != null) {
            this.f2296a = value;
            this.c = 6;
            return;
        }
        throw new NullPointerException();
    }

    public v V() {
        v vVar = this.b;
        return vVar == null ? v.N() : vVar;
    }

    /* access modifiers changed from: private */
    public void f0(v value) {
        if (value != null) {
            this.b = value;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void T() {
        this.b = null;
    }

    public void b(g output) {
        int i = this.d;
        if (i != 0) {
            output.h0(1, i);
        }
        if (this.f2295a != null) {
            output.l0(2, Z());
        }
        if (!this.f2294a.isEmpty()) {
            output.V(3, this.f2294a);
        }
        long j = this.f2293a;
        if (j != 0) {
            output.j0(4, j);
        }
        if (this.c == 5) {
            output.l0(5, (o.d) this.f2296a);
        }
        if (this.c == 6) {
            output.l0(6, (o.c) this.f2296a);
        }
        if (this.b != null) {
            output.l0(7, V());
        }
    }

    public int d() {
        int size = this.b;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        int i = this.d;
        if (i != 0) {
            size2 = 0 + g.r(1, i);
        }
        if (this.f2295a != null) {
            size2 += g.w(2, Z());
        }
        if (!this.f2294a.isEmpty()) {
            size2 += g.h(3, this.f2294a);
        }
        long j = this.f2293a;
        if (j != 0) {
            size2 += g.t(4, j);
        }
        if (this.c == 5) {
            size2 += g.w(5, (o.d) this.f2296a);
        }
        if (this.c == 6) {
            size2 += g.w(6, (o.c) this.f2296a);
        }
        if (this.b != null) {
            size2 += g.w(7, V());
        }
        this.b = size2;
        return size2;
    }

    public static c d0(byte[] data) {
        return (c) i.E(a, data);
    }

    public static b c0() {
        return (b) a.a();
    }

    public static final class b extends i.b<c, b> implements h10 {
        /* synthetic */ b(a x0) {
            this();
        }

        private b() {
            super(c.a);
        }

        public b F(int value) {
            s();
            ((c) this.b).k0(value);
            return this;
        }

        public b E(v value) {
            s();
            ((c) this.b).j0(value);
            return this;
        }

        public b D(e value) {
            s();
            ((c) this.b).i0(value);
            return this;
        }

        public b A(long value) {
            s();
            ((c) this.b).g0(value);
            return this;
        }

        public b B(o.d value) {
            s();
            ((c) this.b).h0(value);
            return this;
        }

        public b y(o.c value) {
            s();
            ((c) this.b).e0(value);
            return this;
        }

        public b z(v value) {
            s();
            ((c) this.b).f0(value);
            return this;
        }

        public b x() {
            s();
            ((c) this.b).T();
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
            int[] iArr2 = new int[C0024c.values().length];
            a = iArr2;
            try {
                iArr2[C0024c.QUERY.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                a[C0024c.DOCUMENTS.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                a[C0024c.TARGETTYPE_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Object p(i.g method, Object arg0, Object arg1) {
        int i;
        switch (a.b[method.ordinal()]) {
            case 1:
                return new c();
            case 2:
                return a;
            case 3:
                return null;
            case 4:
                return new b((a) null);
            case 5:
                i.h visitor = (i.h) arg0;
                c other = (c) arg1;
                int i2 = this.d;
                boolean z = true;
                boolean z2 = i2 != 0;
                int i3 = other.d;
                this.d = visitor.p(z2, i2, i3 != 0, i3);
                this.f2295a = (v) visitor.m(this.f2295a, other.f2295a);
                e eVar = this.f2294a;
                e eVar2 = e.f2563a;
                boolean z3 = eVar != eVar2;
                e eVar3 = other.f2294a;
                this.f2294a = visitor.n(z3, eVar, eVar3 != eVar2, eVar3);
                long j = this.f2293a;
                boolean z4 = j != 0;
                long j2 = other.f2293a;
                this.f2293a = visitor.g(z4, j, j2 != 0, j2);
                this.b = (v) visitor.m(this.b, other.b);
                switch (a.a[other.b0().ordinal()]) {
                    case 1:
                        if (this.c != 5) {
                            z = false;
                        }
                        this.f2296a = visitor.i(z, this.f2296a, other.f2296a);
                        break;
                    case 2:
                        if (this.c != 6) {
                            z = false;
                        }
                        this.f2296a = visitor.i(z, this.f2296a, other.f2296a);
                        break;
                    case 3:
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
                                this.d = input.s();
                                break;
                            case 18:
                                v.b subBuilder = null;
                                v vVar = this.f2295a;
                                if (vVar != null) {
                                    subBuilder = (v.b) vVar.a();
                                }
                                v vVar2 = (v) input.u(v.R(), extensionRegistry);
                                this.f2295a = vVar2;
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.w(vVar2);
                                    this.f2295a = (v) subBuilder.f();
                                    break;
                                }
                            case 26:
                                this.f2294a = input.m();
                                break;
                            case 32:
                                this.f2293a = input.t();
                                break;
                            case 42:
                                o.d.a subBuilder2 = null;
                                if (this.c == 5) {
                                    subBuilder2 = (o.d.a) ((o.d) this.f2296a).a();
                                }
                                p u = input.u(o.d.S(), extensionRegistry);
                                this.f2296a = u;
                                if (subBuilder2 != null) {
                                    subBuilder2.w((o.d) u);
                                    this.f2296a = subBuilder2.f();
                                }
                                this.c = 5;
                                break;
                            case 50:
                                o.c.a subBuilder3 = null;
                                if (this.c == 6) {
                                    subBuilder3 = (o.c.a) ((o.c) this.f2296a).a();
                                }
                                p u2 = input.u(o.c.T(), extensionRegistry);
                                this.f2296a = u2;
                                if (subBuilder3 != null) {
                                    subBuilder3.w((o.c) u2);
                                    this.f2296a = subBuilder3.f();
                                }
                                this.c = 6;
                                break;
                            case 58:
                                v.b subBuilder4 = null;
                                v vVar3 = this.b;
                                if (vVar3 != null) {
                                    subBuilder4 = (v.b) vVar3.a();
                                }
                                v vVar4 = (v) input.u(v.R(), extensionRegistry);
                                this.b = vVar4;
                                if (subBuilder4 == null) {
                                    break;
                                } else {
                                    subBuilder4.w(vVar4);
                                    this.b = (v) subBuilder4.f();
                                    break;
                                }
                            default:
                                if (input.P(tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
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
                if (f2292a == null) {
                    synchronized (c.class) {
                        if (f2292a == null) {
                            f2292a = new i.c(a);
                        }
                    }
                }
                return f2292a;
            default:
                throw new UnsupportedOperationException();
        }
        return a;
    }

    static {
        c cVar = new c();
        a = cVar;
        cVar.x();
    }
}
