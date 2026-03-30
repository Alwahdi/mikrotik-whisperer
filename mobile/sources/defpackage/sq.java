package defpackage;

import android.content.Context;
import android.view.View;
import com.blogspot.yemeninfo4it.mumsmobile_app.AsyncClasses.HotspotAsync;

/* renamed from: sq  reason: default package */
public final /* synthetic */ class sq implements View.OnClickListener {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ HotspotAsync f5016a;

    public /* synthetic */ sq(HotspotAsync hotspotAsync, Context context) {
        this.f5016a = hotspotAsync;
        this.a = context;
    }

    public final void onClick(View view) {
        this.f5016a.c(this.a, view);
    }
}
