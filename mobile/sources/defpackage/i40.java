package defpackage;

import android.app.Activity;
import android.content.Context;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;

/* renamed from: i40  reason: default package */
public abstract class i40 {
    public static void c(Context context) {
        ((Activity) context).overridePendingTransition(R.anim.slide_up_enter, R.anim.slide_up_exit);
    }

    public static void e(Context context) {
        ((Activity) context).overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
    }

    public static void d(Context context) {
        ((Activity) context).overridePendingTransition(R.anim.split_enter, R.anim.split_exit);
    }

    public static void a(Context context) {
        ((Activity) context).overridePendingTransition(R.anim.card_enter, R.anim.card_exit);
    }

    public static void b(Context context) {
        ((Activity) context).overridePendingTransition(R.anim.in_out_enter, R.anim.in_out_exit);
    }
}
