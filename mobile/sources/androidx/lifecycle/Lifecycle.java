package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import java.util.concurrent.atomic.AtomicReference;

public abstract class Lifecycle {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private AtomicReference<Object> internalScopeRef = new AtomicReference<>();

    @MainThread
    public abstract void addObserver(LifecycleObserver lifecycleObserver);

    @MainThread
    public abstract State getCurrentState();

    @MainThread
    public abstract void removeObserver(LifecycleObserver lifecycleObserver);

    public final AtomicReference<Object> getInternalScopeRef() {
        return this.internalScopeRef;
    }

    public final void setInternalScopeRef(AtomicReference<Object> atomicReference) {
        lu.f(atomicReference, "<set-?>");
        this.internalScopeRef = atomicReference;
    }

    public enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;
        
        public static final Companion Companion = null;

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] iArr = new int[Event.values().length];
                try {
                    iArr[Event.ON_CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[Event.ON_STOP.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[Event.ON_START.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[Event.ON_PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError e4) {
                }
                try {
                    iArr[Event.ON_RESUME.ordinal()] = 5;
                } catch (NoSuchFieldError e5) {
                }
                try {
                    iArr[Event.ON_DESTROY.ordinal()] = 6;
                } catch (NoSuchFieldError e6) {
                }
                try {
                    iArr[Event.ON_ANY.ordinal()] = 7;
                } catch (NoSuchFieldError e7) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public static final Event downFrom(State state) {
            return Companion.downFrom(state);
        }

        public static final Event downTo(State state) {
            return Companion.downTo(state);
        }

        public static final Event upFrom(State state) {
            return Companion.upFrom(state);
        }

        public static final Event upTo(State state) {
            return Companion.upTo(state);
        }

        static {
            Companion = new Companion((Cif) null);
        }

        public final State getTargetState() {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                case 2:
                    return State.CREATED;
                case 3:
                case 4:
                    return State.STARTED;
                case 5:
                    return State.RESUMED;
                case 6:
                    return State.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }

        public static final class Companion {

            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

                static {
                    int[] iArr = new int[State.values().length];
                    try {
                        iArr[State.CREATED.ordinal()] = 1;
                    } catch (NoSuchFieldError e) {
                    }
                    try {
                        iArr[State.STARTED.ordinal()] = 2;
                    } catch (NoSuchFieldError e2) {
                    }
                    try {
                        iArr[State.RESUMED.ordinal()] = 3;
                    } catch (NoSuchFieldError e3) {
                    }
                    try {
                        iArr[State.DESTROYED.ordinal()] = 4;
                    } catch (NoSuchFieldError e4) {
                    }
                    try {
                        iArr[State.INITIALIZED.ordinal()] = 5;
                    } catch (NoSuchFieldError e5) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public /* synthetic */ Companion(Cif ifVar) {
                this();
            }

            private Companion() {
            }

            public final Event downFrom(State state) {
                lu.f(state, "state");
                switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
                    case 1:
                        return Event.ON_DESTROY;
                    case 2:
                        return Event.ON_STOP;
                    case 3:
                        return Event.ON_PAUSE;
                    default:
                        return null;
                }
            }

            public final Event downTo(State state) {
                lu.f(state, "state");
                switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
                    case 1:
                        return Event.ON_STOP;
                    case 2:
                        return Event.ON_PAUSE;
                    case 4:
                        return Event.ON_DESTROY;
                    default:
                        return null;
                }
            }

            public final Event upFrom(State state) {
                lu.f(state, "state");
                switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
                    case 1:
                        return Event.ON_START;
                    case 2:
                        return Event.ON_RESUME;
                    case 5:
                        return Event.ON_CREATE;
                    default:
                        return null;
                }
            }

            public final Event upTo(State state) {
                lu.f(state, "state");
                switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
                    case 1:
                        return Event.ON_CREATE;
                    case 2:
                        return Event.ON_START;
                    case 3:
                        return Event.ON_RESUME;
                    default:
                        return null;
                }
            }
        }
    }

    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public final boolean isAtLeast(State state) {
            lu.f(state, "state");
            return compareTo(state) >= 0;
        }
    }
}
