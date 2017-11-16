package com.example.zzb.aac.net;

import rx.Subscriber;

/**
 * Created by zzb on 2017/11/16.
 */

public class BaseSubscriber<T> extends Subscriber<T> {
    private String status;
    private OnSubscriberListener<T> mListener;
    public BaseSubscriber(OnSubscriberListener<T> listener) {
        if (listener == null) {
            throw new NullPointerException("缺少必要的参数");
        }
        mListener = listener;
    }
    @Override
    public void onCompleted() {
        status="onCompleted";
        mListener.onChanged(status);
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void onNext(T t) {
        mListener.onSuccess(t);
    }

    @Override
    public void onStart() {
        super.onStart();
        status="onStart";
        mListener.onChanged(status);
    }
}
