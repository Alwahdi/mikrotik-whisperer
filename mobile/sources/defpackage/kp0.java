package defpackage;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;

/* renamed from: kp0  reason: default package */
public class kp0 extends d0<y9, cf0, z7> {
    private static final String a = op0.class.getSimpleName();

    /* renamed from: a  reason: collision with other field name */
    private final LayoutInflater f4148a = LayoutInflater.from(this.f2684a);

    /* renamed from: a  reason: collision with other field name */
    private tp0 f4149a;

    public kp0(Context context, tp0 tableViewModel) {
        super(context);
        this.f4149a = tableViewModel;
    }

    public com.evrencoskun.tableview.adapter.recyclerview.holder.a d(ViewGroup parent, int viewType) {
        Log.e(a, " onCreateCellViewHolder has been called");
        switch (viewType) {
            case 2:
                return new ap(this.f4148a.inflate(R.layout.table_view_image_cell_layout, parent, false));
            case 10:
                return new e20(this.f4148a.inflate(R.layout.table_view_image_cell_layout, parent, false));
            default:
                return new b(this.f4148a.inflate(R.layout.table_view_cell_layout, parent, false));
        }
    }

    public void j(com.evrencoskun.tableview.adapter.recyclerview.holder.a holder, Object cellItemModel, int columnPosition, int rowPosition) {
        z7 cell = (z7) cellItemModel;
        switch (holder.getItemViewType()) {
            case 2:
                ((ap) holder).a.setImageDrawable(this.f4149a.d(((Integer) cell.d()).intValue(), true));
                return;
            case 10:
                ((e20) holder).a.setImageDrawable(this.f4149a.d(((Integer) cell.d()).intValue(), false));
                return;
            default:
                ((b) holder).e(cell);
                return;
        }
    }

    public com.evrencoskun.tableview.adapter.recyclerview.holder.a f(ViewGroup parent, int viewType) {
        return new ca(this.f4148a.inflate(R.layout.table_view_column_header_layout, parent, false), b());
    }

    public void a(com.evrencoskun.tableview.adapter.recyclerview.holder.a holder, Object columnHeaderItemModel, int columnPosition) {
        ((ca) holder).h((y9) columnHeaderItemModel);
    }

    public com.evrencoskun.tableview.adapter.recyclerview.holder.a e(ViewGroup parent, int viewType) {
        return new kf0(this.f4148a.inflate(R.layout.table_view_row_header_layout, parent, false));
    }

    public void i(com.evrencoskun.tableview.adapter.recyclerview.holder.a holder, Object rowHeaderItemModel, int rowPosition) {
        ((kf0) holder).a.setText(String.valueOf(((cf0) rowHeaderItemModel).d()));
    }

    /* renamed from: kp0$a */
    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            com.evrencoskun.tableview.sort.a sortState = kp0.this.b().getRowHeaderSortingStatus();
            com.evrencoskun.tableview.sort.a aVar = com.evrencoskun.tableview.sort.a.ASCENDING;
            if (sortState != aVar) {
                Log.d("TableViewAdapter", "Order Ascending");
                kp0.this.b().f(aVar);
                return;
            }
            Log.d("TableViewAdapter", "Order Descending");
            kp0.this.b().f(com.evrencoskun.tableview.sort.a.DESCENDING);
        }
    }

    public View c() {
        View corner = this.f4148a.inflate(R.layout.table_view_corner_layout, (ViewGroup) null);
        corner.setOnClickListener(new a());
        return corner;
    }

    public int k(int position) {
        return 0;
    }

    public int g(int position) {
        return 0;
    }

    public int h(int column) {
        switch (column) {
            case 4:
                return 0;
            default:
                return 0;
        }
    }

    /* renamed from: kp0$b */
    public class b extends com.evrencoskun.tableview.adapter.recyclerview.holder.a {
        public final LinearLayout a;

        /* renamed from: a  reason: collision with other field name */
        public final TextView f4150a;

        /* renamed from: a  reason: collision with other field name */
        private z7 f4152a;

        public b(View itemView) {
            super(itemView);
            this.f4150a = (TextView) itemView.findViewById(R.id.cell_data);
            this.a = (LinearLayout) itemView.findViewById(R.id.cell_container);
        }

        public void e(z7 cell) {
            this.f4152a = cell;
            this.f4150a.setText(String.valueOf(cell.d()));
            this.a.getLayoutParams().width = -2;
            this.f4150a.requestLayout();
        }
    }
}
