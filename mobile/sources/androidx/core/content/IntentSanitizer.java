package androidx.core.content;

import android.content.ClipData;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import androidx.core.util.Predicate;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class IntentSanitizer {
    private static final String TAG = "IntentSanitizer";
    /* access modifiers changed from: private */
    public boolean mAllowAnyComponent;
    /* access modifiers changed from: private */
    public boolean mAllowClipDataText;
    /* access modifiers changed from: private */
    public boolean mAllowIdentifier;
    /* access modifiers changed from: private */
    public boolean mAllowSelector;
    /* access modifiers changed from: private */
    public boolean mAllowSourceBounds;
    /* access modifiers changed from: private */
    public Predicate<String> mAllowedActions;
    /* access modifiers changed from: private */
    public Predicate<String> mAllowedCategories;
    /* access modifiers changed from: private */
    public Predicate<ClipData> mAllowedClipData;
    /* access modifiers changed from: private */
    public Predicate<Uri> mAllowedClipDataUri;
    /* access modifiers changed from: private */
    public Predicate<ComponentName> mAllowedComponents;
    /* access modifiers changed from: private */
    public Predicate<Uri> mAllowedData;
    /* access modifiers changed from: private */
    public Map<String, Predicate<Object>> mAllowedExtras;
    /* access modifiers changed from: private */
    public int mAllowedFlags;
    /* access modifiers changed from: private */
    public Predicate<String> mAllowedPackages;
    /* access modifiers changed from: private */
    public Predicate<String> mAllowedTypes;

    private IntentSanitizer() {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$sanitizeByFiltering$0(String msg) {
    }

    @NonNull
    public Intent sanitizeByFiltering(@NonNull Intent in) {
        return sanitize(in, gt.a);
    }

    @NonNull
    public Intent sanitizeByThrowing(@NonNull Intent in) {
        return sanitize(in, ft.a);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$sanitizeByThrowing$1(String msg) {
        throw new SecurityException(msg);
    }

    @NonNull
    public Intent sanitize(@NonNull Intent in, @NonNull Consumer<String> penalty) {
        int i;
        Consumer<String> consumer = penalty;
        Intent intent = new Intent();
        ComponentName componentName = in.getComponent();
        if ((!this.mAllowAnyComponent || componentName != null) && !this.mAllowedComponents.test(componentName)) {
            consumer.accept("Component is not allowed: " + componentName);
            intent.setComponent(new ComponentName("android", "java.lang.Void"));
        } else {
            intent.setComponent(componentName);
        }
        String packageName = in.getPackage();
        if (packageName == null || this.mAllowedPackages.test(packageName)) {
            intent.setPackage(packageName);
        } else {
            consumer.accept("Package is not allowed: " + packageName);
        }
        int flags = this.mAllowedFlags | in.getFlags();
        int i2 = this.mAllowedFlags;
        if (flags == i2) {
            intent.setFlags(in.getFlags());
        } else {
            intent.setFlags(in.getFlags() & i2);
            consumer.accept("The intent contains flags that are not allowed: 0x" + Integer.toHexString(in.getFlags() & (~this.mAllowedFlags)));
        }
        String action = in.getAction();
        if (action == null || this.mAllowedActions.test(action)) {
            intent.setAction(action);
        } else {
            consumer.accept("Action is not allowed: " + action);
        }
        Uri data = in.getData();
        if (data == null || this.mAllowedData.test(data)) {
            intent.setData(data);
        } else {
            consumer.accept("Data is not allowed: " + data);
        }
        String type = in.getType();
        if (type == null || this.mAllowedTypes.test(type)) {
            intent.setDataAndType(intent.getData(), type);
        } else {
            consumer.accept("Type is not allowed: " + type);
        }
        Set<String> categories = in.getCategories();
        if (categories != null) {
            for (String category : categories) {
                if (this.mAllowedCategories.test(category)) {
                    intent.addCategory(category);
                } else {
                    consumer.accept("Category is not allowed: " + category);
                }
            }
        }
        Bundle extras = in.getExtras();
        if (extras != null) {
            for (String key : extras.keySet()) {
                if (key.equals("android.intent.extra.STREAM") && (this.mAllowedFlags & 1) == 0) {
                    consumer.accept("Allowing Extra Stream requires also allowing at least  FLAG_GRANT_READ_URI_PERMISSION Flag.");
                } else if (!key.equals("output") || ((~this.mAllowedFlags) & 3) == 0) {
                    Object value = extras.get(key);
                    Predicate<Object> test = this.mAllowedExtras.get(key);
                    if (test == null || !test.test(value)) {
                        consumer.accept("Extra is not allowed. Key: " + key + ". Value: " + value);
                    } else {
                        putExtra(intent, key, value);
                    }
                } else {
                    consumer.accept("Allowing Extra Output requires also allowing FLAG_GRANT_READ_URI_PERMISSION and FLAG_GRANT_WRITE_URI_PERMISSION Flags.");
                }
            }
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 16) {
            ComponentName componentName2 = componentName;
            i = i3;
            Api16Impl.sanitizeClipData(in, intent, this.mAllowedClipData, this.mAllowClipDataText, this.mAllowedClipDataUri, penalty);
        } else {
            i = i3;
        }
        if (i >= 29) {
            if (this.mAllowIdentifier) {
                Api29Impl.setIdentifier(intent, Api29Impl.getIdentifier(in));
            } else if (Api29Impl.getIdentifier(in) != null) {
                consumer.accept("Identifier is not allowed: " + Api29Impl.getIdentifier(in));
            }
        }
        if (i >= 15) {
            if (this.mAllowSelector) {
                Api15Impl.setSelector(intent, Api15Impl.getSelector(in));
            } else if (Api15Impl.getSelector(in) != null) {
                consumer.accept("Selector is not allowed: " + Api15Impl.getSelector(in));
            }
        }
        if (this.mAllowSourceBounds) {
            intent.setSourceBounds(in.getSourceBounds());
        } else if (in.getSourceBounds() != null) {
            consumer.accept("SourceBounds is not allowed: " + in.getSourceBounds());
        }
        return intent;
    }

    private void putExtra(Intent intent, String key, Object value) {
        if (value == null) {
            intent.getExtras().putString(key, (String) null);
        } else if (value instanceof Parcelable) {
            intent.putExtra(key, (Parcelable) value);
        } else if (value instanceof Parcelable[]) {
            intent.putExtra(key, (Parcelable[]) value);
        } else if (value instanceof Serializable) {
            intent.putExtra(key, (Serializable) value);
        } else {
            throw new IllegalArgumentException("Unsupported type " + value.getClass());
        }
    }

    public static final class Builder {
        private static final int HISTORY_STACK_FLAGS = 2112614400;
        private static final int RECEIVER_FLAGS = 2015363072;
        private boolean mAllowAnyComponent;
        private boolean mAllowClipDataText = false;
        private boolean mAllowIdentifier;
        private boolean mAllowSelector;
        private boolean mAllowSomeComponents;
        private boolean mAllowSourceBounds;
        private Predicate<String> mAllowedActions = mt.a;
        private Predicate<String> mAllowedCategories = ot.a;
        private Predicate<ClipData> mAllowedClipData = yt.a;
        private Predicate<Uri> mAllowedClipDataUri = jt.a;
        private Predicate<ComponentName> mAllowedComponents = it.a;
        private Predicate<Uri> mAllowedData = kt.a;
        private Map<String, Predicate<Object>> mAllowedExtras = new HashMap();
        private int mAllowedFlags;
        private Predicate<String> mAllowedPackages = nt.a;
        private Predicate<String> mAllowedTypes = lt.a;

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$0(String v) {
            return false;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$1(Uri v) {
            return false;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$2(String v) {
            return false;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$3(String v) {
            return false;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$4(String v) {
            return false;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$5(ComponentName v) {
            return false;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$6(Uri v) {
            return false;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$new$7(ClipData v) {
            return false;
        }

        @NonNull
        public Builder allowFlags(int flags) {
            this.mAllowedFlags |= flags;
            return this;
        }

        @NonNull
        public Builder allowHistoryStackFlags() {
            this.mAllowedFlags |= HISTORY_STACK_FLAGS;
            return this;
        }

        @NonNull
        public Builder allowReceiverFlags() {
            this.mAllowedFlags |= RECEIVER_FLAGS;
            return this;
        }

        @NonNull
        public Builder allowAction(@NonNull String action) {
            Preconditions.checkNotNull(action);
            Objects.requireNonNull(action);
            allowAction((Predicate<String>) new xt(action));
            return this;
        }

        @NonNull
        public Builder allowAction(@NonNull Predicate<String> filter) {
            Preconditions.checkNotNull(filter);
            this.mAllowedActions = this.mAllowedActions.or(filter);
            return this;
        }

        @NonNull
        public Builder allowDataWithAuthority(@NonNull String authority) {
            Preconditions.checkNotNull(authority);
            allowData(new vt(authority));
            return this;
        }

        @NonNull
        public Builder allowData(@NonNull Predicate<Uri> filter) {
            Preconditions.checkNotNull(filter);
            this.mAllowedData = this.mAllowedData.or(filter);
            return this;
        }

        @NonNull
        public Builder allowType(@NonNull String type) {
            Preconditions.checkNotNull(type);
            Objects.requireNonNull(type);
            return allowType((Predicate<String>) new xt(type));
        }

        @NonNull
        public Builder allowType(@NonNull Predicate<String> filter) {
            Preconditions.checkNotNull(filter);
            this.mAllowedTypes = this.mAllowedTypes.or(filter);
            return this;
        }

        @NonNull
        public Builder allowCategory(@NonNull String category) {
            Preconditions.checkNotNull(category);
            Objects.requireNonNull(category);
            return allowCategory((Predicate<String>) new xt(category));
        }

        @NonNull
        public Builder allowCategory(@NonNull Predicate<String> filter) {
            Preconditions.checkNotNull(filter);
            this.mAllowedCategories = this.mAllowedCategories.or(filter);
            return this;
        }

        @NonNull
        public Builder allowPackage(@NonNull String packageName) {
            Preconditions.checkNotNull(packageName);
            Objects.requireNonNull(packageName);
            return allowPackage((Predicate<String>) new xt(packageName));
        }

        @NonNull
        public Builder allowPackage(@NonNull Predicate<String> filter) {
            Preconditions.checkNotNull(filter);
            this.mAllowedPackages = this.mAllowedPackages.or(filter);
            return this;
        }

        @NonNull
        public Builder allowComponent(@NonNull ComponentName component) {
            Preconditions.checkNotNull(component);
            Objects.requireNonNull(component);
            return allowComponent((Predicate<ComponentName>) new ht(component));
        }

        @NonNull
        public Builder allowComponent(@NonNull Predicate<ComponentName> filter) {
            Preconditions.checkNotNull(filter);
            this.mAllowSomeComponents = true;
            this.mAllowedComponents = this.mAllowedComponents.or(filter);
            return this;
        }

        @NonNull
        public Builder allowComponentWithPackage(@NonNull String packageName) {
            Preconditions.checkNotNull(packageName);
            return allowComponent((Predicate<ComponentName>) new st(packageName));
        }

        @NonNull
        public Builder allowAnyComponent() {
            this.mAllowAnyComponent = true;
            this.mAllowedComponents = zt.a;
            return this;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$allowAnyComponent$10(ComponentName v) {
            return true;
        }

        @NonNull
        public Builder allowClipDataText() {
            this.mAllowClipDataText = true;
            return this;
        }

        @NonNull
        public Builder allowClipDataUriWithAuthority(@NonNull String authority) {
            Preconditions.checkNotNull(authority);
            return allowClipDataUri(new ut(authority));
        }

        @NonNull
        public Builder allowClipDataUri(@NonNull Predicate<Uri> filter) {
            Preconditions.checkNotNull(filter);
            this.mAllowedClipDataUri = this.mAllowedClipDataUri.or(filter);
            return this;
        }

        @NonNull
        public Builder allowClipData(@NonNull Predicate<ClipData> filter) {
            Preconditions.checkNotNull(filter);
            this.mAllowedClipData = this.mAllowedClipData.or(filter);
            return this;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$allowExtra$12(Object v) {
            return true;
        }

        @NonNull
        public Builder allowExtra(@NonNull String key, @NonNull Class<?> clazz) {
            return allowExtra(key, clazz, qt.a);
        }

        @NonNull
        public <T> Builder allowExtra(@NonNull String key, @NonNull Class<T> clazz, @NonNull Predicate<T> valueFilter) {
            Preconditions.checkNotNull(key);
            Preconditions.checkNotNull(clazz);
            Preconditions.checkNotNull(valueFilter);
            return allowExtra(key, (Predicate<Object>) new rt(clazz, valueFilter));
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$allowExtra$13(Class clazz, Predicate valueFilter, Object v) {
            return clazz.isInstance(v) && valueFilter.test(clazz.cast(v));
        }

        @NonNull
        public Builder allowExtra(@NonNull String key, @NonNull Predicate<Object> filter) {
            Preconditions.checkNotNull(key);
            Preconditions.checkNotNull(filter);
            Predicate<Object> allowedExtra = this.mAllowedExtras.get(key);
            if (allowedExtra == null) {
                allowedExtra = pt.a;
            }
            this.mAllowedExtras.put(key, allowedExtra.or(filter));
            return this;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$allowExtra$14(Object v) {
            return false;
        }

        @NonNull
        public Builder allowExtraStreamUriWithAuthority(@NonNull String uriAuthority) {
            Preconditions.checkNotNull(uriAuthority);
            allowExtra("android.intent.extra.STREAM", Uri.class, new wt(uriAuthority));
            return this;
        }

        @NonNull
        public Builder allowExtraStream(@NonNull Predicate<Uri> filter) {
            allowExtra("android.intent.extra.STREAM", Uri.class, filter);
            return this;
        }

        @NonNull
        public Builder allowExtraOutput(@NonNull String uriAuthority) {
            allowExtra("output", Uri.class, new tt(uriAuthority));
            return this;
        }

        @NonNull
        public Builder allowExtraOutput(@NonNull Predicate<Uri> filter) {
            allowExtra("output", Uri.class, filter);
            return this;
        }

        @NonNull
        public Builder allowIdentifier() {
            this.mAllowIdentifier = true;
            return this;
        }

        @NonNull
        public Builder allowSelector() {
            this.mAllowSelector = true;
            return this;
        }

        @NonNull
        public Builder allowSourceBounds() {
            this.mAllowSourceBounds = true;
            return this;
        }

        @NonNull
        public IntentSanitizer build() {
            boolean z = this.mAllowAnyComponent;
            if ((!z || !this.mAllowSomeComponents) && (z || this.mAllowSomeComponents)) {
                IntentSanitizer sanitizer = new IntentSanitizer();
                int unused = sanitizer.mAllowedFlags = this.mAllowedFlags;
                Predicate unused2 = sanitizer.mAllowedActions = this.mAllowedActions;
                Predicate unused3 = sanitizer.mAllowedData = this.mAllowedData;
                Predicate unused4 = sanitizer.mAllowedTypes = this.mAllowedTypes;
                Predicate unused5 = sanitizer.mAllowedCategories = this.mAllowedCategories;
                Predicate unused6 = sanitizer.mAllowedPackages = this.mAllowedPackages;
                boolean unused7 = sanitizer.mAllowAnyComponent = this.mAllowAnyComponent;
                Predicate unused8 = sanitizer.mAllowedComponents = this.mAllowedComponents;
                Map unused9 = sanitizer.mAllowedExtras = this.mAllowedExtras;
                boolean unused10 = sanitizer.mAllowClipDataText = this.mAllowClipDataText;
                Predicate unused11 = sanitizer.mAllowedClipDataUri = this.mAllowedClipDataUri;
                Predicate unused12 = sanitizer.mAllowedClipData = this.mAllowedClipData;
                boolean unused13 = sanitizer.mAllowIdentifier = this.mAllowIdentifier;
                boolean unused14 = sanitizer.mAllowSelector = this.mAllowSelector;
                boolean unused15 = sanitizer.mAllowSourceBounds = this.mAllowSourceBounds;
                return sanitizer;
            }
            throw new SecurityException("You must call either allowAnyComponent or one or more of the allowComponent methods; but not both.");
        }
    }

    @RequiresApi(15)
    private static class Api15Impl {
        private Api15Impl() {
        }

        @DoNotInline
        static void setSelector(Intent intent, Intent selector) {
            intent.setSelector(selector);
        }

        @DoNotInline
        static Intent getSelector(Intent intent) {
            return intent.getSelector();
        }
    }

    @RequiresApi(16)
    private static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static void sanitizeClipData(@NonNull Intent in, Intent out, Predicate<ClipData> mAllowedClipData, boolean mAllowClipDataText, Predicate<Uri> mAllowedClipDataUri, Consumer<String> penalty) {
            ClipData clipData = in.getClipData();
            if (clipData != null) {
                ClipData newClipData = null;
                if (mAllowedClipData == null || !mAllowedClipData.test(clipData)) {
                    for (int i = 0; i < clipData.getItemCount(); i++) {
                        ClipData.Item item = clipData.getItemAt(i);
                        if (Build.VERSION.SDK_INT >= 31) {
                            Api31Impl.checkOtherMembers(i, item, penalty);
                        } else {
                            checkOtherMembers(i, item, penalty);
                        }
                        CharSequence itemText = null;
                        if (mAllowClipDataText) {
                            itemText = item.getText();
                        } else if (item.getText() != null) {
                            penalty.accept("Item text cannot contain value. Item position: " + i + ". Text: " + item.getText());
                        }
                        Uri itemUri = null;
                        if (mAllowedClipDataUri == null) {
                            if (item.getUri() != null) {
                                penalty.accept("Item URI is not allowed. Item position: " + i + ". URI: " + item.getUri());
                            }
                        } else if (item.getUri() == null || mAllowedClipDataUri.test(item.getUri())) {
                            itemUri = item.getUri();
                        } else {
                            penalty.accept("Item URI is not allowed. Item position: " + i + ". URI: " + item.getUri());
                        }
                        if (itemText != null || itemUri != null) {
                            if (newClipData == null) {
                                newClipData = new ClipData(clipData.getDescription(), new ClipData.Item(itemText, (Intent) null, itemUri));
                            } else {
                                newClipData.addItem(new ClipData.Item(itemText, (Intent) null, itemUri));
                            }
                        }
                    }
                    if (newClipData != null) {
                        out.setClipData(newClipData);
                        return;
                    }
                    return;
                }
                out.setClipData(clipData);
            }
        }

        private static void checkOtherMembers(int i, ClipData.Item item, Consumer<String> penalty) {
            if (item.getHtmlText() != null || item.getIntent() != null) {
                penalty.accept("ClipData item at position " + i + " contains htmlText, textLinks or intent: " + item);
            }
        }

        @RequiresApi(31)
        private static class Api31Impl {
            private Api31Impl() {
            }

            @DoNotInline
            static void checkOtherMembers(int i, ClipData.Item item, Consumer<String> penalty) {
                if (item.getHtmlText() != null || item.getIntent() != null || item.getTextLinks() != null) {
                    penalty.accept("ClipData item at position " + i + " contains htmlText, textLinks or intent: " + item);
                }
            }
        }
    }

    @RequiresApi(29)
    private static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static Intent setIdentifier(Intent intent, String identifier) {
            return intent.setIdentifier(identifier);
        }

        @DoNotInline
        static String getIdentifier(Intent intent) {
            return intent.getIdentifier();
        }
    }
}
