package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;

public final class TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1 implements TextWatcher {
    final /* synthetic */ no $onTextChanged;

    public TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1(no $onTextChanged2) {
        this.$onTextChanged = $onTextChanged2;
    }

    public void afterTextChanged(Editable s) {
        Editable editable = s;
    }

    public void beforeTextChanged(CharSequence text, int start, int count, int after) {
    }

    public void onTextChanged(CharSequence text, int start, int before, int count) {
        this.$onTextChanged.invoke(text, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
    }
}
