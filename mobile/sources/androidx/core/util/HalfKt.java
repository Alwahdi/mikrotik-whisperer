package androidx.core.util;

import android.util.Half;
import androidx.annotation.RequiresApi;

public final class HalfKt {
    @RequiresApi(26)
    public static final Half toHalf(short $this$toHalf) {
        Half valueOf = Half.valueOf($this$toHalf);
        lu.e(valueOf, "valueOf(this)");
        return valueOf;
    }

    @RequiresApi(26)
    public static final Half toHalf(float $this$toHalf) {
        Half valueOf = Half.valueOf($this$toHalf);
        lu.e(valueOf, "valueOf(this)");
        return valueOf;
    }

    @RequiresApi(26)
    public static final Half toHalf(double $this$toHalf) {
        Half valueOf = Half.valueOf((float) $this$toHalf);
        lu.e(valueOf, "valueOf(this)");
        return valueOf;
    }

    @RequiresApi(26)
    public static final Half toHalf(String $this$toHalf) {
        lu.f($this$toHalf, "<this>");
        Half valueOf = Half.valueOf($this$toHalf);
        lu.e(valueOf, "valueOf(this)");
        return valueOf;
    }
}
