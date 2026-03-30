package androidx.emoji2.text;

import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class a implements ThreadFactory {
    public final /* synthetic */ String a;

    public /* synthetic */ a(String str) {
        this.a = str;
    }

    public final Thread newThread(Runnable runnable) {
        return ConcurrencyHelpers.lambda$createBackgroundPriorityExecutor$0(this.a, runnable);
    }
}
