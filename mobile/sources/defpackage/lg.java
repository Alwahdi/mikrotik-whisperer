package defpackage;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

/* renamed from: lg  reason: default package */
public abstract class lg implements DialogInterface.OnClickListener {
    /* access modifiers changed from: protected */
    public abstract void b();

    public static lg a(Activity activity, Intent intent, int i) {
        return new tx0(intent, activity, i);
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            b();
        } catch (ActivityNotFoundException e) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
