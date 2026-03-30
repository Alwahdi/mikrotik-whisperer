package defpackage;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.Model_images;
import java.util.ArrayList;

/* renamed from: t0  reason: default package */
public class t0 extends ArrayAdapter<Model_images> {
    Context a;

    /* renamed from: a  reason: collision with other field name */
    ArrayList<Model_images> f5068a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    b f5069a;

    public t0(Context context, ArrayList<Model_images> al_menu) {
        super(context, R.layout.adapter_photosfolder, al_menu);
        this.f5068a = al_menu;
        this.a = context;
    }

    public int getCount() {
        Log.e("ADAPTER LIST SIZE", this.f5068a.size() + "");
        return this.f5068a.size();
    }

    public int getItemViewType(int position) {
        return position;
    }

    public int getViewTypeCount() {
        if (this.f5068a.size() > 0) {
            return this.f5068a.size();
        }
        return 1;
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            this.f5069a = new b();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_photosfolder, parent, false);
            this.f5069a.f5070a = (TextView) convertView.findViewById(R.id.tv_folder);
            this.f5069a.b = (TextView) convertView.findViewById(R.id.tv_folder2);
            this.f5069a.a = (ImageView) convertView.findViewById(R.id.iv_image);
            convertView.setTag(this.f5069a);
        } else {
            this.f5069a = (b) convertView.getTag();
        }
        this.f5069a.f5070a.setText(this.f5068a.get(position).getStr_folder());
        this.f5069a.a.setBackground(new BitmapDrawable(BitmapFactory.decodeFile(this.f5068a.get(position).getAl_imagepath())));
        return convertView;
    }

    /* renamed from: t0$b */
    private static class b {
        ImageView a;

        /* renamed from: a  reason: collision with other field name */
        TextView f5070a;
        TextView b;

        private b() {
        }
    }
}
