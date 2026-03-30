package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Display;
import android.view.DragEvent;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.os.BuildCompat;
import androidx.core.view.DragAndDropPermissionsCompat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ActivityCompat extends ContextCompat {
    private static PermissionCompatDelegate sDelegate;

    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    public interface PermissionCompatDelegate {
        boolean onActivityResult(@NonNull Activity activity, @IntRange(from = 0) int i, int i2, @Nullable Intent intent);

        boolean requestPermissions(@NonNull Activity activity, @NonNull String[] strArr, @IntRange(from = 0) int i);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int i);
    }

    protected ActivityCompat() {
    }

    public static void setPermissionCompatDelegate(@Nullable PermissionCompatDelegate delegate) {
        sDelegate = delegate;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static PermissionCompatDelegate getPermissionCompatDelegate() {
        return sDelegate;
    }

    @Deprecated
    public static boolean invalidateOptionsMenu(Activity activity) {
        activity.invalidateOptionsMenu();
        return true;
    }

    public static void startActivityForResult(@NonNull Activity activity, @NonNull Intent intent, int requestCode, @Nullable Bundle options) {
        if (Build.VERSION.SDK_INT >= 16) {
            Api16Impl.startActivityForResult(activity, intent, requestCode, options);
        } else {
            activity.startActivityForResult(intent, requestCode);
        }
    }

    public static void startIntentSenderForResult(@NonNull Activity activity, @NonNull IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, @Nullable Bundle options) throws IntentSender.SendIntentException {
        if (Build.VERSION.SDK_INT >= 16) {
            Api16Impl.startIntentSenderForResult(activity, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
        } else {
            activity.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
        }
    }

    public static void finishAffinity(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            Api16Impl.finishAffinity(activity);
        } else {
            activity.finish();
        }
    }

    public static void finishAfterTransition(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.finishAfterTransition(activity);
        } else {
            activity.finish();
        }
    }

    @Nullable
    public static Uri getReferrer(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 22) {
            return Api22Impl.getReferrer(activity);
        }
        Intent intent = activity.getIntent();
        Uri referrer = (Uri) intent.getParcelableExtra("android.intent.extra.REFERRER");
        if (referrer != null) {
            return referrer;
        }
        String referrerName = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (referrerName != null) {
            return Uri.parse(referrerName);
        }
        return null;
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull Activity activity, @IdRes int id) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (View) Api28Impl.requireViewById(activity, id);
        }
        T view = activity.findViewById(id);
        if (view != null) {
            return view;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Activity");
    }

    public static void setEnterSharedElementCallback(@NonNull Activity activity, @Nullable SharedElementCallback callback) {
        SharedElementCallback frameworkCallback;
        if (Build.VERSION.SDK_INT >= 21) {
            if (callback != null) {
                frameworkCallback = new SharedElementCallback21Impl(callback);
            } else {
                frameworkCallback = null;
            }
            Api21Impl.setEnterSharedElementCallback(activity, frameworkCallback);
        }
    }

    public static void setExitSharedElementCallback(@NonNull Activity activity, @Nullable SharedElementCallback callback) {
        SharedElementCallback frameworkCallback;
        if (Build.VERSION.SDK_INT >= 21) {
            if (callback != null) {
                frameworkCallback = new SharedElementCallback21Impl(callback);
            } else {
                frameworkCallback = null;
            }
            Api21Impl.setExitSharedElementCallback(activity, frameworkCallback);
        }
    }

    public static void postponeEnterTransition(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.postponeEnterTransition(activity);
        }
    }

    public static void startPostponedEnterTransition(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.startPostponedEnterTransition(activity);
        }
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static void requestPermissions(@NonNull final Activity activity, @NonNull String[] permissions, @IntRange(from = 0) final int requestCode) {
        PermissionCompatDelegate permissionCompatDelegate = sDelegate;
        if (permissionCompatDelegate == null || !permissionCompatDelegate.requestPermissions(activity, permissions, requestCode)) {
            Set<Integer> indicesOfPermissionsToRemove = new HashSet<>();
            int i = 0;
            while (i < permissions.length) {
                if (!TextUtils.isEmpty(permissions[i])) {
                    if (!BuildCompat.isAtLeastT() && TextUtils.equals(permissions[i], "android.permission.POST_NOTIFICATIONS")) {
                        indicesOfPermissionsToRemove.add(Integer.valueOf(i));
                    }
                    i++;
                } else {
                    throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(permissions) + " must not contain null or empty values");
                }
            }
            int numPermissionsToRemove = indicesOfPermissionsToRemove.size();
            final String[] permissionsArray = numPermissionsToRemove > 0 ? new String[(permissions.length - numPermissionsToRemove)] : permissions;
            if (numPermissionsToRemove > 0) {
                if (numPermissionsToRemove != permissions.length) {
                    int modifiedIndex = 0;
                    for (int i2 = 0; i2 < permissions.length; i2++) {
                        if (!indicesOfPermissionsToRemove.contains(Integer.valueOf(i2))) {
                            permissionsArray[modifiedIndex] = permissions[i2];
                            modifiedIndex++;
                        }
                    }
                } else {
                    return;
                }
            }
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity instanceof RequestPermissionsRequestCodeValidator) {
                    ((RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(requestCode);
                }
                Api23Impl.requestPermissions(activity, permissions, requestCode);
            } else if (activity instanceof OnRequestPermissionsResultCallback) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        int[] grantResults = new int[permissionsArray.length];
                        PackageManager packageManager = activity.getPackageManager();
                        String packageName = activity.getPackageName();
                        int permissionCount = permissionsArray.length;
                        for (int i = 0; i < permissionCount; i++) {
                            grantResults[i] = packageManager.checkPermission(permissionsArray[i], packageName);
                        }
                        ((OnRequestPermissionsResultCallback) activity).onRequestPermissionsResult(requestCode, permissionsArray, grantResults);
                    }
                });
            }
        }
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static boolean shouldShowRequestPermissionRationale(@NonNull Activity activity, @NonNull String permission) {
        if ((BuildCompat.isAtLeastT() || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", permission)) && Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.shouldShowRequestPermissionRationale(activity, permission);
        }
        return false;
    }

    public static boolean isLaunchedFromBubble(@NonNull Activity activity) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            return Api31Impl.isLaunchedFromBubble(activity);
        }
        if (i == 30) {
            if (Api30Impl.getDisplay(activity) == null || Api30Impl.getDisplay(activity).getDisplayId() == 0) {
                return false;
            }
            return true;
        } else if (i != 29 || activity.getWindowManager().getDefaultDisplay() == null || activity.getWindowManager().getDefaultDisplay().getDisplayId() == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Nullable
    public static DragAndDropPermissionsCompat requestDragAndDropPermissions(@NonNull Activity activity, @NonNull DragEvent dragEvent) {
        return DragAndDropPermissionsCompat.request(activity, dragEvent);
    }

    public static void recreate(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            new Handler(activity.getMainLooper()).post(new m0(activity));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$recreate$0(Activity activity) {
        if (!activity.isFinishing() && !ActivityRecreator.recreate(activity)) {
            activity.recreate();
        }
    }

    public static void setLocusContext(@NonNull Activity activity, @Nullable LocusIdCompat locusId, @Nullable Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.setLocusContext(activity, locusId, bundle);
        }
    }

    @RequiresApi(21)
    static class SharedElementCallback21Impl extends SharedElementCallback {
        private final SharedElementCallback mCallback;

        SharedElementCallback21Impl(SharedElementCallback callback) {
            this.mCallback = callback;
        }

        public void onSharedElementStart(List<String> sharedElementNames, List<View> sharedElements, List<View> sharedElementSnapshots) {
            this.mCallback.onSharedElementStart(sharedElementNames, sharedElements, sharedElementSnapshots);
        }

        public void onSharedElementEnd(List<String> sharedElementNames, List<View> sharedElements, List<View> sharedElementSnapshots) {
            this.mCallback.onSharedElementEnd(sharedElementNames, sharedElements, sharedElementSnapshots);
        }

        public void onRejectSharedElements(List<View> rejectedSharedElements) {
            this.mCallback.onRejectSharedElements(rejectedSharedElements);
        }

        public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
            this.mCallback.onMapSharedElements(names, sharedElements);
        }

        public Parcelable onCaptureSharedElementSnapshot(View sharedElement, Matrix viewToGlobalMatrix, RectF screenBounds) {
            return this.mCallback.onCaptureSharedElementSnapshot(sharedElement, viewToGlobalMatrix, screenBounds);
        }

        public View onCreateSnapshotView(Context context, Parcelable snapshot) {
            return this.mCallback.onCreateSnapshotView(context, snapshot);
        }

        @RequiresApi(23)
        public void onSharedElementsArrived(List<String> sharedElementNames, List<View> sharedElements, SharedElementCallback.OnSharedElementsReadyListener listener) {
            this.mCallback.onSharedElementsArrived(sharedElementNames, sharedElements, new a(listener));
        }
    }

    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static void setLocusContext(@NonNull Activity activity, @Nullable LocusIdCompat locusId, @Nullable Bundle bundle) {
            activity.setLocusContext(locusId == null ? null : locusId.toLocusId(), bundle);
        }

        @DoNotInline
        static Display getDisplay(ContextWrapper contextWrapper) {
            return contextWrapper.getDisplay();
        }
    }

    @RequiresApi(31)
    static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        static boolean isLaunchedFromBubble(@NonNull Activity activity) {
            return activity.isLaunchedFromBubble();
        }
    }

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static void startActivityForResult(Activity activity, Intent intent, int requestCode, Bundle options) {
            activity.startActivityForResult(intent, requestCode, options);
        }

        @DoNotInline
        static void startIntentSenderForResult(Activity activity, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
            activity.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
        }

        @DoNotInline
        static void finishAffinity(Activity activity) {
            activity.finishAffinity();
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static void finishAfterTransition(Activity activity) {
            activity.finishAfterTransition();
        }

        @DoNotInline
        static void setEnterSharedElementCallback(Activity activity, SharedElementCallback callback) {
            activity.setEnterSharedElementCallback(callback);
        }

        @DoNotInline
        static void setExitSharedElementCallback(Activity activity, SharedElementCallback callback) {
            activity.setExitSharedElementCallback(callback);
        }

        @DoNotInline
        static void postponeEnterTransition(Activity activity) {
            activity.postponeEnterTransition();
        }

        @DoNotInline
        static void startPostponedEnterTransition(Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }

    @RequiresApi(22)
    static class Api22Impl {
        private Api22Impl() {
        }

        @DoNotInline
        static Uri getReferrer(Activity activity) {
            return activity.getReferrer();
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static <T> T requireViewById(Activity activity, int id) {
            return activity.requireViewById(id);
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static void requestPermissions(Activity activity, String[] permissions, int requestCode) {
            activity.requestPermissions(permissions, requestCode);
        }

        @DoNotInline
        static boolean shouldShowRequestPermissionRationale(Activity activity, String permission) {
            return activity.shouldShowRequestPermissionRationale(permission);
        }

        /* access modifiers changed from: package-private */
        @DoNotInline
        public static void onSharedElementsReady(Object onSharedElementsReadyListener) {
            ((SharedElementCallback.OnSharedElementsReadyListener) onSharedElementsReadyListener).onSharedElementsReady();
        }
    }
}
