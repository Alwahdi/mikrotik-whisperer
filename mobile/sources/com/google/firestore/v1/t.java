package com.google.firestore.v1;

import com.google.protobuf.e;
import com.google.protobuf.f;
import com.google.protobuf.g;
import com.google.protobuf.i;
import com.google.protobuf.l;
import com.google.protobuf.m;
import com.google.protobuf.v;
import java.io.IOException;

public final class t extends i<t, b> implements h10 {
    /* access modifiers changed from: private */
    public static final t a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<t> f2552a;

    /* renamed from: a  reason: collision with other field name */
    private e f2553a = e.f2563a;

    /* renamed from: a  reason: collision with other field name */
    private l.d<u> f2554a = i.s();

    /* renamed from: a  reason: collision with other field name */
    private v f2555a;

    /* renamed from: a  reason: collision with other field name */
    private String f2556a = "";
    private int c;

    private t() {
    }

    public String N() {
        return this.f2556a;
    }

    public e O() {
        return this.f2553a;
    }

    public int Q() {
        return this.f2554a.size();
    }

    public u P(int index) {
        return this.f2554a.get(index);
    }

    public v L() {
        v vVar = this.f2555a;
        return vVar == null ? v.N() : vVar;
    }

    public void b(g output) {
        if (!this.f2556a.isEmpty()) {
            output.r0(1, N());
        }
        if (!this.f2553a.isEmpty()) {
            output.V(2, this.f2553a);
        }
        for (int i = 0; i < this.f2554a.size(); i++) {
            output.l0(3, this.f2554a.get(i));
        }
        if (this.f2555a != null) {
            output.l0(4, L());
        }
    }

    public int d() {
        int size = this.b;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.f2556a.isEmpty()) {
            size2 = 0 + g.D(1, N());
        }
        if (!this.f2553a.isEmpty()) {
            size2 += g.h(2, this.f2553a);
        }
        for (int i = 0; i < this.f2554a.size(); i++) {
            size2 += g.w(3, this.f2554a.get(i));
        }
        if (this.f2555a != null) {
            size2 += g.w(4, L());
        }
        this.b = size2;
        return size2;
    }

    public static final class b extends i.b<t, b> implements h10 {
        /* synthetic */ b(a x0) {
            this();
        }

        private b() {
            super(t.a);
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
                return new t();
            case 2:
                return a;
            case 3:
                this.f2554a.i();
                return null;
            case 4:
                return new b((a) null);
            case 5:
                i.h visitor = (i.h) arg0;
                t other = (t) arg1;
                boolean z = true;
                this.f2556a = visitor.l(!this.f2556a.isEmpty(), this.f2556a, !other.f2556a.isEmpty(), other.f2556a);
                e eVar = this.f2553a;
                e eVar2 = e.f2563a;
                boolean z2 = eVar != eVar2;
                e eVar3 = other.f2553a;
                if (eVar3 == eVar2) {
                    z = false;
                }
                this.f2553a = visitor.n(z2, eVar, z, eVar3);
                this.f2554a = visitor.q(this.f2554a, other.f2554a);
                this.f2555a = (v) visitor.m(this.f2555a, other.f2555a);
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
                                this.f2556a = input.I();
                                break;
                            case 18:
                                this.f2553a = input.m();
                                break;
                            case 26:
                                if (!this.f2554a.e()) {
                                    this.f2554a = i.z(this.f2554a);
                                }
                                this.f2554a.add((u) input.u(u.O(), extensionRegistry));
                                break;
                            case 34:
                                v.b subBuilder = null;
                                v vVar = this.f2555a;
                                if (vVar != null) {
                                    subBuilder = (v.b) vVar.a();
                                }
                                v vVar2 = (v) input.u(v.R(), extensionRegistry);
                                this.f2555a = vVar2;
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.w(vVar2);
                                    this.f2555a = (v) subBuilder.f();
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
                if (f2552a == null) {
                    synchronized (t.class) {
                        if (f2552a == null) {
                            f2552a = new i.c(a);
                        }
                    }
                }
                return f2552a;
            default:
                throw new UnsupportedOperationException();
        }
        return a;
    }

    static {
        t tVar = new t();
        a = tVar;
        tVar.x();
    }

    public static t M() {
        return a;
    }
}
