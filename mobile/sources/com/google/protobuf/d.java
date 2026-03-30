package com.google.protobuf;

import com.google.protobuf.i;
import java.io.IOException;

public final class d extends i<d, b> implements h10 {
    /* access modifiers changed from: private */
    public static final d a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<d> f2560a;

    /* renamed from: a  reason: collision with other field name */
    private e f2561a = e.f2563a;

    /* renamed from: a  reason: collision with other field name */
    private String f2562a = "";

    private d() {
    }

    public String L() {
        return this.f2562a;
    }

    public void b(g output) {
        if (!this.f2562a.isEmpty()) {
            output.r0(1, L());
        }
        if (!this.f2561a.isEmpty()) {
            output.V(2, this.f2561a);
        }
    }

    public int d() {
        int size = this.b;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.f2562a.isEmpty()) {
            size2 = 0 + g.D(1, L());
        }
        if (!this.f2561a.isEmpty()) {
            size2 += g.h(2, this.f2561a);
        }
        this.b = size2;
        return size2;
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
                return null;
            case 4:
                return new b((a) null);
            case 5:
                i.h visitor = (i.h) arg0;
                d other = (d) arg1;
                boolean z = true;
                this.f2562a = visitor.l(!this.f2562a.isEmpty(), this.f2562a, !other.f2562a.isEmpty(), other.f2562a);
                e eVar = this.f2561a;
                e eVar2 = e.f2563a;
                boolean z2 = eVar != eVar2;
                e eVar3 = other.f2561a;
                if (eVar3 == eVar2) {
                    z = false;
                }
                this.f2561a = visitor.n(z2, eVar, z, eVar3);
                i.f fVar = i.f.a;
                return this;
            case 6:
                f input = (f) arg0;
                fk fkVar = (fk) arg1;
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.J();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 10:
                                this.f2562a = input.I();
                                break;
                            case 18:
                                this.f2561a = input.m();
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
                if (f2560a == null) {
                    synchronized (d.class) {
                        if (f2560a == null) {
                            f2560a = new i.c(a);
                        }
                    }
                }
                return f2560a;
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

    public static n50<d> M() {
        return a.h();
    }
}
