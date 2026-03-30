package androidx.core.util;

import android.util.Pair;

public final class PairKt {
    public static final <F, S> F component1(Pair<F, S> $this$component1) {
        lu.f($this$component1, "<this>");
        return $this$component1.first;
    }

    public static final <F, S> S component2(Pair<F, S> $this$component2) {
        lu.f($this$component2, "<this>");
        return $this$component2.second;
    }

    public static final <F, S> j50<F, S> toKotlinPair(Pair<F, S> $this$toKotlinPair) {
        lu.f($this$toKotlinPair, "<this>");
        return new j50<>($this$toKotlinPair.first, $this$toKotlinPair.second);
    }

    public static final <F, S> Pair<F, S> toAndroidXPair(j50<? extends F, ? extends S> $this$toAndroidXPair) {
        lu.f($this$toAndroidXPair, "<this>");
        return new Pair<>($this$toAndroidXPair.c(), $this$toAndroidXPair.d());
    }

    public static final <F, S> F component1(Pair<F, S> $this$component1) {
        lu.f($this$component1, "<this>");
        return $this$component1.first;
    }

    public static final <F, S> S component2(Pair<F, S> $this$component2) {
        lu.f($this$component2, "<this>");
        return $this$component2.second;
    }

    public static final <F, S> j50<F, S> toKotlinPair(Pair<F, S> $this$toKotlinPair) {
        lu.f($this$toKotlinPair, "<this>");
        return new j50<>($this$toKotlinPair.first, $this$toKotlinPair.second);
    }

    public static final <F, S> Pair<F, S> toAndroidPair(j50<? extends F, ? extends S> $this$toAndroidPair) {
        lu.f($this$toAndroidPair, "<this>");
        return new Pair<>($this$toAndroidPair.c(), $this$toAndroidPair.d());
    }
}
