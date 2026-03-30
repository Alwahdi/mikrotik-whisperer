package defpackage;

/* renamed from: rh0  reason: default package */
final /* synthetic */ class rh0 implements Runnable {
    private final xh0 a;

    private rh0(xh0 xh0) {
        this.a = xh0;
    }

    public static Runnable a(xh0 xh0) {
        return new rh0(xh0);
    }

    public void run() {
        this.a.a.execSQL("CREATE TABLE remote_documents (path TEXT PRIMARY KEY, contents BLOB)");
    }
}
