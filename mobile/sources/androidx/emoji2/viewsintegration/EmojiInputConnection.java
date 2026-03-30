package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;

@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class EmojiInputConnection extends InputConnectionWrapper {
    private final EmojiCompatDeleteHelper mEmojiCompatDeleteHelper;
    private final TextView mTextView;

    EmojiInputConnection(@NonNull TextView textView, @NonNull InputConnection inputConnection, @NonNull EditorInfo outAttrs) {
        this(textView, inputConnection, outAttrs, new EmojiCompatDeleteHelper());
    }

    EmojiInputConnection(@NonNull TextView textView, @NonNull InputConnection inputConnection, @NonNull EditorInfo outAttrs, @NonNull EmojiCompatDeleteHelper emojiCompatDeleteHelper) {
        super(inputConnection, false);
        this.mTextView = textView;
        this.mEmojiCompatDeleteHelper = emojiCompatDeleteHelper;
        emojiCompatDeleteHelper.updateEditorInfoAttrs(outAttrs);
    }

    public boolean deleteSurroundingText(int beforeLength, int afterLength) {
        return this.mEmojiCompatDeleteHelper.handleDeleteSurroundingText(this, getEditable(), beforeLength, afterLength, false) || super.deleteSurroundingText(beforeLength, afterLength);
    }

    public boolean deleteSurroundingTextInCodePoints(int beforeLength, int afterLength) {
        return this.mEmojiCompatDeleteHelper.handleDeleteSurroundingText(this, getEditable(), beforeLength, afterLength, true) || super.deleteSurroundingTextInCodePoints(beforeLength, afterLength);
    }

    private Editable getEditable() {
        return this.mTextView.getEditableText();
    }

    public static class EmojiCompatDeleteHelper {
        public boolean handleDeleteSurroundingText(@NonNull InputConnection inputConnection, @NonNull Editable editable, @IntRange(from = 0) int beforeLength, @IntRange(from = 0) int afterLength, boolean inCodePoints) {
            return EmojiCompat.handleDeleteSurroundingText(inputConnection, editable, beforeLength, afterLength, inCodePoints);
        }

        public void updateEditorInfoAttrs(@NonNull EditorInfo outAttrs) {
            if (EmojiCompat.isConfigured()) {
                EmojiCompat.get().updateEditorInfo(outAttrs);
            }
        }
    }
}
