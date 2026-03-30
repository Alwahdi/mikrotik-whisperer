package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyGraph;
import java.util.ArrayList;
import java.util.Arrays;

public class ConstraintWidgetContainer extends WidgetContainer {
    private static final boolean DEBUG = false;
    static final boolean DEBUG_GRAPH = false;
    private static final boolean DEBUG_LAYOUT = false;
    private static final int MAX_ITERATIONS = 8;
    BasicMeasure mBasicMeasureSolver = new BasicMeasure(this);
    int mDebugSolverPassCount = 0;
    public DependencyGraph mDependencyGraph = new DependencyGraph(this);
    public boolean mGroupsWrapOptimized = false;
    private boolean mHeightMeasuredTooSmall = false;
    ChainHead[] mHorizontalChainsArray = new ChainHead[4];
    int mHorizontalChainsSize = 0;
    public boolean mHorizontalWrapOptimized = false;
    private boolean mIsRtl = false;
    protected BasicMeasure.Measurer mMeasurer = null;
    public Metrics mMetrics;
    private int mOptimizationLevel = Optimizer.OPTIMIZATION_STANDARD;
    int mPaddingBottom;
    int mPaddingLeft;
    int mPaddingRight;
    int mPaddingTop;
    public boolean mSkipSolver = false;
    protected LinearSystem mSystem = new LinearSystem();
    ChainHead[] mVerticalChainsArray = new ChainHead[4];
    int mVerticalChainsSize = 0;
    public boolean mVerticalWrapOptimized = false;
    private boolean mWidthMeasuredTooSmall = false;
    public int mWrapFixedHeight = 0;
    public int mWrapFixedWidth = 0;

    public void invalidateGraph() {
        this.mDependencyGraph.invalidateGraph();
    }

    public void invalidateMeasures() {
        this.mDependencyGraph.invalidateMeasures();
    }

    public boolean directMeasure(boolean optimizeWrap) {
        return this.mDependencyGraph.directMeasure(optimizeWrap);
    }

    public boolean directMeasureSetup(boolean optimizeWrap) {
        return this.mDependencyGraph.directMeasureSetup(optimizeWrap);
    }

    public boolean directMeasureWithOrientation(boolean optimizeWrap, int orientation) {
        return this.mDependencyGraph.directMeasureWithOrientation(optimizeWrap, orientation);
    }

    public void defineTerminalWidgets() {
        this.mDependencyGraph.defineTerminalWidgets(getHorizontalDimensionBehaviour(), getVerticalDimensionBehaviour());
    }

    public long measure(int optimizationLevel, int widthMode, int widthSize, int heightMode, int heightSize, int lastMeasureWidth, int lastMeasureHeight, int paddingX, int paddingY) {
        this.mPaddingLeft = paddingX;
        this.mPaddingTop = paddingY;
        return this.mBasicMeasureSolver.solverMeasure(this, optimizationLevel, paddingX, paddingY, widthMode, widthSize, heightMode, heightSize, lastMeasureWidth, lastMeasureHeight);
    }

    public void updateHierarchy() {
        this.mBasicMeasureSolver.updateHierarchy(this);
    }

    public void setMeasurer(BasicMeasure.Measurer measurer) {
        this.mMeasurer = measurer;
        this.mDependencyGraph.setMeasurer(measurer);
    }

    public BasicMeasure.Measurer getMeasurer() {
        return this.mMeasurer;
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.mSystem.fillMetrics(metrics);
    }

    public ConstraintWidgetContainer() {
    }

    public ConstraintWidgetContainer(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public ConstraintWidgetContainer(int width, int height) {
        super(width, height);
    }

    public void setOptimizationLevel(int value) {
        this.mOptimizationLevel = value;
        LinearSystem.OPTIMIZED_ENGINE = Optimizer.enabled(value, 256);
    }

    public int getOptimizationLevel() {
        return this.mOptimizationLevel;
    }

    public boolean optimizeFor(int feature) {
        return (this.mOptimizationLevel & feature) == feature;
    }

    public String getType() {
        return "ConstraintLayout";
    }

    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mSkipSolver = false;
        super.reset();
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.mWidthMeasuredTooSmall;
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.mHeightMeasuredTooSmall;
    }

    public boolean addChildrenToSolver(LinearSystem system) {
        addToSolver(system);
        int count = this.mChildren.size();
        boolean hasBarriers = false;
        for (int i = 0; i < count; i++) {
            ConstraintWidget widget = this.mChildren.get(i);
            widget.setInBarrier(0, false);
            widget.setInBarrier(1, false);
            if (widget instanceof Barrier) {
                hasBarriers = true;
            }
        }
        if (hasBarriers) {
            for (int i2 = 0; i2 < count; i2++) {
                ConstraintWidget widget2 = this.mChildren.get(i2);
                if (widget2 instanceof Barrier) {
                    ((Barrier) widget2).markWidgets();
                }
            }
        }
        for (int i3 = 0; i3 < count; i3++) {
            ConstraintWidget widget3 = this.mChildren.get(i3);
            if (widget3.addFirst()) {
                widget3.addToSolver(system);
            }
        }
        for (int i4 = 0; i4 < count; i4++) {
            ConstraintWidget widget4 = this.mChildren.get(i4);
            if (widget4 instanceof ConstraintWidgetContainer) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = widget4.mListDimensionBehaviors;
                ConstraintWidget.DimensionBehaviour horizontalBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour verticalBehaviour = dimensionBehaviourArr[1];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (horizontalBehaviour == dimensionBehaviour) {
                    widget4.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                if (verticalBehaviour == dimensionBehaviour) {
                    widget4.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                widget4.addToSolver(system);
                if (horizontalBehaviour == dimensionBehaviour) {
                    widget4.setHorizontalDimensionBehaviour(horizontalBehaviour);
                }
                if (verticalBehaviour == dimensionBehaviour) {
                    widget4.setVerticalDimensionBehaviour(verticalBehaviour);
                }
            } else {
                Optimizer.checkMatchParent(this, system, widget4);
                if (!widget4.addFirst()) {
                    widget4.addToSolver(system);
                }
            }
        }
        if (this.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(this, system, 0);
        }
        if (this.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(this, system, 1);
        }
        return true;
    }

    public void updateChildrenFromSolver(LinearSystem system, boolean[] flags) {
        flags[2] = false;
        updateFromSolver(system);
        int count = this.mChildren.size();
        for (int i = 0; i < count; i++) {
            this.mChildren.get(i).updateFromSolver(system);
        }
    }

    public void updateFromRuns(boolean updateHorizontal, boolean updateVertical) {
        super.updateFromRuns(updateHorizontal, updateVertical);
        int count = this.mChildren.size();
        for (int i = 0; i < count; i++) {
            this.mChildren.get(i).updateFromRuns(updateHorizontal, updateVertical);
        }
    }

    public void setPadding(int left, int top, int right, int bottom) {
        this.mPaddingLeft = left;
        this.mPaddingTop = top;
        this.mPaddingRight = right;
        this.mPaddingBottom = bottom;
    }

    public void setRtl(boolean isRtl) {
        this.mIsRtl = isRtl;
    }

    public boolean isRtl() {
        return this.mIsRtl;
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void layout() {
        /*
            r21 = this;
            r1 = r21
            r2 = 0
            r1.mX = r2
            r1.mY = r2
            int r0 = r21.getWidth()
            int r3 = java.lang.Math.max(r2, r0)
            int r0 = r21.getHeight()
            int r4 = java.lang.Math.max(r2, r0)
            r1.mWidthMeasuredTooSmall = r2
            r1.mHeightMeasuredTooSmall = r2
            r0 = 64
            boolean r0 = r1.optimizeFor(r0)
            r5 = 1
            if (r0 != 0) goto L_0x002f
            r0 = 128(0x80, float:1.794E-43)
            boolean r0 = r1.optimizeFor(r0)
            if (r0 == 0) goto L_0x002d
            goto L_0x002f
        L_0x002d:
            r0 = 0
            goto L_0x0030
        L_0x002f:
            r0 = 1
        L_0x0030:
            r6 = r0
            androidx.constraintlayout.solver.LinearSystem r0 = r1.mSystem
            r0.graphOptimizer = r2
            r0.newgraphOptimizer = r2
            int r7 = r1.mOptimizationLevel
            if (r7 == 0) goto L_0x003f
            if (r6 == 0) goto L_0x003f
            r0.newgraphOptimizer = r5
        L_0x003f:
            r0 = 0
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r7 = r1.mListDimensionBehaviors
            r8 = r7[r5]
            r7 = r7[r2]
            r9 = 0
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r10 = r1.mChildren
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = r21.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r11 == r12) goto L_0x005a
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = r21.getVerticalDimensionBehaviour()
            if (r11 != r12) goto L_0x0058
            goto L_0x005a
        L_0x0058:
            r11 = 0
            goto L_0x005b
        L_0x005a:
            r11 = 1
        L_0x005b:
            r21.resetChains()
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r12 = r1.mChildren
            int r12 = r12.size()
            r9 = 0
            r13 = 0
        L_0x0066:
            if (r13 >= r12) goto L_0x007d
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r14 = r1.mChildren
            java.lang.Object r14 = r14.get(r13)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r14 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r14
            boolean r15 = r14 instanceof androidx.constraintlayout.solver.widgets.WidgetContainer
            if (r15 == 0) goto L_0x007a
            r15 = r14
            androidx.constraintlayout.solver.widgets.WidgetContainer r15 = (androidx.constraintlayout.solver.widgets.WidgetContainer) r15
            r15.layout()
        L_0x007a:
            int r13 = r13 + 1
            goto L_0x0066
        L_0x007d:
            r13 = 1
            r20 = r9
            r9 = r0
            r0 = r20
        L_0x0083:
            if (r13 == 0) goto L_0x01ef
            int r14 = r0 + 1
            androidx.constraintlayout.solver.LinearSystem r0 = r1.mSystem     // Catch:{ Exception -> 0x00b7 }
            r0.reset()     // Catch:{ Exception -> 0x00b7 }
            r21.resetChains()     // Catch:{ Exception -> 0x00b7 }
            androidx.constraintlayout.solver.LinearSystem r0 = r1.mSystem     // Catch:{ Exception -> 0x00b7 }
            r1.createObjectVariables(r0)     // Catch:{ Exception -> 0x00b7 }
            r0 = 0
        L_0x0095:
            if (r0 >= r12) goto L_0x00a8
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r15 = r1.mChildren     // Catch:{ Exception -> 0x00b7 }
            java.lang.Object r15 = r15.get(r0)     // Catch:{ Exception -> 0x00b7 }
            androidx.constraintlayout.solver.widgets.ConstraintWidget r15 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r15     // Catch:{ Exception -> 0x00b7 }
            androidx.constraintlayout.solver.LinearSystem r5 = r1.mSystem     // Catch:{ Exception -> 0x00b7 }
            r15.createObjectVariables(r5)     // Catch:{ Exception -> 0x00b7 }
            int r0 = r0 + 1
            r5 = 1
            goto L_0x0095
        L_0x00a8:
            androidx.constraintlayout.solver.LinearSystem r0 = r1.mSystem     // Catch:{ Exception -> 0x00b7 }
            boolean r0 = r1.addChildrenToSolver(r0)     // Catch:{ Exception -> 0x00b7 }
            r13 = r0
            if (r13 == 0) goto L_0x00b6
            androidx.constraintlayout.solver.LinearSystem r0 = r1.mSystem     // Catch:{ Exception -> 0x00b7 }
            r0.minimize()     // Catch:{ Exception -> 0x00b7 }
        L_0x00b6:
            goto L_0x00d1
        L_0x00b7:
            r0 = move-exception
            r0.printStackTrace()
            java.io.PrintStream r5 = java.lang.System.out
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r2 = "EXCEPTION : "
            r15.append(r2)
            r15.append(r0)
            java.lang.String r2 = r15.toString()
            r5.println(r2)
        L_0x00d1:
            if (r13 == 0) goto L_0x00db
            androidx.constraintlayout.solver.LinearSystem r0 = r1.mSystem
            boolean[] r2 = androidx.constraintlayout.solver.widgets.Optimizer.flags
            r1.updateChildrenFromSolver(r0, r2)
            goto L_0x00f3
        L_0x00db:
            androidx.constraintlayout.solver.LinearSystem r0 = r1.mSystem
            r1.updateFromSolver(r0)
            r0 = 0
        L_0x00e1:
            if (r0 >= r12) goto L_0x00f3
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r2 = r1.mChildren
            java.lang.Object r2 = r2.get(r0)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r2
            androidx.constraintlayout.solver.LinearSystem r5 = r1.mSystem
            r2.updateFromSolver(r5)
            int r0 = r0 + 1
            goto L_0x00e1
        L_0x00f3:
            r0 = 0
            if (r11 == 0) goto L_0x0165
            r2 = 8
            if (r14 >= r2) goto L_0x0165
            boolean[] r2 = androidx.constraintlayout.solver.widgets.Optimizer.flags
            r5 = 2
            boolean r2 = r2[r5]
            if (r2 == 0) goto L_0x0165
            r2 = 0
            r5 = 0
            r13 = 0
        L_0x0104:
            if (r13 >= r12) goto L_0x012d
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r15 = r1.mChildren
            java.lang.Object r15 = r15.get(r13)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r15 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r15
            r18 = r0
            int r0 = r15.mX
            int r19 = r15.getWidth()
            int r0 = r0 + r19
            int r2 = java.lang.Math.max(r2, r0)
            int r0 = r15.mY
            int r19 = r15.getHeight()
            int r0 = r0 + r19
            int r5 = java.lang.Math.max(r5, r0)
            int r13 = r13 + 1
            r0 = r18
            goto L_0x0104
        L_0x012d:
            r18 = r0
            int r0 = r1.mMinWidth
            int r0 = java.lang.Math.max(r0, r2)
            int r2 = r1.mMinHeight
            int r2 = java.lang.Math.max(r2, r5)
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r7 != r5) goto L_0x0151
            int r13 = r21.getWidth()
            if (r13 >= r0) goto L_0x0151
            r1.setWidth(r0)
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r13 = r1.mListDimensionBehaviors
            r15 = 0
            r13[r15] = r5
            r9 = 1
            r13 = 1
            r18 = r13
        L_0x0151:
            if (r8 != r5) goto L_0x0167
            int r13 = r21.getHeight()
            if (r13 >= r2) goto L_0x0167
            r1.setHeight(r2)
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r13 = r1.mListDimensionBehaviors
            r15 = 1
            r13[r15] = r5
            r9 = 1
            r5 = 1
            r0 = r5
            goto L_0x0169
        L_0x0165:
            r18 = r0
        L_0x0167:
            r0 = r18
        L_0x0169:
            int r2 = r1.mMinWidth
            int r5 = r21.getWidth()
            int r2 = java.lang.Math.max(r2, r5)
            int r5 = r21.getWidth()
            if (r2 <= r5) goto L_0x0185
            r1.setWidth(r2)
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r1.mListDimensionBehaviors
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r15 = 0
            r5[r15] = r13
            r9 = 1
            r0 = 1
        L_0x0185:
            int r5 = r1.mMinHeight
            int r13 = r21.getHeight()
            int r5 = java.lang.Math.max(r5, r13)
            int r13 = r21.getHeight()
            if (r5 <= r13) goto L_0x01a2
            r1.setHeight(r5)
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r13 = r1.mListDimensionBehaviors
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r16 = 1
            r13[r16] = r15
            r9 = 1
            r0 = 1
        L_0x01a2:
            if (r9 != 0) goto L_0x01e7
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r13 = r1.mListDimensionBehaviors
            r15 = 0
            r13 = r13[r15]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r13 != r15) goto L_0x01c5
            if (r3 <= 0) goto L_0x01c5
            int r13 = r21.getWidth()
            if (r13 <= r3) goto L_0x01c5
            r13 = 1
            r1.mWidthMeasuredTooSmall = r13
            r9 = 1
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r13 = r1.mListDimensionBehaviors
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r18 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r17 = 0
            r13[r17] = r18
            r1.setWidth(r3)
            r0 = 1
        L_0x01c5:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r13 = r1.mListDimensionBehaviors
            r18 = r2
            r2 = 1
            r13 = r13[r2]
            if (r13 != r15) goto L_0x01e5
            if (r4 <= 0) goto L_0x01e5
            int r13 = r21.getHeight()
            if (r13 <= r4) goto L_0x01e5
            r1.mHeightMeasuredTooSmall = r2
            r9 = 1
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r13 = r1.mListDimensionBehaviors
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r13[r2] = r15
            r1.setHeight(r4)
            r0 = 1
            r13 = r0
            goto L_0x01ea
        L_0x01e5:
            r13 = r0
            goto L_0x01ea
        L_0x01e7:
            r18 = r2
            r13 = r0
        L_0x01ea:
            r0 = r14
            r2 = 0
            r5 = 1
            goto L_0x0083
        L_0x01ef:
            r1.mChildren = r10
            if (r9 == 0) goto L_0x01fb
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r1.mListDimensionBehaviors
            r5 = 0
            r2[r5] = r7
            r5 = 1
            r2[r5] = r8
        L_0x01fb:
            androidx.constraintlayout.solver.LinearSystem r2 = r1.mSystem
            androidx.constraintlayout.solver.Cache r2 = r2.getCache()
            r1.resetSolverVariables(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer.layout():void");
    }

    public boolean handlesInternalConstraints() {
        return false;
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        ArrayList<Guideline> guidelines = new ArrayList<>();
        int mChildrenSize = this.mChildren.size();
        for (int i = 0; i < mChildrenSize; i++) {
            ConstraintWidget widget = this.mChildren.get(i);
            if (widget instanceof Guideline) {
                Guideline guideline = (Guideline) widget;
                if (guideline.getOrientation() == 1) {
                    guidelines.add(guideline);
                }
            }
        }
        return guidelines;
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        ArrayList<Guideline> guidelines = new ArrayList<>();
        int mChildrenSize = this.mChildren.size();
        for (int i = 0; i < mChildrenSize; i++) {
            ConstraintWidget widget = this.mChildren.get(i);
            if (widget instanceof Guideline) {
                Guideline guideline = (Guideline) widget;
                if (guideline.getOrientation() == 0) {
                    guidelines.add(guideline);
                }
            }
        }
        return guidelines;
    }

    public LinearSystem getSystem() {
        return this.mSystem;
    }

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    /* access modifiers changed from: package-private */
    public void addChain(ConstraintWidget constraintWidget, int type) {
        ConstraintWidget widget = constraintWidget;
        if (type == 0) {
            addHorizontalChain(widget);
        } else if (type == 1) {
            addVerticalChain(widget);
        }
    }

    private void addHorizontalChain(ConstraintWidget widget) {
        int i = this.mHorizontalChainsSize + 1;
        ChainHead[] chainHeadArr = this.mHorizontalChainsArray;
        if (i >= chainHeadArr.length) {
            this.mHorizontalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(widget, 0, isRtl());
        this.mHorizontalChainsSize++;
    }

    private void addVerticalChain(ConstraintWidget widget) {
        int i = this.mVerticalChainsSize + 1;
        ChainHead[] chainHeadArr = this.mVerticalChainsArray;
        if (i >= chainHeadArr.length) {
            this.mVerticalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(widget, 1, isRtl());
        this.mVerticalChainsSize++;
    }
}
