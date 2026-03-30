package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public final class InitializerViewModelFactoryKt {
    public static final ViewModelProvider.Factory viewModelFactory(vn<? super InitializerViewModelFactoryBuilder, jt0> builder) {
        lu.f(builder, "builder");
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        builder.invoke(initializerViewModelFactoryBuilder);
        return initializerViewModelFactoryBuilder.build();
    }

    public static final /* synthetic */ <VM extends ViewModel> void initializer(InitializerViewModelFactoryBuilder $this$initializer, vn<? super CreationExtras, ? extends VM> initializer) {
        lu.f($this$initializer, "<this>");
        lu.f(initializer, "initializer");
        lu.j(4, "VM");
        $this$initializer.addInitializer(xd0.b(ViewModel.class), initializer);
    }
}
