package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.ArrayMap;
import java.util.Map;

/* renamed from: fe0  reason: default package */
public final class fe0 extends x {
    public static final Parcelable.Creator<fe0> CREATOR = new l91();
    Bundle a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, String> f2967a;

    public fe0(Bundle bundle) {
        this.a = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = fi0.a(parcel);
        fi0.e(parcel, 2, this.a, false);
        fi0.b(parcel, a2);
    }

    public final String p() {
        return this.a.getString("from");
    }

    public final Map<String, String> m() {
        if (this.f2967a == null) {
            Bundle bundle = this.a;
            ArrayMap arrayMap = new ArrayMap();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                        arrayMap.put(str, str2);
                    }
                }
            }
            this.f2967a = arrayMap;
        }
        return this.f2967a;
    }
}
