package defpackage;

import com.blogspot.yemeninfo4it.mumsmobile_app.model.UserProfile;
import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards;
import java.util.Objects;

/* renamed from: zk  reason: default package */
public final /* synthetic */ class zk implements ha0 {
    public final /* synthetic */ UsermanagerCards a;

    public /* synthetic */ zk(UsermanagerCards usermanagerCards) {
        this.a = usermanagerCards;
    }

    public final boolean test(Object obj) {
        return Objects.equals(this.a.getUname(), ((UserProfile) obj).getUser());
    }
}
