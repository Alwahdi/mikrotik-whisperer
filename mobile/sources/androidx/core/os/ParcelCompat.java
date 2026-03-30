package androidx.core.os;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.core.os.BuildCompat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ParcelCompat {
    public static boolean readBoolean(@NonNull Parcel in) {
        return in.readInt() != 0;
    }

    public static void writeBoolean(@NonNull Parcel out, boolean value) {
        out.writeInt(value);
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static <T> void readList(@NonNull Parcel in, @NonNull List<? super T> outVal, @Nullable ClassLoader loader, @NonNull Class<T> clazz) {
        if (BuildCompat.isAtLeastT()) {
            TiramisuImpl.readList(in, outVal, loader, clazz);
        } else {
            in.readList(outVal, loader);
        }
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @Nullable
    public static <T> ArrayList<T> readArrayList(@NonNull Parcel in, @Nullable ClassLoader loader, @NonNull Class<? extends T> clazz) {
        if (BuildCompat.isAtLeastT()) {
            return TiramisuImpl.readArrayList(in, loader, clazz);
        }
        return in.readArrayList(loader);
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @Nullable
    public static <T> T[] readArray(@NonNull Parcel in, @Nullable ClassLoader loader, @NonNull Class<T> clazz) {
        if (BuildCompat.isAtLeastT()) {
            return TiramisuImpl.readArray(in, loader, clazz);
        }
        return in.readArray(loader);
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @Nullable
    public static <T> SparseArray<T> readSparseArray(@NonNull Parcel in, @Nullable ClassLoader loader, @NonNull Class<? extends T> clazz) {
        if (BuildCompat.isAtLeastT()) {
            return TiramisuImpl.readSparseArray(in, loader, clazz);
        }
        return in.readSparseArray(loader);
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static <K, V> void readMap(@NonNull Parcel in, @NonNull Map<? super K, ? super V> outVal, @Nullable ClassLoader loader, @NonNull Class<K> clazzKey, @NonNull Class<V> clazzValue) {
        if (BuildCompat.isAtLeastT()) {
            TiramisuImpl.readMap(in, outVal, loader, clazzKey, clazzValue);
        } else {
            in.readMap(outVal, loader);
        }
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @Nullable
    public static <K, V> HashMap<K, V> readHashMap(@NonNull Parcel in, @Nullable ClassLoader loader, @NonNull Class<? extends K> clazzKey, @NonNull Class<? extends V> clazzValue) {
        if (BuildCompat.isAtLeastT()) {
            return TiramisuImpl.readHashMap(in, loader, clazzKey, clazzValue);
        }
        return in.readHashMap(loader);
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @Nullable
    public static <T extends Parcelable> T readParcelable(@NonNull Parcel in, @Nullable ClassLoader loader, @NonNull Class<T> clazz) {
        if (BuildCompat.isAtLeastT()) {
            return TiramisuImpl.readParcelable(in, loader, clazz);
        }
        return in.readParcelable(loader);
    }

    @RequiresApi(30)
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @Nullable
    public static <T> Parcelable.Creator<T> readParcelableCreator(@NonNull Parcel in, @Nullable ClassLoader loader, @NonNull Class<T> clazz) {
        if (BuildCompat.isAtLeastT()) {
            return TiramisuImpl.readParcelableCreator(in, loader, clazz);
        }
        return Api30Impl.readParcelableCreator(in, loader);
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @Nullable
    public static <T> T[] readParcelableArray(@NonNull Parcel in, @Nullable ClassLoader loader, @NonNull Class<T> clazz) {
        if (BuildCompat.isAtLeastT()) {
            return TiramisuImpl.readParcelableArray(in, loader, clazz);
        }
        return in.readParcelableArray(loader);
    }

    @RequiresApi(api = 29)
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @NonNull
    public static <T> List<T> readParcelableList(@NonNull Parcel in, @NonNull List<T> list, @Nullable ClassLoader cl, @NonNull Class<T> clazz) {
        if (BuildCompat.isAtLeastT()) {
            return TiramisuImpl.readParcelableList(in, list, cl, clazz);
        }
        return Api29Impl.readParcelableList(in, list, cl);
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @Nullable
    public static <T extends Serializable> T readSerializable(@NonNull Parcel in, @Nullable ClassLoader loader, @NonNull Class<T> clazz) {
        if (BuildCompat.isAtLeastT()) {
            return TiramisuImpl.readSerializable(in, loader, clazz);
        }
        return in.readSerializable();
    }

    private ParcelCompat() {
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static final <T extends Parcelable> List<T> readParcelableList(@NonNull Parcel in, @NonNull List<T> list, @Nullable ClassLoader cl) {
            return in.readParcelableList(list, cl);
        }
    }

    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static final Parcelable.Creator<?> readParcelableCreator(@NonNull Parcel in, @Nullable ClassLoader loader) {
            return in.readParcelableCreator(loader);
        }
    }

    @RequiresApi(33)
    static class TiramisuImpl {
        private TiramisuImpl() {
        }

        @DoNotInline
        static <T extends Serializable> T readSerializable(@NonNull Parcel in, @Nullable ClassLoader loader, @NonNull Class<T> clazz) {
            return (Serializable) in.readSerializable(loader, clazz);
        }

        @DoNotInline
        static <T extends Parcelable> T readParcelable(@NonNull Parcel in, @Nullable ClassLoader loader, @NonNull Class<T> clazz) {
            return (Parcelable) in.readParcelable(loader, clazz);
        }

        @DoNotInline
        public static <T> Parcelable.Creator<T> readParcelableCreator(Parcel in, ClassLoader loader, Class<T> clazz) {
            return in.readParcelableCreator(loader, clazz);
        }

        @DoNotInline
        static <T> T[] readParcelableArray(@NonNull Parcel in, @Nullable ClassLoader loader, @NonNull Class<T> clazz) {
            return in.readParcelableArray(loader, clazz);
        }

        @DoNotInline
        static <T> List<T> readParcelableList(@NonNull Parcel in, @NonNull List<T> list, @Nullable ClassLoader cl, @NonNull Class<T> clazz) {
            return in.readParcelableList(list, cl, clazz);
        }

        @DoNotInline
        public static <T> void readList(@NonNull Parcel in, @NonNull List<? super T> outVal, @Nullable ClassLoader loader, @NonNull Class<T> clazz) {
            in.readList(outVal, loader, clazz);
        }

        @DoNotInline
        public static <T> ArrayList<T> readArrayList(Parcel in, ClassLoader loader, Class<? extends T> clazz) {
            return in.readArrayList(loader, clazz);
        }

        @DoNotInline
        public static <T> T[] readArray(Parcel in, ClassLoader loader, Class<T> clazz) {
            return in.readArray(loader, clazz);
        }

        @DoNotInline
        public static <T> SparseArray<T> readSparseArray(Parcel in, ClassLoader loader, Class<? extends T> clazz) {
            return in.readSparseArray(loader, clazz);
        }

        @DoNotInline
        public static <K, V> void readMap(Parcel in, Map<? super K, ? super V> outVal, ClassLoader loader, Class<K> clazzKey, Class<V> clazzValue) {
            in.readMap(outVal, loader, clazzKey, clazzValue);
        }

        @DoNotInline
        public static <V, K> HashMap<K, V> readHashMap(Parcel in, ClassLoader loader, Class<? extends K> clazzKey, Class<? extends V> clazzValue) {
            return in.readHashMap(loader, clazzKey, clazzValue);
        }
    }
}
