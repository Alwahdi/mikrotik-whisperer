package com.google.firestore.v1;

import com.google.protobuf.f;
import com.google.protobuf.i;
import com.google.protobuf.l;
import com.google.protobuf.m;
import com.google.protobuf.v;
import java.io.IOException;
import java.util.List;

public final class g extends i<g, b> implements h10 {
    /* access modifiers changed from: private */
    public static final g a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<g> f2482a;

    /* renamed from: a  reason: collision with other field name */
    private l.c f2483a = i.r();

    /* renamed from: a  reason: collision with other field name */
    private v f2484a;

    /* renamed from: a  reason: collision with other field name */
    private String f2485a = "";
    private int c;

    private g() {
    }

    public String M() {
        return this.f2485a;
    }

    public List<Integer> O() {
        return this.f2483a;
    }

    public v N() {
        v vVar = this.f2484a;
        return vVar == null ? v.N() : vVar;
    }

    public void b(com.google.protobuf.g output) {
        d();
        if (!this.f2485a.isEmpty()) {
            output.r0(1, M());
        }
        for (int i = 0; i < this.f2483a.size(); i++) {
            output.h0(2, this.f2483a.getInt(i));
        }
        if (this.f2484a != null) {
            output.l0(4, N());
        }
    }

    public int d() {
        int size = this.b;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.f2485a.isEmpty()) {
            size2 = 0 + com.google.protobuf.g.D(1, M());
        }
        int dataSize = 0;
        for (int i = 0; i < this.f2483a.size(); i++) {
            dataSize += com.google.protobuf.g.s(this.f2483a.getInt(i));
        }
        int size3 = size2 + dataSize + (O().size() * 1);
        if (this.f2484a != null) {
            size3 += com.google.protobuf.g.w(4, N());
        }
        this.b = size3;
        return size3;
    }

    public static final class b extends i.b<g, b> implements h10 {
        /* synthetic */ b(a x0) {
            this();
        }

        private b() {
            super(g.a);
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
                return new g();
            case 2:
                return a;
            case 3:
                this.f2483a.i();
                return null;
            case 4:
                return new b((a) null);
            case 5:
                i.h visitor = (i.h) arg0;
                g other = (g) arg1;
                this.f2485a = visitor.l(!this.f2485a.isEmpty(), this.f2485a, !other.f2485a.isEmpty(), other.f2485a);
                this.f2483a = visitor.c(this.f2483a, other.f2483a);
                this.f2484a = (v) visitor.m(this.f2484a, other.f2484a);
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
                            case 10:
                                this.f2485a = input.I();
                                break;
                            case 16:
                                if (!this.f2483a.e()) {
                                    this.f2483a = i.y(this.f2483a);
                                }
                                this.f2483a.k(input.s());
                                break;
                            case 18:
                                int limit = input.k(input.A());
                                if (!this.f2483a.e() && input.d() > 0) {
                                    this.f2483a = i.y(this.f2483a);
                                }
                                while (input.d() > 0) {
                                    this.f2483a.k(input.s());
                                }
                                input.j(limit);
                                break;
                            case 34:
                                v.b subBuilder = null;
                                v vVar = this.f2484a;
                                if (vVar != null) {
                                    subBuilder = (v.b) vVar.a();
                                }
                                v vVar2 = (v) input.u(v.R(), extensionRegistry);
                                this.f2484a = vVar2;
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.w(vVar2);
                                    this.f2484a = (v) subBuilder.f();
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
                if (f2482a == null) {
                    synchronized (g.class) {
                        if (f2482a == null) {
                            f2482a = new i.c(a);
                        }
                    }
                }
                return f2482a;
            default:
                throw new UnsupportedOperationException();
        }
        return a;
    }

    static {
        g gVar = new g();
        a = gVar;
        gVar.x();
    }

    public static g L() {
        return a;
    }

    public static n50<g> P() {
        return a.h();
    }
}
