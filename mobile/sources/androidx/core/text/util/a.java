package androidx.core.text.util;

import androidx.core.text.util.LinkifyCompat;
import java.util.Comparator;

public final /* synthetic */ class a implements Comparator {
    public static final /* synthetic */ a a = new a();

    private /* synthetic */ a() {
    }

    public final int compare(Object obj, Object obj2) {
        return LinkifyCompat.lambda$static$0((LinkifyCompat.LinkSpec) obj, (LinkifyCompat.LinkSpec) obj2);
    }
}
