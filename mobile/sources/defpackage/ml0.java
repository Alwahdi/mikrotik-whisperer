package defpackage;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: ml0  reason: default package */
public abstract class ml0 {
    public static SharedPreferences.Editor a;

    /* renamed from: a  reason: collision with other field name */
    public static SharedPreferences f4366a;

    public static void b(Context context, String Key, String Value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mumsprovider", 0);
        f4366a = sharedPreferences;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        a = edit;
        edit.putString(Key, Value);
        a.apply();
    }

    public static String a(Context contextGetKey, String Key) {
        SharedPreferences sharedPreferences = contextGetKey.getSharedPreferences("mumsprovider", 0);
        f4366a = sharedPreferences;
        return sharedPreferences.getString(Key, "");
    }
}
