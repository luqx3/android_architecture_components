package com.example.zzb.aac.net;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zzb on 2017/11/15.
 */

public class HttpClient {
    protected Retrofit retrofit;
    protected static final String BaseDoubanUrl = "https://api.douban.com";
    public static String BaseIPUrl = "http://api.ip138.com/";

    public void subscribe(Observable o, Subscriber s) {
        o.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }
}
