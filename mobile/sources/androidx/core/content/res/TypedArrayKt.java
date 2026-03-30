package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;

public final class TypedArrayKt {
    private static final void checkAttribute(TypedArray $this$checkAttribute, @StyleableRes int index) {
        if (!$this$checkAttribute.hasValue(index)) {
            throw new IllegalArgumentException("Attribute not defined in set.");
        }
    }

    public static final boolean getBooleanOrThrow(TypedArray $this$getBooleanOrThrow, @StyleableRes int index) {
        lu.f($this$getBooleanOrThrow, "<this>");
        checkAttribute($this$getBooleanOrThrow, index);
        return $this$getBooleanOrThrow.getBoolean(index, false);
    }

    @ColorInt
    public static final int getColorOrThrow(TypedArray $this$getColorOrThrow, @StyleableRes int index) {
        lu.f($this$getColorOrThrow, "<this>");
        checkAttribute($this$getColorOrThrow, index);
        return $this$getColorOrThrow.getColor(index, 0);
    }

    public static final ColorStateList getColorStateListOrThrow(TypedArray $this$getColorStateListOrThrow, @StyleableRes int index) {
        lu.f($this$getColorStateListOrThrow, "<this>");
        checkAttribute($this$getColorStateListOrThrow, index);
        ColorStateList colorStateList = $this$getColorStateListOrThrow.getColorStateList(index);
        if (colorStateList != null) {
            return colorStateList;
        }
        throw new IllegalStateException("Attribute value was not a color or color state list.".toString());
    }

    public static final float getDimensionOrThrow(TypedArray $this$getDimensionOrThrow, @StyleableRes int index) {
        lu.f($this$getDimensionOrThrow, "<this>");
        checkAttribute($this$getDimensionOrThrow, index);
        return $this$getDimensionOrThrow.getDimension(index, 0.0f);
    }

    @Dimension
    public static final int getDimensionPixelOffsetOrThrow(TypedArray $this$getDimensionPixelOffsetOrThrow, @StyleableRes int index) {
        lu.f($this$getDimensionPixelOffsetOrThrow, "<this>");
        checkAttribute($this$getDimensionPixelOffsetOrThrow, index);
        return $this$getDimensionPixelOffsetOrThrow.getDimensionPixelOffset(index, 0);
    }

    @Dimension
    public static final int getDimensionPixelSizeOrThrow(TypedArray $this$getDimensionPixelSizeOrThrow, @StyleableRes int index) {
        lu.f($this$getDimensionPixelSizeOrThrow, "<this>");
        checkAttribute($this$getDimensionPixelSizeOrThrow, index);
        return $this$getDimensionPixelSizeOrThrow.getDimensionPixelSize(index, 0);
    }

    public static final Drawable getDrawableOrThrow(TypedArray $this$getDrawableOrThrow, @StyleableRes int index) {
        lu.f($this$getDrawableOrThrow, "<this>");
        checkAttribute($this$getDrawableOrThrow, index);
        Drawable drawable = $this$getDrawableOrThrow.getDrawable(index);
        lu.c(drawable);
        return drawable;
    }

    public static final float getFloatOrThrow(TypedArray $this$getFloatOrThrow, @StyleableRes int index) {
        lu.f($this$getFloatOrThrow, "<this>");
        checkAttribute($this$getFloatOrThrow, index);
        return $this$getFloatOrThrow.getFloat(index, 0.0f);
    }

    @RequiresApi(26)
    public static final Typeface getFontOrThrow(TypedArray $this$getFontOrThrow, @StyleableRes int index) {
        lu.f($this$getFontOrThrow, "<this>");
        checkAttribute($this$getFontOrThrow, index);
        return TypedArrayApi26ImplKt.getFont($this$getFontOrThrow, index);
    }

    public static final int getIntOrThrow(TypedArray $this$getIntOrThrow, @StyleableRes int index) {
        lu.f($this$getIntOrThrow, "<this>");
        checkAttribute($this$getIntOrThrow, index);
        return $this$getIntOrThrow.getInt(index, 0);
    }

    public static final int getIntegerOrThrow(TypedArray $this$getIntegerOrThrow, @StyleableRes int index) {
        lu.f($this$getIntegerOrThrow, "<this>");
        checkAttribute($this$getIntegerOrThrow, index);
        return $this$getIntegerOrThrow.getInteger(index, 0);
    }

    @AnyRes
    public static final int getResourceIdOrThrow(TypedArray $this$getResourceIdOrThrow, @StyleableRes int index) {
        lu.f($this$getResourceIdOrThrow, "<this>");
        checkAttribute($this$getResourceIdOrThrow, index);
        return $this$getResourceIdOrThrow.getResourceId(index, 0);
    }

    public static final String getStringOrThrow(TypedArray $this$getStringOrThrow, @StyleableRes int index) {
        lu.f($this$getStringOrThrow, "<this>");
        checkAttribute($this$getStringOrThrow, index);
        String string = $this$getStringOrThrow.getString(index);
        if (string != null) {
            return string;
        }
        throw new IllegalStateException("Attribute value could not be coerced to String.".toString());
    }

    public static final CharSequence getTextOrThrow(TypedArray $this$getTextOrThrow, @StyleableRes int index) {
        lu.f($this$getTextOrThrow, "<this>");
        checkAttribute($this$getTextOrThrow, index);
        CharSequence text = $this$getTextOrThrow.getText(index);
        if (text != null) {
            return text;
        }
        throw new IllegalStateException("Attribute value could not be coerced to CharSequence.".toString());
    }

    public static final CharSequence[] getTextArrayOrThrow(TypedArray $this$getTextArrayOrThrow, @StyleableRes int index) {
        lu.f($this$getTextArrayOrThrow, "<this>");
        checkAttribute($this$getTextArrayOrThrow, index);
        CharSequence[] textArray = $this$getTextArrayOrThrow.getTextArray(index);
        lu.e(textArray, "getTextArray(index)");
        return textArray;
    }

    public static final <R> R use(TypedArray $this$use, vn<? super TypedArray, ? extends R> block) {
        lu.f($this$use, "<this>");
        lu.f(block, "block");
        R invoke = block.invoke($this$use);
        R r = invoke;
        $this$use.recycle();
        return invoke;
    }
}
