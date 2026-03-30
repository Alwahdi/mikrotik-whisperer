package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenuItemView extends mn implements MenuView.ItemView {
    private static final int[] a = {16842912};

    /* renamed from: a  reason: collision with other field name */
    private ColorStateList f1833a;

    /* renamed from: a  reason: collision with other field name */
    private final CheckedTextView f1834a;

    /* renamed from: a  reason: collision with other field name */
    private FrameLayout f1835a;

    /* renamed from: a  reason: collision with other field name */
    private MenuItemImpl f1836a;

    /* renamed from: a  reason: collision with other field name */
    private final AccessibilityDelegateCompat f1837a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private Drawable f1838b;
    private boolean c;
    boolean d;
    boolean e;
    private boolean f;

    class a extends AccessibilityDelegateCompat {
        a() {
        }

        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
            super.onInitializeAccessibilityNodeInfo(host, info);
            info.setCheckable(NavigationMenuItemView.this.d);
        }
    }

    public NavigationMenuItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.e = true;
        a aVar = new a();
        this.f1837a = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(nc0.design_navigation_menu_item, this, true);
        setIconSize(context.getResources().getDimensionPixelSize(cc0.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(ic0.design_menu_item_text);
        this.f1834a = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        ViewCompat.setAccessibilityDelegate(checkedTextView, aVar);
    }

    public void initialize(MenuItemImpl itemData, int menuType) {
        this.f1836a = itemData;
        if (itemData.getItemId() > 0) {
            setId(itemData.getItemId());
        }
        setVisibility(itemData.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            ViewCompat.setBackground(this, b());
        }
        setCheckable(itemData.isCheckable());
        setChecked(itemData.isChecked());
        setEnabled(itemData.isEnabled());
        setTitle(itemData.getTitle());
        setIcon(itemData.getIcon());
        setActionView(itemData.getActionView());
        setContentDescription(itemData.getContentDescription());
        TooltipCompat.setTooltipText(this, itemData.getTooltipText());
        a();
    }

    private boolean c() {
        return this.f1836a.getTitle() == null && this.f1836a.getIcon() == null && this.f1836a.getActionView() != null;
    }

    private void a() {
        if (c()) {
            this.f1834a.setVisibility(8);
            FrameLayout frameLayout = this.f1835a;
            if (frameLayout != null) {
                LinearLayoutCompat.LayoutParams params = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                params.width = -1;
                this.f1835a.setLayoutParams(params);
                return;
            }
            return;
        }
        this.f1834a.setVisibility(0);
        FrameLayout frameLayout2 = this.f1835a;
        if (frameLayout2 != null) {
            LinearLayoutCompat.LayoutParams params2 = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
            params2.width = -2;
            this.f1835a.setLayoutParams(params2);
        }
    }

    private void setActionView(@Nullable View actionView) {
        if (actionView != null) {
            if (this.f1835a == null) {
                this.f1835a = (FrameLayout) ((ViewStub) findViewById(ic0.design_menu_item_action_area_stub)).inflate();
            }
            this.f1835a.removeAllViews();
            this.f1835a.addView(actionView);
        }
    }

    private StateListDrawable b() {
        TypedValue value = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(R.attr.colorControlHighlight, value, true)) {
            return null;
        }
        StateListDrawable drawable = new StateListDrawable();
        drawable.addState(a, new ColorDrawable(value.data));
        drawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return drawable;
    }

    public MenuItemImpl getItemData() {
        return this.f1836a;
    }

    public void setTitle(CharSequence title) {
        this.f1834a.setText(title);
    }

    public void setCheckable(boolean checkable) {
        refreshDrawableState();
        if (this.d != checkable) {
            this.d = checkable;
            this.f1837a.sendAccessibilityEvent(this.f1834a, 2048);
        }
    }

    public void setChecked(boolean checked) {
        refreshDrawableState();
        this.f1834a.setChecked(checked);
        CheckedTextView checkedTextView = this.f1834a;
        checkedTextView.setTypeface(checkedTextView.getTypeface(), (!checked || !this.e) ? 0 : 1);
    }

    public void setShortcut(boolean showShortcut, char shortcutKey) {
    }

    public void setIcon(@Nullable Drawable icon) {
        if (icon != null) {
            if (this.f) {
                Drawable.ConstantState state = icon.getConstantState();
                icon = DrawableCompat.wrap(state == null ? icon : state.newDrawable()).mutate();
                DrawableCompat.setTintList(icon, this.f1833a);
            }
            int i = this.b;
            icon.setBounds(0, 0, i, i);
        } else if (this.c) {
            if (this.f1838b == null) {
                Drawable drawable = ResourcesCompat.getDrawable(getResources(), gc0.navigation_empty_icon, getContext().getTheme());
                this.f1838b = drawable;
                if (drawable != null) {
                    int i2 = this.b;
                    drawable.setBounds(0, 0, i2, i2);
                }
            }
            icon = this.f1838b;
        }
        TextViewCompat.setCompoundDrawablesRelative(this.f1834a, icon, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void setIconSize(@Dimension int iconSize) {
        this.b = iconSize;
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public boolean showsIcon() {
        return true;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int extraSpace) {
        int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        MenuItemImpl menuItemImpl = this.f1836a;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.f1836a.isChecked()) {
            ViewGroup.mergeDrawableStates(drawableState, a);
        }
        return drawableState;
    }

    /* access modifiers changed from: package-private */
    public void setIconTintList(ColorStateList tintList) {
        this.f1833a = tintList;
        this.f = tintList != null;
        MenuItemImpl menuItemImpl = this.f1836a;
        if (menuItemImpl != null) {
            setIcon(menuItemImpl.getIcon());
        }
    }

    public void setTextAppearance(int textAppearance) {
        TextViewCompat.setTextAppearance(this.f1834a, textAppearance);
    }

    public void setTextColor(ColorStateList colors) {
        this.f1834a.setTextColor(colors);
    }

    public void setNeedsEmptyIcon(boolean needsEmptyIcon) {
        this.c = needsEmptyIcon;
    }

    public void setHorizontalPadding(int padding) {
        setPadding(padding, getPaddingTop(), padding, getPaddingBottom());
    }

    public void setIconPadding(int padding) {
        this.f1834a.setCompoundDrawablePadding(padding);
    }

    public void setMaxLines(int maxLines) {
        this.f1834a.setMaxLines(maxLines);
    }
}
