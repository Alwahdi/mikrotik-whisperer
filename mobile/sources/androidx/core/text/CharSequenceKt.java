package androidx.core.text;

import android.text.TextUtils;

public final class CharSequenceKt {
    public static final boolean isDigitsOnly(CharSequence $this$isDigitsOnly) {
        lu.f($this$isDigitsOnly, "<this>");
        return TextUtils.isDigitsOnly($this$isDigitsOnly);
    }

    public static final int trimmedLength(CharSequence $this$trimmedLength) {
        lu.f($this$trimmedLength, "<this>");
        return TextUtils.getTrimmedLength($this$trimmedLength);
    }
}
