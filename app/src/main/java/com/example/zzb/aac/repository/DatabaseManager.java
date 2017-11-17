package com.example.zzb.aac.repository;

import android.util.Log;

import rx.Observable;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by zzb on 2017/11/16.
 */

public class DatabaseManager {
    private static DatabaseManager INSTANCE = null;

    public interface DatabaseCallback {
        void onComplete();
    }
    private DatabaseManager() {
    }
    public static DatabaseManager getInstance() {
        if (INSTANCE == null) {
            synchronized (DatabaseManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DatabaseManager();
                }
            }
        }
        return INSTANCE;
    }
    public void insertIP(final IPDAO ipdao,final IP ip){
        Observable.empty()
                .doOnCompleted(new Action0() {
                    @Override
                    public void call() {
                        if (ip == null) {
                            return;
                        }
                        ipdao.insertIP(ip);
                    }
                })
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    public void findindex(final IPDAO ipdao,final String ip){
        Observable.empty()
                .doOnCompleted(new Action0() {
                    @Override
                    public void call() {
                        if (ip == null) {
                            Log.i("IP","null");
                            return;
                        }
                        Log.i("IP",ipdao.findIP(ip)+"");

                    }
                })
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

}
