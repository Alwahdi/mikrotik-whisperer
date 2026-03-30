package defpackage;

/* renamed from: wh0  reason: default package */
final /* synthetic */ class wh0 implements Runnable {
    private final xh0 a;

    private wh0(xh0 xh0) {
        this.a = xh0;
    }

    public static Runnable a(xh0 xh0) {
        return new wh0(xh0);
    }

    public void run() {
        this.a.a.execSQL("CREATE TABLE collection_parents (collection_id TEXT, parent TEXT, PRIMARY KEY(collection_id, parent))");
    }
}
