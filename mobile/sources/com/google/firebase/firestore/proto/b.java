package com.google.firebase.firestore.proto;

import com.google.protobuf.f;
import com.google.protobuf.g;
import com.google.protobuf.i;
import com.google.protobuf.m;
import com.google.protobuf.v;
import java.io.IOException;

public final class b extends i<b, C0023b> implements h10 {
    /* access modifiers changed from: private */
    public static final b a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<b> f2289a;

    /* renamed from: a  reason: collision with other field name */
    private v f2290a;

    /* renamed from: a  reason: collision with other field name */
    private String f2291a = "";

    private b() {
    }

    public String O() {
        return this.f2291a;
    }

    /* access modifiers changed from: private */
    public void S(String value) {
        if (value != null) {
            this.f2291a = value;
            return;
        }
        throw new NullPointerException();
    }

    public v P() {
        v vVar = this.f2290a;
        return vVar == null ? v.N() : vVar;
    }

    /* access modifiers changed from: private */
    public void T(v value) {
        if (value != null) {
            this.f2290a = value;
            return;
        }
        throw new NullPointerException();
    }

    public void b(g output) {
        if (!this.f2291a.isEmpty()) {
            output.r0(1, O());
        }
        if (this.f2290a != null) {
            output.l0(2, P());
        }
    }

    public int d() {
        int size = this.b;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.f2291a.isEmpty()) {
            size2 = 0 + g.D(1, O());
        }
        if (this.f2290a != null) {
            size2 += g.w(2, P());
        }
        this.b = size2;
        return size2;
    }

    public static C0023b Q() {
        return (C0023b) a.a();
    }

    /* renamed from: com.google.firebase.firestore.proto.b$b  reason: collision with other inner class name */
    public static final class C0023b extends i.b<b, C0023b> implements h10 {
        /* synthetic */ C0023b(a x0) {
            this();
        }

        private C0023b() {
            super(b.a);
        }

        public C0023b x(String value) {
            s();
            ((b) this.b).S(value);
            return this;
        }

        public C0023b y(v value) {
            s();
            ((b) this.b).T(value);
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
                return new b();
            case 2:
                return a;
            case 3:
                return null;
            case 4:
                return new C0023b((a) null);
            case 5:
                i.h visitor = (i.h) arg0;
                b other = (b) arg1;
                this.f2291a = visitor.l(!this.f2291a.isEmpty(), this.f2291a, !other.f2291a.isEmpty(), other.f2291a);
                this.f2290a = (v) visitor.m(this.f2290a, other.f2290a);
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
                                this.f2291a = input.I();
                                break;
                            case 18:
                                v.b subBuilder = null;
                                v vVar = this.f2290a;
                                if (vVar != null) {
                                    subBuilder = (v.b) vVar.a();
                                }
                                v vVar2 = (v) input.u(v.R(), extensionRegistry);
                                this.f2290a = vVar2;
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.w(vVar2);
                                    this.f2290a = (v) subBuilder.f();
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
                if (f2289a == null) {
                    synchronized (b.class) {
                        if (f2289a == null) {
                            f2289a = new i.c(a);
                        }
                    }
                }
                return f2289a;
            default:
                throw new UnsupportedOperationException();
        }
        return a;
    }

    static {
        b bVar = new b();
        a = bVar;
        bVar.x();
    }

    public static b N() {
        return a;
    }

    public static n50<b> R() {
        return a.h();
    }
}
