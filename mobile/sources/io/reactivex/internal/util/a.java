package io.reactivex.internal.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public enum a implements Callable<List<Object>>, mo<Object, List<Object>> {
    INSTANCE;

    public static <T> Callable<List<T>> asCallable() {
        return INSTANCE;
    }

    public static <T, O> mo<O, List<T>> asFunction() {
        return INSTANCE;
    }

    public List<Object> call() throws Exception {
        return new ArrayList();
    }

    public List<Object> apply(Object o) throws Exception {
        return new ArrayList();
    }
}
