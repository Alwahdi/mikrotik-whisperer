package com.google.android.material.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import android.widget.ImageButton;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CheckableImageButton extends AppCompatImageButton implements Checkable {
    private static final int[] a = {16842912};

    /* renamed from: a  reason: collision with other field name */
    private boolean f1831a;
    private boolean b;
    private boolean c;

    public CheckableImageButton(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.b = true;
        this.c = true;
        ViewCompat.setAccessibilityDelegate(this, new a());
    }

    class a extends AccessibilityDelegateCompat {
        a() {
        }

        public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
            super.onInitializeAccessibilityEvent(host, event);
            event.setChecked(CheckableImageButton.this.isChecked());
        }

        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
            super.onInitializeAccessibilityNodeInfo(host, info);
            info.setCheckable(CheckableImageButton.this.a());
            info.setChecked(CheckableImageButton.this.isChecked());
        }
    }

    public void setChecked(boolean checked) {
        if (this.b && this.f1831a != checked) {
            this.f1831a = checked;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    public boolean isChecked() {
        return this.f1831a;
    }

    public void toggle() {
        setChecked(!this.f1831a);
    }

    public void setPressed(boolean pressed) {
        if (this.c) {
            super.setPressed(pressed);
        }
    }

    public int[] onCreateDrawableState(int extraSpace) {
        if (!this.f1831a) {
            return super.onCreateDrawableState(extraSpace);
        }
        int[] iArr = a;
        return ImageButton.mergeDrawableStates(super.onCreateDrawableState(iArr.length + extraSpace), iArr);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        b savedState = new b(super.onSaveInstanceState());
        savedState.a = this.f1831a;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof b)) {
            super.onRestoreInstanceState(state);
            return;
        }
        b savedState = (b) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.a);
    }

    public void setCheckable(boolean checkable) {
        if (this.b != checkable) {
            this.b = checkable;
            sendAccessibilityEvent(0);
        }
    }

    public boolean a() {
        return this.b;
    }

    public void setPressable(boolean pressable) {
        this.c = pressable;
    }

    static class b extends AbsSavedState {
        public static final Parcelable.Creator<b> CREATOR = new a();
        boolean a;

        public b(Parcelable superState) {
            super(superState);
        }

        public b(Parcel source, ClassLoader loader) {
            super(source, loader);
            f(source);
        }

        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.a ? 1 : 0);
        }

        private void f(Parcel in) {
            boolean z = true;
            if (in.readInt() != 1) {
                z = false;
            }
            this.a = z;
        }

        class a implements Parcelable.ClassLoaderCreator<b> {
            a() {
            }

            /* renamed from: b */
            public b createFromParcel(Parcel in, ClassLoader loader) {
                return new b(in, loader);
            }

            /* renamed from: a */
            public b createFromParcel(Parcel in) {
                return new b(in, (ClassLoader) null);
            }

            /* renamed from: c */
            public b[] newArray(int size) {
                return new b[size];
            }
        }
    }
}
