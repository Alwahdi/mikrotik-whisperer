package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import java.util.List;

/* renamed from: nd  reason: default package */
public class nd extends BaseAdapter {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    LayoutInflater f4424a;

    /* renamed from: a  reason: collision with other field name */
    List<md> f4425a;

    public nd(Context context, List<md> countries) {
        this.a = context;
        this.f4425a = countries;
        this.f4424a = LayoutInflater.from(context);
    }

    public int getCount() {
        return this.f4425a.size();
    }

    public Object getItem(int arg0) {
        return null;
    }

    public long getItemId(int arg0) {
        return 0;
    }

    public View getView(int position, View view, ViewGroup parent) {
        md country = this.f4425a.get(position);
        if (view == null) {
            view = this.f4424a.inflate(R.layout.row, (ViewGroup) null);
        }
        a cell = a.a(view);
        cell.f4426a.setText(country.h());
        country.i(this.a);
        if (country.g() != -1) {
            cell.a.setImageResource(country.g());
        }
        return view;
    }

    /* renamed from: nd$a */
    static class a {
        public ImageView a;

        /* renamed from: a  reason: collision with other field name */
        public TextView f4426a;

        a() {
        }

        static a a(View view) {
            if (view == null) {
                return null;
            }
            if (view.getTag() != null) {
                return (a) view.getTag();
            }
            a cell = new a();
            cell.f4426a = (TextView) view.findViewById(R.id.row_title);
            cell.a = (ImageView) view.findViewById(R.id.row_icon);
            view.setTag(cell);
            return cell;
        }
    }
}
