package kotlinx.coroutines;

public enum a {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    /* renamed from: kotlinx.coroutines.a$a  reason: collision with other inner class name */
    public /* synthetic */ class C0051a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] iArr = new int[a.values().length];
            iArr[a.DEFAULT.ordinal()] = 1;
            iArr[a.ATOMIC.ordinal()] = 2;
            iArr[a.UNDISPATCHED.ordinal()] = 3;
            iArr[a.LAZY.ordinal()] = 4;
            a = iArr;
        }
    }

    public final <T> void invoke(vn<? super rc<? super T>, ? extends Object> block, rc<? super T> completion) {
        switch (C0051a.a[ordinal()]) {
            case 1:
                t7.c(block, completion);
                return;
            case 2:
                uc.a(block, completion);
                return;
            case 3:
                ft0.a(block, completion);
                return;
            case 4:
                return;
            default:
                throw new j30();
        }
    }

    public final <R, T> void invoke(jo<? super R, ? super rc<? super T>, ? extends Object> block, R receiver, rc<? super T> completion) {
        switch (C0051a.a[ordinal()]) {
            case 1:
                t7.e(block, receiver, completion, (vn) null, 4, (Object) null);
                return;
            case 2:
                uc.b(block, receiver, completion);
                return;
            case 3:
                ft0.b(block, receiver, completion);
                return;
            case 4:
                return;
            default:
                throw new j30();
        }
    }

    public final boolean isLazy() {
        return this == LAZY;
    }
}
