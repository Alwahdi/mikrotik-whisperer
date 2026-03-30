package androidx.core.app;

import android.app.PendingIntent;
import android.app.RemoteAction;
import android.graphics.drawable.Icon;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.VersionedParcelable;

public final class RemoteActionCompat implements VersionedParcelable {
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PendingIntent mActionIntent;
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CharSequence mContentDescription;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean mEnabled;
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public IconCompat mIcon;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean mShouldShowIcon;
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CharSequence mTitle;

    public RemoteActionCompat(@NonNull IconCompat icon, @NonNull CharSequence title, @NonNull CharSequence contentDescription, @NonNull PendingIntent intent) {
        this.mIcon = (IconCompat) Preconditions.checkNotNull(icon);
        this.mTitle = (CharSequence) Preconditions.checkNotNull(title);
        this.mContentDescription = (CharSequence) Preconditions.checkNotNull(contentDescription);
        this.mActionIntent = (PendingIntent) Preconditions.checkNotNull(intent);
        this.mEnabled = true;
        this.mShouldShowIcon = true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteActionCompat() {
    }

    public RemoteActionCompat(@NonNull RemoteActionCompat other) {
        Preconditions.checkNotNull(other);
        this.mIcon = other.mIcon;
        this.mTitle = other.mTitle;
        this.mContentDescription = other.mContentDescription;
        this.mActionIntent = other.mActionIntent;
        this.mEnabled = other.mEnabled;
        this.mShouldShowIcon = other.mShouldShowIcon;
    }

    @RequiresApi(26)
    @NonNull
    public static RemoteActionCompat createFromRemoteAction(@NonNull RemoteAction remoteAction) {
        Preconditions.checkNotNull(remoteAction);
        RemoteActionCompat action = new RemoteActionCompat(IconCompat.createFromIcon(Api26Impl.getIcon(remoteAction)), Api26Impl.getTitle(remoteAction), Api26Impl.getContentDescription(remoteAction), Api26Impl.getActionIntent(remoteAction));
        action.setEnabled(Api26Impl.isEnabled(remoteAction));
        if (Build.VERSION.SDK_INT >= 28) {
            action.setShouldShowIcon(Api28Impl.shouldShowIcon(remoteAction));
        }
        return action;
    }

    public void setEnabled(boolean enabled) {
        this.mEnabled = enabled;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void setShouldShowIcon(boolean shouldShowIcon) {
        this.mShouldShowIcon = shouldShowIcon;
    }

    public boolean shouldShowIcon() {
        return this.mShouldShowIcon;
    }

    @NonNull
    public IconCompat getIcon() {
        return this.mIcon;
    }

    @NonNull
    public CharSequence getTitle() {
        return this.mTitle;
    }

    @NonNull
    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    @NonNull
    public PendingIntent getActionIntent() {
        return this.mActionIntent;
    }

    @RequiresApi(26)
    @NonNull
    public RemoteAction toRemoteAction() {
        RemoteAction action = Api26Impl.createRemoteAction(this.mIcon.toIcon(), this.mTitle, this.mContentDescription, this.mActionIntent);
        Api26Impl.setEnabled(action, isEnabled());
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.setShouldShowIcon(action, shouldShowIcon());
        }
        return action;
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static boolean shouldShowIcon(RemoteAction remoteAction) {
            return remoteAction.shouldShowIcon();
        }

        @DoNotInline
        static void setShouldShowIcon(RemoteAction remoteAction, boolean shouldShowIcon) {
            remoteAction.setShouldShowIcon(shouldShowIcon);
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static CharSequence getContentDescription(RemoteAction remoteAction) {
            return remoteAction.getContentDescription();
        }

        @DoNotInline
        static PendingIntent getActionIntent(RemoteAction remoteAction) {
            return remoteAction.getActionIntent();
        }

        @DoNotInline
        static CharSequence getTitle(RemoteAction remoteAction) {
            return remoteAction.getTitle();
        }

        @DoNotInline
        static Icon getIcon(RemoteAction remoteAction) {
            return remoteAction.getIcon();
        }

        @DoNotInline
        static boolean isEnabled(RemoteAction remoteAction) {
            return remoteAction.isEnabled();
        }

        @DoNotInline
        static RemoteAction createRemoteAction(Icon icon, CharSequence title, CharSequence contentDescription, PendingIntent intent) {
            return new RemoteAction(icon, title, contentDescription, intent);
        }

        @DoNotInline
        static void setEnabled(RemoteAction remoteAction, boolean enabled) {
            remoteAction.setEnabled(enabled);
        }
    }
}
