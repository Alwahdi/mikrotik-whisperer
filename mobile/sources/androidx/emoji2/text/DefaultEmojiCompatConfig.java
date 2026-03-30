package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.provider.FontRequest;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DefaultEmojiCompatConfig {
    private DefaultEmojiCompatConfig() {
    }

    @Nullable
    public static FontRequestEmojiCompatConfig create(@NonNull Context context) {
        return (FontRequestEmojiCompatConfig) new DefaultEmojiCompatConfigFactory((DefaultEmojiCompatConfigHelper) null).create(context);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class DefaultEmojiCompatConfigFactory {
        @NonNull
        private static final String DEFAULT_EMOJI_QUERY = "emojicompat-emoji-font";
        @NonNull
        private static final String INTENT_LOAD_EMOJI_FONT = "androidx.content.action.LOAD_EMOJI_FONT";
        @NonNull
        private static final String TAG = "emoji2.text.DefaultEmojiConfig";
        private final DefaultEmojiCompatConfigHelper mHelper;

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public DefaultEmojiCompatConfigFactory(@Nullable DefaultEmojiCompatConfigHelper helper) {
            this.mHelper = helper != null ? helper : getHelperForApi();
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public EmojiCompat.Config create(@NonNull Context context) {
            return configOrNull(context, queryForDefaultFontRequest(context));
        }

        @Nullable
        private EmojiCompat.Config configOrNull(@NonNull Context context, @Nullable FontRequest fontRequest) {
            if (fontRequest == null) {
                return null;
            }
            return new FontRequestEmojiCompatConfig(context, fontRequest);
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public FontRequest queryForDefaultFontRequest(@NonNull Context context) {
            PackageManager packageManager = context.getPackageManager();
            Preconditions.checkNotNull(packageManager, "Package manager required to locate emoji font provider");
            ProviderInfo providerInfo = queryDefaultInstalledContentProvider(packageManager);
            if (providerInfo == null) {
                return null;
            }
            try {
                return generateFontRequestFrom(providerInfo, packageManager);
            } catch (PackageManager.NameNotFoundException e) {
                Log.wtf(TAG, e);
                return null;
            }
        }

        @Nullable
        private ProviderInfo queryDefaultInstalledContentProvider(@NonNull PackageManager packageManager) {
            for (ResolveInfo resolveInfo : this.mHelper.queryIntentContentProviders(packageManager, new Intent(INTENT_LOAD_EMOJI_FONT), 0)) {
                ProviderInfo providerInfo = this.mHelper.getProviderInfo(resolveInfo);
                if (hasFlagSystem(providerInfo)) {
                    return providerInfo;
                }
            }
            return null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
            r1 = r3.applicationInfo;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean hasFlagSystem(@androidx.annotation.Nullable android.content.pm.ProviderInfo r3) {
            /*
                r2 = this;
                r0 = 1
                if (r3 == 0) goto L_0x000d
                android.content.pm.ApplicationInfo r1 = r3.applicationInfo
                if (r1 == 0) goto L_0x000d
                int r1 = r1.flags
                r1 = r1 & r0
                if (r1 != r0) goto L_0x000d
                goto L_0x000e
            L_0x000d:
                r0 = 0
            L_0x000e:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory.hasFlagSystem(android.content.pm.ProviderInfo):boolean");
        }

        @NonNull
        private FontRequest generateFontRequestFrom(@NonNull ProviderInfo providerInfo, @NonNull PackageManager packageManager) throws PackageManager.NameNotFoundException {
            String providerAuthority = providerInfo.authority;
            String providerPackage = providerInfo.packageName;
            return new FontRequest(providerAuthority, providerPackage, DEFAULT_EMOJI_QUERY, convertToByteArray(this.mHelper.getSigningSignatures(packageManager, providerPackage)));
        }

        @NonNull
        private List<List<byte[]>> convertToByteArray(@NonNull Signature[] signatures) {
            List<byte[]> shaList = new ArrayList<>();
            for (Signature signature : signatures) {
                shaList.add(signature.toByteArray());
            }
            return Collections.singletonList(shaList);
        }

        @NonNull
        private static DefaultEmojiCompatConfigHelper getHelperForApi() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                return new DefaultEmojiCompatConfigHelper_API28();
            }
            if (i >= 19) {
                return new DefaultEmojiCompatConfigHelper_API19();
            }
            return new DefaultEmojiCompatConfigHelper();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class DefaultEmojiCompatConfigHelper {
        @NonNull
        public Signature[] getSigningSignatures(@NonNull PackageManager packageManager, @NonNull String providerPackage) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(providerPackage, 64).signatures;
        }

        @NonNull
        public List<ResolveInfo> queryIntentContentProviders(@NonNull PackageManager packageManager, @NonNull Intent intent, int flags) {
            return Collections.emptyList();
        }

        @Nullable
        public ProviderInfo getProviderInfo(@NonNull ResolveInfo resolveInfo) {
            throw new IllegalStateException("Unable to get provider info prior to API 19");
        }
    }

    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class DefaultEmojiCompatConfigHelper_API19 extends DefaultEmojiCompatConfigHelper {
        @NonNull
        public List<ResolveInfo> queryIntentContentProviders(@NonNull PackageManager packageManager, @NonNull Intent intent, int flags) {
            return packageManager.queryIntentContentProviders(intent, flags);
        }

        @Nullable
        public ProviderInfo getProviderInfo(@NonNull ResolveInfo resolveInfo) {
            return resolveInfo.providerInfo;
        }
    }

    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class DefaultEmojiCompatConfigHelper_API28 extends DefaultEmojiCompatConfigHelper_API19 {
        @NonNull
        public Signature[] getSigningSignatures(@NonNull PackageManager packageManager, @NonNull String providerPackage) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(providerPackage, 64).signatures;
        }
    }
}
