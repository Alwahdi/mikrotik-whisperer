package androidx.core.text;

import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.ColorInt;

public final class SpannableStringBuilderKt {
    public static final SpannedString buildSpannedString(vn<? super SpannableStringBuilder, jt0> builderAction) {
        lu.f(builderAction, "builderAction");
        SpannableStringBuilder builder = new SpannableStringBuilder();
        builderAction.invoke(builder);
        return new SpannedString(builder);
    }

    public static final SpannableStringBuilder inSpans(SpannableStringBuilder $this$inSpans, Object[] spans, vn<? super SpannableStringBuilder, jt0> builderAction) {
        lu.f($this$inSpans, "<this>");
        lu.f(spans, "spans");
        lu.f(builderAction, "builderAction");
        int start = $this$inSpans.length();
        builderAction.invoke($this$inSpans);
        for (Object span : spans) {
            $this$inSpans.setSpan(span, start, $this$inSpans.length(), 17);
        }
        return $this$inSpans;
    }

    public static final SpannableStringBuilder inSpans(SpannableStringBuilder $this$inSpans, Object span, vn<? super SpannableStringBuilder, jt0> builderAction) {
        lu.f($this$inSpans, "<this>");
        lu.f(span, "span");
        lu.f(builderAction, "builderAction");
        int start = $this$inSpans.length();
        builderAction.invoke($this$inSpans);
        $this$inSpans.setSpan(span, start, $this$inSpans.length(), 17);
        return $this$inSpans;
    }

    public static final SpannableStringBuilder bold(SpannableStringBuilder $this$bold, vn<? super SpannableStringBuilder, jt0> builderAction) {
        lu.f($this$bold, "<this>");
        lu.f(builderAction, "builderAction");
        Object span$iv = new StyleSpan(1);
        SpannableStringBuilder $this$inSpans$iv = $this$bold;
        int start$iv = $this$inSpans$iv.length();
        builderAction.invoke($this$inSpans$iv);
        $this$inSpans$iv.setSpan(span$iv, start$iv, $this$inSpans$iv.length(), 17);
        return $this$inSpans$iv;
    }

    public static final SpannableStringBuilder italic(SpannableStringBuilder $this$italic, vn<? super SpannableStringBuilder, jt0> builderAction) {
        lu.f($this$italic, "<this>");
        lu.f(builderAction, "builderAction");
        Object span$iv = new StyleSpan(2);
        SpannableStringBuilder $this$inSpans$iv = $this$italic;
        int start$iv = $this$inSpans$iv.length();
        builderAction.invoke($this$inSpans$iv);
        $this$inSpans$iv.setSpan(span$iv, start$iv, $this$inSpans$iv.length(), 17);
        return $this$inSpans$iv;
    }

    public static final SpannableStringBuilder underline(SpannableStringBuilder $this$underline, vn<? super SpannableStringBuilder, jt0> builderAction) {
        lu.f($this$underline, "<this>");
        lu.f(builderAction, "builderAction");
        Object span$iv = new UnderlineSpan();
        SpannableStringBuilder $this$inSpans$iv = $this$underline;
        int start$iv = $this$inSpans$iv.length();
        builderAction.invoke($this$inSpans$iv);
        $this$inSpans$iv.setSpan(span$iv, start$iv, $this$inSpans$iv.length(), 17);
        return $this$inSpans$iv;
    }

    public static final SpannableStringBuilder color(SpannableStringBuilder $this$color, @ColorInt int color, vn<? super SpannableStringBuilder, jt0> builderAction) {
        lu.f($this$color, "<this>");
        lu.f(builderAction, "builderAction");
        Object span$iv = new ForegroundColorSpan(color);
        SpannableStringBuilder $this$inSpans$iv = $this$color;
        int start$iv = $this$inSpans$iv.length();
        builderAction.invoke($this$inSpans$iv);
        $this$inSpans$iv.setSpan(span$iv, start$iv, $this$inSpans$iv.length(), 17);
        return $this$inSpans$iv;
    }

    public static final SpannableStringBuilder backgroundColor(SpannableStringBuilder $this$backgroundColor, @ColorInt int color, vn<? super SpannableStringBuilder, jt0> builderAction) {
        lu.f($this$backgroundColor, "<this>");
        lu.f(builderAction, "builderAction");
        Object span$iv = new BackgroundColorSpan(color);
        SpannableStringBuilder $this$inSpans$iv = $this$backgroundColor;
        int start$iv = $this$inSpans$iv.length();
        builderAction.invoke($this$inSpans$iv);
        $this$inSpans$iv.setSpan(span$iv, start$iv, $this$inSpans$iv.length(), 17);
        return $this$inSpans$iv;
    }

    public static final SpannableStringBuilder strikeThrough(SpannableStringBuilder $this$strikeThrough, vn<? super SpannableStringBuilder, jt0> builderAction) {
        lu.f($this$strikeThrough, "<this>");
        lu.f(builderAction, "builderAction");
        Object span$iv = new StrikethroughSpan();
        SpannableStringBuilder $this$inSpans$iv = $this$strikeThrough;
        int start$iv = $this$inSpans$iv.length();
        builderAction.invoke($this$inSpans$iv);
        $this$inSpans$iv.setSpan(span$iv, start$iv, $this$inSpans$iv.length(), 17);
        return $this$inSpans$iv;
    }

    public static final SpannableStringBuilder scale(SpannableStringBuilder $this$scale, float proportion, vn<? super SpannableStringBuilder, jt0> builderAction) {
        lu.f($this$scale, "<this>");
        lu.f(builderAction, "builderAction");
        Object span$iv = new RelativeSizeSpan(proportion);
        SpannableStringBuilder $this$inSpans$iv = $this$scale;
        int start$iv = $this$inSpans$iv.length();
        builderAction.invoke($this$inSpans$iv);
        $this$inSpans$iv.setSpan(span$iv, start$iv, $this$inSpans$iv.length(), 17);
        return $this$inSpans$iv;
    }

    public static final SpannableStringBuilder superscript(SpannableStringBuilder $this$superscript, vn<? super SpannableStringBuilder, jt0> builderAction) {
        lu.f($this$superscript, "<this>");
        lu.f(builderAction, "builderAction");
        Object span$iv = new SuperscriptSpan();
        SpannableStringBuilder $this$inSpans$iv = $this$superscript;
        int start$iv = $this$inSpans$iv.length();
        builderAction.invoke($this$inSpans$iv);
        $this$inSpans$iv.setSpan(span$iv, start$iv, $this$inSpans$iv.length(), 17);
        return $this$inSpans$iv;
    }

    public static final SpannableStringBuilder subscript(SpannableStringBuilder $this$subscript, vn<? super SpannableStringBuilder, jt0> builderAction) {
        lu.f($this$subscript, "<this>");
        lu.f(builderAction, "builderAction");
        Object span$iv = new SubscriptSpan();
        SpannableStringBuilder $this$inSpans$iv = $this$subscript;
        int start$iv = $this$inSpans$iv.length();
        builderAction.invoke($this$inSpans$iv);
        $this$inSpans$iv.setSpan(span$iv, start$iv, $this$inSpans$iv.length(), 17);
        return $this$inSpans$iv;
    }
}
