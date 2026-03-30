package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: x21  reason: default package */
public final class x21 extends Fragment implements dx {
    private static WeakHashMap<FragmentActivity, WeakReference<x21>> a = new WeakHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public int f5564a = 0;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public Bundle f5565a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, LifecycleCallback> f5566a = new ArrayMap();

    public static x21 j(FragmentActivity fragmentActivity) {
        x21 x21;
        WeakReference weakReference = a.get(fragmentActivity);
        if (weakReference != null && (x21 = (x21) weakReference.get()) != null) {
            return x21;
        }
        try {
            x21 x212 = (x21) fragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
            if (x212 == null || x212.isRemoving()) {
                x212 = new x21();
                fragmentActivity.getSupportFragmentManager().beginTransaction().add((Fragment) x212, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
            }
            a.put(fragmentActivity, new WeakReference(x212));
            return x212;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
        }
    }

    public final <T extends LifecycleCallback> T h(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.f5566a.get(str));
    }

    public final void e(String str, LifecycleCallback lifecycleCallback) {
        if (!this.f5566a.containsKey(str)) {
            this.f5566a.put(str, lifecycleCallback);
            if (this.f5564a > 0) {
                new b51(Looper.getMainLooper()).post(new h41(this, lifecycleCallback, str));
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
        this.f5564a = 1;
        this.f5565a = bundle;
        for (Map.Entry next : this.f5566a.entrySet()) {
            ((LifecycleCallback) next.getValue()).e(bundle != null ? bundle.getBundle((String) next.getKey()) : null);
        }
    }

    public final void onStart() {
        super.onStart();
        this.f5564a = 2;
        for (LifecycleCallback i : this.f5566a.values()) {
            i.i();
        }
    }

    public final void onResume() {
        super.onResume();
        this.f5564a = 3;
        for (LifecycleCallback g : this.f5566a.values()) {
            g.g();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (LifecycleCallback d : this.f5566a.values()) {
            d.d(i, i2, intent);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry next : this.f5566a.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) next.getValue()).h(bundle2);
                bundle.putBundle((String) next.getKey(), bundle2);
            }
        }
    }

    public final void onStop() {
        super.onStop();
        this.f5564a = 4;
        for (LifecycleCallback j : this.f5566a.values()) {
            j.j();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f5564a = 5;
        for (LifecycleCallback f : this.f5566a.values()) {
            f.f();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback a2 : this.f5566a.values()) {
            a2.a(str, fileDescriptor, printWriter, strArr);
        }
    }
}
