package com.google.firestore.v1;

import com.google.protobuf.f;
import com.google.protobuf.g;
import com.google.protobuf.i;
import com.google.protobuf.l;
import com.google.protobuf.m;
import com.google.protobuf.v;
import java.io.IOException;
import java.util.List;

public final class e extends i<e, b> implements h10 {
    /* access modifiers changed from: private */
    public static final e a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<e> f2476a;

    /* renamed from: a  reason: collision with other field name */
    private l.c f2477a = i.r();

    /* renamed from: a  reason: collision with other field name */
    private v f2478a;

    /* renamed from: a  reason: collision with other field name */
    private String f2479a = "";
    private int c;

    private e() {
    }

    public String M() {
        return this.f2479a;
    }

    public List<Integer> O() {
        return this.f2477a;
    }

    public v N() {
        v vVar = this.f2478a;
        return vVar == null ? v.N() : vVar;
    }

    public void b(g output) {
        d();
        if (!this.f2479a.isEmpty()) {
            output.r0(1, M());
        }
        if (this.f2478a != null) {
            output.l0(4, N());
        }
        for (int i = 0; i < this.f2477a.size(); i++) {
            output.h0(6, this.f2477a.getInt(i));
        }
    }

    public int d() {
        int size = this.b;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.f2479a.isEmpty()) {
            size2 = 0 + g.D(1, M());
        }
        if (this.f2478a != null) {
            size2 += g.w(4, N());
        }
        int dataSize = 0;
        for (int i = 0; i < this.f2477a.size(); i++) {
            dataSize += g.s(this.f2477a.getInt(i));
        }
        int size3 = size2 + dataSize + (O().size() * 1);
        this.b = size3;
        return size3;
    }

    public static final class b extends i.b<e, b> implements h10 {
        /* synthetic */ b(a x0) {
            this();
        }

        private b() {
            super(e.a);
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
                return new e();
            case 2:
                return a;
            case 3:
                this.f2477a.i();
                return null;
            case 4:
                return new b((a) null);
            case 5:
                i.h visitor = (i.h) arg0;
                e other = (e) arg1;
                this.f2479a = visitor.l(!this.f2479a.isEmpty(), this.f2479a, !other.f2479a.isEmpty(), other.f2479a);
                this.f2477a = visitor.c(this.f2477a, other.f2477a);
                this.f2478a = (v) visitor.m(this.f2478a, other.f2478a);
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
                                this.f2479a = input.I();
                                break;
                            case 34:
                                v.b subBuilder = null;
                                v vVar = this.f2478a;
                                if (vVar != null) {
                                    subBuilder = (v.b) vVar.a();
                                }
                                v vVar2 = (v) input.u(v.R(), extensionRegistry);
                                this.f2478a = vVar2;
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.w(vVar2);
                                    this.f2478a = (v) subBuilder.f();
                                    break;
                                }
                            case 48:
                                if (!this.f2477a.e()) {
                                    this.f2477a = i.y(this.f2477a);
                                }
                                this.f2477a.k(input.s());
                                break;
                            case 50:
                                int limit = input.k(input.A());
                                if (!this.f2477a.e() && input.d() > 0) {
                                    this.f2477a = i.y(this.f2477a);
                                }
                                while (input.d() > 0) {
                                    this.f2477a.k(input.s());
                                }
                                input.j(limit);
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
                if (f2476a == null) {
                    synchronized (e.class) {
                        if (f2476a == null) {
                            f2476a = new i.c(a);
                        }
                    }
                }
                return f2476a;
            default:
                throw new UnsupportedOperationException();
        }
        return a;
    }

    static {
        e eVar = new e();
        a = eVar;
        eVar.x();
    }

    public static e L() {
        return a;
    }

    public static n50<e> P() {
        return a.h();
    }
}
