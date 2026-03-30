package androidx.emoji2.text;

import androidx.emoji2.text.FontRequestEmojiCompatConfig;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ FontRequestEmojiCompatConfig.FontRequestMetadataLoader a;

    public /* synthetic */ c(FontRequestEmojiCompatConfig.FontRequestMetadataLoader fontRequestMetadataLoader) {
        this.a = fontRequestMetadataLoader;
    }

    public final void run() {
        this.a.createMetadata();
    }
}
