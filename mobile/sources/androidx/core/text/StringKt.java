package androidx.core.text;

import android.text.TextUtils;

public final class StringKt {
    public static final String htmlEncode(String $this$htmlEncode) {
        lu.f($this$htmlEncode, "<this>");
        String htmlEncode = TextUtils.htmlEncode($this$htmlEncode);
        lu.e(htmlEncode, "htmlEncode(this)");
        return htmlEncode;
    }
}
