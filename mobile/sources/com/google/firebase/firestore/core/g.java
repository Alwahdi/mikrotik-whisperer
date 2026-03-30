package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.h;
import com.google.firebase.firestore.model.b;
import java.util.Arrays;

public class g extends h {
    private final h.a a;

    /* renamed from: a  reason: collision with other field name */
    private final pk f2211a;

    /* renamed from: a  reason: collision with other field name */
    private final rk f2212a;

    protected g(pk field, h.a operator, rk value) {
        this.f2211a = field;
        this.a = operator;
        this.f2212a = value;
    }

    public h.a e() {
        return this.a;
    }

    public pk d() {
        return this.f2211a;
    }

    public rk f() {
        return this.f2212a;
    }

    public static g c(pk path, h.a operator, rk value) {
        if (path.u()) {
            if (operator == h.a.IN) {
                n4.d(value instanceof g4, "Comparing on key with IN, but the value was not an ArrayValue", new Object[0]);
                return new t(path, (g4) value);
            }
            n4.d(value instanceof wd0, "Comparing on key, but filter value not a ReferenceValue", new Object[0]);
            boolean z = (operator == h.a.ARRAY_CONTAINS || operator == h.a.ARRAY_CONTAINS_ANY) ? false : true;
            n4.d(z, operator.toString() + "queries don't make sense on document keys", new Object[0]);
            return new s(path, operator, (wd0) value);
        } else if (value.equals(p30.e())) {
            if (operator == h.a.EQUAL) {
                return new g(path, operator, value);
            }
            throw new IllegalArgumentException("Invalid Query. Null supports only equality comparisons (via whereEqualTo()).");
        } else if (value.equals(th.a)) {
            if (operator == h.a.EQUAL) {
                return new g(path, operator, value);
            }
            throw new IllegalArgumentException("Invalid Query. NaN supports only equality comparisons (via whereEqualTo()).");
        } else if (operator == h.a.ARRAY_CONTAINS) {
            return new b(path, value);
        } else {
            if (operator == h.a.IN) {
                n4.d(value instanceof g4, "IN filter has invalid value: " + value.toString(), new Object[0]);
                return new r(path, (g4) value);
            } else if (operator != h.a.ARRAY_CONTAINS_ANY) {
                return new g(path, operator, value);
            } else {
                n4.d(value instanceof g4, "ARRAY_CONTAINS_ANY filter has invalid value: " + value.toString(), new Object[0]);
                return new a(path, (g4) value);
            }
        }
    }

    public boolean b(b doc) {
        rk other = doc.e(this.f2211a);
        return other != null && this.f2212a.c() == other.c() && h(other.a(this.f2212a));
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[h.a.values().length];
            a = iArr;
            try {
                iArr[h.a.LESS_THAN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[h.a.LESS_THAN_OR_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[h.a.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[h.a.GREATER_THAN.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[h.a.GREATER_THAN_OR_EQUAL.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean h(int comp) {
        switch (a.a[this.a.ordinal()]) {
            case 1:
                if (comp < 0) {
                    return true;
                }
                return false;
            case 2:
                if (comp <= 0) {
                    return true;
                }
                return false;
            case 3:
                if (comp == 0) {
                    return true;
                }
                return false;
            case 4:
                if (comp > 0) {
                    return true;
                }
                return false;
            case 5:
                if (comp >= 0) {
                    return true;
                }
                return false;
            default:
                throw n4.a("Unknown FieldFilter operator: %s", this.a);
        }
    }

    public boolean g() {
        return Arrays.asList(new h.a[]{h.a.LESS_THAN, h.a.LESS_THAN_OR_EQUAL, h.a.GREATER_THAN, h.a.GREATER_THAN_OR_EQUAL}).contains(this.a);
    }

    public String a() {
        return d().c() + e().toString() + f().toString();
    }

    public String toString() {
        return this.f2211a.c() + " " + this.a + " " + this.f2212a;
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof g)) {
            return false;
        }
        g other = (g) o;
        if (this.a != other.a || !this.f2211a.equals(other.f2211a) || !this.f2212a.equals(other.f2212a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((37 * 31) + this.a.hashCode()) * 31) + this.f2211a.hashCode()) * 31) + this.f2212a.hashCode();
    }
}
