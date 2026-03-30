package androidx.constraintlayout.solver.widgets.analyzer;

class BaselineDimensionDependency extends DimensionDependency {
    public BaselineDimensionDependency(WidgetRun run) {
        super(run);
    }

    public void update(DependencyNode node) {
        WidgetRun widgetRun = this.run;
        ((VerticalWidgetRun) widgetRun).baseline.margin = widgetRun.widget.getBaselineDistance();
        this.resolved = true;
    }
}
