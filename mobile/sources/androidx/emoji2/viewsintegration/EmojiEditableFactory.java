package androidx.emoji2.viewsintegration;

import android.text.Editable;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.emoji2.text.SpannableBuilder;

final class EmojiEditableFactory extends Editable.Factory {
    private static final Object INSTANCE_LOCK = new Object();
    @GuardedBy("INSTANCE_LOCK")
    private static volatile Editable.Factory sInstance;
    @Nullable
    private static Class<?> sWatcherClass;

    private EmojiEditableFactory() {
        try {
            sWatcherClass = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, getClass().getClassLoader());
        } catch (Throwable th) {
        }
    }

    public static Editable.Factory getInstance() {
        if (sInstance == null) {
            synchronized (INSTANCE_LOCK) {
                if (sInstance == null) {
                    sInstance = new EmojiEditableFactory();
                }
            }
        }
        return sInstance;
    }

    public Editable newEditable(@NonNull CharSequence source) {
        Class<?> cls = sWatcherClass;
        if (cls != null) {
            return SpannableBuilder.create(cls, source);
        }
        return super.newEditable(source);
    }
}
