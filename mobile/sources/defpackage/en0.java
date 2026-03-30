package defpackage;

import com.google.protobuf.d;
import com.google.protobuf.f;
import com.google.protobuf.g;
import com.google.protobuf.i;
import com.google.protobuf.l;
import com.google.protobuf.m;
import java.io.IOException;

/* renamed from: en0  reason: default package */
public final class en0 extends i<en0, b> implements h10 {
    /* access modifiers changed from: private */
    public static final en0 a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<en0> f2918a;

    /* renamed from: a  reason: collision with other field name */
    private l.d<d> f2919a = i.s();

    /* renamed from: a  reason: collision with other field name */
    private String f2920a = "";
    private int c;
    private int d;

    private en0() {
    }

    public int L() {
        return this.d;
    }

    public String N() {
        return this.f2920a;
    }

    public void b(g output) {
        int i = this.d;
        if (i != 0) {
            output.h0(1, i);
        }
        if (!this.f2920a.isEmpty()) {
            output.r0(2, N());
        }
        for (int i2 = 0; i2 < this.f2919a.size(); i2++) {
            output.l0(3, this.f2919a.get(i2));
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
        if (!this.f2920a.isEmpty()) {
            size2 += g.D(2, N());
        }
        for (int i2 = 0; i2 < this.f2919a.size(); i2++) {
            size2 += g.w(3, this.f2919a.get(i2));
        }
        this.b = size2;
        return size2;
    }

    /* renamed from: en0$b */
    public static final class b extends i.b<en0, b> implements h10 {
        /* synthetic */ b(a x0) {
            this();
        }

        private b() {
            super(en0.a);
        }
    }

    /* renamed from: en0$a */
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
                return new en0();
            case 2:
                return a;
            case 3:
                this.f2919a.i();
                return null;
            case 4:
                return new b((a) null);
            case 5:
                i.h visitor = (i.h) arg0;
                en0 other = (en0) arg1;
                int i = this.d;
                boolean z = false;
                boolean z2 = i != 0;
                int i2 = other.d;
                if (i2 != 0) {
                    z = true;
                }
                this.d = visitor.p(z2, i, z, i2);
                this.f2920a = visitor.l(!this.f2920a.isEmpty(), this.f2920a, true ^ other.f2920a.isEmpty(), other.f2920a);
                this.f2919a = visitor.q(this.f2919a, other.f2919a);
                if (visitor == i.f.a) {
                    this.c |= other.c;
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
                                this.f2920a = input.I();
                                break;
                            case 26:
                                if (!this.f2919a.e()) {
                                    this.f2919a = i.z(this.f2919a);
                                }
                                this.f2919a.add((d) input.u(d.M(), extensionRegistry));
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
                if (f2918a == null) {
                    synchronized (en0.class) {
                        if (f2918a == null) {
                            f2918a = new i.c(a);
                        }
                    }
                }
                return f2918a;
            default:
                throw new UnsupportedOperationException();
        }
        return a;
    }

    static {
        en0 en0 = new en0();
        a = en0;
        en0.x();
    }

    public static en0 M() {
        return a;
    }

    public static n50<en0> O() {
        return a.h();
    }
}
