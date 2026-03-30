package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.DoNotInline;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import androidx.core.os.BuildCompat;
import androidx.core.text.ICUCompat;
import java.util.Locale;

public final class LocaleListCompat {
    private static final LocaleListCompat sEmptyLocaleList = create(new Locale[0]);
    private final LocaleListInterface mImpl;

    private LocaleListCompat(LocaleListInterface impl) {
        this.mImpl = impl;
    }

    @RequiresApi(24)
    @Deprecated
    public static LocaleListCompat wrap(Object localeList) {
        return wrap((LocaleList) localeList);
    }

    @RequiresApi(24)
    @NonNull
    public static LocaleListCompat wrap(@NonNull LocaleList localeList) {
        return new LocaleListCompat(new LocaleListPlatformWrapper(localeList));
    }

    @Nullable
    public Object unwrap() {
        return this.mImpl.getLocaleList();
    }

    @NonNull
    public static LocaleListCompat create(@NonNull Locale... localeList) {
        if (Build.VERSION.SDK_INT >= 24) {
            return wrap(Api24Impl.createLocaleList(localeList));
        }
        return new LocaleListCompat(new LocaleListCompatWrapper(localeList));
    }

    @Nullable
    public Locale get(int index) {
        return this.mImpl.get(index);
    }

    public boolean isEmpty() {
        return this.mImpl.isEmpty();
    }

    @IntRange(from = 0)
    public int size() {
        return this.mImpl.size();
    }

    @IntRange(from = -1)
    public int indexOf(@Nullable Locale locale) {
        return this.mImpl.indexOf(locale);
    }

    @NonNull
    public String toLanguageTags() {
        return this.mImpl.toLanguageTags();
    }

    @Nullable
    public Locale getFirstMatch(@NonNull String[] supportedLocales) {
        return this.mImpl.getFirstMatch(supportedLocales);
    }

    @NonNull
    public static LocaleListCompat getEmptyLocaleList() {
        return sEmptyLocaleList;
    }

    @NonNull
    public static LocaleListCompat forLanguageTags(@Nullable String list) {
        Locale locale;
        if (list == null || list.isEmpty()) {
            return getEmptyLocaleList();
        }
        String[] tags = list.split(",", -1);
        Locale[] localeArray = new Locale[tags.length];
        for (int i = 0; i < localeArray.length; i++) {
            if (Build.VERSION.SDK_INT >= 21) {
                locale = Api21Impl.forLanguageTag(tags[i]);
            } else {
                locale = forLanguageTagCompat(tags[i]);
            }
            localeArray[i] = locale;
        }
        return create(localeArray);
    }

    static Locale forLanguageTagCompat(String str) {
        if (str.contains("-")) {
            String[] args = str.split("-", -1);
            if (args.length > 2) {
                return new Locale(args[0], args[1], args[2]);
            }
            if (args.length > 1) {
                return new Locale(args[0], args[1]);
            }
            if (args.length == 1) {
                return new Locale(args[0]);
            }
        } else if (!str.contains("_")) {
            return new Locale(str);
        } else {
            String[] args2 = str.split("_", -1);
            if (args2.length > 2) {
                return new Locale(args2[0], args2[1], args2[2]);
            }
            if (args2.length > 1) {
                return new Locale(args2[0], args2[1]);
            }
            if (args2.length == 1) {
                return new Locale(args2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    @Size(min = 1)
    @NonNull
    public static LocaleListCompat getAdjustedDefault() {
        if (Build.VERSION.SDK_INT >= 24) {
            return wrap(Api24Impl.getAdjustedDefault());
        }
        return create(Locale.getDefault());
    }

    @Size(min = 1)
    @NonNull
    public static LocaleListCompat getDefault() {
        if (Build.VERSION.SDK_INT >= 24) {
            return wrap(Api24Impl.getDefault());
        }
        return create(Locale.getDefault());
    }

    @RequiresApi(21)
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static boolean matchesLanguageAndScript(@NonNull Locale supported, @NonNull Locale desired) {
        if (BuildCompat.isAtLeastT()) {
            return LocaleList.matchesLanguageAndScript(supported, desired);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.matchesLanguageAndScript(supported, desired);
        }
        throw new UnsupportedOperationException("This method is only supported on API level 21+");
    }

    @RequiresApi(21)
    static class Api21Impl {
        private static final Locale[] PSEUDO_LOCALE = {new Locale("en", "XA"), new Locale("ar", "XB")};

        private Api21Impl() {
        }

        @DoNotInline
        static boolean matchesLanguageAndScript(@NonNull Locale supported, @NonNull Locale desired) {
            if (supported.equals(desired)) {
                return true;
            }
            if (!supported.getLanguage().equals(desired.getLanguage()) || isPseudoLocale(supported) || isPseudoLocale(desired)) {
                return false;
            }
            String supportedScr = ICUCompat.maximizeAndGetScript(supported);
            if (!supportedScr.isEmpty()) {
                return supportedScr.equals(ICUCompat.maximizeAndGetScript(desired));
            }
            String supportedRegion = supported.getCountry();
            if (supportedRegion.isEmpty() || supportedRegion.equals(desired.getCountry())) {
                return true;
            }
            return false;
        }

        private static boolean isPseudoLocale(Locale locale) {
            for (Locale pseudoLocale : PSEUDO_LOCALE) {
                if (pseudoLocale.equals(locale)) {
                    return true;
                }
            }
            return false;
        }

        @DoNotInline
        static Locale forLanguageTag(String languageTag) {
            return Locale.forLanguageTag(languageTag);
        }
    }

    public boolean equals(Object other) {
        return (other instanceof LocaleListCompat) && this.mImpl.equals(((LocaleListCompat) other).mImpl);
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    @NonNull
    public String toString() {
        return this.mImpl.toString();
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static LocaleList createLocaleList(Locale... list) {
            return new LocaleList(list);
        }

        @DoNotInline
        static LocaleList getAdjustedDefault() {
            return LocaleList.getAdjustedDefault();
        }

        @DoNotInline
        static LocaleList getDefault() {
            return LocaleList.getDefault();
        }
    }
}
