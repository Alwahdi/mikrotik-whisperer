package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;

class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem system, int orientation) {
        ChainHead[] chainsArray;
        int chainsSize;
        int offset;
        if (orientation == 0) {
            offset = 0;
            chainsSize = constraintWidgetContainer.mHorizontalChainsSize;
            chainsArray = constraintWidgetContainer.mHorizontalChainsArray;
        } else {
            offset = 2;
            chainsSize = constraintWidgetContainer.mVerticalChainsSize;
            chainsArray = constraintWidgetContainer.mVerticalChainsArray;
        }
        for (int i = 0; i < chainsSize; i++) {
            ChainHead first = chainsArray[i];
            first.define();
            applyChainConstraints(constraintWidgetContainer, system, orientation, offset, first);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:295:0x0630 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0644  */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x0647  */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x064e  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x0651  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x0654  */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x0666  */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x066a  */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x0673  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0677 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r45, androidx.constraintlayout.solver.LinearSystem r46, int r47, int r48, androidx.constraintlayout.solver.widgets.ChainHead r49) {
        /*
            r0 = r45
            r10 = r46
            r11 = r49
            androidx.constraintlayout.solver.widgets.ConstraintWidget r12 = r11.mFirst
            androidx.constraintlayout.solver.widgets.ConstraintWidget r13 = r11.mLast
            androidx.constraintlayout.solver.widgets.ConstraintWidget r14 = r11.mFirstVisibleWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r15 = r11.mLastVisibleWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r11.mHead
            r1 = r12
            r2 = 0
            r3 = 0
            float r4 = r11.mTotalWeight
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = r11.mFirstMatchConstraintWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r11.mLastMatchConstraintWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r0.mListDimensionBehaviors
            r5 = r5[r47]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r16 = r1
            if (r5 != r6) goto L_0x0025
            r5 = 1
            goto L_0x0026
        L_0x0025:
            r5 = 0
        L_0x0026:
            r18 = r5
            r5 = 0
            r6 = 0
            r19 = 0
            if (r47 != 0) goto L_0x0052
            int r1 = r9.mHorizontalChainStyle
            if (r1 != 0) goto L_0x0035
            r22 = 1
            goto L_0x0037
        L_0x0035:
            r22 = 0
        L_0x0037:
            r5 = r22
            r22 = r2
            r2 = 1
            if (r1 != r2) goto L_0x0040
            r2 = 1
            goto L_0x0041
        L_0x0040:
            r2 = 0
        L_0x0041:
            r6 = 2
            if (r1 != r6) goto L_0x0046
            r1 = 1
            goto L_0x0047
        L_0x0046:
            r1 = 0
        L_0x0047:
            r19 = r2
            r21 = r3
            r23 = r5
            r6 = r16
            r16 = r1
            goto L_0x0072
        L_0x0052:
            r22 = r2
            int r1 = r9.mVerticalChainStyle
            if (r1 != 0) goto L_0x005a
            r2 = 1
            goto L_0x005b
        L_0x005a:
            r2 = 0
        L_0x005b:
            r5 = r2
            r2 = 1
            if (r1 != r2) goto L_0x0061
            r2 = 1
            goto L_0x0062
        L_0x0061:
            r2 = 0
        L_0x0062:
            r6 = 2
            if (r1 != r6) goto L_0x0067
            r1 = 1
            goto L_0x0068
        L_0x0067:
            r1 = 0
        L_0x0068:
            r19 = r2
            r21 = r3
            r23 = r5
            r6 = r16
            r16 = r1
        L_0x0072:
            if (r21 != 0) goto L_0x0151
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r6.mListAnchors
            r3 = r3[r48]
            r24 = 4
            if (r16 == 0) goto L_0x007e
            r24 = 1
        L_0x007e:
            int r25 = r3.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r6.mListDimensionBehaviors
            r1 = r1[r47]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 != r5) goto L_0x0092
            int[] r1 = r6.mResolvedMatchConstraintDefault
            r1 = r1[r47]
            if (r1 != 0) goto L_0x0092
            r1 = 1
            goto L_0x0093
        L_0x0092:
            r1 = 0
        L_0x0093:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r3.mTarget
            if (r2 == 0) goto L_0x00a2
            if (r6 == r12) goto L_0x00a2
            int r2 = r2.getMargin()
            int r25 = r25 + r2
            r2 = r25
            goto L_0x00a4
        L_0x00a2:
            r2 = r25
        L_0x00a4:
            if (r16 == 0) goto L_0x00ac
            if (r6 == r12) goto L_0x00ac
            if (r6 == r14) goto L_0x00ac
            r24 = 5
        L_0x00ac:
            r25 = r4
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r3.mTarget
            if (r4 == 0) goto L_0x00e2
            if (r6 != r14) goto L_0x00c1
            r29 = r7
            androidx.constraintlayout.solver.SolverVariable r7 = r3.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            r30 = r8
            r8 = 6
            r10.addGreaterThan(r7, r4, r2, r8)
            goto L_0x00ce
        L_0x00c1:
            r29 = r7
            r30 = r8
            androidx.constraintlayout.solver.SolverVariable r7 = r3.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            r8 = 8
            r10.addGreaterThan(r7, r4, r2, r8)
        L_0x00ce:
            if (r1 == 0) goto L_0x00d4
            if (r16 != 0) goto L_0x00d4
            r4 = 5
            goto L_0x00d6
        L_0x00d4:
            r4 = r24
        L_0x00d6:
            androidx.constraintlayout.solver.SolverVariable r7 = r3.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r3.mTarget
            androidx.constraintlayout.solver.SolverVariable r8 = r8.mSolverVariable
            r10.addEquality(r7, r8, r2, r4)
            r24 = r4
            goto L_0x00e6
        L_0x00e2:
            r29 = r7
            r30 = r8
        L_0x00e6:
            if (r18 == 0) goto L_0x0119
            int r4 = r6.getVisibility()
            r7 = 8
            if (r4 == r7) goto L_0x0107
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r6.mListDimensionBehaviors
            r4 = r4[r47]
            if (r4 != r5) goto L_0x0107
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r6.mListAnchors
            int r5 = r48 + 1
            r5 = r4[r5]
            androidx.constraintlayout.solver.SolverVariable r5 = r5.mSolverVariable
            r4 = r4[r48]
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            r7 = 5
            r8 = 0
            r10.addGreaterThan(r5, r4, r8, r7)
        L_0x0107:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r6.mListAnchors
            r4 = r4[r48]
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r0.mListAnchors
            r5 = r5[r48]
            androidx.constraintlayout.solver.SolverVariable r5 = r5.mSolverVariable
            r7 = 8
            r8 = 0
            r10.addGreaterThan(r4, r5, r8, r7)
        L_0x0119:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r6.mListAnchors
            int r5 = r48 + 1
            r4 = r4[r5]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 == 0) goto L_0x013d
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r4.mOwner
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r5.mListAnchors
            r8 = r7[r48]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r8.mTarget
            if (r8 == 0) goto L_0x0139
            r7 = r7[r48]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r7.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r7.mOwner
            if (r7 == r6) goto L_0x0136
            goto L_0x0139
        L_0x0136:
            r22 = r5
            goto L_0x0140
        L_0x0139:
            r5 = 0
            r22 = r5
            goto L_0x0140
        L_0x013d:
            r5 = 0
            r22 = r5
        L_0x0140:
            if (r22 == 0) goto L_0x0146
            r5 = r22
            r6 = r5
            goto L_0x0149
        L_0x0146:
            r5 = 1
            r21 = r5
        L_0x0149:
            r4 = r25
            r7 = r29
            r8 = r30
            goto L_0x0072
        L_0x0151:
            r25 = r4
            r29 = r7
            r30 = r8
            r1 = 4
            if (r15 == 0) goto L_0x01bc
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            int r3 = r48 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x01bc
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r15.mListAnchors
            int r3 = r48 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r15.mListDimensionBehaviors
            r3 = r3[r47]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r4) goto L_0x017a
            int[] r3 = r15.mResolvedMatchConstraintDefault
            r3 = r3[r47]
            if (r3 != 0) goto L_0x017a
            r3 = 1
            goto L_0x017b
        L_0x017a:
            r3 = 0
        L_0x017b:
            if (r3 == 0) goto L_0x0193
            if (r16 != 0) goto L_0x0193
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r2.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r4.mOwner
            if (r5 != r0) goto L_0x0193
            androidx.constraintlayout.solver.SolverVariable r5 = r2.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            int r7 = r2.getMargin()
            int r7 = -r7
            r8 = 5
            r10.addEquality(r5, r4, r7, r8)
            goto L_0x01a7
        L_0x0193:
            if (r16 == 0) goto L_0x01a7
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r2.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r4.mOwner
            if (r5 != r0) goto L_0x01a7
            androidx.constraintlayout.solver.SolverVariable r5 = r2.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            int r7 = r2.getMargin()
            int r7 = -r7
            r10.addEquality(r5, r4, r7, r1)
        L_0x01a7:
            androidx.constraintlayout.solver.SolverVariable r4 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r13.mListAnchors
            int r7 = r48 + 1
            r5 = r5[r7]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            androidx.constraintlayout.solver.SolverVariable r5 = r5.mSolverVariable
            int r7 = r2.getMargin()
            int r7 = -r7
            r8 = 6
            r10.addLowerThan(r4, r5, r7, r8)
        L_0x01bc:
            if (r18 == 0) goto L_0x01db
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r0.mListAnchors
            int r3 = r48 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r13.mListAnchors
            int r4 = r48 + 1
            r4 = r3[r4]
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            int r5 = r48 + 1
            r3 = r3[r5]
            int r3 = r3.getMargin()
            r5 = 8
            r10.addGreaterThan(r2, r4, r3, r5)
        L_0x01db:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r8 = r11.mWeightedMatchConstraintsWidgets
            if (r8 == 0) goto L_0x02b7
            int r2 = r8.size()
            r3 = 1
            if (r2 <= r3) goto L_0x02b0
            r4 = 0
            r5 = 0
            boolean r7 = r11.mHasUndefinedWeights
            if (r7 == 0) goto L_0x01f4
            boolean r7 = r11.mHasComplexMatchWeights
            if (r7 != 0) goto L_0x01f4
            int r7 = r11.mWidgetsMatchCount
            float r7 = (float) r7
            goto L_0x01f6
        L_0x01f4:
            r7 = r25
        L_0x01f6:
            r20 = 0
            r3 = r20
        L_0x01fa:
            if (r3 >= r2) goto L_0x02a5
            java.lang.Object r24 = r8.get(r3)
            r1 = r24
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r1
            float[] r0 = r1.mWeight
            r0 = r0[r47]
            r24 = 0
            int r25 = (r0 > r24 ? 1 : (r0 == r24 ? 0 : -1))
            if (r25 >= 0) goto L_0x0238
            r25 = r0
            boolean r0 = r11.mHasComplexMatchWeights
            if (r0 == 0) goto L_0x022e
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r1.mListAnchors
            int r24 = r48 + 1
            r28 = r2
            r2 = r0[r24]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            r0 = r0[r48]
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            r39 = r6
            r26 = r8
            r6 = 4
            r8 = 0
            r10.addEquality(r2, r0, r8, r6)
            r11 = 0
            goto L_0x0296
        L_0x022e:
            r28 = r2
            r39 = r6
            r26 = r8
            r6 = 4
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0241
        L_0x0238:
            r25 = r0
            r28 = r2
            r39 = r6
            r26 = r8
            r6 = 4
        L_0x0241:
            int r2 = (r0 > r24 ? 1 : (r0 == r24 ? 0 : -1))
            if (r2 != 0) goto L_0x0258
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r1.mListAnchors
            int r8 = r48 + 1
            r8 = r2[r8]
            androidx.constraintlayout.solver.SolverVariable r8 = r8.mSolverVariable
            r2 = r2[r48]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            r6 = 8
            r11 = 0
            r10.addEquality(r8, r2, r11, r6)
            goto L_0x0296
        L_0x0258:
            r11 = 0
            if (r4 == 0) goto L_0x0290
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r4.mListAnchors
            r6 = r2[r48]
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
            int r8 = r48 + 1
            r2 = r2[r8]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r8 = r1.mListAnchors
            r11 = r8[r48]
            androidx.constraintlayout.solver.SolverVariable r11 = r11.mSolverVariable
            int r25 = r48 + 1
            r8 = r8[r25]
            androidx.constraintlayout.solver.SolverVariable r8 = r8.mSolverVariable
            r25 = r4
            androidx.constraintlayout.solver.ArrayRow r4 = r46.createRow()
            r31 = r4
            r32 = r5
            r33 = r7
            r34 = r0
            r35 = r6
            r36 = r2
            r37 = r11
            r38 = r8
            r31.createRowEqualMatchDimensions(r32, r33, r34, r35, r36, r37, r38)
            r10.addConstraint(r4)
            goto L_0x0292
        L_0x0290:
            r25 = r4
        L_0x0292:
            r2 = r1
            r4 = r0
            r5 = r4
            r4 = r2
        L_0x0296:
            int r3 = r3 + 1
            r0 = r45
            r11 = r49
            r8 = r26
            r2 = r28
            r6 = r39
            r1 = 4
            goto L_0x01fa
        L_0x02a5:
            r28 = r2
            r25 = r4
            r39 = r6
            r26 = r8
            r25 = r7
            goto L_0x02bb
        L_0x02b0:
            r28 = r2
            r39 = r6
            r26 = r8
            goto L_0x02bb
        L_0x02b7:
            r39 = r6
            r26 = r8
        L_0x02bb:
            if (r14 == 0) goto L_0x0349
            if (r14 == r15) goto L_0x02ce
            if (r16 == 0) goto L_0x02c2
            goto L_0x02ce
        L_0x02c2:
            r34 = r9
            r31 = r39
            r44 = r30
            r30 = r26
            r26 = r44
            goto L_0x0353
        L_0x02ce:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r12.mListAnchors
            r1 = r1[r48]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            int r3 = r48 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r1.mTarget
            if (r3 == 0) goto L_0x02df
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x02e0
        L_0x02df:
            r3 = 0
        L_0x02e0:
            r11 = r3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r2.mTarget
            if (r3 == 0) goto L_0x02e8
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x02e9
        L_0x02e8:
            r3 = 0
        L_0x02e9:
            r17 = r3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r14.mListAnchors
            r8 = r3[r48]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r15.mListAnchors
            int r3 = r48 + 1
            r7 = r1[r3]
            if (r11 == 0) goto L_0x0337
            if (r17 == 0) goto L_0x0337
            r1 = 1056964608(0x3f000000, float:0.5)
            if (r47 != 0) goto L_0x0302
            float r1 = r9.mHorizontalBiasPercent
            r20 = r1
            goto L_0x0306
        L_0x0302:
            float r1 = r9.mVerticalBiasPercent
            r20 = r1
        L_0x0306:
            int r24 = r8.getMargin()
            int r27 = r7.getMargin()
            androidx.constraintlayout.solver.SolverVariable r2 = r8.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r6 = r7.mSolverVariable
            r28 = 7
            r1 = r46
            r3 = r11
            r4 = r24
            r5 = r20
            r32 = r6
            r31 = r39
            r6 = r17
            r33 = r7
            r7 = r32
            r32 = r8
            r44 = r30
            r30 = r26
            r26 = r44
            r8 = r27
            r34 = r9
            r9 = r28
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x0345
        L_0x0337:
            r33 = r7
            r32 = r8
            r34 = r9
            r31 = r39
            r44 = r30
            r30 = r26
            r26 = r44
        L_0x0345:
            r11 = r49
            goto L_0x062e
        L_0x0349:
            r34 = r9
            r31 = r39
            r44 = r30
            r30 = r26
            r26 = r44
        L_0x0353:
            if (r23 == 0) goto L_0x049c
            if (r14 == 0) goto L_0x049c
            r1 = r14
            r2 = r14
            r11 = r49
            r3 = 0
            int r4 = r11.mWidgetsMatchCount
            if (r4 <= 0) goto L_0x0365
            int r5 = r11.mWidgetsCount
            if (r5 != r4) goto L_0x0365
            r3 = 1
        L_0x0365:
            r17 = r3
            r8 = r1
            r9 = r2
        L_0x0369:
            if (r8 == 0) goto L_0x0494
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r1 = r8.mNextChainWidget
            r1 = r1[r47]
            r7 = r1
        L_0x0370:
            if (r7 == 0) goto L_0x037f
            int r1 = r7.getVisibility()
            r5 = 8
            if (r1 != r5) goto L_0x0381
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r1 = r7.mNextChainWidget
            r7 = r1[r47]
            goto L_0x0370
        L_0x037f:
            r5 = 8
        L_0x0381:
            if (r7 != 0) goto L_0x0390
            if (r8 != r15) goto L_0x0386
            goto L_0x0390
        L_0x0386:
            r39 = r7
            r40 = r8
            r41 = r9
            r0 = 8
            goto L_0x0482
        L_0x0390:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r8.mListAnchors
            r6 = r1[r48]
            androidx.constraintlayout.solver.SolverVariable r4 = r6.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r6.mTarget
            if (r1 == 0) goto L_0x039d
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            goto L_0x039e
        L_0x039d:
            r1 = 0
        L_0x039e:
            if (r9 == r8) goto L_0x03ab
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r9.mListAnchors
            int r3 = r48 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r1 = r2.mSolverVariable
            r20 = r1
            goto L_0x03c5
        L_0x03ab:
            if (r8 != r14) goto L_0x03c3
            if (r9 != r8) goto L_0x03c3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r12.mListAnchors
            r3 = r2[r48]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x03be
            r2 = r2[r48]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x03bf
        L_0x03be:
            r2 = 0
        L_0x03bf:
            r1 = r2
            r20 = r1
            goto L_0x03c5
        L_0x03c3:
            r20 = r1
        L_0x03c5:
            r1 = 0
            r2 = 0
            r3 = 0
            int r22 = r6.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r8.mListAnchors
            int r27 = r48 + 1
            r0 = r0[r27]
            int r0 = r0.getMargin()
            if (r7 == 0) goto L_0x03ed
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r7.mListAnchors
            r1 = r5[r48]
            androidx.constraintlayout.solver.SolverVariable r2 = r1.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r8.mListAnchors
            int r28 = r48 + 1
            r5 = r5[r28]
            androidx.constraintlayout.solver.SolverVariable r3 = r5.mSolverVariable
            r28 = r1
            r31 = r2
            r32 = r3
            goto L_0x0407
        L_0x03ed:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r13.mListAnchors
            int r28 = r48 + 1
            r5 = r5[r28]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r5.mTarget
            if (r1 == 0) goto L_0x03f9
            androidx.constraintlayout.solver.SolverVariable r2 = r1.mSolverVariable
        L_0x03f9:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r8.mListAnchors
            int r28 = r48 + 1
            r5 = r5[r28]
            androidx.constraintlayout.solver.SolverVariable r3 = r5.mSolverVariable
            r28 = r1
            r31 = r2
            r32 = r3
        L_0x0407:
            if (r28 == 0) goto L_0x040e
            int r1 = r28.getMargin()
            int r0 = r0 + r1
        L_0x040e:
            if (r9 == 0) goto L_0x041c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r9.mListAnchors
            int r2 = r48 + 1
            r1 = r1[r2]
            int r1 = r1.getMargin()
            int r22 = r22 + r1
        L_0x041c:
            if (r4 == 0) goto L_0x0474
            if (r20 == 0) goto L_0x0474
            if (r31 == 0) goto L_0x0474
            if (r32 == 0) goto L_0x0474
            r1 = r22
            if (r8 != r14) goto L_0x0433
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r14.mListAnchors
            r2 = r2[r48]
            int r1 = r2.getMargin()
            r33 = r1
            goto L_0x0435
        L_0x0433:
            r33 = r1
        L_0x0435:
            r1 = r0
            if (r8 != r15) goto L_0x0445
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r15.mListAnchors
            int r3 = r48 + 1
            r2 = r2[r3]
            int r1 = r2.getMargin()
            r35 = r1
            goto L_0x0447
        L_0x0445:
            r35 = r1
        L_0x0447:
            r1 = 5
            if (r17 == 0) goto L_0x044f
            r1 = 8
            r36 = r1
            goto L_0x0451
        L_0x044f:
            r36 = r1
        L_0x0451:
            r5 = 1056964608(0x3f000000, float:0.5)
            r1 = r46
            r2 = r4
            r3 = r20
            r37 = r4
            r4 = r33
            r38 = r0
            r0 = 8
            r27 = r6
            r6 = r31
            r39 = r7
            r7 = r32
            r40 = r8
            r8 = r35
            r41 = r9
            r9 = r36
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x0482
        L_0x0474:
            r38 = r0
            r37 = r4
            r27 = r6
            r39 = r7
            r40 = r8
            r41 = r9
            r0 = 8
        L_0x0482:
            int r1 = r40.getVisibility()
            if (r1 == r0) goto L_0x048c
            r1 = r40
            r9 = r1
            goto L_0x048e
        L_0x048c:
            r9 = r41
        L_0x048e:
            r8 = r39
            r22 = r39
            goto L_0x0369
        L_0x0494:
            r40 = r8
            r41 = r9
            r31 = r40
            goto L_0x062e
        L_0x049c:
            r11 = r49
            r0 = 8
            r3 = 0
            if (r19 == 0) goto L_0x062e
            if (r14 == 0) goto L_0x062e
            r1 = r14
            r2 = r14
            int r4 = r11.mWidgetsMatchCount
            if (r4 <= 0) goto L_0x04b0
            int r5 = r11.mWidgetsCount
            if (r5 != r4) goto L_0x04b0
            r3 = 1
        L_0x04b0:
            r17 = r3
            r8 = r1
            r9 = r2
        L_0x04b4:
            if (r8 == 0) goto L_0x059d
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r1 = r8.mNextChainWidget
            r1 = r1[r47]
        L_0x04ba:
            if (r1 == 0) goto L_0x04c7
            int r2 = r1.getVisibility()
            if (r2 != r0) goto L_0x04c7
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r2 = r1.mNextChainWidget
            r1 = r2[r47]
            goto L_0x04ba
        L_0x04c7:
            if (r8 == r14) goto L_0x0583
            if (r8 == r15) goto L_0x0583
            if (r1 == 0) goto L_0x0583
            if (r1 != r15) goto L_0x04d2
            r1 = 0
            r7 = r1
            goto L_0x04d3
        L_0x04d2:
            r7 = r1
        L_0x04d3:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r8.mListAnchors
            r6 = r1[r48]
            androidx.constraintlayout.solver.SolverVariable r5 = r6.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r6.mTarget
            if (r1 == 0) goto L_0x04e0
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            goto L_0x04e1
        L_0x04e0:
            r1 = 0
        L_0x04e1:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r9.mListAnchors
            int r3 = r48 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r4 = r2.mSolverVariable
            r1 = 0
            r2 = 0
            r3 = 0
            int r20 = r6.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r8.mListAnchors
            int r22 = r48 + 1
            r0 = r0[r22]
            int r0 = r0.getMargin()
            if (r7 == 0) goto L_0x0515
            r22 = r1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r7.mListAnchors
            r1 = r1[r48]
            androidx.constraintlayout.solver.SolverVariable r2 = r1.mSolverVariable
            r22 = r2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r1.mTarget
            if (r2 == 0) goto L_0x050d
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x050e
        L_0x050d:
            r2 = 0
        L_0x050e:
            r28 = r2
            r31 = r22
            r22 = r1
            goto L_0x052d
        L_0x0515:
            r22 = r1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r15.mListAnchors
            r1 = r1[r48]
            if (r1 == 0) goto L_0x051f
            androidx.constraintlayout.solver.SolverVariable r2 = r1.mSolverVariable
        L_0x051f:
            r22 = r1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r8.mListAnchors
            int r28 = r48 + 1
            r1 = r1[r28]
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            r28 = r1
            r31 = r2
        L_0x052d:
            if (r22 == 0) goto L_0x0534
            int r1 = r22.getMargin()
            int r0 = r0 + r1
        L_0x0534:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r9.mListAnchors
            int r2 = r48 + 1
            r1 = r1[r2]
            int r1 = r1.getMargin()
            int r20 = r20 + r1
            r1 = 4
            if (r17 == 0) goto L_0x0549
            r1 = 8
            r32 = r1
            goto L_0x054b
        L_0x0549:
            r32 = r1
        L_0x054b:
            if (r5 == 0) goto L_0x0574
            if (r4 == 0) goto L_0x0574
            if (r31 == 0) goto L_0x0574
            if (r28 == 0) goto L_0x0574
            r33 = 1056964608(0x3f000000, float:0.5)
            r1 = r46
            r2 = r5
            r3 = r4
            r35 = r4
            r4 = r20
            r36 = r5
            r5 = r33
            r33 = r6
            r6 = r31
            r37 = r7
            r7 = r28
            r38 = r8
            r8 = r0
            r39 = r9
            r9 = r32
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x0580
        L_0x0574:
            r35 = r4
            r36 = r5
            r33 = r6
            r37 = r7
            r38 = r8
            r39 = r9
        L_0x0580:
            r22 = r37
            goto L_0x0589
        L_0x0583:
            r38 = r8
            r39 = r9
            r22 = r1
        L_0x0589:
            int r0 = r38.getVisibility()
            r1 = 8
            if (r0 == r1) goto L_0x0595
            r0 = r38
            r9 = r0
            goto L_0x0597
        L_0x0595:
            r9 = r39
        L_0x0597:
            r8 = r22
            r0 = 8
            goto L_0x04b4
        L_0x059d:
            r38 = r8
            r39 = r9
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r14.mListAnchors
            r0 = r0[r48]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r12.mListAnchors
            r1 = r1[r48]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r1.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r15.mListAnchors
            int r2 = r48 + 1
            r8 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r13.mListAnchors
            int r2 = r48 + 1
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r1.mTarget
            r6 = 5
            if (r9 == 0) goto L_0x0609
            if (r14 == r15) goto L_0x05d2
            androidx.constraintlayout.solver.SolverVariable r1 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r2 = r9.mSolverVariable
            int r3 = r0.getMargin()
            r10.addEquality(r1, r2, r3, r6)
            r31 = r6
            r42 = r7
            r43 = r8
            r20 = r9
            goto L_0x0611
        L_0x05d2:
            if (r7 == 0) goto L_0x0600
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r3 = r9.mSolverVariable
            int r4 = r0.getMargin()
            androidx.constraintlayout.solver.SolverVariable r1 = r8.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r5 = r7.mSolverVariable
            int r27 = r8.getMargin()
            r28 = r1
            r1 = r46
            r20 = r5
            r5 = 1056964608(0x3f000000, float:0.5)
            r31 = r6
            r6 = r28
            r42 = r7
            r7 = r20
            r43 = r8
            r8 = r27
            r20 = r9
            r9 = r31
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x0611
        L_0x0600:
            r31 = r6
            r42 = r7
            r43 = r8
            r20 = r9
            goto L_0x0611
        L_0x0609:
            r31 = r6
            r42 = r7
            r43 = r8
            r20 = r9
        L_0x0611:
            r1 = r42
            if (r1 == 0) goto L_0x0628
            if (r14 == r15) goto L_0x0628
            r2 = r43
            androidx.constraintlayout.solver.SolverVariable r3 = r2.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r4 = r1.mSolverVariable
            int r5 = r2.getMargin()
            int r5 = -r5
            r6 = r31
            r10.addEquality(r3, r4, r5, r6)
            goto L_0x062c
        L_0x0628:
            r6 = r31
            r2 = r43
        L_0x062c:
            r31 = r38
        L_0x062e:
            if (r23 != 0) goto L_0x0632
            if (r19 == 0) goto L_0x06a6
        L_0x0632:
            if (r14 == 0) goto L_0x06a6
            if (r14 == r15) goto L_0x06a6
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r14.mListAnchors
            r1 = r0[r48]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r15.mListAnchors
            int r3 = r48 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r1.mTarget
            if (r3 == 0) goto L_0x0647
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x0648
        L_0x0647:
            r3 = 0
        L_0x0648:
            r17 = r3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r2.mTarget
            if (r3 == 0) goto L_0x0651
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x0652
        L_0x0651:
            r3 = 0
        L_0x0652:
            if (r13 == r15) goto L_0x0666
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r13.mListAnchors
            int r5 = r48 + 1
            r4 = r4[r5]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r4.mTarget
            if (r5 == 0) goto L_0x0661
            androidx.constraintlayout.solver.SolverVariable r5 = r5.mSolverVariable
            goto L_0x0662
        L_0x0661:
            r5 = 0
        L_0x0662:
            r3 = r5
            r20 = r3
            goto L_0x0668
        L_0x0666:
            r20 = r3
        L_0x0668:
            if (r14 != r15) goto L_0x0673
            r1 = r0[r48]
            int r3 = r48 + 1
            r2 = r0[r3]
            r0 = r1
            r9 = r2
            goto L_0x0675
        L_0x0673:
            r0 = r1
            r9 = r2
        L_0x0675:
            if (r17 == 0) goto L_0x06a4
            if (r20 == 0) goto L_0x06a4
            r24 = 1056964608(0x3f000000, float:0.5)
            int r27 = r0.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r15.mListAnchors
            int r2 = r48 + 1
            r1 = r1[r2]
            int r28 = r1.getMargin()
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r7 = r9.mSolverVariable
            r32 = 5
            r1 = r46
            r3 = r17
            r4 = r27
            r5 = r24
            r6 = r20
            r8 = r28
            r33 = r9
            r9 = r32
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x06a6
        L_0x06a4:
            r33 = r9
        L_0x06a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Chain.applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, androidx.constraintlayout.solver.LinearSystem, int, int, androidx.constraintlayout.solver.widgets.ChainHead):void");
    }
}
