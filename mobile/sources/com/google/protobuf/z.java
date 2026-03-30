package com.google.protobuf;

import java.io.IOException;

public abstract class z {
    static final int a = c(1, 3);
    static final int b = c(1, 4);
    static final int c = c(2, 0);
    static final int d = c(3, 2);

    enum d {
        LOOSE {
            /* access modifiers changed from: package-private */
            public Object readString(f input) throws IOException {
                return input.H();
            }
        },
        STRICT {
            /* access modifiers changed from: package-private */
            public Object readString(f input) throws IOException {
                return input.I();
            }
        },
        LAZY {
            /* access modifiers changed from: package-private */
            public Object readString(f input) throws IOException {
                return input.m();
            }
        };

        /* access modifiers changed from: package-private */
        public abstract Object readString(f fVar) throws IOException;
    }

    public static int b(int tag) {
        return tag & 7;
    }

    public static int a(int tag) {
        return tag >>> 3;
    }

    static int c(int fieldNumber, int wireType) {
        return (fieldNumber << 3) | wireType;
    }

    public enum c {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(false),
        STRING(""),
        BYTE_STRING(e.f2563a),
        ENUM((String) null),
        MESSAGE((String) null);
        
        private final Object defaultDefault;

        private c(Object defaultDefault2) {
            this.defaultDefault = defaultDefault2;
        }

        /* access modifiers changed from: package-private */
        public Object getDefaultDefault() {
            return this.defaultDefault;
        }
    }

    public enum b {
        DOUBLE(c.DOUBLE, 1),
        FLOAT(c.FLOAT, 5),
        INT64(r5, 0),
        UINT64(r5, 0),
        INT32(r11, 0),
        FIXED64(r5, 1),
        FIXED32(r11, 5),
        BOOL(c.BOOLEAN, 0),
        STRING(c.STRING, 2) {
            public boolean isPackable() {
                return false;
            }
        },
        GROUP(r13, 3) {
            public boolean isPackable() {
                return false;
            }
        },
        MESSAGE(r13, 2) {
            public boolean isPackable() {
                return false;
            }
        },
        BYTES(c.BYTE_STRING, 2) {
            public boolean isPackable() {
                return false;
            }
        },
        UINT32(r11, 0),
        ENUM(c.ENUM, 0),
        SFIXED32(r11, 5),
        SFIXED64(r5, 1),
        SINT32(r11, 0),
        SINT64(r5, 0);
        
        private final c javaType;
        private final int wireType;

        private b(c javaType2, int wireType2) {
            this.javaType = javaType2;
            this.wireType = wireType2;
        }

        public c getJavaType() {
            return this.javaType;
        }

        public int getWireType() {
            return this.wireType;
        }

        public boolean isPackable() {
            return true;
        }
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[b.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[b.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[b.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[b.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[b.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[b.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                a[b.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                a[b.BYTES.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                a[b.UINT32.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                a[b.SFIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                a[b.SFIXED64.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                a[b.SINT32.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                a[b.SINT64.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                a[b.STRING.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                a[b.GROUP.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                a[b.MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                a[b.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
        }
    }

    static Object d(f input, b type, d utf8Validation) {
        switch (a.a[type.ordinal()]) {
            case 1:
                return Double.valueOf(input.n());
            case 2:
                return Float.valueOf(input.r());
            case 3:
                return Long.valueOf(input.t());
            case 4:
                return Long.valueOf(input.L());
            case 5:
                return Integer.valueOf(input.s());
            case 6:
                return Long.valueOf(input.q());
            case 7:
                return Integer.valueOf(input.p());
            case 8:
                return Boolean.valueOf(input.l());
            case 9:
                return input.m();
            case 10:
                return Integer.valueOf(input.K());
            case 11:
                return Integer.valueOf(input.D());
            case 12:
                return Long.valueOf(input.E());
            case 13:
                return Integer.valueOf(input.F());
            case 14:
                return Long.valueOf(input.G());
            case 15:
                return utf8Validation.readString(input);
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }
}
