package com.google.protobuf;

import com.google.protobuf.h.b;
import com.google.protobuf.l;
import com.google.protobuf.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class h<FieldDescriptorType extends b<FieldDescriptorType>> {
    private static final h a = new h(true);

    /* renamed from: a  reason: collision with other field name */
    private final t<FieldDescriptorType, Object> f2575a = t.o(16);

    /* renamed from: a  reason: collision with other field name */
    private boolean f2576a;
    private boolean b = false;

    public interface b<T extends b<T>> extends Comparable<T> {
        z.b f();

        boolean m();
    }

    private h() {
    }

    private h(boolean dummy) {
        e();
    }

    public static <T extends b<T>> h<T> f() {
        return new h<>();
    }

    public void e() {
        if (!this.f2576a) {
            this.f2575a.n();
            this.f2576a = true;
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof h)) {
            return false;
        }
        return this.f2575a.equals(((h) o).f2575a);
    }

    public int hashCode() {
        return this.f2575a.hashCode();
    }

    /* renamed from: a */
    public h<FieldDescriptorType> clone() {
        FieldSet<FieldDescriptorType> clone = f();
        for (int i = 0; i < this.f2575a.i(); i++) {
            Map.Entry<FieldDescriptorType, Object> entry = this.f2575a.h(i);
            clone.h((b) entry.getKey(), entry.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry2 : this.f2575a.k()) {
            clone.h((b) entry2.getKey(), entry2.getValue());
        }
        clone.b = this.b;
        return clone;
    }

    public void h(FieldDescriptorType descriptor, Object value) {
        if (!descriptor.m()) {
            i(descriptor.f(), value);
        } else if (value instanceof List) {
            List<Object> newList = new ArrayList<>();
            newList.addAll((List) value);
            for (Object element : newList) {
                i(descriptor.f(), element);
            }
            value = newList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        this.f2575a.p(descriptor, value);
    }

    private static void i(z.b type, Object value) {
        if (value != null) {
            boolean isValid = false;
            boolean z = false;
            switch (a.a[type.getJavaType().ordinal()]) {
                case 1:
                    isValid = value instanceof Integer;
                    break;
                case 2:
                    isValid = value instanceof Long;
                    break;
                case 3:
                    isValid = value instanceof Float;
                    break;
                case 4:
                    isValid = value instanceof Double;
                    break;
                case 5:
                    isValid = value instanceof Boolean;
                    break;
                case 6:
                    isValid = value instanceof String;
                    break;
                case 7:
                    if ((value instanceof e) || (value instanceof byte[])) {
                        z = true;
                    }
                    isValid = z;
                    break;
                case 8:
                    if ((value instanceof Integer) || (value instanceof l.a)) {
                        z = true;
                    }
                    isValid = z;
                    break;
                case 9:
                    if (value instanceof p) {
                        z = true;
                    }
                    isValid = z;
                    break;
            }
            if (!isValid) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            return;
        }
        throw new NullPointerException();
    }

    static int d(z.b type, boolean isPacked) {
        if (isPacked) {
            return 2;
        }
        return type.getWireType();
    }

    public static Object g(f input, z.b type, boolean checkUtf8) {
        if (checkUtf8) {
            return z.d(input, type, z.d.STRICT);
        }
        return z.d(input, type, z.d.LOOSE);
    }

    static void j(g output, z.b type, int number, Object value) {
        if (type == z.b.GROUP) {
            output.f0(number, (p) value);
            return;
        }
        output.t0(number, d(type, false));
        k(output, type, value);
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[z.b.values().length];
            b = iArr;
            try {
                iArr[z.b.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[z.b.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                b[z.b.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                b[z.b.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                b[z.b.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                b[z.b.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                b[z.b.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                b[z.b.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                b[z.b.GROUP.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                b[z.b.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                b[z.b.STRING.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                b[z.b.BYTES.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                b[z.b.UINT32.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                b[z.b.SFIXED32.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                b[z.b.SFIXED64.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                b[z.b.SINT32.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                b[z.b.SINT64.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                b[z.b.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
            int[] iArr2 = new int[z.c.values().length];
            a = iArr2;
            try {
                iArr2[z.c.INT.ordinal()] = 1;
            } catch (NoSuchFieldError e19) {
            }
            try {
                a[z.c.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError e20) {
            }
            try {
                a[z.c.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError e21) {
            }
            try {
                a[z.c.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError e22) {
            }
            try {
                a[z.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError e23) {
            }
            try {
                a[z.c.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError e24) {
            }
            try {
                a[z.c.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError e25) {
            }
            try {
                a[z.c.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError e26) {
            }
            try {
                a[z.c.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError e27) {
            }
        }
    }

    static void k(g output, z.b type, Object value) {
        switch (a.b[type.ordinal()]) {
            case 1:
                output.Y(((Double) value).doubleValue());
                return;
            case 2:
                output.e0(((Float) value).floatValue());
                return;
            case 3:
                output.k0(((Long) value).longValue());
                return;
            case 4:
                output.w0(((Long) value).longValue());
                return;
            case 5:
                output.i0(((Integer) value).intValue());
                return;
            case 6:
                output.d0(((Long) value).longValue());
                return;
            case 7:
                output.b0(((Integer) value).intValue());
                return;
            case 8:
                output.S(((Boolean) value).booleanValue());
                return;
            case 9:
                output.g0((p) value);
                return;
            case 10:
                output.m0((p) value);
                return;
            case 11:
                if (value instanceof e) {
                    output.W((e) value);
                    return;
                } else {
                    output.s0((String) value);
                    return;
                }
            case 12:
                if (value instanceof e) {
                    output.W((e) value);
                    return;
                } else {
                    output.T((byte[]) value);
                    return;
                }
            case 13:
                output.u0(((Integer) value).intValue());
                return;
            case 14:
                output.n0(((Integer) value).intValue());
                return;
            case 15:
                output.o0(((Long) value).longValue());
                return;
            case 16:
                output.p0(((Integer) value).intValue());
                return;
            case 17:
                output.q0(((Long) value).longValue());
                return;
            case 18:
                if (value instanceof l.a) {
                    output.a0(((l.a) value).getNumber());
                    return;
                } else {
                    output.a0(((Integer) value).intValue());
                    return;
                }
            default:
                return;
        }
    }

    static int b(z.b type, int number, Object value) {
        int tagSize = g.F(number);
        if (type == z.b.GROUP) {
            tagSize *= 2;
        }
        return c(type, value) + tagSize;
    }

    static int c(z.b type, Object value) {
        switch (a.b[type.ordinal()]) {
            case 1:
                return g.k(((Double) value).doubleValue());
            case 2:
                return g.p(((Float) value).floatValue());
            case 3:
                return g.u(((Long) value).longValue());
            case 4:
                return g.H(((Long) value).longValue());
            case 5:
                return g.s(((Integer) value).intValue());
            case 6:
                return g.o(((Long) value).longValue());
            case 7:
                return g.n(((Integer) value).intValue());
            case 8:
                return g.f(((Boolean) value).booleanValue());
            case 9:
                return g.q((p) value);
            case 10:
                return g.x((p) value);
            case 11:
                if (value instanceof e) {
                    return g.i((e) value);
                }
                return g.E((String) value);
            case 12:
                if (value instanceof e) {
                    return g.i((e) value);
                }
                return g.g((byte[]) value);
            case 13:
                return g.G(((Integer) value).intValue());
            case 14:
                return g.z(((Integer) value).intValue());
            case 15:
                return g.A(((Long) value).longValue());
            case 16:
                return g.B(((Integer) value).intValue());
            case 17:
                return g.C(((Long) value).longValue());
            case 18:
                if (value instanceof l.a) {
                    return g.m(((l.a) value).getNumber());
                }
                return g.m(((Integer) value).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }
}
