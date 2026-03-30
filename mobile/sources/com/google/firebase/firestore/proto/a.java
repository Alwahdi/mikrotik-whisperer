package com.google.firebase.firestore.proto;

import com.google.firebase.firestore.proto.b;
import com.google.firebase.firestore.proto.d;
import com.google.firestore.v1.c;
import com.google.protobuf.f;
import com.google.protobuf.g;
import com.google.protobuf.i;
import com.google.protobuf.l;
import com.google.protobuf.m;
import com.google.protobuf.p;
import java.io.IOException;

public final class a extends i<a, b> implements h10 {
    /* access modifiers changed from: private */
    public static final a a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<a> f2286a;

    /* renamed from: a  reason: collision with other field name */
    private Object f2287a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f2288a;
    private int c = 0;

    private a() {
    }

    public enum c implements l.a {
        NO_DOCUMENT(1),
        DOCUMENT(2),
        UNKNOWN_DOCUMENT(3),
        DOCUMENTTYPE_NOT_SET(0);
        
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
                    return DOCUMENTTYPE_NOT_SET;
                case 1:
                    return NO_DOCUMENT;
                case 2:
                    return DOCUMENT;
                case 3:
                    return UNKNOWN_DOCUMENT;
                default:
                    return null;
            }
        }

        public int getNumber() {
            return this.value;
        }
    }

    public c Q() {
        return c.forNumber(this.c);
    }

    public b S() {
        if (this.c == 1) {
            return (b) this.f2287a;
        }
        return b.N();
    }

    /* access modifiers changed from: private */
    public void Y(b value) {
        if (value != null) {
            this.f2287a = value;
            this.c = 1;
            return;
        }
        throw new NullPointerException();
    }

    public com.google.firestore.v1.c P() {
        if (this.c == 2) {
            return (com.google.firestore.v1.c) this.f2287a;
        }
        return com.google.firestore.v1.c.P();
    }

    /* access modifiers changed from: private */
    public void W(com.google.firestore.v1.c value) {
        if (value != null) {
            this.f2287a = value;
            this.c = 2;
            return;
        }
        throw new NullPointerException();
    }

    public d T() {
        if (this.c == 3) {
            return (d) this.f2287a;
        }
        return d.N();
    }

    /* access modifiers changed from: private */
    public void Z(d value) {
        if (value != null) {
            this.f2287a = value;
            this.c = 3;
            return;
        }
        throw new NullPointerException();
    }

    public boolean R() {
        return this.f2288a;
    }

    /* access modifiers changed from: private */
    public void X(boolean value) {
        this.f2288a = value;
    }

    public void b(g output) {
        if (this.c == 1) {
            output.l0(1, (b) this.f2287a);
        }
        if (this.c == 2) {
            output.l0(2, (com.google.firestore.v1.c) this.f2287a);
        }
        if (this.c == 3) {
            output.l0(3, (d) this.f2287a);
        }
        boolean z = this.f2288a;
        if (z) {
            output.R(4, z);
        }
    }

    public int d() {
        int size = this.b;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (this.c == 1) {
            size2 = 0 + g.w(1, (b) this.f2287a);
        }
        if (this.c == 2) {
            size2 += g.w(2, (com.google.firestore.v1.c) this.f2287a);
        }
        if (this.c == 3) {
            size2 += g.w(3, (d) this.f2287a);
        }
        boolean z = this.f2288a;
        if (z) {
            size2 += g.e(4, z);
        }
        this.b = size2;
        return size2;
    }

    public static a V(byte[] data) {
        return (a) i.E(a, data);
    }

    public static b U() {
        return (b) a.a();
    }

    public static final class b extends i.b<a, b> implements h10 {
        /* synthetic */ b(C0022a x0) {
            this();
        }

        private b() {
            super(a.a);
        }

        public b z(b value) {
            s();
            ((a) this.b).Y(value);
            return this;
        }

        public b x(com.google.firestore.v1.c value) {
            s();
            ((a) this.b).W(value);
            return this;
        }

        public b A(d value) {
            s();
            ((a) this.b).Z(value);
            return this;
        }

        public b y(boolean value) {
            s();
            ((a) this.b).X(value);
            return this;
        }
    }

    /* renamed from: com.google.firebase.firestore.proto.a$a  reason: collision with other inner class name */
    static /* synthetic */ class C0022a {
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
                iArr2[c.NO_DOCUMENT.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                a[c.DOCUMENT.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                a[c.UNKNOWN_DOCUMENT.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                a[c.DOCUMENTTYPE_NOT_SET.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Object p(i.g method, Object arg0, Object arg1) {
        int i;
        boolean z = true;
        switch (C0022a.b[method.ordinal()]) {
            case 1:
                return new a();
            case 2:
                return a;
            case 3:
                return null;
            case 4:
                return new b((C0022a) null);
            case 5:
                i.h visitor = (i.h) arg0;
                a other = (a) arg1;
                boolean z2 = this.f2288a;
                boolean z3 = other.f2288a;
                this.f2288a = visitor.b(z2, z2, z3, z3);
                switch (C0022a.a[other.Q().ordinal()]) {
                    case 1:
                        if (this.c != 1) {
                            z = false;
                        }
                        this.f2287a = visitor.i(z, this.f2287a, other.f2287a);
                        break;
                    case 2:
                        if (this.c != 2) {
                            z = false;
                        }
                        this.f2287a = visitor.i(z, this.f2287a, other.f2287a);
                        break;
                    case 3:
                        if (this.c != 3) {
                            z = false;
                        }
                        this.f2287a = visitor.i(z, this.f2287a, other.f2287a);
                        break;
                    case 4:
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
                                b.C0023b subBuilder = null;
                                if (this.c == 1) {
                                    subBuilder = (b.C0023b) ((b) this.f2287a).a();
                                }
                                p u = input.u(b.R(), extensionRegistry);
                                this.f2287a = u;
                                if (subBuilder != null) {
                                    subBuilder.w((b) u);
                                    this.f2287a = subBuilder.f();
                                }
                                this.c = 1;
                                break;
                            case 18:
                                c.b subBuilder2 = null;
                                if (this.c == 2) {
                                    subBuilder2 = (c.b) ((com.google.firestore.v1.c) this.f2287a).a();
                                }
                                p u2 = input.u(com.google.firestore.v1.c.X(), extensionRegistry);
                                this.f2287a = u2;
                                if (subBuilder2 != null) {
                                    subBuilder2.w((com.google.firestore.v1.c) u2);
                                    this.f2287a = subBuilder2.f();
                                }
                                this.c = 2;
                                break;
                            case 26:
                                d.b subBuilder3 = null;
                                if (this.c == 3) {
                                    subBuilder3 = (d.b) ((d) this.f2287a).a();
                                }
                                p u3 = input.u(d.R(), extensionRegistry);
                                this.f2287a = u3;
                                if (subBuilder3 != null) {
                                    subBuilder3.w((d) u3);
                                    this.f2287a = subBuilder3.f();
                                }
                                this.c = 3;
                                break;
                            case 32:
                                this.f2288a = input.l();
                                break;
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
                if (f2286a == null) {
                    synchronized (a.class) {
                        if (f2286a == null) {
                            f2286a = new i.c(a);
                        }
                    }
                }
                return f2286a;
            default:
                throw new UnsupportedOperationException();
        }
        return a;
    }

    static {
        a aVar = new a();
        a = aVar;
        aVar.x();
    }
}
