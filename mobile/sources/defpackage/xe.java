package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Pair;
import com.google.android.material.datepicker.a;
import java.util.Collection;

/* renamed from: xe  reason: default package */
public interface xe<S> extends Parcelable {
    S a();

    void b(long j);

    Collection<Pair<Long, Long>> c();

    String d(Context context);

    int e(Context context);

    Collection<Long> h();

    View k(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, a aVar, s40<S> s40);

    boolean l();

    String n(Context context);
}
