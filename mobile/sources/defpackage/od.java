package defpackage;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import androidx.fragment.app.DialogFragment;
import com.blogspot.yemeninfo4it.mumsmobile_app.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: od  reason: default package */
public class od extends DialogFragment {
    private EditText a;

    /* renamed from: a  reason: collision with other field name */
    private ListView f4525a;

    /* renamed from: a  reason: collision with other field name */
    private List<md> f4526a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    private nd f4527a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public pd f4528a;
    /* access modifiers changed from: private */
    public List<md> b = new ArrayList();

    public od() {
        n(md.b());
    }

    public static od l(String dialogTitle) {
        od picker = new od();
        Bundle bundle = new Bundle();
        bundle.putString("dialogTitle", dialogTitle);
        picker.setArguments(bundle);
        return picker;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.country_picker, (ViewGroup) null);
        Bundle args = getArguments();
        if (args != null) {
            getDialog().setTitle(args.getString("dialogTitle"));
            getDialog().getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.cp_dialog_width), getResources().getDimensionPixelSize(R.dimen.cp_dialog_height));
        }
        this.a = (EditText) view.findViewById(R.id.country_code_picker_search);
        this.f4525a = (ListView) view.findViewById(R.id.country_code_picker_listview);
        ArrayList arrayList = new ArrayList(this.f4526a.size());
        this.b = arrayList;
        arrayList.addAll(this.f4526a);
        nd ndVar = new nd(getActivity(), this.b);
        this.f4527a = ndVar;
        this.f4525a.setAdapter(ndVar);
        this.f4525a.setOnItemClickListener(new a());
        this.a.addTextChangedListener(new b());
        return view;
    }

    /* renamed from: od$a */
    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            if (od.this.f4528a != null) {
                md country = (md) od.this.b.get(position);
                od.this.f4528a.a(country.h(), country.c(), country.f(), country.g());
            }
        }
    }

    /* renamed from: od$b */
    class b implements TextWatcher {
        b() {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void afterTextChanged(Editable s) {
            od.this.m(s.toString());
        }
    }

    public void o(pd listener) {
        this.f4528a = listener;
    }

    /* access modifiers changed from: private */
    public void m(String text) {
        this.b.clear();
        for (md country : this.f4526a) {
            if (country.h().toLowerCase(Locale.ENGLISH).contains(text.toLowerCase())) {
                this.b.add(country);
            }
        }
        this.f4527a.notifyDataSetChanged();
    }

    public void n(List<md> newCountries) {
        this.f4526a.clear();
        this.f4526a.addAll(newCountries);
    }
}
