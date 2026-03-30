package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;

class TimePickerView extends ConstraintLayout {
    private final View.OnClickListener a;

    /* renamed from: a  reason: collision with other field name */
    private final MaterialButtonToggleGroup f2119a;

    /* renamed from: a  reason: collision with other field name */
    private final Chip f2120a;

    /* renamed from: a  reason: collision with other field name */
    private final ClockFaceView f2121a;

    /* renamed from: a  reason: collision with other field name */
    private final ClockHandView f2122a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public d f2123a;

    /* renamed from: a  reason: collision with other field name */
    private e f2124a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public f f2125a;
    private final Chip b;

    interface d {
        void a();
    }

    interface e {
        void a(int i);
    }

    interface f {
        void a(int i);
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View v) {
            if (TimePickerView.this.f2125a != null) {
                TimePickerView.this.f2125a.a(((Integer) v.getTag(ic0.selection_type)).intValue());
            }
        }
    }

    public TimePickerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TimePickerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.a = new a();
        LayoutInflater.from(context).inflate(nc0.material_timepicker, this);
        this.f2121a = (ClockFaceView) findViewById(ic0.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(ic0.material_clock_period_toggle);
        this.f2119a = materialButtonToggleGroup;
        materialButtonToggleGroup.b(new f(this));
        this.f2120a = (Chip) findViewById(ic0.material_minute_tv);
        this.b = (Chip) findViewById(ic0.material_hour_tv);
        this.f2122a = (ClockHandView) findViewById(ic0.material_clock_hand);
        g();
        f();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
        e eVar;
        if (isChecked && (eVar = this.f2124a) != null) {
            eVar.a(checkedId == ic0.material_clock_period_pm_button ? 1 : 0);
        }
    }

    private void g() {
        View.OnTouchListener onTouchListener = new c(new GestureDetector(getContext(), new b()));
        this.f2120a.setOnTouchListener(onTouchListener);
        this.b.setOnTouchListener(onTouchListener);
    }

    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        public boolean onDoubleTap(MotionEvent e) {
            d listener = TimePickerView.this.f2123a;
            if (listener == null) {
                return false;
            }
            listener.a();
            return true;
        }
    }

    class c implements View.OnTouchListener {
        final /* synthetic */ GestureDetector a;

        c(GestureDetector gestureDetector) {
            this.a = gestureDetector;
        }

        public boolean onTouch(View v, MotionEvent event) {
            if (((Checkable) v).isChecked()) {
                return this.a.onTouchEvent(event);
            }
            return false;
        }
    }

    private void f() {
        Chip chip = this.f2120a;
        int i = ic0.selection_type;
        chip.setTag(i, 12);
        this.b.setTag(i, 10);
        this.f2120a.setOnClickListener(this.a);
        this.b.setOnClickListener(this.a);
        this.f2120a.setAccessibilityClassName("android.view.View");
        this.b.setAccessibilityClassName("android.view.View");
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (changedView == this && visibility == 0) {
            this.b.sendAccessibilityEvent(8);
        }
    }
}
