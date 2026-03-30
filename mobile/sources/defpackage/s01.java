package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: s01  reason: default package */
public final class s01 {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f4955a = this.a.getSharedPreferences(String.format("com.google.firebase.auth.api.Store.%s", new Object[]{this.f4956a}), 0);

    /* renamed from: a  reason: collision with other field name */
    private String f4956a;

    /* renamed from: a  reason: collision with other field name */
    private vy f4957a = new vy("StorageHelpers", new String[0]);

    public s01(Context context, String str) {
        y90.j(context);
        this.f4956a = y90.f(str);
        this.a = context.getApplicationContext();
    }

    public final void c(dm dmVar) {
        y90.j(dmVar);
        String g = g(dmVar);
        if (!TextUtils.isEmpty(g)) {
            this.f4955a.edit().putString("com.google.firebase.auth.FIREBASE_USER", g).apply();
        }
    }

    public final dm a() {
        String string = this.f4955a.getString("com.google.firebase.auth.FIREBASE_USER", (String) null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.has("type") && "com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(jSONObject.optString("type"))) {
                return b(jSONObject);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public final void d(dm dmVar, s61 s61) {
        y90.j(dmVar);
        y90.j(s61);
        this.f4955a.edit().putString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{dmVar.r()}), s61.w()).apply();
    }

    public final s61 f(dm dmVar) {
        y90.j(dmVar);
        String string = this.f4955a.getString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{dmVar.r()}), (String) null);
        if (string != null) {
            return s61.p(string);
        }
        return null;
    }

    public final void e(String str) {
        this.f4955a.edit().remove(str).apply();
    }

    private final String g(dm dmVar) {
        JSONObject jSONObject = new JSONObject();
        if (!y81.class.isAssignableFrom(dmVar.getClass())) {
            return null;
        }
        y81 y81 = (y81) dmVar;
        try {
            jSONObject.put("cachedTokenState", y81.E());
            jSONObject.put("applicationName", y81.A().l());
            jSONObject.put("type", "com.google.firebase.auth.internal.DefaultFirebaseUser");
            if (y81.L() != null) {
                JSONArray jSONArray = new JSONArray();
                List<i81> L = y81.L();
                for (int i = 0; i < L.size(); i++) {
                    jSONArray.put(L.get(i).w());
                }
                jSONObject.put("userInfos", jSONArray);
            }
            jSONObject.put("anonymous", y81.s());
            jSONObject.put(ClientCookie.VERSION_ATTR, "2");
            if (y81.m() != null) {
                jSONObject.put("userMetadata", ((g91) y81.m()).m());
            }
            List<ga1> a2 = ((o91) y81.G()).a();
            if (a2 != null && !a2.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < a2.size(); i2++) {
                    jSONArray2.put(a2.get(i2).m());
                }
                jSONObject.put("userMultiFactorInfo", jSONArray2);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            this.f4957a.g("Failed to turn object into JSON", e, new Object[0]);
            throw new wy0(e);
        }
    }

    private final y81 b(JSONObject jSONObject) {
        JSONArray jSONArray;
        mz0 mz0;
        g91 o;
        try {
            String string = jSONObject.getString("cachedTokenState");
            String string2 = jSONObject.getString("applicationName");
            boolean z = jSONObject.getBoolean("anonymous");
            String str = "2";
            String string3 = jSONObject.getString(ClientCookie.VERSION_ATTR);
            if (string3 != null) {
                str = string3;
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray("userInfos");
            int length = jSONArray2.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(i81.v(jSONArray2.getString(i)));
            }
            y81 y81 = new y81(gl.k(string2), arrayList);
            if (!TextUtils.isEmpty(string)) {
                y81.x(s61.p(string));
            }
            if (!z) {
                y81.y();
            }
            y81.H(str);
            if (jSONObject.has("userMetadata") && (o = g91.o(jSONObject.getJSONObject("userMetadata"))) != null) {
                y81.J(o);
            }
            if (jSONObject.has("userMultiFactorInfo") && (jSONArray = jSONObject.getJSONArray("userMultiFactorInfo")) != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = new JSONObject(jSONArray.getString(i2));
                    if ("phone".equals(jSONObject2.optString("factorIdKey"))) {
                        mz0 = mz0.p(jSONObject2);
                    } else {
                        mz0 = null;
                    }
                    arrayList2.add(mz0);
                }
                y81.z(arrayList2);
            }
            return y81;
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException | JSONException | wy0 e) {
            this.f4957a.h(e);
            return null;
        }
    }
}
