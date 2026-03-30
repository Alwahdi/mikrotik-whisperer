package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import java.util.Iterator;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class i<S> extends m<S> {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private a f1735a;

    /* renamed from: a  reason: collision with other field name */
    private xe<S> f1736a;

    static <T> i<T> k(xe<T> dateSelector, int themeResId, a calendarConstraints) {
        MaterialTextInputPicker<T> materialCalendar = new i<>();
        Bundle args = new Bundle();
        args.putInt("THEME_RES_ID_KEY", themeResId);
        args.putParcelable("DATE_SELECTOR_KEY", dateSelector);
        args.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        materialCalendar.setArguments(args);
        return materialCalendar;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.a);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f1736a);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f1735a);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle activeBundle = bundle == null ? getArguments() : bundle;
        this.a = activeBundle.getInt("THEME_RES_ID_KEY");
        this.f1736a = (xe) activeBundle.getParcelable("DATE_SELECTOR_KEY");
        this.f1735a = (a) activeBundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f1736a.k(layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), this.a)), viewGroup, bundle, this.f1735a, new a());
    }

    class a extends s40<S> {
        a() {
        }

        public void a(S selection) {
            Iterator it = i.this.a.iterator();
            while (it.hasNext()) {
                ((s40) it.next()).a(selection);
            }
        }
    }
}
