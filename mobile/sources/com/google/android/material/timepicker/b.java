package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;

class b implements InputFilter {
    private int a;

    public b(int max) {
        this.a = max;
    }

    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {
            StringBuilder builder = new StringBuilder(dest);
            builder.replace(dstart, dend, source.subSequence(start, end).toString());
            if (Integer.parseInt(builder.toString()) <= this.a) {
                return null;
            }
            return "";
        } catch (NumberFormatException e) {
            return "";
        }
    }
}
