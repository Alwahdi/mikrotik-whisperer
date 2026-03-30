package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.EditText;

class y extends s {
    private int a = gc0.design_password_eye;

    /* renamed from: a  reason: collision with other field name */
    private final View.OnClickListener f2079a = new x(this);

    /* renamed from: a  reason: collision with other field name */
    private EditText f2080a;

    /* access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        EditText editText = this.f2080a;
        if (editText != null) {
            int selection = editText.getSelectionEnd();
            if (w()) {
                this.f2080a.setTransformationMethod((TransformationMethod) null);
            } else {
                this.f2080a.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            if (selection >= 0) {
                this.f2080a.setSelection(selection);
            }
            r();
        }
    }

    y(r endLayout, int overrideIconResId) {
        super(endLayout);
        if (overrideIconResId != 0) {
            this.a = overrideIconResId;
        }
    }

    /* access modifiers changed from: package-private */
    public void s() {
        if (x(this.f2080a)) {
            this.f2080a.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    /* access modifiers changed from: package-private */
    public void u() {
        EditText editText = this.f2080a;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return sc0.password_toggle_content_description;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return !w();
    }

    /* access modifiers changed from: package-private */
    public View.OnClickListener f() {
        return this.f2079a;
    }

    /* access modifiers changed from: package-private */
    public void n(EditText editText) {
        this.f2080a = editText;
        r();
    }

    /* access modifiers changed from: package-private */
    public void b(CharSequence s, int start, int count, int after) {
        r();
    }

    private boolean w() {
        EditText editText = this.f2080a;
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private static boolean x(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }
}
