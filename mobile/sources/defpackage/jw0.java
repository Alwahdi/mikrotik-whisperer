package defpackage;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: jw0  reason: default package */
public abstract class jw0 {
    public static String e(Context context, Uri uri) {
        if (Build.VERSION.SDK_INT >= 19 && DocumentsContract.isDocumentUri(context, uri)) {
            int i = 0;
            if (g(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(split[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else if (f(uri)) {
                String id = DocumentsContract.getDocumentId(uri);
                if (id != null && id.startsWith("raw:")) {
                    return id.substring(4);
                }
                String[] contentUriPrefixesToTry = {"content://downloads/public_downloads", "content://downloads/my_downloads", "content://downloads/all_downloads"};
                int length = contentUriPrefixesToTry.length;
                while (i < length) {
                    try {
                        String path = b(context, ContentUris.withAppendedId(Uri.parse(contentUriPrefixesToTry[i]), Long.valueOf(id).longValue()), (String) null, (String[]) null);
                        if (path != null) {
                            return path;
                        }
                        i++;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                File file = a(d(context, uri), c(context));
                if (file == null) {
                    return null;
                }
                String destinationPath = file.getAbsolutePath();
                j(context, uri, destinationPath);
                return destinationPath;
            } else if (i(uri)) {
                String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                String type = split2[0];
                Uri contentUri = null;
                if ("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(type)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(type)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return b(context, contentUri, "_id=?", new String[]{split2[1]});
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            if (h(uri)) {
                return uri.getLastPathSegment();
            }
            return b(context, uri, (String) null, (String[]) null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    public static boolean g(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean f(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean i(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean h(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static String b(Context context, Uri uri, String selection, String[] selectionArgs) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, selection, selectionArgs, (String) null);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor == null) {
                    return null;
                }
                cursor.close();
                return null;
            }
            String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
            cursor.close();
            return string;
        } catch (Exception e) {
            e.printStackTrace();
            if (cursor == null) {
                return null;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static String d(Context context, Uri uri) {
        String type = context.getContentResolver().getType(uri);
        Cursor returnCursor = context.getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
        if (returnCursor == null) {
            return null;
        }
        int nameIndex = returnCursor.getColumnIndex("_display_name");
        returnCursor.moveToFirst();
        String filename = returnCursor.getString(nameIndex);
        returnCursor.close();
        return filename;
    }

    public static File c(Context context) {
        File dir = new File(context.getCacheDir(), "document");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }

    public static File a(String name, File directory) {
        if (name == null) {
            return null;
        }
        File file = new File(directory, name);
        if (file.exists()) {
            String fileName = name;
            String extension = "";
            int dotIndex = name.lastIndexOf(46);
            if (dotIndex > 0) {
                fileName = name.substring(0, dotIndex);
                extension = name.substring(dotIndex);
            }
            int index = 0;
            while (file.exists()) {
                index++;
                file = new File(directory, fileName + '(' + index + ')' + extension);
            }
        }
        try {
            if (!file.createNewFile()) {
                return null;
            }
            return file;
        } catch (IOException e) {
            return null;
        }
    }

    private static void j(Context context, Uri uri, String destinationPath) {
        InputStream is = null;
        BufferedOutputStream bos = null;
        try {
            InputStream is2 = context.getContentResolver().openInputStream(uri);
            BufferedOutputStream bos2 = new BufferedOutputStream(new FileOutputStream(destinationPath, false));
            byte[] buf = new byte[1024];
            is2.read(buf);
            do {
                bos2.write(buf);
            } while (is2.read(buf) != -1);
            try {
                is2.close();
                bos2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            if (is != null) {
                is.close();
            }
            if (bos != null) {
                bos.close();
            }
        } catch (Throwable th) {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                    throw th;
                }
            }
            if (bos != null) {
                bos.close();
            }
            throw th;
        }
    }
}
