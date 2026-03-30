package com.google.android.material.textfield;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.CheckableImageButton;

abstract class s {
    final Context a;

    /* renamed from: a  reason: collision with other field name */
    final CheckableImageButton f2047a;

    /* renamed from: a  reason: collision with other field name */
    final TextInputLayout f2048a;

    /* renamed from: a  reason: collision with other field name */
    final r f2049a;

    s(r endLayout) {
        this.f2048a = endLayout.f2036a;
        this.f2049a = endLayout;
        this.a = endLayout.getContext();
        this.f2047a = endLayout.r();
    }

    /* access modifiers changed from: package-private */
    public void s() {
    }

    /* access modifiers changed from: package-private */
    public void u() {
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean t() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean i(int boxBackgroundMode) {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void q(boolean visible) {
    }

    /* access modifiers changed from: package-private */
    public View.OnClickListener f() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public View.OnFocusChangeListener e() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public View.OnFocusChangeListener g() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public AccessibilityManagerCompat.TouchExplorationStateChangeListener h() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public void n(EditText editText) {
    }

    /* access modifiers changed from: package-private */
    public void b(CharSequence s, int start, int count, int after) {
    }

    /* access modifiers changed from: package-private */
    public void a(Editable s) {
    }

    /* access modifiers changed from: package-private */
    public void o(View host, AccessibilityNodeInfoCompat info) {
    }

    /* access modifiers changed from: package-private */
    public void p(View host, AccessibilityEvent event) {
    }

    /* access modifiers changed from: package-private */
    public final void r() {
        this.f2049a.L(false);
    }
}
