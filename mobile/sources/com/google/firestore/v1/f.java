package com.google.firestore.v1;

import com.google.protobuf.g;
import com.google.protobuf.i;
import com.google.protobuf.l;
import com.google.protobuf.m;
import java.io.IOException;
import java.util.List;

public final class f extends i<f, b> implements h10 {
    /* access modifiers changed from: private */
    public static final f a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<f> f2480a;

    /* renamed from: a  reason: collision with other field name */
    private l.d<String> f2481a = i.s();

    private f() {
    }

    public List<String> R() {
        return this.f2481a;
    }

    public int Q() {
        return this.f2481a.size();
    }

    public String P(int index) {
        return this.f2481a.get(index);
    }

    private void N() {
        if (!this.f2481a.e()) {
            this.f2481a = i.z(this.f2481a);
        }
    }

    /* access modifiers changed from: private */
    public void M(String value) {
        if (value != null) {
            N();
            this.f2481a.add(value);
            return;
        }
        throw new NullPointerException();
    }

    public void b(g output) {
        for (int i = 0; i < this.f2481a.size(); i++) {
            output.r0(1, this.f2481a.get(i));
        }
    }

    public int d() {
        int size = this.b;
        if (size != -1) {
            return size;
        }
        int dataSize = 0;
        for (int i = 0; i < this.f2481a.size(); i++) {
            dataSize += g.E(this.f2481a.get(i));
        }
        int size2 = 0 + dataSize + (R().size() * 1);
        this.b = size2;
        return size2;
    }

    public static b S() {
        return (b) a.a();
    }

    public static final class b extends i.b<f, b> implements h10 {
        /* synthetic */ b(a x0) {
            this();
        }

        private b() {
            super(f.a);
        }

        public b x(String value) {
            s();
            ((f) this.b).M(value);
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
                return new f();
            case 2:
                return a;
            case 3:
                this.f2481a.i();
                return null;
            case 4:
                return new b((a) null);
            case 5:
                this.f2481a = ((i.h) arg0).q(this.f2481a, ((f) arg1).f2481a);
                i.f fVar = i.f.a;
                return this;
            case 6:
                com.google.protobuf.f input = (com.google.protobuf.f) arg0;
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
                                String s = input.I();
                                if (!this.f2481a.e()) {
                                    this.f2481a = i.z(this.f2481a);
                                }
                                this.f2481a.add(s);
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
                if (f2480a == null) {
                    synchronized (f.class) {
                        if (f2480a == null) {
                            f2480a = new i.c(a);
                        }
                    }
                }
                return f2480a;
            default:
                throw new UnsupportedOperationException();
        }
        return a;
    }

    static {
        f fVar = new f();
        a = fVar;
        fVar.x();
    }

    public static f O() {
        return a;
    }

    public static n50<f> T() {
        return a.h();
    }
}
