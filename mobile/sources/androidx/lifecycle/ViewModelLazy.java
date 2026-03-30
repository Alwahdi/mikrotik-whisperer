package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;

public final class ViewModelLazy<VM extends ViewModel> implements rw<VM> {
    private VM cached;
    private final tn<CreationExtras> extrasProducer;
    private final tn<ViewModelProvider.Factory> factoryProducer;
    private final tn<ViewModelStore> storeProducer;
    private final aw<VM> viewModelClass;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ViewModelLazy(aw<VM> awVar, tn<? extends ViewModelStore> tnVar, tn<? extends ViewModelProvider.Factory> tnVar2) {
        this(awVar, tnVar, tnVar2, (tn) null, 8, (Cif) null);
        lu.f(awVar, "viewModelClass");
        lu.f(tnVar, "storeProducer");
        lu.f(tnVar2, "factoryProducer");
    }

    public ViewModelLazy(aw<VM> viewModelClass2, tn<? extends ViewModelStore> storeProducer2, tn<? extends ViewModelProvider.Factory> factoryProducer2, tn<? extends CreationExtras> extrasProducer2) {
        lu.f(viewModelClass2, "viewModelClass");
        lu.f(storeProducer2, "storeProducer");
        lu.f(factoryProducer2, "factoryProducer");
        lu.f(extrasProducer2, "extrasProducer");
        this.viewModelClass = viewModelClass2;
        this.storeProducer = storeProducer2;
        this.factoryProducer = factoryProducer2;
        this.extrasProducer = extrasProducer2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ViewModelLazy(aw awVar, tn tnVar, tn tnVar2, tn tnVar3, int i, Cif ifVar) {
        this(awVar, tnVar, tnVar2, (i & 8) != 0 ? AnonymousClass1.INSTANCE : tnVar3);
    }

    public VM getValue() {
        ViewModel viewModel = this.cached;
        if (viewModel != null) {
            return viewModel;
        }
        ViewModel it = new ViewModelProvider(this.storeProducer.invoke(), this.factoryProducer.invoke(), this.extrasProducer.invoke()).get(xv.a(this.viewModelClass));
        this.cached = it;
        return it;
    }

    public boolean isInitialized() {
        return this.cached != null;
    }
}
