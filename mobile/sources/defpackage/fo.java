package defpackage;

import java.lang.Throwable;

/* renamed from: fo  reason: default package */
public interface fo<TInput, TResult, TException extends Throwable> {
    TResult apply(TInput tinput);
}
