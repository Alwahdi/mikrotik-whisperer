package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

public class ChainRun extends WidgetRun {
    private int chainStyle;
    ArrayList<WidgetRun> widgets = new ArrayList<>();

    public ChainRun(ConstraintWidget widget, int orientation) {
        super(widget);
        this.orientation = orientation;
        build();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ChainRun ");
        sb.append(this.orientation == 0 ? "horizontal : " : "vertical : ");
        String log = sb.toString();
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            log = ((log + "<") + it.next()) + "> ";
        }
        return log;
    }

    /* access modifiers changed from: package-private */
    public boolean supportsWrapComputation() {
        int count = this.widgets.size();
        for (int i = 0; i < count; i++) {
            if (!this.widgets.get(i).supportsWrapComputation()) {
                return false;
            }
        }
        return true;
    }

    public long getWrapDimension() {
        int count = this.widgets.size();
        long wrapDimension = 0;
        for (int i = 0; i < count; i++) {
            WidgetRun run = this.widgets.get(i);
            wrapDimension = wrapDimension + ((long) run.start.margin) + run.getWrapDimension() + ((long) run.end.margin);
        }
        return wrapDimension;
    }

    private void build() {
        ConstraintWidget current = this.widget;
        ConstraintWidget previous = current.getPreviousChainMember(this.orientation);
        while (previous != null) {
            current = previous;
            previous = current.getPreviousChainMember(this.orientation);
        }
        this.widget = current;
        this.widgets.add(current.getRun(this.orientation));
        ConstraintWidget next = current.getNextChainMember(this.orientation);
        while (next != null) {
            ConstraintWidget current2 = next;
            this.widgets.add(current2.getRun(this.orientation));
            next = current2.getNextChainMember(this.orientation);
        }
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            WidgetRun run = it.next();
            int i = this.orientation;
            if (i == 0) {
                run.widget.horizontalChainRun = this;
            } else if (i == 1) {
                run.widget.verticalChainRun = this;
            }
        }
        if ((this.orientation == 0 && ((ConstraintWidgetContainer) this.widget.getParent()).isRtl()) && this.widgets.size() > 1) {
            ArrayList<WidgetRun> arrayList = this.widgets;
            this.widget = arrayList.get(arrayList.size() - 1).widget;
        }
        this.chainStyle = this.orientation == 0 ? this.widget.getHorizontalChainStyle() : this.widget.getVerticalChainStyle();
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        this.runGroup = null;
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    /* access modifiers changed from: package-private */
    public void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f7 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update(androidx.constraintlayout.solver.widgets.analyzer.Dependency r28) {
        /*
            r27 = this;
            r0 = r27
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r0.start
            boolean r1 = r1.resolved
            if (r1 == 0) goto L_0x04be
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r0.end
            boolean r1 = r1.resolved
            if (r1 != 0) goto L_0x0010
            goto L_0x04be
        L_0x0010:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r0.widget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r1.getParent()
            r2 = 0
            if (r1 == 0) goto L_0x0024
            boolean r3 = r1 instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
            if (r3 == 0) goto L_0x0024
            r3 = r1
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r3 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) r3
            boolean r2 = r3.isRtl()
        L_0x0024:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r0.end
            int r3 = r3.value
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r4 = r0.start
            int r4 = r4.value
            int r3 = r3 - r4
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r8 = r0.widgets
            int r8 = r8.size()
            r9 = -1
            r10 = 0
        L_0x0039:
            r11 = 8
            if (r10 >= r8) goto L_0x0052
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r12 = r0.widgets
            java.lang.Object r12 = r12.get(r10)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r12 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r12
            androidx.constraintlayout.solver.widgets.ConstraintWidget r13 = r12.widget
            int r13 = r13.getVisibility()
            if (r13 != r11) goto L_0x0051
            int r10 = r10 + 1
            goto L_0x0039
        L_0x0051:
            r9 = r10
        L_0x0052:
            r10 = -1
            int r12 = r8 + -1
        L_0x0055:
            if (r12 < 0) goto L_0x006c
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r13 = r0.widgets
            java.lang.Object r13 = r13.get(r12)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r13 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r13
            androidx.constraintlayout.solver.widgets.ConstraintWidget r14 = r13.widget
            int r14 = r14.getVisibility()
            if (r14 != r11) goto L_0x006b
            int r12 = r12 + -1
            goto L_0x0055
        L_0x006b:
            r10 = r12
        L_0x006c:
            r12 = 0
        L_0x006d:
            r15 = 2
            if (r12 >= r15) goto L_0x011f
            r17 = 0
            r15 = r17
        L_0x0074:
            if (r15 >= r8) goto L_0x010c
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r13 = r0.widgets
            java.lang.Object r13 = r13.get(r15)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r13 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r13
            androidx.constraintlayout.solver.widgets.ConstraintWidget r14 = r13.widget
            int r14 = r14.getVisibility()
            if (r14 != r11) goto L_0x008a
            r19 = r1
            goto L_0x0104
        L_0x008a:
            int r7 = r7 + 1
            if (r15 <= 0) goto L_0x0095
            if (r15 < r9) goto L_0x0095
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r14 = r13.start
            int r14 = r14.margin
            int r4 = r4 + r14
        L_0x0095:
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency r14 = r13.dimension
            int r11 = r14.value
            r19 = r1
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = r13.dimensionBehavior
            r20 = r7
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 == r7) goto L_0x00a5
            r1 = 1
            goto L_0x00a6
        L_0x00a5:
            r1 = 0
        L_0x00a6:
            if (r1 == 0) goto L_0x00c8
            int r7 = r0.orientation
            if (r7 != 0) goto L_0x00b7
            androidx.constraintlayout.solver.widgets.ConstraintWidget r14 = r13.widget
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r14 = r14.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency r14 = r14.dimension
            boolean r14 = r14.resolved
            if (r14 != 0) goto L_0x00b7
            return
        L_0x00b7:
            r14 = 1
            if (r7 != r14) goto L_0x00c5
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r13.widget
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r7 = r7.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency r7 = r7.dimension
            boolean r7 = r7.resolved
            if (r7 != 0) goto L_0x00c5
            return
        L_0x00c5:
            r21 = r1
            goto L_0x00dd
        L_0x00c8:
            int r7 = r13.matchConstraintsType
            r21 = r1
            r1 = 1
            if (r7 != r1) goto L_0x00d7
            if (r12 != 0) goto L_0x00d7
            r1 = 1
            int r11 = r14.wrapValue
            int r5 = r5 + 1
            goto L_0x00df
        L_0x00d7:
            boolean r1 = r14.resolved
            if (r1 == 0) goto L_0x00dd
            r1 = 1
            goto L_0x00df
        L_0x00dd:
            r1 = r21
        L_0x00df:
            if (r1 != 0) goto L_0x00f2
            int r5 = r5 + 1
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r13.widget
            float[] r7 = r7.mWeight
            int r14 = r0.orientation
            r7 = r7[r14]
            r14 = 0
            int r21 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
            if (r21 < 0) goto L_0x00f1
            float r6 = r6 + r7
        L_0x00f1:
            goto L_0x00f3
        L_0x00f2:
            int r4 = r4 + r11
        L_0x00f3:
            int r7 = r8 + -1
            if (r15 >= r7) goto L_0x0102
            if (r15 >= r10) goto L_0x0102
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r7 = r13.end
            int r7 = r7.margin
            int r7 = -r7
            int r4 = r4 + r7
            r7 = r20
            goto L_0x0104
        L_0x0102:
            r7 = r20
        L_0x0104:
            int r15 = r15 + 1
            r1 = r19
            r11 = 8
            goto L_0x0074
        L_0x010c:
            r19 = r1
            if (r4 < r3) goto L_0x0121
            if (r5 != 0) goto L_0x0113
            goto L_0x0121
        L_0x0113:
            r7 = 0
            r5 = 0
            r4 = 0
            r6 = 0
            int r12 = r12 + 1
            r1 = r19
            r11 = 8
            goto L_0x006d
        L_0x011f:
            r19 = r1
        L_0x0121:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r0.start
            int r1 = r1.value
            if (r2 == 0) goto L_0x012b
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r11 = r0.end
            int r1 = r11.value
        L_0x012b:
            r11 = 1056964608(0x3f000000, float:0.5)
            if (r4 <= r3) goto L_0x0142
            r12 = 1073741824(0x40000000, float:2.0)
            if (r2 == 0) goto L_0x013b
            int r13 = r4 - r3
            float r13 = (float) r13
            float r13 = r13 / r12
            float r13 = r13 + r11
            int r12 = (int) r13
            int r1 = r1 + r12
            goto L_0x0142
        L_0x013b:
            int r13 = r4 - r3
            float r13 = (float) r13
            float r13 = r13 / r12
            float r13 = r13 + r11
            int r12 = (int) r13
            int r1 = r1 - r12
        L_0x0142:
            r12 = 0
            if (r5 <= 0) goto L_0x027a
            int r13 = r3 - r4
            float r13 = (float) r13
            float r14 = (float) r5
            float r13 = r13 / r14
            float r13 = r13 + r11
            int r12 = (int) r13
            r13 = 0
            r14 = 0
        L_0x014e:
            if (r14 >= r8) goto L_0x0226
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r15 = r0.widgets
            java.lang.Object r15 = r15.get(r14)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r15 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r15
            androidx.constraintlayout.solver.widgets.ConstraintWidget r11 = r15.widget
            int r11 = r11.getVisibility()
            r21 = r1
            r1 = 8
            if (r11 != r1) goto L_0x0172
            r26 = r2
            r22 = r4
            r25 = r6
            r24 = r7
            r23 = r12
            r18 = 0
            goto L_0x0214
        L_0x0172:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = r15.dimensionBehavior
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 != r11) goto L_0x0208
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency r1 = r15.dimension
            boolean r11 = r1.resolved
            if (r11 != 0) goto L_0x0208
            r11 = r12
            r18 = 0
            int r22 = (r6 > r18 ? 1 : (r6 == r18 ? 0 : -1))
            if (r22 <= 0) goto L_0x019e
            r22 = r11
            androidx.constraintlayout.solver.widgets.ConstraintWidget r11 = r15.widget
            float[] r11 = r11.mWeight
            r23 = r12
            int r12 = r0.orientation
            r11 = r11[r12]
            int r12 = r3 - r4
            float r12 = (float) r12
            float r12 = r12 * r11
            float r12 = r12 / r6
            r20 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 + r20
            int r12 = (int) r12
            r11 = r12
            goto L_0x01a2
        L_0x019e:
            r22 = r11
            r23 = r12
        L_0x01a2:
            int r12 = r0.orientation
            if (r12 != 0) goto L_0x01d9
            androidx.constraintlayout.solver.widgets.ConstraintWidget r12 = r15.widget
            r22 = r4
            int r4 = r12.mMatchConstraintMaxWidth
            int r12 = r12.mMatchConstraintMinWidth
            r24 = r11
            r25 = r6
            int r6 = r15.matchConstraintsType
            r26 = r2
            r2 = 1
            if (r6 != r2) goto L_0x01c4
            int r1 = r1.wrapValue
            r2 = r24
            int r24 = java.lang.Math.min(r2, r1)
            r2 = r24
            goto L_0x01c6
        L_0x01c4:
            r2 = r24
        L_0x01c6:
            int r1 = java.lang.Math.max(r12, r2)
            if (r4 <= 0) goto L_0x01d0
            int r1 = java.lang.Math.min(r4, r1)
        L_0x01d0:
            if (r1 == r11) goto L_0x01d6
            int r13 = r13 + 1
            r2 = r1
            r11 = r2
        L_0x01d6:
            r24 = r7
            goto L_0x0202
        L_0x01d9:
            r26 = r2
            r22 = r4
            r25 = r6
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r15.widget
            int r4 = r2.mMatchConstraintMaxHeight
            int r2 = r2.mMatchConstraintMinHeight
            r6 = r11
            int r12 = r15.matchConstraintsType
            r24 = r7
            r7 = 1
            if (r12 != r7) goto L_0x01f3
            int r1 = r1.wrapValue
            int r6 = java.lang.Math.min(r6, r1)
        L_0x01f3:
            int r1 = java.lang.Math.max(r2, r6)
            if (r4 <= 0) goto L_0x01fd
            int r1 = java.lang.Math.min(r4, r1)
        L_0x01fd:
            if (r1 == r11) goto L_0x0202
            int r13 = r13 + 1
            r11 = r1
        L_0x0202:
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency r1 = r15.dimension
            r1.resolve(r11)
            goto L_0x0214
        L_0x0208:
            r26 = r2
            r22 = r4
            r25 = r6
            r24 = r7
            r23 = r12
            r18 = 0
        L_0x0214:
            int r14 = r14 + 1
            r1 = r21
            r4 = r22
            r12 = r23
            r7 = r24
            r6 = r25
            r2 = r26
            r11 = 1056964608(0x3f000000, float:0.5)
            goto L_0x014e
        L_0x0226:
            r21 = r1
            r26 = r2
            r22 = r4
            r25 = r6
            r24 = r7
            r23 = r12
            if (r13 <= 0) goto L_0x026b
            int r5 = r5 - r13
            r1 = 0
            r2 = 0
        L_0x0237:
            if (r2 >= r8) goto L_0x0269
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r4 = r0.widgets
            java.lang.Object r4 = r4.get(r2)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r4 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r4
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r4.widget
            int r6 = r6.getVisibility()
            r7 = 8
            if (r6 != r7) goto L_0x024c
            goto L_0x0266
        L_0x024c:
            if (r2 <= 0) goto L_0x0255
            if (r2 < r9) goto L_0x0255
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r6 = r4.start
            int r6 = r6.margin
            int r1 = r1 + r6
        L_0x0255:
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency r6 = r4.dimension
            int r6 = r6.value
            int r1 = r1 + r6
            int r6 = r8 + -1
            if (r2 >= r6) goto L_0x0266
            if (r2 >= r10) goto L_0x0266
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r6 = r4.end
            int r6 = r6.margin
            int r6 = -r6
            int r1 = r1 + r6
        L_0x0266:
            int r2 = r2 + 1
            goto L_0x0237
        L_0x0269:
            r4 = r1
            goto L_0x026d
        L_0x026b:
            r4 = r22
        L_0x026d:
            int r1 = r0.chainStyle
            r2 = 2
            if (r1 != r2) goto L_0x0277
            if (r13 != 0) goto L_0x0277
            r1 = 0
            r0.chainStyle = r1
        L_0x0277:
            r12 = r23
            goto L_0x0284
        L_0x027a:
            r21 = r1
            r26 = r2
            r22 = r4
            r25 = r6
            r24 = r7
        L_0x0284:
            if (r4 <= r3) goto L_0x028a
            r1 = 2
            r0.chainStyle = r1
            goto L_0x028b
        L_0x028a:
            r1 = 2
        L_0x028b:
            if (r24 <= 0) goto L_0x0293
            if (r5 != 0) goto L_0x0293
            if (r9 != r10) goto L_0x0293
            r0.chainStyle = r1
        L_0x0293:
            int r1 = r0.chainStyle
            r2 = 1
            if (r1 != r2) goto L_0x034c
            r1 = 0
            r7 = r24
            if (r7 <= r2) goto L_0x02a4
            int r6 = r3 - r4
            int r11 = r7 + -1
            int r1 = r6 / r11
            goto L_0x02ab
        L_0x02a4:
            if (r7 != r2) goto L_0x02ab
            int r2 = r3 - r4
            r6 = 2
            int r1 = r2 / 2
        L_0x02ab:
            if (r5 <= 0) goto L_0x02ae
            r1 = 0
        L_0x02ae:
            r2 = 0
            r6 = r2
            r2 = r21
        L_0x02b2:
            if (r6 >= r8) goto L_0x0345
            r11 = r6
            if (r26 == 0) goto L_0x02bb
            int r13 = r6 + 1
            int r11 = r8 - r13
        L_0x02bb:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r13 = r0.widgets
            java.lang.Object r13 = r13.get(r11)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r13 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r13
            androidx.constraintlayout.solver.widgets.ConstraintWidget r14 = r13.widget
            int r14 = r14.getVisibility()
            r15 = 8
            if (r14 != r15) goto L_0x02db
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r14 = r13.start
            r14.resolve(r2)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r14 = r13.end
            r14.resolve(r2)
            r16 = r1
            goto L_0x033f
        L_0x02db:
            if (r6 <= 0) goto L_0x02e2
            if (r26 == 0) goto L_0x02e1
            int r2 = r2 - r1
            goto L_0x02e2
        L_0x02e1:
            int r2 = r2 + r1
        L_0x02e2:
            if (r6 <= 0) goto L_0x02f3
            if (r6 < r9) goto L_0x02f3
            if (r26 == 0) goto L_0x02ee
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r14 = r13.start
            int r14 = r14.margin
            int r2 = r2 - r14
            goto L_0x02f3
        L_0x02ee:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r14 = r13.start
            int r14 = r14.margin
            int r2 = r2 + r14
        L_0x02f3:
            if (r26 == 0) goto L_0x02fb
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r14 = r13.end
            r14.resolve(r2)
            goto L_0x0300
        L_0x02fb:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r14 = r13.start
            r14.resolve(r2)
        L_0x0300:
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency r14 = r13.dimension
            int r15 = r14.value
            r16 = r1
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = r13.dimensionBehavior
            r17 = r11
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 != r11) goto L_0x0315
            int r1 = r13.matchConstraintsType
            r11 = 1
            if (r1 != r11) goto L_0x0315
            int r15 = r14.wrapValue
        L_0x0315:
            if (r26 == 0) goto L_0x0319
            int r2 = r2 - r15
            goto L_0x031a
        L_0x0319:
            int r2 = r2 + r15
        L_0x031a:
            if (r26 == 0) goto L_0x0322
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r13.start
            r1.resolve(r2)
            goto L_0x0327
        L_0x0322:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r13.end
            r1.resolve(r2)
        L_0x0327:
            r1 = 1
            r13.resolved = r1
            int r1 = r8 + -1
            if (r6 >= r1) goto L_0x033f
            if (r6 >= r10) goto L_0x033f
            if (r26 == 0) goto L_0x0339
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r13.end
            int r1 = r1.margin
            int r1 = -r1
            int r2 = r2 - r1
            goto L_0x033f
        L_0x0339:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r13.end
            int r1 = r1.margin
            int r1 = -r1
            int r2 = r2 + r1
        L_0x033f:
            int r6 = r6 + 1
            r1 = r16
            goto L_0x02b2
        L_0x0345:
            r16 = r1
            r1 = r2
            r24 = r7
            goto L_0x04bd
        L_0x034c:
            r7 = r24
            if (r1 != 0) goto L_0x03f9
            int r1 = r3 - r4
            int r2 = r7 + 1
            int r1 = r1 / r2
            if (r5 <= 0) goto L_0x0358
            r1 = 0
        L_0x0358:
            r2 = 0
            r6 = r2
            r2 = r21
        L_0x035c:
            if (r6 >= r8) goto L_0x03f2
            r11 = r6
            if (r26 == 0) goto L_0x0365
            int r13 = r6 + 1
            int r11 = r8 - r13
        L_0x0365:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r13 = r0.widgets
            java.lang.Object r13 = r13.get(r11)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r13 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r13
            androidx.constraintlayout.solver.widgets.ConstraintWidget r14 = r13.widget
            int r14 = r14.getVisibility()
            r15 = 8
            if (r14 != r15) goto L_0x0387
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r14 = r13.start
            r14.resolve(r2)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r14 = r13.end
            r14.resolve(r2)
            r16 = r1
            r24 = r7
            goto L_0x03ea
        L_0x0387:
            if (r26 == 0) goto L_0x038b
            int r2 = r2 - r1
            goto L_0x038c
        L_0x038b:
            int r2 = r2 + r1
        L_0x038c:
            if (r6 <= 0) goto L_0x039d
            if (r6 < r9) goto L_0x039d
            if (r26 == 0) goto L_0x0398
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r14 = r13.start
            int r14 = r14.margin
            int r2 = r2 - r14
            goto L_0x039d
        L_0x0398:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r14 = r13.start
            int r14 = r14.margin
            int r2 = r2 + r14
        L_0x039d:
            if (r26 == 0) goto L_0x03a5
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r14 = r13.end
            r14.resolve(r2)
            goto L_0x03aa
        L_0x03a5:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r14 = r13.start
            r14.resolve(r2)
        L_0x03aa:
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency r14 = r13.dimension
            int r15 = r14.value
            r16 = r1
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = r13.dimensionBehavior
            r24 = r7
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 != r7) goto L_0x03c3
            int r1 = r13.matchConstraintsType
            r7 = 1
            if (r1 != r7) goto L_0x03c3
            int r1 = r14.wrapValue
            int r15 = java.lang.Math.min(r15, r1)
        L_0x03c3:
            if (r26 == 0) goto L_0x03c7
            int r2 = r2 - r15
            goto L_0x03c8
        L_0x03c7:
            int r2 = r2 + r15
        L_0x03c8:
            if (r26 == 0) goto L_0x03d0
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r13.start
            r1.resolve(r2)
            goto L_0x03d5
        L_0x03d0:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r13.end
            r1.resolve(r2)
        L_0x03d5:
            int r1 = r8 + -1
            if (r6 >= r1) goto L_0x03ea
            if (r6 >= r10) goto L_0x03ea
            if (r26 == 0) goto L_0x03e4
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r13.end
            int r1 = r1.margin
            int r1 = -r1
            int r2 = r2 - r1
            goto L_0x03ea
        L_0x03e4:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r13.end
            int r1 = r1.margin
            int r1 = -r1
            int r2 = r2 + r1
        L_0x03ea:
            int r6 = r6 + 1
            r1 = r16
            r7 = r24
            goto L_0x035c
        L_0x03f2:
            r16 = r1
            r24 = r7
            r1 = r2
            goto L_0x04bd
        L_0x03f9:
            r24 = r7
            r2 = 2
            if (r1 != r2) goto L_0x04bb
            int r1 = r0.orientation
            if (r1 != 0) goto L_0x0409
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r0.widget
            float r1 = r1.getHorizontalBiasPercent()
            goto L_0x040f
        L_0x0409:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r0.widget
            float r1 = r1.getVerticalBiasPercent()
        L_0x040f:
            if (r26 == 0) goto L_0x0416
            r2 = 1065353216(0x3f800000, float:1.0)
            float r1 = r2 - r1
        L_0x0416:
            int r2 = r3 - r4
            float r2 = (float) r2
            float r2 = r2 * r1
            r6 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r6
            int r2 = (int) r2
            if (r2 < 0) goto L_0x0423
            if (r5 <= 0) goto L_0x0424
        L_0x0423:
            r2 = 0
        L_0x0424:
            if (r26 == 0) goto L_0x0429
            int r6 = r21 - r2
            goto L_0x042b
        L_0x0429:
            int r6 = r21 + r2
        L_0x042b:
            r7 = 0
        L_0x042c:
            if (r7 >= r8) goto L_0x04b7
            r11 = r7
            if (r26 == 0) goto L_0x0435
            int r13 = r7 + 1
            int r11 = r8 - r13
        L_0x0435:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r13 = r0.widgets
            java.lang.Object r13 = r13.get(r11)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r13 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r13
            androidx.constraintlayout.solver.widgets.ConstraintWidget r14 = r13.widget
            int r14 = r14.getVisibility()
            r15 = 8
            if (r14 != r15) goto L_0x0455
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r14 = r13.start
            r14.resolve(r6)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r14 = r13.end
            r14.resolve(r6)
            r16 = r1
            r1 = 1
            goto L_0x04af
        L_0x0455:
            if (r7 <= 0) goto L_0x0466
            if (r7 < r9) goto L_0x0466
            if (r26 == 0) goto L_0x0461
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r14 = r13.start
            int r14 = r14.margin
            int r6 = r6 - r14
            goto L_0x0466
        L_0x0461:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r14 = r13.start
            int r14 = r14.margin
            int r6 = r6 + r14
        L_0x0466:
            if (r26 == 0) goto L_0x046e
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r14 = r13.end
            r14.resolve(r6)
            goto L_0x0473
        L_0x046e:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r14 = r13.start
            r14.resolve(r6)
        L_0x0473:
            androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency r14 = r13.dimension
            int r15 = r14.value
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = r13.dimensionBehavior
            r16 = r1
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x0487
            int r0 = r13.matchConstraintsType
            r1 = 1
            if (r0 != r1) goto L_0x0488
            int r15 = r14.wrapValue
            goto L_0x0488
        L_0x0487:
            r1 = 1
        L_0x0488:
            if (r26 == 0) goto L_0x048c
            int r6 = r6 - r15
            goto L_0x048d
        L_0x048c:
            int r6 = r6 + r15
        L_0x048d:
            if (r26 == 0) goto L_0x0495
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r13.start
            r0.resolve(r6)
            goto L_0x049a
        L_0x0495:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r13.end
            r0.resolve(r6)
        L_0x049a:
            int r0 = r8 + -1
            if (r7 >= r0) goto L_0x04af
            if (r7 >= r10) goto L_0x04af
            if (r26 == 0) goto L_0x04a9
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r13.end
            int r0 = r0.margin
            int r0 = -r0
            int r6 = r6 - r0
            goto L_0x04af
        L_0x04a9:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r13.end
            int r0 = r0.margin
            int r0 = -r0
            int r6 = r6 + r0
        L_0x04af:
            int r7 = r7 + 1
            r0 = r27
            r1 = r16
            goto L_0x042c
        L_0x04b7:
            r16 = r1
            r1 = r6
            goto L_0x04bd
        L_0x04bb:
            r1 = r21
        L_0x04bd:
            return
        L_0x04be:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.ChainRun.update(androidx.constraintlayout.solver.widgets.analyzer.Dependency):void");
    }

    public void applyToWidget() {
        for (int i = 0; i < this.widgets.size(); i++) {
            this.widgets.get(i).applyToWidget();
        }
    }

    private ConstraintWidget getFirstVisibleWidget() {
        for (int i = 0; i < this.widgets.size(); i++) {
            WidgetRun run = this.widgets.get(i);
            if (run.widget.getVisibility() != 8) {
                return run.widget;
            }
        }
        return null;
    }

    private ConstraintWidget getLastVisibleWidget() {
        for (int i = this.widgets.size() - 1; i >= 0; i--) {
            WidgetRun run = this.widgets.get(i);
            if (run.widget.getVisibility() != 8) {
                return run.widget;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void apply() {
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().apply();
        }
        int count = this.widgets.size();
        if (count >= 1) {
            ConstraintWidget firstWidget = this.widgets.get(0).widget;
            ConstraintWidget lastWidget = this.widgets.get(count - 1).widget;
            if (this.orientation == 0) {
                ConstraintAnchor startAnchor = firstWidget.mLeft;
                ConstraintAnchor endAnchor = lastWidget.mRight;
                DependencyNode startTarget = getTarget(startAnchor, 0);
                int startMargin = startAnchor.getMargin();
                ConstraintWidget firstVisibleWidget = getFirstVisibleWidget();
                if (firstVisibleWidget != null) {
                    startMargin = firstVisibleWidget.mLeft.getMargin();
                }
                if (startTarget != null) {
                    addTarget(this.start, startTarget, startMargin);
                }
                DependencyNode endTarget = getTarget(endAnchor, 0);
                int endMargin = endAnchor.getMargin();
                ConstraintWidget lastVisibleWidget = getLastVisibleWidget();
                if (lastVisibleWidget != null) {
                    endMargin = lastVisibleWidget.mRight.getMargin();
                }
                if (endTarget != null) {
                    addTarget(this.end, endTarget, -endMargin);
                }
            } else {
                ConstraintAnchor startAnchor2 = firstWidget.mTop;
                ConstraintAnchor endAnchor2 = lastWidget.mBottom;
                DependencyNode startTarget2 = getTarget(startAnchor2, 1);
                int startMargin2 = startAnchor2.getMargin();
                ConstraintWidget firstVisibleWidget2 = getFirstVisibleWidget();
                if (firstVisibleWidget2 != null) {
                    startMargin2 = firstVisibleWidget2.mTop.getMargin();
                }
                if (startTarget2 != null) {
                    addTarget(this.start, startTarget2, startMargin2);
                }
                DependencyNode endTarget2 = getTarget(endAnchor2, 1);
                int endMargin2 = endAnchor2.getMargin();
                ConstraintWidget lastVisibleWidget2 = getLastVisibleWidget();
                if (lastVisibleWidget2 != null) {
                    endMargin2 = lastVisibleWidget2.mBottom.getMargin();
                }
                if (endTarget2 != null) {
                    addTarget(this.end, endTarget2, -endMargin2);
                }
            }
            this.start.updateDelegate = this;
            this.end.updateDelegate = this;
        }
    }
}
