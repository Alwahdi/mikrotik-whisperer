package defpackage;

/* renamed from: ve0  reason: default package */
public abstract class ve0 {
    public static <TInput, TResult, TException extends Throwable> TResult a(int maxAttempts, TInput input, fo<TInput, TResult, TException> function, we0<TInput, TResult> retryStrategy) {
        TResult result;
        if (maxAttempts < 1) {
            return function.apply(input);
        }
        do {
            result = function.apply(input);
            input = retryStrategy.a(input, result);
            if (input == null || maxAttempts - 1 < 1) {
                return result;
            }
            result = function.apply(input);
            input = retryStrategy.a(input, result);
            break;
        } while (maxAttempts - 1 < 1);
        return result;
    }
}
