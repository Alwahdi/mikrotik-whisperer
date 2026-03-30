package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Base64;
import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.List;

/* renamed from: tz0  reason: default package */
public final class tz0 {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private final Context f5182a;

    /* renamed from: a  reason: collision with other field name */
    private String f5183a;
    private int b = 0;

    /* renamed from: b  reason: collision with other field name */
    private String f5184b;

    public tz0(Context context) {
        this.f5182a = context;
    }

    public final synchronized int a() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        PackageManager packageManager = this.f5182a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseInstanceId", "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!n90.h()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.b = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            Log.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
            if (n90.h()) {
                this.b = 2;
            } else {
                this.b = 1;
            }
            return this.b;
        }
        this.b = 2;
        return 2;
    }

    public static String c(gl glVar) {
        String d = glVar.m().d();
        if (d != null) {
            return d;
        }
        String c = glVar.m().c();
        if (!c.startsWith("1:")) {
            return c;
        }
        String[] split = c.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    public static String d(PublicKey publicKey) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(publicKey.getEncoded());
            digest[0] = (byte) ((digest[0] & 15) + 112);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            Log.w("FirebaseInstanceId", "Unexpected error, device missing required algorithms");
            return null;
        }
    }

    public final synchronized String e() {
        if (this.f5183a == null) {
            h();
        }
        return this.f5183a;
    }

    public final synchronized String f() {
        if (this.f5184b == null) {
            h();
        }
        return this.f5184b;
    }

    public final synchronized int g() {
        PackageInfo b2;
        if (this.a == 0 && (b2 = b("com.google.android.gms")) != null) {
            this.a = b2.versionCode;
        }
        return this.a;
    }

    private final synchronized void h() {
        PackageInfo b2 = b(this.f5182a.getPackageName());
        if (b2 != null) {
            this.f5183a = Integer.toString(b2.versionCode);
            this.f5184b = b2.versionName;
        }
    }

    private final PackageInfo b(String str) {
        try {
            return this.f5182a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Failed to find package ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }
}
