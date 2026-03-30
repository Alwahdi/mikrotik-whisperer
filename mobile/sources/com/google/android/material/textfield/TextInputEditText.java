package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

public class TextInputEditText extends AppCompatEditText {
    private final Rect a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f1953a;

    public TextInputEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, yb0.p);
    }

    public TextInputEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(t00.c(context, attrs, defStyleAttr, 0), attrs, defStyleAttr);
        this.a = new Rect();
        TypedArray attributes = vq0.i(context, attrs, xc0.f5597B1, defStyleAttr, uc0.Widget_Design_TextInputEditText, new int[0]);
        setTextInputLayoutFocusedRectEnabled(attributes.getBoolean(xc0.N4, false));
        attributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout layout = getTextInputLayout();
        if (layout != null && layout.R() && super.getHint() == null && uz.b()) {
            setHint("");
        }
    }

    @Nullable
    public CharSequence getHint() {
        TextInputLayout layout = getTextInputLayout();
        if (layout == null || !layout.R()) {
            return super.getHint();
        }
        return layout.getHint();
    }

    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        InputConnection ic = super.onCreateInputConnection(outAttrs);
        if (ic != null && outAttrs.hintText == null) {
            outAttrs.hintText = getHintFromLayout();
        }
        return ic;
    }

    @Nullable
    private TextInputLayout getTextInputLayout() {
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    @Nullable
    private CharSequence getHintFromLayout() {
        TextInputLayout layout = getTextInputLayout();
        if (layout != null) {
            return layout.getHint();
        }
        return null;
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean textInputLayoutFocusedRectEnabled) {
        this.f1953a = textInputLayoutFocusedRectEnabled;
    }

    private boolean b(TextInputLayout textInputLayout) {
        return textInputLayout != null && this.f1953a;
    }

    public void getFocusedRect(Rect r) {
        super.getFocusedRect(r);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (b(textInputLayout) && r != null) {
            textInputLayout.getFocusedRect(this.a);
            r.bottom = this.a.bottom;
        }
    }

    public boolean getGlobalVisibleRect(Rect r, Point globalOffset) {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!b(textInputLayout)) {
            return super.getGlobalVisibleRect(r, globalOffset);
        }
        boolean isVisible = textInputLayout.getGlobalVisibleRect(r, globalOffset);
        if (isVisible && globalOffset != null) {
            globalOffset.offset(-getScrollX(), -getScrollY());
        }
        return isVisible;
    }

    public boolean requestRectangleOnScreen(Rect rectangle) {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!b(textInputLayout) || rectangle == null) {
            return super.requestRectangleOnScreen(rectangle);
        }
        this.a.set(rectangle.left, rectangle.top, rectangle.right, rectangle.bottom + (textInputLayout.getHeight() - getHeight()));
        return super.requestRectangleOnScreen(this.a);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        TextInputLayout layout = getTextInputLayout();
        if (Build.VERSION.SDK_INT < 23 && layout != null) {
            info.setText(a(layout));
        }
    }

    private String a(TextInputLayout layout) {
        CharSequence inputText = getText();
        CharSequence hintText = layout.getHint();
        boolean showingText = !TextUtils.isEmpty(inputText);
        String str = "";
        String hint = TextUtils.isEmpty(hintText) ^ true ? hintText.toString() : str;
        if (showingText) {
            StringBuilder sb = new StringBuilder();
            sb.append(inputText);
            if (!TextUtils.isEmpty(hint)) {
                str = ", " + hint;
            }
            sb.append(str);
            return sb.toString();
        } else if (!TextUtils.isEmpty(hint)) {
            return hint;
        } else {
            return str;
        }
    }
}
