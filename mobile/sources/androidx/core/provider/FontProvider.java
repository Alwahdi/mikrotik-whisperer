package androidx.core.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.http.HttpStatus;

class FontProvider {
    private static final Comparator<byte[]> sByteArrayComparator = a.a;

    private FontProvider() {
    }

    @NonNull
    static FontsContractCompat.FontFamilyResult getFontFamilyResult(@NonNull Context context, @NonNull FontRequest request, @Nullable CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfo = getProvider(context.getPackageManager(), request, context.getResources());
        if (providerInfo == null) {
            return FontsContractCompat.FontFamilyResult.create(1, (FontsContractCompat.FontInfo[]) null);
        }
        return FontsContractCompat.FontFamilyResult.create(0, query(context, request, providerInfo.authority, cancellationSignal));
    }

    @VisibleForTesting
    @Nullable
    static ProviderInfo getProvider(@NonNull PackageManager packageManager, @NonNull FontRequest request, @Nullable Resources resources) throws PackageManager.NameNotFoundException {
        String providerAuthority = request.getProviderAuthority();
        ProviderInfo info = packageManager.resolveContentProvider(providerAuthority, 0);
        if (info == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + providerAuthority);
        } else if (info.packageName.equals(request.getProviderPackage())) {
            List<byte[]> signatures = convertToByteArrayList(packageManager.getPackageInfo(info.packageName, 64).signatures);
            Collections.sort(signatures, sByteArrayComparator);
            List<List<byte[]>> requestCertificatesList = getCertificates(request, resources);
            for (int i = 0; i < requestCertificatesList.size(); i++) {
                List<byte[]> requestSignatures = new ArrayList<>(requestCertificatesList.get(i));
                Collections.sort(requestSignatures, sByteArrayComparator);
                if (equalsByteArrayList(signatures, requestSignatures)) {
                    return info;
                }
            }
            return null;
        } else {
            throw new PackageManager.NameNotFoundException("Found content provider " + providerAuthority + ", but package was not " + request.getProviderPackage());
        }
    }

    @VisibleForTesting
    @NonNull
    static FontsContractCompat.FontInfo[] query(Context context, FontRequest request, String authority, CancellationSignal cancellationSignal) {
        int i;
        String[] projection;
        Uri fileUri;
        Cursor cursor;
        String str = authority;
        ArrayList<FontsContractCompat.FontInfo> result = new ArrayList<>();
        Uri uri = new Uri.Builder().scheme("content").authority(str).build();
        Uri fileBaseUri = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        Cursor cursor2 = null;
        try {
            String[] projection2 = {"_id", FontsContractCompat.Columns.FILE_ID, FontsContractCompat.Columns.TTC_INDEX, FontsContractCompat.Columns.VARIATION_SETTINGS, FontsContractCompat.Columns.WEIGHT, FontsContractCompat.Columns.ITALIC, FontsContractCompat.Columns.RESULT_CODE};
            ContentResolver resolver = context.getContentResolver();
            int resultCode = 1;
            if (Build.VERSION.SDK_INT > 16) {
                cursor = Api16Impl.query(resolver, uri, projection2, "query = ?", new String[]{request.getQuery()}, (String) null, cancellationSignal);
            } else {
                cursor = resolver.query(uri, projection2, "query = ?", new String[]{request.getQuery()}, (String) null);
            }
            if (cursor2 == null || cursor2.getCount() <= 0) {
            } else {
                int ttcIndex = cursor2.getColumnIndex(FontsContractCompat.Columns.RESULT_CODE);
                result = new ArrayList<>();
                int idColumnIndex = cursor2.getColumnIndex("_id");
                int fileIdColumnIndex = cursor2.getColumnIndex(FontsContractCompat.Columns.FILE_ID);
                int ttcIndexColumnIndex = cursor2.getColumnIndex(FontsContractCompat.Columns.TTC_INDEX);
                int weightColumnIndex = cursor2.getColumnIndex(FontsContractCompat.Columns.WEIGHT);
                int italicColumnIndex = cursor2.getColumnIndex(FontsContractCompat.Columns.ITALIC);
                while (cursor2.moveToNext()) {
                    if (ttcIndex != -1) {
                        i = cursor2.getInt(ttcIndex);
                    } else {
                        i = 0;
                    }
                    int resultCode2 = i;
                    int ttcIndex2 = ttcIndexColumnIndex != -1 ? cursor2.getInt(ttcIndexColumnIndex) : 0;
                    if (fileIdColumnIndex == -1) {
                        projection = projection2;
                        fileUri = ContentUris.withAppendedId(uri, cursor2.getLong(idColumnIndex));
                    } else {
                        projection = projection2;
                        fileUri = ContentUris.withAppendedId(fileBaseUri, cursor2.getLong(fileIdColumnIndex));
                    }
                    int weight = weightColumnIndex != -1 ? cursor2.getInt(weightColumnIndex) : HttpStatus.SC_BAD_REQUEST;
                    boolean italic = italicColumnIndex != -1 && cursor2.getInt(italicColumnIndex) == resultCode;
                    int resultCode3 = resultCode2;
                    int resultCodeColumnIndex = ttcIndex;
                    result.add(FontsContractCompat.FontInfo.create(fileUri, ttcIndex2, weight, italic, resultCode3));
                    String str2 = authority;
                    projection2 = projection;
                    ttcIndex = resultCodeColumnIndex;
                    resultCode = 1;
                }
                int resultCodeColumnIndex2 = ttcIndex;
                String[] strArr = projection2;
            }
            return (FontsContractCompat.FontInfo[]) result.toArray(new FontsContractCompat.FontInfo[0]);
        } finally {
            if (cursor2 != null) {
                cursor2.close();
            }
        }
    }

    private static List<List<byte[]>> getCertificates(FontRequest request, Resources resources) {
        if (request.getCertificates() != null) {
            return request.getCertificates();
        }
        return FontResourcesParserCompat.readCerts(resources, request.getCertificatesArrayResId());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$0(byte[] l, byte[] r) {
        if (l.length != r.length) {
            return l.length - r.length;
        }
        for (int i = 0; i < l.length; i++) {
            if (l[i] != r[i]) {
                return l[i] - r[i];
            }
        }
        return 0;
    }

    private static boolean equalsByteArrayList(List<byte[]> signatures, List<byte[]> requestSignatures) {
        if (signatures.size() != requestSignatures.size()) {
            return false;
        }
        for (int i = 0; i < signatures.size(); i++) {
            if (!Arrays.equals(signatures.get(i), requestSignatures.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<byte[]> convertToByteArrayList(Signature[] signatures) {
        List<byte[]> shaList = new ArrayList<>();
        for (Signature signature : signatures) {
            shaList.add(signature.toByteArray());
        }
        return shaList;
    }

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static Cursor query(ContentResolver contentResolver, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, Object cancellationSignal) {
            return contentResolver.query(uri, projection, selection, selectionArgs, sortOrder, (CancellationSignal) cancellationSignal);
        }
    }
}
