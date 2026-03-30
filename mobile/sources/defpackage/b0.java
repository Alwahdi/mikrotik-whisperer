package defpackage;

import android.view.View;
import com.evrencoskun.tableview.adapter.recyclerview.holder.a;

/* renamed from: b0  reason: default package */
public abstract class b0 extends a {
    private com.evrencoskun.tableview.sort.a a = com.evrencoskun.tableview.sort.a.UNSORTED;

    public b0(View itemView) {
        super(itemView);
    }

    public void f(com.evrencoskun.tableview.sort.a pSortState) {
        this.a = pSortState;
    }

    public com.evrencoskun.tableview.sort.a e() {
        return this.a;
    }
}
