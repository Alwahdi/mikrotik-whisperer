package androidx.lifecycle;

import android.app.Application;

public class AndroidViewModel extends ViewModel {
    private final Application application;

    public AndroidViewModel(Application application2) {
        lu.f(application2, "application");
        this.application = application2;
    }

    public <T extends Application> T getApplication() {
        T t = this.application;
        lu.d(t, "null cannot be cast to non-null type T of androidx.lifecycle.AndroidViewModel.getApplication");
        return t;
    }
}
