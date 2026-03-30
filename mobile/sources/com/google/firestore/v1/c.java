package com.google.firestore.v1;

import com.google.protobuf.f;
import com.google.protobuf.g;
import com.google.protobuf.i;
import com.google.protobuf.m;
import com.google.protobuf.n;
import com.google.protobuf.o;
import com.google.protobuf.v;
import com.google.protobuf.z;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public final class c extends i<c, b> implements h10 {
    /* access modifiers changed from: private */
    public static final c a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<c> f2469a;

    /* renamed from: a  reason: collision with other field name */
    private o<String, q> f2470a = o.c();

    /* renamed from: a  reason: collision with other field name */
    private v f2471a;

    /* renamed from: a  reason: collision with other field name */
    private String f2472a = "";
    private v b;
    private int c;

    /* renamed from: com.google.firestore.v1.c$c  reason: collision with other inner class name */
    private static final class C0029c {
        static final n<String, q> a = n.c(z.b.STRING, "", z.b.MESSAGE, q.Z());
    }

    private c() {
    }

    public String S() {
        return this.f2472a;
    }

    /* access modifiers changed from: private */
    public void Y(String value) {
        if (value != null) {
            this.f2472a = value;
            return;
        }
        throw new NullPointerException();
    }

    private o<String, q> U() {
        return this.f2470a;
    }

    private o<String, q> V() {
        if (!this.f2470a.i()) {
            this.f2470a = this.f2470a.l();
        }
        return this.f2470a;
    }

    public Map<String, q> Q() {
        return Collections.unmodifiableMap(U());
    }

    /* access modifiers changed from: private */
    public Map<String, q> R() {
        return V();
    }

    public v O() {
        v vVar = this.f2471a;
        return vVar == null ? v.N() : vVar;
    }

    public v T() {
        v vVar = this.b;
        return vVar == null ? v.N() : vVar;
    }

    /* access modifiers changed from: private */
    public void Z(v value) {
        if (value != null) {
            this.b = value;
            return;
        }
        throw new NullPointerException();
    }

    public void b(g output) {
        if (!this.f2472a.isEmpty()) {
            output.r0(1, S());
        }
        for (Map.Entry<String, Value> entry : U().entrySet()) {
            C0029c.a.f(output, 2, entry.getKey(), (q) entry.getValue());
        }
        if (this.f2471a != null) {
            output.l0(3, O());
        }
        if (this.b != null) {
            output.l0(4, T());
        }
    }

    public int d() {
        int size = this.b;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.f2472a.isEmpty()) {
            size2 = 0 + g.D(1, S());
        }
        for (Map.Entry<String, Value> entry : U().entrySet()) {
            size2 += C0029c.a.a(2, entry.getKey(), (q) entry.getValue());
        }
        if (this.f2471a != null) {
            size2 += g.w(3, O());
        }
        if (this.b != null) {
            size2 += g.w(4, T());
        }
        this.b = size2;
        return size2;
    }

    public static b W() {
        return (b) a.a();
    }

    public static final class b extends i.b<c, b> implements h10 {
        /* synthetic */ b(a x0) {
            this();
        }

        private b() {
            super(c.a);
        }

        public b y(String value) {
            s();
            ((c) this.b).Y(value);
            return this;
        }

        public b x(String key, q value) {
            if (key == null) {
                throw new NullPointerException();
            } else if (value != null) {
                s();
                ((c) this.b).R().put(key, value);
                return this;
            } else {
                throw new NullPointerException();
            }
        }

        public b z(v value) {
            s();
            ((c) this.b).Z(value);
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
                return new c();
            case 2:
                return a;
            case 3:
                this.f2470a.j();
                return null;
            case 4:
                return new b((a) null);
            case 5:
                i.h visitor = (i.h) arg0;
                c other = (c) arg1;
                this.f2472a = visitor.l(!this.f2472a.isEmpty(), this.f2472a, !other.f2472a.isEmpty(), other.f2472a);
                this.f2470a = visitor.a(this.f2470a, other.U());
                this.f2471a = (v) visitor.m(this.f2471a, other.f2471a);
                this.b = (v) visitor.m(this.b, other.b);
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
                                this.f2472a = input.I();
                                break;
                            case 18:
                                if (!this.f2470a.i()) {
                                    this.f2470a = this.f2470a.l();
                                }
                                C0029c.a.e(this.f2470a, input, extensionRegistry);
                                break;
                            case 26:
                                v.b subBuilder = null;
                                v vVar = this.f2471a;
                                if (vVar != null) {
                                    subBuilder = (v.b) vVar.a();
                                }
                                v vVar2 = (v) input.u(v.R(), extensionRegistry);
                                this.f2471a = vVar2;
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.w(vVar2);
                                    this.f2471a = (v) subBuilder.f();
                                    break;
                                }
                            case 34:
                                v.b subBuilder2 = null;
                                v vVar3 = this.b;
                                if (vVar3 != null) {
                                    subBuilder2 = (v.b) vVar3.a();
                                }
                                v vVar4 = (v) input.u(v.R(), extensionRegistry);
                                this.b = vVar4;
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.w(vVar4);
                                    this.b = (v) subBuilder2.f();
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
                if (f2469a == null) {
                    synchronized (c.class) {
                        if (f2469a == null) {
                            f2469a = new i.c(a);
                        }
                    }
                }
                return f2469a;
            default:
                throw new UnsupportedOperationException();
        }
        return a;
    }

    static {
        c cVar = new c();
        a = cVar;
        cVar.x();
    }

    public static c P() {
        return a;
    }

    public static n50<c> X() {
        return a.h();
    }
}
