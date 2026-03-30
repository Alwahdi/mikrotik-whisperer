package com.google.firestore.v1;

import com.google.protobuf.f;
import com.google.protobuf.g;
import com.google.protobuf.i;
import com.google.protobuf.l;
import com.google.protobuf.p;
import com.google.protobuf.v;
import java.io.IOException;

public final class m extends i<m, b> implements h10 {
    /* access modifiers changed from: private */
    public static final m a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<m> f2501a;

    /* renamed from: a  reason: collision with other field name */
    private Object f2502a;
    private int c = 0;

    private m() {
    }

    public enum c implements l.a {
        EXISTS(1),
        UPDATE_TIME(2),
        CONDITIONTYPE_NOT_SET(0);
        
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
                    return CONDITIONTYPE_NOT_SET;
                case 1:
                    return EXISTS;
                case 2:
                    return UPDATE_TIME;
                default:
                    return null;
            }
        }

        public int getNumber() {
            return this.value;
        }
    }

    public c N() {
        return c.forNumber(this.c);
    }

    public boolean P() {
        if (this.c == 1) {
            return ((Boolean) this.f2502a).booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void T(boolean value) {
        this.c = 1;
        this.f2502a = Boolean.valueOf(value);
    }

    public v Q() {
        if (this.c == 2) {
            return (v) this.f2502a;
        }
        return v.N();
    }

    /* access modifiers changed from: private */
    public void U(v value) {
        if (value != null) {
            this.f2502a = value;
            this.c = 2;
            return;
        }
        throw new NullPointerException();
    }

    public void b(g output) {
        if (this.c == 1) {
            output.R(1, ((Boolean) this.f2502a).booleanValue());
        }
        if (this.c == 2) {
            output.l0(2, (v) this.f2502a);
        }
    }

    public int d() {
        int size = this.b;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (this.c == 1) {
            size2 = 0 + g.e(1, ((Boolean) this.f2502a).booleanValue());
        }
        if (this.c == 2) {
            size2 += g.w(2, (v) this.f2502a);
        }
        this.b = size2;
        return size2;
    }

    public static b R() {
        return (b) a.a();
    }

    public static final class b extends i.b<m, b> implements h10 {
        /* synthetic */ b(a x0) {
            this();
        }

        private b() {
            super(m.a);
        }

        public b x(boolean value) {
            s();
            ((m) this.b).T(value);
            return this;
        }

        public b y(v value) {
            s();
            ((m) this.b).U(value);
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
                iArr2[c.EXISTS.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                a[c.UPDATE_TIME.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                a[c.CONDITIONTYPE_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Object p(i.g method, Object arg0, Object arg1) {
        int i;
        boolean z = true;
        switch (a.b[method.ordinal()]) {
            case 1:
                return new m();
            case 2:
                return a;
            case 3:
                return null;
            case 4:
                return new b((a) null);
            case 5:
                i.h visitor = (i.h) arg0;
                m other = (m) arg1;
                switch (a.a[other.N().ordinal()]) {
                    case 1:
                        if (this.c != 1) {
                            z = false;
                        }
                        this.f2502a = visitor.k(z, this.f2502a, other.f2502a);
                        break;
                    case 2:
                        if (this.c != 2) {
                            z = false;
                        }
                        this.f2502a = visitor.i(z, this.f2502a, other.f2502a);
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
                                this.c = 1;
                                this.f2502a = Boolean.valueOf(input.l());
                                break;
                            case 18:
                                v.b subBuilder = null;
                                if (this.c == 2) {
                                    subBuilder = (v.b) ((v) this.f2502a).a();
                                }
                                p u = input.u(v.R(), extensionRegistry);
                                this.f2502a = u;
                                if (subBuilder != null) {
                                    subBuilder.w((v) u);
                                    this.f2502a = subBuilder.f();
                                }
                                this.c = 2;
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
                if (f2501a == null) {
                    synchronized (m.class) {
                        if (f2501a == null) {
                            f2501a = new i.c(a);
                        }
                    }
                }
                return f2501a;
            default:
                throw new UnsupportedOperationException();
        }
        return a;
    }

    static {
        m mVar = new m();
        a = mVar;
        mVar.x();
    }

    public static m O() {
        return a;
    }

    public static n50<m> S() {
        return a.h();
    }
}
