package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class SavedStateHandle {
    /* access modifiers changed from: private */
    public static final Class<? extends Object>[] ACCEPTABLE_CLASSES;
    public static final Companion Companion = new Companion((Cif) null);
    private static final String KEYS = "keys";
    private static final String VALUES = "values";
    /* access modifiers changed from: private */
    public final Map<String, t20<Object>> flows;
    private final Map<String, SavingStateLiveData<?>> liveDatas;
    /* access modifiers changed from: private */
    public final Map<String, Object> regular;
    private final SavedStateRegistry.SavedStateProvider savedStateProvider;
    private final Map<String, SavedStateRegistry.SavedStateProvider> savedStateProviders;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final SavedStateHandle createHandle(Bundle bundle, Bundle bundle2) {
        return Companion.createHandle(bundle, bundle2);
    }

    /* access modifiers changed from: private */
    public static final Bundle savedStateProvider$lambda$0(SavedStateHandle this$0) {
        lu.f(this$0, "this$0");
        for (Map.Entry entry : a00.i(this$0.savedStateProviders).entrySet()) {
            this$0.set((String) entry.getKey(), ((SavedStateRegistry.SavedStateProvider) entry.getValue()).saveState());
        }
        Set keySet = this$0.regular.keySet();
        ArrayList keys = new ArrayList(keySet.size());
        ArrayList value = new ArrayList(keys.size());
        for (String key : keySet) {
            keys.add(key);
            value.add(this$0.regular.get(key));
        }
        return BundleKt.bundleOf(ws0.a(KEYS, keys), ws0.a(VALUES, value));
    }

    public SavedStateHandle(Map<String, ? extends Object> initialState) {
        lu.f(initialState, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.regular = linkedHashMap;
        this.savedStateProviders = new LinkedHashMap();
        this.liveDatas = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.savedStateProvider = new ui0(this);
        linkedHashMap.putAll(initialState);
    }

    public SavedStateHandle() {
        this.regular = new LinkedHashMap();
        this.savedStateProviders = new LinkedHashMap();
        this.liveDatas = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.savedStateProvider = new ui0(this);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final SavedStateRegistry.SavedStateProvider savedStateProvider() {
        return this.savedStateProvider;
    }

    @MainThread
    public final boolean contains(String key) {
        lu.f(key, "key");
        return this.regular.containsKey(key);
    }

    @MainThread
    public final <T> MutableLiveData<T> getLiveData(String key) {
        lu.f(key, "key");
        MutableLiveData<T> liveDataInternal = getLiveDataInternal(key, false, (Object) null);
        lu.d(liveDataInternal, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<T of androidx.lifecycle.SavedStateHandle.getLiveData>");
        return liveDataInternal;
    }

    @MainThread
    public final <T> MutableLiveData<T> getLiveData(String key, T initialValue) {
        lu.f(key, "key");
        return getLiveDataInternal(key, true, initialValue);
    }

    private final <T> MutableLiveData<T> getLiveDataInternal(String key, boolean hasInitialValue, T initialValue) {
        SavingStateLiveData mutableLd;
        MutableLiveData mutableLiveData = this.liveDatas.get(key);
        MutableLiveData liveData = mutableLiveData instanceof MutableLiveData ? mutableLiveData : null;
        if (liveData != null) {
            return liveData;
        }
        if (this.regular.containsKey(key)) {
            mutableLd = new SavingStateLiveData(this, key, this.regular.get(key));
        } else if (hasInitialValue) {
            this.regular.put(key, initialValue);
            mutableLd = new SavingStateLiveData(this, key, initialValue);
        } else {
            mutableLd = new SavingStateLiveData(this, key);
        }
        this.liveDatas.put(key, mutableLd);
        return mutableLd;
    }

    @MainThread
    public final <T> vm0<T> getStateFlow(String key, T initialValue) {
        Object answer$iv;
        lu.f(key, "key");
        Map $this$getOrPut$iv = this.flows;
        Object value$iv = $this$getOrPut$iv.get(key);
        if (value$iv == null) {
            if (!this.regular.containsKey(key)) {
                this.regular.put(key, initialValue);
            }
            Object $this$getStateFlow_u24lambda_u242_u24lambda_u241 = xm0.a(this.regular.get(key));
            this.flows.put(key, $this$getStateFlow_u24lambda_u242_u24lambda_u241);
            answer$iv = $this$getStateFlow_u24lambda_u242_u24lambda_u241;
            $this$getOrPut$iv.put(key, answer$iv);
        } else {
            answer$iv = value$iv;
        }
        vm0<T> a = im.a((t20) answer$iv);
        lu.d(a, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<T of androidx.lifecycle.SavedStateHandle.getStateFlow>");
        return a;
    }

    @MainThread
    public final Set<String> keys() {
        return cl0.e(cl0.e(this.regular.keySet(), this.savedStateProviders.keySet()), this.liveDatas.keySet());
    }

    @MainThread
    public final <T> T get(String key) {
        lu.f(key, "key");
        try {
            return this.regular.get(key);
        } catch (ClassCastException e) {
            remove(key);
            return null;
        }
    }

    @MainThread
    public final <T> void set(String key, T value) {
        lu.f(key, "key");
        if (Companion.validateValue(value)) {
            SavingStateLiveData<?> savingStateLiveData = this.liveDatas.get(key);
            MutableLiveData mutableLiveData = savingStateLiveData instanceof MutableLiveData ? savingStateLiveData : null;
            if (mutableLiveData != null) {
                mutableLiveData.setValue(value);
            } else {
                this.regular.put(key, value);
            }
            t20 t20 = this.flows.get(key);
            if (t20 != null) {
                t20.a(value);
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't put value with type ");
        lu.c(value);
        sb.append(value.getClass());
        sb.append(" into saved state");
        throw new IllegalArgumentException(sb.toString());
    }

    @MainThread
    public final <T> T remove(String key) {
        lu.f(key, "key");
        Object latestValue = this.regular.remove(key);
        SavingStateLiveData liveData = this.liveDatas.remove(key);
        if (liveData != null) {
            liveData.detach();
        }
        this.flows.remove(key);
        return latestValue;
    }

    @MainThread
    public final void setSavedStateProvider(String key, SavedStateRegistry.SavedStateProvider provider) {
        lu.f(key, "key");
        lu.f(provider, "provider");
        this.savedStateProviders.put(key, provider);
    }

    @MainThread
    public final void clearSavedStateProvider(String key) {
        lu.f(key, "key");
        this.savedStateProviders.remove(key);
    }

    public static final class SavingStateLiveData<T> extends MutableLiveData<T> {
        private SavedStateHandle handle;
        private String key;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavingStateLiveData(SavedStateHandle handle2, String key2, T value) {
            super(value);
            lu.f(key2, "key");
            this.key = key2;
            this.handle = handle2;
        }

        public SavingStateLiveData(SavedStateHandle handle2, String key2) {
            lu.f(key2, "key");
            this.key = key2;
            this.handle = handle2;
        }

        public void setValue(T value) {
            SavedStateHandle it = this.handle;
            if (it != null) {
                it.regular.put(this.key, value);
                t20 t20 = (t20) it.flows.get(this.key);
                if (t20 != null) {
                    t20.a(value);
                }
            }
            super.setValue(value);
        }

        public final void detach() {
            this.handle = null;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(Cif ifVar) {
            this();
        }

        private Companion() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final SavedStateHandle createHandle(Bundle restoredState, Bundle defaultState) {
            if (restoredState != null) {
                ArrayList keys = restoredState.getParcelableArrayList(SavedStateHandle.KEYS);
                ArrayList values = restoredState.getParcelableArrayList(SavedStateHandle.VALUES);
                if ((keys == null || values == null || keys.size() != values.size()) ? false : true) {
                    Map state = new LinkedHashMap();
                    int size = keys.size();
                    for (int i = 0; i < size; i++) {
                        Object obj = keys.get(i);
                        lu.d(obj, "null cannot be cast to non-null type kotlin.String");
                        state.put((String) obj, values.get(i));
                    }
                    return new SavedStateHandle(state);
                }
                throw new IllegalStateException("Invalid bundle passed as restored state".toString());
            } else if (defaultState == null) {
                return new SavedStateHandle();
            } else {
                Map state2 = new HashMap();
                for (String key : defaultState.keySet()) {
                    lu.e(key, "key");
                    state2.put(key, defaultState.get(key));
                }
                return new SavedStateHandle(state2);
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final boolean validateValue(Object value) {
            if (value == null) {
                return true;
            }
            for (Class cl : SavedStateHandle.ACCEPTABLE_CLASSES) {
                lu.c(cl);
                if (cl.isInstance(value)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.Class<? extends java.lang.Object>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            androidx.lifecycle.SavedStateHandle$Companion r0 = new androidx.lifecycle.SavedStateHandle$Companion
            r1 = 0
            r0.<init>(r1)
            Companion = r0
            r0 = 29
            java.lang.Class[] r0 = new java.lang.Class[r0]
            java.lang.Class r1 = java.lang.Boolean.TYPE
            r2 = 0
            r0[r2] = r1
            r1 = 1
            java.lang.Class<boolean[]> r2 = boolean[].class
            r0[r1] = r2
            java.lang.Class r1 = java.lang.Double.TYPE
            r2 = 2
            r0[r2] = r1
            r1 = 3
            java.lang.Class<double[]> r2 = double[].class
            r0[r1] = r2
            java.lang.Class r1 = java.lang.Integer.TYPE
            r2 = 4
            r0[r2] = r1
            r2 = 5
            java.lang.Class<int[]> r3 = int[].class
            r0[r2] = r3
            java.lang.Class r2 = java.lang.Long.TYPE
            r3 = 6
            r0[r3] = r2
            r2 = 7
            java.lang.Class<long[]> r3 = long[].class
            r0[r2] = r3
            r2 = 8
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r0[r2] = r3
            r2 = 9
            java.lang.Class<java.lang.String[]> r3 = java.lang.String[].class
            r0[r2] = r3
            r2 = 10
            java.lang.Class<android.os.Binder> r3 = android.os.Binder.class
            r0[r2] = r3
            r2 = 11
            java.lang.Class<android.os.Bundle> r3 = android.os.Bundle.class
            r0[r2] = r3
            java.lang.Class r2 = java.lang.Byte.TYPE
            r3 = 12
            r0[r3] = r2
            r2 = 13
            java.lang.Class<byte[]> r3 = byte[].class
            r0[r2] = r3
            java.lang.Class r2 = java.lang.Character.TYPE
            r3 = 14
            r0[r3] = r2
            r2 = 15
            java.lang.Class<char[]> r3 = char[].class
            r0[r2] = r3
            r2 = 16
            java.lang.Class<java.lang.CharSequence> r3 = java.lang.CharSequence.class
            r0[r2] = r3
            r2 = 17
            java.lang.Class<java.lang.CharSequence[]> r3 = java.lang.CharSequence[].class
            r0[r2] = r3
            r2 = 18
            java.lang.Class<java.util.ArrayList> r3 = java.util.ArrayList.class
            r0[r2] = r3
            java.lang.Class r2 = java.lang.Float.TYPE
            r3 = 19
            r0[r3] = r2
            r2 = 20
            java.lang.Class<float[]> r3 = float[].class
            r0[r2] = r3
            java.lang.Class<android.os.Parcelable> r2 = android.os.Parcelable.class
            r3 = 21
            r0[r3] = r2
            r2 = 22
            java.lang.Class<android.os.Parcelable[]> r4 = android.os.Parcelable[].class
            r0[r2] = r4
            r2 = 23
            java.lang.Class<java.io.Serializable> r4 = java.io.Serializable.class
            r0[r2] = r4
            java.lang.Class r2 = java.lang.Short.TYPE
            r4 = 24
            r0[r4] = r2
            r2 = 25
            java.lang.Class<short[]> r4 = short[].class
            r0[r2] = r4
            r2 = 26
            java.lang.Class<android.util.SparseArray> r4 = android.util.SparseArray.class
            r0[r2] = r4
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r3) goto L_0x00ae
            java.lang.Class<android.util.Size> r4 = android.util.Size.class
            goto L_0x00af
        L_0x00ae:
            r4 = r1
        L_0x00af:
            r5 = 27
            r0[r5] = r4
            r4 = 28
            if (r2 < r3) goto L_0x00b9
            java.lang.Class<android.util.SizeF> r1 = android.util.SizeF.class
        L_0x00b9:
            r0[r4] = r1
            ACCEPTABLE_CLASSES = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.SavedStateHandle.<clinit>():void");
    }
}
