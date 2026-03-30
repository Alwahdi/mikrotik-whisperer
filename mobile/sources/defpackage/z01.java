package defpackage;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import java.util.HashMap;
import java.util.Map;

/* renamed from: z01  reason: default package */
public abstract class z01 {
    private static final Map<String, String> a;

    public static void a(Intent intent, Status status) {
        hi0.e(status, intent, "com.google.firebase.auth.internal.STATUS");
    }

    public static boolean b(Intent intent) {
        y90.j(intent);
        return intent.hasExtra("com.google.firebase.auth.internal.STATUS");
    }

    public static Status c(Intent intent) {
        y90.j(intent);
        y90.a(b(intent));
        return (Status) hi0.b(intent, "com.google.firebase.auth.internal.STATUS", Status.CREATOR);
    }

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("auth/invalid-provider-id", "INVALID_PROVIDER_ID");
        hashMap.put("auth/invalid-cert-hash", "INVALID_CERT_HASH");
        hashMap.put("auth/network-request-failed", "WEB_NETWORK_REQUEST_FAILED");
        hashMap.put("auth/web-storage-unsupported", "WEB_STORAGE_UNSUPPORTED");
        hashMap.put("auth/operation-not-allowed", "OPERATION_NOT_ALLOWED");
    }
}
