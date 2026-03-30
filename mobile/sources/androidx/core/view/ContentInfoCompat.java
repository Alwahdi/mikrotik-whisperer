package androidx.core.view;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.ContentInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.core.util.Predicate;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class ContentInfoCompat {
    public static final int FLAG_CONVERT_TO_PLAIN_TEXT = 1;
    public static final int SOURCE_APP = 0;
    public static final int SOURCE_AUTOFILL = 4;
    public static final int SOURCE_CLIPBOARD = 1;
    public static final int SOURCE_DRAG_AND_DROP = 3;
    public static final int SOURCE_INPUT_METHOD = 2;
    public static final int SOURCE_PROCESS_TEXT = 5;
    @NonNull
    private final Compat mCompat;

    private interface BuilderCompat {
        @NonNull
        ContentInfoCompat build();

        void setClip(@NonNull ClipData clipData);

        void setExtras(@Nullable Bundle bundle);

        void setFlags(int i);

        void setLinkUri(@Nullable Uri uri);

        void setSource(int i);
    }

    private interface Compat {
        @NonNull
        ClipData getClip();

        @Nullable
        Bundle getExtras();

        int getFlags();

        @Nullable
        Uri getLinkUri();

        int getSource();

        @Nullable
        ContentInfo getWrapped();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Source {
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static String sourceToString(int source) {
        switch (source) {
            case 0:
                return "SOURCE_APP";
            case 1:
                return "SOURCE_CLIPBOARD";
            case 2:
                return "SOURCE_INPUT_METHOD";
            case 3:
                return "SOURCE_DRAG_AND_DROP";
            case 4:
                return "SOURCE_AUTOFILL";
            case 5:
                return "SOURCE_PROCESS_TEXT";
            default:
                return String.valueOf(source);
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static String flagsToString(int flags) {
        if ((flags & 1) != 0) {
            return "FLAG_CONVERT_TO_PLAIN_TEXT";
        }
        return String.valueOf(flags);
    }

    ContentInfoCompat(@NonNull Compat compat) {
        this.mCompat = compat;
    }

    @RequiresApi(31)
    @NonNull
    public static ContentInfoCompat toContentInfoCompat(@NonNull ContentInfo platContentInfo) {
        return new ContentInfoCompat(new Compat31Impl(platContentInfo));
    }

    @RequiresApi(31)
    @NonNull
    public ContentInfo toContentInfo() {
        ContentInfo wrapped = this.mCompat.getWrapped();
        Objects.requireNonNull(wrapped);
        ContentInfo contentInfo = wrapped;
        return wrapped;
    }

    @NonNull
    public String toString() {
        return this.mCompat.toString();
    }

    @NonNull
    public ClipData getClip() {
        return this.mCompat.getClip();
    }

    public int getSource() {
        return this.mCompat.getSource();
    }

    public int getFlags() {
        return this.mCompat.getFlags();
    }

    @Nullable
    public Uri getLinkUri() {
        return this.mCompat.getLinkUri();
    }

    @Nullable
    public Bundle getExtras() {
        return this.mCompat.getExtras();
    }

    @NonNull
    public Pair<ContentInfoCompat, ContentInfoCompat> partition(@NonNull Predicate<ClipData.Item> itemPredicate) {
        ClipData clip = this.mCompat.getClip();
        ContentInfoCompat contentInfoCompat = null;
        if (clip.getItemCount() == 1) {
            boolean matched = itemPredicate.test(clip.getItemAt(0));
            ContentInfoCompat contentInfoCompat2 = matched ? this : null;
            if (!matched) {
                contentInfoCompat = this;
            }
            return Pair.create(contentInfoCompat2, contentInfoCompat);
        }
        Pair<ClipData, ClipData> split = partition(clip, itemPredicate);
        if (split.first == null) {
            return Pair.create((Object) null, this);
        }
        if (split.second == null) {
            return Pair.create(this, (Object) null);
        }
        return Pair.create(new Builder(this).setClip((ClipData) split.first).build(), new Builder(this).setClip((ClipData) split.second).build());
    }

    @NonNull
    static Pair<ClipData, ClipData> partition(@NonNull ClipData clip, @NonNull Predicate<ClipData.Item> itemPredicate) {
        ArrayList<ClipData.Item> acceptedItems = null;
        ArrayList<ClipData.Item> remainingItems = null;
        for (int i = 0; i < clip.getItemCount(); i++) {
            ClipData.Item item = clip.getItemAt(i);
            if (itemPredicate.test(item)) {
                acceptedItems = acceptedItems == null ? new ArrayList<>() : acceptedItems;
                acceptedItems.add(item);
            } else {
                remainingItems = remainingItems == null ? new ArrayList<>() : remainingItems;
                remainingItems.add(item);
            }
        }
        if (acceptedItems == null) {
            return Pair.create((Object) null, clip);
        }
        if (remainingItems == null) {
            return Pair.create(clip, (Object) null);
        }
        return Pair.create(buildClipData(clip.getDescription(), acceptedItems), buildClipData(clip.getDescription(), remainingItems));
    }

    @NonNull
    static ClipData buildClipData(@NonNull ClipDescription description, @NonNull List<ClipData.Item> items) {
        ClipData clip = new ClipData(new ClipDescription(description), items.get(0));
        for (int i = 1; i < items.size(); i++) {
            clip.addItem(items.get(i));
        }
        return clip;
    }

    @RequiresApi(31)
    @NonNull
    public static Pair<ContentInfo, ContentInfo> partition(@NonNull ContentInfo payload, @NonNull java.util.function.Predicate<ClipData.Item> itemPredicate) {
        return Api31Impl.partition(payload, itemPredicate);
    }

    @RequiresApi(31)
    private static final class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        @NonNull
        public static Pair<ContentInfo, ContentInfo> partition(@NonNull ContentInfo payload, @NonNull java.util.function.Predicate<ClipData.Item> itemPredicate) {
            ClipData clip = payload.getClip();
            ContentInfo contentInfo = null;
            if (clip.getItemCount() == 1) {
                boolean matched = itemPredicate.test(clip.getItemAt(0));
                ContentInfo contentInfo2 = matched ? payload : null;
                if (!matched) {
                    contentInfo = payload;
                }
                return Pair.create(contentInfo2, contentInfo);
            }
            Objects.requireNonNull(itemPredicate);
            Pair<ClipData, ClipData> split = ContentInfoCompat.partition(clip, (Predicate<ClipData.Item>) new kc(itemPredicate));
            if (split.first == null) {
                return Pair.create((Object) null, payload);
            }
            if (split.second == null) {
                return Pair.create(payload, (Object) null);
            }
            return Pair.create(new ContentInfo.Builder(payload).setClip((ClipData) split.first).build(), new ContentInfo.Builder(payload).setClip((ClipData) split.second).build());
        }
    }

    private static final class CompatImpl implements Compat {
        @NonNull
        private final ClipData mClip;
        @Nullable
        private final Bundle mExtras;
        private final int mFlags;
        @Nullable
        private final Uri mLinkUri;
        private final int mSource;

        CompatImpl(BuilderCompatImpl b) {
            this.mClip = (ClipData) Preconditions.checkNotNull(b.mClip);
            this.mSource = Preconditions.checkArgumentInRange(b.mSource, 0, 5, "source");
            this.mFlags = Preconditions.checkFlagsArgument(b.mFlags, 1);
            this.mLinkUri = b.mLinkUri;
            this.mExtras = b.mExtras;
        }

        @Nullable
        public ContentInfo getWrapped() {
            return null;
        }

        @NonNull
        public ClipData getClip() {
            return this.mClip;
        }

        public int getSource() {
            return this.mSource;
        }

        public int getFlags() {
            return this.mFlags;
        }

        @Nullable
        public Uri getLinkUri() {
            return this.mLinkUri;
        }

        @Nullable
        public Bundle getExtras() {
            return this.mExtras;
        }

        @NonNull
        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("ContentInfoCompat{clip=");
            sb.append(this.mClip.getDescription());
            sb.append(", source=");
            sb.append(ContentInfoCompat.sourceToString(this.mSource));
            sb.append(", flags=");
            sb.append(ContentInfoCompat.flagsToString(this.mFlags));
            String str2 = "";
            if (this.mLinkUri == null) {
                str = str2;
            } else {
                str = ", hasLinkUri(" + this.mLinkUri.toString().length() + ")";
            }
            sb.append(str);
            if (this.mExtras != null) {
                str2 = ", hasExtras";
            }
            sb.append(str2);
            sb.append("}");
            return sb.toString();
        }
    }

    @RequiresApi(31)
    private static final class Compat31Impl implements Compat {
        @NonNull
        private final ContentInfo mWrapped;

        Compat31Impl(@NonNull ContentInfo wrapped) {
            this.mWrapped = (ContentInfo) Preconditions.checkNotNull(wrapped);
        }

        @NonNull
        public ContentInfo getWrapped() {
            return this.mWrapped;
        }

        @NonNull
        public ClipData getClip() {
            return this.mWrapped.getClip();
        }

        public int getSource() {
            return this.mWrapped.getSource();
        }

        public int getFlags() {
            return this.mWrapped.getFlags();
        }

        @Nullable
        public Uri getLinkUri() {
            return this.mWrapped.getLinkUri();
        }

        @Nullable
        public Bundle getExtras() {
            return this.mWrapped.getExtras();
        }

        @NonNull
        public String toString() {
            return "ContentInfoCompat{" + this.mWrapped + "}";
        }
    }

    public static final class Builder {
        @NonNull
        private final BuilderCompat mBuilderCompat;

        public Builder(@NonNull ContentInfoCompat other) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.mBuilderCompat = new BuilderCompat31Impl(other);
            } else {
                this.mBuilderCompat = new BuilderCompatImpl(other);
            }
        }

        public Builder(@NonNull ClipData clip, int source) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.mBuilderCompat = new BuilderCompat31Impl(clip, source);
            } else {
                this.mBuilderCompat = new BuilderCompatImpl(clip, source);
            }
        }

        @NonNull
        public Builder setClip(@NonNull ClipData clip) {
            this.mBuilderCompat.setClip(clip);
            return this;
        }

        @NonNull
        public Builder setSource(int source) {
            this.mBuilderCompat.setSource(source);
            return this;
        }

        @NonNull
        public Builder setFlags(int flags) {
            this.mBuilderCompat.setFlags(flags);
            return this;
        }

        @NonNull
        public Builder setLinkUri(@Nullable Uri linkUri) {
            this.mBuilderCompat.setLinkUri(linkUri);
            return this;
        }

        @NonNull
        public Builder setExtras(@Nullable Bundle extras) {
            this.mBuilderCompat.setExtras(extras);
            return this;
        }

        @NonNull
        public ContentInfoCompat build() {
            return this.mBuilderCompat.build();
        }
    }

    private static final class BuilderCompatImpl implements BuilderCompat {
        @NonNull
        ClipData mClip;
        @Nullable
        Bundle mExtras;
        int mFlags;
        @Nullable
        Uri mLinkUri;
        int mSource;

        BuilderCompatImpl(@NonNull ClipData clip, int source) {
            this.mClip = clip;
            this.mSource = source;
        }

        BuilderCompatImpl(@NonNull ContentInfoCompat other) {
            this.mClip = other.getClip();
            this.mSource = other.getSource();
            this.mFlags = other.getFlags();
            this.mLinkUri = other.getLinkUri();
            this.mExtras = other.getExtras();
        }

        public void setClip(@NonNull ClipData clip) {
            this.mClip = clip;
        }

        public void setSource(int source) {
            this.mSource = source;
        }

        public void setFlags(int flags) {
            this.mFlags = flags;
        }

        public void setLinkUri(@Nullable Uri linkUri) {
            this.mLinkUri = linkUri;
        }

        public void setExtras(@Nullable Bundle extras) {
            this.mExtras = extras;
        }

        @NonNull
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new CompatImpl(this));
        }
    }

    @RequiresApi(31)
    private static final class BuilderCompat31Impl implements BuilderCompat {
        @NonNull
        private final ContentInfo.Builder mPlatformBuilder;

        BuilderCompat31Impl(@NonNull ClipData clip, int source) {
            this.mPlatformBuilder = new ContentInfo.Builder(clip, source);
        }

        BuilderCompat31Impl(@NonNull ContentInfoCompat other) {
            this.mPlatformBuilder = new ContentInfo.Builder(other.toContentInfo());
        }

        public void setClip(@NonNull ClipData clip) {
            this.mPlatformBuilder.setClip(clip);
        }

        public void setSource(int source) {
            this.mPlatformBuilder.setSource(source);
        }

        public void setFlags(int flags) {
            this.mPlatformBuilder.setFlags(flags);
        }

        public void setLinkUri(@Nullable Uri linkUri) {
            this.mPlatformBuilder.setLinkUri(linkUri);
        }

        public void setExtras(@Nullable Bundle extras) {
            this.mPlatformBuilder.setExtras(extras);
        }

        @NonNull
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new Compat31Impl(this.mPlatformBuilder.build()));
        }
    }
}
