package androidx.core.text;

import android.text.Html;
import android.text.Spanned;

public final class HtmlKt {
    public static /* synthetic */ Spanned parseAsHtml$default(String $this$parseAsHtml_u24default, int flags, Html.ImageGetter imageGetter, Html.TagHandler tagHandler, int i, Object obj) {
        if ((i & 1) != 0) {
            flags = 0;
        }
        if ((i & 2) != 0) {
            imageGetter = null;
        }
        if ((i & 4) != 0) {
            tagHandler = null;
        }
        lu.f($this$parseAsHtml_u24default, "<this>");
        Spanned fromHtml = HtmlCompat.fromHtml($this$parseAsHtml_u24default, flags, imageGetter, tagHandler);
        lu.e(fromHtml, "fromHtml(this, flags, imageGetter, tagHandler)");
        return fromHtml;
    }

    public static final Spanned parseAsHtml(String $this$parseAsHtml, int flags, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
        lu.f($this$parseAsHtml, "<this>");
        Spanned fromHtml = HtmlCompat.fromHtml($this$parseAsHtml, flags, imageGetter, tagHandler);
        lu.e(fromHtml, "fromHtml(this, flags, imageGetter, tagHandler)");
        return fromHtml;
    }

    public static /* synthetic */ String toHtml$default(Spanned $this$toHtml_u24default, int option, int i, Object obj) {
        if ((i & 1) != 0) {
            option = 0;
        }
        lu.f($this$toHtml_u24default, "<this>");
        String html = HtmlCompat.toHtml($this$toHtml_u24default, option);
        lu.e(html, "toHtml(this, option)");
        return html;
    }

    public static final String toHtml(Spanned $this$toHtml, int option) {
        lu.f($this$toHtml, "<this>");
        String html = HtmlCompat.toHtml($this$toHtml, option);
        lu.e(html, "toHtml(this, option)");
        return html;
    }
}
