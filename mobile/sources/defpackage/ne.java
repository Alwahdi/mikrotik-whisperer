package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: ne  reason: default package */
public class ne {
    private final Context a;

    /* renamed from: a  reason: collision with other field name */
    private final SharedPreferences f4427a;

    /* renamed from: a  reason: collision with other field name */
    private final AtomicBoolean f4428a = new AtomicBoolean(c());

    /* renamed from: a  reason: collision with other field name */
    private final sb0 f4429a;

    public ne(Context applicationContext, String persistenceKey, sb0 publisher) {
        this.a = a(applicationContext);
        this.f4427a = applicationContext.getSharedPreferences("com.google.firebase.common.prefs:" + persistenceKey, 0);
        this.f4429a = publisher;
    }

    private static Context a(Context applicationContext) {
        if (Build.VERSION.SDK_INT < 24 || ContextCompat.isDeviceProtectedStorage(applicationContext)) {
            return applicationContext;
        }
        return ContextCompat.createDeviceProtectedStorageContext(applicationContext);
    }

    public boolean b() {
        return this.f4428a.get();
    }

    private boolean c() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        if (this.f4427a.contains("firebase_data_collection_default_enabled")) {
            return this.f4427a.getBoolean("firebase_data_collection_default_enabled", true);
        }
        try {
            PackageManager packageManager = this.a.getPackageManager();
            if (!(packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.a.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_data_collection_default_enabled"))) {
                return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
            }
        } catch (PackageManager.NameNotFoundException e) {
        }
        return true;
    }
}
