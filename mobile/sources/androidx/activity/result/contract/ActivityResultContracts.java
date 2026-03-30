package androidx.activity.result.contract;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.CallSuper;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public final class ActivityResultContracts {
    private ActivityResultContracts() {
    }

    public static final class StartActivityForResult extends ActivityResultContract<Intent, ActivityResult> {
        public static final Companion Companion = new Companion((Cif) null);
        public static final String EXTRA_ACTIVITY_OPTIONS_BUNDLE = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";

        public static final class Companion {
            public /* synthetic */ Companion(Cif ifVar) {
                this();
            }

            private Companion() {
            }
        }

        public Intent createIntent(Context context, Intent input) {
            lu.f(context, "context");
            lu.f(input, "input");
            return input;
        }

        public ActivityResult parseResult(int resultCode, Intent intent) {
            return new ActivityResult(resultCode, intent);
        }
    }

    public static final class StartIntentSenderForResult extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        public static final String ACTION_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.action.INTENT_SENDER_REQUEST";
        public static final Companion Companion = new Companion((Cif) null);
        public static final String EXTRA_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST";
        public static final String EXTRA_SEND_INTENT_EXCEPTION = "androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION";

        public static final class Companion {
            public /* synthetic */ Companion(Cif ifVar) {
                this();
            }

            private Companion() {
            }
        }

        public Intent createIntent(Context context, IntentSenderRequest input) {
            lu.f(context, "context");
            lu.f(input, "input");
            Intent putExtra = new Intent(ACTION_INTENT_SENDER_REQUEST).putExtra(EXTRA_INTENT_SENDER_REQUEST, input);
            lu.e(putExtra, "Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)");
            return putExtra;
        }

        public ActivityResult parseResult(int resultCode, Intent intent) {
            return new ActivityResult(resultCode, intent);
        }
    }

    public static final class RequestMultiplePermissions extends ActivityResultContract<String[], Map<String, Boolean>> {
        public static final String ACTION_REQUEST_PERMISSIONS = "androidx.activity.result.contract.action.REQUEST_PERMISSIONS";
        public static final Companion Companion = new Companion((Cif) null);
        public static final String EXTRA_PERMISSIONS = "androidx.activity.result.contract.extra.PERMISSIONS";
        public static final String EXTRA_PERMISSION_GRANT_RESULTS = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS";

        public static final class Companion {
            public /* synthetic */ Companion(Cif ifVar) {
                this();
            }

            private Companion() {
            }

            public final Intent createIntent$activity_release(String[] input) {
                lu.f(input, "input");
                Intent putExtra = new Intent(RequestMultiplePermissions.ACTION_REQUEST_PERMISSIONS).putExtra(RequestMultiplePermissions.EXTRA_PERMISSIONS, input);
                lu.e(putExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
                return putExtra;
            }
        }

        public Intent createIntent(Context context, String[] input) {
            lu.f(context, "context");
            lu.f(input, "input");
            return Companion.createIntent$activity_release(input);
        }

        public ActivityResultContract.SynchronousResult<Map<String, Boolean>> getSynchronousResult(Context context, String[] input) {
            boolean allGranted;
            Context context2 = context;
            String[] strArr = input;
            lu.f(context2, "context");
            lu.f(strArr, "input");
            if (strArr.length == 0) {
                return new ActivityResultContract.SynchronousResult<>(a00.d());
            }
            String[] strArr2 = input;
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    allGranted = true;
                    break;
                }
                if (!(ContextCompat.checkSelfPermission(context2, strArr2[i]) == 0)) {
                    allGranted = false;
                    break;
                }
                i++;
            }
            if (!allGranted) {
                return null;
            }
            String[] $this$associateTo$iv$iv = input;
            Map destination$iv$iv = new LinkedHashMap(hd0.a(zz.a($this$associateTo$iv$iv.length), 16));
            for (String element$iv$iv : $this$associateTo$iv$iv) {
                j50 a = ws0.a(element$iv$iv, true);
                destination$iv$iv.put(a.c(), a.d());
            }
            return new ActivityResultContract.SynchronousResult<>(destination$iv$iv);
        }

        public Map<String, Boolean> parseResult(int resultCode, Intent intent) {
            Intent intent2 = intent;
            if (resultCode != -1) {
                return a00.d();
            }
            if (intent2 == null) {
                return a00.d();
            }
            String[] permissions = intent2.getStringArrayExtra(EXTRA_PERMISSIONS);
            int[] grantResults = intent2.getIntArrayExtra(EXTRA_PERMISSION_GRANT_RESULTS);
            if (grantResults == null || permissions == null) {
                return a00.d();
            }
            int[] $this$map$iv = grantResults;
            List grantState = new ArrayList($this$map$iv.length);
            int[] $this$mapTo$iv$iv = $this$map$iv;
            int length = $this$mapTo$iv$iv.length;
            for (int i = 0; i < length; i++) {
                grantState.add(Boolean.valueOf($this$mapTo$iv$iv[i] == 0));
            }
            return a00.g(t9.s(l4.h(permissions), grantState));
        }
    }

    public static final class RequestPermission extends ActivityResultContract<String, Boolean> {
        public Intent createIntent(Context context, String input) {
            lu.f(context, "context");
            lu.f(input, "input");
            return RequestMultiplePermissions.Companion.createIntent$activity_release(new String[]{input});
        }

        public Boolean parseResult(int resultCode, Intent intent) {
            boolean z;
            boolean z2 = false;
            if (intent == null || resultCode != -1) {
                return false;
            }
            int[] grantResults = intent.getIntArrayExtra(RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS);
            if (grantResults != null) {
                int[] $this$any$iv = grantResults;
                int length = $this$any$iv.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    }
                    if (($this$any$iv[i] == 0 ? 1 : 0) != 0) {
                        z = true;
                        break;
                    }
                    i++;
                }
                if (z) {
                    z2 = true;
                }
            }
            return Boolean.valueOf(z2);
        }

        public ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context context, String input) {
            lu.f(context, "context");
            lu.f(input, "input");
            if (ContextCompat.checkSelfPermission(context, input) == 0) {
                return new ActivityResultContract.SynchronousResult<>(true);
            }
            return null;
        }
    }

    public static class TakePicturePreview extends ActivityResultContract<Void, Bitmap> {
        @CallSuper
        public Intent createIntent(Context context, Void input) {
            lu.f(context, "context");
            return new Intent("android.media.action.IMAGE_CAPTURE");
        }

        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(Context context, Void input) {
            lu.f(context, "context");
            return null;
        }

        public final Bitmap parseResult(int resultCode, Intent intent) {
            Intent intent2 = intent;
            Intent intent3 = resultCode == -1 ? intent : null;
            if (intent3 != null) {
                return (Bitmap) intent3.getParcelableExtra("data");
            }
            return null;
        }
    }

    public static class TakePicture extends ActivityResultContract<Uri, Boolean> {
        @CallSuper
        public Intent createIntent(Context context, Uri input) {
            lu.f(context, "context");
            lu.f(input, "input");
            Intent putExtra = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", input);
            lu.e(putExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return putExtra;
        }

        public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context context, Uri input) {
            lu.f(context, "context");
            lu.f(input, "input");
            return null;
        }

        public final Boolean parseResult(int resultCode, Intent intent) {
            return Boolean.valueOf(resultCode == -1);
        }
    }

    public static class TakeVideo extends ActivityResultContract<Uri, Bitmap> {
        @CallSuper
        public Intent createIntent(Context context, Uri input) {
            lu.f(context, "context");
            lu.f(input, "input");
            Intent putExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", input);
            lu.e(putExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return putExtra;
        }

        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(Context context, Uri input) {
            lu.f(context, "context");
            lu.f(input, "input");
            return null;
        }

        public final Bitmap parseResult(int resultCode, Intent intent) {
            Intent intent2 = intent;
            Intent intent3 = resultCode == -1 ? intent : null;
            if (intent3 != null) {
                return (Bitmap) intent3.getParcelableExtra("data");
            }
            return null;
        }
    }

    public static class CaptureVideo extends ActivityResultContract<Uri, Boolean> {
        @CallSuper
        public Intent createIntent(Context context, Uri input) {
            lu.f(context, "context");
            lu.f(input, "input");
            Intent putExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", input);
            lu.e(putExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return putExtra;
        }

        public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context context, Uri input) {
            lu.f(context, "context");
            lu.f(input, "input");
            return null;
        }

        public final Boolean parseResult(int resultCode, Intent intent) {
            return Boolean.valueOf(resultCode == -1);
        }
    }

    public static final class PickContact extends ActivityResultContract<Void, Uri> {
        public Intent createIntent(Context context, Void input) {
            lu.f(context, "context");
            Intent type = new Intent("android.intent.action.PICK").setType("vnd.android.cursor.dir/contact");
            lu.e(type, "Intent(Intent.ACTION_PIC…ct.Contacts.CONTENT_TYPE)");
            return type;
        }

        public Uri parseResult(int resultCode, Intent intent) {
            Intent intent2 = intent;
            Intent intent3 = resultCode == -1 ? intent : null;
            if (intent3 != null) {
                return intent3.getData();
            }
            return null;
        }
    }

    public static class GetContent extends ActivityResultContract<String, Uri> {
        @CallSuper
        public Intent createIntent(Context context, String input) {
            lu.f(context, "context");
            lu.f(input, "input");
            Intent type = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(input);
            lu.e(type, "Intent(Intent.ACTION_GET…          .setType(input)");
            return type;
        }

        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, String input) {
            lu.f(context, "context");
            lu.f(input, "input");
            return null;
        }

        public final Uri parseResult(int resultCode, Intent intent) {
            Intent intent2 = intent;
            Intent intent3 = resultCode == -1 ? intent : null;
            if (intent3 != null) {
                return intent3.getData();
            }
            return null;
        }
    }

    @RequiresApi(18)
    public static class GetMultipleContents extends ActivityResultContract<String, List<Uri>> {
        public static final Companion Companion = new Companion((Cif) null);

        @CallSuper
        public Intent createIntent(Context context, String input) {
            lu.f(context, "context");
            lu.f(input, "input");
            Intent putExtra = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(input).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            lu.e(putExtra, "Intent(Intent.ACTION_GET…TRA_ALLOW_MULTIPLE, true)");
            return putExtra;
        }

        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context context, String input) {
            lu.f(context, "context");
            lu.f(input, "input");
            return null;
        }

        public final List<Uri> parseResult(int resultCode, Intent intent) {
            List<Uri> clipDataUris$activity_release;
            Intent intent2 = intent;
            Intent intent3 = resultCode == -1 ? intent : null;
            if (intent3 == null || (clipDataUris$activity_release = Companion.getClipDataUris$activity_release(intent3)) == null) {
                return l9.d();
            }
            return clipDataUris$activity_release;
        }

        @RequiresApi(18)
        public static final class Companion {
            public /* synthetic */ Companion(Cif ifVar) {
                this();
            }

            private Companion() {
            }

            public final List<Uri> getClipDataUris$activity_release(Intent $this$getClipDataUris) {
                lu.f($this$getClipDataUris, "<this>");
                LinkedHashSet resultSet = new LinkedHashSet();
                Uri data = $this$getClipDataUris.getData();
                if (data != null) {
                    resultSet.add(data);
                }
                ClipData clipData = $this$getClipDataUris.getClipData();
                if (clipData == null && resultSet.isEmpty()) {
                    return l9.d();
                }
                if (clipData != null) {
                    int itemCount = clipData.getItemCount();
                    for (int i = 0; i < itemCount; i++) {
                        Uri uri = clipData.getItemAt(i).getUri();
                        if (uri != null) {
                            resultSet.add(uri);
                        }
                    }
                }
                return new ArrayList(resultSet);
            }
        }
    }

    @RequiresApi(19)
    public static class OpenDocument extends ActivityResultContract<String[], Uri> {
        @CallSuper
        public Intent createIntent(Context context, String[] input) {
            lu.f(context, "context");
            lu.f(input, "input");
            Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", input).setType("*/*");
            lu.e(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return type;
        }

        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, String[] input) {
            lu.f(context, "context");
            lu.f(input, "input");
            return null;
        }

        public final Uri parseResult(int resultCode, Intent intent) {
            Intent intent2 = intent;
            Intent intent3 = resultCode == -1 ? intent : null;
            if (intent3 != null) {
                return intent3.getData();
            }
            return null;
        }
    }

    @RequiresApi(19)
    public static class OpenMultipleDocuments extends ActivityResultContract<String[], List<Uri>> {
        @CallSuper
        public Intent createIntent(Context context, String[] input) {
            lu.f(context, "context");
            lu.f(input, "input");
            Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", input).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
            lu.e(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return type;
        }

        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context context, String[] input) {
            lu.f(context, "context");
            lu.f(input, "input");
            return null;
        }

        public final List<Uri> parseResult(int resultCode, Intent intent) {
            List<Uri> clipDataUris$activity_release;
            Intent intent2 = intent;
            Intent intent3 = resultCode == -1 ? intent : null;
            if (intent3 == null || (clipDataUris$activity_release = GetMultipleContents.Companion.getClipDataUris$activity_release(intent3)) == null) {
                return l9.d();
            }
            return clipDataUris$activity_release;
        }
    }

    @RequiresApi(21)
    public static class OpenDocumentTree extends ActivityResultContract<Uri, Uri> {
        @CallSuper
        public Intent createIntent(Context context, Uri input) {
            lu.f(context, "context");
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (Build.VERSION.SDK_INT >= 26 && input != null) {
                intent.putExtra("android.provider.extra.INITIAL_URI", input);
            }
            return intent;
        }

        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, Uri input) {
            lu.f(context, "context");
            return null;
        }

        public final Uri parseResult(int resultCode, Intent intent) {
            Intent intent2 = intent;
            Intent intent3 = resultCode == -1 ? intent : null;
            if (intent3 != null) {
                return intent3.getData();
            }
            return null;
        }
    }

    @RequiresApi(19)
    public static class CreateDocument extends ActivityResultContract<String, Uri> {
        private final String mimeType;

        public CreateDocument(String mimeType2) {
            lu.f(mimeType2, "mimeType");
            this.mimeType = mimeType2;
        }

        public CreateDocument() {
            this("*/*");
        }

        @CallSuper
        public Intent createIntent(Context context, String input) {
            lu.f(context, "context");
            lu.f(input, "input");
            Intent putExtra = new Intent("android.intent.action.CREATE_DOCUMENT").setType(this.mimeType).putExtra("android.intent.extra.TITLE", input);
            lu.e(putExtra, "Intent(Intent.ACTION_CRE…ntent.EXTRA_TITLE, input)");
            return putExtra;
        }

        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, String input) {
            lu.f(context, "context");
            lu.f(input, "input");
            return null;
        }

        public final Uri parseResult(int resultCode, Intent intent) {
            Intent intent2 = intent;
            Intent intent3 = resultCode == -1 ? intent : null;
            if (intent3 != null) {
                return intent3.getData();
            }
            return null;
        }
    }

    @RequiresApi(19)
    public static class PickVisualMedia extends ActivityResultContract<PickVisualMediaRequest, Uri> {
        public static final String ACTION_SYSTEM_FALLBACK_PICK_IMAGES = "androidx.activity.result.contract.action.PICK_IMAGES";
        public static final Companion Companion = new Companion((Cif) null);
        public static final String EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX = "androidx.activity.result.contract.extra.PICK_IMAGES_MAX";
        public static final String GMS_ACTION_PICK_IMAGES = "com.google.android.gms.provider.action.PICK_IMAGES";
        public static final String GMS_EXTRA_PICK_IMAGES_MAX = "com.google.android.gms.provider.extra.PICK_IMAGES_MAX";

        public interface VisualMediaType {
        }

        public static final ResolveInfo getGmsPicker$activity_release(Context context) {
            return Companion.getGmsPicker$activity_release(context);
        }

        public static final ResolveInfo getSystemFallbackPicker$activity_release(Context context) {
            return Companion.getSystemFallbackPicker$activity_release(context);
        }

        public static final boolean isGmsPickerAvailable$activity_release(Context context) {
            return Companion.isGmsPickerAvailable$activity_release(context);
        }

        public static final boolean isPhotoPickerAvailable() {
            return Companion.isPhotoPickerAvailable();
        }

        public static final boolean isPhotoPickerAvailable(Context context) {
            return Companion.isPhotoPickerAvailable(context);
        }

        public static final boolean isSystemFallbackPickerAvailable$activity_release(Context context) {
            return Companion.isSystemFallbackPickerAvailable$activity_release(context);
        }

        public static final boolean isSystemPickerAvailable$activity_release() {
            return Companion.isSystemPickerAvailable$activity_release();
        }

        public static final class Companion {
            public /* synthetic */ Companion(Cif ifVar) {
                this();
            }

            public static /* synthetic */ void getACTION_SYSTEM_FALLBACK_PICK_IMAGES$annotations() {
            }

            public static /* synthetic */ void getEXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX$annotations() {
            }

            private Companion() {
            }

            public final boolean isPhotoPickerAvailable() {
                return isSystemPickerAvailable$activity_release();
            }

            public final boolean isPhotoPickerAvailable(Context context) {
                lu.f(context, "context");
                return isSystemPickerAvailable$activity_release() || isSystemFallbackPickerAvailable$activity_release(context) || isGmsPickerAvailable$activity_release(context);
            }

            public final boolean isSystemPickerAvailable$activity_release() {
                int i = Build.VERSION.SDK_INT;
                if (i >= 33) {
                    return true;
                }
                if (i < 30 || SdkExtensions.getExtensionVersion(30) < 2) {
                    return false;
                }
                return true;
            }

            public final boolean isSystemFallbackPickerAvailable$activity_release(Context context) {
                lu.f(context, "context");
                return getSystemFallbackPicker$activity_release(context) != null;
            }

            public final ResolveInfo getSystemFallbackPicker$activity_release(Context context) {
                lu.f(context, "context");
                return context.getPackageManager().resolveActivity(new Intent(PickVisualMedia.ACTION_SYSTEM_FALLBACK_PICK_IMAGES), 1114112);
            }

            public final boolean isGmsPickerAvailable$activity_release(Context context) {
                lu.f(context, "context");
                return getGmsPicker$activity_release(context) != null;
            }

            public final ResolveInfo getGmsPicker$activity_release(Context context) {
                lu.f(context, "context");
                return context.getPackageManager().resolveActivity(new Intent(PickVisualMedia.GMS_ACTION_PICK_IMAGES), 1114112);
            }

            public final String getVisualMimeType$activity_release(VisualMediaType input) {
                lu.f(input, "input");
                if (input instanceof ImageOnly) {
                    return "image/*";
                }
                if (input instanceof VideoOnly) {
                    return "video/*";
                }
                if (input instanceof SingleMimeType) {
                    return ((SingleMimeType) input).getMimeType();
                }
                if (input instanceof ImageAndVideo) {
                    return null;
                }
                throw new j30();
            }
        }

        public static final class ImageOnly implements VisualMediaType {
            public static final ImageOnly INSTANCE = new ImageOnly();

            private ImageOnly() {
            }
        }

        public static final class VideoOnly implements VisualMediaType {
            public static final VideoOnly INSTANCE = new VideoOnly();

            private VideoOnly() {
            }
        }

        public static final class ImageAndVideo implements VisualMediaType {
            public static final ImageAndVideo INSTANCE = new ImageAndVideo();

            private ImageAndVideo() {
            }
        }

        public static final class SingleMimeType implements VisualMediaType {
            private final String mimeType;

            public SingleMimeType(String mimeType2) {
                lu.f(mimeType2, "mimeType");
                this.mimeType = mimeType2;
            }

            public final String getMimeType() {
                return this.mimeType;
            }
        }

        @CallSuper
        public Intent createIntent(Context context, PickVisualMediaRequest input) {
            lu.f(context, "context");
            lu.f(input, "input");
            Companion companion = Companion;
            if (companion.isSystemPickerAvailable$activity_release()) {
                Intent $this$createIntent_u24lambda_u240 = new Intent("android.provider.action.PICK_IMAGES");
                $this$createIntent_u24lambda_u240.setType(companion.getVisualMimeType$activity_release(input.getMediaType()));
                return $this$createIntent_u24lambda_u240;
            } else if (companion.isSystemFallbackPickerAvailable$activity_release(context)) {
                ResolveInfo systemFallbackPicker$activity_release = companion.getSystemFallbackPicker$activity_release(context);
                if (systemFallbackPicker$activity_release != null) {
                    ActivityInfo fallbackPicker = systemFallbackPicker$activity_release.activityInfo;
                    Intent intent = new Intent(ACTION_SYSTEM_FALLBACK_PICK_IMAGES);
                    Intent $this$createIntent_u24lambda_u241 = intent;
                    $this$createIntent_u24lambda_u241.setClassName(fallbackPicker.applicationInfo.packageName, fallbackPicker.name);
                    $this$createIntent_u24lambda_u241.setType(companion.getVisualMimeType$activity_release(input.getMediaType()));
                    return intent;
                }
                throw new IllegalStateException("Required value was null.".toString());
            } else if (companion.isGmsPickerAvailable$activity_release(context)) {
                ResolveInfo gmsPicker$activity_release = companion.getGmsPicker$activity_release(context);
                if (gmsPicker$activity_release != null) {
                    ActivityInfo gmsPicker = gmsPicker$activity_release.activityInfo;
                    Intent intent2 = new Intent(GMS_ACTION_PICK_IMAGES);
                    Intent $this$createIntent_u24lambda_u242 = intent2;
                    $this$createIntent_u24lambda_u242.setClassName(gmsPicker.applicationInfo.packageName, gmsPicker.name);
                    $this$createIntent_u24lambda_u242.setType(companion.getVisualMimeType$activity_release(input.getMediaType()));
                    return intent2;
                }
                throw new IllegalStateException("Required value was null.".toString());
            } else {
                Intent intent3 = new Intent("android.intent.action.OPEN_DOCUMENT");
                Intent $this$createIntent_u24lambda_u243 = intent3;
                $this$createIntent_u24lambda_u243.setType(companion.getVisualMimeType$activity_release(input.getMediaType()));
                if ($this$createIntent_u24lambda_u243.getType() != null) {
                    return intent3;
                }
                $this$createIntent_u24lambda_u243.setType("*/*");
                $this$createIntent_u24lambda_u243.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
                return intent3;
            }
        }

        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, PickVisualMediaRequest input) {
            lu.f(context, "context");
            lu.f(input, "input");
            return null;
        }

        public final Uri parseResult(int resultCode, Intent intent) {
            Intent intent2 = intent;
            Intent intent3 = resultCode == -1 ? intent : null;
            if (intent3 == null) {
                return null;
            }
            Intent $this$parseResult_u24lambda_u245 = intent3;
            Uri data = $this$parseResult_u24lambda_u245.getData();
            if (data == null) {
                data = (Uri) t9.l(GetMultipleContents.Companion.getClipDataUris$activity_release($this$parseResult_u24lambda_u245));
            }
            return data;
        }
    }

    @RequiresApi(19)
    public static class PickMultipleVisualMedia extends ActivityResultContract<PickVisualMediaRequest, List<Uri>> {
        public static final Companion Companion = new Companion((Cif) null);
        private final int maxItems;

        public PickMultipleVisualMedia() {
            this(0, 1, (Cif) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PickMultipleVisualMedia(int i, int i2, Cif ifVar) {
            this((i2 & 1) != 0 ? Companion.getMaxItems$activity_release() : i);
        }

        public PickMultipleVisualMedia(int maxItems2) {
            this.maxItems = maxItems2;
            if (!(maxItems2 <= 1 ? false : true)) {
                throw new IllegalArgumentException("Max items must be higher than 1".toString());
            }
        }

        @CallSuper
        public Intent createIntent(Context context, PickVisualMediaRequest input) {
            lu.f(context, "context");
            lu.f(input, "input");
            PickVisualMedia.Companion companion = PickVisualMedia.Companion;
            boolean z = true;
            if (companion.isSystemPickerAvailable$activity_release()) {
                Intent intent = new Intent("android.provider.action.PICK_IMAGES");
                Intent $this$createIntent_u24lambda_u242 = intent;
                $this$createIntent_u24lambda_u242.setType(companion.getVisualMimeType$activity_release(input.getMediaType()));
                if (this.maxItems > MediaStore.getPickImagesMaxLimit()) {
                    z = false;
                }
                if (z) {
                    $this$createIntent_u24lambda_u242.putExtra("android.provider.extra.PICK_IMAGES_MAX", this.maxItems);
                    return intent;
                }
                throw new IllegalArgumentException("Max items must be less or equals MediaStore.getPickImagesMaxLimit()".toString());
            } else if (companion.isSystemFallbackPickerAvailable$activity_release(context)) {
                ResolveInfo systemFallbackPicker$activity_release = companion.getSystemFallbackPicker$activity_release(context);
                if (systemFallbackPicker$activity_release != null) {
                    ActivityInfo fallbackPicker = systemFallbackPicker$activity_release.activityInfo;
                    Intent intent2 = new Intent(PickVisualMedia.ACTION_SYSTEM_FALLBACK_PICK_IMAGES);
                    Intent $this$createIntent_u24lambda_u243 = intent2;
                    $this$createIntent_u24lambda_u243.setClassName(fallbackPicker.applicationInfo.packageName, fallbackPicker.name);
                    $this$createIntent_u24lambda_u243.setType(companion.getVisualMimeType$activity_release(input.getMediaType()));
                    $this$createIntent_u24lambda_u243.putExtra(PickVisualMedia.GMS_EXTRA_PICK_IMAGES_MAX, this.maxItems);
                    return intent2;
                }
                throw new IllegalStateException("Required value was null.".toString());
            } else if (companion.isGmsPickerAvailable$activity_release(context)) {
                ResolveInfo gmsPicker$activity_release = companion.getGmsPicker$activity_release(context);
                if (gmsPicker$activity_release != null) {
                    ActivityInfo gmsPicker = gmsPicker$activity_release.activityInfo;
                    Intent intent3 = new Intent(PickVisualMedia.GMS_ACTION_PICK_IMAGES);
                    Intent $this$createIntent_u24lambda_u244 = intent3;
                    $this$createIntent_u24lambda_u244.setClassName(gmsPicker.applicationInfo.packageName, gmsPicker.name);
                    $this$createIntent_u24lambda_u244.putExtra(PickVisualMedia.GMS_EXTRA_PICK_IMAGES_MAX, this.maxItems);
                    return intent3;
                }
                throw new IllegalStateException("Required value was null.".toString());
            } else {
                Intent intent4 = new Intent("android.intent.action.OPEN_DOCUMENT");
                Intent $this$createIntent_u24lambda_u245 = intent4;
                $this$createIntent_u24lambda_u245.setType(companion.getVisualMimeType$activity_release(input.getMediaType()));
                $this$createIntent_u24lambda_u245.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                if ($this$createIntent_u24lambda_u245.getType() != null) {
                    return intent4;
                }
                $this$createIntent_u24lambda_u245.setType("*/*");
                $this$createIntent_u24lambda_u245.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
                return intent4;
            }
        }

        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context context, PickVisualMediaRequest input) {
            lu.f(context, "context");
            lu.f(input, "input");
            return null;
        }

        public final List<Uri> parseResult(int resultCode, Intent intent) {
            List<Uri> clipDataUris$activity_release;
            Intent intent2 = intent;
            Intent intent3 = resultCode == -1 ? intent : null;
            if (intent3 == null || (clipDataUris$activity_release = GetMultipleContents.Companion.getClipDataUris$activity_release(intent3)) == null) {
                return l9.d();
            }
            return clipDataUris$activity_release;
        }

        public static final class Companion {
            public /* synthetic */ Companion(Cif ifVar) {
                this();
            }

            private Companion() {
            }

            public final int getMaxItems$activity_release() {
                if (PickVisualMedia.Companion.isSystemPickerAvailable$activity_release()) {
                    return MediaStore.getPickImagesMaxLimit();
                }
                return Integer.MAX_VALUE;
            }
        }
    }
}
