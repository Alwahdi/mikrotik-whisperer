package com.google.firestore.v1;

import com.google.protobuf.f;
import com.google.protobuf.g;
import com.google.protobuf.i;
import com.google.protobuf.l;
import com.google.protobuf.m;
import java.io.IOException;

public final class a extends i<a, b> implements h10 {
    /* access modifiers changed from: private */
    public static final a a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<a> f2464a;

    /* renamed from: a  reason: collision with other field name */
    private l.d<q> f2465a = i.s();

    private a() {
    }

    public int Q() {
        return this.f2465a.size();
    }

    public q P(int index) {
        return this.f2465a.get(index);
    }

    private void N() {
        if (!this.f2465a.e()) {
            this.f2465a = i.z(this.f2465a);
        }
    }

    /* access modifiers changed from: private */
    public void M(q value) {
        if (value != null) {
            N();
            this.f2465a.add(value);
            return;
        }
        throw new NullPointerException();
    }

    public void b(g output) {
        for (int i = 0; i < this.f2465a.size(); i++) {
            output.l0(1, this.f2465a.get(i));
        }
    }

    public int d() {
        int size = this.b;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        for (int i = 0; i < this.f2465a.size(); i++) {
            size2 += g.w(1, this.f2465a.get(i));
        }
        this.b = size2;
        return size2;
    }

    public static b R() {
        return (b) a.a();
    }

    public static final class b extends i.b<a, b> implements h10 {
        /* synthetic */ b(C0027a x0) {
            this();
        }

        private b() {
            super(a.a);
        }

        public b x(q value) {
            s();
            ((a) this.b).M(value);
            return this;
        }
    }

    /* renamed from: com.google.firestore.v1.a$a  reason: collision with other inner class name */
    static /* synthetic */ class C0027a {
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
        switch (C0027a.a[method.ordinal()]) {
            case 1:
                return new a();
            case 2:
                return a;
            case 3:
                this.f2465a.i();
                return null;
            case 4:
                return new b((C0027a) null);
            case 5:
                this.f2465a = ((i.h) arg0).q(this.f2465a, ((a) arg1).f2465a);
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
                                if (!this.f2465a.e()) {
                                    this.f2465a = i.z(this.f2465a);
                                }
                                this.f2465a.add((q) input.u(q.j0(), extensionRegistry));
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
                if (f2464a == null) {
                    synchronized (a.class) {
                        if (f2464a == null) {
                            f2464a = new i.c(a);
                        }
                    }
                }
                return f2464a;
            default:
                throw new UnsupportedOperationException();
        }
        return a;
    }

    static {
        a aVar = new a();
        a = aVar;
        aVar.x();
    }

    public static a O() {
        return a;
    }

    public static n50<a> S() {
        return a.h();
    }
}
