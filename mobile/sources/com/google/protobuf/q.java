package com.google.protobuf;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

abstract class q {
    static String e(p messageLite, String commentString) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("# ");
        buffer.append(commentString);
        d(messageLite, buffer, 0);
        return buffer.toString();
    }

    private static void d(p messageLite, StringBuilder buffer, int indent) {
        Map<String, Method> nameToNoArgMethod;
        boolean hasValue;
        p pVar = messageLite;
        StringBuilder sb = buffer;
        int i = indent;
        Map<String, Method> hashMap = new HashMap<>();
        Map<String, Method> nameToMethod = new HashMap<>();
        Set<String> getters = new TreeSet<>();
        int i2 = 0;
        for (Method method : messageLite.getClass().getDeclaredMethods()) {
            nameToMethod.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    getters.add(method.getName());
                }
            }
        }
        for (String getter : getters) {
            String suffix = getter.replaceFirst("get", "");
            if (suffix.endsWith("List") && !suffix.endsWith("OrBuilderList")) {
                String camelCase = suffix.substring(i2, 1).toLowerCase() + suffix.substring(1, suffix.length() - "List".length());
                Method listMethod = (Method) hashMap.get("get" + suffix);
                if (listMethod != null) {
                    c(sb, i, a(camelCase), i.w(listMethod, pVar, new Object[i2]));
                }
            }
            if (nameToMethod.get("set" + suffix) != null) {
                if (suffix.endsWith("Bytes")) {
                    if (hashMap.containsKey("get" + suffix.substring(i2, suffix.length() - "Bytes".length()))) {
                    }
                }
                String camelCase2 = suffix.substring(i2, 1).toLowerCase() + suffix.substring(1);
                Method getMethod = hashMap.get("get" + suffix);
                Method hasMethod = hashMap.get("has" + suffix);
                if (getMethod != null) {
                    Object value = i.w(getMethod, pVar, new Object[i2]);
                    if (hasMethod == null) {
                        nameToNoArgMethod = hashMap;
                        hasValue = !b(value);
                    } else {
                        nameToNoArgMethod = hashMap;
                        hasValue = ((Boolean) i.w(hasMethod, pVar, new Object[i2])).booleanValue();
                    }
                    if (hasValue) {
                        c(sb, i, a(camelCase2), value);
                        hashMap = nameToNoArgMethod;
                        i2 = 0;
                    } else {
                        hashMap = nameToNoArgMethod;
                        i2 = 0;
                    }
                } else {
                    Map<String, Method> nameToNoArgMethod2 = hashMap;
                    i2 = 0;
                }
            }
        }
        Map<String, Method> nameToNoArgMethod3 = hashMap;
        if (((i) pVar).a != null) {
            ((i) pVar).a.d(sb, i);
        }
    }

    private static boolean b(Object o) {
        if (o instanceof Boolean) {
            return !((Boolean) o).booleanValue();
        }
        if (o instanceof Integer) {
            if (((Integer) o).intValue() == 0) {
                return true;
            }
            return false;
        } else if (o instanceof Float) {
            if (((Float) o).floatValue() == 0.0f) {
                return true;
            }
            return false;
        } else if (o instanceof Double) {
            if (((Double) o).doubleValue() == 0.0d) {
                return true;
            }
            return false;
        } else if (o instanceof String) {
            return o.equals("");
        } else {
            if (o instanceof e) {
                return o.equals(e.f2563a);
            }
            if (o instanceof p) {
                if (o == ((p) o).g()) {
                    return true;
                }
                return false;
            } else if (!(o instanceof Enum) || ((Enum) o).ordinal() != 0) {
                return false;
            } else {
                return true;
            }
        }
    }

    static final void c(StringBuilder buffer, int indent, String name, Object object) {
        if (object instanceof List) {
            for (Object entry : (List) object) {
                c(buffer, indent, name, entry);
            }
            return;
        }
        buffer.append(10);
        for (int i = 0; i < indent; i++) {
            buffer.append(' ');
        }
        buffer.append(name);
        if (object instanceof String) {
            buffer.append(": \"");
            buffer.append(u.c((String) object));
            buffer.append('\"');
        } else if (object instanceof e) {
            buffer.append(": \"");
            buffer.append(u.a((e) object));
            buffer.append('\"');
        } else if (object instanceof i) {
            buffer.append(" {");
            d((i) object, buffer, indent + 2);
            buffer.append("\n");
            for (int i2 = 0; i2 < indent; i2++) {
                buffer.append(' ');
            }
            buffer.append("}");
        } else {
            buffer.append(": ");
            buffer.append(object.toString());
        }
    }

    private static final String a(String camelCase) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < camelCase.length(); i++) {
            char ch = camelCase.charAt(i);
            if (Character.isUpperCase(ch)) {
                builder.append("_");
            }
            builder.append(Character.toLowerCase(ch));
        }
        return builder.toString();
    }
}
