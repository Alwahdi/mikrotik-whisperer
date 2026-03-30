package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TouchObserverFrameLayout extends FrameLayout {
    private View.OnTouchListener a;

    public TouchObserverFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        View.OnTouchListener onTouchListener = this.a;
        if (onTouchListener != null) {
            onTouchListener.onTouch(this, ev);
        }
        return super.onInterceptTouchEvent(ev);
    }

    public void setOnTouchListener(@Nullable View.OnTouchListener onTouchListener) {
        this.a = onTouchListener;
    }
}
