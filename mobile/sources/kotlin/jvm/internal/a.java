package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

public abstract class a implements zv, Serializable {
    public static final Object NO_RECEIVER = C0050a.a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient zv reflected;
    private final String signature;

    /* access modifiers changed from: protected */
    public abstract zv computeReflected();

    /* renamed from: kotlin.jvm.internal.a$a  reason: collision with other inner class name */
    private static class C0050a implements Serializable {
        /* access modifiers changed from: private */
        public static final C0050a a = new C0050a();

        private C0050a() {
        }
    }

    protected a(Object receiver2, Class owner2, String name2, String signature2, boolean isTopLevel2) {
        this.receiver = receiver2;
        this.owner = owner2;
        this.name = name2;
        this.signature = signature2;
        this.isTopLevel = isTopLevel2;
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public zv compute() {
        zv result = this.reflected;
        if (result != null) {
            return result;
        }
        zv result2 = computeReflected();
        this.reflected = result2;
        return result2;
    }

    /* access modifiers changed from: protected */
    public zv getReflected() {
        zv result = compute();
        if (result != this) {
            return result;
        }
        throw new kw();
    }

    public bw getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? xd0.c(cls) : xd0.b(cls);
    }

    public String getName() {
        return this.name;
    }

    public String getSignature() {
        return this.signature;
    }

    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    public gw getReturnType() {
        return getReflected().getReturnType();
    }

    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    public Object call(Object... args) {
        return getReflected().call(args);
    }

    public Object callBy(Map args) {
        return getReflected().callBy(args);
    }

    public kotlin.reflect.a getVisibility() {
        return getReflected().getVisibility();
    }

    public boolean isFinal() {
        return getReflected().isFinal();
    }

    public boolean isOpen() {
        return getReflected().isOpen();
    }

    public boolean isAbstract() {
        return getReflected().isAbstract();
    }
}
