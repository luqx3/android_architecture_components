package com.example.zzb.aac.net;

/**
 * Created by zzb on 2017/11/16.
 */

public interface OnSubscriberListener<T> {

    void onSuccess(T data);
//
//    void onError(int code, String errorMsg);
//
//    void onLoading();

    void onChanged(String status);

}
