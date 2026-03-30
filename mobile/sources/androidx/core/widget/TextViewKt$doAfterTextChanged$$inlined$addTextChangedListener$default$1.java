package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;

public final class TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1 implements TextWatcher {
    final /* synthetic */ vn $afterTextChanged;

    public TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1(vn $afterTextChanged2) {
        this.$afterTextChanged = $afterTextChanged2;
    }

    public void afterTextChanged(Editable s) {
        this.$afterTextChanged.invoke(s);
    }

    public void beforeTextChanged(CharSequence text, int start, int count, int after) {
    }

    public void onTextChanged(CharSequence text, int start, int before, int count) {
    }
}
