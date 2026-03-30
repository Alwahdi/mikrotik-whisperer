package com.google.protobuf;

import com.google.protobuf.a;
import com.google.protobuf.a.C0031a;
import com.google.protobuf.p;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;

public abstract class a<MessageType extends a<MessageType, BuilderType>, BuilderType extends C0031a<MessageType, BuilderType>> implements p {
    protected int a = 0;

    public byte[] e() {
        try {
            byte[] result = new byte[d()];
            g output = g.N(result);
            b(output);
            output.d();
            return result;
        } catch (IOException e) {
            throw new RuntimeException(j("byte array"), e);
        }
    }

    public void writeTo(OutputStream output) {
        g codedOutput = g.M(output, g.y(d()));
        b(codedOutput);
        codedOutput.K();
    }

    /* access modifiers changed from: package-private */
    public ht0 k() {
        return new ht0(this);
    }

    private String j(String target) {
        return "Serializing " + getClass().getName() + " to a " + target + " threw an IOException (should never happen).";
    }

    protected static <T> void i(Iterable<T> values, Collection<? super T> list) {
        C0031a.i(values, list);
    }

    /* renamed from: com.google.protobuf.a$a  reason: collision with other inner class name */
    public static abstract class C0031a<MessageType extends a<MessageType, BuilderType>, BuilderType extends C0031a<MessageType, BuilderType>> implements p.a {
        /* access modifiers changed from: protected */
        public abstract BuilderType k(MessageType messagetype);

        /* renamed from: l */
        public BuilderType C(p other) {
            if (g().getClass().isInstance(other)) {
                return k((a) other);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        protected static ht0 m(p message) {
            return new ht0(message);
        }

        protected static <T> void i(Iterable<T> values, Collection<? super T> list) {
            if (values == null) {
                throw new NullPointerException();
            } else if (values instanceof Collection) {
                j(values);
                list.addAll((Collection) values);
            } else {
                for (T value : values) {
                    if (value != null) {
                        list.add(value);
                    } else {
                        throw new NullPointerException();
                    }
                }
            }
        }

        private static void j(Iterable<?> values) {
            for (Object value : values) {
                if (value == null) {
                    throw new NullPointerException();
                }
            }
        }
    }
}
