package com.google.firestore.v1;

import com.google.protobuf.e;
import com.google.protobuf.f;
import com.google.protobuf.g;
import com.google.protobuf.i;
import com.google.protobuf.l;
import com.google.protobuf.m;
import com.google.protobuf.n;
import com.google.protobuf.o;
import com.google.protobuf.z;
import java.io.IOException;
import java.util.Map;

public final class s extends i<s, b> implements h10 {
    /* access modifiers changed from: private */
    public static final s a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<s> f2547a;

    /* renamed from: a  reason: collision with other field name */
    private e f2548a = e.f2563a;

    /* renamed from: a  reason: collision with other field name */
    private l.d<r> f2549a = i.s();

    /* renamed from: a  reason: collision with other field name */
    private o<String, String> f2550a = o.c();

    /* renamed from: a  reason: collision with other field name */
    private String f2551a = "";
    private String b = "";
    private int c;

    private s() {
    }

    public String Q() {
        return this.f2551a;
    }

    /* access modifiers changed from: private */
    public void V(String value) {
        if (value != null) {
            this.f2551a = value;
            return;
        }
        throw new NullPointerException();
    }

    public String S() {
        return this.b;
    }

    private void P() {
        if (!this.f2549a.e()) {
            this.f2549a = i.z(this.f2549a);
        }
    }

    /* access modifiers changed from: private */
    public void O(r value) {
        if (value != null) {
            P();
            this.f2549a.add(value);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void W(e value) {
        if (value != null) {
            this.f2548a = value;
            return;
        }
        throw new NullPointerException();
    }

    private static final class c {
        static final n<String, String> a;

        static {
            z.b bVar = z.b.STRING;
            a = n.c(bVar, "", bVar, "");
        }
    }

    private o<String, String> T() {
        return this.f2550a;
    }

    public void b(g output) {
        if (!this.f2551a.isEmpty()) {
            output.r0(1, Q());
        }
        if (!this.b.isEmpty()) {
            output.r0(2, S());
        }
        for (int i = 0; i < this.f2549a.size(); i++) {
            output.l0(3, this.f2549a.get(i));
        }
        if (!this.f2548a.isEmpty()) {
            output.V(4, this.f2548a);
        }
        for (Map.Entry<String, String> entry : T().entrySet()) {
            c.a.f(output, 5, entry.getKey(), entry.getValue());
        }
    }

    public int d() {
        int size = this.b;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.f2551a.isEmpty()) {
            size2 = 0 + g.D(1, Q());
        }
        if (!this.b.isEmpty()) {
            size2 += g.D(2, S());
        }
        for (int i = 0; i < this.f2549a.size(); i++) {
            size2 += g.w(3, this.f2549a.get(i));
        }
        if (!this.f2548a.isEmpty()) {
            size2 += g.h(4, this.f2548a);
        }
        for (Map.Entry<String, String> entry : T().entrySet()) {
            size2 += c.a.a(5, entry.getKey(), entry.getValue());
        }
        this.b = size2;
        return size2;
    }

    public static b U() {
        return (b) a.a();
    }

    public static final class b extends i.b<s, b> implements h10 {
        /* synthetic */ b(a x0) {
            this();
        }

        private b() {
            super(s.a);
        }

        public b y(String value) {
            s();
            ((s) this.b).V(value);
            return this;
        }

        public b x(r value) {
            s();
            ((s) this.b).O(value);
            return this;
        }

        public b z(e value) {
            s();
            ((s) this.b).W(value);
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
                return new s();
            case 2:
                return a;
            case 3:
                this.f2549a.i();
                this.f2550a.j();
                return null;
            case 4:
                return new b((a) null);
            case 5:
                i.h visitor = (i.h) arg0;
                s other = (s) arg1;
                boolean z = true;
                this.f2551a = visitor.l(!this.f2551a.isEmpty(), this.f2551a, !other.f2551a.isEmpty(), other.f2551a);
                this.b = visitor.l(!this.b.isEmpty(), this.b, !other.b.isEmpty(), other.b);
                this.f2549a = visitor.q(this.f2549a, other.f2549a);
                e eVar = this.f2548a;
                e eVar2 = e.f2563a;
                boolean z2 = eVar != eVar2;
                e eVar3 = other.f2548a;
                if (eVar3 == eVar2) {
                    z = false;
                }
                this.f2548a = visitor.n(z2, eVar, z, eVar3);
                this.f2550a = visitor.a(this.f2550a, other.T());
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
                                this.f2551a = input.I();
                                break;
                            case 18:
                                this.b = input.I();
                                break;
                            case 26:
                                if (!this.f2549a.e()) {
                                    this.f2549a = i.z(this.f2549a);
                                }
                                this.f2549a.add((r) input.u(r.b0(), extensionRegistry));
                                break;
                            case 34:
                                this.f2548a = input.m();
                                break;
                            case 42:
                                if (!this.f2550a.i()) {
                                    this.f2550a = this.f2550a.l();
                                }
                                c.a.e(this.f2550a, input, extensionRegistry);
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
                if (f2547a == null) {
                    synchronized (s.class) {
                        if (f2547a == null) {
                            f2547a = new i.c(a);
                        }
                    }
                }
                return f2547a;
            default:
                throw new UnsupportedOperationException();
        }
        return a;
    }

    static {
        s sVar = new s();
        a = sVar;
        sVar.x();
    }

    public static s R() {
        return a;
    }
}
