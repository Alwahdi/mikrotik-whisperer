package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.SimpleArrayMap;
import androidx.customview.view.AbsSavedState;

/* renamed from: ck  reason: default package */
public class ck extends AbsSavedState {
    public static final Parcelable.Creator<ck> CREATOR = new a();
    public final SimpleArrayMap<String, Bundle> a;

    /* synthetic */ ck(Parcel x0, ClassLoader x1, a x2) {
        this(x0, x1);
    }

    public ck(Parcelable superState) {
        super(superState);
        this.a = new SimpleArrayMap<>();
    }

    private ck(Parcel in, ClassLoader loader) {
        super(in, loader);
        int size = in.readInt();
        String[] keys = new String[size];
        in.readStringArray(keys);
        Bundle[] states = new Bundle[size];
        in.readTypedArray(states, Bundle.CREATOR);
        this.a = new SimpleArrayMap<>(size);
        for (int i = 0; i < size; i++) {
            this.a.put(keys[i], states[i]);
        }
    }

    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        int size = this.a.size();
        out.writeInt(size);
        String[] keys = new String[size];
        Bundle[] states = new Bundle[size];
        for (int i = 0; i < size; i++) {
            keys[i] = this.a.keyAt(i);
            states[i] = this.a.valueAt(i);
        }
        out.writeStringArray(keys);
        out.writeTypedArray(states, 0);
    }

    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.a + "}";
    }

    /* renamed from: ck$a */
    class a implements Parcelable.ClassLoaderCreator<ck> {
        a() {
        }

        /* renamed from: b */
        public ck createFromParcel(Parcel in, ClassLoader loader) {
            return new ck(in, loader, (a) null);
        }

        /* renamed from: a */
        public ck createFromParcel(Parcel in) {
            return new ck(in, (ClassLoader) null, (a) null);
        }

        /* renamed from: c */
        public ck[] newArray(int size) {
            return new ck[size];
        }
    }
}
