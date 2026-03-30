package defpackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: d01  reason: default package */
abstract class d01 {
    private static final vy a = new vy("JSONParser", new String[0]);

    public static Map<String, Object> b(String str) {
        y90.f(str);
        List<String> a2 = r01.c('.').a(str);
        if (a2.size() < 2) {
            vy vyVar = a;
            String valueOf = String.valueOf(str);
            vyVar.b(valueOf.length() != 0 ? "Invalid idToken ".concat(valueOf) : new String("Invalid idToken "), new Object[0]);
            return d21.a();
        }
        try {
            Map<String, Object> d = d(new String(v5.b(a2.get(1)), HTTP.UTF_8));
            return d == null ? d21.a() : d;
        } catch (UnsupportedEncodingException e) {
            a.a("Unable to decode token", e, new Object[0]);
            return d21.a();
        }
    }

    public static Map<String, Object> d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != JSONObject.NULL) {
                return c(jSONObject);
            }
            return null;
        } catch (Exception e) {
            Log.d("JSONParser", "Failed to parse JSONObject into Map.");
            throw new wy0(e);
        }
    }

    private static Map<String, Object> c(JSONObject jSONObject) {
        ArrayMap arrayMap = new ArrayMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONArray) {
                obj = a((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = c((JSONObject) obj);
            }
            arrayMap.put(next, obj);
        }
        return arrayMap;
    }

    private static List<Object> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                obj = a((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = c((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }
}
