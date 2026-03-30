package defpackage;

import com.google.firestore.v1.ListenRequest;
import com.google.firestore.v1.ListenResponse;
import com.google.firestore.v1.WriteRequest;
import com.google.firestore.v1.WriteResponse;
import com.google.firestore.v1.j;
import com.google.firestore.v1.k;
import com.google.firestore.v1.s;
import com.google.firestore.v1.t;
import io.grpc.MethodDescriptor;
import io.grpc.m;

/* renamed from: gm  reason: default package */
public abstract class gm {
    private static volatile m<s, t> a;
    private static volatile m<j, k> b;

    public static m<s, t> b() {
        MethodDescriptor<WriteRequest, WriteResponse> methodDescriptor = a;
        MethodDescriptor<WriteRequest, WriteResponse> getWriteMethod = methodDescriptor;
        if (methodDescriptor == null) {
            synchronized (gm.class) {
                MethodDescriptor<WriteRequest, WriteResponse> methodDescriptor2 = a;
                getWriteMethod = methodDescriptor2;
                if (methodDescriptor2 == null) {
                    MethodDescriptor<WriteRequest, WriteResponse> a2 = m.g().f(m.d.BIDI_STREAMING).b(m.b("google.firestore.v1.Firestore", "Write")).e(true).c(kb0.b(s.R())).d(kb0.b(t.M())).a();
                    getWriteMethod = a2;
                    a = a2;
                }
            }
        }
        return getWriteMethod;
    }

    public static m<j, k> a() {
        MethodDescriptor<ListenRequest, ListenResponse> methodDescriptor = b;
        MethodDescriptor<ListenRequest, ListenResponse> getListenMethod = methodDescriptor;
        if (methodDescriptor == null) {
            synchronized (gm.class) {
                MethodDescriptor<ListenRequest, ListenResponse> methodDescriptor2 = b;
                getListenMethod = methodDescriptor2;
                if (methodDescriptor2 == null) {
                    MethodDescriptor<ListenRequest, ListenResponse> a2 = m.g().f(m.d.BIDI_STREAMING).b(m.b("google.firestore.v1.Firestore", "Listen")).e(true).c(kb0.b(j.Q())).d(kb0.b(k.L())).a();
                    getListenMethod = a2;
                    b = a2;
                }
            }
        }
        return getListenMethod;
    }

    public static b c(e8 channel) {
        return new b(channel);
    }

    /* renamed from: gm$b */
    public static final class b extends c0<b> {
        private b(e8 channel) {
            super(channel);
        }

        private b(e8 channel, n7 callOptions) {
            super(channel, callOptions);
        }

        /* access modifiers changed from: protected */
        /* renamed from: e */
        public b a(e8 channel, n7 callOptions) {
            return new b(channel, callOptions);
        }
    }
}
