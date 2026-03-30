package defpackage;

import com.google.android.gms.common.api.Status;

/* renamed from: n3  reason: default package */
public abstract class n3 {
    public static l3 a(Status status) {
        if (status.r()) {
            return new je0(status);
        }
        return new l3(status);
    }
}
