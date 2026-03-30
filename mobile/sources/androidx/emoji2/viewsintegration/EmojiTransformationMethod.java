package androidx.emoji2.viewsintegration;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;

@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
class EmojiTransformationMethod implements TransformationMethod {
    @Nullable
    private final TransformationMethod mTransformationMethod;

    EmojiTransformationMethod(@Nullable TransformationMethod transformationMethod) {
        this.mTransformationMethod = transformationMethod;
    }

    public CharSequence getTransformation(@Nullable CharSequence source, @NonNull View view) {
        if (view.isInEditMode()) {
            return source;
        }
        TransformationMethod transformationMethod = this.mTransformationMethod;
        if (transformationMethod != null) {
            source = transformationMethod.getTransformation(source, view);
        }
        if (source != null) {
            switch (EmojiCompat.get().getLoadState()) {
                case 1:
                    return EmojiCompat.get().process(source);
            }
        }
        return source;
    }

    public void onFocusChanged(View view, CharSequence sourceText, boolean focused, int direction, Rect previouslyFocusedRect) {
        TransformationMethod transformationMethod = this.mTransformationMethod;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, sourceText, focused, direction, previouslyFocusedRect);
        }
    }

    public TransformationMethod getOriginalTransformationMethod() {
        return this.mTransformationMethod;
    }
}
