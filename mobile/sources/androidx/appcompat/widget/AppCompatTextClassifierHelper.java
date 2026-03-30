package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

final class AppCompatTextClassifierHelper {
    @Nullable
    private TextClassifier mTextClassifier;
    @NonNull
    private TextView mTextView;

    AppCompatTextClassifierHelper(@NonNull TextView textView) {
        this.mTextView = (TextView) Preconditions.checkNotNull(textView);
    }

    @RequiresApi(api = 26)
    public void setTextClassifier(@Nullable TextClassifier textClassifier) {
        this.mTextClassifier = textClassifier;
    }

    @RequiresApi(api = 26)
    @NonNull
    public TextClassifier getTextClassifier() {
        TextClassifier textClassifier = this.mTextClassifier;
        if (textClassifier == null) {
            return Api26Impl.getTextClassifier(this.mTextView);
        }
        return textClassifier;
    }

    @RequiresApi(26)
    private static final class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        @NonNull
        static TextClassifier getTextClassifier(@NonNull TextView textView) {
            TextClassificationManager tcm = (TextClassificationManager) textView.getContext().getSystemService(TextClassificationManager.class);
            if (tcm != null) {
                return tcm.getTextClassifier();
            }
            return TextClassifier.NO_OP;
        }
    }
}
