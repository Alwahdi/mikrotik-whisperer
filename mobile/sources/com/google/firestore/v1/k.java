package com.google.firestore.v1;

import com.google.firestore.v1.d;
import com.google.firestore.v1.e;
import com.google.firestore.v1.g;
import com.google.firestore.v1.i;
import com.google.firestore.v1.p;
import com.google.protobuf.f;
import com.google.protobuf.g;
import com.google.protobuf.i;
import com.google.protobuf.l;
import com.google.protobuf.m;
import java.io.IOException;

public final class k extends i<k, b> implements h10 {
    /* access modifiers changed from: private */
    public static final k a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<k> f2497a;

    /* renamed from: a  reason: collision with other field name */
    private Object f2498a;
    private int c = 0;

    private k() {
    }

    public enum c implements l.a {
        TARGET_CHANGE(2),
        DOCUMENT_CHANGE(3),
        DOCUMENT_DELETE(4),
        DOCUMENT_REMOVE(6),
        FILTER(5),
        RESPONSETYPE_NOT_SET(0);
        
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
                    return RESPONSETYPE_NOT_SET;
                case 2:
                    return TARGET_CHANGE;
                case 3:
                    return DOCUMENT_CHANGE;
                case 4:
                    return DOCUMENT_DELETE;
                case 5:
                    return FILTER;
                case 6:
                    return DOCUMENT_REMOVE;
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

    public p R() {
        if (this.c == 2) {
            return (p) this.f2498a;
        }
        return p.M();
    }

    public d M() {
        if (this.c == 3) {
            return (d) this.f2498a;
        }
        return d.L();
    }

    public e N() {
        if (this.c == 4) {
            return (e) this.f2498a;
        }
        return e.L();
    }

    public g O() {
        if (this.c == 6) {
            return (g) this.f2498a;
        }
        return g.L();
    }

    public i P() {
        if (this.c == 5) {
            return (i) this.f2498a;
        }
        return i.M();
    }

    public void b(g output) {
        if (this.c == 2) {
            output.l0(2, (p) this.f2498a);
        }
        if (this.c == 3) {
            output.l0(3, (d) this.f2498a);
        }
        if (this.c == 4) {
            output.l0(4, (e) this.f2498a);
        }
        if (this.c == 5) {
            output.l0(5, (i) this.f2498a);
        }
        if (this.c == 6) {
            output.l0(6, (g) this.f2498a);
        }
    }

    public int d() {
        int size = this.b;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (this.c == 2) {
            size2 = 0 + g.w(2, (p) this.f2498a);
        }
        if (this.c == 3) {
            size2 += g.w(3, (d) this.f2498a);
        }
        if (this.c == 4) {
            size2 += g.w(4, (e) this.f2498a);
        }
        if (this.c == 5) {
            size2 += g.w(5, (i) this.f2498a);
        }
        if (this.c == 6) {
            size2 += g.w(6, (g) this.f2498a);
        }
        this.b = size2;
        return size2;
    }

    public static final class b extends i.b<k, b> implements h10 {
        /* synthetic */ b(a x0) {
            this();
        }

        private b() {
            super(k.a);
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
                iArr2[c.TARGET_CHANGE.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                a[c.DOCUMENT_CHANGE.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                a[c.DOCUMENT_DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                a[c.DOCUMENT_REMOVE.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                a[c.FILTER.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                a[c.RESPONSETYPE_NOT_SET.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Object p(i.g method, Object arg0, Object arg1) {
        int i;
        switch (a.b[method.ordinal()]) {
            case 1:
                return new k();
            case 2:
                return a;
            case 3:
                return null;
            case 4:
                return new b((a) null);
            case 5:
                i.h visitor = (i.h) arg0;
                k other = (k) arg1;
                boolean z = true;
                switch (a.a[other.Q().ordinal()]) {
                    case 1:
                        if (this.c != 2) {
                            z = false;
                        }
                        this.f2498a = visitor.i(z, this.f2498a, other.f2498a);
                        break;
                    case 2:
                        if (this.c != 3) {
                            z = false;
                        }
                        this.f2498a = visitor.i(z, this.f2498a, other.f2498a);
                        break;
                    case 3:
                        if (this.c != 4) {
                            z = false;
                        }
                        this.f2498a = visitor.i(z, this.f2498a, other.f2498a);
                        break;
                    case 4:
                        if (this.c != 6) {
                            z = false;
                        }
                        this.f2498a = visitor.i(z, this.f2498a, other.f2498a);
                        break;
                    case 5:
                        if (this.c != 5) {
                            z = false;
                        }
                        this.f2498a = visitor.i(z, this.f2498a, other.f2498a);
                        break;
                    case 6:
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
                            case 18:
                                p.b subBuilder = null;
                                if (this.c == 2) {
                                    subBuilder = (p.b) ((p) this.f2498a).a();
                                }
                                com.google.protobuf.p u = input.u(p.S(), extensionRegistry);
                                this.f2498a = u;
                                if (subBuilder != null) {
                                    subBuilder.w((p) u);
                                    this.f2498a = subBuilder.f();
                                }
                                this.c = 2;
                                break;
                            case 26:
                                d.b subBuilder2 = null;
                                if (this.c == 3) {
                                    subBuilder2 = (d.b) ((d) this.f2498a).a();
                                }
                                com.google.protobuf.p u2 = input.u(d.P(), extensionRegistry);
                                this.f2498a = u2;
                                if (subBuilder2 != null) {
                                    subBuilder2.w((d) u2);
                                    this.f2498a = subBuilder2.f();
                                }
                                this.c = 3;
                                break;
                            case 34:
                                e.b subBuilder3 = null;
                                if (this.c == 4) {
                                    subBuilder3 = (e.b) ((e) this.f2498a).a();
                                }
                                com.google.protobuf.p u3 = input.u(e.P(), extensionRegistry);
                                this.f2498a = u3;
                                if (subBuilder3 != null) {
                                    subBuilder3.w((e) u3);
                                    this.f2498a = subBuilder3.f();
                                }
                                this.c = 4;
                                break;
                            case 42:
                                i.b subBuilder4 = null;
                                if (this.c == 5) {
                                    subBuilder4 = (i.b) ((i) this.f2498a).a();
                                }
                                com.google.protobuf.p u4 = input.u(i.O(), extensionRegistry);
                                this.f2498a = u4;
                                if (subBuilder4 != null) {
                                    subBuilder4.w((i) u4);
                                    this.f2498a = subBuilder4.f();
                                }
                                this.c = 5;
                                break;
                            case 50:
                                g.b subBuilder5 = null;
                                if (this.c == 6) {
                                    subBuilder5 = (g.b) ((g) this.f2498a).a();
                                }
                                com.google.protobuf.p u5 = input.u(g.P(), extensionRegistry);
                                this.f2498a = u5;
                                if (subBuilder5 != null) {
                                    subBuilder5.w((g) u5);
                                    this.f2498a = subBuilder5.f();
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
                if (f2497a == null) {
                    synchronized (k.class) {
                        if (f2497a == null) {
                            f2497a = new i.c(a);
                        }
                    }
                }
                return f2497a;
            default:
                throw new UnsupportedOperationException();
        }
        return a;
    }

    static {
        k kVar = new k();
        a = kVar;
        kVar.x();
    }

    public static k L() {
        return a;
    }
}
