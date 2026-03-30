package defpackage;

import com.google.firestore.v1.r;
import com.google.protobuf.e;
import com.google.protobuf.f;
import com.google.protobuf.g;
import com.google.protobuf.i;
import com.google.protobuf.l;
import com.google.protobuf.m;
import com.google.protobuf.v;
import java.io.IOException;

/* renamed from: dw0  reason: default package */
public final class dw0 extends i<dw0, b> implements h10 {
    /* access modifiers changed from: private */
    public static final dw0 a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<dw0> f2825a;

    /* renamed from: a  reason: collision with other field name */
    private l.d<r> f2826a = i.s();

    /* renamed from: a  reason: collision with other field name */
    private v f2827a;
    private l.d<r> b = i.s();
    private int c;
    private int d;

    private dw0() {
    }

    public int V() {
        return this.d;
    }

    /* access modifiers changed from: private */
    public void c0(int value) {
        this.d = value;
    }

    public int Y() {
        return this.f2826a.size();
    }

    public r X(int index) {
        return this.f2826a.get(index);
    }

    private void S() {
        if (!this.f2826a.e()) {
            this.f2826a = i.z(this.f2826a);
        }
    }

    /* access modifiers changed from: private */
    public void Q(r value) {
        if (value != null) {
            S();
            this.f2826a.add(value);
            return;
        }
        throw new NullPointerException();
    }

    public v W() {
        v vVar = this.f2827a;
        return vVar == null ? v.N() : vVar;
    }

    /* access modifiers changed from: private */
    public void d0(v value) {
        if (value != null) {
            this.f2827a = value;
            return;
        }
        throw new NullPointerException();
    }

    public int U() {
        return this.b.size();
    }

    public r T(int index) {
        return this.b.get(index);
    }

    private void R() {
        if (!this.b.e()) {
            this.b = i.z(this.b);
        }
    }

    /* access modifiers changed from: private */
    public void P(r value) {
        if (value != null) {
            R();
            this.b.add(value);
            return;
        }
        throw new NullPointerException();
    }

    public void b(g output) {
        int i = this.d;
        if (i != 0) {
            output.h0(1, i);
        }
        for (int i2 = 0; i2 < this.f2826a.size(); i2++) {
            output.l0(2, this.f2826a.get(i2));
        }
        if (this.f2827a != null) {
            output.l0(3, W());
        }
        for (int i3 = 0; i3 < this.b.size(); i3++) {
            output.l0(4, this.b.get(i3));
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
        for (int i2 = 0; i2 < this.f2826a.size(); i2++) {
            size2 += g.w(2, this.f2826a.get(i2));
        }
        if (this.f2827a != null) {
            size2 += g.w(3, W());
        }
        for (int i3 = 0; i3 < this.b.size(); i3++) {
            size2 += g.w(4, this.b.get(i3));
        }
        this.b = size2;
        return size2;
    }

    public static dw0 a0(e data) {
        return (dw0) i.B(a, data);
    }

    public static dw0 b0(byte[] data) {
        return (dw0) i.E(a, data);
    }

    public static b Z() {
        return (b) a.a();
    }

    /* renamed from: dw0$b */
    public static final class b extends i.b<dw0, b> implements h10 {
        /* synthetic */ b(a x0) {
            this();
        }

        private b() {
            super(dw0.a);
        }

        public b z(int value) {
            s();
            ((dw0) this.b).c0(value);
            return this;
        }

        public b y(r value) {
            s();
            ((dw0) this.b).Q(value);
            return this;
        }

        public b A(v value) {
            s();
            ((dw0) this.b).d0(value);
            return this;
        }

        public b x(r value) {
            s();
            ((dw0) this.b).P(value);
            return this;
        }
    }

    /* renamed from: dw0$a */
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
                return new dw0();
            case 2:
                return a;
            case 3:
                this.f2826a.i();
                this.b.i();
                return null;
            case 4:
                return new b((a) null);
            case 5:
                i.h visitor = (i.h) arg0;
                dw0 other = (dw0) arg1;
                int i = this.d;
                boolean z = true;
                boolean z2 = i != 0;
                int i2 = other.d;
                if (i2 == 0) {
                    z = false;
                }
                this.d = visitor.p(z2, i, z, i2);
                this.f2826a = visitor.q(this.f2826a, other.f2826a);
                this.f2827a = (v) visitor.m(this.f2827a, other.f2827a);
                this.b = visitor.q(this.b, other.b);
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
                                if (!this.f2826a.e()) {
                                    this.f2826a = i.z(this.f2826a);
                                }
                                this.f2826a.add((r) input.u(r.b0(), extensionRegistry));
                                break;
                            case 26:
                                v.b subBuilder = null;
                                v vVar = this.f2827a;
                                if (vVar != null) {
                                    subBuilder = (v.b) vVar.a();
                                }
                                v vVar2 = (v) input.u(v.R(), extensionRegistry);
                                this.f2827a = vVar2;
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.w(vVar2);
                                    this.f2827a = (v) subBuilder.f();
                                    break;
                                }
                            case 34:
                                if (!this.b.e()) {
                                    this.b = i.z(this.b);
                                }
                                this.b.add((r) input.u(r.b0(), extensionRegistry));
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
                if (f2825a == null) {
                    synchronized (dw0.class) {
                        if (f2825a == null) {
                            f2825a = new i.c(a);
                        }
                    }
                }
                return f2825a;
            default:
                throw new UnsupportedOperationException();
        }
        return a;
    }

    static {
        dw0 dw0 = new dw0();
        a = dw0;
        dw0.x();
    }
}
