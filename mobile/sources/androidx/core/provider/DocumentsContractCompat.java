package androidx.core.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.FileNotFoundException;
import java.util.List;

public final class DocumentsContractCompat {
    private static final String PATH_TREE = "tree";

    public static final class DocumentCompat {
        public static final int FLAG_VIRTUAL_DOCUMENT = 512;

        private DocumentCompat() {
        }
    }

    public static boolean isDocumentUri(@NonNull Context context, @Nullable Uri uri) {
        if (Build.VERSION.SDK_INT >= 19) {
            return DocumentsContractApi19Impl.isDocumentUri(context, uri);
        }
        return false;
    }

    public static boolean isTreeUri(@NonNull Uri uri) {
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
            return false;
        }
        if (i >= 24) {
            return DocumentsContractApi24Impl.isTreeUri(uri);
        }
        List<String> paths = uri.getPathSegments();
        if (paths.size() < 2 || !PATH_TREE.equals(paths.get(0))) {
            return false;
        }
        return true;
    }

    @Nullable
    public static String getDocumentId(@NonNull Uri documentUri) {
        if (Build.VERSION.SDK_INT >= 19) {
            return DocumentsContractApi19Impl.getDocumentId(documentUri);
        }
        return null;
    }

    @Nullable
    public static String getTreeDocumentId(@NonNull Uri documentUri) {
        if (Build.VERSION.SDK_INT >= 21) {
            return DocumentsContractApi21Impl.getTreeDocumentId(documentUri);
        }
        return null;
    }

    @Nullable
    public static Uri buildDocumentUri(@NonNull String authority, @NonNull String documentId) {
        if (Build.VERSION.SDK_INT >= 19) {
            return DocumentsContractApi19Impl.buildDocumentUri(authority, documentId);
        }
        return null;
    }

    @Nullable
    public static Uri buildDocumentUriUsingTree(@NonNull Uri treeUri, @NonNull String documentId) {
        if (Build.VERSION.SDK_INT >= 21) {
            return DocumentsContractApi21Impl.buildDocumentUriUsingTree(treeUri, documentId);
        }
        return null;
    }

    @Nullable
    public static Uri buildTreeDocumentUri(@NonNull String authority, @NonNull String documentId) {
        if (Build.VERSION.SDK_INT >= 21) {
            return DocumentsContractApi21Impl.buildTreeDocumentUri(authority, documentId);
        }
        return null;
    }

    @Nullable
    public static Uri buildChildDocumentsUri(@NonNull String authority, @Nullable String parentDocumentId) {
        if (Build.VERSION.SDK_INT >= 21) {
            return DocumentsContractApi21Impl.buildChildDocumentsUri(authority, parentDocumentId);
        }
        return null;
    }

    @Nullable
    public static Uri buildChildDocumentsUriUsingTree(@NonNull Uri treeUri, @NonNull String parentDocumentId) {
        if (Build.VERSION.SDK_INT >= 21) {
            return DocumentsContractApi21Impl.buildChildDocumentsUriUsingTree(treeUri, parentDocumentId);
        }
        return null;
    }

    @Nullable
    public static Uri createDocument(@NonNull ContentResolver content, @NonNull Uri parentDocumentUri, @NonNull String mimeType, @NonNull String displayName) throws FileNotFoundException {
        if (Build.VERSION.SDK_INT >= 21) {
            return DocumentsContractApi21Impl.createDocument(content, parentDocumentUri, mimeType, displayName);
        }
        return null;
    }

    @Nullable
    public static Uri renameDocument(@NonNull ContentResolver content, @NonNull Uri documentUri, @NonNull String displayName) throws FileNotFoundException {
        if (Build.VERSION.SDK_INT >= 21) {
            return DocumentsContractApi21Impl.renameDocument(content, documentUri, displayName);
        }
        return null;
    }

    public static boolean removeDocument(@NonNull ContentResolver content, @NonNull Uri documentUri, @NonNull Uri parentDocumentUri) throws FileNotFoundException {
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            return DocumentsContractApi24Impl.removeDocument(content, documentUri, parentDocumentUri);
        }
        if (i >= 19) {
            return DocumentsContractApi19Impl.deleteDocument(content, documentUri);
        }
        return false;
    }

    @RequiresApi(19)
    private static class DocumentsContractApi19Impl {
        @DoNotInline
        public static Uri buildDocumentUri(String authority, String documentId) {
            return DocumentsContract.buildDocumentUri(authority, documentId);
        }

        @DoNotInline
        static boolean isDocumentUri(Context context, @Nullable Uri uri) {
            return DocumentsContract.isDocumentUri(context, uri);
        }

        @DoNotInline
        static String getDocumentId(Uri documentUri) {
            return DocumentsContract.getDocumentId(documentUri);
        }

        @DoNotInline
        static boolean deleteDocument(ContentResolver content, Uri documentUri) throws FileNotFoundException {
            return DocumentsContract.deleteDocument(content, documentUri);
        }

        private DocumentsContractApi19Impl() {
        }
    }

    @RequiresApi(21)
    private static class DocumentsContractApi21Impl {
        @DoNotInline
        static String getTreeDocumentId(Uri documentUri) {
            return DocumentsContract.getTreeDocumentId(documentUri);
        }

        @DoNotInline
        public static Uri buildTreeDocumentUri(String authority, String documentId) {
            return DocumentsContract.buildTreeDocumentUri(authority, documentId);
        }

        @DoNotInline
        static Uri buildDocumentUriUsingTree(Uri treeUri, String documentId) {
            return DocumentsContract.buildDocumentUriUsingTree(treeUri, documentId);
        }

        @DoNotInline
        static Uri buildChildDocumentsUri(String authority, String parentDocumentId) {
            return DocumentsContract.buildChildDocumentsUri(authority, parentDocumentId);
        }

        @DoNotInline
        static Uri buildChildDocumentsUriUsingTree(Uri treeUri, String parentDocumentId) {
            return DocumentsContract.buildChildDocumentsUriUsingTree(treeUri, parentDocumentId);
        }

        @DoNotInline
        static Uri createDocument(ContentResolver content, Uri parentDocumentUri, String mimeType, String displayName) throws FileNotFoundException {
            return DocumentsContract.createDocument(content, parentDocumentUri, mimeType, displayName);
        }

        @DoNotInline
        static Uri renameDocument(@NonNull ContentResolver content, @NonNull Uri documentUri, @NonNull String displayName) throws FileNotFoundException {
            return DocumentsContract.renameDocument(content, documentUri, displayName);
        }

        private DocumentsContractApi21Impl() {
        }
    }

    @RequiresApi(24)
    private static class DocumentsContractApi24Impl {
        @DoNotInline
        static boolean isTreeUri(@NonNull Uri uri) {
            return DocumentsContract.isTreeUri(uri);
        }

        @DoNotInline
        static boolean removeDocument(ContentResolver content, Uri documentUri, Uri parentDocumentUri) throws FileNotFoundException {
            return DocumentsContract.removeDocument(content, documentUri, parentDocumentUri);
        }

        private DocumentsContractApi24Impl() {
        }
    }

    private DocumentsContractCompat() {
    }
}
