package defpackage;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: nl0  reason: default package */
class nl0 implements l7 {
    private SharedPreferences a;

    public nl0(Context context) {
        this.a = context.getSharedPreferences("timeme.com.instacart.library.truetime.shared_preferences", 0);
    }

    public void b(String key, long value) {
        this.a.edit().putLong(key, value).apply();
    }

    public long a(String key, long defaultValue) {
        return this.a.getLong(key, defaultValue);
    }
}
