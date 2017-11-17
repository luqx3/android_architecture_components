package com.example.zzb.aac;

import android.app.Application;

import com.example.zzb.aac.dragger.AppComponent;
import com.example.zzb.aac.dragger.AppModule;
import com.example.zzb.aac.dragger.DaggerAppComponent;
import com.example.zzb.aac.repository.IPDAO;
import com.example.zzb.aac.repository.MyIPDB;

import javax.inject.Inject;

/**
 * Created by zzb on 2017/11/17.
 */

public class MyApplication extends Application {
//    @Inject
//    IPDAO ipdao;
//
//    @Inject
//    MyIPDB myIPDB;


    AppComponent appComponent = null;
//    @Inject
//    AnalyticsManager analyticsManager;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent= DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);


    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

//    public MyIPDB getMyIPDB(){
//        return myIPDB;
//    }
//
//    public IPDAO getIpdao(){
//        return ipdao;
//    }

}
