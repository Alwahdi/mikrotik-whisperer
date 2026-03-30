package com.google.firestore.v1;

import com.google.protobuf.f;
import com.google.protobuf.g;
import com.google.protobuf.i;
import com.google.protobuf.m;
import com.google.protobuf.n;
import com.google.protobuf.o;
import com.google.protobuf.z;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public final class l extends i<l, b> implements h10 {
    /* access modifiers changed from: private */
    public static final l a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<l> f2499a;

    /* renamed from: a  reason: collision with other field name */
    private o<String, q> f2500a = o.c();

    private static final class c {
        static final n<String, q> a = n.c(z.b.STRING, "", z.b.MESSAGE, q.Z());
    }

    private l() {
    }

    private o<String, q> P() {
        return this.f2500a;
    }

    private o<String, q> Q() {
        if (!this.f2500a.i()) {
            this.f2500a = this.f2500a.l();
        }
        return this.f2500a;
    }

    public Map<String, q> N() {
        return Collections.unmodifiableMap(P());
    }

    /* access modifiers changed from: private */
    public Map<String, q> O() {
        return Q();
    }

    public void b(g output) {
        for (Map.Entry<String, Value> entry : P().entrySet()) {
            c.a.f(output, 1, entry.getKey(), (q) entry.getValue());
        }
    }

    public int d() {
        int size = this.b;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        for (Map.Entry<String, Value> entry : P().entrySet()) {
            size2 += c.a.a(1, entry.getKey(), (q) entry.getValue());
        }
        this.b = size2;
        return size2;
    }

    public static b R() {
        return (b) a.a();
    }

    public static final class b extends i.b<l, b> implements h10 {
        /* synthetic */ b(a x0) {
            this();
        }

        private b() {
            super(l.a);
        }

        public b x(String key, q value) {
            if (key == null) {
                throw new NullPointerException();
            } else if (value != null) {
                s();
                ((l) this.b).O().put(key, value);
                return this;
            } else {
                throw new NullPointerException();
            }
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
                return new l();
            case 2:
                return a;
            case 3:
                this.f2500a.j();
                return null;
            case 4:
                return new b((a) null);
            case 5:
                this.f2500a = ((i.h) arg0).a(this.f2500a, ((l) arg1).P());
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
                                if (!this.f2500a.i()) {
                                    this.f2500a = this.f2500a.l();
                                }
                                c.a.e(this.f2500a, input, extensionRegistry);
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
                if (f2499a == null) {
                    synchronized (l.class) {
                        if (f2499a == null) {
                            f2499a = new i.c(a);
                        }
                    }
                }
                return f2499a;
            default:
                throw new UnsupportedOperationException();
        }
        return a;
    }

    static {
        l lVar = new l();
        a = lVar;
        lVar.x();
    }

    public static l M() {
        return a;
    }

    public static n50<l> S() {
        return a.h();
    }
}
