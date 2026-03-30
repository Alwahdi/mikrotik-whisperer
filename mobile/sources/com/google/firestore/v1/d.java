package com.google.firestore.v1;

import com.google.firestore.v1.c;
import com.google.protobuf.f;
import com.google.protobuf.g;
import com.google.protobuf.i;
import com.google.protobuf.l;
import com.google.protobuf.m;
import java.io.IOException;
import java.util.List;

public final class d extends i<d, b> implements h10 {
    /* access modifiers changed from: private */
    public static final d a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<d> f2473a;

    /* renamed from: a  reason: collision with other field name */
    private c f2474a;

    /* renamed from: a  reason: collision with other field name */
    private l.c f2475a = i.r();
    private l.c b = i.r();
    private int c;

    private d() {
    }

    public c M() {
        c cVar = this.f2474a;
        return cVar == null ? c.P() : cVar;
    }

    public List<Integer> O() {
        return this.f2475a;
    }

    public List<Integer> N() {
        return this.b;
    }

    public void b(g output) {
        d();
        if (this.f2474a != null) {
            output.l0(1, M());
        }
        for (int i = 0; i < this.f2475a.size(); i++) {
            output.h0(5, this.f2475a.getInt(i));
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            output.h0(6, this.b.getInt(i2));
        }
    }

    public int d() {
        int size = this.b;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (this.f2474a != null) {
            size2 = 0 + g.w(1, M());
        }
        int dataSize = 0;
        for (int i = 0; i < this.f2475a.size(); i++) {
            dataSize += g.s(this.f2475a.getInt(i));
        }
        int size3 = size2 + dataSize + (O().size() * 1);
        int dataSize2 = 0;
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            dataSize2 += g.s(this.b.getInt(i2));
        }
        int size4 = size3 + dataSize2 + (N().size() * 1);
        this.b = size4;
        return size4;
    }

    public static final class b extends i.b<d, b> implements h10 {
        /* synthetic */ b(a x0) {
            this();
        }

        private b() {
            super(d.a);
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
                this.f2475a.i();
                this.b.i();
                return null;
            case 4:
                return new b((a) null);
            case 5:
                i.h visitor = (i.h) arg0;
                d other = (d) arg1;
                this.f2474a = (c) visitor.m(this.f2474a, other.f2474a);
                this.f2475a = visitor.c(this.f2475a, other.f2475a);
                this.b = visitor.c(this.b, other.b);
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
                                c.b subBuilder = null;
                                c cVar = this.f2474a;
                                if (cVar != null) {
                                    subBuilder = (c.b) cVar.a();
                                }
                                c cVar2 = (c) input.u(c.X(), extensionRegistry);
                                this.f2474a = cVar2;
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.w(cVar2);
                                    this.f2474a = (c) subBuilder.f();
                                    break;
                                }
                            case 40:
                                if (!this.f2475a.e()) {
                                    this.f2475a = i.y(this.f2475a);
                                }
                                this.f2475a.k(input.s());
                                break;
                            case 42:
                                int limit = input.k(input.A());
                                if (!this.f2475a.e() && input.d() > 0) {
                                    this.f2475a = i.y(this.f2475a);
                                }
                                while (input.d() > 0) {
                                    this.f2475a.k(input.s());
                                }
                                input.j(limit);
                                break;
                            case 48:
                                if (!this.b.e()) {
                                    this.b = i.y(this.b);
                                }
                                this.b.k(input.s());
                                break;
                            case 50:
                                int limit2 = input.k(input.A());
                                if (!this.b.e() && input.d() > 0) {
                                    this.b = i.y(this.b);
                                }
                                while (input.d() > 0) {
                                    this.b.k(input.s());
                                }
                                input.j(limit2);
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
                if (f2473a == null) {
                    synchronized (d.class) {
                        if (f2473a == null) {
                            f2473a = new i.c(a);
                        }
                    }
                }
                return f2473a;
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

    public static d L() {
        return a;
    }

    public static n50<d> P() {
        return a.h();
    }
}
