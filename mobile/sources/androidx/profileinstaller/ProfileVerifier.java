package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.concurrent.futures.ResolvableFuture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

public final class ProfileVerifier {
    private static final String CUR_PROFILES_BASE_DIR = "/data/misc/profiles/cur/0/";
    private static final String PROFILE_FILE_NAME = "primary.prof";
    private static final String PROFILE_INSTALLED_CACHE_FILE_NAME = "profileInstalled";
    private static final String REF_PROFILES_BASE_DIR = "/data/misc/profiles/ref/";
    private static final Object SYNC_OBJ = new Object();
    private static final String TAG = "ProfileVerifier";
    @Nullable
    private static CompilationStatus sCompilationStatus = null;
    private static final ResolvableFuture<CompilationStatus> sFuture = ResolvableFuture.create();

    private ProfileVerifier() {
    }

    @WorkerThread
    @NonNull
    public static CompilationStatus writeProfileVerification(@NonNull Context context) {
        return writeProfileVerification(context, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c3 A[Catch:{ IOException -> 0x0089 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00cc A[Catch:{ IOException -> 0x0089 }] */
    @androidx.annotation.WorkerThread
    @androidx.annotation.NonNull
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static androidx.profileinstaller.ProfileVerifier.CompilationStatus writeProfileVerification(@androidx.annotation.NonNull android.content.Context r22, boolean r23) {
        /*
            if (r23 != 0) goto L_0x0007
            androidx.profileinstaller.ProfileVerifier$CompilationStatus r0 = sCompilationStatus
            if (r0 == 0) goto L_0x0007
            return r0
        L_0x0007:
            java.lang.Object r1 = SYNC_OBJ
            monitor-enter(r1)
            if (r23 != 0) goto L_0x0012
            androidx.profileinstaller.ProfileVerifier$CompilationStatus r0 = sCompilationStatus     // Catch:{ all -> 0x010f }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r1)     // Catch:{ all -> 0x010f }
            return r0
        L_0x0012:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x010f }
            r2 = 28
            r3 = 0
            if (r0 < r2) goto L_0x0107
            r2 = 30
            if (r0 != r2) goto L_0x001f
            goto L_0x0107
        L_0x001f:
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x010f }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x010f }
            java.lang.String r4 = "/data/misc/profiles/ref/"
            java.lang.String r5 = r22.getPackageName()     // Catch:{ all -> 0x010f }
            r2.<init>(r4, r5)     // Catch:{ all -> 0x010f }
            java.lang.String r4 = "primary.prof"
            r0.<init>(r2, r4)     // Catch:{ all -> 0x010f }
            r2 = r0
            long r4 = r2.length()     // Catch:{ all -> 0x010f }
            boolean r0 = r2.exists()     // Catch:{ all -> 0x010f }
            r6 = 0
            if (r0 == 0) goto L_0x0045
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0045
            r0 = 1
            goto L_0x0046
        L_0x0045:
            r0 = 0
        L_0x0046:
            r9 = r0
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x010f }
            java.io.File r10 = new java.io.File     // Catch:{ all -> 0x010f }
            java.lang.String r11 = "/data/misc/profiles/cur/0/"
            java.lang.String r12 = r22.getPackageName()     // Catch:{ all -> 0x010f }
            r10.<init>(r11, r12)     // Catch:{ all -> 0x010f }
            java.lang.String r11 = "primary.prof"
            r0.<init>(r10, r11)     // Catch:{ all -> 0x010f }
            r10 = r0
            long r11 = r10.length()     // Catch:{ all -> 0x010f }
            boolean r0 = r10.exists()     // Catch:{ all -> 0x010f }
            if (r0 == 0) goto L_0x006a
            int r0 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x006a
            r3 = 1
        L_0x006a:
            long r6 = getPackageLastUpdateTime(r22)     // Catch:{ NameNotFoundException -> 0x00f9 }
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x010f }
            java.io.File r13 = r22.getFilesDir()     // Catch:{ all -> 0x010f }
            java.lang.String r14 = "profileInstalled"
            r0.<init>(r13, r14)     // Catch:{ all -> 0x010f }
            r15 = r0
            r13 = 0
            boolean r0 = r15.exists()     // Catch:{ all -> 0x010f }
            if (r0 == 0) goto L_0x0094
            androidx.profileinstaller.ProfileVerifier$Cache r0 = androidx.profileinstaller.ProfileVerifier.Cache.readFromFile(r15)     // Catch:{ IOException -> 0x0089 }
            r13 = r0
            r14 = r13
            goto L_0x0095
        L_0x0089:
            r0 = move-exception
            r8 = r0
            r0 = r8
            r8 = 131072(0x20000, float:1.83671E-40)
            androidx.profileinstaller.ProfileVerifier$CompilationStatus r8 = setCompilationStatus(r8, r9, r3)     // Catch:{ all -> 0x010f }
            monitor-exit(r1)     // Catch:{ all -> 0x010f }
            return r8
        L_0x0094:
            r14 = r13
        L_0x0095:
            r0 = 2
            if (r14 == 0) goto L_0x00a7
            r20 = r9
            long r8 = r14.mPackageLastUpdateTime     // Catch:{ all -> 0x010f }
            int r16 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r16 != 0) goto L_0x00a9
            int r8 = r14.mResultCode     // Catch:{ all -> 0x010f }
            if (r8 != r0) goto L_0x00a5
            goto L_0x00a9
        L_0x00a5:
            goto L_0x00b2
        L_0x00a7:
            r20 = r9
        L_0x00a9:
            if (r20 == 0) goto L_0x00ad
            r8 = 1
            goto L_0x00b2
        L_0x00ad:
            if (r3 == 0) goto L_0x00b1
            r8 = 2
            goto L_0x00b2
        L_0x00b1:
            r8 = 0
        L_0x00b2:
            if (r23 == 0) goto L_0x00ba
            if (r3 == 0) goto L_0x00ba
            r9 = 1
            if (r8 == r9) goto L_0x00ba
            r8 = 2
        L_0x00ba:
            if (r14 == 0) goto L_0x00cc
            int r9 = r14.mResultCode     // Catch:{ all -> 0x010f }
            if (r9 != r0) goto L_0x00cc
            r0 = 1
            if (r8 != r0) goto L_0x00cc
            r0 = r8
            long r8 = r14.mInstalledCurrentProfileSize     // Catch:{ all -> 0x010f }
            int r13 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r13 >= 0) goto L_0x00cd
            r8 = 3
            goto L_0x00ce
        L_0x00cc:
            r0 = r8
        L_0x00cd:
            r8 = r0
        L_0x00ce:
            androidx.profileinstaller.ProfileVerifier$Cache r0 = new androidx.profileinstaller.ProfileVerifier$Cache     // Catch:{ all -> 0x010f }
            r9 = 1
            r13 = r0
            r21 = r2
            r2 = r14
            r14 = r9
            r9 = r15
            r15 = r8
            r16 = r6
            r18 = r11
            r13.<init>(r14, r15, r16, r18)     // Catch:{ all -> 0x010f }
            r13 = r0
            if (r2 == 0) goto L_0x00e8
            boolean r0 = r2.equals(r13)     // Catch:{ all -> 0x010f }
            if (r0 != 0) goto L_0x00f1
        L_0x00e8:
            r13.writeOnFile(r9)     // Catch:{ IOException -> 0x00ec }
            goto L_0x00f1
        L_0x00ec:
            r0 = move-exception
            r14 = r0
            r0 = r14
            r8 = 196608(0x30000, float:2.75506E-40)
        L_0x00f1:
            r14 = r20
            androidx.profileinstaller.ProfileVerifier$CompilationStatus r0 = setCompilationStatus(r8, r14, r3)     // Catch:{ all -> 0x010f }
            monitor-exit(r1)     // Catch:{ all -> 0x010f }
            return r0
        L_0x00f9:
            r0 = move-exception
            r21 = r2
            r14 = r9
            r2 = r0
            r0 = r2
            r2 = 65536(0x10000, float:9.18355E-41)
            androidx.profileinstaller.ProfileVerifier$CompilationStatus r2 = setCompilationStatus(r2, r14, r3)     // Catch:{ all -> 0x010f }
            monitor-exit(r1)     // Catch:{ all -> 0x010f }
            return r2
        L_0x0107:
            r0 = 262144(0x40000, float:3.67342E-40)
            androidx.profileinstaller.ProfileVerifier$CompilationStatus r0 = setCompilationStatus(r0, r3, r3)     // Catch:{ all -> 0x010f }
            monitor-exit(r1)     // Catch:{ all -> 0x010f }
            return r0
        L_0x010f:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x010f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.ProfileVerifier.writeProfileVerification(android.content.Context, boolean):androidx.profileinstaller.ProfileVerifier$CompilationStatus");
    }

    private static CompilationStatus setCompilationStatus(int resultCode, boolean hasReferenceProfile, boolean hasCurrentProfile) {
        CompilationStatus compilationStatus = new CompilationStatus(resultCode, hasReferenceProfile, hasCurrentProfile);
        sCompilationStatus = compilationStatus;
        sFuture.set(compilationStatus);
        return sCompilationStatus;
    }

    private static long getPackageLastUpdateTime(Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.getPackageInfo(packageManager, context).lastUpdateTime;
        }
        return packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    @NonNull
    public static ox<CompilationStatus> getCompilationStatusAsync() {
        return sFuture;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static class Cache {
        private static final int SCHEMA = 1;
        final long mInstalledCurrentProfileSize;
        final long mPackageLastUpdateTime;
        final int mResultCode;
        final int mSchema;

        Cache(int schema, int resultCode, long packageLastUpdateTime, long installedCurrentProfileSize) {
            this.mSchema = schema;
            this.mResultCode = resultCode;
            this.mPackageLastUpdateTime = packageLastUpdateTime;
            this.mInstalledCurrentProfileSize = installedCurrentProfileSize;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || !(o instanceof Cache)) {
                return false;
            }
            Cache cacheFile = (Cache) o;
            if (this.mResultCode == cacheFile.mResultCode && this.mPackageLastUpdateTime == cacheFile.mPackageLastUpdateTime && this.mSchema == cacheFile.mSchema && this.mInstalledCurrentProfileSize == cacheFile.mInstalledCurrentProfileSize) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.mResultCode), Long.valueOf(this.mPackageLastUpdateTime), Integer.valueOf(this.mSchema), Long.valueOf(this.mInstalledCurrentProfileSize)});
        }

        /* access modifiers changed from: package-private */
        public void writeOnFile(@NonNull File file) throws IOException {
            file.delete();
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
            try {
                dos.writeInt(this.mSchema);
                dos.writeInt(this.mResultCode);
                dos.writeLong(this.mPackageLastUpdateTime);
                dos.writeLong(this.mInstalledCurrentProfileSize);
                dos.close();
                return;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            throw th;
        }

        static Cache readFromFile(@NonNull File file) throws IOException {
            DataInputStream dis = new DataInputStream(new FileInputStream(file));
            try {
                Cache cache = new Cache(dis.readInt(), dis.readInt(), dis.readLong(), dis.readLong());
                dis.close();
                return cache;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            throw th;
        }
    }

    public static class CompilationStatus {
        public static final int RESULT_CODE_COMPILED_WITH_PROFILE = 1;
        public static final int RESULT_CODE_COMPILED_WITH_PROFILE_NON_MATCHING = 3;
        public static final int RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ = 131072;
        public static final int RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE = 196608;
        private static final int RESULT_CODE_ERROR_CODE_BIT_SHIFT = 16;
        public static final int RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST = 65536;
        public static final int RESULT_CODE_ERROR_UNSUPPORTED_API_VERSION = 262144;
        public static final int RESULT_CODE_NO_PROFILE = 0;
        public static final int RESULT_CODE_PROFILE_ENQUEUED_FOR_COMPILATION = 2;
        private final boolean mHasCurrentProfile;
        private final boolean mHasReferenceProfile;
        final int mResultCode;

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        @Retention(RetentionPolicy.SOURCE)
        public @interface ResultCode {
        }

        CompilationStatus(int resultCode, boolean hasReferenceProfile, boolean hasCurrentProfile) {
            this.mResultCode = resultCode;
            this.mHasCurrentProfile = hasCurrentProfile;
            this.mHasReferenceProfile = hasReferenceProfile;
        }

        public int getProfileInstallResultCode() {
            return this.mResultCode;
        }

        public boolean isCompiledWithProfile() {
            return this.mHasReferenceProfile;
        }

        public boolean hasProfileEnqueuedForCompilation() {
            return this.mHasCurrentProfile;
        }
    }

    @RequiresApi(33)
    private static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static PackageInfo getPackageInfo(PackageManager packageManager, Context context) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0));
        }
    }
}
