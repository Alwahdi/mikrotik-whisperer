package com.google.firestore.v1;

import com.google.firestore.v1.c;
import com.google.firestore.v1.f;
import com.google.firestore.v1.h;
import com.google.firestore.v1.m;
import com.google.protobuf.f;
import com.google.protobuf.g;
import com.google.protobuf.i;
import com.google.protobuf.l;
import com.google.protobuf.p;
import java.io.IOException;

public final class r extends i<r, b> implements h10 {
    /* access modifiers changed from: private */
    public static final r a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<r> f2543a;

    /* renamed from: a  reason: collision with other field name */
    private f f2544a;

    /* renamed from: a  reason: collision with other field name */
    private m f2545a;

    /* renamed from: a  reason: collision with other field name */
    private Object f2546a;
    private int c = 0;

    private r() {
    }

    public enum c implements l.a {
        UPDATE(1),
        DELETE(2),
        VERIFY(5),
        TRANSFORM(6),
        OPERATION_NOT_SET(0);
        
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
                    return OPERATION_NOT_SET;
                case 1:
                    return UPDATE;
                case 2:
                    return DELETE;
                case 5:
                    return VERIFY;
                case 6:
                    return TRANSFORM;
                default:
                    return null;
            }
        }

        public int getNumber() {
            return this.value;
        }
    }

    public c T() {
        return c.forNumber(this.c);
    }

    public c V() {
        if (this.c == 1) {
            return (c) this.f2546a;
        }
        return c.P();
    }

    /* access modifiers changed from: private */
    public void f0(c value) {
        if (value != null) {
            this.f2546a = value;
            this.c = 1;
            return;
        }
        throw new NullPointerException();
    }

    public String S() {
        if (this.c == 2) {
            return (String) this.f2546a;
        }
        return "";
    }

    /* access modifiers changed from: private */
    public void d0(String value) {
        if (value != null) {
            this.c = 2;
            this.f2546a = value;
            return;
        }
        throw new NullPointerException();
    }

    public String X() {
        if (this.c == 5) {
            return (String) this.f2546a;
        }
        return "";
    }

    /* access modifiers changed from: private */
    public void h0(String value) {
        if (value != null) {
            this.c = 5;
            this.f2546a = value;
            return;
        }
        throw new NullPointerException();
    }

    public h U() {
        if (this.c == 6) {
            return (h) this.f2546a;
        }
        return h.P();
    }

    /* access modifiers changed from: private */
    public void e0(h.b builderForValue) {
        this.f2546a = builderForValue.q();
        this.c = 6;
    }

    public boolean Z() {
        return this.f2544a != null;
    }

    public f W() {
        f fVar = this.f2544a;
        return fVar == null ? f.O() : fVar;
    }

    /* access modifiers changed from: private */
    public void g0(f value) {
        if (value != null) {
            this.f2544a = value;
            return;
        }
        throw new NullPointerException();
    }

    public boolean Y() {
        return this.f2545a != null;
    }

    public m R() {
        m mVar = this.f2545a;
        return mVar == null ? m.O() : mVar;
    }

    /* access modifiers changed from: private */
    public void c0(m value) {
        if (value != null) {
            this.f2545a = value;
            return;
        }
        throw new NullPointerException();
    }

    public void b(g output) {
        if (this.c == 1) {
            output.l0(1, (c) this.f2546a);
        }
        if (this.c == 2) {
            output.r0(2, S());
        }
        if (this.f2544a != null) {
            output.l0(3, W());
        }
        if (this.f2545a != null) {
            output.l0(4, R());
        }
        if (this.c == 5) {
            output.r0(5, X());
        }
        if (this.c == 6) {
            output.l0(6, (h) this.f2546a);
        }
    }

    public int d() {
        int size = this.b;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (this.c == 1) {
            size2 = 0 + g.w(1, (c) this.f2546a);
        }
        if (this.c == 2) {
            size2 += g.D(2, S());
        }
        if (this.f2544a != null) {
            size2 += g.w(3, W());
        }
        if (this.f2545a != null) {
            size2 += g.w(4, R());
        }
        if (this.c == 5) {
            size2 += g.D(5, X());
        }
        if (this.c == 6) {
            size2 += g.w(6, (h) this.f2546a);
        }
        this.b = size2;
        return size2;
    }

    public static b a0() {
        return (b) a.a();
    }

    public static final class b extends i.b<r, b> implements h10 {
        /* synthetic */ b(a x0) {
            this();
        }

        private b() {
            super(r.a);
        }

        public b A(c value) {
            s();
            ((r) this.b).f0(value);
            return this;
        }

        public b y(String value) {
            s();
            ((r) this.b).d0(value);
            return this;
        }

        public b D(String value) {
            s();
            ((r) this.b).h0(value);
            return this;
        }

        public b z(h.b builderForValue) {
            s();
            ((r) this.b).e0(builderForValue);
            return this;
        }

        public b B(f value) {
            s();
            ((r) this.b).g0(value);
            return this;
        }

        public b x(m value) {
            s();
            ((r) this.b).c0(value);
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
                iArr2[c.UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                a[c.DELETE.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                a[c.VERIFY.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                a[c.TRANSFORM.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                a[c.OPERATION_NOT_SET.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Object p(i.g method, Object arg0, Object arg1) {
        int i;
        boolean z = true;
        switch (a.b[method.ordinal()]) {
            case 1:
                return new r();
            case 2:
                return a;
            case 3:
                return null;
            case 4:
                return new b((a) null);
            case 5:
                i.h visitor = (i.h) arg0;
                r other = (r) arg1;
                this.f2544a = (f) visitor.m(this.f2544a, other.f2544a);
                this.f2545a = (m) visitor.m(this.f2545a, other.f2545a);
                switch (a.a[other.T().ordinal()]) {
                    case 1:
                        if (this.c != 1) {
                            z = false;
                        }
                        this.f2546a = visitor.i(z, this.f2546a, other.f2546a);
                        break;
                    case 2:
                        if (this.c != 2) {
                            z = false;
                        }
                        this.f2546a = visitor.d(z, this.f2546a, other.f2546a);
                        break;
                    case 3:
                        if (this.c != 5) {
                            z = false;
                        }
                        this.f2546a = visitor.d(z, this.f2546a, other.f2546a);
                        break;
                    case 4:
                        if (this.c != 6) {
                            z = false;
                        }
                        this.f2546a = visitor.i(z, this.f2546a, other.f2546a);
                        break;
                    case 5:
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
                            case 10:
                                c.b subBuilder = null;
                                if (this.c == 1) {
                                    subBuilder = (c.b) ((c) this.f2546a).a();
                                }
                                p u = input.u(c.X(), extensionRegistry);
                                this.f2546a = u;
                                if (subBuilder != null) {
                                    subBuilder.w((c) u);
                                    this.f2546a = subBuilder.f();
                                }
                                this.c = 1;
                                break;
                            case 18:
                                String s = input.I();
                                this.c = 2;
                                this.f2546a = s;
                                break;
                            case 26:
                                f.b subBuilder2 = null;
                                f fVar = this.f2544a;
                                if (fVar != null) {
                                    subBuilder2 = (f.b) fVar.a();
                                }
                                f fVar2 = (f) input.u(f.T(), extensionRegistry);
                                this.f2544a = fVar2;
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.w(fVar2);
                                    this.f2544a = (f) subBuilder2.f();
                                    break;
                                }
                            case 34:
                                m.b subBuilder3 = null;
                                m mVar = this.f2545a;
                                if (mVar != null) {
                                    subBuilder3 = (m.b) mVar.a();
                                }
                                m mVar2 = (m) input.u(m.S(), extensionRegistry);
                                this.f2545a = mVar2;
                                if (subBuilder3 == null) {
                                    break;
                                } else {
                                    subBuilder3.w(mVar2);
                                    this.f2545a = (m) subBuilder3.f();
                                    break;
                                }
                            case 42:
                                String s2 = input.I();
                                this.c = 5;
                                this.f2546a = s2;
                                break;
                            case 50:
                                h.b subBuilder4 = null;
                                if (this.c == 6) {
                                    subBuilder4 = (h.b) ((h) this.f2546a).a();
                                }
                                p u2 = input.u(h.T(), extensionRegistry);
                                this.f2546a = u2;
                                if (subBuilder4 != null) {
                                    subBuilder4.w((h) u2);
                                    this.f2546a = subBuilder4.f();
                                }
                                this.c = 6;
                                break;
                            default:
                                if (input.P(tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                    } catch (com.google.protobuf.m e) {
                        throw new RuntimeException(e.i(this));
                    } catch (IOException e2) {
                        throw new RuntimeException(new com.google.protobuf.m(e2.getMessage()).i(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (f2543a == null) {
                    synchronized (r.class) {
                        if (f2543a == null) {
                            f2543a = new i.c(a);
                        }
                    }
                }
                return f2543a;
            default:
                throw new UnsupportedOperationException();
        }
        return a;
    }

    static {
        r rVar = new r();
        a = rVar;
        rVar.x();
    }

    public static n50<r> b0() {
        return a.h();
    }
}
