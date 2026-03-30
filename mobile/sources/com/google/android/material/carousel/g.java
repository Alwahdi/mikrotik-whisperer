package com.google.android.material.carousel;

import androidx.core.math.MathUtils;
import com.google.android.material.carousel.KeylineState;
import com.google.android.material.carousel.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class g {
    private final float a;

    /* renamed from: a  reason: collision with other field name */
    private final f f1600a;

    /* renamed from: a  reason: collision with other field name */
    private final List<f> f1601a;

    /* renamed from: a  reason: collision with other field name */
    private final float[] f1602a;
    private final float b;

    /* renamed from: b  reason: collision with other field name */
    private final List<f> f1603b;

    /* renamed from: b  reason: collision with other field name */
    private final float[] f1604b;

    private g(f defaultState, List<f> startStateSteps, List<f> endStateSteps) {
        this.f1600a = defaultState;
        this.f1601a = Collections.unmodifiableList(startStateSteps);
        this.f1603b = Collections.unmodifiableList(endStateSteps);
        float f = startStateSteps.get(startStateSteps.size() - 1).c().a - defaultState.c().a;
        this.a = f;
        float f2 = defaultState.j().a - endStateSteps.get(endStateSteps.size() - 1).j().a;
        this.b = f2;
        this.f1602a = m(f, startStateSteps, true);
        this.f1604b = m(f2, endStateSteps, false);
    }

    static g f(b carousel, f state) {
        return new g(state, p(carousel, state), n(carousel, state));
    }

    /* access modifiers changed from: package-private */
    public f g() {
        return this.f1600a;
    }

    /* access modifiers changed from: package-private */
    public f l() {
        List<f> list = this.f1601a;
        return list.get(list.size() - 1);
    }

    /* access modifiers changed from: package-private */
    public f h() {
        List<f> list = this.f1603b;
        return list.get(list.size() - 1);
    }

    public f j(float scrollOffset, float minScrollOffset, float maxScrollOffset) {
        return k(scrollOffset, minScrollOffset, maxScrollOffset, false);
    }

    /* access modifiers changed from: package-private */
    public f k(float scrollOffset, float minScrollOffset, float maxScrollOffset, boolean roundToNearestStep) {
        float[] interpolationPoints;
        List<f> list;
        float interpolation;
        float startShiftOffset = this.a + minScrollOffset;
        float endShiftOffset = maxScrollOffset - this.b;
        if (scrollOffset < startShiftOffset) {
            interpolation = f3.b(1.0f, 0.0f, minScrollOffset, startShiftOffset, scrollOffset);
            list = this.f1601a;
            interpolationPoints = this.f1602a;
        } else if (scrollOffset <= endShiftOffset) {
            return this.f1600a;
        } else {
            interpolation = f3.b(0.0f, 1.0f, endShiftOffset, maxScrollOffset, scrollOffset);
            list = this.f1603b;
            interpolationPoints = this.f1604b;
        }
        if (roundToNearestStep) {
            return a(list, interpolation, interpolationPoints);
        }
        return s(list, interpolation, interpolationPoints);
    }

    private static f s(List<f> stateSteps, float interpolation, float[] stateStepsInterpolationPoints) {
        float[] stateStepsRange = o(stateSteps, interpolation, stateStepsInterpolationPoints);
        return f.l(stateSteps.get((int) stateStepsRange[1]), stateSteps.get((int) stateStepsRange[2]), stateStepsRange[0]);
    }

    private static float[] o(List<f> stateSteps, float interpolation, float[] stateStepsInterpolationPoints) {
        int numberOfSteps = stateSteps.size();
        float lowerBounds = stateStepsInterpolationPoints[0];
        for (int i = 1; i < numberOfSteps; i++) {
            float upperBounds = stateStepsInterpolationPoints[i];
            if (interpolation <= upperBounds) {
                return new float[]{f3.b(0.0f, 1.0f, lowerBounds, upperBounds, interpolation), (float) (i - 1), (float) i};
            }
            lowerBounds = upperBounds;
        }
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    private f a(List<f> stateSteps, float interpolation, float[] stateStepsInterpolationPoints) {
        float[] stateStepsRange = o(stateSteps, interpolation, stateStepsInterpolationPoints);
        if (stateStepsRange[0] > 0.5f) {
            return stateSteps.get((int) stateStepsRange[2]);
        }
        return stateSteps.get((int) stateStepsRange[1]);
    }

    private static float[] m(float shiftRange, List<f> stateSteps, boolean isShiftingLeft) {
        float distanceShifted;
        int numberOfSteps = stateSteps.size();
        float[] stateStepsInterpolationPoints = new float[numberOfSteps];
        int i = 1;
        while (i < numberOfSteps) {
            f prevState = stateSteps.get(i - 1);
            f currState = stateSteps.get(i);
            if (isShiftingLeft) {
                distanceShifted = currState.c().a - prevState.c().a;
            } else {
                distanceShifted = prevState.j().a - currState.j().a;
            }
            stateStepsInterpolationPoints[i] = i == numberOfSteps + -1 ? 1.0f : stateStepsInterpolationPoints[i - 1] + (distanceShifted / shiftRange);
            i++;
        }
        return stateStepsInterpolationPoints;
    }

    private static boolean q(f state) {
        return state.a().b - (state.a().d / 2.0f) >= 0.0f && state.a() == state.d();
    }

    private static boolean r(b carousel, f state) {
        int containerSize = carousel.c();
        if (carousel.b()) {
            containerSize = carousel.a();
        }
        return state.h().b + (state.h().d / 2.0f) <= ((float) containerSize) && state.h() == state.k();
    }

    private static List<f> p(b carousel, f defaultState) {
        f fVar = defaultState;
        List<KeylineState> steps = new ArrayList<>();
        steps.add(fVar);
        int firstNonAnchorKeylineIndex = c(defaultState);
        if (q(defaultState) || firstNonAnchorKeylineIndex == -1) {
            return steps;
        }
        int start = firstNonAnchorKeylineIndex;
        int numberOfSteps = defaultState.b() - start;
        float carouselSize = (float) (carousel.b() ? carousel.a() : carousel.c());
        float originalStart = defaultState.c().b - (defaultState.c().d / 2.0f);
        if (numberOfSteps > 0 || defaultState.a().e <= 0.0f) {
            float cutoffs = 0.0f;
            int i = 0;
            while (i < numberOfSteps) {
                f prevStepState = (f) steps.get(steps.size() - 1);
                int itemOrigIndex = start + i;
                int dstIndex = defaultState.g().size() - 1;
                float cutoffs2 = cutoffs + defaultState.g().get(itemOrigIndex).e;
                if (itemOrigIndex - 1 >= 0) {
                    dstIndex = b(prevStepState, defaultState.g().get(itemOrigIndex - 1).c) - 1;
                }
                int i2 = itemOrigIndex;
                f fVar2 = prevStepState;
                steps.add(t(prevStepState, firstNonAnchorKeylineIndex, dstIndex, originalStart + cutoffs2, (defaultState.b() - i) - 1, (defaultState.i() - i) - 1, carouselSize));
                i++;
                cutoffs = cutoffs2;
            }
            return steps;
        }
        steps.add(u(fVar, originalStart + defaultState.a().e, carouselSize));
        return steps;
    }

    private static List<f> n(b carousel, f defaultState) {
        f fVar = defaultState;
        List<KeylineState> steps = new ArrayList<>();
        steps.add(fVar);
        int lastNonAnchorKeylineIndex = e(defaultState);
        if (r(carousel, defaultState) || lastNonAnchorKeylineIndex == -1) {
            return steps;
        }
        int end = lastNonAnchorKeylineIndex;
        int numberOfSteps = end - defaultState.i();
        float carouselSize = (float) (carousel.b() ? carousel.a() : carousel.c());
        float originalStart = defaultState.c().b - (defaultState.c().d / 2.0f);
        if (numberOfSteps > 0 || defaultState.h().e <= 0.0f) {
            float cutoffs = 0.0f;
            int i = 0;
            while (i < numberOfSteps) {
                f prevStepState = (f) steps.get(steps.size() - 1);
                int itemOrigIndex = end - i;
                float cutoffs2 = cutoffs + defaultState.g().get(itemOrigIndex).e;
                int dstIndex = 0;
                if (itemOrigIndex + 1 < defaultState.g().size()) {
                    dstIndex = d(prevStepState, defaultState.g().get(itemOrigIndex + 1).c) + 1;
                }
                int i2 = itemOrigIndex;
                f fVar2 = prevStepState;
                steps.add(t(prevStepState, lastNonAnchorKeylineIndex, dstIndex, originalStart - cutoffs2, defaultState.b() + i + 1, defaultState.i() + i + 1, carouselSize));
                i++;
                cutoffs = cutoffs2;
            }
            return steps;
        }
        steps.add(u(fVar, originalStart - defaultState.h().e, carouselSize));
        return steps;
    }

    private static f u(f state, float startOffset, float carouselSize) {
        return t(state, 0, 0, startOffset, state.b(), state.i(), carouselSize);
    }

    private static f t(f state, int keylineSrcIndex, int keylineDstIndex, float startOffset, int newFirstFocalIndex, int newLastFocalIndex, float carouselSize) {
        boolean isFocal;
        List<KeylineState.Keyline> tmpKeylines = new ArrayList<>(state.g());
        tmpKeylines.add(keylineDstIndex, (f.c) tmpKeylines.remove(keylineSrcIndex));
        f.b builder = new f.b(state.f(), carouselSize);
        float startOffset2 = startOffset;
        int j = 0;
        while (j < tmpKeylines.size()) {
            f.c k = (f.c) tmpKeylines.get(j);
            float f = k.d;
            float offset = startOffset2 + (f / 2.0f);
            if (j < newFirstFocalIndex) {
                int i = newLastFocalIndex;
            } else if (j <= newLastFocalIndex) {
                isFocal = true;
                builder.e(offset, k.c, f, isFocal, k.f1599a, k.e);
                startOffset2 += k.d;
                j++;
                tmpKeylines = tmpKeylines;
            }
            isFocal = false;
            builder.e(offset, k.c, f, isFocal, k.f1599a, k.e);
            startOffset2 += k.d;
            j++;
            tmpKeylines = tmpKeylines;
        }
        return builder.h();
    }

    private static int b(f state, float mask) {
        for (int i = state.i(); i < state.g().size(); i++) {
            if (mask == state.g().get(i).c) {
                return i;
            }
        }
        return state.g().size() - 1;
    }

    private static int d(f state, float mask) {
        for (int i = state.b() - 1; i >= 0; i--) {
            if (mask == state.g().get(i).c) {
                return i;
            }
        }
        return 0;
    }

    private static int c(f state) {
        for (int i = 0; i < state.g().size(); i++) {
            if (!state.g().get(i).f1599a) {
                return i;
            }
        }
        return -1;
    }

    private static int e(f state) {
        for (int i = state.g().size() - 1; i >= 0; i--) {
            if (!state.g().get(i).f1599a) {
                return i;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public Map<Integer, f> i(int itemCount, int minHorizontalScroll, int maxHorizontalScroll, boolean isRTL) {
        int i = itemCount;
        float itemSize = this.f1600a.f();
        Map<Integer, KeylineState> keylineStates = new HashMap<>();
        int endStepsIndex = 0;
        int startStepsIndex = 0;
        for (int i2 = 0; i2 < i; i2++) {
            int position = isRTL ? (i - i2) - 1 : i2;
            if (((float) position) * itemSize * ((float) (isRTL ? -1 : 1)) > ((float) maxHorizontalScroll) - this.b || i2 >= i - this.f1603b.size()) {
                Integer valueOf = Integer.valueOf(position);
                List<f> list = this.f1603b;
                keylineStates.put(valueOf, list.get(MathUtils.clamp(endStepsIndex, 0, list.size() - 1)));
                endStepsIndex++;
            }
        }
        int i3 = maxHorizontalScroll;
        for (int i4 = i - 1; i4 >= 0; i4--) {
            int position2 = isRTL ? (i - i4) - 1 : i4;
            if (((float) position2) * itemSize * ((float) (isRTL ? -1 : 1)) < ((float) minHorizontalScroll) + this.a || i4 < this.f1601a.size()) {
                Integer valueOf2 = Integer.valueOf(position2);
                List<f> list2 = this.f1601a;
                keylineStates.put(valueOf2, list2.get(MathUtils.clamp(startStepsIndex, 0, list2.size() - 1)));
                startStepsIndex++;
            }
        }
        int i5 = minHorizontalScroll;
        return keylineStates;
    }
}
