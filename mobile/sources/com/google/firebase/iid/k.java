package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import java.io.File;
import java.io.IOException;
import java.util.Map;

final class k {
    private final Context a;

    /* renamed from: a  reason: collision with other field name */
    private final SharedPreferences f2434a;

    /* renamed from: a  reason: collision with other field name */
    private final h0 f2435a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<String, j0> f2436a;

    public k(Context context) {
        this(context, new h0());
    }

    private k(Context context, h0 h0Var) {
        this.f2436a = new ArrayMap();
        this.a = context;
        this.f2434a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.f2435a = h0Var;
        File file = new File(ContextCompat.getNoBackupFilesDir(context), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !j()) {
                    Log.i("FirebaseInstanceId", "App restored, clearing state");
                    g();
                    FirebaseInstanceId.b().x();
                }
            } catch (IOException e) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(e.getMessage());
                    Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(valueOf) : new String("Error creating file in no backup dir: "));
                }
            }
        }
    }

    public final synchronized String b() {
        return this.f2434a.getString("topic_operation_queue", "");
    }

    public final synchronized void d(String str) {
        this.f2434a.edit().putString("topic_operation_queue", str).apply();
    }

    private final synchronized boolean j() {
        return this.f2434a.getAll().isEmpty();
    }

    private static String h(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        return sb.toString();
    }

    static String c(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("|S|");
        sb.append(str2);
        return sb.toString();
    }

    public final synchronized void g() {
        this.f2436a.clear();
        h0.g(this.a);
        this.f2434a.edit().clear().commit();
    }

    public final synchronized j a(String str, String str2, String str3) {
        return j.a(this.f2434a.getString(h(str, str2, str3), (String) null));
    }

    public final synchronized void e(String str, String str2, String str3, String str4, String str5) {
        String c = j.c(str4, str5, System.currentTimeMillis());
        if (c != null) {
            SharedPreferences.Editor edit = this.f2434a.edit();
            edit.putString(h(str, str2, str3), c);
            edit.commit();
        }
    }

    public final synchronized j0 f(String str) {
        j0 j0Var;
        j0 j0Var2 = this.f2436a.get(str);
        if (j0Var2 != null) {
            return j0Var2;
        }
        try {
            j0Var = this.f2435a.a(this.a, str);
        } catch (k0 e) {
            Log.w("FirebaseInstanceId", "Stored data is corrupt, generating new identity");
            FirebaseInstanceId.b().x();
            j0Var = this.f2435a.j(this.a, str);
        }
        this.f2436a.put(str, j0Var);
        return j0Var;
    }

    public final synchronized void i(String str) {
        String concat = String.valueOf(str).concat("|T|");
        SharedPreferences.Editor edit = this.f2434a.edit();
        for (String next : this.f2434a.getAll().keySet()) {
            if (next.startsWith(concat)) {
                edit.remove(next);
            }
        }
        edit.commit();
    }
}
