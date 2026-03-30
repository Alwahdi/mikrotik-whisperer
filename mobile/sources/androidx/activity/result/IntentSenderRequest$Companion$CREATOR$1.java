package androidx.activity.result;

import android.os.Parcel;
import android.os.Parcelable;

public final class IntentSenderRequest$Companion$CREATOR$1 implements Parcelable.Creator<IntentSenderRequest> {
    IntentSenderRequest$Companion$CREATOR$1() {
    }

    public IntentSenderRequest createFromParcel(Parcel inParcel) {
        lu.f(inParcel, "inParcel");
        return new IntentSenderRequest(inParcel);
    }

    public IntentSenderRequest[] newArray(int size) {
        return new IntentSenderRequest[size];
    }
}
