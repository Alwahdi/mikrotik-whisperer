package androidx.core.content;

import android.content.UriMatcher;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.util.Predicate;

public class UriMatcherCompat {
    private UriMatcherCompat() {
    }

    @NonNull
    public static Predicate<Uri> asPredicate(@NonNull UriMatcher matcher) {
        return new xt0(matcher);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$asPredicate$0(UriMatcher matcher, Uri v) {
        return matcher.match(v) != -1;
    }
}
