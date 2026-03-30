package androidx.appcompat.resources;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class Compatibility {
    private Compatibility() {
    }

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static void inflate(@NonNull Drawable drawable, @NonNull Resources r, @NonNull XmlPullParser parser, @NonNull AttributeSet attrs, @Nullable Resources.Theme theme) throws IOException, XmlPullParserException {
            drawable.inflate(r, parser, attrs, theme);
        }

        @DoNotInline
        public static int getChangingConfigurations(@NonNull TypedArray typedArray) {
            return typedArray.getChangingConfigurations();
        }

        @DoNotInline
        @NonNull
        public static Drawable createFromXmlInner(@NonNull Resources r, @NonNull XmlPullParser parser, @NonNull AttributeSet attrs, @Nullable Resources.Theme theme) throws IOException, XmlPullParserException {
            return Drawable.createFromXmlInner(r, parser, attrs, theme);
        }
    }

    @RequiresApi(18)
    public static class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        public static void setAutoCancel(@NonNull ObjectAnimator objectAnimator, boolean cancel) {
            objectAnimator.setAutoCancel(cancel);
        }
    }

    @RequiresApi(15)
    public static class Api15Impl {
        private Api15Impl() {
        }

        @DoNotInline
        public static void getValueForDensity(@NonNull Resources resources, int id, int density, @NonNull TypedValue outValue, boolean resolveRefs) {
            resources.getValueForDensity(id, density, outValue, resolveRefs);
        }
    }
}
