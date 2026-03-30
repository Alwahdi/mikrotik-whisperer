package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;

public final class TextViewKt$addTextChangedListener$textWatcher$1 implements TextWatcher {
    final /* synthetic */ vn<Editable, jt0> $afterTextChanged;
    final /* synthetic */ no<CharSequence, Integer, Integer, Integer, jt0> $beforeTextChanged;
    final /* synthetic */ no<CharSequence, Integer, Integer, Integer, jt0> $onTextChanged;

    public TextViewKt$addTextChangedListener$textWatcher$1(vn<? super Editable, jt0> $afterTextChanged2, no<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, jt0> $beforeTextChanged2, no<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, jt0> $onTextChanged2) {
        this.$afterTextChanged = $afterTextChanged2;
        this.$beforeTextChanged = $beforeTextChanged2;
        this.$onTextChanged = $onTextChanged2;
    }

    public void afterTextChanged(Editable s) {
        this.$afterTextChanged.invoke(s);
    }

    public void beforeTextChanged(CharSequence text, int start, int count, int after) {
        this.$beforeTextChanged.invoke(text, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
    }

    public void onTextChanged(CharSequence text, int start, int before, int count) {
        this.$onTextChanged.invoke(text, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
    }
}
