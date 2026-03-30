package com.google.firebase.firestore;

import com.google.firebase.firestore.core.c0;
import com.google.firebase.firestore.g;
import com.google.firebase.firestore.model.value.FieldValue;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class q {
    private final ve a;

    public q(ve databaseId) {
        this.a = databaseId;
    }

    public du0 h(Object input) {
        bu0 accumulator = new bu0(c0.Set);
        return accumulator.h(a(input, accumulator.e()));
    }

    public du0 e(Object input, ok fieldMask) {
        bu0 accumulator = new bu0(c0.MergeSet);
        c40 updateData = a(input, accumulator.e());
        if (fieldMask == null) {
            return accumulator.f(updateData);
        }
        for (pk field : fieldMask.c()) {
            if (!accumulator.d(field)) {
                throw new IllegalArgumentException("Field '" + field.toString() + "' is specified in your field mask but not in your input data.");
            }
        }
        return accumulator.g(updateData, fieldMask);
    }

    private c40 a(Object input, cu0 context) {
        if (!input.getClass().isArray()) {
            rk value = b(yd.c(input), context);
            if (value instanceof c40) {
                return (c40) value;
            }
            throw new IllegalArgumentException("Invalid data. Data must be a Map<String, Object> or a suitable POJO object, but it was " + "of type: " + qu0.n(input));
        }
        throw new IllegalArgumentException("Invalid data. Data must be a Map<String, Object> or a suitable POJO object, but it was " + "an array");
    }

    private rk b(Object input, cu0 context) {
        if (input instanceof Map) {
            return d((Map) input, context);
        }
        if (input instanceof g) {
            g((g) input, context);
            return null;
        }
        if (context.g() != null) {
            context.a(context.g());
        }
        if (!(input instanceof List)) {
            return f(input, context);
        }
        if (!context.h() || context.f() == c0.ArrayArgument) {
            return c((List) input, context);
        }
        throw context.e("Nested arrays are not supported");
    }

    private <K, V> c40 d(Map<K, V> map, cu0 context) {
        Map<String, FieldValue> result = new HashMap<>();
        if (map.isEmpty()) {
            if (context.g() != null && !context.g().j()) {
                context.a(context.g());
            }
            return c40.g();
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getKey() instanceof String) {
                String key = (String) entry.getKey();
                rk parsedValue = b(entry.getValue(), context.d(key));
                if (parsedValue != null) {
                    result.put(key, parsedValue);
                }
            } else {
                throw context.e(String.format("Non-String Map key (%s) is not allowed", new Object[]{entry.getValue()}));
            }
        }
        return c40.i(result);
    }

    private <T> g4 c(List<T> list, cu0 context) {
        List<FieldValue> result = new ArrayList<>(list.size());
        int entryIndex = 0;
        for (T entry : list) {
            rk parsedEntry = b(entry, context.c(entryIndex));
            if (parsedEntry == null) {
                parsedEntry = p30.e();
            }
            result.add(parsedEntry);
            entryIndex++;
        }
        return g4.e(result);
    }

    private void g(g value, cu0 context) {
        boolean z = true;
        if (!context.i()) {
            throw context.e(String.format("%s() can only be used with set() and update()", new Object[]{value.a()}));
        } else if (context.g() == null) {
            throw context.e(String.format("%s() is not currently supported inside arrays", new Object[]{value.a()}));
        } else if (value instanceof g.a) {
            if (context.f() == c0.MergeSet) {
                context.a(context.g());
            } else if (context.f() == c0.Update) {
                if (context.g().n() <= 0) {
                    z = false;
                }
                n4.d(z, "FieldValue.delete() at the top level should have already been handled.", new Object[0]);
                throw context.e("FieldValue.delete() can only appear at the top level of your update data");
            } else {
                throw context.e("FieldValue.delete() can only be used with update() and set() with SetOptions.merge()");
            }
        } else if (value instanceof g.b) {
            context.b(context.g(), ok0.d());
        } else {
            throw n4.a("Unknown FieldValue type: %s", qu0.n(value));
        }
    }

    private rk f(Object input, cu0 context) {
        if (input == null) {
            return p30.e();
        }
        if (input instanceof Integer) {
            return et.h(Long.valueOf(((Integer) input).longValue()));
        }
        if (input instanceof Long) {
            return et.h((Long) input);
        }
        if (input instanceof Float) {
            return th.h(Double.valueOf(((Float) input).doubleValue()));
        }
        if (input instanceof Double) {
            return th.h((Double) input);
        }
        if (input instanceof Boolean) {
            return q6.g((Boolean) input);
        }
        if (input instanceof String) {
            return rn0.g((String) input);
        }
        if (input instanceof Date) {
            return qr0.h(new pr0((Date) input));
        }
        if (input instanceof pr0) {
            pr0 timestamp = (pr0) input;
            return qr0.h(new pr0(timestamp.p(), (timestamp.o() / 1000) * 1000));
        } else if (input instanceof cp) {
            return dp.g((cp) input);
        } else {
            if (input instanceof l6) {
                return m6.g((l6) input);
            }
            if (input instanceof e) {
                e ref = (e) input;
                if (ref.f() != null) {
                    ve otherDb = ref.f().e();
                    if (!otherDb.equals(this.a)) {
                        throw context.e(String.format("Document reference is for database %s/%s but should be for database %s/%s", new Object[]{otherDb.d(), otherDb.c(), this.a.d(), this.a.c()}));
                    }
                }
                return wd0.h(this.a, ref.g());
            } else if (input.getClass().isArray()) {
                throw context.e("Arrays are not supported; use a List instead");
            } else {
                throw context.e("Unsupported type: " + qu0.n(input));
            }
        }
    }
}
