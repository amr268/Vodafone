package com.task.bundles.data;

public interface ResultListener<T> {
    void onSuccess(T data);
    void onError(Throwable t);
}
