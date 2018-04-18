package com.task.vodafone.data;

public interface ResultListener<T> {
    void onSuccess(T data);
    void onError(Throwable t);
}
