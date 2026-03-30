package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ConstraintWidget {
    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    private static final boolean USE_WRAP_DIMENSION_FOR_SPREAD = false;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    private boolean hasBaseline;
    public ChainRun horizontalChainRun;
    public HorizontalWidgetRun horizontalRun;
    private boolean inPlaceholder;
    public boolean[] isTerminalWidget;
    protected ArrayList<ConstraintAnchor> mAnchors;
    ConstraintAnchor mBaseline;
    int mBaselineDistance;
    public ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    public float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    boolean mGroupsToSolver;
    int mHeight;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    boolean mHorizontalWrapVisited;
    private boolean mInVirtuaLayout;
    public boolean mIsHeightWrapContent;
    private boolean[] mIsInBarrier;
    public boolean mIsWidthWrapContent;
    public ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight;
    public int mMatchConstraintDefaultWidth;
    public int mMatchConstraintMaxHeight;
    public int mMatchConstraintMaxWidth;
    public int mMatchConstraintMinHeight;
    public int mMatchConstraintMinWidth;
    public float mMatchConstraintPercentHeight;
    public float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    boolean mOptimizerMeasurable;
    public ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    boolean mResolvedHasRatio;
    public int[] mResolvedMatchConstraintDefault;
    public ConstraintAnchor mRight;
    boolean mRightHasCentered;
    public ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    public float[] mWeight;
    int mWidth;
    protected int mX;
    protected int mY;
    public boolean measured;
    public WidgetRun[] run;
    public ChainRun verticalChainRun;
    public VerticalWidgetRun verticalRun;
    public int[] wrapMeasure;

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public WidgetRun getRun(int orientation) {
        if (orientation == 0) {
            return this.horizontalRun;
        }
        if (orientation == 1) {
            return this.verticalRun;
        }
        return null;
    }

    public boolean isInVirtualLayout() {
        return this.mInVirtuaLayout;
    }

    public void setInVirtualLayout(boolean inVirtualLayout) {
        this.mInVirtuaLayout = inVirtualLayout;
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public void setMaxWidth(int maxWidth) {
        this.mMaxDimension[0] = maxWidth;
    }

    public void setMaxHeight(int maxHeight) {
        this.mMaxDimension[1] = maxHeight;
    }

    public boolean isSpreadWidth() {
        return this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isSpreadHeight() {
        return this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public void setHasBaseline(boolean hasBaseline2) {
        this.hasBaseline = hasBaseline2;
    }

    public boolean getHasBaseline() {
        return this.hasBaseline;
    }

    public boolean isInPlaceholder() {
        return this.inPlaceholder;
    }

    public void setInPlaceholder(boolean inPlaceholder2) {
        this.inPlaceholder = inPlaceholder2;
    }

    /* access modifiers changed from: protected */
    public void setInBarrier(int orientation, boolean value) {
        this.mIsInBarrier[orientation] = value;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.mMaxDimension;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedHasRatio = false;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mOptimizerMeasurable = false;
        this.mGroupsToSolver = false;
        boolean[] zArr = this.isTerminalWidget;
        zArr[0] = true;
        zArr[1] = true;
        this.mInVirtuaLayout = false;
        boolean[] zArr2 = this.mIsInBarrier;
        zArr2[0] = false;
        zArr2[1] = false;
    }

    public ConstraintWidget() {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = new HorizontalWidgetRun(this);
        this.verticalRun = new VerticalWidgetRun(this);
        this.isTerminalWidget = new boolean[]{true, true};
        this.wrapMeasure = new int[]{0, 0, 0, 0};
        this.mResolvedHasRatio = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        addAnchors();
    }

    public ConstraintWidget(int x, int y, int width, int height) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = new HorizontalWidgetRun(this);
        this.verticalRun = new VerticalWidgetRun(this);
        this.isTerminalWidget = new boolean[]{true, true};
        this.wrapMeasure = new int[]{0, 0, 0, 0};
        this.mResolvedHasRatio = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.mX = x;
        this.mY = y;
        this.mWidth = width;
        this.mHeight = height;
        addAnchors();
    }

    public ConstraintWidget(int width, int height) {
        this(0, 0, width, height);
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    public boolean isRoot() {
        return this.mParent == null;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public void setParent(ConstraintWidget widget) {
        this.mParent = widget;
    }

    public void setWidthWrapContent(boolean widthWrapContent) {
        this.mIsWidthWrapContent = widthWrapContent;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void setHeightWrapContent(boolean heightWrapContent) {
        this.mIsHeightWrapContent = heightWrapContent;
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public void connectCircularConstraint(ConstraintWidget target, float angle, int radius) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        immediateConnect(type, target, type, radius, 0);
        this.mCircleConstraintAngle = angle;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String type) {
        this.mType = type;
    }

    public void setVisibility(int visibility) {
        this.mVisibility = visibility;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public void setDebugName(String name) {
        this.mDebugName = name;
    }

    public void setDebugSolverName(LinearSystem system, String name) {
        this.mDebugName = name;
        SolverVariable left = system.createObjectVariable(this.mLeft);
        SolverVariable top = system.createObjectVariable(this.mTop);
        SolverVariable right = system.createObjectVariable(this.mRight);
        SolverVariable bottom = system.createObjectVariable(this.mBottom);
        left.setName(name + ".left");
        top.setName(name + ".top");
        right.setName(name + ".right");
        bottom.setName(name + ".bottom");
        if (this.mBaselineDistance > 0) {
            SolverVariable baseline = system.createObjectVariable(this.mBaseline);
            baseline.setName(name + ".baseline");
        }
    }

    public void createObjectVariables(LinearSystem system) {
        SolverVariable createObjectVariable = system.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = system.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable3 = system.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable4 = system.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            system.createObjectVariable(this.mBaseline);
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.mType != null) {
            str = "type: " + this.mType + " ";
        } else {
            str = str2;
        }
        sb.append(str);
        if (this.mDebugName != null) {
            str2 = "id: " + this.mDebugName + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.mX);
        sb.append(", ");
        sb.append(this.mY);
        sb.append(") - (");
        sb.append(this.mWidth);
        sb.append(" x ");
        sb.append(this.mHeight);
        sb.append(")");
        return sb.toString();
    }

    public int getX() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.mX;
        }
        return ((ConstraintWidgetContainer) constraintWidget).mPaddingLeft + this.mX;
    }

    public int getY() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.mY;
        }
        return ((ConstraintWidgetContainer) constraintWidget).mPaddingTop + this.mY;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getOptimizerWrapWidth() {
        int w;
        int w2 = this.mWidth;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return w2;
        }
        if (this.mMatchConstraintDefaultWidth == 1) {
            w = Math.max(this.mMatchConstraintMinWidth, w2);
        } else if (this.mMatchConstraintMinWidth > 0) {
            w = this.mMatchConstraintMinWidth;
            this.mWidth = w;
        } else {
            w = 0;
        }
        int i = this.mMatchConstraintMaxWidth;
        if (i <= 0 || i >= w) {
            return w;
        }
        return this.mMatchConstraintMaxWidth;
    }

    public int getOptimizerWrapHeight() {
        int h;
        int h2 = this.mHeight;
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return h2;
        }
        if (this.mMatchConstraintDefaultHeight == 1) {
            h = Math.max(this.mMatchConstraintMinHeight, h2);
        } else if (this.mMatchConstraintMinHeight > 0) {
            h = this.mMatchConstraintMinHeight;
            this.mHeight = h;
        } else {
            h = 0;
        }
        int i = this.mMatchConstraintMaxHeight;
        if (i <= 0 || i >= h) {
            return h;
        }
        return this.mMatchConstraintMaxHeight;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public int getLength(int orientation) {
        if (orientation == 0) {
            return getWidth();
        }
        if (orientation == 1) {
            return getHeight();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getRootX() {
        return this.mX + this.mOffsetX;
    }

    /* access modifiers changed from: protected */
    public int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getLeft() {
        return getX();
    }

    public int getTop() {
        return getY();
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public int getHorizontalMargin() {
        int margin = 0;
        ConstraintAnchor constraintAnchor = this.mLeft;
        if (constraintAnchor != null) {
            margin = 0 + constraintAnchor.mMargin;
        }
        ConstraintAnchor constraintAnchor2 = this.mRight;
        if (constraintAnchor2 != null) {
            return margin + constraintAnchor2.mMargin;
        }
        return margin;
    }

    public int getVerticalMargin() {
        int margin = 0;
        if (this.mLeft != null) {
            margin = 0 + this.mTop.mMargin;
        }
        if (this.mRight != null) {
            return margin + this.mBottom.mMargin;
        }
        return margin;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public float getBiasPercent(int orientation) {
        if (orientation == 0) {
            return this.mHorizontalBiasPercent;
        }
        if (orientation == 1) {
            return this.mVerticalBiasPercent;
        }
        return -1.0f;
    }

    public boolean hasBaseline() {
        return this.hasBaseline;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public void setX(int x) {
        this.mX = x;
    }

    public void setY(int y) {
        this.mY = y;
    }

    public void setOrigin(int x, int y) {
        this.mX = x;
        this.mY = y;
    }

    public void setOffset(int x, int y) {
        this.mOffsetX = x;
        this.mOffsetY = y;
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int goneMargin) {
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type.ordinal()]) {
            case 1:
                this.mLeft.mGoneMargin = goneMargin;
                return;
            case 2:
                this.mTop.mGoneMargin = goneMargin;
                return;
            case 3:
                this.mRight.mGoneMargin = goneMargin;
                return;
            case 4:
                this.mBottom.mGoneMargin = goneMargin;
                return;
            default:
                return;
        }
    }

    public void setWidth(int w) {
        this.mWidth = w;
        int i = this.mMinWidth;
        if (w < i) {
            this.mWidth = i;
        }
    }

    public void setHeight(int h) {
        this.mHeight = h;
        int i = this.mMinHeight;
        if (h < i) {
            this.mHeight = i;
        }
    }

    public void setLength(int length, int orientation) {
        if (orientation == 0) {
            setWidth(length);
        } else if (orientation == 1) {
            setHeight(length);
        }
    }

    public void setHorizontalMatchStyle(int horizontalMatchStyle, int min, int max, float percent) {
        this.mMatchConstraintDefaultWidth = horizontalMatchStyle;
        this.mMatchConstraintMinWidth = min;
        this.mMatchConstraintMaxWidth = max == Integer.MAX_VALUE ? 0 : max;
        this.mMatchConstraintPercentWidth = percent;
        if (percent > 0.0f && percent < 1.0f && horizontalMatchStyle == 0) {
            this.mMatchConstraintDefaultWidth = 2;
        }
    }

    public void setVerticalMatchStyle(int verticalMatchStyle, int min, int max, float percent) {
        this.mMatchConstraintDefaultHeight = verticalMatchStyle;
        this.mMatchConstraintMinHeight = min;
        this.mMatchConstraintMaxHeight = max == Integer.MAX_VALUE ? 0 : max;
        this.mMatchConstraintPercentHeight = percent;
        if (percent > 0.0f && percent < 1.0f && verticalMatchStyle == 0) {
            this.mMatchConstraintDefaultHeight = 2;
        }
    }

    public void setDimensionRatio(String ratio) {
        int commaIndex;
        if (ratio == null || ratio.length() == 0) {
            this.mDimensionRatio = 0.0f;
            return;
        }
        int dimensionRatioSide = -1;
        float dimensionRatio = 0.0f;
        int len = ratio.length();
        int commaIndex2 = ratio.indexOf(44);
        if (commaIndex2 <= 0 || commaIndex2 >= len - 1) {
            commaIndex = 0;
        } else {
            String dimension = ratio.substring(0, commaIndex2);
            if (dimension.equalsIgnoreCase("W")) {
                dimensionRatioSide = 0;
            } else if (dimension.equalsIgnoreCase("H")) {
                dimensionRatioSide = 1;
            }
            commaIndex = commaIndex2 + 1;
        }
        int colonIndex = ratio.indexOf(58);
        if (colonIndex < 0 || colonIndex >= len - 1) {
            String r = ratio.substring(commaIndex);
            if (r.length() > 0) {
                try {
                    dimensionRatio = Float.parseFloat(r);
                } catch (NumberFormatException e) {
                }
            }
        } else {
            String nominator = ratio.substring(commaIndex, colonIndex);
            String denominator = ratio.substring(colonIndex + 1);
            if (nominator.length() > 0 && denominator.length() > 0) {
                try {
                    float nominatorValue = Float.parseFloat(nominator);
                    float denominatorValue = Float.parseFloat(denominator);
                    if (nominatorValue > 0.0f && denominatorValue > 0.0f) {
                        dimensionRatio = dimensionRatioSide == 1 ? Math.abs(denominatorValue / nominatorValue) : Math.abs(nominatorValue / denominatorValue);
                    }
                } catch (NumberFormatException e2) {
                }
            }
        }
        if (dimensionRatio > 0.0f) {
            this.mDimensionRatio = dimensionRatio;
            this.mDimensionRatioSide = dimensionRatioSide;
        }
    }

    public void setDimensionRatio(float ratio, int dimensionRatioSide) {
        this.mDimensionRatio = ratio;
        this.mDimensionRatioSide = dimensionRatioSide;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public void setHorizontalBiasPercent(float horizontalBiasPercent) {
        this.mHorizontalBiasPercent = horizontalBiasPercent;
    }

    public void setVerticalBiasPercent(float verticalBiasPercent) {
        this.mVerticalBiasPercent = verticalBiasPercent;
    }

    public void setMinWidth(int w) {
        if (w < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = w;
        }
    }

    public void setMinHeight(int h) {
        if (h < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = h;
        }
    }

    public void setDimension(int w, int h) {
        this.mWidth = w;
        int i = this.mMinWidth;
        if (w < i) {
            this.mWidth = i;
        }
        this.mHeight = h;
        int i2 = this.mMinHeight;
        if (h < i2) {
            this.mHeight = i2;
        }
    }

    public void setFrame(int left, int top, int right, int bottom) {
        int w = right - left;
        int h = bottom - top;
        this.mX = left;
        this.mY = top;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && w < this.mWidth) {
            w = this.mWidth;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && h < this.mHeight) {
            h = this.mHeight;
        }
        this.mWidth = w;
        this.mHeight = h;
        int i = this.mMinHeight;
        if (h < i) {
            this.mHeight = i;
        }
        int i2 = this.mMinWidth;
        if (w < i2) {
            this.mWidth = i2;
        }
    }

    public void setFrame(int start, int end, int orientation) {
        if (orientation == 0) {
            setHorizontalDimension(start, end);
        } else if (orientation == 1) {
            setVerticalDimension(start, end);
        }
    }

    public void setHorizontalDimension(int left, int right) {
        this.mX = left;
        int i = right - left;
        this.mWidth = i;
        int i2 = this.mMinWidth;
        if (i < i2) {
            this.mWidth = i2;
        }
    }

    public void setVerticalDimension(int top, int bottom) {
        this.mY = top;
        int i = bottom - top;
        this.mHeight = i;
        int i2 = this.mMinHeight;
        if (i < i2) {
            this.mHeight = i2;
        }
    }

    /* access modifiers changed from: package-private */
    public int getRelativePositioning(int orientation) {
        if (orientation == 0) {
            return this.mRelX;
        }
        if (orientation == 1) {
            return this.mRelY;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void setRelativePositioning(int offset, int orientation) {
        if (orientation == 0) {
            this.mRelX = offset;
        } else if (orientation == 1) {
            this.mRelY = offset;
        }
    }

    public void setBaselineDistance(int baseline) {
        this.mBaselineDistance = baseline;
        this.hasBaseline = baseline > 0;
    }

    public void setCompanionWidget(Object companion) {
        this.mCompanionWidget = companion;
    }

    public void setContainerItemSkip(int skip) {
        if (skip >= 0) {
            this.mContainerItemSkip = skip;
        } else {
            this.mContainerItemSkip = 0;
        }
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public void setHorizontalWeight(float horizontalWeight) {
        this.mWeight[0] = horizontalWeight;
    }

    public void setVerticalWeight(float verticalWeight) {
        this.mWeight[1] = verticalWeight;
    }

    public void setHorizontalChainStyle(int horizontalChainStyle) {
        this.mHorizontalChainStyle = horizontalChainStyle;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public void setVerticalChainStyle(int verticalChainStyle) {
        this.mVerticalChainStyle = verticalChainStyle;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    public void immediateConnect(ConstraintAnchor.Type startType, ConstraintWidget target, ConstraintAnchor.Type endType, int margin, int goneMargin) {
        getAnchor(startType).connect(target.getAnchor(endType), margin, goneMargin, true);
    }

    public void connect(ConstraintAnchor from, ConstraintAnchor to, int margin) {
        if (from.getOwner() == this) {
            connect(from.getType(), to.getOwner(), to.getType(), margin);
        }
    }

    public void connect(ConstraintAnchor.Type constraintFrom, ConstraintWidget target, ConstraintAnchor.Type constraintTo) {
        connect(constraintFrom, target, constraintTo, 0);
    }

    public void connect(ConstraintAnchor.Type constraintFrom, ConstraintWidget target, ConstraintAnchor.Type constraintTo, int margin) {
        int margin2;
        ConstraintAnchor.Type type;
        ConstraintAnchor.Type type2;
        ConstraintAnchor.Type type3 = constraintFrom;
        ConstraintWidget constraintWidget = target;
        ConstraintAnchor.Type type4 = constraintTo;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.CENTER;
        if (type3 != type5) {
            ConstraintAnchor.Type type6 = ConstraintAnchor.Type.CENTER_X;
            if (type3 == type6 && (type4 == (type2 = ConstraintAnchor.Type.LEFT) || type4 == ConstraintAnchor.Type.RIGHT)) {
                ConstraintAnchor left = getAnchor(type2);
                ConstraintAnchor targetAnchor = target.getAnchor(constraintTo);
                ConstraintAnchor right = getAnchor(ConstraintAnchor.Type.RIGHT);
                left.connect(targetAnchor, 0);
                right.connect(targetAnchor, 0);
                getAnchor(type6).connect(targetAnchor, 0);
            } else {
                ConstraintAnchor.Type type7 = ConstraintAnchor.Type.CENTER_Y;
                if (type3 == type7 && (type4 == (type = ConstraintAnchor.Type.TOP) || type4 == ConstraintAnchor.Type.BOTTOM)) {
                    ConstraintAnchor targetAnchor2 = target.getAnchor(constraintTo);
                    getAnchor(type).connect(targetAnchor2, 0);
                    getAnchor(ConstraintAnchor.Type.BOTTOM).connect(targetAnchor2, 0);
                    getAnchor(type7).connect(targetAnchor2, 0);
                } else if (type3 == type6 && type4 == type6) {
                    ConstraintAnchor.Type type8 = ConstraintAnchor.Type.LEFT;
                    getAnchor(type8).connect(constraintWidget.getAnchor(type8), 0);
                    ConstraintAnchor.Type type9 = ConstraintAnchor.Type.RIGHT;
                    getAnchor(type9).connect(constraintWidget.getAnchor(type9), 0);
                    getAnchor(type6).connect(target.getAnchor(constraintTo), 0);
                } else if (type3 == type7 && type4 == type7) {
                    ConstraintAnchor.Type type10 = ConstraintAnchor.Type.TOP;
                    getAnchor(type10).connect(constraintWidget.getAnchor(type10), 0);
                    ConstraintAnchor.Type type11 = ConstraintAnchor.Type.BOTTOM;
                    getAnchor(type11).connect(constraintWidget.getAnchor(type11), 0);
                    getAnchor(type7).connect(target.getAnchor(constraintTo), 0);
                } else {
                    ConstraintAnchor fromAnchor = getAnchor(constraintFrom);
                    ConstraintAnchor toAnchor = target.getAnchor(constraintTo);
                    if (fromAnchor.isValidConnection(toAnchor)) {
                        ConstraintAnchor.Type type12 = ConstraintAnchor.Type.BASELINE;
                        if (type3 == type12) {
                            ConstraintAnchor top = getAnchor(ConstraintAnchor.Type.TOP);
                            ConstraintAnchor bottom = getAnchor(ConstraintAnchor.Type.BOTTOM);
                            if (top != null) {
                                top.reset();
                            }
                            if (bottom != null) {
                                bottom.reset();
                            }
                            margin2 = 0;
                        } else {
                            if (type3 == ConstraintAnchor.Type.TOP || type3 == ConstraintAnchor.Type.BOTTOM) {
                                ConstraintAnchor centerX = getAnchor(type12);
                                if (centerX != null) {
                                    centerX.reset();
                                }
                                ConstraintAnchor center = getAnchor(type5);
                                if (center.getTarget() != toAnchor) {
                                    center.reset();
                                }
                                ConstraintAnchor opposite = getAnchor(constraintFrom).getOpposite();
                                ConstraintAnchor centerY = getAnchor(type7);
                                if (centerY.isConnected()) {
                                    opposite.reset();
                                    centerY.reset();
                                }
                            } else if (type3 == ConstraintAnchor.Type.LEFT || type3 == ConstraintAnchor.Type.RIGHT) {
                                ConstraintAnchor center2 = getAnchor(type5);
                                if (center2.getTarget() != toAnchor) {
                                    center2.reset();
                                }
                                ConstraintAnchor opposite2 = getAnchor(constraintFrom).getOpposite();
                                ConstraintAnchor centerX2 = getAnchor(type6);
                                if (centerX2.isConnected()) {
                                    opposite2.reset();
                                    centerX2.reset();
                                }
                            }
                            margin2 = margin;
                        }
                        fromAnchor.connect(toAnchor, margin2);
                        return;
                    }
                }
            }
        } else if (type4 == type5) {
            ConstraintAnchor.Type type13 = ConstraintAnchor.Type.LEFT;
            ConstraintAnchor left2 = getAnchor(type13);
            ConstraintAnchor.Type type14 = ConstraintAnchor.Type.RIGHT;
            ConstraintAnchor right2 = getAnchor(type14);
            ConstraintAnchor.Type type15 = ConstraintAnchor.Type.TOP;
            ConstraintAnchor top2 = getAnchor(type15);
            ConstraintAnchor.Type type16 = ConstraintAnchor.Type.BOTTOM;
            ConstraintAnchor bottom2 = getAnchor(type16);
            boolean centerX3 = false;
            boolean centerY2 = false;
            if ((left2 == null || !left2.isConnected()) && (right2 == null || !right2.isConnected())) {
                connect(type13, constraintWidget, type13, 0);
                connect(type14, constraintWidget, type14, 0);
                centerX3 = true;
            }
            if ((top2 == null || !top2.isConnected()) && (bottom2 == null || !bottom2.isConnected())) {
                connect(type15, constraintWidget, type15, 0);
                connect(type16, constraintWidget, type16, 0);
                centerY2 = true;
            }
            if (centerX3 && centerY2) {
                getAnchor(type5).connect(constraintWidget.getAnchor(type5), 0);
            } else if (centerX3) {
                ConstraintAnchor.Type type17 = ConstraintAnchor.Type.CENTER_X;
                getAnchor(type17).connect(constraintWidget.getAnchor(type17), 0);
            } else if (centerY2) {
                ConstraintAnchor.Type type18 = ConstraintAnchor.Type.CENTER_Y;
                getAnchor(type18).connect(constraintWidget.getAnchor(type18), 0);
            }
        } else {
            ConstraintAnchor.Type type19 = ConstraintAnchor.Type.LEFT;
            if (type4 == type19 || type4 == ConstraintAnchor.Type.RIGHT) {
                connect(type19, constraintWidget, type4, 0);
                try {
                    connect(ConstraintAnchor.Type.RIGHT, constraintWidget, type4, 0);
                    getAnchor(type5).connect(target.getAnchor(constraintTo), 0);
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                ConstraintAnchor.Type type20 = ConstraintAnchor.Type.TOP;
                if (type4 == type20 || type4 == ConstraintAnchor.Type.BOTTOM) {
                    connect(type20, constraintWidget, type4, 0);
                    connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, type4, 0);
                    getAnchor(type5).connect(target.getAnchor(constraintTo), 0);
                }
            }
        }
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
    }

    public void resetAnchor(ConstraintAnchor anchor) {
        if (getParent() == null || !(getParent() instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            ConstraintAnchor left = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor right = getAnchor(ConstraintAnchor.Type.RIGHT);
            ConstraintAnchor top = getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor bottom = getAnchor(ConstraintAnchor.Type.BOTTOM);
            ConstraintAnchor center = getAnchor(ConstraintAnchor.Type.CENTER);
            ConstraintAnchor centerX = getAnchor(ConstraintAnchor.Type.CENTER_X);
            ConstraintAnchor centerY = getAnchor(ConstraintAnchor.Type.CENTER_Y);
            if (anchor == center) {
                if (left.isConnected() && right.isConnected() && left.getTarget() == right.getTarget()) {
                    left.reset();
                    right.reset();
                }
                if (top.isConnected() && bottom.isConnected() && top.getTarget() == bottom.getTarget()) {
                    top.reset();
                    bottom.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
                this.mVerticalBiasPercent = 0.5f;
            } else if (anchor == centerX) {
                if (left.isConnected() && right.isConnected() && left.getTarget().getOwner() == right.getTarget().getOwner()) {
                    left.reset();
                    right.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
            } else if (anchor == centerY) {
                if (top.isConnected() && bottom.isConnected() && top.getTarget().getOwner() == bottom.getTarget().getOwner()) {
                    top.reset();
                    bottom.reset();
                }
                this.mVerticalBiasPercent = 0.5f;
            } else if (anchor == left || anchor == right) {
                if (left.isConnected() && left.getTarget() == right.getTarget()) {
                    center.reset();
                }
            } else if ((anchor == top || anchor == bottom) && top.isConnected() && top.getTarget() == bottom.getTarget()) {
                center.reset();
            }
            anchor.reset();
        }
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent == null || !(parent instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            int mAnchorsSize = this.mAnchors.size();
            for (int i = 0; i < mAnchorsSize; i++) {
                this.mAnchors.get(i).reset();
            }
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type anchorType) {
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[anchorType.ordinal()]) {
            case 1:
                return this.mLeft;
            case 2:
                return this.mTop;
            case 3:
                return this.mRight;
            case 4:
                return this.mBottom;
            case 5:
                return this.mBaseline;
            case 6:
                return this.mCenter;
            case 7:
                return this.mCenterX;
            case 8:
                return this.mCenterY;
            case 9:
                return null;
            default:
                throw new AssertionError(anchorType.name());
        }
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public DimensionBehaviour getDimensionBehaviour(int orientation) {
        if (orientation == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (orientation == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour behaviour) {
        this.mListDimensionBehaviors[0] = behaviour;
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour behaviour) {
        this.mListDimensionBehaviors[1] = behaviour;
    }

    public boolean isInHorizontalChain() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.mRight;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        r0 = r3.mTop;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.constraintlayout.solver.widgets.ConstraintWidget getPreviousChainMember(int r4) {
        /*
            r3 = this;
            if (r4 != 0) goto L_0x000f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r3.mLeft
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r0.mTarget
            if (r1 == 0) goto L_0x001f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r1.mTarget
            if (r2 != r0) goto L_0x001f
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r1.mOwner
            return r0
        L_0x000f:
            r0 = 1
            if (r4 != r0) goto L_0x001f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r3.mTop
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r0.mTarget
            if (r1 == 0) goto L_0x001f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r1.mTarget
            if (r2 != r0) goto L_0x001f
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r1.mOwner
            return r0
        L_0x001f:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.getPreviousChainMember(int):androidx.constraintlayout.solver.widgets.ConstraintWidget");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        r0 = r3.mBottom;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.constraintlayout.solver.widgets.ConstraintWidget getNextChainMember(int r4) {
        /*
            r3 = this;
            if (r4 != 0) goto L_0x000f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r3.mRight
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r0.mTarget
            if (r1 == 0) goto L_0x001f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r1.mTarget
            if (r2 != r0) goto L_0x001f
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r1.mOwner
            return r0
        L_0x000f:
            r0 = 1
            if (r4 != r0) goto L_0x001f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r3.mBottom
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r0.mTarget
            if (r1 == 0) goto L_0x001f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r1.mTarget
            if (r2 != r0) goto L_0x001f
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r1.mOwner
            return r0
        L_0x001f:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.getNextChainMember(int):androidx.constraintlayout.solver.widgets.ConstraintWidget");
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        ConstraintWidget found = null;
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget tmp = this;
        while (found == null && tmp != null) {
            ConstraintAnchor anchor = tmp.getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor targetAnchor = null;
            ConstraintAnchor targetOwner = anchor == null ? null : anchor.getTarget();
            ConstraintWidget target = targetOwner == null ? null : targetOwner.getOwner();
            if (target == getParent()) {
                return tmp;
            }
            if (target != null) {
                targetAnchor = target.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            }
            if (targetAnchor == null || targetAnchor.getOwner() == tmp) {
                tmp = target;
            } else {
                found = tmp;
            }
        }
        return found;
    }

    public boolean isInVerticalChain() {
        ConstraintAnchor constraintAnchor = this.mTop;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.mBottom;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
            return false;
        }
        return true;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        ConstraintWidget found = null;
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget tmp = this;
        while (found == null && tmp != null) {
            ConstraintAnchor anchor = tmp.getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor targetAnchor = null;
            ConstraintAnchor targetOwner = anchor == null ? null : anchor.getTarget();
            ConstraintWidget target = targetOwner == null ? null : targetOwner.getOwner();
            if (target == getParent()) {
                return tmp;
            }
            if (target != null) {
                targetAnchor = target.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            }
            if (targetAnchor == null || targetAnchor.getOwner() == tmp) {
                tmp = target;
            } else {
                found = tmp;
            }
        }
        return found;
    }

    private boolean isChainHead(int orientation) {
        int offset = orientation * 2;
        ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
        return (constraintAnchorArr[offset].mTarget == null || constraintAnchorArr[offset].mTarget.mTarget == constraintAnchorArr[offset] || constraintAnchorArr[offset + 1].mTarget == null || constraintAnchorArr[offset + 1].mTarget.mTarget != constraintAnchorArr[offset + 1]) ? false : true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0268, code lost:
        if (r0 == -1) goto L_0x026c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x026f  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x028a  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x02ab  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x03b9  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x03e0  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0429  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x043a  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x043d  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0440  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0506  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0531  */
    /* JADX WARNING: Removed duplicated region for block: B:263:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addToSolver(androidx.constraintlayout.solver.LinearSystem r64) {
        /*
            r63 = this;
            r13 = r63
            r9 = r64
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r13.mLeft
            androidx.constraintlayout.solver.SolverVariable r4 = r9.createObjectVariable(r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r13.mRight
            androidx.constraintlayout.solver.SolverVariable r3 = r9.createObjectVariable(r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r13.mTop
            androidx.constraintlayout.solver.SolverVariable r1 = r9.createObjectVariable(r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r13.mBottom
            androidx.constraintlayout.solver.SolverVariable r0 = r9.createObjectVariable(r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r13.mBaseline
            androidx.constraintlayout.solver.SolverVariable r15 = r9.createObjectVariable(r2)
            androidx.constraintlayout.solver.Metrics r2 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            r5 = 1
            if (r2 == 0) goto L_0x002d
            long r7 = r2.widgets
            long r7 = r7 + r5
            r2.widgets = r7
        L_0x002d:
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r7 = r13.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r8 = r7.start
            boolean r10 = r8.resolved
            r14 = 8
            if (r10 == 0) goto L_0x00d1
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r7 = r7.end
            boolean r7 = r7.resolved
            if (r7 == 0) goto L_0x00d1
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r7 = r13.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r10 = r7.start
            boolean r10 = r10.resolved
            if (r10 == 0) goto L_0x00d1
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r7 = r7.end
            boolean r7 = r7.resolved
            if (r7 == 0) goto L_0x00d1
            if (r2 == 0) goto L_0x0052
            long r11 = r2.graphSolved
            long r11 = r11 + r5
            r2.graphSolved = r11
        L_0x0052:
            int r2 = r8.value
            r9.addEquality(r4, r2)
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r2 = r13.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.end
            int r2 = r2.value
            r9.addEquality(r3, r2)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r2 = r13.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.start
            int r2 = r2.value
            r9.addEquality(r1, r2)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r2 = r13.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.end
            int r2 = r2.value
            r9.addEquality(r0, r2)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r2 = r13.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.baseline
            int r2 = r2.value
            r9.addEquality(r15, r2)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r13.mParent
            if (r2 == 0) goto L_0x00d0
            if (r2 == 0) goto L_0x008c
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r2.mListDimensionBehaviors
            r6 = 0
            r5 = r5[r6]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 != r6) goto L_0x008c
            r5 = 1
            goto L_0x008d
        L_0x008c:
            r5 = 0
        L_0x008d:
            if (r2 == 0) goto L_0x009a
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r2.mListDimensionBehaviors
            r6 = 1
            r2 = r2[r6]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 != r6) goto L_0x009a
            r2 = 1
            goto L_0x009b
        L_0x009a:
            r2 = 0
        L_0x009b:
            if (r5 == 0) goto L_0x00b5
            boolean[] r6 = r13.isTerminalWidget
            r7 = 0
            boolean r6 = r6[r7]
            if (r6 == 0) goto L_0x00b5
            boolean r6 = r63.isInHorizontalChain()
            if (r6 != 0) goto L_0x00b5
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r13.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r6.mRight
            androidx.constraintlayout.solver.SolverVariable r6 = r9.createObjectVariable(r6)
            r9.addGreaterThan(r6, r3, r7, r14)
        L_0x00b5:
            if (r2 == 0) goto L_0x00d0
            boolean[] r6 = r13.isTerminalWidget
            r7 = 1
            boolean r6 = r6[r7]
            if (r6 == 0) goto L_0x00d0
            boolean r6 = r63.isInVerticalChain()
            if (r6 != 0) goto L_0x00d0
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r13.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r6.mBottom
            androidx.constraintlayout.solver.SolverVariable r6 = r9.createObjectVariable(r6)
            r7 = 0
            r9.addGreaterThan(r6, r0, r7, r14)
        L_0x00d0:
            return
        L_0x00d1:
            if (r2 == 0) goto L_0x00d8
            long r7 = r2.linearSolved
            long r7 = r7 + r5
            r2.linearSolved = r7
        L_0x00d8:
            r2 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = r13.mParent
            if (r8 == 0) goto L_0x0173
            if (r8 == 0) goto L_0x00ed
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r10 = r8.mListDimensionBehaviors
            r11 = 0
            r10 = r10[r11]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r10 != r11) goto L_0x00ed
            r10 = 1
            goto L_0x00ee
        L_0x00ed:
            r10 = 0
        L_0x00ee:
            r6 = r10
            if (r8 == 0) goto L_0x00fc
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r8.mListDimensionBehaviors
            r10 = 1
            r8 = r8[r10]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r8 != r10) goto L_0x00fc
            r8 = 1
            goto L_0x00fd
        L_0x00fc:
            r8 = 0
        L_0x00fd:
            r7 = r8
            r8 = 0
            boolean r10 = r13.isChainHead(r8)
            if (r10 == 0) goto L_0x010e
            androidx.constraintlayout.solver.widgets.ConstraintWidget r10 = r13.mParent
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r10 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) r10
            r10.addChain(r13, r8)
            r2 = 1
            goto L_0x0112
        L_0x010e:
            boolean r2 = r63.isInHorizontalChain()
        L_0x0112:
            r8 = 1
            boolean r10 = r13.isChainHead(r8)
            if (r10 == 0) goto L_0x0122
            androidx.constraintlayout.solver.widgets.ConstraintWidget r10 = r13.mParent
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r10 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) r10
            r10.addChain(r13, r8)
            r5 = 1
            goto L_0x0126
        L_0x0122:
            boolean r5 = r63.isInVerticalChain()
        L_0x0126:
            if (r2 != 0) goto L_0x0147
            if (r6 == 0) goto L_0x0147
            int r8 = r13.mVisibility
            if (r8 == r14) goto L_0x0147
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r13.mLeft
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r8.mTarget
            if (r8 != 0) goto L_0x0147
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r13.mRight
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r8.mTarget
            if (r8 != 0) goto L_0x0147
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = r13.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r8.mRight
            androidx.constraintlayout.solver.SolverVariable r8 = r9.createObjectVariable(r8)
            r10 = 1
            r11 = 0
            r9.addGreaterThan(r8, r3, r11, r10)
        L_0x0147:
            if (r5 != 0) goto L_0x016c
            if (r7 == 0) goto L_0x016c
            int r8 = r13.mVisibility
            if (r8 == r14) goto L_0x016c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r13.mTop
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r8.mTarget
            if (r8 != 0) goto L_0x016c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r13.mBottom
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r8.mTarget
            if (r8 != 0) goto L_0x016c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r13.mBaseline
            if (r8 != 0) goto L_0x016c
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = r13.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r8.mBottom
            androidx.constraintlayout.solver.SolverVariable r8 = r9.createObjectVariable(r8)
            r10 = 1
            r11 = 0
            r9.addGreaterThan(r8, r0, r11, r10)
        L_0x016c:
            r45 = r2
            r46 = r5
            r12 = r6
            r11 = r7
            goto L_0x0179
        L_0x0173:
            r45 = r2
            r46 = r5
            r12 = r6
            r11 = r7
        L_0x0179:
            int r2 = r13.mWidth
            int r5 = r13.mMinWidth
            if (r2 >= r5) goto L_0x0181
            int r2 = r13.mMinWidth
        L_0x0181:
            int r5 = r13.mHeight
            int r6 = r13.mMinHeight
            if (r5 >= r6) goto L_0x0189
            int r5 = r13.mMinHeight
        L_0x0189:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r6 = r13.mListDimensionBehaviors
            r7 = 0
            r8 = r6[r7]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r8 == r7) goto L_0x0194
            r8 = 1
            goto L_0x0195
        L_0x0194:
            r8 = 0
        L_0x0195:
            r10 = r8
            r8 = 1
            r14 = r6[r8]
            if (r14 == r7) goto L_0x019d
            r8 = 1
            goto L_0x019e
        L_0x019d:
            r8 = 0
        L_0x019e:
            r14 = r8
            r8 = 0
            r20 = r0
            int r0 = r13.mDimensionRatioSide
            r13.mResolvedDimensionRatioSide = r0
            r21 = r1
            float r1 = r13.mDimensionRatio
            r13.mResolvedDimensionRatio = r1
            r17 = r2
            int r2 = r13.mMatchConstraintDefaultWidth
            r22 = r5
            int r5 = r13.mMatchConstraintDefaultHeight
            r23 = 0
            r24 = r15
            int r23 = (r1 > r23 ? 1 : (r1 == r23 ? 0 : -1))
            if (r23 <= 0) goto L_0x024b
            int r15 = r13.mVisibility
            r25 = r8
            r8 = 8
            if (r15 == r8) goto L_0x024d
            r8 = 1
            r25 = r8
            r15 = 0
            r8 = r6[r15]
            if (r8 != r7) goto L_0x01cf
            if (r2 != 0) goto L_0x01cf
            r2 = 3
        L_0x01cf:
            r8 = 1
            r15 = r6[r8]
            if (r15 != r7) goto L_0x01d7
            if (r5 != 0) goto L_0x01d7
            r5 = 3
        L_0x01d7:
            r8 = 0
            r15 = r6[r8]
            if (r15 != r7) goto L_0x01eb
            r15 = 1
            r8 = r6[r15]
            if (r8 != r7) goto L_0x01eb
            r8 = 3
            if (r2 != r8) goto L_0x01eb
            if (r5 != r8) goto L_0x01eb
            r13.setupDimensionRatio(r12, r11, r10, r14)
            goto L_0x024d
        L_0x01eb:
            r8 = 0
            r15 = r6[r8]
            if (r15 != r7) goto L_0x0215
            r15 = 3
            if (r2 != r15) goto L_0x0215
            r13.mResolvedDimensionRatioSide = r8
            int r0 = r13.mHeight
            float r0 = (float) r0
            float r1 = r1 * r0
            int r0 = (int) r1
            r1 = 1
            r6 = r6[r1]
            if (r6 == r7) goto L_0x020b
            r2 = 4
            r8 = 0
            r47 = r2
            r48 = r5
            r1 = r8
            r27 = r22
            r2 = r0
            goto L_0x0257
        L_0x020b:
            r47 = r2
            r48 = r5
            r27 = r22
            r1 = r25
            r2 = r0
            goto L_0x0257
        L_0x0215:
            r8 = 1
            r15 = r6[r8]
            if (r15 != r7) goto L_0x024d
            r15 = 3
            if (r5 != r15) goto L_0x024d
            r13.mResolvedDimensionRatioSide = r8
            r8 = -1
            if (r0 != r8) goto L_0x0227
            r0 = 1065353216(0x3f800000, float:1.0)
            float r0 = r0 / r1
            r13.mResolvedDimensionRatio = r0
        L_0x0227:
            float r0 = r13.mResolvedDimensionRatio
            int r1 = r13.mWidth
            float r1 = (float) r1
            float r0 = r0 * r1
            int r0 = (int) r0
            r1 = 0
            r6 = r6[r1]
            if (r6 == r7) goto L_0x0240
            r5 = 4
            r8 = 0
            r27 = r0
            r47 = r2
            r48 = r5
            r1 = r8
            r2 = r17
            goto L_0x0257
        L_0x0240:
            r27 = r0
            r47 = r2
            r48 = r5
            r2 = r17
            r1 = r25
            goto L_0x0257
        L_0x024b:
            r25 = r8
        L_0x024d:
            r47 = r2
            r48 = r5
            r2 = r17
            r27 = r22
            r1 = r25
        L_0x0257:
            int[] r0 = r13.mResolvedMatchConstraintDefault
            r5 = 0
            r0[r5] = r47
            r5 = 1
            r0[r5] = r48
            r13.mResolvedHasRatio = r1
            if (r1 == 0) goto L_0x026f
            int r0 = r13.mResolvedDimensionRatioSide
            if (r0 == 0) goto L_0x026b
            r15 = -1
            if (r0 != r15) goto L_0x0270
            goto L_0x026c
        L_0x026b:
            r15 = -1
        L_0x026c:
            r17 = 1
            goto L_0x0272
        L_0x026f:
            r15 = -1
        L_0x0270:
            r17 = 0
        L_0x0272:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r13.mListDimensionBehaviors
            r5 = 0
            r0 = r0[r5]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r8) goto L_0x0281
            boolean r0 = r13 instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
            if (r0 == 0) goto L_0x0281
            r0 = 1
            goto L_0x0282
        L_0x0281:
            r0 = 0
        L_0x0282:
            r28 = r0
            if (r28 == 0) goto L_0x028a
            r2 = 0
            r49 = r2
            goto L_0x028c
        L_0x028a:
            r49 = r2
        L_0x028c:
            r0 = 1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r13.mCenter
            boolean r2 = r2.isConnected()
            if (r2 == 0) goto L_0x0299
            r0 = 0
            r29 = r0
            goto L_0x029b
        L_0x0299:
            r29 = r0
        L_0x029b:
            boolean[] r0 = r13.mIsInBarrier
            r2 = 0
            boolean r50 = r0[r2]
            r16 = 1
            boolean r51 = r0[r16]
            int r0 = r13.mHorizontalResolution
            r5 = 2
            r30 = 0
            if (r0 == r5) goto L_0x03b9
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r0 = r13.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r0.start
            boolean r6 = r2.resolved
            if (r6 == 0) goto L_0x0337
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.end
            boolean r0 = r0.resolved
            if (r0 != 0) goto L_0x02bd
            r6 = 8
            goto L_0x0339
        L_0x02bd:
            int r0 = r2.value
            r9.addEquality(r4, r0)
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r0 = r13.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.end
            int r0 = r0.value
            r9.addEquality(r3, r0)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r13.mParent
            if (r0 == 0) goto L_0x031d
            if (r12 == 0) goto L_0x0303
            boolean[] r0 = r13.isTerminalWidget
            r2 = 0
            boolean r0 = r0[r2]
            if (r0 == 0) goto L_0x0303
            boolean r0 = r63.isInHorizontalChain()
            if (r0 != 0) goto L_0x0303
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r13.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.mRight
            androidx.constraintlayout.solver.SolverVariable r0 = r9.createObjectVariable(r0)
            r6 = 8
            r9.addGreaterThan(r0, r3, r2, r6)
            r60 = r1
            r61 = r3
            r62 = r4
            r52 = r8
            r53 = r10
            r54 = r11
            r55 = r12
            r56 = r14
            r58 = r20
            r59 = r21
            r57 = r24
            goto L_0x03cf
        L_0x0303:
            r6 = 8
            r60 = r1
            r61 = r3
            r62 = r4
            r52 = r8
            r53 = r10
            r54 = r11
            r55 = r12
            r56 = r14
            r58 = r20
            r59 = r21
            r57 = r24
            goto L_0x03cf
        L_0x031d:
            r6 = 8
            r60 = r1
            r61 = r3
            r62 = r4
            r52 = r8
            r53 = r10
            r54 = r11
            r55 = r12
            r56 = r14
            r58 = r20
            r59 = r21
            r57 = r24
            goto L_0x03cf
        L_0x0337:
            r6 = 8
        L_0x0339:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r13.mParent
            if (r0 == 0) goto L_0x0345
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.mRight
            androidx.constraintlayout.solver.SolverVariable r0 = r9.createObjectVariable(r0)
            r7 = r0
            goto L_0x0347
        L_0x0345:
            r7 = r30
        L_0x0347:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r13.mParent
            if (r0 == 0) goto L_0x0352
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.mLeft
            androidx.constraintlayout.solver.SolverVariable r0 = r9.createObjectVariable(r0)
            goto L_0x0354
        L_0x0352:
            r0 = r30
        L_0x0354:
            r19 = 8
            r6 = r0
            r2 = 1
            boolean[] r0 = r13.isTerminalWidget
            r18 = 0
            boolean r0 = r0[r18]
            r5 = r0
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r13.mListDimensionBehaviors
            r0 = r0[r18]
            r52 = r8
            r8 = r0
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r13.mLeft
            r53 = r10
            r10 = r0
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r13.mRight
            r54 = r11
            r2 = 0
            r11 = r0
            int r0 = r13.mX
            r55 = r12
            r12 = r0
            int r0 = r13.mMinWidth
            r56 = r14
            r14 = r0
            int[] r0 = r13.mMaxDimension
            r0 = r0[r2]
            r57 = r24
            r15 = r0
            float r0 = r13.mHorizontalBiasPercent
            r16 = r0
            int r0 = r13.mMatchConstraintMinWidth
            r23 = r0
            int r0 = r13.mMatchConstraintMaxWidth
            r24 = r0
            float r0 = r13.mMatchConstraintPercentWidth
            r25 = r0
            r58 = r20
            r0 = r63
            r60 = r1
            r59 = r21
            r1 = r64
            r61 = r3
            r3 = r55
            r62 = r4
            r4 = r54
            r9 = r28
            r13 = r49
            r18 = r45
            r19 = r46
            r20 = r50
            r21 = r47
            r22 = r48
            r26 = r29
            r2 = 1
            r0.applyConstraints(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            goto L_0x03cf
        L_0x03b9:
            r60 = r1
            r61 = r3
            r62 = r4
            r52 = r8
            r53 = r10
            r54 = r11
            r55 = r12
            r56 = r14
            r58 = r20
            r59 = r21
            r57 = r24
        L_0x03cf:
            r0 = 1
            r7 = r63
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r1 = r7.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r1.start
            boolean r3 = r2.resolved
            if (r3 == 0) goto L_0x0429
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.end
            boolean r1 = r1.resolved
            if (r1 == 0) goto L_0x0429
            int r1 = r2.value
            r8 = r64
            r9 = r59
            r8.addEquality(r9, r1)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r1 = r7.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.end
            int r1 = r1.value
            r10 = r58
            r8.addEquality(r10, r1)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r1 = r7.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.baseline
            int r1 = r1.value
            r11 = r57
            r8.addEquality(r11, r1)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r7.mParent
            if (r1 == 0) goto L_0x0423
            if (r46 != 0) goto L_0x041e
            if (r54 == 0) goto L_0x041e
            boolean[] r2 = r7.isTerminalWidget
            r3 = 1
            boolean r2 = r2[r3]
            if (r2 == 0) goto L_0x041b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.mBottom
            androidx.constraintlayout.solver.SolverVariable r1 = r8.createObjectVariable(r1)
            r2 = 8
            r4 = 0
            r8.addGreaterThan(r1, r10, r4, r2)
            goto L_0x0427
        L_0x041b:
            r2 = 8
            goto L_0x0421
        L_0x041e:
            r2 = 8
            r3 = 1
        L_0x0421:
            r4 = 0
            goto L_0x0427
        L_0x0423:
            r2 = 8
            r3 = 1
            r4 = 0
        L_0x0427:
            r0 = 0
            goto L_0x0435
        L_0x0429:
            r8 = r64
            r11 = r57
            r10 = r58
            r9 = r59
            r2 = 8
            r3 = 1
            r4 = 0
        L_0x0435:
            int r1 = r7.mVerticalResolution
            r5 = 2
            if (r1 != r5) goto L_0x043d
            r0 = 0
            r12 = r0
            goto L_0x043e
        L_0x043d:
            r12 = r0
        L_0x043e:
            if (r12 == 0) goto L_0x0504
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r7.mListDimensionBehaviors
            r0 = r0[r3]
            r1 = r52
            if (r0 != r1) goto L_0x044e
            boolean r0 = r7 instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
            if (r0 == 0) goto L_0x044e
            r0 = 1
            goto L_0x044f
        L_0x044e:
            r0 = 0
        L_0x044f:
            if (r0 == 0) goto L_0x0453
            r1 = 0
            goto L_0x0455
        L_0x0453:
            r1 = r27
        L_0x0455:
            if (r60 == 0) goto L_0x0461
            int r5 = r7.mResolvedDimensionRatioSide
            if (r5 == r3) goto L_0x045e
            r6 = -1
            if (r5 != r6) goto L_0x0461
        L_0x045e:
            r35 = 1
            goto L_0x0463
        L_0x0461:
            r35 = 0
        L_0x0463:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r7.mParent
            if (r5 == 0) goto L_0x046e
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.mBottom
            androidx.constraintlayout.solver.SolverVariable r5 = r8.createObjectVariable(r5)
            goto L_0x0470
        L_0x046e:
            r5 = r30
        L_0x0470:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r7.mParent
            if (r6 == 0) goto L_0x047d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r6.mTop
            androidx.constraintlayout.solver.SolverVariable r6 = r8.createObjectVariable(r6)
            r24 = r6
            goto L_0x047f
        L_0x047d:
            r24 = r30
        L_0x047f:
            int r6 = r7.mBaselineDistance
            if (r6 > 0) goto L_0x0487
            int r6 = r7.mVisibility
            if (r6 != r2) goto L_0x04b1
        L_0x0487:
            int r6 = r63.getBaselineDistance()
            r8.addEquality(r11, r9, r6, r2)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r7.mBaseline
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r6.mTarget
            if (r6 == 0) goto L_0x04aa
            androidx.constraintlayout.solver.SolverVariable r6 = r8.createObjectVariable(r6)
            r13 = 0
            r8.addEquality(r11, r6, r13, r2)
            r2 = 0
            if (r54 == 0) goto L_0x04a9
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r7.mBottom
            androidx.constraintlayout.solver.SolverVariable r14 = r8.createObjectVariable(r14)
            r15 = 5
            r8.addGreaterThan(r5, r14, r4, r15)
        L_0x04a9:
            goto L_0x04b3
        L_0x04aa:
            int r6 = r7.mVisibility
            if (r6 != r2) goto L_0x04b1
            r8.addEquality(r11, r9, r4, r2)
        L_0x04b1:
            r2 = r29
        L_0x04b3:
            r20 = 0
            boolean[] r4 = r7.isTerminalWidget
            boolean r23 = r4[r3]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r7.mListDimensionBehaviors
            r26 = r4[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r7.mTop
            r28 = r4
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r7.mBottom
            r29 = r4
            int r4 = r7.mY
            r30 = r4
            int r4 = r7.mMinHeight
            r32 = r4
            int[] r4 = r7.mMaxDimension
            r33 = r4[r3]
            float r4 = r7.mVerticalBiasPercent
            r34 = r4
            int r4 = r7.mMatchConstraintMinHeight
            r41 = r4
            int r4 = r7.mMatchConstraintMaxHeight
            r42 = r4
            float r4 = r7.mMatchConstraintPercentHeight
            r43 = r4
            r18 = r63
            r19 = r64
            r21 = r54
            r22 = r55
            r25 = r5
            r27 = r0
            r31 = r1
            r36 = r46
            r37 = r45
            r38 = r51
            r39 = r48
            r40 = r47
            r44 = r2
            r18.applyConstraints(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44)
            r28 = r0
            r27 = r1
            r29 = r2
        L_0x0504:
            if (r60 == 0) goto L_0x0529
            r13 = 8
            int r0 = r7.mResolvedDimensionRatioSide
            if (r0 != r3) goto L_0x051b
            float r5 = r7.mResolvedDimensionRatio
            r0 = r64
            r1 = r10
            r2 = r9
            r3 = r61
            r4 = r62
            r6 = r13
            r0.addRatio(r1, r2, r3, r4, r5, r6)
            goto L_0x0529
        L_0x051b:
            float r5 = r7.mResolvedDimensionRatio
            r0 = r64
            r1 = r61
            r2 = r62
            r3 = r10
            r4 = r9
            r6 = r13
            r0.addRatio(r1, r2, r3, r4, r5, r6)
        L_0x0529:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.mCenter
            boolean r0 = r0.isConnected()
            if (r0 == 0) goto L_0x054f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.mCenter
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.getTarget()
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r0.getOwner()
            float r1 = r7.mCircleConstraintAngle
            r2 = 1119092736(0x42b40000, float:90.0)
            float r1 = r1 + r2
            double r1 = (double) r1
            double r1 = java.lang.Math.toRadians(r1)
            float r1 = (float) r1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r7.mCenter
            int r2 = r2.getMargin()
            r8.addCenterPoint(r7, r0, r1, r2)
        L_0x054f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.addToSolver(androidx.constraintlayout.solver.LinearSystem):void");
    }

    /* access modifiers changed from: package-private */
    public boolean addFirst() {
        return (this instanceof VirtualLayout) || (this instanceof Guideline);
    }

    public void setupDimensionRatio(boolean hparentWrapContent, boolean vparentWrapContent, boolean horizontalDimensionFixed, boolean verticalDimensionFixed) {
        if (this.mResolvedDimensionRatioSide == -1) {
            if (horizontalDimensionFixed && !verticalDimensionFixed) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!horizontalDimensionFixed && verticalDimensionFixed) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            int i = this.mMatchConstraintMinWidth;
            if (i > 0 && this.mMatchConstraintMinHeight == 0) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (i == 0 && this.mMatchConstraintMinHeight > 0) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:184:0x03dd  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0411  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0423 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0424  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void applyConstraints(androidx.constraintlayout.solver.LinearSystem r40, boolean r41, boolean r42, boolean r43, boolean r44, androidx.constraintlayout.solver.SolverVariable r45, androidx.constraintlayout.solver.SolverVariable r46, androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour r47, boolean r48, androidx.constraintlayout.solver.widgets.ConstraintAnchor r49, androidx.constraintlayout.solver.widgets.ConstraintAnchor r50, int r51, int r52, int r53, int r54, float r55, boolean r56, boolean r57, boolean r58, boolean r59, int r60, int r61, int r62, int r63, float r64, boolean r65) {
        /*
            r39 = this;
            r0 = r39
            r10 = r40
            r11 = r45
            r12 = r46
            r13 = r49
            r14 = r50
            r15 = r53
            r9 = r54
            r8 = r61
            r1 = r62
            r2 = r63
            androidx.constraintlayout.solver.SolverVariable r7 = r10.createObjectVariable(r13)
            androidx.constraintlayout.solver.SolverVariable r6 = r10.createObjectVariable(r14)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r49.getTarget()
            androidx.constraintlayout.solver.SolverVariable r5 = r10.createObjectVariable(r3)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r50.getTarget()
            androidx.constraintlayout.solver.SolverVariable r4 = r10.createObjectVariable(r3)
            androidx.constraintlayout.solver.Metrics r3 = androidx.constraintlayout.solver.LinearSystem.getMetrics()
            if (r3 == 0) goto L_0x0040
            androidx.constraintlayout.solver.Metrics r3 = androidx.constraintlayout.solver.LinearSystem.getMetrics()
            long r12 = r3.nonresolvedWidgets
            r16 = 1
            long r12 = r12 + r16
            r3.nonresolvedWidgets = r12
        L_0x0040:
            boolean r12 = r49.isConnected()
            boolean r13 = r50.isConnected()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r0.mCenter
            boolean r16 = r3.isConnected()
            r3 = 0
            r17 = 0
            if (r12 == 0) goto L_0x0055
            int r17 = r17 + 1
        L_0x0055:
            if (r13 == 0) goto L_0x0059
            int r17 = r17 + 1
        L_0x0059:
            if (r16 == 0) goto L_0x0060
            int r17 = r17 + 1
            r8 = r17
            goto L_0x0062
        L_0x0060:
            r8 = r17
        L_0x0062:
            if (r56 == 0) goto L_0x0069
            r17 = 3
            r14 = r17
            goto L_0x006b
        L_0x0069:
            r14 = r60
        L_0x006b:
            int[] r17 = androidx.constraintlayout.solver.widgets.ConstraintWidget.AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour
            int r18 = r47.ordinal()
            r17 = r17[r18]
            switch(r17) {
                case 1: goto L_0x0086;
                case 2: goto L_0x0084;
                case 3: goto L_0x0082;
                case 4: goto L_0x0077;
                default: goto L_0x0076;
            }
        L_0x0076:
            goto L_0x0088
        L_0x0077:
            r3 = 1
            r60 = r3
            r3 = 4
            if (r14 != r3) goto L_0x007f
            r3 = 0
            goto L_0x0088
        L_0x007f:
            r3 = r60
            goto L_0x0088
        L_0x0082:
            r3 = 0
            goto L_0x0088
        L_0x0084:
            r3 = 0
            goto L_0x0088
        L_0x0086:
            r3 = 0
        L_0x0088:
            r60 = r3
            int r3 = r0.mVisibility
            r11 = 8
            if (r3 != r11) goto L_0x0094
            r3 = 0
            r17 = 0
            goto L_0x0098
        L_0x0094:
            r3 = r52
            r17 = r60
        L_0x0098:
            if (r65 == 0) goto L_0x00bd
            if (r12 != 0) goto L_0x00a8
            if (r13 != 0) goto L_0x00a8
            if (r16 != 0) goto L_0x00a8
            r11 = r51
            r10.addEquality(r7, r11)
            r18 = r4
            goto L_0x00bf
        L_0x00a8:
            r11 = r51
            if (r12 == 0) goto L_0x00ba
            if (r13 != 0) goto L_0x00ba
            r18 = r4
            int r4 = r49.getMargin()
            r11 = 8
            r10.addEquality(r7, r5, r4, r11)
            goto L_0x00bf
        L_0x00ba:
            r18 = r4
            goto L_0x00bf
        L_0x00bd:
            r18 = r4
        L_0x00bf:
            r11 = 0
            if (r17 != 0) goto L_0x00f3
            if (r48 == 0) goto L_0x00db
            r4 = 3
            r10.addEquality(r6, r7, r11, r4)
            if (r15 <= 0) goto L_0x00d0
            r4 = 8
            r10.addGreaterThan(r6, r7, r15, r4)
            goto L_0x00d2
        L_0x00d0:
            r4 = 8
        L_0x00d2:
            r11 = 2147483647(0x7fffffff, float:NaN)
            if (r9 >= r11) goto L_0x00e0
            r10.addLowerThan(r6, r7, r9, r4)
            goto L_0x00e0
        L_0x00db:
            r4 = 8
            r10.addEquality(r6, r7, r3, r4)
        L_0x00e0:
            r21 = r2
            r22 = r3
            r25 = r5
            r11 = r6
            r24 = r8
            r23 = r17
            r8 = r18
            r17 = r44
            r18 = r1
            goto L_0x0220
        L_0x00f3:
            r4 = 2
            if (r8 == r4) goto L_0x0121
            if (r56 != 0) goto L_0x0121
            r4 = 1
            if (r14 == r4) goto L_0x00fd
            if (r14 != 0) goto L_0x0121
        L_0x00fd:
            r17 = 0
            int r4 = java.lang.Math.max(r1, r3)
            if (r2 <= 0) goto L_0x0109
            int r4 = java.lang.Math.min(r2, r4)
        L_0x0109:
            r11 = 8
            r10.addEquality(r6, r7, r4, r11)
            r21 = r2
            r22 = r3
            r25 = r5
            r11 = r6
            r24 = r8
            r23 = r17
            r8 = r18
            r17 = r44
            r18 = r1
            goto L_0x0220
        L_0x0121:
            r4 = -2
            if (r1 != r4) goto L_0x0127
            r1 = r3
            r11 = r1
            goto L_0x0128
        L_0x0127:
            r11 = r1
        L_0x0128:
            if (r2 != r4) goto L_0x012d
            r1 = r3
            r4 = r1
            goto L_0x012e
        L_0x012d:
            r4 = r2
        L_0x012e:
            if (r3 <= 0) goto L_0x0134
            r1 = 1
            if (r14 == r1) goto L_0x0134
            r3 = 0
        L_0x0134:
            if (r11 <= 0) goto L_0x013f
            r1 = 8
            r10.addGreaterThan(r6, r7, r11, r1)
            int r3 = java.lang.Math.max(r3, r11)
        L_0x013f:
            if (r4 <= 0) goto L_0x0154
            r1 = 1
            if (r42 == 0) goto L_0x0148
            r2 = 1
            if (r14 != r2) goto L_0x0148
            r1 = 0
        L_0x0148:
            if (r1 == 0) goto L_0x014f
            r2 = 8
            r10.addLowerThan(r6, r7, r4, r2)
        L_0x014f:
            int r2 = java.lang.Math.min(r3, r4)
            r3 = r2
        L_0x0154:
            r2 = 1
            if (r14 != r2) goto L_0x0185
            if (r42 == 0) goto L_0x015f
            r1 = 8
            r10.addEquality(r6, r7, r3, r1)
            goto L_0x0172
        L_0x015f:
            r1 = 8
            if (r57 == 0) goto L_0x016b
            r2 = 5
            r10.addEquality(r6, r7, r3, r2)
            r10.addLowerThan(r6, r7, r3, r1)
            goto L_0x0172
        L_0x016b:
            r2 = 5
            r10.addEquality(r6, r7, r3, r2)
            r10.addLowerThan(r6, r7, r3, r1)
        L_0x0172:
            r22 = r3
            r21 = r4
            r25 = r5
            r24 = r8
            r23 = r17
            r8 = r18
            r17 = r44
            r18 = r11
            r11 = r6
            goto L_0x0220
        L_0x0185:
            r1 = 2
            if (r14 != r1) goto L_0x0208
            r1 = 0
            r2 = 0
            r62 = r1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = r49.getType()
            r63 = r2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            if (r1 == r2) goto L_0x01be
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = r49.getType()
            r21 = r3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            if (r1 != r3) goto L_0x01a1
            goto L_0x01c0
        L_0x01a1:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.getAnchor(r2)
            androidx.constraintlayout.solver.SolverVariable r1 = r10.createObjectVariable(r1)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.getAnchor(r3)
            androidx.constraintlayout.solver.SolverVariable r2 = r10.createObjectVariable(r2)
            r22 = r1
            r23 = r2
            goto L_0x01da
        L_0x01be:
            r21 = r3
        L_0x01c0:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.getAnchor(r2)
            androidx.constraintlayout.solver.SolverVariable r1 = r10.createObjectVariable(r1)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.getAnchor(r3)
            androidx.constraintlayout.solver.SolverVariable r2 = r10.createObjectVariable(r2)
            r22 = r1
            r23 = r2
        L_0x01da:
            androidx.constraintlayout.solver.ArrayRow r1 = r40.createRow()
            r20 = 1
            r2 = r6
            r3 = r7
            r24 = r8
            r62 = r11
            r8 = r18
            r11 = 3
            r18 = r4
            r4 = r23
            r25 = r5
            r5 = r22
            r11 = r6
            r6 = r64
            androidx.constraintlayout.solver.ArrayRow r1 = r1.createRowDimensionRatio(r2, r3, r4, r5, r6)
            r10.addConstraint(r1)
            r17 = 0
            r23 = r17
            r22 = r21
            r17 = r44
            r21 = r18
            r18 = r62
            goto L_0x0220
        L_0x0208:
            r21 = r3
            r25 = r5
            r24 = r8
            r62 = r11
            r8 = r18
            r18 = r4
            r11 = r6
            r1 = 1
            r23 = r17
            r22 = r21
            r17 = r1
            r21 = r18
            r18 = r62
        L_0x0220:
            if (r65 == 0) goto L_0x0522
            if (r57 == 0) goto L_0x0239
            r4 = r50
            r5 = r7
            r2 = r8
            r30 = r12
            r31 = r13
            r9 = r14
            r32 = r24
            r1 = r25
            r6 = 8
            r7 = r45
            r12 = r46
            goto L_0x0535
        L_0x0239:
            r6 = 5
            if (r12 != 0) goto L_0x0250
            if (r13 != 0) goto L_0x0250
            if (r16 != 0) goto L_0x0250
            r5 = r7
            r2 = r8
            r30 = r12
            r31 = r13
            r9 = r14
            r32 = r24
            r1 = r25
            r7 = r45
            r8 = r6
            goto L_0x0506
        L_0x0250:
            if (r12 == 0) goto L_0x0264
            if (r13 != 0) goto L_0x0264
            r5 = r7
            r2 = r8
            r30 = r12
            r31 = r13
            r9 = r14
            r32 = r24
            r1 = r25
            r7 = r45
            r8 = r6
            goto L_0x0506
        L_0x0264:
            if (r12 != 0) goto L_0x02a1
            if (r13 == 0) goto L_0x02a1
            int r1 = r50.getMargin()
            int r1 = -r1
            r2 = 8
            r10.addEquality(r11, r8, r1, r2)
            if (r42 == 0) goto L_0x028d
            r5 = r45
            r1 = 5
            r2 = 0
            r10.addGreaterThan(r7, r5, r2, r1)
            r2 = r8
            r30 = r12
            r31 = r13
            r9 = r14
            r32 = r24
            r1 = r25
            r8 = r6
            r38 = r7
            r7 = r5
            r5 = r38
            goto L_0x0506
        L_0x028d:
            r5 = r45
            r2 = r8
            r30 = r12
            r31 = r13
            r9 = r14
            r32 = r24
            r1 = r25
            r8 = r6
            r38 = r7
            r7 = r5
            r5 = r38
            goto L_0x0506
        L_0x02a1:
            r5 = r45
            r4 = 8
            if (r12 == 0) goto L_0x04f6
            if (r13 == 0) goto L_0x04f6
            r1 = 1
            r2 = 0
            r3 = 0
            r26 = 0
            r27 = 5
            r28 = 4
            r29 = 6
            r27 = 5
            r4 = r49
            r44 = r1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r4.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r1.mOwner
            r52 = r2
            r30 = r12
            r12 = r14
            r14 = r50
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r14.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r2.mOwner
            r31 = r13
            androidx.constraintlayout.solver.widgets.ConstraintWidget r13 = r39.getParent()
            if (r23 == 0) goto L_0x03bc
            if (r12 != 0) goto L_0x030b
            if (r21 != 0) goto L_0x02e4
            if (r18 != 0) goto L_0x02e4
            r3 = 1
            r19 = 8
            r20 = 8
            r27 = r19
            r28 = r20
            r19 = r52
            goto L_0x02ee
        L_0x02e4:
            r19 = 1
            r20 = 5
            r27 = 5
            r28 = r27
            r27 = r20
        L_0x02ee:
            r52 = r3
            boolean r3 = r1 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r3 != 0) goto L_0x0301
            boolean r3 = r2 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r3 == 0) goto L_0x02f9
            goto L_0x0301
        L_0x02f9:
            r20 = r52
            r9 = r61
            r32 = r24
            goto L_0x03c9
        L_0x0301:
            r28 = 4
            r20 = r52
            r9 = r61
            r32 = r24
            goto L_0x03c9
        L_0x030b:
            r62 = r3
            r3 = 1
            if (r12 != r3) goto L_0x031f
            r3 = 1
            r26 = 1
            r27 = 8
            r9 = r61
            r20 = r62
            r19 = r3
            r32 = r24
            goto L_0x03c9
        L_0x031f:
            r3 = 3
            if (r12 != r3) goto L_0x03b3
            int r3 = r0.mResolvedDimensionRatioSide
            r4 = -1
            if (r3 != r4) goto L_0x0359
            r3 = 1
            r26 = 1
            r4 = 1
            r27 = 8
            r28 = 5
            if (r58 == 0) goto L_0x034d
            r28 = 5
            r29 = 4
            if (r42 == 0) goto L_0x0343
            r29 = 5
            r9 = r61
            r19 = r3
            r20 = r4
            r32 = r24
            goto L_0x03c9
        L_0x0343:
            r9 = r61
            r19 = r3
            r20 = r4
            r32 = r24
            goto L_0x03c9
        L_0x034d:
            r29 = 8
            r9 = r61
            r19 = r3
            r20 = r4
            r32 = r24
            goto L_0x03c9
        L_0x0359:
            r3 = 1
            r26 = 1
            r4 = 1
            if (r56 == 0) goto L_0x037e
            r9 = r61
            r52 = r3
            r32 = r24
            r3 = 2
            if (r9 == r3) goto L_0x036f
            r3 = 1
            if (r9 != r3) goto L_0x036c
            goto L_0x036f
        L_0x036c:
            r20 = 0
            goto L_0x0371
        L_0x036f:
            r20 = 1
        L_0x0371:
            r3 = r20
            if (r3 != 0) goto L_0x0379
            r27 = 8
            r28 = 5
        L_0x0379:
            r19 = r52
            r20 = r4
            goto L_0x03c9
        L_0x037e:
            r9 = r61
            r52 = r3
            r32 = r24
            r27 = 5
            if (r21 <= 0) goto L_0x038f
            r28 = 5
            r19 = r52
            r20 = r4
            goto L_0x03c9
        L_0x038f:
            if (r21 != 0) goto L_0x03ae
            if (r18 != 0) goto L_0x03ae
            if (r58 != 0) goto L_0x039c
            r28 = 8
            r19 = r52
            r20 = r4
            goto L_0x03c9
        L_0x039c:
            if (r1 == r13) goto L_0x03a4
            if (r2 == r13) goto L_0x03a4
            r3 = 4
            r27 = r3
            goto L_0x03a7
        L_0x03a4:
            r3 = 5
            r27 = r3
        L_0x03a7:
            r28 = 4
            r19 = r52
            r20 = r4
            goto L_0x03c9
        L_0x03ae:
            r19 = r52
            r20 = r4
            goto L_0x03c9
        L_0x03b3:
            r9 = r61
            r32 = r24
            r19 = r52
            r20 = r62
            goto L_0x03c9
        L_0x03bc:
            r9 = r61
            r62 = r3
            r32 = r24
            r3 = 1
            r26 = 1
            r20 = r62
            r19 = r3
        L_0x03c9:
            if (r26 == 0) goto L_0x03d7
            r4 = r25
            if (r4 != r8) goto L_0x03d9
            if (r1 == r13) goto L_0x03d9
            r26 = 0
            r3 = 0
            r24 = r3
            goto L_0x03db
        L_0x03d7:
            r4 = r25
        L_0x03d9:
            r24 = r44
        L_0x03db:
            if (r19 == 0) goto L_0x0411
            int r3 = r0.mVisibility
            r5 = 8
            if (r3 != r5) goto L_0x03e6
            r3 = 4
            r29 = r3
        L_0x03e6:
            int r25 = r49.getMargin()
            int r33 = r50.getMargin()
            r3 = r1
            r1 = r40
            r14 = r2
            r2 = r7
            r44 = r12
            r12 = r3
            r3 = r4
            r5 = r4
            r15 = 8
            r4 = r25
            r34 = r5
            r5 = r55
            r35 = r6
            r6 = r8
            r36 = r7
            r7 = r11
            r9 = r8
            r8 = r33
            r37 = r9
            r9 = r29
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x041f
        L_0x0411:
            r14 = r2
            r34 = r4
            r35 = r6
            r36 = r7
            r37 = r8
            r44 = r12
            r15 = 8
            r12 = r1
        L_0x041f:
            int r1 = r0.mVisibility
            if (r1 != r15) goto L_0x0424
            return
        L_0x0424:
            if (r26 == 0) goto L_0x0454
            if (r42 == 0) goto L_0x043a
            r1 = r34
            r2 = r37
            if (r1 == r2) goto L_0x043e
            if (r23 != 0) goto L_0x043e
            boolean r3 = r12 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r3 != 0) goto L_0x0438
            boolean r3 = r14 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r3 == 0) goto L_0x043e
        L_0x0438:
            r3 = 6
            goto L_0x0440
        L_0x043a:
            r1 = r34
            r2 = r37
        L_0x043e:
            r3 = r27
        L_0x0440:
            int r4 = r49.getMargin()
            r5 = r36
            r10.addGreaterThan(r5, r1, r4, r3)
            int r4 = r50.getMargin()
            int r4 = -r4
            r10.addLowerThan(r11, r2, r4, r3)
            r27 = r3
            goto L_0x045a
        L_0x0454:
            r1 = r34
            r5 = r36
            r2 = r37
        L_0x045a:
            if (r42 == 0) goto L_0x0471
            if (r59 == 0) goto L_0x0471
            boolean r3 = r12 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r3 != 0) goto L_0x0471
            boolean r3 = r14 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r3 != 0) goto L_0x0471
            r28 = 6
            r27 = 6
            r24 = 1
            r3 = r27
            r4 = r28
            goto L_0x0475
        L_0x0471:
            r3 = r27
            r4 = r28
        L_0x0475:
            if (r24 == 0) goto L_0x04ba
            if (r20 == 0) goto L_0x049c
            if (r58 == 0) goto L_0x047d
            if (r43 == 0) goto L_0x049c
        L_0x047d:
            r6 = r4
            if (r12 == r13) goto L_0x0482
            if (r14 != r13) goto L_0x0483
        L_0x0482:
            r6 = 6
        L_0x0483:
            boolean r7 = r12 instanceof androidx.constraintlayout.solver.widgets.Guideline
            if (r7 != 0) goto L_0x048b
            boolean r7 = r14 instanceof androidx.constraintlayout.solver.widgets.Guideline
            if (r7 == 0) goto L_0x048c
        L_0x048b:
            r6 = 5
        L_0x048c:
            boolean r7 = r12 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r7 != 0) goto L_0x0494
            boolean r7 = r14 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r7 == 0) goto L_0x0495
        L_0x0494:
            r6 = 5
        L_0x0495:
            if (r58 == 0) goto L_0x0498
            r6 = 5
        L_0x0498:
            int r4 = java.lang.Math.max(r6, r4)
        L_0x049c:
            if (r42 == 0) goto L_0x04ab
            int r4 = java.lang.Math.min(r3, r4)
            if (r56 == 0) goto L_0x04ab
            if (r58 != 0) goto L_0x04ab
            if (r12 == r13) goto L_0x04aa
            if (r14 != r13) goto L_0x04ab
        L_0x04aa:
            r4 = 4
        L_0x04ab:
            int r6 = r49.getMargin()
            r10.addEquality(r5, r1, r6, r4)
            int r6 = r50.getMargin()
            int r6 = -r6
            r10.addEquality(r11, r2, r6, r4)
        L_0x04ba:
            if (r42 == 0) goto L_0x04d0
            r6 = 0
            r7 = r45
            if (r7 != r1) goto L_0x04c5
            int r6 = r49.getMargin()
        L_0x04c5:
            if (r1 == r7) goto L_0x04cd
            r8 = r35
            r10.addGreaterThan(r5, r7, r6, r8)
            goto L_0x04d4
        L_0x04cd:
            r8 = r35
            goto L_0x04d4
        L_0x04d0:
            r7 = r45
            r8 = r35
        L_0x04d4:
            if (r42 == 0) goto L_0x04f3
            if (r23 == 0) goto L_0x04f3
            r6 = 8
            if (r53 != 0) goto L_0x04f3
            if (r18 != 0) goto L_0x04f3
            if (r23 == 0) goto L_0x04ec
            r9 = r44
            r15 = 3
            if (r9 != r15) goto L_0x04ea
            r15 = 0
            r10.addGreaterThan(r11, r5, r15, r6)
            goto L_0x0506
        L_0x04ea:
            r15 = 0
            goto L_0x04ef
        L_0x04ec:
            r9 = r44
            r15 = 0
        L_0x04ef:
            r10.addGreaterThan(r11, r5, r15, r8)
            goto L_0x0506
        L_0x04f3:
            r9 = r44
            goto L_0x0506
        L_0x04f6:
            r2 = r8
            r30 = r12
            r31 = r13
            r9 = r14
            r32 = r24
            r1 = r25
            r8 = r6
            r38 = r7
            r7 = r5
            r5 = r38
        L_0x0506:
            if (r42 == 0) goto L_0x051d
            if (r17 == 0) goto L_0x051d
            r3 = 0
            r4 = r50
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r4.mTarget
            if (r6 == 0) goto L_0x0515
            int r3 = r50.getMargin()
        L_0x0515:
            r12 = r46
            if (r2 == r12) goto L_0x0521
            r10.addGreaterThan(r12, r11, r3, r8)
            goto L_0x0521
        L_0x051d:
            r12 = r46
            r4 = r50
        L_0x0521:
            return
        L_0x0522:
            r4 = r50
            r5 = r7
            r2 = r8
            r30 = r12
            r31 = r13
            r9 = r14
            r32 = r24
            r1 = r25
            r6 = 8
            r7 = r45
            r12 = r46
        L_0x0535:
            r3 = r32
            r8 = 2
            if (r3 >= r8) goto L_0x0578
            if (r42 == 0) goto L_0x0578
            if (r17 == 0) goto L_0x0578
            r8 = 0
            r10.addGreaterThan(r5, r7, r8, r6)
            if (r41 != 0) goto L_0x054d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r0.mBaseline
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r8.mTarget
            if (r8 != 0) goto L_0x054b
            goto L_0x054d
        L_0x054b:
            r8 = 0
            goto L_0x054e
        L_0x054d:
            r8 = 1
        L_0x054e:
            if (r41 != 0) goto L_0x0570
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r13 = r0.mBaseline
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r13 = r13.mTarget
            if (r13 == 0) goto L_0x0570
            androidx.constraintlayout.solver.widgets.ConstraintWidget r13 = r13.mOwner
            float r14 = r13.mDimensionRatio
            r15 = 0
            int r14 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1))
            if (r14 == 0) goto L_0x056f
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r14 = r13.mListDimensionBehaviors
            r15 = 0
            r6 = r14[r15]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r15) goto L_0x056f
            r6 = 1
            r6 = r14[r6]
            if (r6 != r15) goto L_0x056f
            r8 = 1
            goto L_0x0570
        L_0x056f:
            r8 = 0
        L_0x0570:
            if (r8 == 0) goto L_0x0578
            r6 = 0
            r13 = 8
            r10.addGreaterThan(r12, r11, r6, r13)
        L_0x0578:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.applyConstraints(androidx.constraintlayout.solver.LinearSystem, boolean, boolean, boolean, boolean, androidx.constraintlayout.solver.SolverVariable, androidx.constraintlayout.solver.SolverVariable, androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.solver.widgets.ConstraintAnchor, androidx.constraintlayout.solver.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    /* renamed from: androidx.constraintlayout.solver.widgets.ConstraintWidget$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour;

        static {
            int[] iArr = new int[DimensionBehaviour.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = iArr;
            try {
                iArr[DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            int[] iArr2 = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = iArr2;
            try {
                iArr2[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError e13) {
            }
        }
    }

    public void updateFromSolver(LinearSystem system) {
        int left = system.getObjectVariableValue(this.mLeft);
        int top = system.getObjectVariableValue(this.mTop);
        int right = system.getObjectVariableValue(this.mRight);
        int bottom = system.getObjectVariableValue(this.mBottom);
        HorizontalWidgetRun horizontalWidgetRun = this.horizontalRun;
        DependencyNode dependencyNode = horizontalWidgetRun.start;
        if (dependencyNode.resolved) {
            DependencyNode dependencyNode2 = horizontalWidgetRun.end;
            if (dependencyNode2.resolved) {
                left = dependencyNode.value;
                right = dependencyNode2.value;
            }
        }
        VerticalWidgetRun verticalWidgetRun = this.verticalRun;
        DependencyNode dependencyNode3 = verticalWidgetRun.start;
        if (dependencyNode3.resolved) {
            DependencyNode dependencyNode4 = verticalWidgetRun.end;
            if (dependencyNode4.resolved) {
                top = dependencyNode3.value;
                bottom = dependencyNode4.value;
            }
        }
        int h = bottom - top;
        if (right - left < 0 || h < 0 || left == Integer.MIN_VALUE || left == Integer.MAX_VALUE || top == Integer.MIN_VALUE || top == Integer.MAX_VALUE || right == Integer.MIN_VALUE || right == Integer.MAX_VALUE || bottom == Integer.MIN_VALUE || bottom == Integer.MAX_VALUE) {
            left = 0;
            top = 0;
            right = 0;
            bottom = 0;
        }
        setFrame(left, top, right, bottom);
    }

    public void copy(ConstraintWidget src, HashMap<ConstraintWidget, ConstraintWidget> map) {
        this.mHorizontalResolution = src.mHorizontalResolution;
        this.mVerticalResolution = src.mVerticalResolution;
        this.mMatchConstraintDefaultWidth = src.mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = src.mMatchConstraintDefaultHeight;
        int[] iArr = this.mResolvedMatchConstraintDefault;
        int[] iArr2 = src.mResolvedMatchConstraintDefault;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.mMatchConstraintMinWidth = src.mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = src.mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = src.mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = src.mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = src.mMatchConstraintPercentHeight;
        this.mIsWidthWrapContent = src.mIsWidthWrapContent;
        this.mIsHeightWrapContent = src.mIsHeightWrapContent;
        this.mResolvedDimensionRatioSide = src.mResolvedDimensionRatioSide;
        this.mResolvedDimensionRatio = src.mResolvedDimensionRatio;
        int[] iArr3 = src.mMaxDimension;
        this.mMaxDimension = Arrays.copyOf(iArr3, iArr3.length);
        this.mCircleConstraintAngle = src.mCircleConstraintAngle;
        this.hasBaseline = src.hasBaseline;
        this.inPlaceholder = src.inPlaceholder;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mListDimensionBehaviors = (DimensionBehaviour[]) Arrays.copyOf(this.mListDimensionBehaviors, 2);
        ConstraintWidget constraintWidget = null;
        this.mParent = this.mParent == null ? null : map.get(src.mParent);
        this.mWidth = src.mWidth;
        this.mHeight = src.mHeight;
        this.mDimensionRatio = src.mDimensionRatio;
        this.mDimensionRatioSide = src.mDimensionRatioSide;
        this.mX = src.mX;
        this.mY = src.mY;
        this.mRelX = src.mRelX;
        this.mRelY = src.mRelY;
        this.mOffsetX = src.mOffsetX;
        this.mOffsetY = src.mOffsetY;
        this.mBaselineDistance = src.mBaselineDistance;
        this.mMinWidth = src.mMinWidth;
        this.mMinHeight = src.mMinHeight;
        this.mHorizontalBiasPercent = src.mHorizontalBiasPercent;
        this.mVerticalBiasPercent = src.mVerticalBiasPercent;
        this.mCompanionWidget = src.mCompanionWidget;
        this.mContainerItemSkip = src.mContainerItemSkip;
        this.mVisibility = src.mVisibility;
        this.mDebugName = src.mDebugName;
        this.mType = src.mType;
        this.mDistToTop = src.mDistToTop;
        this.mDistToLeft = src.mDistToLeft;
        this.mDistToRight = src.mDistToRight;
        this.mDistToBottom = src.mDistToBottom;
        this.mLeftHasCentered = src.mLeftHasCentered;
        this.mRightHasCentered = src.mRightHasCentered;
        this.mTopHasCentered = src.mTopHasCentered;
        this.mBottomHasCentered = src.mBottomHasCentered;
        this.mHorizontalWrapVisited = src.mHorizontalWrapVisited;
        this.mVerticalWrapVisited = src.mVerticalWrapVisited;
        this.mOptimizerMeasurable = src.mOptimizerMeasurable;
        this.mGroupsToSolver = src.mGroupsToSolver;
        this.mHorizontalChainStyle = src.mHorizontalChainStyle;
        this.mVerticalChainStyle = src.mVerticalChainStyle;
        this.mHorizontalChainFixedPosition = src.mHorizontalChainFixedPosition;
        this.mVerticalChainFixedPosition = src.mVerticalChainFixedPosition;
        float[] fArr = this.mWeight;
        float[] fArr2 = src.mWeight;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.mListNextMatchConstraintsWidget;
        ConstraintWidget[] constraintWidgetArr2 = src.mListNextMatchConstraintsWidget;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.mNextChainWidget;
        ConstraintWidget[] constraintWidgetArr4 = src.mNextChainWidget;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget2 = src.mHorizontalNextWidget;
        this.mHorizontalNextWidget = constraintWidget2 == null ? null : map.get(constraintWidget2);
        ConstraintWidget constraintWidget3 = src.mVerticalNextWidget;
        if (constraintWidget3 != null) {
            constraintWidget = map.get(constraintWidget3);
        }
        this.mVerticalNextWidget = constraintWidget;
    }

    public void updateFromRuns(boolean updateHorizontal, boolean updateVertical) {
        boolean updateHorizontal2 = updateHorizontal & this.horizontalRun.isResolved();
        boolean updateVertical2 = updateVertical & this.verticalRun.isResolved();
        HorizontalWidgetRun horizontalWidgetRun = this.horizontalRun;
        int left = horizontalWidgetRun.start.value;
        VerticalWidgetRun verticalWidgetRun = this.verticalRun;
        int top = verticalWidgetRun.start.value;
        int right = horizontalWidgetRun.end.value;
        int bottom = verticalWidgetRun.end.value;
        int h = bottom - top;
        if (right - left < 0 || h < 0 || left == Integer.MIN_VALUE || left == Integer.MAX_VALUE || top == Integer.MIN_VALUE || top == Integer.MAX_VALUE || right == Integer.MIN_VALUE || right == Integer.MAX_VALUE || bottom == Integer.MIN_VALUE || bottom == Integer.MAX_VALUE) {
            left = 0;
            top = 0;
            right = 0;
            bottom = 0;
        }
        int w = right - left;
        int h2 = bottom - top;
        if (updateHorizontal2) {
            this.mX = left;
        }
        if (updateVertical2) {
            this.mY = top;
        }
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (updateHorizontal2) {
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && w < this.mWidth) {
                w = this.mWidth;
            }
            this.mWidth = w;
            int i = this.mMinWidth;
            if (w < i) {
                this.mWidth = i;
            }
        }
        if (updateVertical2) {
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && h2 < this.mHeight) {
                h2 = this.mHeight;
            }
            this.mHeight = h2;
            int i2 = this.mMinHeight;
            if (h2 < i2) {
                this.mHeight = i2;
            }
        }
    }
}
