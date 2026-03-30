package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;

public final class TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1 implements TextWatcher {
    final /* synthetic */ no $beforeTextChanged;

    public TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1(no $beforeTextChanged2) {
        this.$beforeTextChanged = $beforeTextChanged2;
    }

    public void afterTextChanged(Editable s) {
        Editable editable = s;
    }

    public void beforeTextChanged(CharSequence text, int start, int count, int after) {
        this.$beforeTextChanged.invoke(text, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
    }

    public void onTextChanged(CharSequence text, int start, int before, int count) {
    }
}
