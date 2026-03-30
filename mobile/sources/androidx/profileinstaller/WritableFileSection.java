package androidx.profileinstaller;

import androidx.annotation.NonNull;

class WritableFileSection {
    final byte[] mContents;
    final int mExpectedInflateSize;
    final boolean mNeedsCompression;
    final FileSectionType mType;

    WritableFileSection(@NonNull FileSectionType type, int expectedInflateSize, @NonNull byte[] contents, boolean needsCompression) {
        this.mType = type;
        this.mExpectedInflateSize = expectedInflateSize;
        this.mContents = contents;
        this.mNeedsCompression = needsCompression;
    }
}
