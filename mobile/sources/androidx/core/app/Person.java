package androidx.core.app;

import android.app.Person;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;

public class Person {
    private static final String ICON_KEY = "icon";
    private static final String IS_BOT_KEY = "isBot";
    private static final String IS_IMPORTANT_KEY = "isImportant";
    private static final String KEY_KEY = "key";
    private static final String NAME_KEY = "name";
    private static final String URI_KEY = "uri";
    @Nullable
    IconCompat mIcon;
    boolean mIsBot;
    boolean mIsImportant;
    @Nullable
    String mKey;
    @Nullable
    CharSequence mName;
    @Nullable
    String mUri;

    @NonNull
    public static Person fromBundle(@NonNull Bundle bundle) {
        Bundle iconBundle = bundle.getBundle(ICON_KEY);
        return new Builder().setName(bundle.getCharSequence(NAME_KEY)).setIcon(iconBundle != null ? IconCompat.createFromBundle(iconBundle) : null).setUri(bundle.getString(URI_KEY)).setKey(bundle.getString(KEY_KEY)).setBot(bundle.getBoolean(IS_BOT_KEY)).setImportant(bundle.getBoolean(IS_IMPORTANT_KEY)).build();
    }

    @RequiresApi(22)
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Person fromPersistableBundle(@NonNull PersistableBundle bundle) {
        return Api22Impl.fromPersistableBundle(bundle);
    }

    @RequiresApi(28)
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Person fromAndroidPerson(@NonNull android.app.Person person) {
        return Api28Impl.fromAndroidPerson(person);
    }

    Person(Builder builder) {
        this.mName = builder.mName;
        this.mIcon = builder.mIcon;
        this.mUri = builder.mUri;
        this.mKey = builder.mKey;
        this.mIsBot = builder.mIsBot;
        this.mIsImportant = builder.mIsImportant;
    }

    @NonNull
    public Bundle toBundle() {
        Bundle result = new Bundle();
        result.putCharSequence(NAME_KEY, this.mName);
        IconCompat iconCompat = this.mIcon;
        result.putBundle(ICON_KEY, iconCompat != null ? iconCompat.toBundle() : null);
        result.putString(URI_KEY, this.mUri);
        result.putString(KEY_KEY, this.mKey);
        result.putBoolean(IS_BOT_KEY, this.mIsBot);
        result.putBoolean(IS_IMPORTANT_KEY, this.mIsImportant);
        return result;
    }

    @RequiresApi(22)
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PersistableBundle toPersistableBundle() {
        return Api22Impl.toPersistableBundle(this);
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @RequiresApi(28)
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public android.app.Person toAndroidPerson() {
        return Api28Impl.toAndroidPerson(this);
    }

    @Nullable
    public CharSequence getName() {
        return this.mName;
    }

    @Nullable
    public IconCompat getIcon() {
        return this.mIcon;
    }

    @Nullable
    public String getUri() {
        return this.mUri;
    }

    @Nullable
    public String getKey() {
        return this.mKey;
    }

    public boolean isBot() {
        return this.mIsBot;
    }

    public boolean isImportant() {
        return this.mIsImportant;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public String resolveToLegacyUri() {
        String str = this.mUri;
        if (str != null) {
            return str;
        }
        if (this.mName == null) {
            return "";
        }
        return "name:" + this.mName;
    }

    public static class Builder {
        @Nullable
        IconCompat mIcon;
        boolean mIsBot;
        boolean mIsImportant;
        @Nullable
        String mKey;
        @Nullable
        CharSequence mName;
        @Nullable
        String mUri;

        public Builder() {
        }

        Builder(Person person) {
            this.mName = person.mName;
            this.mIcon = person.mIcon;
            this.mUri = person.mUri;
            this.mKey = person.mKey;
            this.mIsBot = person.mIsBot;
            this.mIsImportant = person.mIsImportant;
        }

        @NonNull
        public Builder setName(@Nullable CharSequence name) {
            this.mName = name;
            return this;
        }

        @NonNull
        public Builder setIcon(@Nullable IconCompat icon) {
            this.mIcon = icon;
            return this;
        }

        @NonNull
        public Builder setUri(@Nullable String uri) {
            this.mUri = uri;
            return this;
        }

        @NonNull
        public Builder setKey(@Nullable String key) {
            this.mKey = key;
            return this;
        }

        @NonNull
        public Builder setBot(boolean bot) {
            this.mIsBot = bot;
            return this;
        }

        @NonNull
        public Builder setImportant(boolean important) {
            this.mIsImportant = important;
            return this;
        }

        @NonNull
        public Person build() {
            return new Person(this);
        }
    }

    @RequiresApi(22)
    static class Api22Impl {
        private Api22Impl() {
        }

        @DoNotInline
        static Person fromPersistableBundle(PersistableBundle bundle) {
            return new Builder().setName(bundle.getString(Person.NAME_KEY)).setUri(bundle.getString(Person.URI_KEY)).setKey(bundle.getString(Person.KEY_KEY)).setBot(bundle.getBoolean(Person.IS_BOT_KEY)).setImportant(bundle.getBoolean(Person.IS_IMPORTANT_KEY)).build();
        }

        @DoNotInline
        static PersistableBundle toPersistableBundle(Person person) {
            PersistableBundle result = new PersistableBundle();
            CharSequence charSequence = person.mName;
            result.putString(Person.NAME_KEY, charSequence != null ? charSequence.toString() : null);
            result.putString(Person.URI_KEY, person.mUri);
            result.putString(Person.KEY_KEY, person.mKey);
            result.putBoolean(Person.IS_BOT_KEY, person.mIsBot);
            result.putBoolean(Person.IS_IMPORTANT_KEY, person.mIsImportant);
            return result;
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static Person fromAndroidPerson(android.app.Person person) {
            IconCompat iconCompat;
            Builder name = new Builder().setName(person.getName());
            if (person.getIcon() != null) {
                iconCompat = IconCompat.createFromIcon(person.getIcon());
            } else {
                iconCompat = null;
            }
            return name.setIcon(iconCompat).setUri(person.getUri()).setKey(person.getKey()).setBot(person.isBot()).setImportant(person.isImportant()).build();
        }

        @DoNotInline
        static android.app.Person toAndroidPerson(Person person) {
            return new Person.Builder().setName(person.getName()).setIcon(person.getIcon() != null ? person.getIcon().toIcon() : null).setUri(person.getUri()).setKey(person.getKey()).setBot(person.isBot()).setImportant(person.isImportant()).build();
        }
    }
}
