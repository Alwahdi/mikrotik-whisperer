package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;

public final class SpannedStringKt {
    public static final Spanned toSpanned(CharSequence $this$toSpanned) {
        lu.f($this$toSpanned, "<this>");
        SpannedString valueOf = SpannedString.valueOf($this$toSpanned);
        lu.e(valueOf, "valueOf(this)");
        return valueOf;
    }

    public static /* synthetic */ Object[] getSpans$default(Spanned $this$getSpans_u24default, int start, int end, int i, Object obj) {
        if ((i & 1) != 0) {
            start = 0;
        }
        if ((i & 2) != 0) {
            end = $this$getSpans_u24default.length();
        }
        lu.f($this$getSpans_u24default, "<this>");
        lu.j(4, "T");
        Object[] spans = $this$getSpans_u24default.getSpans(start, end, Object.class);
        lu.e(spans, "getSpans(start, end, T::class.java)");
        return spans;
    }

    public static final /* synthetic */ <T> T[] getSpans(Spanned $this$getSpans, int start, int end) {
        lu.f($this$getSpans, "<this>");
        lu.j(4, "T");
        T[] spans = $this$getSpans.getSpans(start, end, Object.class);
        lu.e(spans, "getSpans(start, end, T::class.java)");
        return spans;
    }
}
