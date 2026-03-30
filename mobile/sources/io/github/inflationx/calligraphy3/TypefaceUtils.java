package io.github.inflationx.calligraphy3;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

public final class TypefaceUtils {
    private static final Map<String, Typeface> sCachedFonts = new HashMap();
    private static final Map<Typeface, CalligraphyTypefaceSpan> sCachedSpans = new HashMap();

    public static Typeface load(AssetManager assetManager, String filePath) {
        Typeface typeface;
        Map<String, Typeface> map = sCachedFonts;
        synchronized (map) {
            try {
                if (!map.containsKey(filePath)) {
                    if (filePath.startsWith("/")) {
                        typeface = Typeface.createFromFile(filePath);
                    } else {
                        typeface = Typeface.createFromAsset(assetManager, filePath);
                    }
                    map.put(filePath, typeface);
                    return typeface;
                }
                Typeface typeface2 = map.get(filePath);
                return typeface2;
            } catch (Exception e) {
                Log.w("Calligraphy", "Can't create asset from " + filePath + ". Make sure you have passed in the correct path and file name.", e);
                sCachedFonts.put(filePath, (Object) null);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static CalligraphyTypefaceSpan getSpan(Typeface typeface) {
        if (typeface == null) {
            return null;
        }
        Map<Typeface, CalligraphyTypefaceSpan> map = sCachedSpans;
        synchronized (map) {
            if (!map.containsKey(typeface)) {
                CalligraphyTypefaceSpan span = new CalligraphyTypefaceSpan(typeface);
                map.put(typeface, span);
                return span;
            }
            CalligraphyTypefaceSpan calligraphyTypefaceSpan = map.get(typeface);
            return calligraphyTypefaceSpan;
        }
    }

    public static boolean isLoaded(Typeface typeface) {
        return typeface != null && sCachedFonts.containsValue(typeface);
    }

    private TypefaceUtils() {
    }
}
