package androidx.lifecycle.viewmodel;

import androidx.lifecycle.viewmodel.CreationExtras;

public final class MutableCreationExtras extends CreationExtras {
    public MutableCreationExtras() {
        this((CreationExtras) null, 1, (Cif) null);
    }

    public MutableCreationExtras(CreationExtras initialExtras) {
        lu.f(initialExtras, "initialExtras");
        getMap$lifecycle_viewmodel_release().putAll(initialExtras.getMap$lifecycle_viewmodel_release());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutableCreationExtras(CreationExtras creationExtras, int i, Cif ifVar) {
        this((i & 1) != 0 ? CreationExtras.Empty.INSTANCE : creationExtras);
    }

    public final <T> void set(CreationExtras.Key<T> key, T t) {
        lu.f(key, "key");
        getMap$lifecycle_viewmodel_release().put(key, t);
    }

    public <T> T get(CreationExtras.Key<T> key) {
        lu.f(key, "key");
        return getMap$lifecycle_viewmodel_release().get(key);
    }
}
