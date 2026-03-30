package com.google.firestore.v1;

import com.google.protobuf.e;
import com.google.protobuf.f;
import com.google.protobuf.g;
import com.google.protobuf.i;
import com.google.protobuf.l;
import com.google.protobuf.m;
import com.google.protobuf.v;
import defpackage.en0;
import java.io.IOException;
import java.util.List;

public final class p extends i<p, b> implements h10 {
    /* access modifiers changed from: private */
    public static final p a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<p> f2536a;

    /* renamed from: a  reason: collision with other field name */
    private e f2537a = e.f2563a;

    /* renamed from: a  reason: collision with other field name */
    private l.c f2538a = i.r();

    /* renamed from: a  reason: collision with other field name */
    private v f2539a;

    /* renamed from: a  reason: collision with other field name */
    private en0 f2540a;
    private int c;
    private int d;

    private p() {
    }

    public enum c implements l.a {
        NO_CHANGE(0),
        ADD(1),
        REMOVE(2),
        CURRENT(3),
        RESET(4),
        UNRECOGNIZED(-1);
        
        public static final int ADD_VALUE = 1;
        public static final int CURRENT_VALUE = 3;
        public static final int NO_CHANGE_VALUE = 0;
        public static final int REMOVE_VALUE = 2;
        public static final int RESET_VALUE = 4;
        private static final l.b<c> internalValueMap = null;
        private final int value;

        static {
            internalValueMap = new a();
        }

        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static c valueOf(int value2) {
            return forNumber(value2);
        }

        public static c forNumber(int value2) {
            switch (value2) {
                case 0:
                    return NO_CHANGE;
                case 1:
                    return ADD;
                case 2:
                    return REMOVE;
                case 3:
                    return CURRENT;
                case 4:
                    return RESET;
                default:
                    return null;
            }
        }

        public static l.b<c> internalGetValueMap() {
            return internalValueMap;
        }

        class a implements l.b<c> {
            a() {
            }
        }

        private c(int value2) {
            this.value = value2;
        }
    }

    public c P() {
        c result = c.forNumber(this.d);
        return result == null ? c.UNRECOGNIZED : result;
    }

    public List<Integer> R() {
        return this.f2538a;
    }

    public int Q() {
        return this.f2538a.size();
    }

    public en0 L() {
        en0 en0 = this.f2540a;
        return en0 == null ? en0.M() : en0;
    }

    public e O() {
        return this.f2537a;
    }

    public v N() {
        v vVar = this.f2539a;
        return vVar == null ? v.N() : vVar;
    }

    public void b(g output) {
        d();
        if (this.d != c.NO_CHANGE.getNumber()) {
            output.Z(1, this.d);
        }
        for (int i = 0; i < this.f2538a.size(); i++) {
            output.h0(2, this.f2538a.getInt(i));
        }
        if (this.f2540a != null) {
            output.l0(3, L());
        }
        if (!this.f2537a.isEmpty()) {
            output.V(4, this.f2537a);
        }
        if (this.f2539a != null) {
            output.l0(6, N());
        }
    }

    public int d() {
        int size = this.b;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (this.d != c.NO_CHANGE.getNumber()) {
            size2 = 0 + g.l(1, this.d);
        }
        int dataSize = 0;
        for (int i = 0; i < this.f2538a.size(); i++) {
            dataSize += g.s(this.f2538a.getInt(i));
        }
        int size3 = size2 + dataSize + (R().size() * 1);
        if (this.f2540a != null) {
            size3 += g.w(3, L());
        }
        if (!this.f2537a.isEmpty()) {
            size3 += g.h(4, this.f2537a);
        }
        if (this.f2539a != null) {
            size3 += g.w(6, N());
        }
        this.b = size3;
        return size3;
    }

    public static final class b extends i.b<p, b> implements h10 {
        /* synthetic */ b(a x0) {
            this();
        }

        private b() {
            super(p.a);
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
                return new p();
            case 2:
                return a;
            case 3:
                this.f2538a.i();
                return null;
            case 4:
                return new b((a) null);
            case 5:
                i.h visitor = (i.h) arg0;
                p other = (p) arg1;
                int i = this.d;
                boolean z = true;
                boolean z2 = i != 0;
                int i2 = other.d;
                this.d = visitor.p(z2, i, i2 != 0, i2);
                this.f2538a = visitor.c(this.f2538a, other.f2538a);
                this.f2540a = (en0) visitor.m(this.f2540a, other.f2540a);
                e eVar = this.f2537a;
                e eVar2 = e.f2563a;
                boolean z3 = eVar != eVar2;
                e eVar3 = other.f2537a;
                if (eVar3 == eVar2) {
                    z = false;
                }
                this.f2537a = visitor.n(z3, eVar, z, eVar3);
                this.f2539a = (v) visitor.m(this.f2539a, other.f2539a);
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
                                this.d = input.o();
                                break;
                            case 16:
                                if (!this.f2538a.e()) {
                                    this.f2538a = i.y(this.f2538a);
                                }
                                this.f2538a.k(input.s());
                                break;
                            case 18:
                                int limit = input.k(input.A());
                                if (!this.f2538a.e() && input.d() > 0) {
                                    this.f2538a = i.y(this.f2538a);
                                }
                                while (input.d() > 0) {
                                    this.f2538a.k(input.s());
                                }
                                input.j(limit);
                                break;
                            case 26:
                                en0.b subBuilder = null;
                                en0 en0 = this.f2540a;
                                if (en0 != null) {
                                    subBuilder = (en0.b) en0.a();
                                }
                                en0 en02 = (en0) input.u(en0.O(), extensionRegistry);
                                this.f2540a = en02;
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.w(en02);
                                    this.f2540a = (en0) subBuilder.f();
                                    break;
                                }
                            case 34:
                                this.f2537a = input.m();
                                break;
                            case 50:
                                v.b subBuilder2 = null;
                                v vVar = this.f2539a;
                                if (vVar != null) {
                                    subBuilder2 = (v.b) vVar.a();
                                }
                                v vVar2 = (v) input.u(v.R(), extensionRegistry);
                                this.f2539a = vVar2;
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.w(vVar2);
                                    this.f2539a = (v) subBuilder2.f();
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
                if (f2536a == null) {
                    synchronized (p.class) {
                        if (f2536a == null) {
                            f2536a = new i.c(a);
                        }
                    }
                }
                return f2536a;
            default:
                throw new UnsupportedOperationException();
        }
        return a;
    }

    static {
        p pVar = new p();
        a = pVar;
        pVar.x();
    }

    public static p M() {
        return a;
    }

    public static n50<p> S() {
        return a.h();
    }
}
