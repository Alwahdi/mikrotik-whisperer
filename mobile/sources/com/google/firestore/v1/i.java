package com.google.firestore.v1;

import com.google.protobuf.f;
import com.google.protobuf.g;
import com.google.protobuf.i;
import com.google.protobuf.m;
import java.io.IOException;

public final class i extends com.google.protobuf.i<i, b> implements h10 {
    /* access modifiers changed from: private */
    public static final i a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<i> f2492a;
    private int c;
    private int d;

    private i() {
    }

    public int N() {
        return this.c;
    }

    public int L() {
        return this.d;
    }

    public void b(g output) {
        int i = this.c;
        if (i != 0) {
            output.h0(1, i);
        }
        int i2 = this.d;
        if (i2 != 0) {
            output.h0(2, i2);
        }
    }

    public int d() {
        int size = this.b;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        int i = this.c;
        if (i != 0) {
            size2 = 0 + g.r(1, i);
        }
        int i2 = this.d;
        if (i2 != 0) {
            size2 += g.r(2, i2);
        }
        this.b = size2;
        return size2;
    }

    public static final class b extends i.b<i, b> implements h10 {
        /* synthetic */ b(a x0) {
            this();
        }

        private b() {
            super(i.a);
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
                return new i();
            case 2:
                return a;
            case 3:
                return null;
            case 4:
                return new b((a) null);
            case 5:
                i.h visitor = (i.h) arg0;
                i other = (i) arg1;
                int i = this.c;
                boolean z = true;
                boolean z2 = i != 0;
                int i2 = other.c;
                this.c = visitor.p(z2, i, i2 != 0, i2);
                int i3 = this.d;
                boolean z3 = i3 != 0;
                int i4 = other.d;
                if (i4 == 0) {
                    z = false;
                }
                this.d = visitor.p(z3, i3, z, i4);
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
                                this.c = input.s();
                                break;
                            case 16:
                                this.d = input.s();
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
                if (f2492a == null) {
                    synchronized (i.class) {
                        if (f2492a == null) {
                            f2492a = new i.c(a);
                        }
                    }
                }
                return f2492a;
            default:
                throw new UnsupportedOperationException();
        }
        return a;
    }

    static {
        i iVar = new i();
        a = iVar;
        iVar.x();
    }

    public static i M() {
        return a;
    }

    public static n50<i> O() {
        return a.h();
    }
}
