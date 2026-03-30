package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ViewModelStore {
    private final Map<String, ViewModel> map = new LinkedHashMap();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void put(String key, ViewModel viewModel) {
        lu.f(key, "key");
        lu.f(viewModel, "viewModel");
        ViewModel oldViewModel = this.map.put(key, viewModel);
        if (oldViewModel != null) {
            oldViewModel.onCleared();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final ViewModel get(String key) {
        lu.f(key, "key");
        return this.map.get(key);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Set<String> keys() {
        return new HashSet(this.map.keySet());
    }

    public final void clear() {
        for (ViewModel vm : this.map.values()) {
            vm.clear();
        }
        this.map.clear();
    }
}
