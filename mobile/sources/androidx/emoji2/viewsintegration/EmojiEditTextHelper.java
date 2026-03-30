package androidx.emoji2.viewsintegration;

import android.os.Build;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;

public final class EmojiEditTextHelper {
    private int mEmojiReplaceStrategy;
    private final HelperInternal mHelper;
    private int mMaxEmojiCount;

    public EmojiEditTextHelper(@NonNull EditText editText) {
        this(editText, true);
    }

    public EmojiEditTextHelper(@NonNull EditText editText, boolean expectInitializedEmojiCompat) {
        this.mMaxEmojiCount = Integer.MAX_VALUE;
        this.mEmojiReplaceStrategy = 0;
        Preconditions.checkNotNull(editText, "editText cannot be null");
        if (Build.VERSION.SDK_INT < 19) {
            this.mHelper = new HelperInternal();
        } else {
            this.mHelper = new HelperInternal19(editText, expectInitializedEmojiCompat);
        }
    }

    public void setMaxEmojiCount(@IntRange(from = 0) int maxEmojiCount) {
        Preconditions.checkArgumentNonnegative(maxEmojiCount, "maxEmojiCount should be greater than 0");
        this.mMaxEmojiCount = maxEmojiCount;
        this.mHelper.setMaxEmojiCount(maxEmojiCount);
    }

    public int getMaxEmojiCount() {
        return this.mMaxEmojiCount;
    }

    @Nullable
    public KeyListener getKeyListener(@Nullable KeyListener keyListener) {
        return this.mHelper.getKeyListener(keyListener);
    }

    @Nullable
    public InputConnection onCreateInputConnection(@Nullable InputConnection inputConnection, @NonNull EditorInfo outAttrs) {
        if (inputConnection == null) {
            return null;
        }
        return this.mHelper.onCreateInputConnection(inputConnection, outAttrs);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setEmojiReplaceStrategy(int replaceStrategy) {
        this.mEmojiReplaceStrategy = replaceStrategy;
        this.mHelper.setEmojiReplaceStrategy(replaceStrategy);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getEmojiReplaceStrategy() {
        return this.mEmojiReplaceStrategy;
    }

    public boolean isEnabled() {
        return this.mHelper.isEnabled();
    }

    public void setEnabled(boolean isEnabled) {
        this.mHelper.setEnabled(isEnabled);
    }

    static class HelperInternal {
        HelperInternal() {
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public KeyListener getKeyListener(@Nullable KeyListener keyListener) {
            return keyListener;
        }

        /* access modifiers changed from: package-private */
        public InputConnection onCreateInputConnection(@NonNull InputConnection inputConnection, @NonNull EditorInfo outAttrs) {
            return inputConnection;
        }

        /* access modifiers changed from: package-private */
        public void setMaxEmojiCount(int maxEmojiCount) {
        }

        /* access modifiers changed from: package-private */
        public void setEmojiReplaceStrategy(int replaceStrategy) {
        }

        /* access modifiers changed from: package-private */
        public void setEnabled(boolean isEnabled) {
        }

        /* access modifiers changed from: package-private */
        public boolean isEnabled() {
            return false;
        }
    }

    @RequiresApi(19)
    private static class HelperInternal19 extends HelperInternal {
        private final EditText mEditText;
        private final EmojiTextWatcher mTextWatcher;

        HelperInternal19(@NonNull EditText editText, boolean expectInitializedEmojiCompat) {
            this.mEditText = editText;
            EmojiTextWatcher emojiTextWatcher = new EmojiTextWatcher(editText, expectInitializedEmojiCompat);
            this.mTextWatcher = emojiTextWatcher;
            editText.addTextChangedListener(emojiTextWatcher);
            editText.setEditableFactory(EmojiEditableFactory.getInstance());
        }

        /* access modifiers changed from: package-private */
        public void setMaxEmojiCount(int maxEmojiCount) {
            this.mTextWatcher.setMaxEmojiCount(maxEmojiCount);
        }

        /* access modifiers changed from: package-private */
        public void setEmojiReplaceStrategy(int replaceStrategy) {
            this.mTextWatcher.setEmojiReplaceStrategy(replaceStrategy);
        }

        /* access modifiers changed from: package-private */
        public KeyListener getKeyListener(@Nullable KeyListener keyListener) {
            if (keyListener instanceof EmojiKeyListener) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            if (keyListener instanceof NumberKeyListener) {
                return keyListener;
            }
            return new EmojiKeyListener(keyListener);
        }

        /* access modifiers changed from: package-private */
        public InputConnection onCreateInputConnection(@NonNull InputConnection inputConnection, @NonNull EditorInfo outAttrs) {
            if (inputConnection instanceof EmojiInputConnection) {
                return inputConnection;
            }
            return new EmojiInputConnection(this.mEditText, inputConnection, outAttrs);
        }

        /* access modifiers changed from: package-private */
        public void setEnabled(boolean isEnabled) {
            this.mTextWatcher.setEnabled(isEnabled);
        }

        /* access modifiers changed from: package-private */
        public boolean isEnabled() {
            return this.mTextWatcher.isEnabled();
        }
    }
}
