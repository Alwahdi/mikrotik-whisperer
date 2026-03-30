package defpackage;

import com.google.protobuf.f;
import com.google.protobuf.g;
import com.google.protobuf.i;
import com.google.protobuf.m;
import java.io.IOException;

/* renamed from: qw  reason: default package */
public final class qw extends i<qw, b> implements h10 {
    private static volatile n50<qw> a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public static final qw f4866a;

    /* renamed from: a  reason: collision with other field name */
    private double f4867a;
    private double b;

    private qw() {
    }

    public double O() {
        return this.f4867a;
    }

    /* access modifiers changed from: private */
    public void S(double value) {
        this.f4867a = value;
    }

    public double P() {
        return this.b;
    }

    /* access modifiers changed from: private */
    public void T(double value) {
        this.b = value;
    }

    public void b(g output) {
        double d = this.f4867a;
        if (d != 0.0d) {
            output.X(1, d);
        }
        double d2 = this.b;
        if (d2 != 0.0d) {
            output.X(2, d2);
        }
    }

    public int d() {
        int size = this.b;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        double d = this.f4867a;
        if (d != 0.0d) {
            size2 = 0 + g.j(1, d);
        }
        double d2 = this.b;
        if (d2 != 0.0d) {
            size2 += g.j(2, d2);
        }
        this.b = size2;
        return size2;
    }

    public static b Q() {
        return (b) f4866a.a();
    }

    /* renamed from: qw$b */
    public static final class b extends i.b<qw, b> implements h10 {
        /* synthetic */ b(a x0) {
            this();
        }

        private b() {
            super(qw.f4866a);
        }

        public b x(double value) {
            s();
            ((qw) this.b).S(value);
            return this;
        }

        public b y(double value) {
            s();
            ((qw) this.b).T(value);
            return this;
        }
    }

    /* renamed from: qw$a */
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
                return new qw();
            case 2:
                return f4866a;
            case 3:
                return null;
            case 4:
                return new b((a) null);
            case 5:
                i.h visitor = (i.h) arg0;
                qw other = (qw) arg1;
                double d = this.f4867a;
                boolean z = d != 0.0d;
                double d2 = other.f4867a;
                this.f4867a = visitor.r(z, d, d2 != 0.0d, d2);
                double d3 = this.b;
                boolean z2 = d3 != 0.0d;
                double d4 = other.b;
                this.b = visitor.r(z2, d3, d4 != 0.0d, d4);
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
                            case 9:
                                this.f4867a = input.n();
                                break;
                            case 17:
                                this.b = input.n();
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
                if (a == null) {
                    synchronized (qw.class) {
                        if (a == null) {
                            a = new i.c(f4866a);
                        }
                    }
                }
                return a;
            default:
                throw new UnsupportedOperationException();
        }
        return f4866a;
    }

    static {
        qw qwVar = new qw();
        f4866a = qwVar;
        qwVar.x();
    }

    public static qw N() {
        return f4866a;
    }

    public static n50<qw> R() {
        return f4866a.h();
    }
}
