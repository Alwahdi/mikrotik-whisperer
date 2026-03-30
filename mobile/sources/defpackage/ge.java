package defpackage;

import com.blogspot.yemeninfo4it.mumsmobile_app.model.UsermanagerCards;

/* renamed from: ge  reason: default package */
public final /* synthetic */ class ge implements ha0 {
    public final /* synthetic */ CharSequence a;

    public /* synthetic */ ge(CharSequence charSequence) {
        this.a = charSequence;
    }

    public final boolean test(Object obj) {
        return ((UsermanagerCards) obj).getProfilename().toLowerCase().equals(this.a.toString().toLowerCase());
    }
}
