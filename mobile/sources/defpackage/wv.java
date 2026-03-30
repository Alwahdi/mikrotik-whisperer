package defpackage;

import android.util.Base64;
import android.util.JsonWriter;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;
import java.io.Writer;
import java.util.Collection;
import java.util.Map;

/* renamed from: wv  reason: default package */
final class wv implements z30, vu0 {
    private final JsonWriter a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<Class<?>, y30<?>> f5552a;

    /* renamed from: a  reason: collision with other field name */
    private wv f5553a = null;

    /* renamed from: a  reason: collision with other field name */
    private boolean f5554a = true;
    private final Map<Class<?>, uu0<?>> b;

    wv(Writer writer, Map<Class<?>, y30<?>> objectEncoders, Map<Class<?>, uu0<?>> valueEncoders) {
        this.a = new JsonWriter(writer);
        this.f5552a = objectEncoders;
        this.b = valueEncoders;
    }

    /* renamed from: l */
    public wv b(String name, Object o) {
        p();
        this.a.name(name);
        if (o != null) {
            return h(o);
        }
        this.a.nullValue();
        return this;
    }

    /* renamed from: j */
    public wv e(String name, int value) {
        p();
        this.a.name(name);
        return f(value);
    }

    /* renamed from: k */
    public wv c(String name, long value) {
        p();
        this.a.name(name);
        return g(value);
    }

    /* renamed from: i */
    public wv a(String value) {
        p();
        this.a.value(value);
        return this;
    }

    public wv f(int value) {
        p();
        this.a.value((long) value);
        return this;
    }

    public wv g(long value) {
        p();
        this.a.value(value);
        return this;
    }

    /* renamed from: m */
    public wv d(boolean value) {
        p();
        this.a.value(value);
        return this;
    }

    public wv n(byte[] bytes) {
        p();
        if (bytes == null) {
            this.a.nullValue();
        } else {
            this.a.value(Base64.encodeToString(bytes, 2));
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public wv h(Object o) {
        if (o == null) {
            this.a.nullValue();
            return this;
        } else if (o instanceof Number) {
            this.a.value((Number) o);
            return this;
        } else {
            int i = 0;
            if (o.getClass().isArray()) {
                if (o instanceof byte[]) {
                    return n((byte[]) o);
                }
                this.a.beginArray();
                if (o instanceof int[]) {
                    int[] iArr = (int[]) o;
                    int length = iArr.length;
                    while (i < length) {
                        this.a.value((long) iArr[i]);
                        i++;
                    }
                } else if (o instanceof long[]) {
                    long[] jArr = (long[]) o;
                    int length2 = jArr.length;
                    while (i < length2) {
                        g(jArr[i]);
                        i++;
                    }
                } else if (o instanceof double[]) {
                    double[] dArr = (double[]) o;
                    int length3 = dArr.length;
                    while (i < length3) {
                        this.a.value(dArr[i]);
                        i++;
                    }
                } else if (o instanceof boolean[]) {
                    boolean[] zArr = (boolean[]) o;
                    int length4 = zArr.length;
                    while (i < length4) {
                        this.a.value(zArr[i]);
                        i++;
                    }
                } else if (o instanceof Number[]) {
                    Number[] numberArr = (Number[]) o;
                    int length5 = numberArr.length;
                    while (i < length5) {
                        h(numberArr[i]);
                        i++;
                    }
                } else {
                    Object[] objArr = (Object[]) o;
                    int length6 = objArr.length;
                    while (i < length6) {
                        h(objArr[i]);
                        i++;
                    }
                }
                this.a.endArray();
                return this;
            } else if (o instanceof Collection) {
                this.a.beginArray();
                for (Object elem : (Collection) o) {
                    h(elem);
                }
                this.a.endArray();
                return this;
            } else if (o instanceof Map) {
                this.a.beginObject();
                for (Map.Entry<Object, Object> entry : ((Map) o).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        b((String) key, entry.getValue());
                    } catch (ClassCastException ex) {
                        throw new ri(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", new Object[]{key, key.getClass()}), ex);
                    }
                }
                this.a.endObject();
                return this;
            } else {
                ObjectEncoder<Object> objectEncoder = (y30) this.f5552a.get(o.getClass());
                if (objectEncoder != null) {
                    this.a.beginObject();
                    objectEncoder.a(o, this);
                    this.a.endObject();
                    return this;
                }
                ValueEncoder<Object> valueEncoder = (uu0) this.b.get(o.getClass());
                if (valueEncoder != null) {
                    valueEncoder.a(o, this);
                    return this;
                } else if (o instanceof Enum) {
                    a(((Enum) o).name());
                    return this;
                } else {
                    throw new ri("Couldn't find encoder for type " + o.getClass().getCanonicalName());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void o() {
        p();
        this.a.flush();
    }

    private void p() {
        if (this.f5554a) {
            wv wvVar = this.f5553a;
            if (wvVar != null) {
                wvVar.p();
                this.f5553a.f5554a = false;
                this.f5553a = null;
                this.a.endObject();
                return;
            }
            return;
        }
        throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
    }
}
