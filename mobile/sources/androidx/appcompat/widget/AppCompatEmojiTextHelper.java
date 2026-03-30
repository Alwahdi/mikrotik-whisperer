package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.emoji2.viewsintegration.EmojiTextViewHelper;

class AppCompatEmojiTextHelper {
    @NonNull
    private final EmojiTextViewHelper mEmojiTextViewHelper;
    @NonNull
    private final TextView mView;

    AppCompatEmojiTextHelper(@NonNull TextView view) {
        this.mView = view;
        this.mEmojiTextViewHelper = new EmojiTextViewHelper(view, false);
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void loadFromAttributes(@Nullable AttributeSet attrs, int defStyleAttr) {
        TypedArray a = this.mView.getContext().obtainStyledAttributes(attrs, R.styleable.AppCompatTextView, defStyleAttr, 0);
        boolean enabled = true;
        try {
            int i = R.styleable.AppCompatTextView_emojiCompatEnabled;
            if (a.hasValue(i)) {
                enabled = a.getBoolean(i, true);
            }
            a.recycle();
            setEnabled(enabled);
        } catch (Throwable th) {
            a.recycle();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void setEnabled(boolean enabled) {
        this.mEmojiTextViewHelper.setEnabled(enabled);
    }

    public boolean isEnabled() {
        return this.mEmojiTextViewHelper.isEnabled();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public InputFilter[] getFilters(@NonNull InputFilter[] filters) {
        return this.mEmojiTextViewHelper.getFilters(filters);
    }

    /* access modifiers changed from: package-private */
    public void setAllCaps(boolean allCaps) {
        this.mEmojiTextViewHelper.setAllCaps(allCaps);
    }

    @Nullable
    public TransformationMethod wrapTransformationMethod(@Nullable TransformationMethod transformationMethod) {
        return this.mEmojiTextViewHelper.wrapTransformationMethod(transformationMethod);
    }
}
