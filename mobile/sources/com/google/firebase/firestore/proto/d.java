package com.google.firebase.firestore.proto;

import com.google.protobuf.f;
import com.google.protobuf.g;
import com.google.protobuf.i;
import com.google.protobuf.m;
import com.google.protobuf.v;
import java.io.IOException;

public final class d extends i<d, b> implements h10 {
    /* access modifiers changed from: private */
    public static final d a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<d> f2297a;

    /* renamed from: a  reason: collision with other field name */
    private v f2298a;

    /* renamed from: a  reason: collision with other field name */
    private String f2299a = "";

    private d() {
    }

    public String O() {
        return this.f2299a;
    }

    /* access modifiers changed from: private */
    public void S(String value) {
        if (value != null) {
            this.f2299a = value;
            return;
        }
        throw new NullPointerException();
    }

    public v P() {
        v vVar = this.f2298a;
        return vVar == null ? v.N() : vVar;
    }

    /* access modifiers changed from: private */
    public void T(v value) {
        if (value != null) {
            this.f2298a = value;
            return;
        }
        throw new NullPointerException();
    }

    public void b(g output) {
        if (!this.f2299a.isEmpty()) {
            output.r0(1, O());
        }
        if (this.f2298a != null) {
            output.l0(2, P());
        }
    }

    public int d() {
        int size = this.b;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.f2299a.isEmpty()) {
            size2 = 0 + g.D(1, O());
        }
        if (this.f2298a != null) {
            size2 += g.w(2, P());
        }
        this.b = size2;
        return size2;
    }

    public static b Q() {
        return (b) a.a();
    }

    public static final class b extends i.b<d, b> implements h10 {
        /* synthetic */ b(a x0) {
            this();
        }

        private b() {
            super(d.a);
        }

        public b x(String value) {
            s();
            ((d) this.b).S(value);
            return this;
        }

        public b y(v value) {
            s();
            ((d) this.b).T(value);
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
                return new d();
            case 2:
                return a;
            case 3:
                return null;
            case 4:
                return new b((a) null);
            case 5:
                i.h visitor = (i.h) arg0;
                d other = (d) arg1;
                this.f2299a = visitor.l(!this.f2299a.isEmpty(), this.f2299a, !other.f2299a.isEmpty(), other.f2299a);
                this.f2298a = (v) visitor.m(this.f2298a, other.f2298a);
                i.f fVar = i.f.a;
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
                                this.f2299a = input.I();
                                break;
                            case 18:
                                v.b subBuilder = null;
                                v vVar = this.f2298a;
                                if (vVar != null) {
                                    subBuilder = (v.b) vVar.a();
                                }
                                v vVar2 = (v) input.u(v.R(), extensionRegistry);
                                this.f2298a = vVar2;
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.w(vVar2);
                                    this.f2298a = (v) subBuilder.f();
                                    break;
                                }
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
                if (f2297a == null) {
                    synchronized (d.class) {
                        if (f2297a == null) {
                            f2297a = new i.c(a);
                        }
                    }
                }
                return f2297a;
            default:
                throw new UnsupportedOperationException();
        }
        return a;
    }

    static {
        d dVar = new d();
        a = dVar;
        dVar.x();
    }

    public static d N() {
        return a;
    }

    public static n50<d> R() {
        return a.h();
    }
}
