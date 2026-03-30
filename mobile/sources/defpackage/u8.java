package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: u8  reason: default package */
public final class u8 implements aw<Object>, t8 {
    private static final HashMap<String, String> a;

    /* renamed from: a  reason: collision with other field name */
    private static final Map<Class<? extends oo<?>>, Integer> f5229a;

    /* renamed from: a  reason: collision with other field name */
    public static final a f5230a = new a((Cif) null);
    private static final HashMap<String, String> b;

    /* renamed from: b  reason: collision with other field name */
    private static final Map<String, String> f5231b;
    private static final HashMap<String, String> c;

    /* renamed from: a  reason: collision with other field name */
    private final Class<?> f5232a;

    public u8(Class<?> jClass) {
        lu.f(jClass, "jClass");
        this.f5232a = jClass;
    }

    public Class<?> a() {
        return this.f5232a;
    }

    public boolean equals(Object other) {
        return (other instanceof u8) && lu.a(xv.b(this), xv.b((aw) other));
    }

    public int hashCode() {
        return xv.b(this).hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }

    /* renamed from: u8$a */
    public static final class a {
        public /* synthetic */ a(Cif ifVar) {
            this();
        }

        private a() {
        }
    }

    static {
        Iterable $this$mapIndexedTo$iv$iv = l9.f(tn.class, vn.class, jo.class, lo.class, no.class, po.class, qo.class, ro.class, so.class, to.class, un.class, wn.class, xn.class, yn.class, zn.class, ao.class, bo.class, co.class, Cdo.class, eo.class, go.class, ho.class, io.class);
        Collection destination$iv$iv = new ArrayList(m9.i($this$mapIndexedTo$iv$iv, 10));
        int index$iv$iv = 0;
        for (Object item$iv$iv : $this$mapIndexedTo$iv$iv) {
            int index$iv$iv2 = index$iv$iv + 1;
            if (index$iv$iv < 0) {
                l9.h();
            }
            destination$iv$iv.add(ws0.a((Class) item$iv$iv, Integer.valueOf(index$iv$iv)));
            index$iv$iv = index$iv$iv2;
        }
        f5229a = a00.g(destination$iv$iv);
        HashMap hashMap = new HashMap();
        HashMap $this$primitiveFqNames_u24lambda_u241 = hashMap;
        $this$primitiveFqNames_u24lambda_u241.put("boolean", "kotlin.Boolean");
        $this$primitiveFqNames_u24lambda_u241.put("char", "kotlin.Char");
        $this$primitiveFqNames_u24lambda_u241.put("byte", "kotlin.Byte");
        $this$primitiveFqNames_u24lambda_u241.put("short", "kotlin.Short");
        $this$primitiveFqNames_u24lambda_u241.put("int", "kotlin.Int");
        $this$primitiveFqNames_u24lambda_u241.put("float", "kotlin.Float");
        $this$primitiveFqNames_u24lambda_u241.put("long", "kotlin.Long");
        $this$primitiveFqNames_u24lambda_u241.put("double", "kotlin.Double");
        a = hashMap;
        HashMap hashMap2 = new HashMap();
        HashMap $this$primitiveWrapperFqNames_u24lambda_u242 = hashMap2;
        $this$primitiveWrapperFqNames_u24lambda_u242.put("java.lang.Boolean", "kotlin.Boolean");
        $this$primitiveWrapperFqNames_u24lambda_u242.put("java.lang.Character", "kotlin.Char");
        $this$primitiveWrapperFqNames_u24lambda_u242.put("java.lang.Byte", "kotlin.Byte");
        $this$primitiveWrapperFqNames_u24lambda_u242.put("java.lang.Short", "kotlin.Short");
        $this$primitiveWrapperFqNames_u24lambda_u242.put("java.lang.Integer", "kotlin.Int");
        $this$primitiveWrapperFqNames_u24lambda_u242.put("java.lang.Float", "kotlin.Float");
        $this$primitiveWrapperFqNames_u24lambda_u242.put("java.lang.Long", "kotlin.Long");
        $this$primitiveWrapperFqNames_u24lambda_u242.put("java.lang.Double", "kotlin.Double");
        b = hashMap2;
        HashMap hashMap3 = new HashMap();
        HashMap $this$classFqNames_u24lambda_u244 = hashMap3;
        $this$classFqNames_u24lambda_u244.put("java.lang.Object", "kotlin.Any");
        $this$classFqNames_u24lambda_u244.put("java.lang.String", "kotlin.String");
        $this$classFqNames_u24lambda_u244.put("java.lang.CharSequence", "kotlin.CharSequence");
        $this$classFqNames_u24lambda_u244.put("java.lang.Throwable", "kotlin.Throwable");
        $this$classFqNames_u24lambda_u244.put("java.lang.Cloneable", "kotlin.Cloneable");
        $this$classFqNames_u24lambda_u244.put("java.lang.Number", "kotlin.Number");
        $this$classFqNames_u24lambda_u244.put("java.lang.Comparable", "kotlin.Comparable");
        $this$classFqNames_u24lambda_u244.put("java.lang.Enum", "kotlin.Enum");
        $this$classFqNames_u24lambda_u244.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        $this$classFqNames_u24lambda_u244.put("java.lang.Iterable", "kotlin.collections.Iterable");
        $this$classFqNames_u24lambda_u244.put("java.util.Iterator", "kotlin.collections.Iterator");
        $this$classFqNames_u24lambda_u244.put("java.util.Collection", "kotlin.collections.Collection");
        $this$classFqNames_u24lambda_u244.put("java.util.List", "kotlin.collections.List");
        $this$classFqNames_u24lambda_u244.put("java.util.Set", "kotlin.collections.Set");
        $this$classFqNames_u24lambda_u244.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        $this$classFqNames_u24lambda_u244.put("java.util.Map", "kotlin.collections.Map");
        $this$classFqNames_u24lambda_u244.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        $this$classFqNames_u24lambda_u244.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        $this$classFqNames_u24lambda_u244.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        $this$classFqNames_u24lambda_u244.putAll(hashMap);
        $this$classFqNames_u24lambda_u244.putAll(hashMap2);
        Iterable<String> $this$associateTo$iv = hashMap.values();
        lu.e($this$associateTo$iv, "primitiveFqNames.values");
        for (String kotlinName : $this$associateTo$iv) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            lu.e(kotlinName, "kotlinName");
            sb.append(eo0.y(kotlinName, '.', (String) null, 2, (Object) null));
            sb.append("CompanionObject");
            String sb2 = sb.toString();
            j50 a2 = ws0.a(sb2, kotlinName + ".Companion");
            $this$classFqNames_u24lambda_u244.put(a2.c(), a2.d());
        }
        for (Map.Entry next : f5229a.entrySet()) {
            int arity = ((Number) next.getValue()).intValue();
            String name = ((Class) next.getKey()).getName();
            $this$classFqNames_u24lambda_u244.put(name, "kotlin.Function" + arity);
        }
        c = hashMap3;
        Map $this$mapValuesTo$iv$iv = hashMap3;
        Map destination$iv$iv2 = new LinkedHashMap(zz.a($this$mapValuesTo$iv$iv.size()));
        for (T next2 : $this$mapValuesTo$iv$iv.entrySet()) {
            destination$iv$iv2.put(((Map.Entry) next2).getKey(), eo0.y((String) ((Map.Entry) next2).getValue(), '.', (String) null, 2, (Object) null));
        }
        f5231b = destination$iv$iv2;
    }
}
