package androidx.core.content;

import android.content.SharedPreferences;

public final class SharedPreferencesKt {
    public static /* synthetic */ void edit$default(SharedPreferences $this$edit_u24default, boolean commit, vn action, int i, Object obj) {
        if ((i & 1) != 0) {
            commit = false;
        }
        lu.f($this$edit_u24default, "<this>");
        lu.f(action, "action");
        SharedPreferences.Editor editor = $this$edit_u24default.edit();
        lu.e(editor, "editor");
        action.invoke(editor);
        if (commit) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static final void edit(SharedPreferences $this$edit, boolean commit, vn<? super SharedPreferences.Editor, jt0> action) {
        lu.f($this$edit, "<this>");
        lu.f(action, "action");
        SharedPreferences.Editor editor = $this$edit.edit();
        lu.e(editor, "editor");
        action.invoke(editor);
        if (commit) {
            editor.commit();
        } else {
            editor.apply();
        }
    }
}
