package com.google.protobuf;

import com.google.protobuf.i;
import java.io.IOException;

public final class v extends i<v, b> implements h10 {
    /* access modifiers changed from: private */
    public static final v a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<v> f2606a;

    /* renamed from: a  reason: collision with other field name */
    private long f2607a;
    private int c;

    private v() {
    }

    public long P() {
        return this.f2607a;
    }

    /* access modifiers changed from: private */
    public void T(long value) {
        this.f2607a = value;
    }

    public int O() {
        return this.c;
    }

    /* access modifiers changed from: private */
    public void S(int value) {
        this.c = value;
    }

    public void b(g output) {
        long j = this.f2607a;
        if (j != 0) {
            output.j0(1, j);
        }
        int i = this.c;
        if (i != 0) {
            output.h0(2, i);
        }
    }

    public int d() {
        int size = this.b;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        long j = this.f2607a;
        if (j != 0) {
            size2 = 0 + g.t(1, j);
        }
        int i = this.c;
        if (i != 0) {
            size2 += g.r(2, i);
        }
        this.b = size2;
        return size2;
    }

    public static b Q() {
        return (b) a.a();
    }

    public static final class b extends i.b<v, b> implements h10 {
        /* synthetic */ b(a x0) {
            this();
        }

        private b() {
            super(v.a);
        }

        public b y(long value) {
            s();
            ((v) this.b).T(value);
            return this;
        }

        public b x(int value) {
            s();
            ((v) this.b).S(value);
            return this;
        }
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[i.g.values().length];
            a = iArr;
            try {
                iArr[i.g.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[i.g.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[i.g.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[i.g.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[i.g.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[i.g.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[i.g.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                a[i.g.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Object p(i.g method, Object arg0, Object arg1) {
        switch (a.a[method.ordinal()]) {
            case 1:
                return new v();
            case 2:
                return a;
            case 3:
                return null;
            case 4:
                return new b((a) null);
            case 5:
                i.h visitor = (i.h) arg0;
                v other = (v) arg1;
                long j = this.f2607a;
                boolean z = true;
                boolean z2 = j != 0;
                long j2 = other.f2607a;
                this.f2607a = visitor.g(z2, j, j2 != 0, j2);
                int i = this.c;
                boolean z3 = i != 0;
                int i2 = other.c;
                if (i2 == 0) {
                    z = false;
                }
                this.c = visitor.p(z3, i, z, i2);
                i.f fVar = i.f.a;
                return this;
            case 6:
                f input = (f) arg0;
                fk fkVar = (fk) arg1;
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.J();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 8:
                                this.f2607a = input.t();
                                break;
                            case 16:
                                this.c = input.s();
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
                if (f2606a == null) {
                    synchronized (v.class) {
                        if (f2606a == null) {
                            f2606a = new i.c(a);
                        }
                    }
                }
                return f2606a;
            default:
                throw new UnsupportedOperationException();
        }
        return a;
    }

    static {
        v vVar = new v();
        a = vVar;
        vVar.x();
    }

    public static v N() {
        return a;
    }

    public static n50<v> R() {
        return a.h();
    }
}
