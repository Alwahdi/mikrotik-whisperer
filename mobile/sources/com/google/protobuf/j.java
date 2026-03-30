package com.google.protobuf;

import com.google.protobuf.i;
import java.io.IOException;

public final class j extends i<j, b> implements h10 {
    /* access modifiers changed from: private */
    public static final j a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<j> f2579a;
    private int c;

    private j() {
    }

    public int N() {
        return this.c;
    }

    /* access modifiers changed from: private */
    public void Q(int value) {
        this.c = value;
    }

    public void b(g output) {
        int i = this.c;
        if (i != 0) {
            output.h0(1, i);
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
        this.b = size2;
        return size2;
    }

    public static b O() {
        return (b) a.a();
    }

    public static final class b extends i.b<j, b> implements h10 {
        /* synthetic */ b(a x0) {
            this();
        }

        private b() {
            super(j.a);
        }

        public b x(int value) {
            s();
            ((j) this.b).Q(value);
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
                return new j();
            case 2:
                return a;
            case 3:
                return null;
            case 4:
                return new b((a) null);
            case 5:
                i.h visitor = (i.h) arg0;
                j other = (j) arg1;
                int i = this.c;
                boolean z = true;
                boolean z2 = i != 0;
                int i2 = other.c;
                if (i2 == 0) {
                    z = false;
                }
                this.c = visitor.p(z2, i, z, i2);
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
                if (f2579a == null) {
                    synchronized (j.class) {
                        if (f2579a == null) {
                            f2579a = new i.c(a);
                        }
                    }
                }
                return f2579a;
            default:
                throw new UnsupportedOperationException();
        }
        return a;
    }

    static {
        j jVar = new j();
        a = jVar;
        jVar.x();
    }

    public static j M() {
        return a;
    }

    public static n50<j> P() {
        return a.h();
    }
}
