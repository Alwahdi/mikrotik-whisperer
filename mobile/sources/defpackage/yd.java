package defpackage;

import com.google.firebase.firestore.e;
import com.google.firebase.firestore.g;
import com.google.firebase.firestore.util.CustomClassMapper;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: yd  reason: default package */
public abstract class yd {
    private static final ConcurrentMap<Class<?>, a<?>> a = new ConcurrentHashMap();

    /* access modifiers changed from: private */
    public static void d(boolean assertion, String message) {
        if (!assertion) {
            throw new RuntimeException("Hard assert failed: " + message);
        }
    }

    public static Object c(Object object) {
        return f(object);
    }

    private static <T> Object f(T o) {
        return g(o, b.b);
    }

    /* access modifiers changed from: private */
    public static <T> Object g(T o, b path) {
        if (path.b() > 500) {
            throw h(path, "Exceeded maximum depth of 500, which likely indicates there's an object cycle");
        } else if (o == null) {
            return null;
        } else {
            if (o instanceof Number) {
                if ((o instanceof Long) || (o instanceof Integer) || (o instanceof Double) || (o instanceof Float)) {
                    return o;
                }
                throw h(path, String.format("Numbers of type %s are not supported, please use an int, long, float or double", new Object[]{o.getClass().getSimpleName()}));
            } else if ((o instanceof String) || (o instanceof Boolean)) {
                return o;
            } else {
                if (o instanceof Character) {
                    throw h(path, "Characters are not supported, please use Strings");
                } else if (o instanceof Map) {
                    Map<String, Object> result = new HashMap<>();
                    for (Map.Entry<Object, Object> entry : ((Map) o).entrySet()) {
                        Object key = entry.getKey();
                        if (key instanceof String) {
                            String keyString = (String) key;
                            result.put(keyString, g(entry.getValue(), path.a(keyString)));
                        } else {
                            throw h(path, "Maps with non-string keys are not supported");
                        }
                    }
                    return result;
                } else if (o instanceof Collection) {
                    if (o instanceof List) {
                        List<Object> list = o;
                        List<Object> result2 = new ArrayList<>(list.size());
                        for (int i = 0; i < list.size(); i++) {
                            Object obj = list.get(i);
                            result2.add(g(obj, path.a("[" + i + "]")));
                        }
                        return result2;
                    }
                    throw h(path, "Serializing Collections is not supported, please use Lists instead");
                } else if (o.getClass().isArray()) {
                    throw h(path, "Serializing Arrays is not supported, please use Lists instead");
                } else if (o instanceof Enum) {
                    String enumName = ((Enum) o).name();
                    try {
                        return a.i(o.getClass().getField(enumName));
                    } catch (NoSuchFieldException e) {
                        return enumName;
                    }
                } else if ((o instanceof Date) || (o instanceof pr0) || (o instanceof cp) || (o instanceof l6) || (o instanceof e) || (o instanceof g)) {
                    return o;
                } else {
                    return e(o.getClass()).k(o, path);
                }
            }
        }
    }

    private static <T> a<T> e(Class<T> clazz) {
        ConcurrentMap<Class<?>, a<?>> concurrentMap = a;
        CustomClassMapper.BeanMapper<T> mapper = (a) concurrentMap.get(clazz);
        if (mapper != null) {
            return mapper;
        }
        CustomClassMapper.BeanMapper<T> mapper2 = new a<>(clazz);
        concurrentMap.put(clazz, mapper2);
        return mapper2;
    }

    private static IllegalArgumentException h(b path, String reason) {
        String reason2 = "Could not serialize object. " + reason;
        if (path.b() > 0) {
            reason2 = reason2 + " (found in field '" + path.toString() + "')";
        }
        return new IllegalArgumentException(reason2);
    }

    /* renamed from: yd$a */
    private static class a<T> {
        private final Class<T> a;

        /* renamed from: a  reason: collision with other field name */
        private final Constructor<T> f5874a;

        /* renamed from: a  reason: collision with other field name */
        private final HashSet<String> f5875a = new HashSet<>();

        /* renamed from: a  reason: collision with other field name */
        private final Map<String, String> f5876a = new HashMap();

        /* renamed from: a  reason: collision with other field name */
        private final boolean f5877a;
        private final HashSet<String> b = new HashSet<>();

        /* renamed from: b  reason: collision with other field name */
        private final Map<String, Method> f5878b = new HashMap();

        /* renamed from: b  reason: collision with other field name */
        private final boolean f5879b;
        private final Map<String, Method> c = new HashMap();
        private final Map<String, Field> d = new HashMap();

        /* JADX WARNING: Removed duplicated region for block: B:24:0x00cc  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x01a3  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        a(java.lang.Class<T> r13) {
            /*
                r12 = this;
                r12.<init>()
                r12.a = r13
                java.lang.Class<gr0> r0 = defpackage.gr0.class
                boolean r0 = r13.isAnnotationPresent(r0)
                r12.f5877a = r0
                java.lang.Class<rr> r0 = defpackage.rr.class
                boolean r0 = r13.isAnnotationPresent(r0)
                r1 = 1
                r0 = r0 ^ r1
                r12.f5879b = r0
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                r12.f5876a = r0
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                r12.c = r0
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                r12.f5878b = r0
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                r12.d = r0
                java.util.HashSet r0 = new java.util.HashSet
                r0.<init>()
                r12.f5875a = r0
                java.util.HashSet r0 = new java.util.HashSet
                r0.<init>()
                r12.b = r0
                r0 = 0
                java.lang.Class[] r2 = new java.lang.Class[r0]     // Catch:{ NoSuchMethodException -> 0x004c }
                java.lang.reflect.Constructor r2 = r13.getDeclaredConstructor(r2)     // Catch:{ NoSuchMethodException -> 0x004c }
                r2.setAccessible(r1)     // Catch:{ NoSuchMethodException -> 0x004c }
                goto L_0x004f
            L_0x004c:
                r2 = move-exception
                r3 = 0
                r2 = r3
            L_0x004f:
                r12.f5874a = r2
                java.lang.reflect.Method[] r3 = r13.getMethods()
                int r4 = r3.length
                r5 = 0
            L_0x0057:
                if (r5 >= r4) goto L_0x00a6
                r6 = r3[r5]
                boolean r7 = n(r6)
                if (r7 == 0) goto L_0x00a3
                java.lang.String r7 = j(r6)
                r12.b(r7)
                r6.setAccessible(r1)
                java.util.Map<java.lang.String, java.lang.reflect.Method> r8 = r12.f5878b
                boolean r8 = r8.containsKey(r7)
                if (r8 != 0) goto L_0x007c
                java.util.Map<java.lang.String, java.lang.reflect.Method> r8 = r12.f5878b
                r8.put(r7, r6)
                r12.e(r6)
                goto L_0x00a3
            L_0x007c:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Found conflicting getters for name "
                r1.append(r3)
                java.lang.String r3 = r6.getName()
                r1.append(r3)
                java.lang.String r3 = " on class "
                r1.append(r3)
                java.lang.String r3 = r13.getName()
                r1.append(r3)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00a3:
                int r5 = r5 + 1
                goto L_0x0057
            L_0x00a6:
                java.lang.reflect.Field[] r3 = r13.getFields()
                int r4 = r3.length
                r5 = 0
            L_0x00ac:
                if (r5 >= r4) goto L_0x00c3
                r6 = r3[r5]
                boolean r7 = m(r6)
                if (r7 == 0) goto L_0x00c0
                java.lang.String r7 = i(r6)
                r12.b(r7)
                r12.d(r6)
            L_0x00c0:
                int r5 = r5 + 1
                goto L_0x00ac
            L_0x00c3:
                r3 = r13
            L_0x00c4:
                java.lang.reflect.Method[] r4 = r3.getDeclaredMethods()
                int r5 = r4.length
                r6 = 0
            L_0x00ca:
                if (r6 >= r5) goto L_0x019b
                r7 = r4[r6]
                boolean r8 = o(r7)
                if (r8 == 0) goto L_0x0197
                java.lang.String r8 = j(r7)
                java.util.Map<java.lang.String, java.lang.String> r9 = r12.f5876a
                java.util.Locale r10 = java.util.Locale.US
                java.lang.String r10 = r8.toLowerCase(r10)
                java.lang.Object r9 = r9.get(r10)
                java.lang.String r9 = (java.lang.String) r9
                if (r9 == 0) goto L_0x0197
                boolean r10 = r9.equals(r8)
                if (r10 == 0) goto L_0x0170
                java.util.Map<java.lang.String, java.lang.reflect.Method> r10 = r12.c
                java.lang.Object r10 = r10.get(r8)
                java.lang.reflect.Method r10 = (java.lang.reflect.Method) r10
                if (r10 != 0) goto L_0x0105
                r7.setAccessible(r1)
                java.util.Map<java.lang.String, java.lang.reflect.Method> r11 = r12.c
                r11.put(r8, r7)
                r12.f(r7)
                goto L_0x0197
            L_0x0105:
                boolean r11 = h(r7, r10)
                if (r11 != 0) goto L_0x0197
                if (r3 != r13) goto L_0x0134
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r4 = "Class "
                r1.append(r4)
                java.lang.String r4 = r13.getName()
                r1.append(r4)
                java.lang.String r4 = " has multiple setter overloads with name "
                r1.append(r4)
                java.lang.String r4 = r7.getName()
                r1.append(r4)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0134:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r4 = "Found conflicting setters with name: "
                r1.append(r4)
                java.lang.String r4 = r7.getName()
                r1.append(r4)
                java.lang.String r4 = " (conflicts with "
                r1.append(r4)
                java.lang.String r4 = r10.getName()
                r1.append(r4)
                java.lang.String r4 = " defined on "
                r1.append(r4)
                java.lang.Class r4 = r10.getDeclaringClass()
                java.lang.String r4 = r4.getName()
                r1.append(r4)
                java.lang.String r4 = ")"
                r1.append(r4)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0170:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r4 = "Found setter on "
                r1.append(r4)
                java.lang.String r4 = r3.getName()
                r1.append(r4)
                java.lang.String r4 = " with invalid case-sensitive name: "
                r1.append(r4)
                java.lang.String r4 = r7.getName()
                r1.append(r4)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0197:
                int r6 = r6 + 1
                goto L_0x00ca
            L_0x019b:
                java.lang.reflect.Field[] r4 = r3.getDeclaredFields()
                int r5 = r4.length
                r6 = 0
            L_0x01a1:
                if (r6 >= r5) goto L_0x01cd
                r7 = r4[r6]
                java.lang.String r8 = i(r7)
                java.util.Map<java.lang.String, java.lang.String> r9 = r12.f5876a
                java.util.Locale r10 = java.util.Locale.US
                java.lang.String r10 = r8.toLowerCase(r10)
                boolean r9 = r9.containsKey(r10)
                if (r9 == 0) goto L_0x01ca
                java.util.Map<java.lang.String, java.lang.reflect.Field> r9 = r12.d
                boolean r9 = r9.containsKey(r8)
                if (r9 != 0) goto L_0x01ca
                r7.setAccessible(r1)
                java.util.Map<java.lang.String, java.lang.reflect.Field> r9 = r12.d
                r9.put(r8, r7)
                r12.d(r7)
            L_0x01ca:
                int r6 = r6 + 1
                goto L_0x01a1
            L_0x01cd:
                java.lang.Class r3 = r3.getSuperclass()
                if (r3 == 0) goto L_0x01db
                java.lang.Class<java.lang.Object> r4 = java.lang.Object.class
                boolean r4 = r3.equals(r4)
                if (r4 == 0) goto L_0x00c4
            L_0x01db:
                java.util.Map<java.lang.String, java.lang.String> r0 = r12.f5876a
                boolean r0 = r0.isEmpty()
                if (r0 != 0) goto L_0x0230
                java.util.HashSet<java.lang.String> r0 = r12.b
                java.util.Iterator r0 = r0.iterator()
            L_0x01e9:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x022f
                java.lang.Object r1 = r0.next()
                java.lang.String r1 = (java.lang.String) r1
                java.util.Map<java.lang.String, java.lang.reflect.Method> r4 = r12.c
                boolean r4 = r4.containsKey(r1)
                if (r4 != 0) goto L_0x022e
                java.util.Map<java.lang.String, java.lang.reflect.Field> r4 = r12.d
                boolean r4 = r4.containsKey(r1)
                if (r4 == 0) goto L_0x0206
                goto L_0x022e
            L_0x0206:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "@DocumentId is annotated on property "
                r4.append(r5)
                r4.append(r1)
                java.lang.String r5 = " of class "
                r4.append(r5)
                java.lang.String r5 = r13.getName()
                r4.append(r5)
                java.lang.String r5 = " but no field or public setter was found"
                r4.append(r5)
                java.lang.String r4 = r4.toString()
                r0.<init>(r4)
                throw r0
            L_0x022e:
                goto L_0x01e9
            L_0x022f:
                return
            L_0x0230:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r4 = "No properties to serialize found on class "
                r1.append(r4)
                java.lang.String r4 = r13.getName()
                r1.append(r4)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.yd.a.<init>(java.lang.Class):void");
        }

        private void b(String property) {
            Map<String, String> map = this.f5876a;
            Locale locale = Locale.US;
            String oldValue = map.put(property.toLowerCase(locale), property);
            if (oldValue != null && !property.equals(oldValue)) {
                throw new RuntimeException("Found two getters or fields with conflicting case sensitivity for property: " + property.toLowerCase(locale));
            }
        }

        /* access modifiers changed from: package-private */
        public Map<String, Object> k(T object, b path) {
            Object propertyValue;
            Object serializedValue;
            if (this.a.isAssignableFrom(object.getClass())) {
                Map<String, Object> result = new HashMap<>();
                for (String property : this.f5876a.values()) {
                    if (!this.b.contains(property)) {
                        if (this.f5878b.containsKey(property)) {
                            propertyValue = p3.a(this.f5878b.get(property), object, new Object[0]);
                        } else {
                            Field field = this.d.get(property);
                            if (field != null) {
                                try {
                                    propertyValue = field.get(object);
                                } catch (IllegalAccessException e) {
                                    throw new RuntimeException(e);
                                }
                            } else {
                                throw new IllegalStateException("Bean property without field or getter: " + property);
                            }
                        }
                        if (!this.f5875a.contains(property) || propertyValue != null) {
                            serializedValue = yd.g(propertyValue, path.a(property));
                        } else {
                            serializedValue = g.b();
                        }
                        result.put(property, serializedValue);
                    }
                }
                return result;
            }
            throw new IllegalArgumentException("Can't serialize object of class " + object.getClass() + " with BeanMapper for class " + this.a);
        }

        private void d(Field field) {
            if (field.isAnnotationPresent(nk0.class)) {
                Class<?> fieldType = field.getType();
                if (fieldType == Date.class || fieldType == pr0.class) {
                    this.f5875a.add(i(field));
                } else {
                    throw new IllegalArgumentException("Field " + field.getName() + " is annotated with @ServerTimestamp but is " + fieldType + " instead of Date or Timestamp.");
                }
            }
            if (field.isAnnotationPresent(kh.class)) {
                g("Field", "is", field.getType());
                this.b.add(i(field));
            }
        }

        private void e(Method method) {
            if (method.isAnnotationPresent(nk0.class)) {
                Class<?> returnType = method.getReturnType();
                if (returnType == Date.class || returnType == pr0.class) {
                    this.f5875a.add(j(method));
                } else {
                    throw new IllegalArgumentException("Method " + method.getName() + " is annotated with @ServerTimestamp but returns " + returnType + " instead of Date or Timestamp.");
                }
            }
            if (method.isAnnotationPresent(kh.class)) {
                g("Method", "returns", method.getReturnType());
                this.b.add(j(method));
            }
        }

        private void f(Method method) {
            if (method.isAnnotationPresent(nk0.class)) {
                throw new IllegalArgumentException("Method " + method.getName() + " is annotated with @ServerTimestamp but should not be. @ServerTimestamp can only be applied to fields and getters, not setters.");
            } else if (method.isAnnotationPresent(kh.class)) {
                g("Method", "accepts", method.getParameterTypes()[0]);
                this.b.add(j(method));
            }
        }

        private void g(String fieldDescription, String operation, Type type) {
            if (type != String.class && type != e.class) {
                throw new IllegalArgumentException(fieldDescription + " is annotated with @DocumentId but " + operation + " " + type + " instead of String or DocumentReference.");
            }
        }

        private static boolean n(Method method) {
            if ((method.getName().startsWith("get") || method.getName().startsWith("is")) && !method.getDeclaringClass().equals(Object.class) && Modifier.isPublic(method.getModifiers()) && !Modifier.isStatic(method.getModifiers()) && !method.getReturnType().equals(Void.TYPE) && method.getParameterTypes().length == 0 && !method.isAnnotationPresent(sj.class)) {
                return true;
            }
            return false;
        }

        private static boolean o(Method method) {
            if (method.getName().startsWith("set") && !method.getDeclaringClass().equals(Object.class) && !Modifier.isStatic(method.getModifiers()) && method.getReturnType().equals(Void.TYPE) && method.getParameterTypes().length == 1 && !method.isAnnotationPresent(sj.class)) {
                return true;
            }
            return false;
        }

        private static boolean m(Field field) {
            if (!field.getDeclaringClass().equals(Object.class) && Modifier.isPublic(field.getModifiers()) && !Modifier.isStatic(field.getModifiers()) && !Modifier.isTransient(field.getModifiers()) && !field.isAnnotationPresent(sj.class)) {
                return true;
            }
            return false;
        }

        private static boolean h(Method base, Method override) {
            yd.d(base.getDeclaringClass().isAssignableFrom(override.getDeclaringClass()), "Expected override from a base class");
            yd.d(base.getReturnType().equals(Void.TYPE), "Expected void return type");
            yd.d(override.getReturnType().equals(Void.TYPE), "Expected void return type");
            Type[] baseParameterTypes = base.getParameterTypes();
            Type[] overrideParameterTypes = override.getParameterTypes();
            yd.d(baseParameterTypes.length == 1, "Expected exactly one parameter");
            yd.d(overrideParameterTypes.length == 1, "Expected exactly one parameter");
            if (!base.getName().equals(override.getName()) || !baseParameterTypes[0].equals(overrideParameterTypes[0])) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: private */
        public static String i(Field field) {
            String annotatedName = c(field);
            return annotatedName != null ? annotatedName : field.getName();
        }

        private static String j(Method method) {
            String annotatedName = c(method);
            return annotatedName != null ? annotatedName : l(method.getName());
        }

        private static String c(AccessibleObject obj) {
            if (obj.isAnnotationPresent(db0.class)) {
                return ((db0) obj.getAnnotation(db0.class)).value();
            }
            return null;
        }

        private static String l(String methodName) {
            String methodPrefix = null;
            for (String prefix : new String[]{"get", "set", "is"}) {
                if (methodName.startsWith(prefix)) {
                    methodPrefix = prefix;
                }
            }
            if (methodPrefix != null) {
                char[] chars = methodName.substring(methodPrefix.length()).toCharArray();
                int pos = 0;
                while (pos < chars.length && Character.isUpperCase(chars[pos])) {
                    chars[pos] = Character.toLowerCase(chars[pos]);
                    pos++;
                }
                return new String(chars);
            }
            throw new IllegalArgumentException("Unknown Bean prefix for method: " + methodName);
        }
    }

    /* renamed from: yd$b */
    static class b {
        static final b b = new b((b) null, (String) null, 0);
        private final int a;

        /* renamed from: a  reason: collision with other field name */
        private final String f5880a;

        /* renamed from: a  reason: collision with other field name */
        private final b f5881a;

        b(b parent, String name, int length) {
            this.f5881a = parent;
            this.f5880a = name;
            this.a = length;
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.a;
        }

        /* access modifiers changed from: package-private */
        public b a(String name) {
            return new b(this, name, this.a + 1);
        }

        public String toString() {
            int i = this.a;
            if (i == 0) {
                return "";
            }
            if (i == 1) {
                return this.f5880a;
            }
            return this.f5881a.toString() + "." + this.f5880a;
        }
    }
}
