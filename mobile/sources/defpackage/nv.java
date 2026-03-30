package defpackage;

/* renamed from: nv  reason: default package */
public abstract class nv {
    /* access modifiers changed from: private */
    public static final fi a = new fi(false);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public static final uo0 f4466a = new uo0("COMPLETING_ALREADY");
    /* access modifiers changed from: private */
    public static final fi b = new fi(true);

    /* renamed from: b  reason: collision with other field name */
    public static final uo0 f4467b = new uo0("COMPLETING_WAITING_CHILDREN");
    /* access modifiers changed from: private */
    public static final uo0 c = new uo0("COMPLETING_RETRY");
    /* access modifiers changed from: private */
    public static final uo0 d = new uo0("TOO_LATE_TO_CANCEL");
    /* access modifiers changed from: private */
    public static final uo0 e = new uo0("SEALED");

    public static final Object g(Object $this$boxIncomplete) {
        return $this$boxIncomplete instanceof gs ? new hs((gs) $this$boxIncomplete) : $this$boxIncomplete;
    }

    public static final Object h(Object $this$unboxState) {
        gs gsVar;
        hs hsVar = $this$unboxState instanceof hs ? (hs) $this$unboxState : null;
        return (hsVar == null || (gsVar = hsVar.a) == null) ? $this$unboxState : gsVar;
    }
}
