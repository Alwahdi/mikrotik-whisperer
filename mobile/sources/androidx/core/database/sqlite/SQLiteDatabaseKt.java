package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;

public final class SQLiteDatabaseKt {
    /* JADX INFO: finally extract failed */
    public static /* synthetic */ Object transaction$default(SQLiteDatabase $this$transaction_u24default, boolean exclusive, vn body, int i, Object obj) {
        if ((i & 1) != 0) {
            exclusive = true;
        }
        lu.f($this$transaction_u24default, "<this>");
        lu.f(body, "body");
        if (exclusive) {
            $this$transaction_u24default.beginTransaction();
        } else {
            $this$transaction_u24default.beginTransactionNonExclusive();
        }
        try {
            Object invoke = body.invoke($this$transaction_u24default);
            $this$transaction_u24default.setTransactionSuccessful();
            ps.b(1);
            $this$transaction_u24default.endTransaction();
            ps.a(1);
            Object obj2 = invoke;
            return invoke;
        } catch (Throwable th) {
            ps.b(1);
            $this$transaction_u24default.endTransaction();
            ps.a(1);
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public static final <T> T transaction(SQLiteDatabase $this$transaction, boolean exclusive, vn<? super SQLiteDatabase, ? extends T> body) {
        lu.f($this$transaction, "<this>");
        lu.f(body, "body");
        if (exclusive) {
            $this$transaction.beginTransaction();
        } else {
            $this$transaction.beginTransactionNonExclusive();
        }
        try {
            T invoke = body.invoke($this$transaction);
            $this$transaction.setTransactionSuccessful();
            ps.b(1);
            $this$transaction.endTransaction();
            ps.a(1);
            T t = invoke;
            return invoke;
        } catch (Throwable th) {
            ps.b(1);
            $this$transaction.endTransaction();
            ps.a(1);
            throw th;
        }
    }
}
