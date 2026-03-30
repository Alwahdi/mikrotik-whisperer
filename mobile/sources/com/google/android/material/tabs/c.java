package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.tabs.TabLayout;

class c {
    c() {
    }

    static RectF b(TabLayout.i tabView, int minWidth) {
        int tabViewContentWidth = tabView.getContentWidth();
        int tabViewContentHeight = tabView.getContentHeight();
        int minWidthPx = (int) lv0.c(tabView.getContext(), minWidth);
        if (tabViewContentWidth < minWidthPx) {
            tabViewContentWidth = minWidthPx;
        }
        int tabViewCenterX = (tabView.getLeft() + tabView.getRight()) / 2;
        int tabViewCenterY = (tabView.getTop() + tabView.getBottom()) / 2;
        return new RectF((float) (tabViewCenterX - (tabViewContentWidth / 2)), (float) (tabViewCenterY - (tabViewContentHeight / 2)), (float) ((tabViewContentWidth / 2) + tabViewCenterX), (float) ((tabViewCenterX / 2) + tabViewCenterY));
    }

    static RectF a(TabLayout tabLayout, View tab) {
        if (tab == null) {
            return new RectF();
        }
        if (tabLayout.C() || !(tab instanceof TabLayout.i)) {
            return new RectF((float) tab.getLeft(), (float) tab.getTop(), (float) tab.getRight(), (float) tab.getBottom());
        }
        return b((TabLayout.i) tab, 24);
    }

    /* access modifiers changed from: package-private */
    public void c(TabLayout tabLayout, View tab, Drawable indicator) {
        RectF startIndicator = a(tabLayout, tab);
        indicator.setBounds((int) startIndicator.left, indicator.getBounds().top, (int) startIndicator.right, indicator.getBounds().bottom);
    }

    /* access modifiers changed from: package-private */
    public void d(TabLayout tabLayout, View startTitle, View endTitle, float offset, Drawable indicator) {
        RectF startIndicator = a(tabLayout, startTitle);
        RectF endIndicator = a(tabLayout, endTitle);
        indicator.setBounds(f3.c((int) startIndicator.left, (int) endIndicator.left, offset), indicator.getBounds().top, f3.c((int) startIndicator.right, (int) endIndicator.right, offset), indicator.getBounds().bottom);
    }
}
