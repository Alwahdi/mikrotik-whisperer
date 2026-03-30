package com.google.firestore.v1;

import com.google.firestore.v1.b;
import com.google.firestore.v1.q;
import com.google.protobuf.i;
import com.google.protobuf.j;
import com.google.protobuf.l;
import com.google.protobuf.m;
import com.google.protobuf.p;
import java.io.IOException;
import java.util.List;

public final class n extends com.google.protobuf.i<n, b> implements h10 {
    /* access modifiers changed from: private */
    public static final n a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile n50<n> f2503a;

    /* renamed from: a  reason: collision with other field name */
    private b f2504a;

    /* renamed from: a  reason: collision with other field name */
    private h f2505a;

    /* renamed from: a  reason: collision with other field name */
    private j f2506a;

    /* renamed from: a  reason: collision with other field name */
    private com.google.protobuf.j f2507a;

    /* renamed from: a  reason: collision with other field name */
    private l.d<c> f2508a = com.google.protobuf.i.s();
    private b b;

    /* renamed from: b  reason: collision with other field name */
    private l.d<i> f2509b = com.google.protobuf.i.s();
    private int c;
    private int d;

    private n() {
    }

    public enum e implements l.a {
        DIRECTION_UNSPECIFIED(0),
        ASCENDING(1),
        DESCENDING(2),
        UNRECOGNIZED(-1);
        
        public static final int ASCENDING_VALUE = 1;
        public static final int DESCENDING_VALUE = 2;
        public static final int DIRECTION_UNSPECIFIED_VALUE = 0;
        private static final l.b<e> internalValueMap = null;
        private final int value;

        static {
            internalValueMap = new a();
        }

        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static e valueOf(int value2) {
            return forNumber(value2);
        }

        public static e forNumber(int value2) {
            switch (value2) {
                case 0:
                    return DIRECTION_UNSPECIFIED;
                case 1:
                    return ASCENDING;
                case 2:
                    return DESCENDING;
                default:
                    return null;
            }
        }

        public static l.b<e> internalGetValueMap() {
            return internalValueMap;
        }

        class a implements l.b<e> {
            a() {
            }
        }

        private e(int value2) {
            this.value = value2;
        }
    }

    public static final class c extends com.google.protobuf.i<c, a> implements h10 {
        /* access modifiers changed from: private */
        public static final c a;

        /* renamed from: a  reason: collision with other field name */
        private static volatile n50<c> f2510a;

        /* renamed from: a  reason: collision with other field name */
        private String f2511a = "";

        /* renamed from: a  reason: collision with other field name */
        private boolean f2512a;

        private c() {
        }

        public String O() {
            return this.f2511a;
        }

        /* access modifiers changed from: private */
        public void S(String value) {
            if (value != null) {
                this.f2511a = value;
                return;
            }
            throw new NullPointerException();
        }

        public boolean N() {
            return this.f2512a;
        }

        /* access modifiers changed from: private */
        public void R(boolean value) {
            this.f2512a = value;
        }

        public void b(com.google.protobuf.g output) {
            if (!this.f2511a.isEmpty()) {
                output.r0(2, O());
            }
            boolean z = this.f2512a;
            if (z) {
                output.R(3, z);
            }
        }

        public int d() {
            int size = this.b;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (!this.f2511a.isEmpty()) {
                size2 = 0 + com.google.protobuf.g.D(2, O());
            }
            boolean z = this.f2512a;
            if (z) {
                size2 += com.google.protobuf.g.e(3, z);
            }
            this.b = size2;
            return size2;
        }

        public static a P() {
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
                ((c) this.b).S(value);
                return this;
            }

            public a x(boolean value) {
                s();
                ((c) this.b).R(value);
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
                    return null;
                case 4:
                    return new a((a) null);
                case 5:
                    i.h visitor = (i.h) arg0;
                    c other = (c) arg1;
                    this.f2511a = visitor.l(!this.f2511a.isEmpty(), this.f2511a, !other.f2511a.isEmpty(), other.f2511a);
                    boolean z = this.f2512a;
                    boolean z2 = other.f2512a;
                    this.f2512a = visitor.b(z, z, z2, z2);
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
                                    this.f2511a = input.I();
                                    break;
                                case 24:
                                    this.f2512a = input.l();
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
                    if (f2510a == null) {
                        synchronized (c.class) {
                            if (f2510a == null) {
                                f2510a = new i.c(a);
                            }
                        }
                    }
                    return f2510a;
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

        public static n50<c> Q() {
            return a.h();
        }
    }

    public static final class h extends com.google.protobuf.i<h, a> implements h10 {
        /* access modifiers changed from: private */
        public static final h a;

        /* renamed from: a  reason: collision with other field name */
        private static volatile n50<h> f2520a;

        /* renamed from: a  reason: collision with other field name */
        private Object f2521a;
        private int c = 0;

        private h() {
        }

        public enum b implements l.a {
            COMPOSITE_FILTER(1),
            FIELD_FILTER(2),
            UNARY_FILTER(3),
            FILTERTYPE_NOT_SET(0);
            
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
                        return FILTERTYPE_NOT_SET;
                    case 1:
                        return COMPOSITE_FILTER;
                    case 2:
                        return FIELD_FILTER;
                    case 3:
                        return UNARY_FILTER;
                    default:
                        return null;
                }
            }

            public int getNumber() {
                return this.value;
            }
        }

        public b R() {
            return b.forNumber(this.c);
        }

        public d O() {
            if (this.c == 1) {
                return (d) this.f2521a;
            }
            return d.P();
        }

        /* access modifiers changed from: private */
        public void V(d.a builderForValue) {
            this.f2521a = builderForValue.q();
            this.c = 1;
        }

        public f Q() {
            if (this.c == 2) {
                return (f) this.f2521a;
            }
            return f.O();
        }

        /* access modifiers changed from: private */
        public void W(f.a builderForValue) {
            this.f2521a = builderForValue.q();
            this.c = 2;
        }

        public k S() {
            if (this.c == 3) {
                return (k) this.f2521a;
            }
            return k.N();
        }

        /* access modifiers changed from: private */
        public void X(k.a builderForValue) {
            this.f2521a = builderForValue.q();
            this.c = 3;
        }

        public void b(com.google.protobuf.g output) {
            if (this.c == 1) {
                output.l0(1, (d) this.f2521a);
            }
            if (this.c == 2) {
                output.l0(2, (f) this.f2521a);
            }
            if (this.c == 3) {
                output.l0(3, (k) this.f2521a);
            }
        }

        public int d() {
            int size = this.b;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.c == 1) {
                size2 = 0 + com.google.protobuf.g.w(1, (d) this.f2521a);
            }
            if (this.c == 2) {
                size2 += com.google.protobuf.g.w(2, (f) this.f2521a);
            }
            if (this.c == 3) {
                size2 += com.google.protobuf.g.w(3, (k) this.f2521a);
            }
            this.b = size2;
            return size2;
        }

        public static a T() {
            return (a) a.a();
        }

        public static final class a extends i.b<h, a> implements h10 {
            /* synthetic */ a(a x0) {
                this();
            }

            private a() {
                super(h.a);
            }

            public a x(d.a builderForValue) {
                s();
                ((h) this.b).V(builderForValue);
                return this;
            }

            public a y(f.a builderForValue) {
                s();
                ((h) this.b).W(builderForValue);
                return this;
            }

            public a z(k.a builderForValue) {
                s();
                ((h) this.b).X(builderForValue);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object p(i.g method, Object arg0, Object arg1) {
            int i;
            boolean z = true;
            switch (a.a[method.ordinal()]) {
                case 1:
                    return new h();
                case 2:
                    return a;
                case 3:
                    return null;
                case 4:
                    return new a((a) null);
                case 5:
                    i.h visitor = (i.h) arg0;
                    h other = (h) arg1;
                    switch (a.b[other.R().ordinal()]) {
                        case 1:
                            if (this.c != 1) {
                                z = false;
                            }
                            this.f2521a = visitor.i(z, this.f2521a, other.f2521a);
                            break;
                        case 2:
                            if (this.c != 2) {
                                z = false;
                            }
                            this.f2521a = visitor.i(z, this.f2521a, other.f2521a);
                            break;
                        case 3:
                            if (this.c != 3) {
                                z = false;
                            }
                            this.f2521a = visitor.i(z, this.f2521a, other.f2521a);
                            break;
                        case 4:
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
                                    d.a subBuilder = null;
                                    if (this.c == 1) {
                                        subBuilder = (d.a) ((d) this.f2521a).a();
                                    }
                                    p u = input.u(d.T(), extensionRegistry);
                                    this.f2521a = u;
                                    if (subBuilder != null) {
                                        subBuilder.w((d) u);
                                        this.f2521a = subBuilder.f();
                                    }
                                    this.c = 1;
                                    break;
                                case 18:
                                    f.a subBuilder2 = null;
                                    if (this.c == 2) {
                                        subBuilder2 = (f.a) ((f) this.f2521a).a();
                                    }
                                    p u2 = input.u(f.T(), extensionRegistry);
                                    this.f2521a = u2;
                                    if (subBuilder2 != null) {
                                        subBuilder2.w((f) u2);
                                        this.f2521a = subBuilder2.f();
                                    }
                                    this.c = 2;
                                    break;
                                case 26:
                                    k.a subBuilder3 = null;
                                    if (this.c == 3) {
                                        subBuilder3 = (k.a) ((k) this.f2521a).a();
                                    }
                                    p u3 = input.u(k.S(), extensionRegistry);
                                    this.f2521a = u3;
                                    if (subBuilder3 != null) {
                                        subBuilder3.w((k) u3);
                                        this.f2521a = subBuilder3.f();
                                    }
                                    this.c = 3;
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
                    if (f2520a == null) {
                        synchronized (h.class) {
                            if (f2520a == null) {
                                f2520a = new i.c(a);
                            }
                        }
                    }
                    return f2520a;
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

        public static n50<h> U() {
            return a.h();
        }
    }

    public static final class d extends com.google.protobuf.i<d, a> implements h10 {
        /* access modifiers changed from: private */
        public static final d a;

        /* renamed from: a  reason: collision with other field name */
        private static volatile n50<d> f2513a;

        /* renamed from: a  reason: collision with other field name */
        private l.d<h> f2514a = com.google.protobuf.i.s();
        private int c;
        private int d;

        private d() {
        }

        public enum b implements l.a {
            OPERATOR_UNSPECIFIED(0),
            AND(1),
            UNRECOGNIZED(-1);
            
            public static final int AND_VALUE = 1;
            public static final int OPERATOR_UNSPECIFIED_VALUE = 0;
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
                        return OPERATOR_UNSPECIFIED;
                    case 1:
                        return AND;
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

        public b R() {
            b result = b.forNumber(this.d);
            return result == null ? b.UNRECOGNIZED : result;
        }

        /* access modifiers changed from: private */
        public void U(b value) {
            if (value != null) {
                this.d = value.getNumber();
                return;
            }
            throw new NullPointerException();
        }

        public List<h> Q() {
            return this.f2514a;
        }

        private void O() {
            if (!this.f2514a.e()) {
                this.f2514a = com.google.protobuf.i.z(this.f2514a);
            }
        }

        /* access modifiers changed from: private */
        public void N(Iterable<? extends h> values) {
            O();
            com.google.protobuf.a.i(values, this.f2514a);
        }

        public void b(com.google.protobuf.g output) {
            if (this.d != b.OPERATOR_UNSPECIFIED.getNumber()) {
                output.Z(1, this.d);
            }
            for (int i = 0; i < this.f2514a.size(); i++) {
                output.l0(2, this.f2514a.get(i));
            }
        }

        public int d() {
            int size = this.b;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.d != b.OPERATOR_UNSPECIFIED.getNumber()) {
                size2 = 0 + com.google.protobuf.g.l(1, this.d);
            }
            for (int i = 0; i < this.f2514a.size(); i++) {
                size2 += com.google.protobuf.g.w(2, this.f2514a.get(i));
            }
            this.b = size2;
            return size2;
        }

        public static a S() {
            return (a) a.a();
        }

        public static final class a extends i.b<d, a> implements h10 {
            /* synthetic */ a(a x0) {
                this();
            }

            private a() {
                super(d.a);
            }

            public a y(b value) {
                s();
                ((d) this.b).U(value);
                return this;
            }

            public a x(Iterable<? extends h> values) {
                s();
                ((d) this.b).N(values);
                return this;
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
                    this.f2514a.i();
                    return null;
                case 4:
                    return new a((a) null);
                case 5:
                    i.h visitor = (i.h) arg0;
                    d other = (d) arg1;
                    int i = this.d;
                    boolean z = true;
                    boolean z2 = i != 0;
                    int i2 = other.d;
                    if (i2 == 0) {
                        z = false;
                    }
                    this.d = visitor.p(z2, i, z, i2);
                    this.f2514a = visitor.q(this.f2514a, other.f2514a);
                    if (visitor == i.f.a) {
                        this.c |= other.c;
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
                                case 8:
                                    this.d = input.o();
                                    break;
                                case 18:
                                    if (!this.f2514a.e()) {
                                        this.f2514a = com.google.protobuf.i.z(this.f2514a);
                                    }
                                    this.f2514a.add((h) input.u(h.U(), extensionRegistry));
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
                    if (f2513a == null) {
                        synchronized (d.class) {
                            if (f2513a == null) {
                                f2513a = new i.c(a);
                            }
                        }
                    }
                    return f2513a;
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

        public static d P() {
            return a;
        }

        public static n50<d> T() {
            return a.h();
        }
    }

    public static final class f extends com.google.protobuf.i<f, a> implements h10 {
        /* access modifiers changed from: private */
        public static final f a;

        /* renamed from: a  reason: collision with other field name */
        private static volatile n50<f> f2515a;

        /* renamed from: a  reason: collision with other field name */
        private g f2516a;

        /* renamed from: a  reason: collision with other field name */
        private q f2517a;
        private int c;

        private f() {
        }

        public enum b implements l.a {
            OPERATOR_UNSPECIFIED(0),
            LESS_THAN(1),
            LESS_THAN_OR_EQUAL(2),
            GREATER_THAN(3),
            GREATER_THAN_OR_EQUAL(4),
            EQUAL(5),
            ARRAY_CONTAINS(7),
            IN(8),
            ARRAY_CONTAINS_ANY(9),
            UNRECOGNIZED(-1);
            
            public static final int ARRAY_CONTAINS_ANY_VALUE = 9;
            public static final int ARRAY_CONTAINS_VALUE = 7;
            public static final int EQUAL_VALUE = 5;
            public static final int GREATER_THAN_OR_EQUAL_VALUE = 4;
            public static final int GREATER_THAN_VALUE = 3;
            public static final int IN_VALUE = 8;
            public static final int LESS_THAN_OR_EQUAL_VALUE = 2;
            public static final int LESS_THAN_VALUE = 1;
            public static final int OPERATOR_UNSPECIFIED_VALUE = 0;
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
                        return OPERATOR_UNSPECIFIED;
                    case 1:
                        return LESS_THAN;
                    case 2:
                        return LESS_THAN_OR_EQUAL;
                    case 3:
                        return GREATER_THAN;
                    case 4:
                        return GREATER_THAN_OR_EQUAL;
                    case 5:
                        return EQUAL;
                    case 7:
                        return ARRAY_CONTAINS;
                    case 8:
                        return IN;
                    case 9:
                        return ARRAY_CONTAINS_ANY;
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

        public g P() {
            g gVar = this.f2516a;
            return gVar == null ? g.M() : gVar;
        }

        /* access modifiers changed from: private */
        public void U(g value) {
            if (value != null) {
                this.f2516a = value;
                return;
            }
            throw new NullPointerException();
        }

        public b Q() {
            b result = b.forNumber(this.c);
            return result == null ? b.UNRECOGNIZED : result;
        }

        /* access modifiers changed from: private */
        public void V(b value) {
            if (value != null) {
                this.c = value.getNumber();
                return;
            }
            throw new NullPointerException();
        }

        public q R() {
            q qVar = this.f2517a;
            return qVar == null ? q.Z() : qVar;
        }

        /* access modifiers changed from: private */
        public void W(q value) {
            if (value != null) {
                this.f2517a = value;
                return;
            }
            throw new NullPointerException();
        }

        public void b(com.google.protobuf.g output) {
            if (this.f2516a != null) {
                output.l0(1, P());
            }
            if (this.c != b.OPERATOR_UNSPECIFIED.getNumber()) {
                output.Z(2, this.c);
            }
            if (this.f2517a != null) {
                output.l0(3, R());
            }
        }

        public int d() {
            int size = this.b;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.f2516a != null) {
                size2 = 0 + com.google.protobuf.g.w(1, P());
            }
            if (this.c != b.OPERATOR_UNSPECIFIED.getNumber()) {
                size2 += com.google.protobuf.g.l(2, this.c);
            }
            if (this.f2517a != null) {
                size2 += com.google.protobuf.g.w(3, R());
            }
            this.b = size2;
            return size2;
        }

        public static a S() {
            return (a) a.a();
        }

        public static final class a extends i.b<f, a> implements h10 {
            /* synthetic */ a(a x0) {
                this();
            }

            private a() {
                super(f.a);
            }

            public a x(g value) {
                s();
                ((f) this.b).U(value);
                return this;
            }

            public a y(b value) {
                s();
                ((f) this.b).V(value);
                return this;
            }

            public a z(q value) {
                s();
                ((f) this.b).W(value);
                return this;
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
                    return null;
                case 4:
                    return new a((a) null);
                case 5:
                    i.h visitor = (i.h) arg0;
                    f other = (f) arg1;
                    this.f2516a = (g) visitor.m(this.f2516a, other.f2516a);
                    int i = this.c;
                    boolean z = true;
                    boolean z2 = i != 0;
                    int i2 = other.c;
                    if (i2 == 0) {
                        z = false;
                    }
                    this.c = visitor.p(z2, i, z, i2);
                    this.f2517a = (q) visitor.m(this.f2517a, other.f2517a);
                    i.f fVar = i.f.a;
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
                                    g.a subBuilder = null;
                                    g gVar = this.f2516a;
                                    if (gVar != null) {
                                        subBuilder = (g.a) gVar.a();
                                    }
                                    g gVar2 = (g) input.u(g.P(), extensionRegistry);
                                    this.f2516a = gVar2;
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.w(gVar2);
                                        this.f2516a = (g) subBuilder.f();
                                        break;
                                    }
                                case 16:
                                    this.c = input.o();
                                    break;
                                case 26:
                                    q.b subBuilder2 = null;
                                    q qVar = this.f2517a;
                                    if (qVar != null) {
                                        subBuilder2 = (q.b) qVar.a();
                                    }
                                    q qVar2 = (q) input.u(q.j0(), extensionRegistry);
                                    this.f2517a = qVar2;
                                    if (subBuilder2 == null) {
                                        break;
                                    } else {
                                        subBuilder2.w(qVar2);
                                        this.f2517a = (q) subBuilder2.f();
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
                    if (f2515a == null) {
                        synchronized (f.class) {
                            if (f2515a == null) {
                                f2515a = new i.c(a);
                            }
                        }
                    }
                    return f2515a;
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

    public static final class k extends com.google.protobuf.i<k, a> implements h10 {
        /* access modifiers changed from: private */
        public static final k a;

        /* renamed from: a  reason: collision with other field name */
        private static volatile n50<k> f2526a;

        /* renamed from: a  reason: collision with other field name */
        private Object f2527a;
        private int c = 0;
        private int d;

        private k() {
        }

        public enum c implements l.a {
            OPERATOR_UNSPECIFIED(0),
            IS_NAN(2),
            IS_NULL(3),
            UNRECOGNIZED(-1);
            
            public static final int IS_NAN_VALUE = 2;
            public static final int IS_NULL_VALUE = 3;
            public static final int OPERATOR_UNSPECIFIED_VALUE = 0;
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
                        return OPERATOR_UNSPECIFIED;
                    case 2:
                        return IS_NAN;
                    case 3:
                        return IS_NULL;
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

        public enum b implements l.a {
            FIELD(2),
            OPERANDTYPE_NOT_SET(0);
            
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
                        return OPERANDTYPE_NOT_SET;
                    case 2:
                        return FIELD;
                    default:
                        return null;
                }
            }

            public int getNumber() {
                return this.value;
            }
        }

        public b Q() {
            return b.forNumber(this.c);
        }

        public c P() {
            c result = c.forNumber(this.d);
            return result == null ? c.UNRECOGNIZED : result;
        }

        /* access modifiers changed from: private */
        public void U(c value) {
            if (value != null) {
                this.d = value.getNumber();
                return;
            }
            throw new NullPointerException();
        }

        public g O() {
            if (this.c == 2) {
                return (g) this.f2527a;
            }
            return g.M();
        }

        /* access modifiers changed from: private */
        public void T(g value) {
            if (value != null) {
                this.f2527a = value;
                this.c = 2;
                return;
            }
            throw new NullPointerException();
        }

        public void b(com.google.protobuf.g output) {
            if (this.d != c.OPERATOR_UNSPECIFIED.getNumber()) {
                output.Z(1, this.d);
            }
            if (this.c == 2) {
                output.l0(2, (g) this.f2527a);
            }
        }

        public int d() {
            int size = this.b;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.d != c.OPERATOR_UNSPECIFIED.getNumber()) {
                size2 = 0 + com.google.protobuf.g.l(1, this.d);
            }
            if (this.c == 2) {
                size2 += com.google.protobuf.g.w(2, (g) this.f2527a);
            }
            this.b = size2;
            return size2;
        }

        public static a R() {
            return (a) a.a();
        }

        public static final class a extends i.b<k, a> implements h10 {
            /* synthetic */ a(a x0) {
                this();
            }

            private a() {
                super(k.a);
            }

            public a y(c value) {
                s();
                ((k) this.b).U(value);
                return this;
            }

            public a x(g value) {
                s();
                ((k) this.b).T(value);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object p(i.g method, Object arg0, Object arg1) {
            int i;
            switch (a.a[method.ordinal()]) {
                case 1:
                    return new k();
                case 2:
                    return a;
                case 3:
                    return null;
                case 4:
                    return new a((a) null);
                case 5:
                    i.h visitor = (i.h) arg0;
                    k other = (k) arg1;
                    int i2 = this.d;
                    boolean z = true;
                    boolean z2 = i2 != 0;
                    int i3 = other.d;
                    this.d = visitor.p(z2, i2, i3 != 0, i3);
                    switch (a.c[other.Q().ordinal()]) {
                        case 1:
                            if (this.c != 2) {
                                z = false;
                            }
                            this.f2527a = visitor.i(z, this.f2527a, other.f2527a);
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
                                case 8:
                                    this.d = input.o();
                                    break;
                                case 18:
                                    g.a subBuilder = null;
                                    if (this.c == 2) {
                                        subBuilder = (g.a) ((g) this.f2527a).a();
                                    }
                                    p u = input.u(g.P(), extensionRegistry);
                                    this.f2527a = u;
                                    if (subBuilder != null) {
                                        subBuilder.w((g) u);
                                        this.f2527a = subBuilder.f();
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
                    if (f2526a == null) {
                        synchronized (k.class) {
                            if (f2526a == null) {
                                f2526a = new i.c(a);
                            }
                        }
                    }
                    return f2526a;
                default:
                    throw new UnsupportedOperationException();
            }
            return a;
        }

        static {
            k kVar = new k();
            a = kVar;
            kVar.x();
        }

        public static k N() {
            return a;
        }

        public static n50<k> S() {
            return a.h();
        }
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[k.b.values().length];
            c = iArr;
            try {
                iArr[k.b.FIELD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                c[k.b.OPERANDTYPE_NOT_SET.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            int[] iArr2 = new int[h.b.values().length];
            b = iArr2;
            try {
                iArr2[h.b.COMPOSITE_FILTER.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                b[h.b.FIELD_FILTER.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                b[h.b.UNARY_FILTER.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                b[h.b.FILTERTYPE_NOT_SET.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            int[] iArr3 = new int[i.g.values().length];
            a = iArr3;
            try {
                iArr3[i.g.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                a[i.g.IS_INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError e8) {
            }
            try {
                a[i.g.MAKE_IMMUTABLE.ordinal()] = 3;
            } catch (NoSuchFieldError e9) {
            }
            try {
                a[i.g.NEW_BUILDER.ordinal()] = 4;
            } catch (NoSuchFieldError e10) {
            }
            try {
                a[i.g.VISIT.ordinal()] = 5;
            } catch (NoSuchFieldError e11) {
            }
            try {
                a[i.g.MERGE_FROM_STREAM.ordinal()] = 6;
            } catch (NoSuchFieldError e12) {
            }
            try {
                a[i.g.GET_DEFAULT_INSTANCE.ordinal()] = 7;
            } catch (NoSuchFieldError e13) {
            }
            try {
                a[i.g.GET_PARSER.ordinal()] = 8;
            } catch (NoSuchFieldError e14) {
            }
        }
    }

    public static final class i extends com.google.protobuf.i<i, a> implements h10 {
        /* access modifiers changed from: private */
        public static final i a;

        /* renamed from: a  reason: collision with other field name */
        private static volatile n50<i> f2522a;

        /* renamed from: a  reason: collision with other field name */
        private g f2523a;
        private int c;

        private i() {
        }

        public g O() {
            g gVar = this.f2523a;
            return gVar == null ? g.M() : gVar;
        }

        /* access modifiers changed from: private */
        public void S(g value) {
            if (value != null) {
                this.f2523a = value;
                return;
            }
            throw new NullPointerException();
        }

        public e N() {
            e result = e.forNumber(this.c);
            return result == null ? e.UNRECOGNIZED : result;
        }

        /* access modifiers changed from: private */
        public void R(e value) {
            if (value != null) {
                this.c = value.getNumber();
                return;
            }
            throw new NullPointerException();
        }

        public void b(com.google.protobuf.g output) {
            if (this.f2523a != null) {
                output.l0(1, O());
            }
            if (this.c != e.DIRECTION_UNSPECIFIED.getNumber()) {
                output.Z(2, this.c);
            }
        }

        public int d() {
            int size = this.b;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.f2523a != null) {
                size2 = 0 + com.google.protobuf.g.w(1, O());
            }
            if (this.c != e.DIRECTION_UNSPECIFIED.getNumber()) {
                size2 += com.google.protobuf.g.l(2, this.c);
            }
            this.b = size2;
            return size2;
        }

        public static a P() {
            return (a) a.a();
        }

        public static final class a extends i.b<i, a> implements h10 {
            /* synthetic */ a(a x0) {
                this();
            }

            private a() {
                super(i.a);
            }

            public a y(g value) {
                s();
                ((i) this.b).S(value);
                return this;
            }

            public a x(e value) {
                s();
                ((i) this.b).R(value);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object p(i.g method, Object arg0, Object arg1) {
            switch (a.a[method.ordinal()]) {
                case 1:
                    return new i();
                case 2:
                    return a;
                case 3:
                    return null;
                case 4:
                    return new a((a) null);
                case 5:
                    i.h visitor = (i.h) arg0;
                    i other = (i) arg1;
                    this.f2523a = (g) visitor.m(this.f2523a, other.f2523a);
                    int i = this.c;
                    boolean z = true;
                    boolean z2 = i != 0;
                    int i2 = other.c;
                    if (i2 == 0) {
                        z = false;
                    }
                    this.c = visitor.p(z2, i, z, i2);
                    i.f fVar = i.f.a;
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
                                    g.a subBuilder = null;
                                    g gVar = this.f2523a;
                                    if (gVar != null) {
                                        subBuilder = (g.a) gVar.a();
                                    }
                                    g gVar2 = (g) input.u(g.P(), extensionRegistry);
                                    this.f2523a = gVar2;
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.w(gVar2);
                                        this.f2523a = (g) subBuilder.f();
                                        break;
                                    }
                                case 16:
                                    this.c = input.o();
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
                    if (f2522a == null) {
                        synchronized (i.class) {
                            if (f2522a == null) {
                                f2522a = new i.c(a);
                            }
                        }
                    }
                    return f2522a;
                default:
                    throw new UnsupportedOperationException();
            }
            return a;
        }

        static {
            i iVar = new i();
            a = iVar;
            iVar.x();
        }

        public static n50<i> Q() {
            return a.h();
        }
    }

    public static final class g extends com.google.protobuf.i<g, a> implements h10 {
        /* access modifiers changed from: private */
        public static final g a;

        /* renamed from: a  reason: collision with other field name */
        private static volatile n50<g> f2518a;

        /* renamed from: a  reason: collision with other field name */
        private String f2519a = "";

        private g() {
        }

        public String N() {
            return this.f2519a;
        }

        /* access modifiers changed from: private */
        public void Q(String value) {
            if (value != null) {
                this.f2519a = value;
                return;
            }
            throw new NullPointerException();
        }

        public void b(com.google.protobuf.g output) {
            if (!this.f2519a.isEmpty()) {
                output.r0(2, N());
            }
        }

        public int d() {
            int size = this.b;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (!this.f2519a.isEmpty()) {
                size2 = 0 + com.google.protobuf.g.D(2, N());
            }
            this.b = size2;
            return size2;
        }

        public static a O() {
            return (a) a.a();
        }

        public static final class a extends i.b<g, a> implements h10 {
            /* synthetic */ a(a x0) {
                this();
            }

            private a() {
                super(g.a);
            }

            public a x(String value) {
                s();
                ((g) this.b).Q(value);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object p(i.g method, Object arg0, Object arg1) {
            switch (a.a[method.ordinal()]) {
                case 1:
                    return new g();
                case 2:
                    return a;
                case 3:
                    return null;
                case 4:
                    return new a((a) null);
                case 5:
                    g other = (g) arg1;
                    this.f2519a = ((i.h) arg0).l(!this.f2519a.isEmpty(), this.f2519a, !other.f2519a.isEmpty(), other.f2519a);
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
                                    this.f2519a = input.I();
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
                    if (f2518a == null) {
                        synchronized (g.class) {
                            if (f2518a == null) {
                                f2518a = new i.c(a);
                            }
                        }
                    }
                    return f2518a;
                default:
                    throw new UnsupportedOperationException();
            }
            return a;
        }

        static {
            g gVar = new g();
            a = gVar;
            gVar.x();
        }

        public static g M() {
            return a;
        }

        public static n50<g> P() {
            return a.h();
        }
    }

    public static final class j extends com.google.protobuf.i<j, a> implements h10 {
        /* access modifiers changed from: private */
        public static final j a;

        /* renamed from: a  reason: collision with other field name */
        private static volatile n50<j> f2524a;

        /* renamed from: a  reason: collision with other field name */
        private l.d<g> f2525a = com.google.protobuf.i.s();

        private j() {
        }

        public void b(com.google.protobuf.g output) {
            for (int i = 0; i < this.f2525a.size(); i++) {
                output.l0(2, this.f2525a.get(i));
            }
        }

        public int d() {
            int size = this.b;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            for (int i = 0; i < this.f2525a.size(); i++) {
                size2 += com.google.protobuf.g.w(2, this.f2525a.get(i));
            }
            this.b = size2;
            return size2;
        }

        public static final class a extends i.b<j, a> implements h10 {
            /* synthetic */ a(a x0) {
                this();
            }

            private a() {
                super(j.a);
            }
        }

        /* access modifiers changed from: protected */
        public final Object p(i.g method, Object arg0, Object arg1) {
            switch (a.a[method.ordinal()]) {
                case 1:
                    return new j();
                case 2:
                    return a;
                case 3:
                    this.f2525a.i();
                    return null;
                case 4:
                    return new a((a) null);
                case 5:
                    this.f2525a = ((i.h) arg0).q(this.f2525a, ((j) arg1).f2525a);
                    i.f fVar = i.f.a;
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
                                    if (!this.f2525a.e()) {
                                        this.f2525a = com.google.protobuf.i.z(this.f2525a);
                                    }
                                    this.f2525a.add((g) input.u(g.P(), extensionRegistry));
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
                    if (f2524a == null) {
                        synchronized (j.class) {
                            if (f2524a == null) {
                                f2524a = new i.c(a);
                            }
                        }
                    }
                    return f2524a;
                default:
                    throw new UnsupportedOperationException();
            }
            return a;
        }

        static {
            j jVar = new j();
            a = jVar;
            jVar.x();
        }

        public static j L() {
            return a;
        }

        public static n50<j> M() {
            return a.h();
        }
    }

    public j c0() {
        j jVar = this.f2506a;
        return jVar == null ? j.L() : jVar;
    }

    public int Y() {
        return this.f2508a.size();
    }

    public c X(int index) {
        return this.f2508a.get(index);
    }

    private void T() {
        if (!this.f2508a.e()) {
            this.f2508a = com.google.protobuf.i.z(this.f2508a);
        }
    }

    /* access modifiers changed from: private */
    public void R(c.a builderForValue) {
        T();
        this.f2508a.add((c) builderForValue.q());
    }

    public boolean i0() {
        return this.f2505a != null;
    }

    public h e0() {
        h hVar = this.f2505a;
        return hVar == null ? h.P() : hVar;
    }

    /* access modifiers changed from: private */
    public void o0(h value) {
        if (value != null) {
            this.f2505a = value;
            return;
        }
        throw new NullPointerException();
    }

    public int b0() {
        return this.f2509b.size();
    }

    public i a0(int index) {
        return this.f2509b.get(index);
    }

    private void U() {
        if (!this.f2509b.e()) {
            this.f2509b = com.google.protobuf.i.z(this.f2509b);
        }
    }

    /* access modifiers changed from: private */
    public void S(i value) {
        if (value != null) {
            U();
            this.f2509b.add(value);
            return;
        }
        throw new NullPointerException();
    }

    public boolean h0() {
        return this.f2504a != null;
    }

    public b d0() {
        b bVar = this.f2504a;
        return bVar == null ? b.Q() : bVar;
    }

    /* access modifiers changed from: private */
    public void n0(b value) {
        if (value != null) {
            this.f2504a = value;
            return;
        }
        throw new NullPointerException();
    }

    public boolean f0() {
        return this.b != null;
    }

    public b W() {
        b bVar = this.b;
        return bVar == null ? b.Q() : bVar;
    }

    /* access modifiers changed from: private */
    public void l0(b value) {
        if (value != null) {
            this.b = value;
            return;
        }
        throw new NullPointerException();
    }

    public boolean g0() {
        return this.f2507a != null;
    }

    public com.google.protobuf.j Z() {
        com.google.protobuf.j jVar = this.f2507a;
        return jVar == null ? com.google.protobuf.j.M() : jVar;
    }

    /* access modifiers changed from: private */
    public void m0(j.b builderForValue) {
        this.f2507a = (com.google.protobuf.j) builderForValue.q();
    }

    public void b(com.google.protobuf.g output) {
        if (this.f2506a != null) {
            output.l0(1, c0());
        }
        for (int i2 = 0; i2 < this.f2508a.size(); i2++) {
            output.l0(2, this.f2508a.get(i2));
        }
        if (this.f2505a != null) {
            output.l0(3, e0());
        }
        for (int i3 = 0; i3 < this.f2509b.size(); i3++) {
            output.l0(4, this.f2509b.get(i3));
        }
        if (this.f2507a != null) {
            output.l0(5, Z());
        }
        int i4 = this.d;
        if (i4 != 0) {
            output.h0(6, i4);
        }
        if (this.f2504a != null) {
            output.l0(7, d0());
        }
        if (this.b != null) {
            output.l0(8, W());
        }
    }

    public int d() {
        int size = this.b;
        if (size != -1) {
            return size;
        }
        int size2 = 0;
        if (this.f2506a != null) {
            size2 = 0 + com.google.protobuf.g.w(1, c0());
        }
        for (int i2 = 0; i2 < this.f2508a.size(); i2++) {
            size2 += com.google.protobuf.g.w(2, this.f2508a.get(i2));
        }
        if (this.f2505a != null) {
            size2 += com.google.protobuf.g.w(3, e0());
        }
        for (int i3 = 0; i3 < this.f2509b.size(); i3++) {
            size2 += com.google.protobuf.g.w(4, this.f2509b.get(i3));
        }
        if (this.f2507a != null) {
            size2 += com.google.protobuf.g.w(5, Z());
        }
        int i4 = this.d;
        if (i4 != 0) {
            size2 += com.google.protobuf.g.r(6, i4);
        }
        if (this.f2504a != null) {
            size2 += com.google.protobuf.g.w(7, d0());
        }
        if (this.b != null) {
            size2 += com.google.protobuf.g.w(8, W());
        }
        this.b = size2;
        return size2;
    }

    public static b j0() {
        return (b) a.a();
    }

    public static final class b extends i.b<n, b> implements h10 {
        /* synthetic */ b(a x0) {
            this();
        }

        private b() {
            super(n.a);
        }

        public b x(c.a builderForValue) {
            s();
            ((n) this.b).R(builderForValue);
            return this;
        }

        public b D(h value) {
            s();
            ((n) this.b).o0(value);
            return this;
        }

        public b y(i value) {
            s();
            ((n) this.b).S(value);
            return this;
        }

        public b B(b value) {
            s();
            ((n) this.b).n0(value);
            return this;
        }

        public b z(b value) {
            s();
            ((n) this.b).l0(value);
            return this;
        }

        public b A(j.b builderForValue) {
            s();
            ((n) this.b).m0(builderForValue);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public final Object p(i.g method, Object arg0, Object arg1) {
        switch (a.a[method.ordinal()]) {
            case 1:
                return new n();
            case 2:
                return a;
            case 3:
                this.f2508a.i();
                this.f2509b.i();
                return null;
            case 4:
                return new b((a) null);
            case 5:
                i.h visitor = (i.h) arg0;
                n other = (n) arg1;
                this.f2506a = (j) visitor.m(this.f2506a, other.f2506a);
                this.f2508a = visitor.q(this.f2508a, other.f2508a);
                this.f2505a = (h) visitor.m(this.f2505a, other.f2505a);
                this.f2509b = visitor.q(this.f2509b, other.f2509b);
                this.f2504a = (b) visitor.m(this.f2504a, other.f2504a);
                this.b = (b) visitor.m(this.b, other.b);
                int i2 = this.d;
                boolean z = true;
                boolean z2 = i2 != 0;
                int i3 = other.d;
                if (i3 == 0) {
                    z = false;
                }
                this.d = visitor.p(z2, i2, z, i3);
                this.f2507a = (com.google.protobuf.j) visitor.m(this.f2507a, other.f2507a);
                if (visitor == i.f.a) {
                    this.c |= other.c;
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
                                j.a subBuilder = null;
                                j jVar = this.f2506a;
                                if (jVar != null) {
                                    subBuilder = (j.a) jVar.a();
                                }
                                j jVar2 = (j) input.u(j.M(), extensionRegistry);
                                this.f2506a = jVar2;
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.w(jVar2);
                                    this.f2506a = (j) subBuilder.f();
                                    break;
                                }
                            case 18:
                                if (!this.f2508a.e()) {
                                    this.f2508a = com.google.protobuf.i.z(this.f2508a);
                                }
                                this.f2508a.add((c) input.u(c.Q(), extensionRegistry));
                                break;
                            case 26:
                                h.a subBuilder2 = null;
                                h hVar = this.f2505a;
                                if (hVar != null) {
                                    subBuilder2 = (h.a) hVar.a();
                                }
                                h hVar2 = (h) input.u(h.U(), extensionRegistry);
                                this.f2505a = hVar2;
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.w(hVar2);
                                    this.f2505a = (h) subBuilder2.f();
                                    break;
                                }
                            case 34:
                                if (!this.f2509b.e()) {
                                    this.f2509b = com.google.protobuf.i.z(this.f2509b);
                                }
                                this.f2509b.add((i) input.u(i.Q(), extensionRegistry));
                                break;
                            case 42:
                                j.b subBuilder3 = null;
                                com.google.protobuf.j jVar3 = this.f2507a;
                                if (jVar3 != null) {
                                    subBuilder3 = (j.b) jVar3.a();
                                }
                                com.google.protobuf.j jVar4 = (com.google.protobuf.j) input.u(com.google.protobuf.j.P(), extensionRegistry);
                                this.f2507a = jVar4;
                                if (subBuilder3 == null) {
                                    break;
                                } else {
                                    subBuilder3.w(jVar4);
                                    this.f2507a = (com.google.protobuf.j) subBuilder3.f();
                                    break;
                                }
                            case 48:
                                this.d = input.s();
                                break;
                            case 58:
                                b.C0028b subBuilder4 = null;
                                b bVar = this.f2504a;
                                if (bVar != null) {
                                    subBuilder4 = (b.C0028b) bVar.a();
                                }
                                b bVar2 = (b) input.u(b.U(), extensionRegistry);
                                this.f2504a = bVar2;
                                if (subBuilder4 == null) {
                                    break;
                                } else {
                                    subBuilder4.w(bVar2);
                                    this.f2504a = (b) subBuilder4.f();
                                    break;
                                }
                            case 66:
                                b.C0028b subBuilder5 = null;
                                b bVar3 = this.b;
                                if (bVar3 != null) {
                                    subBuilder5 = (b.C0028b) bVar3.a();
                                }
                                b bVar4 = (b) input.u(b.U(), extensionRegistry);
                                this.b = bVar4;
                                if (subBuilder5 == null) {
                                    break;
                                } else {
                                    subBuilder5.w(bVar4);
                                    this.b = (b) subBuilder5.f();
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
                if (f2503a == null) {
                    synchronized (n.class) {
                        if (f2503a == null) {
                            f2503a = new i.c(a);
                        }
                    }
                }
                return f2503a;
            default:
                throw new UnsupportedOperationException();
        }
        return a;
    }

    static {
        n nVar = new n();
        a = nVar;
        nVar.x();
    }

    public static n V() {
        return a;
    }

    public static n50<n> k0() {
        return a.h();
    }
}
