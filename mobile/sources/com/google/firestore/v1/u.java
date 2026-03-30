package com.google.firestore.v1;

import com.google.protobuf.f;
import com.google.protobuf.g;
import com.google.protobuf.i;
import com.google.protobuf.l;
import com.google.protobuf.m;
import com.google.protobuf.v;
import java.io.IOException;

public final class u extends i<u, b> implements h10 {
    /* access modifiers changed from: private */
    public static final u a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<u> f2557a;

    /* renamed from: a  reason: collision with other field name */
    private l.d<q> f2558a = i.s();

    /* renamed from: a  reason: collision with other field name */
    private v f2559a;
    private int c;

    private u() {
    }

    public v N() {
        v vVar = this.f2559a;
        return vVar == null ? v.N() : vVar;
    }

    public int M() {
        return this.f2558a.size();
    }

    public q L(int index) {
        return this.f2558a.get(index);
    }

    public void b(g output) {
        if (this.f2559a != null) {
            output.l0(1, N());
        }
        for (int i = 0; i < this.f2558a.size(); i++) {
            output.l0(2, this.f2558a.get(i));
        }
    }

    public int d() {
        int size = this.b;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (this.f2559a != null) {
            size2 = 0 + g.w(1, N());
        }
        for (int i = 0; i < this.f2558a.size(); i++) {
            size2 += g.w(2, this.f2558a.get(i));
        }
        this.b = size2;
        return size2;
    }

    public static final class b extends i.b<u, b> implements h10 {
        /* synthetic */ b(a x0) {
            this();
        }

        private b() {
            super(u.a);
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
                return new u();
            case 2:
                return a;
            case 3:
                this.f2558a.i();
                return null;
            case 4:
                return new b((a) null);
            case 5:
                i.h visitor = (i.h) arg0;
                u other = (u) arg1;
                this.f2559a = (v) visitor.m(this.f2559a, other.f2559a);
                this.f2558a = visitor.q(this.f2558a, other.f2558a);
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
                                v.b subBuilder = null;
                                v vVar = this.f2559a;
                                if (vVar != null) {
                                    subBuilder = (v.b) vVar.a();
                                }
                                v vVar2 = (v) input.u(v.R(), extensionRegistry);
                                this.f2559a = vVar2;
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.w(vVar2);
                                    this.f2559a = (v) subBuilder.f();
                                    break;
                                }
                            case 18:
                                if (!this.f2558a.e()) {
                                    this.f2558a = i.z(this.f2558a);
                                }
                                this.f2558a.add((q) input.u(q.j0(), extensionRegistry));
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
                if (f2557a == null) {
                    synchronized (u.class) {
                        if (f2557a == null) {
                            f2557a = new i.c(a);
                        }
                    }
                }
                return f2557a;
            default:
                throw new UnsupportedOperationException();
        }
        return a;
    }

    static {
        u uVar = new u();
        a = uVar;
        uVar.x();
    }

    public static n50<u> O() {
        return a.h();
    }
}
