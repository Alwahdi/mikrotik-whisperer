package androidx.core.app;

import android.app.LocaleManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.AnyThread;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.BuildCompat;
import androidx.core.os.LocaleListCompat;
import java.util.Locale;

public final class LocaleManagerCompat {
    private LocaleManagerCompat() {
    }

    @NonNull
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @AnyThread
    public static LocaleListCompat getSystemLocales(@NonNull Context context) {
        LocaleListCompat systemLocales = LocaleListCompat.getEmptyLocaleList();
        if (!BuildCompat.isAtLeastT()) {
            return getConfigurationLocales(context.getApplicationContext().getResources().getConfiguration());
        }
        Object localeManager = getLocaleManagerForApplication(context);
        if (localeManager != null) {
            return LocaleListCompat.wrap(Api33Impl.localeManagerGetSystemLocales(localeManager));
        }
        return systemLocales;
    }

    @RequiresApi(33)
    private static Object getLocaleManagerForApplication(Context context) {
        return context.getSystemService("locale");
    }

    @VisibleForTesting
    static LocaleListCompat getConfigurationLocales(Configuration conf) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            return Api24Impl.getLocales(conf);
        }
        if (i >= 21) {
            return LocaleListCompat.forLanguageTags(Api21Impl.toLanguageTag(conf.locale));
        }
        return LocaleListCompat.create(conf.locale);
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static String toLanguageTag(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static LocaleListCompat getLocales(Configuration configuration) {
            return LocaleListCompat.forLanguageTags(configuration.getLocales().toLanguageTags());
        }
    }

    @RequiresApi(33)
    static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static LocaleList localeManagerGetSystemLocales(Object localeManager) {
            return ((LocaleManager) localeManager).getSystemLocales();
        }
    }
}
