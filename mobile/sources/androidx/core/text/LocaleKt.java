package androidx.core.text;

import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import java.util.Locale;

public final class LocaleKt {
    @RequiresApi(17)
    public static final int getLayoutDirection(Locale $this$layoutDirection) {
        lu.f($this$layoutDirection, "<this>");
        return TextUtils.getLayoutDirectionFromLocale($this$layoutDirection);
    }
}
