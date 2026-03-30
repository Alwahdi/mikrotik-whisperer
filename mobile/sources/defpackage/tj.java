package defpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* renamed from: tj  reason: default package */
abstract class tj {
    static Executor a() {
        return Executors.newSingleThreadExecutor();
    }
}
