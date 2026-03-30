package defpackage;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

/* renamed from: ro0  reason: default package */
public class ro0 extends DialogFragment {
    private Dialog a = null;

    /* renamed from: a  reason: collision with other field name */
    private DialogInterface.OnCancelListener f4912a = null;

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.a == null) {
            setShowsDialog(false);
        }
        return this.a;
    }

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f4912a;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public static ro0 i(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        ro0 ro0 = new ro0();
        Dialog dialog2 = (Dialog) y90.k(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog2.setOnDismissListener((DialogInterface.OnDismissListener) null);
        ro0.a = dialog2;
        if (onCancelListener != null) {
            ro0.f4912a = onCancelListener;
        }
        return ro0;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
