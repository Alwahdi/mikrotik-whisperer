package io.github.inflationx.calligraphy3;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

class Calligraphy {
    private static final String ACTION_BAR_SUBTITLE = "action_bar_subtitle";
    private static final String ACTION_BAR_TITLE = "action_bar_title";
    private final int[] mAttributeId;
    private final CalligraphyConfig mCalligraphyConfig;

    /* access modifiers changed from: protected */
    public int[] getStyleForTextView(TextView view) {
        int[] styleIds = {-1, -1};
        if (isActionBarTitle(view)) {
            styleIds[0] = 16843470;
            styleIds[1] = 16843512;
        } else if (isActionBarSubTitle(view)) {
            styleIds[0] = 16843470;
            styleIds[1] = 16843513;
        }
        if (styleIds[0] == -1) {
            styleIds[0] = this.mCalligraphyConfig.getClassStyles().containsKey(view.getClass()) ? this.mCalligraphyConfig.getClassStyles().get(view.getClass()).intValue() : 16842804;
        }
        return styleIds;
    }

    protected static boolean isActionBarTitle(TextView view) {
        if (matchesResourceIdName(view, ACTION_BAR_TITLE)) {
            return true;
        }
        if (parentIsToolbarV7(view)) {
            return TextUtils.equals(((Toolbar) view.getParent()).getTitle(), view.getText());
        }
        return false;
    }

    protected static boolean isActionBarSubTitle(TextView view) {
        if (matchesResourceIdName(view, ACTION_BAR_SUBTITLE)) {
            return true;
        }
        if (parentIsToolbarV7(view)) {
            return TextUtils.equals(((Toolbar) view.getParent()).getSubtitle(), view.getText());
        }
        return false;
    }

    protected static boolean parentIsToolbarV7(View view) {
        return CalligraphyUtils.canCheckForV7Toolbar() && view.getParent() != null && (view.getParent() instanceof Toolbar);
    }

    protected static boolean matchesResourceIdName(View view, String matches) {
        if (view.getId() == -1) {
            return false;
        }
        return view.getResources().getResourceEntryName(view.getId()).equalsIgnoreCase(matches);
    }

    public Calligraphy(CalligraphyConfig calligraphyConfig) {
        this.mCalligraphyConfig = calligraphyConfig;
        this.mAttributeId = new int[]{calligraphyConfig.getAttrId()};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = io.github.inflationx.calligraphy3.R.id.calligraphy_tag_id;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onViewCreated(android.view.View r4, android.content.Context r5, android.util.AttributeSet r6) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x0012
            int r0 = io.github.inflationx.calligraphy3.R.id.calligraphy_tag_id
            java.lang.Object r1 = r4.getTag(r0)
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            if (r1 == r2) goto L_0x0012
            r3.onViewCreatedInternal(r4, r5, r6)
            r4.setTag(r0, r2)
        L_0x0012:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.github.inflationx.calligraphy3.Calligraphy.onViewCreated(android.view.View, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    /* access modifiers changed from: package-private */
    public void onViewCreatedInternal(View view, Context context, AttributeSet attrs) {
        if (view instanceof TextView) {
            if (!TypefaceUtils.isLoaded(((TextView) view).getTypeface())) {
                String textViewFont = resolveFontPath(context, attrs);
                if (TextUtils.isEmpty(textViewFont)) {
                    int[] styleForTextView = getStyleForTextView((TextView) view);
                    if (styleForTextView[1] != -1) {
                        textViewFont = CalligraphyUtils.pullFontPathFromTheme(context, styleForTextView[0], styleForTextView[1], this.mAttributeId);
                    } else {
                        textViewFont = CalligraphyUtils.pullFontPathFromTheme(context, styleForTextView[0], this.mAttributeId);
                    }
                }
                CalligraphyUtils.applyFontToTextView(context, (TextView) view, this.mCalligraphyConfig, applyFontMapper(textViewFont), matchesResourceIdName(view, ACTION_BAR_TITLE) || matchesResourceIdName(view, ACTION_BAR_SUBTITLE));
            } else {
                return;
            }
        }
        if (CalligraphyUtils.canCheckForV7Toolbar() && (view instanceof Toolbar)) {
            Toolbar toolbar = (Toolbar) view;
            toolbar.getViewTreeObserver().addOnGlobalLayoutListener(new ToolbarLayoutListener(context, toolbar));
        }
        if (view instanceof HasTypeface) {
            Typeface typeface = getDefaultTypeface(context, applyFontMapper(resolveFontPath(context, attrs)));
            if (typeface != null) {
                ((HasTypeface) view).setTypeface(typeface);
            }
        } else if (this.mCalligraphyConfig.isCustomViewTypefaceSupport() && this.mCalligraphyConfig.isCustomViewHasTypeface(view)) {
            Method setTypeface = ReflectionUtils.getMethod(view.getClass(), "setTypeface");
            Typeface typeface2 = getDefaultTypeface(context, applyFontMapper(resolveFontPath(context, attrs)));
            if (setTypeface != null && typeface2 != null) {
                ReflectionUtils.invokeMethod(view, setTypeface, typeface2);
            }
        }
    }

    private Typeface getDefaultTypeface(Context context, String fontPath) {
        if (TextUtils.isEmpty(fontPath)) {
            fontPath = this.mCalligraphyConfig.getFontPath();
        }
        if (!TextUtils.isEmpty(fontPath)) {
            return TypefaceUtils.load(context.getAssets(), fontPath);
        }
        return null;
    }

    private String resolveFontPath(Context context, AttributeSet attrs) {
        String textViewFont = CalligraphyUtils.pullFontPathFromView(context, attrs, this.mAttributeId);
        if (TextUtils.isEmpty(textViewFont)) {
            textViewFont = CalligraphyUtils.pullFontPathFromStyle(context, attrs, this.mAttributeId);
        }
        if (TextUtils.isEmpty(textViewFont)) {
            return CalligraphyUtils.pullFontPathFromTextAppearance(context, attrs, this.mAttributeId);
        }
        return textViewFont;
    }

    private String applyFontMapper(String textViewFont) {
        FontMapper fontMapper = this.mCalligraphyConfig.getFontMapper();
        return fontMapper != null ? fontMapper.map(textViewFont) : textViewFont;
    }

    private static class ToolbarLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        static String BLANK = " ";
        private final WeakReference<Calligraphy> mCalligraphyFactory;
        private final WeakReference<Context> mContextRef;
        private final WeakReference<Toolbar> mToolbarReference;
        private final CharSequence originalSubTitle;

        private ToolbarLayoutListener(Calligraphy calligraphy, Context context, Toolbar toolbar) {
            this.mCalligraphyFactory = new WeakReference<>(calligraphy);
            this.mContextRef = new WeakReference<>(context);
            this.mToolbarReference = new WeakReference<>(toolbar);
            this.originalSubTitle = toolbar.getSubtitle();
            toolbar.setSubtitle((CharSequence) BLANK);
        }

        public void onGlobalLayout() {
            Toolbar toolbar = (Toolbar) this.mToolbarReference.get();
            Context context = (Context) this.mContextRef.get();
            Calligraphy factory = (Calligraphy) this.mCalligraphyFactory.get();
            if (toolbar != null) {
                if (factory == null || context == null) {
                    removeSelf(toolbar);
                    return;
                }
                int childCount = toolbar.getChildCount();
                if (childCount != 0) {
                    for (int i = 0; i < childCount; i++) {
                        factory.onViewCreated(toolbar.getChildAt(i), context, (AttributeSet) null);
                    }
                }
                removeSelf(toolbar);
                toolbar.setSubtitle(this.originalSubTitle);
            }
        }

        private void removeSelf(Toolbar toolbar) {
            if (Build.VERSION.SDK_INT < 16) {
                toolbar.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            } else {
                toolbar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }
}
