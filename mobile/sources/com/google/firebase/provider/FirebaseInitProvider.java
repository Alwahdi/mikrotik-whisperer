package com.google.firebase.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public class FirebaseInitProvider extends ContentProvider {
    public void attachInfo(Context context, ProviderInfo info) {
        a(info);
        super.attachInfo(context, info);
    }

    public boolean onCreate() {
        if (gl.p(getContext()) == null) {
            Log.i("FirebaseInitProvider", "FirebaseApp initialization unsuccessful");
            return false;
        }
        Log.i("FirebaseInitProvider", "FirebaseApp initialization successful");
        return false;
    }

    private static void a(ProviderInfo info) {
        y90.k(info, "FirebaseInitProvider ProviderInfo cannot be null.");
        if ("com.google.firebase.firebaseinitprovider".equals(info.authority)) {
            throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
        }
    }

    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
