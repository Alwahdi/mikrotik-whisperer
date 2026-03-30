package defpackage;

import android.util.Log;
import android.util.SparseArray;
import java.util.List;

/* renamed from: nv0  reason: default package */
public class nv0 {
    private static final String a = nv0.class.getSimpleName();

    /* renamed from: a  reason: collision with other field name */
    private SparseArray<a> f4468a = new SparseArray<>();

    /* renamed from: a  reason: collision with other field name */
    private or f4469a;
    private SparseArray<Object> b = new SparseArray<>();

    public nv0(or tableView) {
        this.f4469a = tableView;
    }

    public void b(int row) {
        this.f4468a.put(row, a(row));
        this.f4469a.getAdapter().w(row);
    }

    public void c(int row) {
        d(row, true);
    }

    private void d(int row, boolean removeFromList) {
        a hiddenRow = this.f4468a.get(row);
        if (hiddenRow != null) {
            this.f4469a.getAdapter().m(row, hiddenRow.b(), hiddenRow.a());
        } else {
            Log.e(a, "This row is already visible.");
        }
        if (removeFromList) {
            this.f4468a.remove(row);
        }
    }

    /* renamed from: nv0$a */
    class a {
        private int a;

        /* renamed from: a  reason: collision with other field name */
        private Object f4470a;

        /* renamed from: a  reason: collision with other field name */
        private List<Object> f4471a;

        public a(int row, Object rowHeaderModel, List<Object> cellModelList) {
            this.a = row;
            this.f4470a = rowHeaderModel;
            this.f4471a = cellModelList;
        }

        public Object b() {
            return this.f4470a;
        }

        public List<Object> a() {
            return this.f4471a;
        }
    }

    private a a(int row) {
        return new a(row, this.f4469a.getAdapter().t(row), this.f4469a.getAdapter().r(row));
    }
}
