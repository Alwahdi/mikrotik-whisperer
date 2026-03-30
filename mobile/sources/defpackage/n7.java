package defpackage;

import defpackage.a9;
import defpackage.f20;
import io.grpc.ClientStreamTracer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: n7  reason: default package */
public final class n7 {
    public static final n7 a = new n7();

    /* renamed from: a  reason: collision with other field name */
    private Boolean f4406a;

    /* renamed from: a  reason: collision with other field name */
    private Integer f4407a;

    /* renamed from: a  reason: collision with other field name */
    private String f4408a;

    /* renamed from: a  reason: collision with other field name */
    private List<a9.a> f4409a = Collections.emptyList();

    /* renamed from: a  reason: collision with other field name */
    private Executor f4410a;

    /* renamed from: a  reason: collision with other field name */
    private m7 f4411a;

    /* renamed from: a  reason: collision with other field name */
    private ze f4412a;

    /* renamed from: a  reason: collision with other field name */
    private Object[][] f4413a = ((Object[][]) Array.newInstance(Object.class, new int[]{0, 2}));
    private Integer b;

    /* renamed from: b  reason: collision with other field name */
    private String f4414b;

    public n7 k(m7 credentials) {
        n7 newOptions = new n7(this);
        newOptions.f4411a = credentials;
        return newOptions;
    }

    public n7 l(ze deadline) {
        n7 newOptions = new n7(this);
        newOptions.f4412a = deadline;
        return newOptions;
    }

    public ze d() {
        return this.f4412a;
    }

    public n7 r() {
        n7 newOptions = new n7(this);
        newOptions.f4406a = Boolean.TRUE;
        return newOptions;
    }

    public n7 s() {
        n7 newOptions = new n7(this);
        newOptions.f4406a = Boolean.FALSE;
        return newOptions;
    }

    public String b() {
        return this.f4414b;
    }

    public String a() {
        return this.f4408a;
    }

    public m7 c() {
        return this.f4411a;
    }

    public n7 m(Executor executor) {
        n7 newOptions = new n7(this);
        newOptions.f4410a = executor;
        return newOptions;
    }

    public n7 q(a9.a factory) {
        n7 newOptions = new n7(this);
        ArrayList<ClientStreamTracer.Factory> newList = new ArrayList<>(this.f4409a.size() + 1);
        newList.addAll(this.f4409a);
        newList.add(factory);
        newOptions.f4409a = Collections.unmodifiableList(newList);
        return newOptions;
    }

    public List<a9.a> i() {
        return this.f4409a;
    }

    /* renamed from: n7$a */
    public static final class a<T> {
        /* access modifiers changed from: private */
        public final T a;

        /* renamed from: a  reason: collision with other field name */
        private final String f4415a;

        private a(String debugString, T defaultValue) {
            this.f4415a = debugString;
            this.a = defaultValue;
        }

        public String toString() {
            return this.f4415a;
        }

        public static <T> a<T> b(String debugString) {
            v90.o(debugString, "debugString");
            return new a<>(debugString, (Object) null);
        }
    }

    public <T> n7 p(a<T> key, T value) {
        v90.o(key, "key");
        v90.o(value, "value");
        n7 newOptions = new n7(this);
        int existingIdx = -1;
        int i = 0;
        while (true) {
            Object[][] objArr = this.f4413a;
            if (i >= objArr.length) {
                break;
            } else if (key.equals(objArr[i][0])) {
                existingIdx = i;
                break;
            } else {
                i++;
            }
        }
        int length = this.f4413a.length;
        int i2 = existingIdx == -1 ? 1 : 0;
        int[] iArr = new int[2];
        iArr[1] = 2;
        iArr[0] = length + i2;
        Object[][] objArr2 = (Object[][]) Array.newInstance(Object.class, iArr);
        newOptions.f4413a = objArr2;
        Object[][] objArr3 = this.f4413a;
        System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
        if (existingIdx == -1) {
            newOptions.f4413a[this.f4413a.length] = new Object[]{key, value};
        } else {
            newOptions.f4413a[existingIdx] = new Object[]{key, value};
        }
        return newOptions;
    }

    public <T> T h(a<T> key) {
        v90.o(key, "key");
        int i = 0;
        while (true) {
            Object[][] objArr = this.f4413a;
            if (i >= objArr.length) {
                return key.a;
            }
            if (key.equals(objArr[i][0])) {
                return this.f4413a[i][1];
            }
            i++;
        }
    }

    public Executor e() {
        return this.f4410a;
    }

    private n7() {
    }

    public boolean j() {
        return Boolean.TRUE.equals(this.f4406a);
    }

    public n7 n(int maxSize) {
        v90.h(maxSize >= 0, "invalid maxsize %s", maxSize);
        n7 newOptions = new n7(this);
        newOptions.f4407a = Integer.valueOf(maxSize);
        return newOptions;
    }

    public n7 o(int maxSize) {
        v90.h(maxSize >= 0, "invalid maxsize %s", maxSize);
        n7 newOptions = new n7(this);
        newOptions.b = Integer.valueOf(maxSize);
        return newOptions;
    }

    public Integer f() {
        return this.f4407a;
    }

    public Integer g() {
        return this.b;
    }

    private n7(n7 other) {
        this.f4412a = other.f4412a;
        this.f4408a = other.f4408a;
        this.f4411a = other.f4411a;
        this.f4410a = other.f4410a;
        this.f4414b = other.f4414b;
        this.f4413a = other.f4413a;
        this.f4406a = other.f4406a;
        this.f4407a = other.f4407a;
        this.b = other.b;
        this.f4409a = other.f4409a;
    }

    public String toString() {
        f20.b d = f20.c(this).d("deadline", this.f4412a).d("authority", this.f4408a).d("callCredentials", this.f4411a);
        Executor executor = this.f4410a;
        return d.d("executor", executor != null ? executor.getClass() : null).d("compressorName", this.f4414b).d("customOptions", Arrays.deepToString(this.f4413a)).e("waitForReady", j()).d("maxInboundMessageSize", this.f4407a).d("maxOutboundMessageSize", this.b).d("streamTracerFactories", this.f4409a).toString();
    }
}
