package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

public final class TextViewKt {
    public static final TextWatcher doBeforeTextChanged(TextView $this$doBeforeTextChanged, no<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, jt0> action) {
        lu.f($this$doBeforeTextChanged, "<this>");
        lu.f(action, "action");
        TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1 textWatcher$iv = new TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1(action);
        $this$doBeforeTextChanged.addTextChangedListener(textWatcher$iv);
        return textWatcher$iv;
    }

    public static final TextWatcher doOnTextChanged(TextView $this$doOnTextChanged, no<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, jt0> action) {
        lu.f($this$doOnTextChanged, "<this>");
        lu.f(action, "action");
        TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1 textWatcher$iv = new TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1(action);
        $this$doOnTextChanged.addTextChangedListener(textWatcher$iv);
        return textWatcher$iv;
    }

    public static final TextWatcher doAfterTextChanged(TextView $this$doAfterTextChanged, vn<? super Editable, jt0> action) {
        lu.f($this$doAfterTextChanged, "<this>");
        lu.f(action, "action");
        TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1 textWatcher$iv = new TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1(action);
        $this$doAfterTextChanged.addTextChangedListener(textWatcher$iv);
        return textWatcher$iv;
    }

    public static /* synthetic */ TextWatcher addTextChangedListener$default(TextView $this$addTextChangedListener_u24default, no beforeTextChanged, no onTextChanged, vn afterTextChanged, int i, Object obj) {
        if ((i & 1) != 0) {
            beforeTextChanged = TextViewKt$addTextChangedListener$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            onTextChanged = TextViewKt$addTextChangedListener$2.INSTANCE;
        }
        if ((i & 4) != 0) {
            afterTextChanged = TextViewKt$addTextChangedListener$3.INSTANCE;
        }
        lu.f($this$addTextChangedListener_u24default, "<this>");
        lu.f(beforeTextChanged, "beforeTextChanged");
        lu.f(onTextChanged, "onTextChanged");
        lu.f(afterTextChanged, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 textWatcher = new TextViewKt$addTextChangedListener$textWatcher$1(afterTextChanged, beforeTextChanged, onTextChanged);
        $this$addTextChangedListener_u24default.addTextChangedListener(textWatcher);
        return textWatcher;
    }

    public static final TextWatcher addTextChangedListener(TextView $this$addTextChangedListener, no<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, jt0> beforeTextChanged, no<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, jt0> onTextChanged, vn<? super Editable, jt0> afterTextChanged) {
        lu.f($this$addTextChangedListener, "<this>");
        lu.f(beforeTextChanged, "beforeTextChanged");
        lu.f(onTextChanged, "onTextChanged");
        lu.f(afterTextChanged, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 textWatcher = new TextViewKt$addTextChangedListener$textWatcher$1(afterTextChanged, beforeTextChanged, onTextChanged);
        $this$addTextChangedListener.addTextChangedListener(textWatcher);
        return textWatcher;
    }
}
