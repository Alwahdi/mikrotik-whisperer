package defpackage;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: uv  reason: default package */
public abstract class uv {
    private static final Logger a = Logger.getLogger(uv.class.getName());

    public static Object a(String raw) {
        JsonReader jr = new JsonReader(new StringReader(raw));
        try {
            return e(jr);
        } finally {
            try {
                jr.close();
            } catch (IOException e) {
                a.log(Level.WARNING, "Failed to close", e);
            }
        }
    }

    /* renamed from: uv$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            a = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    private static Object e(JsonReader jr) {
        v90.u(jr.hasNext(), "unexpected end of JSON");
        switch (a.a[jr.peek().ordinal()]) {
            case 1:
                return b(jr);
            case 2:
                return d(jr);
            case 3:
                return jr.nextString();
            case 4:
                return Double.valueOf(jr.nextDouble());
            case 5:
                return Boolean.valueOf(jr.nextBoolean());
            case 6:
                return c(jr);
            default:
                throw new IllegalStateException("Bad token: " + jr.getPath());
        }
    }

    private static Map<String, ?> d(JsonReader jr) {
        jr.beginObject();
        Map<String, Object> obj = new LinkedHashMap<>();
        while (jr.hasNext()) {
            obj.put(jr.nextName(), e(jr));
        }
        boolean z = jr.peek() == JsonToken.END_OBJECT;
        v90.u(z, "Bad token: " + jr.getPath());
        jr.endObject();
        return Collections.unmodifiableMap(obj);
    }

    private static List<?> b(JsonReader jr) {
        jr.beginArray();
        List<Object> array = new ArrayList<>();
        while (jr.hasNext()) {
            array.add(e(jr));
        }
        boolean z = jr.peek() == JsonToken.END_ARRAY;
        v90.u(z, "Bad token: " + jr.getPath());
        jr.endArray();
        return Collections.unmodifiableList(array);
    }

    private static Void c(JsonReader jr) {
        jr.nextNull();
        return null;
    }
}
