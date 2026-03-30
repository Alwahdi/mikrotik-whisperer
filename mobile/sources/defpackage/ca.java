package defpackage;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;

/* renamed from: ca  reason: default package */
public class ca extends b0 {
    private static final String a = ca.class.getSimpleName();

    /* renamed from: a  reason: collision with other field name */
    public final Drawable f315a;

    /* renamed from: a  reason: collision with other field name */
    private View.OnClickListener f316a = new a();

    /* renamed from: a  reason: collision with other field name */
    public final ImageButton f317a;

    /* renamed from: a  reason: collision with other field name */
    public final LinearLayout f318a;

    /* renamed from: a  reason: collision with other field name */
    public final TextView f319a;

    /* renamed from: a  reason: collision with other field name */
    public final or f320a;
    public final Drawable b;

    public ca(View itemView, or tableView) {
        super(itemView);
        this.f320a = tableView;
        this.f319a = (TextView) itemView.findViewById(R.id.column_header_textView);
        this.f318a = (LinearLayout) itemView.findViewById(R.id.column_header_container);
        ImageButton imageButton = (ImageButton) itemView.findViewById(R.id.column_header_sortButton);
        this.f317a = imageButton;
        this.f315a = ContextCompat.getDrawable(itemView.getContext(), R.drawable.ic_plus);
        this.b = ContextCompat.getDrawable(itemView.getContext(), R.drawable.ic_left);
        imageButton.setOnClickListener(this.f316a);
    }

    public void h(y9 columnHeader) {
        this.f319a.setText(String.valueOf(columnHeader.d()));
        this.f318a.getLayoutParams().width = -2;
        this.f319a.requestLayout();
    }

    /* renamed from: ca$a */
    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            com.evrencoskun.tableview.sort.a e = ca.this.e();
            com.evrencoskun.tableview.sort.a aVar = com.evrencoskun.tableview.sort.a.ASCENDING;
            if (e == aVar) {
                ca caVar = ca.this;
                caVar.f320a.l(caVar.getAdapterPosition(), com.evrencoskun.tableview.sort.a.DESCENDING);
                return;
            }
            com.evrencoskun.tableview.sort.a e2 = ca.this.e();
            com.evrencoskun.tableview.sort.a aVar2 = com.evrencoskun.tableview.sort.a.DESCENDING;
            if (e2 == aVar2) {
                ca caVar2 = ca.this;
                caVar2.f320a.l(caVar2.getAdapterPosition(), aVar);
                return;
            }
            ca caVar3 = ca.this;
            caVar3.f320a.l(caVar3.getAdapterPosition(), aVar2);
        }
    }

    public void f(com.evrencoskun.tableview.sort.a sortState) {
        String str = a;
        Log.e(str, " + onSortingStatusChanged : x:  " + getAdapterPosition() + " old state " + e() + " current state : " + sortState + " visiblity: " + this.f317a.getVisibility());
        super.f(sortState);
        this.f318a.getLayoutParams().width = -2;
        g(sortState);
        Log.e(str, " - onSortingStatusChanged : x:  " + getAdapterPosition() + " old state " + e() + " current state : " + sortState + " visiblity: " + this.f317a.getVisibility());
        this.f319a.requestLayout();
        this.f317a.requestLayout();
        this.f318a.requestLayout();
        this.itemView.requestLayout();
    }

    private void g(com.evrencoskun.tableview.sort.a sortState) {
        if (sortState == com.evrencoskun.tableview.sort.a.ASCENDING) {
            this.f317a.setVisibility(0);
            this.f317a.setImageDrawable(this.b);
        } else if (sortState == com.evrencoskun.tableview.sort.a.DESCENDING) {
            this.f317a.setVisibility(0);
            this.f317a.setImageDrawable(this.f315a);
        } else {
            this.f317a.setVisibility(4);
        }
    }
}
