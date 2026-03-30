package com.blogspot.yemeninfo4it.mumsmobile_app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class MyScrollView extends ScrollView {
    private boolean a = true;

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (a()) {
            return super.onInterceptTouchEvent(ev);
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent ev) {
        if (a()) {
            return super.onTouchEvent(ev);
        }
        return false;
    }

    private boolean a() {
        return this.a;
    }

    public void setScrolling(boolean enableScrolling) {
        this.a = enableScrolling;
    }
}
