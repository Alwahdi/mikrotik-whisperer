package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CheckedTextViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY})
class AppCompatCheckedTextViewHelper {
    private ColorStateList mCheckMarkTintList = null;
    private PorterDuff.Mode mCheckMarkTintMode = null;
    private boolean mHasCheckMarkTint = false;
    private boolean mHasCheckMarkTintMode = false;
    private boolean mSkipNextApply;
    @NonNull
    private final CheckedTextView mView;

    AppCompatCheckedTextViewHelper(@NonNull CheckedTextView view) {
        this.mView = view;
    }

    /* access modifiers changed from: package-private */
    public void loadFromAttributes(@Nullable AttributeSet attrs, int defStyleAttr) {
        int resourceId;
        int resourceId2;
        Context context = this.mView.getContext();
        int[] iArr = R.styleable.CheckedTextView;
        TintTypedArray a = TintTypedArray.obtainStyledAttributes(context, attrs, iArr, defStyleAttr, 0);
        CheckedTextView checkedTextView = this.mView;
        ViewCompat.saveAttributeDataForStyleable(checkedTextView, checkedTextView.getContext(), iArr, attrs, a.getWrappedTypeArray(), defStyleAttr, 0);
        boolean checkMarkDrawableLoaded = false;
        try {
            int i = R.styleable.CheckedTextView_checkMarkCompat;
            if (a.hasValue(i) && (resourceId2 = a.getResourceId(i, 0)) != 0) {
                try {
                    CheckedTextView checkedTextView2 = this.mView;
                    checkedTextView2.setCheckMarkDrawable(AppCompatResources.getDrawable(checkedTextView2.getContext(), resourceId2));
                    checkMarkDrawableLoaded = true;
                } catch (Resources.NotFoundException e) {
                }
            }
            if (!checkMarkDrawableLoaded) {
                int i2 = R.styleable.CheckedTextView_android_checkMark;
                if (a.hasValue(i2) && (resourceId = a.getResourceId(i2, 0)) != 0) {
                    CheckedTextView checkedTextView3 = this.mView;
                    checkedTextView3.setCheckMarkDrawable(AppCompatResources.getDrawable(checkedTextView3.getContext(), resourceId));
                }
            }
            int resourceId3 = R.styleable.CheckedTextView_checkMarkTint;
            if (a.hasValue(resourceId3)) {
                CheckedTextViewCompat.setCheckMarkTintList(this.mView, a.getColorStateList(resourceId3));
            }
            int i3 = R.styleable.CheckedTextView_checkMarkTintMode;
            if (a.hasValue(i3)) {
                CheckedTextViewCompat.setCheckMarkTintMode(this.mView, DrawableUtils.parseTintMode(a.getInt(i3, -1), (PorterDuff.Mode) null));
            }
        } finally {
            a.recycle();
        }
    }

    /* access modifiers changed from: package-private */
    public void setSupportCheckMarkTintList(ColorStateList tint) {
        this.mCheckMarkTintList = tint;
        this.mHasCheckMarkTint = true;
        applyCheckMarkTint();
    }

    /* access modifiers changed from: package-private */
    public ColorStateList getSupportCheckMarkTintList() {
        return this.mCheckMarkTintList;
    }

    /* access modifiers changed from: package-private */
    public void setSupportCheckMarkTintMode(@Nullable PorterDuff.Mode tintMode) {
        this.mCheckMarkTintMode = tintMode;
        this.mHasCheckMarkTintMode = true;
        applyCheckMarkTint();
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        return this.mCheckMarkTintMode;
    }

    /* access modifiers changed from: package-private */
    public void onSetCheckMarkDrawable() {
        if (this.mSkipNextApply) {
            this.mSkipNextApply = false;
            return;
        }
        this.mSkipNextApply = true;
        applyCheckMarkTint();
    }

    /* access modifiers changed from: package-private */
    public void applyCheckMarkTint() {
        Drawable checkMarkDrawable = CheckedTextViewCompat.getCheckMarkDrawable(this.mView);
        if (checkMarkDrawable == null) {
            return;
        }
        if (this.mHasCheckMarkTint || this.mHasCheckMarkTintMode) {
            Drawable checkMarkDrawable2 = DrawableCompat.wrap(checkMarkDrawable).mutate();
            if (this.mHasCheckMarkTint) {
                DrawableCompat.setTintList(checkMarkDrawable2, this.mCheckMarkTintList);
            }
            if (this.mHasCheckMarkTintMode) {
                DrawableCompat.setTintMode(checkMarkDrawable2, this.mCheckMarkTintMode);
            }
            if (checkMarkDrawable2.isStateful()) {
                checkMarkDrawable2.setState(this.mView.getDrawableState());
            }
            this.mView.setCheckMarkDrawable(checkMarkDrawable2);
        }
    }
}
