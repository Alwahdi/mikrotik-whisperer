package defpackage;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards;
import java.util.ArrayList;

/* renamed from: ts  reason: default package */
public class ts extends AsyncTask<Void, Void, String> {
    int a = 0;

    /* renamed from: a  reason: collision with other field name */
    Context f5151a;

    /* renamed from: a  reason: collision with other field name */
    ArrayList<UsermanagerCards> f5152a;

    /* renamed from: a  reason: collision with other field name */
    ue f5153a;

    public ts(Context context, ArrayList<UsermanagerCards> mUsermanagerCards, int selectedSlsId) {
        this.f5151a = context;
        this.f5152a = mUsermanagerCards;
        this.f5153a = new ue(context);
        this.a = selectedSlsId;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        Toast.makeText(this.f5151a, "يتم ارشفة الكروت قاعدة بيانات الموبايل", 0).show();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(Void... voids) {
        try {
            this.f5153a.V(this.f5152a, qb0.f4800a, this.a);
            return "ok";
        } catch (Exception e) {
            return "ok";
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void onPostExecute(String result) {
        try {
            Toast.makeText(this.f5151a, "تمت ارشفة الكروت", 0).show();
        } catch (Exception e) {
        }
    }
}
