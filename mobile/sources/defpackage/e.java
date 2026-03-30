package defpackage;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.BuildCompat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: e  reason: default package */
public final class e extends LayoutInflater {
    public static final b a = new b((Cif) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public static final Set<String> f2832a = bl0.d("android.widget.", "android.webkit.");
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public static final rw f2833a = vw.a(a.a);

    /* renamed from: a  reason: collision with other field name */
    private final kk f2834a;

    /* renamed from: a  reason: collision with other field name */
    private final boolean f2835a;
    private final kk b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f2836b;
    private boolean c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(LayoutInflater original, Context newContext, boolean cloned) {
        super(original, newContext);
        lu.g(original, "original");
        lu.g(newContext, "newContext");
        this.f2835a = Build.VERSION.SDK_INT > 28 || BuildCompat.isAtLeastQ();
        this.f2834a = new c(this);
        this.b = new d(this);
        this.c = iv0.a.b().h();
        h(cloned);
    }

    public LayoutInflater cloneInContext(Context newContext) {
        lu.g(newContext, "newContext");
        return new e(this, newContext, true);
    }

    public View inflate(int resource, ViewGroup root, boolean attachToRoot) {
        View view = super.inflate(resource, root, attachToRoot);
        if (view != null && this.c) {
            view.setTag(jc0.viewpump_layout_res, Integer.valueOf(resource));
        }
        return view;
    }

    public View inflate(XmlPullParser parser, ViewGroup root, boolean attachToRoot) {
        lu.g(parser, "parser");
        g();
        View inflate = super.inflate(parser, root, attachToRoot);
        lu.b(inflate, "super.inflate(parser, root, attachToRoot)");
        return inflate;
    }

    private final void h(boolean cloned) {
        if (!cloned) {
            if (getFactory2() != null && !(getFactory2() instanceof g)) {
                setFactory2(getFactory2());
            }
            if (getFactory() != null && !(getFactory() instanceof i)) {
                setFactory(getFactory());
            }
        }
    }

    public void setFactory(LayoutInflater.Factory factory) {
        lu.g(factory, "factory");
        if (!(factory instanceof i)) {
            super.setFactory(new i(factory));
        } else {
            super.setFactory(factory);
        }
    }

    public void setFactory2(LayoutInflater.Factory2 factory2) {
        lu.g(factory2, "factory2");
        if (!(factory2 instanceof g)) {
            super.setFactory2(new g(factory2));
        } else {
            super.setFactory2(factory2);
        }
    }

    private final void g() {
        if (this.f2836b || !iv0.a.b().g()) {
            return;
        }
        if (!(getContext() instanceof LayoutInflater.Factory2)) {
            this.f2836b = true;
            return;
        }
        Method setPrivateFactoryMethod = c.a(LayoutInflater.class, "setPrivateFactory");
        Object[] objArr = new Object[1];
        Context context = getContext();
        if (context != null) {
            objArr[0] = new C0039e((LayoutInflater.Factory2) context, this);
            c.b(setPrivateFactoryMethod, this, objArr);
            this.f2836b = true;
            return;
        }
        throw new ys0("null cannot be cast to non-null type android.view.LayoutInflater.Factory2");
    }

    /* access modifiers changed from: protected */
    public View onCreateView(View parent, String name, AttributeSet attrs) {
        lu.g(name, "name");
        iv0 b2 = iv0.a.b();
        Context context = getContext();
        lu.b(context, "context");
        return b2.d(new ns(name, context, attrs, parent, this.b)).e();
    }

    /* access modifiers changed from: protected */
    public View onCreateView(String name, AttributeSet attrs) {
        lu.g(name, "name");
        iv0 b2 = iv0.a.b();
        Context context = getContext();
        lu.b(context, "context");
        return b2.d(new ns(name, context, attrs, (View) null, this.f2834a, 8, (Cif) null)).e();
    }

    /* access modifiers changed from: private */
    public final View f(View view, String name, Context viewContext, AttributeSet attrs) {
        View mutableView = view;
        if (!iv0.a.b().f() || mutableView != null || eo0.m(name, '.', 0, false, 6, (Object) null) <= -1) {
            return mutableView;
        }
        if (this.f2835a) {
            return cloneInContext(viewContext).createView(name, (String) null, attrs);
        }
        b bVar = a;
        Object obj = bVar.b().get(this);
        if (obj != null) {
            Object[] constructorArgsArr = (Object[]) obj;
            Object lastContext = constructorArgsArr[0];
            constructorArgsArr[0] = viewContext;
            c.c(bVar.b(), this, constructorArgsArr);
            try {
                mutableView = createView(name, (String) null, attrs);
                constructorArgsArr[0] = lastContext;
            } catch (ClassNotFoundException e) {
                constructorArgsArr[0] = lastContext;
                bVar = a;
            } catch (Throwable th) {
                constructorArgsArr[0] = lastContext;
                c.c(a.b(), this, constructorArgsArr);
                throw th;
            }
            c.c(bVar.b(), this, constructorArgsArr);
            return mutableView;
        }
        throw new ys0("null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
    }

    /* access modifiers changed from: private */
    public final View i(View parent, String name, AttributeSet attrs) {
        try {
            return super.onCreateView(parent, name, attrs);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public final View j(String name, AttributeSet attrs) {
        try {
            return super.onCreateView(name, attrs);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    /* renamed from: e$d */
    private static final class d implements kk {
        private final e a;

        public d(e inflater) {
            lu.g(inflater, "inflater");
            this.a = inflater;
        }

        public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
            lu.g(name, "name");
            lu.g(context, "context");
            return this.a.i(parent, name, attrs);
        }
    }

    /* renamed from: e$c */
    private static final class c implements kk {
        private final e a;

        public c(e inflater) {
            lu.g(inflater, "inflater");
            this.a = inflater;
        }

        public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
            lu.g(name, "name");
            lu.g(context, "context");
            View view = null;
            for (String prefix : e.f2832a) {
                try {
                    view = this.a.createView(name, prefix, attrs);
                    if (view != null) {
                        break;
                    }
                } catch (ClassNotFoundException e) {
                }
            }
            if (view == null) {
                return this.a.j(name, attrs);
            }
            return view;
        }
    }

    /* renamed from: e$i */
    private static final class i implements LayoutInflater.Factory {
        private final kk a;

        public i(LayoutInflater.Factory factory) {
            lu.g(factory, "factory");
            this.a = new j(factory);
        }

        public View onCreateView(String name, Context context, AttributeSet attrs) {
            lu.g(name, "name");
            lu.g(context, "context");
            return iv0.a.b().d(new ns(name, context, attrs, (View) null, this.a, 8, (Cif) null)).e();
        }
    }

    /* renamed from: e$j */
    private static final class j implements kk {
        private final LayoutInflater.Factory a;

        public j(LayoutInflater.Factory factory) {
            lu.g(factory, "factory");
            this.a = factory;
        }

        public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
            lu.g(name, "name");
            lu.g(context, "context");
            return this.a.onCreateView(name, context, attrs);
        }
    }

    /* renamed from: e$g */
    private static class g implements LayoutInflater.Factory2 {
        private final h a;

        public g(LayoutInflater.Factory2 factory2) {
            lu.g(factory2, "factory2");
            this.a = new h(factory2);
        }

        public View onCreateView(String name, Context context, AttributeSet attrs) {
            lu.g(name, "name");
            lu.g(context, "context");
            return onCreateView((View) null, name, context, attrs);
        }

        public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
            lu.g(name, "name");
            lu.g(context, "context");
            return iv0.a.b().d(new ns(name, context, attrs, parent, this.a)).e();
        }
    }

    /* renamed from: e$h */
    private static class h implements kk {
        private final LayoutInflater.Factory2 a;

        public h(LayoutInflater.Factory2 factory2) {
            lu.g(factory2, "factory2");
            this.a = factory2;
        }

        /* access modifiers changed from: protected */
        public final LayoutInflater.Factory2 a() {
            return this.a;
        }

        public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
            lu.g(name, "name");
            lu.g(context, "context");
            return this.a.onCreateView(parent, name, context, attrs);
        }
    }

    /* renamed from: e$e  reason: collision with other inner class name */
    private static final class C0039e extends g {
        private final f a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0039e(LayoutInflater.Factory2 factory2, e inflater) {
            super(factory2);
            lu.g(factory2, "factory2");
            lu.g(inflater, "inflater");
            this.a = new f(factory2, inflater);
        }

        public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
            lu.g(name, "name");
            lu.g(context, "context");
            return iv0.a.b().d(new ns(name, context, attrs, parent, this.a)).e();
        }
    }

    /* renamed from: e$f */
    private static final class f extends h {
        private final e a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(LayoutInflater.Factory2 factory2, e inflater) {
            super(factory2);
            lu.g(factory2, "factory2");
            lu.g(inflater, "inflater");
            this.a = inflater;
        }

        public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
            lu.g(name, "name");
            lu.g(context, "context");
            return this.a.f(a().onCreateView(parent, name, context, attrs), name, context, attrs);
        }
    }

    /* renamed from: e$b */
    public static final class b {
        static final /* synthetic */ fw[] a = {xd0.e(new hb0(xd0.b(b.class), "CONSTRUCTOR_ARGS_FIELD", "getCONSTRUCTOR_ARGS_FIELD()Ljava/lang/reflect/Field;"))};

        /* access modifiers changed from: private */
        public final Field b() {
            rw c = e.f2833a;
            b bVar = e.a;
            fw fwVar = a[0];
            return (Field) c.getValue();
        }

        private b() {
        }

        public /* synthetic */ b(Cif $constructor_marker) {
            this();
        }
    }

    /* renamed from: e$a */
    static final class a extends ow implements tn<Field> {
        public static final a a = new a();

        a() {
            super(0);
        }

        /* renamed from: b */
        public final Field invoke() {
            Field $receiver = LayoutInflater.class.getDeclaredField("mConstructorArgs");
            if ($receiver != null) {
                $receiver.setAccessible(true);
                return $receiver;
            }
            throw new IllegalArgumentException("No constructor arguments field found in LayoutInflater!".toString());
        }
    }
}
