package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public final class NavUtils {
    public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
    private static final String TAG = "NavUtils";

    public static boolean shouldUpRecreateTask(@NonNull Activity sourceActivity, @NonNull Intent targetIntent) {
        if (Build.VERSION.SDK_INT >= 16) {
            return Api16Impl.shouldUpRecreateTask(sourceActivity, targetIntent);
        }
        String action = sourceActivity.getIntent().getAction();
        return action != null && !action.equals("android.intent.action.MAIN");
    }

    public static void navigateUpFromSameTask(@NonNull Activity sourceActivity) {
        Intent upIntent = getParentActivityIntent(sourceActivity);
        if (upIntent != null) {
            navigateUpTo(sourceActivity, upIntent);
            return;
        }
        throw new IllegalArgumentException("Activity " + sourceActivity.getClass().getSimpleName() + " does not have a parent activity name specified. (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data>  element in your manifest?)");
    }

    public static void navigateUpTo(@NonNull Activity sourceActivity, @NonNull Intent upIntent) {
        if (Build.VERSION.SDK_INT >= 16) {
            Api16Impl.navigateUpTo(sourceActivity, upIntent);
            return;
        }
        upIntent.addFlags(67108864);
        sourceActivity.startActivity(upIntent);
        sourceActivity.finish();
    }

    @Nullable
    public static Intent getParentActivityIntent(@NonNull Activity sourceActivity) {
        Intent result;
        if (Build.VERSION.SDK_INT >= 16 && (result = Api16Impl.getParentActivityIntent(sourceActivity)) != null) {
            return result;
        }
        String parentName = getParentActivityName(sourceActivity);
        if (parentName == null) {
            return null;
        }
        ComponentName target = new ComponentName(sourceActivity, parentName);
        try {
            if (getParentActivityName(sourceActivity, target) == null) {
                return Intent.makeMainActivity(target);
            }
            return new Intent().setComponent(target);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "getParentActivityIntent: bad parentActivityName '" + parentName + "' in manifest");
            return null;
        }
    }

    @Nullable
    public static Intent getParentActivityIntent(@NonNull Context context, @NonNull Class<?> sourceActivityClass) throws PackageManager.NameNotFoundException {
        String parentActivity = getParentActivityName(context, new ComponentName(context, sourceActivityClass));
        if (parentActivity == null) {
            return null;
        }
        ComponentName target = new ComponentName(context, parentActivity);
        if (getParentActivityName(context, target) == null) {
            return Intent.makeMainActivity(target);
        }
        return new Intent().setComponent(target);
    }

    @Nullable
    public static Intent getParentActivityIntent(@NonNull Context context, @NonNull ComponentName componentName) throws PackageManager.NameNotFoundException {
        String parentActivity = getParentActivityName(context, componentName);
        if (parentActivity == null) {
            return null;
        }
        ComponentName target = new ComponentName(componentName.getPackageName(), parentActivity);
        if (getParentActivityName(context, target) == null) {
            return Intent.makeMainActivity(target);
        }
        return new Intent().setComponent(target);
    }

    @Nullable
    public static String getParentActivityName(@NonNull Activity sourceActivity) {
        try {
            return getParentActivityName(sourceActivity, sourceActivity.getComponentName());
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Nullable
    public static String getParentActivityName(@NonNull Context context, @NonNull ComponentName componentName) throws PackageManager.NameNotFoundException {
        int flags;
        String parentActivity;
        String result;
        PackageManager pm = context.getPackageManager();
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            flags = 128 | 512;
        } else {
            flags = 128 | 512;
        }
        if (i >= 29) {
            flags |= 269221888;
        } else if (i >= 24) {
            flags |= 786432;
        }
        ActivityInfo info = pm.getActivityInfo(componentName, flags);
        if (i >= 16 && (result = info.parentActivityName) != null) {
            return result;
        }
        Bundle bundle = info.metaData;
        if (bundle == null || (parentActivity = bundle.getString(PARENT_ACTIVITY)) == null) {
            return null;
        }
        if (parentActivity.charAt(0) != '.') {
            return parentActivity;
        }
        return context.getPackageName() + parentActivity;
    }

    private NavUtils() {
    }

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static boolean shouldUpRecreateTask(Activity activity, Intent targetIntent) {
            return activity.shouldUpRecreateTask(targetIntent);
        }

        @DoNotInline
        static boolean navigateUpTo(Activity activity, Intent upIntent) {
            return activity.navigateUpTo(upIntent);
        }

        @DoNotInline
        static Intent getParentActivityIntent(Activity activity) {
            return activity.getParentActivityIntent();
        }
    }
}
