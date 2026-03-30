package defpackage;

/* renamed from: sh0  reason: default package */
final /* synthetic */ class sh0 implements Runnable {
    private final xh0 a;

    private sh0(xh0 xh0) {
        this.a = xh0;
    }

    public static Runnable a(xh0 xh0) {
        return new sh0(xh0);
    }

    public void run() {
        this.a.a.execSQL("CREATE TABLE collection_index (uid TEXT, collection_path TEXT, field_path TEXT, field_value_type INTEGER, field_value_1, field_value_2, document_id TEXT, PRIMARY KEY (uid, collection_path, field_path, field_value_type, field_value_1, field_value_2, document_id))");
    }
}
