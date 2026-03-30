package defpackage;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;

/* renamed from: qs  reason: default package */
public final /* synthetic */ class qs implements InputConnectionCompat.OnCommitContentListener {
    public final /* synthetic */ View a;

    public /* synthetic */ qs(View view) {
        this.a = view;
    }

    public final boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
        return InputConnectionCompat.lambda$createOnCommitContentListenerUsingPerformReceiveContent$0(this.a, inputContentInfoCompat, i, bundle);
    }
}
