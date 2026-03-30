package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.datepicker.a;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class h<S> extends DialogFragment {
    static final Object a = "CONFIRM_BUTTON_TAG";
    static final Object b = "CANCEL_BUTTON_TAG";
    static final Object c = "TOGGLE_BUTTON_TAG";

    /* renamed from: a  reason: collision with other field name */
    private int f1707a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public Button f1708a;

    /* renamed from: a  reason: collision with other field name */
    private TextView f1709a;

    /* renamed from: a  reason: collision with other field name */
    private a f1710a;

    /* renamed from: a  reason: collision with other field name */
    private g<S> f1711a;

    /* renamed from: a  reason: collision with other field name */
    private m<S> f1712a;

    /* renamed from: a  reason: collision with other field name */
    private CheckableImageButton f1713a;

    /* renamed from: a  reason: collision with other field name */
    private CharSequence f1714a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final LinkedHashSet<m00<? super S>> f1715a = new LinkedHashSet<>();

    /* renamed from: a  reason: collision with other field name */
    private p00 f1716a;

    /* renamed from: a  reason: collision with other field name */
    private xe<S> f1717a;

    /* renamed from: a  reason: collision with other field name */
    private ye f1718a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f1719a;

    /* renamed from: b  reason: collision with other field name */
    private int f1720b;

    /* renamed from: b  reason: collision with other field name */
    private TextView f1721b;

    /* renamed from: b  reason: collision with other field name */
    private CharSequence f1722b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public final LinkedHashSet<View.OnClickListener> f1723b = new LinkedHashSet<>();

    /* renamed from: b  reason: collision with other field name */
    private boolean f1724b;

    /* renamed from: c  reason: collision with other field name */
    private int f1725c;

    /* renamed from: c  reason: collision with other field name */
    private CharSequence f1726c;

    /* renamed from: c  reason: collision with other field name */
    private final LinkedHashSet<DialogInterface.OnCancelListener> f1727c = new LinkedHashSet<>();
    private int d;

    /* renamed from: d  reason: collision with other field name */
    private CharSequence f1728d;

    /* renamed from: d  reason: collision with other field name */
    private final LinkedHashSet<DialogInterface.OnDismissListener> f1729d = new LinkedHashSet<>();
    private int e;

    /* renamed from: e  reason: collision with other field name */
    private CharSequence f1730e;
    private int f;

    /* renamed from: f  reason: collision with other field name */
    private CharSequence f1731f;
    private int g;

    /* renamed from: g  reason: collision with other field name */
    private CharSequence f1732g;

    public String s() {
        return p().n(getContext());
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f1707a);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f1717a);
        a.b constraintsBuilder = new a.b(this.f1710a);
        g<S> gVar = this.f1711a;
        j currentMonth = gVar == null ? null : gVar.v();
        if (currentMonth != null) {
            constraintsBuilder.b(currentMonth.f1737a);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", constraintsBuilder.a());
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f1718a);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f1720b);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f1714a);
        bundle.putInt("INPUT_MODE_KEY", this.f1725c);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.d);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.f1722b);
        bundle.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.e);
        bundle.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.f1726c);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.f);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.f1728d);
        bundle.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.g);
        bundle.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.f1730e);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle activeBundle = bundle == null ? getArguments() : bundle;
        this.f1707a = activeBundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f1717a = (xe) activeBundle.getParcelable("DATE_SELECTOR_KEY");
        this.f1710a = (a) activeBundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        b6.a(activeBundle.getParcelable("DAY_VIEW_DECORATOR_KEY"));
        this.f1720b = activeBundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f1714a = activeBundle.getCharSequence("TITLE_TEXT_KEY");
        this.f1725c = activeBundle.getInt("INPUT_MODE_KEY");
        this.d = activeBundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f1722b = activeBundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.e = activeBundle.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.f1726c = activeBundle.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        this.f = activeBundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f1728d = activeBundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        this.g = activeBundle.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.f1730e = activeBundle.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        CharSequence charSequence = this.f1714a;
        if (charSequence == null) {
            charSequence = requireContext().getResources().getText(this.f1720b);
        }
        this.f1731f = charSequence;
        this.f1732g = q(charSequence);
    }

    private int v(Context context) {
        int i = this.f1707a;
        if (i != 0) {
            return i;
        }
        return p().e(context);
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), v(requireContext()));
        Context context = dialog.getContext();
        this.f1719a = x(context);
        int i = yb0.materialCalendarStyle;
        int i2 = uc0.Widget_MaterialComponents_MaterialCalendar;
        this.f1716a = new p00(context, (AttributeSet) null, i, i2);
        TypedArray a2 = context.obtainStyledAttributes((AttributeSet) null, xc0.f5730y0, i, i2);
        int backgroundColor = a2.getColor(xc0.F2, 0);
        a2.recycle();
        this.f1716a.K(context);
        this.f1716a.V(ColorStateList.valueOf(backgroundColor));
        this.f1716a.U(ViewCompat.getElevation(dialog.getWindow().getDecorView()));
        return dialog;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View root = layoutInflater.inflate(this.f1719a ? nc0.mtrl_picker_fullscreen : nc0.mtrl_picker_dialog, viewGroup);
        Context context = root.getContext();
        if (this.f1719a) {
            root.findViewById(ic0.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(t(context), -2));
        } else {
            root.findViewById(ic0.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(t(context), -1));
        }
        TextView textView = (TextView) root.findViewById(ic0.mtrl_picker_header_selection_text);
        this.f1721b = textView;
        ViewCompat.setAccessibilityLiveRegion(textView, 1);
        this.f1713a = (CheckableImageButton) root.findViewById(ic0.mtrl_picker_header_toggle);
        this.f1709a = (TextView) root.findViewById(ic0.mtrl_picker_title_text);
        w(context);
        this.f1708a = (Button) root.findViewById(ic0.confirm_button);
        if (p().l()) {
            this.f1708a.setEnabled(true);
        } else {
            this.f1708a.setEnabled(false);
        }
        this.f1708a.setTag(a);
        CharSequence charSequence = this.f1722b;
        if (charSequence != null) {
            this.f1708a.setText(charSequence);
        } else {
            int i = this.d;
            if (i != 0) {
                this.f1708a.setText(i);
            }
        }
        CharSequence charSequence2 = this.f1726c;
        if (charSequence2 != null) {
            this.f1708a.setContentDescription(charSequence2);
        } else if (this.e != 0) {
            this.f1708a.setContentDescription(getContext().getResources().getText(this.e));
        }
        this.f1708a.setOnClickListener(new a());
        Button cancelButton = (Button) root.findViewById(ic0.cancel_button);
        cancelButton.setTag(b);
        CharSequence charSequence3 = this.f1728d;
        if (charSequence3 != null) {
            cancelButton.setText(charSequence3);
        } else {
            int i2 = this.f;
            if (i2 != 0) {
                cancelButton.setText(i2);
            }
        }
        CharSequence charSequence4 = this.f1730e;
        if (charSequence4 != null) {
            cancelButton.setContentDescription(charSequence4);
        } else if (this.g != 0) {
            cancelButton.setContentDescription(getContext().getResources().getText(this.g));
        }
        cancelButton.setOnClickListener(new b());
        return root;
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View v) {
            Iterator it = h.this.f1715a.iterator();
            while (it.hasNext()) {
                ((m00) it.next()).a(h.this.u());
            }
            h.this.dismiss();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View v) {
            Iterator it = h.this.f1723b.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(v);
            }
            h.this.dismiss();
        }
    }

    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.f1719a) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.f1716a);
            o(window);
        } else {
            window.setLayout(-2, -2);
            int inset = getResources().getDimensionPixelOffset(cc0.mtrl_calendar_dialog_background_inset);
            Rect insets = new Rect(inset, inset, inset, inset);
            window.setBackgroundDrawable(new InsetDrawable(this.f1716a, inset, inset, inset, inset));
            window.getDecorView().setOnTouchListener(new us(requireDialog(), insets));
        }
        C();
    }

    public void onStop() {
        this.f1712a.j();
        super.onStop();
    }

    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.f1727c.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.f1729d.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    public final S u() {
        return p().a();
    }

    private void o(Window window) {
        if (!this.f1724b) {
            View headerLayout = requireView().findViewById(ic0.fullscreen_header);
            zh.a(window, true, lv0.d(headerLayout), (Integer) null);
            ViewCompat.setOnApplyWindowInsetsListener(headerLayout, new c(headerLayout.getLayoutParams().height, headerLayout, headerLayout.getPaddingTop()));
            this.f1724b = true;
        }
    }

    class c implements OnApplyWindowInsetsListener {
        final /* synthetic */ int a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ View f1733a;
        final /* synthetic */ int b;

        c(int i, View view, int i2) {
            this.a = i;
            this.f1733a = view;
            this.b = i2;
        }

        public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
            int topInset = insets.getInsets(WindowInsetsCompat.Type.systemBars()).top;
            if (this.a >= 0) {
                this.f1733a.getLayoutParams().height = this.a + topInset;
                View view = this.f1733a;
                view.setLayoutParams(view.getLayoutParams());
            }
            View view2 = this.f1733a;
            view2.setPadding(view2.getPaddingLeft(), this.b + topInset, this.f1733a.getPaddingRight(), this.f1733a.getPaddingBottom());
            return insets;
        }
    }

    private void E() {
        this.f1709a.setText((this.f1725c != 1 || !y()) ? this.f1731f : this.f1732g);
    }

    /* access modifiers changed from: package-private */
    public void D(String headerText) {
        this.f1721b.setContentDescription(r());
        this.f1721b.setText(headerText);
    }

    private String r() {
        return p().d(requireContext());
    }

    private void C() {
        int themeResId = v(requireContext());
        g<S> A = g.A(p(), themeResId, this.f1710a, this.f1718a);
        this.f1711a = A;
        m mVar = A;
        if (this.f1725c == 1) {
            mVar = i.k(p(), themeResId, this.f1710a);
        }
        this.f1712a = mVar;
        E();
        D(s());
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(ic0.mtrl_calendar_frame, this.f1712a);
        fragmentTransaction.commitNow();
        this.f1712a.i(new d());
    }

    class d extends s40<S> {
        d() {
        }

        public void a(S s) {
            h hVar = h.this;
            hVar.D(hVar.s());
            h.this.f1708a.setEnabled(h.this.p().l());
        }
    }

    private void w(Context context) {
        this.f1713a.setTag(c);
        this.f1713a.setImageDrawable(n(context));
        this.f1713a.setChecked(this.f1725c != 0);
        ViewCompat.setAccessibilityDelegate(this.f1713a, (AccessibilityDelegateCompat) null);
        F(this.f1713a);
        this.f1713a.setOnClickListener(new l00(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A(View v) {
        this.f1708a.setEnabled(p().l());
        this.f1713a.toggle();
        int i = 1;
        if (this.f1725c == 1) {
            i = 0;
        }
        this.f1725c = i;
        F(this.f1713a);
        C();
    }

    private void F(CheckableImageButton toggle) {
        String contentDescription;
        if (this.f1725c == 1) {
            contentDescription = toggle.getContext().getString(sc0.mtrl_picker_toggle_to_calendar_input_mode);
        } else {
            contentDescription = toggle.getContext().getString(sc0.mtrl_picker_toggle_to_text_input_mode);
        }
        this.f1713a.setContentDescription(contentDescription);
    }

    /* access modifiers changed from: private */
    public xe<S> p() {
        if (this.f1717a == null) {
            this.f1717a = (xe) getArguments().getParcelable("DATE_SELECTOR_KEY");
        }
        return this.f1717a;
    }

    private static Drawable n(Context context) {
        StateListDrawable toggleDrawable = new StateListDrawable();
        toggleDrawable.addState(new int[]{16842912}, AppCompatResources.getDrawable(context, gc0.material_ic_calendar_black_24dp));
        toggleDrawable.addState(new int[0], AppCompatResources.getDrawable(context, gc0.material_ic_edit_black_24dp));
        return toggleDrawable;
    }

    private static CharSequence q(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        String[] lines = TextUtils.split(String.valueOf(charSequence), "\n");
        return lines.length > 1 ? lines[0] : charSequence;
    }

    private boolean y() {
        return getResources().getConfiguration().orientation == 2;
    }

    static boolean x(Context context) {
        return B(context, 16843277);
    }

    static boolean z(Context context) {
        return B(context, yb0.nestedScrollable);
    }

    static boolean B(Context context, int attributeResId) {
        TypedArray a2 = context.obtainStyledAttributes(e00.d(context, yb0.materialCalendarStyle, g.class.getCanonicalName()), new int[]{attributeResId});
        boolean attributeValue = a2.getBoolean(0, false);
        a2.recycle();
        return attributeValue;
    }

    private static int t(Context context) {
        Resources resources = context.getResources();
        int padding = resources.getDimensionPixelOffset(cc0.mtrl_calendar_content_padding);
        int daysInWeek = j.q().c;
        return (padding * 2) + (daysInWeek * resources.getDimensionPixelSize(cc0.mtrl_calendar_day_width)) + ((daysInWeek - 1) * resources.getDimensionPixelOffset(cc0.mtrl_calendar_month_horizontal_padding));
    }
}
