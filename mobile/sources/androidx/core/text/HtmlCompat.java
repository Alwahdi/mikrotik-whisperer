package androidx.core.text;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public final class HtmlCompat {
    public static final int FROM_HTML_MODE_COMPACT = 63;
    public static final int FROM_HTML_MODE_LEGACY = 0;
    public static final int FROM_HTML_OPTION_USE_CSS_COLORS = 256;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_BLOCKQUOTE = 32;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_DIV = 16;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_HEADING = 2;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_LIST = 8;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_LIST_ITEM = 4;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_PARAGRAPH = 1;
    public static final int TO_HTML_PARAGRAPH_LINES_CONSECUTIVE = 0;
    public static final int TO_HTML_PARAGRAPH_LINES_INDIVIDUAL = 1;

    @NonNull
    public static Spanned fromHtml(@NonNull String source, int flags) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.fromHtml(source, flags);
        }
        return Html.fromHtml(source);
    }

    @NonNull
    public static Spanned fromHtml(@NonNull String source, int flags, @Nullable Html.ImageGetter imageGetter, @Nullable Html.TagHandler tagHandler) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.fromHtml(source, flags, imageGetter, tagHandler);
        }
        return Html.fromHtml(source, imageGetter, tagHandler);
    }

    @NonNull
    public static String toHtml(@NonNull Spanned text, int options) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.toHtml(text, options);
        }
        return Html.toHtml(text);
    }

    private HtmlCompat() {
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static Spanned fromHtml(String source, int flags) {
            return Html.fromHtml(source, flags);
        }

        @DoNotInline
        static Spanned fromHtml(String source, int flags, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
            return Html.fromHtml(source, flags, imageGetter, tagHandler);
        }

        @DoNotInline
        static String toHtml(Spanned text, int option) {
            return Html.toHtml(text, option);
        }
    }
}
