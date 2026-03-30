package defpackage;

import com.google.firebase.inject.Provider;
import java.util.Set;

/* renamed from: i  reason: default package */
abstract class i implements hb {
    i() {
    }

    public <T> T d(Class<T> anInterface) {
        Provider<T> provider = b(anInterface);
        if (provider == null) {
            return null;
        }
        return provider.get();
    }

    public <T> Set<T> a(Class<T> anInterface) {
        return c(anInterface).get();
    }
}
