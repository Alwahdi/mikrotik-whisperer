package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;

class ChipTextInputComboView extends FrameLayout implements Checkable {
    private TextWatcher a;

    /* renamed from: a  reason: collision with other field name */
    private final EditText f2090a;

    /* renamed from: a  reason: collision with other field name */
    private TextView f2091a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final Chip f2092a;

    /* renamed from: a  reason: collision with other field name */
    private final TextInputLayout f2093a;

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChipTextInputComboView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = LayoutInflater.from(context);
        Chip chip = (Chip) inflater.inflate(nc0.material_time_chip, this, false);
        this.f2092a = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) inflater.inflate(nc0.material_time_input, this, false);
        this.f2093a = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f2090a = editText;
        editText.setVisibility(4);
        b bVar = new b();
        this.a = bVar;
        editText.addTextChangedListener(bVar);
        d();
        addView(chip);
        addView(textInputLayout);
        this.f2091a = (TextView) findViewById(ic0.material_label);
        editText.setId(ViewCompat.generateViewId());
        ViewCompat.setLabelFor(this.f2091a, editText.getId());
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }

    private void d() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f2090a.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    public boolean isChecked() {
        return this.f2092a.isChecked();
    }

    public void setChecked(boolean checked) {
        this.f2092a.setChecked(checked);
        this.f2090a.setVisibility(checked ? 0 : 4);
        this.f2092a.setVisibility(checked ? 8 : 0);
        if (isChecked()) {
            lv0.k(this.f2090a, false);
        }
    }

    public void toggle() {
        this.f2092a.toggle();
    }

    /* access modifiers changed from: private */
    public String c(CharSequence text) {
        return e.f(getResources(), text);
    }

    public void setOnClickListener(View.OnClickListener l) {
        this.f2092a.setOnClickListener(l);
    }

    public void setTag(int key, Object tag) {
        this.f2092a.setTag(key, tag);
    }

    private class b extends uq0 {
        private b() {
        }

        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.this.f2092a.setText(ChipTextInputComboView.this.c("00"));
                return;
            }
            String formattedText = ChipTextInputComboView.this.c(editable);
            ChipTextInputComboView.this.f2092a.setText(TextUtils.isEmpty(formattedText) ? ChipTextInputComboView.this.c("00") : formattedText);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        d();
    }
}
