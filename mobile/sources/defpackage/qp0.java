package defpackage;

import android.content.Context;
import android.widget.TableRow;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.evrencoskun.tableview.TableView;

/* renamed from: qp0  reason: default package */
public class qp0 implements pr {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    TableRow f4851a = null;

    /* renamed from: a  reason: collision with other field name */
    private Toast f4852a;

    /* renamed from: a  reason: collision with other field name */
    private TableView f4853a;

    public qp0(TableView tableView) {
        this.a = tableView.getContext();
        this.f4853a = tableView;
    }

    public void g(RecyclerView.ViewHolder cellView, int column, int row) {
        e("Cell " + column + " " + row + " has been clicked.---");
        qb0.a = row;
    }

    public void c(RecyclerView.ViewHolder cellView, int column, int row) {
        qb0.a = row;
        e("Cell " + column + " " + qb0.f4807b.get(row).getUname() + " has been long pressed.");
        if (cellView != null) {
            new ef0(cellView, this.f4853a).show();
        }
    }

    public void d(RecyclerView.ViewHolder columnHeaderView, int column) {
        e("Column header  " + column + " has been clicked.");
    }

    public void b(RecyclerView.ViewHolder columnHeaderView, int column) {
        if (columnHeaderView != null && (columnHeaderView instanceof ca)) {
            new z9((ca) columnHeaderView, this.f4853a).show();
        }
    }

    public void f(RecyclerView.ViewHolder rowHeaderView, int row) {
        e("Row header " + row + " has been clicked.");
    }

    public void a(RecyclerView.ViewHolder rowHeaderView, int row) {
        if (rowHeaderView != null) {
            new ef0(rowHeaderView, this.f4853a).show();
        }
    }

    private void e(String p_strMessage) {
        if (this.f4852a == null) {
            this.f4852a = Toast.makeText(this.a, "", 0);
        }
        this.f4852a.setText(p_strMessage);
        this.f4852a.show();
    }
}
