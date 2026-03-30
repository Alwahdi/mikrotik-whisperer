package androidx.core.text;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;

public final class SpannableStringKt {
    public static final Spannable toSpannable(CharSequence $this$toSpannable) {
        lu.f($this$toSpannable, "<this>");
        SpannableString valueOf = SpannableString.valueOf($this$toSpannable);
        lu.e(valueOf, "valueOf(this)");
        return valueOf;
    }

    public static final void clearSpans(Spannable $this$clearSpans) {
        lu.f($this$clearSpans, "<this>");
        Spanned $this$getSpans_u24default$iv = $this$clearSpans;
        Object[] $this$forEach$iv = $this$getSpans_u24default$iv.getSpans(0, $this$getSpans_u24default$iv.length(), Object.class);
        lu.e($this$forEach$iv, "getSpans(start, end, T::class.java)");
        for (Object element$iv : $this$forEach$iv) {
            $this$clearSpans.removeSpan(element$iv);
        }
    }

    public static final void set(Spannable $this$set, int start, int end, Object span) {
        lu.f($this$set, "<this>");
        lu.f(span, "span");
        $this$set.setSpan(span, start, end, 17);
    }

    public static final void set(Spannable $this$set, dt range, Object span) {
        lu.f($this$set, "<this>");
        lu.f(range, "range");
        lu.f(span, "span");
        $this$set.setSpan(span, range.getStart().intValue(), range.getEndInclusive().intValue(), 17);
    }
}
