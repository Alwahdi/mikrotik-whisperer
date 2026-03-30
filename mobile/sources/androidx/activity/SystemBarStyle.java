package androidx.activity;

import android.content.res.Resources;
import androidx.annotation.ColorInt;

public final class SystemBarStyle {
    public static final Companion Companion = new Companion((Cif) null);
    private final int darkScrim;
    private final vn<Resources, Boolean> detectDarkMode;
    private final int lightScrim;
    private final int nightMode;

    public /* synthetic */ SystemBarStyle(int i, int i2, int i3, vn vnVar, Cif ifVar) {
        this(i, i2, i3, vnVar);
    }

    public static final SystemBarStyle auto(@ColorInt int i, @ColorInt int i2) {
        return Companion.auto(i, i2);
    }

    public static final SystemBarStyle auto(@ColorInt int i, @ColorInt int i2, vn<? super Resources, Boolean> vnVar) {
        return Companion.auto(i, i2, vnVar);
    }

    public static final SystemBarStyle dark(@ColorInt int i) {
        return Companion.dark(i);
    }

    public static final SystemBarStyle light(@ColorInt int i, @ColorInt int i2) {
        return Companion.light(i, i2);
    }

    private SystemBarStyle(int lightScrim2, int darkScrim2, int nightMode2, vn<? super Resources, Boolean> detectDarkMode2) {
        this.lightScrim = lightScrim2;
        this.darkScrim = darkScrim2;
        this.nightMode = nightMode2;
        this.detectDarkMode = detectDarkMode2;
    }

    public final int getDarkScrim$activity_release() {
        return this.darkScrim;
    }

    public final int getNightMode$activity_release() {
        return this.nightMode;
    }

    public final vn<Resources, Boolean> getDetectDarkMode$activity_release() {
        return this.detectDarkMode;
    }

    public static final class Companion {
        public /* synthetic */ Companion(Cif ifVar) {
            this();
        }

        public final SystemBarStyle auto(@ColorInt int i, @ColorInt int i2) {
            return auto$default(this, i, i2, (vn) null, 4, (Object) null);
        }

        private Companion() {
        }

        public static /* synthetic */ SystemBarStyle auto$default(Companion companion, int i, int i2, vn vnVar, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                vnVar = SystemBarStyle$Companion$auto$1.INSTANCE;
            }
            return companion.auto(i, i2, vnVar);
        }

        public final SystemBarStyle auto(@ColorInt int lightScrim, @ColorInt int darkScrim, vn<? super Resources, Boolean> detectDarkMode) {
            lu.f(detectDarkMode, "detectDarkMode");
            return new SystemBarStyle(lightScrim, darkScrim, 0, detectDarkMode, (Cif) null);
        }

        public final SystemBarStyle dark(@ColorInt int scrim) {
            return new SystemBarStyle(scrim, scrim, 2, SystemBarStyle$Companion$dark$1.INSTANCE, (Cif) null);
        }

        public final SystemBarStyle light(@ColorInt int scrim, @ColorInt int darkScrim) {
            return new SystemBarStyle(scrim, darkScrim, 1, SystemBarStyle$Companion$light$1.INSTANCE, (Cif) null);
        }
    }

    public final int getScrim$activity_release(boolean isDark) {
        return isDark ? this.darkScrim : this.lightScrim;
    }

    public final int getScrimWithEnforcedContrast$activity_release(boolean isDark) {
        if (this.nightMode == 0) {
            return 0;
        }
        if (isDark) {
            return this.darkScrim;
        }
        return this.lightScrim;
    }
}
