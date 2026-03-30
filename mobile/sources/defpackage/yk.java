package defpackage;

import com.blogspot.yemeninfo4it.mumsmobile_app.model.Sessions;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards;

/* renamed from: yk  reason: default package */
public final /* synthetic */ class yk implements ha0 {
    public final /* synthetic */ UsermanagerCards a;

    public /* synthetic */ yk(UsermanagerCards usermanagerCards) {
        this.a = usermanagerCards;
    }

    public final boolean test(Object obj) {
        return ((Sessions) obj).getName().equals(this.a.getUname());
    }
}
