package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ConstraintSet {
    private static final int ALPHA = 43;
    private static final int ANIMATE_RELATIVE_TO = 64;
    private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
    private static final int BARRIER_DIRECTION = 72;
    private static final int BARRIER_MARGIN = 73;
    private static final int BARRIER_TYPE = 1;
    public static final int BASELINE = 5;
    private static final int BASELINE_TO_BASELINE = 1;
    public static final int BOTTOM = 4;
    private static final int BOTTOM_MARGIN = 2;
    private static final int BOTTOM_TO_BOTTOM = 3;
    private static final int BOTTOM_TO_TOP = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    private static final int CHAIN_USE_RTL = 71;
    private static final int CIRCLE = 61;
    private static final int CIRCLE_ANGLE = 63;
    private static final int CIRCLE_RADIUS = 62;
    private static final int CONSTRAINED_HEIGHT = 81;
    private static final int CONSTRAINED_WIDTH = 80;
    private static final int CONSTRAINT_REFERENCED_IDS = 74;
    private static final int CONSTRAINT_TAG = 77;
    private static final boolean DEBUG = false;
    private static final int DIMENSION_RATIO = 5;
    private static final int DRAW_PATH = 66;
    private static final int EDITOR_ABSOLUTE_X = 6;
    private static final int EDITOR_ABSOLUTE_Y = 7;
    private static final int ELEVATION = 44;
    public static final int END = 7;
    private static final int END_MARGIN = 8;
    private static final int END_TO_END = 9;
    private static final int END_TO_START = 10;
    private static final String ERROR_MESSAGE = "XML parser error must be within a Constraint ";
    public static final int GONE = 8;
    private static final int GONE_BOTTOM_MARGIN = 11;
    private static final int GONE_END_MARGIN = 12;
    private static final int GONE_LEFT_MARGIN = 13;
    private static final int GONE_RIGHT_MARGIN = 14;
    private static final int GONE_START_MARGIN = 15;
    private static final int GONE_TOP_MARGIN = 16;
    private static final int GUIDE_BEGIN = 17;
    private static final int GUIDE_END = 18;
    private static final int GUIDE_PERCENT = 19;
    private static final int HEIGHT_DEFAULT = 55;
    private static final int HEIGHT_MAX = 57;
    private static final int HEIGHT_MIN = 59;
    private static final int HEIGHT_PERCENT = 70;
    public static final int HORIZONTAL = 0;
    private static final int HORIZONTAL_BIAS = 20;
    public static final int HORIZONTAL_GUIDELINE = 0;
    private static final int HORIZONTAL_STYLE = 41;
    private static final int HORIZONTAL_WEIGHT = 39;
    public static final int INVISIBLE = 4;
    private static final int LAYOUT_HEIGHT = 21;
    private static final int LAYOUT_VISIBILITY = 22;
    private static final int LAYOUT_WIDTH = 23;
    public static final int LEFT = 1;
    private static final int LEFT_MARGIN = 24;
    private static final int LEFT_TO_LEFT = 25;
    private static final int LEFT_TO_RIGHT = 26;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    private static final int MOTION_STAGGER = 79;
    private static final int ORIENTATION = 27;
    public static final int PARENT_ID = 0;
    private static final int PATH_MOTION_ARC = 76;
    private static final int PROGRESS = 68;
    public static final int RIGHT = 2;
    private static final int RIGHT_MARGIN = 28;
    private static final int RIGHT_TO_LEFT = 29;
    private static final int RIGHT_TO_RIGHT = 30;
    private static final int ROTATION = 60;
    private static final int ROTATION_X = 45;
    private static final int ROTATION_Y = 46;
    private static final int SCALE_X = 47;
    private static final int SCALE_Y = 48;
    public static final int START = 6;
    private static final int START_MARGIN = 31;
    private static final int START_TO_END = 32;
    private static final int START_TO_START = 33;
    private static final String TAG = "ConstraintSet";
    public static final int TOP = 3;
    private static final int TOP_MARGIN = 34;
    private static final int TOP_TO_BOTTOM = 35;
    private static final int TOP_TO_TOP = 36;
    private static final int TRANSFORM_PIVOT_X = 49;
    private static final int TRANSFORM_PIVOT_Y = 50;
    private static final int TRANSITION_EASING = 65;
    private static final int TRANSITION_PATH_ROTATE = 67;
    private static final int TRANSLATION_X = 51;
    private static final int TRANSLATION_Y = 52;
    private static final int TRANSLATION_Z = 53;
    public static final int UNSET = -1;
    private static final int UNUSED = 82;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_BIAS = 37;
    public static final int VERTICAL_GUIDELINE = 1;
    private static final int VERTICAL_STYLE = 42;
    private static final int VERTICAL_WEIGHT = 40;
    private static final int VIEW_ID = 38;
    /* access modifiers changed from: private */
    public static final int[] VISIBILITY_FLAGS = {0, 4, 8};
    private static final int VISIBILITY_MODE = 78;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 0;
    private static final int WIDTH_DEFAULT = 54;
    private static final int WIDTH_MAX = 56;
    private static final int WIDTH_MIN = 58;
    private static final int WIDTH_PERCENT = 69;
    public static final int WRAP_CONTENT = -2;
    private static SparseIntArray mapToConstant;
    private HashMap<Integer, Constraint> mConstraints = new HashMap<>();
    private boolean mForceId = true;
    private HashMap<String, ConstraintAttribute> mSavedAttributes = new HashMap<>();
    private boolean mValidate;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        mapToConstant = sparseIntArray;
        sparseIntArray.append(R.styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_toRightOf, 30);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_toTopOf, 36);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        mapToConstant.append(R.styleable.Constraint_layout_editor_absoluteX, 6);
        mapToConstant.append(R.styleable.Constraint_layout_editor_absoluteY, 7);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_begin, 17);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_end, 18);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_percent, 19);
        mapToConstant.append(R.styleable.Constraint_android_orientation, 27);
        mapToConstant.append(R.styleable.Constraint_layout_constraintStart_toEndOf, 32);
        mapToConstant.append(R.styleable.Constraint_layout_constraintStart_toStartOf, 33);
        mapToConstant.append(R.styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        mapToConstant.append(R.styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginLeft, 13);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginTop, 16);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginRight, 14);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginBottom, 11);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginStart, 15);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginEnd, 12);
        mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_weight, 40);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_weight, 39);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_bias, 20);
        mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_bias, 37);
        mapToConstant.append(R.styleable.Constraint_layout_constraintDimensionRatio, 5);
        mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_creator, 82);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_creator, 82);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_creator, 82);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_creator, 82);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_creator, 82);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginLeft, 24);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginRight, 28);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginStart, 31);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginEnd, 8);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginTop, 34);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginBottom, 2);
        mapToConstant.append(R.styleable.Constraint_android_layout_width, 23);
        mapToConstant.append(R.styleable.Constraint_android_layout_height, 21);
        mapToConstant.append(R.styleable.Constraint_android_visibility, 22);
        mapToConstant.append(R.styleable.Constraint_android_alpha, 43);
        mapToConstant.append(R.styleable.Constraint_android_elevation, 44);
        mapToConstant.append(R.styleable.Constraint_android_rotationX, 45);
        mapToConstant.append(R.styleable.Constraint_android_rotationY, 46);
        mapToConstant.append(R.styleable.Constraint_android_rotation, 60);
        mapToConstant.append(R.styleable.Constraint_android_scaleX, 47);
        mapToConstant.append(R.styleable.Constraint_android_scaleY, 48);
        mapToConstant.append(R.styleable.Constraint_android_transformPivotX, 49);
        mapToConstant.append(R.styleable.Constraint_android_transformPivotY, 50);
        mapToConstant.append(R.styleable.Constraint_android_translationX, 51);
        mapToConstant.append(R.styleable.Constraint_android_translationY, 52);
        mapToConstant.append(R.styleable.Constraint_android_translationZ, 53);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_default, 54);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_default, 55);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_max, 56);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_max, 57);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_min, 58);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_min, 59);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircle, 61);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircleRadius, 62);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircleAngle, 63);
        mapToConstant.append(R.styleable.Constraint_animate_relativeTo, 64);
        mapToConstant.append(R.styleable.Constraint_transitionEasing, 65);
        mapToConstant.append(R.styleable.Constraint_drawPath, 66);
        mapToConstant.append(R.styleable.Constraint_transitionPathRotate, 67);
        mapToConstant.append(R.styleable.Constraint_motionStagger, 79);
        mapToConstant.append(R.styleable.Constraint_android_id, 38);
        mapToConstant.append(R.styleable.Constraint_motionProgress, 68);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_percent, 69);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_percent, 70);
        mapToConstant.append(R.styleable.Constraint_chainUseRtl, 71);
        mapToConstant.append(R.styleable.Constraint_barrierDirection, 72);
        mapToConstant.append(R.styleable.Constraint_barrierMargin, 73);
        mapToConstant.append(R.styleable.Constraint_constraint_referenced_ids, 74);
        mapToConstant.append(R.styleable.Constraint_barrierAllowsGoneWidgets, 75);
        mapToConstant.append(R.styleable.Constraint_pathMotionArc, 76);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTag, 77);
        mapToConstant.append(R.styleable.Constraint_visibilityMode, 78);
        mapToConstant.append(R.styleable.Constraint_layout_constrainedWidth, 80);
        mapToConstant.append(R.styleable.Constraint_layout_constrainedHeight, 81);
    }

    public HashMap<String, ConstraintAttribute> getCustomAttributeSet() {
        return this.mSavedAttributes;
    }

    public Constraint getParameters(int mId) {
        return get(mId);
    }

    public void readFallback(ConstraintSet set) {
        for (Integer key : set.mConstraints.keySet()) {
            int id = key.intValue();
            Constraint parent = set.mConstraints.get(key);
            if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                this.mConstraints.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
            Layout layout = constraint.layout;
            if (!layout.mApply) {
                layout.copyFrom(parent.layout);
            }
            PropertySet propertySet = constraint.propertySet;
            if (!propertySet.mApply) {
                propertySet.copyFrom(parent.propertySet);
            }
            Transform transform = constraint.transform;
            if (!transform.mApply) {
                transform.copyFrom(parent.transform);
            }
            Motion motion = constraint.motion;
            if (!motion.mApply) {
                motion.copyFrom(parent.motion);
            }
            for (String s : parent.mCustomConstraints.keySet()) {
                if (!constraint.mCustomConstraints.containsKey(s)) {
                    constraint.mCustomConstraints.put(s, parent.mCustomConstraints.get(s));
                }
            }
        }
    }

    public void readFallback(ConstraintLayout constraintLayout) {
        int count = constraintLayout.getChildCount();
        int i = 0;
        while (i < count) {
            View view = constraintLayout.getChildAt(i);
            ConstraintLayout.LayoutParams param = (ConstraintLayout.LayoutParams) view.getLayoutParams();
            int id = view.getId();
            if (!this.mForceId || id != -1) {
                if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                    this.mConstraints.put(Integer.valueOf(id), new Constraint());
                }
                Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
                if (!constraint.layout.mApply) {
                    constraint.fillFrom(id, param);
                    if (view instanceof ConstraintHelper) {
                        constraint.layout.mReferenceIds = ((ConstraintHelper) view).getReferencedIds();
                        if (view instanceof Barrier) {
                            Barrier barrier = (Barrier) view;
                            constraint.layout.mBarrierAllowsGoneWidgets = barrier.allowsGoneWidget();
                            constraint.layout.mBarrierDirection = barrier.getType();
                            constraint.layout.mBarrierMargin = barrier.getMargin();
                        }
                    }
                    constraint.layout.mApply = true;
                }
                PropertySet propertySet = constraint.propertySet;
                if (!propertySet.mApply) {
                    propertySet.visibility = view.getVisibility();
                    constraint.propertySet.alpha = view.getAlpha();
                    constraint.propertySet.mApply = true;
                }
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 17) {
                    Transform transform = constraint.transform;
                    if (!transform.mApply) {
                        transform.mApply = true;
                        transform.rotation = view.getRotation();
                        constraint.transform.rotationX = view.getRotationX();
                        constraint.transform.rotationY = view.getRotationY();
                        constraint.transform.scaleX = view.getScaleX();
                        constraint.transform.scaleY = view.getScaleY();
                        float pivotX = view.getPivotX();
                        float pivotY = view.getPivotY();
                        if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                            Transform transform2 = constraint.transform;
                            transform2.transformPivotX = pivotX;
                            transform2.transformPivotY = pivotY;
                        }
                        constraint.transform.translationX = view.getTranslationX();
                        constraint.transform.translationY = view.getTranslationY();
                        if (i2 >= 21) {
                            constraint.transform.translationZ = view.getTranslationZ();
                            Transform transform3 = constraint.transform;
                            if (transform3.applyElevation) {
                                transform3.elevation = view.getElevation();
                            }
                        }
                    }
                }
                i++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public static class Layout {
        private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
        private static final int BARRIER_DIRECTION = 72;
        private static final int BARRIER_MARGIN = 73;
        private static final int BASELINE_TO_BASELINE = 1;
        private static final int BOTTOM_MARGIN = 2;
        private static final int BOTTOM_TO_BOTTOM = 3;
        private static final int BOTTOM_TO_TOP = 4;
        private static final int CHAIN_USE_RTL = 71;
        private static final int CIRCLE = 61;
        private static final int CIRCLE_ANGLE = 63;
        private static final int CIRCLE_RADIUS = 62;
        private static final int CONSTRAINT_REFERENCED_IDS = 74;
        private static final int DIMENSION_RATIO = 5;
        private static final int EDITOR_ABSOLUTE_X = 6;
        private static final int EDITOR_ABSOLUTE_Y = 7;
        private static final int END_MARGIN = 8;
        private static final int END_TO_END = 9;
        private static final int END_TO_START = 10;
        private static final int GONE_BOTTOM_MARGIN = 11;
        private static final int GONE_END_MARGIN = 12;
        private static final int GONE_LEFT_MARGIN = 13;
        private static final int GONE_RIGHT_MARGIN = 14;
        private static final int GONE_START_MARGIN = 15;
        private static final int GONE_TOP_MARGIN = 16;
        private static final int GUIDE_BEGIN = 17;
        private static final int GUIDE_END = 18;
        private static final int GUIDE_PERCENT = 19;
        private static final int HEIGHT_PERCENT = 70;
        private static final int HORIZONTAL_BIAS = 20;
        private static final int HORIZONTAL_STYLE = 39;
        private static final int HORIZONTAL_WEIGHT = 37;
        private static final int LAYOUT_HEIGHT = 21;
        private static final int LAYOUT_WIDTH = 22;
        private static final int LEFT_MARGIN = 23;
        private static final int LEFT_TO_LEFT = 24;
        private static final int LEFT_TO_RIGHT = 25;
        private static final int ORIENTATION = 26;
        private static final int RIGHT_MARGIN = 27;
        private static final int RIGHT_TO_LEFT = 28;
        private static final int RIGHT_TO_RIGHT = 29;
        private static final int START_MARGIN = 30;
        private static final int START_TO_END = 31;
        private static final int START_TO_START = 32;
        private static final int TOP_MARGIN = 33;
        private static final int TOP_TO_BOTTOM = 34;
        private static final int TOP_TO_TOP = 35;
        public static final int UNSET = -1;
        private static final int UNUSED = 76;
        private static final int VERTICAL_BIAS = 36;
        private static final int VERTICAL_STYLE = 40;
        private static final int VERTICAL_WEIGHT = 38;
        private static final int WIDTH_PERCENT = 69;
        private static SparseIntArray mapToConstant;
        public int baselineToBaseline = -1;
        public int bottomMargin = -1;
        public int bottomToBottom = -1;
        public int bottomToTop = -1;
        public float circleAngle = 0.0f;
        public int circleConstraint = -1;
        public int circleRadius = 0;
        public boolean constrainedHeight = false;
        public boolean constrainedWidth = false;
        public String dimensionRatio = null;
        public int editorAbsoluteX = -1;
        public int editorAbsoluteY = -1;
        public int endMargin = -1;
        public int endToEnd = -1;
        public int endToStart = -1;
        public int goneBottomMargin = -1;
        public int goneEndMargin = -1;
        public int goneLeftMargin = -1;
        public int goneRightMargin = -1;
        public int goneStartMargin = -1;
        public int goneTopMargin = -1;
        public int guideBegin = -1;
        public int guideEnd = -1;
        public float guidePercent = -1.0f;
        public int heightDefault = 0;
        public int heightMax = -1;
        public int heightMin = -1;
        public float heightPercent = 1.0f;
        public float horizontalBias = 0.5f;
        public int horizontalChainStyle = 0;
        public float horizontalWeight = -1.0f;
        public int leftMargin = -1;
        public int leftToLeft = -1;
        public int leftToRight = -1;
        public boolean mApply = false;
        public boolean mBarrierAllowsGoneWidgets = true;
        public int mBarrierDirection = -1;
        public int mBarrierMargin = 0;
        public String mConstraintTag;
        public int mHeight;
        public int mHelperType = -1;
        public boolean mIsGuideline = false;
        public String mReferenceIdString;
        public int[] mReferenceIds;
        public int mWidth;
        public int orientation = -1;
        public int rightMargin = -1;
        public int rightToLeft = -1;
        public int rightToRight = -1;
        public int startMargin = -1;
        public int startToEnd = -1;
        public int startToStart = -1;
        public int topMargin = -1;
        public int topToBottom = -1;
        public int topToTop = -1;
        public float verticalBias = 0.5f;
        public int verticalChainStyle = 0;
        public float verticalWeight = -1.0f;
        public int widthDefault = 0;
        public int widthMax = -1;
        public int widthMin = -1;
        public float widthPercent = 1.0f;

        public void copyFrom(Layout src) {
            this.mIsGuideline = src.mIsGuideline;
            this.mWidth = src.mWidth;
            this.mApply = src.mApply;
            this.mHeight = src.mHeight;
            this.guideBegin = src.guideBegin;
            this.guideEnd = src.guideEnd;
            this.guidePercent = src.guidePercent;
            this.leftToLeft = src.leftToLeft;
            this.leftToRight = src.leftToRight;
            this.rightToLeft = src.rightToLeft;
            this.rightToRight = src.rightToRight;
            this.topToTop = src.topToTop;
            this.topToBottom = src.topToBottom;
            this.bottomToTop = src.bottomToTop;
            this.bottomToBottom = src.bottomToBottom;
            this.baselineToBaseline = src.baselineToBaseline;
            this.startToEnd = src.startToEnd;
            this.startToStart = src.startToStart;
            this.endToStart = src.endToStart;
            this.endToEnd = src.endToEnd;
            this.horizontalBias = src.horizontalBias;
            this.verticalBias = src.verticalBias;
            this.dimensionRatio = src.dimensionRatio;
            this.circleConstraint = src.circleConstraint;
            this.circleRadius = src.circleRadius;
            this.circleAngle = src.circleAngle;
            this.editorAbsoluteX = src.editorAbsoluteX;
            this.editorAbsoluteY = src.editorAbsoluteY;
            this.orientation = src.orientation;
            this.leftMargin = src.leftMargin;
            this.rightMargin = src.rightMargin;
            this.topMargin = src.topMargin;
            this.bottomMargin = src.bottomMargin;
            this.endMargin = src.endMargin;
            this.startMargin = src.startMargin;
            this.goneLeftMargin = src.goneLeftMargin;
            this.goneTopMargin = src.goneTopMargin;
            this.goneRightMargin = src.goneRightMargin;
            this.goneBottomMargin = src.goneBottomMargin;
            this.goneEndMargin = src.goneEndMargin;
            this.goneStartMargin = src.goneStartMargin;
            this.verticalWeight = src.verticalWeight;
            this.horizontalWeight = src.horizontalWeight;
            this.horizontalChainStyle = src.horizontalChainStyle;
            this.verticalChainStyle = src.verticalChainStyle;
            this.widthDefault = src.widthDefault;
            this.heightDefault = src.heightDefault;
            this.widthMax = src.widthMax;
            this.heightMax = src.heightMax;
            this.widthMin = src.widthMin;
            this.heightMin = src.heightMin;
            this.widthPercent = src.widthPercent;
            this.heightPercent = src.heightPercent;
            this.mBarrierDirection = src.mBarrierDirection;
            this.mBarrierMargin = src.mBarrierMargin;
            this.mHelperType = src.mHelperType;
            this.mConstraintTag = src.mConstraintTag;
            int[] iArr = src.mReferenceIds;
            if (iArr != null) {
                this.mReferenceIds = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.mReferenceIds = null;
            }
            this.mReferenceIdString = src.mReferenceIdString;
            this.constrainedWidth = src.constrainedWidth;
            this.constrainedHeight = src.constrainedHeight;
            this.mBarrierAllowsGoneWidgets = src.mBarrierAllowsGoneWidgets;
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(R.styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            mapToConstant.append(R.styleable.Layout_layout_constraintLeft_toRightOf, 25);
            mapToConstant.append(R.styleable.Layout_layout_constraintRight_toLeftOf, 28);
            mapToConstant.append(R.styleable.Layout_layout_constraintRight_toRightOf, 29);
            mapToConstant.append(R.styleable.Layout_layout_constraintTop_toTopOf, 35);
            mapToConstant.append(R.styleable.Layout_layout_constraintTop_toBottomOf, 34);
            mapToConstant.append(R.styleable.Layout_layout_constraintBottom_toTopOf, 4);
            mapToConstant.append(R.styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            mapToConstant.append(R.styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            mapToConstant.append(R.styleable.Layout_layout_editor_absoluteX, 6);
            mapToConstant.append(R.styleable.Layout_layout_editor_absoluteY, 7);
            mapToConstant.append(R.styleable.Layout_layout_constraintGuide_begin, 17);
            mapToConstant.append(R.styleable.Layout_layout_constraintGuide_end, 18);
            mapToConstant.append(R.styleable.Layout_layout_constraintGuide_percent, 19);
            mapToConstant.append(R.styleable.Layout_android_orientation, 26);
            mapToConstant.append(R.styleable.Layout_layout_constraintStart_toEndOf, 31);
            mapToConstant.append(R.styleable.Layout_layout_constraintStart_toStartOf, 32);
            mapToConstant.append(R.styleable.Layout_layout_constraintEnd_toStartOf, 10);
            mapToConstant.append(R.styleable.Layout_layout_constraintEnd_toEndOf, 9);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginLeft, 13);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginTop, 16);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginRight, 14);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginBottom, 11);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginStart, 15);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginEnd, 12);
            mapToConstant.append(R.styleable.Layout_layout_constraintVertical_weight, 38);
            mapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_weight, 37);
            mapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            mapToConstant.append(R.styleable.Layout_layout_constraintVertical_chainStyle, 40);
            mapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_bias, 20);
            mapToConstant.append(R.styleable.Layout_layout_constraintVertical_bias, 36);
            mapToConstant.append(R.styleable.Layout_layout_constraintDimensionRatio, 5);
            mapToConstant.append(R.styleable.Layout_layout_constraintLeft_creator, 76);
            mapToConstant.append(R.styleable.Layout_layout_constraintTop_creator, 76);
            mapToConstant.append(R.styleable.Layout_layout_constraintRight_creator, 76);
            mapToConstant.append(R.styleable.Layout_layout_constraintBottom_creator, 76);
            mapToConstant.append(R.styleable.Layout_layout_constraintBaseline_creator, 76);
            mapToConstant.append(R.styleable.Layout_android_layout_marginLeft, 23);
            mapToConstant.append(R.styleable.Layout_android_layout_marginRight, 27);
            mapToConstant.append(R.styleable.Layout_android_layout_marginStart, 30);
            mapToConstant.append(R.styleable.Layout_android_layout_marginEnd, 8);
            mapToConstant.append(R.styleable.Layout_android_layout_marginTop, 33);
            mapToConstant.append(R.styleable.Layout_android_layout_marginBottom, 2);
            mapToConstant.append(R.styleable.Layout_android_layout_width, 22);
            mapToConstant.append(R.styleable.Layout_android_layout_height, 21);
            mapToConstant.append(R.styleable.Layout_layout_constraintCircle, 61);
            mapToConstant.append(R.styleable.Layout_layout_constraintCircleRadius, 62);
            mapToConstant.append(R.styleable.Layout_layout_constraintCircleAngle, 63);
            mapToConstant.append(R.styleable.Layout_layout_constraintWidth_percent, 69);
            mapToConstant.append(R.styleable.Layout_layout_constraintHeight_percent, 70);
            mapToConstant.append(R.styleable.Layout_chainUseRtl, 71);
            mapToConstant.append(R.styleable.Layout_barrierDirection, 72);
            mapToConstant.append(R.styleable.Layout_barrierMargin, 73);
            mapToConstant.append(R.styleable.Layout_constraint_referenced_ids, 74);
            mapToConstant.append(R.styleable.Layout_barrierAllowsGoneWidgets, 75);
        }

        /* access modifiers changed from: package-private */
        public void fillFromAttributeList(Context context, AttributeSet attrs) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Layout);
            this.mApply = true;
            int N = a.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a.getIndex(i);
                switch (mapToConstant.get(attr)) {
                    case 1:
                        this.baselineToBaseline = ConstraintSet.lookupID(a, attr, this.baselineToBaseline);
                        break;
                    case 2:
                        this.bottomMargin = a.getDimensionPixelSize(attr, this.bottomMargin);
                        break;
                    case 3:
                        this.bottomToBottom = ConstraintSet.lookupID(a, attr, this.bottomToBottom);
                        break;
                    case 4:
                        this.bottomToTop = ConstraintSet.lookupID(a, attr, this.bottomToTop);
                        break;
                    case 5:
                        this.dimensionRatio = a.getString(attr);
                        break;
                    case 6:
                        this.editorAbsoluteX = a.getDimensionPixelOffset(attr, this.editorAbsoluteX);
                        break;
                    case 7:
                        this.editorAbsoluteY = a.getDimensionPixelOffset(attr, this.editorAbsoluteY);
                        break;
                    case 8:
                        if (Build.VERSION.SDK_INT < 17) {
                            break;
                        } else {
                            this.endMargin = a.getDimensionPixelSize(attr, this.endMargin);
                            break;
                        }
                    case 9:
                        this.endToEnd = ConstraintSet.lookupID(a, attr, this.endToEnd);
                        break;
                    case 10:
                        this.endToStart = ConstraintSet.lookupID(a, attr, this.endToStart);
                        break;
                    case 11:
                        this.goneBottomMargin = a.getDimensionPixelSize(attr, this.goneBottomMargin);
                        break;
                    case 12:
                        this.goneEndMargin = a.getDimensionPixelSize(attr, this.goneEndMargin);
                        break;
                    case 13:
                        this.goneLeftMargin = a.getDimensionPixelSize(attr, this.goneLeftMargin);
                        break;
                    case 14:
                        this.goneRightMargin = a.getDimensionPixelSize(attr, this.goneRightMargin);
                        break;
                    case 15:
                        this.goneStartMargin = a.getDimensionPixelSize(attr, this.goneStartMargin);
                        break;
                    case 16:
                        this.goneTopMargin = a.getDimensionPixelSize(attr, this.goneTopMargin);
                        break;
                    case 17:
                        this.guideBegin = a.getDimensionPixelOffset(attr, this.guideBegin);
                        break;
                    case 18:
                        this.guideEnd = a.getDimensionPixelOffset(attr, this.guideEnd);
                        break;
                    case 19:
                        this.guidePercent = a.getFloat(attr, this.guidePercent);
                        break;
                    case 20:
                        this.horizontalBias = a.getFloat(attr, this.horizontalBias);
                        break;
                    case 21:
                        this.mHeight = a.getLayoutDimension(attr, this.mHeight);
                        break;
                    case 22:
                        this.mWidth = a.getLayoutDimension(attr, this.mWidth);
                        break;
                    case 23:
                        this.leftMargin = a.getDimensionPixelSize(attr, this.leftMargin);
                        break;
                    case 24:
                        this.leftToLeft = ConstraintSet.lookupID(a, attr, this.leftToLeft);
                        break;
                    case 25:
                        this.leftToRight = ConstraintSet.lookupID(a, attr, this.leftToRight);
                        break;
                    case 26:
                        this.orientation = a.getInt(attr, this.orientation);
                        break;
                    case 27:
                        this.rightMargin = a.getDimensionPixelSize(attr, this.rightMargin);
                        break;
                    case 28:
                        this.rightToLeft = ConstraintSet.lookupID(a, attr, this.rightToLeft);
                        break;
                    case 29:
                        this.rightToRight = ConstraintSet.lookupID(a, attr, this.rightToRight);
                        break;
                    case 30:
                        if (Build.VERSION.SDK_INT < 17) {
                            break;
                        } else {
                            this.startMargin = a.getDimensionPixelSize(attr, this.startMargin);
                            break;
                        }
                    case 31:
                        this.startToEnd = ConstraintSet.lookupID(a, attr, this.startToEnd);
                        break;
                    case 32:
                        this.startToStart = ConstraintSet.lookupID(a, attr, this.startToStart);
                        break;
                    case 33:
                        this.topMargin = a.getDimensionPixelSize(attr, this.topMargin);
                        break;
                    case 34:
                        this.topToBottom = ConstraintSet.lookupID(a, attr, this.topToBottom);
                        break;
                    case 35:
                        this.topToTop = ConstraintSet.lookupID(a, attr, this.topToTop);
                        break;
                    case 36:
                        this.verticalBias = a.getFloat(attr, this.verticalBias);
                        break;
                    case 37:
                        this.horizontalWeight = a.getFloat(attr, this.horizontalWeight);
                        break;
                    case 38:
                        this.verticalWeight = a.getFloat(attr, this.verticalWeight);
                        break;
                    case 39:
                        this.horizontalChainStyle = a.getInt(attr, this.horizontalChainStyle);
                        break;
                    case 40:
                        this.verticalChainStyle = a.getInt(attr, this.verticalChainStyle);
                        break;
                    case 54:
                        this.widthDefault = a.getInt(attr, this.widthDefault);
                        break;
                    case 55:
                        this.heightDefault = a.getInt(attr, this.heightDefault);
                        break;
                    case 56:
                        this.widthMax = a.getDimensionPixelSize(attr, this.widthMax);
                        break;
                    case 57:
                        this.heightMax = a.getDimensionPixelSize(attr, this.heightMax);
                        break;
                    case 58:
                        this.widthMin = a.getDimensionPixelSize(attr, this.widthMin);
                        break;
                    case 59:
                        this.heightMin = a.getDimensionPixelSize(attr, this.heightMin);
                        break;
                    case 61:
                        this.circleConstraint = ConstraintSet.lookupID(a, attr, this.circleConstraint);
                        break;
                    case 62:
                        this.circleRadius = a.getDimensionPixelSize(attr, this.circleRadius);
                        break;
                    case 63:
                        this.circleAngle = a.getFloat(attr, this.circleAngle);
                        break;
                    case 69:
                        this.widthPercent = a.getFloat(attr, 1.0f);
                        break;
                    case 70:
                        this.heightPercent = a.getFloat(attr, 1.0f);
                        break;
                    case 71:
                        Log.e(ConstraintSet.TAG, "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        this.mBarrierDirection = a.getInt(attr, this.mBarrierDirection);
                        break;
                    case 73:
                        this.mBarrierMargin = a.getDimensionPixelSize(attr, this.mBarrierMargin);
                        break;
                    case 74:
                        this.mReferenceIdString = a.getString(attr);
                        break;
                    case 75:
                        this.mBarrierAllowsGoneWidgets = a.getBoolean(attr, this.mBarrierAllowsGoneWidgets);
                        break;
                    case 76:
                        Log.w(ConstraintSet.TAG, "unused attribute 0x" + Integer.toHexString(attr) + "   " + mapToConstant.get(attr));
                        break;
                    case 77:
                        this.mConstraintTag = a.getString(attr);
                        break;
                    case 80:
                        this.constrainedWidth = a.getBoolean(attr, this.constrainedWidth);
                        break;
                    case 81:
                        this.constrainedHeight = a.getBoolean(attr, this.constrainedHeight);
                        break;
                    default:
                        Log.w(ConstraintSet.TAG, "Unknown attribute 0x" + Integer.toHexString(attr) + "   " + mapToConstant.get(attr));
                        break;
                }
            }
            a.recycle();
        }

        public void dump(MotionScene scene, StringBuilder stringBuilder) {
            Field[] fields = getClass().getDeclaredFields();
            stringBuilder.append("\n");
            for (Field field : fields) {
                String name = field.getName();
                if (!Modifier.isStatic(field.getModifiers())) {
                    try {
                        Object value = field.get(this);
                        Class<?> type = field.getType();
                        if (type == Integer.TYPE) {
                            Integer iValue = (Integer) value;
                            if (iValue.intValue() != -1) {
                                String stringid = scene.lookUpConstraintName(iValue.intValue());
                                stringBuilder.append("    ");
                                stringBuilder.append(name);
                                stringBuilder.append(" = \"");
                                stringBuilder.append(stringid == null ? iValue : stringid);
                                stringBuilder.append("\"\n");
                            }
                        } else if (type == Float.TYPE) {
                            Float fValue = (Float) value;
                            if (fValue.floatValue() != -1.0f) {
                                stringBuilder.append("    ");
                                stringBuilder.append(name);
                                stringBuilder.append(" = \"");
                                stringBuilder.append(fValue);
                                stringBuilder.append("\"\n");
                            }
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static class Transform {
        private static final int ELEVATION = 11;
        private static final int ROTATION = 1;
        private static final int ROTATION_X = 2;
        private static final int ROTATION_Y = 3;
        private static final int SCALE_X = 4;
        private static final int SCALE_Y = 5;
        private static final int TRANSFORM_PIVOT_X = 6;
        private static final int TRANSFORM_PIVOT_Y = 7;
        private static final int TRANSLATION_X = 8;
        private static final int TRANSLATION_Y = 9;
        private static final int TRANSLATION_Z = 10;
        private static SparseIntArray mapToConstant;
        public boolean applyElevation = false;
        public float elevation = 0.0f;
        public boolean mApply = false;
        public float rotation = 0.0f;
        public float rotationX = 0.0f;
        public float rotationY = 0.0f;
        public float scaleX = 1.0f;
        public float scaleY = 1.0f;
        public float transformPivotX = Float.NaN;
        public float transformPivotY = Float.NaN;
        public float translationX = 0.0f;
        public float translationY = 0.0f;
        public float translationZ = 0.0f;

        public void copyFrom(Transform src) {
            this.mApply = src.mApply;
            this.rotation = src.rotation;
            this.rotationX = src.rotationX;
            this.rotationY = src.rotationY;
            this.scaleX = src.scaleX;
            this.scaleY = src.scaleY;
            this.transformPivotX = src.transformPivotX;
            this.transformPivotY = src.transformPivotY;
            this.translationX = src.translationX;
            this.translationY = src.translationY;
            this.translationZ = src.translationZ;
            this.applyElevation = src.applyElevation;
            this.elevation = src.elevation;
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(R.styleable.Transform_android_rotation, 1);
            mapToConstant.append(R.styleable.Transform_android_rotationX, 2);
            mapToConstant.append(R.styleable.Transform_android_rotationY, 3);
            mapToConstant.append(R.styleable.Transform_android_scaleX, 4);
            mapToConstant.append(R.styleable.Transform_android_scaleY, 5);
            mapToConstant.append(R.styleable.Transform_android_transformPivotX, 6);
            mapToConstant.append(R.styleable.Transform_android_transformPivotY, 7);
            mapToConstant.append(R.styleable.Transform_android_translationX, 8);
            mapToConstant.append(R.styleable.Transform_android_translationY, 9);
            mapToConstant.append(R.styleable.Transform_android_translationZ, 10);
            mapToConstant.append(R.styleable.Transform_android_elevation, 11);
        }

        /* access modifiers changed from: package-private */
        public void fillFromAttributeList(Context context, AttributeSet attrs) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Transform);
            this.mApply = true;
            int N = a.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a.getIndex(i);
                switch (mapToConstant.get(attr)) {
                    case 1:
                        this.rotation = a.getFloat(attr, this.rotation);
                        break;
                    case 2:
                        this.rotationX = a.getFloat(attr, this.rotationX);
                        break;
                    case 3:
                        this.rotationY = a.getFloat(attr, this.rotationY);
                        break;
                    case 4:
                        this.scaleX = a.getFloat(attr, this.scaleX);
                        break;
                    case 5:
                        this.scaleY = a.getFloat(attr, this.scaleY);
                        break;
                    case 6:
                        this.transformPivotX = a.getDimension(attr, this.transformPivotX);
                        break;
                    case 7:
                        this.transformPivotY = a.getDimension(attr, this.transformPivotY);
                        break;
                    case 8:
                        this.translationX = a.getDimension(attr, this.translationX);
                        break;
                    case 9:
                        this.translationY = a.getDimension(attr, this.translationY);
                        break;
                    case 10:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            this.translationZ = a.getDimension(attr, this.translationZ);
                            break;
                        }
                    case 11:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            this.applyElevation = true;
                            this.elevation = a.getDimension(attr, this.elevation);
                            break;
                        }
                }
            }
            a.recycle();
        }
    }

    public static class PropertySet {
        public float alpha = 1.0f;
        public boolean mApply = false;
        public float mProgress = Float.NaN;
        public int mVisibilityMode = 0;
        public int visibility = 0;

        public void copyFrom(PropertySet src) {
            this.mApply = src.mApply;
            this.visibility = src.visibility;
            this.alpha = src.alpha;
            this.mProgress = src.mProgress;
            this.mVisibilityMode = src.mVisibilityMode;
        }

        /* access modifiers changed from: package-private */
        public void fillFromAttributeList(Context context, AttributeSet attrs) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.PropertySet);
            this.mApply = true;
            int N = a.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a.getIndex(i);
                if (attr == R.styleable.PropertySet_android_alpha) {
                    this.alpha = a.getFloat(attr, this.alpha);
                } else if (attr == R.styleable.PropertySet_android_visibility) {
                    this.visibility = a.getInt(attr, this.visibility);
                    this.visibility = ConstraintSet.VISIBILITY_FLAGS[this.visibility];
                } else if (attr == R.styleable.PropertySet_visibilityMode) {
                    this.mVisibilityMode = a.getInt(attr, this.mVisibilityMode);
                } else if (attr == R.styleable.PropertySet_motionProgress) {
                    this.mProgress = a.getFloat(attr, this.mProgress);
                }
            }
            a.recycle();
        }
    }

    public static class Motion {
        private static final int ANIMATE_RELATIVE_TO = 5;
        private static final int MOTION_DRAW_PATH = 4;
        private static final int MOTION_STAGGER = 6;
        private static final int PATH_MOTION_ARC = 2;
        private static final int TRANSITION_EASING = 3;
        private static final int TRANSITION_PATH_ROTATE = 1;
        private static SparseIntArray mapToConstant;
        public int mAnimateRelativeTo = -1;
        public boolean mApply = false;
        public int mDrawPath = 0;
        public float mMotionStagger = Float.NaN;
        public int mPathMotionArc = -1;
        public float mPathRotate = Float.NaN;
        public String mTransitionEasing = null;

        public void copyFrom(Motion src) {
            this.mApply = src.mApply;
            this.mAnimateRelativeTo = src.mAnimateRelativeTo;
            this.mTransitionEasing = src.mTransitionEasing;
            this.mPathMotionArc = src.mPathMotionArc;
            this.mDrawPath = src.mDrawPath;
            this.mPathRotate = src.mPathRotate;
            this.mMotionStagger = src.mMotionStagger;
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(R.styleable.Motion_motionPathRotate, 1);
            mapToConstant.append(R.styleable.Motion_pathMotionArc, 2);
            mapToConstant.append(R.styleable.Motion_transitionEasing, 3);
            mapToConstant.append(R.styleable.Motion_drawPath, 4);
            mapToConstant.append(R.styleable.Motion_animate_relativeTo, 5);
            mapToConstant.append(R.styleable.Motion_motionStagger, 6);
        }

        /* access modifiers changed from: package-private */
        public void fillFromAttributeList(Context context, AttributeSet attrs) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Motion);
            this.mApply = true;
            int N = a.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a.getIndex(i);
                switch (mapToConstant.get(attr)) {
                    case 1:
                        this.mPathRotate = a.getFloat(attr, this.mPathRotate);
                        break;
                    case 2:
                        this.mPathMotionArc = a.getInt(attr, this.mPathMotionArc);
                        break;
                    case 3:
                        if (a.peekValue(attr).type != 3) {
                            this.mTransitionEasing = Easing.NAMED_EASING[a.getInteger(attr, 0)];
                            break;
                        } else {
                            this.mTransitionEasing = a.getString(attr);
                            break;
                        }
                    case 4:
                        this.mDrawPath = a.getInt(attr, 0);
                        break;
                    case 5:
                        this.mAnimateRelativeTo = ConstraintSet.lookupID(a, attr, this.mAnimateRelativeTo);
                        break;
                    case 6:
                        this.mMotionStagger = a.getFloat(attr, this.mMotionStagger);
                        break;
                }
            }
            a.recycle();
        }
    }

    public static class Constraint {
        public final Layout layout = new Layout();
        public HashMap<String, ConstraintAttribute> mCustomConstraints = new HashMap<>();
        int mViewId;
        public final Motion motion = new Motion();
        public final PropertySet propertySet = new PropertySet();
        public final Transform transform = new Transform();

        private ConstraintAttribute get(String attributeName, ConstraintAttribute.AttributeType attributeType) {
            if (this.mCustomConstraints.containsKey(attributeName)) {
                ConstraintAttribute ret = this.mCustomConstraints.get(attributeName);
                if (ret.getType() == attributeType) {
                    return ret;
                }
                throw new IllegalArgumentException("ConstraintAttribute is already a " + ret.getType().name());
            }
            ConstraintAttribute ret2 = new ConstraintAttribute(attributeName, attributeType);
            this.mCustomConstraints.put(attributeName, ret2);
            return ret2;
        }

        /* access modifiers changed from: private */
        public void setStringValue(String attributeName, String value) {
            get(attributeName, ConstraintAttribute.AttributeType.STRING_TYPE).setStringValue(value);
        }

        /* access modifiers changed from: private */
        public void setFloatValue(String attributeName, float value) {
            get(attributeName, ConstraintAttribute.AttributeType.FLOAT_TYPE).setFloatValue(value);
        }

        /* access modifiers changed from: private */
        public void setIntValue(String attributeName, int value) {
            get(attributeName, ConstraintAttribute.AttributeType.INT_TYPE).setIntValue(value);
        }

        /* access modifiers changed from: private */
        public void setColorValue(String attributeName, int value) {
            get(attributeName, ConstraintAttribute.AttributeType.COLOR_TYPE).setColorValue(value);
        }

        public Constraint clone() {
            Constraint clone = new Constraint();
            clone.layout.copyFrom(this.layout);
            clone.motion.copyFrom(this.motion);
            clone.propertySet.copyFrom(this.propertySet);
            clone.transform.copyFrom(this.transform);
            clone.mViewId = this.mViewId;
            return clone;
        }

        /* access modifiers changed from: private */
        public void fillFromConstraints(ConstraintHelper helper, int viewId, Constraints.LayoutParams param) {
            fillFromConstraints(viewId, param);
            if (helper instanceof Barrier) {
                Layout layout2 = this.layout;
                layout2.mHelperType = 1;
                Barrier barrier = (Barrier) helper;
                layout2.mBarrierDirection = barrier.getType();
                this.layout.mReferenceIds = barrier.getReferencedIds();
                this.layout.mBarrierMargin = barrier.getMargin();
            }
        }

        /* access modifiers changed from: private */
        public void fillFromConstraints(int viewId, Constraints.LayoutParams param) {
            fillFrom(viewId, param);
            this.propertySet.alpha = param.alpha;
            Transform transform2 = this.transform;
            transform2.rotation = param.rotation;
            transform2.rotationX = param.rotationX;
            transform2.rotationY = param.rotationY;
            transform2.scaleX = param.scaleX;
            transform2.scaleY = param.scaleY;
            transform2.transformPivotX = param.transformPivotX;
            transform2.transformPivotY = param.transformPivotY;
            transform2.translationX = param.translationX;
            transform2.translationY = param.translationY;
            transform2.translationZ = param.translationZ;
            transform2.elevation = param.elevation;
            transform2.applyElevation = param.applyElevation;
        }

        /* access modifiers changed from: private */
        public void fillFrom(int viewId, ConstraintLayout.LayoutParams param) {
            this.mViewId = viewId;
            Layout layout2 = this.layout;
            layout2.leftToLeft = param.leftToLeft;
            layout2.leftToRight = param.leftToRight;
            layout2.rightToLeft = param.rightToLeft;
            layout2.rightToRight = param.rightToRight;
            layout2.topToTop = param.topToTop;
            layout2.topToBottom = param.topToBottom;
            layout2.bottomToTop = param.bottomToTop;
            layout2.bottomToBottom = param.bottomToBottom;
            layout2.baselineToBaseline = param.baselineToBaseline;
            layout2.startToEnd = param.startToEnd;
            layout2.startToStart = param.startToStart;
            layout2.endToStart = param.endToStart;
            layout2.endToEnd = param.endToEnd;
            layout2.horizontalBias = param.horizontalBias;
            layout2.verticalBias = param.verticalBias;
            layout2.dimensionRatio = param.dimensionRatio;
            layout2.circleConstraint = param.circleConstraint;
            layout2.circleRadius = param.circleRadius;
            layout2.circleAngle = param.circleAngle;
            layout2.editorAbsoluteX = param.editorAbsoluteX;
            layout2.editorAbsoluteY = param.editorAbsoluteY;
            layout2.orientation = param.orientation;
            layout2.guidePercent = param.guidePercent;
            layout2.guideBegin = param.guideBegin;
            layout2.guideEnd = param.guideEnd;
            layout2.mWidth = param.width;
            layout2.mHeight = param.height;
            layout2.leftMargin = param.leftMargin;
            layout2.rightMargin = param.rightMargin;
            layout2.topMargin = param.topMargin;
            layout2.bottomMargin = param.bottomMargin;
            layout2.verticalWeight = param.verticalWeight;
            layout2.horizontalWeight = param.horizontalWeight;
            layout2.verticalChainStyle = param.verticalChainStyle;
            layout2.horizontalChainStyle = param.horizontalChainStyle;
            layout2.constrainedWidth = param.constrainedWidth;
            layout2.constrainedHeight = param.constrainedHeight;
            layout2.widthDefault = param.matchConstraintDefaultWidth;
            layout2.heightDefault = param.matchConstraintDefaultHeight;
            layout2.widthMax = param.matchConstraintMaxWidth;
            layout2.heightMax = param.matchConstraintMaxHeight;
            layout2.widthMin = param.matchConstraintMinWidth;
            layout2.heightMin = param.matchConstraintMinHeight;
            layout2.widthPercent = param.matchConstraintPercentWidth;
            layout2.heightPercent = param.matchConstraintPercentHeight;
            layout2.mConstraintTag = param.constraintTag;
            layout2.goneTopMargin = param.goneTopMargin;
            layout2.goneBottomMargin = param.goneBottomMargin;
            layout2.goneLeftMargin = param.goneLeftMargin;
            layout2.goneRightMargin = param.goneRightMargin;
            layout2.goneStartMargin = param.goneStartMargin;
            layout2.goneEndMargin = param.goneEndMargin;
            if (Build.VERSION.SDK_INT >= 17) {
                layout2.endMargin = param.getMarginEnd();
                this.layout.startMargin = param.getMarginStart();
            }
        }

        public void applyTo(ConstraintLayout.LayoutParams param) {
            Layout layout2 = this.layout;
            param.leftToLeft = layout2.leftToLeft;
            param.leftToRight = layout2.leftToRight;
            param.rightToLeft = layout2.rightToLeft;
            param.rightToRight = layout2.rightToRight;
            param.topToTop = layout2.topToTop;
            param.topToBottom = layout2.topToBottom;
            param.bottomToTop = layout2.bottomToTop;
            param.bottomToBottom = layout2.bottomToBottom;
            param.baselineToBaseline = layout2.baselineToBaseline;
            param.startToEnd = layout2.startToEnd;
            param.startToStart = layout2.startToStart;
            param.endToStart = layout2.endToStart;
            param.endToEnd = layout2.endToEnd;
            param.leftMargin = layout2.leftMargin;
            param.rightMargin = layout2.rightMargin;
            param.topMargin = layout2.topMargin;
            param.bottomMargin = layout2.bottomMargin;
            param.goneStartMargin = layout2.goneStartMargin;
            param.goneEndMargin = layout2.goneEndMargin;
            param.goneTopMargin = layout2.goneTopMargin;
            param.goneBottomMargin = layout2.goneBottomMargin;
            param.horizontalBias = layout2.horizontalBias;
            param.verticalBias = layout2.verticalBias;
            param.circleConstraint = layout2.circleConstraint;
            param.circleRadius = layout2.circleRadius;
            param.circleAngle = layout2.circleAngle;
            param.dimensionRatio = layout2.dimensionRatio;
            param.editorAbsoluteX = layout2.editorAbsoluteX;
            param.editorAbsoluteY = layout2.editorAbsoluteY;
            param.verticalWeight = layout2.verticalWeight;
            param.horizontalWeight = layout2.horizontalWeight;
            param.verticalChainStyle = layout2.verticalChainStyle;
            param.horizontalChainStyle = layout2.horizontalChainStyle;
            param.constrainedWidth = layout2.constrainedWidth;
            param.constrainedHeight = layout2.constrainedHeight;
            param.matchConstraintDefaultWidth = layout2.widthDefault;
            param.matchConstraintDefaultHeight = layout2.heightDefault;
            param.matchConstraintMaxWidth = layout2.widthMax;
            param.matchConstraintMaxHeight = layout2.heightMax;
            param.matchConstraintMinWidth = layout2.widthMin;
            param.matchConstraintMinHeight = layout2.heightMin;
            param.matchConstraintPercentWidth = layout2.widthPercent;
            param.matchConstraintPercentHeight = layout2.heightPercent;
            param.orientation = layout2.orientation;
            param.guidePercent = layout2.guidePercent;
            param.guideBegin = layout2.guideBegin;
            param.guideEnd = layout2.guideEnd;
            param.width = layout2.mWidth;
            param.height = layout2.mHeight;
            String str = layout2.mConstraintTag;
            if (str != null) {
                param.constraintTag = str;
            }
            if (Build.VERSION.SDK_INT >= 17) {
                param.setMarginStart(layout2.startMargin);
                param.setMarginEnd(this.layout.endMargin);
            }
            param.validate();
        }
    }

    public void clone(Context context, int constraintLayoutId) {
        clone((ConstraintLayout) LayoutInflater.from(context).inflate(constraintLayoutId, (ViewGroup) null));
    }

    public void clone(ConstraintSet set) {
        this.mConstraints.clear();
        for (Integer key : set.mConstraints.keySet()) {
            this.mConstraints.put(key, set.mConstraints.get(key).clone());
        }
    }

    public void clone(ConstraintLayout constraintLayout) {
        int count = constraintLayout.getChildCount();
        this.mConstraints.clear();
        int i = 0;
        while (i < count) {
            View view = constraintLayout.getChildAt(i);
            ConstraintLayout.LayoutParams param = (ConstraintLayout.LayoutParams) view.getLayoutParams();
            int id = view.getId();
            if (!this.mForceId || id != -1) {
                if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                    this.mConstraints.put(Integer.valueOf(id), new Constraint());
                }
                Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
                constraint.mCustomConstraints = ConstraintAttribute.extractAttributes(this.mSavedAttributes, view);
                constraint.fillFrom(id, param);
                constraint.propertySet.visibility = view.getVisibility();
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 17) {
                    constraint.propertySet.alpha = view.getAlpha();
                    constraint.transform.rotation = view.getRotation();
                    constraint.transform.rotationX = view.getRotationX();
                    constraint.transform.rotationY = view.getRotationY();
                    constraint.transform.scaleX = view.getScaleX();
                    constraint.transform.scaleY = view.getScaleY();
                    float pivotX = view.getPivotX();
                    float pivotY = view.getPivotY();
                    if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                        Transform transform = constraint.transform;
                        transform.transformPivotX = pivotX;
                        transform.transformPivotY = pivotY;
                    }
                    constraint.transform.translationX = view.getTranslationX();
                    constraint.transform.translationY = view.getTranslationY();
                    if (i2 >= 21) {
                        constraint.transform.translationZ = view.getTranslationZ();
                        Transform transform2 = constraint.transform;
                        if (transform2.applyElevation) {
                            transform2.elevation = view.getElevation();
                        }
                    }
                }
                if (view instanceof Barrier) {
                    Barrier barrier = (Barrier) view;
                    constraint.layout.mBarrierAllowsGoneWidgets = barrier.allowsGoneWidget();
                    constraint.layout.mReferenceIds = barrier.getReferencedIds();
                    constraint.layout.mBarrierDirection = barrier.getType();
                    constraint.layout.mBarrierMargin = barrier.getMargin();
                }
                i++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void clone(Constraints constraints) {
        int count = constraints.getChildCount();
        this.mConstraints.clear();
        int i = 0;
        while (i < count) {
            View view = constraints.getChildAt(i);
            Constraints.LayoutParams param = (Constraints.LayoutParams) view.getLayoutParams();
            int id = view.getId();
            if (!this.mForceId || id != -1) {
                if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                    this.mConstraints.put(Integer.valueOf(id), new Constraint());
                }
                Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
                if (view instanceof ConstraintHelper) {
                    constraint.fillFromConstraints((ConstraintHelper) view, id, param);
                }
                constraint.fillFromConstraints(id, param);
                i++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void applyTo(ConstraintLayout constraintLayout) {
        applyToInternal(constraintLayout, true);
        constraintLayout.setConstraintSet((ConstraintSet) null);
        constraintLayout.requestLayout();
    }

    public void applyToWithoutCustom(ConstraintLayout constraintLayout) {
        applyToInternal(constraintLayout, false);
        constraintLayout.setConstraintSet((ConstraintSet) null);
    }

    public void applyCustomAttributes(ConstraintLayout constraintLayout) {
        int count = constraintLayout.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = constraintLayout.getChildAt(i);
            int id = view.getId();
            if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                Log.v(TAG, "id unknown " + Debug.getName(view));
            } else if (this.mForceId && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (this.mConstraints.containsKey(Integer.valueOf(id))) {
                ConstraintAttribute.setAttributes(view, this.mConstraints.get(Integer.valueOf(id)).mCustomConstraints);
            }
        }
    }

    public void applyToHelper(ConstraintHelper helper, ConstraintWidget child, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> mapIdToWidget) {
        int id = helper.getId();
        if (this.mConstraints.containsKey(Integer.valueOf(id))) {
            Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
            if (child instanceof HelperWidget) {
                helper.loadParameters(constraint, (HelperWidget) child, layoutParams, mapIdToWidget);
            }
        }
    }

    public void applyToLayoutParams(int id, ConstraintLayout.LayoutParams layoutParams) {
        if (this.mConstraints.containsKey(Integer.valueOf(id))) {
            this.mConstraints.get(Integer.valueOf(id)).applyTo(layoutParams);
        }
    }

    /* access modifiers changed from: package-private */
    public void applyToInternal(ConstraintLayout constraintLayout, boolean applyPostLayout) {
        int count = constraintLayout.getChildCount();
        HashSet<Integer> used = new HashSet<>(this.mConstraints.keySet());
        for (int i = 0; i < count; i++) {
            View view = constraintLayout.getChildAt(i);
            int id = view.getId();
            if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                Log.w(TAG, "id unknown " + Debug.getName(view));
            } else if (this.mForceId && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (id != -1) {
                if (this.mConstraints.containsKey(Integer.valueOf(id))) {
                    used.remove(Integer.valueOf(id));
                    Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
                    if (view instanceof Barrier) {
                        constraint.layout.mHelperType = 1;
                    }
                    int i2 = constraint.layout.mHelperType;
                    if (i2 != -1) {
                        switch (i2) {
                            case 1:
                                Barrier barrier = (Barrier) view;
                                barrier.setId(id);
                                barrier.setType(constraint.layout.mBarrierDirection);
                                barrier.setMargin(constraint.layout.mBarrierMargin);
                                barrier.setAllowsGoneWidget(constraint.layout.mBarrierAllowsGoneWidgets);
                                Layout layout = constraint.layout;
                                int[] iArr = layout.mReferenceIds;
                                if (iArr == null) {
                                    String str = layout.mReferenceIdString;
                                    if (str != null) {
                                        layout.mReferenceIds = convertReferenceString(barrier, str);
                                        barrier.setReferencedIds(constraint.layout.mReferenceIds);
                                        break;
                                    }
                                } else {
                                    barrier.setReferencedIds(iArr);
                                    break;
                                }
                                break;
                        }
                    }
                    ConstraintLayout.LayoutParams param = (ConstraintLayout.LayoutParams) view.getLayoutParams();
                    param.validate();
                    constraint.applyTo(param);
                    if (applyPostLayout) {
                        ConstraintAttribute.setAttributes(view, constraint.mCustomConstraints);
                    }
                    view.setLayoutParams(param);
                    PropertySet propertySet = constraint.propertySet;
                    if (propertySet.mVisibilityMode == 0) {
                        view.setVisibility(propertySet.visibility);
                    }
                    int i3 = Build.VERSION.SDK_INT;
                    if (i3 >= 17) {
                        view.setAlpha(constraint.propertySet.alpha);
                        view.setRotation(constraint.transform.rotation);
                        view.setRotationX(constraint.transform.rotationX);
                        view.setRotationY(constraint.transform.rotationY);
                        view.setScaleX(constraint.transform.scaleX);
                        view.setScaleY(constraint.transform.scaleY);
                        if (!Float.isNaN(constraint.transform.transformPivotX)) {
                            view.setPivotX(constraint.transform.transformPivotX);
                        }
                        if (!Float.isNaN(constraint.transform.transformPivotY)) {
                            view.setPivotY(constraint.transform.transformPivotY);
                        }
                        view.setTranslationX(constraint.transform.translationX);
                        view.setTranslationY(constraint.transform.translationY);
                        if (i3 >= 21) {
                            view.setTranslationZ(constraint.transform.translationZ);
                            Transform transform = constraint.transform;
                            if (transform.applyElevation) {
                                view.setElevation(transform.elevation);
                            }
                        }
                    }
                } else {
                    Log.v(TAG, "WARNING NO CONSTRAINTS for view " + id);
                }
            }
        }
        Iterator<Integer> it = used.iterator();
        while (it.hasNext()) {
            Integer id2 = it.next();
            Constraint constraint2 = this.mConstraints.get(id2);
            int i4 = constraint2.layout.mHelperType;
            if (i4 != -1) {
                switch (i4) {
                    case 1:
                        Barrier barrier2 = new Barrier(constraintLayout.getContext());
                        barrier2.setId(id2.intValue());
                        Layout layout2 = constraint2.layout;
                        int[] iArr2 = layout2.mReferenceIds;
                        if (iArr2 != null) {
                            barrier2.setReferencedIds(iArr2);
                        } else {
                            String str2 = layout2.mReferenceIdString;
                            if (str2 != null) {
                                layout2.mReferenceIds = convertReferenceString(barrier2, str2);
                                barrier2.setReferencedIds(constraint2.layout.mReferenceIds);
                            }
                        }
                        barrier2.setType(constraint2.layout.mBarrierDirection);
                        barrier2.setMargin(constraint2.layout.mBarrierMargin);
                        ConstraintLayout.LayoutParams param2 = constraintLayout.generateDefaultLayoutParams();
                        barrier2.validateParams();
                        constraint2.applyTo(param2);
                        constraintLayout.addView(barrier2, param2);
                        break;
                }
            }
            if (constraint2.layout.mIsGuideline) {
                Guideline g = new Guideline(constraintLayout.getContext());
                g.setId(id2.intValue());
                ConstraintLayout.LayoutParams param3 = constraintLayout.generateDefaultLayoutParams();
                constraint2.applyTo(param3);
                constraintLayout.addView(g, param3);
            }
        }
    }

    public void center(int centerID, int firstID, int firstSide, int firstMargin, int secondId, int secondSide, int secondMargin, float bias) {
        int i = firstSide;
        float f = bias;
        if (firstMargin < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        } else if (secondMargin < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        } else if (f <= 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        } else if (i == 1 || i == 2) {
            int i2 = centerID;
            connect(i2, 1, firstID, firstSide, firstMargin);
            connect(i2, 2, secondId, secondSide, secondMargin);
            this.mConstraints.get(Integer.valueOf(centerID)).layout.horizontalBias = f;
        } else if (i == 6 || i == 7) {
            int i3 = centerID;
            connect(i3, 6, firstID, firstSide, firstMargin);
            connect(i3, 7, secondId, secondSide, secondMargin);
            this.mConstraints.get(Integer.valueOf(centerID)).layout.horizontalBias = f;
        } else {
            int i4 = centerID;
            connect(i4, 3, firstID, firstSide, firstMargin);
            connect(i4, 4, secondId, secondSide, secondMargin);
            this.mConstraints.get(Integer.valueOf(centerID)).layout.verticalBias = f;
        }
    }

    public void centerHorizontally(int centerID, int leftId, int leftSide, int leftMargin, int rightId, int rightSide, int rightMargin, float bias) {
        connect(centerID, 1, leftId, leftSide, leftMargin);
        connect(centerID, 2, rightId, rightSide, rightMargin);
        this.mConstraints.get(Integer.valueOf(centerID)).layout.horizontalBias = bias;
    }

    public void centerHorizontallyRtl(int centerID, int startId, int startSide, int startMargin, int endId, int endSide, int endMargin, float bias) {
        connect(centerID, 6, startId, startSide, startMargin);
        connect(centerID, 7, endId, endSide, endMargin);
        this.mConstraints.get(Integer.valueOf(centerID)).layout.horizontalBias = bias;
    }

    public void centerVertically(int centerID, int topId, int topSide, int topMargin, int bottomId, int bottomSide, int bottomMargin, float bias) {
        connect(centerID, 3, topId, topSide, topMargin);
        connect(centerID, 4, bottomId, bottomSide, bottomMargin);
        this.mConstraints.get(Integer.valueOf(centerID)).layout.verticalBias = bias;
    }

    public void createVerticalChain(int topId, int topSide, int bottomId, int bottomSide, int[] chainIds, float[] weights, int style) {
        int[] iArr = chainIds;
        float[] fArr = weights;
        if (iArr.length < 2) {
            int i = style;
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        } else if (fArr == null || fArr.length == iArr.length) {
            if (fArr != null) {
                get(iArr[0]).layout.verticalWeight = fArr[0];
            }
            get(iArr[0]).layout.verticalChainStyle = style;
            connect(iArr[0], 3, topId, topSide, 0);
            for (int i2 = 1; i2 < iArr.length; i2++) {
                int i3 = iArr[i2];
                connect(iArr[i2], 3, iArr[i2 - 1], 4, 0);
                connect(iArr[i2 - 1], 4, iArr[i2], 3, 0);
                if (fArr != null) {
                    get(iArr[i2]).layout.verticalWeight = fArr[i2];
                }
            }
            connect(iArr[iArr.length - 1], 4, bottomId, bottomSide, 0);
        } else {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
    }

    public void createHorizontalChain(int leftId, int leftSide, int rightId, int rightSide, int[] chainIds, float[] weights, int style) {
        createHorizontalChain(leftId, leftSide, rightId, rightSide, chainIds, weights, style, 1, 2);
    }

    public void createHorizontalChainRtl(int startId, int startSide, int endId, int endSide, int[] chainIds, float[] weights, int style) {
        createHorizontalChain(startId, startSide, endId, endSide, chainIds, weights, style, 6, 7);
    }

    private void createHorizontalChain(int leftId, int leftSide, int rightId, int rightSide, int[] chainIds, float[] weights, int style, int left, int right) {
        int[] iArr = chainIds;
        float[] fArr = weights;
        if (iArr.length < 2) {
            int i = style;
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        } else if (fArr == null || fArr.length == iArr.length) {
            if (fArr != null) {
                get(iArr[0]).layout.horizontalWeight = fArr[0];
            }
            get(iArr[0]).layout.horizontalChainStyle = style;
            connect(iArr[0], left, leftId, leftSide, -1);
            for (int i2 = 1; i2 < iArr.length; i2++) {
                int i3 = iArr[i2];
                connect(iArr[i2], left, iArr[i2 - 1], right, -1);
                connect(iArr[i2 - 1], right, iArr[i2], left, -1);
                if (fArr != null) {
                    get(iArr[i2]).layout.horizontalWeight = fArr[i2];
                }
            }
            connect(iArr[iArr.length - 1], right, rightId, rightSide, -1);
        } else {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
    }

    public void connect(int startID, int startSide, int endID, int endSide, int margin) {
        if (!this.mConstraints.containsKey(Integer.valueOf(startID))) {
            this.mConstraints.put(Integer.valueOf(startID), new Constraint());
        }
        Constraint constraint = this.mConstraints.get(Integer.valueOf(startID));
        switch (startSide) {
            case 1:
                if (endSide == 1) {
                    Layout layout = constraint.layout;
                    layout.leftToLeft = endID;
                    layout.leftToRight = -1;
                } else if (endSide == 2) {
                    Layout layout2 = constraint.layout;
                    layout2.leftToRight = endID;
                    layout2.leftToLeft = -1;
                } else {
                    throw new IllegalArgumentException("Left to " + sideToString(endSide) + " undefined");
                }
                constraint.layout.leftMargin = margin;
                return;
            case 2:
                if (endSide == 1) {
                    Layout layout3 = constraint.layout;
                    layout3.rightToLeft = endID;
                    layout3.rightToRight = -1;
                } else if (endSide == 2) {
                    Layout layout4 = constraint.layout;
                    layout4.rightToRight = endID;
                    layout4.rightToLeft = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
                }
                constraint.layout.rightMargin = margin;
                return;
            case 3:
                if (endSide == 3) {
                    Layout layout5 = constraint.layout;
                    layout5.topToTop = endID;
                    layout5.topToBottom = -1;
                    layout5.baselineToBaseline = -1;
                } else if (endSide == 4) {
                    Layout layout6 = constraint.layout;
                    layout6.topToBottom = endID;
                    layout6.topToTop = -1;
                    layout6.baselineToBaseline = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
                }
                constraint.layout.topMargin = margin;
                return;
            case 4:
                if (endSide == 4) {
                    Layout layout7 = constraint.layout;
                    layout7.bottomToBottom = endID;
                    layout7.bottomToTop = -1;
                    layout7.baselineToBaseline = -1;
                } else if (endSide == 3) {
                    Layout layout8 = constraint.layout;
                    layout8.bottomToTop = endID;
                    layout8.bottomToBottom = -1;
                    layout8.baselineToBaseline = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
                }
                constraint.layout.bottomMargin = margin;
                return;
            case 5:
                if (endSide == 5) {
                    Layout layout9 = constraint.layout;
                    layout9.baselineToBaseline = endID;
                    layout9.bottomToBottom = -1;
                    layout9.bottomToTop = -1;
                    layout9.topToTop = -1;
                    layout9.topToBottom = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
            case 6:
                if (endSide == 6) {
                    Layout layout10 = constraint.layout;
                    layout10.startToStart = endID;
                    layout10.startToEnd = -1;
                } else if (endSide == 7) {
                    Layout layout11 = constraint.layout;
                    layout11.startToEnd = endID;
                    layout11.startToStart = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
                }
                constraint.layout.startMargin = margin;
                return;
            case 7:
                if (endSide == 7) {
                    Layout layout12 = constraint.layout;
                    layout12.endToEnd = endID;
                    layout12.endToStart = -1;
                } else if (endSide == 6) {
                    Layout layout13 = constraint.layout;
                    layout13.endToStart = endID;
                    layout13.endToEnd = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
                }
                constraint.layout.endMargin = margin;
                return;
            default:
                throw new IllegalArgumentException(sideToString(startSide) + " to " + sideToString(endSide) + " unknown");
        }
    }

    public void connect(int startID, int startSide, int endID, int endSide) {
        if (!this.mConstraints.containsKey(Integer.valueOf(startID))) {
            this.mConstraints.put(Integer.valueOf(startID), new Constraint());
        }
        Constraint constraint = this.mConstraints.get(Integer.valueOf(startID));
        switch (startSide) {
            case 1:
                if (endSide == 1) {
                    Layout layout = constraint.layout;
                    layout.leftToLeft = endID;
                    layout.leftToRight = -1;
                    return;
                } else if (endSide == 2) {
                    Layout layout2 = constraint.layout;
                    layout2.leftToRight = endID;
                    layout2.leftToLeft = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("left to " + sideToString(endSide) + " undefined");
                }
            case 2:
                if (endSide == 1) {
                    Layout layout3 = constraint.layout;
                    layout3.rightToLeft = endID;
                    layout3.rightToRight = -1;
                    return;
                } else if (endSide == 2) {
                    Layout layout4 = constraint.layout;
                    layout4.rightToRight = endID;
                    layout4.rightToLeft = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
                }
            case 3:
                if (endSide == 3) {
                    Layout layout5 = constraint.layout;
                    layout5.topToTop = endID;
                    layout5.topToBottom = -1;
                    layout5.baselineToBaseline = -1;
                    return;
                } else if (endSide == 4) {
                    Layout layout6 = constraint.layout;
                    layout6.topToBottom = endID;
                    layout6.topToTop = -1;
                    layout6.baselineToBaseline = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
                }
            case 4:
                if (endSide == 4) {
                    Layout layout7 = constraint.layout;
                    layout7.bottomToBottom = endID;
                    layout7.bottomToTop = -1;
                    layout7.baselineToBaseline = -1;
                    return;
                } else if (endSide == 3) {
                    Layout layout8 = constraint.layout;
                    layout8.bottomToTop = endID;
                    layout8.bottomToBottom = -1;
                    layout8.baselineToBaseline = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
                }
            case 5:
                if (endSide == 5) {
                    Layout layout9 = constraint.layout;
                    layout9.baselineToBaseline = endID;
                    layout9.bottomToBottom = -1;
                    layout9.bottomToTop = -1;
                    layout9.topToTop = -1;
                    layout9.topToBottom = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
            case 6:
                if (endSide == 6) {
                    Layout layout10 = constraint.layout;
                    layout10.startToStart = endID;
                    layout10.startToEnd = -1;
                    return;
                } else if (endSide == 7) {
                    Layout layout11 = constraint.layout;
                    layout11.startToEnd = endID;
                    layout11.startToStart = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
                }
            case 7:
                if (endSide == 7) {
                    Layout layout12 = constraint.layout;
                    layout12.endToEnd = endID;
                    layout12.endToStart = -1;
                    return;
                } else if (endSide == 6) {
                    Layout layout13 = constraint.layout;
                    layout13.endToStart = endID;
                    layout13.endToEnd = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(endSide) + " undefined");
                }
            default:
                throw new IllegalArgumentException(sideToString(startSide) + " to " + sideToString(endSide) + " unknown");
        }
    }

    public void centerHorizontally(int viewId, int toView) {
        if (toView == 0) {
            center(viewId, 0, 1, 0, 0, 2, 0, 0.5f);
        } else {
            center(viewId, toView, 2, 0, toView, 1, 0, 0.5f);
        }
    }

    public void centerHorizontallyRtl(int viewId, int toView) {
        if (toView == 0) {
            center(viewId, 0, 6, 0, 0, 7, 0, 0.5f);
        } else {
            center(viewId, toView, 7, 0, toView, 6, 0, 0.5f);
        }
    }

    public void centerVertically(int viewId, int toView) {
        if (toView == 0) {
            center(viewId, 0, 3, 0, 0, 4, 0, 0.5f);
        } else {
            center(viewId, toView, 4, 0, toView, 3, 0, 0.5f);
        }
    }

    public void clear(int viewId) {
        this.mConstraints.remove(Integer.valueOf(viewId));
    }

    public void clear(int viewId, int anchor) {
        if (this.mConstraints.containsKey(Integer.valueOf(viewId))) {
            Constraint constraint = this.mConstraints.get(Integer.valueOf(viewId));
            switch (anchor) {
                case 1:
                    Layout layout = constraint.layout;
                    layout.leftToRight = -1;
                    layout.leftToLeft = -1;
                    layout.leftMargin = -1;
                    layout.goneLeftMargin = -1;
                    return;
                case 2:
                    Layout layout2 = constraint.layout;
                    layout2.rightToRight = -1;
                    layout2.rightToLeft = -1;
                    layout2.rightMargin = -1;
                    layout2.goneRightMargin = -1;
                    return;
                case 3:
                    Layout layout3 = constraint.layout;
                    layout3.topToBottom = -1;
                    layout3.topToTop = -1;
                    layout3.topMargin = -1;
                    layout3.goneTopMargin = -1;
                    return;
                case 4:
                    Layout layout4 = constraint.layout;
                    layout4.bottomToTop = -1;
                    layout4.bottomToBottom = -1;
                    layout4.bottomMargin = -1;
                    layout4.goneBottomMargin = -1;
                    return;
                case 5:
                    constraint.layout.baselineToBaseline = -1;
                    return;
                case 6:
                    Layout layout5 = constraint.layout;
                    layout5.startToEnd = -1;
                    layout5.startToStart = -1;
                    layout5.startMargin = -1;
                    layout5.goneStartMargin = -1;
                    return;
                case 7:
                    Layout layout6 = constraint.layout;
                    layout6.endToStart = -1;
                    layout6.endToEnd = -1;
                    layout6.endMargin = -1;
                    layout6.goneEndMargin = -1;
                    return;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
        }
    }

    public void setMargin(int viewId, int anchor, int value) {
        Constraint constraint = get(viewId);
        switch (anchor) {
            case 1:
                constraint.layout.leftMargin = value;
                return;
            case 2:
                constraint.layout.rightMargin = value;
                return;
            case 3:
                constraint.layout.topMargin = value;
                return;
            case 4:
                constraint.layout.bottomMargin = value;
                return;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                constraint.layout.startMargin = value;
                return;
            case 7:
                constraint.layout.endMargin = value;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void setGoneMargin(int viewId, int anchor, int value) {
        Constraint constraint = get(viewId);
        switch (anchor) {
            case 1:
                constraint.layout.goneLeftMargin = value;
                return;
            case 2:
                constraint.layout.goneRightMargin = value;
                return;
            case 3:
                constraint.layout.goneTopMargin = value;
                return;
            case 4:
                constraint.layout.goneBottomMargin = value;
                return;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                constraint.layout.goneStartMargin = value;
                return;
            case 7:
                constraint.layout.goneEndMargin = value;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void setHorizontalBias(int viewId, float bias) {
        get(viewId).layout.horizontalBias = bias;
    }

    public void setVerticalBias(int viewId, float bias) {
        get(viewId).layout.verticalBias = bias;
    }

    public void setDimensionRatio(int viewId, String ratio) {
        get(viewId).layout.dimensionRatio = ratio;
    }

    public void setVisibility(int viewId, int visibility) {
        get(viewId).propertySet.visibility = visibility;
    }

    public void setVisibilityMode(int viewId, int visibilityMode) {
        get(viewId).propertySet.mVisibilityMode = visibilityMode;
    }

    public int getVisibilityMode(int viewId) {
        return get(viewId).propertySet.mVisibilityMode;
    }

    public int getVisibility(int viewId) {
        return get(viewId).propertySet.visibility;
    }

    public int getHeight(int viewId) {
        return get(viewId).layout.mHeight;
    }

    public int getWidth(int viewId) {
        return get(viewId).layout.mWidth;
    }

    public void setAlpha(int viewId, float alpha) {
        get(viewId).propertySet.alpha = alpha;
    }

    public boolean getApplyElevation(int viewId) {
        return get(viewId).transform.applyElevation;
    }

    public void setApplyElevation(int viewId, boolean apply) {
        if (Build.VERSION.SDK_INT >= 21) {
            get(viewId).transform.applyElevation = apply;
        }
    }

    public void setElevation(int viewId, float elevation) {
        if (Build.VERSION.SDK_INT >= 21) {
            get(viewId).transform.elevation = elevation;
            get(viewId).transform.applyElevation = true;
        }
    }

    public void setRotation(int viewId, float rotation) {
        get(viewId).transform.rotation = rotation;
    }

    public void setRotationX(int viewId, float rotationX) {
        get(viewId).transform.rotationX = rotationX;
    }

    public void setRotationY(int viewId, float rotationY) {
        get(viewId).transform.rotationY = rotationY;
    }

    public void setScaleX(int viewId, float scaleX) {
        get(viewId).transform.scaleX = scaleX;
    }

    public void setScaleY(int viewId, float scaleY) {
        get(viewId).transform.scaleY = scaleY;
    }

    public void setTransformPivotX(int viewId, float transformPivotX) {
        get(viewId).transform.transformPivotX = transformPivotX;
    }

    public void setTransformPivotY(int viewId, float transformPivotY) {
        get(viewId).transform.transformPivotY = transformPivotY;
    }

    public void setTransformPivot(int viewId, float transformPivotX, float transformPivotY) {
        Transform transform = get(viewId).transform;
        transform.transformPivotY = transformPivotY;
        transform.transformPivotX = transformPivotX;
    }

    public void setTranslationX(int viewId, float translationX) {
        get(viewId).transform.translationX = translationX;
    }

    public void setTranslationY(int viewId, float translationY) {
        get(viewId).transform.translationY = translationY;
    }

    public void setTranslation(int viewId, float translationX, float translationY) {
        Transform transform = get(viewId).transform;
        transform.translationX = translationX;
        transform.translationY = translationY;
    }

    public void setTranslationZ(int viewId, float translationZ) {
        if (Build.VERSION.SDK_INT >= 21) {
            get(viewId).transform.translationZ = translationZ;
        }
    }

    public void setEditorAbsoluteX(int viewId, int position) {
        get(viewId).layout.editorAbsoluteX = position;
    }

    public void setEditorAbsoluteY(int viewId, int position) {
        get(viewId).layout.editorAbsoluteY = position;
    }

    public void constrainHeight(int viewId, int height) {
        get(viewId).layout.mHeight = height;
    }

    public void constrainWidth(int viewId, int width) {
        get(viewId).layout.mWidth = width;
    }

    public void constrainCircle(int viewId, int id, int radius, float angle) {
        Layout layout = get(viewId).layout;
        layout.circleConstraint = id;
        layout.circleRadius = radius;
        layout.circleAngle = angle;
    }

    public void constrainMaxHeight(int viewId, int height) {
        get(viewId).layout.heightMax = height;
    }

    public void constrainMaxWidth(int viewId, int width) {
        get(viewId).layout.widthMax = width;
    }

    public void constrainMinHeight(int viewId, int height) {
        get(viewId).layout.heightMin = height;
    }

    public void constrainMinWidth(int viewId, int width) {
        get(viewId).layout.widthMin = width;
    }

    public void constrainPercentWidth(int viewId, float percent) {
        get(viewId).layout.widthPercent = percent;
    }

    public void constrainPercentHeight(int viewId, float percent) {
        get(viewId).layout.heightPercent = percent;
    }

    public void constrainDefaultHeight(int viewId, int height) {
        get(viewId).layout.heightDefault = height;
    }

    public void constrainedWidth(int viewId, boolean constrained) {
        get(viewId).layout.constrainedWidth = constrained;
    }

    public void constrainedHeight(int viewId, boolean constrained) {
        get(viewId).layout.constrainedHeight = constrained;
    }

    public void constrainDefaultWidth(int viewId, int width) {
        get(viewId).layout.widthDefault = width;
    }

    public void setHorizontalWeight(int viewId, float weight) {
        get(viewId).layout.horizontalWeight = weight;
    }

    public void setVerticalWeight(int viewId, float weight) {
        get(viewId).layout.verticalWeight = weight;
    }

    public void setHorizontalChainStyle(int viewId, int chainStyle) {
        get(viewId).layout.horizontalChainStyle = chainStyle;
    }

    public void setVerticalChainStyle(int viewId, int chainStyle) {
        get(viewId).layout.verticalChainStyle = chainStyle;
    }

    public void addToHorizontalChain(int viewId, int leftId, int rightId) {
        connect(viewId, 1, leftId, leftId == 0 ? 1 : 2, 0);
        connect(viewId, 2, rightId, rightId == 0 ? 2 : 1, 0);
        if (leftId != 0) {
            connect(leftId, 2, viewId, 1, 0);
        }
        if (rightId != 0) {
            connect(rightId, 1, viewId, 2, 0);
        }
    }

    public void addToHorizontalChainRTL(int viewId, int leftId, int rightId) {
        connect(viewId, 6, leftId, leftId == 0 ? 6 : 7, 0);
        connect(viewId, 7, rightId, rightId == 0 ? 7 : 6, 0);
        if (leftId != 0) {
            connect(leftId, 7, viewId, 6, 0);
        }
        if (rightId != 0) {
            connect(rightId, 6, viewId, 7, 0);
        }
    }

    public void addToVerticalChain(int viewId, int topId, int bottomId) {
        connect(viewId, 3, topId, topId == 0 ? 3 : 4, 0);
        connect(viewId, 4, bottomId, bottomId == 0 ? 4 : 3, 0);
        if (topId != 0) {
            connect(topId, 4, viewId, 3, 0);
        }
        if (bottomId != 0) {
            connect(bottomId, 3, viewId, 4, 0);
        }
    }

    public void removeFromVerticalChain(int viewId) {
        if (this.mConstraints.containsKey(Integer.valueOf(viewId))) {
            Layout layout = this.mConstraints.get(Integer.valueOf(viewId)).layout;
            int topId = layout.topToBottom;
            int bottomId = layout.bottomToTop;
            if (!(topId == -1 && bottomId == -1)) {
                if (topId != -1 && bottomId != -1) {
                    connect(topId, 4, bottomId, 3, 0);
                    connect(bottomId, 3, topId, 4, 0);
                } else if (!(topId == -1 && bottomId == -1)) {
                    int i = layout.bottomToBottom;
                    if (i != -1) {
                        connect(topId, 4, i, 4, 0);
                    } else {
                        int i2 = layout.topToTop;
                        if (i2 != -1) {
                            connect(bottomId, 3, i2, 3, 0);
                        }
                    }
                }
            }
        }
        clear(viewId, 3);
        clear(viewId, 4);
    }

    public void removeFromHorizontalChain(int viewId) {
        if (this.mConstraints.containsKey(Integer.valueOf(viewId))) {
            Layout layout = this.mConstraints.get(Integer.valueOf(viewId)).layout;
            int leftId = layout.leftToRight;
            int rightId = layout.rightToLeft;
            if (leftId == -1 && rightId == -1) {
                int startId = layout.startToEnd;
                int endId = layout.endToStart;
                if (!(startId == -1 && endId == -1)) {
                    if (startId != -1 && endId != -1) {
                        connect(startId, 7, endId, 6, 0);
                        connect(endId, 6, leftId, 7, 0);
                    } else if (!(leftId == -1 && endId == -1)) {
                        int i = layout.rightToRight;
                        if (i != -1) {
                            connect(leftId, 7, i, 7, 0);
                        } else {
                            int i2 = layout.leftToLeft;
                            if (i2 != -1) {
                                connect(endId, 6, i2, 6, 0);
                            }
                        }
                    }
                }
                clear(viewId, 6);
                clear(viewId, 7);
                return;
            }
            if (leftId != -1 && rightId != -1) {
                connect(leftId, 2, rightId, 1, 0);
                connect(rightId, 1, leftId, 2, 0);
            } else if (!(leftId == -1 && rightId == -1)) {
                int i3 = layout.rightToRight;
                if (i3 != -1) {
                    connect(leftId, 2, i3, 2, 0);
                } else {
                    int i4 = layout.leftToLeft;
                    if (i4 != -1) {
                        connect(rightId, 1, i4, 1, 0);
                    }
                }
            }
            clear(viewId, 1);
            clear(viewId, 2);
        }
    }

    public void create(int guidelineID, int orientation) {
        Layout layout = get(guidelineID).layout;
        layout.mIsGuideline = true;
        layout.orientation = orientation;
    }

    public void createBarrier(int id, int direction, int margin, int... referenced) {
        Layout layout = get(id).layout;
        layout.mHelperType = 1;
        layout.mBarrierDirection = direction;
        layout.mBarrierMargin = margin;
        layout.mIsGuideline = false;
        layout.mReferenceIds = referenced;
    }

    public void setGuidelineBegin(int guidelineID, int margin) {
        get(guidelineID).layout.guideBegin = margin;
        get(guidelineID).layout.guideEnd = -1;
        get(guidelineID).layout.guidePercent = -1.0f;
    }

    public void setGuidelineEnd(int guidelineID, int margin) {
        get(guidelineID).layout.guideEnd = margin;
        get(guidelineID).layout.guideBegin = -1;
        get(guidelineID).layout.guidePercent = -1.0f;
    }

    public void setGuidelinePercent(int guidelineID, float ratio) {
        get(guidelineID).layout.guidePercent = ratio;
        get(guidelineID).layout.guideEnd = -1;
        get(guidelineID).layout.guideBegin = -1;
    }

    public int[] getReferencedIds(int id) {
        int[] iArr = get(id).layout.mReferenceIds;
        if (iArr == null) {
            return new int[0];
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    public void setReferencedIds(int id, int... referenced) {
        get(id).layout.mReferenceIds = referenced;
    }

    public void setBarrierType(int id, int type) {
        get(id).layout.mHelperType = type;
    }

    public void removeAttribute(String attributeName) {
        this.mSavedAttributes.remove(attributeName);
    }

    public void setIntValue(int viewId, String attributeName, int value) {
        get(viewId).setIntValue(attributeName, value);
    }

    public void setColorValue(int viewId, String attributeName, int value) {
        get(viewId).setColorValue(attributeName, value);
    }

    public void setFloatValue(int viewId, String attributeName, float value) {
        get(viewId).setFloatValue(attributeName, value);
    }

    public void setStringValue(int viewId, String attributeName, String value) {
        get(viewId).setStringValue(attributeName, value);
    }

    private void addAttributes(ConstraintAttribute.AttributeType attributeType, String... attributeName) {
        for (int i = 0; i < attributeName.length; i++) {
            if (this.mSavedAttributes.containsKey(attributeName[i])) {
                ConstraintAttribute constraintAttribute = this.mSavedAttributes.get(attributeName[i]);
                if (constraintAttribute.getType() != attributeType) {
                    throw new IllegalArgumentException("ConstraintAttribute is already a " + constraintAttribute.getType().name());
                }
            } else {
                this.mSavedAttributes.put(attributeName[i], new ConstraintAttribute(attributeName[i], attributeType));
            }
        }
    }

    public void parseIntAttributes(Constraint set, String attributes) {
        String[] sp = attributes.split(",");
        for (int i = 0; i < sp.length; i++) {
            String[] attr = sp[i].split("=");
            if (attr.length != 2) {
                Log.w(TAG, " Unable to parse " + sp[i]);
            } else {
                set.setFloatValue(attr[0], (float) Integer.decode(attr[1]).intValue());
            }
        }
    }

    public void parseColorAttributes(Constraint set, String attributes) {
        String[] sp = attributes.split(",");
        for (int i = 0; i < sp.length; i++) {
            String[] attr = sp[i].split("=");
            if (attr.length != 2) {
                Log.w(TAG, " Unable to parse " + sp[i]);
            } else {
                set.setColorValue(attr[0], Color.parseColor(attr[1]));
            }
        }
    }

    public void parseFloatAttributes(Constraint set, String attributes) {
        String[] sp = attributes.split(",");
        for (int i = 0; i < sp.length; i++) {
            String[] attr = sp[i].split("=");
            if (attr.length != 2) {
                Log.w(TAG, " Unable to parse " + sp[i]);
            } else {
                set.setFloatValue(attr[0], Float.parseFloat(attr[1]));
            }
        }
    }

    public void parseStringAttributes(Constraint set, String attributes) {
        String[] sp = splitString(attributes);
        for (int i = 0; i < sp.length; i++) {
            String[] attr = sp[i].split("=");
            Log.w(TAG, " Unable to parse " + sp[i]);
            set.setStringValue(attr[0], attr[1]);
        }
    }

    private static String[] splitString(String str) {
        char[] chars = str.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        boolean indouble = false;
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ',' && !indouble) {
                list.add(new String(chars, start, i - start));
                start = i + 1;
            } else if (chars[i] == '\"') {
                indouble = !indouble;
            }
        }
        list.add(new String(chars, start, chars.length - start));
        return (String[]) list.toArray(new String[list.size()]);
    }

    public void addIntAttributes(String... attributeName) {
        addAttributes(ConstraintAttribute.AttributeType.INT_TYPE, attributeName);
    }

    public void addColorAttributes(String... attributeName) {
        addAttributes(ConstraintAttribute.AttributeType.COLOR_TYPE, attributeName);
    }

    public void addFloatAttributes(String... attributeName) {
        addAttributes(ConstraintAttribute.AttributeType.FLOAT_TYPE, attributeName);
    }

    public void addStringAttributes(String... attributeName) {
        addAttributes(ConstraintAttribute.AttributeType.STRING_TYPE, attributeName);
    }

    private Constraint get(int id) {
        if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
            this.mConstraints.put(Integer.valueOf(id), new Constraint());
        }
        return this.mConstraints.get(Integer.valueOf(id));
    }

    private String sideToString(int side) {
        switch (side) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    public void load(Context context, int resourceId) {
        XmlPullParser parser = context.getResources().getXml(resourceId);
        try {
            for (int eventType = parser.getEventType(); eventType != 1; eventType = parser.next()) {
                switch (eventType) {
                    case 0:
                        String document = parser.getName();
                        break;
                    case 2:
                        String tagName = parser.getName();
                        Constraint constraint = fillFromAttributeList(context, Xml.asAttributeSet(parser));
                        if (tagName.equalsIgnoreCase("Guideline")) {
                            constraint.layout.mIsGuideline = true;
                        }
                        this.mConstraints.put(Integer.valueOf(constraint.mViewId), constraint);
                        break;
                    case 3:
                        break;
                }
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void load(android.content.Context r8, org.xmlpull.v1.XmlPullParser r9) {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            int r2 = r9.getEventType()     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
        L_0x0006:
            r3 = 1
            if (r2 == r3) goto L_0x0182
            java.lang.String r4 = "Constraint"
            switch(r2) {
                case 0: goto L_0x0176;
                case 1: goto L_0x000e;
                case 2: goto L_0x0033;
                case 3: goto L_0x0010;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x017b
        L_0x0010:
            java.lang.String r3 = r9.getName()     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r0 = r3
            java.lang.String r3 = "ConstraintSet"
            boolean r3 = r3.equals(r0)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            if (r3 == 0) goto L_0x001e
            return
        L_0x001e:
            boolean r3 = r0.equalsIgnoreCase(r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            if (r3 == 0) goto L_0x0030
            java.util.HashMap<java.lang.Integer, androidx.constraintlayout.widget.ConstraintSet$Constraint> r3 = r7.mConstraints     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            int r4 = r1.mViewId     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r3.put(r4, r1)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r1 = 0
        L_0x0030:
            r0 = 0
            goto L_0x017b
        L_0x0033:
            java.lang.String r5 = r9.getName()     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r0 = r5
            r5 = -1
            int r6 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            switch(r6) {
                case -2025855158: goto L_0x0085;
                case -1984451626: goto L_0x007b;
                case -1269513683: goto L_0x0071;
                case -1238332596: goto L_0x0067;
                case -71750448: goto L_0x005d;
                case 1331510167: goto L_0x0053;
                case 1791837707: goto L_0x0049;
                case 1803088381: goto L_0x0041;
                default: goto L_0x0040;
            }     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
        L_0x0040:
            goto L_0x008e
        L_0x0041:
            boolean r4 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            if (r4 == 0) goto L_0x0040
            r5 = 0
            goto L_0x008e
        L_0x0049:
            java.lang.String r4 = "CustomAttribute"
            boolean r4 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            if (r4 == 0) goto L_0x0040
            r5 = 7
            goto L_0x008e
        L_0x0053:
            java.lang.String r4 = "Barrier"
            boolean r4 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            if (r4 == 0) goto L_0x0040
            r5 = 2
            goto L_0x008e
        L_0x005d:
            java.lang.String r4 = "Guideline"
            boolean r4 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            if (r4 == 0) goto L_0x0040
            r5 = 1
            goto L_0x008e
        L_0x0067:
            java.lang.String r4 = "Transform"
            boolean r4 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            if (r4 == 0) goto L_0x0040
            r5 = 4
            goto L_0x008e
        L_0x0071:
            java.lang.String r4 = "PropertySet"
            boolean r4 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            if (r4 == 0) goto L_0x0040
            r5 = 3
            goto L_0x008e
        L_0x007b:
            java.lang.String r4 = "Motion"
            boolean r4 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            if (r4 == 0) goto L_0x0040
            r5 = 6
            goto L_0x008e
        L_0x0085:
            java.lang.String r4 = "Layout"
            boolean r4 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            if (r4 == 0) goto L_0x0040
            r5 = 5
        L_0x008e:
            java.lang.String r4 = "XML parser error must be within a Constraint "
            switch(r5) {
                case 0: goto L_0x016b;
                case 1: goto L_0x015b;
                case 2: goto L_0x014d;
                case 3: goto L_0x0128;
                case 4: goto L_0x0103;
                case 5: goto L_0x00dd;
                case 6: goto L_0x00b7;
                case 7: goto L_0x0095;
                default: goto L_0x0093;
            }
        L_0x0093:
            goto L_0x0175
        L_0x0095:
            if (r1 == 0) goto L_0x009e
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r3 = r1.mCustomConstraints     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            androidx.constraintlayout.widget.ConstraintAttribute.parse(r8, r9, r3)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            goto L_0x0175
        L_0x009e:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r5.<init>()     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r5.append(r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            int r4 = r9.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r5.append(r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            java.lang.String r4 = r5.toString()     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r3.<init>(r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            throw r3     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
        L_0x00b7:
            if (r1 == 0) goto L_0x00c4
            androidx.constraintlayout.widget.ConstraintSet$Motion r3 = r1.motion     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            android.util.AttributeSet r4 = android.util.Xml.asAttributeSet(r9)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r3.fillFromAttributeList(r8, r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            goto L_0x0175
        L_0x00c4:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r5.<init>()     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r5.append(r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            int r4 = r9.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r5.append(r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            java.lang.String r4 = r5.toString()     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r3.<init>(r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            throw r3     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
        L_0x00dd:
            if (r1 == 0) goto L_0x00ea
            androidx.constraintlayout.widget.ConstraintSet$Layout r3 = r1.layout     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            android.util.AttributeSet r4 = android.util.Xml.asAttributeSet(r9)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r3.fillFromAttributeList(r8, r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            goto L_0x0175
        L_0x00ea:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r5.<init>()     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r5.append(r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            int r4 = r9.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r5.append(r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            java.lang.String r4 = r5.toString()     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r3.<init>(r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            throw r3     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
        L_0x0103:
            if (r1 == 0) goto L_0x010f
            androidx.constraintlayout.widget.ConstraintSet$Transform r3 = r1.transform     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            android.util.AttributeSet r4 = android.util.Xml.asAttributeSet(r9)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r3.fillFromAttributeList(r8, r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            goto L_0x0175
        L_0x010f:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r5.<init>()     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r5.append(r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            int r4 = r9.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r5.append(r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            java.lang.String r4 = r5.toString()     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r3.<init>(r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            throw r3     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
        L_0x0128:
            if (r1 == 0) goto L_0x0134
            androidx.constraintlayout.widget.ConstraintSet$PropertySet r3 = r1.propertySet     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            android.util.AttributeSet r4 = android.util.Xml.asAttributeSet(r9)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r3.fillFromAttributeList(r8, r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            goto L_0x0175
        L_0x0134:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r5.<init>()     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r5.append(r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            int r4 = r9.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r5.append(r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            java.lang.String r4 = r5.toString()     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r3.<init>(r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            throw r3     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
        L_0x014d:
            android.util.AttributeSet r4 = android.util.Xml.asAttributeSet(r9)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            androidx.constraintlayout.widget.ConstraintSet$Constraint r4 = r7.fillFromAttributeList(r8, r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r1 = r4
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r1.layout     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r4.mHelperType = r3     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            goto L_0x0175
        L_0x015b:
            android.util.AttributeSet r4 = android.util.Xml.asAttributeSet(r9)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            androidx.constraintlayout.widget.ConstraintSet$Constraint r4 = r7.fillFromAttributeList(r8, r4)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r1 = r4
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = r1.layout     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r4.mIsGuideline = r3     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r4.mApply = r3     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            goto L_0x0175
        L_0x016b:
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r9)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            androidx.constraintlayout.widget.ConstraintSet$Constraint r3 = r7.fillFromAttributeList(r8, r3)     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r1 = r3
        L_0x0175:
            goto L_0x017b
        L_0x0176:
            java.lang.String r3 = r9.getName()     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
        L_0x017b:
            int r3 = r9.next()     // Catch:{ XmlPullParserException -> 0x0188, IOException -> 0x0183 }
            r2 = r3
            goto L_0x0006
        L_0x0182:
            goto L_0x018c
        L_0x0183:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x018d
        L_0x0188:
            r1 = move-exception
            r1.printStackTrace()
        L_0x018c:
        L_0x018d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.load(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    /* access modifiers changed from: private */
    public static int lookupID(TypedArray a, int index, int def) {
        int ret = a.getResourceId(index, def);
        if (ret == -1) {
            return a.getInt(index, -1);
        }
        return ret;
    }

    private Constraint fillFromAttributeList(Context context, AttributeSet attrs) {
        Constraint c = new Constraint();
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Constraint);
        populateConstraint(context, c, a);
        a.recycle();
        return c;
    }

    private void populateConstraint(Context ctx, Constraint c, TypedArray a) {
        int N = a.getIndexCount();
        for (int i = 0; i < N; i++) {
            int attr = a.getIndex(i);
            if (!(attr == R.styleable.Constraint_android_id || R.styleable.Constraint_android_layout_marginStart == attr || R.styleable.Constraint_android_layout_marginEnd == attr)) {
                c.motion.mApply = true;
                c.layout.mApply = true;
                c.propertySet.mApply = true;
                c.transform.mApply = true;
            }
            switch (mapToConstant.get(attr)) {
                case 1:
                    Layout layout = c.layout;
                    layout.baselineToBaseline = lookupID(a, attr, layout.baselineToBaseline);
                    break;
                case 2:
                    Layout layout2 = c.layout;
                    layout2.bottomMargin = a.getDimensionPixelSize(attr, layout2.bottomMargin);
                    break;
                case 3:
                    Layout layout3 = c.layout;
                    layout3.bottomToBottom = lookupID(a, attr, layout3.bottomToBottom);
                    break;
                case 4:
                    Layout layout4 = c.layout;
                    layout4.bottomToTop = lookupID(a, attr, layout4.bottomToTop);
                    break;
                case 5:
                    c.layout.dimensionRatio = a.getString(attr);
                    break;
                case 6:
                    Layout layout5 = c.layout;
                    layout5.editorAbsoluteX = a.getDimensionPixelOffset(attr, layout5.editorAbsoluteX);
                    break;
                case 7:
                    Layout layout6 = c.layout;
                    layout6.editorAbsoluteY = a.getDimensionPixelOffset(attr, layout6.editorAbsoluteY);
                    break;
                case 8:
                    if (Build.VERSION.SDK_INT < 17) {
                        break;
                    } else {
                        Layout layout7 = c.layout;
                        layout7.endMargin = a.getDimensionPixelSize(attr, layout7.endMargin);
                        break;
                    }
                case 9:
                    Layout layout8 = c.layout;
                    layout8.endToEnd = lookupID(a, attr, layout8.endToEnd);
                    break;
                case 10:
                    Layout layout9 = c.layout;
                    layout9.endToStart = lookupID(a, attr, layout9.endToStart);
                    break;
                case 11:
                    Layout layout10 = c.layout;
                    layout10.goneBottomMargin = a.getDimensionPixelSize(attr, layout10.goneBottomMargin);
                    break;
                case 12:
                    Layout layout11 = c.layout;
                    layout11.goneEndMargin = a.getDimensionPixelSize(attr, layout11.goneEndMargin);
                    break;
                case 13:
                    Layout layout12 = c.layout;
                    layout12.goneLeftMargin = a.getDimensionPixelSize(attr, layout12.goneLeftMargin);
                    break;
                case 14:
                    Layout layout13 = c.layout;
                    layout13.goneRightMargin = a.getDimensionPixelSize(attr, layout13.goneRightMargin);
                    break;
                case 15:
                    Layout layout14 = c.layout;
                    layout14.goneStartMargin = a.getDimensionPixelSize(attr, layout14.goneStartMargin);
                    break;
                case 16:
                    Layout layout15 = c.layout;
                    layout15.goneTopMargin = a.getDimensionPixelSize(attr, layout15.goneTopMargin);
                    break;
                case 17:
                    Layout layout16 = c.layout;
                    layout16.guideBegin = a.getDimensionPixelOffset(attr, layout16.guideBegin);
                    break;
                case 18:
                    Layout layout17 = c.layout;
                    layout17.guideEnd = a.getDimensionPixelOffset(attr, layout17.guideEnd);
                    break;
                case 19:
                    Layout layout18 = c.layout;
                    layout18.guidePercent = a.getFloat(attr, layout18.guidePercent);
                    break;
                case 20:
                    Layout layout19 = c.layout;
                    layout19.horizontalBias = a.getFloat(attr, layout19.horizontalBias);
                    break;
                case 21:
                    Layout layout20 = c.layout;
                    layout20.mHeight = a.getLayoutDimension(attr, layout20.mHeight);
                    break;
                case 22:
                    PropertySet propertySet = c.propertySet;
                    propertySet.visibility = a.getInt(attr, propertySet.visibility);
                    PropertySet propertySet2 = c.propertySet;
                    propertySet2.visibility = VISIBILITY_FLAGS[propertySet2.visibility];
                    break;
                case 23:
                    Layout layout21 = c.layout;
                    layout21.mWidth = a.getLayoutDimension(attr, layout21.mWidth);
                    break;
                case 24:
                    Layout layout22 = c.layout;
                    layout22.leftMargin = a.getDimensionPixelSize(attr, layout22.leftMargin);
                    break;
                case 25:
                    Layout layout23 = c.layout;
                    layout23.leftToLeft = lookupID(a, attr, layout23.leftToLeft);
                    break;
                case 26:
                    Layout layout24 = c.layout;
                    layout24.leftToRight = lookupID(a, attr, layout24.leftToRight);
                    break;
                case 27:
                    Layout layout25 = c.layout;
                    layout25.orientation = a.getInt(attr, layout25.orientation);
                    break;
                case 28:
                    Layout layout26 = c.layout;
                    layout26.rightMargin = a.getDimensionPixelSize(attr, layout26.rightMargin);
                    break;
                case 29:
                    Layout layout27 = c.layout;
                    layout27.rightToLeft = lookupID(a, attr, layout27.rightToLeft);
                    break;
                case 30:
                    Layout layout28 = c.layout;
                    layout28.rightToRight = lookupID(a, attr, layout28.rightToRight);
                    break;
                case 31:
                    if (Build.VERSION.SDK_INT < 17) {
                        break;
                    } else {
                        Layout layout29 = c.layout;
                        layout29.startMargin = a.getDimensionPixelSize(attr, layout29.startMargin);
                        break;
                    }
                case 32:
                    Layout layout30 = c.layout;
                    layout30.startToEnd = lookupID(a, attr, layout30.startToEnd);
                    break;
                case 33:
                    Layout layout31 = c.layout;
                    layout31.startToStart = lookupID(a, attr, layout31.startToStart);
                    break;
                case 34:
                    Layout layout32 = c.layout;
                    layout32.topMargin = a.getDimensionPixelSize(attr, layout32.topMargin);
                    break;
                case 35:
                    Layout layout33 = c.layout;
                    layout33.topToBottom = lookupID(a, attr, layout33.topToBottom);
                    break;
                case 36:
                    Layout layout34 = c.layout;
                    layout34.topToTop = lookupID(a, attr, layout34.topToTop);
                    break;
                case 37:
                    Layout layout35 = c.layout;
                    layout35.verticalBias = a.getFloat(attr, layout35.verticalBias);
                    break;
                case 38:
                    c.mViewId = a.getResourceId(attr, c.mViewId);
                    break;
                case 39:
                    Layout layout36 = c.layout;
                    layout36.horizontalWeight = a.getFloat(attr, layout36.horizontalWeight);
                    break;
                case 40:
                    Layout layout37 = c.layout;
                    layout37.verticalWeight = a.getFloat(attr, layout37.verticalWeight);
                    break;
                case 41:
                    Layout layout38 = c.layout;
                    layout38.horizontalChainStyle = a.getInt(attr, layout38.horizontalChainStyle);
                    break;
                case 42:
                    Layout layout39 = c.layout;
                    layout39.verticalChainStyle = a.getInt(attr, layout39.verticalChainStyle);
                    break;
                case 43:
                    PropertySet propertySet3 = c.propertySet;
                    propertySet3.alpha = a.getFloat(attr, propertySet3.alpha);
                    break;
                case 44:
                    if (Build.VERSION.SDK_INT < 21) {
                        break;
                    } else {
                        Transform transform = c.transform;
                        transform.applyElevation = true;
                        transform.elevation = a.getDimension(attr, transform.elevation);
                        break;
                    }
                case 45:
                    Transform transform2 = c.transform;
                    transform2.rotationX = a.getFloat(attr, transform2.rotationX);
                    break;
                case 46:
                    Transform transform3 = c.transform;
                    transform3.rotationY = a.getFloat(attr, transform3.rotationY);
                    break;
                case 47:
                    Transform transform4 = c.transform;
                    transform4.scaleX = a.getFloat(attr, transform4.scaleX);
                    break;
                case 48:
                    Transform transform5 = c.transform;
                    transform5.scaleY = a.getFloat(attr, transform5.scaleY);
                    break;
                case 49:
                    Transform transform6 = c.transform;
                    transform6.transformPivotX = a.getDimension(attr, transform6.transformPivotX);
                    break;
                case 50:
                    Transform transform7 = c.transform;
                    transform7.transformPivotY = a.getDimension(attr, transform7.transformPivotY);
                    break;
                case 51:
                    Transform transform8 = c.transform;
                    transform8.translationX = a.getDimension(attr, transform8.translationX);
                    break;
                case 52:
                    Transform transform9 = c.transform;
                    transform9.translationY = a.getDimension(attr, transform9.translationY);
                    break;
                case 53:
                    if (Build.VERSION.SDK_INT < 21) {
                        break;
                    } else {
                        Transform transform10 = c.transform;
                        transform10.translationZ = a.getDimension(attr, transform10.translationZ);
                        break;
                    }
                case 54:
                    Layout layout40 = c.layout;
                    layout40.widthDefault = a.getInt(attr, layout40.widthDefault);
                    break;
                case 55:
                    Layout layout41 = c.layout;
                    layout41.heightDefault = a.getInt(attr, layout41.heightDefault);
                    break;
                case 56:
                    Layout layout42 = c.layout;
                    layout42.widthMax = a.getDimensionPixelSize(attr, layout42.widthMax);
                    break;
                case 57:
                    Layout layout43 = c.layout;
                    layout43.heightMax = a.getDimensionPixelSize(attr, layout43.heightMax);
                    break;
                case 58:
                    Layout layout44 = c.layout;
                    layout44.widthMin = a.getDimensionPixelSize(attr, layout44.widthMin);
                    break;
                case 59:
                    Layout layout45 = c.layout;
                    layout45.heightMin = a.getDimensionPixelSize(attr, layout45.heightMin);
                    break;
                case 60:
                    Transform transform11 = c.transform;
                    transform11.rotation = a.getFloat(attr, transform11.rotation);
                    break;
                case 61:
                    Layout layout46 = c.layout;
                    layout46.circleConstraint = lookupID(a, attr, layout46.circleConstraint);
                    break;
                case 62:
                    Layout layout47 = c.layout;
                    layout47.circleRadius = a.getDimensionPixelSize(attr, layout47.circleRadius);
                    break;
                case 63:
                    Layout layout48 = c.layout;
                    layout48.circleAngle = a.getFloat(attr, layout48.circleAngle);
                    break;
                case 64:
                    Motion motion = c.motion;
                    motion.mAnimateRelativeTo = lookupID(a, attr, motion.mAnimateRelativeTo);
                    break;
                case 65:
                    if (a.peekValue(attr).type != 3) {
                        c.motion.mTransitionEasing = Easing.NAMED_EASING[a.getInteger(attr, 0)];
                        break;
                    } else {
                        c.motion.mTransitionEasing = a.getString(attr);
                        break;
                    }
                case 66:
                    c.motion.mDrawPath = a.getInt(attr, 0);
                    break;
                case 67:
                    Motion motion2 = c.motion;
                    motion2.mPathRotate = a.getFloat(attr, motion2.mPathRotate);
                    break;
                case 68:
                    PropertySet propertySet4 = c.propertySet;
                    propertySet4.mProgress = a.getFloat(attr, propertySet4.mProgress);
                    break;
                case 69:
                    c.layout.widthPercent = a.getFloat(attr, 1.0f);
                    break;
                case 70:
                    c.layout.heightPercent = a.getFloat(attr, 1.0f);
                    break;
                case 71:
                    Log.e(TAG, "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    Layout layout49 = c.layout;
                    layout49.mBarrierDirection = a.getInt(attr, layout49.mBarrierDirection);
                    break;
                case 73:
                    Layout layout50 = c.layout;
                    layout50.mBarrierMargin = a.getDimensionPixelSize(attr, layout50.mBarrierMargin);
                    break;
                case 74:
                    c.layout.mReferenceIdString = a.getString(attr);
                    break;
                case 75:
                    Layout layout51 = c.layout;
                    layout51.mBarrierAllowsGoneWidgets = a.getBoolean(attr, layout51.mBarrierAllowsGoneWidgets);
                    break;
                case 76:
                    Motion motion3 = c.motion;
                    motion3.mPathMotionArc = a.getInt(attr, motion3.mPathMotionArc);
                    break;
                case 77:
                    c.layout.mConstraintTag = a.getString(attr);
                    break;
                case 78:
                    PropertySet propertySet5 = c.propertySet;
                    propertySet5.mVisibilityMode = a.getInt(attr, propertySet5.mVisibilityMode);
                    break;
                case 79:
                    Motion motion4 = c.motion;
                    motion4.mMotionStagger = a.getFloat(attr, motion4.mMotionStagger);
                    break;
                case 80:
                    Layout layout52 = c.layout;
                    layout52.constrainedWidth = a.getBoolean(attr, layout52.constrainedWidth);
                    break;
                case 81:
                    Layout layout53 = c.layout;
                    layout53.constrainedHeight = a.getBoolean(attr, layout53.constrainedHeight);
                    break;
                case 82:
                    Log.w(TAG, "unused attribute 0x" + Integer.toHexString(attr) + "   " + mapToConstant.get(attr));
                    break;
                default:
                    Log.w(TAG, "Unknown attribute 0x" + Integer.toHexString(attr) + "   " + mapToConstant.get(attr));
                    break;
            }
        }
    }

    private int[] convertReferenceString(View view, String referenceIdString) {
        Object value;
        String[] split = referenceIdString.split(",");
        Context context = view.getContext();
        int[] tags = new int[split.length];
        int count = 0;
        int i = 0;
        while (i < split.length) {
            String idString = split[i].trim();
            int tag = 0;
            try {
                tag = R.id.class.getField(idString).getInt((Object) null);
            } catch (Exception e) {
            }
            if (tag == 0) {
                tag = context.getResources().getIdentifier(idString, "id", context.getPackageName());
            }
            if (tag == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (value = ((ConstraintLayout) view.getParent()).getDesignInformation(0, idString)) != null && (value instanceof Integer)) {
                tag = ((Integer) value).intValue();
            }
            tags[count] = tag;
            i++;
            count++;
        }
        if (count != split.length) {
            return Arrays.copyOf(tags, count);
        }
        return tags;
    }

    public Constraint getConstraint(int id) {
        if (this.mConstraints.containsKey(Integer.valueOf(id))) {
            return this.mConstraints.get(Integer.valueOf(id));
        }
        return null;
    }

    public int[] getKnownIds() {
        Integer[] arr = (Integer[]) this.mConstraints.keySet().toArray(new Integer[0]);
        int[] array = new int[arr.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = arr[i].intValue();
        }
        return array;
    }

    public boolean isForceId() {
        return this.mForceId;
    }

    public void setForceId(boolean forceId) {
        this.mForceId = forceId;
    }

    public void setValidateOnParse(boolean validate) {
        this.mValidate = validate;
    }

    public void dump(MotionScene scene, int... ids) {
        HashSet<Integer> set;
        Set<Integer> keys = this.mConstraints.keySet();
        if (ids.length != 0) {
            set = new HashSet<>();
            for (int id : ids) {
                set.add(Integer.valueOf(id));
            }
        } else {
            set = new HashSet<>(keys);
        }
        System.out.println(set.size() + " constraints");
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer id2 : (Integer[]) set.toArray(new Integer[0])) {
            stringBuilder.append("<Constraint id=");
            stringBuilder.append(id2);
            stringBuilder.append(" \n");
            this.mConstraints.get(id2).layout.dump(scene, stringBuilder);
            stringBuilder.append("/>\n");
        }
        System.out.println(stringBuilder.toString());
    }
}
