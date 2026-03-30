package com.google.android.material.button;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import androidx.annotation.BoolRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.button.MaterialButton;
import defpackage.il0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class MaterialButtonToggleGroup extends LinearLayout {
    private static final int b = uc0.Widget_MaterialComponents_MaterialButtonToggleGroup;
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final e f1553a;

    /* renamed from: a  reason: collision with other field name */
    private final Comparator<MaterialButton> f1554a;

    /* renamed from: a  reason: collision with other field name */
    private final LinkedHashSet<d> f1555a;

    /* renamed from: a  reason: collision with other field name */
    private final List<c> f1556a;

    /* renamed from: a  reason: collision with other field name */
    private Set<Integer> f1557a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f1558a;

    /* renamed from: a  reason: collision with other field name */
    private Integer[] f1559a;

    /* renamed from: b  reason: collision with other field name */
    private boolean f1560b;
    private boolean c;

    public interface d {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z);
    }

    class a implements Comparator<MaterialButton> {
        a() {
        }

        /* renamed from: a */
        public int compare(MaterialButton v1, MaterialButton v2) {
            int checked = Boolean.valueOf(v1.isChecked()).compareTo(Boolean.valueOf(v2.isChecked()));
            if (checked != 0) {
                return checked;
            }
            int stateful = Boolean.valueOf(v1.isPressed()).compareTo(Boolean.valueOf(v2.isPressed()));
            if (stateful != 0) {
                return stateful;
            }
            return Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(v1)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(v2)));
        }
    }

    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, yb0.materialButtonToggleGroupStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialButtonToggleGroup(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = b
            android.content.Context r0 = defpackage.t00.c(r8, r9, r10, r4)
            r7.<init>(r0, r9, r10)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r7.f1556a = r0
            com.google.android.material.button.MaterialButtonToggleGroup$e r0 = new com.google.android.material.button.MaterialButtonToggleGroup$e
            r1 = 0
            r0.<init>(r7, r1)
            r7.f1553a = r0
            java.util.LinkedHashSet r0 = new java.util.LinkedHashSet
            r0.<init>()
            r7.f1555a = r0
            com.google.android.material.button.MaterialButtonToggleGroup$a r0 = new com.google.android.material.button.MaterialButtonToggleGroup$a
            r0.<init>()
            r7.f1554a = r0
            r6 = 0
            r7.f1558a = r6
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r7.f1557a = r0
            android.content.Context r8 = r7.getContext()
            int[] r2 = defpackage.xc0.f5727x0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r0 = defpackage.vq0.i(r0, r1, r2, r3, r4, r5)
            int r1 = defpackage.xc0.E2
            boolean r1 = r0.getBoolean(r1, r6)
            r7.setSingleSelection((boolean) r1)
            int r1 = defpackage.xc0.C2
            r2 = -1
            int r1 = r0.getResourceId(r1, r2)
            r7.a = r1
            int r1 = defpackage.xc0.D2
            boolean r1 = r0.getBoolean(r1, r6)
            r7.c = r1
            r1 = 1
            r7.setChildrenDrawingOrderEnabled(r1)
            int r2 = defpackage.xc0.B2
            boolean r2 = r0.getBoolean(r2, r1)
            r7.setEnabled(r2)
            r0.recycle()
            androidx.core.view.ViewCompat.setImportantForAccessibility(r7, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButtonToggleGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.a;
        if (i != -1) {
            q(Collections.singleton(Integer.valueOf(i)));
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        r();
        super.dispatchDraw(canvas);
    }

    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (!(child instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(child, index, params);
        MaterialButton buttonChild = (MaterialButton) child;
        setGeneratedIdIfNeeded(buttonChild);
        setupButtonChild(buttonChild);
        e(buttonChild.getId(), buttonChild.isChecked());
        il0 shapeAppearanceModel = buttonChild.getShapeAppearanceModel();
        this.f1556a.add(new c(shapeAppearanceModel.r(), shapeAppearanceModel.j(), shapeAppearanceModel.t(), shapeAppearanceModel.l()));
        buttonChild.setEnabled(isEnabled());
        ViewCompat.setAccessibilityDelegate(buttonChild, new b());
    }

    class b extends AccessibilityDelegateCompat {
        b() {
        }

        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
            super.onInitializeAccessibilityNodeInfo(host, info);
            info.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, MaterialButtonToggleGroup.this.i(host), 1, false, ((MaterialButton) host).isChecked()));
        }
    }

    public void onViewRemoved(View child) {
        super.onViewRemoved(child);
        if (child instanceof MaterialButton) {
            ((MaterialButton) child).setOnPressedChangeListenerInternal((MaterialButton.b) null);
        }
        int indexOfChild = indexOfChild(child);
        if (indexOfChild >= 0) {
            this.f1556a.remove(indexOfChild);
        }
        s();
        c();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        s();
        c();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        int i;
        super.onInitializeAccessibilityNodeInfo(info);
        AccessibilityNodeInfoCompat infoCompat = AccessibilityNodeInfoCompat.wrap(info);
        int visibleButtonCount = getVisibleButtonCount();
        if (l()) {
            i = 1;
        } else {
            i = 2;
        }
        infoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, visibleButtonCount, false, i));
    }

    public void f() {
        q(new HashSet());
    }

    @IdRes
    public int getCheckedButtonId() {
        if (!this.f1560b || this.f1557a.isEmpty()) {
            return -1;
        }
        return this.f1557a.iterator().next().intValue();
    }

    @NonNull
    public List<Integer> getCheckedButtonIds() {
        List<Integer> orderedCheckedIds = new ArrayList<>();
        for (int i = 0; i < getChildCount(); i++) {
            int childId = h(i).getId();
            if (this.f1557a.contains(Integer.valueOf(childId))) {
                orderedCheckedIds.add(Integer.valueOf(childId));
            }
        }
        return orderedCheckedIds;
    }

    public void b(d listener) {
        this.f1555a.add(listener);
    }

    public boolean l() {
        return this.f1560b;
    }

    public void setSingleSelection(boolean singleSelection) {
        if (this.f1560b != singleSelection) {
            this.f1560b = singleSelection;
            f();
        }
        t();
    }

    private void t() {
        for (int i = 0; i < getChildCount(); i++) {
            h(i).setA11yClassName((this.f1560b ? RadioButton.class : ToggleButton.class).getName());
        }
    }

    public void setSelectionRequired(boolean selectionRequired) {
        this.c = selectionRequired;
    }

    public void setSingleSelection(@BoolRes int id) {
        setSingleSelection(getResources().getBoolean(id));
    }

    private void o(int viewId, boolean checked) {
        View checkedView = findViewById(viewId);
        if (checkedView instanceof MaterialButton) {
            this.f1558a = true;
            ((MaterialButton) checkedView).setChecked(checked);
            this.f1558a = false;
        }
    }

    private void c() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex != -1) {
            for (int i = firstVisibleChildIndex + 1; i < getChildCount(); i++) {
                MaterialButton currentButton = h(i);
                int smallestStrokeWidth = Math.min(currentButton.getStrokeWidth(), h(i - 1).getStrokeWidth());
                LinearLayout.LayoutParams params = d(currentButton);
                if (getOrientation() == 0) {
                    MarginLayoutParamsCompat.setMarginEnd(params, 0);
                    MarginLayoutParamsCompat.setMarginStart(params, -smallestStrokeWidth);
                    params.topMargin = 0;
                } else {
                    params.bottomMargin = 0;
                    params.topMargin = -smallestStrokeWidth;
                    MarginLayoutParamsCompat.setMarginStart(params, 0);
                }
                currentButton.setLayoutParams(params);
            }
            n(firstVisibleChildIndex);
        }
    }

    private MaterialButton h(int index) {
        return (MaterialButton) getChildAt(index);
    }

    private void n(int childIndex) {
        if (getChildCount() != 0 && childIndex != -1) {
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) h(childIndex).getLayoutParams();
            if (getOrientation() == 1) {
                params.topMargin = 0;
                params.bottomMargin = 0;
                return;
            }
            MarginLayoutParamsCompat.setMarginEnd(params, 0);
            MarginLayoutParamsCompat.setMarginStart(params, 0);
            params.leftMargin = 0;
            params.rightMargin = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public void s() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i = 0; i < childCount; i++) {
            MaterialButton button = h(i);
            if (button.getVisibility() != 8) {
                il0.b builder = button.getShapeAppearanceModel().v();
                p(builder, j(i, firstVisibleChildIndex, lastVisibleChildIndex));
                button.setShapeAppearanceModel(builder.m());
            }
        }
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (k(i)) {
                return i;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int i = getChildCount() - 1; i >= 0; i--) {
            if (k(i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean k(int i) {
        return getChildAt(i).getVisibility() != 8;
    }

    private int getVisibleButtonCount() {
        int count = 0;
        for (int i = 0; i < getChildCount(); i++) {
            if ((getChildAt(i) instanceof MaterialButton) && k(i)) {
                count++;
            }
        }
        return count;
    }

    /* access modifiers changed from: private */
    public int i(View child) {
        if (!(child instanceof MaterialButton)) {
            return -1;
        }
        int index = 0;
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) == child) {
                return index;
            }
            if ((getChildAt(i) instanceof MaterialButton) && k(i)) {
                index++;
            }
        }
        return -1;
    }

    private c j(int index, int firstVisibleChildIndex, int lastVisibleChildIndex) {
        c cornerData = this.f1556a.get(index);
        if (firstVisibleChildIndex == lastVisibleChildIndex) {
            return cornerData;
        }
        boolean isHorizontal = getOrientation() == 0;
        if (index == firstVisibleChildIndex) {
            return isHorizontal ? c.e(cornerData, this) : c.f(cornerData);
        }
        if (index == lastVisibleChildIndex) {
            return isHorizontal ? c.b(cornerData, this) : c.a(cornerData);
        }
        return null;
    }

    private static void p(il0.b shapeAppearanceModelBuilder, c cornerData) {
        if (cornerData == null) {
            shapeAppearanceModelBuilder.o(0.0f);
        } else {
            shapeAppearanceModelBuilder.B(cornerData.a).t(cornerData.d).F(cornerData.b).x(cornerData.c);
        }
    }

    private void e(int buttonId, boolean checked) {
        if (buttonId == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + buttonId);
            return;
        }
        Set<Integer> checkedIds = new HashSet<>(this.f1557a);
        if (checked && !checkedIds.contains(Integer.valueOf(buttonId))) {
            if (this.f1560b && !checkedIds.isEmpty()) {
                checkedIds.clear();
            }
            checkedIds.add(Integer.valueOf(buttonId));
        } else if (!checked && checkedIds.contains(Integer.valueOf(buttonId))) {
            if (!this.c || checkedIds.size() > 1) {
                checkedIds.remove(Integer.valueOf(buttonId));
            }
        } else {
            return;
        }
        q(checkedIds);
    }

    private void q(Set<Integer> checkedIds) {
        Set<Integer> previousCheckedIds = this.f1557a;
        this.f1557a = new HashSet(checkedIds);
        for (int i = 0; i < getChildCount(); i++) {
            int buttonId = h(i).getId();
            o(buttonId, checkedIds.contains(Integer.valueOf(buttonId)));
            if (previousCheckedIds.contains(Integer.valueOf(buttonId)) != checkedIds.contains(Integer.valueOf(buttonId))) {
                g(buttonId, checkedIds.contains(Integer.valueOf(buttonId)));
            }
        }
        invalidate();
    }

    private void g(int buttonId, boolean checked) {
        Iterator it = this.f1555a.iterator();
        while (it.hasNext()) {
            ((d) it.next()).a(this, buttonId, checked);
        }
    }

    private void setGeneratedIdIfNeeded(@NonNull MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(ViewCompat.generateViewId());
        }
    }

    private void setupButtonChild(@NonNull MaterialButton buttonChild) {
        buttonChild.setMaxLines(1);
        buttonChild.setEllipsize(TextUtils.TruncateAt.END);
        buttonChild.setCheckable(true);
        buttonChild.setOnPressedChangeListenerInternal(this.f1553a);
        buttonChild.setShouldDrawSurfaceColorStroke(true);
    }

    private LinearLayout.LayoutParams d(View child) {
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) layoutParams;
        }
        return new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int childCount, int i) {
        Integer[] numArr = this.f1559a;
        if (numArr != null && i < numArr.length) {
            return numArr[i].intValue();
        }
        Log.w("MButtonToggleGroup", "Child order wasn't updated");
        return i;
    }

    private void r() {
        SortedMap<MaterialButton, Integer> viewToIndexMap = new TreeMap<>(this.f1554a);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            viewToIndexMap.put(h(i), Integer.valueOf(i));
        }
        this.f1559a = (Integer[]) viewToIndexMap.values().toArray(new Integer[0]);
    }

    /* access modifiers changed from: package-private */
    public void m(MaterialButton button, boolean isChecked) {
        if (!this.f1558a) {
            e(button.getId(), isChecked);
        }
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        for (int i = 0; i < getChildCount(); i++) {
            h(i).setEnabled(enabled);
        }
    }

    private class e implements MaterialButton.b {
        private e() {
        }

        /* synthetic */ e(MaterialButtonToggleGroup x0, a x1) {
            this();
        }

        public void a(MaterialButton button, boolean isPressed) {
            MaterialButtonToggleGroup.this.invalidate();
        }
    }

    private static class c {
        private static final wc e = new f(0.0f);
        wc a;
        wc b;
        wc c;
        wc d;

        c(wc topLeft, wc bottomLeft, wc topRight, wc bottomRight) {
            this.a = topLeft;
            this.b = topRight;
            this.c = bottomRight;
            this.d = bottomLeft;
        }

        public static c e(c orig, View view) {
            return lv0.g(view) ? d(orig) : c(orig);
        }

        public static c b(c orig, View view) {
            return lv0.g(view) ? c(orig) : d(orig);
        }

        public static c c(c orig) {
            wc wcVar = orig.a;
            wc wcVar2 = orig.d;
            wc wcVar3 = e;
            return new c(wcVar, wcVar2, wcVar3, wcVar3);
        }

        public static c d(c orig) {
            wc wcVar = e;
            return new c(wcVar, wcVar, orig.b, orig.c);
        }

        public static c f(c orig) {
            wc wcVar = orig.a;
            wc wcVar2 = e;
            return new c(wcVar, wcVar2, orig.b, wcVar2);
        }

        public static c a(c orig) {
            wc wcVar = e;
            return new c(wcVar, orig.d, wcVar, orig.c);
        }
    }
}
