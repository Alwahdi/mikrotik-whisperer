package com.google.firestore.v1;

import com.google.firestore.v1.a;
import com.google.firestore.v1.q;
import com.google.protobuf.f;
import com.google.protobuf.g;
import com.google.protobuf.i;
import com.google.protobuf.l;
import com.google.protobuf.m;
import com.google.protobuf.p;
import java.io.IOException;
import java.util.List;

public final class h extends i<h, b> implements h10 {
    /* access modifiers changed from: private */
    public static final h a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<h> f2486a;

    /* renamed from: a  reason: collision with other field name */
    private l.d<c> f2487a = i.s();

    /* renamed from: a  reason: collision with other field name */
    private String f2488a = "";
    private int c;

    private h() {
    }

    public static final class c extends i<c, a> implements h10 {
        /* access modifiers changed from: private */
        public static final c a;

        /* renamed from: a  reason: collision with other field name */
        private static volatile n50<c> f2489a;

        /* renamed from: a  reason: collision with other field name */
        private Object f2490a;

        /* renamed from: a  reason: collision with other field name */
        private String f2491a = "";
        private int c = 0;

        private c() {
        }

        public enum b implements l.a {
            SERVER_VALUE_UNSPECIFIED(0),
            REQUEST_TIME(1),
            UNRECOGNIZED(-1);
            
            public static final int REQUEST_TIME_VALUE = 1;
            public static final int SERVER_VALUE_UNSPECIFIED_VALUE = 0;
            private static final l.b<b> internalValueMap = null;
            private final int value;

            static {
                internalValueMap = new a();
            }

            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static b valueOf(int value2) {
                return forNumber(value2);
            }

            public static b forNumber(int value2) {
                switch (value2) {
                    case 0:
                        return SERVER_VALUE_UNSPECIFIED;
                    case 1:
                        return REQUEST_TIME;
                    default:
                        return null;
                }
            }

            public static l.b<b> internalGetValueMap() {
                return internalValueMap;
            }

            class a implements l.b<b> {
                a() {
                }
            }

            private b(int value2) {
                this.value = value2;
            }
        }

        /* renamed from: com.google.firestore.v1.h$c$c  reason: collision with other inner class name */
        public enum C0030c implements l.a {
            SET_TO_SERVER_VALUE(2),
            INCREMENT(3),
            MAXIMUM(4),
            MINIMUM(5),
            APPEND_MISSING_ELEMENTS(6),
            REMOVE_ALL_FROM_ARRAY(7),
            TRANSFORMTYPE_NOT_SET(0);
            
            private final int value;

            private C0030c(int value2) {
                this.value = value2;
            }

            @Deprecated
            public static C0030c valueOf(int value2) {
                return forNumber(value2);
            }

            public static C0030c forNumber(int value2) {
                switch (value2) {
                    case 0:
                        return TRANSFORMTYPE_NOT_SET;
                    case 2:
                        return SET_TO_SERVER_VALUE;
                    case 3:
                        return INCREMENT;
                    case 4:
                        return MAXIMUM;
                    case 5:
                        return MINIMUM;
                    case 6:
                        return APPEND_MISSING_ELEMENTS;
                    case 7:
                        return REMOVE_ALL_FROM_ARRAY;
                    default:
                        return null;
                }
            }

            public int getNumber() {
                return this.value;
            }
        }

        public C0030c V() {
            return C0030c.forNumber(this.c);
        }

        public String R() {
            return this.f2491a;
        }

        /* access modifiers changed from: private */
        public void Z(String value) {
            if (value != null) {
                this.f2491a = value;
                return;
            }
            throw new NullPointerException();
        }

        public b U() {
            if (this.c != 2) {
                return b.SERVER_VALUE_UNSPECIFIED;
            }
            b result = b.forNumber(((Integer) this.f2490a).intValue());
            return result == null ? b.UNRECOGNIZED : result;
        }

        /* access modifiers changed from: private */
        public void c0(b value) {
            if (value != null) {
                this.c = 2;
                this.f2490a = Integer.valueOf(value.getNumber());
                return;
            }
            throw new NullPointerException();
        }

        public q S() {
            if (this.c == 3) {
                return (q) this.f2490a;
            }
            return q.Z();
        }

        /* access modifiers changed from: private */
        public void a0(q value) {
            if (value != null) {
                this.f2490a = value;
                this.c = 3;
                return;
            }
            throw new NullPointerException();
        }

        public a Q() {
            if (this.c == 6) {
                return (a) this.f2490a;
            }
            return a.O();
        }

        /* access modifiers changed from: private */
        public void Y(a value) {
            if (value != null) {
                this.f2490a = value;
                this.c = 6;
                return;
            }
            throw new NullPointerException();
        }

        public a T() {
            if (this.c == 7) {
                return (a) this.f2490a;
            }
            return a.O();
        }

        /* access modifiers changed from: private */
        public void b0(a value) {
            if (value != null) {
                this.f2490a = value;
                this.c = 7;
                return;
            }
            throw new NullPointerException();
        }

        public void b(g output) {
            if (!this.f2491a.isEmpty()) {
                output.r0(1, R());
            }
            if (this.c == 2) {
                output.Z(2, ((Integer) this.f2490a).intValue());
            }
            if (this.c == 3) {
                output.l0(3, (q) this.f2490a);
            }
            if (this.c == 4) {
                output.l0(4, (q) this.f2490a);
            }
            if (this.c == 5) {
                output.l0(5, (q) this.f2490a);
            }
            if (this.c == 6) {
                output.l0(6, (a) this.f2490a);
            }
            if (this.c == 7) {
                output.l0(7, (a) this.f2490a);
            }
        }

        public int d() {
            int size = this.b;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (!this.f2491a.isEmpty()) {
                size2 = 0 + g.D(1, R());
            }
            if (this.c == 2) {
                size2 += g.l(2, ((Integer) this.f2490a).intValue());
            }
            if (this.c == 3) {
                size2 += g.w(3, (q) this.f2490a);
            }
            if (this.c == 4) {
                size2 += g.w(4, (q) this.f2490a);
            }
            if (this.c == 5) {
                size2 += g.w(5, (q) this.f2490a);
            }
            if (this.c == 6) {
                size2 += g.w(6, (a) this.f2490a);
            }
            if (this.c == 7) {
                size2 += g.w(7, (a) this.f2490a);
            }
            this.b = size2;
            return size2;
        }

        public static a W() {
            return (a) a.a();
        }

        public static final class a extends i.b<c, a> implements h10 {
            /* synthetic */ a(a x0) {
                this();
            }

            private a() {
                super(c.a);
            }

            public a y(String value) {
                s();
                ((c) this.b).Z(value);
                return this;
            }

            public a B(b value) {
                s();
                ((c) this.b).c0(value);
                return this;
            }

            public a z(q value) {
                s();
                ((c) this.b).a0(value);
                return this;
            }

            public a x(a value) {
                s();
                ((c) this.b).Y(value);
                return this;
            }

            public a A(a value) {
                s();
                ((c) this.b).b0(value);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object p(i.g method, Object arg0, Object arg1) {
            int i;
            switch (a.b[method.ordinal()]) {
                case 1:
                    return new c();
                case 2:
                    return a;
                case 3:
                    return null;
                case 4:
                    return new a((a) null);
                case 5:
                    i.h visitor = (i.h) arg0;
                    c other = (c) arg1;
                    boolean z = true;
                    this.f2491a = visitor.l(!this.f2491a.isEmpty(), this.f2491a, !other.f2491a.isEmpty(), other.f2491a);
                    switch (a.a[other.V().ordinal()]) {
                        case 1:
                            if (this.c != 2) {
                                z = false;
                            }
                            this.f2490a = visitor.o(z, this.f2490a, other.f2490a);
                            break;
                        case 2:
                            if (this.c != 3) {
                                z = false;
                            }
                            this.f2490a = visitor.i(z, this.f2490a, other.f2490a);
                            break;
                        case 3:
                            if (this.c != 4) {
                                z = false;
                            }
                            this.f2490a = visitor.i(z, this.f2490a, other.f2490a);
                            break;
                        case 4:
                            if (this.c != 5) {
                                z = false;
                            }
                            this.f2490a = visitor.i(z, this.f2490a, other.f2490a);
                            break;
                        case 5:
                            if (this.c != 6) {
                                z = false;
                            }
                            this.f2490a = visitor.i(z, this.f2490a, other.f2490a);
                            break;
                        case 6:
                            if (this.c != 7) {
                                z = false;
                            }
                            this.f2490a = visitor.i(z, this.f2490a, other.f2490a);
                            break;
                        case 7:
                            if (this.c == 0) {
                                z = false;
                            }
                            visitor.s(z);
                            break;
                    }
                    if (visitor == i.f.a && (i = other.c) != 0) {
                        this.c = i;
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
                                    this.f2491a = input.I();
                                    break;
                                case 16:
                                    int rawValue = input.o();
                                    this.c = 2;
                                    this.f2490a = Integer.valueOf(rawValue);
                                    break;
                                case 26:
                                    q.b subBuilder = null;
                                    if (this.c == 3) {
                                        subBuilder = (q.b) ((q) this.f2490a).a();
                                    }
                                    p u = input.u(q.j0(), extensionRegistry);
                                    this.f2490a = u;
                                    if (subBuilder != null) {
                                        subBuilder.w((q) u);
                                        this.f2490a = subBuilder.f();
                                    }
                                    this.c = 3;
                                    break;
                                case 34:
                                    q.b subBuilder2 = null;
                                    if (this.c == 4) {
                                        subBuilder2 = (q.b) ((q) this.f2490a).a();
                                    }
                                    p u2 = input.u(q.j0(), extensionRegistry);
                                    this.f2490a = u2;
                                    if (subBuilder2 != null) {
                                        subBuilder2.w((q) u2);
                                        this.f2490a = subBuilder2.f();
                                    }
                                    this.c = 4;
                                    break;
                                case 42:
                                    q.b subBuilder3 = null;
                                    if (this.c == 5) {
                                        subBuilder3 = (q.b) ((q) this.f2490a).a();
                                    }
                                    p u3 = input.u(q.j0(), extensionRegistry);
                                    this.f2490a = u3;
                                    if (subBuilder3 != null) {
                                        subBuilder3.w((q) u3);
                                        this.f2490a = subBuilder3.f();
                                    }
                                    this.c = 5;
                                    break;
                                case 50:
                                    a.b subBuilder4 = null;
                                    if (this.c == 6) {
                                        subBuilder4 = (a.b) ((a) this.f2490a).a();
                                    }
                                    p u4 = input.u(a.S(), extensionRegistry);
                                    this.f2490a = u4;
                                    if (subBuilder4 != null) {
                                        subBuilder4.w((a) u4);
                                        this.f2490a = subBuilder4.f();
                                    }
                                    this.c = 6;
                                    break;
                                case 58:
                                    a.b subBuilder5 = null;
                                    if (this.c == 7) {
                                        subBuilder5 = (a.b) ((a) this.f2490a).a();
                                    }
                                    p u5 = input.u(a.S(), extensionRegistry);
                                    this.f2490a = u5;
                                    if (subBuilder5 != null) {
                                        subBuilder5.w((a) u5);
                                        this.f2490a = subBuilder5.f();
                                    }
                                    this.c = 7;
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
                    if (f2489a == null) {
                        synchronized (c.class) {
                            if (f2489a == null) {
                                f2489a = new i.c(a);
                            }
                        }
                    }
                    return f2489a;
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

        public static n50<c> X() {
            return a.h();
        }
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[i.g.values().length];
            b = iArr;
            try {
                iArr[i.g.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[i.g.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                b[i.g.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                b[i.g.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                b[i.g.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                b[i.g.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                b[i.g.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                b[i.g.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            int[] iArr2 = new int[c.C0030c.values().length];
            a = iArr2;
            try {
                iArr2[c.C0030c.SET_TO_SERVER_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                a[c.C0030c.INCREMENT.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                a[c.C0030c.MAXIMUM.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                a[c.C0030c.MINIMUM.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                a[c.C0030c.APPEND_MISSING_ELEMENTS.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                a[c.C0030c.REMOVE_ALL_FROM_ARRAY.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
            try {
                a[c.C0030c.TRANSFORMTYPE_NOT_SET.ordinal()] = 7;
            } catch (NoSuchFieldError e15) {
            }
        }
    }

    public String Q() {
        return this.f2488a;
    }

    /* access modifiers changed from: private */
    public void U(String value) {
        if (value != null) {
            this.f2488a = value;
            return;
        }
        throw new NullPointerException();
    }

    public List<c> R() {
        return this.f2487a;
    }

    private void O() {
        if (!this.f2487a.e()) {
            this.f2487a = i.z(this.f2487a);
        }
    }

    /* access modifiers changed from: private */
    public void N(c value) {
        if (value != null) {
            O();
            this.f2487a.add(value);
            return;
        }
        throw new NullPointerException();
    }

    public void b(g output) {
        if (!this.f2488a.isEmpty()) {
            output.r0(1, Q());
        }
        for (int i = 0; i < this.f2487a.size(); i++) {
            output.l0(2, this.f2487a.get(i));
        }
    }

    public int d() {
        int size = this.b;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (!this.f2488a.isEmpty()) {
            size2 = 0 + g.D(1, Q());
        }
        for (int i = 0; i < this.f2487a.size(); i++) {
            size2 += g.w(2, this.f2487a.get(i));
        }
        this.b = size2;
        return size2;
    }

    public static b S() {
        return (b) a.a();
    }

    public static final class b extends i.b<h, b> implements h10 {
        /* synthetic */ b(a x0) {
            this();
        }

        private b() {
            super(h.a);
        }

        public b y(String value) {
            s();
            ((h) this.b).U(value);
            return this;
        }

        public b x(c value) {
            s();
            ((h) this.b).N(value);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object p(i.g method, Object arg0, Object arg1) {
        switch (a.b[method.ordinal()]) {
            case 1:
                return new h();
            case 2:
                return a;
            case 3:
                this.f2487a.i();
                return null;
            case 4:
                return new b((a) null);
            case 5:
                i.h visitor = (i.h) arg0;
                h other = (h) arg1;
                this.f2488a = visitor.l(!this.f2488a.isEmpty(), this.f2488a, !other.f2488a.isEmpty(), other.f2488a);
                this.f2487a = visitor.q(this.f2487a, other.f2487a);
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
                                this.f2488a = input.I();
                                break;
                            case 18:
                                if (!this.f2487a.e()) {
                                    this.f2487a = i.z(this.f2487a);
                                }
                                this.f2487a.add((c) input.u(c.X(), extensionRegistry));
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
                if (f2486a == null) {
                    synchronized (h.class) {
                        if (f2486a == null) {
                            f2486a = new i.c(a);
                        }
                    }
                }
                return f2486a;
            default:
                throw new UnsupportedOperationException();
        }
        return a;
    }

    static {
        h hVar = new h();
        a = hVar;
        hVar.x();
    }

    public static h P() {
        return a;
    }

    public static n50<h> T() {
        return a.h();
    }
}
