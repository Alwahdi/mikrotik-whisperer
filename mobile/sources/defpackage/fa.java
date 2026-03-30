package defpackage;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.evrencoskun.tableview.sort.ISortableModel;
import com.evrencoskun.tableview.sort.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: fa  reason: default package */
public class fa {
    private aa a;

    /* renamed from: a  reason: collision with other field name */
    private b8 f2961a;

    /* renamed from: a  reason: collision with other field name */
    private ff0 f2962a;

    /* renamed from: a  reason: collision with other field name */
    private List<ha> f2963a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    private boolean f2964a = true;

    public fa(or tableView) {
        this.f2961a = (b8) tableView.getCellRecyclerView().getAdapter();
        this.f2962a = (ff0) tableView.getRowHeaderRecyclerView().getAdapter();
        this.a = (aa) tableView.getColumnHeaderRecyclerView().getAdapter();
    }

    public void e(a sortState) {
        List<ISortableModel> originalRowHeaderList = this.f2962a.c();
        List<ISortableModel> sortedRowHeaderList = new ArrayList<>(originalRowHeaderList);
        List<List<ISortableModel>> originalList = this.f2961a.c();
        List<List<ISortableModel>> sortedList = new ArrayList<>(originalList);
        if (sortState != a.UNSORTED) {
            Collections.sort(sortedRowHeaderList, new if0(sortState));
            Collections.sort(sortedList, new df0(originalRowHeaderList, originalList, sortState));
        }
        this.f2962a.f().b(sortState);
        g(originalRowHeaderList, sortedRowHeaderList, sortedList, sortState);
    }

    public void d(int column, a sortState) {
        List<List<ISortableModel>> originalList = this.f2961a.c();
        List<List<ISortableModel>> sortedList = new ArrayList<>(originalList);
        List<ISortableModel> originalRowHeaderList = this.f2962a.c();
        List<ISortableModel> sortedRowHeaderList = new ArrayList<>(originalRowHeaderList);
        if (sortState != a.UNSORTED) {
            Collections.sort(sortedList, new ea(column, sortState));
            Collections.sort(sortedRowHeaderList, new x9(originalRowHeaderList, originalList, column, sortState));
        }
        this.a.f().c(column, sortState);
        f(originalList, sortedList, column, sortedRowHeaderList, sortState);
    }

    private void g(List<mr> oldRowHeader, List<mr> newRowHeader, List<List<mr>> newColumnItems, a sortState) {
        this.f2962a.e(newRowHeader, !this.f2964a);
        this.f2961a.e(newColumnItems, !this.f2964a);
        if (this.f2964a) {
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new hf0(oldRowHeader, newRowHeader));
            diffResult.dispatchUpdatesTo((RecyclerView.Adapter) this.f2962a);
            diffResult.dispatchUpdatesTo((RecyclerView.Adapter) this.f2961a);
        }
        for (ha listener : this.f2963a) {
            listener.b(sortState);
        }
    }

    private void f(List<List<mr>> oldItems, List<List<mr>> newItems, int column, List<mr> newRowHeader, a sortState) {
        this.f2961a.e(newItems, !this.f2964a);
        this.f2962a.e(newRowHeader, !this.f2964a);
        if (this.f2964a) {
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new da(oldItems, newItems, column));
            diffResult.dispatchUpdatesTo((RecyclerView.Adapter) this.f2961a);
            diffResult.dispatchUpdatesTo((RecyclerView.Adapter) this.f2962a);
        }
        for (ha listener : this.f2963a) {
            listener.a(column, sortState);
        }
    }

    public a c(int column) {
        return this.a.f().b(column);
    }

    public a b() {
        return this.f2962a.f().a();
    }

    public void a(ha listener) {
        if (this.f2963a == null) {
            this.f2963a = new ArrayList();
        }
        this.f2963a.add(listener);
    }
}
