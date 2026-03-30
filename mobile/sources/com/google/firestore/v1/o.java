package com.google.firestore.v1;

import com.google.firestore.v1.n;
import com.google.protobuf.g;
import com.google.protobuf.i;
import com.google.protobuf.l;
import com.google.protobuf.m;
import com.google.protobuf.p;
import com.google.protobuf.v;
import java.io.IOException;
import java.util.List;

public final class o extends i<o, b> implements h10 {
    /* access modifiers changed from: private */
    public static final o a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<o> f2528a;

    /* renamed from: a  reason: collision with other field name */
    private Object f2529a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f2530a;
    private Object b;
    private int c = 0;
    private int d = 0;
    private int e;

    private o() {
    }

    public static final class c extends i<c, a> implements h10 {
        /* access modifiers changed from: private */
        public static final c a;

        /* renamed from: a  reason: collision with other field name */
        private static volatile n50<c> f2531a;

        /* renamed from: a  reason: collision with other field name */
        private l.d<String> f2532a = i.s();

        private c() {
        }

        public List<String> R() {
            return this.f2532a;
        }

        public int Q() {
            return this.f2532a.size();
        }

        public String P(int index) {
            return this.f2532a.get(index);
        }

        private void N() {
            if (!this.f2532a.e()) {
                this.f2532a = i.z(this.f2532a);
            }
        }

        /* access modifiers changed from: private */
        public void M(String value) {
            if (value != null) {
                N();
                this.f2532a.add(value);
                return;
            }
            throw new NullPointerException();
        }

        public void b(g output) {
            for (int i = 0; i < this.f2532a.size(); i++) {
                output.r0(2, this.f2532a.get(i));
            }
        }

        public int d() {
            int size = this.b;
            if (size != -1) {
                return size;
            }
            int dataSize = 0;
            for (int i = 0; i < this.f2532a.size(); i++) {
                dataSize += g.E(this.f2532a.get(i));
            }
            int size2 = 0 + dataSize + (R().size() * 1);
            this.b = size2;
            return size2;
        }

        public static a S() {
            return (a) a.a();
        }

        public static final class a extends i.b<c, a> implements h10 {
            /* synthetic */ a(a x0) {
                this();
            }

            private a() {
                super(c.a);
            }

            public a x(String value) {
                s();
                ((c) this.b).M(value);
                return this;
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
                    this.f2532a.i();
                    return null;
                case 4:
                    return new a((a) null);
                case 5:
                    this.f2532a = ((i.h) arg0).q(this.f2532a, ((c) arg1).f2532a);
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
                                case 18:
                                    String s = input.I();
                                    if (!this.f2532a.e()) {
                                        this.f2532a = i.z(this.f2532a);
                                    }
                                    this.f2532a.add(s);
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
                    if (f2531a == null) {
                        synchronized (c.class) {
                            if (f2531a == null) {
                                f2531a = new i.c(a);
                            }
                        }
                    }
                    return f2531a;
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

        public static c O() {
            return a;
        }

        public static n50<c> T() {
            return a.h();
        }
    }

    public static final class d extends i<d, a> implements h10 {
        /* access modifiers changed from: private */
        public static final d a;

        /* renamed from: a  reason: collision with other field name */
        private static volatile n50<d> f2533a;

        /* renamed from: a  reason: collision with other field name */
        private Object f2534a;

        /* renamed from: a  reason: collision with other field name */
        private String f2535a = "";
        private int c = 0;

        private d() {
        }

        public enum b implements l.a {
            STRUCTURED_QUERY(2),
            QUERYTYPE_NOT_SET(0);
            
            private final int value;

            private b(int value2) {
                this.value = value2;
            }

            @Deprecated
            public static b valueOf(int value2) {
                return forNumber(value2);
            }

            public static b forNumber(int value2) {
                switch (value2) {
                    case 0:
                        return QUERYTYPE_NOT_SET;
                    case 2:
                        return STRUCTURED_QUERY;
                    default:
                        return null;
                }
            }

            public int getNumber() {
                return this.value;
            }
        }

        public b P() {
            return b.forNumber(this.c);
        }

        public String O() {
            return this.f2535a;
        }

        /* access modifiers changed from: private */
        public void T(String value) {
            if (value != null) {
                this.f2535a = value;
                return;
            }
            throw new NullPointerException();
        }

        public n Q() {
            if (this.c == 2) {
                return (n) this.f2534a;
            }
            return n.V();
        }

        /* access modifiers changed from: private */
        public void U(n.b builderForValue) {
            this.f2534a = builderForValue.q();
            this.c = 2;
        }

        public void b(g output) {
            if (!this.f2535a.isEmpty()) {
                output.r0(1, O());
            }
            if (this.c == 2) {
                output.l0(2, (n) this.f2534a);
            }
        }

        public int d() {
            int size = this.b;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (!this.f2535a.isEmpty()) {
                size2 = 0 + g.D(1, O());
            }
            if (this.c == 2) {
                size2 += g.w(2, (n) this.f2534a);
            }
            this.b = size2;
            return size2;
        }

        public static a R() {
            return (a) a.a();
        }

        public static final class a extends i.b<d, a> implements h10 {
            /* synthetic */ a(a x0) {
                this();
            }

            private a() {
                super(d.a);
            }

            public a x(String value) {
                s();
                ((d) this.b).T(value);
                return this;
            }

            public a y(n.b builderForValue) {
                s();
                ((d) this.b).U(builderForValue);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object p(i.g method, Object arg0, Object arg1) {
            int i;
            switch (a.a[method.ordinal()]) {
                case 1:
                    return new d();
                case 2:
                    return a;
                case 3:
                    return null;
                case 4:
                    return new a((a) null);
                case 5:
                    i.h visitor = (i.h) arg0;
                    d other = (d) arg1;
                    boolean z = true;
                    this.f2535a = visitor.l(!this.f2535a.isEmpty(), this.f2535a, !other.f2535a.isEmpty(), other.f2535a);
                    switch (a.b[other.P().ordinal()]) {
                        case 1:
                            if (this.c != 2) {
                                z = false;
                            }
                            this.f2534a = visitor.i(z, this.f2534a, other.f2534a);
                            break;
                        case 2:
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
                    com.google.protobuf.f input = (com.google.protobuf.f) arg0;
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
                                    this.f2535a = input.I();
                                    break;
                                case 18:
                                    n.b subBuilder = null;
                                    if (this.c == 2) {
                                        subBuilder = (n.b) ((n) this.f2534a).a();
                                    }
                                    p u = input.u(n.k0(), extensionRegistry);
                                    this.f2534a = u;
                                    if (subBuilder != null) {
                                        subBuilder.w((n) u);
                                        this.f2534a = subBuilder.f();
                                    }
                                    this.c = 2;
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
                    if (f2533a == null) {
                        synchronized (d.class) {
                            if (f2533a == null) {
                                f2533a = new i.c(a);
                            }
                        }
                    }
                    return f2533a;
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

        public static d N() {
            return a;
        }

        public static n50<d> S() {
            return a.h();
        }
    }

    public enum f implements l.a {
        QUERY(2),
        DOCUMENTS(3),
        TARGETTYPE_NOT_SET(0);
        
        private final int value;

        private f(int value2) {
            this.value = value2;
        }

        @Deprecated
        public static f valueOf(int value2) {
            return forNumber(value2);
        }

        public static f forNumber(int value2) {
            switch (value2) {
                case 0:
                    return TARGETTYPE_NOT_SET;
                case 2:
                    return QUERY;
                case 3:
                    return DOCUMENTS;
                default:
                    return null;
            }
        }

        public int getNumber() {
            return this.value;
        }
    }

    public f Q() {
        return f.forNumber(this.c);
    }

    public enum e implements l.a {
        RESUME_TOKEN(4),
        READ_TIME(11),
        RESUMETYPE_NOT_SET(0);
        
        private final int value;

        private e(int value2) {
            this.value = value2;
        }

        @Deprecated
        public static e valueOf(int value2) {
            return forNumber(value2);
        }

        public static e forNumber(int value2) {
            switch (value2) {
                case 0:
                    return RESUMETYPE_NOT_SET;
                case 4:
                    return RESUME_TOKEN;
                case 11:
                    return READ_TIME;
                default:
                    return null;
            }
        }

        public int getNumber() {
            return this.value;
        }
    }

    public e P() {
        return e.forNumber(this.d);
    }

    /* access modifiers changed from: private */
    public void U(d value) {
        if (value != null) {
            this.f2529a = value;
            this.c = 2;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void T(c value) {
        if (value != null) {
            this.f2529a = value;
            this.c = 3;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void V(com.google.protobuf.e value) {
        if (value != null) {
            this.d = 4;
            this.b = value;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public void W(int value) {
        this.e = value;
    }

    public void b(g output) {
        if (this.c == 2) {
            output.l0(2, (d) this.f2529a);
        }
        if (this.c == 3) {
            output.l0(3, (c) this.f2529a);
        }
        if (this.d == 4) {
            output.V(4, (com.google.protobuf.e) this.b);
        }
        int i = this.e;
        if (i != 0) {
            output.h0(5, i);
        }
        boolean z = this.f2530a;
        if (z) {
            output.R(6, z);
        }
        if (this.d == 11) {
            output.l0(11, (v) this.b);
        }
    }

    public int d() {
        int size = this.b;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (this.c == 2) {
            size2 = 0 + g.w(2, (d) this.f2529a);
        }
        if (this.c == 3) {
            size2 += g.w(3, (c) this.f2529a);
        }
        if (this.d == 4) {
            size2 += g.h(4, (com.google.protobuf.e) this.b);
        }
        int i = this.e;
        if (i != 0) {
            size2 += g.r(5, i);
        }
        boolean z = this.f2530a;
        if (z) {
            size2 += g.e(6, z);
        }
        if (this.d == 11) {
            size2 += g.w(11, (v) this.b);
        }
        this.b = size2;
        return size2;
    }

    public static b R() {
        return (b) a.a();
    }

    public static final class b extends i.b<o, b> implements h10 {
        /* synthetic */ b(a x0) {
            this();
        }

        private b() {
            super(o.a);
        }

        public b y(d value) {
            s();
            ((o) this.b).U(value);
            return this;
        }

        public b x(c value) {
            s();
            ((o) this.b).T(value);
            return this;
        }

        public b z(com.google.protobuf.e value) {
            s();
            ((o) this.b).V(value);
            return this;
        }

        public b A(int value) {
            s();
            ((o) this.b).W(value);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object p(i.g method, Object arg0, Object arg1) {
        switch (a.a[method.ordinal()]) {
            case 1:
                return new o();
            case 2:
                return a;
            case 3:
                return null;
            case 4:
                return new b((a) null);
            case 5:
                i.h visitor = (i.h) arg0;
                o other = (o) arg1;
                int i = this.e;
                boolean z = true;
                boolean z2 = i != 0;
                int i2 = other.e;
                this.e = visitor.p(z2, i, i2 != 0, i2);
                boolean z3 = this.f2530a;
                boolean z4 = other.f2530a;
                this.f2530a = visitor.b(z3, z3, z4, z4);
                switch (a.c[other.Q().ordinal()]) {
                    case 1:
                        this.f2529a = visitor.i(this.c == 2, this.f2529a, other.f2529a);
                        break;
                    case 2:
                        this.f2529a = visitor.i(this.c == 3, this.f2529a, other.f2529a);
                        break;
                    case 3:
                        visitor.s(this.c != 0);
                        break;
                }
                switch (a.d[other.P().ordinal()]) {
                    case 1:
                        if (this.d != 4) {
                            z = false;
                        }
                        this.b = visitor.h(z, this.b, other.b);
                        break;
                    case 2:
                        if (this.d != 11) {
                            z = false;
                        }
                        this.b = visitor.i(z, this.b, other.b);
                        break;
                    case 3:
                        if (this.d == 0) {
                            z = false;
                        }
                        visitor.s(z);
                        break;
                }
                if (visitor == i.f.a) {
                    int i3 = other.c;
                    if (i3 != 0) {
                        this.c = i3;
                    }
                    int i4 = other.d;
                    if (i4 != 0) {
                        this.d = i4;
                    }
                }
                return this;
            case 6:
                com.google.protobuf.f input = (com.google.protobuf.f) arg0;
                fk extensionRegistry = (fk) arg1;
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.J();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 18:
                                d.a subBuilder = null;
                                if (this.c == 2) {
                                    subBuilder = (d.a) ((d) this.f2529a).a();
                                }
                                p u = input.u(d.S(), extensionRegistry);
                                this.f2529a = u;
                                if (subBuilder != null) {
                                    subBuilder.w((d) u);
                                    this.f2529a = subBuilder.f();
                                }
                                this.c = 2;
                                break;
                            case 26:
                                c.a subBuilder2 = null;
                                if (this.c == 3) {
                                    subBuilder2 = (c.a) ((c) this.f2529a).a();
                                }
                                p u2 = input.u(c.T(), extensionRegistry);
                                this.f2529a = u2;
                                if (subBuilder2 != null) {
                                    subBuilder2.w((c) u2);
                                    this.f2529a = subBuilder2.f();
                                }
                                this.c = 3;
                                break;
                            case 34:
                                this.d = 4;
                                this.b = input.m();
                                break;
                            case 40:
                                this.e = input.s();
                                break;
                            case 48:
                                this.f2530a = input.l();
                                break;
                            case 90:
                                v.b subBuilder3 = null;
                                if (this.d == 11) {
                                    subBuilder3 = (v.b) ((v) this.b).a();
                                }
                                p u3 = input.u(v.R(), extensionRegistry);
                                this.b = u3;
                                if (subBuilder3 != null) {
                                    subBuilder3.w((v) u3);
                                    this.b = subBuilder3.f();
                                }
                                this.d = 11;
                                break;
                            default:
                                if (input.P(tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                    } catch (m e2) {
                        throw new RuntimeException(e2.i(this));
                    } catch (IOException e3) {
                        throw new RuntimeException(new m(e3.getMessage()).i(this));
                    }
                }
                break;
            case 7:
                break;
            case 8:
                if (f2528a == null) {
                    synchronized (o.class) {
                        if (f2528a == null) {
                            f2528a = new i.c(a);
                        }
                    }
                }
                return f2528a;
            default:
                throw new UnsupportedOperationException();
        }
        return a;
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;
        static final /* synthetic */ int[] d;

        static {
            int[] iArr = new int[e.values().length];
            d = iArr;
            try {
                iArr[e.RESUME_TOKEN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                d[e.READ_TIME.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                d[e.RESUMETYPE_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            int[] iArr2 = new int[f.values().length];
            c = iArr2;
            try {
                iArr2[f.QUERY.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                c[f.DOCUMENTS.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                c[f.TARGETTYPE_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            int[] iArr3 = new int[d.b.values().length];
            b = iArr3;
            try {
                iArr3[d.b.STRUCTURED_QUERY.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                b[d.b.QUERYTYPE_NOT_SET.ordinal()] = 2;
            } catch (NoSuchFieldError e8) {
            }
            int[] iArr4 = new int[i.g.values().length];
            a = iArr4;
            try {
                iArr4[i.g.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                a[i.g.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                a[i.g.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                a[i.g.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                a[i.g.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                a[i.g.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
            try {
                a[i.g.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError e15) {
            }
            try {
                a[i.g.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError e16) {
            }
        }
    }

    static {
        o oVar = new o();
        a = oVar;
        oVar.x();
    }

    public static n50<o> S() {
        return a.h();
    }
}
