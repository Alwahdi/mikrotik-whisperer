package androidx.emoji2.text;

import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiCompatInitializer;
import java.util.concurrent.ThreadPoolExecutor;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ EmojiCompat.MetadataRepoLoaderCallback a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ EmojiCompatInitializer.BackgroundDefaultLoader f114a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ThreadPoolExecutor f115a;

    public /* synthetic */ b(EmojiCompatInitializer.BackgroundDefaultLoader backgroundDefaultLoader, EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, ThreadPoolExecutor threadPoolExecutor) {
        this.f114a = backgroundDefaultLoader;
        this.a = metadataRepoLoaderCallback;
        this.f115a = threadPoolExecutor;
    }

    public final void run() {
        this.f114a.lambda$load$0(this.a, this.f115a);
    }
}
