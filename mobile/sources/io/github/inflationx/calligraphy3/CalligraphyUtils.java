package io.github.inflationx.calligraphy3;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

public final class CalligraphyUtils {
    public static final int[] ANDROID_ATTR_TEXT_APPEARANCE = {16842804};
    private static Boolean sAppCompatViewCheck = null;
    private static Boolean sToolbarCheck = null;

    public static CharSequence applyTypefaceSpan(CharSequence s, Typeface typeface) {
        if (s != null && s.length() > 0) {
            if (!(s instanceof Spannable)) {
                s = new SpannableString(s);
            }
            ((Spannable) s).setSpan(TypefaceUtils.getSpan(typeface), 0, s.length(), 33);
        }
        return s;
    }

    public static boolean applyFontToTextView(TextView textView, Typeface typeface) {
        return applyFontToTextView(textView, typeface, false);
    }

    public static boolean applyFontToTextView(TextView textView, final Typeface typeface, boolean deferred) {
        if (textView == null || typeface == null) {
            return false;
        }
        textView.setPaintFlags(textView.getPaintFlags() | 128 | 1);
        textView.setTypeface(typeface);
        if (deferred) {
            textView.setText(applyTypefaceSpan(textView.getText(), typeface), TextView.BufferType.SPANNABLE);
            textView.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                public void afterTextChanged(Editable s) {
                    CalligraphyUtils.applyTypefaceSpan(s, typeface);
                }
            });
        }
        return true;
    }

    public static boolean applyFontToTextView(Context context, TextView textView, String filePath) {
        return applyFontToTextView(context, textView, filePath, false);
    }

    static boolean applyFontToTextView(Context context, TextView textView, String filePath, boolean deferred) {
        if (textView == null || context == null) {
            return false;
        }
        return applyFontToTextView(textView, TypefaceUtils.load(context.getAssets(), filePath), deferred);
    }

    static void applyFontToTextView(Context context, TextView textView, CalligraphyConfig config) {
        applyFontToTextView(context, textView, config, false);
    }

    static void applyFontToTextView(Context context, TextView textView, CalligraphyConfig config, boolean deferred) {
        if (context != null && textView != null && config != null && config.isFontSet()) {
            applyFontToTextView(context, textView, config.getFontPath(), deferred);
        }
    }

    public static void applyFontToTextView(Context context, TextView textView, CalligraphyConfig config, String textViewFont) {
        applyFontToTextView(context, textView, config, textViewFont, false);
    }

    static void applyFontToTextView(Context context, TextView textView, CalligraphyConfig config, String textViewFont, boolean deferred) {
        if (context != null && textView != null && config != null) {
            if (TextUtils.isEmpty(textViewFont) || !applyFontToTextView(context, textView, textViewFont, deferred)) {
                applyFontToTextView(context, textView, config, deferred);
            }
        }
    }

    static String pullFontPathFromView(Context context, AttributeSet attrs, int[] attributeId) {
        String fontPath;
        CharSequence charSequence;
        if (attributeId == null || attrs == null) {
            return null;
        }
        try {
            String attributeName = context.getResources().getResourceEntryName(attributeId[0]);
            int stringResourceId = attrs.getAttributeResourceValue((String) null, attributeName, -1);
            if (stringResourceId > 0) {
                fontPath = context.getString(stringResourceId);
            } else {
                fontPath = attrs.getAttributeValue((String) null, attributeName);
            }
            if (fontPath == null || !fontPath.startsWith("?") || fontPath.length() <= 1) {
                return fontPath;
            }
            String fontPathValueAttr = fontPath.substring(1);
            if (!TextUtils.isDigitsOnly(fontPathValueAttr)) {
                return fontPath;
            }
            int fontPathValueAttrRes = Integer.parseInt(fontPathValueAttr);
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(fontPathValueAttrRes, typedValue, true);
            if (typedValue.type != 3 || (charSequence = typedValue.string) == null) {
                return fontPath;
            }
            return charSequence.toString();
        } catch (Resources.NotFoundException e) {
            return null;
        }
    }

    static String pullFontPathFromStyle(Context context, AttributeSet attrs, int[] attributeId) {
        TypedArray typedArray;
        if (!(attributeId == null || attrs == null || (typedArray = context.obtainStyledAttributes(attrs, attributeId)) == null)) {
            try {
                String fontFromAttribute = typedArray.getString(0);
                if (!TextUtils.isEmpty(fontFromAttribute)) {
                    typedArray.recycle();
                    return fontFromAttribute;
                }
            } catch (Exception e) {
            } catch (Throwable th) {
                typedArray.recycle();
                throw th;
            }
            typedArray.recycle();
        }
        return null;
    }

    static String pullFontPathFromTextAppearance(Context context, AttributeSet attrs, int[] attributeId) {
        if (attributeId == null || attrs == null) {
            return null;
        }
        int textAppearanceId = -1;
        TypedArray typedArrayAttr = context.obtainStyledAttributes(attrs, ANDROID_ATTR_TEXT_APPEARANCE);
        if (typedArrayAttr != null) {
            try {
                textAppearanceId = typedArrayAttr.getResourceId(0, -1);
            } catch (Exception e) {
                return null;
            } finally {
                typedArrayAttr.recycle();
            }
        }
        TypedArray textAppearanceAttrs = context.obtainStyledAttributes(textAppearanceId, attributeId);
        if (textAppearanceAttrs == null) {
            return null;
        }
        try {
            return textAppearanceAttrs.getString(0);
        } catch (Exception e2) {
            return null;
        } finally {
            textAppearanceAttrs.recycle();
        }
    }

    static String pullFontPathFromTheme(Context context, int styleAttrId, int[] attributeId) {
        if (styleAttrId == -1 || attributeId == null) {
            return null;
        }
        Resources.Theme theme = context.getTheme();
        TypedValue value = new TypedValue();
        theme.resolveAttribute(styleAttrId, value, true);
        TypedArray typedArray = theme.obtainStyledAttributes(value.resourceId, attributeId);
        try {
            return typedArray.getString(0);
        } catch (Exception e) {
            return null;
        } finally {
            typedArray.recycle();
        }
    }

    static String pullFontPathFromTheme(Context context, int styleAttrId, int subStyleAttrId, int[] attributeId) {
        TypedArray subTypedArray;
        if (styleAttrId == -1 || attributeId == null) {
            return null;
        }
        Resources.Theme theme = context.getTheme();
        TypedValue value = new TypedValue();
        theme.resolveAttribute(styleAttrId, value, true);
        TypedArray parentTypedArray = theme.obtainStyledAttributes(value.resourceId, new int[]{subStyleAttrId});
        try {
            int subStyleResId = parentTypedArray.getResourceId(0, -1);
            if (subStyleResId == -1 || (subTypedArray = context.obtainStyledAttributes(subStyleResId, attributeId)) == null) {
                return null;
            }
            try {
                return subTypedArray.getString(0);
            } catch (Exception e) {
                return null;
            } finally {
                subTypedArray.recycle();
            }
        } catch (Exception e2) {
            return null;
        } finally {
            parentTypedArray.recycle();
        }
    }

    static boolean canCheckForV7Toolbar() {
        if (sToolbarCheck == null) {
            try {
                Class.forName("androidx.appcompat.widget.Toolbar");
                sToolbarCheck = Boolean.TRUE;
            } catch (ClassNotFoundException e) {
                sToolbarCheck = Boolean.FALSE;
            }
        }
        return sToolbarCheck.booleanValue();
    }

    static boolean canAddV7AppCompatViews() {
        if (sAppCompatViewCheck == null) {
            try {
                Class.forName("androidx.appcompat.widget.AppCompatTextView");
                sAppCompatViewCheck = Boolean.TRUE;
            } catch (ClassNotFoundException e) {
                sAppCompatViewCheck = Boolean.FALSE;
            }
        }
        return sAppCompatViewCheck.booleanValue();
    }

    private CalligraphyUtils() {
    }
}
