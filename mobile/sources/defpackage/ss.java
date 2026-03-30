package defpackage;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.HotspotCard;
import java.util.ArrayList;

/* renamed from: ss  reason: default package */
public class ss extends AsyncTask<Void, Void, String> {
    int a = 0;

    /* renamed from: a  reason: collision with other field name */
    Context f5017a;

    /* renamed from: a  reason: collision with other field name */
    ArrayList<HotspotCard> f5018a;

    /* renamed from: a  reason: collision with other field name */
    ue f5019a;

    public ss(Context context, ArrayList<HotspotCard> hotspotCard, int selectedSlsId) {
        this.f5017a = context;
        this.f5018a = hotspotCard;
        this.f5019a = new ue(context);
        this.a = selectedSlsId;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        Toast.makeText(this.f5017a, "يتم ارشفة الكروت قاعدة بيانات الموبايل", 0).show();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(Void... voids) {
        try {
            this.f5019a.w(this.f5018a, qb0.f4800a, this.a);
            return "ok";
        } catch (Exception e) {
            return "ok";
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void onPostExecute(String result) {
        try {
            Toast.makeText(this.f5017a, "تمت ارشفة الكروت", 0).show();
        } catch (Exception e) {
        }
    }
}
