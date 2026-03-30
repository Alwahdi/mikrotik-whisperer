package com.google.firestore.v1;

import com.google.firestore.v1.o;
import com.google.protobuf.f;
import com.google.protobuf.g;
import com.google.protobuf.i;
import com.google.protobuf.l;
import com.google.protobuf.m;
import com.google.protobuf.n;
import com.google.protobuf.o;
import com.google.protobuf.p;
import com.google.protobuf.z;
import java.io.IOException;
import java.util.Map;

public final class j extends i<j, b> implements h10 {
    /* access modifiers changed from: private */
    public static final j a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<j> f2493a;

    /* renamed from: a  reason: collision with other field name */
    private o<String, String> f2494a = o.c();

    /* renamed from: a  reason: collision with other field name */
    private Object f2495a;

    /* renamed from: a  reason: collision with other field name */
    private String f2496a = "";
    private int c;
    private int d = 0;

    private j() {
    }

    public enum d implements l.a {
        ADD_TARGET(2),
        REMOVE_TARGET(3),
        TARGETCHANGE_NOT_SET(0);
        
        private final int value;

        private d(int value2) {
            this.value = value2;
        }

        @Deprecated
        public static d valueOf(int value2) {
            return forNumber(value2);
        }

        public static d forNumber(int value2) {
            switch (value2) {
                case 0:
                    return TARGETCHANGE_NOT_SET;
                case 2:
                    return ADD_TARGET;
                case 3:
                    return REMOVE_TARGET;
                default:
                    return null;
            }
        }

        public int getNumber() {
            return this.value;
        }
    }

    public d S() {
        return d.forNumber(this.d);
    }

    public String P() {
        return this.f2496a;
    }

    /* access modifiers changed from: private */
    public void X(String value) {
        if (value != null) {
            this.f2496a = value;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void W(o value) {
        if (value != null) {
            this.f2495a = value;
            this.d = 2;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void Y(int value) {
        this.d = 3;
        this.f2495a = Integer.valueOf(value);
    }

    private static final class c {
        static final n<String, String> a;

        static {
            z.b bVar = z.b.STRING;
            a = n.c(bVar, "", bVar, "");
        }
    }

    private o<String, String> T() {
        return this.f2494a;
    }

    private o<String, String> U() {
        if (!this.f2494a.i()) {
            this.f2494a = this.f2494a.l();
        }
        return this.f2494a;
    }

    /* access modifiers changed from: private */
    public Map<String, String> R() {
        return U();
    }

    public void b(g output) {
        if (!this.f2496a.isEmpty()) {
            output.r0(1, P());
        }
        if (this.d == 2) {
            output.l0(2, (o) this.f2495a);
        }
        if (this.d == 3) {
            output.h0(3, ((Integer) this.f2495a).intValue());
        }
        for (Map.Entry<String, String> entry : T().entrySet()) {
            c.a.f(output, 4, entry.getKey(), entry.getValue());
        }
    }

    public int d() {
        int size = this.b;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.f2496a.isEmpty()) {
            size2 = 0 + g.D(1, P());
        }
        if (this.d == 2) {
            size2 += g.w(2, (o) this.f2495a);
        }
        if (this.d == 3) {
            size2 += g.r(3, ((Integer) this.f2495a).intValue());
        }
        for (Map.Entry<String, String> entry : T().entrySet()) {
            size2 += c.a.a(4, entry.getKey(), entry.getValue());
        }
        this.b = size2;
        return size2;
    }

    public static b V() {
        return (b) a.a();
    }

    public static final class b extends i.b<j, b> implements h10 {
        /* synthetic */ b(a x0) {
            this();
        }

        private b() {
            super(j.a);
        }

        public b z(String value) {
            s();
            ((j) this.b).X(value);
            return this;
        }

        public b y(o value) {
            s();
            ((j) this.b).W(value);
            return this;
        }

        public b A(int value) {
            s();
            ((j) this.b).Y(value);
            return this;
        }

        public b x(Map<String, String> values) {
            s();
            ((j) this.b).R().putAll(values);
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
            int[] iArr2 = new int[d.values().length];
            a = iArr2;
            try {
                iArr2[d.ADD_TARGET.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                a[d.REMOVE_TARGET.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                a[d.TARGETCHANGE_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Object p(i.g method, Object arg0, Object arg1) {
        switch (a.b[method.ordinal()]) {
            case 1:
                return new j();
            case 2:
                return a;
            case 3:
                this.f2494a.j();
                return null;
            case 4:
                return new b((a) null);
            case 5:
                i.h visitor = (i.h) arg0;
                j other = (j) arg1;
                boolean z = true;
                this.f2496a = visitor.l(!this.f2496a.isEmpty(), this.f2496a, !other.f2496a.isEmpty(), other.f2496a);
                this.f2494a = visitor.a(this.f2494a, other.T());
                switch (a.a[other.S().ordinal()]) {
                    case 1:
                        if (this.d != 2) {
                            z = false;
                        }
                        this.f2495a = visitor.i(z, this.f2495a, other.f2495a);
                        break;
                    case 2:
                        if (this.d != 3) {
                            z = false;
                        }
                        this.f2495a = visitor.o(z, this.f2495a, other.f2495a);
                        break;
                    case 3:
                        if (this.d == 0) {
                            z = false;
                        }
                        visitor.s(z);
                        break;
                }
                if (visitor == i.f.a) {
                    int i = other.d;
                    if (i != 0) {
                        this.d = i;
                    }
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
                            case 10:
                                this.f2496a = input.I();
                                break;
                            case 18:
                                o.b subBuilder = null;
                                if (this.d == 2) {
                                    subBuilder = (o.b) ((o) this.f2495a).a();
                                }
                                p u = input.u(o.S(), extensionRegistry);
                                this.f2495a = u;
                                if (subBuilder != null) {
                                    subBuilder.w((o) u);
                                    this.f2495a = subBuilder.f();
                                }
                                this.d = 2;
                                break;
                            case 24:
                                this.d = 3;
                                this.f2495a = Integer.valueOf(input.s());
                                break;
                            case 34:
                                if (!this.f2494a.i()) {
                                    this.f2494a = this.f2494a.l();
                                }
                                c.a.e(this.f2494a, input, extensionRegistry);
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
                if (f2493a == null) {
                    synchronized (j.class) {
                        if (f2493a == null) {
                            f2493a = new i.c(a);
                        }
                    }
                }
                return f2493a;
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

    public static j Q() {
        return a;
    }
}
