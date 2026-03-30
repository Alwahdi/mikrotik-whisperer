package defpackage;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: oy0  reason: default package */
public final class oy0 extends Fragment implements dx {
    private static WeakHashMap<Activity, WeakReference<oy0>> a = new WeakHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public int f4612a = 0;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public Bundle f4613a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, LifecycleCallback> f4614a = new ArrayMap();

    public static oy0 b(Activity activity) {
        oy0 oy0;
        WeakReference weakReference = a.get(activity);
        if (weakReference != null && (oy0 = (oy0) weakReference.get()) != null) {
            return oy0;
        }
        try {
            oy0 oy02 = (oy0) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (oy02 == null || oy02.isRemoving()) {
                oy02 = new oy0();
                activity.getFragmentManager().beginTransaction().add(oy02, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            a.put(activity, new WeakReference(oy02));
            return oy02;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e);
        }
    }

    public final <T extends LifecycleCallback> T h(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.f4614a.get(str));
    }

    public final void e(String str, LifecycleCallback lifecycleCallback) {
        if (!this.f4614a.containsKey(str)) {
            this.f4614a.put(str, lifecycleCallback);
            if (this.f4612a > 0) {
                new b51(Looper.getMainLooper()).post(new b11(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
        sb.append("LifecycleCallback with tag ");
        sb.append(str);
        sb.append(" already added to this fragment.");
        throw new IllegalArgumentException(sb.toString());
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4612a = 1;
        this.f4613a = bundle;
        for (Map.Entry next : this.f4614a.entrySet()) {
            ((LifecycleCallback) next.getValue()).e(bundle != null ? bundle.getBundle((String) next.getKey()) : null);
        }
    }

    public final void onStart() {
        super.onStart();
        this.f4612a = 2;
        for (LifecycleCallback i : this.f4614a.values()) {
            i.i();
        }
    }

    public final void onResume() {
        super.onResume();
        this.f4612a = 3;
        for (LifecycleCallback g : this.f4614a.values()) {
            g.g();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (LifecycleCallback d : this.f4614a.values()) {
            d.d(i, i2, intent);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry next : this.f4614a.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) next.getValue()).h(bundle2);
                bundle.putBundle((String) next.getKey(), bundle2);
            }
        }
    }

    public final void onStop() {
        super.onStop();
        this.f4612a = 4;
        for (LifecycleCallback j : this.f4614a.values()) {
            j.j();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f4612a = 5;
        for (LifecycleCallback f : this.f4614a.values()) {
            f.f();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback a2 : this.f4614a.values()) {
            a2.a(str, fileDescriptor, printWriter, strArr);
        }
    }
}
