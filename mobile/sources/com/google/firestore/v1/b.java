package com.google.firestore.v1;

import com.google.protobuf.f;
import com.google.protobuf.g;
import com.google.protobuf.i;
import com.google.protobuf.l;
import com.google.protobuf.m;
import java.io.IOException;

public final class b extends i<b, C0028b> implements h10 {
    /* access modifiers changed from: private */
    public static final b a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<b> f2466a;

    /* renamed from: a  reason: collision with other field name */
    private l.d<q> f2467a = i.s();

    /* renamed from: a  reason: collision with other field name */
    private boolean f2468a;
    private int c;

    private b() {
    }

    public int S() {
        return this.f2467a.size();
    }

    public q R(int index) {
        return this.f2467a.get(index);
    }

    private void O() {
        if (!this.f2467a.e()) {
            this.f2467a = i.z(this.f2467a);
        }
    }

    /* access modifiers changed from: private */
    public void N(q value) {
        if (value != null) {
            O();
            this.f2467a.add(value);
            return;
        }
        throw new NullPointerException();
    }

    public boolean P() {
        return this.f2468a;
    }

    /* access modifiers changed from: private */
    public void V(boolean value) {
        this.f2468a = value;
    }

    public void b(g output) {
        for (int i = 0; i < this.f2467a.size(); i++) {
            output.l0(1, this.f2467a.get(i));
        }
        boolean z = this.f2468a;
        if (z) {
            output.R(2, z);
        }
    }

    public int d() {
        int size = this.b;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        for (int i = 0; i < this.f2467a.size(); i++) {
            size2 += g.w(1, this.f2467a.get(i));
        }
        boolean z = this.f2468a;
        if (z) {
            size2 += g.e(2, z);
        }
        this.b = size2;
        return size2;
    }

    public static C0028b T() {
        return (C0028b) a.a();
    }

    /* renamed from: com.google.firestore.v1.b$b  reason: collision with other inner class name */
    public static final class C0028b extends i.b<b, C0028b> implements h10 {
        /* synthetic */ C0028b(a x0) {
            this();
        }

        private C0028b() {
            super(b.a);
        }

        public C0028b x(q value) {
            s();
            ((b) this.b).N(value);
            return this;
        }

        public C0028b y(boolean value) {
            s();
            ((b) this.b).V(value);
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
                return new b();
            case 2:
                return a;
            case 3:
                this.f2467a.i();
                return null;
            case 4:
                return new C0028b((a) null);
            case 5:
                i.h visitor = (i.h) arg0;
                b other = (b) arg1;
                this.f2467a = visitor.q(this.f2467a, other.f2467a);
                boolean z = this.f2468a;
                boolean z2 = other.f2468a;
                this.f2468a = visitor.b(z, z, z2, z2);
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
                                if (!this.f2467a.e()) {
                                    this.f2467a = i.z(this.f2467a);
                                }
                                this.f2467a.add((q) input.u(q.j0(), extensionRegistry));
                                break;
                            case 16:
                                this.f2468a = input.l();
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
                if (f2466a == null) {
                    synchronized (b.class) {
                        if (f2466a == null) {
                            f2466a = new i.c(a);
                        }
                    }
                }
                return f2466a;
            default:
                throw new UnsupportedOperationException();
        }
        return a;
    }

    static {
        b bVar = new b();
        a = bVar;
        bVar.x();
    }

    public static b Q() {
        return a;
    }

    public static n50<b> U() {
        return a.h();
    }
}
