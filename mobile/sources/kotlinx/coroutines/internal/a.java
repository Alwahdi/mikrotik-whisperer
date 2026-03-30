package kotlinx.coroutines.internal;

public abstract class a {
    private static final Object a = new uo0("CONDITION_FALSE");
    private static final Object b = new uo0("LIST_EMPTY");

    public static final Object a() {
        return a;
    }

    public static final b b(Object $this$unwrap) {
        b bVar;
        c cVar = $this$unwrap instanceof c ? (c) $this$unwrap : null;
        return (cVar == null || (bVar = cVar.a) == null) ? (b) $this$unwrap : bVar;
    }
}
