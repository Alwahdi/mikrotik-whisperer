package androidx.emoji2.text;

import androidx.emoji2.text.FontRequestEmojiCompatConfig;

public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ FontRequestEmojiCompatConfig.FontRequestMetadataLoader a;

    public /* synthetic */ d(FontRequestEmojiCompatConfig.FontRequestMetadataLoader fontRequestMetadataLoader) {
        this.a = fontRequestMetadataLoader;
    }

    public final void run() {
        this.a.loadInternal();
    }
}
