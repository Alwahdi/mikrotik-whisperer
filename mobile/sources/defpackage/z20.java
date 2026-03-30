package defpackage;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import java.util.Calendar;

/* renamed from: z20  reason: default package */
public class z20 extends DialogFragment {
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar mCalendar = Calendar.getInstance();
        int year = mCalendar.get(1);
        int month = mCalendar.get(2);
        int dayOfMonth = mCalendar.get(5);
        new TextView(getActivity());
        return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), year, month, dayOfMonth);
    }
}
