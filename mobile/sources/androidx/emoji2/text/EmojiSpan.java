package androidx.emoji2.text;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;

@RequiresApi(19)
public abstract class EmojiSpan extends ReplacementSpan {
    private short mHeight = -1;
    @NonNull
    private final EmojiMetadata mMetadata;
    private float mRatio = 1.0f;
    private final Paint.FontMetricsInt mTmpFontMetrics = new Paint.FontMetricsInt();
    private short mWidth = -1;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    EmojiSpan(@NonNull EmojiMetadata metadata) {
        Preconditions.checkNotNull(metadata, "metadata cannot be null");
        this.mMetadata = metadata;
    }

    public int getSize(@NonNull Paint paint, CharSequence text, int start, int end, @Nullable Paint.FontMetricsInt fm) {
        paint.getFontMetricsInt(this.mTmpFontMetrics);
        Paint.FontMetricsInt fontMetricsInt = this.mTmpFontMetrics;
        this.mRatio = (((float) Math.abs(fontMetricsInt.descent - fontMetricsInt.ascent)) * 1.0f) / ((float) this.mMetadata.getHeight());
        this.mHeight = (short) ((int) (((float) this.mMetadata.getHeight()) * this.mRatio));
        short width = (short) ((int) (((float) this.mMetadata.getWidth()) * this.mRatio));
        this.mWidth = width;
        if (fm != null) {
            Paint.FontMetricsInt fontMetricsInt2 = this.mTmpFontMetrics;
            fm.ascent = fontMetricsInt2.ascent;
            fm.descent = fontMetricsInt2.descent;
            fm.top = fontMetricsInt2.top;
            fm.bottom = fontMetricsInt2.bottom;
        }
        return width;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final EmojiMetadata getMetadata() {
        return this.mMetadata;
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final int getWidth() {
        return this.mWidth;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public final int getHeight() {
        return this.mHeight;
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final float getRatio() {
        return this.mRatio;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public final int getId() {
        return getMetadata().getId();
    }
}
