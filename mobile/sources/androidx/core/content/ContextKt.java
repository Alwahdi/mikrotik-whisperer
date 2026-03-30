package androidx.core.content;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;

public final class ContextKt {
    public static final /* synthetic */ <T> T getSystemService(Context $this$getSystemService) {
        lu.f($this$getSystemService, "<this>");
        lu.j(4, "T");
        return ContextCompat.getSystemService($this$getSystemService, Object.class);
    }

    public static /* synthetic */ void withStyledAttributes$default(Context $this$withStyledAttributes_u24default, AttributeSet set, int[] attrs, int defStyleAttr, int defStyleRes, vn block, int i, Object obj) {
        if ((i & 1) != 0) {
            set = null;
        }
        if ((i & 4) != 0) {
            defStyleAttr = 0;
        }
        if ((i & 8) != 0) {
            defStyleRes = 0;
        }
        lu.f($this$withStyledAttributes_u24default, "<this>");
        lu.f(attrs, "attrs");
        lu.f(block, "block");
        TypedArray obtainStyledAttributes = $this$withStyledAttributes_u24default.obtainStyledAttributes(set, attrs, defStyleAttr, defStyleRes);
        lu.e(obtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        block.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static final void withStyledAttributes(Context $this$withStyledAttributes, AttributeSet set, int[] attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes, vn<? super TypedArray, jt0> block) {
        lu.f($this$withStyledAttributes, "<this>");
        lu.f(attrs, "attrs");
        lu.f(block, "block");
        TypedArray obtainStyledAttributes = $this$withStyledAttributes.obtainStyledAttributes(set, attrs, defStyleAttr, defStyleRes);
        lu.e(obtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        block.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static final void withStyledAttributes(Context $this$withStyledAttributes, @StyleRes int resourceId, int[] attrs, vn<? super TypedArray, jt0> block) {
        lu.f($this$withStyledAttributes, "<this>");
        lu.f(attrs, "attrs");
        lu.f(block, "block");
        TypedArray obtainStyledAttributes = $this$withStyledAttributes.obtainStyledAttributes(resourceId, attrs);
        lu.e(obtainStyledAttributes, "obtainStyledAttributes(resourceId, attrs)");
        block.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}
