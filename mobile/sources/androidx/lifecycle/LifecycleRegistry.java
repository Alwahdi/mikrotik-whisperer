package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class LifecycleRegistry extends Lifecycle {
    public static final Companion Companion = new Companion((Cif) null);
    private int addingObserverCounter;
    private final boolean enforceMainThread;
    private boolean handlingEvent;
    private final WeakReference<LifecycleOwner> lifecycleOwner;
    private boolean newEventOccurred;
    private FastSafeIterableMap<LifecycleObserver, ObserverWithState> observerMap;
    private ArrayList<Lifecycle.State> parentStates;
    private Lifecycle.State state;

    public /* synthetic */ LifecycleRegistry(LifecycleOwner lifecycleOwner2, boolean z, Cif ifVar) {
        this(lifecycleOwner2, z);
    }

    @VisibleForTesting
    public static final LifecycleRegistry createUnsafe(LifecycleOwner lifecycleOwner2) {
        return Companion.createUnsafe(lifecycleOwner2);
    }

    public static final Lifecycle.State min$lifecycle_runtime_release(Lifecycle.State state2, Lifecycle.State state3) {
        return Companion.min$lifecycle_runtime_release(state2, state3);
    }

    private LifecycleRegistry(LifecycleOwner provider, boolean enforceMainThread2) {
        this.enforceMainThread = enforceMainThread2;
        this.observerMap = new FastSafeIterableMap<>();
        this.state = Lifecycle.State.INITIALIZED;
        this.parentStates = new ArrayList<>();
        this.lifecycleOwner = new WeakReference<>(provider);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LifecycleRegistry(LifecycleOwner provider) {
        this(provider, true);
        lu.f(provider, "provider");
    }

    @MainThread
    public void markState(Lifecycle.State state2) {
        lu.f(state2, "state");
        enforceMainThreadIfNeeded("markState");
        setCurrentState(state2);
    }

    public Lifecycle.State getCurrentState() {
        return this.state;
    }

    public void setCurrentState(Lifecycle.State state2) {
        lu.f(state2, "state");
        enforceMainThreadIfNeeded("setCurrentState");
        moveToState(state2);
    }

    public void handleLifecycleEvent(Lifecycle.Event event) {
        lu.f(event, NotificationCompat.CATEGORY_EVENT);
        enforceMainThreadIfNeeded("handleLifecycleEvent");
        moveToState(event.getTargetState());
    }

    private final void moveToState(Lifecycle.State next) {
        Lifecycle.State state2 = this.state;
        if (state2 != next) {
            if ((state2 == Lifecycle.State.INITIALIZED && next == Lifecycle.State.DESTROYED) ? false : true) {
                this.state = next;
                if (this.handlingEvent || this.addingObserverCounter != 0) {
                    this.newEventOccurred = true;
                    return;
                }
                this.handlingEvent = true;
                sync();
                this.handlingEvent = false;
                if (this.state == Lifecycle.State.DESTROYED) {
                    this.observerMap = new FastSafeIterableMap<>();
                    return;
                }
                return;
            }
            throw new IllegalStateException(("no event down from " + this.state + " in component " + this.lifecycleOwner.get()).toString());
        }
    }

    private final boolean isSynced() {
        if (this.observerMap.size() == 0) {
            return true;
        }
        Map.Entry<LifecycleObserver, ObserverWithState> eldest = this.observerMap.eldest();
        lu.c(eldest);
        Lifecycle.State eldestObserverState = eldest.getValue().getState();
        Map.Entry<LifecycleObserver, ObserverWithState> newest = this.observerMap.newest();
        lu.c(newest);
        Lifecycle.State newestObserverState = newest.getValue().getState();
        if (eldestObserverState == newestObserverState && this.state == newestObserverState) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r2 = r0.getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.lifecycle.Lifecycle.State calculateTargetState(androidx.lifecycle.LifecycleObserver r6) {
        /*
            r5 = this;
            androidx.arch.core.internal.FastSafeIterableMap<androidx.lifecycle.LifecycleObserver, androidx.lifecycle.LifecycleRegistry$ObserverWithState> r0 = r5.observerMap
            java.util.Map$Entry r0 = r0.ceil(r6)
            r1 = 0
            if (r0 == 0) goto L_0x0016
            java.lang.Object r2 = r0.getValue()
            androidx.lifecycle.LifecycleRegistry$ObserverWithState r2 = (androidx.lifecycle.LifecycleRegistry.ObserverWithState) r2
            if (r2 == 0) goto L_0x0016
            androidx.lifecycle.Lifecycle$State r2 = r2.getState()
            goto L_0x0017
        L_0x0016:
            r2 = r1
        L_0x0017:
            java.util.ArrayList<androidx.lifecycle.Lifecycle$State> r3 = r5.parentStates
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ 1
            if (r3 == 0) goto L_0x002f
            java.util.ArrayList<androidx.lifecycle.Lifecycle$State> r1 = r5.parentStates
            int r3 = r1.size()
            int r3 = r3 + -1
            java.lang.Object r1 = r1.get(r3)
            androidx.lifecycle.Lifecycle$State r1 = (androidx.lifecycle.Lifecycle.State) r1
        L_0x002f:
            androidx.lifecycle.LifecycleRegistry$Companion r3 = Companion
            androidx.lifecycle.Lifecycle$State r4 = r5.state
            androidx.lifecycle.Lifecycle$State r4 = r3.min$lifecycle_runtime_release(r4, r2)
            androidx.lifecycle.Lifecycle$State r3 = r3.min$lifecycle_runtime_release(r4, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.LifecycleRegistry.calculateTargetState(androidx.lifecycle.LifecycleObserver):androidx.lifecycle.Lifecycle$State");
    }

    public void addObserver(LifecycleObserver observer) {
        LifecycleOwner lifecycleOwner2;
        lu.f(observer, "observer");
        enforceMainThreadIfNeeded("addObserver");
        Lifecycle.State state2 = this.state;
        Lifecycle.State initialState = Lifecycle.State.DESTROYED;
        if (state2 != initialState) {
            initialState = Lifecycle.State.INITIALIZED;
        }
        ObserverWithState statefulObserver = new ObserverWithState(observer, initialState);
        if (this.observerMap.putIfAbsent(observer, statefulObserver) == null && (lifecycleOwner2 = (LifecycleOwner) this.lifecycleOwner.get()) != null) {
            boolean isReentrance = this.addingObserverCounter != 0 || this.handlingEvent;
            Lifecycle.State targetState = calculateTargetState(observer);
            this.addingObserverCounter++;
            while (statefulObserver.getState().compareTo(targetState) < 0 && this.observerMap.contains(observer)) {
                pushParentState(statefulObserver.getState());
                Lifecycle.Event event = Lifecycle.Event.Companion.upFrom(statefulObserver.getState());
                if (event != null) {
                    statefulObserver.dispatchEvent(lifecycleOwner2, event);
                    popParentState();
                    targetState = calculateTargetState(observer);
                } else {
                    throw new IllegalStateException("no event up from " + statefulObserver.getState());
                }
            }
            if (!isReentrance) {
                sync();
            }
            this.addingObserverCounter--;
        }
    }

    private final void popParentState() {
        ArrayList<Lifecycle.State> arrayList = this.parentStates;
        arrayList.remove(arrayList.size() - 1);
    }

    private final void pushParentState(Lifecycle.State state2) {
        this.parentStates.add(state2);
    }

    public void removeObserver(LifecycleObserver observer) {
        lu.f(observer, "observer");
        enforceMainThreadIfNeeded("removeObserver");
        this.observerMap.remove(observer);
    }

    public int getObserverCount() {
        enforceMainThreadIfNeeded("getObserverCount");
        return this.observerMap.size();
    }

    private final void forwardPass(LifecycleOwner lifecycleOwner2) {
        Iterator ascendingIterator = this.observerMap.iteratorWithAdditions();
        lu.e(ascendingIterator, "observerMap.iteratorWithAdditions()");
        while (ascendingIterator.hasNext() && !this.newEventOccurred) {
            Map.Entry entry = (Map.Entry) ascendingIterator.next();
            LifecycleObserver key = (LifecycleObserver) entry.getKey();
            ObserverWithState observer = (ObserverWithState) entry.getValue();
            while (observer.getState().compareTo(this.state) < 0 && !this.newEventOccurred && this.observerMap.contains(key)) {
                pushParentState(observer.getState());
                Lifecycle.Event event = Lifecycle.Event.Companion.upFrom(observer.getState());
                if (event != null) {
                    observer.dispatchEvent(lifecycleOwner2, event);
                    popParentState();
                } else {
                    throw new IllegalStateException("no event up from " + observer.getState());
                }
            }
        }
    }

    private final void backwardPass(LifecycleOwner lifecycleOwner2) {
        Iterator descendingIterator = this.observerMap.descendingIterator();
        lu.e(descendingIterator, "observerMap.descendingIterator()");
        while (descendingIterator.hasNext() && !this.newEventOccurred) {
            Map.Entry next = descendingIterator.next();
            lu.e(next, "next()");
            LifecycleObserver key = (LifecycleObserver) next.getKey();
            ObserverWithState observer = (ObserverWithState) next.getValue();
            while (observer.getState().compareTo(this.state) > 0 && !this.newEventOccurred && this.observerMap.contains(key)) {
                Lifecycle.Event event = Lifecycle.Event.Companion.downFrom(observer.getState());
                if (event != null) {
                    pushParentState(event.getTargetState());
                    observer.dispatchEvent(lifecycleOwner2, event);
                    popParentState();
                } else {
                    throw new IllegalStateException("no event down from " + observer.getState());
                }
            }
        }
    }

    private final void sync() {
        LifecycleOwner lifecycleOwner2 = (LifecycleOwner) this.lifecycleOwner.get();
        if (lifecycleOwner2 != null) {
            while (!isSynced()) {
                this.newEventOccurred = false;
                Lifecycle.State state2 = this.state;
                Map.Entry<LifecycleObserver, ObserverWithState> eldest = this.observerMap.eldest();
                lu.c(eldest);
                if (state2.compareTo(eldest.getValue().getState()) < 0) {
                    backwardPass(lifecycleOwner2);
                }
                Map.Entry newest = this.observerMap.newest();
                if (!this.newEventOccurred && newest != null && this.state.compareTo(newest.getValue().getState()) > 0) {
                    forwardPass(lifecycleOwner2);
                }
            }
            this.newEventOccurred = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
    }

    private final void enforceMainThreadIfNeeded(String methodName) {
        if (this.enforceMainThread && !ArchTaskExecutor.getInstance().isMainThread()) {
            throw new IllegalStateException(("Method " + methodName + " must be called on the main thread").toString());
        }
    }

    public static final class ObserverWithState {
        private LifecycleEventObserver lifecycleObserver;
        private Lifecycle.State state;

        public ObserverWithState(LifecycleObserver observer, Lifecycle.State initialState) {
            lu.f(initialState, "initialState");
            lu.c(observer);
            this.lifecycleObserver = Lifecycling.lifecycleEventObserver(observer);
            this.state = initialState;
        }

        public final Lifecycle.State getState() {
            return this.state;
        }

        public final void setState(Lifecycle.State state2) {
            lu.f(state2, "<set-?>");
            this.state = state2;
        }

        public final LifecycleEventObserver getLifecycleObserver() {
            return this.lifecycleObserver;
        }

        public final void setLifecycleObserver(LifecycleEventObserver lifecycleEventObserver) {
            lu.f(lifecycleEventObserver, "<set-?>");
            this.lifecycleObserver = lifecycleEventObserver;
        }

        public final void dispatchEvent(LifecycleOwner owner, Lifecycle.Event event) {
            lu.f(event, NotificationCompat.CATEGORY_EVENT);
            Lifecycle.State newState = event.getTargetState();
            this.state = LifecycleRegistry.Companion.min$lifecycle_runtime_release(this.state, newState);
            LifecycleEventObserver lifecycleEventObserver = this.lifecycleObserver;
            lu.c(owner);
            lifecycleEventObserver.onStateChanged(owner, event);
            this.state = newState;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(Cif ifVar) {
            this();
        }

        private Companion() {
        }

        @VisibleForTesting
        public final LifecycleRegistry createUnsafe(LifecycleOwner owner) {
            lu.f(owner, "owner");
            return new LifecycleRegistry(owner, false, (Cif) null);
        }

        public final Lifecycle.State min$lifecycle_runtime_release(Lifecycle.State state1, Lifecycle.State state2) {
            lu.f(state1, "state1");
            return (state2 == null || state2.compareTo(state1) >= 0) ? state1 : state2;
        }
    }
}
