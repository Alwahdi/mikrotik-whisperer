package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class ImageViewCompat {
    @Nullable
    public static ColorStateList getImageTintList(@NonNull ImageView view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.getImageTintList(view);
        }
        if (view instanceof TintableImageSourceView) {
            return ((TintableImageSourceView) view).getSupportImageTintList();
        }
        return null;
    }

    public static void setImageTintList(@NonNull ImageView view, @Nullable ColorStateList tintList) {
        Drawable imageViewDrawable;
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            Api21Impl.setImageTintList(view, tintList);
            if (i == 21 && (imageViewDrawable = view.getDrawable()) != null && Api21Impl.getImageTintList(view) != null) {
                if (imageViewDrawable.isStateful()) {
                    imageViewDrawable.setState(view.getDrawableState());
                }
                view.setImageDrawable(imageViewDrawable);
            }
        } else if (view instanceof TintableImageSourceView) {
            ((TintableImageSourceView) view).setSupportImageTintList(tintList);
        }
    }

    @Nullable
    public static PorterDuff.Mode getImageTintMode(@NonNull ImageView view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.getImageTintMode(view);
        }
        if (view instanceof TintableImageSourceView) {
            return ((TintableImageSourceView) view).getSupportImageTintMode();
        }
        return null;
    }

    public static void setImageTintMode(@NonNull ImageView view, @Nullable PorterDuff.Mode mode) {
        Drawable imageViewDrawable;
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            Api21Impl.setImageTintMode(view, mode);
            if (i == 21 && (imageViewDrawable = view.getDrawable()) != null && Api21Impl.getImageTintList(view) != null) {
                if (imageViewDrawable.isStateful()) {
                    imageViewDrawable.setState(view.getDrawableState());
                }
                view.setImageDrawable(imageViewDrawable);
            }
        } else if (view instanceof TintableImageSourceView) {
            ((TintableImageSourceView) view).setSupportImageTintMode(mode);
        }
    }

    private ImageViewCompat() {
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static ColorStateList getImageTintList(ImageView imageView) {
            return imageView.getImageTintList();
        }

        @DoNotInline
        static void setImageTintList(ImageView imageView, ColorStateList tint) {
            imageView.setImageTintList(tint);
        }

        @DoNotInline
        static PorterDuff.Mode getImageTintMode(ImageView imageView) {
            return imageView.getImageTintMode();
        }

        @DoNotInline
        static void setImageTintMode(ImageView imageView, PorterDuff.Mode tintMode) {
            imageView.setImageTintMode(tintMode);
        }
    }
}
