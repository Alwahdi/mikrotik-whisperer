package defpackage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/* renamed from: d  reason: default package */
public final class d implements kk {
    public static final a a = new a((Cif) null);

    /* renamed from: a  reason: collision with other field name */
    private static final Class<? extends Object>[] f2682a = {Context.class};
    private static final Class<? extends Object>[] b = {Context.class, AttributeSet.class};

    /* renamed from: d$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(Cif $constructor_marker) {
            this();
        }
    }

    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        Object[] constructorArgs;
        Constructor constructor;
        lu.g(name, "name");
        lu.g(context, "context");
        try {
            Class clazz = Class.forName(name).asSubclass(View.class);
            try {
                Class<? extends Object>[] clsArr = b;
                Constructor constructor2 = clazz.getConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
                lu.b(constructor2, "clazz.getConstructor(*CONSTRUCTOR_SIGNATURE_2)");
                constructor = constructor2;
                constructorArgs = new Object[]{context, attrs};
            } catch (NoSuchMethodException e) {
                Class<? extends Object>[] clsArr2 = f2682a;
                Constructor constructor3 = clazz.getConstructor((Class[]) Arrays.copyOf(clsArr2, clsArr2.length));
                lu.b(constructor3, "clazz.getConstructor(*CONSTRUCTOR_SIGNATURE_1)");
                constructor = constructor3;
                constructorArgs = new Context[]{context};
            }
            constructor.setAccessible(true);
            return (View) constructor.newInstance(Arrays.copyOf(constructorArgs, constructorArgs.length));
        } catch (Exception e2) {
            if (e2 instanceof ClassNotFoundException) {
                e2.printStackTrace();
                return null;
            } else if (e2 instanceof NoSuchMethodException) {
                e2.printStackTrace();
                return null;
            } else if (e2 instanceof IllegalAccessException) {
                e2.printStackTrace();
                return null;
            } else if (e2 instanceof InstantiationException) {
                e2.printStackTrace();
                return null;
            } else if (e2 instanceof InvocationTargetException) {
                e2.printStackTrace();
                return null;
            } else {
                throw e2;
            }
        }
    }
}
