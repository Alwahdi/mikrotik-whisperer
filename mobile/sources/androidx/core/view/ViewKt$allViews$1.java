package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

@bf(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", l = {414, 416}, m = "invokeSuspend")
final class ViewKt$allViews$1 extends re0 implements jo<ek0<? super View>, rc<? super jt0>, Object> {
    final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ViewKt$allViews$1(View view, rc<? super ViewKt$allViews$1> rcVar) {
        super(2, rcVar);
        this.$this_allViews = view;
    }

    public final rc<jt0> create(Object obj, rc<?> rcVar) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.$this_allViews, rcVar);
        viewKt$allViews$1.L$0 = obj;
        return viewKt$allViews$1;
    }

    public final Object invoke(ek0<? super View> ek0, rc<? super jt0> rcVar) {
        return ((ViewKt$allViews$1) create(ek0, rcVar)).invokeSuspend(jt0.a);
    }

    public final Object invokeSuspend(Object $result) {
        ViewKt$allViews$1 viewKt$allViews$1;
        ek0 $this$sequence;
        ViewKt$allViews$1 viewKt$allViews$12;
        Object d = ou.d();
        switch (this.label) {
            case 0:
                te0.b($result);
                viewKt$allViews$12 = this;
                $this$sequence = (ek0) viewKt$allViews$12.L$0;
                View view = viewKt$allViews$12.$this_allViews;
                viewKt$allViews$12.L$0 = $this$sequence;
                viewKt$allViews$12.label = 1;
                if ($this$sequence.a(view, viewKt$allViews$12) == d) {
                    return d;
                }
                break;
            case 1:
                viewKt$allViews$12 = this;
                $this$sequence = (ek0) viewKt$allViews$12.L$0;
                te0.b($result);
                break;
            case 2:
                viewKt$allViews$1 = this;
                te0.b($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        View view2 = viewKt$allViews$12.$this_allViews;
        if (view2 instanceof ViewGroup) {
            ck0<View> descendants = ViewGroupKt.getDescendants((ViewGroup) view2);
            viewKt$allViews$12.L$0 = null;
            viewKt$allViews$12.label = 2;
            if ($this$sequence.c(descendants, viewKt$allViews$12) == d) {
                return d;
            }
            viewKt$allViews$1 = viewKt$allViews$12;
            ViewKt$allViews$1 viewKt$allViews$13 = viewKt$allViews$1;
        }
        return jt0.a;
    }
}
