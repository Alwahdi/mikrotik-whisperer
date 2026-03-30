package defpackage;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;

/* renamed from: ui  reason: default package */
public class ui extends DialogFragment {
    private Dialog a = null;

    /* renamed from: a  reason: collision with other field name */
    private DialogInterface.OnCancelListener f5245a = null;

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.a == null) {
            setShowsDialog(false);
        }
        return this.a;
    }

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f5245a;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public static ui a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        ui uiVar = new ui();
        Dialog dialog2 = (Dialog) y90.k(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog2.setOnDismissListener((DialogInterface.OnDismissListener) null);
        uiVar.a = dialog2;
        if (onCancelListener != null) {
            uiVar.f5245a = onCancelListener;
        }
        return uiVar;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
