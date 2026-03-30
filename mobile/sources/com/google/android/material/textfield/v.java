package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.ArrayRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;

public class v extends AppCompatAutoCompleteTextView {
    private final float a;

    /* renamed from: a  reason: collision with other field name */
    private final int f2072a;

    /* renamed from: a  reason: collision with other field name */
    private ColorStateList f2073a;

    /* renamed from: a  reason: collision with other field name */
    private final Rect f2074a;

    /* renamed from: a  reason: collision with other field name */
    private final AccessibilityManager f2075a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final ListPopupWindow f2076a;
    /* access modifiers changed from: private */
    public int b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public ColorStateList f2077b;

    public v(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, yb0.b);
    }

    public v(Context context, AttributeSet attributeSet, int defStyleAttr) {
        super(t00.c(context, attributeSet, defStyleAttr, 0), attributeSet, defStyleAttr);
        this.f2074a = new Rect();
        Context context2 = getContext();
        TypedArray attributes = vq0.i(context2, attributeSet, xc0.f5721v0, defStyleAttr, uc0.f, new int[0]);
        int i = xc0.a2;
        if (attributes.hasValue(i) && attributes.getInt(i, 0) == 0) {
            setKeyListener((KeyListener) null);
        }
        this.f2072a = attributes.getResourceId(xc0.d2, nc0.mtrl_auto_complete_simple_item);
        this.a = (float) attributes.getDimensionPixelOffset(xc0.b2, cc0.mtrl_exposed_dropdown_menu_popup_elevation);
        int i2 = xc0.c2;
        if (attributes.hasValue(i2)) {
            this.f2073a = ColorStateList.valueOf(attributes.getColor(i2, 0));
        }
        this.b = attributes.getColor(xc0.e2, 0);
        this.f2077b = o00.a(context2, attributes, xc0.f2);
        this.f2075a = (AccessibilityManager) context2.getSystemService("accessibility");
        ListPopupWindow listPopupWindow = new ListPopupWindow(context2);
        this.f2076a = listPopupWindow;
        listPopupWindow.setModal(true);
        listPopupWindow.setAnchorView(this);
        listPopupWindow.setInputMethodMode(2);
        listPopupWindow.setAdapter(getAdapter());
        listPopupWindow.setOnItemClickListener(new a());
        int i3 = xc0.g2;
        if (attributes.hasValue(i3)) {
            setSimpleItems(attributes.getResourceId(i3, 0));
        }
        attributes.recycle();
    }

    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        public void onItemClick(AdapterView<?> adapterView, View selectedView, int position, long id) {
            v vVar = v.this;
            v.this.i(position < 0 ? vVar.f2076a.getSelectedItem() : vVar.getAdapter().getItem(position));
            AdapterView.OnItemClickListener userOnItemClickListener = v.this.getOnItemClickListener();
            if (userOnItemClickListener != null) {
                if (selectedView == null || position < 0) {
                    selectedView = v.this.f2076a.getSelectedView();
                    position = v.this.f2076a.getSelectedItemPosition();
                    id = v.this.f2076a.getSelectedItemId();
                }
                userOnItemClickListener.onItemClick(v.this.f2076a.getListView(), selectedView, position, id);
            }
            v.this.f2076a.dismiss();
        }
    }

    public void showDropDown() {
        if (f()) {
            this.f2076a.show();
        } else {
            super.showDropDown();
        }
    }

    public void dismissDropDown() {
        if (f()) {
            this.f2076a.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    public void onWindowFocusChanged(boolean hasWindowFocus) {
        if (!f()) {
            super.onWindowFocusChanged(hasWindowFocus);
        }
    }

    private boolean f() {
        AccessibilityManager accessibilityManager = this.f2075a;
        return accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled();
    }

    public <T extends ListAdapter & Filterable> void setAdapter(@Nullable T adapter) {
        super.setAdapter(adapter);
        this.f2076a.setAdapter(getAdapter());
    }

    public void setRawInputType(int type) {
        super.setRawInputType(type);
        h();
    }

    public void setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener listener) {
        super.setOnItemSelectedListener(listener);
        this.f2076a.setOnItemSelectedListener(getOnItemSelectedListener());
    }

    public void setSimpleItems(@ArrayRes int stringArrayResId) {
        setSimpleItems(getResources().getStringArray(stringArrayResId));
    }

    public void setSimpleItems(@NonNull String[] stringArray) {
        setAdapter(new b(getContext(), this.f2072a, stringArray));
    }

    public void setDropDownBackgroundTint(@ColorInt int dropDownBackgroundColor) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(dropDownBackgroundColor));
    }

    public void setDropDownBackgroundTintList(@Nullable ColorStateList dropDownBackgroundTint) {
        this.f2073a = dropDownBackgroundTint;
        Drawable dropDownBackground = getDropDownBackground();
        if (dropDownBackground instanceof p00) {
            ((p00) dropDownBackground).V(this.f2073a);
        }
    }

    @Nullable
    public ColorStateList getDropDownBackgroundTintList() {
        return this.f2073a;
    }

    public void setSimpleItemSelectedColor(int simpleItemSelectedColor) {
        this.b = simpleItemSelectedColor;
        if (getAdapter() instanceof b) {
            ((b) getAdapter()).f();
        }
    }

    public int getSimpleItemSelectedColor() {
        return this.b;
    }

    public void setSimpleItemSelectedRippleColor(@Nullable ColorStateList simpleItemSelectedRippleColor) {
        this.f2077b = simpleItemSelectedRippleColor;
        if (getAdapter() instanceof b) {
            ((b) getAdapter()).f();
        }
    }

    @Nullable
    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.f2077b;
    }

    public void setDropDownBackgroundDrawable(Drawable d) {
        super.setDropDownBackgroundDrawable(d);
        ListPopupWindow listPopupWindow = this.f2076a;
        if (listPopupWindow != null) {
            listPopupWindow.setBackgroundDrawable(d);
        }
    }

    public float getPopupElevation() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout layout = e();
        if (layout != null && layout.R() && super.getHint() == null && uz.b()) {
            setHint("");
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2076a.dismiss();
    }

    @Nullable
    public CharSequence getHint() {
        TextInputLayout textInputLayout = e();
        if (textInputLayout == null || !textInputLayout.R()) {
            return super.getHint();
        }
        return textInputLayout.getHint();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (View.MeasureSpec.getMode(widthMeasureSpec) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), g()), View.MeasureSpec.getSize(widthMeasureSpec)), getMeasuredHeight());
        }
    }

    private int g() {
        ListAdapter adapter = getAdapter();
        TextInputLayout textInputLayout = e();
        if (adapter == null || textInputLayout == null) {
            return 0;
        }
        int width = 0;
        View itemView = null;
        int itemType = 0;
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int end = Math.min(adapter.getCount(), Math.max(0, this.f2076a.getSelectedItemPosition()) + 15);
        for (int i = Math.max(0, end - 15); i < end; i++) {
            int positionType = adapter.getItemViewType(i);
            if (positionType != itemType) {
                itemType = positionType;
                itemView = null;
            }
            itemView = adapter.getView(i, itemView, textInputLayout);
            if (itemView.getLayoutParams() == null) {
                itemView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            itemView.measure(widthMeasureSpec, heightMeasureSpec);
            width = Math.max(width, itemView.getMeasuredWidth());
        }
        Drawable background = this.f2076a.getBackground();
        if (background != null) {
            background.getPadding(this.f2074a);
            Rect rect = this.f2074a;
            width += rect.left + rect.right;
        }
        return width + textInputLayout.getEndIconView().getMeasuredWidth();
    }

    private void h() {
        TextInputLayout textInputLayout = e();
        if (textInputLayout != null) {
            textInputLayout.r0();
        }
    }

    private TextInputLayout e() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public <T extends ListAdapter & Filterable> void i(Object selectedItem) {
        if (Build.VERSION.SDK_INT >= 17) {
            setText(convertSelectionToString(selectedItem), false);
            return;
        }
        ListAdapter adapter = getAdapter();
        setAdapter((ListAdapter) null);
        setText(convertSelectionToString(selectedItem));
        setAdapter(adapter);
    }

    private class b<T> extends ArrayAdapter<String> {
        private ColorStateList a;
        private ColorStateList b;

        b(Context context, int resource, String[] objects) {
            super(context, resource, objects);
            f();
        }

        /* access modifiers changed from: package-private */
        public void f() {
            this.b = e();
            this.a = a();
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View view = super.getView(position, convertView, parent);
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                ViewCompat.setBackground(textView, v.this.getText().toString().contentEquals(textView.getText()) ? b() : null);
            }
            return view;
        }

        private Drawable b() {
            if (!c() || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            Drawable colorDrawable = new ColorDrawable(v.this.b);
            if (this.b == null) {
                return colorDrawable;
            }
            DrawableCompat.setTintList(colorDrawable, this.a);
            return new RippleDrawable(this.b, colorDrawable, (Drawable) null);
        }

        private ColorStateList a() {
            if (!c() || !d() || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            int[] stateHovered = {16843623, -16842919};
            int[] stateSelected = {16842913, -16842919};
            return new ColorStateList(new int[][]{stateSelected, stateHovered, new int[0]}, new int[]{k00.j(v.this.b, v.this.f2077b.getColorForState(stateSelected, 0)), k00.j(v.this.b, v.this.f2077b.getColorForState(stateHovered, 0)), v.this.b});
        }

        private ColorStateList e() {
            if (!d()) {
                return null;
            }
            int[] statePressed = {16842919};
            return new ColorStateList(new int[][]{statePressed, new int[0]}, new int[]{v.this.f2077b.getColorForState(statePressed, 0), 0});
        }

        private boolean c() {
            return v.this.b != 0;
        }

        private boolean d() {
            return v.this.f2077b != null;
        }
    }
}
