package androidx.activity.result;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class IntentSenderRequest implements Parcelable {
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new IntentSenderRequest$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((Cif) null);
    private final Intent fillInIntent;
    private final int flagsMask;
    private final int flagsValues;
    private final IntentSender intentSender;

    public IntentSenderRequest(IntentSender intentSender2, Intent fillInIntent2, int flagsMask2, int flagsValues2) {
        lu.f(intentSender2, "intentSender");
        this.intentSender = intentSender2;
        this.fillInIntent = fillInIntent2;
        this.flagsMask = flagsMask2;
        this.flagsValues = flagsValues2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IntentSenderRequest(IntentSender intentSender2, Intent intent, int i, int i2, int i3, Cif ifVar) {
        this(intentSender2, (i3 & 2) != 0 ? null : intent, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    public final IntentSender getIntentSender() {
        return this.intentSender;
    }

    public final Intent getFillInIntent() {
        return this.fillInIntent;
    }

    public final int getFlagsMask() {
        return this.flagsMask;
    }

    public final int getFlagsValues() {
        return this.flagsValues;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public IntentSenderRequest(android.os.Parcel r5) {
        /*
            r4 = this;
            java.lang.String r0 = "parcel"
            defpackage.lu.f(r5, r0)
            java.lang.Class<android.content.IntentSender> r0 = android.content.IntentSender.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable r0 = r5.readParcelable(r0)
            defpackage.lu.c(r0)
            android.content.IntentSender r0 = (android.content.IntentSender) r0
            java.lang.Class<android.content.Intent> r1 = android.content.Intent.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            android.os.Parcelable r1 = r5.readParcelable(r1)
            android.content.Intent r1 = (android.content.Intent) r1
            int r2 = r5.readInt()
            int r3 = r5.readInt()
            r4.<init>(r0, r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.IntentSenderRequest.<init>(android.os.Parcel):void");
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        lu.f(dest, "dest");
        dest.writeParcelable(this.intentSender, flags);
        dest.writeParcelable(this.fillInIntent, flags);
        dest.writeInt(this.flagsMask);
        dest.writeInt(this.flagsValues);
    }

    public static final class Builder {
        private Intent fillInIntent;
        private int flagsMask;
        private int flagsValues;
        private final IntentSender intentSender;

        @Retention(RetentionPolicy.SOURCE)
        private @interface Flag {
        }

        public Builder(IntentSender intentSender2) {
            lu.f(intentSender2, "intentSender");
            this.intentSender = intentSender2;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Builder(android.app.PendingIntent r3) {
            /*
                r2 = this;
                java.lang.String r0 = "pendingIntent"
                defpackage.lu.f(r3, r0)
                android.content.IntentSender r0 = r3.getIntentSender()
                java.lang.String r1 = "pendingIntent.intentSender"
                defpackage.lu.e(r0, r1)
                r2.<init>((android.content.IntentSender) r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.IntentSenderRequest.Builder.<init>(android.app.PendingIntent):void");
        }

        public final Builder setFillInIntent(Intent fillInIntent2) {
            this.fillInIntent = fillInIntent2;
            return this;
        }

        public final Builder setFlags(int values, int mask) {
            this.flagsValues = values;
            this.flagsMask = mask;
            return this;
        }

        public final IntentSenderRequest build() {
            return new IntentSenderRequest(this.intentSender, this.fillInIntent, this.flagsMask, this.flagsValues);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(Cif ifVar) {
            this();
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }

        private Companion() {
        }
    }
}
